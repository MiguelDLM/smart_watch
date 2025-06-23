package com.baidu.navisdk.ui.routeguide.control.indoorpark;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.model.o;

/* loaded from: classes8.dex */
public abstract class a {
    public abstract o a();

    public void a(boolean z) {
        if (z) {
            TTSPlayerControl.playTTS("导航结束", 1);
        }
        com.baidu.navisdk.ui.routeguide.b.V().Q();
    }

    public abstract boolean b();

    public abstract void c();
}
