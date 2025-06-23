package com.angcyo.dsladapter;

import androidx.recyclerview.widget.DiffUtil;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class XxX0x0xxx {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f5328I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f5329II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f5330II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super DiffUtil.DiffResult, ? super List<? extends DslAdapterItem>, oXIO0o0XI> f5331OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f5332Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f5333X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f5334XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final DslAdapterItem f5335oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f5336oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public long f5337xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public long f5338xxIXOIIO;

    public XxX0x0xxx() {
        this(null, false, false, false, false, false, null, null, 0L, 0L, null, 2047, null);
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<DiffUtil.DiffResult, List<? extends DslAdapterItem>, oXIO0o0XI> I0Io() {
        return this.f5331OOXIXo;
    }

    public final boolean II0XooXoX() {
        return this.f5334XO;
    }

    public final long II0xO0() {
        return this.f5337xoIox;
    }

    public final void IIX0o(boolean z) {
        this.f5330II0xO0 = z;
    }

    public final long IIXOooo() {
        return this.f5338xxIXOIIO;
    }

    public final boolean IXxxXO() {
        return this.f5336oxoX;
    }

    public final void O0xOxO(@OXOo.oOoXoXO Object obj) {
        this.f5329II0XooXoX = obj;
    }

    public final long OOXIXo() {
        return this.f5338xxIXOIIO;
    }

    public final boolean Oo() {
        return this.f5333X0o0xo;
    }

    public final void OxI(boolean z) {
        this.f5328I0Io = z;
    }

    public final boolean Oxx0IOOO() {
        return this.f5333X0o0xo;
    }

    public final long Oxx0xo() {
        return this.f5337xoIox;
    }

    @OXOo.oOoXoXO
    public final Object OxxIIOOXO() {
        return this.f5332Oxx0IOOO;
    }

    public final void X0IIOO(boolean z) {
        this.f5333X0o0xo = z;
    }

    public final boolean X0o0xo() {
        return this.f5328I0Io;
    }

    public final void XI0IXoo(boolean z) {
        this.f5336oxoX = z;
    }

    public final void XIxXXX0x0(long j) {
        this.f5337xoIox = j;
    }

    public final boolean XO() {
        return this.f5336oxoX;
    }

    public final void XxX0x0xxx(@OXOo.oOoXoXO Object obj) {
        this.f5332Oxx0IOOO = obj;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XxX0x0xxx)) {
            return false;
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5335oIX0oI, xxX0x0xxx.f5335oIX0oI) && this.f5330II0xO0 == xxX0x0xxx.f5330II0xO0 && this.f5328I0Io == xxX0x0xxx.f5328I0Io && this.f5336oxoX == xxX0x0xxx.f5336oxoX && this.f5333X0o0xo == xxX0x0xxx.f5333X0o0xo && this.f5334XO == xxX0x0xxx.f5334XO && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5332Oxx0IOOO, xxX0x0xxx.f5332Oxx0IOOO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5329II0XooXoX, xxX0x0xxx.f5329II0XooXoX) && this.f5338xxIXOIIO == xxX0x0xxx.f5338xxIXOIIO && this.f5337xoIox == xxX0x0xxx.f5337xoIox && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5331OOXIXo, xxX0x0xxx.f5331OOXIXo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        DslAdapterItem dslAdapterItem = this.f5335oIX0oI;
        int hashCode = (dslAdapterItem == null ? 0 : dslAdapterItem.hashCode()) * 31;
        boolean z = this.f5330II0xO0;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.f5328I0Io;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.f5336oxoX;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.f5333X0o0xo;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z5 = this.f5334XO;
        int i9 = (i8 + (z5 ? 1 : z5 ? 1 : 0)) * 31;
        Object obj = this.f5332Oxx0IOOO;
        int hashCode2 = (i9 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f5329II0XooXoX;
        int hashCode3 = (((((hashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31) + androidx.collection.oIX0oI.oIX0oI(this.f5338xxIXOIIO)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.f5337xoIox)) * 31;
        Oox.x0xO0oo<? super DiffUtil.DiffResult, ? super List<? extends DslAdapterItem>, oXIO0o0XI> x0xo0oo = this.f5331OOXIXo;
        return hashCode3 + (x0xo0oo != null ? x0xo0oo.hashCode() : 0);
    }

    public final boolean o00() {
        return this.f5334XO;
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<DiffUtil.DiffResult, List<? extends DslAdapterItem>, oXIO0o0XI> oI0IIXIo() {
        return this.f5331OOXIXo;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem oIX0oI() {
        return this.f5335oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object oO() {
        return this.f5329II0XooXoX;
    }

    @OXOo.OOXIXo
    public final XxX0x0xxx oOoXoXO(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Object obj2, long j, long j2, @OXOo.oOoXoXO Oox.x0xO0oo<? super DiffUtil.DiffResult, ? super List<? extends DslAdapterItem>, oXIO0o0XI> x0xo0oo) {
        return new XxX0x0xxx(dslAdapterItem, z, z2, z3, z4, z5, obj, obj2, j, j2, x0xo0oo);
    }

    public final void ooXIXxIX(boolean z) {
        this.f5334XO = z;
    }

    public final boolean oxoX() {
        return this.f5330II0xO0;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "FilterParams(fromDslAdapterItem=" + this.f5335oIX0oI + ", skip=" + this.f5330II0xO0 + ", asyncDiff=" + this.f5328I0Io + ", justRun=" + this.f5336oxoX + ", justFilter=" + this.f5333X0o0xo + ", updateDependItemWithEmpty=" + this.f5334XO + ", payload=" + this.f5332Oxx0IOOO + ", filterData=" + this.f5329II0XooXoX + ", shakeDelay=" + this.f5338xxIXOIIO + ", notifyDiffDelay=" + this.f5337xoIox + ", onDispatchUpdatesTo=" + this.f5331OOXIXo + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final boolean x0XOIxOo() {
        return this.f5328I0Io;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem x0xO0oo() {
        return this.f5335oIX0oI;
    }

    public final void xXxxox0I(long j) {
        this.f5338xxIXOIIO = j;
    }

    @OXOo.oOoXoXO
    public final Object xoIox() {
        return this.f5329II0XooXoX;
    }

    public final boolean xoXoI() {
        return this.f5330II0xO0;
    }

    @OXOo.oOoXoXO
    public final Object xxIXOIIO() {
        return this.f5332Oxx0IOOO;
    }

    public final void xxX(@OXOo.oOoXoXO Oox.x0xO0oo<? super DiffUtil.DiffResult, ? super List<? extends DslAdapterItem>, oXIO0o0XI> x0xo0oo) {
        this.f5331OOXIXo = x0xo0oo;
    }

    public XxX0x0xxx(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Object obj2, long j, long j2, @OXOo.oOoXoXO Oox.x0xO0oo<? super DiffUtil.DiffResult, ? super List<? extends DslAdapterItem>, oXIO0o0XI> x0xo0oo) {
        this.f5335oIX0oI = dslAdapterItem;
        this.f5330II0xO0 = z;
        this.f5328I0Io = z2;
        this.f5336oxoX = z3;
        this.f5333X0o0xo = z4;
        this.f5334XO = z5;
        this.f5332Oxx0IOOO = obj;
        this.f5329II0XooXoX = obj2;
        this.f5338xxIXOIIO = j;
        this.f5337xoIox = j2;
        this.f5331OOXIXo = x0xo0oo;
    }

    public /* synthetic */ XxX0x0xxx(DslAdapterItem dslAdapterItem, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Object obj, Object obj2, long j, long j2, Oox.x0xO0oo x0xo0oo, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : dslAdapterItem, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3, (i & 16) == 0 ? z4 : false, (i & 32) == 0 ? z5 : true, (i & 64) != 0 ? null : obj, (i & 128) != 0 ? null : obj2, (i & 256) != 0 ? DslDataFilter.f5190OOXIXo.I0Io() : j, (i & 512) != 0 ? -1L : j2, (i & 1024) == 0 ? x0xo0oo : null);
    }
}
