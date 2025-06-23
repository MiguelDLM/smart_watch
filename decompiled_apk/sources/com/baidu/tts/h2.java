package com.baidu.tts;

import com.baidu.tts.i2;
import com.baidu.tts.jni.TtsLogLoad;

/* loaded from: classes8.dex */
public class h2 implements i2.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i2.a f10101a;

    public h2(i2.a aVar) {
        this.f10101a = aVar;
    }

    public String a(boolean z) throws Exception {
        i2.d dVar;
        if (z) {
            i2.a().getClass();
            i2.j = true;
            String path = i2.this.f10107a.getCacheDir().getPath();
            i2.this.getClass();
            TtsLogLoad.initLocalTtsWpData(path, 30000, false, true, false, true, true);
            i2.a aVar = this.f10101a;
            if (aVar.b && (dVar = aVar.c) != null) {
                i2.b bVar = (i2.b) dVar;
                i2.this.b(bVar.f10109a, bVar.b, bVar.c, bVar.d, bVar.e);
                return null;
            }
            return null;
        }
        i2.a().getClass();
        i2.j = false;
        return null;
    }
}
