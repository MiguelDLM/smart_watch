package com.baidu.navisdk.ugc.eventdetails.model;

import androidx.annotation.DrawableRes;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @DrawableRes
    public int f8067a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String[] k;
    public c.d l;

    public void a() {
        this.f8067a = 0;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f = null;
        c.d dVar = this.l;
        if (dVar != null) {
            dVar.a();
        }
    }

    public String toString() {
        return "BNFixedPanelDataModel{titleIconId=" + this.f8067a + ", titleIconUrl='" + this.b + "', eventType=" + this.c + ", title='" + this.d + "', time='" + this.e + "', realisticImg='" + this.f + "', isShowAvoidCongestionBtn=" + this.g + ", address='" + this.h + "', distance='" + this.i + "', congestionTime='" + this.j + "', detailLabels=" + Arrays.toString(this.k) + ", source=" + this.l + '}';
    }
}
