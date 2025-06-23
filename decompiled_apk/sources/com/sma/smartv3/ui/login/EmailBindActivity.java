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
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.material.textfield.TextInputEditText;
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
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import java.util.HashMap;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nEmailBindActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmailBindActivity.kt\ncom/sma/smartv3/ui/login/EmailBindActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,258:1\n19#2:259\n15#2:260\n151#3,11:261\n171#3:280\n151#3,11:281\n171#3:300\n208#4,7:272\n226#4:279\n208#4,7:292\n226#4:299\n69#5,3:301\n72#5,5:305\n1#6:304\n*S KotlinDebug\n*F\n+ 1 EmailBindActivity.kt\ncom/sma/smartv3/ui/login/EmailBindActivity\n*L\n46#1:259\n46#1:260\n137#1:261,11\n137#1:280\n163#1:281,11\n163#1:300\n137#1:272,7\n137#1:279\n163#1:292,7\n163#1:299\n197#1:301,3\n197#1:305,5\n197#1:304\n*E\n"})
/* loaded from: classes12.dex */
public final class EmailBindActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_FORCED = 2;
    public static final int TYPE_NEW_MAIL = 1;
    public static final int TYPE_RECOVER_DEFAULT = 3;
    private boolean isExistsEmail;

    @OXOo.OOXIXo
    private AppUser mAppUser;
    private int nowPage;
    private int verificationType;

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) EmailBindActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llInputEmail$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$llInputEmail$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) EmailBindActivity.this.findViewById(R.id.llInputEmail);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llCheckCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$llCheckCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) EmailBindActivity.this.findViewById(R.id.llCheckCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$tvTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) EmailBindActivity.this.findViewById(R.id.tvTitle);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvDescription$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$tvDescription$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) EmailBindActivity.this.findViewById(R.id.tvDescription);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO email$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$email$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) EmailBindActivity.this.findViewById(R.id.email);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO verificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$verificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) EmailBindActivity.this.findViewById(R.id.verificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btGetVerificationCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$btGetVerificationCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) EmailBindActivity.this.findViewById(R.id.btGetVerificationCode);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bottomBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$bottomBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) EmailBindActivity.this.findViewById(R.id.bottom_btn);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvCodeError$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$tvCodeError$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) EmailBindActivity.this.findViewById(R.id.tvCodeError);
        }
    });

    /* loaded from: classes12.dex */
    public static final class I0Io implements TextWatcher {
        public I0Io() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            if (String.valueOf(EmailBindActivity.this.getVerificationCode().getText()).length() == 4) {
                EmailBindActivity emailBindActivity = EmailBindActivity.this;
                emailBindActivity.changeEmail(String.valueOf(emailBindActivity.getVerificationCode().getText()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            EmailBindActivity.this.getTvCodeError().setVisibility(8);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            EmailBindActivity.this.getBottomBtn().setEnabled(StringsKt__StringsKt.o00xOoIO(String.valueOf(EmailBindActivity.this.getEmail().getText()), "@", false, 2, null));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public EmailBindActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeEmail(String str) {
        final Activity activity = null;
        if (this.mAppUser.getEmail().length() == 0 || getMArg1() == 1) {
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            HashMap<String, String> setEmailBody = RequestBodyKt.getSetEmailBody(this.mAppUser.getIdentity(), String.valueOf(getEmail().getText()), str);
            final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    EmailBindActivity.this.getTvCodeError().setVisibility(0);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO AppUser appUser) {
                    AppUser appUser2;
                    AppUser appUser3;
                    appUser2 = EmailBindActivity.this.mAppUser;
                    appUser2.setEmail(String.valueOf(EmailBindActivity.this.getEmail().getText()));
                    SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                    appUser3 = EmailBindActivity.this.mAppUser;
                    XO2.put(AppUser.class.getName(), new Gson().toJson(appUser3));
                    x0xO0oo.II0xO0(x0xO0oo.f24587O0Xx, null, 2, null);
                    if (EmailBindActivity.this.getMArg1() == 2) {
                        EmailBindActivity emailBindActivity = EmailBindActivity.this;
                        emailBindActivity.startActivity(new Intent(emailBindActivity, (Class<?>) MainActivity.class));
                    }
                    EmailBindActivity.this.finish();
                }
            };
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
            String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), SetEmail.URL);
            netWorkUtils.printParam(convertBaseUrl + SetEmail.URL, setEmailBody);
            NetWork netWork = NetWork.f19682oIX0oI;
            String str2 = convertBaseUrl + SetEmail.URL;
            final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$$inlined$post$default$1
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
            AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) setEmailBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$$inlined$post$default$2
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
        HashMap<String, String> verificationCodeCheckBody = RequestBodyKt.getVerificationCodeCheckBody(String.valueOf(getEmail().getText()), str);
        final xxxI.II0xO0<String> iI0xO03 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                EmailBindActivity.this.getTvCodeError().setVisibility(0);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str3) {
                EmailBindActivity emailBindActivity = EmailBindActivity.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 1);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(emailBindActivity, (Class<?>) EmailBindActivity.class);
                intent.putExtras(bundle);
                emailBindActivity.startActivity(intent);
                EmailBindActivity.this.finish();
            }
        };
        final I0X0x0oIo loadPopup2 = netWorkUtils2.loadPopup(null, null);
        String convertBaseUrl2 = netWorkUtils2.convertBaseUrl(Api.INSTANCE.getBASE_URL(), VerificationCodeCheck.URL);
        netWorkUtils2.printParam(convertBaseUrl2 + VerificationCodeCheck.URL, verificationCodeCheckBody);
        NetWork netWork2 = NetWork.f19682oIX0oI;
        String str3 = convertBaseUrl2 + VerificationCodeCheck.URL;
        final xxxI.II0xO0<Response<String>> iI0xO04 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$$inlined$post$default$3
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
        AndroidNetworking.post(str3).addBodyParameter((Map<String, String>) verificationCodeCheckBody).setTag((Object) str3).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$changeEmail$$inlined$post$default$4
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

    /* JADX INFO: Access modifiers changed from: private */
    public final TextInputEditText getEmail() {
        return (TextInputEditText) this.email$delegate.getValue();
    }

    private final LinearLayout getLlCheckCode() {
        return (LinearLayout) this.llCheckCode$delegate.getValue();
    }

    private final LinearLayout getLlInputEmail() {
        return (LinearLayout) this.llInputEmail$delegate.getValue();
    }

    private final LinearLayout getRv() {
        return (LinearLayout) this.rv$delegate.getValue();
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
    public static final void initView$lambda$0(EmailBindActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        TextInputEditText email = this$0.getEmail();
        IIX0o.oO(email, "<get-email>(...)");
        this$0.getVerificationCode(email);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(EmailBindActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            TextInputEditText email = this$0.getEmail();
            IIX0o.oO(email, "<get-email>(...)");
            this$0.getVerificationCode(email);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(EmailBindActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.changeEmail(String.valueOf(this$0.getVerificationCode().getText()));
            return false;
        }
        return false;
    }

    public final void backClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        int mArg1 = getMArg1();
        if (mArg1 != 2) {
            if (mArg1 != 3) {
                Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24370IoOoX, true);
                finish();
                return;
            } else {
                if (this.nowPage > 0) {
                    onBackPressed();
                    return;
                }
                Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24370IoOoX, true);
                startActivity(new Intent(this, (Class<?>) MainActivity.class));
                finish();
                return;
            }
        }
        if (this.nowPage > 0) {
            onBackPressed();
        } else {
            ToastUtils.showShort(R.string.input_email);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (this.mAppUser.getEmail().length() == 0) {
            this.verificationType = 2;
            this.isExistsEmail = false;
            getTvTitle().setText(R.string.bind_email);
            getTvDescription().setText(R.string.bind_email_tips);
        } else if (getMArg1() == 1) {
            this.nowPage++;
            this.verificationType = 2;
            this.isExistsEmail = false;
            getTvTitle().setText(R.string.update_email);
            getTvDescription().setText(R.string.safety_verification_tips);
            getLlInputEmail().setVisibility(0);
            getBottomBtn().setVisibility(0);
            getLlCheckCode().setVisibility(8);
        } else {
            this.verificationType = 1;
            this.nowPage = -1;
            this.isExistsEmail = true;
            getTvTitle().setText(R.string.safety_verification);
            getTvDescription().setText(R.string.safety_verification_tips);
            getEmail().setText(this.mAppUser.getEmail());
            getBottomBtn().setVisibility(8);
            ToastUtils.showShort(getString(R.string.verifying_information), new Object[0]);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.login.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    EmailBindActivity.initView$lambda$0(EmailBindActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        getBottomBtn().setEnabled(false);
        getEmail().addTextChangedListener(new II0xO0());
        getVerificationCode().addTextChangedListener(new I0Io());
        getEmail().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.II0xO0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$1;
                initView$lambda$1 = EmailBindActivity.initView$lambda$1(EmailBindActivity.this, textView, i, keyEvent);
                return initView$lambda$1;
            }
        });
        getVerificationCode().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.ui.login.I0Io
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$2;
                initView$lambda$2 = EmailBindActivity.initView$lambda$2(EmailBindActivity.this, textView, i, keyEvent);
                return initView$lambda$2;
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_email_bind;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.nowPage;
        if (i > 0) {
            this.nowPage = i - 1;
            getLlInputEmail().setVisibility(0);
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
        if (!RegexUtils.isEmail(String.valueOf(getEmail().getText()))) {
            ToastUtils.showShort(R.string.email_format_error);
            return;
        }
        int i = this.nowPage;
        if (i == 0) {
            this.nowPage = i + 1;
        }
        getLlInputEmail().setVisibility(8);
        getLlCheckCode().setVisibility(0);
        getTvCodeError().setVisibility(8);
        RequestCommonMethod requestCommonMethod = RequestCommonMethod.INSTANCE;
        LinearLayout rv = getRv();
        String valueOf = String.valueOf(getEmail().getText());
        Button btGetVerificationCode = getBtGetVerificationCode();
        IIX0o.oO(btGetVerificationCode, "<get-btGetVerificationCode>(...)");
        requestCommonMethod.requestVerificationCode(this, rv, valueOf, btGetVerificationCode, this.verificationType, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.login.EmailBindActivity$getVerificationCode$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                if (EmailBindActivity.this.getMArg1() == 2 && StringsKt__StringsKt.o00xOoIO(error, "code=2003", false, 2, null)) {
                    EmailBindActivity.this.setMArg1(3);
                    Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24370IoOoX, true);
                    EmailBindActivity emailBindActivity = EmailBindActivity.this;
                    emailBindActivity.startActivity(new Intent(emailBindActivity, (Class<?>) MainActivity.class));
                    EmailBindActivity.this.finish();
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
            }
        });
    }
}
