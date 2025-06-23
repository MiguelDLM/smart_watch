package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.component.BleConnector;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ClassicPairItem extends BaseDslItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        if (ProjectManager.f19822oIX0oI.OX()) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isBound() && !bleConnector.isBoundClassic() && ProductManager.f20544oIX0oI.OOOI()) {
                z = false;
                setItemHidden(z);
            }
        }
        z = true;
        setItemHidden(z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_classic_pair;
    }
}
