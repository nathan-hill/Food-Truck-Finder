package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.payload.ApiResponse;
import com.software2.foodtruckfinder.secure.payload.JwtAuthenticationResponse;
import com.software2.foodtruckfinder.secure.payload.LoginRequest;
import com.software2.foodtruckfinder.secure.payload.SignUpRequest;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import com.software2.foodtruckfinder.secure.security.JwtTokenProvider;
import com.software2.foodtruckfinder.secure.service.Email;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@RestController
@RequestMapping("/v/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UPreferenceRepository userPreferencesRepository;

    @PostMapping("/notify")
    public ResponseEntity<?> sendEmail(@RequestBody Email e){
        System.out.println(e.toString());
        if(e.send()){
            return ResponseEntity.ok("Send Message");
        }else{
            return ResponseEntity.badRequest().body("Failed to send message");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        byte[] salt;
//        String
//        if(userRepository.existsByEmail(loginRequest.getUsernameOrEmail())){
//            System.out.println("Exists by email");
//            User u = userRepository.findByemail(loginRequest.getUsernameOrEmail());
//
//        }
//        else if(userRepository.existsByUsername(loginRequest.getUsernameOrEmail())){
//            System.out.println("Exists by username");
//            User u = userRepository.findByusername(loginRequest.getUsernameOrEmail());
//
//        }
//        else{
//            System.out.println("Does not exist, giving it: " + loginRequest.getUsernameOrEmail());
//        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }

    public String bytetoString(byte[] input) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
    }

    public byte[] stringToByte(String input) {
        if (Base64.isBase64(input)) {
            return Base64.decodeBase64(input);

        } else {
            return Base64.encodeBase64(input.getBytes());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
        System.out.println(signUpRequest.toString());

        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.CONFLICT);
        }


        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getType());

        // Password Salting Process
        user.setSalt(generateSalt());
        String salty = bytetoString(user.getSalt());
        // Appends salt to the current password
        String pass = user.getPassword().concat(salty);
        //Hashed the requested password + salt and stores it
        user.setPassword(passwordEncoder.encode(pass));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        userPreferencesRepository.save(new UserPreferences(result.getId()));

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}

