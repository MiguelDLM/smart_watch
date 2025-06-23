package com.angcyo.dsladapter;

import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class DslLoadMoreItem extends BaseDslStateItem {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int LOAD_MORE_ERROR = 10;
    public static final int LOAD_MORE_LOADING = 1;
    public static final int LOAD_MORE_NORMAL = 0;
    public static final int LOAD_MORE_NO_MORE = 2;
    public static final int _LOAD_MORE_RETRY = 11;
    private boolean _isLoadMore;
    private boolean itemStateEnable;

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslViewHolder, oXIO0o0XI> onLoadMore = new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslLoadMoreItem$onLoadMore$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder) {
            invoke2(dslViewHolder);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo DslViewHolder it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            L.f5267oIX0oI.Oxx0xo("[DslLoadMoreItem] 触发加载更多");
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

    public DslLoadMoreItem() {
        HashMap<Integer, Integer> itemStateLayoutMap = getItemStateLayoutMap();
        int i = R.layout.base_loading_layout;
        itemStateLayoutMap.put(0, Integer.valueOf(i));
        getItemStateLayoutMap().put(1, Integer.valueOf(i));
        getItemStateLayoutMap().put(2, Integer.valueOf(R.layout.base_no_more_layout));
        HashMap<Integer, Integer> itemStateLayoutMap2 = getItemStateLayoutMap();
        int i2 = R.layout.base_error_layout;
        itemStateLayoutMap2.put(10, Integer.valueOf(i2));
        getItemStateLayoutMap().put(11, Integer.valueOf(i2));
        setItemWidth(-1);
        setItemHeight(-2);
        setItemUpdateFlag(false);
        setThisAreContentsTheSame(new Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslLoadMoreItem.1
            @Override // Oox.Oxx0xo
            public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, Integer num, Integer num2) {
                return invoke(dslAdapterItem, dslAdapterItem2, num.intValue(), num2.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapterItem dslAdapterItem2, int i3, int i4) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem2, "<anonymous parameter 1>");
                return Boolean.FALSE;
            }
        });
    }

    public void _notifyLoadMore(@OXOo.OOXIXo final DslViewHolder itemHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        setItemState(1);
        if (!this._isLoadMore) {
            this._isLoadMore = true;
            itemHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslLoadMoreItem$_notifyLoadMore$1
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
                    DslLoadMoreItem.this.getOnLoadMore().invoke(itemHolder);
                }
            });
        }
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public void _onBindStateLayout(@OXOo.OOXIXo final DslViewHolder itemHolder, int i) {
        String string;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super._onBindStateLayout(itemHolder, i);
        if (getItemStateEnable()) {
            if (getItemState() != 0 && getItemState() != 1) {
                if (getItemState() == 10) {
                    TextView tv = itemHolder.tv(R.id.base_text_view);
                    if (tv != null) {
                        Throwable itemErrorThrowable = getItemErrorThrowable();
                        if (itemErrorThrowable == null || (string = itemErrorThrowable.getMessage()) == null) {
                            string = itemHolder.getContext().getString(R.string.adapter_error);
                        }
                        tv.setText(string);
                    }
                    itemHolder.clickItem(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslLoadMoreItem$_onBindStateLayout$1
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
                            if (DslLoadMoreItem.this.getItemEnableRetry()) {
                                if (DslLoadMoreItem.this.getItemState() == 10 || DslLoadMoreItem.this.getItemState() == 11) {
                                    DslLoadMoreItem.this._notifyLoadMore(itemHolder);
                                    DslAdapterItem.updateAdapterItem$default(DslLoadMoreItem.this, null, false, 3, null);
                                }
                            }
                        }
                    });
                    return;
                }
                itemHolder.itemView.setClickable(false);
                return;
            }
            _notifyLoadMore(itemHolder);
            return;
        }
        itemHolder.itemView.setClickable(false);
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public void _onItemStateChange(int i, int i2) {
        if (i != i2 && i2 != 1) {
            this._isLoadMore = false;
        }
        super._onItemStateChange(i, i2);
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public boolean getItemStateEnable() {
        return this.itemStateEnable;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslViewHolder, oXIO0o0XI> getOnLoadMore() {
        return this.onLoadMore;
    }

    public final boolean get_isLoadMore() {
        return this._isLoadMore;
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem, com.angcyo.dsladapter.DslAdapterItem
    public void onItemBind(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        super.onItemBind(itemHolder, i, adapterItem);
    }

    @Override // com.angcyo.dsladapter.DslAdapterItem
    public void onItemViewDetachedToWindow(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.onItemViewDetachedToWindow(itemHolder, i);
        if (getItemStateEnable() && getItemState() == 10) {
            setItemState(11);
        }
    }

    @Override // com.angcyo.dsladapter.BaseDslStateItem
    public void setItemStateEnable(boolean z) {
        this.itemStateEnable = z;
        setItemState(0);
    }

    public final void setOnLoadMore(@OXOo.OOXIXo Oox.oOoXoXO<? super DslViewHolder, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.onLoadMore = oooxoxo;
    }

    public final void set_isLoadMore(boolean z) {
        this._isLoadMore = z;
    }
}
