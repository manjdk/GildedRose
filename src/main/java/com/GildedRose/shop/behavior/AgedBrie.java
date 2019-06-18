package com.GildedRose.shop.behavior;

import com.GildedRose.shop.Item;
import com.GildedRose.shop.UpdateItem;

public class AgedBrie implements UpdateItem {
    public void updateItem(Item item) {
        decreaseSellInFor(item);
        increaseQualityFor(item);
    }

    private void decreaseSellInFor(Item item) {
        item.setSellIn(item.getSellIn() - DECREASE_VALUE_BY_ONE);
    }

    private void increaseQualityFor(Item item) {
        item.setQuality(Math.min(item.getQuality() + INCREASE_VALUE_BY_ONE, MAX_QUALITY));
    }
}
