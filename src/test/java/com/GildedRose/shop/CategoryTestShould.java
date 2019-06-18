package com.GildedRose.shop;

import com.GildedRose.shop.behavior.AgedBrie;
import com.GildedRose.shop.behavior.BackStagePass;
import com.GildedRose.shop.behavior.Default;
import com.GildedRose.shop.behavior.Sulfuras;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTestShould {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String SOME_OTHER_ITEM = "Some other item";

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void returnAgedBrieCategoryIfItemIsAgedBrie() {
        UpdateItem definedCategory = category.defineCategory(
                new Item("id", AGED_BRIE, 10, 5));

        assertEquals(
                "should return Aged Brie category",
                definedCategory.getClass().getName(),
                AgedBrie.class.getName());
    }

    @Test
    public void returnBackStageCategoryIfItemIsBackStage() {
        UpdateItem definedCategory = category.defineCategory(
                new Item("id", BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 10, 5));

        assertEquals(
                "should return BackStage category",
                BackStagePass.class.getName(),
                definedCategory.getClass().getName());
    }

    @Test
    public void returnSulfurasCategoryIfItemIsSulfuras() {
        UpdateItem definedCategory = category.defineCategory(
                new Item("id", SULFURAS_HAND_OF_RAGNAROS, 10, 5));

        assertEquals(
                "should return Sulfuras category",
                Sulfuras.class.getName(),
                definedCategory.getClass().getName());
    }

    @Test
    public void returnDefaultCategoryIfItemIsUnDefined() {
        UpdateItem definedCategory = category.defineCategory(
                new Item("id", SOME_OTHER_ITEM, 10, 5));

        assertEquals(
                "should return Default category",
                Default.class.getName(),
                definedCategory.getClass().getName());
    }
}