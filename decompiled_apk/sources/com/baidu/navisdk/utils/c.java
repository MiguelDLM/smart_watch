package com.baidu.navisdk.utils;

import android.text.Layout;
import android.widget.TextView;

/* loaded from: classes8.dex */
public class c {
    public static boolean a(TextView textView) {
        int lineCount;
        Layout layout = textView.getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
            return false;
        }
        return true;
    }
}
