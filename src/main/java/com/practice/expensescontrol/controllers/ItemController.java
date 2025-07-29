package com.practice.expensescontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.expensescontrol.dto.ItemDTO;
import com.practice.expensescontrol.services.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> findById(@PathVariable Long id){
		ItemDTO dto = itemService.findById(id);
		return ResponseEntity.ok(dto);
	}
	

}
