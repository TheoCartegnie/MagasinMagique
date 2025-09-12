package com.magasin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    

}
