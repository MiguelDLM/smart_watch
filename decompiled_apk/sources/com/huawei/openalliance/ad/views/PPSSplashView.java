package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fj;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.ik;
import com.huawei.hms.ads.iw;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.kw;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bb;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.n;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.dialog.PPSAdvertiserInfoDialog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes10.dex */
public class PPSSplashView extends RelativeLayout implements kk, kw {
    private PPSSplashSwipeView A;
    protected ed B;
    protected long C;
    SloganView Code;
    private View D;
    private PPSSplashTwistView E;
    private AdSlotParam F;
    private PPSSplashSwipeClickView G;
    private PPSSplashTwistClickView H;
    PPSSkipButton I;
    private b J;
    private AdContentData K;
    private int L;
    RelativeLayout V;

    /* renamed from: a, reason: collision with root package name */
    private PPSWLSView f17429a;
    private PPSSplashAdSourceView b;
    private fn c;
    private iw d;
    private com.huawei.openalliance.ad.inter.listeners.b e;
    private com.huawei.openalliance.ad.inter.listeners.a f;
    private boolean g;
    private int h;
    private Bitmap i;
    private View j;
    private km k;
    private int l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private View t;
    private boolean u;
    private int v;
    private final String w;
    private int x;
    private RewardVerifyConfig y;
    private PPSSplashProView z;

    /* loaded from: classes10.dex */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSSplashView> Code;
        private AdContentData V;

