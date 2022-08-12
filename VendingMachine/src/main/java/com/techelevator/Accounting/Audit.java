package com.techelevator.Accounting;

import com.techelevator.Application.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    public static void auditMoneyFeed(String userInput, Money balance) throws FileNotFoundException {
        File auditFile = new File("audit.txt");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String log = LocalDateTime.now().format(format) + " MONEY FED: " + new BigDecimal(userInput) + ", " + balance.getCurrentBalance() + "\n";

        PrintWriter writer = new PrintWriter(auditFile);

        try {
            if(auditFile.exists()){
                writer = new PrintWriter(new FileOutputStream(auditFile.getAbsoluteFile(), true));
            }
            else {
                writer = new PrintWriter(auditFile.getAbsoluteFile());
            }
        } catch (FileNotFoundException e){
            System.out.println("No file found.");
        }

        writer.append(log);
        writer.flush();
        writer.close();

    }

    public static void auditSelection(Stock item, Money balance){
        File auditFile = new File("audit.txt");

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String log = LocalDateTime.now().format(format) + " " + item.getItemName() + " " + item.getItemSlot() + ": " + balance.getCurrentBalance().add(item.getPrice()) + ", " + balance.getCurrentBalance()  + "\n";

        PrintWriter writer = null;

        try {
            if(auditFile.exists()) {
                writer = new PrintWriter(new FileOutputStream(auditFile.getAbsoluteFile(), true));
            } else {
                writer = new PrintWriter(auditFile.getAbsoluteFile());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("ERROR");
        }
        assert writer != null;
        writer.append(log);
        writer.flush();
        writer.close();
    }
    public static void auditFinish(BigDecimal currentBalance, String makeChange) {

        File auditFile = new File("audit.txt");

        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String log = LocalDateTime.now().format(targetFormat) + " " + makeChange + " given for Customer Balance of $" + currentBalance + ".  Customer Balance Remaining: $0.00\n";

        PrintWriter writer = null;

        try {
            if (auditFile.exists()) {
                writer = new PrintWriter(new FileOutputStream(auditFile.getAbsoluteFile(), true));
            } else {
                writer = new PrintWriter(auditFile.getAbsoluteFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        assert writer != null;
        writer.append(log);
        writer.flush();
        writer.close();
    }
}