package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nShockSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShockSettingsActivity.kt\ncom/sma/smartv3/ui/device/ShockSettingsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,140:1\n1549#2:141\n1620#2,3:142\n*S KotlinDebug\n*F\n+ 1 ShockSettingsActivity.kt\ncom/sma/smartv3/ui/device/ShockSettingsActivity\n*L\n41#1:141\n41#1:142,3\n*E\n"})
/* loaded from: classes12.dex */
public final class ShockSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mCirculationPopup;

    @OXOo.OOXIXo
    private final List<String> mCirculations;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mShockModePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mShockModes$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ShockSettingsActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvIncomingCallShockMode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvIncomingCallShockMode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_incoming_call_shock_mode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvIncomingCallCirculation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvIncomingCallCirculation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_incoming_call_circulation);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAlarmClockShockMode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvAlarmClockShockMode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_alarm_clock_shock_mode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAlarmClockCirculation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvAlarmClockCirculation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_alarm_clock_circulation);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvScheduleShockMode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvScheduleShockMode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_schedule_shock_mode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvScheduleCirculation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvScheduleCirculation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_schedule_circulation);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSedentaryShockMode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvSedentaryShockMode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_sedentary_shock_mode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSedentaryCirculation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvSedentaryCirculation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_sedentary_circulation);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMessagePushShockMode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvMessagePushShockMode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_message_push_shock_mode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMessagePushCirculation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$tvMessagePushCirculation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShockSettingsActivity.this.findViewById(R.id.tv_message_push_circulation);
        }
    });

    public ShockSettingsActivity() {
        X0.oOoXoXO oooxoxo = new X0.oOoXoXO(0, 6);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(oooxoxo, 10));
        Iterator<Integer> it = oooxoxo.iterator();
        while (it.hasNext()) {
            arrayList.add(TextConvertKt.IoOoo(((kotlin.collections.oOXoIIIo) it).nextInt()));
        }
        this.mCirculations = arrayList;
        this.mShockModes$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String[]>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$mShockModes$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final String[] invoke() {
                return ShockSettingsActivity.this.getResources().getStringArray(R.array.shock_mode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getMShockModes() {
        return (String[]) this.mShockModes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvAlarmClockCirculation() {
        return (PFMedium) this.tvAlarmClockCirculation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvAlarmClockShockMode() {
        return (PFMedium) this.tvAlarmClockShockMode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvIncomingCallCirculation() {
        return (PFMedium) this.tvIncomingCallCirculation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvIncomingCallShockMode() {
        return (PFMedium) this.tvIncomingCallShockMode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvMessagePushCirculation() {
        return (PFMedium) this.tvMessagePushCirculation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvMessagePushShockMode() {
        return (PFMedium) this.tvMessagePushShockMode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvScheduleCirculation() {
        return (PFMedium) this.tvScheduleCirculation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvScheduleShockMode() {
        return (PFMedium) this.tvScheduleShockMode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvSedentaryCirculation() {
        return (PFMedium) this.tvSedentaryCirculation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvSedentaryShockMode() {
        return (PFMedium) this.tvSedentaryShockMode$delegate.getValue();
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.shock);
        getTvIncomingCallShockMode().setText(getMShockModes()[0]);
        getTvIncomingCallCirculation().setText(this.mCirculations.get(0));
        getTvAlarmClockShockMode().setText(getMShockModes()[1]);
        getTvAlarmClockCirculation().setText(this.mCirculations.get(0));
        getTvScheduleShockMode().setText(getMShockModes()[2]);
        getTvScheduleCirculation().setText(this.mCirculations.get(0));
        getTvSedentaryShockMode().setText(getMShockModes()[3]);
        getTvSedentaryCirculation().setText(this.mCirculations.get(0));
        getTvMessagePushShockMode().setText(getMShockModes()[4]);
        getTvMessagePushCirculation().setText(this.mCirculations.get(0));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_shock_settings;
    }

    public final void onItemClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        final int id = view.getId();
        switch (id) {
            case R.id.ll_alarm_clock_circulation /* 2131365855 */:
            case R.id.ll_incoming_call_circulation /* 2131365903 */:
            case R.id.ll_message_push_circulation /* 2131365916 */:
            case R.id.ll_schedule_circulation /* 2131365947 */:
            case R.id.ll_sedentary_circulation /* 2131365951 */:
                com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, this.mCirculations, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                xxoxoooix.xI(R.string.circulation);
                xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$onItemClick$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i) {
                        PFMedium tvAlarmClockCirculation;
                        List list;
                        PFMedium tvIncomingCallCirculation;
                        List list2;
                        PFMedium tvMessagePushCirculation;
                        List list3;
                        PFMedium tvScheduleCirculation;
                        List list4;
                        PFMedium tvSedentaryCirculation;
                        List list5;
                        switch (id) {
                            case R.id.ll_alarm_clock_circulation /* 2131365855 */:
                                tvAlarmClockCirculation = this.getTvAlarmClockCirculation();
                                list = this.mCirculations;
                                tvAlarmClockCirculation.setText((CharSequence) list.get(i));
                                break;
                            case R.id.ll_incoming_call_circulation /* 2131365903 */:
                                tvIncomingCallCirculation = this.getTvIncomingCallCirculation();
                                list2 = this.mCirculations;
                                tvIncomingCallCirculation.setText((CharSequence) list2.get(i));
                                break;
                            case R.id.ll_message_push_circulation /* 2131365916 */:
                                tvMessagePushCirculation = this.getTvMessagePushCirculation();
                                list3 = this.mCirculations;
                                tvMessagePushCirculation.setText((CharSequence) list3.get(i));
                                break;
                            case R.id.ll_schedule_circulation /* 2131365947 */:
                                tvScheduleCirculation = this.getTvScheduleCirculation();
                                list4 = this.mCirculations;
                                tvScheduleCirculation.setText((CharSequence) list4.get(i));
                                break;
                            case R.id.ll_sedentary_circulation /* 2131365951 */:
                                tvSedentaryCirculation = this.getTvSedentaryCirculation();
                                list5 = this.mCirculations;
                                tvSedentaryCirculation.setText((CharSequence) list5.get(i));
                                break;
                        }
                        return Boolean.TRUE;
                    }
                });
                this.mCirculationPopup = xxoxoooix;
                xxoxoooix.IIX0o(0);
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xxoxoooix.OxxIIOOXO(rootView);
                return;
            case R.id.ll_alarm_clock_shock_mode /* 2131365856 */:
            case R.id.ll_incoming_call_shock_mode /* 2131365904 */:
            case R.id.ll_message_push_shock_mode /* 2131365917 */:
            case R.id.ll_schedule_shock_mode /* 2131365948 */:
            case R.id.ll_sedentary_shock_mode /* 2131365952 */:
                com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.shock_mode, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                xxoxoooix2.xI(R.string.shock_model);
                xxoxoooix2.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.ShockSettingsActivity$onItemClick$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i) {
                        PFMedium tvAlarmClockShockMode;
                        String[] mShockModes;
                        PFMedium tvIncomingCallShockMode;
                        String[] mShockModes2;
                        PFMedium tvMessagePushShockMode;
                        String[] mShockModes3;
                        PFMedium tvScheduleShockMode;
                        String[] mShockModes4;
                        PFMedium tvSedentaryShockMode;
                        String[] mShockModes5;
                        switch (id) {
                            case R.id.ll_alarm_clock_shock_mode /* 2131365856 */:
                                tvAlarmClockShockMode = this.getTvAlarmClockShockMode();
                                mShockModes = this.getMShockModes();
                                tvAlarmClockShockMode.setText(mShockModes[i]);
                                break;
                            case R.id.ll_incoming_call_shock_mode /* 2131365904 */:
                                tvIncomingCallShockMode = this.getTvIncomingCallShockMode();
                                mShockModes2 = this.getMShockModes();
                                tvIncomingCallShockMode.setText(mShockModes2[i]);
                                break;
                            case R.id.ll_message_push_shock_mode /* 2131365917 */:
                                tvMessagePushShockMode = this.getTvMessagePushShockMode();
                                mShockModes3 = this.getMShockModes();
                                tvMessagePushShockMode.setText(mShockModes3[i]);
                                break;
                            case R.id.ll_schedule_shock_mode /* 2131365948 */:
                                tvScheduleShockMode = this.getTvScheduleShockMode();
                                mShockModes4 = this.getMShockModes();
                                tvScheduleShockMode.setText(mShockModes4[i]);
                                break;
                            case R.id.ll_sedentary_shock_mode /* 2131365952 */:
                                tvSedentaryShockMode = this.getTvSedentaryShockMode();
                                mShockModes5 = this.getMShockModes();
                                tvSedentaryShockMode.setText(mShockModes5[i]);
                                break;
                        }
                        return Boolean.TRUE;
                    }
                });
                this.mShockModePopup = xxoxoooix2;
                xxoxoooix2.IIX0o(0);
                View rootView2 = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView2, "<get-rootView>(...)");
                xxoxoooix2.OxxIIOOXO(rootView2);
                return;
            default:
                return;
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
