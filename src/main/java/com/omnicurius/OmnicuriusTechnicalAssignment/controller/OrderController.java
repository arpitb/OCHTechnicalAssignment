package com.omnicurius.OmnicuriusTechnicalAssignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnicurius.OmnicuriusTechnicalAssignment.dao.ItemDao;
import com.omnicurius.OmnicuriusTechnicalAssignment.dao.OrderDao;
import com.omnicurius.OmnicuriusTechnicalAssignment.model.Item;
import com.omnicurius.OmnicuriusTechnicalAssignment.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	
	@GetMapping("/allOrders")
	public List<Order> getAllOrders() {
		return (List<Order>) orderDao.findAll(); 
	}
	
	@PostMapping("/placeOrder")
	public String createOrder(@RequestBody ArrayList<Order> orders) {
		boolean itemNotFound = false;
		for (int i = 0; i < orders.size(); i++) {
			Optional<Item> itemOrder = itemDao.findById(orders.get(i).getItemId());
			if (itemOrder == null) {
				return "Item " + orders.get(i).getItemName() + " does not exist.";
			}
			Item item = itemOrder.get();
			if (item.getItemCount() < orders.get(i).getItemCount()) {
				itemNotFound = true;
			}
		}
		
		if (itemNotFound) {
			return "Some of the items in your order are out of stock.";
		} else {
			for (int i = 0; i < orders.size(); i++) {
				Optional<Item> itemOrder = itemDao.findById(orders.get(i).getItemId());
				Item item = itemOrder.get();
				item.setItemCount( item.getItemCount() - orders.get(i).getItemCount());
				itemDao.save(item);
				orderDao.save(orders.get(i));
			}
			return "Your order has been placed successfully";
		}
	}
}
