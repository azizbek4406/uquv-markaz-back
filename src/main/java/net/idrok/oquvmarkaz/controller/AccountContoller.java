package net.idrok.oquvmarkaz.controller;

import net.idrok.oquvmarkaz.entity.Lavozim;
import net.idrok.oquvmarkaz.entity.User;
import net.idrok.oquvmarkaz.security.JwtUtil;
import net.idrok.oquvmarkaz.security.Token;
import net.idrok.oquvmarkaz.security.UserSignDTO;
import net.idrok.oquvmarkaz.service.UserService;
import net.idrok.oquvmarkaz.service.dto.UserDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/account")
public class AccountContoller {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;



    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserSignDTO user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication, user.getRememberMe());
        return ResponseEntity.ok(new Token(token));
    }


    @GetMapping("/current")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return ResponseEntity.ok(userService.getUserByLogin(principal.getName()));
    }

    @GetMapping
    public Page<UserDTO2> getAll(Pageable pageable) {
        String key = "";
        return userService.getAll(key, pageable);
    }

    @PutMapping
    public UserDTO2 update(@RequestBody User user) throws InterruptedException {
        user.setAktiv(true);
        user.setLavozimlar(user.getLogin().equals("admin") ? Set.of(Lavozim.ADMIN) : Set.of(Lavozim.DIRECTOR));
        return userService.update(user);
    }
}
