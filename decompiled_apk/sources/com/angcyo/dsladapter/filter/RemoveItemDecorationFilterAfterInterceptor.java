package com.angcyo.dsladapter.filter;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nRemoveItemDecorationFilterAfterInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoveItemDecorationFilterAfterInterceptor.kt\ncom/angcyo/dsladapter/filter/RemoveItemDecorationFilterAfterInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1864#2,3:45\n*S KotlinDebug\n*F\n+ 1 RemoveItemDecorationFilterAfterInterceptor.kt\ncom/angcyo/dsladapter/filter/RemoveItemDecorationFilterAfterInterceptor\n*L\n38#1:45,3\n*E\n"})
/* loaded from: classes7.dex */
public final class RemoveItemDecorationFilterAfterInterceptor extends oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5378II0xO0 = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public IXxxXO<? super XO, ? super Integer, ? super DslAdapterItem, oXIO0o0XI> f5377I0Io = new IXxxXO<XO, Integer, DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.filter.RemoveItemDecorationFilterAfterInterceptor$removeConfig$1
        public final void invoke(@OOXIXo XO xo2, int i, @OOXIXo DslAdapterItem dslAdapterItem) {
            IIX0o.x0xO0oo(xo2, "<anonymous parameter 0>");
            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
        }

        @Override // Oox.IXxxXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(XO xo2, Integer num, DslAdapterItem dslAdapterItem) {
            invoke(xo2, num.intValue(), dslAdapterItem);
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    public final int I0Io() {
        return this.f5378II0xO0;
    }

    @Override // com.angcyo.dsladapter.filter.II0XooXoX
    @OOXIXo
    public List<DslAdapterItem> II0xO0(@OOXIXo XO chain) {
        IIX0o.x0xO0oo(chain, "chain");
        DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.XxXX(chain.oOoXoXO());
        int i = 0;
        if (dslAdapterItem != null) {
            if (this.f5378II0xO0 == 1) {
                dslAdapterItem.setItemTopInsert(0);
            } else {
                dslAdapterItem.setItemLeftInsert(0);
            }
        }
        DslAdapterItem dslAdapterItem2 = (DslAdapterItem) CollectionsKt___CollectionsKt.xX0ox(chain.oOoXoXO());
        if (dslAdapterItem2 != null) {
            if (this.f5378II0xO0 == 1) {
                dslAdapterItem2.setItemBottomInsert(0);
            } else {
                dslAdapterItem2.setItemRightInsert(0);
            }
        }
        for (Object obj : chain.oOoXoXO()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            this.f5377I0Io.invoke(chain, Integer.valueOf(i), (DslAdapterItem) obj);
            i = i2;
        }
        return chain.oOoXoXO();
    }

    public final void X0o0xo(int i) {
        this.f5378II0xO0 = i;
    }

    public final void XO(@OOXIXo IXxxXO<? super XO, ? super Integer, ? super DslAdapterItem, oXIO0o0XI> iXxxXO) {
        IIX0o.x0xO0oo(iXxxXO, "<set-?>");
        this.f5377I0Io = iXxxXO;
    }

    @OOXIXo
    public final IXxxXO<XO, Integer, DslAdapterItem, oXIO0o0XI> oxoX() {
        return this.f5377I0Io;
    }
}
