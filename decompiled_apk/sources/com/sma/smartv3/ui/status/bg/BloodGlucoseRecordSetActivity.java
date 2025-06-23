package com.sma.smartv3.ui.status.bg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BGEMRecordSet;
import com.sma.smartv3.pop.DatePickerPopup;
import com.sma.smartv3.pop.xxOXOOoIX;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.AbhSettingsItem;
import java.util.Calendar;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBloodGlucoseRecordSetActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucoseRecordSetActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseRecordSetActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,125:1\n18#2,2:126\n15#2:128\n11#2,2:129\n11#2,2:131\n*S KotlinDebug\n*F\n+ 1 BloodGlucoseRecordSetActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseRecordSetActivity\n*L\n33#1:126,2\n33#1:128\n111#1:129,2\n117#1:131,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodGlucoseRecordSetActivity extends BaseActivity {

    @OOXIXo
    private BGEMRecordSet mSetting;

    @OOXIXo
    private final X0IIOO itemCalendar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$itemCalendar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) BloodGlucoseRecordSetActivity.this.findViewById(R.id.item_calendar);
        }
    });

    @OOXIXo
    private final X0IIOO itemStartDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$itemStartDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) BloodGlucoseRecordSetActivity.this.findViewById(R.id.item_start_date);
        }
    });

    @OOXIXo
    private final X0IIOO itemEndDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$itemEndDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) BloodGlucoseRecordSetActivity.this.findViewById(R.id.item_end_date);
        }
    });

    public BloodGlucoseRecordSetActivity() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(BGEMRecordSet.class.getName()), (Class<Object>) BGEMRecordSet.class);
        this.mSetting = (BGEMRecordSet) (fromJson == null ? BGEMRecordSet.class.newInstance() : fromJson);
    }

    private final AbhSettingsItem getItemCalendar() {
        return (AbhSettingsItem) this.itemCalendar$delegate.getValue();
    }

    private final AbhSettingsItem getItemEndDate() {
        return (AbhSettingsItem) this.itemEndDate$delegate.getValue();
    }

    private final AbhSettingsItem getItemStartDate() {
        return (AbhSettingsItem) this.itemStartDate$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        String str;
        AbhSettingsItem itemCalendar = getItemCalendar();
        String str2 = getResources().getStringArray(R.array.by_calendars)[this.mSetting.getCalendar()];
        IIX0o.oO(str2, "get(...)");
        itemCalendar.setMRightText(str2);
        AbhSettingsItem itemStartDate = getItemStartDate();
        String str3 = "";
        if (this.mSetting.getStartDate() == 0) {
            str = "";
        } else {
            str = xoIox.oo0xXOI0I().format(Long.valueOf(this.mSetting.getStartDate()));
            IIX0o.oO(str, "format(...)");
        }
        itemStartDate.setMRightText(str);
        AbhSettingsItem itemEndDate = getItemEndDate();
        if (this.mSetting.getEndDate() != 0) {
            str3 = xoIox.oo0xXOI0I().format(Long.valueOf(this.mSetting.getEndDate()));
            IIX0o.oO(str3, "format(...)");
        }
        itemEndDate.setMRightText(str3);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.measurement_logs);
        updateUI();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_blood_glucose_record_set;
    }

    public final void onBottomClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0.f24349oIX0oI.XO().put(BGEMRecordSet.class.getName(), new Gson().toJson(this.mSetting));
        x0xO0oo.II0xO0(x0xO0oo.f24625o0oIxOo, null, 2, null);
        finish();
    }

    public final void onCalendar(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        xxOXOOoIX xxoxoooix = new xxOXOOoIX(this, R.array.by_calendars, 0, 4, (IIXOooo) null);
        xxoxoooix.xI(R.string.by_calendar);
        xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$onCalendar$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OOXIXo
            public final Boolean invoke(int i) {
                BGEMRecordSet bGEMRecordSet;
                bGEMRecordSet = BloodGlucoseRecordSetActivity.this.mSetting;
                bGEMRecordSet.setCalendar(i);
                BloodGlucoseRecordSetActivity.this.updateUI();
                return Boolean.TRUE;
            }
        });
        xxoxoooix.IIX0o(this.mSetting.getCalendar());
        xxoxoooix.IIXOooo();
    }

    public final void onEndDate(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        DatePickerPopup datePickerPopup = new DatePickerPopup(this);
        datePickerPopup.oo(R.string.end_date);
        datePickerPopup.oo0xXOI0I(new IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$onEndDate$1$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                return invoke(num.intValue(), num2.intValue(), num3.intValue());
            }

            @OOXIXo
            public final Boolean invoke(int i, int i2, int i3) {
                BGEMRecordSet bGEMRecordSet;
                Calendar calendar = Calendar.getInstance();
                IIX0o.ooOOo0oXI(calendar);
                oOXoIIIo.II0xO0.XI0IXoo(calendar, i);
                oOXoIIIo.II0xO0.o00(calendar, i2);
                oOXoIIIo.II0xO0.IXxxXO(calendar, i3);
                oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
                oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
                oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
                oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
                bGEMRecordSet = BloodGlucoseRecordSetActivity.this.mSetting;
                bGEMRecordSet.setEndDate(calendar.getTimeInMillis());
                BloodGlucoseRecordSetActivity.this.updateUI();
                return Boolean.TRUE;
            }
        });
        datePickerPopup.IoOoX(this.mSetting.getEndDate());
        datePickerPopup.IIXOooo();
    }

    public final void onReset(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        this.mSetting = new BGEMRecordSet(0, 0L, 0L, 7, null);
        Xo0.f24349oIX0oI.XO().put(BGEMRecordSet.class.getName(), new Gson().toJson(this.mSetting));
        x0xO0oo.II0xO0(x0xO0oo.f24625o0oIxOo, null, 2, null);
        updateUI();
    }

    public final void onStartDate(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        DatePickerPopup datePickerPopup = new DatePickerPopup(this);
        datePickerPopup.oo(R.string.start_date);
        datePickerPopup.oo0xXOI0I(new IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordSetActivity$onStartDate$1$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                return invoke(num.intValue(), num2.intValue(), num3.intValue());
            }

            @OOXIXo
            public final Boolean invoke(int i, int i2, int i3) {
                BGEMRecordSet bGEMRecordSet;
                Calendar calendar = Calendar.getInstance();
                IIX0o.ooOOo0oXI(calendar);
                oOXoIIIo.II0xO0.XI0IXoo(calendar, i);
                oOXoIIIo.II0xO0.o00(calendar, i2);
                oOXoIIIo.II0xO0.IXxxXO(calendar, i3);
                oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
                oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
                oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
                oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
                bGEMRecordSet = BloodGlucoseRecordSetActivity.this.mSetting;
                bGEMRecordSet.setStartDate(calendar.getTimeInMillis());
                BloodGlucoseRecordSetActivity.this.updateUI();
                return Boolean.TRUE;
            }
        });
        datePickerPopup.IoOoX(this.mSetting.getStartDate());
        datePickerPopup.IIXOooo();
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
