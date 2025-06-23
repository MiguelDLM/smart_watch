package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.banner.R;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.hf;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.il;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.kf;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.ah;
import com.huawei.openalliance.ad.constant.aw;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.inter.listeners.o;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class PPSBannerView extends RelativeLayout implements gf, kf, PPSLabelView.a {
    private ed A;
    private String E;
    private ImageView G;
    private final byte[] H;
    private boolean J;
    private String K;
    private TextView M;
    private int O;
    private b P;
    private a Q;
    private int R;
    private List<String> T;
    private String U;
    Handler V;
    private String W;
    private RequestOptions aa;
    private Location ab;
    private r ac;
    private Integer ad;
    private float ae;
    private RewardVerifyConfig af;
    private fs ag;
    private il d;
    private long e;
    private long f;
    private String g;
    private com.huawei.openalliance.ad.inter.listeners.d h;
    private o i;
    private com.huawei.openalliance.ad.inter.data.b j;
    private PPSNativeView k;
    private PPSNativeView l;
    private ImageView m;
    private ImageView n;
    private ChoicesView o;
    private CusWhyThisAdView p;
    private ImageView q;
    private boolean r;
    private LinearLayout s;
    private PPSLabelSourceView t;
    private PPSLabelView u;
    private TextView v;
    private AutoScaleSizeRelativeLayout w;
    private com.huawei.openalliance.ad.inter.data.g x;
    private com.huawei.openalliance.ad.inter.data.g y;
    private int z;

    /* loaded from: classes10.dex */
    public enum a {
        STARTED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    /* loaded from: classes10.dex */
    public enum b {
        IDLE,
        LOADING
    }

    public PPSBannerView(Context context) {
        super(context);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.P = b.IDLE;
        this.Q = a.STARTED;
        this.R = 0;
        this.ae = 0.05f;
        this.ag = new fs(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                fb.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.d();
                PPSBannerView.this.i();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i) {
                fb.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(context);
    }

    private long Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long g = gVar.g();
            r0 = currentTimeMillis < g ? g - currentTimeMillis : 0L;
            fb.Code("PPSBannerView", "calcAdLeftTime,currentTime:" + currentTimeMillis + ",expireTime:" + g + ",leftTime:" + r0);
        }
        return r0;
    }

    private void F() {
        if (this.G == null) {
            return;
        }
        fb.V("PPSBannerView", "init compliance activity");
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.x == null || !(PPSBannerView.this.x instanceof l)) {
                    return;
                }
                ComplianceActivity.Code(PPSBannerView.this.getContext(), view, ((l) PPSBannerView.this.x).n(), false);
            }
        });
    }

    private long V(long j) {
        ed edVar;
        if (0 == j || (edVar = this.A) == null) {
            return 0L;
        }
        long n = edVar.n();
        long p = this.A.p();
        if (fb.Code()) {
            fb.Code("PPSBannerView", "setBannerRefresh,minInterval:%s,maxInterval:%s", Long.valueOf(n), Long.valueOf(p));
        }
        if (n > p) {
            return 0L;
        }
        return j < n ? n : Math.min(j, p);
    }

    private String c() {
        return getResources().getString(R.string.hiad_click_open_to, getResources().getString(R.string.hiad_share_wx));
    }

    private b getAdLoadState() {
        b bVar;
        synchronized (this.H) {
            bVar = this.P;
        }
        return bVar;
    }

    private int getBannerVisibility() {
        int i;
        synchronized (this.H) {
            i = this.R;
        }
        return i;
    }

    private String getJumpText() {
        int j = this.x.n().j();
        if (j == 0 || j == 1 || j == 2) {
            return null;
        }
        if (j == 9) {
            PPSAbilityDataContent pPSAbilityDataContent = (PPSAbilityDataContent) aa.V(this.x.n().aG(), PPSAbilityDataContent.class, new Class[0]);
            return V(pPSAbilityDataContent != null ? pPSAbilityDataContent.V() : null);
        }
        PromoteInfo z = this.x.n().z();
        if (j == 10) {
            return Code(z);
        }
        if (j == 11) {
            return c();
        }
        if (z != null && z.getType() == 1) {
            String name = z.getName();
            return !TextUtils.isEmpty(name) ? getResources().getString(R.string.hiad_click_open_to, name) : getResources().getString(R.string.hiad_click_to_open_quick_app);
        }
        AppInfo y = this.x.n().y();
        if (y == null) {
            return getResources().getString(R.string.hiad_click_to_learn_more);
        }
        if (com.huawei.openalliance.ad.utils.g.Code(getContext(), y.Code())) {
            return (TextUtils.isEmpty(y.L()) || !com.huawei.openalliance.ad.utils.g.Code(getContext(), y.Code())) ? getResources().getString(R.string.hiad_click_to_learn_more) : getResources().getString(R.string.hiad_click_open_to, y.L());
        }
        return null;
    }

    private void h() {
        fb.V("PPSBannerView", "hide dsa activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), com.huawei.openalliance.ad.utils.g.I(getContext()), bm.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.V == null || this.x == null || f()) {
            return;
        }
        if (this.V.hasMessages(1001)) {
            this.V.removeMessages(1001);
        }
        fb.Code("PPSBannerView", "start closeAdWhenExpire");
        this.V.sendEmptyMessageDelayed(1001, Code(this.x));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1001)) {
            return;
        }
        fb.Code("PPSBannerView", "stopCloseAdWhenExpire");
        this.V.removeMessages(1001);
    }

    private void setAdLoadState(b bVar) {
        synchronized (this.H) {
            this.P = bVar;
        }
    }

    private void setAdViewParam(Context context) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.w;
        if (autoScaleSizeRelativeLayout == null || this.j == null || context == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autoScaleSizeRelativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.w.setLayoutParams(layoutParams);
        this.w.setRatio(Float.valueOf((this.j.Code() * 1.0f) / this.j.V()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerVisibility(int i) {
        synchronized (this.H) {
            this.R = i;
        }
    }

    private void setChildrenViewsInVisible(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setVisibility(4);
            }
        }
    }

    private void setChoiceViewPosition(int i) {
        fb.Code("PPSBannerView", "bannerView option = %s", Integer.valueOf(i));
        if (this.o == null) {
            fb.Code("PPSBannerView", "choicesView is null, error");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.o.getLayoutParams());
        Resources resources = getResources();
        int i2 = R.dimen.hiad_banner_choice_custom_margin;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i2);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(i2);
        if (i != 0) {
            if (i == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, dimensionPixelOffset2);
            } else if (i == 3) {
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                layoutParams.setMargins(dimensionPixelOffset, 0, 0, dimensionPixelOffset2);
            } else if (i == 4) {
                this.o.setVisibility(8);
                this.o.setLayoutParams(layoutParams);
                this.o.bringToFront();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, dimensionPixelOffset2, dimensionPixelOffset, 0);
            }
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.o.setLayoutParams(layoutParams);
            this.o.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset2, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.o.setLayoutParams(layoutParams);
        this.o.bringToFront();
    }

    public boolean C() {
        return getAdLoadState() == b.LOADING;
    }

    public void I() {
        if (getBannerState() == a.DESTROYED) {
            fb.V("PPSBannerView", "hasDestroyed");
            return;
        }
        fb.V("PPSBannerView", "pause");
        setBannerState(a.PAUSED);
        e();
    }

    public void Z() {
        if (getBannerState() == a.DESTROYED) {
            fb.V("PPSBannerView", "hasDestroyed");
            return;
        }
        fb.V("PPSBannerView", aw.ag);
        setBannerState(a.RESUMED);
        d();
    }

    public String getAdId() {
        return this.g;
    }

    public long getBannerRefresh() {
        return this.e;
    }

    public com.huawei.openalliance.ad.inter.data.b getBannerSize() {
        return this.j;
    }

    public a getBannerState() {
        a aVar;
        synchronized (this.H) {
            aVar = this.Q;
        }
        return aVar;
    }

    public BiddingInfo getBiddingInfo() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        if (gVar != null) {
            return gVar.ae();
        }
        return null;
    }

    public Integer getIsSmart() {
        return this.ad;
    }

    public Location getLocation() {
        return this.ab;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public RequestOptions getRequestOptions() {
        return this.aa;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs fsVar = this.ag;
        if (fsVar != null) {
            fsVar.D();
        }
        iz.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fs fsVar = this.ag;
        if (fsVar != null) {
            fsVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fs fsVar = this.ag;
        if (fsVar != null) {
            fsVar.a();
        }
    }

    public void setAdContainerSizeMatched(boolean z) {
        this.J = z;
    }

    public void setAdId(String str) {
        this.g = str;
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.d dVar) {
        this.h = dVar;
    }

    public void setBannerRefresh(long j) {
        long V = V(j);
        this.e = V;
        fb.V("PPSBannerView", "setBannerRefresh:%s", Long.valueOf(V));
    }

    public void setBannerSize(com.huawei.openalliance.ad.inter.data.b bVar) {
        this.j = bVar;
        setAdViewParam(getContext());
    }

    public void setBannerState(a aVar) {
        synchronized (this.H) {
            this.Q = aVar;
        }
    }

    public void setContentBundle(String str) {
        this.K = str;
    }

    public void setIsSmart(Integer num) {
        this.ad = num;
    }

    public void setLocation(Location location) {
        this.ab = location;
    }

    public void setOnBannerAdStatusTrackingListener(o oVar) {
        this.i = oVar;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.aa = requestOptions;
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.af = rewardVerifyConfig;
    }

    public void setTargetingInfo(r rVar) {
        this.ac = rVar;
    }

    public PPSBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.P = b.IDLE;
        this.Q = a.STARTED;
        this.R = 0;
        this.ae = 0.05f;
        this.ag = new fs(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                fb.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.d();
                PPSBannerView.this.i();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i) {
                fb.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private String Code(PromoteInfo promoteInfo) {
        return (promoteInfo == null || promoteInfo.getType() != 2 || TextUtils.isEmpty(promoteInfo.getName())) ? getResources().getString(R.string.hiad_click_to_open_wechat_mini_spec) : getResources().getString(R.string.hiad_click_open_to, promoteInfo.getName());
    }

    private void D() {
        fb.Code("PPSBannerView", "initChoicesView start");
        if (this.o == null) {
            ChoicesView choicesView = new ChoicesView(getContext());
            this.o = choicesView;
            choicesView.setId(R.id.hiad_choice_view);
            this.w.addView(this.o);
        }
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.p != null) {
                    PPSBannerView.this.L();
                    PPSBannerView.this.p.V();
                } else if (PPSBannerView.this.x instanceof l) {
                    w.Code(PPSBannerView.this.getContext(), ((l) PPSBannerView.this.x).n());
                }
                PPSBannerView.this.o.setVisibility(8);
            }
        });
        if (com.huawei.openalliance.ad.inter.data.b.Code == getBannerSize()) {
            this.o.V();
            this.o.Code(R.dimen.hiad_banner_choice_view_size);
        }
    }

    private void I(long j) {
        Handler handler = this.V;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.V.removeMessages(1000);
        }
        if (getBannerVisibility() == 4 || getBannerState() == a.PAUSED || getBannerState() == a.DESTROYED) {
            fb.V("PPSBannerView", "stopRefreshAd");
        } else if (0 != j) {
            fb.V("PPSBannerView", "start refreshAd ad will be refreshed in %s", Long.valueOf(j));
            this.V.sendEmptyMessageDelayed(1000, j * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        CusWhyThisAdView cusWhyThisAdView = this.p;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                setChildrenViewsInVisible(viewGroup);
            }
            this.p.setVisibility(0);
        }
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.w;
        if (autoScaleSizeRelativeLayout != null) {
            autoScaleSizeRelativeLayout.setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private String V(String str) {
        return !TextUtils.isEmpty(str) ? getResources().getString(R.string.hiad_click_open_to, str) : getResources().getString(R.string.hiad_click_to_open_harmony_service);
    }

    private void a() {
        if (this.p != null) {
            fb.Code("PPSBannerView", "SDK-banner cusWhyView is not null");
            return;
        }
        CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this.w);
        this.p = cusWhyThisAdView;
        cusWhyThisAdView.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.7
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSBannerView.this.x == null) {
                    return null;
                }
                return PPSBannerView.this.x.m();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSBannerView.this.x instanceof l) {
                    w.Code(PPSBannerView.this.getContext(), ((l) PPSBannerView.this.x).n());
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSBannerView pPSBannerView = PPSBannerView.this;
                pPSBannerView.Code(0, pPSBannerView.x, arrayList);
                PPSBannerView pPSBannerView2 = PPSBannerView.this;
                pPSBannerView2.Code(pPSBannerView2.f(), 2, 0);
            }
        });
        this.w.addView(this.p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.p.getLayoutParams());
        layoutParams.addRule(13);
        this.p.setLayoutParams(layoutParams);
    }

    private void b() {
        TextView textView;
        int i;
        String str = this.E;
        if (str == null || str.isEmpty()) {
            textView = this.v;
            i = 8;
        } else {
            this.v.setText(this.E);
            textView = this.v;
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j = this.e;
        if (j == 0) {
            j = this.f;
        }
        I(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1000)) {
            return;
        }
        fb.V("PPSBannerView", "stopRefreshAd");
        this.V.removeMessages(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.e > 0 || this.f > 0;
    }

    private void g() {
        fb.V("PPSBannerView", "hide activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bm.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    @Override // com.huawei.hms.ads.kf
    public void B() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        cy.Code(getContext(), gVar instanceof l ? ((l) gVar).q() : "", this.g, 8, ah.y, "Fail to display ad because of missing presentation material");
    }

    public void S() {
        PPSNativeView pPSNativeView = this.k;
        if (pPSNativeView != null) {
            pPSNativeView.S();
        }
        PPSNativeView pPSNativeView2 = this.l;
        if (pPSNativeView2 != null) {
            pPSNativeView2.S();
        }
    }

    public PPSBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.z = 0;
        this.H = new byte[0];
        this.J = true;
        this.P = b.IDLE;
        this.Q = a.STARTED;
        this.R = 0;
        this.ae = 0.05f;
        this.ag = new fs(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                fb.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.d();
                PPSBannerView.this.i();
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i2) {
                fb.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.e();
                PPSBannerView.this.j();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i2 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.x, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private void I(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        fb.Code("PPSBannerView", "reportAdCancelled");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.V, gVar, 0L);
    }

    public void Code() {
        if (!this.d.S()) {
            Code(f(), 1, 1001);
            return;
        }
        if (getAdLoadState() != b.IDLE) {
            fb.I("PPSBannerView", "ad is loading now!");
            Code(f(), 1, 701);
            return;
        }
        setAdLoadState(b.LOADING);
        ArrayList arrayList = new ArrayList();
        String str = this.U;
        if (str == null || str.isEmpty()) {
            arrayList = null;
        } else {
            arrayList.add(this.U);
        }
        this.d.Code(this.ab);
        this.d.Code(this.aa);
        this.d.Code(this.ac);
        this.d.Code(this.ad);
        this.d.V(Integer.valueOf(this.j.Code()));
        this.d.I(Integer.valueOf(this.j.V()));
        this.d.V(this.K);
        this.d.Code(this.g, 8, arrayList, this.e == 0 ? 0 : 1);
        d();
    }

    public void V() {
        fb.V("PPSBannerView", "destroy");
        setBannerState(a.DESTROYED);
        e();
        j();
        h();
        this.V = null;
    }

    private void V(Context context) {
        View.inflate(context, R.layout.hiad_view_banner_ad, this);
        this.k = (PPSNativeView) findViewById(R.id.hiad_banner_layout_1);
        this.l = (PPSNativeView) findViewById(R.id.hiad_banner_layout_2);
        this.m = (ImageView) findViewById(R.id.hiad_banner_image_1);
        this.n = (ImageView) findViewById(R.id.hiad_banner_image_2);
        this.t = (PPSLabelSourceView) findViewById(R.id.custom_ad_bg_layout);
        this.s = (LinearLayout) findViewById(R.id.custom_ad_bg_layout_container);
        this.G = (ImageView) findViewById(R.id.compliance_icon_banner);
        this.w = (AutoScaleSizeRelativeLayout) findViewById(R.id.hiad_banner_ad);
        setAdViewParam(context);
        this.w.setVisibility(8);
        boolean V = ck.Code(context).V();
        this.r = V;
        fb.Code("PPSBannerView", "isChinaRom = %s", Boolean.valueOf(V));
        if (this.r) {
            ImageView imageView = (ImageView) findViewById(R.id.hiad_banner_close_button);
            this.q = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(0, pPSBannerView.x, (List<String>) null);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.Code(pPSBannerView2.f(), 2, 0);
                }
            });
        } else {
            a();
            D();
            F();
        }
        Code(this.k);
        Code(this.l);
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(int i) {
        fb.Code("PPSBannerView", "onReqAdFail ");
        if (Code(this.U, this.T)) {
            Code(2, this.x, (List<String>) null);
            Code(false, 1, 705);
        } else {
            Code(f(), 1, i);
        }
        setAdLoadState(b.IDLE);
    }

    private void Code(int i, int i2) {
        com.huawei.openalliance.ad.inter.listeners.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        if (i == 0) {
            dVar.D();
        } else if (i == 1) {
            dVar.Code(i2);
        } else {
            if (i != 2) {
                return;
            }
            dVar.c();
        }
    }

    private void I(PPSNativeView pPSNativeView) {
        if (this.i == null) {
            return;
        }
        pPSNativeView.setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.8
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                PPSBannerView.this.i.L();
            }
        });
        pPSNativeView.setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.9
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                PPSBannerView.this.i.d();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                PPSBannerView.this.i.b();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                PPSBannerView.this.i.a();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                PPSBannerView.this.i.c();
            }
        });
    }

    private void V(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        fb.Code("PPSBannerView", "reportAdExpire");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.Code, gVar, gVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0025, code lost:
    
        r4.Code(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Code(int r4, com.huawei.openalliance.ad.inter.data.g r5, java.util.List<java.lang.String> r6) {
        /*
            r3 = this;
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r0 = r3.w
            if (r0 == 0) goto L4d
            r1 = 2
            r2 = 1
            if (r4 == 0) goto L1b
            if (r4 == r2) goto L11
            if (r4 == r1) goto Ld
            goto L2e
        Ld:
            r3.I(r5)
            goto L2e
        L11:
            int r4 = r0.getVisibility()
            if (r4 != 0) goto L2e
            r3.V(r5)
            goto L2e
        L1b:
            int r4 = r3.z
            int r4 = r4 - r2
            int r4 = r4 % r1
            if (r4 != 0) goto L29
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.k
            if (r4 == 0) goto L2e
        L25:
            r4.Code(r6)
            goto L2e
        L29:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.l
            if (r4 == 0) goto L2e
            goto L25
        L2e:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.k
            r5 = 8
            if (r4 == 0) goto L37
            r4.setVisibility(r5)
        L37:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.l
            if (r4 == 0) goto L3e
            r4.setVisibility(r5)
        L3e:
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r4 = r3.w
            r4.setVisibility(r5)
            com.huawei.hms.ads.fs r4 = r3.ag
            if (r4 == 0) goto L4a
            r4.onGlobalLayout()
        L4a:
            r3.S()
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(int, com.huawei.openalliance.ad.inter.data.g, java.util.List):void");
    }

    private void V(PPSNativeView pPSNativeView) {
        hg adSessionAgent = pPSNativeView.getAdSessionAgent();
        if (adSessionAgent != null) {
            adSessionAgent.Code(this.q, hf.CLOSE_AD, null);
            PPSLabelView pPSLabelView = this.u;
            hf hfVar = hf.OTHER;
            adSessionAgent.Code(pPSLabelView, hfVar, null);
            adSessionAgent.Code(this.v, hfVar, null);
            adSessionAgent.Code(this.o, hfVar, null);
            adSessionAgent.Code(this.p, hfVar, null);
        }
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(long j) {
        this.f = V(j);
        d();
    }

    private void Code(Context context) {
        this.d = new hv(context, this);
        ed Code = ed.Code(context);
        this.A = Code;
        this.ae = Code.s();
        this.O = w.V(getContext(), getResources().getDimension(R.dimen.hiad_2_dp));
        V(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Code(android.graphics.drawable.Drawable r7) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(android.graphics.drawable.Drawable):void");
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(Drawable drawable, com.huawei.openalliance.ad.inter.data.g gVar) {
        if (drawable == null || gVar == null) {
            Code(f(), 1, ah.y);
            fb.I("PPSBannerView", "onAdContentLoaded,content is null");
        } else {
            this.x = gVar;
            this.E = gVar.e();
            this.U = gVar.a();
            if (0 == Code(gVar)) {
                V(gVar);
                fb.Code("PPSBannerView", "do not show ad due to ad expired");
                Code(false, 1, 704);
                if (Code(this.W, this.T)) {
                    Code(2, this.y, (List<String>) null);
                }
            } else if (Code(this.U, this.T)) {
                fb.Code("PPSBannerView", "do not show ad due to ad cancelled");
                I(gVar);
                Code(false, 1, 705);
            } else {
                g();
                h();
                Code(drawable);
                Code(f(), 0, 0);
                i();
            }
            this.W = this.U;
            this.y = gVar;
        }
        setAdLoadState(b.IDLE);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        com.huawei.openalliance.ad.inter.data.b bVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PPSBannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_adId);
                    if (string != null && !string.isEmpty()) {
                        this.g = string;
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.equals("BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.Code;
                        } else if (string2.equals("LARGE_BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.V;
                        }
                        this.j = bVar;
                    }
                } catch (RuntimeException e) {
                    str = "initDefAttr " + e.getClass().getSimpleName();
                    fb.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = "initDefAttr " + th.getClass().getSimpleName();
                    fb.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView.a
    public void Code(fw fwVar, int[] iArr, int[] iArr2) {
        fb.Code("PPSBannerView", "on label click");
        com.huawei.openalliance.ad.inter.data.g gVar = this.x;
        if (gVar == null || !(gVar instanceof l)) {
            return;
        }
        cj.Code(getContext(), this.u, this.x.n());
    }

    private void Code(final PPSNativeView pPSNativeView) {
        pPSNativeView.setOnNativeAdImpressionListener(new PPSNativeView.c() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.c
            public void Code() {
                pPSNativeView.setAdContainerSizeMatched(PPSBannerView.this.ad == x.aP ? PPSBannerView.this.J : PPSBannerView.this.d.Code(PPSBannerView.this.j, PPSBannerView.this.ae) ? "1" : "0");
            }
        });
    }

    private void Code(String str) {
        if (!this.r || TextUtils.isEmpty(str)) {
            this.M.setVisibility(8);
            b();
        } else {
            this.M.setText(str);
            this.v.setVisibility(8);
            this.M.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.kf
    public void Code(List<String> list) {
        this.T = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i, int i2) {
        fb.Code("PPSBannerView", "notifyResult isRefreshAd:%s,resultType:%s", Boolean.valueOf(z), Integer.valueOf(i));
        Code(i, i2);
        if (z) {
            return;
        }
        e();
    }

    private boolean Code(String str, List<String> list) {
        fb.Code("PPSBannerView", "invalidcontentIds is %s", list);
        fb.Code("PPSBannerView", "currentContentId is %s", str);
        return (TextUtils.isEmpty(str) || list == null || list.isEmpty() || !list.contains(str)) ? false : true;
    }
}
