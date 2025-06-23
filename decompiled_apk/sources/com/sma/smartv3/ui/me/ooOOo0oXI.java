package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class ooOOo0oXI extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23593XO;

    /* JADX WARN: Multi-variable type inference failed */
    public ooOOo0oXI() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ooOOo0oXI I0Io(ooOOo0oXI ooooo0oxi, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = ooooo0oxi.f23593XO;
        }
        return ooooo0oxi.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final ooOOo0oXI II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new ooOOo0oXI(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ooOOo0oXI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23593XO, ((ooOOo0oXI) obj).f23593XO);
    }

    public int hashCode() {
        return this.f23593XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23593XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23593XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyUpdateDeviceList(list=" + this.f23593XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ooOOo0oXI(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public ooOOo0oXI(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23593XO = list;
    }
}
