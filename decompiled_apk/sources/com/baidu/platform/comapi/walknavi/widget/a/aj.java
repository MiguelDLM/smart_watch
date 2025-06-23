package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aj implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9853a;

    public aj(z zVar) {
        this.f9853a = zVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f9853a.h();
        }
        return true;
    }
}
