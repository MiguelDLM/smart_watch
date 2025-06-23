package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.component.BleCache;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DialItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMWatchFaceType() != 0 && ProjectManager.f19822oIX0oI.Xo0() && bleCache.getMWatchFaceType() != 14) {
            z = false;
        } else {
            z = true;
        }
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_dial;
    }
}
