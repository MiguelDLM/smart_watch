package com.sma.smartv3.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.network.SetEmail;
import com.sma.smartv3.network.VerificationCodeCheck;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nPhoneBindActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneBindActivity.kt\ncom/sma/smartv3/ui/login/PhoneBindActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,209:1\n19#2:210\n15#2:211\n151#3,11:212\n171#3:231\n151#3,11:232\n171#3:251\n208#4,7:223\n226#4:230\n208#4,7:243\n226#4:250\n*S KotlinDebug\n*F\n+ 1 PhoneBindActivity.kt\ncom/sma/smartv3/ui/login/PhoneBindActivity\n*L\n46#1:210\n46#1:211\n134#1:212,11\n134#1:231\n156#1:232,11\n156#1:251\n134#1:223,7\n134#1:230\n156#1:243,7\n156#1:250\n*E\n"})
/* loaded from: classes12.dex */
public final class PhoneBindActivity extends BaseActivity {
    private boolean isExistsPhone;

    @OXOo.OOXIXo
    private AppUser mAppUser;
    private int nowPage;
    private int verificationType;

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) PhoneBindActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llInputPhone$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$llInputPhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) PhoneBindActivity.this.findViewById(R.id.llInputPhone);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llCheckCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$llCheckCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) PhoneBindActivity.this.findViewById(R.id.llCheckCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$tvTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PhoneBindActivity.this.findViewById(R.id.tvTitle);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvDescription$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$tvDescription$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PhoneBindActivity.this.findViewById(R.id.tvDescription);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$tvCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PhoneBindActivity.this.findViewById(R.id.tv_code);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO phone$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$phone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) PhoneBindActivity.this.findViewById(R.id.phone);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO verificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$verificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) PhoneBindActivity.this.findViewById(R.id.verificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btGetVerificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$btGetVerificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PhoneBindActivity.this.findViewById(R.id.btGetVerificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bottomBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$bottomBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PhoneBindActivity.this.findViewById(R.id.bottom_btn);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvCodeError$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$tvCodeError$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PhoneBindActivity.this.findViewById(R.id.tvCodeError);
        }
    });

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            if (String.valueOf(PhoneBindActivity.this.getVerificationCode().getText()).length() == 4) {
                PhoneBindActivity phoneBindActivity = PhoneBindActivity.this;
                phoneBindActivity.changePhone(String.valueOf(phoneBindActivity.getVerificationCode().getText()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            PhoneBindActivity.this.getTvCodeError().setVisibility(8);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            boolean z;
            Button bottomBtn = PhoneBindActivity.this.getBottomBtn();
            if (String.valueOf(PhoneBindActivity.this.getPhone().getText()).length() > 0) {
                z = true;
            } else {
                z = false;
            }
            bottomBtn.setEnabled(z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public PhoneBindActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    public final void changePhone(String str) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Activity activity = null;
        objectRef.element = RequestCommonMethod.getPhoneWithCode$default(RequestCommonMethod.INSTANCE, null, String.valueOf(getPhone().getText()), 1, null);
        if (this.mAppUser.getPhone().length() == 0 || getMArg1() == 1) {
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            HashMap<String, String> setEmailBody = RequestBodyKt.getSetEmailBody(this.mAppUser.getIdentity(), (String) objectRef.element, str);
            final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    PhoneBindActivity.this.getTvCodeError().setVisibility(0);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO AppUser appUser) {
                    AppUser appUser2;
                    AppUser appUser3;
                    appUser2 = PhoneBindActivity.this.mAppUser;
                    appUser2.setPhone(objectRef.element);
                    SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                    appUser3 = PhoneBindActivity.this.mAppUser;
                    XO2.put(AppUser.class.getName(), new Gson().toJson(appUser3));
                    x0xO0oo.II0xO0(x0xO0oo.f24564I0oOIX, null, 2, null);
                    PhoneBindActivity.this.finish();
                }
            };
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
            String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), SetEmail.URL);
            netWorkUtils.printParam(convertBaseUrl + SetEmail.URL, setEmailBody);
            NetWork netWork = NetWork.f19682oIX0oI;
            String str2 = convertBaseUrl + SetEmail.URL;
            final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$$inlined$post$default$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                    Activity activity2 = activity;
                    xxxI.II0xO0 iI0xO03 = iI0xO0;
                    I0X0x0oIo i0X0x0oIo = loadPopup;
                    LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                    if (response == null) {
                        response = new Response<>();
                        response.setCode(-1000);
                    }
                    netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                    if (i0X0x0oIo != null) {
                        i0X0x0oIo.dismiss();
                    }
                }
            };
            AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) setEmailBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$$inlined$post$default$2
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
            return;
        }
        NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
        HashMap<String, String> verificationCodeCheckBody = RequestBodyKt.getVerificationCodeCheckBody((String) objectRef.element, str);
        final xxxI.II0xO0<String> iI0xO03 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                PhoneBindActivity.this.getTvCodeError().setVisibility(0);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str3) {
                PhoneBindActivity phoneBindActivity = PhoneBindActivity.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 1);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(phoneBindActivity, (Class<?>) PhoneBindActivity.class);
                intent.putExtras(bundle);
                phoneBindActivity.startActivity(intent);
                PhoneBindActivity.this.finish();
            }
        };
        final I0X0x0oIo loadPopup2 = netWorkUtils2.loadPopup(null, null);
        String convertBaseUrl2 = netWorkUtils2.convertBaseUrl(Api.INSTANCE.getBASE_URL(), VerificationCodeCheck.URL);
        netWorkUtils2.printParam(convertBaseUrl2 + VerificationCodeCheck.URL, verificationCodeCheckBody);
        NetWork netWork2 = NetWork.f19682oIX0oI;
        String str3 = convertBaseUrl2 + VerificationCodeCheck.URL;
        final xxxI.II0xO0<Response<String>> iI0xO04 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$$inlined$post$default$3
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO03, loadPopup2);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                NetWorkUtils netWorkUtils3 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO05 = iI0xO03;
                I0X0x0oIo i0X0x0oIo = loadPopup2;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils3.responseWhenCheck(activity2, response, iI0xO05);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str3).addBodyParameter((Map<String, String>) verificationCodeCheckBody).setTag((Object) str3).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.login.PhoneBindActivity$changePhone$$inlined$post$default$4
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str4;
                String str5;
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
                    str4 = aNError.getErrorBody();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", ");
                if (aNError != null) {
                    str5 = aNError.getErrorDetail();
                } else {
                    str5 = null;
                }
                sb.append(str5);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Button getBottomBtn() {
        return (Button) this.bottomBtn$delegate.getValue();
    }

    private final Button getBtGetVerificationCode() {
        return (Button) this.btGetVerificationCode$delegate.getValue();
    }

    private final LinearLayout getLlCheckCode() {
        return (LinearLayout) this.llCheckCode$delegate.getValue();
    }

    private final LinearLayout getLlInputPhone() {
        return (LinearLayout) this.llInputPhone$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextInputEditText getPhone() {
        return (TextInputEditText) this.phone$delegate.getValue();
    }

    private final LinearLayout getRv() {
        return (LinearLayout) this.rv$delegate.getValue();
    }

    private final TextView getTvCode() {
        return (TextView) this.tvCode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvCodeError() {
        return (PFMedium) this.tvCodeError$delegate.getValue();
    }

    private final PFMedium getTvDescription() {
        return (PFMedium) this.tvDescription$delegate.getValue();
    }

    private final PFMedium getTvTitle() {
        return (PFMedium) this.tvTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextInputEditText getVerificationCode() {
        return (TextInputEditText) this.verificationCode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PhoneBindActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        TextInputEditText phone = this$0.getPhone();
        IIX0o.oO(phone, "<get-phone>(...)");
        this$0.getVerificationCode(phone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(PhoneBindActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            TextInputEditText phone = this$0.getPhone();
            IIX0o.oO(phone, "<get-phone>(...)");
            this$0.getVerificationCode(phone);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3(PhoneBindActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.changePhone(String.valueOf(this$0.getVerificationCode().getText()));
            return false;
        }
        return false;
    }

    public final void backClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24445oOXoIIIo, true);
        finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (this.mAppUser.getPhone().length() == 0) {
            this.verificationType = 2;
            this.isExistsPhone = false;
            getTvTitle().setText(R.string.bind_phone_num);
            getTvDescription().setText(R.string.bind_phone_tips);
        } else if (getMArg1() == 1) {
            this.nowPage++;
            this.verificationType = 2;
            this.isExistsPhone = false;
            getTvTitle().setText(R.string.update_phone);
            getTvDescription().setText(R.string.safety_verification_tips);
            getLlInputPhone().setVisibility(0);
            getBottomBtn().setVisibility(0);
            getLlCheckCode().setVisibility(8);
        } else {
            this.verificationType = 1;
            this.nowPage = -1;
            this.isExistsPhone = true;
            getTvTitle().setText(R.string.safety_verification);
            getTvDescription().setText(R.string.safety_verification_tips);
            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(this.mAppUser.getPhone(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, null);
            getTvCode().setText((CharSequence) XXoO0oX2.get(0));
            getPhone().setText((CharSequence) XXoO0oX2.get(1));
            getBottomBtn().setVisibility(8);
            ToastUtils.showShort(getString(R.string.verifying_information), new Object[0]);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.login.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    PhoneBindActivity.initView$lambda$1(PhoneBindActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        getBottomBtn().setEnabled(false);
        getPhone().addTextChangedListener(new oIX0oI());
        getVerificationCode().addTextChangedListener(new II0xO0());
        getPhone().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.xxIXOIIO
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$2;
                initView$lambda$2 = PhoneBindActivity.initView$lambda$2(PhoneBindActivity.this, textView, i, keyEvent);
                return initView$lambda$2;
            }
        });
        getVerificationCode().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.xoIox
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$3;
                initView$lambda$3 = PhoneBindActivity.initView$lambda$3(PhoneBindActivity.this, textView, i, keyEvent);
                return initView$lambda$3;
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_phone_bind;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.nowPage;
        if (i > 0) {
            this.nowPage = i - 1;
            getLlInputPhone().setVisibility(0);
            getBottomBtn().setVisibility(0);
            getLlCheckCode().setVisibility(8);
            return;
        }
        LinearLayout rv = getRv();
        IIX0o.oO(rv, "<get-rv>(...)");
        backClick(rv);
    }

    public final void getVerificationCode(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (!UtilsKt.IoOoX(String.valueOf(getPhone().getText()))) {
            ToastUtils.showShort(R.string.input_phone_format_error);
            return;
        }
        int i = this.nowPage;
        if (i == 0) {
            this.nowPage = i + 1;
        }
        getLlInputPhone().setVisibility(8);
        getLlCheckCode().setVisibility(0);
        getTvCodeError().setVisibility(8);
        RequestCommonMethod requestCommonMethod = RequestCommonMethod.INSTANCE;
        LinearLayout rv = getRv();
        String valueOf = String.valueOf(getPhone().getText());
        Button btGetVerificationCode = getBtGetVerificationCode();
        IIX0o.oO(btGetVerificationCode, "<get-btGetVerificationCode>(...)");
        RequestCommonMethod.requestVerificationCode$default(requestCommonMethod, this, rv, valueOf, btGetVerificationCode, this.verificationType, null, 32, null);
    }
}
