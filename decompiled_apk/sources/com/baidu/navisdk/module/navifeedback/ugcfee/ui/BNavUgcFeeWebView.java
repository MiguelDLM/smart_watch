package com.baidu.navisdk.module.navifeedback.ugcfee.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.mapframework.braavos.CallbackContext;
import com.baidu.navisdk.ui.widget.BNBraavosView;
import com.baidu.navisdk.util.common.g;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class BNavUgcFeeWebView extends BNBraavosView {

    /* renamed from: a, reason: collision with root package name */
    private a f7205a;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(CallbackContext callbackContext);

        void a(String str, String str2);
    }

    public BNavUgcFeeWebView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.navisdk.ui.widget.BNBraavosView
    public void dispatchMessage(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        String str2;
        String str3 = "";
        if (this.f7205a == null) {
            return;
        }
        if ("getUgcFeeContent".equals(str)) {
            this.f7205a.a(callbackContext);
            return;
        }
        if ("updateRealFee".equals(str)) {
            try {
                str2 = jSONArray.getJSONObject(0).optString("realFee", "");
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                str3 = jSONArray.getJSONObject(0).optJSONArray("list").toString();
            } catch (Exception unused2) {
                g gVar = g.TRAJECTORY;
                if (gVar.d()) {
                    gVar.g("BNavUgcFeeWebView", "update fee error!");
                }
                this.f7205a.a(str2, str3);
                return;
            }
            this.f7205a.a(str2, str3);
            return;
        }
        if ("pageClose".equals(str)) {
            this.f7205a.a();
        }
    }

    public void setActionCallback(a aVar) {
        this.f7205a = aVar;
    }

    public BNavUgcFeeWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNavUgcFeeWebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public BNavUgcFeeWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
