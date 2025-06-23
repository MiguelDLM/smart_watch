package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.network.ResetPassword;
import java.util.HashMap;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nResetPasswordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResetPasswordActivity.kt\ncom/sma/smartv3/ui/me/ResetPasswordActivity\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,164:1\n158#2,4:165\n171#2:177\n208#3,7:169\n226#3:176\n254#4:178\n*S KotlinDebug\n*F\n+ 1 ResetPasswordActivity.kt\ncom/sma/smartv3/ui/me/ResetPasswordActivity\n*L\n135#1:165,4\n135#1:177\n135#1:169,7\n135#1:176\n157#1:178\n*E\n"})
/* loaded from: classes11.dex */
public final class ResetPasswordActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llGetVerificationCode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$llGetVerificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ResetPasswordActivity.this.findViewById(R.id.llGetVerificationCode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llSetNewPassword$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$llSetNewPassword$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ResetPasswordActivity.this.findViewById(R.id.llSetNewPassword);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO email$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$email$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) ResetPasswordActivity.this.findViewById(R.id.email);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO verificationCode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$verificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) ResetPasswordActivity.this.findViewById(R.id.verificationCode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO newPassword$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$newPassword$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) ResetPasswordActivity.this.findViewById(R.id.newPassword);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO newPasswordAgain$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$newPasswordAgain$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) ResetPasswordActivity.this.findViewById(R.id.newPasswordAgain);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btGetVerificationCode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$btGetVerificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) ResetPasswordActivity.this.findViewById(R.id.btGetVerificationCode);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ResetPasswordActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO resetPasswordTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$resetPasswordTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ResetPasswordActivity.this.findViewById(R.id.resetPasswordTip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnNextStep$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$btnNextStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ResetPasswordActivity.this.findViewById(R.id.btn_nextStep);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnConfirm$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$btnConfirm$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ResetPasswordActivity.this.findViewById(R.id.btn_confirm);
        }
    });

    /* loaded from: classes11.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            boolean z;
            View btnConfirm = ResetPasswordActivity.this.getBtnConfirm();
            if (editable != null && editable.toString().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            btnConfirm.setEnabled(z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            boolean z;
            View btnNextStep = ResetPasswordActivity.this.getBtnNextStep();
            if (editable != null && editable.toString().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            btnNextStep.setEnabled(z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private final Button getBtGetVerificationCode() {
        Object value = this.btGetVerificationCode$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getBtnConfirm() {
        return (View) this.btnConfirm$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getBtnNextStep() {
        return (View) this.btnNextStep$delegate.getValue();
    }

    private final TextInputEditText getEmail() {
        Object value = this.email$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextInputEditText) value;
    }

    private final LinearLayout getLlGetVerificationCode() {
        Object value = this.llGetVerificationCode$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (LinearLayout) value;
    }

    private final LinearLayout getLlSetNewPassword() {
        Object value = this.llSetNewPassword$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (LinearLayout) value;
    }

    private final TextInputEditText getNewPassword() {
        Object value = this.newPassword$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextInputEditText) value;
    }

    private final TextInputEditText getNewPasswordAgain() {
        Object value = this.newPasswordAgain$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextInputEditText) value;
    }

    private final TextView getResetPasswordTip() {
        return (TextView) this.resetPasswordTip$delegate.getValue();
    }

    private final LinearLayout getRv() {
        Object value = this.rv$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (LinearLayout) value;
    }

    private final TextInputEditText getVerificationCode() {
        Object value = this.verificationCode$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextInputEditText) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(ResetPasswordActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.nextStep(this$0.getRv());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(ResetPasswordActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.confirm(this$0.getRv());
            return false;
        }
        return false;
    }

    public final void backClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (getLlSetNewPassword().getVisibility() == 0) {
            getLlSetNewPassword().setVisibility(8);
            getLlGetVerificationCode().setVisibility(0);
        } else {
            finish();
        }
    }

    public final void confirm(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (String.valueOf(getNewPassword().getText()).length() == 0) {
            ToastUtils.showLong(R.string.input_password);
            return;
        }
        if (String.valueOf(getNewPasswordAgain().getText()).length() == 0) {
            ToastUtils.showLong(R.string.input_password_again);
            return;
        }
        Editable text = getNewPassword().getText();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(text);
        if (text.length() >= 6) {
            Editable text2 = getNewPassword().getText();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(text2);
            if (text2.length() <= 32) {
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(String.valueOf(getNewPassword().getText()), String.valueOf(getNewPasswordAgain().getText()))) {
                    ToastUtils.showLong(R.string.inconsistent_passwords);
                    return;
                }
                NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
                HashMap<String, String> resetPasswordBody = RequestBodyKt.getResetPasswordBody(String.valueOf(getEmail().getText()), String.valueOf(getNewPassword().getText()), String.valueOf(getVerificationCode().getText()));
                final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$confirm$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        ToastUtils.showLong(error.toString(), new Object[0]);
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        ToastUtils.showLong(R.string.password_updated_successfully);
                        ResetPasswordActivity.this.finish();
                    }
                };
                final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRv());
                String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), ResetPassword.URL);
                netWorkUtils.printParam(convertBaseUrl + ResetPassword.URL, resetPasswordBody);
                NetWork netWork = NetWork.f19682oIX0oI;
                String str = convertBaseUrl + ResetPassword.URL;
                final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$confirm$$inlined$post$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                        NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                        Activity activity = this;
                        xxxI.II0xO0 iI0xO03 = iI0xO0;
                        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                        LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                        if (response == null) {
                            response = new Response<>();
                            response.setCode(-1000);
                        }
                        netWorkUtils2.responseWhenCheck(activity, response, iI0xO03);
                        if (i0X0x0oIo != null) {
                            i0X0x0oIo.dismiss();
                        }
                    }
                };
                AndroidNetworking.post(str).addBodyParameter((Map<String, String>) resetPasswordBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.me.ResetPasswordActivity$confirm$$inlined$post$2
                    @Override // com.androidnetworking.interfaces.ParsedRequestListener
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void onResponse(@OXOo.OOXIXo Response<String> response) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                        xxxI.II0xO0.this.handleResponse(response);
                    }

                    @Override // com.androidnetworking.interfaces.ParsedRequestListener
                    public void onError(@OXOo.oOoXoXO ANError aNError) {
                        Integer num;
                        String str2;
                        String str3;
                        Response response;
                        StringBuilder sb = new StringBuilder();
                        sb.append("errorCode:");
                        Integer num2 = null;
                        if (aNError != null) {
                            num = Integer.valueOf(aNError.getErrorCode());
                        } else {
                            num = null;
                        }
                        sb.append(num);
                        sb.append(", errorBody:");
                        if (aNError != null) {
                            str2 = aNError.getErrorBody();
                        } else {
                            str2 = null;
                        }
                        sb.append(str2);
                        sb.append(", ");
                        if (aNError != null) {
                            str3 = aNError.getErrorDetail();
                        } else {
                            str3 = null;
                        }
                        sb.append(str3);
                        LogUtils.d(sb.toString());
                        if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                            num2 = Integer.valueOf(response.getCode());
                        } else if (aNError != null) {
                            num2 = Integer.valueOf(aNError.getErrorCode());
                        }
                        xxxI.II0xO0.this.handleError(String.valueOf(num2));
                    }
                });
                return;
            }
        }
        ToastUtils.showLong(R.string.length_passwords);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getLlGetVerificationCode().setVisibility(0);
        int i = 8;
        getLlSetNewPassword().setVisibility(8);
        TextView resetPasswordTip = getResetPasswordTip();
        if (ProjectManager.f19822oIX0oI.XX0xXo()) {
            i = 0;
        }
        resetPasswordTip.setVisibility(i);
        getVerificationCode().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.me.OIxOX
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean initView$lambda$1;
                initView$lambda$1 = ResetPasswordActivity.initView$lambda$1(ResetPasswordActivity.this, textView, i2, keyEvent);
                return initView$lambda$1;
            }
        });
        getBtnNextStep().setEnabled(false);
        getVerificationCode().addTextChangedListener(new oIX0oI());
        getNewPasswordAgain().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.me.x0OOI
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean initView$lambda$2;
                initView$lambda$2 = ResetPasswordActivity.initView$lambda$2(ResetPasswordActivity.this, textView, i2, keyEvent);
                return initView$lambda$2;
            }
        });
        getBtnConfirm().setEnabled(false);
        getNewPasswordAgain().addTextChangedListener(new II0xO0());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.reset_password_activity;
    }

    public final void nextStep(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (String.valueOf(getEmail().getText()).length() == 0) {
            ToastUtils.showLong(R.string.input_email);
        } else if (String.valueOf(getVerificationCode().getText()).length() == 0) {
            ToastUtils.showLong(R.string.enter_confirmation_code);
        } else {
            getLlGetVerificationCode().setVisibility(8);
            getLlSetNewPassword().setVisibility(0);
        }
    }

    public final void getVerificationCode(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        RequestCommonMethod.requestVerificationCode$default(RequestCommonMethod.INSTANCE, this, getRv(), String.valueOf(getEmail().getText()), getBtGetVerificationCode(), 0, null, 48, null);
    }
}
