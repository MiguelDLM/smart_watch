package com.angcyo.dsladapter;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes7.dex */
public final class ooXIXxIX {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f5438I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5439II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<? extends DslAdapterItem> f5440X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public xxX f5441XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<ooXIXxIX> f5442oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public DslAdapterItem f5443oxoX;

    public ooXIXxIX() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    public static /* synthetic */ ooXIXxIX II0XooXoX(ooXIXxIX ooxixxix, List list, int i, int i2, DslAdapterItem dslAdapterItem, List list2, xxX xxx2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = ooxixxix.f5442oIX0oI;
        }
        if ((i3 & 2) != 0) {
            i = ooxixxix.f5439II0xO0;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = ooxixxix.f5438I0Io;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            dslAdapterItem = ooxixxix.f5443oxoX;
        }
        DslAdapterItem dslAdapterItem2 = dslAdapterItem;
        if ((i3 & 16) != 0) {
            list2 = ooxixxix.f5440X0o0xo;
        }
        List list3 = list2;
        if ((i3 & 32) != 0) {
            xxx2 = ooxixxix.f5441XO;
        }
        return ooxixxix.Oxx0IOOO(list, i4, i5, dslAdapterItem2, list3, xxx2);
    }

    public final int I0Io() {
        return this.f5438I0Io;
    }

    public final int II0xO0() {
        return this.f5439II0xO0;
    }

    public final void IXxxXO(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.f5440X0o0xo = list;
    }

    public final int OOXIXo() {
        return this.f5439II0xO0;
    }

    public final void Oo(int i) {
        this.f5439II0xO0 = i;
    }

    @OXOo.OOXIXo
    public final ooXIXxIX Oxx0IOOO(@OXOo.OOXIXo List<ooXIXxIX> groupList, int i, int i2, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends DslAdapterItem> groupItems, @OXOo.oOoXoXO xxX xxx2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(groupList, "groupList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(groupItems, "groupItems");
        return new ooXIXxIX(groupList, i, i2, dslAdapterItem, groupItems, xxx2);
    }

    public final void Oxx0xo(@OXOo.OOXIXo List<ooXIXxIX> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.f5442oIX0oI = list;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> X0o0xo() {
        return this.f5440X0o0xo;
    }

    @OXOo.oOoXoXO
    public final xxX XO() {
        return this.f5441XO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ooXIXxIX)) {
            return false;
        }
        ooXIXxIX ooxixxix = (ooXIXxIX) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5442oIX0oI, ooxixxix.f5442oIX0oI) && this.f5439II0xO0 == ooxixxix.f5439II0xO0 && this.f5438I0Io == ooxixxix.f5438I0Io && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5443oxoX, ooxixxix.f5443oxoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5440X0o0xo, ooxixxix.f5440X0o0xo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5441XO, ooxixxix.f5441XO);
    }

    public int hashCode() {
        int hashCode = ((((this.f5442oIX0oI.hashCode() * 31) + this.f5439II0xO0) * 31) + this.f5438I0Io) * 31;
        DslAdapterItem dslAdapterItem = this.f5443oxoX;
        int hashCode2 = (((hashCode + (dslAdapterItem == null ? 0 : dslAdapterItem.hashCode())) * 31) + this.f5440X0o0xo.hashCode()) * 31;
        xxX xxx2 = this.f5441XO;
        return hashCode2 + (xxx2 != null ? xxx2.hashCode() : 0);
    }

    public final void oI0IIXIo(int i) {
        this.f5438I0Io = i;
    }

    @OXOo.OOXIXo
    public final List<ooXIXxIX> oIX0oI() {
        return this.f5442oIX0oI;
    }

    public final void oO(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        this.f5443oxoX = dslAdapterItem;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> oOoXoXO() {
        return this.f5440X0o0xo;
    }

    @OXOo.OOXIXo
    public final List<ooXIXxIX> ooOOo0oXI() {
        return this.f5442oIX0oI;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem oxoX() {
        return this.f5443oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "ItemGroupParams(groupList=" + this.f5442oIX0oI + ", groupIndex=" + this.f5439II0xO0 + ", indexInGroup=" + this.f5438I0Io + ", currentAdapterItem=" + this.f5443oxoX + ", groupItems=" + this.f5440X0o0xo + ", edgeGridParams=" + this.f5441XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final int x0XOIxOo() {
        return this.f5438I0Io;
    }

    public final void x0xO0oo(@OXOo.oOoXoXO xxX xxx2) {
        this.f5441XO = xxx2;
    }

    @OXOo.oOoXoXO
    public final xxX xoIox() {
        return this.f5441XO;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem xxIXOIIO() {
        return this.f5443oxoX;
    }

    public ooXIXxIX(@OXOo.OOXIXo List<ooXIXxIX> groupList, int i, int i2, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends DslAdapterItem> groupItems, @OXOo.oOoXoXO xxX xxx2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(groupList, "groupList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(groupItems, "groupItems");
        this.f5442oIX0oI = groupList;
        this.f5439II0xO0 = i;
        this.f5438I0Io = i2;
        this.f5443oxoX = dslAdapterItem;
        this.f5440X0o0xo = groupItems;
        this.f5441XO = xxx2;
    }

    public /* synthetic */ ooXIXxIX(List list, int i, int i2, DslAdapterItem dslAdapterItem, List list2, xxX xxx2, int i3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i3 & 2) != 0 ? -1 : i, (i3 & 4) == 0 ? i2 : -1, (i3 & 8) != 0 ? null : dslAdapterItem, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list2, (i3 & 32) != 0 ? null : xxx2);
    }
}
