package com.mjkim.project.userservice.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class UserDto {
	private Integer id;
	private String userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String profileImageUrl;
	private LocalDateTime lastLoginDate;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private String[] roles;		// ROLE_USER {read, edit}, ROLE_ADMIN {delete}
	private String[] authorities;
	private boolean isActive;
	private boolean isNotLocked;
	private Integer balance;
}
