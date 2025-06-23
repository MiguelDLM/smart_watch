package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.MedicationAlarmsActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsItem;
import com.sma.smartv3.view.picker.TimePicker;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleMedicationAlarm;
import com.szabh.smable3.entity.BleRepeat;
import java.util.Calendar;
import java.util.Set;

/* loaded from: classes12.dex */
public final class MedicationAlarmEditActivity extends BaseActivity {
    private boolean isEdited;
    private BleMedicationAlarm mAlarm;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoxXI mRepeatPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mSaveTipPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MedicationAlarmEditActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemRepeat$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$itemRepeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) MedicationAlarmEditActivity.this.findViewById(R.id.item_repeat);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemRepeat() {
        return (AbhSettingsItem) this.itemRepeat$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleComplete() {
        return com.sma.smartv3.ble.I0Io.oIX0oI(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$handleComplete$1
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
                BleMedicationAlarm bleMedicationAlarm;
                BleMedicationAlarm bleMedicationAlarm2;
                BleMedicationAlarm bleMedicationAlarm3;
                BleMedicationAlarm bleMedicationAlarm4;
                BleMedicationAlarm bleMedicationAlarm5;
                BleMedicationAlarm bleMedicationAlarm6;
                BleMedicationAlarm bleMedicationAlarm7;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleMedicationAlarm = MedicationAlarmEditActivity.this.mAlarm;
                if (bleMedicationAlarm == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    bleMedicationAlarm = null;
                }
                if (bleMedicationAlarm.getMRepeat() == 0) {
                    Calendar calendar = Calendar.getInstance();
                    bleMedicationAlarm4 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm4 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm4 = null;
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
                    bleMedicationAlarm4.setMYear(oOXoIIIo.II0xO0.oO(calendar));
                    bleMedicationAlarm5 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm5 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm5 = null;
                    }
                    bleMedicationAlarm5.setMMonth(oOXoIIIo.II0xO0.OOXIXo(calendar));
                    bleMedicationAlarm6 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm6 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm6 = null;
                    }
                    bleMedicationAlarm6.setMDay(oOXoIIIo.II0xO0.II0xO0(calendar));
                    MedicationAlarmsActivity.oIX0oI oix0oi = MedicationAlarmsActivity.Companion;
                    bleMedicationAlarm7 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm7 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm7 = null;
                    }
                    oix0oi.oIX0oI(bleMedicationAlarm7);
                }
                if (MedicationAlarmEditActivity.this.getMArg1() < 0) {
                    BleKey bleKey = BleKey.MEDICATION_ALARM;
                    BleKeyFlag bleKeyFlag = BleKeyFlag.CREATE;
                    bleMedicationAlarm3 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm3 = null;
                    }
                    BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleMedicationAlarm3, false, false, 24, null);
                } else {
                    BleKey bleKey2 = BleKey.MEDICATION_ALARM;
                    BleKeyFlag bleKeyFlag2 = BleKeyFlag.UPDATE;
                    bleMedicationAlarm2 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm2 = null;
                    }
                    BleConnector.sendObject$default(it, bleKey2, bleKeyFlag2, bleMedicationAlarm2, false, false, 24, null);
                }
                MedicationAlarmEditActivity.this.setResult(-1);
                MedicationAlarmEditActivity.this.finish();
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleMedicationAlarm bleMedicationAlarm;
        if (getMArg1() < 0) {
            bleMedicationAlarm = new BleMedicationAlarm(0, 0, 0, 0, 0, 0, 0, 127, null);
        } else {
            bleMedicationAlarm = (BleMedicationAlarm) BleCache.getList$default(BleCache.INSTANCE, BleKey.MEDICATION_ALARM, BleMedicationAlarm.class, null, 4, null).get(getMArg1());
        }
        this.mAlarm = bleMedicationAlarm;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (getMArg1() < 0) {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.add_medication_alarm);
            findViewById(R.id.btn_bottom).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.edit_medication_alarm);
            findViewById(R.id.btn_bottom).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.id.abh_title_right);
        imageView.setImageResource(R.drawable.ic_confirm);
        imageView.setVisibility(0);
        TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
        BleMedicationAlarm bleMedicationAlarm = this.mAlarm;
        BleMedicationAlarm bleMedicationAlarm2 = null;
        if (bleMedicationAlarm == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            bleMedicationAlarm = null;
        }
        int mHour = bleMedicationAlarm.getMHour();
        BleMedicationAlarm bleMedicationAlarm3 = this.mAlarm;
        if (bleMedicationAlarm3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            bleMedicationAlarm3 = null;
        }
        timePicker.xoIox(mHour, bleMedicationAlarm3.getMMinute());
        timePicker.setMListener(new Oox.x0xO0oo<Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$initView$2$1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2) {
                BleMedicationAlarm bleMedicationAlarm4;
                BleMedicationAlarm bleMedicationAlarm5;
                MedicationAlarmEditActivity.this.isEdited = true;
                bleMedicationAlarm4 = MedicationAlarmEditActivity.this.mAlarm;
                BleMedicationAlarm bleMedicationAlarm6 = null;
                if (bleMedicationAlarm4 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    bleMedicationAlarm4 = null;
                }
                bleMedicationAlarm4.setMHour(i);
                bleMedicationAlarm5 = MedicationAlarmEditActivity.this.mAlarm;
                if (bleMedicationAlarm5 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                } else {
                    bleMedicationAlarm6 = bleMedicationAlarm5;
                }
                bleMedicationAlarm6.setMMinute(i2);
            }
        });
        AbhSettingsItem itemRepeat = getItemRepeat();
        BleMedicationAlarm bleMedicationAlarm4 = this.mAlarm;
        if (bleMedicationAlarm4 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
        } else {
            bleMedicationAlarm2 = bleMedicationAlarm4;
        }
        itemRepeat.setMRightText(TextConvertKt.Io(bleMedicationAlarm2.getMRepeat()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_medication_alarm_edit;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDeletePopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_medication_alarm);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$onBottomClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    final MedicationAlarmEditActivity medicationAlarmEditActivity = MedicationAlarmEditActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.oIX0oI(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$onBottomClick$1$1.1
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
                            BleMedicationAlarm bleMedicationAlarm;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            BleKey bleKey = BleKey.MEDICATION_ALARM;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.DELETE;
                            bleMedicationAlarm = MedicationAlarmEditActivity.this.mAlarm;
                            if (bleMedicationAlarm == null) {
                                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                                bleMedicationAlarm = null;
                            }
                            BleConnector.sendInt8$default(it, bleKey, bleKeyFlag, bleMedicationAlarm.getMId(), false, false, 24, null);
                            MedicationAlarmEditActivity.this.setResult(-1);
                            MedicationAlarmEditActivity.this.finish();
                        }
                    }));
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

    public final void onSetRepeat(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mRepeatPopup == null) {
            com.sma.smartv3.pop.xoxXI xoxxi = new com.sma.smartv3.pop.xoxXI(this, R.array.weekdays_s);
            xoxxi.IoOoX(R.string.repeat);
            xoxxi.oo(new Oox.oOoXoXO<Set<? extends Integer>, Boolean>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$onSetRepeat$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Set<? extends Integer> set) {
                    return invoke2((Set<Integer>) set);
                }

                @OXOo.OOXIXo
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(@OXOo.OOXIXo Set<Integer> picked) {
                    BleMedicationAlarm bleMedicationAlarm;
                    AbhSettingsItem itemRepeat;
                    BleMedicationAlarm bleMedicationAlarm2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picked, "picked");
                    MedicationAlarmEditActivity.this.isEdited = true;
                    bleMedicationAlarm = MedicationAlarmEditActivity.this.mAlarm;
                    BleMedicationAlarm bleMedicationAlarm3 = null;
                    if (bleMedicationAlarm == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleMedicationAlarm = null;
                    }
                    bleMedicationAlarm.setMRepeat(BleRepeat.indicesToRepeat$default(BleRepeat.INSTANCE, picked, null, 2, null));
                    itemRepeat = MedicationAlarmEditActivity.this.getItemRepeat();
                    bleMedicationAlarm2 = MedicationAlarmEditActivity.this.mAlarm;
                    if (bleMedicationAlarm2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    } else {
                        bleMedicationAlarm3 = bleMedicationAlarm2;
                    }
                    itemRepeat.setMRightText(TextConvertKt.Io(bleMedicationAlarm3.getMRepeat()));
                    return Boolean.TRUE;
                }
            });
            this.mRepeatPopup = xoxxi;
        }
        com.sma.smartv3.pop.xoxXI xoxxi2 = this.mRepeatPopup;
        if (xoxxi2 != null) {
            BleRepeat bleRepeat = BleRepeat.INSTANCE;
            BleMedicationAlarm bleMedicationAlarm = this.mAlarm;
            if (bleMedicationAlarm == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                bleMedicationAlarm = null;
            }
            xoxxi2.oo0xXOI0I(BleRepeat.toIndices$default(bleRepeat, bleMedicationAlarm.getMRepeat(), null, 2, null));
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoxxi2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.isEdited) {
            if (this.mSaveTipPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.whether_to_save_change);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.give_up), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$onTitleLeftClick$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        MedicationAlarmEditActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.save, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MedicationAlarmEditActivity$onTitleLeftClick$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        boolean handleComplete;
                        handleComplete = MedicationAlarmEditActivity.this.handleComplete();
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
}
