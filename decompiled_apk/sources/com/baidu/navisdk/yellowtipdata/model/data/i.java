package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class i {

    @OOXIXo
    public static final a f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private String f9471a;
    private int b;

    @oOoXoXO
    private String c;
    private boolean d;

    @OOXIXo
    private final ArrayList<f> e = new ArrayList<>();

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: com.baidu.navisdk.yellowtipdata.model.data.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0521a<T> implements Comparator<f> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0521a f9472a = new C0521a();

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final int compare(f fVar, f fVar2) {
                return fVar.a() - fVar2.a();
            }
        }

        private a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0165  */
        @OXOo.OOXIXo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.baidu.navisdk.yellowtipdata.model.data.i a(@OXOo.oOoXoXO java.lang.String r21, @OXOo.oOoXoXO com.baidu.entity.pb.yellow_tips_t r22, @OXOo.oOoXoXO com.baidu.entity.pb.yellow_tips_t r23) {
            /*
                Method dump skipped, instructions count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.yellowtipdata.model.data.i.a.a(java.lang.String, com.baidu.entity.pb.yellow_tips_t, com.baidu.entity.pb.yellow_tips_t):com.baidu.navisdk.yellowtipdata.model.data.i");
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(@oOoXoXO String str) {
        this.f9471a = str;
    }

    @oOoXoXO
    public final String c() {
        return this.f9471a;
    }

    public final int d() {
        return this.b;
    }

    public final boolean e() {
        return this.d;
    }

    public final void a(@oOoXoXO String str) {
        this.c = str;
    }

    @oOoXoXO
    public final String b() {
        return this.c;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    @OOXIXo
    public final ArrayList<f> a() {
        return this.e;
    }
}
