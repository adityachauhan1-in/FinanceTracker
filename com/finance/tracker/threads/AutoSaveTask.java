// this thread only work is to saving the transaction into the file (without user interaction)
// so it work auto mode .
package com.finance.tracker.threads;

import com.finance.tracker.services.FinanceManager; // for balancing 
import com.finance.tracker.util.FileHandler; // to create the file .

public class AutoSaveTask  extends Thread{

private final FinanceManager manager;
private final FileHandler  fileHandler;

private boolean running = true; 

public AutoSaveTask ( FinanceManager manager , FileHandler fileHandler ){
    this.manager = manager ; 
    this.fileHandler = fileHandler;
}

public void run(){
while (running) {
    try {
        Thread.sleep(5000); // task is saved after every 5  second 
        fileHandler.saveTransactions(manager.getTransactions() );
        // System.out.println("[AutoSave] Transaction saved successfully !!");
    } catch (InterruptedException e) {
      
        System.out.println("\n[AutoSave] . Interrupted . Stopping ....");// mainly work when user choose exit option 
        running = false;
    }
     catch (Exception e) {
                System.out.println("[AutoSave] Error: " + e.getMessage());
            }
} 

}
public void stopAutoSave(){
   running = false; // stop whetever you worked on.
    this.interrupt();
}


}
