package com.baidu.navisdk.b4nav.data.panorama;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.c;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final GeoPoint f6567a;

    @OOXIXo
    private final String b;
    private final int c;

    @OOXIXo
    private final String d;

    @OOXIXo
    private final c e;

    /* renamed from: com.baidu.navisdk.b4nav.data.panorama.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0170a {
        private C0170a() {
        }

        public /* synthetic */ C0170a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0170a(null);
    }

    @OOXIXo
    public final String a() {
        return this.d;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (IIX0o.Oxx0IOOO(this.b, aVar.b) && this.c == aVar.c && IIX0o.Oxx0IOOO(this.d, aVar.d) && IIX0o.Oxx0IOOO(this.e, aVar.e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.b.hashCode() * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "PanoramaInfo(imgUrl='" + this.b + "', imgType=" + this.c + ", jumpUrl='" + this.d + "', point=" + this.e + ", geoPoint=" + this.f6567a + HexStringBuilder.COMMENT_END_CHAR;
    }
}
