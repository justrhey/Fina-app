package com.example.fina;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "balance")
public class Balance {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public double current_balance;

    public Balance() {}
    @Ignore
    public Balance(double current_balance) {
        this.current_balance = current_balance;
    }
}
