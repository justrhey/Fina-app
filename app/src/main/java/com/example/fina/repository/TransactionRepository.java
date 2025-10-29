package com.example.fina.repository;

import android.app.Application;

import com.example.fina.database.Fina_DB;
import com.example.fina.data_processing.Transaction_data_access_object;
import com.example.fina.data_processing.Balance_data_access_object;
import com.example.fina.entity.Balance;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionRepository {
    private final Transaction_data_access_object transactionDao;
    private  final Balance_data_access_object balanceDao;
    private  final List<Balance.Transaction> allTransactions;
    private final ExecutorService executorService;
    public TransactionRepository(Application application){
        Fina_DB database = Fina_DB.getInstance(application);
        transactionDao = database.transactionDao();
        balanceDao = database.balanceDao();
        allTransactions = transactionDao.getAllTransaction();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void insertTransaction(Balance.Transaction transaction){
        executorService.execute(() -> {
           Balance.Transaction oldTransaction = transactionDao.getTransactionByIdSync(transaction.getId());
        });
    }
}