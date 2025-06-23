package com.baidu.navisdk.framework.func;

import androidx.annotation.NonNull;
import com.baidu.navisdk.apicenter.c;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.context.business.a;
import o0oIxXOx.IXxxXO;

/* loaded from: classes7.dex */
public abstract class Func<C extends com.baidu.navisdk.context.business.a> extends BaseFunc implements c {
    protected final String g;
    protected final String h;

    @NonNull
    protected final C i;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f6808a = true;
    }

    public Func(C c) {
        super(c.g(), c.b());
        this.i = c;
        String o = o();
        this.h = o;
        this.g = c.h() + IXxxXO.f31153oxoX + o;
        c.a(o, this);
    }

    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        return null;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void create() {
        super.create();
        this.i.a(this.h, this);
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void destroy() {
        super.destroy();
        this.i.a(this.h);
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final String m() {
        return this.g;
    }

    @NonNull
    public C n() {
        return this.i;
    }

    public abstract String o();
}
