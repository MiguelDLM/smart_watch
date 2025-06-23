package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class I0Io extends oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    @oOoXoXO
    public DslAdapterItem f5368I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5369II0xO0 = Integer.MAX_VALUE;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f5370oxoX = true;

    @oOoXoXO
    public final DslAdapterItem I0Io() {
        return this.f5368I0Io;
    }

    public final void II0XooXoX(int i) {
        this.f5369II0xO0 = i;
    }

    @Override // com.angcyo.dsladapter.filter.II0XooXoX
    @OOXIXo
    public List<DslAdapterItem> II0xO0(@OOXIXo XO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        if (chain.oOoXoXO().size() >= this.f5369II0xO0) {
            return chain.oOoXoXO().subList(0, this.f5369II0xO0);
        }
        DslAdapterItem dslAdapterItem = this.f5368I0Io;
        if (dslAdapterItem != null) {
            if (this.f5370oxoX) {
                DslAdapterExKt.IxIX0I(chain.II0XooXoX());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(chain.oOoXoXO());
            arrayList.add(dslAdapterItem);
            return arrayList;
        }
        return chain.oOoXoXO();
    }

    public final void Oxx0IOOO(boolean z) {
        this.f5370oxoX = z;
    }

    public final int X0o0xo() {
        return this.f5369II0xO0;
    }

    public final void XO(@oOoXoXO DslAdapterItem dslAdapterItem) {
        this.f5368I0Io = dslAdapterItem;
    }

    public final boolean oxoX() {
        return this.f5370oxoX;
    }
}
