package com.techelevator;

import com.techelevator.Accounting.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountingTest {

    @Test
    public void testMakeChange() {
        Money balance = new Money();
        balance.moneyProvided(new BigDecimal("5"));
        assertEquals("Change Returned to Customer: " + 20 + " quarters, " + 0 + " dimes, " + 0 + " nickles.", balance.makeChange());
    }

    @Test
    public void testMakeChange2() {
        Money balance = new Money();
        balance.moneyProvided(new BigDecimal("1"));
        assertEquals("Change Returned to Customer: " + 4 + " quarters, " + 0 + " dimes, " + 0 + " nickles.", balance.makeChange());
    }
}
