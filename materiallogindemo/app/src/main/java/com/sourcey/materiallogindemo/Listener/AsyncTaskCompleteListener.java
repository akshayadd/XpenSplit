package com.sourcey.materiallogindemo.Listener;

import org.json.JSONObject;

public interface AsyncTaskCompleteListener {
    void onTaskCompleted(JSONObject response, int serviceCode);
}
