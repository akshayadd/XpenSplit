package com.akshay.finalyear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//import com.akshay.finalyear.presenter.ExpensePresenter;

/**
 * Created by Akshay on 2/28/2017.
 */
public class AddExpenseActivity extends AppCompatActivity {

    //  Spinner spinner;
    //  TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_expense);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(AddExpenseActivity.this, PersonActivity.class);
        AddExpenseActivity.this.startActivity(in);
        super.onBackPressed();
    }
}
   /* @Override
    public void onClick(View view) {

        AddExpenseActivity activity = (AddExpenseActivity) getActivity();

        if (view.getId() == R.id.add_expense) {
            DataBaseHelper expenseDatabaseHelper = new DataBaseHelper(this.getActivity());
            ExpensePresenter expensePresenter = new ExpensePresenter(DataBaseHelper, this);
            if (expensePresenter.addExpense()) {
                spinner.setSelection(0);
                textView.setText("");
                activity.onExpenseAdded();
            }
            DatabaseHelper.close();
        }
    }*/



