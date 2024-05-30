//package dev.vorstu.Controller;
//
//import dev.vorstu.repositories.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.security.Principal;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/api")
//@Slf4j
//public class AuthorizationController {
//    UserRepository userRepository;
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//
//    @PostMapping(value = "/login")
//    public Principal apiLogin(Principal user) {
//        log.info("Login user");
//        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
//        log.info("Hell {} with role {}", token.getName(), token.getAuthorities());
//
//
//        String username = token.getName();
//        String userIdQuery = "SELECT user_id FROM users WHERE username = ?";
//        Long userid = jdbcTemplate.queryForObject(userIdQuery, new Object[] { username }, Long.class);
//        Map<String, Object> details = new HashMap<String, Object>();
//        details.put("user_id", userid);
//        ((AbstractAuthenticationToken) token).setDetails(details);
//        return token;
//
//    }
//
//    @PostMapping(path = "/logout", consumes = "application/json", produces = "application/json")
//    @ResponseBody
//    public Principal logout(Principal user, HttpServletRequest request, HttpServletResponse response) {
//        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(
//                AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY
//        );
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//        cookieClearingLogoutHandler.logout(request, response, null);
//        securityContextLogoutHandler.logout(request, response, null);
//
//        return user;
//    }
//}
package dev.vorstu.Controller;


import dev.vorstu.enitity.User;
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

    @GetMapping(value = "/checkLogin")
    public boolean checkLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.isAuthenticated();
    }

//    @GetMapping("/user/role")
//    public  String getUserRole() {
//        Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//        if (principal instanceof  UserDetails) {
//            username = ((UserDetails)principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        return userService.findByUsername(username).getRole().name();
//    }

    @PostMapping(value = "/login")
    public Principal Login(Principal user) {
        log.info("Login user");
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
        log.info("Hello {} with role {}", token.getName(), token.getAuthorities());
        token.setDetails(userService.findByUsername(token.getName()));
        return token;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }
        User registredUser = userService.save(user);
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