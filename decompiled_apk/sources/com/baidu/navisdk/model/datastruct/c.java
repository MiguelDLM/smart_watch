package com.baidu.navisdk.model.datastruct;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private RoutePlanNode f6904a;
    private RoutePlanNode b;
    private RoutePlanTime e;
    private String h;
    private String i;
    private Bundle j;
    private ArrayList<RoutePlanNode> c = new ArrayList<>();
    private ArrayList<RoutePlanNode> d = new ArrayList<>();
    private int f = 4;
    private int g = 0;

    public Bundle a() {
        return this.j;
    }

    public String toString() {
        return "BNRouteSearchParam{\n           mStartNode=" + this.f6904a + "\n           mEndNode=" + this.b + "\n           mApproachNodeList=" + this.c + "\n           mEndNodeList=" + this.d + "\n           mEntry=" + this.f + "\n           mPrefer=" + this.g + "\n           mCarPlate=" + this.h + "\n           mMrsl=" + this.i + "\n           mExtraData=" + this.j + "\n           }";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m83clone() {
        c cVar = new c();
        RoutePlanNode routePlanNode = this.f6904a;
        if (routePlanNode != null) {
            cVar.f6904a = routePlanNode.mo81clone();
        }
        RoutePlanNode routePlanNode2 = this.b;
        if (routePlanNode2 != null) {
            cVar.b = routePlanNode2.mo81clone();
        }
        if (this.b != null) {
            cVar.d = new ArrayList<>();
        }
        if (this.c != null) {
            ArrayList<RoutePlanNode> arrayList = new ArrayList<>();
            Iterator<RoutePlanNode> it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().mo81clone());
            }
            cVar.c = arrayList;
            cVar.d.addAll(arrayList);
        }
        RoutePlanNode routePlanNode3 = this.b;
        if (routePlanNode3 != null) {
            cVar.d.add(routePlanNode3);
        }
        RoutePlanTime routePlanTime = this.e;
        if (routePlanTime != null) {
            cVar.e = routePlanTime.m82clone();
        }
        cVar.f = this.f;
        cVar.g = this.g;
        if (!TextUtils.isEmpty(this.h)) {
            cVar.h = this.h;
        }
        if (!TextUtils.isEmpty(this.i)) {
            cVar.i = this.i;
        }
        Bundle bundle = this.j;
        if (bundle != null) {
            cVar.j = (Bundle) bundle.clone();
        }
        return cVar;
    }
}
