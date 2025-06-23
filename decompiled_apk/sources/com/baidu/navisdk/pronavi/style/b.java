package com.baidu.navisdk.pronavi.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XoX;

/* loaded from: classes7.dex */
public final class b implements com.baidu.navisdk.module.pronavi.abs.b, com.baidu.navisdk.pronavi.style.i.b {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f7812a = XIxXXX0x0.oIX0oI(C0332b.f7813a);
    private final X0IIOO b = XIxXXX0x0.oIX0oI(d.f7815a);
    private final X0IIOO c = XIxXXX0x0.oIX0oI(c.f7814a);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.style.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0332b extends Lambda implements oIX0oI<HashMap<String, com.baidu.navisdk.pronavi.style.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0332b f7813a = new C0332b();

        public C0332b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final HashMap<String, com.baidu.navisdk.pronavi.style.a> invoke() {
            return new HashMap<>(8);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7814a = new c();

        public c() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> invoke() {
            return new ConcurrentHashMap<>(8);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<HashMap<String, String>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7815a = new d();

        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final HashMap<String, String> invoke() {
            return new HashMap<>(8);
        }
    }

    static {
        new a(null);
    }

    public b() {
        c();
    }

    private final HashMap<String, com.baidu.navisdk.pronavi.style.a> d() {
        return (HashMap) this.f7812a.getValue();
    }

    private final ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> e() {
        return (ConcurrentHashMap) this.c.getValue();
    }

    private final HashMap<String, String> f() {
        return (HashMap) this.b.getValue();
    }

    private final void g() {
        g gVar = g.PRO_NAV;
        gVar.e("RGEnableChangeStyleController", "printAll mChangedStyleItemMap size: " + d().size());
        gVar.e("RGEnableChangeStyleController", "printAll mStyleItemMainSubKeyMap size: " + f().size());
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> entry : e().entrySet()) {
            arrayList.add(entry.getKey() + org.apache.commons.text.oIX0oI.f33048oxoX + entry.getValue().size());
        }
        g.PRO_NAV.e("RGEnableChangeStyleController", "printAll mNeedChangeStyleHelperMap size:" + e().size() + ',' + TokenParser.SP + arrayList);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "registerChangeStyleHelper: " + str);
        }
        a(str, aVar, true);
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void b(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "refreshItemStyle: " + str + ", " + aVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(str);
            }
        } else {
            if (aVar != null) {
                d(str, aVar);
                return;
            }
            HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = e().get(str);
            if (hashSet != null) {
                Iterator<T> it = hashSet.iterator();
                while (it.hasNext()) {
                    d(str, (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it.next()).get());
                }
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void c(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar) {
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> e;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterChangeStyleView: ");
            sb.append(str);
            sb.append(", {");
            sb.append(aVar != null ? aVar.a() : null);
            sb.append('}');
            gVar.e("RGEnableChangeStyleController", sb.toString());
        }
        if (TextUtils.isEmpty(str) || (e = e()) == null || e.isEmpty()) {
            return;
        }
        if (aVar == null) {
            ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> e2 = e();
            if (e2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            XoX.OOXIXo(e2).remove(str);
            return;
        }
        HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = e().get(str);
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

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        d().clear();
        f().clear();
        try {
            Iterator<Map.Entry<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>>> it = e().entrySet().iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = it.next().getValue().iterator();
                while (it2.hasNext()) {
                    com.baidu.navisdk.pronavi.style.i.a aVar = (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it2.next()).get();
                    if (aVar != null) {
                        aVar.onDestroy();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        e().clear();
        f.b.c();
    }

    private final void d(String str, com.baidu.navisdk.pronavi.style.i.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String c2 = aVar.c(str);
        com.baidu.navisdk.pronavi.style.a aVar2 = TextUtils.isEmpty(c2) ? d().get(str) : d().get(c2);
        if (aVar2 == null) {
            aVar.a(str, (HashMap<String, ? super com.baidu.navisdk.pronavi.style.d>) null);
            return;
        }
        if (aVar2.a(aVar.d())) {
            aVar.a(str, aVar2.a());
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "updateStyle " + str + ", " + aVar + " not support scenes");
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.style.i.a aVar, @OOXIXo String... keys) {
        IIX0o.x0xO0oo(keys, "keys");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "registerChangeStyleHelper subKey:" + keys);
        }
        if (aVar == null || keys.length == 0) {
            return;
        }
        for (String str : keys) {
            a(str, aVar, true);
        }
    }

    private final void a(String str, com.baidu.navisdk.pronavi.style.i.a aVar, boolean z) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "registerChangeStyleView: " + str + ", helperName: " + aVar.a());
        }
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> e = e();
        IIX0o.ooOOo0oXI(str);
        HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = e.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>(4, 1.0f);
            e().put(str, hashSet);
        } else {
            a(hashSet, aVar);
        }
        hashSet.add(new WeakReference<>(aVar));
        if (z) {
            d(str, aVar);
        }
    }

    private final String b(String str) {
        String str2 = f().get(str);
        return (str2 == null || str2.length() == 0) ? str : str2;
    }

    private final void c() {
        ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> a2;
        f fVar = f.b;
        if (fVar.b() || (a2 = fVar.a()) == null || a2.isEmpty()) {
            return;
        }
        e().putAll(a2);
        if (a2 != null) {
            a2.clear();
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void b() {
        Iterator<Map.Entry<String, com.baidu.navisdk.pronavi.style.a>> it = d().entrySet().iterator();
        while (it.hasNext()) {
            String b = b(it.next().getKey());
            HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = e().get(b);
            if (hashSet != null) {
                Iterator<T> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    com.baidu.navisdk.pronavi.style.i.a aVar = (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it2.next()).get();
                    if (aVar != null) {
                        aVar.b(b);
                    }
                }
            }
        }
        d().clear();
        f().clear();
    }

    private final void a(HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet, com.baidu.navisdk.pronavi.style.i.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "removeSameNameStyleHelper: " + aVar);
        }
        String a2 = aVar.a();
        Iterator<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> it = hashSet.iterator();
        IIX0o.oO(it, "styleHelperSet.iterator()");
        while (it.hasNext()) {
            com.baidu.navisdk.pronavi.style.i.a aVar2 = it.next().get();
            if (aVar2 == null || TextUtils.equals(a2, aVar2.a())) {
                it.remove();
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a(@oOoXoXO String str, @oOoXoXO HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> hashMap, @OOXIXo int... scenes) {
        IIX0o.x0xO0oo(scenes, "scenes");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "updateItemStyle: " + str + TokenParser.SP + hashMap + ", " + scenes);
        }
        a(str, hashMap, true, ArraysKt___ArraysKt.oXooI(scenes));
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> hashMap, boolean z, @OOXIXo int... scenes) {
        IIX0o.x0xO0oo(scenes, "scenes");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "updateItemStyle: " + str + (char) 65292 + str2 + " ->" + hashMap + ", " + z + ", " + scenes);
        }
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            f().put(str2, str);
        }
        a(str2, hashMap, z, ArraysKt___ArraysKt.oXooI(scenes));
    }

    private final void a(String str, HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> hashMap, boolean z, List<Integer> list) {
        String b;
        HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "updateItemStyle: " + str + " ->" + hashMap + ", " + z + ", " + list);
        }
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        HashMap<String, com.baidu.navisdk.pronavi.style.a> d2 = d();
        IIX0o.ooOOo0oXI(str);
        com.baidu.navisdk.pronavi.style.a aVar = d2.get(str);
        if (aVar == null) {
            aVar = new com.baidu.navisdk.pronavi.style.a(list);
            d().put(str, aVar);
        } else {
            aVar.b(list);
        }
        aVar.a(hashMap);
        if (!z || (hashSet = e().get((b = b(str)))) == null) {
            return;
        }
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            d(b, (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it.next()).get());
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a(@oOoXoXO String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGEnableChangeStyleController", "removeItemStyle: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, com.baidu.navisdk.pronavi.style.a> d2 = d();
        if (d2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
        if (XoX.OOXIXo(d2).remove(str) != null) {
            ConcurrentHashMap<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> e = e();
            IIX0o.ooOOo0oXI(str);
            HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>> hashSet = e.get(b(str));
            f().remove(str);
            if (hashSet != null) {
                Iterator<T> it = hashSet.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.pronavi.style.i.a aVar = (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it.next()).get();
                    if (aVar != null) {
                        aVar.b(str);
                    }
                }
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.style.i.b
    public void a() {
        for (Map.Entry<String, HashSet<WeakReference<com.baidu.navisdk.pronavi.style.i.a>>> entry : e().entrySet()) {
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.pronavi.style.i.a aVar = (com.baidu.navisdk.pronavi.style.i.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.b();
                    aVar.c();
                    d(entry.getKey(), aVar);
                }
            }
        }
        if (g.PRO_NAV.d()) {
            g();
        }
    }
}
