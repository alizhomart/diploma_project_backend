package kz.sdu.edu.diploma.controllers;


import kz.sdu.edu.diploma.dto.LoginDto;
import kz.sdu.edu.diploma.dto.SignUpDto;
import kz.sdu.edu.diploma.entities.Roles;
import kz.sdu.edu.diploma.entities.Users;
import kz.sdu.edu.diploma.repos.RoleRepository;
import kz.sdu.edu.diploma.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
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

import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String SUCCESS_STATUS = "SUCCESS";
    private static final String ERROR_STATUS = "ERROR";

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return SUCCESS_STATUS;
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody SignUpDto signUpDto){
        // add check for username exists in a DB
        log.info("signUpDto", signUpDto.getUsername());
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return ERROR_STATUS;
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return ERROR_STATUS;
        }

        // create user object
        Roles roles = roleRepository.findByName("ROLE_USER").get();
        Users user = Users.builder()
                .name(signUpDto.getName())
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .password(signUpDto.getPassword())
                .build();

        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return SUCCESS_STATUS;

    }
}