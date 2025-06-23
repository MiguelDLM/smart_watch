package com.baidu.navisdk.ui.routeguide.brule.matchpage;

import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.ui.routeguide.brule.matchpage.e;
import java.util.List;

/* loaded from: classes8.dex */
public class d implements n {

    /* renamed from: a, reason: collision with root package name */
    private final e f8519a;

    public d() {
        e.f fVar = new e.f();
        fVar.b(true);
        this.f8519a = fVar.a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public com.baidu.navisdk.behavrules.d a(List<String> list) {
        return this.f8519a.a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public String e() {
        return "10";
    }
}
