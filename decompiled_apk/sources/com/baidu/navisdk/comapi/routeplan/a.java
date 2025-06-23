package com.baidu.navisdk.comapi.routeplan;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.LruCache;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<String, String> f6717a;

    @OOXIXo
    public static final C0182a c = new C0182a(null);

    @OOXIXo
    private static final a b = b.b.a();

    /* renamed from: com.baidu.navisdk.comapi.routeplan.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0182a {
        private C0182a() {
        }

        @OOXIXo
        public final a a() {
            return a.b;
        }

        public /* synthetic */ C0182a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        @OOXIXo
        public static final b b = new b();

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private static final a f6718a = new a(null);

        private b() {
        }

        @OOXIXo
        public final a a() {
            return f6718a;
        }
    }

    private a() {
        this.f6717a = new LruCache<>(20);
    }

    public final void b(@oOoXoXO RoutePlanNode routePlanNode) {
        String str;
        if (routePlanNode != null && routePlanNode.mIconType > 0 && (str = routePlanNode.mUID) != null && str.length() != 0) {
            LruCache<String, String> lruCache = this.f6717a;
            String str2 = routePlanNode.mUID;
            String str3 = routePlanNode.mName;
            if (str3 == null) {
                str3 = "";
            }
            lruCache.put(str2, str3);
        }
    }

    public final boolean a(@oOoXoXO RoutePlanNode routePlanNode) {
        String str;
        return (routePlanNode == null || (str = routePlanNode.mUID) == null || str.length() == 0 || this.f6717a.get(routePlanNode.mUID) == null) ? false : true;
    }

    public /* synthetic */ a(IIXOooo iIXOooo) {
        this();
    }
}
