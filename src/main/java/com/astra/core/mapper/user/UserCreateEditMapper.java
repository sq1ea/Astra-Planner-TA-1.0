package com.astra.core.mapper.user;

import com.astra.core.dto.user.UserCreateEdit;
import com.astra.core.entity.User;
import com.astra.core.mapper.Mapper;
import com.astra.security.authority.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserCreateEditMapper implements Mapper<UserCreateEdit, User> {

    private final PasswordEncoder passwordEncoder;

    public UserCreateEditMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User map(UserCreateEdit fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public User map(UserCreateEdit object) {
        User user = new User();
        copy(object, user);
        return user;
    }
    private void copy(UserCreateEdit object, User user) {
        user.setRole(Role.USER);
        user.setUsername(object.getUsername());
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        Optional.ofNullable(object.getPassword())
                .filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);
    }

}