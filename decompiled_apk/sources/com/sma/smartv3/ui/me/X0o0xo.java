package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class X0o0xo extends JsonFieldContainer {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<String> f23481XO;

    /* JADX WARN: Multi-variable type inference failed */
    public X0o0xo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ X0o0xo I0Io(X0o0xo x0o0xo, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = x0o0xo.f23481XO;
        }
        return x0o0xo.II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public final X0o0xo II0xO0(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        return new X0o0xo(list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof X0o0xo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23481XO, ((X0o0xo) obj).f23481XO);
    }

    public int hashCode() {
        return this.f23481XO.hashCode();
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oIX0oI() {
        return this.f23481XO;
    }

    @OXOo.OOXIXo
    public final ArrayList<String> oxoX() {
        return this.f23481XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AlreadyBtNameDeviceList(list=" + this.f23481XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ X0o0xo(ArrayList arrayList, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public X0o0xo(@OXOo.OOXIXo ArrayList<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f23481XO = list;
    }
}
