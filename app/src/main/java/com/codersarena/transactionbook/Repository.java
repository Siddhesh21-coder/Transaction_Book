package com.codersarena.transactionbook;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {
    private final TransactionsDAO transactionsDAO;
    Handler handler;
    ExecutorService executor;
    public Repository(Application application) {
        TransactionDatabase transactionDatabase = TransactionDatabase.getInstance(application);
        this.transactionsDAO = transactionDatabase.getTransactionDAO();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
    public void addTransaction(Transactions transactions){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                transactionsDAO.insert(transactions);
            }
        });
    }
    public void deleteTransaction(Transactions transactions){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                transactionsDAO.delete(transactions);
            }
        });
    }
    public LiveData<List<Transactions>> getAllTransactions() {
        return transactionsDAO.getAllTransactions();
    }
}
