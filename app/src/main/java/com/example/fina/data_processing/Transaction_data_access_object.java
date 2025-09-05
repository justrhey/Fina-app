    package com.example.fina.data_processing;


    import java.util.List;

    import androidx.room.Dao;
    import androidx.room.Query;
    import androidx.room.Insert;

    import com.example.fina.Transaction;
    import com.example.fina.Balance;  // <- make sure this entity exists!


    @Dao
    public interface Transaction_data_access_object{
        @Insert
        void insert(Transaction transaction);

        @Query("SELECT * FROM transactions ORDER BY id DESC")
        List<Transaction> getAllTransaction();
    }



