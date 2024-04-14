package com.astra.core.mapper.user;

import com.astra.core.dto.user.UserRead;
import com.astra.core.entity.User;
import com.astra.core.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserRead> {

    @Override
    public UserRead map(User object) {
        return new UserRead(
                object.getId(),
                object.getRole(),
                object.getUsername(),
                object.getPassword(),
                object.getFirstname(),
                object.getLastname(),
                object.getCreatedAt(),
                object.getUpdatedAt()
        );
    }
}

