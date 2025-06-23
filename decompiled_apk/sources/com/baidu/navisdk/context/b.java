package com.baidu.navisdk.context;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.b0;
import com.baidu.navisdk.util.common.d0;

/* loaded from: classes7.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6760a;
    private b0 b;

    public b(Context context, b0 b0Var, com.baidu.navisdk.context.support.imageloader.b bVar, com.baidu.navisdk.context.support.taskscheduler.b bVar2, com.baidu.navisdk.context.support.logger.b bVar3) {
        this.f6760a = context.getApplicationContext();
        this.b = b0Var;
    }

    @Override // com.baidu.navisdk.context.a
    public Context a() {
        return this.f6760a;
    }

    @Override // com.baidu.navisdk.context.a
    public b0 b() {
        if (this.b == null) {
            this.b = new b0(a());
        }
        return this.b;
    }

    @Override // com.baidu.navisdk.context.a
    public void a(@NonNull String... strArr) {
        b0 b0Var = this.b;
        if (b0Var != null) {
            b0Var.a(strArr);
        }
    }

    public static b a(@NonNull Context context, b0 b0Var, com.baidu.navisdk.context.support.imageloader.b bVar, com.baidu.navisdk.context.support.taskscheduler.b bVar2, com.baidu.navisdk.context.support.logger.b bVar3) {
        d0.a(context, "Context could not be null");
        return new b(context, b0Var, bVar, bVar2, bVar3);
    }

    @Override // com.baidu.navisdk.context.a
    public void b(@NonNull String... strArr) {
        b0 b0Var = this.b;
        if (b0Var != null) {
            b0Var.b(strArr);
        }
    }
}
