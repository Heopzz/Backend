//package dev.vorstu.Controller;
//
//
//import dev.vorstu.enitity.User;
//import dev.vorstu.service.UserService;
//import jdk.jfr.internal.tool.PrettyWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping("/findAll/")
//    public List<User> findAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<User> findById(@PathVariable Long id) {
//        Optional<User> user = userService.findById(id);
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get());
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/findByUsername/username/{username}")
//    private ResponseEntity<User> findByUsername(@PathVariable String username) {
//        User user = userService.findByUsername(username);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/create/")
//    public User create(@RequestBody User user) {
//        return userService.save(user);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
//        if (!userService.findById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
//            return ResponseEntity.ok(userService.save(user));
//        }
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (!userService.findById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        userService.deleteById(id);
//        return ResponseEntity.noContent().build();
//        }
//    }
//
