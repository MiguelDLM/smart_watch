package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.aq;

/* loaded from: classes7.dex */
public class PromoteInstallManager {
    private PromoteInstallListener promoteInstallListener;
    private aq promoteInstallProd;

    /* loaded from: classes7.dex */
    public interface PromoteInstallListener {
        void onFail(String str);

        void onSuccess();
    }

    public PromoteInstallManager(Context context, PromoteInstallListener promoteInstallListener) {
        this.promoteInstallListener = promoteInstallListener;
        if (context != null) {
            this.promoteInstallProd = aq.a(context, promoteInstallListener);
        } else if (promoteInstallListener != null) {
            promoteInstallListener.onFail("context为空 初始化失败");
        }
    }

    public IPromoteInstallAdInfo getPromoteInstallAdInfo() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.a() && this.promoteInstallProd.b() == 1) {
            return this.promoteInstallProd.a(false);
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能未加白，请联系对应的商务同学");
        }
        return null;
    }

    public void showPromoteInstallDialog() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.a() && this.promoteInstallProd.b() == 0) {
            this.promoteInstallProd.a(true);
            return;
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能未加白，请联系对应的商务同学");
        }
    }
}
