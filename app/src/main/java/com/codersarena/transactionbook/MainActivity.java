package com.codersarena.transactionbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.util.LocaleData;
import android.os.Bundle;

import com.codersarena.transactionbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TransactionDatabase transactionDatabase;
    private ArrayList<Transactions> transactions = new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandler(this);
        mainBinding.setClickHandler(handlers);
        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        transactionDatabase = TransactionDatabase.getInstance(this);
        MyViewHolder viewModel = new ViewModelProvider(this).get(MyViewHolder.class);
        Date date = new Date();
        Transactions transactions1 = new Transactions(100, "debit", "Development of app", "Cash", "27 Dec", "EdTech");
        viewModel.addNewTransaction(transactions1);
        viewModel.getAllTransactions().observe(this,
                new Observer<List<Transactions>>() {
                    @Override
                    public void onChanged(List<Transactions> transactions1) {
                        transactions.clear();
                        for(Transactions t:transactions1){
                            transactions.add(t);
                        }
                        myAdapter.notifyDataSetChanged();
                    }
                });
        myAdapter = new MyAdapter(transactions);
        recyclerView.setAdapter(myAdapter);

    }
}