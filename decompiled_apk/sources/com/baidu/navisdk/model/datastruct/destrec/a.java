package com.baidu.navisdk.model.datastruct.destrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.entity.pb.FirstParkingSpace;
import com.baidu.entity.pb.IdssPoint;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    @OOXIXo
    public static final C0211a e = new C0211a(null);

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final ArrayList<com.baidu.nplatform.comapi.basestruct.c> f6915a = new ArrayList<>();

    @OOXIXo
    private final ArrayList<GeoPoint> b = new ArrayList<>();

    @oOoXoXO
    private com.baidu.nplatform.comapi.basestruct.c c;

    @oOoXoXO
    private GeoPoint d;

    /* renamed from: com.baidu.navisdk.model.datastruct.destrec.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0211a {
        private C0211a() {
        }

        @oOoXoXO
        public final a a(@oOoXoXO FirstParkingSpace firstParkingSpace) {
            if (firstParkingSpace != null) {
                a aVar = new a();
                int linkPointCount = firstParkingSpace.getLinkPointCount();
                for (int i = 0; i < linkPointCount; i++) {
                    IdssPoint linkPoint = firstParkingSpace.getLinkPoint(i);
                    if (linkPoint != null) {
                        com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c(linkPoint.getX(), linkPoint.getY());
                        aVar.b().add(cVar);
                        aVar.a().add(o.a(cVar));
                    }
                }
                IdssPoint parkingSpacePt = firstParkingSpace.getParkingSpacePt();
                if (parkingSpacePt != null) {
                    com.baidu.nplatform.comapi.basestruct.c cVar2 = new com.baidu.nplatform.comapi.basestruct.c(parkingSpacePt.getX(), parkingSpacePt.getY());
                    aVar.a(cVar2);
                    aVar.a(o.a(cVar2));
                }
                return aVar;
            }
            return null;
        }

        public /* synthetic */ C0211a(IIXOooo iIXOooo) {
            this();
        }
    }

    @OOXIXo
    public final ArrayList<GeoPoint> a() {
        return this.b;
    }

    @OOXIXo
    public final ArrayList<com.baidu.nplatform.comapi.basestruct.c> b() {
        return this.f6915a;
    }

    @OOXIXo
    public String toString() {
        return "DestFirstParkingSpace(linkPointList=" + this.f6915a + ", linkGeoPointList=" + this.b + ", parkingSpacePoint=" + this.c + ", parkingSpaceGeoPoint=" + this.d + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a(@oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
        this.c = cVar;
    }

    public final void a(@oOoXoXO GeoPoint geoPoint) {
        this.d = geoPoint;
    }
}
