package com.sma.smartv3.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.BleDevice;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetDevice;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.network.SignInByVerificationCode;
import com.sma.smartv3.network.Signin;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.ui.me.ResetPasswordActivity;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import java.util.HashMap;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.Xo0;
import kotlin.collections.OI0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLoginActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginActivity.kt\ncom/sma/smartv3/ui/login/LoginActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 5 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,193:1\n69#2,3:194\n72#2,5:198\n1#3:197\n158#4,4:203\n171#4:215\n158#4,4:216\n171#4:228\n208#5,7:207\n226#5:214\n208#5,7:220\n226#5:227\n*S KotlinDebug\n*F\n+ 1 LoginActivity.kt\ncom/sma/smartv3/ui/login/LoginActivity\n*L\n101#1:194,3\n101#1:198,5\n101#1:197\n164#1:203,4\n164#1:215\n179#1:216,4\n179#1:228\n164#1:207,7\n164#1:214\n179#1:220,7\n179#1:227\n*E\n"})
/* loaded from: classes12.dex */
public final class LoginActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final X0IIOO email$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.LoginActivity$email$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) LoginActivity.this.findViewById(R.id.email);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO passwordTil$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.LoginActivity$passwordTil$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) LoginActivity.this.findViewById(R.id.passwordTil);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO password$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.LoginActivity$password$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) LoginActivity.this.findViewById(R.id.password);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO verificationCodeLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.LoginActivity$verificationCodeLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) LoginActivity.this.findViewById(R.id.verificationCodeLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO verificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.LoginActivity$verificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) LoginActivity.this.findViewById(R.id.verificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btGetVerificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.LoginActivity$btGetVerificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) LoginActivity.this.findViewById(R.id.btGetVerificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btLoginType$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.LoginActivity$btLoginType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) LoginActivity.this.findViewById(R.id.btLoginType);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.LoginActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) LoginActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO loginRemind$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.LoginActivity$loginRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) LoginActivity.this.findViewById(R.id.loginRemind);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnLogin$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.LoginActivity$btnLogin$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return LoginActivity.this.findViewById(R.id.btn_login);
        }
    });

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            boolean z;
            View btnLogin = LoginActivity.this.getBtnLogin();
            if (editable != null && editable.toString().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            btnLogin.setEnabled(z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            boolean z;
            View btnLogin = LoginActivity.this.getBtnLogin();
            if (editable != null && editable.toString().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            btnLogin.setEnabled(z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private final Button getBtGetVerificationCode() {
        return (Button) this.btGetVerificationCode$delegate.getValue();
    }

    private final Button getBtLoginType() {
        return (Button) this.btLoginType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getBtnLogin() {
        return (View) this.btnLogin$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getDeviceInfo(String str) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        Map<String, String> OOXIXo2 = OI0.OOXIXo(Xo0.oIX0oI("identity", str));
        final xxxI.II0xO0<BleDevice> iI0xO0 = new xxxI.II0xO0<BleDevice>() { // from class: com.sma.smartv3.ui.login.LoginActivity$getDeviceInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BleDevice bleDevice) {
                com.sma.smartv3.ble.II0xO0.f20317oIX0oI.XI0IXoo(bleDevice);
                ProjectManager.f19822oIX0oI.x0oxIIIX(LoginActivity.this);
                x0xO0oo.II0xO0(x0xO0oo.f24563I0X0x0oIo, null, 2, null);
                LoginActivity.this.finish();
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRv());
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetDevice.URL);
        netWorkUtils.printParam(convertBaseUrl + GetDevice.URL, OOXIXo2);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + GetDevice.URL;
        final xxxI.II0xO0<Response<BleDevice>> iI0xO02 = new xxxI.II0xO0<Response<BleDevice>>() { // from class: com.sma.smartv3.ui.login.LoginActivity$getDeviceInfo$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BleDevice> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = this;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
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
        AndroidNetworking.post(str2).addBodyParameter(OOXIXo2).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BleDevice.class), new ParsedRequestListener<Response<BleDevice>>() { // from class: com.sma.smartv3.ui.login.LoginActivity$getDeviceInfo$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BleDevice> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", ");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    private final TextInputEditText getEmail() {
        return (TextInputEditText) this.email$delegate.getValue();
    }

    private final PFMedium getLoginRemind() {
        return (PFMedium) this.loginRemind$delegate.getValue();
    }

    private final TextInputEditText getPassword() {
        return (TextInputEditText) this.password$delegate.getValue();
    }

    private final RelativeLayout getPasswordTil() {
        return (RelativeLayout) this.passwordTil$delegate.getValue();
    }

    private final LinearLayout getRv() {
        return (LinearLayout) this.rv$delegate.getValue();
    }

    private final TextInputEditText getVerificationCode() {
        return (TextInputEditText) this.verificationCode$delegate.getValue();
    }

    private final LinearLayout getVerificationCodeLl() {
        return (LinearLayout) this.verificationCodeLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$0(LoginActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            LinearLayout rv = this$0.getRv();
            IIX0o.oO(rv, "<get-rv>(...)");
            this$0.login(rv);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(LoginActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            LinearLayout rv = this$0.getRv();
            IIX0o.oO(rv, "<get-rv>(...)");
            this$0.login(rv);
            return false;
        }
        return false;
    }

    private final void loginRequest(HashMap<String, String> hashMap, String str) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.login.LoginActivity$loginRequest$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser) {
                String identity;
                com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(appUser));
                if (appUser != null && (identity = appUser.getIdentity()) != null) {
                    LoginActivity.this.getDeviceInfo(identity);
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRv());
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), str);
        netWorkUtils.printParam(convertBaseUrl + str, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + str;
        final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.LoginActivity$loginRequest$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = this;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
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
        AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.LoginActivity$loginRequest$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", ");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    private final void showLoginRemind() {
        if (ProjectManager.f19822oIX0oI.X00IoxXI()) {
            getLoginRemind().setVisibility(0);
        } else {
            getLoginRemind().setVisibility(8);
        }
    }

    public final void forgetPassword(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) ResetPasswordActivity.class));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        showLoginRemind();
        getBtnLogin().setEnabled(false);
        getPassword().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.oxoX
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$0;
                initView$lambda$0 = LoginActivity.initView$lambda$0(LoginActivity.this, textView, i, keyEvent);
                return initView$lambda$0;
            }
        });
        getPassword().addTextChangedListener(new oIX0oI());
        getVerificationCode().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.X0o0xo
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$1;
                initView$lambda$1 = LoginActivity.initView$lambda$1(LoginActivity.this, textView, i, keyEvent);
                return initView$lambda$1;
            }
        });
        getVerificationCode().addTextChangedListener(new II0xO0());
        TextView textView = (TextView) findViewById(R.id.tv_link);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_login;
    }

    public final void login(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (String.valueOf(getEmail().getText()).length() == 0) {
            ToastUtils.showLong(R.string.input_email);
            return;
        }
        if (getPasswordTil().isShown()) {
            if (String.valueOf(getPassword().getText()).length() == 0) {
                ToastUtils.showLong(R.string.input_password);
                return;
            } else {
                loginRequest(RequestBodyKt.getLoginByPasswordBody(String.valueOf(getEmail().getText()), String.valueOf(getPassword().getText())), Signin.URL);
                return;
            }
        }
        if (String.valueOf(getVerificationCode().getText()).length() == 0) {
            ToastUtils.showLong(R.string.enter_confirmation_code);
        } else {
            loginRequest(RequestBodyKt.getLoginByCodeBody(String.valueOf(getEmail().getText()), String.valueOf(getVerificationCode().getText())), SignInByVerificationCode.URL);
        }
    }

    public final void passwordLoginType(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        boolean z = true;
        if (IIX0o.Oxx0IOOO(getBtLoginType().getText(), getText(R.string.password_login))) {
            getBtLoginType().setText(R.string.code_login);
            getVerificationCodeLl().setVisibility(8);
            getPasswordTil().setVisibility(0);
            showLoginRemind();
            View btnLogin = getBtnLogin();
            if (getPassword().getText() == null || String.valueOf(getPassword().getText()).length() <= 0) {
                z = false;
            }
            btnLogin.setEnabled(z);
            return;
        }
        getBtLoginType().setText(R.string.password_login);
        getVerificationCodeLl().setVisibility(0);
        getPasswordTil().setVisibility(8);
        getLoginRemind().setVisibility(0);
        View btnLogin2 = getBtnLogin();
        if (getVerificationCode().getText() == null || String.valueOf(getVerificationCode().getText()).length() <= 0) {
            z = false;
        }
        btnLogin2.setEnabled(z);
    }

    public final void getVerificationCode(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        RequestCommonMethod requestCommonMethod = RequestCommonMethod.INSTANCE;
        LinearLayout rv = getRv();
        String valueOf = String.valueOf(getEmail().getText());
        Button btGetVerificationCode = getBtGetVerificationCode();
        IIX0o.oO(btGetVerificationCode, "<get-btGetVerificationCode>(...)");
        RequestCommonMethod.requestVerificationCode$default(requestCommonMethod, this, rv, valueOf, btGetVerificationCode, 0, null, 48, null);
    }
}
