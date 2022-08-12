package com.techelevator.Application;

import com.techelevator.Accounting.Audit;
import com.techelevator.UserInterface.UserInput;
import com.techelevator.UserInterface.UserOutput;
import com.techelevator.Accounting.Money;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private final List<Stock> stock = new ArrayList<>();
    public List<Stock> startedMachine(){
        File file = new File("catering.csv");
        try {
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] lineSplit = line.split(",");

                switch (lineSplit[3]) {
                    case "Munchy": {
                        Stock item = new Stock.Munchy(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        stock.add(item);
                        break;
                    }
                    case "Candy": {
                        Stock item = new Stock.Candy(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        stock.add(item);
                        break;
                    }
                    case "Drink": {
                        Stock item = new Stock.Drink(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        stock.add(item);
                        break;
                    }
                    case "Gum": {
                        Stock item = new Stock.Gum(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        stock.add(item);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("*INVALID*");
            System.exit(0);
        }
        return stock;
    }

    public void run(){
        List<Stock> items = startedMachine();

        label:
        while(true){
            UserOutput.displayHomeScreen();
            String option = UserInput.getMainMenu();

            switch (option) {
                case "display":
                    for (Stock item : items) {
                        System.out.println(item.getItemSlot() + "---> " + item.getItemName() + "  Cost: $" +  item.getPrice() + "  " + item.getAmtAvailable() + " currently available.");
                    }
                    break;
                case "purchase":
                    purchaseMethod();
                    break;
                case "exit":
                    System.out.println("");
                    System.out.println("Thank You!");
                    System.out.println("");
                    break label;
            }
        }
    }

    public void purchaseMethod(){
        Money balance = new Money();

        label:
        while(true){
            UserInput input = new UserInput();
            String option = UserInput.getPurchaseMenu(balance);

            switch (option) {
                case "Feed Money":
                    input.getMoney(balance);
                    break;
                case "Select Item":
                    for (Stock item : stock) {
                        System.out.println(item.getItemSlot() + " --> " + item.getItemName() + " Cost--> $" + item.getPrice() + "  Remaining Stock:  " + item.getAmtAvailable() + "  available.");
                    }
                    input.getItemID(stock, balance);
                    break;
                case "Finish Transaction":
                    Audit.auditFinish(balance.getCurrentBalance(), balance.makeChange());
                    System.out.println("Current Machine Balance: $" + balance.getCurrentBalance());
                    System.out.println(balance.makeChange());
                    System.out.println("Current Machine Balance: $" + balance.getCurrentBalance());
                    break label;
            }
        }
    }
}