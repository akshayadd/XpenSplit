package com.akshay.finalyear;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    Button add_expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*{setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        /*ListView trans_personal = (ListView) findViewById(R.id.trans_person);

        List<String> transactions = new ArrayList<String>();
        transactions.add("One");
        transactions.add("Two");
        transactions.add("Three");
        transactions.add("Four");
        transactions.add("Five");

        ArrayAdapter<String> trans = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, transactions);
        trans_personal.setAdapter(trans);*/

        add_expense = (Button) findViewById(R.id.sendButton);

        add_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonActivity.this, AddExpenseActivity.class);
                PersonActivity.this.startActivity(i);
                PersonActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(PersonActivity.this, DrawerActivity.class);
        PersonActivity.this.startActivity(in);
        super.onBackPressed();
    }
}
