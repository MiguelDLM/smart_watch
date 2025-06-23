package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class OOXIXo extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23412XO;

    /* JADX WARN: Multi-variable type inference failed */
    public OOXIXo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OOXIXo I0Io(OOXIXo oOXIXo, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = oOXIXo.f23412XO;
        }
        return oOXIXo.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final OOXIXo II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new OOXIXo(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OOXIXo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23412XO, ((OOXIXo) obj).f23412XO);
    }

    public int hashCode() {
        return this.f23412XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23412XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23412XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyTemperatureValueDeviceList(list=" + this.f23412XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ OOXIXo(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public OOXIXo(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23412XO = list;
    }
}
