package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.ad.inter.HiAd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public abstract class fs implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final String Code = "ViewMonitor";
    private static final Map<View, fs> V = new ConcurrentHashMap();
    private boolean B;
    private long C;
    private int S;
    private View Z;

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f17289a;
    private String I = Code;
    private Rect F = new Rect();
    private boolean D = true;
    private BroadcastReceiver L = new BroadcastReceiver() { // from class: com.huawei.hms.ads.fs.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            fb.V(fs.this.I, "receive screen state: %s", action);
            if (TextUtils.equals("android.intent.action.SCREEN_ON", action) || TextUtils.equals("android.intent.action.SCREEN_OFF", action) || TextUtils.equals("android.intent.action.USER_PRESENT", action)) {
                fs.this.Z();
                fs.this.C();
            }
        }
    };

    public fs(View view) {
        this.Z = view;
        V();
    }

    private void B() {
        fb.V(this.I, "unregisterObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        this.Z.setOnSystemUiVisibilityChangeListener(null);
        if (this.f17289a != null) {
            HiAd.Code(this.Z.getContext()).Code(this.f17289a);
            this.f17289a = null;
        }
        V.remove(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        if (r3 <= 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C() {
        /*
            r5 = this;
            boolean r0 = r5.D
            r1 = 0
            if (r0 == 0) goto L19
            android.view.View r0 = r5.Z
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L19
            android.view.View r0 = r5.Z
            android.graphics.Rect r2 = r5.F
            boolean r0 = r0.getLocalVisibleRect(r2)
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            android.view.View r2 = r5.Z
            int r2 = r2.getWidth()
            android.view.View r3 = r5.Z
            int r3 = r3.getHeight()
            int r2 = r2 * r3
            if (r0 == 0) goto L49
            if (r2 <= 0) goto L49
            android.graphics.Rect r3 = r5.F
            int r3 = r3.width()
            android.graphics.Rect r4 = r5.F
            int r4 = r4.height()
            int r3 = r3 * r4
            int r3 = r3 * 100
            int r3 = r3 / r2
            int r2 = r5.S
            if (r3 <= r2) goto L43
            r5.S = r3
        L43:
            r5.Code(r3)
            if (r3 > 0) goto L49
            goto L4a
        L49:
            r1 = r0
        L4a:
            if (r1 == 0) goto L50
            r5.b()
            goto L53
        L50:
            r5.c()
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.fs.C():void");
    }

    private void I() {
        fb.V(this.I, "registerObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Map<View, fs> map = V;
        fs fsVar = map.get(this.Z);
        if (fsVar != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(fsVar);
            viewTreeObserver.removeOnGlobalLayoutListener(fsVar);
        }
        map.put(this.Z, this);
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f17289a = this.L;
        HiAd.Code(this.Z.getContext()).Code(this.f17289a, intentFilter);
        this.D = true;
    }

    private void V() {
        if (this.Z != null) {
            this.I = this.Z.getClass().getSimpleName() + Code;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Context context = this.Z.getContext();
        this.D = com.huawei.openalliance.ad.utils.bc.Code(context) && !com.huawei.openalliance.ad.utils.bc.V(context);
        if (fb.Code()) {
            fb.Code(this.I, "checkScreenState screen available: %s ", Boolean.valueOf(this.D));
        }
    }

    public void D() {
        fb.V(this.I, "onViewAttachedToWindow");
        I();
        C();
    }

    public void L() {
        if (fb.Code()) {
            fb.Code(this.I, "onViewDetachedFromWindow");
        }
        B();
        c();
    }

    public void a() {
        fb.V(this.I, "onViewVisibilityChanged");
        C();
    }

    public void b() {
        if (this.B) {
            return;
        }
        fb.V(this.I, "onViewShown");
        this.B = true;
        this.C = System.currentTimeMillis();
        Code();
    }

    public void c() {
        if (this.B) {
            fb.V(this.I, "onViewHidden");
            this.B = false;
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (fb.Code()) {
                fb.Code(this.I, "max physical visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(currentTimeMillis));
            }
            Code(currentTimeMillis, this.S);
            this.S = 0;
        }
    }

    public boolean d() {
        return this.B && this.Z.isShown();
    }

    public int e() {
        boolean z = this.D && this.Z.isShown() && this.Z.getLocalVisibleRect(this.F);
        int width = this.Z.getWidth() * this.Z.getHeight();
        if (!z || width <= 0) {
            return 0;
        }
        return ((this.F.width() * this.F.height()) * 100) / width;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (fb.Code()) {
            fb.Code(this.I, "onGlobalLayout");
        }
        C();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        if (fb.Code()) {
            fb.Code(this.I, "onScrollChanged");
        }
        C();
    }

    public void Code() {
    }

    public void Code(int i) {
    }

    public void Code(long j, int i) {
    }
}
