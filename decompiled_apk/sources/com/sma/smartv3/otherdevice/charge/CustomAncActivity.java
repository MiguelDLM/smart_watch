package com.sma.smartv3.otherdevice.charge;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.view.RulerView;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAncMode;
import com.szabh.smable3.entity.BleEarphoneAncSettings;
import kotlin.jvm.internal.Ref;

@kotlin.jvm.internal.XX({"SMAP\nCustomAncActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomAncActivity.kt\ncom/sma/smartv3/otherdevice/charge/CustomAncActivity\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,273:1\n107#2:274\n79#2,22:275\n107#2:297\n79#2,22:298\n*S KotlinDebug\n*F\n+ 1 CustomAncActivity.kt\ncom/sma/smartv3/otherdevice/charge/CustomAncActivity\n*L\n182#1:274\n182#1:275,22\n183#1:297\n183#1:298,22\n*E\n"})
/* loaded from: classes12.dex */
public final class CustomAncActivity extends BaseChargeActivity {
    private boolean isLeftEdit;
    private boolean isRightEdit;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.IIX0o mEditPop;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO clLeft$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$clLeft$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return CustomAncActivity.this.findViewById(R.id.cl_modify_voice_left);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLeftTips$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$tvLeftTips$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CustomAncActivity.this.findViewById(R.id.tv_modify_voice_left);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLeftValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$tvLeftValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CustomAncActivity.this.findViewById(R.id.tv_modify_voice_left_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rulerLeft$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RulerView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$rulerLeft$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RulerView invoke() {
            return (RulerView) CustomAncActivity.this.findViewById(R.id.ruler_modify_voice_left);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO clRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$clRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CustomAncActivity.this.findViewById(R.id.cl_modify_voice_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRightTips$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$tvRightTips$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CustomAncActivity.this.findViewById(R.id.tv_modify_voice_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRightValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$tvRightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CustomAncActivity.this.findViewById(R.id.tv_modify_voice_right_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rulerRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RulerView>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$rulerRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RulerView invoke() {
            return (RulerView) CustomAncActivity.this.findViewById(R.id.ruler_modify_voice_right);
        }
    });

    @OXOo.OOXIXo
    private BleEarphoneAncSettings mEarphoneAncSettings = (BleEarphoneAncSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.EARPHONE_ANC_SET, BleEarphoneAncSettings.class, null, null, 12, null);

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements RulerView.X0o0xo {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.otherdevice.jl.view.RulerView.X0o0xo
        public void II0xO0(@OXOo.OOXIXo String result) {
            int round;
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            BleAncMode bleAncMode = CustomAncActivity.this.mEarphoneAncSettings.getMAncModeList().get(CustomAncActivity.this.mEarphoneAncSettings.getMMode());
            if (CustomAncActivity.this.isLeftEdit) {
                CustomAncActivity.this.isLeftEdit = false;
                round = Math.round(Float.parseFloat(result));
            } else {
                round = Math.round(Float.parseFloat(result) / 100) * 100;
            }
            if (round > bleAncMode.getMLeftMax()) {
                round = bleAncMode.getMLeftMax();
                ToastUtils.showLong(R.string.maximum_tips);
            }
            CustomAncActivity.this.getTvRightValue().setText(String.valueOf(round));
        }

        @Override // com.sma.smartv3.otherdevice.jl.view.RulerView.X0o0xo
        public void oIX0oI(@OXOo.OOXIXo String result) {
            int round;
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            BleAncMode bleAncMode = CustomAncActivity.this.mEarphoneAncSettings.getMAncModeList().get(CustomAncActivity.this.mEarphoneAncSettings.getMMode());
            if (CustomAncActivity.this.isRightEdit) {
                CustomAncActivity.this.isRightEdit = false;
                round = Math.round(Float.parseFloat(result));
            } else {
                round = Math.round(Float.parseFloat(result) / 100) * 100;
            }
            if (round > bleAncMode.getMRightMax()) {
                round = bleAncMode.getMRightMax();
                ToastUtils.showLong(R.string.maximum_tips);
            }
            CustomAncActivity.this.getTvRightValue().setText(String.valueOf(round));
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements RulerView.X0o0xo {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.otherdevice.jl.view.RulerView.X0o0xo
        public void II0xO0(@OXOo.OOXIXo String result) {
            int round;
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            BleAncMode bleAncMode = CustomAncActivity.this.mEarphoneAncSettings.getMAncModeList().get(CustomAncActivity.this.mEarphoneAncSettings.getMMode());
            if (CustomAncActivity.this.isLeftEdit) {
                CustomAncActivity.this.isLeftEdit = false;
                round = Math.round(Float.parseFloat(result));
            } else {
                round = Math.round(Float.parseFloat(result) / 100) * 100;
            }
            if (round > bleAncMode.getMLeftMax()) {
                round = bleAncMode.getMLeftMax();
                ToastUtils.showLong(R.string.maximum_tips);
            }
            CustomAncActivity.this.getTvLeftValue().setText(String.valueOf(round));
        }

        @Override // com.sma.smartv3.otherdevice.jl.view.RulerView.X0o0xo
        public void oIX0oI(@OXOo.OOXIXo String result) {
            int round;
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            BleAncMode bleAncMode = CustomAncActivity.this.mEarphoneAncSettings.getMAncModeList().get(CustomAncActivity.this.mEarphoneAncSettings.getMMode());
            if (CustomAncActivity.this.isLeftEdit) {
                CustomAncActivity.this.isLeftEdit = false;
                round = Math.round(Float.parseFloat(result));
            } else {
                round = Math.round(Float.parseFloat(result) / 100) * 100;
            }
            if (round > bleAncMode.getMLeftMax()) {
                round = bleAncMode.getMLeftMax();
                ToastUtils.showLong(R.string.maximum_tips);
            }
            CustomAncActivity.this.getTvLeftValue().setText(String.valueOf(round));
        }
    }

    private final View getClLeft() {
        return (View) this.clLeft$delegate.getValue();
    }

    private final LinearLayout getClRight() {
        return (LinearLayout) this.clRight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RulerView getRulerLeft() {
        return (RulerView) this.rulerLeft$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RulerView getRulerRight() {
        return (RulerView) this.rulerRight$delegate.getValue();
    }

    private final TextView getTvLeftTips() {
        return (TextView) this.tvLeftTips$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvLeftValue() {
        return (TextView) this.tvLeftValue$delegate.getValue();
    }

    private final TextView getTvRightTips() {
        return (TextView) this.tvRightTips$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvRightValue() {
        return (TextView) this.tvRightValue$delegate.getValue();
    }

    private final void saveConfigure() {
        int parseInt;
        int parseInt2;
        int i;
        boolean z;
        int i2;
        boolean z2;
        BleAncMode bleAncMode = this.mEarphoneAncSettings.getMAncModeList().get(this.mEarphoneAncSettings.getMMode());
        String obj = getTvLeftValue().getText().toString();
        boolean z3 = true;
        int length = obj.length() - 1;
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (i3 <= length) {
            if (!z5) {
                i2 = i3;
            } else {
                i2 = length;
            }
            if (kotlin.jvm.internal.IIX0o.oI0IIXIo(obj.charAt(i2), 32) <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z5) {
                if (!z2) {
                    z5 = true;
                } else {
                    i3++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj2 = obj.subSequence(i3, length + 1).toString();
        String obj3 = getTvRightValue().getText().toString();
        int length2 = obj3.length() - 1;
        int i4 = 0;
        boolean z6 = false;
        while (i4 <= length2) {
            if (!z6) {
                i = i4;
            } else {
                i = length2;
            }
            if (kotlin.jvm.internal.IIX0o.oI0IIXIo(obj3.charAt(i), 32) <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z6) {
                if (!z) {
                    z6 = true;
                } else {
                    i4++;
                }
            } else if (!z) {
                break;
            } else {
                length2--;
            }
        }
        String obj4 = obj3.subSequence(i4, length2 + 1).toString();
        if (TextUtils.isEmpty(obj2)) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(obj2);
        }
        if (TextUtils.isEmpty(obj4)) {
            parseInt2 = 0;
        } else {
            parseInt2 = Integer.parseInt(obj4);
        }
        if (parseInt != bleAncMode.getMLeftCurVal()) {
            bleAncMode.setMLeftCurVal(parseInt);
            z4 = true;
        }
        if (parseInt2 != bleAncMode.getMRightCurVal()) {
            bleAncMode.setMRightCurVal(parseInt2);
        } else {
            z3 = z4;
        }
        if (z3) {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.EARPHONE_ANC_SET, BleKeyFlag.UPDATE, this.mEarphoneAncSettings, false, false, 24, null);
        }
    }

    private final void updateVoiceMode() {
        String string;
        String string2;
        int i;
        BleAncMode bleAncMode = this.mEarphoneAncSettings.getMAncModeList().get(this.mEarphoneAncSettings.getMMode());
        LogUtils.d("updateVoiceMode -> mode = " + this.mEarphoneAncSettings);
        int mMode = this.mEarphoneAncSettings.getMMode();
        if (mMode != 0) {
            if (mMode != 1) {
                if (mMode != 2) {
                    ToastUtils.showLong(R.string.unknown_mode);
                    finish();
                    return;
                } else {
                    kotlin.jvm.internal.IIX0o.oO(getString(R.string.transparent_value), "getString(...)");
                    string = getString(R.string.left_ear_gain_value);
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    string2 = getString(R.string.right_ear_gain_value);
                    kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                }
            } else {
                kotlin.jvm.internal.IIX0o.oO(getString(R.string.denoise_value), "getString(...)");
                string = getString(R.string.left_dev_denoise_value);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                string2 = getString(R.string.right_dev_denoise_value);
                kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            }
            View clLeft = getClLeft();
            int i2 = 8;
            if (bleAncMode.getMLeftMax() > 0) {
                i = 0;
            } else {
                i = 8;
            }
            clLeft.setVisibility(i);
            if (bleAncMode.getMLeftMax() > 0) {
                getTvLeftTips().setText(string);
                getTvLeftValue().setText(String.valueOf(bleAncMode.getMLeftCurVal()));
                getRulerLeft().setScaleLimit(400);
                float f = 200;
                double d = 200;
                getRulerLeft().O0xOxO(0, (float) (Math.ceil(bleAncMode.getMLeftMax() / f) * d), (float) (Math.ceil(bleAncMode.getMLeftCurVal() / f) * d));
            }
            LinearLayout clRight = getClRight();
            if (bleAncMode.getMRightMax() > 0) {
                i2 = 0;
            }
            clRight.setVisibility(i2);
            if (bleAncMode.getMRightMax() > 0) {
                getTvRightTips().setText(string2);
                getTvRightValue().setText(String.valueOf(bleAncMode.getMRightCurVal()));
                getRulerRight().setScaleLimit(400);
                float f2 = 200;
                double d2 = 200;
                getRulerRight().O0xOxO(0, (float) (Math.ceil(bleAncMode.getMRightMax() / f2) * d2), (float) (Math.ceil(bleAncMode.getMRightCurVal() / f2) * d2));
                return;
            }
            return;
        }
        ToastUtils.showLong(R.string.invalid_mode);
        finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseChargeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.noise_settings);
        ((TextView) findViewById(R.id.abh_sub_title)).setText(R.string.noise_settings_sub);
        getRulerLeft().setOnChooseResulterListener(new oIX0oI());
        getRulerRight().setOnChooseResulterListener(new II0xO0());
        updateVoiceMode();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_custom_anc;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        saveConfigure();
    }

    public final void onShowInputValue(@OXOo.OOXIXo final View view) {
        String obj;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        BleAncMode bleAncMode = this.mEarphoneAncSettings.getMAncModeList().get(this.mEarphoneAncSettings.getMMode());
        final Ref.IntRef intRef = new Ref.IntRef();
        if (view.getId() == R.id.iv_modify_voice_edit_right) {
            obj = getTvRightValue().getText().toString();
            intRef.element = bleAncMode.getMRightMax();
            i = R.string.right_ear_gain_value;
        } else {
            obj = getTvLeftValue().getText().toString();
            intRef.element = bleAncMode.getMLeftMax();
            i = R.string.left_ear_gain_value;
        }
        if (this.mEditPop == null) {
            com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
            iIX0o.xXxxox0I().setInputType(2);
            this.mEditPop = iIX0o;
        }
        com.sma.smartv3.pop.IIX0o iIX0o2 = this.mEditPop;
        if (iIX0o2 != null) {
            iIX0o2.xII(i);
            iIX0o2.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.CustomAncActivity$onShowInputValue$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo String text) {
                    RulerView rulerLeft;
                    RulerView rulerRight;
                    boolean z = true;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                    if (TextUtils.isEmpty(text)) {
                        z = false;
                    } else {
                        float parseFloat = Float.parseFloat(text);
                        if (parseFloat < 0.0f || parseFloat > Ref.IntRef.this.element) {
                            ToastUtils.showLong(this.getString(R.string.input_valid_value_tips, 0, Integer.valueOf(Ref.IntRef.this.element)), new Object[0]);
                        }
                        int round = Math.round((float) (Math.ceil(parseFloat / 200) * 200));
                        if (view.getId() == R.id.iv_modify_voice_edit_right) {
                            this.isRightEdit = true;
                            rulerRight = this.getRulerRight();
                            rulerRight.Oo(round);
                        } else {
                            this.isLeftEdit = true;
                            rulerLeft = this.getRulerLeft();
                            rulerLeft.Oo(round);
                        }
                    }
                    return Boolean.valueOf(z);
                }
            });
            iIX0o2.xXxxox0I().setText(obj);
            iIX0o2.xXxxox0I().setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.line_color));
            iIX0o2.IIXOooo();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
