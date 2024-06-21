package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Operation(summary = "Get all items", description = "Get all items")
    @GetMapping("")
    public List<Item> getAll() {
        return this.itemService.getAll();
    }

    @Operation(summary = "Get item by id", description = "Get item by id")
    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return this.itemService.getById(id);
    }

    @Operation(summary = "Create Item", description = "Create Item")
    @PostMapping("")
    public Item create(@RequestBody Item item) {
        return this.itemService.create(item);
    }

    @Operation(summary = "Update Item", description = "Update Item")
    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        return this.itemService.update(id, item);
    }

    @Operation(summary = "Delete Item", description = "Delete Item")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
    
}
