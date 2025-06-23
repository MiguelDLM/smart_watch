package com.baidu.navisdk.pageframe.store;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.NonNull;
import com.baidu.navisdk.uiframe.framework.a;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public abstract class a<C extends com.baidu.navisdk.uiframe.framework.a> implements com.baidu.navisdk.pageframe.store.i.b<C>, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, com.baidu.navisdk.pageframe.store.data.c<C>> f7629a = new HashMap<>();

    @oOoXoXO
    private C b;

    /* renamed from: com.baidu.navisdk.pageframe.store.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0305a {
        private C0305a() {
        }

        public /* synthetic */ C0305a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0305a(null);
    }

    public abstract void b(@OOXIXo Class<?> cls);

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        Iterator<com.baidu.navisdk.pageframe.store.data.c<C>> it = this.f7629a.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        synchronized (this.f7629a) {
            this.f7629a.clear();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        this.b = null;
    }

    @Override // com.baidu.navisdk.pageframe.store.i.a
    public <T extends com.baidu.navisdk.pageframe.store.data.c<C>> T a(@OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        return (T) a("RGBaseVMStore.DefaultKeyPre:" + modelClass.getCanonicalName(), modelClass);
    }

    public <T extends com.baidu.navisdk.pageframe.store.data.c<C>> T a(@NonNull @OOXIXo String key, @OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        T t = (T) a(key, modelClass, true);
        IIX0o.ooOOo0oXI(t);
        return t;
    }

    @oOoXoXO
    public <T extends com.baidu.navisdk.pageframe.store.data.c<C>> T a(@NonNull @OOXIXo String key, @OOXIXo Class<T> modelClass, boolean z) {
        com.baidu.navisdk.pageframe.store.data.c<C> cVar;
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        b(modelClass);
        com.baidu.navisdk.pageframe.store.data.c<C> cVar2 = this.f7629a.get(key);
        if (cVar2 != null && modelClass.isInstance(cVar2)) {
            return cVar2;
        }
        synchronized (this.f7629a) {
            try {
                cVar = this.f7629a.get(key);
                if (cVar == null && z) {
                    try {
                        T newInstance = modelClass.newInstance();
                        if (newInstance != null) {
                            try {
                                newInstance.a(this.b);
                            } catch (Exception e) {
                                e = e;
                                cVar = newInstance;
                                g gVar = g.PRO_NAV;
                                if (gVar.d()) {
                                    e.printStackTrace();
                                    gVar.a("get: " + key, e);
                                }
                                return cVar;
                            }
                        }
                        HashMap<String, com.baidu.navisdk.pageframe.store.data.c<C>> hashMap = this.f7629a;
                        IIX0o.ooOOo0oXI(newInstance);
                        hashMap.put(key, newInstance);
                        cVar = newInstance;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.baidu.navisdk.pageframe.store.i.b
    public void a(@oOoXoXO C c) {
        this.b = c;
    }
}
