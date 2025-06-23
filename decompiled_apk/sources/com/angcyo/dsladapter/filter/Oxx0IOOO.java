package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslDataFilter;
import com.angcyo.dsladapter.XxX0x0xxx;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final XxX0x0xxx f5371I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final DslDataFilter f5372II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public List<? extends DslAdapterItem> f5373X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f5374XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final DslAdapter f5375oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final List<DslAdapterItem> f5376oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0IOOO(@OOXIXo DslAdapter dslAdapter, @OOXIXo DslDataFilter dslDataFilter, @OOXIXo XxX0x0xxx filterParams, @OOXIXo List<? extends DslAdapterItem> originList, @OOXIXo List<? extends DslAdapterItem> requestList, boolean z) {
        IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        IIX0o.x0xO0oo(dslDataFilter, "dslDataFilter");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(originList, "originList");
        IIX0o.x0xO0oo(requestList, "requestList");
        this.f5375oIX0oI = dslAdapter;
        this.f5372II0xO0 = dslDataFilter;
        this.f5371I0Io = filterParams;
        this.f5376oxoX = originList;
        this.f5373X0o0xo = requestList;
        this.f5374XO = z;
    }

    public static /* synthetic */ Oxx0IOOO II0XooXoX(Oxx0IOOO oxx0IOOO, DslAdapter dslAdapter, DslDataFilter dslDataFilter, XxX0x0xxx xxX0x0xxx, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = oxx0IOOO.f5375oIX0oI;
        }
        if ((i & 2) != 0) {
            dslDataFilter = oxx0IOOO.f5372II0xO0;
        }
        DslDataFilter dslDataFilter2 = dslDataFilter;
        if ((i & 4) != 0) {
            xxX0x0xxx = oxx0IOOO.f5371I0Io;
        }
        XxX0x0xxx xxX0x0xxx2 = xxX0x0xxx;
        if ((i & 8) != 0) {
            list = oxx0IOOO.f5376oxoX;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = oxx0IOOO.f5373X0o0xo;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            z = oxx0IOOO.f5374XO;
        }
        return oxx0IOOO.Oxx0IOOO(dslAdapter, dslDataFilter2, xxX0x0xxx2, list3, list4, z);
    }

    @OOXIXo
    public final XxX0x0xxx I0Io() {
        return this.f5371I0Io;
    }

    @OOXIXo
    public final DslDataFilter II0xO0() {
        return this.f5372II0xO0;
    }

    @OOXIXo
    public final XxX0x0xxx OOXIXo() {
        return this.f5371I0Io;
    }

    @OOXIXo
    public final Oxx0IOOO Oxx0IOOO(@OOXIXo DslAdapter dslAdapter, @OOXIXo DslDataFilter dslDataFilter, @OOXIXo XxX0x0xxx filterParams, @OOXIXo List<? extends DslAdapterItem> originList, @OOXIXo List<? extends DslAdapterItem> requestList, boolean z) {
        IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        IIX0o.x0xO0oo(dslDataFilter, "dslDataFilter");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(originList, "originList");
        IIX0o.x0xO0oo(requestList, "requestList");
        return new Oxx0IOOO(dslAdapter, dslDataFilter, filterParams, originList, requestList, z);
    }

    @OOXIXo
    public final List<DslAdapterItem> X0o0xo() {
        return this.f5373X0o0xo;
    }

    public final boolean XO() {
        return this.f5374XO;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oxx0IOOO)) {
            return false;
        }
        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) obj;
        return IIX0o.Oxx0IOOO(this.f5375oIX0oI, oxx0IOOO.f5375oIX0oI) && IIX0o.Oxx0IOOO(this.f5372II0xO0, oxx0IOOO.f5372II0xO0) && IIX0o.Oxx0IOOO(this.f5371I0Io, oxx0IOOO.f5371I0Io) && IIX0o.Oxx0IOOO(this.f5376oxoX, oxx0IOOO.f5376oxoX) && IIX0o.Oxx0IOOO(this.f5373X0o0xo, oxx0IOOO.f5373X0o0xo) && this.f5374XO == oxx0IOOO.f5374XO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f5375oIX0oI.hashCode() * 31) + this.f5372II0xO0.hashCode()) * 31) + this.f5371I0Io.hashCode()) * 31) + this.f5376oxoX.hashCode()) * 31) + this.f5373X0o0xo.hashCode()) * 31;
        boolean z = this.f5374XO;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @OOXIXo
    public final DslAdapter oIX0oI() {
        return this.f5375oIX0oI;
    }

    public final void oO(boolean z) {
        this.f5374XO = z;
    }

    public final boolean oOoXoXO() {
        return this.f5374XO;
    }

    @OOXIXo
    public final List<DslAdapterItem> ooOOo0oXI() {
        return this.f5376oxoX;
    }

    @OOXIXo
    public final List<DslAdapterItem> oxoX() {
        return this.f5376oxoX;
    }

    @OOXIXo
    public String toString() {
        return "FilterChain(dslAdapter=" + this.f5375oIX0oI + ", dslDataFilter=" + this.f5372II0xO0 + ", filterParams=" + this.f5371I0Io + ", originList=" + this.f5376oxoX + ", requestList=" + this.f5373X0o0xo + ", interruptChain=" + this.f5374XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OOXIXo
    public final List<DslAdapterItem> x0XOIxOo() {
        return this.f5373X0o0xo;
    }

    public final void x0xO0oo(@OOXIXo List<? extends DslAdapterItem> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.f5373X0o0xo = list;
    }

    @OOXIXo
    public final DslDataFilter xoIox() {
        return this.f5372II0xO0;
    }

    @OOXIXo
    public final DslAdapter xxIXOIIO() {
        return this.f5375oIX0oI;
    }

    public /* synthetic */ Oxx0IOOO(DslAdapter dslAdapter, DslDataFilter dslDataFilter, XxX0x0xxx xxX0x0xxx, List list, List list2, boolean z, int i, IIXOooo iIXOooo) {
        this(dslAdapter, dslDataFilter, xxX0x0xxx, list, list2, (i & 32) != 0 ? false : z);
    }
}
