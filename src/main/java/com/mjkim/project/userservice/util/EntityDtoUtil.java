package com.mjkim.project.userservice.util;

import com.mjkim.project.userservice.entity.User;
import com.mjkim.project.userservice.entity.UserTransaction;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.mjkim.project.userservice.dto.TransactionRequestDto;
import com.mjkim.project.userservice.dto.TransactionResponseDto;
import com.mjkim.project.userservice.dto.TransactionStatus;
import com.mjkim.project.userservice.dto.UserDto;

public class EntityDtoUtil {
	public static UserDto toDto(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}

	public static User toEntity(UserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
	
	public static UserTransaction toEntity(TransactionRequestDto requestDto) {
		UserTransaction ut = new UserTransaction();
		ut.setUserId(requestDto.getUserId());
		ut.setAmount(requestDto.getAmount());
		ut.setTransactionDate(LocalDateTime.now());
		return ut;
	}
	
	public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
		TransactionResponseDto responseDto = new TransactionResponseDto();
		responseDto.setAmount(requestDto.getAmount());
		responseDto.setUserId(requestDto.getUserId());
		responseDto.setStatus(status);
		return responseDto;
	}
}
