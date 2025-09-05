<<<<<<< HEAD
package com.example.fina;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String description;
    public String date;
    public String category;
    public double amount;

    public Transaction() {}

    public Transaction(String description, String date, String category, double amount) {
        this.description = description;
        this.date = date;
        this.category = category;
        this.amount = amount;
    }
=======
package  com.example.fina;



public class Transaction {
    public int id;

    public String description;
    public double amount;
    public String date;

    public Transaction(String description, double amount, String date){
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

>>>>>>> origin/main
}
