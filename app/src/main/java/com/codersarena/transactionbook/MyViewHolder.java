package com.codersarena.transactionbook;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewHolder extends AndroidViewModel {
    private Repository myRepository;
    private LiveData<List<Transactions>> allTransactions;

    public MyViewHolder(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }
    public LiveData<List<Transactions>> getAllTransactions(){
        allTransactions = myRepository.getAllTransactions();
        return allTransactions;
    }
    public void addNewTransaction(Transactions transactions){ myRepository.addTransaction(transactions);}
    public void deleteNewTransaction(Transactions transactions){ myRepository.deleteTransaction(transactions);}
}
