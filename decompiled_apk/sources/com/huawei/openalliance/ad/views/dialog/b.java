package com.huawei.openalliance.ad.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ju;
import com.huawei.hms.ads.jv;
import com.huawei.hms.ads.jw;
import com.huawei.openalliance.ad.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class b {
    private static final Map<String, String> B = new HashMap<String, String>() { // from class: com.huawei.openalliance.ad.views.dialog.b.1
        {
            put(ju.V, "com.tencent.mm");
            put("QQ", "com.tencent.mobileqq");
            put(ju.I, "com.sina.weibo");
            put(ju.Z, "com.huawei.works");
        }
    };
    private static final Map<String, Integer> C = new HashMap<String, Integer>() { // from class: com.huawei.openalliance.ad.views.dialog.b.2
        {
            put(ju.V, Integer.valueOf(R.string.hiad_share_wx));
            put("QQ", Integer.valueOf(R.string.hiad_share_qq));
        }
    };
    private static final String Code = "PPSShareDialog";
    private static final String I = "http";
    private static final float V = 0.0f;
    private static final String Z = "defImg";
    private final Activity D;
    private View F;
    private final jv L;
    private Dialog S;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f17437a = new ArrayList();
    private Map<String, String> b = new HashMap();

    public b(Activity activity, jv jvVar) {
        this.D = activity;
        this.L = jvVar;
        Z();
    }

    private void B() {
        this.S = new Dialog(this.D, R.style.HIAD_share_dialog);
        View inflate = LayoutInflater.from(this.D).inflate(R.layout.bottom_share_layout, (ViewGroup) null);
        this.F = inflate;
        this.S.setContentView(inflate);
        this.S.setCanceledOnTouchOutside(true);
        this.S.setCancelable(true);
        Window window = this.S.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setDimAmount(0.0f);
            attributes.gravity = 80;
            attributes.width = this.D.getResources().getDisplayMetrics().widthPixels;
        }
    }

    private void C() {
        Code(R.id.share_wx, ju.V, 1);
        Code(R.id.share_wx_moments, ju.V, 2);
        Code(R.id.share_qq, "QQ", 1);
        Code(R.id.share_qq_qzone, "QQ", 2);
        Code(R.id.share_weibo, ju.I, -1);
        Code(R.id.share_weLink, ju.Z, -1);
        Code(R.id.share_more, ju.B, -1);
        if (fb.Code()) {
            fb.Code(Code, "initShareButton end");
        }
    }

    private void Z() {
        if (fb.Code()) {
            fb.Code(Code, "initDialog");
        }
        if (this.D == null) {
            if (fb.Code()) {
                fb.Code(Code, "initDialog filed : context is null");
            }
        } else {
            B();
            this.b = ed.Code(this.D.getApplicationContext()).an();
            C();
        }
    }

    private boolean I(String str) {
        if (jw.Code(str)) {
            return true;
        }
        if (fb.Code()) {
            fb.Code(Code, "checkForDependencies : %s filed", str);
        }
        return false;
    }

    private boolean Z(String str) {
        if (g.Code(this.D, B.get(str))) {
            return true;
        }
        if (fb.Code()) {
            fb.Code(Code, "checkForInstall : %s filed", str);
        }
        return false;
    }

    public void Code() {
        Dialog dialog;
        if (this.D == null || this.L == null || (dialog = this.S) == null) {
            fb.Code(Code, "context,nativeAd or dialog is empty");
        } else {
            dialog.show();
        }
    }

    public void V() {
        Dialog dialog = this.S;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.S.dismiss();
    }

    private void Code(int i, final String str, final int i2) {
        View findViewById = this.F.findViewById(i);
        if ("QQ".equals(str) || ju.V.equals(str)) {
            if (Code(str, findViewById)) {
                return;
            }
        } else if (ju.I.equals(str)) {
            if (!V(str) || !Z(str)) {
                findViewById.setVisibility(8);
                return;
            }
        } else if (ju.Z.equals(str) && (!I(str) || !Z(str))) {
            findViewById.setVisibility(8);
            return;
        }
        Code(str);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dialog.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Code(str, i2);
                cy.Code(b.this.D, str, b.this.L.L());
                fb.Code(b.Code, "click %s share", str);
            }
        });
    }

    private boolean V(String str) {
        if (this.b.get(str) != null) {
            return I(str);
        }
        if (fb.Code()) {
            fb.Code(Code, "checkForAppId : %s filed", str);
        }
        return false;
    }

    public void Code(DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog = this.S;
        if (dialog != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
    }

    private void Code(String str) {
        String str2 = B.get(str);
        if (this.f17437a.contains(str2)) {
            return;
        }
        this.f17437a.add(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Code(java.lang.String r4, int r5) {
        /*
            r3 = this;
            com.huawei.hms.ads.jx r0 = new com.huawei.hms.ads.jx
            r0.<init>()
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.b
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r0.Code(r1)
            r1 = 1
            if (r1 != r5) goto L19
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
        L15:
            r0.Code(r5)
            goto L1f
        L19:
            r1 = 2
            if (r1 != r5) goto L1f
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L15
        L1f:
            java.lang.String r5 = "more"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L2c
            java.util.List<java.lang.String> r5 = r3.f17437a
            r0.Code(r5)
        L2c:
            r3.V()
            com.huawei.hms.ads.jv r5 = r3.L
            java.lang.String r5 = r5.Code()
            if (r5 == 0) goto L3f
            java.lang.String r1 = "http"
            boolean r5 = r5.startsWith(r1)
            if (r5 != 0) goto L4e
        L3f:
            com.huawei.hms.ads.jv r5 = r3.L
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.b
            java.lang.String r2 = "defImg"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r5.Code(r1)
        L4e:
            android.app.Activity r5 = r3.D
            com.huawei.hms.ads.jv r1 = r3.L
            com.huawei.hms.ads.jw.Code(r4, r5, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.dialog.b.Code(java.lang.String, int):void");
    }

    private boolean Code(final String str, View view) {
        if (!V(str)) {
            view.setVisibility(8);
            return true;
        }
        if (Z(str)) {
            return false;
        }
        Code(str);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dialog.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Toast.makeText(b.this.D, b.this.D.getResources().getString(R.string.hiad_share_app_not_install, b.this.D.getResources().getString(((Integer) b.C.get(str)).intValue())), 0).show();
                fb.Code(b.Code, "click %s share : app not support", str);
            }
        });
        return true;
    }
}
