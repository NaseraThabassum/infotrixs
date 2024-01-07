package com.training.quoteGenerator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quote {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String content;


    private String author;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Quote(Integer id, String content, String author) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
	}


	public Quote() {
		super();
	}
	
    
    
}
