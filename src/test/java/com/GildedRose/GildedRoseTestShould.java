package com.GildedRose;

import com.GildedRose.repositories.ItemRepository;
import com.GildedRose.shop.Category;
import com.GildedRose.shop.GildedRose;
import com.GildedRose.shop.Item;
import com.GildedRose.shop.UpdateItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTestShould {
    private GildedRose gildedRose;
    private List<Item> initialItems;

    @Mock
    private ItemRepository itemRepository;

    private Category category;

    @Before
    public void setUp() {
        initialItems = new ArrayList<>();
        initialItems.add(new Item("foo", 5, 4));
        initialItems.add(new Item("foo2", 5, 4));
        when(itemRepository.findAll()).thenReturn(initialItems);
        gildedRose = new GildedRose(initialItems, itemRepository);
        category = new Category();
    }

    @Test
    public void verifyItemWasSavedAfterUpdate() {
        List<Item> foundItems = itemRepository.findAll();

        verifyItemWasSaved(foundItems);

        assertEquals("should return foo", "foo", foundItems.get(0).getName());
    }

    private void verifyItemWasSaved(List<Item> items) {
        gildedRose.updateAll();
        for (Item item : items) {
            UpdateItem definedCategory = category.defineCategory(item);
            definedCategory.updateItem(item);

            verify(itemRepository).save(item);
        }
    }
}
