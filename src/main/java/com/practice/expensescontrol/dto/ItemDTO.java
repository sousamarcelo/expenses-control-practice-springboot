package com.practice.expensescontrol.dto;

import java.time.LocalDate;

import com.practice.expensescontrol.entities.Item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;



public class ItemDTO {
	
	private Long id;
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@Positive(message = "O preço deve ser positivo")
	private Double amount;
	private LocalDate date;
	private Long categoryId;
	
	public ItemDTO() {		
	}
	
	public ItemDTO(Long id, String description, Double amount, LocalDate date, Long categoryId) {
		this.id = id;		
		this.description = description;		
		this.amount = amount;
		this.date = date;
		this.categoryId = categoryId;
	}
	
	public ItemDTO(Item item) {
		id = item.getId();
		description = item.getDescription();
		amount = item.getAmount();
		date = item.getDate();
		categoryId = item.getCategory().getId();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public Long getCategoryId() {
		return categoryId;
	}
}
