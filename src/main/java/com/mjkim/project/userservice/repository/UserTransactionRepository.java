package com.mjkim.project.userservice.repository;

import com.mjkim.project.userservice.entity.UserTransaction;

import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {

	public Flux<UserTransaction> findByUserId(int userId);
}
