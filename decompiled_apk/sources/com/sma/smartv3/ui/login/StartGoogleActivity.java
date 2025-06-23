package com.sma.smartv3.ui.login;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.ThirdPartyLogin;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import java.util.HashMap;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nStartGoogleActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartGoogleActivity.kt\ncom/sma/smartv3/ui/login/StartGoogleActivity\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,166:1\n158#2,4:167\n171#2:179\n208#3,7:171\n226#3:178\n*S KotlinDebug\n*F\n+ 1 StartGoogleActivity.kt\ncom/sma/smartv3/ui/login/StartGoogleActivity\n*L\n124#1:167,4\n124#1:179\n124#1:171,7\n124#1:178\n*E\n"})
/* loaded from: classes12.dex */
public final class StartGoogleActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            return (NestedScrollView) StartGoogleActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO weChatRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$weChatRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.weChatRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO QQRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$QQRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.QQRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO weiBoRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$weiBoRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.weiBoRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO faceBookRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$faceBookRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.faceBookRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO twitterRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$twitterRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.twitterRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO googleRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$googleRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) StartGoogleActivity.this.findViewById(R.id.googleRl);
        }
    });

    @OXOo.OOXIXo
    private final oIX0oI thirdPartyCallback = new oIX0oI();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements O00.II0xO0 {
        public oIX0oI() {
        }

        @Override // O00.II0xO0
        public void II0xO0(@OXOo.oOoXoXO LoginResponse loginResponse) {
            if (loginResponse != null) {
                StartGoogleActivity.this.thirdPartyLogin(loginResponse);
            } else {
                ToastUtils.showLong(R.string.login_failed_please_try_again);
            }
        }

        @Override // O00.II0xO0
        public void oIX0oI(@OXOo.OOXIXo String lb) {
            IIX0o.x0xO0oo(lb, "lb");
            ToastUtils.showLong(lb, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void thirdPartyLogin(LoginResponse loginResponse) {
        LogUtils.d(loginResponse);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap thirdPartyBody$default = RequestBodyKt.getThirdPartyBody$default(loginResponse.oxoX(), loginResponse.I0Io(), loginResponse.oIX0oI(), null, 8, null);
        final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$thirdPartyLogin$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser) {
                Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(appUser));
                ProjectManager.f19822oIX0oI.x0oxIIIX(StartGoogleActivity.this);
                x0xO0oo.II0xO0(x0xO0oo.f24563I0X0x0oIo, null, 2, null);
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRv());
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), ThirdPartyLogin.URL);
        netWorkUtils.printParam(convertBaseUrl + ThirdPartyLogin.URL, thirdPartyBody$default);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + ThirdPartyLogin.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$thirdPartyLogin$$inlined$post$1
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) thirdPartyBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.StartGoogleActivity$thirdPartyLogin$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
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
    }

    public final void emailLogin(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        ProjectManager.f19822oIX0oI.oxIO0IIo(getMContext());
    }

    public final void faceBook(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        xOOxIO.II0xO0.f34463oIX0oI.II0xO0(this, this.thirdPartyCallback);
    }

    public final RelativeLayout getFaceBookRl() {
        return (RelativeLayout) this.faceBookRl$delegate.getValue();
    }

    public final RelativeLayout getGoogleRl() {
        return (RelativeLayout) this.googleRl$delegate.getValue();
    }

    public final RelativeLayout getQQRl() {
        return (RelativeLayout) this.QQRl$delegate.getValue();
    }

    public final NestedScrollView getRv() {
        return (NestedScrollView) this.rv$delegate.getValue();
    }

    public final RelativeLayout getTwitterRl() {
        return (RelativeLayout) this.twitterRl$delegate.getValue();
    }

    public final RelativeLayout getWeChatRl() {
        return (RelativeLayout) this.weChatRl$delegate.getValue();
    }

    public final RelativeLayout getWeiBoRl() {
        return (RelativeLayout) this.weiBoRl$delegate.getValue();
    }

    public final void google(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        com.sma.androidthirdpartylogin.google.I0Io.f19704oIX0oI.oxoX(this, this.thirdPartyCallback);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        xOOxIO.II0xO0 iI0xO0 = xOOxIO.II0xO0.f34463oIX0oI;
        Application application = getApplication();
        IIX0o.oO(application, "getApplication(...)");
        iI0xO0.oIX0oI(application);
        IxX00.oIX0oI oix0oi = IxX00.oIX0oI.f1099oIX0oI;
        Application application2 = getApplication();
        IIX0o.oO(application2, "getApplication(...)");
        oix0oi.oIX0oI(application2);
        ProjectManager.f19822oIX0oI.xIXIOX(getWeChatRl(), getQQRl(), getWeiBoRl(), getFaceBookRl(), getTwitterRl(), getGoogleRl());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_start_google;
    }

    public final void noLogin(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        ToastUtils.showLong("noLogin", new Object[0]);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        xOOxIO.II0xO0.f34463oIX0oI.I0Io(i, i2, intent);
        com.sma.androidthirdpartylogin.google.I0Io.f19704oIX0oI.X0o0xo(i, intent);
        oxOXxoXII.oIX0oI.f33565oIX0oI.II0xO0(i, i2, intent);
        IxX00.oIX0oI.f1099oIX0oI.I0Io(this, i, i2, intent);
    }

    @XO0.XO(tag = x0xO0oo.f24563I0X0x0oIo)
    public final void onEmailLoginDone(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        if (!isFinishing()) {
            finish();
        }
    }

    @XO0.XO(tag = x0xO0oo.f24615XX0)
    public final void onThirdPartyLogin(@OXOo.OOXIXo LoginResponse data) {
        IIX0o.x0xO0oo(data, "data");
        thirdPartyLogin(data);
    }

    public final void qq(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        if (O00.I0Io.f1137oIX0oI.II0xO0(getMContext())) {
            oxOXxoXII.oIX0oI.f33565oIX0oI.oIX0oI(this, this.thirdPartyCallback);
        } else {
            ToastUtils.showLong(R.string.client_no_installed);
        }
    }

    public final void twitter(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        ToastUtils.showLong("twitter", new Object[0]);
    }

    public final void weChat(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        XO0o.oIX0oI.f3924oIX0oI.oIX0oI(this);
    }

    public final void weiBo(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        IxX00.oIX0oI.f1099oIX0oI.II0xO0(this, this.thirdPartyCallback);
    }
}
