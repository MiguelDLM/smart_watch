package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class XO extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23490XO;

    /* JADX WARN: Multi-variable type inference failed */
    public XO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XO I0Io(XO xo2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = xo2.f23490XO;
        }
        return xo2.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final XO II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new XO(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof XO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23490XO, ((XO) obj).f23490XO);
    }

    public int hashCode() {
        return this.f23490XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23490XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23490XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyBtNameSearchDeviceList(list=" + this.f23490XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ XO(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public XO(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23490XO = list;
    }
}
