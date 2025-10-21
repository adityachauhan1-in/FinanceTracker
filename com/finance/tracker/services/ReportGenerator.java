package com.finance.tracker.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;
import com.finance.tracker.model.Transaction;

public class ReportGenerator {
 private   List<Transaction>transactions ; 
 
 public  ReportGenerator( List<Transaction>transactions ){
this.transactions = transactions;
 }

  public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
 // total income 

 public  double  getTotalIncome(){
return transactions.stream()
.filter(t -> t instanceof Income) 
.mapToDouble(Transaction :: getAmount)
.sum();
 }

 // Total Expense 
  public  double  getTotalExpense(){
return transactions.stream()
.filter(t -> t instanceof Expense) 
.mapToDouble(Transaction :: getAmount)
.sum();
 }

 // get total expense summary 

 public void showExpenseByCategory(){
    Map <String,Double> expenseSummary = transactions.stream()
    .filter(t -> t instanceof Expense)
    .collect(Collectors.groupingBy(Transaction :: getCategory,
                   Collectors.summingDouble(Transaction :: getAmount)) );

                       System.out.println("\nExpense by Category : ");
        expenseSummary.forEach((category, total) ->
                System.out.println(category + " : " + total));
 }
 
 // show all the income sources .
 public void showIncomeSource(){
  Map<String,Double>incomeSummary = transactions.stream()
    .filter(t -> t instanceof Income)
    .collect(Collectors.groupingBy(Transaction :: getCategory,
                   Collectors.summingDouble(Transaction :: getAmount)) );

                       System.out.println("\n Income by Sources : ");
        incomeSummary.forEach((category, total) ->
                System.out.println(category + " : " + total));
 }
 
 //generate overall report 
 public void generateReport(){

   if(transactions == null || transactions.isEmpty()){
      System.out.println(" No transaction to report ");
      return ; 
   }
else {
    System.out.println("======Finance Report======");
    System.out.println("Total Income : " + getTotalIncome());
    System.out.println("Total Expense : " + getTotalExpense());
    System.out.println("Net Balance  : " + (getTotalIncome() - getTotalExpense()));
    showExpenseByCategory();
    showIncomeSource();
 }
}

}
