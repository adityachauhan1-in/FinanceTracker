package com.finance.tracker.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList; //it helps to write data in a manner or you can understand it as it make the arrayLIst -> thread safe version .

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;
import com.finance.tracker.model.Transaction;

public class FinanceManager {
    
    // thread safe list for concurrent access

    private final  List<Transaction> transaction = new CopyOnWriteArrayList<>(); // thread safe version of arrya list allow to write 
 
    // add new transaction 
    public void addTransaction(Transaction t ){
        transaction.add(t);
        System.out.println( t.getCategory() + " add successfully"); // whetever it is income or expense
    }

// show all transactions 
    public void showAllTransaction(){
        if(transaction.isEmpty()){
            System.out.println(" \n No transaction found !! ");
            return ;
        }

        System.out.println("====Transaction History====");

        System.out.println("-------------------------------------------------");
   System.out.printf("%-8s | %-10s | %-12s | %-12s\n", "ID", "Amount", "Date", "Category");
        System.out.println("-------------------------------------------------");

        for(Transaction t : transaction)  {
        System.out.println(t.toString());
    }   }


    // for calculating the balance 
    public double calculateBalance(){
        // income - expense 
 double income = transaction.stream() // easy to calculate total 
 .filter(t ->  t instanceof Income)
 .mapToDouble(Transaction :: getAmount)
 .sum();


 double expense = transaction.stream()
 .filter(t -> t instanceof Expense)
 .mapToDouble(Transaction :: getAmount)
 .sum();

 return income - expense; // for calculating current balance 
    }
  

    public List<Transaction> getTransactions() { // it is call by reportgernerator;
        // Auto-generated method 
  return transaction;
        
    }
  

  

}
