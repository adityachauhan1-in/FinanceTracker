# FinanceTracker

A Java-based CLI Finance Tracker application that helps you manage income and expenses, generate reports, and automatically monitor your budget. The project also includes auto-saving functionality using background threads.

---

## Features

- **Add Income & Expenses:** Easily input your transactions with amount, category, and date.  
- **View Transaction History:** See all transactions in a clean tabular format.  
- **Current Balance:** Calculate your net balance automatically.  
- **Reports:** Generate detailed reports including total income, total expenses, net balance, expense by category, and income by source.  
- **Auto-Save:** Transactions are automatically saved to a file in the background.  
- **Budget Monitoring:** Real-time warning if expenses exceed 80% of total income.  
- **Multi-threaded:** Background threads handle auto-saving and budget monitoring without interrupting user input.


## File Structure

FinanceTracker/
│
├── model/
│ ├── Transaction.java
│ ├── Expense.java
│ └── Income.java
│
├── service/
│ ├── FinanceManager.java
│ └── ReportGenerator.java
│
├── util/
│ └── FileHandler.java
│
├── threads/
│ ├── AutoSaveTask.java
│ └── BudgetMonitor.java
│
└── Main.java



---

## Setup & Run

1. **Clone or Download the repository**
2. **Compile the code**  

Run the application


Follow the CLI menu to add income, expenses, view transactions, generate reports, or exit.

How It Works
FinanceManager: Handles transactions, balance calculation, and transaction retrieval.

ReportGenerator: Creates reports for total income, expenses, net balance, and category/source breakdown.

FileHandler: Saves transactions to data/transactions.txt automatically in the background.

AutoSaveTask: Runs as a separate thread to save transactions every 5 seconds.

BudgetMonitor: Monitors expenses in real-time and prints warnings if spending exceeds 80% of income.

Main: The CLI interface where users interact with the application.

Example Usage

=====Finance Tracker=====
1. Add Income
2. Add Expense
3. Show All Transactions
4. Show Current Balance
5. Generate Report
6. Exit
Enter Your Choice:

Dependencies
Java 23 or higher
No external libraries required

Author
Aditya Chauhan

GitHub: https://github.com/adityachauhan1-in

LinkedIn: https://www.linkedin.com/in/adityachauhan00/







