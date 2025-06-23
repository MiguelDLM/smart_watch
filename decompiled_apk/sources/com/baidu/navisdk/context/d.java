package com.baidu.navisdk.context;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.b0;

/* loaded from: classes7.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    protected a f6762a;

    public d(a aVar) {
        this.f6762a = aVar;
    }

    @Override // com.baidu.navisdk.context.a
    public Context a() {
        a aVar = this.f6762a;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.baidu.navisdk.context.a
    public b0 b() {
        a aVar = this.f6762a;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public void d() {
        this.f6762a = null;
    }

    @Override // com.baidu.navisdk.context.a
    public void a(@NonNull String... strArr) {
        a aVar = this.f6762a;
        if (aVar == null) {
            return;
        }
        aVar.a(strArr);
    }

    @Override // com.baidu.navisdk.context.a
    public void b(@NonNull String... strArr) {
        a aVar = this.f6762a;
        if (aVar == null) {
            return;
        }
        aVar.b(strArr);
    }
}
