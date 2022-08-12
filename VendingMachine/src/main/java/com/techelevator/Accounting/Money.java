package com.techelevator.Accounting;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Money {

    private BigDecimal currentBalance = new BigDecimal("0.00");
    public BigDecimal getCurrentBalance(){
        return currentBalance;
    }

    public void updateBalance(BigDecimal itemPrice) throws Exception {
        if (itemPrice.compareTo(currentBalance) <= 0) {
            currentBalance = currentBalance.subtract(itemPrice);
        } else {
            System.out.println("");
            System.out.println("You need to give me money if you want food or drink.");
            System.out.println("");
            throw new Exception();
        }
    }

    public void moneyProvided(BigDecimal customerMoney) throws InputMismatchException {

        try {
            if (customerMoney.equals(new BigDecimal("1")) || customerMoney.equals(new BigDecimal("5")) || customerMoney.equals(new BigDecimal("10")) || customerMoney.equals(new BigDecimal("20"))) {
                currentBalance = currentBalance.add(customerMoney);
            } else {
                throw new InputMismatchException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
    }

    public String makeChange(){
        String output = null;

        int dollars = currentBalance.multiply(new BigDecimal("100")).intValue();

        int quarters = dollars / 25;
        dollars = dollars % 25;

        int dimes = dollars / 10;
        dollars = dollars % 10;

        int nickles = dollars / 5;
        dollars = dollars % 5;

        if(dollars % 5 == 0){
            output = "Change Returned to Customer: " + quarters + " quarters, " + dimes + " dimes, " + nickles + " nickles.";
        }
        return output;
    }
}