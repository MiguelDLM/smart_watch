package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.TimeRangePopup;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleEcgSettings;
import com.szabh.smable3.entity.BleTimeRange;

/* loaded from: classes12.dex */
public final class EcgMonitoringSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return EcgMonitoringSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$timePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return EcgMonitoringSettingsActivity.this.findViewById(R.id.ll_time_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) EcgMonitoringSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) EcgMonitoringSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) EcgMonitoringSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final BleEcgSettings mEcgMonitoringSettings = (BleEcgSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.ECG_SET, BleEcgSettings.class, null, null, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemInterval() {
        return (AbhSettingsItem) this.itemInterval$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTimeRange() {
        return (AbhSettingsItem) this.itemTimeRange$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final View getTimePanel() {
        return (View) this.timePanel$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.electrocardiogram_monitoring);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.I0()) {
            getTimePanel().setVisibility(0);
            AbhSettingsHeader itemHeader = getItemHeader();
            itemHeader.setChecked(productManager.oX0I0O(this.mEcgMonitoringSettings.getMBleTimeRange().getMEnabled()));
            itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$initView$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    AbhSettingsHeader itemHeader2;
                    final EcgMonitoringSettingsActivity ecgMonitoringSettingsActivity = EcgMonitoringSettingsActivity.this;
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$initView$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            BleEcgSettings bleEcgSettings;
                            BleEcgSettings bleEcgSettings2;
                            BleEcgSettings bleEcgSettings3;
                            BleEcgSettings bleEcgSettings4;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleEcgSettings = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            LogUtils.d(bleEcgSettings);
                            bleEcgSettings2 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            BleTimeRange mBleTimeRange = bleEcgSettings2.getMBleTimeRange();
                            bleEcgSettings3 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            mBleTimeRange.setMEnabled(bleEcgSettings3.getMBleTimeRange().getMEnabled() == 0 ? 255 : 0);
                            BleKey bleKey = BleKey.ECG_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleEcgSettings4 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleEcgSettings4, false, false, 24, null);
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24665xoXoI, null, 2, null);
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeader2 = EcgMonitoringSettingsActivity.this.getItemHeader();
                    itemHeader2.setChecked(!z);
                }
            });
            getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mEcgMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mEcgMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mEcgMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mEcgMonitoringSettings.getMBleTimeRange().getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
            getItemInterval().setMRightText(TextConvertKt.xI(this.mEcgMonitoringSettings.getMInterval()));
            return;
        }
        getTimePanel().setVisibility(8);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ecg_monitoring_settings;
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mIntervalPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.hr_monitoring_intervals, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.monitoring_interval);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$onSetInterval$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i) {
                    final EcgMonitoringSettingsActivity ecgMonitoringSettingsActivity = EcgMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$onSetInterval$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            BleEcgSettings bleEcgSettings;
                            AbhSettingsItem itemInterval;
                            BleEcgSettings bleEcgSettings2;
                            BleEcgSettings bleEcgSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleEcgSettings = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            bleEcgSettings.setMInterval(((int) Math.pow(2.0d, i)) * 15);
                            itemInterval = EcgMonitoringSettingsActivity.this.getItemInterval();
                            bleEcgSettings2 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            itemInterval.setMRightText(TextConvertKt.xI(bleEcgSettings2.getMInterval()));
                            BleKey bleKey = BleKey.ECG_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleEcgSettings3 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleEcgSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mIntervalPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mIntervalPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(Xx000oIo.X0o0xo.oIX0oI(this.mEcgMonitoringSettings.getMInterval() / 15));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final EcgMonitoringSettingsActivity ecgMonitoringSettingsActivity = EcgMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EcgMonitoringSettingsActivity$onSetTimeRange$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            BleEcgSettings bleEcgSettings;
                            BleEcgSettings bleEcgSettings2;
                            AbhSettingsItem itemTimeRange;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleEcgSettings = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            BleTimeRange mBleTimeRange = bleEcgSettings.getMBleTimeRange();
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            mBleTimeRange.setMStartHour(i5);
                            mBleTimeRange.setMStartMinute(i6);
                            mBleTimeRange.setMEndHour(i7);
                            mBleTimeRange.setMEndMinute(i8);
                            BleKey bleKey = BleKey.ECG_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleEcgSettings2 = EcgMonitoringSettingsActivity.this.mEcgMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleEcgSettings2, false, false, 24, null);
                            itemTimeRange = EcgMonitoringSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mEcgMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mEcgMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mEcgMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mEcgMonitoringSettings.getMBleTimeRange().getMEndMinute());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            timeRangePopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
