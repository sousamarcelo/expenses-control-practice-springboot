package com.practice.expensescontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.expensescontrol.dto.ItemDTO;
import com.practice.expensescontrol.entities.Item;
import com.practice.expensescontrol.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional(readOnly = true)
	public ItemDTO findById(Long id) {
		Optional<Item> result = itemRepository.findById(id);
		Item item = result.get();
		ItemDTO dto = new ItemDTO(item);
		return dto;
	}
}
