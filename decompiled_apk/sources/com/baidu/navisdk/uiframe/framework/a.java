package com.baidu.navisdk.uiframe.framework;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.navisdk.context.a;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.context.business.a {
    private final com.baidu.navisdk.framework.data.a f;
    private final a.C0188a g;

    public a(@NonNull Activity activity, String str, @NonNull com.baidu.navisdk.framework.data.a aVar) {
        super(activity, str);
        this.f = aVar;
        this.g = new a.C0188a(activity.getApplicationContext());
    }

    @Override // com.baidu.navisdk.context.business.a, com.baidu.navisdk.context.d
    public void d() {
        super.d();
        this.f.a();
    }

    @NonNull
    public a.C0188a k() {
        return this.g;
    }
}
