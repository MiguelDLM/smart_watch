package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.Feedback;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nFeedbackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackActivity.kt\ncom/sma/smartv3/ui/me/FeedbackActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 5 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,86:1\n19#2:87\n15#2:88\n65#3,16:89\n93#3,3:105\n158#4,4:108\n171#4:120\n208#5,7:112\n226#5:119\n*S KotlinDebug\n*F\n+ 1 FeedbackActivity.kt\ncom/sma/smartv3/ui/me/FeedbackActivity\n*L\n27#1:87\n27#1:88\n40#1:89,16\n40#1:105,3\n63#1:108,4\n63#1:120\n63#1:112,7\n63#1:119\n*E\n"})
/* loaded from: classes11.dex */
public final class FeedbackActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int MAX_LENGTH = 500;

    @OXOo.OOXIXo
    private final AppUser appUser;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtFeedback$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$edtFeedback$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) FeedbackActivity.this.findViewById(R.id.edt_feedback);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtContact$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$edtContact$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) FeedbackActivity.this.findViewById(R.id.edt_contact);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCount$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$tvCount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) FeedbackActivity.this.findViewById(R.id.tv_count);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) FeedbackActivity.this.findViewById(R.id.rootView);
        }
    });

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 FeedbackActivity.kt\ncom/sma/smartv3/ui/me/FeedbackActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n41#2,5:98\n71#3:103\n77#4:104\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            if (editable != null && editable.length() > 500) {
                editable.delete(500, editable.length());
            }
            FeedbackActivity.this.updateCount();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public FeedbackActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.appUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final EditText getEdtContact() {
        return (EditText) this.edtContact$delegate.getValue();
    }

    private final EditText getEdtFeedback() {
        return (EditText) this.edtFeedback$delegate.getValue();
    }

    private final LinearLayout getRootView() {
        return (LinearLayout) this.rootView$delegate.getValue();
    }

    private final TextView getTvCount() {
        return (TextView) this.tvCount$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCount() {
        int length = getEdtFeedback().getText().length();
        TextView tvCount = getTvCount();
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(length), 500}, 2));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        tvCount.setText(format);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.feedback);
        if (this.appUser.getEmail().length() > 0) {
            getEdtContact().setText(this.appUser.getEmail());
        }
        updateCount();
        EditText edtFeedback = getEdtFeedback();
        kotlin.jvm.internal.IIX0o.oO(edtFeedback, "<get-edtFeedback>(...)");
        edtFeedback.addTextChangedListener(new II0xO0());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_feedback;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (getEdtFeedback().getText().toString().length() == 0) {
            ToastUtils.showLong(R.string.detailed_description_of_the_problem);
            return;
        }
        if (getEdtContact().getText().toString().length() == 0 || !RegexUtils.isEmail(getEdtContact().getText())) {
            ToastUtils.showLong(R.string.email_format_error);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> feedbackBody = RequestBodyKt.getFeedbackBody(getMContext(), getEdtContact().getText().toString(), getEdtFeedback().getText().toString());
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$onBottomClick$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                ToastUtils.showLong(R.string.feedback_success);
                FeedbackActivity.this.finish();
            }
        };
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRootView());
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), Feedback.URL);
        netWorkUtils.printParam(convertBaseUrl + Feedback.URL, feedbackBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + Feedback.URL;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$onBottomClick$$inlined$post$1
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) feedbackBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.me.FeedbackActivity$onBottomClick$$inlined$post$2
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
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
