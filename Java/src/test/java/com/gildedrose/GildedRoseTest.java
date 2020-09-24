package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Test;
import com.gildedrose.Item;
import com.gildedrose.GildedRose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {


	public GildedRoseTest() {
	}


	  @Test
    public void decrease_quality_and_sellin_of_default_items() {
        Item[] givenDefaultItems = new Item[]{new Item("default", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("default", 29, 19)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void decrease_quality_twice_as_fast_of_default_items_when_sellin_is_negative() {
        Item[] givenDefaultItems = new Item[]{new Item("default", -1, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("default", -2, 18)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    /*@Test
    public void decrease_quality_twice_as_fast_for_conjured() {
        Item[] givenDefaultItems = new Item[]{new Item("Conjured Mana Cake", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Conjured Mana Cake", 29, 18)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void decrease_quality_twice_as_fast_of_conjured_when_sellin_is_negative() {
        Item[] givenDefaultItems = new Item[]{new Item("Conjured Mana Cake", -1, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Conjured Mana Cake", -2, 16)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }*/
   

		@Test
    public void not_modify_sulfuras() {
        Item[] givenDefaultItems = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 30, 20)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void not_modify_sulfuras_even_with_negative_sellin() {
        Item[] givenDefaultItems = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 20)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void increase_quality_of_aged_brie() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Aged Brie", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Aged Brie", 29, 21)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void increase_quality_twice_as_fast_of_aged_brie_when_sellin_is_low() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Aged Brie", -1, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Aged Brie", -2, 22)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void increase_quality_of_backstage() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 29, 21)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void increase_quality_twice_as_fast_of_backstage_when_sellin_is_low() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }
    @Test
    public void increase_quality_three_times_as_fast_of_backstage_when_sellin_is_very_low() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 23)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }
    @Test
    public void delete_quality_of_backstage_when_sellin_is_negative() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }



}
