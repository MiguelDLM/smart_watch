package okhttp3.internal.http;

import okhttp3.Interceptor;

/* loaded from: classes6.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0168 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    @Override // okhttp3.Interceptor
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(@OXOo.OOXIXo okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
