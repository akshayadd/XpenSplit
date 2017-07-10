package com.akshay.finalyear;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button _personal= (Button) findViewById(R.id.btn_personal);
        _personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sum = new Intent(DrawerActivity.this, PersonActivity.class);
                DrawerActivity.this.startActivity(sum);
                DrawerActivity.this.finish();
            }
        });

        Button _summaried= (Button) findViewById(R.id.btn_summary);
        _summaried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sum = new Intent(DrawerActivity.this, SummaryActivity.class);
                DrawerActivity.this.startActivity(sum);
                DrawerActivity.this.finish();
            }
        });

        Button _group= (Button) findViewById(R.id.btn_group);
        _group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sum = new Intent(DrawerActivity.this, PersonActivity.class);
                DrawerActivity.this.startActivity(sum);
                DrawerActivity.this.finish();
            }
        });

        Button _budget= (Button) findViewById(R.id.btn_budget);
        _budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sum = new Intent(DrawerActivity.this, BudgetActivity.class);
                DrawerActivity.this.startActivity(sum);
                DrawerActivity.this.finish();
            }
        });

        Button _category= (Button) findViewById(R.id.btn_category);
        _category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sum = new Intent(DrawerActivity.this, CategoryActivity.class);
                DrawerActivity.this.startActivity(sum);
                DrawerActivity.this.finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Button launches NewPostActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawerActivity.this, AddExpenseActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            moveTaskToBack(false);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {


        } else if (id == R.id.nav_add_expense) {

            Intent i = new Intent(DrawerActivity.this,AddExpenseActivity.class);
            DrawerActivity.this.startActivity(i);
        } else if (id == R.id.nav_add_category) {

        } else if (id == R.id.nav_view_summary) {

        } else if (id == R.id.nav_signOut) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK  && data != null){

            Uri selectedImage = data.getData();

            try {
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);

                ImageView imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmapImage);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
