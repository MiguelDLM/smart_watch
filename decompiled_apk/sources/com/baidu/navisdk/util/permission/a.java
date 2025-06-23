package com.baidu.navisdk.util.permission;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o0;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final a f9352a = new a();

    private a() {
    }

    public final void a(@oOoXoXO Context context, @oOoXoXO o0.b bVar) {
        if (context == null || bVar == null) {
            return;
        }
        if (a(context)) {
            bVar.a(3004, true, null);
        } else {
            o0.b().a(3004, bVar);
        }
    }

    private final boolean a(Context context) {
        return n0.a(context, "android.permission.CAMERA");
    }
}
