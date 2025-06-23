package com.baidu.navisdk.util.common;

import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes8.dex */
public class t {
    public static String a(int i) {
        if (i >= 10000) {
            return String.valueOf(i / 1000);
        }
        if (i >= 1000) {
            float round = Math.round((((float) (i / 1000.0d)) * 10.0f) * 1.0f) / 10.0f;
            int i2 = (int) round;
            if (i2 == round) {
                return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2));
            }
            return String.format("%.1f", Float.valueOf(round));
        }
        if (i >= 0) {
            return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
        }
        return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
    }
}
