package com.training.quoteGenerator.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.quoteGenerator.entity.Quote;
import com.training.quoteGenerator.repository.QuoteRepository;
import com.training.quoteGenerator.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	@Override
	public List<Quote> getAllQuotes() {
		return quoteRepository.findAll();
	}

	@Override
	public List<Quote> getQuotesByAuthor(String author) {
		if (author == null || author.trim().isEmpty()) {
			return Collections.emptyList();
		}

		List<Quote> quotesByAuthor = quoteRepository.findByAuthor(author);

		if (quotesByAuthor.isEmpty()) {
			return Collections.emptyList();
		}

		return quotesByAuthor;
	}

}
