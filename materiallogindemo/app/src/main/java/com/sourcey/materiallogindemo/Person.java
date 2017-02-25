package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sourcey.materiallogindemo.R;

import java.util.ArrayList;
import java.util.List;

public class Person extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);

        ListView trans_personal = (ListView) findViewById(R.id.trans_person);

        List<String> transactions = new ArrayList<String>();
        transactions.add("One");
        transactions.add("Two");
        transactions.add("Three");
        transactions.add("Four");
        transactions.add("Five");


        ArrayAdapter<String> trans = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, transactions);
        trans_personal.setAdapter(trans);


    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(Person.this, MainActivity.class);
        Person.this.startActivity(in);
        super.onBackPressed();
    }
}
