package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class oxoX extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23600XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oxoX() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ oxoX I0Io(oxoX oxox, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = oxox.f23600XO;
        }
        return oxox.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final oxoX II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new oxoX(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof oxoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23600XO, ((oxoX) obj).f23600XO);
    }

    public int hashCode() {
        return this.f23600XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23600XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23600XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyAirPressureValueDeviceList(list=" + this.f23600XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ oxoX(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public oxoX(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23600XO = list;
    }
}
