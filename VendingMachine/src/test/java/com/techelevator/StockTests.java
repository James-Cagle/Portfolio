package com.techelevator;

import com.techelevator.Application.Stock;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class StockTests {

    @Test
    public void candySoundTest() {
        Stock.Candy candy = new Stock.Candy("DuckBits", "R2", new BigDecimal("42.44"));
        Assert.assertEquals("Sugar, Sugar, so Sweet!", candy.playSound());
    }

    @Test
    public void gumSoundTest() {
        Stock.Gum gum = new Stock.Gum("DuckBits", "R2", new BigDecimal("42.44"));
        Assert.assertEquals("Chewy, Chewy, Lots O Bubbles!", gum.playSound());
    }

    @Test
    public void drinkSoundTest() {
        Stock.Drink drink = new Stock.Drink("DuckBits", "R2", new BigDecimal("42.44"));
        Assert.assertEquals("Drinky, Drinky, Slurp Slurp!", drink.playSound());
    }

    @Test
    public void munchySoundTest() {
        Stock.Munchy munchy = new Stock.Munchy("DuckBits", "R2", new BigDecimal("42.44"));
        Assert.assertEquals("Munchy, Munchy, so Good!", munchy.playSound());
    }
}
