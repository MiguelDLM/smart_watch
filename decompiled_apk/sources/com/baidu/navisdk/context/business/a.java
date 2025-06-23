package com.baidu.navisdk.context.business;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.apicenter.b;
import com.baidu.navisdk.apicenter.g;
import com.baidu.navisdk.context.c;
import com.baidu.navisdk.context.d;

/* loaded from: classes7.dex */
public class a extends d {
    private final Activity b;
    private final g c;
    private final com.baidu.navisdk.context.support.service.a d;
    protected final String e;

    public a(@NonNull Activity activity, String str) {
        super(c.a().a(activity));
        this.c = new b();
        this.d = new com.baidu.navisdk.context.support.service.b();
        this.b = activity;
        this.e = str;
    }

    public void a(String str, com.baidu.navisdk.apicenter.c cVar) {
        f().a(str, cVar);
    }

    @Override // com.baidu.navisdk.context.d
    public void d() {
        super.d();
        this.c.clear();
        this.d.clear();
    }

    public Activity e() {
        return this.b;
    }

    public g f() {
        return this.c;
    }

    public Application g() {
        return this.b.getApplication();
    }

    public String h() {
        return this.e;
    }

    public com.baidu.navisdk.context.support.service.a i() {
        return this.d;
    }

    public com.baidu.navisdk.apicenter.a j() {
        return com.baidu.navisdk.apicenter.a.a(f());
    }

    public void a(String str) {
        f().a(str);
    }

    @Nullable
    public <T> T a(@NonNull Class<T> cls) {
        return (T) i().getService(cls);
    }

    @Override // com.baidu.navisdk.context.d, com.baidu.navisdk.context.a
    public Context a() {
        Activity activity = this.b;
        if (activity == null) {
            return super.a();
        }
        return activity.getApplicationContext();
    }
}
