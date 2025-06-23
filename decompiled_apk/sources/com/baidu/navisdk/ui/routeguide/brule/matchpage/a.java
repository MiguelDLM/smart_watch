package com.baidu.navisdk.ui.routeguide.brule.matchpage;

import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.ui.routeguide.brule.matchpage.e;
import java.util.List;

/* loaded from: classes8.dex */
public class a implements n {

    /* renamed from: a, reason: collision with root package name */
    private final e f8516a;

    public a() {
        e.f fVar = new e.f();
        fVar.a(true);
        fVar.b(true);
        fVar.c(true);
        this.f8516a = fVar.a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public com.baidu.navisdk.behavrules.d a(List<String> list) {
        return this.f8516a.a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public String e() {
        return "2";
    }
}
