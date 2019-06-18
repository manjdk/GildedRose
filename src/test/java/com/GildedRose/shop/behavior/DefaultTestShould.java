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
public class DefaultTestShould {
    private static final String SOME_OTHER_ITEM = "Some other item";
    private static final int MIN_QUALITY = 0;

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void updateUndefinedItem() {
        Item item = new Item("id", SOME_OTHER_ITEM, 10, 5);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 9, item.getSellIn());
        assertEquals("quality should be 4 after update", 4, item.getQuality());
    }

    @Test
    public void notDecreaseUndefinedItemQualityAfterMinValueReached() {
        Item item = new Item("id", SOME_OTHER_ITEM, 10, 0);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 9, item.getSellIn());
        assertEquals("quality should be 0 after update", MIN_QUALITY, item.getQuality());
    }
}