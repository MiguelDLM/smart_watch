package com.baidu.tts;

/* loaded from: classes8.dex */
public class o0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f10142a;

    public o0(p0 p0Var) {
        this.f10142a = p0Var;
    }

    @Override // com.baidu.tts.h0
    public void onPlayFinished(x4 x4Var) {
        h0 h0Var;
        p0 p0Var = this.f10142a;
        if (p0Var.b() && (h0Var = p0Var.c) != null) {
            h0Var.onPlayFinished(x4Var);
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayLipData(x4 x4Var) {
        h0 h0Var;
        p0 p0Var = this.f10142a;
        if (p0Var.b() && (h0Var = p0Var.c) != null) {
            h0Var.onPlayLipData(x4Var);
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayProgressUpdate(x4 x4Var) {
        h0 h0Var;
        p0 p0Var = this.f10142a;
        if (p0Var.b() && (h0Var = p0Var.c) != null) {
            h0Var.onPlayProgressUpdate(x4Var);
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayStart(x4 x4Var) {
        h0 h0Var;
        p0 p0Var = this.f10142a;
        if (p0Var.b() && (h0Var = p0Var.c) != null) {
            h0Var.onPlayStart(x4Var);
        }
    }
}
