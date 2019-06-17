package com.GildedRose.controllers;

import com.GildedRose.Item;
import com.GildedRose.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class Items {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Item> getItemsList() {
        return itemRepository.findAll();
    }
}
