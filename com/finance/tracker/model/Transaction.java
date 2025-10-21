package com.finance.tracker.model;

import java.time.LocalDate;

public abstract class Transaction {
    protected int id ;
    protected double amount ;
    protected LocalDate date ; //protected =>  we can use this in same package only.
    protected String category ;


    private static int nextId = 1; // it help to not write the id at each transaction (it make it number automate )
    public Transaction ( double amount , LocalDate date , String category ){

        this.id = nextId++ ;  // auto increment id .
        this.amount = amount;
        this.date = date;
        this.category = category ;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

 
    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

   
 public abstract void displayTransaction();  // abstract means here we define them now you can use them according to your modification .

@Override
  public String toString() {
        return String.format("%-8d |  %-10.2f | %-12s | %-12s ", 
        id,amount , date,  category  );
    }
}