        public a(PPSSplashView pPSSplashView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSSplashView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSSplashView pPSSplashView = this.Code.get();
            if (pPSSplashView != null) {
                final int[] choiceViewLoc = pPSSplashView.f17429a.getChoiceViewLoc();
                final int[] choiceViewSize = pPSSplashView.f17429a.getChoiceViewSize();
                if (w.Code(choiceViewLoc, 2) && w.Code(choiceViewSize, 2)) {
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSSplashView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d.b {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.inter.d.b
        public void Code() {
            fb.V("PPSSplashView", "onStart");
            PPSSplashView.this.d();
        }
    }

    public PPSSplashView(Context context) {
        super(context);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private void B() {
        String str;
        int I;
        int i;
        int i2;
        int i3;
        View view;
        try {
            if (this.j == null) {
                View inflate = ((ViewStub) findViewById(R.id.hiad_logo_stub)).inflate();
                this.j = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            if (1 == this.F.V()) {
                L();
                if (this.p > 0) {
                    fb.Code("PPSSplashView", "left: %s, top: %s, right: %s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.p, layoutParams.rightMargin, layoutParams.bottomMargin);
                    view = this.j;
                }
                D();
                S();
            }
            fb.V("PPSSplashView", "showFullModeLogo, orientation: %s, leftNotchHeight: %s", Integer.valueOf(this.F.V()), Integer.valueOf(this.q));
            fb.Code("PPSSplashView", "left:%s, top:%s, right:%s, leftNotchHeight:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(this.q));
            if (!ck.V(getContext()) || this.q <= 0) {
                if (!ck.V(getContext()) || (ck.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 && !n.B(getContext()))) {
                    if (layoutParams.isMarginRelative()) {
                        layoutParams.setMarginStart(bc.I(getContext()));
                    } else {
                        I = bc.I(getContext());
                        i = layoutParams.topMargin;
                        i2 = layoutParams.rightMargin;
                        i3 = layoutParams.bottomMargin;
                        layoutParams.setMargins(I, i, i2, i3);
                    }
                }
                layoutParams.topMargin += w.V(getContext(), 12.0f);
                view = this.j;
            } else if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin + this.q);
                layoutParams.topMargin += w.V(getContext(), 12.0f);
                view = this.j;
            } else {
                I = layoutParams.leftMargin + this.q;
                i = layoutParams.topMargin;
                i2 = layoutParams.rightMargin;
                i3 = layoutParams.bottomMargin;
                layoutParams.setMargins(I, i, i2, i3);
                layoutParams.topMargin += w.V(getContext(), 12.0f);
                view = this.j;
            }
            view.setLayoutParams(layoutParams);
            D();
            S();
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            fb.I("PPSSplashView", str);
        } catch (Exception e) {
            str = "showFullModeLogo " + e.getClass().getSimpleName();
            fb.I("PPSSplashView", str);
        }
    }

    private void C() {
        if (this.j == null) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.S();
            }
        });
    }

    private PPSSkipButton Code(String str, int i, String str2, boolean z, float f, int i2) {
        int i3;
        boolean z2;
        PPSSkipButton pPSSkipButton;
        int V = this.F.V();
        int I = this.F.I();
        L();
        if (1 == V) {
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i, str2, z, this.p, f, i2, false);
        } else {
            fb.V("PPSSplashView", "createSkipAdButton, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
            int i4 = this.q;
            if (i4 > 0) {
                i3 = i4;
                z2 = true;
            } else {
                i3 = this.r;
                z2 = false;
            }
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i, str2, z, i3, f, i2, z2);
        }
        pPSSkipButton.setAdMediator(this.c);
        return pPSSkipButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        View view = this.j;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.hiad_full_mode_logo);
        int i = this.h;
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            Bitmap bitmap = this.i;
            if (bitmap == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
        imageView.setVisibility(0);
    }

    private void F() {
        if (this.j == null) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.2
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.D();
            }
        });
    }

    private int I(AdContentData adContentData) {
        return (adContentData.aA() == null || adContentData.aA().Code() == null) ? this.B.w() : adContentData.aA().Code().intValue();
    }

    private void L() {
        if (this.p > 0 || ck.Code(getContext().getApplicationContext()).Code(getContext().getApplicationContext())) {
            return;
        }
        this.p = w.g(getContext().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        View view = this.j;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.hiad_media_name);
        int i = this.l;
        if (i > 0) {
            textView.setText(i);
        } else {
            String str = this.m;
            if (str == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
        }
        textView.setVisibility(0);
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private void a() {
        if (this.I != null) {
            fb.Code("PPSSplashView", "%d delay, skip btn show", Integer.valueOf(this.v));
            if (this.v > 0) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashView.this.I != null) {
                            fb.Code("PPSSplashView", "skip btn show");
                            PPSSplashView.this.I.setVisibility(0);
                        }
                    }
                }, this.w, this.v);
            } else {
                fb.Code("PPSSplashView", "skip btn show");
                this.I.setVisibility(0);
            }
        }
    }

    private boolean b() {
        if (this.B.f()) {
            return !n.Z(getContext().getApplicationContext());
        }
        return true;
    }

    private void c() {
        int y = this.B.y();
        if (y > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            int V = w.V(getContext(), y);
            this.z.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.z.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.g || this.F == null) {
            return;
        }
        fb.V("PPSSplashView", " exsplash start, dismiss");
        Z();
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.ar() <= 0) {
            return;
        }
        this.v = adContentData.ar();
    }

    @Override // com.huawei.hms.ads.kk
    public km V(int i) {
        if (i == 2) {
            return new PPSImageView(getContext());
        }
        if (i != 9) {
            return null;
        }
        Context context = getContext();
        int V = this.F.V();
        int i2 = this.r;
        return new PPSVideoView(context, V, i2 > 0 ? i2 : 0, this.F.I(), 1);
    }

    public void destroyView() {
        km kmVar = this.k;
        if (kmVar != null) {
            kmVar.destroyView();
        }
        try {
            PPSSplashProView pPSSplashProView = this.z;
            if (pPSSplashProView != null) {
                pPSSplashProView.Code();
            }
            PPSSplashSwipeView pPSSplashSwipeView = this.A;
            if (pPSSplashSwipeView != null) {
                pPSSplashSwipeView.V();
            }
            PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
            if (pPSSplashSwipeClickView != null) {
                pPSSplashSwipeClickView.V();
            }
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).V(this.J);
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
            RelativeLayout relativeLayout = this.V;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable th) {
            fb.V("PPSSplashView", "destroy err: %s", th.getClass().getSimpleName());
        }
        this.g = false;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.e;
    }

    public fn getAdMediator() {
        return this.c;
    }

    @Override // com.huawei.hms.ads.kk
    public AdSlotParam getAdSlotParam() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.kk
    public int getAdType() {
        return 1;
    }

    @Override // com.huawei.hms.ads.kk
    public int getAudioFocusType() {
        return this.o;
    }

    public BiddingInfo getBiddingInfo() {
        fn fnVar = this.c;
        if (fnVar != null) {
            return fnVar.l();
        }
        return null;
    }

    public View getLogo() {
        return this.D;
    }

    public Bitmap getLogoBitmap() {
        return this.i;
    }

    public int getLogoResId() {
        return this.h;
    }

    public int getMediaNameResId() {
        return this.l;
    }

    public String getMediaNameString() {
        return this.m;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public View getSloganView() {
        return this.t;
    }

    public iw getSplashPresenter() {
        return this.d;
    }

    public String getUniqueId() {
        fn fnVar = this.c;
        if (fnVar != null) {
            return fnVar.k();
        }
        return null;
    }

    public boolean isLoaded() {
        fn fnVar = this.c;
        return fnVar != null && fnVar.V() == com.huawei.openalliance.ad.constant.b.LOADED;
    }

    public boolean isLoading() {
        fn fnVar = this.c;
        return fnVar == null ? this.g : fnVar.V() == com.huawei.openalliance.ad.constant.b.LOADING;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        r0 = r5.getDisplayCutout();
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r5) {
        /*
            r4 = this;
            java.lang.String r0 = "onApplyWindowInsets"
            java.lang.String r1 = "PPSSplashView"
            com.huawei.hms.ads.fb.V(r1, r0)
            boolean r0 = com.huawei.openalliance.ad.utils.bc.V()
            if (r0 == 0) goto L64
            if (r5 == 0) goto L64
            android.view.DisplayCutout r0 = androidx.core.view.xoO0xx0.oIX0oI(r5)
            if (r0 == 0) goto L64
            java.util.List r2 = com.huawei.hms.ads.oIX0oI.oIX0oI(r0)
            boolean r3 = com.huawei.openalliance.ad.utils.ad.Code(r2)
            if (r3 != 0) goto L2c
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            int r2 = r2.height()
            r4.p = r2
        L2c:
            int r2 = com.huawei.openalliance.ad.views.oIX0oI.oIX0oI(r0)
            r4.q = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "notchHeight left:"
            r2.append(r3)
            int r3 = r4.q
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.huawei.hms.ads.fb.V(r1, r2)
            int r0 = com.huawei.openalliance.ad.views.II0xO0.oIX0oI(r0)
            r4.r = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "notchHeight right:"
            r0.append(r2)
            int r2 = r4.r
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.ads.fb.V(r1, r0)
        L64:
            int r0 = r4.p
            if (r0 > 0) goto L94
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 < r2) goto L94
            android.content.Context r0 = r4.getContext()
            com.huawei.hms.ads.cv r0 = com.huawei.hms.ads.ck.Code(r0)
            android.content.Context r2 = r4.getContext()
            boolean r0 = r0.Code(r2)
            if (r0 == 0) goto L94
            int r0 = r4.p
            android.content.Context r2 = r4.getContext()
            com.huawei.hms.ads.cv r2 = com.huawei.hms.ads.ck.Code(r2)
            int r2 = r2.Code(r4)
            int r0 = java.lang.Math.max(r0, r2)
            r4.p = r0
        L94:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "notchHeight:"
            r0.append(r2)
            int r2 = r4.p
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.ads.fb.V(r1, r0)
            android.view.WindowInsets r5 = super.onApplyWindowInsets(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSSplashView.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fb.V("PPSSplashView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bf.Code(this.w);
        PPSSplashProView pPSSplashProView = this.z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void pauseView() {
        km kmVar = this.k;
        if (kmVar != null) {
            kmVar.pauseView();
        }
        PPSSplashProView pPSSplashProView = this.z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void resumeView() {
        km kmVar = this.k;
        if (kmVar != null) {
            kmVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.f = aVar;
        fn fnVar = this.c;
        if (fnVar != null) {
            fnVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.e = bVar;
        this.d.Code(bVar);
        fn fnVar = this.c;
        if (fnVar != null) {
            fnVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (w.Code(getContext())) {
            int Code = bb.Code(getContext(), adSlotParam.V());
            int V = bb.V(getContext(), adSlotParam.V());
            adSlotParam.Z(Code);
            adSlotParam.B(V);
            adSlotParam.I(this.x);
            adSlotParam.L(Integer.valueOf(this.s));
            adSlotParam.Code(com.huawei.hms.ads.utils.c.Code(adSlotParam.B()));
            adSlotParam.Z((Integer) 0);
            adSlotParam.B(Integer.valueOf((HiAd.Code(getContext()).isNewProcess() && com.huawei.openalliance.ad.utils.d.L(getContext())) ? 0 : 1));
            this.F = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code2 = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code2 instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code2).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.o = i;
        km kmVar = this.k;
        if (kmVar != null) {
            kmVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.s = i;
    }

    public void setLogo(View view) {
        setLogo(view, 8);
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.i = bitmap;
        this.h = 0;
        F();
    }

    public void setLogoResId(int i) {
        this.h = i;
        this.i = null;
        F();
    }

    public void setMediaNameResId(int i) {
        this.l = i;
        this.m = null;
        C();
    }

    public void setMediaNameString(String str) {
        this.m = str;
        this.l = 0;
        C();
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.y = rewardVerifyConfig;
    }

    public void setSloganResId(int i) {
        if (w.Code(getContext())) {
            if (I(getContext())) {
                fb.I("PPSSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.F == null && !(this instanceof SplashView)) {
                throw new dp("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.Code == null) {
                SloganView sloganView = new SloganView(getContext(), i, 1);
                this.Code = sloganView;
                int i2 = this.n;
                if (i2 > 0) {
                    sloganView.setWideSloganResId(i2);
                }
                this.V.addView(this.Code, new RelativeLayout.LayoutParams(-1, -1));
                this.Code.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.t = view;
            view.setVisibility(8);
        }
    }

    public void setWideSloganResId(int i) {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.setWideSloganResId(i);
        } else {
            this.n = i;
        }
    }

    public PPSSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private String V(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private void Z() {
        List<String> Code = this.F.Code();
        this.d.Code(!ad.Code(Code) ? Code.get(0) : null, 1);
        this.d.F();
        com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
    }

    @Override // com.huawei.hms.ads.kk
    public Integer Code(AdContentData adContentData) {
        int C = ja.C(adContentData.v());
        if (C == 0) {
            return null;
        }
        int I = I(adContentData);
        fb.V("PPSSplashView", "initial mode: %s", Integer.valueOf(I));
        if (I == 0) {
            return Integer.valueOf(I);
        }
        Map<String, String> Code = aa.Code(ed.Code(getContext()).ah());
        if (Code != null) {
            if ((2 == I || 3 == I) && Code(ay.I(Code.get(x.ct)))) {
                I = 4;
            }
            if ((1 == I || 4 == I) && Code(ay.I(Code.get(x.cs)))) {
                return 0;
            }
        }
        if (1 != this.F.V() || 2 != C) {
            return 0;
        }
        if (!Z(I) || !b()) {
            return Integer.valueOf(I);
        }
        fb.V("PPSSplashView", "can't use twist, enable : %s", Boolean.valueOf(this.B.f()));
        return 0;
    }

    public void setLogo(View view, int i) {
        this.D = view;
        view.setVisibility(i);
        this.L = i;
    }

    public PPSSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private String Code(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private String V(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.a() == null) ? this.B.E() : interactCfg.a();
    }

    private boolean Z(int i) {
        return 2 == i || 3 == i;
    }

    private String Code(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.a() == null) ? this.B.z() : interactCfg.a();
    }

    @Override // com.huawei.hms.ads.kk
    public void I(int i) {
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            pPSSkipButton.Code(i);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void V() {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.t;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private String Code(String str) {
        String Code = com.huawei.openalliance.ad.utils.c.Code(getContext(), this.K, 0);
        return !TextUtils.isEmpty(Code) ? Code : !TextUtils.isEmpty(this.B.x()) ? this.B.x() : str;
    }

    private static boolean I(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    private void V(Context context) {
        View.inflate(context, R.layout.hiad_view_splash_ad, this);
        this.V = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.f17429a = (PPSWLSView) findViewById(R.id.splash_wls_view);
        this.b = (PPSSplashAdSourceView) findViewById(R.id.splash_ad_source_view);
        this.u = ck.Code(context).V();
        this.z = (PPSSplashProView) findViewById(R.id.hiad_splash_pro_view);
        this.A = (PPSSplashSwipeView) findViewById(R.id.hiad_splash_swipe_view);
        this.E = (PPSSplashTwistView) findViewById(R.id.hiad_splash_twist_view);
        this.H = (PPSSplashTwistClickView) findViewById(R.id.hiad_splash_twist_click_view);
        this.G = (PPSSplashSwipeClickView) findViewById(R.id.hiad_splash_swipe_click_view);
    }

    private void V(AdContentData adContentData) {
        int i;
        boolean z;
        PPSSplashAdSourceView pPSSplashAdSourceView;
        boolean z2;
        int i2;
        boolean z3;
        PPSWLSView pPSWLSView;
        boolean z4;
        if (adContentData != null) {
            int V = this.F.V();
            Integer Code = Code(adContentData);
            InteractCfg aA = adContentData.aA();
            Integer B = aA == null ? null : aA.B();
            L();
            if (this.u) {
                this.b.setAdMediator(this.c);
                this.b.Code(this, Code, B, w.Code(true, adContentData.aQ(), adContentData.aP()));
                this.b.setVisibility(0);
                if (1 == V) {
                    pPSSplashAdSourceView = this.b;
                    z2 = adContentData.c() == 1;
                    i = this.p;
                    z = false;
                } else {
                    fb.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
                    int i3 = this.q;
                    if (i3 > 0) {
                        i = i3;
                        z = true;
                    } else {
                        i = this.r;
                        z = false;
                    }
                    pPSSplashAdSourceView = this.b;
                    z2 = adContentData.c() == 1;
                }
                pPSSplashAdSourceView.Code(adContentData, z2, i, V, z);
                return;
            }
            this.f17429a.setAdMediator(this.c);
            this.f17429a.Code(Code, B);
            this.f17429a.setVisibility(0);
            if (1 == V) {
                pPSWLSView = this.f17429a;
                z4 = adContentData.c() == 1;
                i2 = this.p;
                z3 = false;
            } else {
                fb.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
                int i4 = this.q;
                if (i4 > 0) {
                    i2 = i4;
                    z3 = true;
                } else {
                    i2 = this.r;
                    z3 = false;
                }
                pPSWLSView = this.f17429a;
                z4 = adContentData.c() == 1;
            }
            pPSWLSView.Code(adContentData, z4, i2, V, z3);
            if (ad.Code(adContentData.aL())) {
                return;
            }
            this.f17429a.setChoiceViewOnClickListener(new a(this, adContentData));
        }
    }

    public void Code(int i) {
        fj Code = fk.Code(i, this);
        this.c = Code;
        Code.Code(this.e);
        this.c.Code(this.f);
        this.c.Code(this.s);
        this.c.V(this.C);
        this.c.Code(this.y);
        this.c.m();
    }

    private void V(AdContentData adContentData, int i) {
        String str;
        String str2;
        boolean z;
        float f;
        int i2;
        if (I(getContext())) {
            fb.I("PPSSplashView", "addSkipAdButton - activity finished, not add view");
            return;
        }
        if (adContentData != null) {
            boolean z2 = adContentData.c() == 1;
            String B = adContentData.B();
            String p = adContentData.p();
            float ag = adContentData.ag();
            i2 = adContentData.ah();
            z = z2;
            str = B;
            str2 = p;
            f = ag;
        } else {
            str = null;
            str2 = null;
            z = false;
            f = 0.0f;
            i2 = 0;
        }
        PPSSkipButton Code = Code(str, i, str2, z, f, i2);
        this.I = Code;
        Code.setId(R.id.hiad_btn_skip);
        addView(this.I);
        this.I.setVisibility(4);
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i, int i2, String str, boolean z, Integer num) {
        if (this.z == null) {
            return;
        }
        fb.V("PPSSplashView", "set splashpro mode: %d", Integer.valueOf(i));
        fb.V("PPSSplashView", "interactCfg = %s", num);
        if (num == null) {
            this.z.setVisibility(8);
        } else if (num.intValue() == 0) {
            Code(i2, str, z);
        } else {
            Code(z, num.intValue());
        }
        this.z.setMode(i);
    }

    private void Code(int i, String str, boolean z) {
        fb.V("PPSSplashView", "showClickButton");
        c();
        this.z.setVisibility(4);
        this.z.setDesc(Code(str));
        this.z.setOrientation(this.F.V());
        this.z.Code(z, i);
        if (i != 0) {
            this.z.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i, boolean z) {
        View view = this.D;
        if (view == null) {
            return;
        }
        if (1 == i) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
        if (z) {
            B();
        }
    }

    private void Code(Context context) {
        V(context);
        this.d = new ik(context, this);
        this.B = ed.Code(context);
        this.x = n.I(context.getApplicationContext());
        this.J = new b();
        com.huawei.openalliance.ad.inter.d.Code(context.getApplicationContext()).Code(this.J);
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(View view) {
        fb.V("PPSSplashView", "showTemplateView");
        if (I(getContext())) {
            fb.I("PPSSplashView", "showAdView - activity finished, not add view");
        } else {
            this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.kk
    public void Code(km kmVar, Integer num) {
        if (I(getContext())) {
            fb.I("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (kmVar == 0 || !(kmVar instanceof View)) {
            return;
        }
        View view = (View) kmVar;
        this.k = kmVar;
        ViewParent parent = view.getParent();
        if (parent == this.V) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
        kmVar.setAudioFocusType(this.o);
        fb.V("PPSSplashView", "set splashpro view to adview");
        if (num != null && num.intValue() == 4) {
            kmVar.Code(this.G.getClickAreaView(), num);
        } else if (num == null || num.intValue() != 3) {
            kmVar.Code(this.z, num);
        } else {
            kmVar.Code(this.H.getClickAreaView(), num);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(ky kyVar) {
        View view = this.D;
        if (view != null) {
            view.setVisibility(this.L);
        }
        View view2 = this.t;
        if (view2 != null) {
            view2.setVisibility(0);
            new hy(this.B, kyVar).V();
            return;
        }
        SloganView sloganView = this.Code;
        if (sloganView == null) {
            fb.V("PPSSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.Code;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(kyVar);
        this.Code.Code();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(AdContentData adContentData, int i) {
        this.K = adContentData;
        setSkipBtnDelayTime(adContentData);
        if (this.I == null) {
            V(adContentData, i);
        }
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            km kmVar = this.k;
            if (kmVar != null) {
                pPSSkipButton.setShowLeftTime(kmVar.C());
            }
            if (adContentData != null && adContentData.S() != null && adContentData.l() == 9) {
                this.I.Code((int) ((((float) adContentData.S().k()) * 1.0f) / 1000.0f));
            }
            a();
        }
        V(adContentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (w.Code(iArr, 2) && w.Code(iArr2, 2) && adContentData != null) {
            if (fb.Code()) {
                fb.Code("PPSSplashView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                fb.Code("PPSSplashView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            addView(pPSAdvertiserInfoDialog, layoutParams);
            pPSAdvertiserInfoDialog.setScreenWidth(getMeasuredWidth());
            pPSAdvertiserInfoDialog.setScreenHeight(getMeasuredHeight());
            pPSAdvertiserInfoDialog.setAdContent(adContentData);
        }
    }

    private void Code(boolean z, int i) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        View view;
        fb.V("PPSSplashView", "showNewStyle, cfg= %s", Integer.valueOf(i));
        String Code = com.huawei.openalliance.ad.utils.c.Code(getContext(), this.K, i);
        AdContentData adContentData = this.K;
        InteractCfg aA = adContentData != null ? adContentData.aA() : null;
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.A;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.A.Code(Code(aA), Code(aA, Code));
            this.A.setOrientation(this.F.V());
            this.A.setShowLogo(z);
            view = this.A;
        } else if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.E;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.E.Code(V(aA), V(aA, Code));
            this.E.setOrientation(this.F.V());
            this.E.setShowLogo(z);
            view = this.E;
        } else if (3 == i) {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.H;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(4);
            this.H.Code(Z(aA), V(aA, Code));
            this.H.setOrientation(this.F.V());
            this.H.setShowLogo(z);
            view = this.H;
        } else {
            if (4 != i || (pPSSplashSwipeClickView = this.G) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.G.Code(I(aA), Code(aA, Code));
            this.G.setOrientation(this.F.V());
            this.G.setShowLogo(z);
            view = this.G;
        }
        view.setVisibility(0);
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long ag = ed.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l.longValue();
    }
}
