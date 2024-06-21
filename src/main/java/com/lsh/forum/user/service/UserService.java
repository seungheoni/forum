package com.lsh.forum.user.service;

import com.lsh.forum.domain.dto.UserRegistrationRequest;
import com.lsh.forum.domain.entity.User;

public interface UserService {
    User registerUser(UserRegistrationRequest userRegistrationRequest);
}
