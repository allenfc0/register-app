package org.perscholas.springapp.dao;

import org.perscholas.springapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    User findById(long id);
    Optional<User> findByEmail(String email);
}
