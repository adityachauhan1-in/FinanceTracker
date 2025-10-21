package com.finance.tracker.services;

import java.time.LocalDate;

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;

public class Testing {
  public static void main(String[] args) {
    FinanceManager manager = new FinanceManager();
    manager.addTransaction(new Income( 100000, LocalDate.now(), "Job" ));
    manager.addTransaction(new Expense( 10000, LocalDate.now(), "pooja"));
    manager.addTransaction(new Expense( 80000, LocalDate.now(), "travelling"));


    manager.showAllTransaction();
    System.out.println();
    System.out.println("Current balance : " +  manager.calculateBalance());

    // Generate Report 

    ReportGenerator reportGenerator = new ReportGenerator(manager.getTransactions());
reportGenerator.generateReport();
  }  
}
