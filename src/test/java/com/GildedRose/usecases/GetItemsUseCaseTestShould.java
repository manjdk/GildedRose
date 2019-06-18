package com.GildedRose.usecases;

import com.GildedRose.repositories.ItemRepository;
import com.GildedRose.shop.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetItemsUseCaseTestShould {
    private List<Item> initialItems;

    @InjectMocks
    private GetItemsUseCase getItemsUseCase;

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        initialItems = new ArrayList<>();
        initialItems.add(new Item("foo", 5, 4));
        when(itemRepository.findAll()).thenReturn(initialItems);
    }

    @Test
    public void returnItems() {
        List<Item> items = getItemsUseCase.getItems();

        assertEquals("should return 2", 1, items.size());
        verify(itemRepository).findAll();
    }
}