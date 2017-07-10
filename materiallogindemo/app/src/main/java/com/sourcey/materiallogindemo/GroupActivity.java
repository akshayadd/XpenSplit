package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Akshay on 2/22/2017.
 */
public class GroupActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(GroupActivity.this, MainActivity.class);
        GroupActivity.this.startActivity(in);
        super.onBackPressed();
    }
}
