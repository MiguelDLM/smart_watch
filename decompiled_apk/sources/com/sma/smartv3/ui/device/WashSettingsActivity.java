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
import com.szabh.smable3.entity.BleRepeat;
import com.szabh.smable3.entity.BleWashSettings;
import java.util.Set;

/* loaded from: classes12.dex */
public final class WashSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoxXI mRepeatPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WashSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) WashSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) WashSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemRepeat$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$itemRepeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) WashSettingsActivity.this.findViewById(R.id.item_repeat);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) WashSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final BleWashSettings mWashSettings = (BleWashSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.WASH_SET, BleWashSettings.class, null, null, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemInterval() {
        return (AbhSettingsItem) this.itemInterval$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemRepeat() {
        return (AbhSettingsItem) this.itemRepeat$delegate.getValue();
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
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.wash_set);
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mWashSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$initView$1$1
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
                final WashSettingsActivity washSettingsActivity = WashSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$initView$1$1.1
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
                        BleWashSettings bleWashSettings;
                        BleWashSettings bleWashSettings2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleWashSettings = WashSettingsActivity.this.mWashSettings;
                        bleWashSettings.setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        BleKey bleKey = BleKey.WASH_SET;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleWashSettings2 = WashSettingsActivity.this.mWashSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleWashSettings2, false, false, 24, null);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24622XxX0x0xxx, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = WashSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mWashSettings.getMStartHour(), this.mWashSettings.getMStartMinute(), this.mWashSettings.getMEndHour(), this.mWashSettings.getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
        getItemRepeat().setMRightText(TextConvertKt.Io(this.mWashSettings.getMRepeat()));
        getItemInterval().setMRightText(TextConvertKt.xI(this.mWashSettings.getMInterval()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_wash_settings;
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mIntervalPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.wash_set_intervals, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.interval);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetInterval$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i) {
                    final WashSettingsActivity washSettingsActivity = WashSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetInterval$1$1.1
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
                            BleWashSettings bleWashSettings;
                            AbhSettingsItem itemInterval;
                            BleWashSettings bleWashSettings2;
                            BleWashSettings bleWashSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleWashSettings = WashSettingsActivity.this.mWashSettings;
                            bleWashSettings.setMInterval(((int) Math.pow(2.0d, i)) * 30);
                            itemInterval = WashSettingsActivity.this.getItemInterval();
                            bleWashSettings2 = WashSettingsActivity.this.mWashSettings;
                            itemInterval.setMRightText(TextConvertKt.xI(bleWashSettings2.getMInterval()));
                            BleKey bleKey = BleKey.WASH_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleWashSettings3 = WashSettingsActivity.this.mWashSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleWashSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mIntervalPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mIntervalPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(Xx000oIo.X0o0xo.oIX0oI(this.mWashSettings.getMInterval() / 30));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetRepeat(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mRepeatPopup == null) {
            com.sma.smartv3.pop.xoxXI xoxxi = new com.sma.smartv3.pop.xoxXI(this, R.array.weekdays_s);
            xoxxi.IoOoX(R.string.repeat);
            xoxxi.oo(new Oox.oOoXoXO<Set<? extends Integer>, Boolean>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetRepeat$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Set<? extends Integer> set) {
                    return invoke2((Set<Integer>) set);
                }

                @OXOo.OOXIXo
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(@OXOo.OOXIXo final Set<Integer> picked) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picked, "picked");
                    final WashSettingsActivity washSettingsActivity = WashSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetRepeat$1$1.1
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
                            BleWashSettings bleWashSettings;
                            AbhSettingsItem itemRepeat;
                            BleWashSettings bleWashSettings2;
                            BleWashSettings bleWashSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleWashSettings = WashSettingsActivity.this.mWashSettings;
                            bleWashSettings.setMRepeat(BleRepeat.indicesToRepeat$default(BleRepeat.INSTANCE, picked, null, 2, null));
                            itemRepeat = WashSettingsActivity.this.getItemRepeat();
                            bleWashSettings2 = WashSettingsActivity.this.mWashSettings;
                            itemRepeat.setMRightText(TextConvertKt.Io(bleWashSettings2.getMRepeat()));
                            BleKey bleKey = BleKey.WASH_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleWashSettings3 = WashSettingsActivity.this.mWashSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleWashSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mRepeatPopup = xoxxi;
        }
        com.sma.smartv3.pop.xoxXI xoxxi2 = this.mRepeatPopup;
        if (xoxxi2 != null) {
            xoxxi2.oo0xXOI0I(BleRepeat.toIndices$default(BleRepeat.INSTANCE, this.mWashSettings.getMRepeat(), null, 2, null));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoxxi2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final WashSettingsActivity washSettingsActivity = WashSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.WashSettingsActivity$onSetTimeRange$1$1.1
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
                            BleWashSettings bleWashSettings;
                            AbhSettingsItem itemTimeRange;
                            BleWashSettings bleWashSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleWashSettings = WashSettingsActivity.this.mWashSettings;
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            bleWashSettings.setMStartHour(i5);
                            bleWashSettings.setMStartMinute(i6);
                            bleWashSettings.setMEndHour(i7);
                            bleWashSettings.setMEndMinute(i8);
                            itemTimeRange = WashSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                            BleKey bleKey = BleKey.WASH_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleWashSettings2 = WashSettingsActivity.this.mWashSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleWashSettings2, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mWashSettings.getMStartHour(), this.mWashSettings.getMStartMinute(), this.mWashSettings.getMEndHour(), this.mWashSettings.getMEndMinute());
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
