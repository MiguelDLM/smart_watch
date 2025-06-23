package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.entity.pb.cloud_yellow_tips_t;
import com.baidu.entity.pb.yellow_tips_t;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class h {

    @OOXIXo
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f9468a;
    private HashMap<Integer, b> b;
    private ArrayList<b> c;
    private final LinkedHashMap<Integer, i> d;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: com.baidu.navisdk.yellowtipdata.model.data.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0520a<T> implements Comparator<b> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0520a f9469a = new C0520a();

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final int compare(b bVar, b bVar2) {
                return bVar.c() - bVar2.c();
            }
        }

        private a() {
        }

        @OOXIXo
        public final h a(@oOoXoXO String str, @oOoXoXO cloud_yellow_tips_t cloud_yellow_tips_tVar, @oOoXoXO cloud_yellow_tips_t cloud_yellow_tips_tVar2) {
            List<yellow_tips_t> cloudYellowTipsList;
            List<yellow_tips_t> cloudYellowTipsList2;
            h hVar = new h(null);
            hVar.f9468a = str;
            if (cloud_yellow_tips_tVar != null && (cloudYellowTipsList2 = cloud_yellow_tips_tVar.getCloudYellowTipsList()) != null) {
                for (yellow_tips_t it : cloudYellowTipsList2) {
                    IIX0o.oO(it, "it");
                    hVar.a(it.getTipsType()).a(it);
                }
            }
            if (cloud_yellow_tips_tVar2 != null && (cloudYellowTipsList = cloud_yellow_tips_tVar2.getCloudYellowTipsList()) != null) {
                for (yellow_tips_t it2 : cloudYellowTipsList) {
                    IIX0o.oO(it2, "it");
                    hVar.a(it2.getTipsType()).b(it2);
                }
            }
            o00.OO0x0xX(hVar.c, C0520a.f9469a);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e("YellowTipDataParse", "parseYellowRouteData --> routeMd5 = " + hVar.f9468a + ", onRouteYellowData = " + cloud_yellow_tips_tVar + ", outRouteYellowData = " + cloud_yellow_tips_tVar2);
            }
            for (b bVar : hVar.c) {
                i a2 = i.f.a(hVar.f9468a, bVar.a(), bVar.b());
                if (a2.a().size() > 0) {
                    hVar.d.put(Integer.valueOf(a2.d()), a2);
                }
            }
            return hVar;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private yellow_tips_t f9470a;

        @oOoXoXO
        private yellow_tips_t b;
        private final int c;

        public b(int i) {
            this.c = i;
        }

        @oOoXoXO
        public final yellow_tips_t a() {
            return this.f9470a;
        }

        @oOoXoXO
        public final yellow_tips_t b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final void a(@oOoXoXO yellow_tips_t yellow_tips_tVar) {
            this.f9470a = yellow_tips_tVar;
        }

        public final void b(@oOoXoXO yellow_tips_t yellow_tips_tVar) {
            this.b = yellow_tips_tVar;
        }
    }

    private h() {
        this.b = new HashMap<>();
        this.c = new ArrayList<>();
        this.d = new LinkedHashMap<>();
    }

    @OOXIXo
    public final ArrayList<d> d() {
        ArrayList<d> arrayList = new ArrayList<>();
        i iVar = this.d.get(0);
        if (iVar != null) {
            Iterator<T> it = iVar.a().iterator();
            while (it.hasNext()) {
                arrayList.addAll(((f) it.next()).e());
            }
        }
        return arrayList;
    }

    @OOXIXo
    public final ArrayList<i> b() {
        ArrayList<i> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, i> entry : this.d.entrySet()) {
            if (!entry.getValue().e()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    @OOXIXo
    public final ArrayList<d> c() {
        ArrayList<d> arrayList = new ArrayList<>();
        i iVar = this.d.get(10);
        if (iVar != null) {
            Iterator<T> it = iVar.a().iterator();
            while (it.hasNext()) {
                arrayList.addAll(((f) it.next()).e());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b a(int i) {
        b bVar = this.b.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(i);
        this.b.put(Integer.valueOf(i), bVar2);
        this.c.add(bVar2);
        return bVar2;
    }

    public /* synthetic */ h(IIXOooo iIXOooo) {
        this();
    }

    @OOXIXo
    public final ArrayList<d> a() {
        ArrayList<d> arrayList = new ArrayList<>();
        i iVar = this.d.get(11);
        if (iVar != null) {
            Iterator<T> it = iVar.a().iterator();
            while (it.hasNext()) {
                arrayList.addAll(((f) it.next()).e());
            }
        }
        return arrayList;
    }
}
