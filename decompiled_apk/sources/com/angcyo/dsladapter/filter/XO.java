package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslDataFilter;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final List<DslAdapterItem> f5380I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final DslDataFilter f5381II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f5382X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final DslAdapter f5383oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public List<? extends DslAdapterItem> f5384oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public XO(@OOXIXo DslAdapter dslAdapter, @OOXIXo DslDataFilter dslDataFilter, @OOXIXo List<? extends DslAdapterItem> originList, @OOXIXo List<? extends DslAdapterItem> requestList, boolean z) {
        IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        IIX0o.x0xO0oo(dslDataFilter, "dslDataFilter");
        IIX0o.x0xO0oo(originList, "originList");
        IIX0o.x0xO0oo(requestList, "requestList");
        this.f5383oIX0oI = dslAdapter;
        this.f5381II0xO0 = dslDataFilter;
        this.f5380I0Io = originList;
        this.f5384oxoX = requestList;
        this.f5382X0o0xo = z;
    }

    public static /* synthetic */ XO Oxx0IOOO(XO xo2, DslAdapter dslAdapter, DslDataFilter dslDataFilter, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = xo2.f5383oIX0oI;
        }
        if ((i & 2) != 0) {
            dslDataFilter = xo2.f5381II0xO0;
        }
        DslDataFilter dslDataFilter2 = dslDataFilter;
        if ((i & 4) != 0) {
            list = xo2.f5380I0Io;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = xo2.f5384oxoX;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            z = xo2.f5382X0o0xo;
        }
        return xo2.XO(dslAdapter, dslDataFilter2, list3, list4, z);
    }

    @OOXIXo
    public final List<DslAdapterItem> I0Io() {
        return this.f5380I0Io;
    }

    @OOXIXo
    public final DslAdapter II0XooXoX() {
        return this.f5383oIX0oI;
    }

    @OOXIXo
    public final DslDataFilter II0xO0() {
        return this.f5381II0xO0;
    }

    @OOXIXo
    public final List<DslAdapterItem> OOXIXo() {
        return this.f5380I0Io;
    }

    public final boolean X0o0xo() {
        return this.f5382X0o0xo;
    }

    @OOXIXo
    public final XO XO(@OOXIXo DslAdapter dslAdapter, @OOXIXo DslDataFilter dslDataFilter, @OOXIXo List<? extends DslAdapterItem> originList, @OOXIXo List<? extends DslAdapterItem> requestList, boolean z) {
        IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        IIX0o.x0xO0oo(dslDataFilter, "dslDataFilter");
        IIX0o.x0xO0oo(originList, "originList");
        IIX0o.x0xO0oo(requestList, "requestList");
        return new XO(dslAdapter, dslDataFilter, originList, requestList, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XO)) {
            return false;
        }
        XO xo2 = (XO) obj;
        return IIX0o.Oxx0IOOO(this.f5383oIX0oI, xo2.f5383oIX0oI) && IIX0o.Oxx0IOOO(this.f5381II0xO0, xo2.f5381II0xO0) && IIX0o.Oxx0IOOO(this.f5380I0Io, xo2.f5380I0Io) && IIX0o.Oxx0IOOO(this.f5384oxoX, xo2.f5384oxoX) && this.f5382X0o0xo == xo2.f5382X0o0xo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f5383oIX0oI.hashCode() * 31) + this.f5381II0xO0.hashCode()) * 31) + this.f5380I0Io.hashCode()) * 31) + this.f5384oxoX.hashCode()) * 31;
        boolean z = this.f5382X0o0xo;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @OOXIXo
    public final DslAdapter oIX0oI() {
        return this.f5383oIX0oI;
    }

    @OOXIXo
    public final List<DslAdapterItem> oOoXoXO() {
        return this.f5384oxoX;
    }

    public final void ooOOo0oXI(boolean z) {
        this.f5382X0o0xo = z;
    }

    @OOXIXo
    public final List<DslAdapterItem> oxoX() {
        return this.f5384oxoX;
    }

    @OOXIXo
    public String toString() {
        return "FilterAfterChain(dslAdapter=" + this.f5383oIX0oI + ", dslDataFilter=" + this.f5381II0xO0 + ", originList=" + this.f5380I0Io + ", requestList=" + this.f5384oxoX + ", interruptChain=" + this.f5382X0o0xo + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void x0XOIxOo(@OOXIXo List<? extends DslAdapterItem> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.f5384oxoX = list;
    }

    public final boolean xoIox() {
        return this.f5382X0o0xo;
    }

    @OOXIXo
    public final DslDataFilter xxIXOIIO() {
        return this.f5381II0xO0;
    }

    public /* synthetic */ XO(DslAdapter dslAdapter, DslDataFilter dslDataFilter, List list, List list2, boolean z, int i, IIXOooo iIXOooo) {
        this(dslAdapter, dslDataFilter, list, list2, (i & 16) != 0 ? false : z);
    }
}
