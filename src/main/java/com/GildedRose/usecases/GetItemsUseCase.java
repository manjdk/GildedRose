package com.GildedRose.usecases;

import com.GildedRose.repositories.ItemRepository;
import com.GildedRose.shop.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetItemsUseCase {
    private ItemRepository itemRepository;

    public GetItemsUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }
}
