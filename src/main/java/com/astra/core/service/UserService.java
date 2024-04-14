package com.astra.core.service;

import com.astra.core.dto.user.UserCreateEdit;
import com.astra.core.dto.user.UserRead;
import com.astra.core.entity.User;
import com.astra.core.mapper.user.UserCreateEditMapper;
import com.astra.core.mapper.user.UserReadMapper;
import com.astra.core.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService   {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public UserService(UserRepository userRepository, UserReadMapper userReadMapper, UserCreateEditMapper userCreateEditMapper) {
        this.userRepository = userRepository;
        this.userReadMapper = userReadMapper;
        this.userCreateEditMapper = userCreateEditMapper;
    }

    public List<UserRead> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<UserRead> findById(Integer id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }
    public Optional<UserRead> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserRead create(UserCreateEdit userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }
    @Transactional
    public Optional<UserRead> update(Integer id, UserCreateEdit userDto) {
        return userRepository.findById(id)
                .map(entity -> {
                    return userCreateEditMapper.map(userDto, entity);
                })
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }



}
