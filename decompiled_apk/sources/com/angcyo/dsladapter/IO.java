package com.angcyo.dsladapter;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes7.dex */
public final class IO {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f5234I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f5235II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5236II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f5237Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f5238X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f5239XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public DslAdapterItem f5240oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f5241oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f5242xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f5243xxIXOIIO;

    public IO() {
        this(null, 0, false, false, false, null, false, false, false, null, 1023, null);
    }

    public final int I0Io() {
        return this.f5236II0xO0;
    }

    public final boolean II0XooXoX() {
        return this.f5237Oxx0IOOO;
    }

    @OXOo.oOoXoXO
    public final Object II0xO0() {
        return this.f5242xoIox;
    }

    public final boolean IIXOooo() {
        return this.f5237Oxx0IOOO;
    }

    public final boolean IXxxXO() {
        return this.f5235II0XooXoX;
    }

    public final void O0xOxO(boolean z) {
        this.f5241oxoX = z;
    }

    @OXOo.OOXIXo
    public final IO OOXIXo(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, int i, boolean z, boolean z2, boolean z3, @OXOo.oOoXoXO Object obj, boolean z4, boolean z5, boolean z6, @OXOo.oOoXoXO Object obj2) {
        return new IO(dslAdapterItem, i, z, z2, z3, obj, z4, z5, z6, obj2);
    }

    public final boolean Oo() {
        return this.f5234I0Io;
    }

    public final void OxI(boolean z) {
        this.f5243xxIXOIIO = z;
    }

    @OXOo.oOoXoXO
    public final Object Oxx0IOOO() {
        return this.f5239XO;
    }

    @OXOo.oOoXoXO
    public final Object Oxx0xo() {
        return this.f5242xoIox;
    }

    public final boolean OxxIIOOXO() {
        return this.f5238X0o0xo;
    }

    public final void X0IIOO(boolean z) {
        this.f5234I0Io = z;
    }

    public final boolean X0o0xo() {
        return this.f5241oxoX;
    }

    public final void XI0IXoo(boolean z) {
        this.f5235II0XooXoX = z;
    }

    public final void XIxXXX0x0(@OXOo.oOoXoXO Object obj) {
        this.f5242xoIox = obj;
    }

    public final boolean XO() {
        return this.f5238X0o0xo;
    }

    public final void XxX0x0xxx(boolean z) {
        this.f5238X0o0xo = z;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IO)) {
            return false;
        }
        IO io2 = (IO) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5240oIX0oI, io2.f5240oIX0oI) && this.f5236II0xO0 == io2.f5236II0xO0 && this.f5234I0Io == io2.f5234I0Io && this.f5241oxoX == io2.f5241oxoX && this.f5238X0o0xo == io2.f5238X0o0xo && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5239XO, io2.f5239XO) && this.f5237Oxx0IOOO == io2.f5237Oxx0IOOO && this.f5235II0XooXoX == io2.f5235II0XooXoX && this.f5243xxIXOIIO == io2.f5243xxIXOIIO && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5242xoIox, io2.f5242xoIox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        DslAdapterItem dslAdapterItem = this.f5240oIX0oI;
        int hashCode = (((dslAdapterItem == null ? 0 : dslAdapterItem.hashCode()) * 31) + this.f5236II0xO0) * 31;
        boolean z = this.f5234I0Io;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.f5241oxoX;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.f5238X0o0xo;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        Object obj = this.f5239XO;
        int hashCode2 = (i6 + (obj == null ? 0 : obj.hashCode())) * 31;
        boolean z4 = this.f5237Oxx0IOOO;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode2 + i7) * 31;
        boolean z5 = this.f5235II0XooXoX;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z6 = this.f5243xxIXOIIO;
        int i11 = (i10 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
        Object obj2 = this.f5242xoIox;
        return i11 + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final void o00(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        this.f5240oIX0oI = dslAdapterItem;
    }

    public final int oI0IIXIo() {
        return this.f5236II0xO0;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem oIX0oI() {
        return this.f5240oIX0oI;
    }

    public final boolean oO() {
        return this.f5243xxIXOIIO;
    }

    @OXOo.oOoXoXO
    public final Object ooOOo0oXI() {
        return this.f5239XO;
    }

    public final boolean oxoX() {
        return this.f5234I0Io;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SelectorParams(item=" + this.f5240oIX0oI + ", selector=" + this.f5236II0xO0 + ", notifySelectListener=" + this.f5234I0Io + ", notifyItemSelectorChange=" + this.f5241oxoX + ", updateItemDepend=" + this.f5238X0o0xo + ", extend=" + this.f5239XO + ", _useFilterList=" + this.f5237Oxx0IOOO + ", notifyWithListEmpty=" + this.f5235II0XooXoX + ", notifyItemChanged=" + this.f5243xxIXOIIO + ", payload=" + this.f5242xoIox + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem x0XOIxOo() {
        return this.f5240oIX0oI;
    }

    public final boolean x0xO0oo() {
        return this.f5241oxoX;
    }

    public final void xXxxox0I(boolean z) {
        this.f5237Oxx0IOOO = z;
    }

    public final boolean xoIox() {
        return this.f5243xxIXOIIO;
    }

    public final void xoXoI(@OXOo.oOoXoXO Object obj) {
        this.f5239XO = obj;
    }

    public final boolean xxIXOIIO() {
        return this.f5235II0XooXoX;
    }

    public final void xxX(int i) {
        this.f5236II0xO0 = i;
    }

    public IO(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, int i, boolean z, boolean z2, boolean z3, @OXOo.oOoXoXO Object obj, boolean z4, boolean z5, boolean z6, @OXOo.oOoXoXO Object obj2) {
        this.f5240oIX0oI = dslAdapterItem;
        this.f5236II0xO0 = i;
        this.f5234I0Io = z;
        this.f5241oxoX = z2;
        this.f5238X0o0xo = z3;
        this.f5239XO = obj;
        this.f5237Oxx0IOOO = z4;
        this.f5235II0XooXoX = z5;
        this.f5243xxIXOIIO = z6;
        this.f5242xoIox = obj2;
    }

    public /* synthetic */ IO(DslAdapterItem dslAdapterItem, int i, boolean z, boolean z2, boolean z3, Object obj, boolean z4, boolean z5, boolean z6, Object obj2, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? null : dslAdapterItem, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) == 0 ? obj : null, (i2 & 64) != 0 ? true : z4, (i2 & 128) != 0 ? false : z5, (i2 & 256) != 0 ? true : z6, (i2 & 512) != 0 ? CollectionsKt__CollectionsKt.X00IoxXI(1, 16) : obj2);
    }
}
