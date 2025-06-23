package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Platform.1
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    private Platform() {
    }

    public static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }
}
