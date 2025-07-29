package com.practice.expensescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.expensescontrol.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {	

}
