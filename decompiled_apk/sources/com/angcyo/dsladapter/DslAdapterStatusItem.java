package com.angcyo.dsladapter;

import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class DslAdapterStatusItem extends BaseDslStateItem {
    public static final int ADAPTER_STATUS_EMPTY = 1;
    public static final int ADAPTER_STATUS_ERROR = 3;
    public static final int ADAPTER_STATUS_LOADING = 2;
    public static final int ADAPTER_STATUS_NONE = 0;
    public static final int ADAPTER_STATUS_PRE_LOADING = 4;

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private boolean _isRefresh;

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslViewHolder, oXIO0o0XI> onRefresh = new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterStatusItem$onRefresh$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder) {
            invoke2(dslViewHolder);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo DslViewHolder it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            L.f5267oIX0oI.Oxx0xo("[DslAdapterStatusItem] 触发刷新");
        }
    };

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public DslAdapterStatusItem() {
        HashMap<Integer, Integer> itemStateLayoutMap = getItemStateLayoutMap();
        int i = R.layout.base_loading_layout;
        itemStateLayoutMap.put(4, Integer.valueOf(i));
        getItemStateLayoutMap().put(2, Integer.valueOf(i));
        getItemStateLayoutMap().put(3, Integer.valueOf(R.layout.base_error_layout));
        getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.base_empty_layout));
        setItemState(0);
        setItemUpdateFlag(false);
        setItemWidth(-1);
        setItemHeight(-1);
    }

    public void _notifyRefresh(@OXOo.OOXIXo final DslViewHolder itemHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        if (!this._isRefresh) {
            this._isRefresh = true;
            itemHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterStatusItem$_notifyRefresh$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DslAdapterStatusItem.this.getOnRefresh().invoke(itemHolder);
                }
            });
        }
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public void _onBindStateLayout(@OXOo.OOXIXo final DslViewHolder itemHolder, int i) {
        String string;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super._onBindStateLayout(itemHolder, i);
        if (getItemState() == 3) {
            TextView tv = itemHolder.tv(R.id.base_text_view);
            if (tv != null) {
                Throwable itemErrorThrowable = getItemErrorThrowable();
                if (itemErrorThrowable == null || (string = itemErrorThrowable.getMessage()) == null) {
                    string = itemHolder.getContext().getString(R.string.adapter_error);
                }
                tv.setText(string);
            }
            itemHolder.clickItem(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterStatusItem$_onBindStateLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (DslAdapterStatusItem.this.getItemEnableRetry() && DslAdapterStatusItem.this.getItemState() == 3) {
                        DslAdapterStatusItem.this._notifyRefresh(itemHolder);
                        DslAdapter itemDslAdapter = DslAdapterStatusItem.this.getItemDslAdapter();
                        if (itemDslAdapter != null) {
                            itemDslAdapter.updateAdapterStatus(2);
                        }
                    }
                }
            });
            itemHolder.click(R.id.base_retry_button, new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterStatusItem$_onBindStateLayout$2
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DslViewHolder dslViewHolder = DslViewHolder.this;
                    dslViewHolder.clickView(dslViewHolder.itemView);
                }
            });
            return;
        }
        if (getItemState() == 2) {
            _notifyRefresh(itemHolder);
        } else {
            itemHolder.itemView.setClickable(false);
        }
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public void _onItemStateChange(int i, int i2) {
        if (i != i2 && i2 != 2) {
            this._isRefresh = false;
        }
        super._onItemStateChange(i, i2);
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslViewHolder, oXIO0o0XI> getOnRefresh() {
        return this.onRefresh;
    }

    public final boolean get_isRefresh() {
        return this._isRefresh;
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem, com.angcyo.dsladapter.DslAdapterItem
    public void onItemBind(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        super.onItemBind(itemHolder, i, adapterItem);
    }

    public final void setOnRefresh(@OXOo.OOXIXo Oox.oOoXoXO<? super DslViewHolder, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.onRefresh = oooxoxo;
    }

    public final void set_isRefresh(boolean z) {
        this._isRefresh = z;
    }
}
