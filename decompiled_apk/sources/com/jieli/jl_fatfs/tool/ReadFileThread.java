package com.jieli.jl_fatfs.tool;

import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener;
import com.jieli.jl_fatfs.tool.ReadFileThread;

/* loaded from: classes10.dex */
public class ReadFileThread extends Thread {
    public static final String d = "ReadFileThread";

    /* renamed from: a, reason: collision with root package name */
    public final String f17818a;
    public final OnFatFsOpResultListener<byte[]> b;
    public final Handler c = new Handler(Looper.getMainLooper());

    public ReadFileThread(String str, OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        this.f17818a = str;
        this.b = onFatFsOpResultListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr) {
        OnFatFsOpResultListener<byte[]> onFatFsOpResultListener = this.b;
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(bArr);
        }
    }

    public final void b(final byte[] bArr) {
        this.c.post(new Runnable() { // from class: OIOoIIOIx.oIX0oI
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
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0098 -> B:14:0x00b6). Please report as a decompilation issue!!! */
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
            java.lang.String r1 = "mUpgradeFilePath : "
            r0.append(r1)
            java.lang.String r1 = r6.f17818a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ReadFileThread"
            android.util.Log.d(r1, r0)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.f17818a
            r0.<init>(r1)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto Lac
            boolean r0 = r0.isFile()
            if (r0 == 0) goto Lac
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L5b
            java.lang.String r1 = r6.f17818a     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L5b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L5b
            int r1 = r0.available()     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            int r3 = r0.read(r1)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            if (r3 <= 0) goto L4f
            byte[] r4 = new byte[r3]     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            r5 = 0
            java.lang.System.arraycopy(r1, r5, r4, r5, r3)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            r6.b(r4)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            goto L4f
        L49:
            r1 = move-exception
            goto La1
        L4b:
            r1 = move-exception
            goto L5f
        L4d:
            r1 = move-exception
            goto L85
        L4f:
            r0.close()     // Catch: java.io.IOException -> L54
            goto Lb6
        L54:
            r0 = move-exception
            goto L98
        L56:
            r0 = move-exception
            goto L9f
        L58:
            r0 = move-exception
            r1 = r0
            goto L5e
        L5b:
            r1 = move-exception
            r0 = r2
            goto L85
        L5e:
            r0 = r2
        L5f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = com.jieli.jl_fatfs.tool.ReadFileThread.d     // Catch: java.lang.Throwable -> L49
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r4.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "error : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L49
            r4.append(r1)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L49
            android.util.Log.w(r3, r1)     // Catch: java.lang.Throwable -> L49
            r6.b(r2)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto Lb6
            r0.close()     // Catch: java.io.IOException -> L54
            goto Lb6
        L85:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = com.jieli.jl_fatfs.tool.ReadFileThread.d     // Catch: java.lang.Throwable -> L9c
            java.lang.String r3 = "file not found"
            android.util.Log.w(r1, r3)     // Catch: java.lang.Throwable -> L9c
            r6.b(r2)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto Lb6
            r0.close()     // Catch: java.io.IOException -> L54
            goto Lb6
        L98:
            r0.printStackTrace()
            goto Lb6
        L9c:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L9f:
            r1 = r0
            r0 = r2
        La1:
            if (r0 == 0) goto Lab
            r0.close()     // Catch: java.io.IOException -> La7
            goto Lab
        La7:
            r0 = move-exception
            r0.printStackTrace()
        Lab:
            throw r1
        Lac:
            java.lang.String r0 = com.jieli.jl_fatfs.tool.ReadFileThread.d
            java.lang.String r1 = "file path not exist."
            android.util.Log.w(r0, r1)
            r6.b(r2)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_fatfs.tool.ReadFileThread.run():void");
    }
}
