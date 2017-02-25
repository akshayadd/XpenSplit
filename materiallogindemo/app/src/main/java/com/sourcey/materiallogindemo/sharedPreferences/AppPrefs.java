package com.sourcey.materiallogindemo.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.voucher.android.constants.PrefKeys;

public class AppPrefs {
    private SharedPreferences sharedPreferences;

    public AppPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(PrefKeys.keyAppPrefs, Context.MODE_PRIVATE);
    }

    public void saveAppPrefs(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getAppPrefs(String key) {
        return sharedPreferences.getString(key, "");
    }
}
