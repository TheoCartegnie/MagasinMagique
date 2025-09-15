package com.magasin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    @Disabled
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }


    @Test
    void TestAllCase()
    {

    Item items [] = new Item [] {
      (new Item("Kryptonite", 15, 30)),
      (new Item("Kryptonite", 15, 0)),
      (new Item("Kryptonite", 0, 51)),
      (new Item("Kryptonite", 0, 1)),
      (new Item("Kryptonite", -1, 1)),
      (new Item("Pass VIP Concert", 15, 30)),
      (new Item("Pass VIP Concert", 10, 50)),
      (new Item("Pass VIP Concert", 10, 39)),
      (new Item("Comté", 15, 30)),
      (new Item("Comté", 0, 10)),
      (new Item("Comté", 0, 51)),
      (new Item("Savon", 15, 0)),
      (new Item("Savon", 15, 30)),
      (new Item("Savon", 0, 30)),
      (new Item("T-shirt Berserk", 15, 30)),
      (new Item("T-shirt AoE", 15, 50)),
      (new Item("T-shirt Batman", -1, 1)),
    };


    Item[] Lastitems = items.clone();
        for(int i = 0; i < 15; i++)
        {
            Magasin app = new Magasin(items);
            Item item = app.items[0];

            app.PrintItems(i, Lastitems);
            app.updateQuality();

            Lastitems = app.items;
          //  assertEquals(35, app.items[app.items.length-1].quality);
        }

    }



    @Test
    void TestDateVIP() {
        Item[] items = new Item [] {new Item( "Pass VIP Concert",5,10)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        /*
        *  Actuellement la valeur Quality ne s'incrémente pas en meme temps que les joursb n
        * */

    }
    @Test
    void TestItemQuality()
    {
        Item[] items = new Item [] {new Item( "Test",1,30)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }

    @Test
    void TestDateQuality()
    {
        Item[] items = new Item [] {new Item( "Test",0,30)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    @Disabled
    void TestDateOutOfLimite()
    {
        Item[] items = new Item [] {new Item( "Test",-1,-1)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);//Le qualité du produit ne diminue pas de *2
    }

    @Test
    void CheesQuality()//Cheese quality increase over time
    {
        Item[] items = new Item [] {new Item( "Comté",10,10)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void ProductQualityIncrement()
    {
        Item[] items = new Item [] {new Item( "Comté",10,49)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void ProductQualityLimit()
    {
        Item[] items = new Item [] {new Item( "Comté",10,50)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


}
