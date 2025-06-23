package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private List<Integer> cB;
    private volatile boolean cC;
    private com.kwad.sdk.widget.j cD;
    private ImageView dE;
    private TextView dF;
    private TextView dM;
    private KsAdVideoPlayConfig dU;
    private TextView eB;
    private ImageView eD;
    private TextView eF;
    private TextView eG;
    private View eH;
    private DownloadProgressView eI;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private TextView eR;
    private final a.InterfaceC0807a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private final AdLivePlayStateListener eZ;
    private OfflineOnAudioConflictListener fa;
    private a.b fb;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.cC = false;
        this.cD = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.b.c.1
            @Override // com.kwad.sdk.widget.j
            public final void ao() {
                com.kwad.sdk.utils.l.en(c.this.mAdTemplate);
            }
        };
        this.eS = new a.InterfaceC0807a() { // from class: com.kwad.components.ad.feed.b.c.3
            @Override // com.kwad.components.core.video.a.InterfaceC0807a
            public final void a(int i, ac.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            i2 = 35;
                        } else {
                            i2 = 39;
                            i3 = 1;
                            z = true;
                        }
                    } else {
                        i2 = 16;
                    }
                } else {
                    i2 = 15;
                }
                c.this.ba();
                com.kwad.components.core.e.d.a.a(new a.C0788a(c.this.getContext()).ar(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).an(i3).ao(z).aq(true).al(5).am(i2).d(aVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.tN();
                    }
                }));
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.c.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.eR.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                c.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.pf().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.pf().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.c.8
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.eN != null) {
                    c.this.eN.setVideoSoundEnable(false);
                }
                if (c.this.eV != null) {
                    c.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fb = new a.b() { // from class: com.kwad.components.ad.feed.b.c.10
            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                if (com.kwad.components.ad.feed.a.b.aW() && c.this.eP == null) {
                    c.this.eP = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.eP, layoutParams);
                    c.this.eP.bn();
                }
                com.kwad.sdk.core.adlog.c.bN(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                c.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - c.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.pf().a(c.this.getCurrentVoiceItem());
                if (c.this.eP != null && (c.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.eP.getParent()).removeView(c.this.eP);
                    c.this.eP.bo();
                    c.this.eP = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ey);
                com.kwad.sdk.core.adlog.c.bM(c.this.mAdTemplate);
            }
        };
    }

    private void bd() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eG = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eH = findViewById(R.id.ksad_h5_open_cover);
        this.eG.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aD(this.mAdInfo));
        this.eH.setOnClickListener(this);
        this.eG.setOnClickListener(this);
        this.dM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.dM, this);
    }

    private void be() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.eF = textView;
        com.kwad.sdk.c.a.a.a(this, this.dE, this.dF, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        this.dF.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.dE.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cg(this.mAdInfo), this.mAdTemplate, 8);
        this.eF.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        bb();
        this.eI.aj(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bg() {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.pj() && com.kwad.sdk.core.response.b.a.cM(this.mAdInfo)) {
            this.eW = true;
        }
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.eW) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eT.getView().getParent();
        if (viewGroup != this.eL) {
            viewGroup.removeView(this.eT.getView());
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eT.getView());
            this.eL.setTag(this.eT.getView());
            this.eV.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(this.eT, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.ch(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo), com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
            this.eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        }
        this.eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bi() {
        bj();
        IAdLiveOfflineView a2 = com.kwad.components.ad.j.b.a(this.eU, this.mContext, 3);
        this.eT = a2;
        if (a2 == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(a2, ServiceProvider.Lx().appId, String.valueOf(com.kwad.sdk.core.response.b.a.ch(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo), com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        final View view = this.eT.getView();
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(view);
        this.eL.setTag(view);
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.feed.b.c.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                c.this.c(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.as(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.bs(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.c.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        } else {
            this.eM.setImageResource(R.drawable.ksad_ad_live_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.c.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (c.this.eW) {
                        if (c.this.eV == null) {
                            c cVar = c.this;
                            cVar.eV = cVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                        c cVar2 = c.this;
                        iAdLivePlayModule.setAudioEnabled(cVar2.g(cVar2.mIsAudioEnable), false);
                        return;
                    }
                    if (c.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                        c cVar3 = c.this;
                        aVar.setVideoSoundEnable(cVar3.g(cVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.video.e eVar = this.eO;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.fb);
        }
        com.kwad.components.core.j.a.pf().a(getCurrentVoiceItem());
        if (!this.eW) {
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.eV = bi();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.pf().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.utils.l.el(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
        com.kwad.components.core.j.a.pf().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.eL = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eI = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.eR = (TextView) findViewById(R.id.ksad_live_end_text);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.as(this.mContext).b(this.fa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.kwad.sdk.core.video.videoview.a aVar;
        if (view == this.eD) {
            tO();
            return;
        }
        if (view == this.eL && (aVar = this.eN) != null && aVar.isIdle()) {
            com.kwad.sdk.utils.l.em(this.mAdTemplate);
            this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate));
            this.eN.start();
            return;
        }
        boolean z = true;
        if (view == this.eB) {
            i = 25;
        } else {
            if (view != this.eL) {
                if (view != this.eI && view != this.dM && view != this.eH) {
                    if (view == this.dE) {
                        i = 13;
                    } else if (view == this.dF) {
                        i = 14;
                    } else if (view != this.eF && view != this.eG) {
                        if (view != this.eN) {
                            i = 35;
                        }
                    } else {
                        i = 101;
                    }
                } else {
                    i = 1;
                }
            }
            i = 100;
        }
        com.kwad.sdk.core.video.videoview.a aVar2 = this.eN;
        if (view != this.eI) {
            z = false;
        }
        a(aVar2, z, i);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && this.eO != null) {
                ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                if (this.eN.getParent() != this.eL) {
                    viewGroup.removeView(this.eN);
                    if (this.eL.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.eL;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.eL.setTag(null);
                    }
                    this.eL.addView(this.eN);
                    this.eL.setTag(this.eN);
                    com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
                    this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                    this.eO.setAdClickListener(this.eS);
                    this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.eO.sq();
                    this.eO.setAutoRelease(true);
                }
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null) {
            this.eV.onPause();
        }
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bU(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
                iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
            } else {
                com.kwad.sdk.core.video.videoview.a aVar = this.eN;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.s.a.as(this.mContext).a(this.fa);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 && (eVar = this.eO) != null) {
                eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final View view) {
        view.post(new az() { // from class: com.kwad.components.ad.feed.b.c.6
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                int width = c.this.eL.getWidth();
                int height = c.this.eL.getHeight();
                if (width != 0 && height != 0) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                    layoutParams.addRule(13, -1);
                    view.setLayoutParams(layoutParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gt()) {
            if (com.kwad.components.core.s.a.as(this.mContext).rB()) {
                return !com.kwad.components.core.s.a.as(this.mContext).rA();
            }
            return com.kwad.components.core.s.a.as(this.mContext).aN(false);
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.as(this.mContext).aN(true);
        }
        return this.eQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((c) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.mLogoView.aE(this.mAdTemplate);
        bg();
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            be();
        } else {
            bd();
        }
        this.eB.setOnClickListener(this);
        this.eL.setOnClickListener(this);
        this.eD.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eL, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.c.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate)) {
            a(this.eN, view == this.eI, 153);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, final int i) {
        if (aVar != null || this.eW) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.eW) {
                this.eO.setAutoRelease(false);
            }
            int i2 = z ? 1 : 2;
            if (!this.eW) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
            ba();
            a.C0788a ao = new a.C0788a(getContext()).ar(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            com.kwad.components.core.e.d.a.a(ao.v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).an(i2).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.aL(i);
                }
            }));
        }
    }
}
