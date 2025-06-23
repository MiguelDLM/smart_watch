package com.kwad.components.core.s;

import androidx.annotation.Nullable;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public final class f {
    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTraceElement.getMethodName();
    }

    public static boolean aB(@Nullable String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }
}
