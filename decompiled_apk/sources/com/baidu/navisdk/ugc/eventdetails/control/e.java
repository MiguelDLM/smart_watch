package com.baidu.navisdk.ugc.eventdetails.control;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNLoadingView;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private BNLoadingView f8062a;
    private BNCommonProgressDialog b = null;
    private Handler c = null;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a() {
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            removeMessages(1);
            e.this.b();
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "请求超时");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f8064a;

        public b(e eVar, d dVar) {
            this.f8064a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f8064a.onAction(1);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnCancelListener {
        public c(e eVar) {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "mUgcDetailViewShowProgress onCancel!");
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onAction(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        try {
            BNCommonProgressDialog bNCommonProgressDialog = this.b;
            if (bNCommonProgressDialog != null && bNCommonProgressDialog.isShowing()) {
                this.b.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = null;
        return true;
    }

    private void c() {
        if (this.c == null) {
            this.c = new a();
        }
    }

    public void a(Activity activity, int i, ViewGroup viewGroup) {
        Handler handler;
        if (activity == null) {
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_EventDetails", "onLoadingStart activity == null");
                return;
            }
            return;
        }
        if (i == 1) {
            c();
            if (!a(activity) || (handler = this.c) == null) {
                return;
            }
            handler.sendEmptyMessageDelayed(1, 10000L);
            return;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f8062a == null) {
                this.f8062a = new BNLoadingView(activity);
            }
            if (this.f8062a.getParent() != null && (this.f8062a.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f8062a.getParent()).removeView(this.f8062a);
            }
            this.f8062a.resetBottomLoadtab(1);
            viewGroup.addView(this.f8062a, layoutParams);
        }
    }

    public void a(int i, boolean z, ViewGroup viewGroup, d dVar) {
        if (i == 1) {
            Handler handler = this.c;
            if (handler != null) {
                handler.removeMessages(1);
            }
            b();
            return;
        }
        if (z) {
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        } else {
            BNLoadingView bNLoadingView = this.f8062a;
            if (bNLoadingView != null) {
                bNLoadingView.resetBottomLoadtab(3);
                this.f8062a.setErrorViewText("加载失败", true);
                this.f8062a.setErrorRepeatBtnListener(new b(this, dVar));
            }
        }
    }

    private boolean a(Activity activity) {
        BNCommonProgressDialog bNCommonProgressDialog;
        try {
            if (this.b == null && activity != null) {
                BNCommonProgressDialog bNCommonProgressDialog2 = new BNCommonProgressDialog(activity);
                this.b = bNCommonProgressDialog2;
                bNCommonProgressDialog2.setMessage("加载中...");
            }
            if (activity == null || activity.isFinishing() || (bNCommonProgressDialog = this.b) == null) {
                return false;
            }
            bNCommonProgressDialog.setOnCancelListener(new c(this));
            this.b.show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a() {
        b();
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.c = null;
        }
        this.f8062a = null;
    }

    public View a(Context context) {
        if (this.f8062a == null) {
            BNLoadingView bNLoadingView = new BNLoadingView(context);
            this.f8062a = bNLoadingView;
            bNLoadingView.resetBottomLoadtab(1);
        }
        return this.f8062a;
    }

    public View a(Context context, int i) {
        if (this.f8062a == null) {
            this.f8062a = new BNLoadingView(context);
        }
        this.f8062a.resetBottomLoadtab(i);
        return this.f8062a;
    }
}
