package ru.jm.springboot2.springboot2.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.jm.springboot2.springboot2.Repository.RoleRepository;
import ru.jm.springboot2.springboot2.model.Role;

@Component
public class RoleConverter implements Converter<String, Role> {
    @Autowired
    private RoleRepository roleDao;

    @Override
    public Role convert(String args0) {
        Long id = Long.valueOf(args0);
        return roleDao.findById(id).get();
    }
}
