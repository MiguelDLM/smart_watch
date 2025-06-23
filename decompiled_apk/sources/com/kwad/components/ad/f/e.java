package com.kwad.components.ad.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.h.c {
    private com.kwad.components.core.widget.a.b bQ;
    private List<Integer> cB;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private int cP;
    private aq.b cU;
    private KSRelativeLayout eL;
    private boolean eQ;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    public IAdLivePlayModule eV;
    private a.b eY;
    private final AdLivePlayStateListener eZ;
    private ba fC;
    private aw fD;
    private WebCardRegisterLiveMessageListener fE;
    private WebCardRegisterLiveShopListener fF;
    private ax.b fJ;
    private ax.a fK;
    private OfflineOnAudioConflictListener fa;
    private IAdLiveEndRequest ga;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private ImageView mG;
    private RelativeLayout mH;
    private AdBasePvFrameLayout mI;
    private boolean mIsAudioEnable;
    private KSAdVideoPlayConfigImpl mJ;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private KsNativeAd.VideoPlayListener mr;
    private int mt;
    private int mu;
    private d.a mw;

    public e(@NonNull Context context) {
        super(context);
        this.mt = 0;
        this.mu = 0;
        this.cU = new aq.b() { // from class: com.kwad.components.ad.f.e.10
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                e.this.cP = aVar.status;
                if (e.this.cP != 1) {
                    e.this.mAdWebView.setVisibility(8);
                } else {
                    e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.ga);
            }

            @NonNull
            private static AdLiveEndCommonResultData p(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return p(str);
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.f.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayComplete();
                }
                String bf = com.kwad.sdk.core.response.b.a.bf(e.this.mAdInfo);
                if (!TextUtils.isEmpty(bf)) {
                    com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                    if (aVar != null) {
                        e.this.ga = aVar.getAdLiveEndRequest(bf);
                    }
                    e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                            super.onStartRequest(aVar2);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                            super.onSuccess(aVar2, adLiveEndCommonResultData);
                            ax.a aVar3 = new ax.a();
                            aVar3.status = 9;
                            aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                            aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                            aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                            aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                            aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                            aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                            if (e.this.fJ != null) {
                                e.this.fJ.a(aVar3);
                            } else {
                                e.this.fK = aVar3;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i, String str) {
                            super.onError(aVar2, i, str);
                        }
                    });
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    e.this.mr.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                e.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.pf().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                try {
                    e.this.mr.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.pf().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.j.a.pf().a(e.this.getCurrentVoiceItem());
                try {
                    e.this.mr.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        initView();
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.aEW = null;
        bVar2.Ph = this.mI;
        bVar2.OA = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.aEY = false;
    }

    private void ay() {
        if (!com.kwad.sdk.core.response.b.b.cS(this.mAdTemplate)) {
            return;
        }
        eu();
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
        this.mH.removeAllViews();
        this.mH.addView(view);
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.f.e.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                e.this.c(view);
            }
        });
        by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.as(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.bs(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.mG.setImageDrawable(null);
            KSImageLoader.loadImage(this.mG, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.f.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.mG.setVisibility(0);
            return;
        }
        this.mG.setVisibility(8);
    }

    private boolean bx() {
        if (this.cP == 1) {
            return true;
        }
        return false;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.f.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.fE != null) {
                    e.this.fE.n(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.f.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.fF != null) {
                    e.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    private void ep() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.mt = nativeAdExtraDataImpl.showLiveStatus;
            this.mu = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void et() {
        this.mAdWebView.setVisibility(8);
        ax();
        if (bx()) {
            this.mAdWebView.reload();
        } else {
            ay();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void eu() {
        aA();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().ek(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cN = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cN, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cK(this.mAdTemplate));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.f.e.11
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                String str;
                long playDuration;
                int i = aVar.Yn;
                if (aVar.KS) {
                    if (aVar.Yl) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
                boolean bb = com.kwad.sdk.core.response.b.a.bb(e.this.mAdInfo);
                com.kwad.sdk.core.webview.d.b.c cVar = aVar.Yo;
                if (cVar != null && !TextUtils.isEmpty(cVar.Lh)) {
                    str = aVar.Yo.Lh;
                } else {
                    str = "";
                }
                a.C0788a as = new a.C0788a(e.this.getContext()).ar(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ao(false).an(i).au(aVar.KS).as(bb);
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule == null) {
                    playDuration = 0;
                } else {
                    playDuration = iAdLivePlayModule.getPlayDuration();
                }
                com.kwad.components.core.e.d.a.a(as.v(playDuration).ah(str).aq(true).a(new a.b() { // from class: com.kwad.components.ad.f.e.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (e.this.mw != null) {
                            e.this.mw.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.f.e.4
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    e eVar = e.this;
                    if (eVar.eV == null) {
                        eVar.eV = eVar.bi();
                    }
                    e eVar2 = e.this;
                    eVar2.eV.setAudioEnabled(eVar2.g(eVar2.mIsAudioEnable), false);
                }
            });
        }
        return this.eY;
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.f.e.9
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0799a().at(bVar.title).au(bVar.url).at(e.this.mAdTemplate).pK());
            }
        };
    }

    private ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.f.e.8
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                e.this.fJ = bVar;
                if (e.this.fK != null) {
                    e.this.fJ.a(e.this.fK);
                    e.this.fK = null;
                }
            }
        };
    }

    private void initView() {
        com.kwad.sdk.n.l.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.mI = adBasePvFrameLayout;
        this.mG = (ImageView) adBasePvFrameLayout.findViewById(R.id.ksad_live_bg_img);
        this.eL = (KSRelativeLayout) this.mI.findViewById(R.id.ksad_live_container);
        this.mH = (RelativeLayout) this.mI.findViewById(R.id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.mI.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.eU = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.components.core.j.a.pf().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.eV = bi();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.pf().c(this.eY);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ac() {
        super.ac();
        this.bQ.ua();
        this.bQ.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ad() {
        super.ad();
        this.bQ.ua();
        this.bQ.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        com.kwad.components.core.j.a.pf().c(this.eY);
        this.fK = null;
        this.fJ = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mw = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mr = videoPlayListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.pf();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
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
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public final void a(Context context, AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.mAdInfo = dS;
        this.mContext = context;
        this.mJ = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.cB = com.kwad.sdk.core.response.b.a.bn(dS);
        this.bQ = new com.kwad.components.core.widget.a.b(getParent() == null ? this : (View) getParent(), 30);
        if (this.mJ.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.mJ.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bU(this.mAdInfo);
        }
        ep();
        et();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fC = new ba();
        aw awVar = new aw();
        this.fD = awVar;
        aVar.a(awVar);
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate)));
        aVar.a(new com.kwad.components.core.webview.jshandler.az(this.cO, this.mApkDownloadHelper));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aVar.a(this.fC);
        aVar.a(new ao(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.e(this.mt, this.mu));
        this.fF = new WebCardRegisterLiveShopListener();
        this.fE = new WebCardRegisterLiveMessageListener();
        aVar.a(this.fF);
        aVar.a(this.fE);
        aVar.a(new ax(getRegisterLiveListener()));
    }
}
