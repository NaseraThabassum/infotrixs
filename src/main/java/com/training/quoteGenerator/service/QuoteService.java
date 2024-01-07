package com.training.quoteGenerator.service;

import java.util.List;

import com.training.quoteGenerator.entity.Quote;

public interface QuoteService {
    List<Quote> getAllQuotes();
    List<Quote> getQuotesByAuthor(String author);
}
