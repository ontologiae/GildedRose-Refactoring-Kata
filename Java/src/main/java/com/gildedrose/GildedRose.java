package com.gildedrose;

import java.util.Arrays; 

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


		public Item[] getItems() {
			return items;
		}

    public void updateQuality() {
			// En terme de perf, il vaudrai mieux discriminer en fonction de la quality et sellIn mais en terme de lisibilité avec name

			for (int j = 0; j < items.length; j++) {
				Item i = items[j];
				switch (i.name) {
					case "Aged Brie" : 
						// B update items i set quality = quality +1 where i.name in ('Aged...','Backstage') and (i.quality < 50 )
						// E update items i set i.sellIn = i.sellIn - 1 where i.name <> 'Sulfuras...'
						// H update items i set i.quality = quality + 1 where i.name in ('Aged...') and i.sellIn < 0 and i.quality < 50
						items[j].sellIn = i.sellIn - 1;
						if (i.quality < 50) {
							items[j].quality = i.quality+1;
							if (i.sellIn < 6)
								items[j].quality = i.quality+1;
						}
						break;
					case "Backstage passes to a TAFKAL80ETC concert" : 
						// B update items i set quality = quality +1 where i.name in ('Aged...','Backstage') and (i.quality < 50 )
						//C update items i set quality = quality +1 where i.name in ('Backstage') and i.quality < 50 and i.sellIn < 11
						//D update items i set quality = quality +1 where i.name in ('Backstage') and i.quality < 50 and i.sellIn < 6
					  // E update items i set i.sellIn = i.sellIn - 1 where i.name <> 'Sulfuras...'
						// //  G update items i set i.quality = 0 where i.name  in ('Backstage...')  and i.sellIn < 0
						// E
						items[j].sellIn = i.sellIn - 1;
						// 
						if (i.quality < 50) {
							items[j].quality = i.quality+1;
							if (i.sellIn < 11)
								items[j].quality = i.quality+1;
							if (i.sellIn < 6)
								items[j].quality = i.quality+1;
						}
						//G
						if (i.sellIn < 0)
							items[j].quality = 0;
						break;
					case "Sulfuras, Hand of Ragnaros" : 
						//if (i.quality < 50)
						//	items[j].quality = i.quality+1;
						break;
					default:
						//A update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage') and (quality > 0 and i.name <> 'Sulfuras..')
						//// E update items i set i.sellIn = i.sellIn - 1 where i.name <> 'Sulfuras...'
						//// F update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage','Sulfuras') and quality > 0 and i.sellIn < 0
						//E
						items[j].sellIn = i.sellIn - 1;
						//A
						if (i.quality > 0) {
							items[j].quality = i.quality-1;
							//F
							if(i.sellIn < 0)
								items[j].quality = i.quality-1;
						}							
						break;

				}
			}
		}


			
	     public void updateQualityRef() {
	 		// A update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage') and (quality > 0 and i.name <> 'Sulfuras..')
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
							// B update items i set quality = quality +1 where i.name in ('Aged...','Backstage') and (i.quality < 50 )
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

										//C update items i set quality = quality +1 where i.name in ('Backstage') and i.quality < 50 and i.sellIn < 11
										//D update items i set quality = quality +1 where i.name in ('Backstage') and i.quality < 50 and i.sellIn < 6
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { 
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

						// E update items i set i.sellIn = i.sellIn - 1 where i.name <> 'Sulfuras...'
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

						// F update items i set quality = quality - 1 where i.name not in ('Aged...','Backstage','Sulfuras') and quality > 0 and i.sellIn < 0
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else { //  G update items i set i.quality = 0 where i.name  in ('Backstage...')  and i.sellIn < 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // H update items i set i.quality = quality + 1 where i.name in ('Aged...') and i.sellIn < 0 and i.quality < 50
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }


  public GildedRose[] onAideEvoSuite(GildedRose g1)  {
		GildedRose tmp = new GildedRose(Arrays.copyOf(g1.items,g1.items.length));

		g1.updateQuality();
		return new GildedRose[] {g1,tmp};
		//return res;
	}

}
