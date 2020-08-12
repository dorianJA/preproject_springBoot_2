package ru.jm.springboot2.springboot2.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jm.springboot2.springboot2.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

}
