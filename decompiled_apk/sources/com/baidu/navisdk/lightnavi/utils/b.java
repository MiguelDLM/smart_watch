package com.baidu.navisdk.lightnavi.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class b {
    private static volatile b c;

    /* renamed from: a, reason: collision with root package name */
    private BNCommonProgressDialog f6891a;
    private Activity b;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a(b bVar) {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            com.baidu.navisdk.module.a.h().l = true;
        }
    }

    public b(Activity activity) {
        this.b = activity;
    }

    public static b a(Activity activity) {
        if (c == null) {
            c = new b(activity);
        }
        return c;
    }

    public BNCommonProgressDialog b() {
        BNCommonProgressDialog bNCommonProgressDialog;
        if (this.b == null) {
            return null;
        }
        try {
            if (this.f6891a == null) {
                this.f6891a = new BNCommonProgressDialog(this.b);
            }
            Activity activity = this.b;
            if (activity != null && !activity.isFinishing() && (bNCommonProgressDialog = this.f6891a) != null) {
                bNCommonProgressDialog.setMessage("分享请求中...");
                this.f6891a.setOnCancelListener(new a(this));
                this.f6891a.show();
            }
        } catch (Exception e) {
            LogUtil.e("LightNaviDialogHelper", e.toString());
        }
        return this.f6891a;
    }

    public void a() {
        BNCommonProgressDialog bNCommonProgressDialog;
        try {
            Activity activity = this.b;
            if (activity != null && !activity.isFinishing() && (bNCommonProgressDialog = this.f6891a) != null && bNCommonProgressDialog.isShowing()) {
                this.f6891a.dismiss();
            }
        } catch (Exception e) {
            LogUtil.e("LightNaviDialogHelper", e.toString());
        }
        this.f6891a = null;
    }
}
