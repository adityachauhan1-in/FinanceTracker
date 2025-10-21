package com.finance.tracker.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.finance.tracker.model.Transaction;

public class FileHandler {
    private static final String FILE_NAME = "transactions.txt";

    public void saveTransactions(List<Transaction>transactions)throws IOException{ 

        try ( BufferedWriter  writer = new BufferedWriter(new FileWriter(FILE_NAME)) ){
        //BufferedWriter is a Java class used to write text to files efficiently.
        //a buffer does — it collects data in memory first, then writes it all to disk at once.
        //makes it faster than writing directly every time.
        //reduces the number of I/O operations (which are slow).

       writer.write(String.format("%-10s | %-10s | %-12s | %-15s | %-10s%n",
       "ID","Amount","Date","Category","Type"));
       writer.write("----------------------------------------------------------------------------\n");
       int id = 1;
    
           for(Transaction t : transactions){
                String type = t.getClass().getSimpleName();  // Income or Expense 
                writer.write(String.format("%-10s | %-10s | %-12s | %-15s | %-10s%n",
       id++ , t.getAmount(),t.getDate(),t.getCategory(),type));

       
            writer.newLine();//give new line b/w each transaction 
           }
           writer.flush(); // okk now off the writer 
        } catch (IOException e) {
            System.out.println("[FileHandler] error while saving transactions  : "  + e.getMessage());
        //  handle exception  // 
        }
    }
    public List<String> loadTransactions(){

        List<String>data = new ArrayList<>();  
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;// start reading the transaction 
            while((line = reader.readLine()) != null){//read the line which is not null
                data.add(line);   
            }
        } catch (IOException e) {
            System.out.println("[FileHandler] error while loading transactions " + e.getMessage());
            //  handle exceptionś
        }
        return data;
    }
}
 