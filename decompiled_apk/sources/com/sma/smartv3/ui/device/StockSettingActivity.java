package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.AbhSettingsItem;

/* loaded from: classes12.dex */
public final class StockSettingActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mSetColorTypePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.StockSettingActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return StockSettingActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemColorType$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.StockSettingActivity$itemColorType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) StockSettingActivity.this.findViewById(R.id.item_colortype);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final String getColorText(int i) {
        String str = getResources().getStringArray(R.array.colortype)[i];
        kotlin.jvm.internal.IIX0o.oO(str, "get(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemColorType() {
        return (AbhSettingsItem) this.itemColorType$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.stock_settings);
        getItemColorType().setMRightText(getColorText(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX)));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_stock_settings;
    }

    public final void onSetColorType(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mSetColorTypePopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.colortype, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.colortype);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.StockSettingActivity$onSetColorType$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    AbhSettingsItem itemColorType;
                    String colorText;
                    itemColorType = StockSettingActivity.this.getItemColorType();
                    colorText = StockSettingActivity.this.getColorText(i);
                    itemColorType.setMRightText(colorText);
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX, i);
                    return Boolean.TRUE;
                }
            });
            this.mSetColorTypePopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mSetColorTypePopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24490xoIxX));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
