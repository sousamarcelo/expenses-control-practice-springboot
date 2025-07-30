package com.practice.expensescontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.expensescontrol.dto.ItemDTO;
import com.practice.expensescontrol.entities.Category;
import com.practice.expensescontrol.entities.Item;
import com.practice.expensescontrol.repository.CategoryRepository;
import com.practice.expensescontrol.repository.ItemRepository;
import com.practice.expensescontrol.services.exceptions.DataBaseException;
import com.practice.expensescontrol.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public ItemDTO findById(Long id) {
		Optional<Item> result = itemRepository.findById(id);
		Item item = result.get();
		ItemDTO dto = new ItemDTO(item);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ItemDTO> findAll(Pageable pageable){
		Page<Item> result = itemRepository.findAll(pageable);
		return result.map(x -> new ItemDTO(x));
	}
	
	@Transactional
	public ItemDTO insert(ItemDTO dto) {
		Item entity = new Item();
		entity.setDescription(dto.getDescription());
		entity.setAmount(dto.getAmount());
		entity.setDate(dto.getDate());
		Category cat = categoryRepository.getReferenceById(dto.getCategoryId());
		entity.setCategory(cat);		
		entity = itemRepository.save(entity);
		
		return new ItemDTO(entity);
	}
	
	@Transactional
	public ItemDTO update(Long id, ItemDTO dto) {
		try {
		Item entity = itemRepository.getReferenceById(id);
		entity.setDescription(dto.getDescription());
		entity.setAmount(dto.getAmount());
		entity.setDate(dto.getDate());
		if (itemRepository.existsById(dto.getCategoryId())) {
			entity.setCategory(categoryRepository.getReferenceById(dto.getCategoryId()));
		} else {
			throw new DataBaseException("Categoria não encontrada");
		}
		return new ItemDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Item não encontrado");
		}
	}
	
}
