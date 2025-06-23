package com.kwad.components.ad.feed.b;

import XIXIX.OOXIXo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class m extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> fG = new HashMap<>(8);
    private List<Integer> cB;
    private int cP;
    private KsAdVideoPlayConfig dU;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private final a.InterfaceC0807a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private final AdLivePlayStateListener eZ;
    private d.b ek;
    private long ey;
    private LinearLayout fA;
    private TextView fB;
    private ba fC;
    private aw fD;
    private WebCardRegisterLiveMessageListener fE;
    private WebCardRegisterLiveShopListener fF;
    private boolean fH;
    private String fI;
    private ax.b fJ;
    private ax.a fK;
    private boolean fL;
    private com.kwad.components.core.widget.b fM;
    private float fN;
    private float fO;
    private boolean fP;
    private a fQ;
    private ViewGroup.MarginLayoutParams fR;
    private Handler fS;
    private e fT;
    private ar fU;
    private boolean fV;
    private boolean fW;
    private com.kwad.components.core.webview.b fX;
    private com.kwad.components.core.webview.c fY;
    private b.a fZ;
    private OfflineOnAudioConflictListener fa;
    private RatioFrameLayout fy;
    private double fz;
    private IAdLiveEndRequest ga;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void c(int i, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.cP = -1;
        this.mIsAudioEnable = false;
        this.fL = false;
        this.fS = new Handler(Looper.getMainLooper());
        this.fV = false;
        this.fW = false;
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eN != null) {
                    m.this.eN.setVideoSoundEnable(false);
                }
                if (m.this.eV != null) {
                    m.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fY = new AnonymousClass11();
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.m.13
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.abY != null) {
                    m.this.abY.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.abY != null && m.this.fL) {
                    m.this.abY.onAdShow();
                }
                if (m.this.fL) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0845a c0845a = new a.C0845a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0845a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0845a);
                    bVar.v((int) Math.ceil(m.this.fz), m.this.mWidth);
                    com.kwad.components.core.s.b.rC().a(m.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.abY != null) {
                    m.this.abY.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.abY != null) {
                    m.this.abY.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.abY != null) {
                    m.this.abY.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.ga);
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
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bf = com.kwad.sdk.core.response.b.a.bf(m.this.mAdInfo);
                if (!TextUtils.isEmpty(bf)) {
                    com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                    if (aVar != null) {
                        m.this.ga = aVar.getAdLiveEndRequest(bf);
                    }
                    m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
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
                            if (m.this.fJ != null) {
                                m.this.fJ.a(aVar3);
                            } else {
                                m.this.fK = aVar3;
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
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                m.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.j.a.pf().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.j.a.pf().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eV.setAudioEnabled(false, false);
            }
        };
        this.eS = new a.InterfaceC0807a() { // from class: com.kwad.components.ad.feed.b.m.10
            @Override // com.kwad.components.core.video.a.InterfaceC0807a
            public final void a(int i, ac.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            i2 = 108;
                        } else {
                            i2 = 83;
                            i3 = 1;
                            z = true;
                        }
                    } else {
                        i2 = 82;
                    }
                } else {
                    i2 = 13;
                }
                m.this.bw();
                com.kwad.components.core.e.d.a.a(new a.C0788a(m.this.getContext()).ar(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(i3).ao(z).aq(true).am(i2).d(aVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        m.this.tN();
                    }
                }));
            }
        };
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eV == null) {
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
            this.eV.setAudioEnabled(g(this.mIsAudioEnable), false);
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
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.feed.b.m.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                m.this.c(view);
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
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
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

    private void bt() {
        this.fS.postDelayed(new az() { // from class: com.kwad.components.ad.feed.b.m.12
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.a("0", 1, 6);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        float cN = com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate);
        d.b bVar = new d.b() { // from class: com.kwad.components.ad.feed.b.m.17
            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(final double d) {
                if (!br.o(m.this.fy, (int) (com.kwad.sdk.core.config.d.CV() * 100.0f))) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0788a(m.this.getContext()).ar(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(2).ao(false).aq(false).am(157).al(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.e.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.ec(m.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                        bVar2.l(d);
                        bVar2.cK(157);
                        m.this.c(bVar2);
                    }
                }));
                return true;
            }
        };
        this.ek = bVar;
        com.kwad.components.ad.feed.d.a(cN, this.mContext, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bx() {
        if (this.cP == 1) {
            return true;
        }
        return false;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fE != null) {
                    m.this.fE.n(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fF != null) {
                    m.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.m.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (m.this.eW) {
                        if (m.this.eV == null) {
                            m mVar = m.this;
                            mVar.eV = mVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                        m mVar2 = m.this;
                        iAdLivePlayModule.setAudioEnabled(mVar2.g(mVar2.mIsAudioEnable), false);
                        return;
                    }
                    if (m.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                        m mVar3 = m.this;
                        aVar.setVideoSoundEnable(mVar3.g(mVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.feed.b.m.18
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0799a().at(bVar.title).au(bVar.url).aC(true).at(m.this.mAdTemplate).pK());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.feed.b.m.14
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                m.this.fJ = bVar;
                if (m.this.fK != null) {
                    m.this.fJ.a(m.this.fK);
                    m.this.fK = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.b.m.7
            private boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.qI().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.adlog.c.bN(m.this.mAdTemplate);
                m.this.fC.aQ(9);
                m.this.eL.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.aW() && m.this.eP == null && !m.this.fV) {
                    m.this.eP = new d(m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.eP, layoutParams);
                    m.this.eP.bn();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                m.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - m.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.pf().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ey);
                com.kwad.sdk.core.adlog.c.bM(m.this.mAdTemplate);
                m.this.fC.aQ(3);
                if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                    m.this.eP.bo();
                    m.this.eP = null;
                }
                if (m.this.fT == null && com.kwad.sdk.core.response.b.b.cL(m.this.mAdTemplate) && m.this.fV) {
                    m.this.fT = new e(m.this.mContext);
                    m.this.eL.addView(m.this.fT, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fT.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (!com.kwad.sdk.core.response.b.b.cM(m.this.mAdTemplate)) {
                                m.this.v(158);
                            }
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (!com.kwad.sdk.core.response.b.b.cM(m.this.mAdTemplate) && com.kwad.sdk.core.response.b.d.dH(m.this.mAdTemplate)) {
                                m.this.v(153);
                            }
                        }
                    });
                    m.this.fT.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fU.aP(1);
                            m.this.eL.removeView(m.this.fT);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
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

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        com.kwad.components.ad.feed.monitor.b.aZ();
        this.fy = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.eL = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.fA = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.fB = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        if (this.cP != 1 && !this.fH) {
            this.mAdWebView.stopLoading();
            this.mAdWebView.setVisibility(8);
            a("0", 1, 3);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        aw awVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.abY) != null && this.fL) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (!this.fL && (awVar = this.fD) != null) {
            awVar.sW();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.d.CY() && com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.ch(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            a(motionEvent);
            if ((action == 2 || action == 3) && this.mAdWebView != null && !this.fL && Math.abs(motionEvent.getX() - this.fN) > 0.0f) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.fN);
                double abs2 = Math.abs(motionEvent.getY() - this.fO);
                if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                    this.mAdWebView.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (z) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eL) {
                viewGroup.removeView(this.eN);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.eO.setVideoPlayCallback(getVideoPlayCallback());
                this.eO.setAdClickListener(this.eS);
                this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eO.sq();
                this.eO.setAutoRelease(true);
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
            iAdLivePlayModule.onPause();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fQ;
        if (aVar2 != null) {
            int i = 1;
            if (this.cP == 1) {
                i = 2;
            }
            aVar2.c(i, "");
        }
        this.fQ = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r = this.mAdTemplate;
                if (r != 0) {
                    r.mIsAudioEnable = isVideoSoundEnable;
                }
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 && (eVar = this.eO) != null) {
                eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void ay() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jq();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().aA(this.mAdTemplate).aH(com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate)).d(this.mAdWebView).k(this.fy).f(this.mApkDownloadHelper).a(this.fY));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate));
        R r = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.b.b.cI(r));
        bt();
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

    private static float h(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (fG.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.fy.setRatio(r5.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.cO(this.mAdTemplate) > OOXIXo.f3760XO) {
            this.fy.setRatio(com.kwad.sdk.core.response.b.b.cO(this.mAdTemplate));
        } else if (this.fy.getRatio() == OOXIXo.f3760XO) {
            this.fy.setRatio(h(this.mAdTemplate));
        }
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.pj() && com.kwad.sdk.core.response.b.a.cM(this.mAdInfo)) {
            this.eW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final int i) {
        bw();
        com.kwad.components.core.e.d.a.a(new a.C0788a(getContext()).ar(this.mAdTemplate).b(this.mApkDownloadHelper).an(1).ao(true).am(i).al(5).aq(false).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.8
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.aL(i);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        if (this.ek != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate), this.mContext, this.ek);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.fS.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.el(this.mAdTemplate);
        d.b bVar = this.ek;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
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
        this.fJ = null;
        this.fK = null;
    }

    public static /* synthetic */ boolean d(m mVar, boolean z) {
        mVar.fV = true;
        return true;
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

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        g(n);
        n.realShowType = 2;
        super.b((m) adResultData);
        if (this.fH) {
            com.kwad.components.core.widget.b bVar = this.fM;
            if (bVar != null) {
                bVar.b((com.kwad.components.core.widget.b) adResultData);
                com.kwad.components.core.widget.b bVar2 = this.fM;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dU);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.cP(this.mAdTemplate)) {
            a("0", 0, 1);
            return;
        }
        if (!bx()) {
            i(this.mAdTemplate);
        }
        try {
            String str = this.fI;
            if (str == null || !str.equals(n.mOriginJString)) {
                if (bx()) {
                    this.mAdWebView.reload();
                } else {
                    this.cP = -2;
                    ay();
                }
            }
        } catch (Throwable unused) {
            a("0", 0, 2);
        }
        this.fI = n.mOriginJString;
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

    private void g(AdTemplate adTemplate) {
        if (this.fW) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.fW = true;
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$11, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass11 extends com.kwad.components.core.webview.c {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aEY = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.f(m.this.mAdTemplate.loadType));
            m.this.fC = new ba();
            aVar.a(m.this.fC);
            aVar.a(new ao(m.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (m.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bb(m.this.mAdInfo) || m.this.eW) {
                            m mVar = m.this;
                            mVar.fR = (ViewGroup.MarginLayoutParams) mVar.eL.getLayoutParams();
                            int ceil = (int) Math.ceil(m.this.fz);
                            int i = m.this.mWidth;
                            if (videoPosition.widthRation == OOXIXo.f3760XO) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            m.this.fR.topMargin = (int) (videoPosition.topMarginRation * ceil);
                            double d = i;
                            m.this.fR.leftMargin = (int) (videoPosition.leftMarginRation * d);
                            m.this.fR.width = (int) (d * videoPosition.widthRation);
                            m.this.fR.height = (int) (m.this.fR.width * videoPosition.heightWidthRation);
                            m.this.eL.setRadius(videoPosition.borderRadius);
                            m.this.eL.setLayoutParams(m.this.fR);
                            m.this.eL.setVisibility(0);
                            if ((m.this.dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) m.this.dU).getVideoSoundValue() != 0) {
                                m mVar2 = m.this;
                                mVar2.mIsAudioEnable = mVar2.dU.isVideoSoundEnable();
                            } else {
                                m mVar3 = m.this;
                                mVar3.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bU(mVar3.mAdInfo);
                            }
                            m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                            m mVar4 = m.this;
                            mVar4.cB = com.kwad.sdk.core.response.b.a.bn(mVar4.mAdInfo);
                            if (!m.this.eW) {
                                m mVar5 = m.this;
                                mVar5.a(mVar5.dU);
                            } else if (m.this.eV != null) {
                                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                                m mVar6 = m.this;
                                iAdLivePlayModule.setAudioEnabled(mVar6.g(mVar6.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ab(bVar, new ab.a() { // from class: com.kwad.components.ad.feed.b.m.11.2
                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void bA() {
                    m.this.fS.post(new az() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            m.this.tO();
                        }
                    });
                }
            }));
            aVar.a(new ay(new ay.a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    m.d(m.this, true);
                    m.this.bu();
                }
            }));
            m.this.fU = new ar();
            aVar.a(m.this.fU);
            if (m.this.eW) {
                aVar.a(new com.kwad.components.core.webview.jshandler.e(1, 1));
                m.this.fF = new WebCardRegisterLiveShopListener();
                m.this.fE = new WebCardRegisterLiveMessageListener();
                aVar.a(m.this.fF);
                aVar.a(m.this.fE);
                aVar.a(new ax(m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i, String str) {
            m.this.a("1", 2, 5);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.feed.b.m.11.4
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (m.this.abY != null && !m.this.fL) {
                        m.this.abY.onAdShow();
                        com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cI(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            m.this.fD = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aj.a aVar) {
            if (m.this.fL) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.fz == OOXIXo.f3760XO) {
                m.this.fz = aVar.height;
                m.this.fy.setRatio((float) r0);
                m.fG.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ac.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            String str;
            m.this.bw();
            int i = aVar.Yn;
            if (aVar.KS) {
                i = aVar.Yl ? 1 : 2;
            }
            boolean bb = com.kwad.sdk.core.response.b.a.bb(m.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.Yo;
            if (cVar != null && !TextUtils.isEmpty(cVar.Lh)) {
                str = aVar.Yo.Lh;
            } else {
                str = "";
            }
            com.kwad.components.core.e.d.a.a(new a.C0788a(m.this.getContext()).ar(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).an(i).am(aVar.kl).ah(str).al(5).au(aVar.KS).as(bb).v(m.this.eV == null ? 0L : m.this.eV.getPlayDuration()).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (m.this.abY != null) {
                        m.this.abY.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            if (m.this.fH) {
                return;
            }
            m.this.cP = aVar.status;
            if (m.this.cP == 1) {
                m.this.fS.removeCallbacksAndMessages(null);
                if (m.this.fM != null) {
                    m.this.fM.setVisibility(8);
                }
                m.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.o.a.qI().av(m.this.mAdTemplate);
                if (m.this.fQ != null) {
                    m.this.fQ.c(2, "");
                    return;
                }
                return;
            }
            m.this.a("3", 3, 4);
        }
    }

    public static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(m mVar, boolean z) {
        mVar.eQ = false;
        return false;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fN = motionEvent.getX();
        this.fO = motionEvent.getY();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate)) {
            if (view == this.eL || view == this.fB) {
                a(this.eN, 153);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        int i3;
        com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError " + str);
        this.fS.removeCallbacksAndMessages(null);
        if (this.fH) {
            return;
        }
        this.fH = true;
        if (this.mAdWebView != null) {
            R r = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.b.b.cI(r), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i);
        }
        com.kwad.components.core.o.a qI = com.kwad.components.core.o.a.qI();
        AdTemplate adTemplate = this.mAdTemplate;
        qI.b(adTemplate, com.kwad.sdk.core.response.b.b.cI(adTemplate), str);
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i3 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.a(i3, com.kwad.sdk.core.response.b.a.bd(this.mAdInfo), this.mAdTemplate, i2);
        a aVar = this.fQ;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fQ = null;
        if (this.fM == null) {
            this.fL = true;
            com.kwad.components.core.widget.b.c(this);
            int bd = com.kwad.sdk.core.response.b.a.bd(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eV.onDestroy();
                this.eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eT = null;
            }
            com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), bd);
            this.fM = a2;
            if (a2 != null) {
                this.fM.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.fy.removeAllViews();
                this.fy.setRatio(OOXIXo.f3760XO);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eL.setVisibility(8);
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.fy.addView(this.fM);
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.KS) {
            return aVar.Yl;
        }
        return aVar.Yn == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.m.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view == this.eL) {
            if (this.eN.isIdle()) {
                com.kwad.sdk.utils.l.em(this.mAdTemplate);
                this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate));
                this.eN.start();
                return;
            }
            a(this.eN, 100);
            return;
        }
        if (view == this.fB) {
            a(this.eN, 25);
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            FeedType.fromInt(this.mAdTemplate.type);
            bw();
            com.kwad.components.core.e.d.a.a(new a.C0788a(getContext()).ar(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).as(com.kwad.sdk.core.response.b.a.bb(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.aL(i);
                }
            }));
        }
    }
}
