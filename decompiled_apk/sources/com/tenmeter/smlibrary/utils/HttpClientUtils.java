package com.tenmeter.smlibrary.utils;

/* loaded from: classes13.dex */
public class HttpClientUtils {
    private static final String TAG = "HttpClientUtils";

    /* loaded from: classes13.dex */
    public interface OnRequestCallBack {
        void onError(String str);

        void onSuccess(String str);
    }

    public static void get(final String str, final OnRequestCallBack onRequestCallBack) {
        new Thread() { // from class: com.tenmeter.smlibrary.utils.HttpClientUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpClientUtils.getRequest(str, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x006d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:110), block:B:72:0x006d */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void getRequest(java.lang.String r7, com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack r8) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.HttpClientUtils.getRequest(java.lang.String, com.tenmeter.smlibrary.utils.HttpClientUtils$OnRequestCallBack):void");
    }

    public static void post(final String str, final String str2, final OnRequestCallBack onRequestCallBack) {
        new Thread() { // from class: com.tenmeter.smlibrary.utils.HttpClientUtils.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpClientUtils.postRequest(str, str2, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void postRequest(java.lang.String r6, java.lang.String r7, com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.HttpClientUtils.postRequest(java.lang.String, java.lang.String, com.tenmeter.smlibrary.utils.HttpClientUtils$OnRequestCallBack):void");
    }
}
