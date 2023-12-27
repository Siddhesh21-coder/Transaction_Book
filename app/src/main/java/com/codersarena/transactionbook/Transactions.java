package com.codersarena.transactionbook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "transactions")
public class Transactions {
    @ColumnInfo(name="transaction_id")
    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo(name="amount")
    private double amount;
    @ColumnInfo(name="type")
    private String type;
    @ColumnInfo(name="description")
    private String description;
    private String method;
    private Date TDate;

    public Transactions(double amount, String type, String description, String method, Date TDate) {
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.method = method;
        this.TDate = TDate;
    }

    public Transactions() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getTDate() {
        return TDate;
    }

    public void setTDate(Date TDate) {
        this.TDate = TDate;
    }
}
