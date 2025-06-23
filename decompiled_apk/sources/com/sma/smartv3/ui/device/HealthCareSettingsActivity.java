package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.DatePickerPopup;
import com.sma.smartv3.pop.TimePickerPopup;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleGirlCareSettings;
import java.util.ArrayList;
import java.util.Calendar;

@kotlin.jvm.internal.XX({"SMAP\nHealthCareSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HealthCareSettingsActivity.kt\ncom/sma/smartv3/ui/device/HealthCareSettingsActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
/* loaded from: classes12.dex */
public final class HealthCareSettingsActivity extends BaseActivity {
    public static final int DURATION_DEFAULT = 5;
    public static final int DURATION_MAX = 8;
    public static final int DURATION_MIN = 2;
    public static final int MENSTRUATION_REMINDER_DEFAULT = 2;
    public static final int MENSTRUATION_REMINDER_MAX = 3;
    public static final int MENSTRUATION_REMINDER_MIN = 1;
    public static final int OVULATION_REMINDER_DEFAULT = 3;
    public static final int OVULATION_REMINDER_MAX = 3;
    public static final int OVULATION_REMINDER_MIN = 1;
    public static final int PERIOD_DEFAULT = 28;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mDurationPopup;

    @OXOo.oOoXoXO
    private DatePickerPopup mLastPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mOvulationReminderPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mPeriodPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mPeriodReminderPopup;

    @OXOo.oOoXoXO
    private TimePickerPopup mReminderPopup;

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int PERIOD_MIN = 25;
    private static final int PERIOD_MAX = 35;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HealthCareSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) HealthCareSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemDuration$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_period_length);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemPeriod$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemPeriod$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_cycle_length);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemLast$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemLast$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_last);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemPeriodReminder$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemPeriodReminder$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_period_reminder);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemOvulationReminder$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemOvulationReminder$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_ovulation_reminder);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemReminderTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$itemReminderTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) HealthCareSettingsActivity.this.findViewById(R.id.item_reminder_time);
        }
    });

    @OXOo.OOXIXo
    private final BleGirlCareSettings mGirlCareSettings = (BleGirlCareSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GIRL_CARE, BleGirlCareSettings.class, null, null, 12, null);

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final int II0xO0() {
            return HealthCareSettingsActivity.PERIOD_MIN;
        }

        public final int oIX0oI() {
            return HealthCareSettingsActivity.PERIOD_MAX;
        }

        public oIX0oI() {
        }
    }

    private final AbhSettingsItem getItemDuration() {
        return (AbhSettingsItem) this.itemDuration$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    private final AbhSettingsItem getItemLast() {
        return (AbhSettingsItem) this.itemLast$delegate.getValue();
    }

    private final AbhSettingsItem getItemOvulationReminder() {
        return (AbhSettingsItem) this.itemOvulationReminder$delegate.getValue();
    }

    private final AbhSettingsItem getItemPeriod() {
        return (AbhSettingsItem) this.itemPeriod$delegate.getValue();
    }

    private final AbhSettingsItem getItemPeriodReminder() {
        return (AbhSettingsItem) this.itemPeriodReminder$delegate.getValue();
    }

    private final AbhSettingsItem getItemReminderTime() {
        return (AbhSettingsItem) this.itemReminderTime$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDuration() {
        getItemDuration().setMRightText(this.mGirlCareSettings.getMMenstruationDuration() + TokenParser.SP + getString(R.string.days));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLatest() {
        String sb;
        AbhSettingsItem itemLast = getItemLast();
        if (ProjectManager.f19822oIX0oI.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mGirlCareSettings.getMLatestDay());
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(this.mGirlCareSettings.getMLatestMonth());
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(this.mGirlCareSettings.getMLatestYear());
            sb = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.mGirlCareSettings.getMLatestMonth());
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb3.append(this.mGirlCareSettings.getMLatestDay());
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb3.append(this.mGirlCareSettings.getMLatestYear());
            sb = sb3.toString();
        }
        itemLast.setMRightText(sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMenstruation() {
        getItemPeriodReminder().setMRightText(this.mGirlCareSettings.getMMenstruationReminderAdvance() + TokenParser.SP + getString(R.string.days_in_advance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOvulation() {
        getItemOvulationReminder().setMRightText(this.mGirlCareSettings.getMOvulationReminderAdvance() + TokenParser.SP + getString(R.string.days_in_advance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePeriod() {
        getItemPeriod().setMRightText(this.mGirlCareSettings.getMMenstruationPeriod() + TokenParser.SP + getString(R.string.days));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReminderTime() {
        getItemReminderTime().setMRightText(com.sma.smartv3.util.xoIox.O0xOxO(this.mGirlCareSettings.getMReminderHour(), this.mGirlCareSettings.getMReminderMinute(), ProjectManager.f19822oIX0oI.IO()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        LogUtils.d(this.mGirlCareSettings);
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        textView.setText(productManager.xxX());
        getItemHeader().getTvTitle().setText(productManager.xxX());
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mGirlCareSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$initView$1$1
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
                final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$initView$1$1.1
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
                        BleGirlCareSettings bleGirlCareSettings;
                        BleGirlCareSettings bleGirlCareSettings2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                        bleGirlCareSettings.setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        BleKey bleKey = BleKey.GIRL_CARE;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings2, false, false, 24, null);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24599OxI, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = HealthCareSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        if (this.mGirlCareSettings.getMMenstruationDuration() == 0) {
            this.mGirlCareSettings.setMMenstruationDuration(5);
        }
        if (this.mGirlCareSettings.getMMenstruationPeriod() == 0) {
            this.mGirlCareSettings.setMMenstruationPeriod(28);
        }
        Calendar calendar = Calendar.getInstance();
        if (this.mGirlCareSettings.getMLatestYear() == 0) {
            this.mGirlCareSettings.setMLatestYear(calendar.get(1));
        }
        if (this.mGirlCareSettings.getMLatestMonth() == 0) {
            this.mGirlCareSettings.setMLatestMonth(calendar.get(2) + 1);
        }
        if (this.mGirlCareSettings.getMLatestDay() == 0) {
            this.mGirlCareSettings.setMLatestDay(calendar.get(5));
        }
        if (this.mGirlCareSettings.getMMenstruationReminderAdvance() == 0) {
            this.mGirlCareSettings.setMMenstruationReminderAdvance(2);
        }
        if (this.mGirlCareSettings.getMOvulationReminderAdvance() == 0) {
            this.mGirlCareSettings.setMOvulationReminderAdvance(3);
        }
        if (this.mGirlCareSettings.getMReminderHour() == 0) {
            this.mGirlCareSettings.setMReminderHour(8);
        }
        updateDuration();
        updatePeriod();
        updateLatest();
        updateMenstruation();
        updateOvulation();
        updateReminderTime();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_health_care_settings;
    }

    public final void onSetDuration(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDurationPopup == null) {
            ArrayList arrayList = new ArrayList(7);
            for (int i = 0; i < 7; i++) {
                arrayList.add(String.valueOf(i + 2));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.period_length);
            oX00O0xII.IoOoX(R.string.days);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetDuration$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetDuration$2$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMMenstruationDuration(i2 + 2);
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings2, false, false, 24, null);
                            HealthCareSettingsActivity.this.updateDuration();
                        }
                    }, 1, null));
                }
            });
            this.mDurationPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mDurationPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mGirlCareSettings.getMMenstruationDuration() - 2);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetLast(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mLastPopup == null) {
            DatePickerPopup datePickerPopup = new DatePickerPopup(this);
            datePickerPopup.oo(R.string.last_menstrual_period);
            datePickerPopup.oo0xXOI0I(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetLast$1$1
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetLast$1$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            BleGirlCareSettings bleGirlCareSettings3;
                            BleGirlCareSettings bleGirlCareSettings4;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMLatestYear(i);
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings2.setMLatestMonth(i2);
                            bleGirlCareSettings3 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings3.setMLatestDay(i3);
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings4 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings4, false, false, 24, null);
                            HealthCareSettingsActivity.this.updateLatest();
                        }
                    }, 1, null));
                }
            });
            this.mLastPopup = datePickerPopup;
        }
        DatePickerPopup datePickerPopup2 = this.mLastPopup;
        if (datePickerPopup2 != null) {
            datePickerPopup2.xI(this.mGirlCareSettings.getMLatestYear(), this.mGirlCareSettings.getMLatestMonth(), this.mGirlCareSettings.getMLatestDay());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            datePickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetOvulationReminder(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mOvulationReminderPopup == null) {
            ArrayList arrayList = new ArrayList(3);
            int i = 0;
            while (i < 3) {
                i++;
                arrayList.add(String.valueOf(i));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.ovulation_reminder);
            oX00O0xII.IoOoX(R.string.days_in_advance);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetOvulationReminder$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetOvulationReminder$2$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMOvulationReminderAdvance(i2 + 1);
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings2, false, false, 24, null);
                            HealthCareSettingsActivity.this.updateOvulation();
                        }
                    }, 1, null));
                }
            });
            this.mOvulationReminderPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mOvulationReminderPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mGirlCareSettings.getMOvulationReminderAdvance() - 1);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetPeriod(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mPeriodPopup == null) {
            int i = (PERIOD_MAX - PERIOD_MIN) + 1;
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(String.valueOf(PERIOD_MIN + i2));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.cycle_length);
            oX00O0xII.IoOoX(R.string.days);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetPeriod$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i3) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetPeriod$2$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMMenstruationPeriod(i3 + HealthCareSettingsActivity.Companion.II0xO0());
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings2, false, false, 24, null);
                            HealthCareSettingsActivity.this.updatePeriod();
                        }
                    }, 1, null));
                }
            });
            this.mPeriodPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mPeriodPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mGirlCareSettings.getMMenstruationPeriod() - PERIOD_MIN);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetPeriodReminder(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mPeriodReminderPopup == null) {
            ArrayList arrayList = new ArrayList(3);
            int i = 0;
            while (i < 3) {
                i++;
                arrayList.add(String.valueOf(i));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.period_reminder);
            oX00O0xII.IoOoX(R.string.days_in_advance);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetPeriodReminder$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetPeriodReminder$2$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMMenstruationReminderAdvance(i2 + 1);
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings2, false, false, 24, null);
                            HealthCareSettingsActivity.this.updateMenstruation();
                        }
                    }, 1, null));
                }
            });
            this.mPeriodReminderPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mPeriodReminderPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mGirlCareSettings.getMMenstruationReminderAdvance() - 1);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oX00O0xII2.OxxIIOOXO(rootView);
        }
    }

    public final void onSetReminderTime(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mReminderPopup == null) {
            TimePickerPopup timePickerPopup = new TimePickerPopup(this, ProjectManager.f19822oIX0oI.IO());
            timePickerPopup.xI(R.string.reminder_time);
            timePickerPopup.ooXIXxIX(new Oox.x0xO0oo<Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetReminderTime$1$1
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2) {
                    return invoke(num.intValue(), num2.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2) {
                    final HealthCareSettingsActivity healthCareSettingsActivity = HealthCareSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.HealthCareSettingsActivity$onSetReminderTime$1$1.1
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
                            BleGirlCareSettings bleGirlCareSettings;
                            BleGirlCareSettings bleGirlCareSettings2;
                            BleGirlCareSettings bleGirlCareSettings3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleGirlCareSettings = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings.setMReminderHour(i);
                            bleGirlCareSettings2 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            bleGirlCareSettings2.setMReminderMinute(i2);
                            BleKey bleKey = BleKey.GIRL_CARE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleGirlCareSettings3 = HealthCareSettingsActivity.this.mGirlCareSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleGirlCareSettings3, false, false, 24, null);
                            HealthCareSettingsActivity.this.updateReminderTime();
                        }
                    }, 1, null));
                }
            });
            this.mReminderPopup = timePickerPopup;
        }
        TimePickerPopup timePickerPopup2 = this.mReminderPopup;
        if (timePickerPopup2 != null) {
            timePickerPopup2.oo0xXOI0I(this.mGirlCareSettings.getMReminderHour(), this.mGirlCareSettings.getMReminderMinute());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            timePickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
