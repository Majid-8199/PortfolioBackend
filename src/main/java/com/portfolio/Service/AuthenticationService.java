package com.portfolio.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.Dto.JwtAuthenticationRequest;
import com.portfolio.Dto.LoginRequest;
import com.portfolio.Dto.RefreshTokenRequest;
import com.portfolio.Entity.User;
import com.portfolio.Repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public JwtAuthenticationRequest login(LoginRequest loginRequest) {
        logger.info("Attempting to authenticate user with email: {}", loginRequest.getEmail());
        
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            logger.info("Authentication successful for user with email: {}", loginRequest.getEmail());
        } catch (Exception e) {
            logger.error("Authentication failed for user with email: {}. Error: {}", loginRequest.getEmail(), e.getMessage());
            throw new IllegalArgumentException("Invalid Email or Password");
        }

        User user = userRepository.findByEmail(loginRequest.getEmail())
                                  .orElseThrow(() -> new IllegalArgumentException("User not found"));
        logger.debug("User found with email: {}. Generating JWT token.", loginRequest.getEmail());

        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        logger.info("JWT token and refresh token generated for user with email: {}", loginRequest.getEmail());

        JwtAuthenticationRequest jwtAuthResponse = new JwtAuthenticationRequest();
        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);
        jwtAuthResponse.setUser(user);

        return jwtAuthResponse;
    }

    public JwtAuthenticationRequest refreshToken(RefreshTokenRequest refreshTokenRequest) {
        logger.info("Attempting to refresh token for token: {}", refreshTokenRequest.getToken());

        String userEmail = jwtService.extractUsername(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail)
                                  .orElseThrow(() -> new IllegalArgumentException("User not found"));

        logger.debug("User found for email: {}. Validating refresh token.", userEmail);

        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            String newToken = jwtService.generateToken(user);
            logger.info("New JWT token generated for user with email: {}", userEmail);

            JwtAuthenticationRequest jwtAuthResponse = new JwtAuthenticationRequest();
            jwtAuthResponse.setToken(newToken);
            jwtAuthResponse.setRefreshToken(refreshTokenRequest.getToken());
            jwtAuthResponse.setUser(user);
            
            return jwtAuthResponse;
        } else {
            logger.error("Invalid or expired refresh token for user with email: {}", userEmail);
            throw new IllegalArgumentException("Invalid or expired refresh token");
        }
    }
}
