package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class xoIox extends oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5387II0xO0 = Integer.MAX_VALUE;

    public final int I0Io() {
        return this.f5387II0xO0;
    }

    @Override // com.angcyo.dsladapter.filter.II0XooXoX
    @OOXIXo
    public List<DslAdapterItem> II0xO0(@OOXIXo XO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        if (chain.oOoXoXO().size() >= this.f5387II0xO0) {
            return chain.oOoXoXO().subList(0, this.f5387II0xO0);
        }
        return chain.oOoXoXO();
    }

    public final void oxoX(int i) {
        this.f5387II0xO0 = i;
    }
}
