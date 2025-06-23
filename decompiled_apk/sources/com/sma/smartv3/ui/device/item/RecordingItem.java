package com.sma.smartv3.ui.device.item;

import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class RecordingItem extends BaseDeviceItem {
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!ProjectManager.f19822oIX0oI.xxIO());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_sync_recording;
    }
}
