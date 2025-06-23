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
import com.szabh.smable3.entity.BleGameSettings;

/* loaded from: classes12.dex */
public final class GameSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup1;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup2;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return GameSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) GameSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange1$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$itemTimeRange1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) GameSettingsActivity.this.findViewById(R.id.item_time_range1);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange2$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$itemTimeRange2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) GameSettingsActivity.this.findViewById(R.id.item_time_range2);
        }
    });

    @OXOo.OOXIXo
    private final BleGameSettings mGameSettings = (BleGameSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GAME_SET, BleGameSettings.class, null, null, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTimeRange1() {
        return (AbhSettingsItem) this.itemTimeRange1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTimeRange2() {
        return (AbhSettingsItem) this.itemTimeRange2$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.game_settings);
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mGameSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$initView$1$1
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
                final GameSettingsActivity gameSettingsActivity = GameSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$initView$1$1.1
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
                        BleGameSettings bleGameSettings;
                        BleGameSettings bleGameSettings2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleGameSettings = GameSettingsActivity.this.mGameSettings;
                        bleGameSettings.setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        BleKey bleKey = BleKey.GAME_SET;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleGameSettings2 = GameSettingsActivity.this.mGameSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGameSettings2, false, false, 24, null);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24660xXxxox0I, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = GameSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        AbhSettingsItem itemTimeRange1 = getItemTimeRange1();
        int mStartHour1 = this.mGameSettings.getMStartHour1();
        int mStartMinute1 = this.mGameSettings.getMStartMinute1();
        int mEndHour1 = this.mGameSettings.getMEndHour1();
        int mEndMinute1 = this.mGameSettings.getMEndMinute1();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        itemTimeRange1.setMRightText(TextConvertKt.xoxXI(mStartHour1, mStartMinute1, mEndHour1, mEndMinute1, projectManager.IO()));
        getItemTimeRange1().setMLeftText(getString(R.string.time) + " 1");
        getItemTimeRange2().setMRightText(TextConvertKt.xoxXI(this.mGameSettings.getMStartHour2(), this.mGameSettings.getMStartMinute2(), this.mGameSettings.getMEndHour2(), this.mGameSettings.getMEndMinute2(), projectManager.IO()));
        getItemTimeRange2().setMLeftText(getString(R.string.time) + " 2");
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_game_settings;
    }

    public final void onSetTimeRange1(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup1 == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$onSetTimeRange1$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final GameSettingsActivity gameSettingsActivity = GameSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$onSetTimeRange1$1$1.1
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
                            BleGameSettings bleGameSettings;
                            AbhSettingsItem itemTimeRange1;
                            BleGameSettings bleGameSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGameSettings = GameSettingsActivity.this.mGameSettings;
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            bleGameSettings.setMStartHour1(i5);
                            bleGameSettings.setMStartMinute1(i6);
                            bleGameSettings.setMEndHour1(i7);
                            bleGameSettings.setMEndMinute1(i8);
                            itemTimeRange1 = GameSettingsActivity.this.getItemTimeRange1();
                            itemTimeRange1.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                            BleKey bleKey = BleKey.GAME_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGameSettings2 = GameSettingsActivity.this.mGameSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGameSettings2, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup1 = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup1;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mGameSettings.getMStartHour1(), this.mGameSettings.getMStartMinute1(), this.mGameSettings.getMEndHour1(), this.mGameSettings.getMEndMinute1());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            timeRangePopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetTimeRange2(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup2 == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$onSetTimeRange2$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final GameSettingsActivity gameSettingsActivity = GameSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameSettingsActivity$onSetTimeRange2$1$1.1
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
                            BleGameSettings bleGameSettings;
                            AbhSettingsItem itemTimeRange2;
                            BleGameSettings bleGameSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGameSettings = GameSettingsActivity.this.mGameSettings;
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            bleGameSettings.setMStartHour2(i5);
                            bleGameSettings.setMStartMinute2(i6);
                            bleGameSettings.setMEndHour2(i7);
                            bleGameSettings.setMEndMinute2(i8);
                            itemTimeRange2 = GameSettingsActivity.this.getItemTimeRange2();
                            itemTimeRange2.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                            BleKey bleKey = BleKey.GAME_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGameSettings2 = GameSettingsActivity.this.mGameSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGameSettings2, false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup2 = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup2;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mGameSettings.getMStartHour2(), this.mGameSettings.getMStartMinute2(), this.mGameSettings.getMEndHour2(), this.mGameSettings.getMEndMinute2());
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
