package com.akshay.finalyear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        ListView trans_personal = (ListView) findViewById(R.id.trans_person);

        List<String> budget = new ArrayList<String>();
        budget.add("1500");
        budget.add("700");
        budget.add("650");

        ArrayAdapter<String> trans = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, budget);
        trans_personal.setAdapter(trans);
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(BudgetActivity.this, DrawerActivity.class);
        BudgetActivity.this.startActivity(in);
        super.onBackPressed();
    }
}
