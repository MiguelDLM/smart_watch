package com.baidu.navisdk.ui.roadcondition;

import com.baidu.navisdk.module.pronavi.model.c;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a f8411a;
    public c b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g = false;

    public boolean a() {
        c cVar = this.b;
        return cVar != null && cVar.c();
    }

    public String toString() {
        return "BNRoadConditionShowLabelModel{labelViewItem=" + this.f8411a + ", jamModel=" + this.b + ", normalMarginBottom=" + this.c + ", normalMarginRight=" + this.d + ", bigMarginBottom=" + this.e + ", bigMarginRight=" + this.f + ", isBigLabel=" + this.g + '}';
    }

    public void a(c cVar) {
        c cVar2 = new c();
        this.b = cVar2;
        cVar2.a(cVar);
    }
}
