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
public class BackStagePassTestShould {
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAX_QUALITY = 50;

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void updateBackStagePassItem() {
        Item item = new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 12, 5);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 11, item.getSellIn());
        assertEquals("quality should be 6 after update", 6, item.getQuality());
    }

    @Test
    public void notIncreaseQualityAfterMaxValueReachedForBackStagePass() {
        Item item = new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 10, MAX_QUALITY);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 9 after update", 9, item.getSellIn());
        assertEquals("quality should be 50 after update", 50, item.getQuality());
    }

    @Test
    public void increaseBackStagePassQualityByTwoIfSellInIsTenDaysOrLess() {
        Item item = new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 9, 10);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 8 after update", 8, item.getSellIn());
        assertEquals("quality should be 12 after update", 12, item.getQuality());
    }

    @Test
    public void increaseBackStagePassQualityByThreeIfSellInIsSixDaysOrLess() {
        Item item = new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 6, 10);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 5 after update", 5, item.getSellIn());
        assertEquals("quality should be 13 after update", 13, item.getQuality());
    }

    @Test
    public void setBackStagePassQualityToZeroIfSellInBecomesZero() {
        Item item = new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 1, 10);

        UpdateItem defineCategory = category.defineCategory(item);
        defineCategory.updateItem(item);

        assertEquals("sellIn should be 0 after update", 0, item.getSellIn());
        assertEquals("quality should be 0 after update", 0, item.getQuality());
    }
}