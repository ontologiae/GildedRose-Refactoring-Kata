package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
			// update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage','Sulfuras') and quality > 0
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
							// update items i set quality = quality +1 where i.name in ('Aged...','Backstage') and i.quality < 50
							// update items i set quality = quality +1 where i.name in ('Aged...','Backstage') and i.quality < 50 and i.sellIn < 6
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // ce cas ne peut survenir
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

						// update items i set i.sellIn = i.sellIn - 1 where i.name = 'Sulfuras...'
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

						// update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage','Sulfuras') and quality > 0 and i.sellIn < 0
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else { //  update items i set i.quality = 0 where i.name not in ('Aged...')  and i.sellIn < 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // update items i set i.quality = quality + 1 where i.sellIn < 0 and i.quality < 50
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
