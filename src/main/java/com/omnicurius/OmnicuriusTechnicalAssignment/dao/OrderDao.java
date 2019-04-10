package com.omnicurius.OmnicuriusTechnicalAssignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.omnicurius.OmnicuriusTechnicalAssignment.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer>{

}
