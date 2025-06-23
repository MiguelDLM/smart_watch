package com.baidu.navisdk.pageframe.store;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class b implements com.baidu.navisdk.pageframe.store.i.a<com.baidu.navisdk.pageframe.store.data.a>, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, com.baidu.navisdk.pageframe.store.data.a> f7630a = new HashMap<>();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public final void b(@OOXIXo Class<?> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        if (com.baidu.navisdk.pageframe.store.data.b.class.isAssignableFrom(modelClass)) {
            return;
        }
        throw new IllegalArgumentException(modelClass.getCanonicalName() + " must RGOriginalBaseVM subclass");
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        synchronized (this.f7630a) {
            this.f7630a.clear();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @Override // com.baidu.navisdk.pageframe.store.i.a
    public <T extends com.baidu.navisdk.pageframe.store.data.a> T a(@OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        return (T) a("RGBaseVMStore.DefaultKeyPre:" + modelClass.getCanonicalName(), modelClass);
    }

    public <T extends com.baidu.navisdk.pageframe.store.data.a> T a(@NonNull @OOXIXo String key, @OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        T t = (T) a(key, modelClass, true);
        IIX0o.ooOOo0oXI(t);
        return t;
    }

    @oOoXoXO
    public <T extends com.baidu.navisdk.pageframe.store.data.a> T a(@NonNull @OOXIXo String key, @OOXIXo Class<T> modelClass, boolean z) {
        T t;
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        b(modelClass);
        T t2 = (T) this.f7630a.get(key);
        if (t2 != null && modelClass.isInstance(t2)) {
            return t2;
        }
        synchronized (this.f7630a) {
            t = (T) this.f7630a.get(key);
            if (t == null && z) {
                try {
                    T newInstance = modelClass.newInstance();
                    try {
                        HashMap<String, com.baidu.navisdk.pageframe.store.data.a> hashMap = this.f7630a;
                        IIX0o.ooOOo0oXI(newInstance);
                        hashMap.put(key, newInstance);
                        t = newInstance;
                    } catch (Exception e) {
                        e = e;
                        t = newInstance;
                        g gVar = g.PRO_NAV;
                        if (gVar.d()) {
                            e.printStackTrace();
                            gVar.a("get: " + key, e);
                        }
                        return t;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
        return t;
    }
}
