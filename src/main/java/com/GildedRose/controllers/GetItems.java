package com.GildedRose.controllers;

import com.GildedRose.shop.Item;
import com.GildedRose.usecases.GetItemsUseCase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class GetItems {
    private GetItemsUseCase getItemsUseCase;

    public GetItems(GetItemsUseCase getItemsUseCase) {
        this.getItemsUseCase = getItemsUseCase;
    }

    @GetMapping("/items")
    public List<Item> getItemsList() {
        return getItemsUseCase.getItems();
    }
}
