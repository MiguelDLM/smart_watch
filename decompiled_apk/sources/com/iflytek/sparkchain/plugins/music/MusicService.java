package com.iflytek.sparkchain.plugins.music;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.iflytek.sparkchain.plugins.utils.Utils;

/* loaded from: classes10.dex */
public class MusicService extends AccessibilityService {
    public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            accessibilityNodeInfo.performAction(16);
            return true;
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        if (parent == null) {
            return false;
        }
        boolean b = b(parent);
        parent.recycle();
        return b;
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence text = accessibilityNodeInfo.getText();
        if (text == null) {
            text = "";
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, 0);
        bundle.putInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, text.length());
        accessibilityNodeInfo.performAction(1);
        accessibilityNodeInfo.performAction(131072, bundle);
        accessibilityNodeInfo.performAction(32768);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence packageName = accessibilityEvent.getPackageName();
        if (32 == accessibilityEvent.getEventType() && !TextUtils.isEmpty(packageName)) {
            Log.d(Utils.TAG, ((Object) packageName) + " ");
            if ("com.netease.cloudmusic".equals(packageName.toString())) {
                Log.d(Utils.TAG, accessibilityEvent.toString());
                AccessibilityNodeInfo a2 = a.a(this, "com.netease.cloudmusic:id/searchBar", "", "");
                if (a2 != null) {
                    b(a2);
                    a2.recycle();
                } else {
                    Log.d(Utils.TAG, "searchBar not found");
                }
                AccessibilityNodeInfo a3 = a.a(this, "com.netease.cloudmusic:id/search_src_text", "", "");
                if (a3 == null) {
                    Log.d(Utils.TAG, "searchSrcText not found");
                    return;
                }
                a(a3);
                AccessibilityNodeInfo a4 = a.a(this, "com.netease.cloudmusic:id/toSearch", "", "");
                if (a4 != null) {
                    if (b(a4)) {
                        try {
                            Thread.sleep(3000L);
                            AccessibilityNodeInfo a5 = a.a(this, "com.netease.cloudmusic:id/actionView", "", "");
                            if (a5 != null) {
                                b(a5);
                                a5.recycle();
                            } else {
                                Log.d(Utils.TAG, "playAll not found");
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    a4.recycle();
                } else {
                    Log.d(Utils.TAG, "toSearch not found");
                }
                a3.recycle();
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.e(Utils.TAG, "MusicService Interrupted");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        Log.e(Utils.TAG, "MusicService Connected");
    }
}
