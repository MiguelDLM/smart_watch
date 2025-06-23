package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesCalculationMethod;
import com.sma.smartv3.model.PrayerTimesKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleQiblaSettings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

@kotlin.jvm.internal.XX({"SMAP\nQiblaSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaSettingsActivity.kt\ncom/sma/smartv3/ui/device/QiblaSettingsActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,256:1\n18#2,2:257\n15#2:259\n11#2,2:260\n18#2,2:311\n15#2:313\n140#3,5:262\n145#3,5:268\n69#3,3:273\n72#3,5:277\n69#3,3:282\n72#3,5:286\n69#3,3:292\n72#3,5:296\n69#3,3:301\n72#3,5:305\n1#4:267\n1#4:276\n1#4:285\n1#4:291\n1#4:295\n1#4:304\n1#4:310\n*S KotlinDebug\n*F\n+ 1 QiblaSettingsActivity.kt\ncom/sma/smartv3/ui/device/QiblaSettingsActivity\n*L\n56#1:257,2\n56#1:259\n94#1:260,2\n231#1:311,2\n231#1:313\n138#1:262,5\n138#1:268,5\n142#1:273,3\n142#1:277,5\n146#1:282,3\n146#1:286,5\n174#1:292,3\n174#1:296,5\n200#1:301,3\n200#1:305,5\n138#1:267\n142#1:276\n146#1:285\n174#1:295\n200#1:304\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaSettingsActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int DEF_REMINDER = 5;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mArsJuristicMethodPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mHijriDateAdjustmentPopup;

    @OXOo.OOXIXo
    private com.sma.smartv3.location.oIX0oI mLocation;

    @OXOo.OOXIXo
    private PrayerTimeSettings mPrayerTimeSettings;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mReminderPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) QiblaSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemMethodSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemMethodSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_method_set);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeCorrect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemTimeCorrect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_time_correct);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemJuristicSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemJuristicSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_juristic_set);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHijriDateCorrrectSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemHijriDateCorrrectSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_hijri_date_correct);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemReminder$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemReminder$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_reminder);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemRenewal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$itemRenewal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) QiblaSettingsActivity.this.findViewById(R.id.item_renewal);
        }
    });

    @OXOo.OOXIXo
    private final BleQiblaSettings mSettings = (BleQiblaSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.QIBLA_SET, BleQiblaSettings.class, null, null, 12, null);

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final int oIX0oI() {
            return QiblaSettingsActivity.DEF_REMINDER;
        }

        public oIX0oI() {
        }
    }

    public QiblaSettingsActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        this.mPrayerTimeSettings = (PrayerTimeSettings) (fromJson == null ? PrayerTimeSettings.class.newInstance() : fromJson);
        this.mLocation = new com.sma.smartv3.location.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0.0f, 0, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAsrMethod(int i) {
        String str = getResources().getStringArray(R.array.asr_juristic_method)[i];
        kotlin.jvm.internal.IIX0o.oO(str, "get(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemHijriDateCorrrectSet() {
        return (AbhSettingsItem) this.itemHijriDateCorrrectSet$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemJuristicSet() {
        return (AbhSettingsItem) this.itemJuristicSet$delegate.getValue();
    }

    private final AbhSettingsItem getItemMethodSet() {
        return (AbhSettingsItem) this.itemMethodSet$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemReminder() {
        return (AbhSettingsItem) this.itemReminder$delegate.getValue();
    }

    private final AbhSettingsItem getItemRenewal() {
        return (AbhSettingsItem) this.itemRenewal$delegate.getValue();
    }

    private final AbhSettingsItem getItemTimeCorrect() {
        return (AbhSettingsItem) this.itemTimeCorrect$delegate.getValue();
    }

    private final String getTimeCorrectString() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        if (fromJson == null) {
            fromJson = PrayerTimeSettings.class.newInstance();
        }
        this.mPrayerTimeSettings = (PrayerTimeSettings) fromJson;
        return com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getFajrAdjustment(), 0, 2, null) + ',' + com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getSunriseAdjustment(), 0, 2, null) + ',' + com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getDhuhrAdjustment(), 0, 2, null) + ',' + com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getAsrAdjustment(), 0, 2, null) + ',' + com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getMaghribAdjustment(), 0, 2, null) + ',' + com.sma.smartv3.util.xoIox.XO(this.mPrayerTimeSettings.getIshaAdjustment(), 0, 2, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (ProductManager.f20544oIX0oI.XXx0OXXXo()) {
            getItemRenewal().setVisibility(0);
        }
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.qibla_set);
        LogUtils.d(this.mSettings);
        if (this.mSettings.getMReminderMinute() == 0) {
            this.mSettings.setMReminderMinute(DEF_REMINDER);
        }
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$initView$1$1
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
                final QiblaSettingsActivity qiblaSettingsActivity = QiblaSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$initView$1$1.1
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
                        BleQiblaSettings bleQiblaSettings;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        bleQiblaSettings = QiblaSettingsActivity.this.mSettings;
                        bleQiblaSettings.setMEnabled(oOXoIIIo.I0Io.I0Io(z));
                        QiblaSettingsActivity.this.onInfoChange(new Object());
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24641ooXIXxIX, null, 2, null);
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = QiblaSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        getItemMethodSet().setMRightText(PrayerTimesCalculationMethod.Companion.getMethodName(this.mSettings.getMMethod()));
        getItemJuristicSet().setMRightText(getAsrMethod(this.mPrayerTimeSettings.getArsJuristicMethod()));
        getItemHijriDateCorrrectSet().setMRightText(com.sma.smartv3.util.xoIox.X0o0xo(this.mPrayerTimeSettings.getHijriDateAdjustment(), R.string.day));
        AbhSettingsItem itemReminder = getItemReminder();
        String string = getString(R.string.d_minutes, Integer.valueOf(this.mSettings.getMReminderMinute()));
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        itemReminder.setMRightText(string);
        onInfoChange(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qibla_settings;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Serializable serializable;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 99) {
            if (intent != null) {
                serializable = intent.getSerializableExtra("method");
            } else {
                serializable = null;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable, "null cannot be cast to non-null type com.sma.smartv3.model.PrayerTimesCalculationMethod");
            PrayerTimesCalculationMethod prayerTimesCalculationMethod = (PrayerTimesCalculationMethod) serializable;
            getItemMethodSet().setMRightText(PrayerTimesCalculationMethod.Companion.getMethodName(prayerTimesCalculationMethod.getMethod()));
            this.mPrayerTimeSettings.setCalculationMethod(prayerTimesCalculationMethod.getMethod());
            onInfoChange(new Object());
        }
    }

    public final void onHijriDateCorrect(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mHijriDateAdjustmentPopup == null) {
            ArrayList arrayList = new ArrayList(61);
            for (int i = 0; i < 61; i++) {
                arrayList.add(String.valueOf(i - 30));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.hijri_date_correct);
            oX00O0xII.IoOoX(R.string.day);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$onHijriDateCorrect$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    PrayerTimeSettings prayerTimeSettings;
                    AbhSettingsItem itemHijriDateCorrrectSet;
                    PrayerTimeSettings prayerTimeSettings2;
                    prayerTimeSettings = QiblaSettingsActivity.this.mPrayerTimeSettings;
                    prayerTimeSettings.setHijriDateAdjustment(i2 - 30);
                    itemHijriDateCorrrectSet = QiblaSettingsActivity.this.getItemHijriDateCorrrectSet();
                    prayerTimeSettings2 = QiblaSettingsActivity.this.mPrayerTimeSettings;
                    itemHijriDateCorrrectSet.setMRightText(com.sma.smartv3.util.xoIox.X0o0xo(prayerTimeSettings2.getHijriDateAdjustment(), R.string.day));
                    QiblaSettingsActivity.this.onInfoChange(new Object());
                    return Boolean.TRUE;
                }
            });
            this.mHijriDateAdjustmentPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mHijriDateAdjustmentPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mPrayerTimeSettings.getHijriDateAdjustment() + 30);
            oX00O0xII2.IIXOooo();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24423XX)
    public final void onInfoChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onInfoChange");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(PrayerTimeSettings.class.getName(), new Gson().toJson(this.mPrayerTimeSettings));
        this.mLocation = UtilsKt.ooOOo0oXI();
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.oO(calendar, "getInstance(...)");
        long OxxIIOOXO2 = com.sma.smartv3.util.xoIox.OxxIIOOXO(calendar);
        this.mSettings.setMMethod(this.mPrayerTimeSettings.getCalculationMethod());
        this.mSettings.setMStartTime((int) (System.currentTimeMillis() / 1000));
        this.mSettings.setMPrayerTimes(PrayerTimesKt.toBlePrayerTimes(PrayerTimesKt.getPrayerTimeMap$default(this.mPrayerTimeSettings, this.mLocation.II0xO0(), this.mLocation.I0Io(), OxxIIOOXO2, 0, 16, null)));
        AbhSettingsItem itemHijriDateCorrrectSet = getItemHijriDateCorrrectSet();
        String string = getString(R.string.hijri_date_correct);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        itemHijriDateCorrrectSet.setMLeftText(string);
        com.sma.smartv3.util.IIX0o x0XOIxOo2 = com.sma.smartv3.util.xoIox.x0XOIxOo(OxxIIOOXO2, 0, 2, null);
        this.mSettings.setMHijriYear(x0XOIxOo2.II0XooXoX());
        this.mSettings.setMHijriMonth(x0XOIxOo2.Oxx0IOOO());
        this.mSettings.setMHijriDay(x0XOIxOo2.XO());
        if (this.mPrayerTimeSettings.getHijriDateAdjustment() != 0) {
            getItemHijriDateCorrrectSet().setMLeftText(getString(R.string.hijri_date_correct) + '\n' + getString(R.string.hijri_date_corrected, com.sma.smartv3.util.xoIox.x0xO0oo(OxxIIOOXO2, 0, 2, null)));
        }
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.QIBLA_SET, BleKeyFlag.UPDATE, this.mSettings, false, false, 24, null);
    }

    public final void onJuristicSet(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mArsJuristicMethodPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.asr_juristic_method, R.layout.pop_choice_asrmethod_set);
            xxoxoooix.xI(R.string.asr_juristic_method);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$onJuristicSet$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    PrayerTimeSettings prayerTimeSettings;
                    AbhSettingsItem itemJuristicSet;
                    PrayerTimeSettings prayerTimeSettings2;
                    String asrMethod;
                    prayerTimeSettings = QiblaSettingsActivity.this.mPrayerTimeSettings;
                    prayerTimeSettings.setArsJuristicMethod(i);
                    itemJuristicSet = QiblaSettingsActivity.this.getItemJuristicSet();
                    QiblaSettingsActivity qiblaSettingsActivity = QiblaSettingsActivity.this;
                    prayerTimeSettings2 = qiblaSettingsActivity.mPrayerTimeSettings;
                    asrMethod = qiblaSettingsActivity.getAsrMethod(prayerTimeSettings2.getArsJuristicMethod());
                    itemJuristicSet.setMRightText(asrMethod);
                    QiblaSettingsActivity.this.onInfoChange(new Object());
                    return Boolean.TRUE;
                }
            });
            this.mArsJuristicMethodPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mArsJuristicMethodPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(this.mPrayerTimeSettings.getArsJuristicMethod());
            xxoxoooix2.IIXOooo();
        }
    }

    public final void onMethodSet(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivityForResult(new Intent(this, (Class<?>) QiblaMethodActivity.class), 99);
    }

    public final void onOrientaiton(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) QiblaOrientationActivity.class));
    }

    public final void onReminder(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mReminderPopup == null) {
            ArrayList arrayList = new ArrayList(30);
            int i = 0;
            while (i < 30) {
                i++;
                arrayList.add(String.valueOf(i));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.qibla_prayer_reminder);
            oX00O0xII.IoOoX(R.string.minute);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$onReminder$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final QiblaSettingsActivity qiblaSettingsActivity = QiblaSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.QiblaSettingsActivity$onReminder$2$1.1
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
                            BleQiblaSettings bleQiblaSettings;
                            AbhSettingsItem itemReminder;
                            BleQiblaSettings bleQiblaSettings2;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleQiblaSettings = QiblaSettingsActivity.this.mSettings;
                            bleQiblaSettings.setMReminderMinute(i2 + 1);
                            itemReminder = QiblaSettingsActivity.this.getItemReminder();
                            QiblaSettingsActivity qiblaSettingsActivity2 = QiblaSettingsActivity.this;
                            bleQiblaSettings2 = qiblaSettingsActivity2.mSettings;
                            String string = qiblaSettingsActivity2.getString(R.string.d_minutes, Integer.valueOf(bleQiblaSettings2.getMReminderMinute()));
                            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                            itemReminder.setMRightText(string);
                            QiblaSettingsActivity.this.onInfoChange(new Object());
                        }
                    }, 1, null));
                }
            });
            this.mReminderPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mReminderPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mSettings.getMReminderMinute() - 1);
            oX00O0xII2.IIXOooo();
        }
    }

    public final void onRenewal(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) ResourceRenewalActivity.class));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String timeCorrectString = getTimeCorrectString();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onResume -> " + getItemTimeCorrect().getMRightText() + ", " + timeCorrectString);
        if (!TextUtils.isEmpty(getItemTimeCorrect().getMRightText()) && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(getItemTimeCorrect().getMRightText(), timeCorrectString)) {
            onInfoChange(new Object());
        }
        getItemTimeCorrect().setMRightText(timeCorrectString);
    }

    public final void onTime(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) QiblaTimeActivity.class));
    }

    public final void onTimeCorrect(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) QiblaTimeCorrectActivity.class));
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
