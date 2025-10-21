package com.finance.tracker.model;

import java.time.LocalDate;

public class Expense extends Transaction {


  public Expense( double amount , LocalDate   date , String category  ){
    super( amount , date,category); // from parent (Transaction )
  

  }

  @Override
  public void displayTransaction(){ // this is also define in parent just here we shape it 
    // also using it , is compulsary because you define in parent .
  
    System.out.println("[Expense] id : " + id + ", Amount :"  + amount  + ", Date : " + date + ", Category : " + category);
  }
}
