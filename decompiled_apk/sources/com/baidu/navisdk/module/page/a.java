package com.baidu.navisdk.module.page;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class a {
    private static final String c = "a";
    private static a d;

    /* renamed from: a, reason: collision with root package name */
    private int f7374a = 0;
    private b b = null;

    private a() {
    }

    public static a b() {
        if (d == null) {
            synchronized (a.class) {
                d = new a();
            }
        }
        return d;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public int a() {
        return this.f7374a;
    }

    public boolean a(int i, Bundle bundle, Object... objArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(c, "jumpTo: cb=" + this.b + "pt=" + i + ", pp=" + bundle);
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.a(i, bundle, objArr);
        }
        return false;
    }
}
