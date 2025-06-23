package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class SingleDataUpdateKt {
    public static /* synthetic */ void I0Io(DslAdapter dslAdapter, Class cls, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.SingleDataUpdateKt$updateItem$1
                public final void invoke(@OOXIXo Object obj2) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        II0xO0(dslAdapter, cls, oooxoxo);
    }

    public static final <Item extends DslAdapterItem> void II0xO0(@OOXIXo DslAdapter dslAdapter, @OOXIXo Class<Item> itemClass, @OOXIXo oOoXoXO<? super Item, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(initItem, "initItem");
        DslAdapterItem xXxxox0I2 = DslAdapterExKt.xXxxox0I(dslAdapter, itemClass, true);
        if (xXxxox0I2 != null) {
            xXxxox0I2.setItemUpdateFlag(true);
            initItem.invoke(xXxxox0I2);
            DslAdapterItem.updateItemDepend$default(xXxxox0I2, null, 1, null);
        }
    }

    public static final void oIX0oI(@OOXIXo DslAdapter dslAdapter, @OOXIXo oOoXoXO<? super SingleDataUpdate, oXIO0o0XI> update) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(update, "update");
        SingleDataUpdate singleDataUpdate = new SingleDataUpdate(dslAdapter);
        update.invoke(singleDataUpdate);
        singleDataUpdate.XO();
    }
}
