package com.GildedRose.shop.behavior;

import com.GildedRose.shop.Item;
import com.GildedRose.shop.UpdateItem;

public class Default implements UpdateItem {

    public void updateItem(Item item) {
        decreaseQualityFor(item);
        decreaseSellInFor(item);
    }

    private void decreaseSellInFor(Item item) {
        item.setSellIn(item.getSellIn() - DECREASE_VALUE_BY_ONE);
    }

    private void decreaseQualityFor(Item item) {
        item.setQuality(Math.max(item.getQuality() - DECREASE_VALUE_BY_ONE, MIN_QUALITY));
    }
}
