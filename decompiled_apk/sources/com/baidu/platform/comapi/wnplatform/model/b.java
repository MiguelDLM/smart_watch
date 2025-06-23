package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    private e f9935a;
    private d b;

    public e a() {
        if (this.f9935a == null) {
            this.f9935a = new e();
        }
        return this.f9935a;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f9935a = null;
        this.b = null;
    }

    public void a(Bundle bundle, int i) {
        if (bundle == null) {
            return;
        }
        a().a(bundle, i);
    }

    public boolean a(com.baidu.platform.comapi.wnplatform.e.a aVar) {
        if (aVar == null) {
            return false;
        }
        return a().a(aVar);
    }
}
