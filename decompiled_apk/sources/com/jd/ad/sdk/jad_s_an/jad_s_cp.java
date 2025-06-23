package com.jd.ad.sdk.jad_s_an;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes10.dex */
public class jad_s_cp implements View.OnTouchListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_bo jad_s_an;

    public jad_s_cp(com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar) {
        this.jad_s_an = jad_s_boVar;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, this.jad_s_an.jad_s_dq);
        return false;
    }
}
