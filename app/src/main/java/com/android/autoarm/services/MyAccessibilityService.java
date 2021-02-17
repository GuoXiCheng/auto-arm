package com.android.autoarm.services;

import android.accessibilityservice.AccessibilityButtonController;
import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class MyAccessibilityService extends AccessibilityService {

    private AccessibilityNodeInfo nodeInfo = null;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source = getRootInActiveWindow();

//        if (source == null || source.equals(nodeInfo)) {
//            return;
//        }

//        nodeInfo = source;
        if (source != null) {
            AccessibilityNodeInfo resultNode = getChildNodeByText(source, "会员礼遇");
        }


    }

    public AccessibilityNodeInfo getChildNodeByText(AccessibilityNodeInfo nodeInfo, String text) {
        int childCount = 0;
        if (nodeInfo != null) {
            childCount = nodeInfo.getChildCount();
        }

        for (int i = 0; i < childCount; i++){
            if (nodeInfo != null) {
                AccessibilityNodeInfo node = getChildNodeByText(nodeInfo.getChild(i), text);
            }
        }
        String nodeText = null;
        if (nodeInfo != null) {
            nodeText = nodeInfo.getText() + "";
        }

//        if (!nodeText.equals("null")) {
//            Log.i("test", nodeText);
//        }

        return nodeInfo;
    }

    public void clickNodeByText(String text, AccessibilityNodeInfo nodeInfo) {
        nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText(text);
            Log.i("节点信息",list.toString());
            if (list.size() != 0) {
                list.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
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
