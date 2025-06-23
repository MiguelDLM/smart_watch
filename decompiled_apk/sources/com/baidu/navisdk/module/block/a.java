package com.baidu.navisdk.module.block;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class a {
    public static ConcurrentHashMap<String, Long> d = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public AtomicInteger f7040a = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    public AtomicInteger c = new AtomicInteger(0);

    /* renamed from: com.baidu.navisdk.module.block.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0225a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7041a = new a();
    }

    public static a b() {
        return C0225a.f7041a;
    }

    public boolean a() {
        if (!com.baidu.navisdk.module.cloudconfig.a.b().b("is_open_perform_monitor", false) || !com.baidu.navisdk.module.cloudconfig.a.b().b("is_open_block_monitor", false)) {
            return false;
        }
        return true;
    }
}
