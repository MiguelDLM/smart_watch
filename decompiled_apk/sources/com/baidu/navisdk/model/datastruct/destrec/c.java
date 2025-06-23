package com.baidu.navisdk.model.datastruct.destrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.entity.pb.DestDrivingRecInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c {

    @OOXIXo
    public static final a f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private boolean f6917a;

    @OOXIXo
    private final ArrayList<g> b = new ArrayList<>();

    @oOoXoXO
    private String c = "";

    @OOXIXo
    private final ArrayList<f> d = new ArrayList<>();

    @OOXIXo
    private final ArrayList<com.baidu.navisdk.model.datastruct.b> e = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @oOoXoXO
        public final c a(@oOoXoXO DestDrivingRecInfo destDrivingRecInfo) {
            boolean z;
            if (destDrivingRecInfo != null) {
                c cVar = new c();
                if (destDrivingRecInfo.getSceneType() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                cVar.a(z);
                int tabPoiInfoCount = destDrivingRecInfo.getTabPoiInfoCount();
                boolean z2 = false;
                for (int i = 0; i < tabPoiInfoCount; i++) {
                    g a2 = g.a(destDrivingRecInfo.getTabPoiInfo(i), i);
                    if (a2 != null) {
                        cVar.d().add(a2);
                        if (!z2) {
                            a2.a(true);
                            z2 = true;
                        }
                        cVar.b().addAll(a2.b());
                        cVar.a().addAll(a2.a());
                    }
                }
                cVar.a(destDrivingRecInfo.getRecParkingText().toStringUtf8());
                return cVar;
            }
            return null;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    public final void a(boolean z) {
        this.f6917a = z;
    }

    @OOXIXo
    public final ArrayList<f> b() {
        return this.d;
    }

    @oOoXoXO
    public final String c() {
        return this.c;
    }

    @OOXIXo
    public final ArrayList<g> d() {
        return this.b;
    }

    public final boolean e() {
        return this.f6917a;
    }

    public final void a(@oOoXoXO String str) {
        this.c = str;
    }

    @OOXIXo
    public final ArrayList<com.baidu.navisdk.model.datastruct.b> a() {
        return this.e;
    }
}
