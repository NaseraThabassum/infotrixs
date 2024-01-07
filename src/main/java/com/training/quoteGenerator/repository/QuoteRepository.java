package com.training.quoteGenerator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.quoteGenerator.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByAuthor(String author);
}
