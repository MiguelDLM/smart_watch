package com.baidu.navisdk.ugc.dialog;

import android.app.Dialog;
import android.content.Context;

/* loaded from: classes8.dex */
public class f extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    boolean f8029a;
    boolean b;

    public f(Context context, int i) {
        super(context, i);
        this.f8029a = true;
        this.b = true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f8029a && this.b) {
            com.baidu.navisdk.asr.d.B().b(true);
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        boolean q = com.baidu.navisdk.asr.d.B().q();
        this.b = q;
        if (this.f8029a && q) {
            com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h != null && !h.x0()) {
                com.baidu.navisdk.framework.b.a();
            }
            com.baidu.navisdk.asr.d.B().b(false);
        }
        super.show();
    }
}
