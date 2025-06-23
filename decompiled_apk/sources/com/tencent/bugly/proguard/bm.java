package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes13.dex */
public final class bm extends m implements Cloneable {
    static ArrayList<String> c;

    /* renamed from: a, reason: collision with root package name */
    public String f26598a = "";
    public ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26598a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26598a = kVar.b(0, true);
        if (c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) kVar.a((k) c, 1, false);
    }
}
