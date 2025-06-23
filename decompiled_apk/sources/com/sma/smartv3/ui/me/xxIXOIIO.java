package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class xxIXOIIO extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23653XO;

    /* JADX WARN: Multi-variable type inference failed */
    public xxIXOIIO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ xxIXOIIO I0Io(xxIXOIIO xxixoiio, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = xxixoiio.f23653XO;
        }
        return xxixoiio.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final xxIXOIIO II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new xxIXOIIO(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof xxIXOIIO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23653XO, ((xxIXOIIO) obj).f23653XO);
    }

    public int hashCode() {
        return this.f23653XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23653XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23653XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyReadLogDeviceList(list=" + this.f23653XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ xxIXOIIO(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public xxIXOIIO(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23653XO = list;
    }
}
