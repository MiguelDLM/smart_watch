package com.baidu.navisdk.util.http.custom;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f9303a = Collections.synchronizedList(new ArrayList(6));

    private boolean b(String str) {
        return !this.f9303a.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01cc A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #2 {all -> 0x01e1, blocks: (B:43:0x01c4, B:45:0x01cc), top: B:42:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.navisdk.util.http.custom.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r20, com.baidu.navisdk.util.http.custom.listeners.a r21, java.io.File r22) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.http.custom.a.a(java.lang.String, com.baidu.navisdk.util.http.custom.listeners.a, java.io.File):void");
    }

    private void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    @Override // com.baidu.navisdk.util.http.custom.b
    public boolean a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNFileDownload", "cancelDownloadFile: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9303a.remove(str);
    }
}
