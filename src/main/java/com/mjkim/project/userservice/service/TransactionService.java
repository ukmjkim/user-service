package com.mjkim.project.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjkim.project.userservice.dto.TransactionRequestDto;
import com.mjkim.project.userservice.dto.TransactionResponseDto;
import com.mjkim.project.userservice.dto.TransactionStatus;
import com.mjkim.project.userservice.entity.UserTransaction;
import com.mjkim.project.userservice.repository.UserRepository;
import com.mjkim.project.userservice.repository.UserTransactionRepository;
import com.mjkim.project.userservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTransactionRepository transactionRepository;
	
	public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto) {
		return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
			.filter(Boolean::booleanValue)
			.map(b -> EntityDtoUtil.toEntity(requestDto))
			.flatMap(this.transactionRepository::save)
			.map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
			.defaultIfEmpty(EntityDtoUtil.toDto(requestDto,  TransactionStatus.DECLINED));
	}
	
	public Flux<UserTransaction> getByUserId(int userId) {
		return this.transactionRepository.findByUserId(userId);
	}
}
