package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.TimeRangePopup;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleTemperatureDetecting;
import com.szabh.smable3.entity.BleTimeRange;

/* loaded from: classes12.dex */
public final class TempMonitoringSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return TempMonitoringSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TempMonitoringSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) TempMonitoringSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) TempMonitoringSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final BleTemperatureDetecting mTempMonitoringSettings = (BleTemperatureDetecting) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.TEMPERATURE_DETECTING, BleTemperatureDetecting.class, null, null, 12, null);

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

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.temp_monitoring);
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mTempMonitoringSettings.getMBleTimeRange().getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$initView$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(final boolean z) {
                AbhSettingsHeader itemHeader2;
                final TempMonitoringSettingsActivity tempMonitoringSettingsActivity = TempMonitoringSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$initView$1$1.1
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
                        BleTemperatureDetecting bleTemperatureDetecting;
                        BleTemperatureDetecting bleTemperatureDetecting2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleTemperatureDetecting = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                        bleTemperatureDetecting.getMBleTimeRange().setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        BleKey bleKey = BleKey.TEMPERATURE_DETECTING;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleTemperatureDetecting2 = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTemperatureDetecting2, false, false, 24, null);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24624o00, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = TempMonitoringSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mTempMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mTempMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mTempMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mTempMonitoringSettings.getMBleTimeRange().getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
        getItemInterval().setMRightText(intervalValueToText(Xx000oIo.X0o0xo.oIX0oI(this.mTempMonitoringSettings.getMInterval() / 60)));
    }

    @OXOo.OOXIXo
    public final String intervalValueToText(int i) {
        String str = getResources().getStringArray(R.array.temp_monitoring_intervals)[i];
        kotlin.jvm.internal.IIX0o.oO(str, "get(...)");
        return str;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_temp_monitoring_settings;
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mIntervalPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.temp_monitoring_intervals, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.monitoring_interval);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$onSetInterval$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i) {
                    final TempMonitoringSettingsActivity tempMonitoringSettingsActivity = TempMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$onSetInterval$1$1.1
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
                            BleTemperatureDetecting bleTemperatureDetecting;
                            AbhSettingsItem itemInterval;
                            BleTemperatureDetecting bleTemperatureDetecting2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleTemperatureDetecting = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                            bleTemperatureDetecting.setMInterval(((int) Math.pow(2.0d, i)) * 60);
                            itemInterval = TempMonitoringSettingsActivity.this.getItemInterval();
                            itemInterval.setMRightText(TempMonitoringSettingsActivity.this.intervalValueToText(i));
                            BleKey bleKey = BleKey.TEMPERATURE_DETECTING;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleTemperatureDetecting2 = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTemperatureDetecting2, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mIntervalPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mIntervalPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(Xx000oIo.X0o0xo.oIX0oI(this.mTempMonitoringSettings.getMInterval() / 60));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final TempMonitoringSettingsActivity tempMonitoringSettingsActivity = TempMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TempMonitoringSettingsActivity$onSetTimeRange$1$1.1
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
                            BleTemperatureDetecting bleTemperatureDetecting;
                            BleTemperatureDetecting bleTemperatureDetecting2;
                            AbhSettingsItem itemTimeRange;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleTemperatureDetecting = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                            BleTimeRange mBleTimeRange = bleTemperatureDetecting.getMBleTimeRange();
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            mBleTimeRange.setMStartHour(i5);
                            mBleTimeRange.setMStartMinute(i6);
                            mBleTimeRange.setMEndHour(i7);
                            mBleTimeRange.setMEndMinute(i8);
                            BleKey bleKey = BleKey.TEMPERATURE_DETECTING;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleTemperatureDetecting2 = TempMonitoringSettingsActivity.this.mTempMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTemperatureDetecting2, false, false, 24, null);
                            itemTimeRange = TempMonitoringSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mTempMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mTempMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mTempMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mTempMonitoringSettings.getMBleTimeRange().getMEndMinute());
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
