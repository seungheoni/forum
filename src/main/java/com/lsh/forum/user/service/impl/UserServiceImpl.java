package com.lsh.forum.user.service.impl;

import com.lsh.forum.domain.dto.UserRegistrationRequest;
import com.lsh.forum.domain.entity.User;
import com.lsh.forum.user.repository.UserRepository;
import com.lsh.forum.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = UserRegistrationRequest.toEntity(userRegistrationRequest);
        return userRepository.save(user);
    }
}

