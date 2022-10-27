package com.example.a651j;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    private final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("service");
    }


    MyIntentService instance;

    boolean isRunning = false;

    void stopService() {

        Log.e(TAG,"Service is stopped!");
        boolean isRunning = false;

        if (instance != null) {
            instance.stopSelf();
        }

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            isRunning = true;

            while (isRunning) {
                Log.e(TAG,"Service is running!");
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
