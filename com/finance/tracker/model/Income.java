package com.finance.tracker.model;

import java.time.LocalDate;

public class Income extends Transaction {


  public Income( double amount , LocalDate   date , String category  ){
    super(amount , date,category); // parent class 
  }

  @Override
  public void displayTransaction(){
    System.out.println("[Income] id : " + id + ", Amount :"  + amount + ", Date : " + date + ", Category : " + category);
  }
}
