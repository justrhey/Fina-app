package com.example.fina;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class TransactionDao{
    public static final List<Expense>transactionList = new ArrayList<>();

    public void insertTransaction(Expense expense){
        transactionList.add(expense);
    }
    public void deleteTransaction(Expense expense){
        transactionList.remove(expense);
    }
    public void clearTransaction(Expense expense) {
        transactionList.clear();
    }
}


