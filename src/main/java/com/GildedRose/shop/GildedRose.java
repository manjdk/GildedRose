package com.GildedRose.shop;

import com.GildedRose.repositories.ItemRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
@Configuration
public class GildedRose {
    private List<Item> items;
    private Category category;
    private int daysCounter;
    private Logger logger;
    private ItemRepository itemRepository;

    public GildedRose(List<Item> items, ItemRepository itemRepository) {
        this.items = items;
        this.category = new Category();
        this.daysCounter = 0;
        this.logger = Logger.getLogger(String.valueOf(GildedRose.class));
        this.itemRepository = itemRepository;
    }

    @Scheduled(initialDelayString = "${delay.initial}", fixedDelayString = "${delay.fixed}")
    public void updateAll() {
        logger.info("-------- day " + daysCounter + " --------");
        logger.info("id, name, sellIn, quality");

        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            updateItem(item);
        }

        daysCounter++;
    }

    @Async
    private void updateItem(Item item) {
        UpdateItem definedCategory = category.defineCategory(item);
        definedCategory.updateItem(item);
        logger.info(String.valueOf(item));
        itemRepository.save(item);
    }
}