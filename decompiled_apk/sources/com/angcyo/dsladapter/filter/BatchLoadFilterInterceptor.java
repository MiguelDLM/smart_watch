package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class BatchLoadFilterInterceptor extends X0o0xo implements Runnable {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @oOoXoXO
    public DslAdapter f5367oI0IIXIo;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final Handler f5364Oo = new Handler(Looper.getMainLooper());

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f5363IXxxXO = 1;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f5365Oxx0xo = 16;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f5366OxxIIOOXO = -1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public x0xO0oo<? super Integer, ? super List<? extends DslAdapterItem>, Integer> f5362IIXOooo = new x0xO0oo<Integer, List<? extends DslAdapterItem>, Integer>() { // from class: com.angcyo.dsladapter.filter.BatchLoadFilterInterceptor$loadInterpolator$1
        {
            super(2);
        }

        @OOXIXo
        public final Integer invoke(int i, @OOXIXo List<? extends DslAdapterItem> list) {
            IIX0o.x0xO0oo(list, "<anonymous parameter 1>");
            return Integer.valueOf(BatchLoadFilterInterceptor.this.X0o0xo());
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, List<? extends DslAdapterItem> list) {
            return invoke(num.intValue(), list);
        }
    };

    public final long I0Io() {
        return this.f5365Oxx0xo;
    }

    public final int II0XooXoX() {
        return this.f5366OxxIIOOXO;
    }

    @Override // com.angcyo.dsladapter.filter.xxIXOIIO
    @OOXIXo
    public List<DslAdapterItem> II0xO0(@OOXIXo Oxx0IOOO chain) {
        int intValue;
        IIX0o.x0xO0oo(chain, "chain");
        DslAdapter xxIXOIIO2 = chain.xxIXOIIO();
        if (!IIX0o.Oxx0IOOO(this.f5367oI0IIXIo, xxIXOIIO2)) {
            this.f5366OxxIIOOXO = -1;
            this.f5364Oo.removeCallbacks(this);
        }
        this.f5367oI0IIXIo = xxIXOIIO2;
        List<DslAdapterItem> x0XOIxOo2 = chain.x0XOIxOo();
        if (x0XOIxOo2.size() > this.f5366OxxIIOOXO + 1 && !xxIXOIIO2.isAdapterStatus()) {
            int i = this.f5366OxxIIOOXO;
            if (i < 0) {
                intValue = this.f5362IIXOooo.invoke(Integer.valueOf(i), x0XOIxOo2).intValue();
            } else {
                intValue = this.f5362IIXOooo.invoke(Integer.valueOf(i), x0XOIxOo2).intValue() + i + 1;
            }
            ArrayList arrayList = new ArrayList((intValue / 4) + intValue);
            for (int i2 = 0; i2 < intValue; i2++) {
                arrayList.add(x0XOIxOo2.get(i2));
            }
            this.f5366OxxIIOOXO = intValue - 1;
            if (x0XOIxOo2.size() > this.f5366OxxIIOOXO + 1) {
                this.f5364Oo.postDelayed(this, this.f5365Oxx0xo);
            }
            return arrayList;
        }
        return x0XOIxOo2;
    }

    public final void OOXIXo(int i) {
        this.f5363IXxxXO = i;
    }

    @oOoXoXO
    public final DslAdapter Oxx0IOOO() {
        return this.f5367oI0IIXIo;
    }

    public final int X0o0xo() {
        return this.f5363IXxxXO;
    }

    @OOXIXo
    public final Handler XO() {
        return this.f5364Oo;
    }

    public final void oOoXoXO(@oOoXoXO DslAdapter dslAdapter) {
        this.f5367oI0IIXIo = dslAdapter;
    }

    public final void ooOOo0oXI(int i) {
        this.f5366OxxIIOOXO = i;
    }

    @OOXIXo
    public final x0xO0oo<Integer, List<? extends DslAdapterItem>, Integer> oxoX() {
        return this.f5362IIXOooo;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView;
        DslAdapter dslAdapter = this.f5367oI0IIXIo;
        if (dslAdapter != null && (recyclerView = dslAdapter.get_recyclerView()) != null && ViewCompat.isAttachedToWindow(recyclerView)) {
            DslAdapter.updateItemDepend$default(dslAdapter, null, 1, null);
        }
    }

    public final void xoIox(@OOXIXo x0xO0oo<? super Integer, ? super List<? extends DslAdapterItem>, Integer> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.f5362IIXOooo = x0xo0oo;
    }

    public final void xxIXOIIO(long j) {
        this.f5365Oxx0xo = j;
    }
}
