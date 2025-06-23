package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
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
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleHrWarningSettings;
import com.szabh.smable3.entity.BleTimeRange;
import java.util.ArrayList;

@kotlin.jvm.internal.XX({"SMAP\nHrMonitoringSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HrMonitoringSettingsActivity.kt\ncom/sma/smartv3/ui/device/HrMonitoringSettingsActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1#2:328\n*E\n"})
/* loaded from: classes12.dex */
public final class HrMonitoringSettingsActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int HR_MAX = 200;
    public static final int HR_MIN = 20;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mHighPopup;

    @OXOo.OOXIXo
    private final BleHrMonitoringSettings mHrMonitoringSettings;

    @OXOo.OOXIXo
    private final BleHrWarningSettings mHrWarningSettings;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mLowPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HrMonitoringSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO modePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$modePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HrMonitoringSettingsActivity.this.findViewById(R.id.ll_mode_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderReal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHeaderReal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HrMonitoringSettingsActivity.this.findViewById(R.id.item_header_real);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderSmart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHeaderSmart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HrMonitoringSettingsActivity.this.findViewById(R.id.item_header_smart);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$timePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HrMonitoringSettingsActivity.this.findViewById(R.id.ll_time_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HrMonitoringSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HrMonitoringSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HrMonitoringSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO warnPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$warnPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HrMonitoringSettingsActivity.this.findViewById(R.id.ll_warn_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderHigh$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHeaderHigh$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HrMonitoringSettingsActivity.this.findViewById(R.id.item_header_high);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHighValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHighValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HrMonitoringSettingsActivity.this.findViewById(R.id.item_high_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderLow$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemHeaderLow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HrMonitoringSettingsActivity.this.findViewById(R.id.item_header_low);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemLowValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$itemLowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HrMonitoringSettingsActivity.this.findViewById(R.id.item_low_value);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public HrMonitoringSettingsActivity() {
        BleCache bleCache = BleCache.INSTANCE;
        this.mHrMonitoringSettings = (BleHrMonitoringSettings) BleCache.getObjectNotNull$default(bleCache, BleKey.HR_MONITORING, BleHrMonitoringSettings.class, null, null, 12, null);
        this.mHrWarningSettings = (BleHrWarningSettings) BleCache.getObjectNotNull$default(bleCache, BleKey.HR_WARNING_SET, BleHrWarningSettings.class, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayPostEvent() {
        kotlinx.coroutines.xoIox.XO(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HrMonitoringSettingsActivity$delayPostEvent$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeaderHigh() {
        return (AbhSettingsHeader) this.itemHeaderHigh$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeaderLow() {
        return (AbhSettingsHeader) this.itemHeaderLow$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeaderReal() {
        return (AbhSettingsHeader) this.itemHeaderReal$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeaderSmart() {
        return (AbhSettingsHeader) this.itemHeaderSmart$delegate.getValue();
    }

    private final AbhSettingsItem getItemHighValue() {
        return (AbhSettingsItem) this.itemHighValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemInterval() {
        return (AbhSettingsItem) this.itemInterval$delegate.getValue();
    }

    private final AbhSettingsItem getItemLowValue() {
        return (AbhSettingsItem) this.itemLowValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTimeRange() {
        return (AbhSettingsItem) this.itemTimeRange$delegate.getValue();
    }

    private final View getModePanel() {
        return (View) this.modePanel$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final View getTimePanel() {
        return (View) this.timePanel$delegate.getValue();
    }

    private final View getWarnPanel() {
        return (View) this.warnPanel$delegate.getValue();
    }

    public static /* synthetic */ void onDeviceSetInterval$default(HrMonitoringSettingsActivity hrMonitoringSettingsActivity, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 15;
        }
        if ((i3 & 2) != 0) {
            i2 = R.array.hr_monitoring_intervals;
        }
        hrMonitoringSettingsActivity.onDeviceSetInterval(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHigh() {
        getItemHighValue().setMRightText(String.valueOf(this.mHrWarningSettings.getMHighValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLow() {
        getItemLowValue().setMRightText(String.valueOf(this.mHrWarningSettings.getMLowValue()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.heart_rate_monitoring);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.Ox0O() && productManager.OOOox()) {
            getTimePanel().setVisibility(0);
            AbhSettingsHeader itemHeader = getItemHeader();
            itemHeader.setChecked(productManager.oX0I0O(this.mHrMonitoringSettings.getMBleTimeRange().getMEnabled()));
            itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$1$1
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
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$1$1.1
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
                            BleHrMonitoringSettings bleHrMonitoringSettings;
                            BleHrMonitoringSettings bleHrMonitoringSettings2;
                            BleHrMonitoringSettings bleHrMonitoringSettings3;
                            BleHrMonitoringSettings bleHrMonitoringSettings4;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrMonitoringSettings = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            LogUtils.d(bleHrMonitoringSettings);
                            bleHrMonitoringSettings2 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            BleTimeRange mBleTimeRange = bleHrMonitoringSettings2.getMBleTimeRange();
                            bleHrMonitoringSettings3 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            mBleTimeRange.setMEnabled(bleHrMonitoringSettings3.getMBleTimeRange().getMEnabled() == 0 ? 255 : 0);
                            BleKey bleKey = BleKey.HR_MONITORING;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrMonitoringSettings4 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrMonitoringSettings4, false, false, 24, null);
                            HrMonitoringSettingsActivity.this.delayPostEvent();
                            LogUtils.d("HR_MONITORING");
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeader2 = HrMonitoringSettingsActivity.this.getItemHeader();
                    itemHeader2.setChecked(!z);
                }
            });
            getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mHrMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mHrMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mHrMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mHrMonitoringSettings.getMBleTimeRange().getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
            getItemInterval().setMRightText(TextConvertKt.xI(this.mHrMonitoringSettings.getMInterval()));
        } else {
            getTimePanel().setVisibility(8);
        }
        if (productManager.IXXIXx00I()) {
            getModePanel().setVisibility(0);
            AbhSettingsHeader itemHeaderReal = getItemHeaderReal();
            itemHeaderReal.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
            itemHeaderReal.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    AbhSettingsHeader itemHeaderReal2;
                    LogUtils.d("onCheckChange" + z);
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeaderReal2 = HrMonitoringSettingsActivity.this.getItemHeaderReal();
                    itemHeaderReal2.setChecked(!z);
                }
            });
            AbhSettingsHeader itemHeaderSmart = getItemHeaderSmart();
            itemHeaderSmart.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
            itemHeaderSmart.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$3$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    AbhSettingsHeader itemHeaderSmart2;
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$3$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeaderSmart2 = HrMonitoringSettingsActivity.this.getItemHeaderSmart();
                    itemHeaderSmart2.setChecked(!z);
                }
            });
        } else {
            getModePanel().setVisibility(8);
        }
        if (productManager.XIxO()) {
            getWarnPanel().setVisibility(0);
            AbhSettingsHeader itemHeaderHigh = getItemHeaderHigh();
            itemHeaderHigh.setChecked(oOXoIIIo.I0Io.II0xO0(this.mHrWarningSettings.getMHighSwitch()));
            itemHeaderHigh.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$4$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(final boolean z) {
                    AbhSettingsHeader itemHeaderHigh2;
                    HrMonitoringSettingsActivity.this.delayPostEvent();
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$4$1.1
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
                            BleHrWarningSettings bleHrWarningSettings;
                            BleHrWarningSettings bleHrWarningSettings2;
                            BleHrWarningSettings bleHrWarningSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrWarningSettings = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            LogUtils.d(bleHrWarningSettings);
                            bleHrWarningSettings2 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            bleHrWarningSettings2.setMHighSwitch(oOXoIIIo.I0Io.I0Io(z));
                            BleKey bleKey = BleKey.HR_WARNING_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrWarningSettings3 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrWarningSettings3, false, false, 24, null);
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeaderHigh2 = HrMonitoringSettingsActivity.this.getItemHeaderHigh();
                    itemHeaderHigh2.setChecked(!z);
                }
            });
            updateHigh();
            AbhSettingsHeader itemHeaderLow = getItemHeaderLow();
            itemHeaderLow.setChecked(oOXoIIIo.I0Io.II0xO0(this.mHrWarningSettings.getMLowSwitch()));
            itemHeaderLow.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$5$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(final boolean z) {
                    AbhSettingsHeader itemHeaderLow2;
                    HrMonitoringSettingsActivity.this.delayPostEvent();
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$initView$5$1.1
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
                            BleHrWarningSettings bleHrWarningSettings;
                            BleHrWarningSettings bleHrWarningSettings2;
                            BleHrWarningSettings bleHrWarningSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrWarningSettings = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            LogUtils.d(bleHrWarningSettings);
                            bleHrWarningSettings2 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            bleHrWarningSettings2.setMLowSwitch(oOXoIIIo.I0Io.I0Io(z));
                            BleKey bleKey = BleKey.HR_WARNING_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrWarningSettings3 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrWarningSettings3, false, false, 24, null);
                        }
                    }, 1, null)) {
                        return;
                    }
                    itemHeaderLow2 = HrMonitoringSettingsActivity.this.getItemHeaderLow();
                    itemHeaderLow2.setChecked(!z);
                }
            });
            updateLow();
            return;
        }
        getWarnPanel().setVisibility(8);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_hr_monitoring_settings;
    }

    public final void onDeviceSetInterval(final int i, int i2) {
        if (this.mIntervalPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, i2, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.monitoring_interval);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onDeviceSetInterval$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i3) {
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    final int i4 = i;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onDeviceSetInterval$1$1.1
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
                            BleHrMonitoringSettings bleHrMonitoringSettings;
                            AbhSettingsItem itemInterval;
                            BleHrMonitoringSettings bleHrMonitoringSettings2;
                            BleHrMonitoringSettings bleHrMonitoringSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrMonitoringSettings = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            bleHrMonitoringSettings.setMInterval(i4 * ((int) Math.pow(2.0d, i3)));
                            itemInterval = HrMonitoringSettingsActivity.this.getItemInterval();
                            bleHrMonitoringSettings2 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            itemInterval.setMRightText(TextConvertKt.xI(bleHrMonitoringSettings2.getMInterval()));
                            BleKey bleKey = BleKey.HR_MONITORING;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrMonitoringSettings3 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrMonitoringSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mIntervalPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mIntervalPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(Xx000oIo.X0o0xo.oIX0oI(this.mHrMonitoringSettings.getMInterval() / i));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetHighValue(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mHighPopup == null) {
            ArrayList arrayList = new ArrayList(181);
            for (int i = 0; i < 181; i++) {
                arrayList.add(String.valueOf(i + 20));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.heart_rate_limit);
            oX00O0xII.ooXIXxIX().setVisibility(8);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetHighValue$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetHighValue$2$1.1
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
                            BleHrWarningSettings bleHrWarningSettings;
                            BleHrWarningSettings bleHrWarningSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrWarningSettings = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            bleHrWarningSettings.setMHighValue(i2 + 20);
                            BleKey bleKey = BleKey.HR_WARNING_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrWarningSettings2 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrWarningSettings2, false, false, 24, null);
                            HrMonitoringSettingsActivity.this.updateHigh();
                        }
                    }, 1, null));
                }
            });
            this.mHighPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mHighPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mHrWarningSettings.getMHighValue() - 20);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (ProductManager.f20544oIX0oI.xIx()) {
            onDeviceSetInterval(30, R.array.hr_monitoring_intervals_ring);
        } else {
            onDeviceSetInterval$default(this, 0, 0, 3, null);
        }
    }

    public final void onSetLowValue(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mLowPopup == null) {
            ArrayList arrayList = new ArrayList(181);
            for (int i = 0; i < 181; i++) {
                arrayList.add(String.valueOf(i + 20));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.heart_rate_lower_limit);
            oX00O0xII.ooXIXxIX().setVisibility(8);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetLowValue$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetLowValue$2$1.1
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
                            BleHrWarningSettings bleHrWarningSettings;
                            BleHrWarningSettings bleHrWarningSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrWarningSettings = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            bleHrWarningSettings.setMLowValue(i2 + 20);
                            BleKey bleKey = BleKey.HR_WARNING_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrWarningSettings2 = HrMonitoringSettingsActivity.this.mHrWarningSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrWarningSettings2, false, false, 24, null);
                            HrMonitoringSettingsActivity.this.updateLow();
                        }
                    }, 1, null));
                }
            });
            this.mLowPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mLowPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mHrWarningSettings.getMLowValue() - 20);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final HrMonitoringSettingsActivity hrMonitoringSettingsActivity = HrMonitoringSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$onSetTimeRange$1$1.1
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
                            BleHrMonitoringSettings bleHrMonitoringSettings;
                            BleHrMonitoringSettings bleHrMonitoringSettings2;
                            AbhSettingsItem itemTimeRange;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleHrMonitoringSettings = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            BleTimeRange mBleTimeRange = bleHrMonitoringSettings.getMBleTimeRange();
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            mBleTimeRange.setMStartHour(i5);
                            mBleTimeRange.setMStartMinute(i6);
                            mBleTimeRange.setMEndHour(i7);
                            mBleTimeRange.setMEndMinute(i8);
                            BleKey bleKey = BleKey.HR_MONITORING;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleHrMonitoringSettings2 = HrMonitoringSettingsActivity.this.mHrMonitoringSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleHrMonitoringSettings2, false, false, 24, null);
                            itemTimeRange = HrMonitoringSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mHrMonitoringSettings.getMBleTimeRange().getMStartHour(), this.mHrMonitoringSettings.getMBleTimeRange().getMStartMinute(), this.mHrMonitoringSettings.getMBleTimeRange().getMEndHour(), this.mHrMonitoringSettings.getMBleTimeRange().getMEndMinute());
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
