package com.angcyo.dsladapter;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public abstract class BaseDslStateItem extends DslAdapterItem {

    @OXOo.oOoXoXO
    private Throwable itemErrorThrowable;

    @OXOo.OOXIXo
    private final HashMap<Integer, Integer> itemStateLayoutMap = new HashMap<>();
    private int itemState = -1;
    private boolean itemStateEnable = true;
    private boolean itemEnableRetry = true;

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> onItemStateChange = new Oox.x0xO0oo<Integer, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.BaseDslStateItem$onItemStateChange$1
        public final void invoke(int i, int i2) {
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> onBindStateLayout = new Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.BaseDslStateItem$onBindStateLayout$1
        public final void invoke(@OXOo.OOXIXo DslViewHolder dslViewHolder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslViewHolder, "<anonymous parameter 0>");
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
            invoke(dslViewHolder, num.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    public BaseDslStateItem() {
        setItemLayoutId(R.layout.item_base_state);
        setItemSpanCount(-1);
        setItemDragEnable(false);
        setItemSwipeEnable(false);
    }

    public void _onBindStateLayout(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.onBindStateLayout.invoke(itemHolder, Integer.valueOf(i));
    }

    public void _onItemStateChange(int i, int i2) {
        if (i != i2) {
            this.onItemStateChange.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final boolean getItemEnableRetry() {
        return this.itemEnableRetry;
    }

    @OXOo.oOoXoXO
    public final Throwable getItemErrorThrowable() {
        return this.itemErrorThrowable;
    }

    public final int getItemState() {
        return this.itemState;
    }

    public boolean getItemStateEnable() {
        return this.itemStateEnable;
    }

    @OXOo.OOXIXo
    public final HashMap<Integer, Integer> getItemStateLayoutMap() {
        return this.itemStateLayoutMap;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI> getOnBindStateLayout() {
        return this.onBindStateLayout;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<Integer, Integer, oXIO0o0XI> getOnItemStateChange() {
        return this.onItemStateChange;
    }

    public boolean isInStateLayout() {
        if (getItemEnable() && getItemStateEnable() && this.itemState > 0) {
            return true;
        }
        return false;
    }

    @Override // com.angcyo.dsladapter.DslAdapterItem
    public void onItemBind(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        super.onItemBind(itemHolder, i, adapterItem);
        itemHolder.clear();
        Integer num = this.itemStateLayoutMap.get(Integer.valueOf(this.itemState));
        ViewGroup group = itemHolder.group(R.id.item_wrap_layout);
        if (group != null) {
            if (num == null) {
                group.removeAllViews();
                return;
            }
            if (group.getChildCount() > 0) {
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(group.getChildAt(0).getTag(R.id.tag), num)) {
                    group.removeAllViews();
                }
                _onBindStateLayout(itemHolder, this.itemState);
            }
            LibExKt.I0X0x0oIo(group, num.intValue(), true);
            View childAt = group.getChildAt(0);
            childAt.setVisibility(0);
            childAt.setTag(R.id.tag, num);
            _onBindStateLayout(itemHolder, this.itemState);
        }
    }

    public final void setItemEnableRetry(boolean z) {
        this.itemEnableRetry = z;
    }

    public final void setItemErrorThrowable(@OXOo.oOoXoXO Throwable th) {
        this.itemErrorThrowable = th;
    }

    public final void setItemState(int i) {
        int i2 = this.itemState;
        this.itemState = i;
        _onItemStateChange(i2, i);
    }

    public void setItemStateEnable(boolean z) {
        this.itemStateEnable = z;
    }

    public final void setOnBindStateLayout(@OXOo.OOXIXo Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.onBindStateLayout = x0xo0oo;
    }

    public final void setOnItemStateChange(@OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.onItemStateChange = x0xo0oo;
    }

    @Override // com.angcyo.dsladapter.DslAdapterItem
    public void updateItemOnHaveDepend(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        updateItemDepend(filterParams);
    }
}
