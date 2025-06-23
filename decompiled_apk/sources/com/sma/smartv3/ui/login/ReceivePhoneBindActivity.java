package com.sma.smartv3.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
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
import com.sma.smartv3.network.SetReceivePhone;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;
import me.zheteng.countrycodeselector.Country;
import me.zheteng.countrycodeselector.CountryCodeSelectorFragment;
import me.zheteng.countrycodeselector.PhoneInputView;

@XX({"SMAP\nReceivePhoneBindActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceivePhoneBindActivity.kt\ncom/sma/smartv3/ui/login/ReceivePhoneBindActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,119:1\n19#2:120\n15#2:121\n158#3,4:122\n171#3:134\n208#4,7:126\n226#4:133\n*S KotlinDebug\n*F\n+ 1 ReceivePhoneBindActivity.kt\ncom/sma/smartv3/ui/login/ReceivePhoneBindActivity\n*L\n37#1:120\n37#1:121\n75#1:122,4\n75#1:134\n75#1:126,7\n75#1:133\n*E\n"})
/* loaded from: classes12.dex */
public final class ReceivePhoneBindActivity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ReceivePhoneBindActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$tvCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ReceivePhoneBindActivity.this.findViewById(R.id.tv_code);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO phone$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$phone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) ReceivePhoneBindActivity.this.findViewById(R.id.phone);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO privacyAppCheck$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$privacyAppCheck$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) ReceivePhoneBindActivity.this.findViewById(R.id.privacyAppCheck);
        }
    });

    public ReceivePhoneBindActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final TextInputEditText getPhone() {
        return (TextInputEditText) this.phone$delegate.getValue();
    }

    private final CheckBox getPrivacyAppCheck() {
        return (CheckBox) this.privacyAppCheck$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final TextView getTvCode() {
        return (TextView) this.tvCode$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCountryCode$lambda$2$lambda$1(ReceivePhoneBindActivity this$0, CountryCodeSelectorFragment countryCodeSelectorFragment, Country country) {
        IIX0o.x0xO0oo(this$0, "this$0");
        String oIX0oI2 = country.oIX0oI();
        IIX0o.oO(oIX0oI2, "getCode(...)");
        if (oIX0oI2.length() > 0) {
            this$0.getTvCode().setText('+' + country.oIX0oI());
        } else {
            this$0.getTvCode().setText("");
        }
        countryCodeSelectorFragment.dismiss();
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
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.phone_number);
        String receivePhone = this.mAppUser.getReceivePhone();
        if (!TextUtils.isEmpty(receivePhone)) {
            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(receivePhone, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, null);
            getTvCode().setText((CharSequence) XXoO0oX2.get(0));
            getPhone().setText((CharSequence) XXoO0oX2.get(1));
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_receive_phone_bind;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (!getPrivacyAppCheck().isChecked()) {
            ToastUtils.showLong(R.string.privacy_tick_tip);
            return;
        }
        final String valueOf = String.valueOf(getPhone().getText());
        if (valueOf.length() == 0) {
            ToastUtils.showLong(R.string.input_phone_num_tip);
            return;
        }
        String obj = getTvCode().getText().toString();
        if (obj.length() != 0) {
            valueOf = obj + '-' + valueOf;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> setReceivePhoneBody = RequestBodyKt.getSetReceivePhoneBody(this.mAppUser.getIdentity(), valueOf);
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$onBottomClick$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                AppUser appUser;
                AppUser appUser2;
                LogUtils.d("handleResponse -> " + str);
                appUser = ReceivePhoneBindActivity.this.mAppUser;
                appUser.setReceivePhone(valueOf);
                SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                appUser2 = ReceivePhoneBindActivity.this.mAppUser;
                XO2.put(AppUser.class.getName(), new Gson().toJson(appUser2));
                x0xO0oo.II0xO0(x0xO0oo.f24666xoxXI, null, 2, null);
                ReceivePhoneBindActivity.this.finish();
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRootView());
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), SetReceivePhone.URL);
        netWorkUtils.printParam(convertBaseUrl + SetReceivePhone.URL, setReceivePhoneBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + SetReceivePhone.URL;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$onBottomClick$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) setReceivePhoneBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.login.ReceivePhoneBindActivity$onBottomClick$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
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

    public final void onCountryCode(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Intent intent = new Intent();
        intent.putExtra(PhoneInputView.f30986XI0IXoo, 1);
        intent.putExtra(PhoneInputView.f30985X0IIOO, ContextCompat.getColor(getMContext(), R.color.colorPrimary));
        final CountryCodeSelectorFragment newInstance = CountryCodeSelectorFragment.newInstance(intent);
        newInstance.show(getSupportFragmentManager(), "CountryCodeSelector");
        newInstance.setOnCountrySelectListener(new CountryCodeSelectorFragment.oIX0oI() { // from class: com.sma.smartv3.ui.login.OOXIXo
            @Override // me.zheteng.countrycodeselector.CountryCodeSelectorFragment.oIX0oI
            public final void oIX0oI(Country country) {
                ReceivePhoneBindActivity.onCountryCode$lambda$2$lambda$1(ReceivePhoneBindActivity.this, newInstance, country);
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
