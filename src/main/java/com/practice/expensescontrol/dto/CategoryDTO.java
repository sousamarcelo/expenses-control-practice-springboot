package com.practice.expensescontrol.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.practice.expensescontrol.entities.Category;
import com.practice.expensescontrol.entities.Item;

public class CategoryDTO {
	
	private Long id;
	private String name;
	private LocalDate inclusionDate;
	private List<ItemDTO> items = new ArrayList<>();
	
	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String name, LocalDate inclusionDate) {
		this.id = id;
		this.name = name;
		this.inclusionDate = inclusionDate;
	}
	
	public CategoryDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
		inclusionDate = entity.getInclusionDate();
		for(Item item : entity.getItems()) {
			items.add(new ItemDTO(item));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getInclusionDate() {
		return inclusionDate;
	}

	public List<ItemDTO> getItems() {
		return items;
	}
}
