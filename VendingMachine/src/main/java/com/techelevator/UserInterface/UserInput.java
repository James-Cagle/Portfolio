package com.techelevator.UserInterface;

import com.techelevator.Application.Stock;
import com.techelevator.Accounting.Audit;
import com.techelevator.Accounting.Money;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static final Scanner input = new Scanner(System.in);

    public static String getMainMenu(){
        boolean repeat;

         do {
            System.out.println("");
            System.out.println("         Welcome to The Taste Elevator Machine!");
            System.out.println("Make selection below and prepare to have your tastebuds ELEVATED!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
            System.out.println("(D) Display Vending Items");
            System.out.println("(P) Purchase");
            System.out.println("(E) Exit");
            System.out.println("");
            System.out.println("   Please select an option: ");

            String userOption = input.nextLine();
            String choice = userOption.toLowerCase();

            switch(choice){
                case "d":
                    return "display";

                case "p":
                    return "purchase";

                case "e":
                    return "exit";

                //I tried, and I gave up

                default:
                    return "Please....For the love of God please put in a correct option.";
            }

        }
        while(repeat);
    }

    public static String getPurchaseMenu(Money balance){

        do {
            System.out.println(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._");
            System.out.println("                Purchase Menu");
            System.out.println(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._");
            System.out.println("");
            System.out.println(">(M) Feed Money");
            System.out.println(">(S) Select Item");
            System.out.println(">(F) Finish Transaction");
            System.out.println("Current Balance: $" + balance.getCurrentBalance());
            System.out.println();

            String userOption = input.nextLine();
            String option = userOption.toLowerCase();

            switch (option) {
                case "m":
                    return "Feed Money";
                case "s":
                    return "Select Item";
                case "f":
                    return "Finish Transaction";
            }

        }
        while(true);
    }

    public void getMoney(Money balance){
        boolean repeat = true;

        do{
            System.out.println("Please insert money to purchase items.");
            System.out.println("Enter 1 for $1.      Enter 5 for $5.");
            System.out.println("Enter 10 for $10.    Enter 20 for $20.");
            System.out.print(">>---enter here---->");

            String userInput = input.nextLine();

            try {
                balance.moneyProvided(new BigDecimal(userInput));
                Audit.auditMoneyFeed(userInput, balance);
                repeat = false;
            } catch(InputMismatchException e){
                System.out.println("Please insert money in $1, $5, $10 or $20 bills.");
            } catch(Exception e){
                System.out.println("Try harder.");
            }
        }
        while(repeat);
    }

    public void getItemID(List<Stock> products, Money balance){

        boolean repeat = true;
        Stock userItem = null;

        do {
            System.out.print("Select an item: ");
            String selected = input.nextLine();

            for(Stock item : products){
                if(item.getItemSlot().equals(selected)){
                    userItem = item;
                }
            }

            if(userItem == null){
                System.out.println("Incorrect Code.");
                continue;
            }
            try {
                balance.updateBalance(userItem.getPrice());
                userItem.buyItem();
                Audit.auditSelection(userItem, balance);
                System.out.println("Now Dispensing " + userItem.getItemName() + ": $" + userItem.getPrice());
                System.out.println("Current Balance: $" + balance.getCurrentBalance());
                System.out.println(userItem.playSound());
                repeat = false;

            } catch(ArithmeticException ignored) {

            } catch(Exception e){
                repeat = false;
            }
        } while (repeat);
    }
}