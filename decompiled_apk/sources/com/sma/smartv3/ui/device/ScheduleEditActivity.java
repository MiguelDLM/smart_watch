package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.DateTimePickerPopup;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleSchedule;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes12.dex */
public final class ScheduleEditActivity extends BaseActivity {
    private boolean isEdited;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoO0xx0 mAdvancePopup;

    @OXOo.oOoXoXO
    private DateTimePickerPopup mDateTimePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mSaveTipPopup;
    private BleSchedule mSchedule;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ScheduleEditActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$itemTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) ScheduleEditActivity.this.findViewById(R.id.item_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$itemTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) ScheduleEditActivity.this.findViewById(R.id.item_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemAdvance$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$itemAdvance$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) ScheduleEditActivity.this.findViewById(R.id.item_advance);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$edtContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) ScheduleEditActivity.this.findViewById(R.id.edt_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$edtTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ScheduleEditActivity.this.findViewById(R.id.edt_tip);
        }
    });

    @OXOo.OOXIXo
    private final SimpleDateFormat mDateFormat = com.sma.smartv3.util.xoIox.oxxXoxO(ProjectManager.f19822oIX0oI.IO(), false, 2, null);

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends com.sma.smartv3.util.XO {
        public II0xO0() {
            super(250);
        }

        @Override // com.sma.smartv3.util.XO, android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            String str;
            super.afterTextChanged(editable);
            ScheduleEditActivity.this.isEdited = true;
            BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
            if (bleSchedule == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule = null;
            }
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            bleSchedule.setMContent(str);
            ScheduleEditActivity.this.getEdtTip().setText(ScheduleEditActivity.this.m283getEdtTip());
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends com.sma.smartv3.util.XO {
        public oIX0oI() {
            super(32);
        }

        @Override // com.sma.smartv3.util.XO, android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            String str;
            super.afterTextChanged(editable);
            ScheduleEditActivity.this.isEdited = true;
            BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
            if (bleSchedule == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule = null;
            }
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            bleSchedule.setMTitle(str);
        }
    }

    private final EditText getEdtContent() {
        return (EditText) this.edtContent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getEdtTip() {
        return (TextView) this.edtTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemAdvance() {
        return (AbhSettingsItem) this.itemAdvance$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTime() {
        return (AbhSettingsItem) this.itemTime$delegate.getValue();
    }

    private final AbhSettingsItem getItemTitle() {
        return (AbhSettingsItem) this.itemTitle$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleComplete() {
        return com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$handleComplete$1
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
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (ScheduleEditActivity.this.getMArg1() < 0) {
                    BleKey bleKey = BleKey.SCHEDULE;
                    BleKeyFlag bleKeyFlag = BleKeyFlag.CREATE;
                    BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule = null;
                    }
                    BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleSchedule, false, false, 24, null);
                } else {
                    BleKey bleKey2 = BleKey.SCHEDULE;
                    BleKeyFlag bleKeyFlag2 = BleKeyFlag.UPDATE;
                    BleSchedule bleSchedule2 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule2 = null;
                    }
                    BleConnector.sendObject$default(it, bleKey2, bleKeyFlag2, bleSchedule2, false, false, 24, null);
                }
                ScheduleEditActivity.this.setResult(-1);
                ScheduleEditActivity.this.finish();
            }
        }, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleSchedule bleSchedule;
        if (getMArg1() < 0) {
            Calendar calendar = Calendar.getInstance();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
            bleSchedule = new BleSchedule(oOXoIIIo.II0xO0.oO(calendar), oOXoIIIo.II0xO0.OOXIXo(calendar), oOXoIIIo.II0xO0.II0xO0(calendar), oOXoIIIo.II0xO0.Oxx0IOOO(calendar), oOXoIIIo.II0xO0.xxIXOIIO(calendar), 0, null, null, 224, null);
        } else {
            bleSchedule = (BleSchedule) BleCache.getList$default(BleCache.INSTANCE, BleKey.SCHEDULE, BleSchedule.class, null, 4, null).get(getMArg1());
        }
        this.mSchedule = bleSchedule;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (getMArg1() < 0) {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.add_schedule);
            findViewById(R.id.btn_bottom).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.edit_schedule);
            findViewById(R.id.btn_bottom).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.id.abh_title_right);
        imageView.setImageResource(R.drawable.ic_confirm);
        imageView.setVisibility(0);
        AbhSettingsItem itemTitle = getItemTitle();
        BleSchedule bleSchedule = this.mSchedule;
        BleSchedule bleSchedule2 = null;
        if (bleSchedule == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
            bleSchedule = null;
        }
        itemTitle.setMRightText(bleSchedule.getMTitle());
        itemTitle.getEdtValue().addTextChangedListener(new oIX0oI());
        AbhSettingsItem itemTime = getItemTime();
        SimpleDateFormat simpleDateFormat = this.mDateFormat;
        BleSchedule bleSchedule3 = this.mSchedule;
        if (bleSchedule3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
            bleSchedule3 = null;
        }
        String format = simpleDateFormat.format(XxXX.oIX0oI(bleSchedule3));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        itemTime.setMRightText(format);
        AbhSettingsItem itemAdvance = getItemAdvance();
        BleSchedule bleSchedule4 = this.mSchedule;
        if (bleSchedule4 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
            bleSchedule4 = null;
        }
        itemAdvance.setMRightText(TextConvertKt.X0o0xo(bleSchedule4.getMAdvance()));
        EditText edtContent = getEdtContent();
        BleSchedule bleSchedule5 = this.mSchedule;
        if (bleSchedule5 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
        } else {
            bleSchedule2 = bleSchedule5;
        }
        edtContent.setText(bleSchedule2.getMContent());
        getEdtTip().setText(m283getEdtTip());
        edtContent.addTextChangedListener(new II0xO0());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_schedule_edit;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDeletePopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_schedule);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onBottomClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    final ScheduleEditActivity scheduleEditActivity = ScheduleEditActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onBottomClick$1$1.1
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
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            BleKey bleKey = BleKey.SCHEDULE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.DELETE;
                            BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
                            if (bleSchedule == null) {
                                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                                bleSchedule = null;
                            }
                            BleConnector.sendInt8$default(it, bleKey, bleKeyFlag, bleSchedule.getMId(), false, false, 24, null);
                            ScheduleEditActivity.this.setResult(-1);
                            ScheduleEditActivity.this.finish();
                        }
                    }, 1, null));
                }
            });
            this.mDeletePopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mDeletePopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void onSetAdvance(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mAdvancePopup == null) {
            com.sma.smartv3.pop.xoO0xx0 xoo0xx0 = new com.sma.smartv3.pop.xoO0xx0(getMContext(), R.array.schedule_advance);
            xoo0xx0.oo0xXOI0I(R.string.remind);
            xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onSetAdvance$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    AbhSettingsItem itemAdvance;
                    ScheduleEditActivity.this.isEdited = true;
                    BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
                    BleSchedule bleSchedule2 = null;
                    if (bleSchedule == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule = null;
                    }
                    bleSchedule.setMAdvance(TextConvertKt.I0Io(i));
                    itemAdvance = ScheduleEditActivity.this.getItemAdvance();
                    BleSchedule bleSchedule3 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                    } else {
                        bleSchedule2 = bleSchedule3;
                    }
                    itemAdvance.setMRightText(TextConvertKt.X0o0xo(bleSchedule2.getMAdvance()));
                    return Boolean.TRUE;
                }
            });
            this.mAdvancePopup = xoo0xx0;
        }
        com.sma.smartv3.pop.xoO0xx0 xoo0xx02 = this.mAdvancePopup;
        if (xoo0xx02 != null) {
            BleSchedule bleSchedule = this.mSchedule;
            if (bleSchedule == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule = null;
            }
            xoo0xx02.IoOoX(TextConvertKt.oxoX(bleSchedule.getMAdvance()));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoo0xx02.OxxIIOOXO(rootView);
        }
    }

    public final void onSetDateTime(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDateTimePopup == null) {
            DateTimePickerPopup dateTimePickerPopup = new DateTimePickerPopup(getMContext(), ProjectManager.f19822oIX0oI.IO());
            dateTimePickerPopup.IO(new Oox.oI0IIXIo<Integer, Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onSetDateTime$1$1
                {
                    super(5);
                }

                @Override // Oox.oI0IIXIo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i, int i2, int i3, int i4, int i5) {
                    AbhSettingsItem itemTime;
                    SimpleDateFormat simpleDateFormat;
                    ScheduleEditActivity.this.isEdited = true;
                    BleSchedule bleSchedule = ScheduleEditActivity.this.mSchedule;
                    BleSchedule bleSchedule2 = null;
                    if (bleSchedule == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule = null;
                    }
                    bleSchedule.setMYear(i);
                    BleSchedule bleSchedule3 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule3 = null;
                    }
                    bleSchedule3.setMMonth(i2);
                    BleSchedule bleSchedule4 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule4 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule4 = null;
                    }
                    bleSchedule4.setMDay(i3);
                    BleSchedule bleSchedule5 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule5 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule5 = null;
                    }
                    bleSchedule5.setMHour(i4);
                    BleSchedule bleSchedule6 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule6 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                        bleSchedule6 = null;
                    }
                    bleSchedule6.setMMinute(i5);
                    itemTime = ScheduleEditActivity.this.getItemTime();
                    simpleDateFormat = ScheduleEditActivity.this.mDateFormat;
                    BleSchedule bleSchedule7 = ScheduleEditActivity.this.mSchedule;
                    if (bleSchedule7 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                    } else {
                        bleSchedule2 = bleSchedule7;
                    }
                    String format = simpleDateFormat.format(XxXX.oIX0oI(bleSchedule2));
                    kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                    itemTime.setMRightText(format);
                    return Boolean.TRUE;
                }
            });
            this.mDateTimePopup = dateTimePickerPopup;
        }
        DateTimePickerPopup dateTimePickerPopup2 = this.mDateTimePopup;
        if (dateTimePickerPopup2 != null) {
            BleSchedule bleSchedule = this.mSchedule;
            BleSchedule bleSchedule2 = null;
            if (bleSchedule == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule = null;
            }
            int mYear = bleSchedule.getMYear();
            BleSchedule bleSchedule3 = this.mSchedule;
            if (bleSchedule3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule3 = null;
            }
            int mMonth = bleSchedule3.getMMonth();
            BleSchedule bleSchedule4 = this.mSchedule;
            if (bleSchedule4 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule4 = null;
            }
            int mDay = bleSchedule4.getMDay();
            BleSchedule bleSchedule5 = this.mSchedule;
            if (bleSchedule5 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
                bleSchedule5 = null;
            }
            int mHour = bleSchedule5.getMHour();
            BleSchedule bleSchedule6 = this.mSchedule;
            if (bleSchedule6 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
            } else {
                bleSchedule2 = bleSchedule6;
            }
            dateTimePickerPopup2.X00IoxXI(mYear, mMonth, mDay, mHour, bleSchedule2.getMMinute());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            dateTimePickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.isEdited) {
            if (this.mSaveTipPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.whether_to_save_change);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.give_up), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onTitleLeftClick$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        ScheduleEditActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.save, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.ScheduleEditActivity$onTitleLeftClick$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        boolean handleComplete;
                        handleComplete = ScheduleEditActivity.this.handleComplete();
                        return Boolean.valueOf(handleComplete);
                    }
                });
                this.mSaveTipPopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mSaveTipPopup;
            if (xoI0Ixx02 != null) {
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        handleComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getEdtTip, reason: collision with other method in class */
    public final String m283getEdtTip() {
        StringBuilder sb = new StringBuilder();
        BleSchedule bleSchedule = this.mSchedule;
        if (bleSchedule == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mSchedule");
            bleSchedule = null;
        }
        String mContent = bleSchedule.getMContent();
        Charset UTF_8 = StandardCharsets.UTF_8;
        kotlin.jvm.internal.IIX0o.oO(UTF_8, "UTF_8");
        byte[] bytes = mContent.getBytes(UTF_8);
        kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
        sb.append(bytes.length);
        sb.append("/250");
        return sb.toString();
    }
}
