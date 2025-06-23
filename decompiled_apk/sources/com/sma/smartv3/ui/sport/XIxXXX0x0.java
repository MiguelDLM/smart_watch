package com.sma.smartv3.ui.sport;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.HashMap;

/* loaded from: classes12.dex */
public final class XIxXXX0x0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public HashMap<SportDataType, Integer> f23890oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public XIxXXX0x0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XIxXXX0x0 I0Io(XIxXXX0x0 xIxXXX0x0, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = xIxXXX0x0.f23890oIX0oI;
        }
        return xIxXXX0x0.II0xO0(hashMap);
    }

    @OXOo.OOXIXo
    public final XIxXXX0x0 II0xO0(@OXOo.OOXIXo HashMap<SportDataType, Integer> order) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(order, "order");
        return new XIxXXX0x0(order);
    }

    public final void X0o0xo(@OXOo.OOXIXo HashMap<SportDataType, Integer> hashMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hashMap, "<set-?>");
        this.f23890oIX0oI = hashMap;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof XIxXXX0x0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23890oIX0oI, ((XIxXXX0x0) obj).f23890oIX0oI);
    }

    public int hashCode() {
        return this.f23890oIX0oI.hashCode();
    }

    @OXOo.OOXIXo
    public final HashMap<SportDataType, Integer> oIX0oI() {
        return this.f23890oIX0oI;
    }

    @OXOo.OOXIXo
    public final HashMap<SportDataType, Integer> oxoX() {
        return this.f23890oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SportDataOrder(order=" + this.f23890oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }

    public XIxXXX0x0(@OXOo.OOXIXo HashMap<SportDataType, Integer> order) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(order, "order");
        this.f23890oIX0oI = order;
    }

    public /* synthetic */ XIxXXX0x0(HashMap hashMap, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? kotlin.collections.o0.oOXoIIIo(kotlin.Xo0.oIX0oI(SportDataType.TIME, 3), kotlin.Xo0.oIX0oI(SportDataType.DISTANCE, 1), kotlin.Xo0.oIX0oI(SportDataType.PACE, 0), kotlin.Xo0.oIX0oI(SportDataType.SPEED, 0), kotlin.Xo0.oIX0oI(SportDataType.CALORIES, 4), kotlin.Xo0.oIX0oI(SportDataType.STEP, 0), kotlin.Xo0.oIX0oI(SportDataType.SPM, 0), kotlin.Xo0.oIX0oI(SportDataType.ALTITUDE, 0), kotlin.Xo0.oIX0oI(SportDataType.HEARTRATE, 2)) : hashMap);
    }
}
