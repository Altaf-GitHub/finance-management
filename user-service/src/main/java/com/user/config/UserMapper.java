package com.user.config;
import org.springframework.stereotype.Component;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.entity.User;

@Component
public class UserMapper {

	    public static User toEntity(UserRequest request) {
	        if (request == null) return null;

	        User user = new User();
	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPhoneNumber(request.getPhoneNumber());
	        return user;
	    }

	    public static UserResponse toResponse(User user) {
	        if (user == null) return null;

	        UserResponse response = new UserResponse();
	        response.setId(user.getId());
	        response.setName(user.getName());
	        response.setEmail(user.getEmail());
	        response.setPhoneNumber(user.getPhoneNumber());
	        return response;
	    }

	    public static void updateUserFromDto(UserRequest request, User user) {
	        if (request == null || user == null) return;

	        if (request.getName() != null) {
	            user.setName(request.getName());
	        }
	        if (request.getEmail() != null) {
	            user.setEmail(request.getEmail());
	        }
	        if (request.getPhoneNumber() != null) {
	            user.setPhoneNumber(request.getPhoneNumber());
	        }
	    }
	}


