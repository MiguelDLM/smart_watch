package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class xoIox extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23642XO;

    /* JADX WARN: Multi-variable type inference failed */
    public xoIox() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ xoIox I0Io(xoIox xoiox, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = xoiox.f23642XO;
        }
        return xoiox.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final xoIox II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new xoIox(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof xoIox) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23642XO, ((xoIox) obj).f23642XO);
    }

    public int hashCode() {
        return this.f23642XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23642XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23642XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyShutdownDeviceList(list=" + this.f23642XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ xoIox(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public xoIox(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23642XO = list;
    }
}
