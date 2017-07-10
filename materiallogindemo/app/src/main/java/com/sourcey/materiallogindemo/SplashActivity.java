package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sourcey.materiallogindemo.sharedPreferences.AppPrefs;

/**
 * Created by Akshay on 1/28/2017.
 */
public class SplashActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchActivity();
            }
        }, 3000);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    protected void showProgress(final String message) {
//        Log.e("show", message);
        hideProgress();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressDialog = ProgressDialog.show(SplashActivity.this, "", message);
            }
        });
    }
               /* final Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();*/

    protected void hideProgress() {
//        Log.e("hide", "hide");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        });
    }

    private void launchActivity() {
        Intent intent;
        String token = new AppPrefs(this).getAppPrefs(PrefKeys.keyMobileToken);
        if (token.equals(""))
            intent = new Intent(SplashActivity.this, LoginActivity.class);
        else {
            intent = new Intent(SplashActivity.this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
