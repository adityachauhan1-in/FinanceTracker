package com.finance.tracker.threads;
// this thread version monitoring the treansaction if user spend 80% then it will send message automatically to his CLI 
// monitoring the transactions .
import com.finance.tracker.services.FinanceManager;

public class BudgetMonitor extends Thread {

    private final FinanceManager manager;
    private boolean running = true;

    public BudgetMonitor(FinanceManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (running) {
            try {
                 Thread.sleep(10000); //  at every 10 , it monitor the transactions
                double balance = manager.calculateBalance();
                double income = manager.getTransactions().stream()
                
                        .filter(t -> t.getClass().getSimpleName().equals("Income"))

                        .mapToDouble(t -> t.getAmount())
                        
                        .sum();
                double expense = income - balance;
                
   if (income > 0 && expense >= income * 0.8) {
       System.out.println("\n==>> [BudgetMonitor]  Warning! You have spent over 80% of your income!");
   }

               // check every 3 seconds
            } catch (InterruptedException e) {
                System.out.println("[BudgetMonitor] Stopped monitoring.");
                running = false;
            } catch (Exception e) {
                System.out.println("[BudgetMonitor] Error: " + e.getMessage());
            }
        }
    }

    public void stopMonitor() {
        running = false;
        this.interrupt();

        
    }
}
