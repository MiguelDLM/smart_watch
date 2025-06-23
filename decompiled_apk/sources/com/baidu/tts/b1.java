package com.baidu.tts;

import android.util.Log;
import java.io.File;

/* loaded from: classes8.dex */
public class b1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public File f10040a;
    public a1 c = new a1(this);
    public c1 d = new c1(this);
    public v0 b = this.c;

    @Override // com.baidu.tts.w0
    public void a(Object obj, Object obj2, Object obj3) {
        int a2 = this.b.a((x0) obj);
        if (a2 < 0) {
            Log.e("StorageLoggerHandler", "write log failed! ret=" + a2);
        }
    }
}
