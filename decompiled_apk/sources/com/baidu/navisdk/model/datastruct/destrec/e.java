package com.baidu.navisdk.model.datastruct.destrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.entity.pb.RecParkingSpace;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.protobuf.micro.ByteStringMicro;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class e {

    @OOXIXo
    public static final a g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private String f6919a;

    @oOoXoXO
    private String b;

    @oOoXoXO
    private String c;

    @oOoXoXO
    private com.baidu.nplatform.comapi.basestruct.c d;

    @oOoXoXO
    private GeoPoint e;

    @oOoXoXO
    private String f;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @oOoXoXO
        public final e a(@oOoXoXO RecParkingSpace recParkingSpace, @oOoXoXO String str) {
            String str2;
            String str3;
            String str4 = null;
            if (recParkingSpace == null) {
                return null;
            }
            e eVar = new e();
            ByteStringMicro name = recParkingSpace.getName();
            if (name != null) {
                str2 = name.toStringUtf8();
            } else {
                str2 = null;
            }
            eVar.b(str2);
            ByteStringMicro uid = recParkingSpace.getUid();
            if (uid != null) {
                str3 = uid.toStringUtf8();
            } else {
                str3 = null;
            }
            eVar.d(str3);
            ByteStringMicro bid = recParkingSpace.getBid();
            if (bid != null) {
                str4 = bid.toStringUtf8();
            }
            eVar.a(str4);
            eVar.a(new com.baidu.nplatform.comapi.basestruct.c(recParkingSpace.getX(), recParkingSpace.getY()));
            eVar.a(o.a(eVar.e()));
            eVar.c(str);
            return eVar;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    @oOoXoXO
    public final String a() {
        return this.c;
    }

    public final void b(@oOoXoXO String str) {
        this.f6919a = str;
    }

    @oOoXoXO
    public final String c() {
        return this.f6919a;
    }

    public final void d(@oOoXoXO String str) {
        this.b = str;
    }

    @oOoXoXO
    public final com.baidu.nplatform.comapi.basestruct.c e() {
        return this.d;
    }

    @oOoXoXO
    public final String f() {
        return this.b;
    }

    @OOXIXo
    public String toString() {
        return "DestRecParkingSpace(name=" + this.f6919a + ", uid=" + this.b + ", bid=" + this.c + ", point=" + this.d + ", geoPoint=" + this.e + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a(@oOoXoXO String str) {
        this.c = str;
    }

    @oOoXoXO
    public final GeoPoint b() {
        return this.e;
    }

    public final void c(@oOoXoXO String str) {
        this.f = str;
    }

    @oOoXoXO
    public final String d() {
        return this.f;
    }

    public final void a(@oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
        this.d = cVar;
    }

    public final void a(@oOoXoXO GeoPoint geoPoint) {
        this.e = geoPoint;
    }
}
