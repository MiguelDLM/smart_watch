package com.angcyo.dsladapter.internal;

import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public long f5388I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f5391oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f5390oIX0oI = 160;

    /* renamed from: II0xO0, reason: collision with root package name */
    public long f5389II0xO0 = 60;

    public final long I0Io() {
        return this.f5390oIX0oI;
    }

    public final void II0XooXoX(long j) {
        this.f5388I0Io = j;
    }

    public final long II0xO0() {
        return this.f5389II0xO0;
    }

    public final void Oxx0IOOO(long j) {
        this.f5390oIX0oI = j;
    }

    public final long X0o0xo() {
        return this.f5391oxoX;
    }

    public final void XO(long j) {
        this.f5389II0xO0 = j;
    }

    public long oIX0oI(@OXOo.OOXIXo DslAdapterItem item) {
        RecyclerView recyclerView;
        IIX0o.x0xO0oo(item, "item");
        if (item.getItemAnimateRes() == 0) {
            return -1L;
        }
        if (item.get_itemAnimateDelay() == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f5388I0Io > this.f5390oIX0oI) {
                this.f5391oxoX = 0L;
            } else {
                DslAdapter itemDslAdapter = item.getItemDslAdapter();
                if (itemDslAdapter != null && (recyclerView = itemDslAdapter.get_recyclerView()) != null && recyclerView.getScrollState() == 2) {
                    this.f5391oxoX = 0L;
                } else {
                    this.f5391oxoX += this.f5389II0xO0;
                }
            }
            this.f5388I0Io = currentTimeMillis;
            return this.f5391oxoX;
        }
        return item.get_itemAnimateDelay();
    }

    public final long oxoX() {
        return this.f5388I0Io;
    }

    public final void xxIXOIIO(long j) {
        this.f5391oxoX = j;
    }
}
