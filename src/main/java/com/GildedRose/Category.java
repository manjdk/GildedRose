package com.GildedRose;

import com.GildedRose.items.*;

public class Category {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public UpdateItem defineCategory(Item item) {
        switch (item.getName()) {
            case SULFURAS_HAND_OF_RAGNAROS:
                return new Sulfuras();
            case AGED_BRIE:
                return new AgedBrie();
            case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
                return new BackStagePass();
            default:
                return new Default();
        }
    }
}
