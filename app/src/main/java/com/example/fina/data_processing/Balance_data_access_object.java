package com.example.fina.data_processing;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;

import com.example.fina.entity.Balance;

@Dao
   public interface Balance_data_access_object{

        @Insert
        void  insert(Balance balance);

        @Update
        void update(Balance balance);


    @Query("SELECT * FROM balance LIMIT 1")
    LiveData<Balance> getBalance();

    @Query("SELECT * FROM balance LIMIT 1")
    Balance getBalanceSync();


    @Query("INSERT OR REPLACE INTO balance (id, totalBalance) VALUES (1, :newBalance)")
    void insertOrUpdate(double newBalance);

    @Query("SELECT current_balance FROM balance ORDER BY id DESC LIMIT 1")
    Double getAllBalance();

    }
