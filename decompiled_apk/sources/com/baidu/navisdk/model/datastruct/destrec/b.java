package com.baidu.navisdk.model.datastruct.destrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.baidu.entity.pb.ParkingInfo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b {

    @OOXIXo
    public static final a i = new a(null);
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;

    /* renamed from: a, reason: collision with root package name */
    private String f6916a = "";
    private String b = "";
    private ArrayList<h> h = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @x0XOIxOo
        @OOXIXo
        public final b a(@oOoXoXO ParkingInfo parkingInfo) {
            b bVar = new b();
            if (parkingInfo != null) {
                String stringUtf8 = parkingInfo.getUid().toStringUtf8();
                IIX0o.oO(stringUtf8, "it.uid.toStringUtf8()");
                bVar.f6916a = stringUtf8;
                String stringUtf82 = parkingInfo.getName().toStringUtf8();
                IIX0o.oO(stringUtf82, "it.name.toStringUtf8()");
                bVar.b = stringUtf82;
                bVar.c = parkingInfo.getParkTotal();
                bVar.d = parkingInfo.getParkLeft();
                bVar.e = parkingInfo.getStatus();
                bVar.f = parkingInfo.getSupportParkGuide();
                bVar.g = parkingInfo.getDynamic();
                bVar.h.clear();
                if (parkingInfo.getAreaCarportListCount() > 0) {
                    bVar.h.clear();
                    int areaCarportListCount = parkingInfo.getAreaCarportListCount();
                    for (int i = 0; i < areaCarportListCount; i++) {
                        bVar.h.add(h.e.a(parkingInfo.getAreaCarportList(i)));
                    }
                }
            }
            return bVar;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final b a(@oOoXoXO ParkingInfo parkingInfo) {
        return i.a(parkingInfo);
    }

    @OOXIXo
    public String toString() {
        return "DestParkingInfoData(uid='" + this.f6916a + "', name='" + this.b + "', parkTotal=" + this.c + ", parkLeft=" + this.d + ", parkStatus=" + this.e + ", supportParkGuide=" + this.f + ", dynamic=" + this.g + ", areaCarportList=" + this.h + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.f;
    }

    public final int b() {
        return this.e;
    }

    public final int a() {
        return this.d;
    }
}
