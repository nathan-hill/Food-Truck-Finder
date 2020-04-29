package com.software2.foodtruckfinder.secure.payload;

import com.software2.foodtruckfinder.secure.model.User;

public class UserJWTdto {
    User u;
    JwtAuthenticationResponse jwt;

    public UserJWTdto(User u, JwtAuthenticationResponse jwt) {
        this.u = u;
        this.jwt = jwt;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public JwtAuthenticationResponse getJwt() {
        return jwt;
    }

    public void setJwt(JwtAuthenticationResponse jwt) {
        this.jwt = jwt;
    }
}
