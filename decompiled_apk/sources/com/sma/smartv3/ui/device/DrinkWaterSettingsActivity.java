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
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import com.szabh.smable3.entity.BleRepeat;
import java.util.Set;

/* loaded from: classes12.dex */
public final class DrinkWaterSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoxXI mRepeatPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return DrinkWaterSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) DrinkWaterSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) DrinkWaterSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemRepeat$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$itemRepeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) DrinkWaterSettingsActivity.this.findViewById(R.id.item_repeat);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) DrinkWaterSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final BleDrinkWaterSettings mDrinkWaterSettings = (BleDrinkWaterSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.DRINK_WATER, BleDrinkWaterSettings.class, null, null, 12, null);

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
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.drink_water);
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mDrinkWaterSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$initView$1$1
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
                final DrinkWaterSettingsActivity drinkWaterSettingsActivity = DrinkWaterSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$initView$1$1.1
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
                        BleDrinkWaterSettings bleDrinkWaterSettings;
                        BleDrinkWaterSettings bleDrinkWaterSettings2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleDrinkWaterSettings = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                        bleDrinkWaterSettings.setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        BleKey bleKey = BleKey.DRINK_WATER;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleDrinkWaterSettings2 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleDrinkWaterSettings2, false, false, 24, null);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24588O0xOxO, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = DrinkWaterSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mDrinkWaterSettings.getMStartHour(), this.mDrinkWaterSettings.getMStartMinute(), this.mDrinkWaterSettings.getMEndHour(), this.mDrinkWaterSettings.getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
        getItemRepeat().setMRightText(TextConvertKt.Io(this.mDrinkWaterSettings.getMRepeat()));
        getItemInterval().setMRightText(TextConvertKt.xI(this.mDrinkWaterSettings.getMInterval()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_drink_water_settings;
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mIntervalPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.drink_water_intervals, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.interval);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetInterval$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i) {
                    final DrinkWaterSettingsActivity drinkWaterSettingsActivity = DrinkWaterSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetInterval$1$1.1
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
                            BleDrinkWaterSettings bleDrinkWaterSettings;
                            AbhSettingsItem itemInterval;
                            BleDrinkWaterSettings bleDrinkWaterSettings2;
                            BleDrinkWaterSettings bleDrinkWaterSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleDrinkWaterSettings = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            bleDrinkWaterSettings.setMInterval(((int) Math.pow(2.0d, i)) * 30);
                            itemInterval = DrinkWaterSettingsActivity.this.getItemInterval();
                            bleDrinkWaterSettings2 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            itemInterval.setMRightText(TextConvertKt.xI(bleDrinkWaterSettings2.getMInterval()));
                            BleKey bleKey = BleKey.DRINK_WATER;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleDrinkWaterSettings3 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleDrinkWaterSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mIntervalPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mIntervalPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(Xx000oIo.X0o0xo.oIX0oI(this.mDrinkWaterSettings.getMInterval() / 30));
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
            xoxxi.oo(new Oox.oOoXoXO<Set<? extends Integer>, Boolean>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetRepeat$1$1
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
                    final DrinkWaterSettingsActivity drinkWaterSettingsActivity = DrinkWaterSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetRepeat$1$1.1
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
                            BleDrinkWaterSettings bleDrinkWaterSettings;
                            AbhSettingsItem itemRepeat;
                            BleDrinkWaterSettings bleDrinkWaterSettings2;
                            BleDrinkWaterSettings bleDrinkWaterSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleDrinkWaterSettings = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            bleDrinkWaterSettings.setMRepeat(BleRepeat.indicesToRepeat$default(BleRepeat.INSTANCE, picked, null, 2, null));
                            itemRepeat = DrinkWaterSettingsActivity.this.getItemRepeat();
                            bleDrinkWaterSettings2 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            itemRepeat.setMRightText(TextConvertKt.Io(bleDrinkWaterSettings2.getMRepeat()));
                            BleKey bleKey = BleKey.DRINK_WATER;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleDrinkWaterSettings3 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleDrinkWaterSettings3, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mRepeatPopup = xoxxi;
        }
        com.sma.smartv3.pop.xoxXI xoxxi2 = this.mRepeatPopup;
        if (xoxxi2 != null) {
            xoxxi2.oo0xXOI0I(BleRepeat.toIndices$default(BleRepeat.INSTANCE, this.mDrinkWaterSettings.getMRepeat(), null, 2, null));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoxxi2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final DrinkWaterSettingsActivity drinkWaterSettingsActivity = DrinkWaterSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DrinkWaterSettingsActivity$onSetTimeRange$1$1.1
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
                            BleDrinkWaterSettings bleDrinkWaterSettings;
                            AbhSettingsItem itemTimeRange;
                            BleDrinkWaterSettings bleDrinkWaterSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleDrinkWaterSettings = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            bleDrinkWaterSettings.setMStartHour(i5);
                            bleDrinkWaterSettings.setMStartMinute(i6);
                            bleDrinkWaterSettings.setMEndHour(i7);
                            bleDrinkWaterSettings.setMEndMinute(i8);
                            itemTimeRange = DrinkWaterSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                            BleKey bleKey = BleKey.DRINK_WATER;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleDrinkWaterSettings2 = DrinkWaterSettingsActivity.this.mDrinkWaterSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleDrinkWaterSettings2, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mDrinkWaterSettings.getMStartHour(), this.mDrinkWaterSettings.getMStartMinute(), this.mDrinkWaterSettings.getMEndHour(), this.mDrinkWaterSettings.getMEndMinute());
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
