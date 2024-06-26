package dev.vorstu.Controller;


import dev.vorstu.enitity.Password;
import dev.vorstu.enitity.Role;
import dev.vorstu.enitity.User;
import dev.vorstu.enitity.UserAndPassword;
import dev.vorstu.repositories.UserRepository;
import dev.vorstu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j // log.info

public class AuthorizationController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/checkLogin")
    public boolean checkLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.isAuthenticated();
    }

    @PostMapping(value = "/login")
    public Principal Login(Principal user) {
        log.info("Login user");
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
        log.info("Hello {} with role {}", token.getName(), token.getAuthorities());
        token.setDetails(userService.findByUsername(token.getName()));
        return token;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody UserAndPassword userAndPassword) {
        if (userService.findByUsername(userAndPassword.getUser().getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        User registredUser = userRepository.save(new User(null, userAndPassword.getUser().getUsername(), Role.USER,
                new Password(userAndPassword.getPassword()), true));
        return  ResponseEntity.ok(registredUser);
    }

    @PostMapping(path = "/logout", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Principal logout(Principal user, HttpServletRequest request, HttpServletResponse response) {
        log.info("Logout user");
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(
                AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY
        );
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        cookieClearingLogoutHandler.logout(request, response, null);
        securityContextLogoutHandler.logout(request, response, null);


        return user;
    }

}