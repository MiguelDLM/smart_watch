package com.baidu.navisdk.logicframe;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.logicframe.b;
import com.baidu.navisdk.util.common.d0;
import com.baidu.navisdk.util.common.g;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class a<C extends b> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6895a = new Object();
    private final LinkedHashMap<String, Func<C>> b = new LinkedHashMap<>();

    /* renamed from: com.baidu.navisdk.logicframe.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0206a {
        private C0206a() {
        }

        public /* synthetic */ C0206a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0206a(null);
    }

    public final <T extends Func<C>> void a(@OOXIXo String key, @OOXIXo T func) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(func, "func");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("FuncCenter", "registerFunc --> key = " + key + ", func = " + func);
        }
        d0.a(key, "Can not register null key to FuncCenter");
        d0.a(func, "Can not register null func to FuncCenter");
        synchronized (this.f6895a) {
            this.b.put(key, func);
        }
    }

    @OOXIXo
    public final LinkedHashMap<String, Func<C>> b() {
        LinkedHashMap<String, Func<C>> linkedHashMap;
        synchronized (this.f6895a) {
            linkedHashMap = new LinkedHashMap<>(this.b);
        }
        return linkedHashMap;
    }

    @oOoXoXO
    public final <T extends Func<C>> T a(@OOXIXo String key) {
        Func<C> func;
        IIX0o.x0xO0oo(key, "key");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("FuncCenter", "getFunc --> key = " + key);
        }
        synchronized (this.f6895a) {
            func = this.b.get(key);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        if (func == null) {
            return null;
        }
        return func;
    }

    public final void a() {
        synchronized (this.f6895a) {
            this.b.clear();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }
}
