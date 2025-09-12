package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++)//On parcours la boucle

        {
    //////////////////////////////////////////STEP 1///////////////////////////////////////////////////////////////
            if (!items[i].name.equals("Comté") && !items[i].name.equals("Pass VIP Concert"))/*Si ce n'est NI du compté NI Une place de concert VIP*/
            {
                if (items[i].quality > 0)/*La qualité est au dessus de 0*/ {
                    if (!items[i].name.equals("Kryptonite"))/*Ce n'est pas de la Kryptonite*/ {
                        items[i].quality = items[i].quality - 1;/*La qualité du l'objet baisse*/
                    }
                }

            }

            else

            {
                if (items[i].quality < 50)/*SI c'est du comté ou un passe VIP*/ {
                    items[i].quality = items[i].quality + 1;//La qualité du produits augemente

                    if (items[i].name.equals("Pass VIP Concert")) {/*Si l'objet est un passe VIP*/
                        if (items[i].sellIn < 11)/*Que l'objet a moins de 11 jours*/ {
                            if (items[i].quality < 50)/*Que l'objet a une qualité inferieur a 50 ?*/ {
                                items[i].quality = items[i].quality + 1;/*L'objet prend 1  de qualité (censé en prendre plus)*/
                            }
                        }

                        if (items[i].sellIn < 6) {/*L'objets a moins de 6 jours*/
                            if (items[i].quality < 50) {/*L'objet a une qualité inferieur a 50 ?*/
                                items[i].quality = items[i].quality + 1;/*La qualité prend plus 1*/
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
