package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class Oxx0IOOO extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23443XO;

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0IOOO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Oxx0IOOO I0Io(Oxx0IOOO oxx0IOOO, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = oxx0IOOO.f23443XO;
        }
        return oxx0IOOO.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final Oxx0IOOO II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new Oxx0IOOO(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Oxx0IOOO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23443XO, ((Oxx0IOOO) obj).f23443XO);
    }

    public int hashCode() {
        return this.f23443XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23443XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23443XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyGoMoreSetDeviceList(list=" + this.f23443XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ Oxx0IOOO(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public Oxx0IOOO(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23443XO = list;
    }
}
