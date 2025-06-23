package com.goodix.ble.libcomx.util;

import XXO0.oIX0oI;
import java.io.IOException;

/* loaded from: classes9.dex */
public class CallUtil {
    public static final String DEFAULT_SPLITTER = "<-";

    public static Appendable trace(int i) {
        return trace(i, null, null, 1);
    }

    public static Appendable trace(int i, CharSequence charSequence, Appendable appendable) {
        return trace(i, charSequence, appendable, 1);
    }

    public static Appendable trace(int i, CharSequence charSequence, Appendable appendable, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i3 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            i3++;
            if (stackTraceElement.getClassName().equals(Thread.class.getName())) {
                break;
            }
        }
        return trace(stackTrace, i, charSequence, appendable, i2 + 2 + i3);
    }

    public static Appendable trace(StackTraceElement[] stackTraceElementArr, int i) {
        return trace(stackTraceElementArr, i, DEFAULT_SPLITTER, null, 0);
    }

    public static Appendable trace(StackTraceElement[] stackTraceElementArr, int i, CharSequence charSequence, Appendable appendable, int i2) {
        if (i < 1) {
            i = 1;
        }
        if (appendable == null) {
            appendable = new StringBuffer(i * 64);
        }
        if (charSequence == null) {
            charSequence = DEFAULT_SPLITTER;
        }
        int i3 = i2;
        for (int i4 = 0; i3 < stackTraceElementArr.length && i4 < i; i4++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            if (i3 > i2) {
                try {
                    appendable.append(charSequence);
                } catch (IOException unused) {
                }
            }
            appendable.append(stackTraceElement.getMethodName()).append(oIX0oI.I0Io.f4096II0xO0).append(stackTraceElement.getFileName()).append(":").append(String.valueOf(stackTraceElement.getLineNumber())).append(oIX0oI.I0Io.f4095I0Io);
            i3++;
        }
        return appendable;
    }
}
