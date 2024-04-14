package com.astra.core.mapper.user;

import com.astra.core.dto.user.CreateUser;
import org.springframework.stereotype.Component;

@Component
public class CreateUserMapper {
    private final CreateUser createUser;

    public CreateUserMapper(CreateUser createUser) {
        this.createUser = createUser;
    }
}