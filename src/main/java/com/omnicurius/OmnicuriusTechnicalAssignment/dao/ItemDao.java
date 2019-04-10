package com.omnicurius.OmnicuriusTechnicalAssignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.omnicurius.OmnicuriusTechnicalAssignment.model.Item;

public interface ItemDao extends CrudRepository<Item, Integer> {

}
