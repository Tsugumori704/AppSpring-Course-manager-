package by.itstep.vasilevskij.repository;

import by.itstep.vasilevskij.domain.Roles;
import by.itstep.vasilevskij.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);

    List<User> findByRoles(Roles roles);
}
