package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes13.dex */
public final class bp extends m implements Cloneable {
    static ArrayList<bo> b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<bo> f26601a = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f26601a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new bo());
        }
        this.f26601a = (ArrayList) kVar.a((k) b, 0, true);
    }
}
