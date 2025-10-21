// It is our CLI (COMMAND LINE INTERFACE )   , Our Menu 
// work in console .
import java.util.Scanner;
import com.finance.tracker.model.*;    
import com.finance.tracker.services.*; 
import java.time.LocalDate; 
import com.finance.tracker.services.FinanceManager;   
import com.finance.tracker.services.ReportGenerator;
import com.finance.tracker.threads.AutoSaveTask;
import com.finance.tracker.threads.BudgetMonitor;
import com.finance.tracker.util.FileHandler;

public class Main  {
   public static void main(String[] args) throws Exception{
System.out.println(" Finance Tracker Started — managing your budget smartly!\n");

    // core setup 
    FileHandler handler = new FileHandler();
    FinanceManager manager = new FinanceManager();

Scanner scan = new Scanner(System.in);

ReportGenerator report = new ReportGenerator(null);

// thread setup (background work)
AutoSaveTask saveTask = new AutoSaveTask(manager, handler);
BudgetMonitor monitor = new BudgetMonitor(manager);

saveTask.start();
monitor.start();
   
 
    while(true){
      // option showing in console .
        System.out.println("\n=====Finance Tracker=====");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. Show All Transactions ");
        System.out.println("4. Show Current Balance ");
        System.out.println("5. Generate Report");
        System.out.println("6. Exit");

        System.out.println("Enter Your Choice : ");

        int choice = scan.nextInt();
        scan.nextLine(); //consume newLine
    
    switch (choice) {
        case 1:
            // add income 
            addIncome(manager, scan);
            break;
     case 2:
            // add expense 
            addExpense(manager, scan);
            break;

             case 3:
            manager.showAllTransaction();
            break;
             case 4:

            System.out.println("Current Balance : " + manager.calculateBalance());
            break;
             case 5:
      report.setTransactions(manager.getTransactions());
      report.generateReport();
            break;
            case 6:
 System.out.println(" All data saved. Goodbye!\n");

            System.out.println("Thank You for using Finance Tracker ");
              saveTask.stopAutoSave();
           monitor.stopMonitor();
            scan.close();
             
          return;
        default:
        System.out.println("Invalid Choice . Try Again !! ");
           
    }

    }
   } 
   private static void addIncome(FinanceManager manager , Scanner scan ){
   
    System.out.println("Enter Income Amount : ");
    double amount = scan.nextDouble();
    scan.nextLine();
    System.out.println("Source of Income : ");
    String category = scan.nextLine();
    System.out.println("\n");


    manager.addTransaction(new Income(amount,LocalDate.now(),category ));

   }

   private static void addExpense (FinanceManager manager , Scanner scan ){
  System.out.println("Enter Expense Amount : ");
    double amount = scan.nextDouble();
    scan.nextLine();
    System.out.println("Expense category  : ");
    String category = scan.nextLine();
    System.out.println("\n");
   

    manager.addTransaction(new Expense(amount,LocalDate.now(),category ));

   }
}
