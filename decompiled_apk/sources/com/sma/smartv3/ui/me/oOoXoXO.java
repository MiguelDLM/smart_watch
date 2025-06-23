package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class oOoXoXO extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23572XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oOoXoXO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ oOoXoXO I0Io(oOoXoXO oooxoxo, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = oooxoxo.f23572XO;
        }
        return oooxoxo.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final oOoXoXO II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new oOoXoXO(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof oOoXoXO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23572XO, ((oOoXoXO) obj).f23572XO);
    }

    public int hashCode() {
        return this.f23572XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23572XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23572XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyTuyaKeySetDeviceList(list=" + this.f23572XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ oOoXoXO(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public oOoXoXO(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23572XO = list;
    }
}
