package com.baidu.tts;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.t0;
import com.baidu.tts.tools.ConfigTool;

/* loaded from: classes8.dex */
public class r0 extends k0 {
    public r0(p0 p0Var) {
        super(p0Var);
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a(x4 x4Var) {
        create();
        if (this.f10117a.d != this) {
            this.f10117a.a(x4Var);
        }
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public TtsError create() {
        p0 p0Var = this.f10117a;
        t0 t0Var = (t0) p0Var.f;
        t0Var.f10164a = new o0(p0Var);
        t0.a aVar = t0Var.c;
        int i = aVar.c;
        t0Var.l = i;
        int i2 = aVar.d;
        int i3 = aVar.e;
        int i4 = aVar.f10167a;
        int i5 = aVar.f;
        int i6 = aVar.i;
        int i7 = aVar.j;
        int a2 = t0Var.a(i, i2, i3);
        int i8 = ConfigTool.sPlayStreamType;
        if (i8 != 2 && i8 == 1) {
            t0Var.b = new AudioTrack(i4, i, i2, i3, a2, i5);
        } else {
            t0Var.b = new AudioTrack(new AudioAttributes.Builder().setUsage(i6).setContentType(i7).build(), new AudioFormat.Builder().setSampleRate(i).setEncoding(i3).setChannelMask(i2).build(), a2, i5, 0);
        }
        t0.a aVar2 = t0Var.c;
        t0Var.b.setStereoVolume(aVar2.g, aVar2.h);
        p0 p0Var2 = this.f10117a;
        p0Var2.d = p0Var2.h;
        return null;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a() {
        create();
        if (this.f10117a.d != this) {
            this.f10117a.a();
        }
    }
}
