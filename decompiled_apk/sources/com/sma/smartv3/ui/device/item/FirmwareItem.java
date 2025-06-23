package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.widget.ImageView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFirmwareItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareItem.kt\ncom/sma/smartv3/ui/device/item/FirmwareItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,40:1\n15#2:41\n*S KotlinDebug\n*F\n+ 1 FirmwareItem.kt\ncom/sma/smartv3/ui/device/item/FirmwareItem\n*L\n31#1:41\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareItem extends BaseDslItem {
    private final boolean initEvent = true;

    @oOoXoXO
    private ImageView ivRemind;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.ivRemind = (ImageView) itemHolder.v(R.id.ivRemind);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        setItemHidden(!ProductManager.f20544oIX0oI.xOoOIoI());
        FirmwareVersion firmwareVersion = (FirmwareVersion) new Gson().fromJson(Xo0.f24349oIX0oI.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        ImageView imageView = this.ivRemind;
        if (imageView != null) {
            if (firmwareVersion != null) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.device_item_firmware;
    }

    @XO0.XO(tag = x0xO0oo.f24613XOxIOxOx)
    public final void onFirmwareVersionChanged(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onFirmwareVersionChanged");
        initView();
    }
}
