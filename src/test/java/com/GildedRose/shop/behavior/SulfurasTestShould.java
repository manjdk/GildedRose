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
public class SulfurasTestShould {
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void notAffectSulfurasAfterUpdate() {
        Item item = new Item("id", SULFURAS_HAND_OF_RAGNAROS, 10, 5);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 10 after update", 10, item.getSellIn());
        assertEquals("quality should be 5 after update", 5, item.getQuality());
    }
}