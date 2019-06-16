package com.GildedRose.items;

import com.GildedRose.Item;

public class BackStagePass implements UpdateItem {
    private static int NO_EXTRA_QUALITY = 0;
    private static int EXTRA_QUALITY = 1;
    private static int DOUBLE_EXTRA_QUALITY = EXTRA_QUALITY * 2;

    public void updateItem(Item item) {
        increaseQualityFor(item);
        decreaseSellInFor(item);
    }

    private void decreaseSellInFor(Item item) {
        item.setSellIn(item.getSellIn() - DECREASE_VALUE_BY_ONE);
    }

    private void increaseQualityFor(Item item) {
        int quality = item.getQuality() + INCREASE_VALUE_BY_ONE + extraQualityIfTenOrLessDaysLeft(item);
        item.setQuality(Math.min(quality, MAX_QUALITY));
    }

    private int extraQualityIfTenOrLessDaysLeft(Item item) {
        if (item.getSellIn() < 6) {
            return DOUBLE_EXTRA_QUALITY;
        } else if (item.getSellIn() < 11) {
            return EXTRA_QUALITY;
        }

        return NO_EXTRA_QUALITY;
    }
}
