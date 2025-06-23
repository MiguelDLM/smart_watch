package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MeasureUnitItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProjectManager.f19822oIX0oI.OO0x0xX());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_measure_unit;
    }
}
