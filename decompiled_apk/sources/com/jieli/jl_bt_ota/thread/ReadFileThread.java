package com.jieli.jl_bt_ota.thread;

import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.thread.ReadFileThread;

/* loaded from: classes10.dex */
public class ReadFileThread extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final String f17735a;
    private final IActionCallback<byte[]> b;
    private final Handler c = new Handler(Looper.getMainLooper());

    public ReadFileThread(String str, IActionCallback<byte[]> iActionCallback) {
        this.f17735a = str;
        this.b = iActionCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr) {
        IActionCallback<byte[]> iActionCallback = this.b;
        if (iActionCallback != null) {
            iActionCallback.onSuccess(bArr);
        }
    }

    private void b(final byte[] bArr) {
        this.c.post(new Runnable() { // from class: XIXIxO.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                ReadFileThread.this.a(bArr);
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v26, types: [byte[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x008a -> B:13:0x00ab). Please report as a decompilation issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "file path : "
            r0.append(r1)
            java.lang.String r1 = r6.f17735a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ReadFileThread"
            com.jieli.jl_bt_ota.util.JL_Log.d(r1, r0)
            java.lang.String r0 = r6.f17735a
            boolean r0 = com.jieli.jl_bt_ota.util.FileUtil.checkFileExist(r0)
            if (r0 == 0) goto La0
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L59 java.io.FileNotFoundException -> L5b java.lang.Throwable -> L76
            java.lang.String r2 = r6.f17735a     // Catch: java.io.IOException -> L59 java.io.FileNotFoundException -> L5b java.lang.Throwable -> L76
            r1.<init>(r2)     // Catch: java.io.IOException -> L59 java.io.FileNotFoundException -> L5b java.lang.Throwable -> L76
            int r0 = r1.available()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            int r2 = r1.read(r0)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            if (r2 < 0) goto L45
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            r4 = 0
            java.lang.System.arraycopy(r0, r4, r3, r4, r2)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            r6.b(r3)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            goto L4e
        L3e:
            r0 = move-exception
            goto L95
        L41:
            r0 = move-exception
            goto L55
        L43:
            r0 = move-exception
            goto L78
        L45:
            r0 = 20485(0x5005, float:2.8706E-41)
            com.jieli.jl_bt_ota.model.base.BaseError r0 = com.jieli.jl_bt_ota.model.OTAError.buildError(r0)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            r6.b(r0)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41 java.io.FileNotFoundException -> L43
        L4e:
            r1.close()     // Catch: java.io.IOException -> L53
            goto Lab
        L53:
            r0 = move-exception
            goto L8a
        L55:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L60
        L59:
            r1 = move-exception
            goto L60
        L5b:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L78
        L60:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L76
            r2 = 20486(0x5006, float:2.8707E-41)
            com.jieli.jl_bt_ota.model.base.BaseError r1 = com.jieli.jl_bt_ota.model.OTAError.buildError(r2, r1)     // Catch: java.lang.Throwable -> L76
            r6.b(r1)     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto Lab
            r0.close()     // Catch: java.io.IOException -> L53
            goto Lab
        L76:
            r1 = move-exception
            goto L92
        L78:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            r0 = 20484(0x5004, float:2.8704E-41)
            com.jieli.jl_bt_ota.model.base.BaseError r0 = com.jieli.jl_bt_ota.model.OTAError.buildError(r0)     // Catch: java.lang.Throwable -> L8e
            r6.b(r0)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto Lab
            r1.close()     // Catch: java.io.IOException -> L53
            goto Lab
        L8a:
            r0.printStackTrace()
            goto Lab
        L8e:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L92:
            r5 = r1
            r1 = r0
            r0 = r5
        L95:
            if (r1 == 0) goto L9f
            r1.close()     // Catch: java.io.IOException -> L9b
            goto L9f
        L9b:
            r1 = move-exception
            r1.printStackTrace()
        L9f:
            throw r0
        La0:
            r0 = 4097(0x1001, float:5.741E-42)
            java.lang.String r1 = "File path does not exist."
            com.jieli.jl_bt_ota.model.base.BaseError r0 = com.jieli.jl_bt_ota.model.OTAError.buildError(r0, r1)
            r6.b(r0)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.thread.ReadFileThread.run():void");
    }

    private void b(final BaseError baseError) {
        if (baseError == null) {
            return;
        }
        this.c.post(new Runnable() { // from class: XIXIxO.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                ReadFileThread.this.a(baseError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseError baseError) {
        IActionCallback<byte[]> iActionCallback = this.b;
        if (iActionCallback != null) {
            iActionCallback.onError(baseError);
        }
    }
}
