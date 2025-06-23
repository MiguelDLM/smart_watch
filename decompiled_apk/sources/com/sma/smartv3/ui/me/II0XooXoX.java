package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class II0XooXoX extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23329XO;

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ II0XooXoX I0Io(II0XooXoX iI0XooXoX, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = iI0XooXoX.f23329XO;
        }
        return iI0XooXoX.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final II0XooXoX II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new II0XooXoX(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof II0XooXoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23329XO, ((II0XooXoX) obj).f23329XO);
    }

    public int hashCode() {
        return this.f23329XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23329XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23329XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyIMEISetDeviceList(list=" + this.f23329XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ II0XooXoX(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public II0XooXoX(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23329XO = list;
    }
}
