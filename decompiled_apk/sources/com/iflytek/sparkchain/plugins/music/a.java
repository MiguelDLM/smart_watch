package com.iflytek.sparkchain.plugins.music;

import android.accessibilityservice.AccessibilityService;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.iflytek.sparkchain.plugins.utils.Utils;

/* loaded from: classes10.dex */
public class a {
    public static AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, String str2, String str3) {
        AccessibilityNodeInfo rootInActiveWindow;
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) && (rootInActiveWindow = accessibilityService.getRootInActiveWindow()) != null) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) {
                String charSequence = TextUtils.isEmpty(accessibilityNodeInfo.getText()) ? "" : accessibilityNodeInfo.getText().toString();
                String charSequence2 = TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription()) ? "" : accessibilityNodeInfo.getContentDescription().toString();
                Log.w(Utils.TAG, "nText: " + charSequence + " nDesc: " + charSequence2 + " name: " + accessibilityNodeInfo.getViewIdResourceName());
                if (TextUtils.isEmpty(charSequence2)) {
                    if (str3.equals(charSequence2)) {
                        return accessibilityNodeInfo;
                    }
                } else if (str2.equals(charSequence)) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }
}
