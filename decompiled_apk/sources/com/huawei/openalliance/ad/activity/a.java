package com.huawei.openalliance.ad.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.n;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class a extends d implements NotifyCallback {
    protected static final int B = 16;
    public static final String Code = "huawei.permission.CLICK_STATUSBAR_BROADCAST";
    public static final String I = "com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY";
    public static final String V = "com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE";
    protected static final int Z = 36;
    private static final String m = "BaseDialogActivity";
    private static final int n = 40;
    private static final String o = "android.permission.WRITE_SECURE_SETTINGS";
    private static final String p = "com.huawei.intent.action.CLICK_STATUSBAR";
    private static Context r;
    protected int C;
    protected int D;
    protected int F;
    protected int[] L;
    protected int S;

    /* renamed from: a, reason: collision with root package name */
    protected int[] f17369a;
    protected AdContentData b;
    protected PPSBaseDialogContentView c;
    protected PPSBaseDialogContentView d;
    protected PPSBaseDialogContentView e;
    protected ImageView f;
    protected ImageView g;
    protected ImageView h;
    protected RelativeLayout i;
    protected View j;
    protected View k;
    protected c l;
    private boolean q = false;

    /* renamed from: com.huawei.openalliance.ad.activity.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class ViewTreeObserverOnGlobalLayoutListenerC0658a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<Context> Code;
        private final int[] I;
        private final WeakReference<View> V;

        public ViewTreeObserverOnGlobalLayoutListenerC0658a(View view, Context context, int[] iArr) {
            this.Code = new WeakReference<>(context);
            this.V = new WeakReference<>(view);
            this.I = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = this.V.get();
                Context context = this.Code.get();
                if (view != null && context != null && this.I != null) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    if (i == 0 && iArr[1] == 0) {
                        fb.V(a.m, "anchorView onGlobalLayout newLoc[x,y] =0,0");
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        return;
                    }
                    int[] iArr2 = this.I;
                    if ((iArr2[0] == i && iArr2[1] == iArr[1]) || a.V(iArr2, iArr)) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    fb.V(a.m, "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.I[0] + "," + this.I[1]);
                    com.huawei.openalliance.ad.msgnotify.b.Code(context, bm.B, new Intent(a.V));
                }
            } catch (Throwable th) {
                fb.I(a.m, "onGlobalLayout error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements i {
        WeakReference<a> Code;

        public b(a aVar) {
            this.Code = new WeakReference<>(aVar);
        }

        @Override // com.huawei.openalliance.ad.views.i
        public void Code(int i) {
            a aVar = this.Code.get();
            if (aVar == null || aVar.q) {
                return;
            }
            fb.V(a.m, "got safePadding: %s", Integer.valueOf(i));
            aVar.Code(i);
        }
    }

    /* loaded from: classes10.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                fb.V(a.m, "intent is empty");
                return;
            }
            String action = intent.getAction();
            fb.V(a.m, "FeedbackEventReceiver action = %s", action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) || a.p.equals(action)) {
                a.this.finish();
            }
        }
    }

    private void D() {
        int i;
        if (Code(this.L) || Code(this.f17369a)) {
            fb.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        if (this.L[1] + (this.f17369a[1] >> 1) > (this.F >> 1)) {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.e = this.c;
            this.h = this.f;
            int g = w.g(this);
            if (ck.Code(this).Code(this)) {
                g = Math.max(g, ck.Code(this).Code(this.i));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.setMargins(0, g, 0, 0);
            this.e.setLayoutParams(layoutParams);
            return;
        }
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.e = this.d;
        this.h = this.g;
        boolean B2 = n.B(this);
        boolean z = n.C(this) && (1 == (i = this.D) || 9 == i);
        boolean z2 = n.S(this) && n.F(this);
        if (B2 || z || z2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, Math.max(w.V(this, 40.0f), bc.S(this)));
            this.e.setLayoutParams(layoutParams2);
        }
    }

    private void L() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.i.setForceDarkAllowed(false);
        }
    }

    private void S() {
        int i;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowMetrics currentWindowMetrics2;
        Rect bounds2;
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = getWindowManager().getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            this.S = bounds.width();
            currentWindowMetrics2 = getWindowManager().getCurrentWindowMetrics();
            bounds2 = currentWindowMetrics2.getBounds();
            i = bounds2.height();
        } else {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            this.S = point.x;
            i = point.y;
        }
        this.F = i;
        fb.Code(m, "initDevicesInfo screenWidth: %s, screenHeight: %s", Integer.valueOf(this.S), Integer.valueOf(this.F));
        this.D = bc.c(this);
        this.C = w.V(this, 22.0f);
    }

    private void a() {
        try {
            this.l = new c();
            registerReceiver(this.l, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), o, null);
            IntentFilter intentFilter = new IntentFilter(p);
            if (getBaseContext() != null) {
                registerReceiver(this.l, intentFilter, Code, null);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bm.B, this);
        } catch (Throwable th) {
            fb.I(m, "registerReceiver error: %s", th.getClass().getSimpleName());
        }
    }

    private void b() {
        try {
            c cVar = this.l;
            if (cVar != null) {
                unregisterReceiver(cVar);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bm.B);
        } catch (Throwable th) {
            fb.I(m, "unRegisterFeedbackReceiver: %s", th.getClass().getSimpleName());
        }
    }

    private void c() {
        if (Code(this.L) || Code(this.f17369a)) {
            fb.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.L;
            layoutParams2.width = iArr[0];
            layoutParams2.height = iArr[1];
            this.j.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.k.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f17369a;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.k.setLayoutParams(layoutParams4);
        }
    }

    private void d() {
        ImageView imageView;
        float f;
        if (Code(this.L) || Code(this.f17369a)) {
            fb.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        int V2 = w.V(this, 36.0f);
        int i = this.C;
        int i2 = (this.S - i) - V2;
        int i3 = (this.L[0] + (this.f17369a[0] >> 1)) - (V2 >> 1);
        if (i3 >= i) {
            i = i3;
        }
        if (i <= i2) {
            i2 = i;
        }
        if (bc.I()) {
            imageView = this.h;
            f = -i2;
        } else {
            imageView = this.h;
            f = i2;
        }
        imageView.setX(f);
    }

    @TargetApi(19)
    private void e() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public boolean B() {
        try {
            this.L = getIntent().getIntArrayExtra(bb.av);
            this.f17369a = getIntent().getIntArrayExtra(bb.ay);
            if (!Code(this.L) && !Code(this.f17369a)) {
                if (bc.I()) {
                    int[] iArr = this.L;
                    int i = (this.S - iArr[0]) - this.f17369a[0];
                    iArr[0] = i;
                    fb.V(m, "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(i), Integer.valueOf(this.L[1]));
                }
                if (Build.VERSION.SDK_INT >= 24 && bc.Code((Activity) this)) {
                    int e = bc.e(this);
                    int[] iArr2 = this.L;
                    iArr2[1] = iArr2[1] - e;
                    fb.Code(m, "windowing mode is freeform");
                    fb.Code(m, "initDevicesInfo dragBarHeight: %s", Integer.valueOf(e));
                }
                return true;
            }
            fb.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return false;
        } catch (Throwable th) {
            fb.I(m, "getIntentExtra error: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void C() {
        int V2;
        fb.V(m, "getRealOrientation orientation %s", Integer.valueOf(this.D));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        int abs = Math.abs((int) this.h.getX());
        int V3 = w.V(this, 36.0f);
        int i = (V3 >> 1) + abs;
        double d = V3 * 0.5d;
        int viewWidthPercent = (int) ((this.S * (1.0f - this.e.getViewWidthPercent()) * 0.5d) + w.V(this, 16.0f) + d);
        int viewWidthPercent2 = (int) (((this.S * ((this.e.getViewWidthPercent() * 0.5d) + 0.5d)) - w.V(this, 16.0f)) - d);
        fb.Code(m, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        fb.Code(m, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V3), Integer.valueOf(i));
        int i2 = this.D;
        if (1 != i2 && 9 != i2) {
            layoutParams.removeRule(14);
            this.e.setLayoutParams(layoutParams);
            int i3 = this.S;
            if (i >= i3 / 3) {
                if (i < (i3 * 2) / 3) {
                    V2 = i - (this.e.getViewWith() >> 1);
                }
                V2 = ((abs + V3) + w.V(this, 16.0f)) - this.e.getViewWith();
            }
            V2 = abs - w.V(this, 16.0f);
        } else if (i < viewWidthPercent) {
            fb.Code(m, "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.e.setLayoutParams(layoutParams);
            V2 = abs - w.V(this, 16.0f);
        } else {
            if (i <= viewWidthPercent2) {
                fb.Code(m, "locationX =< curImgCenter =< locationX2");
                layoutParams.addRule(14);
                this.e.setLayoutParams(layoutParams);
                bc.Code(this, new b(this));
            }
            fb.Code(m, "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.e.setLayoutParams(layoutParams);
            V2 = ((abs + V3) + w.V(this, 16.0f)) - this.e.getViewWith();
        }
        this.e.setPaddingStart(V2);
        bc.Code(this, new b(this));
    }

    public void Code() {
    }

    public void I() {
    }

    public int V() {
        return 0;
    }

    public void Z() {
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        fb.V(m, "finish");
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(V());
            r = getApplicationContext();
            S();
            if (!B()) {
                fb.I(m, "getIntentExtra return false");
                Z();
                finish();
                return;
            }
            e();
            getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
            Code();
            L();
            a();
            D();
            c();
            d();
            I();
        } catch (Throwable th) {
            fb.I(m, "onCreate ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            fb.V(m, "msgName or msgData is empty!");
            return;
        }
        fb.Code(m, "onMessageNotify msgName:%s", str);
        try {
            String action = intent.getAction();
            fb.V(m, "FeedbackEventReceiver action = %s", action);
            if (!V.equals(action) && !I.equals(action)) {
                return;
            }
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.a.1
                @Override // java.lang.Runnable
                public void run() {
                    fb.V(a.m, "anchor point changed, do finish.");
                    a.this.finish();
                }
            });
        } catch (Throwable th) {
            fb.I(m, "error: " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i) {
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView != null) {
            pPSBaseDialogContentView.Code(i);
        }
        if (this.h != null) {
            this.C += i;
            d();
        }
        this.q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(int[] iArr, int[] iArr2) {
        int max = Math.max(w.g(r), bc.S(r));
        return Math.abs(iArr[0] - iArr2[0]) <= max && Math.abs(iArr[1] - iArr2[1]) <= max;
    }

    private boolean Code(int[] iArr) {
        return iArr == null || iArr.length != 2;
    }
}
