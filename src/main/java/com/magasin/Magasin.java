package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++)

        {
    //////////////////////////////////////////STEP 1///////////////////////////////////////////////////////////////
            if (!items[i].name.equals("Comté") && !items[i].name.equals("Pass VIP Concert"))
            {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Kryptonite")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }

            }

            else

            {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Pass VIP Concert")) {
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
/////////////////////////////////////////STEP 2 /////////////////////////////////////////////////
            if (!items[i].name.equals("Kryptonite"))/*Si CE N'EST PAS de la Kryptonite*/ {
                items[i].sellIn = items[i].sellIn - 1;//L'item perds un jour de durée de vie.
            }

            if (items[i].sellIn < 0)/*Si on arrive a la date de peremption*/ {
                if (!items[i].name.equals("Comté"))/*Et que l'objet n'est pas du fromage*/ {
                    if (!items[i].name.equals("Pass VIP Concert"))/*Ni un Pass VIP de concert*/ {
                        if (items[i].quality > 0)/*Si il reste des objets*/ {
                            if (!items[i].name.equals("Kryptonite"))/*Et que ce n'est pas de la kryptonite*/ {
                                items[i].quality = items[i].quality - 1;/*L'objet perds en qualité*/
                            }
                        }
                    }
                    else /*Si l'objet n'est pas une place de concert*/{
                        items[i].quality = items[i].quality - items[i].quality /*La qualité de l'objet passe a zero (normalement)*/;
                    }
                } else /*Si l'objet n'est PAS du compté*/{
                    if (items[i].quality < 50)/*Que ca quantité est en dessous de 50*/ {
                        items[i].quality = items[i].quality + 1/*Ca qualité augement*/;
                    }
                }
            }
        }
    }
}
