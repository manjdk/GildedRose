package com.GildedRose.items;

import com.GildedRose.Item;

public interface UpdateItem {
    int DECREASE_VALUE_BY_ONE = 1;
    int INCREASE_VALUE_BY_ONE = 1;
    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;

    void updateItem(Item item);
}
