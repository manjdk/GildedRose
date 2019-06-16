package com.GildedRose;

import com.GildedRose.items.UpdateItem;

class GildedRose {
    Item[] items;
    private Category category;

    public GildedRose(Item[] items) {
        this.items = items;
        this.category = new Category();
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateItem selectedCategory = category.defineCategory(item);
            selectedCategory.updateItem(item);
        }
    }
}