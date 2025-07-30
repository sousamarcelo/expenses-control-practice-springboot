package com.practice.expensescontrol.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.expensescontrol.dto.ItemDTO;
import com.practice.expensescontrol.services.ItemService;

import jakarta.validation.Valid;

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
	
	@GetMapping
	public ResponseEntity<Page<ItemDTO>> findAll(Pageable pageable){
		Page<ItemDTO> dto = itemService.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ItemDTO> insert(@Valid @RequestBody ItemDTO dto){
		dto = itemService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> update(@PathVariable Long id,@Valid @RequestBody ItemDTO dto){
		dto = itemService.update(id, dto);
		return ResponseEntity.ok(dto);
	}

}
