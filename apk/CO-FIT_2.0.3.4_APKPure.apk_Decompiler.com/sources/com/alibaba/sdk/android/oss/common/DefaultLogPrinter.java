package com.alibaba.sdk.android.oss.common;

import android.util.Log;

public class DefaultLogPrinter implements LogPrinter {
    private static final String TAG = "OSS-Android-SDK";

    /* renamed from: com.alibaba.sdk.android.oss.common.DefaultLogPrinter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.sdk.android.oss.common.LogLevel[] r0 = com.alibaba.sdk.android.oss.common.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel = r0
                com.alibaba.sdk.android.oss.common.LogLevel r1 = com.alibaba.sdk.android.oss.common.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.oss.common.LogLevel r1 = com.alibaba.sdk.android.oss.common.LogLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.oss.common.LogLevel r1 = com.alibaba.sdk.android.oss.common.LogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.sdk.android.oss.common.LogLevel r1 = com.alibaba.sdk.android.oss.common.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.sdk.android.oss.common.LogLevel r1 = com.alibaba.sdk.android.oss.common.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.DefaultLogPrinter.AnonymousClass1.<clinit>():void");
        }
    }

    public void log(LogLevel logLevel, String str) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            Log.i(TAG, "[INFO]: ".concat(str));
        } else if (i == 2) {
            Log.v(TAG, "[VERBOSE]: ".concat(str));
        } else if (i == 3) {
            Log.w(TAG, "[WARN]: ".concat(str));
        } else if (i == 4) {
            Log.d(TAG, "[DEBUG]: ".concat(str));
        } else if (i == 5) {
            Log.e(TAG, "[ERROR]: ".concat(str));
        }
    }
}
