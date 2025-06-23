package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.framework.pref.a {

    @OOXIXo
    public static final a c = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        public final b a() {
            return C0213b.b.a();
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ar.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0213b {

        @OOXIXo
        public static final C0213b b = new C0213b();

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private static final b f6976a = new b(null);

        private C0213b() {
        }

        @OOXIXo
        public final b a() {
            return f6976a;
        }
    }

    private b() {
    }

    public final void a(boolean z) {
        b("is_showed_ar_declare", z);
    }

    @Override // com.baidu.navisdk.framework.pref.a
    @OOXIXo
    public String b() {
        return "navi_ar";
    }

    public final boolean c() {
        return a("is_showed_ar_declare", false);
    }

    public /* synthetic */ b(IIXOooo iIXOooo) {
        this();
    }
}
