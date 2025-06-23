package com.angcyo.dsladapter;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes7.dex */
public final class xxX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5461I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5462II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5463X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5464XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5465oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public x0o f5466oxoX;

    public xxX() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ xxX II0XooXoX(xxX xxx2, x0o x0oVar, x0o x0oVar2, x0o x0oVar3, x0o x0oVar4, x0o x0oVar5, x0o x0oVar6, int i, Object obj) {
        if ((i & 1) != 0) {
            x0oVar = xxx2.f5465oIX0oI;
        }
        if ((i & 2) != 0) {
            x0oVar2 = xxx2.f5462II0xO0;
        }
        x0o x0oVar7 = x0oVar2;
        if ((i & 4) != 0) {
            x0oVar3 = xxx2.f5461I0Io;
        }
        x0o x0oVar8 = x0oVar3;
        if ((i & 8) != 0) {
            x0oVar4 = xxx2.f5466oxoX;
        }
        x0o x0oVar9 = x0oVar4;
        if ((i & 16) != 0) {
            x0oVar5 = xxx2.f5463X0o0xo;
        }
        x0o x0oVar10 = x0oVar5;
        if ((i & 32) != 0) {
            x0oVar6 = xxx2.f5464XO;
        }
        return xxx2.Oxx0IOOO(x0oVar, x0oVar7, x0oVar8, x0oVar9, x0oVar10, x0oVar6);
    }

    @OXOo.OOXIXo
    public final x0o I0Io() {
        return this.f5461I0Io;
    }

    @OXOo.OOXIXo
    public final x0o II0xO0() {
        return this.f5462II0xO0;
    }

    public final void IXxxXO(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5464XO = x0oVar;
    }

    @OXOo.OOXIXo
    public final x0o OOXIXo() {
        return this.f5461I0Io;
    }

    public final void Oo(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5461I0Io = x0oVar;
    }

    @OXOo.OOXIXo
    public final xxX Oxx0IOOO(@OXOo.OOXIXo x0o currentSpanParams, @OXOo.OOXIXo x0o nextSpanParams, @OXOo.OOXIXo x0o firstSpanParams, @OXOo.OOXIXo x0o lastSpanParams, @OXOo.OOXIXo x0o firstParams, @OXOo.OOXIXo x0o lastParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(currentSpanParams, "currentSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(nextSpanParams, "nextSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(firstSpanParams, "firstSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lastSpanParams, "lastSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(firstParams, "firstParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lastParams, "lastParams");
        return new xxX(currentSpanParams, nextSpanParams, firstSpanParams, lastSpanParams, firstParams, lastParams);
    }

    public final void Oxx0xo(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5466oxoX = x0oVar;
    }

    @OXOo.OOXIXo
    public final x0o X0o0xo() {
        return this.f5463X0o0xo;
    }

    @OXOo.OOXIXo
    public final x0o XO() {
        return this.f5464XO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xxX)) {
            return false;
        }
        xxX xxx2 = (xxX) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5465oIX0oI, xxx2.f5465oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5462II0xO0, xxx2.f5462II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5461I0Io, xxx2.f5461I0Io) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5466oxoX, xxx2.f5466oxoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5463X0o0xo, xxx2.f5463X0o0xo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f5464XO, xxx2.f5464XO);
    }

    public int hashCode() {
        return (((((((((this.f5465oIX0oI.hashCode() * 31) + this.f5462II0xO0.hashCode()) * 31) + this.f5461I0Io.hashCode()) * 31) + this.f5466oxoX.hashCode()) * 31) + this.f5463X0o0xo.hashCode()) * 31) + this.f5464XO.hashCode();
    }

    public final void oI0IIXIo(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5462II0xO0 = x0oVar;
    }

    @OXOo.OOXIXo
    public final x0o oIX0oI() {
        return this.f5465oIX0oI;
    }

    public final void oO(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5465oIX0oI = x0oVar;
    }

    @OXOo.OOXIXo
    public final x0o oOoXoXO() {
        return this.f5464XO;
    }

    @OXOo.OOXIXo
    public final x0o ooOOo0oXI() {
        return this.f5466oxoX;
    }

    @OXOo.OOXIXo
    public final x0o oxoX() {
        return this.f5466oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "EdgeGridParams(currentSpanParams=" + this.f5465oIX0oI + ", nextSpanParams=" + this.f5462II0xO0 + ", firstSpanParams=" + this.f5461I0Io + ", lastSpanParams=" + this.f5466oxoX + ", firstParams=" + this.f5463X0o0xo + ", lastParams=" + this.f5464XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    public final x0o x0XOIxOo() {
        return this.f5462II0xO0;
    }

    public final void x0xO0oo(@OXOo.OOXIXo x0o x0oVar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oVar, "<set-?>");
        this.f5463X0o0xo = x0oVar;
    }

    @OXOo.OOXIXo
    public final x0o xoIox() {
        return this.f5463X0o0xo;
    }

    @OXOo.OOXIXo
    public final x0o xxIXOIIO() {
        return this.f5465oIX0oI;
    }

    public xxX(@OXOo.OOXIXo x0o currentSpanParams, @OXOo.OOXIXo x0o nextSpanParams, @OXOo.OOXIXo x0o firstSpanParams, @OXOo.OOXIXo x0o lastSpanParams, @OXOo.OOXIXo x0o firstParams, @OXOo.OOXIXo x0o lastParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(currentSpanParams, "currentSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(nextSpanParams, "nextSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(firstSpanParams, "firstSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lastSpanParams, "lastSpanParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(firstParams, "firstParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lastParams, "lastParams");
        this.f5465oIX0oI = currentSpanParams;
        this.f5462II0xO0 = nextSpanParams;
        this.f5461I0Io = firstSpanParams;
        this.f5466oxoX = lastSpanParams;
        this.f5463X0o0xo = firstParams;
        this.f5464XO = lastParams;
    }

    public /* synthetic */ xxX(x0o x0oVar, x0o x0oVar2, x0o x0oVar3, x0o x0oVar4, x0o x0oVar5, x0o x0oVar6, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar, (i & 2) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar2, (i & 4) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar3, (i & 8) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar4, (i & 16) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar5, (i & 32) != 0 ? new x0o(0, 0, 0, 0, 0, 0, 63, null) : x0oVar6);
    }
}
