package com.GildedRose;

import com.GildedRose.items.UpdateItem;
import com.GildedRose.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
@EnableScheduling
@Configuration
class GildedRose {
    Item[] items;
    private Category category;
    private int daysCounter;
    private Logger logger;

    @Autowired
    private ItemRepository itemRepository;

    public GildedRose(Item[] items) {
        this.items = items;
        this.category = new Category();
        this.daysCounter = 0;
        this.logger = Logger.getLogger(String.valueOf(GildedRose.class));
    }

    @Scheduled(initialDelayString = "${delay.initial}", fixedDelayString = "${delay.fixed}")
    public void updateQuality() {
        logger.info("-------- day " + daysCounter + " --------");
        logger.info("id, name, sellIn, quality");

        List<Item> all = itemRepository.findAll();

        for (Item item : all) {
            UpdateItem selectedCategory = category.defineCategory(item);
            selectedCategory.updateItem(item);
            logger.info(String.valueOf(item));
            itemRepository.save(item);
        }

        daysCounter++;
    }
}