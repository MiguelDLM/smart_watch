package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class GroupHeaderItem extends BaseDeviceItem {
    private final int titleRes;

    @oOoXoXO
    private TextView tvTitle;

    public GroupHeaderItem(int i) {
        this.titleRes = i;
    }

    @Override // com.sma.smartv3.ui.device.item.BaseDeviceItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.bindView(itemHolder);
        TextView textView = (TextView) itemHolder.v(R.id.tv_title);
        this.tvTitle = textView;
        if (textView != null) {
            textView.setText(this.titleRes);
        }
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    @oOoXoXO
    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_group_header;
    }

    public final void setTvTitle(@oOoXoXO TextView textView) {
        this.tvTitle = textView;
    }
}
