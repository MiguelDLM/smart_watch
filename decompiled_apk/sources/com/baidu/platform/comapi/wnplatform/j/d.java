package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.navisdk.tts.BNTTS;

/* loaded from: classes8.dex */
final class d implements com.baidu.platform.comapi.wnplatform.tts.c {
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
        IBTTSPlayer iBTTSPlayer;
        IBTTSPlayer iBTTSPlayer2;
        if (!com.baidu.platform.comapi.wnplatform.tts.a.f9969a) {
            try {
                return com.baidu.platform.comapi.wnplatform.tts.a.b(str, z);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        iBTTSPlayer = a.b;
        if (iBTTSPlayer == null) {
            return 0;
        }
        iBTTSPlayer2 = a.b;
        return iBTTSPlayer2.playTTSText(str, z);
    }
}
