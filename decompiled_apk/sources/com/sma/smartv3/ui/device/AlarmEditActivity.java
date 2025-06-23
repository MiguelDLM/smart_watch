package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.AlarmsActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsItem;
import com.sma.smartv3.view.picker.TimePicker;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleRepeat;
import java.util.Calendar;
import java.util.Set;

/* loaded from: classes12.dex */
public final class AlarmEditActivity extends BaseActivity {
    private boolean isEdited;
    private BleAlarm mAlarm;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoxXI mRepeatPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mSaveTipPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return AlarmEditActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemRepeat$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$itemRepeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) AlarmEditActivity.this.findViewById(R.id.item_repeat);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemLabel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$itemLabel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) AlarmEditActivity.this.findViewById(R.id.item_label);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemLabel() {
        return (AbhSettingsItem) this.itemLabel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemRepeat() {
        return (AbhSettingsItem) this.itemRepeat$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleComplete() {
        return com.sma.smartv3.ble.I0Io.oIX0oI(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$handleComplete$1
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
                BleAlarm bleAlarm;
                AbhSettingsItem itemLabel;
                BleAlarm bleAlarm2;
                BleAlarm bleAlarm3;
                BleAlarm bleAlarm4;
                BleAlarm bleAlarm5;
                BleAlarm bleAlarm6;
                BleAlarm bleAlarm7;
                BleAlarm bleAlarm8;
                BleAlarm bleAlarm9;
                BleAlarm bleAlarm10;
                BleAlarm bleAlarm11;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleAlarm = AlarmEditActivity.this.mAlarm;
                if (bleAlarm == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    bleAlarm = null;
                }
                itemLabel = AlarmEditActivity.this.getItemLabel();
                bleAlarm.setMTag(itemLabel.getRightText());
                bleAlarm2 = AlarmEditActivity.this.mAlarm;
                if (bleAlarm2 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    bleAlarm2 = null;
                }
                if (bleAlarm2.getMRepeat() == 0) {
                    Calendar calendar = Calendar.getInstance();
                    bleAlarm8 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm8 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm8 = null;
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
                    bleAlarm8.setMYear(oOXoIIIo.II0xO0.oO(calendar));
                    bleAlarm9 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm9 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm9 = null;
                    }
                    bleAlarm9.setMMonth(oOXoIIIo.II0xO0.OOXIXo(calendar));
                    bleAlarm10 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm10 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm10 = null;
                    }
                    bleAlarm10.setMDay(oOXoIIIo.II0xO0.II0xO0(calendar));
                    AlarmsActivity.oIX0oI oix0oi = AlarmsActivity.Companion;
                    bleAlarm11 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm11 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm11 = null;
                    }
                    oix0oi.oIX0oI(bleAlarm11);
                }
                if (AlarmEditActivity.this.getMArg1() >= 0) {
                    bleAlarm3 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm3 = null;
                    }
                    bleAlarm3.setMEnabled(1);
                    BleKey bleKey = BleKey.ALARM;
                    BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                    bleAlarm4 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm4 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm5 = null;
                    } else {
                        bleAlarm5 = bleAlarm4;
                    }
                    BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleAlarm5, false, false, 24, null);
                } else {
                    BleKey bleKey2 = BleKey.ALARM;
                    BleKeyFlag bleKeyFlag2 = BleKeyFlag.CREATE;
                    bleAlarm6 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm6 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm7 = null;
                    } else {
                        bleAlarm7 = bleAlarm6;
                    }
                    BleConnector.sendObject$default(it, bleKey2, bleKeyFlag2, bleAlarm7, false, false, 24, null);
                }
                AlarmEditActivity.this.setResult(-1);
                AlarmEditActivity.this.finish();
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleAlarm bleAlarm;
        if (getMArg1() < 0) {
            bleAlarm = new BleAlarm(0, 0, 0, 0, 0, 0, 0, null, 255, null);
        } else {
            bleAlarm = (BleAlarm) BleCache.getList$default(BleCache.INSTANCE, BleKey.ALARM, BleAlarm.class, null, 4, null).get(getMArg1());
        }
        this.mAlarm = bleAlarm;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (getMArg1() < 0) {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.add_alarm);
            findViewById(R.id.btn_bottom).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.edit_alarm);
            findViewById(R.id.btn_bottom).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.id.abh_title_right);
        imageView.setImageResource(R.drawable.ic_confirm);
        imageView.setVisibility(0);
        TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
        BleAlarm bleAlarm = this.mAlarm;
        BleAlarm bleAlarm2 = null;
        if (bleAlarm == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            bleAlarm = null;
        }
        int mHour = bleAlarm.getMHour();
        BleAlarm bleAlarm3 = this.mAlarm;
        if (bleAlarm3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            bleAlarm3 = null;
        }
        timePicker.xoIox(mHour, bleAlarm3.getMMinute());
        timePicker.setMListener(new Oox.x0xO0oo<Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$initView$2$1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2) {
                BleAlarm bleAlarm4;
                BleAlarm bleAlarm5;
                AlarmEditActivity.this.isEdited = true;
                bleAlarm4 = AlarmEditActivity.this.mAlarm;
                BleAlarm bleAlarm6 = null;
                if (bleAlarm4 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    bleAlarm4 = null;
                }
                bleAlarm4.setMHour(i);
                bleAlarm5 = AlarmEditActivity.this.mAlarm;
                if (bleAlarm5 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                } else {
                    bleAlarm6 = bleAlarm5;
                }
                bleAlarm6.setMMinute(i2);
            }
        });
        AbhSettingsItem itemRepeat = getItemRepeat();
        BleAlarm bleAlarm4 = this.mAlarm;
        if (bleAlarm4 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            bleAlarm4 = null;
        }
        itemRepeat.setMRightText(TextConvertKt.Io(bleAlarm4.getMRepeat()));
        if (ProductManager.f20544oIX0oI.IO()) {
            getItemLabel().setVisibility(0);
            getItemLabel().getEdtValue().addTextChangedListener(new com.sma.smartv3.util.X0o0xo(getItemLabel().getEdtValue(), 21));
            AbhSettingsItem itemLabel = getItemLabel();
            BleAlarm bleAlarm5 = this.mAlarm;
            if (bleAlarm5 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
            } else {
                bleAlarm2 = bleAlarm5;
            }
            itemLabel.setMRightText(bleAlarm2.getMTag());
            return;
        }
        getItemLabel().setVisibility(8);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_alarm_edit;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDeletePopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_alarm);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$onBottomClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    final AlarmEditActivity alarmEditActivity = AlarmEditActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.oIX0oI(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$onBottomClick$1$1.1
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
                            BleAlarm bleAlarm;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            BleKey bleKey = BleKey.ALARM;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.DELETE;
                            bleAlarm = AlarmEditActivity.this.mAlarm;
                            if (bleAlarm == null) {
                                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                                bleAlarm = null;
                            }
                            BleConnector.sendInt8$default(it, bleKey, bleKeyFlag, bleAlarm.getMId(), false, false, 24, null);
                            AlarmEditActivity.this.setResult(-1);
                            AlarmEditActivity.this.finish();
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
            xoxxi.oo(new Oox.oOoXoXO<Set<? extends Integer>, Boolean>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$onSetRepeat$1$1
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
                    BleAlarm bleAlarm;
                    AbhSettingsItem itemRepeat;
                    BleAlarm bleAlarm2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picked, "picked");
                    AlarmEditActivity.this.isEdited = true;
                    bleAlarm = AlarmEditActivity.this.mAlarm;
                    BleAlarm bleAlarm3 = null;
                    if (bleAlarm == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                        bleAlarm = null;
                    }
                    bleAlarm.setMRepeat(BleRepeat.indicesToRepeat$default(BleRepeat.INSTANCE, picked, null, 2, null));
                    itemRepeat = AlarmEditActivity.this.getItemRepeat();
                    bleAlarm2 = AlarmEditActivity.this.mAlarm;
                    if (bleAlarm2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                    } else {
                        bleAlarm3 = bleAlarm2;
                    }
                    itemRepeat.setMRightText(TextConvertKt.Io(bleAlarm3.getMRepeat()));
                    return Boolean.TRUE;
                }
            });
            this.mRepeatPopup = xoxxi;
        }
        com.sma.smartv3.pop.xoxXI xoxxi2 = this.mRepeatPopup;
        if (xoxxi2 != null) {
            BleRepeat bleRepeat = BleRepeat.INSTANCE;
            BleAlarm bleAlarm = this.mAlarm;
            if (bleAlarm == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAlarm");
                bleAlarm = null;
            }
            xoxxi2.oo0xXOI0I(BleRepeat.toIndices$default(bleRepeat, bleAlarm.getMRepeat(), null, 2, null));
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
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.give_up), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$onTitleLeftClick$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        AlarmEditActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.save, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.AlarmEditActivity$onTitleLeftClick$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        boolean handleComplete;
                        handleComplete = AlarmEditActivity.this.handleComplete();
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
