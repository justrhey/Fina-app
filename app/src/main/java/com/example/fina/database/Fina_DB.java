package com.example.fina.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fina.Transaction;
import com.example.fina.Balance;
import com.example.fina.data_processing.Balance_data_access_object;
import com.example.fina.data_processing.Transaction_data_access_object;

@Database(
        entities = {Transaction.class, Balance.class},
        version = 2,
        exportSchema = false
)
public abstract class Fina_DB extends RoomDatabase{
    public abstract Transaction_data_access_object transactionDao();
    public  abstract Balance_data_access_object balanceDao();

    private static volatile Fina_DB INSTANCE;


    public static Fina_DB getInstance(Context context){
        if(INSTANCE == null){
            synchronized (Fina_DB.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Fina_DB.class,
                            "Fina_DB"

                    )
                            .fallbackToDestructiveMigration()
                            .build();
                }

            }
        }
        return INSTANCE;
    }
}
