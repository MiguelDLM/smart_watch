package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.navisdk.tts.BNTTS;

/* loaded from: classes8.dex */
final class k implements com.baidu.platform.comapi.wnplatform.tts.c {
    @Override // com.baidu.platform.comapi.wnplatform.tts.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.c
    public int b() {
        if (!com.baidu.platform.comapi.wnplatform.tts.a.f9969a) {
            try {
                return BNTTS.getTTSState();
            } catch (Throwable th) {
                th.getMessage();
                return 1;
            }
        }
        return 1;
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.c
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.c
    public int a(String str, boolean z) {
        IWTTSPlayer iWTTSPlayer;
        IWTTSPlayer iWTTSPlayer2;
        if (!com.baidu.platform.comapi.wnplatform.tts.a.f9969a) {
            try {
                return com.baidu.platform.comapi.wnplatform.tts.a.b(str, z);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        iWTTSPlayer = h.c;
        if (iWTTSPlayer == null) {
            return 0;
        }
        iWTTSPlayer2 = h.c;
        return iWTTSPlayer2.playTTSText(str, z);
    }
}
