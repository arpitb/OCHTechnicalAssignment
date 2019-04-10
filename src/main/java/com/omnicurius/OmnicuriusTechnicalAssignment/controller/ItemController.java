package com.omnicurius.OmnicuriusTechnicalAssignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnicurius.OmnicuriusTechnicalAssignment.dao.ItemDao;
import com.omnicurius.OmnicuriusTechnicalAssignment.model.Item;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemDao itemDao;

	@PostMapping("/createItem")
	public String createItem(@RequestBody Item item) {
		itemDao.save(item);
		return "Item is successfully created";
	}

	@GetMapping("/readItem")
	public Optional<Item> readItem(Integer id) {
		return itemDao.findById(id);
	}

	@PutMapping("/updateItem")
	public String updateItem(@RequestBody Item item) {
		Optional<Item> itOptional = itemDao.findById(item.getItemId());
		if (itOptional == null) {
			return "Item does not exist";
		}
		Item it = itOptional.get();
		it.setItemCount(item.getItemCount());
		it.setItemName(item.getItemName());
		itemDao.save(it);
		return "Item is successfully updated";
	}

	@DeleteMapping("/deleteItem")
	public String deleteItem(Integer id) {
		if (itemDao.findById(id) == null) {
			return "Item does not exist";
		}
		itemDao.deleteById(id);
		return "Item is successfully deleted.";
	}

	@GetMapping("/readAllItems")
	public List<Item> readAllItems() {
		return (List<Item>) itemDao.findAll();
	}

}
