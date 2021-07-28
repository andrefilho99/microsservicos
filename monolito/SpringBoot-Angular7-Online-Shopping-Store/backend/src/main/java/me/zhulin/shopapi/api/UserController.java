package me.zhulin.shopapi.api;

import me.zhulin.shopapi.entity.User;
import me.zhulin.shopapi.service.UserService;
import me.zhulin.shopapi.service.request.AutenticacaoRequest;
import me.zhulin.shopapi.vo.request.JwtResponse;
import me.zhulin.shopapi.vo.request.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AutenticacaoRequest autenticacaoRequest;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        try {
            return ResponseEntity.ok(autenticacaoRequest.login(loginForm.getUsername(), loginForm.getPassword()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user, Principal principal) {

        try {
            if (!principal.getName().equals(user.getEmail())) throw new IllegalArgumentException();
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getProfile(@PathVariable("email") String email, Principal principal) {
        if (principal.getName().equals(email)) {
            return ResponseEntity.ok(userService.findOne(email));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getone/{email}")
    public ResponseEntity<User> getOneUser(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.findOne(email));
    }
}
