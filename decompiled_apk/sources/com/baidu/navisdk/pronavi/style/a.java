package com.baidu.navisdk.pronavi.style;

import OXOo.oOoXoXO;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, ? super d> f7811a;
    private List<Integer> b;

    /* renamed from: com.baidu.navisdk.pronavi.style.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0331a {
        private C0331a() {
        }

        public /* synthetic */ C0331a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0331a(null);
    }

    public a(@oOoXoXO List<Integer> list) {
        this.b = list;
    }

    public final void a(@oOoXoXO HashMap<String, ? super d> hashMap) {
        this.f7811a = hashMap;
    }

    public final void b(@oOoXoXO List<Integer> list) {
        this.b = list;
    }

    public final boolean a(@oOoXoXO List<Integer> list) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGChangNewStyleItem", "isSupportScenes: ");
        }
        if (list != null && list.isEmpty()) {
            return true;
        }
        List<Integer> list2 = this.b;
        if (list2 != null && list2.isEmpty()) {
            return true;
        }
        IIX0o.ooOOo0oXI(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            List<Integer> list3 = this.b;
            if (list3 != null && list3.contains(Integer.valueOf(intValue))) {
                return true;
            }
        }
        return false;
    }

    @oOoXoXO
    public final HashMap<String, ? super d> a() {
        return this.f7811a;
    }
}
