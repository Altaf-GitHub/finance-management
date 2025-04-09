package com.user.service;

import java.util.List;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);
}
