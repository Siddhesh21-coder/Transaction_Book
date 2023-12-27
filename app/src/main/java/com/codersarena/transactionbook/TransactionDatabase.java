package com.codersarena.transactionbook;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Transactions.class},version = 1)
public abstract class TransactionDatabase extends RoomDatabase {
    public abstract TransactionsDAO getTransactionDAO();
    private static TransactionDatabase dbinstance;
    public static synchronized TransactionDatabase getInstance(Context context) {
        if(dbinstance == null) {
            dbinstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    TransactionDatabase.class,
                    "transaction_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbinstance;
    }


}
