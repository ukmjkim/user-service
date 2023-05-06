package com.mjkim.project.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkim.project.userservice.dto.TransactionRequestDto;
import com.mjkim.project.userservice.dto.TransactionResponseDto;
import com.mjkim.project.userservice.entity.UserTransaction;
import com.mjkim.project.userservice.service.TransactionService;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public Mono<TransactionResponseDto> createTransaction (@RequestBody Mono<TransactionRequestDto> requestDtoMono) {
		return requestDtoMono.flatMap(this.transactionService::createTransaction);
	}
	
	@GetMapping
	public Flux<UserTransaction> getByUserId(@RequestParam("userId") int userId) {
		return this.transactionService.getByUserId(userId);
	}
}
