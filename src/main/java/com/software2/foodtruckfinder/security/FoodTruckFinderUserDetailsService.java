package com.software2.foodtruckfinder.security;


import java.util.stream.Collectors;

import com.software2.foodtruckfinder.common.user.UserAuthenticationDto;
import com.software2.foodtruckfinder.common.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by jlutteringer on 1/15/18.
 */
@Service
public class FoodTruckFinderUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthenticationDto userAuthentication =
                userService.findUserAuthenticationByPrincipal(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));

        return new User(
                userAuthentication.getUser().getPrincipal(),
                userAuthentication.getPassword(),
                userAuthentication.getUser().getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}
