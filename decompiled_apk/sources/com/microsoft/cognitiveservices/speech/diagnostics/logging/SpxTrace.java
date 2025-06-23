package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class SpxTrace {
    private static final int __SPX_TRACE_LEVEL_ERROR = 2;
    private static final int __SPX_TRACE_LEVEL_INFO = 8;
    private static final int __SPX_TRACE_LEVEL_VERBOSE = 16;
    private static final int __SPX_TRACE_LEVEL_WARNING = 4;

    /* loaded from: classes11.dex */
    public static class CallerInfo {
        public String fileName;
        public int lineNumber;

        public CallerInfo(String str, int i) {
            this.fileName = str;
            this.lineNumber = i;
        }
    }

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private SpxTrace() {
    }

    public static void SPX_TRACE_ERROR(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_ERROR(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    private static void SPX_TRACE_HELPER(int i, String str, String str2, Object[] objArr, int i2, String str3) {
        Contracts.throwIfNull(str, "title");
        Contracts.throwIfNull(str2, "format");
        Contracts.throwIfNull(objArr, "args");
        Contracts.throwIfNull(str3, "file");
        Contracts.throwIfFail(logTraceString(i, str, str3, i2, String.format(str2, objArr)));
    }

    public static void SPX_TRACE_INFO(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_INFO(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_VERBOSE(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_VERBOSE(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_WARNING(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_WARNING(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    private static Object[] args(Object... objArr) {
        return objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r3 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.microsoft.cognitiveservices.speech.diagnostics.logging.SpxTrace.CallerInfo getCallerInfo() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.lang.Exception -> L1c
            java.lang.StackTraceElement[] r2 = r2.getStackTrace()     // Catch: java.lang.Exception -> L1c
            r3 = 2
            r2 = r2[r3]     // Catch: java.lang.Exception -> L1c
            if (r2 == 0) goto L1c
            java.lang.String r3 = r2.getFileName()     // Catch: java.lang.Exception -> L1c
            int r1 = r2.getLineNumber()     // Catch: java.lang.Exception -> L1b
            if (r3 != 0) goto L1b
            goto L1c
        L1b:
            r0 = r3
        L1c:
            com.microsoft.cognitiveservices.speech.diagnostics.logging.SpxTrace$CallerInfo r2 = new com.microsoft.cognitiveservices.speech.diagnostics.logging.SpxTrace$CallerInfo
            r2.<init>(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.cognitiveservices.speech.diagnostics.logging.SpxTrace.getCallerInfo():com.microsoft.cognitiveservices.speech.diagnostics.logging.SpxTrace$CallerInfo");
    }

    private static final native long logTraceString(int i, String str, String str2, int i2, String str3);

    public static void SPX_TRACE_ERROR(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(2, "SPX_TRACE_ERROR", str, objArr, i, str2);
    }

    public static void SPX_TRACE_INFO(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(8, "SPX_TRACE_INFO", str, objArr, i, str2);
    }

    public static void SPX_TRACE_VERBOSE(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(16, "SPX_TRACE_VERBOSE", str, objArr, i, str2);
    }

    public static void SPX_TRACE_WARNING(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(4, "SPX_TRACE_WARNING", str, objArr, i, str2);
    }
}
