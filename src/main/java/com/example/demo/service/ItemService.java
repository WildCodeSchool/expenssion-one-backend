package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> getAll() {
        List<Item> items = this.itemRepository.findAll();
        return items;
    }

    public Item getById(Long id) {
        Item item = this.itemRepository.findById(id).get();
        return item;
    }

    public Item create(Item item) {
        Item createdItem = this.itemRepository.save(item);
        return createdItem;
    }

    public Item update(Long id, Item item) {
        Item retrievedItem = this.itemRepository.findById(id).get();
        retrievedItem.setName(item.getName());
        retrievedItem.setPrice(item.getPrice());
        retrievedItem.setPicture(item.getPicture());
        Item updatedItem = this.itemRepository.save(item);
        return updatedItem;
    }

    public void delete(Long id) {
        this.itemRepository.deleteById(id);
    }

}
