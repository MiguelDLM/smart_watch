package com.baidu.navisdk.context;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.b0;

/* loaded from: classes7.dex */
public class c {
    private static volatile c b;

    /* renamed from: a, reason: collision with root package name */
    private volatile a f6761a;

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public a a(@NonNull Context context) {
        if (this.f6761a == null) {
            synchronized (c.class) {
                try {
                    if (this.f6761a == null) {
                        this.f6761a = b.a(context, new b0(context), new com.baidu.navisdk.context.support.imageloader.a(context.getApplicationContext()), new com.baidu.navisdk.context.support.taskscheduler.a(), new com.baidu.navisdk.context.support.logger.a());
                    }
                } finally {
                }
            }
        }
        return this.f6761a;
    }
}
