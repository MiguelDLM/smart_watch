package com.sma.smartv3.ui.device.item;

import android.widget.ImageView;
import android.widget.TextView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class VoiceItem extends BaseDeviceItem {
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        setItemHidden(!productManager.XXoO0oX());
        TextView tvLeft = getTvLeft();
        if (tvLeft != null) {
            tvLeft.setText(productManager.x0OxxIOxX());
        }
        ImageView iv = getIv();
        if (iv != null) {
            iv.setImageResource(productManager.xXoOI00O());
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_voice;
    }
}
