package com.codersarena.transactionbook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionsDAO {

    @Insert
    void insert(Transactions transactions);
    @Delete
    void delete(Transactions transactions);
    @Update
    void update(Transactions transactions);

    @Query("SELECT * FROM transactions")
    LiveData<List<Transactions>> getAllTransactions();
}
