package dev.vorstu.service;


import dev.vorstu.enitity.Password;
import dev.vorstu.enitity.Role;
import dev.vorstu.enitity.User;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();





    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id ) {
        return userRepository.findById(id);
    }

    public User  findByUsername(String username) {
        return userRepository.getUser(username);

    }

//    public User save(User user) {
//        Password password = user.getPassword();
//        password.setPassword(bCryptPasswordEncoder.encode(password.getPassword()));
//        user.setRole(Role.USER);
//        user.setEnable(true);
//
//            return userRepository.save(user);
//
//    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
