package com.techelevator;

import com.techelevator.Application.Stock;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SoldOutTest {

    @Test
    void buyGumSoldOut() {
        Stock.Gum pop = new Stock.Gum("Gum", "A1", new BigDecimal(0.01));
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        try {
            pop.buyItem();
        } catch (ArithmeticException e) {
            return;
        }
        fail();
    }

    @Test
    void buyDrinkSoldOut() {
        Stock.Drink pop = new Stock.Drink("Gum", "A1", new BigDecimal(0.01));
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        pop.buyItem();
        try {
            pop.buyItem();
        } catch (ArithmeticException e) {
            return;
        }
        fail();
    }
}