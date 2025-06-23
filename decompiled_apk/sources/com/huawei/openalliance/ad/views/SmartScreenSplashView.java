package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fj;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.ik;
import com.huawei.hms.ads.iw;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.kw;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class SmartScreenSplashView extends RelativeLayout implements kk, kw {
    private AdSlotParam B;
    private com.huawei.openalliance.ad.inter.listeners.b C;
    protected ed Code;
    private iw D;
    private com.huawei.openalliance.ad.inter.listeners.a F;
    private int I;
    private SloganView L;
    private fn S;

    /* renamed from: a, reason: collision with root package name */
    private View f17435a;
    private View b;
    private km c;
    private TextView d;
    private PPSCircleProgressBar e;
    private PPSLabelView f;
    private TextView g;
    private int h;
    private RelativeLayout i;
    private RelativeLayout j;
    private long k;
    private int l;
    private final String m;
    private long n;
    private boolean o;
    private boolean p;
    private int q;
    private a r;
    private float s;

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private WeakReference<km> Code;

        public a(km kmVar) {
            this.Code = new WeakReference<>(kmVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            km kmVar;
            if (intent == null || !x.cg.equals(intent.getAction()) || (kmVar = this.Code.get()) == null || !(kmVar instanceof PPSVideoView)) {
                return;
            }
            ((PPSVideoView) kmVar).L();
        }
    }

    public SmartScreenSplashView(Context context) {
        super(context);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    private void S() {
        if (this.d == null || this.e == null) {
            return;
        }
        int i = this.l;
        if (i > 0) {
            fb.V("SmartScreenSplashView", "%d delay, skip btn show", Integer.valueOf(i));
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SmartScreenSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartScreenSplashView.this.d != null) {
                        fb.Code("SmartScreenSplashView", "skip hint show");
                        SmartScreenSplashView.this.d.setVisibility(0);
                    }
                    if (SmartScreenSplashView.this.e != null) {
                        fb.Code("SmartScreenSplashView", "coutDownView show");
                        SmartScreenSplashView.this.e.setVisibility(0);
                    }
                    SmartScreenSplashView.this.p = true;
                }
            }, this.m, this.l);
        } else {
            fb.V("SmartScreenSplashView", "direct show skip hint");
            this.p = true;
            this.d.setVisibility(0);
            this.e.setVisibility(0);
        }
    }

    private void setVisibleAndBringToFont(View view) {
        if (view != null) {
            view.setVisibility(0);
            view.bringToFront();
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void I(int i) {
        fb.Code("SmartScreenSplashView", "update left time, total: %s, left: %s", Long.valueOf(this.n), Integer.valueOf(i));
        long j = this.n;
        int doubleValue = j > 0 ? (int) ((1.0d - aj.Code(Double.valueOf(((i - 1) * 1000) / j), 2, 4).doubleValue()) * 100.0d) : 0;
        if (doubleValue >= 100) {
            doubleValue = 100;
        }
        PPSCircleProgressBar pPSCircleProgressBar = this.e;
        if (pPSCircleProgressBar != null) {
            pPSCircleProgressBar.Code(doubleValue, ay.Code(Integer.valueOf(i)));
        }
    }

    @Override // com.huawei.hms.ads.kk
    public km V(int i) {
        if (i == 2) {
            return new PPSImageView(getContext());
        }
        if (i != 9) {
            return null;
        }
        PPSVideoView pPSVideoView = new PPSVideoView(getContext(), this.B.V(), 0, this.B.I(), 18);
        pPSVideoView.setHideSoundIcon(true);
        pPSVideoView.setIgnoreSoundCtrl(false);
        pPSVideoView.setStartVol(this.s);
        return pPSVideoView;
    }

    @Override // com.huawei.hms.ads.kw
    public void destroyView() {
        fb.V("SmartScreenSplashView", "destroyView ");
        km kmVar = this.c;
        if (kmVar != null) {
            kmVar.destroyView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        fn fnVar;
        fb.V("SmartScreenSplashView", "dispatchKeyEvent:" + keyEvent.getKeyCode() + ", " + keyEvent.getAction());
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (fnVar = this.S) != null) {
            fnVar.Code(0, 0);
        }
        return true;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.kk
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.B;
        if (adSlotParam != null) {
            adSlotParam.Code(18);
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.kk
    public int getAdType() {
        return 18;
    }

    @Override // com.huawei.hms.ads.kk
    public int getAudioFocusType() {
        return 0;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public float getStartMaxVol() {
        return this.s;
    }

    public String getUniqueId() {
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        fn fnVar;
        fb.V("SmartScreenSplashView", "onKeyDown, keyCode: %s", Integer.valueOf(keyEvent.getKeyCode()));
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (fnVar = this.S) != null) {
            fnVar.Code(0, 0);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
        fb.V("SmartScreenSplashView", "pauseView ");
        km kmVar = this.c;
        if (kmVar != null) {
            kmVar.pauseView();
        }
        if (getContext() != null) {
            try {
                if (this.r != null) {
                    getContext().unregisterReceiver(this.r);
                    this.r = null;
                }
            } catch (Throwable th) {
                fb.I("SmartScreenSplashView", "unregister err: %s", th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
        fb.V("SmartScreenSplashView", "resumeView ");
        km kmVar = this.c;
        if (kmVar != null) {
            kmVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.F = aVar;
        fn fnVar = this.S;
        if (fnVar != null) {
            fnVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.C = bVar;
        this.D.Code(bVar);
        fn fnVar = this.S;
        if (fnVar != null) {
            fnVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (w.Code(getContext())) {
            int B = com.huawei.openalliance.ad.utils.d.B(getContext(), adSlotParam.V());
            int C = com.huawei.openalliance.ad.utils.d.C(getContext(), adSlotParam.V());
            adSlotParam.Z(B);
            adSlotParam.B(C);
            adSlotParam.I(8);
            adSlotParam.L(Integer.valueOf(this.I));
            adSlotParam.Z((Integer) 0);
            adSlotParam.B(Integer.valueOf((HiAd.Code(getContext()).isNewProcess() && com.huawei.openalliance.ad.utils.d.L(getContext())) ? 0 : 1));
            this.B = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.q = i;
        km kmVar = this.c;
        if (kmVar != null) {
            kmVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.I = i;
    }

    public void setLogo(View view) {
        Code(view, 0);
    }

    public void setSloganResId(int i) {
        if (w.Code(getContext())) {
            if (bc.D(getContext())) {
                fb.I("SmartScreenSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.B == null) {
                throw new dp("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.L == null) {
                SloganView sloganView = new SloganView(getContext(), this.B.V(), i, 18);
                this.L = sloganView;
                this.i.addView(sloganView, new RelativeLayout.LayoutParams(-1, -1));
                this.L.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.f17435a = view;
            view.setVisibility(8);
        }
    }

    public void setStartMaxVol(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                AudioManager audioManager = (AudioManager) getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                fb.V("SmartScreenSplashView", "music max %s, current %s， maxVol： %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
                float f2 = streamVolume;
                float f3 = streamMaxVolume * 1.0f * f;
                float f4 = f2 * 1.0f >= f3 ? f3 / f2 : 1.0f;
                if (fb.Code()) {
                    fb.Code("SmartScreenSplashView", "maxVol end: %s", Float.valueOf(f4));
                }
                this.s = f4;
                return;
            }
        }
        fb.I("SmartScreenSplashView", "valid max vol is from 0.0 to 1.0");
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    @Override // com.huawei.hms.ads.kk
    public Integer Code(AdContentData adContentData) {
        return null;
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i) {
        fj Code = fk.Code(i, this);
        this.S = Code;
        Code.Code(this.C);
        this.S.Code(this.F);
        this.S.Code(this.I);
        this.S.V(this.k);
        this.S.m();
    }

    @Override // com.huawei.hms.ads.kk
    public void V() {
        SloganView sloganView = this.L;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.f17435a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void V(Context context) {
        View.inflate(context, w.f(context) ? R.layout.hiad_view_tv_splash_ad_elderly : R.layout.hiad_view_tv_splash_ad, this);
        this.i = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.j = (RelativeLayout) findViewById(R.id.hiad_logo_container);
        this.d = (TextView) findViewById(R.id.hiad_skip_text);
        this.e = (PPSCircleProgressBar) findViewById(R.id.hiad_count_progress);
        this.f = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.g = (TextView) findViewById(R.id.hiad_ad_source);
        setFocusable(true);
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i, int i2, String str, boolean z, Integer num) {
    }

    private void V(AdContentData adContentData) {
        MetaData S;
        if (adContentData == null) {
            return;
        }
        if (this.f != null) {
            String r = adContentData.r();
            this.f.setDataAndRefreshUi(adContentData);
            if (TextUtils.isEmpty(r) || !this.f.Code()) {
                this.f.setVisibility(8);
            } else {
                MetaData S2 = adContentData.S();
                if (S2 == null || AdSource.Code(S2.l()) == null) {
                    this.f.setText(r);
                } else {
                    this.f.V(AdSource.Code(S2.l()), r);
                }
                this.f.setVisibility(0);
            }
        }
        if (this.g == null || (S = adContentData.S()) == null) {
            return;
        }
        String V = ay.V(S.L());
        if (TextUtils.isEmpty(V)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(V);
            this.g.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i, boolean z) {
    }

    private void Code(Context context) {
        V(context);
        this.Code = ed.Code(context.getApplicationContext());
        this.D = new ik(context.getApplicationContext(), this);
        this.l = this.Code.ab();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(View view) {
    }

    public void Code(View view, int i) {
        this.b = view;
        view.setVisibility(i);
        this.h = i;
    }

    private void Code(km kmVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.cg);
        if (this.r == null) {
            this.r = new a(kmVar);
        }
        getContext().registerReceiver(this.r, intentFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.kk
    public void Code(km kmVar, Integer num) {
        if (bc.D(getContext())) {
            fb.I("SmartScreenSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (kmVar == 0 || !(kmVar instanceof View)) {
            return;
        }
        View view = (View) kmVar;
        this.c = kmVar;
        kmVar.setAudioFocusType(this.q);
        Code(this.c);
        ViewParent parent = view.getParent();
        if (parent == this.i) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            fb.V("SmartScreenSplashView", "showAdView, remove adView.");
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        setVisibleAndBringToFont(this.j);
        setVisibleAndBringToFont(this.b);
        this.i.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(ky kyVar) {
        View view = this.f17435a;
        if (view != null) {
            view.setVisibility(0);
            new hy(this.Code, kyVar).V();
            return;
        }
        SloganView sloganView = this.L;
        if (sloganView == null) {
            fb.V("SmartScreenSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.L;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(kyVar);
        this.L.Code();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(AdContentData adContentData, int i) {
        fb.Code("SmartScreenSplashView", "showLabelView and logo.");
        if (this.d != null && this.e != null) {
            if (adContentData != null && adContentData.S() != null && adContentData.l() == 9) {
                long k = adContentData.S().k();
                this.n = k;
                this.e.Code(0, ay.Code(Integer.valueOf((int) ((((float) k) * 1.0f) / 1000.0f))));
            }
            S();
        }
        if (this.j != null && this.b != null) {
            fb.V("SmartScreenSplashView", "show logo, visibility: %s", Integer.valueOf(this.h));
            this.j.addView(this.b);
            this.b.setVisibility(this.h);
        }
        V(adContentData);
    }
}
