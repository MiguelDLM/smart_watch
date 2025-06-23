package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oOoXoXO;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nUpdateDataConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateDataConfig.kt\ncom/angcyo/dsladapter/data/UpdateDataConfigKt$updateSingleDataIndex$3\n*L\n1#1,422:1\n*E\n"})
/* loaded from: classes7.dex */
public final class UpdateDataConfigKt$updateSingleDataIndex$3 extends Lambda implements oOoXoXO<UpdateDataConfig, oXIO0o0XI> {
    final /* synthetic */ oOoXoXO<UpdateDataConfig, oXIO0o0XI> $action;
    final /* synthetic */ List<Object> $dataList;
    final /* synthetic */ IXxxXO<Item, Object, Integer, oXIO0o0XI> $initItem;
    final /* synthetic */ int $requestPage;
    final /* synthetic */ int $requestPageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpdateDataConfigKt$updateSingleDataIndex$3(int i, int i2, List<? extends Object> list, oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> oooxoxo, IXxxXO<? super Item, Object, ? super Integer, oXIO0o0XI> iXxxXO) {
        super(1);
        this.$requestPage = i;
        this.$requestPageSize = i2;
        this.$dataList = list;
        this.$action = oooxoxo;
        this.$initItem = iXxxXO;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(UpdateDataConfig updateDataConfig) {
        invoke2(updateDataConfig);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OOXIXo UpdateDataConfig updateData) {
        IIX0o.x0xO0oo(updateData, "$this$updateData");
        updateData.Oxx0xo(this.$requestPage);
        updateData.oO(this.$requestPageSize);
        updateData.Oo(this.$dataList);
        IIX0o.xoXoI();
        final IXxxXO<Item, Object, Integer, oXIO0o0XI> iXxxXO = this.$initItem;
        updateData.IXxxXO(new IXxxXO<DslAdapterItem, Object, Integer, DslAdapterItem>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateSingleDataIndex$3.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ DslAdapterItem invoke(DslAdapterItem dslAdapterItem, Object obj, Integer num) {
                return invoke(dslAdapterItem, obj, num.intValue());
            }

            @OXOo.oOoXoXO
            public final DslAdapterItem invoke(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO final Object obj, final int i) {
                IIX0o.OxI(4, "Item");
                IIX0o.xoXoI();
                final IXxxXO<Item, Object, Integer, oXIO0o0XI> iXxxXO2 = iXxxXO;
                return UpdateDataConfigKt.x0xO0oo(DslAdapterItem.class, dslAdapterItem, new oOoXoXO<Item, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt.updateSingleDataIndex.3.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                        invoke((DslAdapterItem) obj2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TItem;)V */
                    public final void invoke(@OOXIXo DslAdapterItem updateOrCreateItemByClass) {
                        IIX0o.x0xO0oo(updateOrCreateItemByClass, "$this$updateOrCreateItemByClass");
                        iXxxXO2.invoke(updateOrCreateItemByClass, obj, Integer.valueOf(i));
                    }
                });
            }
        });
        this.$action.invoke(updateData);
    }
}
