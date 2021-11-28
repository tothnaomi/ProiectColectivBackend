package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    private final AuthentificationService loginService;

    @Autowired
    public LoginController(AuthentificationService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("employee/login")
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String pwd) throws Exception {
        return loginService.login(email, pwd);
    }

    @PostMapping("employee/logout")
    public ResponseEntity<?> logout(@RequestParam("email") String email) throws Exception{
        return loginService.logout(email);
    }


    @PostMapping("employee/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestParam("username") String username,
                                            @RequestParam("password") String password,
                                            @RequestParam("confirm") String confirmPassword) throws Exception{
        return loginService.forgotPassword(username, password, confirmPassword);
    }
}
