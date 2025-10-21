package com.finance.tracker.threads;

import java.time.LocalDate;

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;
import com.finance.tracker.services.FinanceManager;
import com.finance.tracker.util.FileHandler;

public class Testing {
    public static void main(String[] args) {
    FileHandler handler = new FileHandler();
    FinanceManager manager = new FinanceManager();

    //=====>>>> background threads = START 
AutoSaveTask saveTask = new AutoSaveTask(manager, handler);
BudgetMonitor monitor = new BudgetMonitor(manager);

saveTask.start();
monitor.start();

// transactions 

manager.addTransaction(new Income(1150000, LocalDate.now(), "Job"));
manager.addTransaction(new Expense( 26000, LocalDate.now(), "Parents"));
manager.addTransaction(new Expense( 12000, LocalDate.now(), "Car Service "));
manager.addTransaction(new Income(4500, LocalDate.now(), "Start UP"));
manager.addTransaction(new Income(513500, LocalDate.now(), "Function"));
manager.addTransaction(new Expense( 80000, LocalDate.now(), "Hospital"));


manager.showAllTransaction();
System.out.println("Current Balance : " + manager.calculateBalance());

try {
    Thread.sleep(15000);
} catch (InterruptedException e) {
    // Auto-generated catch block
    e.printStackTrace();
}
saveTask.stopAutoSave();
monitor.stopMonitor();
    }
}
 