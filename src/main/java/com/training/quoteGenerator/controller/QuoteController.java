package com.training.quoteGenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.quoteGenerator.entity.Quote;
import com.training.quoteGenerator.service.QuoteService;

@Controller
public class QuoteController {

	@Autowired
	private QuoteService quoteService;

	@GetMapping("/")
	public String home(Model model) {
		List<Quote> allQuotes = quoteService.getAllQuotes();
		model.addAttribute("allQuotes", allQuotes);
		return "home";
	}

	@GetMapping("/search")
	public String searchPage(Model model) {
		model.addAttribute("quotesByAuthor", null);
		return "search";
	}

	@GetMapping("/search-results")
	public String searchByAuthor(@RequestParam String author, Model model) {
		if (author == null || author.trim().isEmpty()) {
			model.addAttribute("errorMessage", "Author cannot be empty.");
			return "search";
		}

		List<Quote> quotesByAuthor = quoteService.getQuotesByAuthor(author);

		if (quotesByAuthor.isEmpty()) {
			model.addAttribute("errorMessage", "No quotes found for the given author.");
			return "search";
		}

		model.addAttribute("quotesByAuthor", quotesByAuthor);
		return "search";
	}
}
