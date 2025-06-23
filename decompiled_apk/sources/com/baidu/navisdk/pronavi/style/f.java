package com.baidu.navisdk.pronavi.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> f7829a;

    @OOXIXo
    public static final f b = new f();

    private f() {
    }

    private final void c(String str, com.baidu.navisdk.pronavi.style.i.a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            if (aVar != null) {
                aVar.b(str);
                return;
            }
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRegisterHelperWrapper", "addHelperToCacheMap: " + str + ", helperName: " + aVar.a());
        }
        if (f7829a == null) {
            f7829a = new ConcurrentHashMap<>(8, 1.0f);
        }
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap = f7829a;
        IIX0o.ooOOo0oXI(concurrentHashMap);
        IIX0o.ooOOo0oXI(str);
        HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = concurrentHashMap.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>(4, 1.0f);
            ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap2 = f7829a;
            IIX0o.ooOOo0oXI(concurrentHashMap2);
            concurrentHashMap2.put(str, hashSet);
        } else {
            a(hashSet, aVar);
        }
        hashSet.add(new WeakReference<>(aVar));
        aVar.b(str);
    }

    public final void a(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        a((com.baidu.navisdk.pronavi.style.i.b) null, str, aVar);
    }

    public final void b(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.navisdk.pronavi.style.i.b g = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g != null) {
            g.c(str, aVar);
        }
        if (aVar == null) {
            ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap = f7829a;
            if (concurrentHashMap != null) {
                return;
            }
            return;
        }
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap2 = f7829a;
        if (concurrentHashMap2 != null) {
            IIX0o.ooOOo0oXI(concurrentHashMap2);
            if (concurrentHashMap2.isEmpty()) {
                return;
            }
            ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap3 = f7829a;
            IIX0o.ooOOo0oXI(concurrentHashMap3);
            HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = concurrentHashMap3.get(str);
            if (hashSet == null || hashSet.isEmpty()) {
                return;
            }
            Iterator<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> it = hashSet.iterator();
            IIX0o.oO(it, "helperHashSet.iterator()");
            while (it.hasNext()) {
                if (IIX0o.Oxx0IOOO(it.next().get(), aVar)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public final void d() {
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap = f7829a;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> value = it.next().getValue();
                if (value != null) {
                    Iterator<T> it2 = value.iterator();
                    while (it2.hasNext()) {
                        com.baidu.navisdk.pronavi.style.i.a aVar = (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it2.next()).get();
                        if (aVar != null) {
                            aVar.b();
                            aVar.c();
                        }
                    }
                }
            }
        }
    }

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.style.i.b bVar, @oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRegisterHelperWrapper", "registerChangeStyleHelper: " + str);
        }
        if (bVar == null) {
            bVar = com.baidu.navisdk.ui.routeguide.utils.b.g();
        }
        if (bVar != null) {
            bVar.a(str, aVar);
        } else {
            c(str, aVar);
        }
    }

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar, @OOXIXo String... keys) {
        IIX0o.x0xO0oo(keys, "keys");
        a((com.baidu.navisdk.pronavi.style.i.b) null, aVar, (String[]) Arrays.copyOf(keys, keys.length));
    }

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.style.i.b bVar, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar, @OOXIXo String... keys) {
        IIX0o.x0xO0oo(keys, "keys");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRegisterHelperWrapper", "registerChangeStyleHelper subKey:" + keys);
        }
        if (aVar == null || keys.length == 0) {
            return;
        }
        if (bVar == null) {
            bVar = com.baidu.navisdk.ui.routeguide.utils.b.g();
        }
        if (bVar != null) {
            bVar.a(aVar, (String[]) Arrays.copyOf(keys, keys.length));
            return;
        }
        for (String str : keys) {
            b.c(str, aVar);
        }
    }

    public final boolean b() {
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap = f7829a;
        return concurrentHashMap != null && concurrentHashMap.isEmpty();
    }

    public final void c() {
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> concurrentHashMap = f7829a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    private final void a(HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet, com.baidu.navisdk.pronavi.style.i.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRegisterHelperWrapper", "removeSameNameStyleHelper: " + aVar);
        }
        String a2 = aVar.a();
        Iterator<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> it = hashSet.iterator();
        IIX0o.oO(it, "styleHelperSet.iterator()");
        while (it.hasNext()) {
            com.baidu.navisdk.pronavi.style.i.a aVar2 = it.next().get();
            if (TextUtils.equals(a2, aVar2 != null ? aVar2.a() : null)) {
                it.remove();
            }
        }
    }

    @oOoXoXO
    public final ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> a() {
        return f7829a;
    }
}
