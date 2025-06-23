package com.baidu.tts;

/* loaded from: classes8.dex */
public class e implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f10077a;

    public e(f fVar) {
        this.f10077a = fVar;
    }

    @Override // com.baidu.tts.p
    public void a(x4 x4Var) {
    }

    @Override // com.baidu.tts.p
    public void onError(x4 x4Var) {
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeDataArrived(x4 x4Var) {
        if (f.a(this.f10077a, x4Var)) {
            this.f10077a.b.a(x4Var);
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeFinished(x4 x4Var) {
        if (f.a(this.f10077a, x4Var)) {
            this.f10077a.b.a(x4Var);
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeStart(x4 x4Var) {
        if (f.a(this.f10077a, x4Var)) {
            this.f10077a.b.a(x4Var);
        }
    }
}
