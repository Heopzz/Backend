package dev.vorstu.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "passwords")

public class Password {

    @Autowired
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public Password(String password) { this.password = passwordEncoder.encode(password); }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    @JsonIgnore
    private void setPasswordWithEncoding(String password) { this.password = passwordEncoder.encode(password); }


}
