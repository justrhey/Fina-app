    package com.example.fina.data_processing;


    import java.util.List;

    import androidx.lifecycle.LiveData;
    import androidx.room.Dao;
    import androidx.room.Query;
    import androidx.room.Insert;
    import androidx.room.Delete;
    import androidx.room.Update;

    import com.example.fina.entity.Balance;


    @Daos
    public interface Transaction_data_access_object{
        @Insert
        void insert(Balance.Transaction transaction);
        @Update
        void update(Balance.Transaction transaction);

        @Delete
        void delete(Balance.Transaction transaction);

        //Get all transaction using live data for real time updates
        @Query("SELECT * FROM transactions ORDER BY date DESC, id DESC")
        LiveData<List<Balance.Transaction>> getAllTransactions();

        //Get single id for transaction editing
        @Query("SELECT * FROM transactions WHERE id = :id LIMIT 1")
        LiveData<Balance.Transaction> getTransactionById(int id);

        //Use non-live data for background operation
        @Query("SELECT * FROM transactions WHERE id = :id")
        Balance.Transaction getTransactionByIdSync(int id);

        //Filter to see categories
        @Query("SELECT * FROM transactions WHERE category = :category ORDER BY date DESC")
        LiveData<List<Balance.Transaction>>  getAllCategoryById(String category);

        @Query("SELECT * FROM  transactions WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
        LiveData<List<Balance.Transaction>> getTransactinByDateRange(String startDate, String endDate);

        @Query("SELECT SUM (amount) FROM transactions WHERE category = :category")
        LiveData<Double> getTotalAmountByCategory(String category);

        //For selection for categoriies
        @Query("SELECT DISTINCT category FROM transactions")
        LiveData<List<String>> getAlCategories();

        @Query("DELETE FROM transactions WHERE id = :id")
        void deleteById(int id);

    }



