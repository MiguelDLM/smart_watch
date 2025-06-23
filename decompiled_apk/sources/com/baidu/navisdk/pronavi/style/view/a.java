package com.baidu.navisdk.pronavi.style.view;

import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a extends View {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private View f7830a;

    @oOoXoXO
    private ImageView b;

    @oOoXoXO
    private TextView c;

    @oOoXoXO
    private TextView d;

    @oOoXoXO
    private HashMap<String, View> e;

    @oOoXoXO
    private HashMap<String, TextView> f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a() {
        /*
            r2 = this;
            com.baidu.navisdk.framework.a r0 = com.baidu.navisdk.framework.a.c()
            java.lang.String r1 = "BNContextManager.getInstance()"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            android.content.Context r0 = r0.a()
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.style.view.a.<init>():void");
    }

    public final void a(@oOoXoXO String str, @oOoXoXO View view) {
        if (TextUtils.isEmpty(str) || view == null) {
            return;
        }
        if (this.e == null) {
            this.e = new HashMap<>(4, 1.0f);
        }
        HashMap<String, View> hashMap = this.e;
        IIX0o.ooOOo0oXI(hashMap);
        IIX0o.ooOOo0oXI(str);
        hashMap.put(str, view);
    }

    @oOoXoXO
    public final View getBgView() {
        return this.f7830a;
    }

    @oOoXoXO
    public final HashMap<String, View> getBgViewMap() {
        return this.e;
    }

    @oOoXoXO
    public final TextView getColorTextView() {
        return this.c;
    }

    @oOoXoXO
    public final ImageView getImageView() {
        return this.b;
    }

    @oOoXoXO
    public final TextView getStrTextView() {
        return this.d;
    }

    @oOoXoXO
    public final HashMap<String, TextView> getTextColorViewMap() {
        return this.f;
    }

    public final void setBgView(@oOoXoXO View view) {
        this.f7830a = view;
    }

    public final void setBgViewMap(@oOoXoXO HashMap<String, View> hashMap) {
        this.e = hashMap;
    }

    public final void setColorTextView(@oOoXoXO TextView textView) {
        this.c = textView;
    }

    public final void setImageView(@oOoXoXO ImageView imageView) {
        this.b = imageView;
    }

    public final void setStrTextView(@oOoXoXO TextView textView) {
        this.d = textView;
    }

    public final void setTextColorViewMap(@oOoXoXO HashMap<String, TextView> hashMap) {
        this.f = hashMap;
    }

    public final void a(@oOoXoXO String str, @oOoXoXO TextView textView) {
        if (TextUtils.isEmpty(str) || textView == null) {
            return;
        }
        if (this.f == null) {
            this.f = new HashMap<>(4, 1.0f);
        }
        HashMap<String, TextView> hashMap = this.f;
        IIX0o.ooOOo0oXI(hashMap);
        IIX0o.ooOOo0oXI(str);
        hashMap.put(str, textView);
    }
}
