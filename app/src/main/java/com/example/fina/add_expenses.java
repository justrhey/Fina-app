package com.example.fina;

import java.util.ArrayList;
import java.util.List;

public class add_expenses {

    public static List<Expense> transactionList = new ArrayList<>();

    public void insertTransaction(Expense expense){
        transactionList.add(expense);
    }

    public void deleteTranscation(Expense expense){
        transactionList.remove(expense);
    }

    public void clearTransaction(Expense expense){
        transactionList.clear();
    }
}
