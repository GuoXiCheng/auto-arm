package com.android.autoarm.services;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class MyAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source = getRootInActiveWindow();
        if (source != null) {
            System.out.println("hhh");
            System.out.println(source.findAccessibilityNodeInfosByText("微信"));
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Test", "Start");
    }

    @Override
    public void onInterrupt() {
        Log.i("Test", "onInterrupt");
    }
}
