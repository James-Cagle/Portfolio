package com.techelevator.Application;

import java.math.BigDecimal;

public abstract class Stock {

    private final String itemName;
    private final String itemSlot;
    private final BigDecimal price;
    private int amtAvailable = 6;

    public static int munchCount;
    public static int gumCount;
    public static int drinkCount;
    public static int candyCount;

    public void buyItem() throws ArithmeticException {
        if(this.amtAvailable == 0){
            System.out.println(this.itemName + " is sold out.");
            throw new ArithmeticException();
        } else {
            --this.amtAvailable;
        }
    }

    public Stock(String itemName, String itemSlot, BigDecimal price){
        this.itemName = itemName;
        this.itemSlot = itemSlot;
        this.price = price;
    }

    public String getItemName() {return itemName;}
    public String getItemSlot() {return itemSlot;}
    public BigDecimal getPrice() {return price;}
    public int getAmtAvailable() {
        return amtAvailable;
    }
    public String playSound(){
        return "";
    }

    //MUNCHMUNCH
    public static class Munchy extends Stock {
        public Munchy(String name, String location, BigDecimal price){
            super(name, location, price);
            munchCount++;
        }
        @Override
        public String playSound(){
            return "Munchy, Munchy, so Good!";
        }
    }

    //CHEWCHEW
    public static class Gum extends Stock {

        public Gum(String name, String location, BigDecimal price){
            super(name, location, price);
            gumCount++;
        }
        @Override
        public String playSound(){
            return "Chewy, Chewy, Lots O Bubbles!";
        }
    }

    //DRINKDRINK
    public static class Drink extends Stock {

        public Drink(String name, String location, BigDecimal price){
            super(name, location, price);
            drinkCount++;
        }

        @Override
        public String playSound(){
            return "Drinky, Drinky, Slurp Slurp!";
        }
    }

    //SUGARSUGAR
    public static class Candy extends Stock {

        public Candy(String name, String location, BigDecimal price){
            super(name, location, price);
            candyCount++;
        }

        @Override
        public String playSound(){
            return "Sugar, Sugar, so Sweet!";
        }
    }
}