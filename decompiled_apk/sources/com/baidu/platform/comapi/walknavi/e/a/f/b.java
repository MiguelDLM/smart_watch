package com.baidu.platform.comapi.walknavi.e.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes8.dex */
public class b extends AsyncTask<String, Integer, String> {

    /* renamed from: a, reason: collision with root package name */
    private String f9735a;
    private int b;
    private a<String> c;
    private boolean d = false;
    private boolean e;
    private String f;

    public b(String str, int i, boolean z, a<String> aVar) {
        this.f9735a = str;
        this.b = i;
        this.c = aVar;
        this.e = z;
    }

    private int b(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            return openConnection.getContentLength();
        } catch (MalformedURLException | IOException unused) {
            return 0;
        }
    }

    private boolean c(String str) {
        if (str == null || str.length() <= 0 || str.contains("../")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.e.a.f.b.d(java.lang.String):java.lang.String");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        a<String> aVar = this.c;
        if (aVar != null) {
            aVar.a(numArr[0].intValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0193, code lost:
    
        com.baidu.platform.comapi.walknavi.e.a.g.a.a(com.facebook.internal.AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0198, code lost:
    
        r8.close();
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b8, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01d6, code lost:
    
        if (r5 != null) goto L70;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String doInBackground(java.lang.String... r13) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.e.a.f.b.doInBackground(java.lang.String[]):java.lang.String");
    }

    private boolean a(String str, String str2) {
        return str != null && str.length() > 0 && str2 != null && str2.length() > 0 && str.startsWith(str2);
    }

    private boolean a(String str, File file) {
        String[] list;
        return (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0 && com.baidu.platform.comapi.walknavi.e.a.g.f.b(str, ".successUnzip.txt")) ? false : true;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a<String> aVar;
        if (TextUtils.isEmpty(str)) {
            a<String> aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b("download error!");
                return;
            }
            return;
        }
        if ("true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str) || (aVar = this.c) == null) {
            return;
        }
        aVar.a(100);
        this.c.a((a<String>) str);
    }
}
