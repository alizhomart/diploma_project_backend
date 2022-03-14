package kz.sdu.edu.diploma.controllers;


import kz.sdu.edu.diploma.entities.Users;
import kz.sdu.edu.diploma.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@Slf4j
public class MainController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";


    @PostMapping(value = "/register")
    public ResponseEntity<String> signUp(@RequestParam(name = "fullname")String fullname,
                                 @RequestParam(name = "email")String email,
                                 @RequestParam(name = "password")String password,
                                 @RequestParam(name = "password2")String pass2){
        Users newUser = new Users();
        if(password.equals(pass2)){
            newUser.builder()
                    .fullname(fullname)
                    .email(email)
                    .password(password)
                    .build();
            if(userService.addUser(newUser)!=null){
                log.info("email: ", newUser.getEmail());
                userService.addUser(newUser);
                return new ResponseEntity<>(SUCCESS_STATUS, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(ERROR_STATUS, HttpStatus.BAD_REQUEST);
    }
}
