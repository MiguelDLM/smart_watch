package com.baidu.platform.comapi.bikenavi.b;

import com.baidu.platform.comapi.wnplatform.p.m;
import com.baidu.platform.comapi.wnplatform.tts.c;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.wnplatform.tts.a {
    private c d = null;

    public int b() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.b();
        }
        return 0;
    }

    public void c() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        a();
        WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        com.baidu.platform.comapi.wnplatform.tts.a.e();
        com.baidu.platform.comapi.wnplatform.tts.a.b = null;
        this.d = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.a
    public void a(c cVar) {
        this.d = cVar;
    }

    public void a() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        if (com.baidu.platform.comapi.walknavi.b.f9700a == com.baidu.platform.comapi.walknavi.b.a().w()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.b != com.baidu.platform.comapi.walknavi.b.a().w()) {
            return a(str, false);
        }
        if (i == 1) {
            m.a().b(com.baidu.platform.comapi.wnplatform.f.a.a().b());
            return 1;
        }
        if (i == 2) {
            m.a().c(com.baidu.platform.comapi.wnplatform.f.a.a().c());
            return 1;
        }
        if (m.a().b()) {
            return 0;
        }
        return a(str, false);
    }

    public int a(String str, boolean z) {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.a(str, z);
        }
        return 0;
    }
}
