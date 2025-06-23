package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alimm.tanx.core.request.TanxError;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.ch;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.dg;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ee;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fo;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.hf;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.hz;
import com.huawei.hms.ads.im;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.kc;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.activity.FeedbackActivity;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class PPSNativeView extends RelativeLayout implements fo, gf, ki {
    private View.OnClickListener A;
    private im<ki> B;
    private fp C;
    protected gv Code;
    private ChoicesView D;
    private View F;
    private boolean I;
    private int L;
    private l S;

    /* renamed from: a, reason: collision with root package name */
    private CusWhyThisAdView f17425a;
    private boolean b;
    private b c;
    private d d;
    private e e;
    private c f;
    private kd g;
    private ke h;
    private kc i;
    private List<View> j;
    private boolean k;
    private final String l;
    private boolean m;
    private boolean n;
    private DislikeAdListener o;
    private String p;
    private String q;
    private MaterialClickInfo r;
    private CusWhyThisAdView.a s;
    private hg t;
    private AdFeedbackListener u;
    private AdCloseBtnClickListener v;
    private IRemoteCreator w;
    private ch x;
    private View y;
    private ImageView z;

    /* loaded from: classes10.dex */
    public static class a implements AdFeedbackListener {
        private final WeakReference<PPSNativeView> Code;

        public a(PPSNativeView pPSNativeView) {
            this.Code = new WeakReference<>(pPSNativeView);
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            PPSNativeView pPSNativeView = this.Code.get();
            if (pPSNativeView != null) {
                pPSNativeView.q();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Code(View view);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void Code();
    }

    /* loaded from: classes10.dex */
    public interface d {
        void Code();
    }

    /* loaded from: classes10.dex */
    public interface e {
        void B();

        void I();

        void V();

        void Z();
    }

    public PPSNativeView(Context context) {
        super(context);
        this.I = true;
        this.Code = new gj();
        this.k = false;
        this.l = x.ak + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.A = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7, true);
            }
        };
        Code(context);
    }

    private void a() {
        fb.Code("PPSNativeView", "initChoicesView start");
        if (this.D == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_choices_wrapper, (ViewGroup) null);
            this.F = inflate;
            this.D = (ChoicesView) inflate.findViewById(R.id.hiad_choices_icon);
            this.z = (ImageView) this.F.findViewById(R.id.compliance_icon);
            addView(this.F);
            View view = this.F;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        setChoiceViewPosition(1);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.Code() || PPSNativeView.this.S == null) {
                    return;
                }
                if (PPSNativeView.this.S.n() == null) {
                    fb.V("PPSNativeView", TanxError.ERROR_ADINFO_NULL);
                } else if (ad.Code(PPSNativeView.this.S.n().aL())) {
                    com.huawei.openalliance.ad.utils.d.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.n(), true);
                }
            }
        });
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.n || PPSNativeView.this.S == null) {
                    return;
                }
                ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.n(), false);
            }
        });
    }

    private void b() {
        fb.Code("PPSNativeView", "update choiceView start.");
        if (this.D == null) {
            fb.Code("PPSNativeView", "do not need update choiceView");
            return;
        }
        if (this.f17425a == null) {
            Z();
        }
        if (!this.n && this.f17425a != null) {
            fb.Code("PPSNativeView", "cusWhyView is not null, set choiceView as close.");
            this.D.V();
        } else {
            if (TextUtils.isEmpty(this.p)) {
                return;
            }
            fb.Code("PPSNativeView", "update choiceView.");
            if (TextUtils.isEmpty(this.q)) {
                this.D.I();
            } else {
                this.D.setAdChoiceIcon(this.q);
            }
        }
    }

    private boolean c() {
        fb.Code("PPSNativeView", "checkAndDealWithV3 ApiVer:%s , CreativeType:%s", this.S.av(), Integer.valueOf(this.S.c()));
        if (!Code(this.S.av(), this.S.c())) {
            return false;
        }
        V(getContext());
        return true;
    }

    private boolean d() {
        l lVar;
        return (this.y == null || (lVar = this.S) == null || (lVar.av() != null && 3 == this.S.av().intValue())) ? false : true;
    }

    private boolean e() {
        l lVar;
        return (this.z == null || this.n || (lVar = this.S) == null || lVar.n() == null || ad.Code(this.S.n().aL())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CusWhyThisAdView cusWhyThisAdView = this.f17425a;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                Code(viewGroup, 4);
            }
            this.f17425a.setVisibility(0);
            setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private void g() {
        Code(this.L);
        V(this.D);
        if (this.b || !h()) {
            return;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.NONE);
        this.I = true;
        Code(this, 0);
    }

    private HashMap<String, String> getBtnText() {
        AppInfo appInfo;
        kc kcVar = this.i;
        if (!(kcVar instanceof AppDownloadButton) || (appInfo = ((AppDownloadButton) kcVar).getAppInfo()) == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(bb.aM, appInfo.l());
        hashMap.put(bb.aN, appInfo.m());
        return hashMap;
    }

    private CusWhyThisAdView.a getWhyAdViewStatus() {
        return this.s;
    }

    private boolean h() {
        return getWhyAdViewStatus() != CusWhyThisAdView.a.NONE && getWhyAdViewStatus() == CusWhyThisAdView.a.INIT;
    }

    @AllApi
    public static void hideFeedback(Context context) {
        if (context != null) {
            com.huawei.openalliance.ad.msgnotify.b.Code(context, bm.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
        }
    }

    private void i() {
        View view;
        IRemoteCreator iRemoteCreator = this.w;
        if (iRemoteCreator != null && (view = this.y) != null) {
            try {
                iRemoteCreator.destroyView(ObjectWrapper.wrap(view));
            } catch (Throwable th) {
                fb.V("PPSNativeView", "destroy remote view err: %s", th.getClass().getSimpleName());
            }
        }
        this.w = null;
        this.y = null;
        ch chVar = this.x;
        if (chVar != null) {
            chVar.C();
            this.x = null;
        }
    }

    private void j() {
        ev.Code(getContext()).V();
        this.C.V();
        kd kdVar = this.g;
        if (kdVar != null) {
            kdVar.S();
            this.g.setPpsNativeView(null);
        }
        this.g = null;
        this.o = null;
        this.u = null;
        m();
        i();
    }

    private void k() {
        kc kcVar = this.i;
        if (kcVar != null) {
            kcVar.setClickActionListener(new kx() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.5
                @Override // com.huawei.hms.ads.kx
                public void Code(AppDownloadButton appDownloadButton) {
                    PPSNativeView.this.B.Code(null, null, PPSNativeView.this.getAdTag(), true);
                }

                @Override // com.huawei.hms.ads.kx
                public void I(AppDownloadButton appDownloadButton) {
                    if (PPSNativeView.this.e != null) {
                        PPSNativeView.this.e.V();
                        PPSNativeView.this.e.I();
                    }
                }

                @Override // com.huawei.hms.ads.kx
                public void V(AppDownloadButton appDownloadButton) {
                }
            });
        }
    }

    private void l() {
        l lVar;
        if (!C() || (lVar = this.S) == null || lVar.ai()) {
            return;
        }
        fb.V("PPSNativeView", " maybe report show start.");
        I();
    }

    private void m() {
        List<View> list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.j) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.j = arrayList;
        V(arrayList);
    }

    private void o() {
        p();
        Code((Integer) 3, false);
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.d();
            this.Code.I();
        }
        kd kdVar = this.g;
        if (kdVar != null) {
            kdVar.S();
        }
        DislikeAdListener dislikeAdListener = this.o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        j();
    }

    private void p() {
        if (this.i != null) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.9
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.i.cancel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        p();
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.d();
            this.Code.I();
        }
        kd kdVar = this.g;
        if (kdVar != null) {
            kdVar.S();
        }
        DislikeAdListener dislikeAdListener = this.o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        j();
    }

    private void setNativeVideoViewClickable(kd kdVar) {
        if (kdVar instanceof NativeVideoView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeVideoView) kdVar);
            V(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhyAdViewStatus(CusWhyThisAdView.a aVar) {
        this.s = aVar;
    }

    private void setWindowImageViewClickable(ke keVar) {
        if (keVar instanceof NativeWindowImageView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeWindowImageView) keVar);
            V(arrayList);
        }
    }

    @Override // com.huawei.hms.ads.ki
    public void D() {
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.Code(hr.CLICK);
        }
    }

    @Override // com.huawei.hms.ads.fo
    public void I() {
        e eVar;
        this.k = false;
        long Code = w.Code();
        String valueOf = String.valueOf(Code);
        l lVar = this.S;
        if (lVar == null) {
            fb.V("PPSNativeView", "nativeAd is null, please register first");
            return;
        }
        lVar.I(false);
        this.S.B(false);
        this.S.C(true);
        this.S.B(valueOf);
        this.S.V(Code);
        if (this.m && (eVar = this.e) != null) {
            this.m = false;
            eVar.Z();
        }
        if (!this.S.ag()) {
            this.S.V(true);
            if (this.d != null) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSNativeView.this.d != null) {
                            PPSNativeView.this.d.Code();
                        }
                    }
                });
            }
        }
        this.B.Code(valueOf);
        this.B.Code(Code);
        kd kdVar = this.g;
        if (kdVar != null) {
            kdVar.Code(valueOf);
            this.g.Code(Code);
        }
        kc kcVar = this.i;
        if (kcVar != null) {
            kcVar.Z(valueOf);
            this.i.Code(Code);
        }
        ch chVar = this.x;
        if (chVar != null) {
            chVar.Code(valueOf);
            this.x.Code(Code);
        }
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.L();
        }
        this.B.Code();
        ch chVar2 = this.x;
        if (chVar2 != null) {
            chVar2.Code("attachToWindow", (Bundle) null);
        }
    }

    public void L() {
        AdCloseBtnClickListener adCloseBtnClickListener = this.v;
        if (adCloseBtnClickListener != null) {
            adCloseBtnClickListener.onCloseBtnClick();
        }
    }

    @Override // com.huawei.hms.ads.fo
    public void V(long j, int i) {
        bf.Code(this.l);
        l lVar = this.S;
        if (lVar != null) {
            lVar.C(false);
        }
        this.B.Code(j, i);
    }

    @Override // com.huawei.hms.ads.fo
    public void a_() {
        l lVar = this.S;
        if (lVar != null) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.4
                @Override // java.lang.Runnable
                public void run() {
                    l lVar2 = PPSNativeView.this.S;
                    if (lVar2 != null) {
                        PPSNativeView.this.Code(Long.valueOf(lVar2.u()), Integer.valueOf(PPSNativeView.this.C.I()), null, false);
                    }
                }
            }, this.l, lVar.u());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int Code = jo.Code(motionEvent);
            if (Code == 0) {
                MaterialClickInfo Code2 = jo.Code(this, motionEvent);
                this.r = Code2;
                kc kcVar = this.i;
                if (kcVar != null) {
                    ((AppDownloadButton) kcVar).Code(Code2);
                }
            }
            if (1 == Code) {
                jo.Code(this, motionEvent, null, this.r);
                kc kcVar2 = this.i;
                if (kcVar2 != null) {
                    ((AppDownloadButton) kcVar2).Code(this.r);
                }
            }
        } catch (Throwable th) {
            fb.I("PPSNativeView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public hg getAdSessionAgent() {
        return this.t;
    }

    @Override // com.huawei.hms.ads.ki
    public String getAdTag() {
        if (!d() || this.S.aA() == null) {
            return null;
        }
        return this.S.aA().Code();
    }

    public MaterialClickInfo getClickInfo() {
        return this.r;
    }

    @AllApi
    public View getFeedBackView() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.g.V();
            View view = this.y;
            if (view == null || V == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(V.Code(ObjectWrapper.wrap(view)));
        } catch (Throwable th) {
            fb.I("PPSNativeView", "get anchor view err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public l getNativeAd() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    @AllApi
    public void gotoWhyThisAdPage() {
        if (this.S != null) {
            com.huawei.openalliance.ad.utils.d.Code(getContext(), this.S);
        } else {
            fb.I("PPSNativeView", "skipWhyThisAdPage nativaAd is null");
        }
    }

    @AllApi
    public void hideAdvertiserInfoDialog() {
        hideFeedback(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fp fpVar = this.C;
        if (fpVar != null) {
            fpVar.D();
        }
        l lVar = this.S;
        if (lVar != null) {
            Code((com.huawei.openalliance.ad.inter.data.d) lVar);
        }
        iz.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.V("PPSNativeView", "onDetechedFromWindow");
        fp fpVar = this.C;
        if (fpVar != null) {
            fpVar.L();
        }
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.I();
        }
    }

    public void onViewUpdate() {
        if (fb.Code()) {
            fb.Code("PPSNativeView", "manual updateView");
        }
        this.C.onGlobalLayout();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fp fpVar = this.C;
        if (fpVar != null) {
            fpVar.a();
        }
    }

    @AllApi
    public void pause() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.g.V();
            View view = this.y;
            if (view == null || V == null) {
                return;
            }
            V.Code(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th) {
            fb.I("PPSNativeView", "pauseVideo err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void resume() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.g.V();
            View view = this.y;
            if (view == null || V == null) {
                return;
            }
            V.V(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th) {
            fb.I("PPSNativeView", "resumeVideo err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener) {
        this.v = adCloseBtnClickListener;
    }

    public void setAdContainerSizeMatched(String str) {
        this.B.V(str);
    }

    @AllApi
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.u = adFeedbackListener;
    }

    public void setChoiceViewPosition(int i) {
        fb.Code("PPSNativeView", "setChoiceViewPosition option = " + i);
        if (this.S == null) {
            this.L = i;
        } else {
            Code(i);
        }
    }

    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        if (this.b) {
            fb.I("PPSNativeView", "china rom should not call setChoiceViewPosition method");
        } else {
            this.o = dislikeAdListener;
        }
    }

    public void setImageInfos(List<ImageInfo> list) {
        this.B.Code(list);
    }

    public void setIsCustomDislikeThisAdEnabled(boolean z) {
        if (this.b) {
            fb.I("PPSNativeView", "china rom should not call this method and isCustomDislikeThisAdEnabled = " + z);
            return;
        }
        this.n = z;
        if (z) {
            fb.Code("PPSNativeView", "dont like default feedback!");
            return;
        }
        fb.Code("PPSNativeView", "like default feedback!");
        ChoicesView choicesView = this.D;
        if (choicesView != null) {
            choicesView.V();
            fb.Code("PPSNativeView", "setCustomLikeBackgroundResource");
        }
        Z();
    }

    public void setMaterialClickInfo(MaterialClickInfo materialClickInfo) {
        this.r = materialClickInfo;
    }

    public void setOnNativeAdClickListener(b bVar) {
        this.c = bVar;
    }

    public void setOnNativeAdImpressionListener(c cVar) {
        this.f = cVar;
    }

    public void setOnNativeAdStatusChangedListener(d dVar) {
        this.d = dVar;
    }

    public void setOnNativeAdStatusTrackingListener(e eVar) {
        this.e = eVar;
        this.B.Code(eVar);
    }

    public void setVideoAlias(String str) {
        this.B.I(str);
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.B.Code(videoInfo);
    }

    @AllApi
    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            fb.I("PPSNativeView", "anchorView is null");
        }
        try {
            l lVar = this.S;
            if (lVar == null) {
                fb.I("PPSNativeView", TanxError.ERROR_ADINFO_NULL);
                return;
            }
            AdContentData n = lVar.n();
            if (ad.Code(n.aL())) {
                fb.I("PPSNativeView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, n, z);
            }
        } catch (Throwable th) {
            fb.I("PPSNativeView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void showFeedback(View view) {
        com.huawei.openalliance.ad.feedback.a aVar = new com.huawei.openalliance.ad.feedback.a();
        aVar.Code(view);
        aVar.V(this.u);
        aVar.Code(new a(this));
        dg.Code(this.S);
        FeedbackActivity.Code(getContext(), aVar);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = true;
        this.Code = new gj();
        this.k = false;
        this.l = x.ak + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.A = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7, true);
            }
        };
        Code(context);
    }

    private void V(Context context) {
        fb.V("PPSNativeView", "showV3Ad");
        IRemoteCreator Code = com.huawei.hms.ads.g.Code(getContext().getApplicationContext());
        this.w = Code;
        if (Code == null) {
            fb.V("PPSNativeView", "Creator is null");
            return;
        }
        this.x = new ch(context, this, this.S);
        String V = aa.V(this.S.n());
        fb.Code("PPSNativeView", "showV3Ad contentJson: %s", V);
        Bundle bundle = new Bundle();
        bundle.putBinder(bn.f.o, (IBinder) ObjectWrapper.wrap(getContext()));
        bundle.putString("content", V);
        bundle.putInt(bn.f.Code, com.huawei.hms.ads.base.a.B);
        boolean f = bc.f(getContext().getApplicationContext());
        bundle.putBoolean(bn.f.p, com.huawei.openalliance.ad.utils.c.Code(getContext(), this.S.aA(), this.S.o(), this.S.j_()));
        if (fb.Code()) {
            fb.Code("PPSNativeView", "emui9 dark %s", Boolean.valueOf(f));
        }
        bundle.putBoolean(bn.f.t, f);
        try {
            View view = (View) ObjectWrapper.unwrap(this.w.newNativeTemplateView(bundle, this.x));
            this.y = view;
            if (view == null) {
                fb.I("PPSNativeView", "templateView is null");
                return;
            }
            this.Code = null;
            removeAllViews();
            addView(this.y);
            this.w.bindData(ObjectWrapper.wrap(this.y), V);
            if (d()) {
                ee.Code(getContext().getApplicationContext()).Code(this.S.o(), System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slotid", this.S.o());
                com.huawei.openalliance.ad.ipc.g.V(context).Code(s.K, jSONObject.toString(), null, null);
            }
        } catch (Throwable th) {
            fb.I("PPSNativeView", "create newNativeTemplateView err: %s", th.getClass().getSimpleName());
        }
    }

    public void B() {
        j();
        ev.Code(getContext()).V();
        if (!this.b) {
            Code(this.F);
            this.F = null;
            this.D = null;
            Code(this.f17425a);
            this.f17425a = null;
        }
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.I();
        }
    }

    public boolean C() {
        fp fpVar = this.C;
        if (fpVar != null) {
            return fpVar.d();
        }
        return false;
    }

    public void Code(int i) {
        fb.Code("PPSNativeView", "changeChoiceViewPosition option = " + i);
        if (this.b) {
            fb.I("PPSNativeView", "china rom should not call this method");
            return;
        }
        if (this.F == null) {
            fb.Code("PPSNativeView", "choicesView is null, error");
            return;
        }
        if (e()) {
            this.z.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.F.getLayoutParams());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.hiad_10_dp);
        if (i != 0) {
            if (i == 2) {
                layoutParams.addRule(12);
            } else if (i == 3) {
                layoutParams.addRule(12);
            } else {
                if (i == 4) {
                    if (this.n) {
                        fb.Code("PPSNativeView", "ADCHOICES_INVISIBLE is called and not default feedback!");
                        Code(this.F, 8);
                        return;
                    }
                    this.F.setVisibility(0);
                    this.F.setLayoutParams(layoutParams);
                    this.F.bringToFront();
                }
                layoutParams.addRule(10);
            }
            layoutParams.addRule(21);
            layoutParams.setMargins(0, 0, dimensionPixelOffset, 0);
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.F.setVisibility(0);
            this.F.setLayoutParams(layoutParams);
            this.F.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, 0, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.F.setScaleX(-1.0f);
        this.D.setScaleX(-1.0f);
        this.F.setVisibility(0);
        this.F.setLayoutParams(layoutParams);
        this.F.bringToFront();
    }

    public void F() {
        fb.V("PPSNativeView", "onClose");
        Code((List<String>) null);
    }

    public void S() {
        gv gvVar = this.Code;
        if (gvVar != null) {
            gvVar.I();
        }
    }

    public void Z() {
        if (this.f17425a == null || getWhyAdViewStatus() != CusWhyThisAdView.a.INIT) {
            View view = this.f17425a;
            if (view != null) {
                Code(view);
                this.f17425a = null;
            }
            setWhyAdViewStatus(CusWhyThisAdView.a.INIT);
            CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this);
            this.f17425a = cusWhyThisAdView;
            addView(cusWhyThisAdView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f17425a.getLayoutParams());
            layoutParams.addRule(13);
            this.f17425a.setLayoutParams(layoutParams);
        }
        this.f17425a.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.3
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                PPSNativeView.this.f();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSNativeView.this.S != null) {
                    return PPSNativeView.this.S.m();
                }
                fb.I("PPSNativeView", "getKeyWords nativaAd is null");
                return null;
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSNativeView.this.S != null) {
                    com.huawei.openalliance.ad.utils.d.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    fb.I("PPSNativeView", "processWhyThisAdEvent nativaAd is null");
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                PPSNativeView.this.f();
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSNativeView.this.setWhyAdViewStatus(CusWhyThisAdView.a.DISLIKED);
                PPSNativeView.this.Code(arrayList);
            }
        });
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = true;
        this.Code = new gj();
        this.k = false;
        this.l = x.ak + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.A = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7, true);
            }
        };
        Code(context);
    }

    private void V(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.bringToFront();
    }

    @Override // com.huawei.hms.ads.fo
    public void Code(long j, int i) {
        bf.Code(this.l);
        if (!this.C.Code(j) || this.k) {
            return;
        }
        this.k = true;
        Code(Long.valueOf(j), Integer.valueOf(i), null, false);
    }

    @SuppressLint({"NewApi"})
    public PPSNativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = true;
        this.Code = new gj();
        this.k = false;
        this.l = x.ak + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.A = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7, true);
            }
        };
    }

    private void Code(Context context) {
        this.B = new hz(context, this);
        this.C = new fp(this, this);
        boolean V = ck.Code(context).V();
        this.b = V;
        if (V) {
            return;
        }
        a();
    }

    public void V(kc kcVar) {
        kc kcVar2;
        if (kcVar == null || kcVar != (kcVar2 = this.i)) {
            return;
        }
        kcVar2.setPpsNativeView(null);
        this.i.Code((com.huawei.openalliance.ad.inter.data.g) null);
        this.i = null;
    }

    private void Code(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.A);
            } else if (view != null) {
                view.setOnClickListener(this.A);
            }
        }
    }

    private void Code(View view, int i) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                viewGroup.getChildAt(i2).setVisibility(i);
            }
        }
    }

    public void Code(View view, int i, boolean z) {
        l lVar;
        if (this.I) {
            this.I = false;
            fb.V("PPSNativeView", "onClick");
            this.m = true;
            b bVar = this.c;
            if (bVar != null) {
                bVar.Code(view);
            }
            ev.Code(getContext()).Code();
            Code((Integer) 1, true);
            q.V();
            if (this.B.Code(this.r, Integer.valueOf(i), getAdTag(), z, getBtnText())) {
                gv gvVar = this.Code;
                if (gvVar != null) {
                    gvVar.Code(hr.CLICK);
                }
            } else {
                kc kcVar = this.i;
                if (kcVar instanceof AppDownloadButton) {
                    if (k.DOWNLOAD == ((AppDownloadButton) kcVar).getStatus() && (lVar = this.S) != null && lVar.p_() && ja.I(this.S.m_())) {
                        fb.V("PPSNativeView", "download app directly");
                        ((AppDownloadButton) this.i).performClick();
                    }
                }
            }
            this.r = null;
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.8
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.I = true;
                }
            }, 500L);
        }
    }

    private void Code(gv gvVar, l lVar) {
        kd kdVar = this.g;
        if (kdVar instanceof NativeVideoView) {
            ((NativeVideoView) kdVar).Code(gvVar, lVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        gv gvVar;
        if (dVar instanceof l) {
            l lVar = (l) dVar;
            AdContentData n = lVar.n();
            if (n.aF() == 3 || (gvVar = this.Code) == null) {
                return;
            }
            gvVar.Code(getContext(), n, this, true);
            this.Code.Code(false);
            this.Code.Z();
            hg V = this.Code.V();
            this.t = V;
            if (V != null) {
                ChoicesView choicesView = this.D;
                hf hfVar = hf.OTHER;
                V.Code(choicesView, hfVar, null);
                this.t.Code(this.f17425a, hfVar, null);
                this.t.Code(this.F, hfVar, null);
            }
            Code(this.Code, lVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        fb.Code("PPSNativeView", "register nativeAd");
        this.S = (l) gVar;
        g();
        if (!c()) {
            this.p = gVar.j();
            this.q = gVar.k();
            b();
        }
        this.C.V(this.S.u(), this.S.v());
        this.B.Code(this.S);
        this.B.V();
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
        l();
        n();
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        fb.Code("PPSNativeView", "register nativeAd");
        this.S = (l) gVar;
        g();
        if (!c()) {
            this.p = gVar.j();
            this.q = gVar.k();
            b();
        }
        this.C.V(this.S.u(), this.S.v());
        this.B.Code(this.S);
        this.B.V();
        l();
        this.j = list;
        V(list);
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, kd kdVar) {
        this.g = kdVar;
        Code(gVar);
        if (kdVar != null) {
            kdVar.setPpsNativeView(this);
            kdVar.setNativeAd(gVar);
            setNativeVideoViewClickable(kdVar);
        }
        this.j = list;
        V(list);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, ke keVar) {
        Code(gVar);
        this.h = keVar;
        if (keVar != null) {
            keVar.setNativeAd(gVar);
            setWindowImageViewClickable(this.h);
        }
        this.j = list;
        V(list);
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.C.Z()), Integer.valueOf(this.C.I()), num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        l lVar = this.S;
        if (lVar == null) {
            return;
        }
        boolean Code = com.huawei.openalliance.ad.utils.c.Code(lVar.F(), num2);
        if (!this.S.ah() || (Code && !this.S.X())) {
            this.B.Code(l, num, num2, z, getAdTag());
            if (Code) {
                this.S.B(true);
            }
            if (this.S.ah()) {
                return;
            }
            this.S.I(true);
            e eVar = this.e;
            if (eVar != null) {
                eVar.B();
            }
            gv gvVar = this.Code;
            if (gvVar != null) {
                gvVar.D();
            }
            c cVar = this.f;
            if (cVar != null) {
                cVar.Code();
            }
        }
    }

    public void Code(List<String> list) {
        fb.V("PPSNativeView", "onClose keyWords");
        this.B.V(list);
        o();
    }

    public boolean Code() {
        if (this.n || this.f17425a == null) {
            return false;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.SHOWN);
        f();
        this.f17425a.V();
        m();
        this.I = false;
        return true;
    }

    public boolean Code(kc kcVar) {
        boolean z;
        if (this.S == null) {
            throw new IllegalStateException("Register INativeAd first");
        }
        this.i = kcVar;
        if (kcVar != null) {
            kcVar.setPpsNativeView(this);
            z = kcVar.Code(this.S);
            k();
        } else {
            z = false;
        }
        if (fb.Code()) {
            fb.Code("PPSNativeView", "register downloadbutton, succ:" + z);
        }
        return z;
    }

    private boolean Code(Integer num, int i) {
        return (num != null && 3 == num.intValue()) || 99 == i;
    }
}
