package com.GildedRose.shop.behavior;

import com.GildedRose.shop.Category;
import com.GildedRose.shop.Item;
import com.GildedRose.shop.UpdateItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AgedBrieTestShould {
    private static final String AGED_BRIE = "Aged Brie";
    private static final int MAX_QUALITY = 50;

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void updateAgedBrieItem() {
        Item item = new Item("id", AGED_BRIE, 10, 5);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 9, item.getSellIn());
        assertEquals("quality should be 6 after update", 6, item.getQuality());
    }

    @Test
    public void notIncreaseQualityAfterMaxValueReachedForAgedBrie() {
        Item item = new Item("id", AGED_BRIE, 10, MAX_QUALITY);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 9, item.getSellIn());
        assertEquals("quality should be 50 after update", 50, item.getQuality());
    }
}