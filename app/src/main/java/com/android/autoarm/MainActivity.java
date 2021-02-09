package com.android.autoarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.android.autoarm.services.MyAccessibilityService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent_s = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent_s);

        Intent intent = new Intent(MainActivity.this, MyAccessibilityService.class);
        startService(intent);
    }
}