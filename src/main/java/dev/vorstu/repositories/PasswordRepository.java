package dev.vorstu.repositories;

import dev.vorstu.enitity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {

}
