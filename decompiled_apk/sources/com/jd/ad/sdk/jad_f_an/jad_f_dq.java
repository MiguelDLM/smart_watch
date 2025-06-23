package com.jd.ad.sdk.jad_f_an;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes10.dex */
public class jad_f_dq implements View.OnTouchListener {
    public final /* synthetic */ View jad_f_an;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_bo;

    public jad_f_dq(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar, View view) {
        this.jad_f_bo = jad_f_anVar;
        this.jad_f_an = view;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADMediator.getInstance().getTouchService().onViewTouch(this.jad_f_an, motionEvent, this.jad_f_bo.jad_f_dq);
        return false;
    }
}
