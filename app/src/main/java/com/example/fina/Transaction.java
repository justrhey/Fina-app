
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

    public Transaction() {

    }

    public Transaction(String description, String date, String category, double amount) {
        this.description = description;
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    }