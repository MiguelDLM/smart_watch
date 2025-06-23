package com.baidu.tts;

import java.util.List;

/* loaded from: classes8.dex */
public class t implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f10168a;

    public t(u uVar) {
        this.f10168a = uVar;
    }

    @Override // com.baidu.tts.p
    public void a(x4 x4Var) {
    }

    @Override // com.baidu.tts.p
    public void onError(x4 x4Var) {
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeDataArrived(x4 x4Var) {
        u uVar = this.f10168a;
        if (uVar.b()) {
            if (x4Var == null) {
                x4Var = new x4();
            }
            x4Var.f10198a = o2.SYN_DATA;
            List<p> list = uVar.d;
            if (list != null) {
                for (p pVar : list) {
                    if (pVar != null) {
                        pVar.onSynthesizeDataArrived(x4Var);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeFinished(x4 x4Var) {
        this.f10168a.c(x4Var);
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeStart(x4 x4Var) {
    }
}
