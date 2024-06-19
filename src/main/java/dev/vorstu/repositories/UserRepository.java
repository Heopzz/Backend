package dev.vorstu.repositories;


import dev.vorstu.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u  WHERE username = :username")
    User getUser(@Param("username") String username);






}
