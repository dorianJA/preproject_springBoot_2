package ru.jm.springboot2.springboot2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jm.springboot2.springboot2.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByName(String username);
}
