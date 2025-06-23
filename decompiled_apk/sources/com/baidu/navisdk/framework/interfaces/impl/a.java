package com.baidu.navisdk.framework.interfaces.impl;

import android.os.Bundle;
import com.baidu.navisdk.module.abtest.model.j;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.framework.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.abtest.b f6812a = new com.baidu.navisdk.module.abtest.b();

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void I() {
        this.f6812a.I();
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void a(JSONObject jSONObject) {
        this.f6812a.a(jSONObject);
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public Bundle e(int i) {
        return this.f6812a.e(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void j(int i) {
        this.f6812a.j(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public j g(int i) {
        return this.f6812a.g(i);
    }
}
