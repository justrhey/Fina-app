package com.example.fina.data_processing;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fina.Balance;

import java.util.List;

@Dao
   public interface Balance_data_access_object{

        @Insert
        void  insert(Balance balance);

    @Query("SELECT current_balance FROM balance ORDER BY id DESC LIMIT 1")
        Double getAllBalance();

    }
