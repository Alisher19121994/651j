package com.example.a651j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * IntentService is an extension of the Service component class that
 * handles asynchronous requests (expressed as Intents) on demand.
 * Clients send requests through Context.startService(Intent) calls; the
 * service is started as needed, handles each Intent in turn using a worker thread,
 * and stops itself when it runs out of work.
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        TextView textView = findViewById(R.id.text_id);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                textView.setText("Service is running!");
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyIntentService().stopService();
                textView.setText("Service stopped!");
            }
        });
    }
}