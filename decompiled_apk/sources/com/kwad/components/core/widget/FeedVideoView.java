package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private com.kwad.components.core.video.e QQ;
    private NestedScrollingChildHelper Qy;
    private TextView acA;
    private ViewGroup acB;
    private ViewGroup acC;
    private int acD;
    private boolean acE;
    private boolean acF;
    private long acG;
    private boolean acH;
    private KsAdVideoPlayConfig acI;
    private a acJ;
    private View acK;
    private boolean acL;
    private Runnable acM;
    private o acN;
    private RatioFrameLayout acn;
    private TextView aco;
    private TextView acp;
    private TextView acq;
    private View acr;
    private KSCornerImageView acs;
    private TextView act;
    private ScaleAnimSeekBar acu;
    private ImageView acv;
    private ImageView acw;
    private ImageView acx;
    private ViewGroup acy;
    private ViewGroup acz;
    private View.OnClickListener bU;
    private List<Integer> cB;
    private KsAppDownloadListener cx;
    private TextView eB;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: classes11.dex */
    public interface a {
        void pP();

        void pQ();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.acD = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.acy.setVisibility(8);
                FeedVideoView.this.acx.setVisibility(8);
                if (FeedVideoView.this.QQ != null) {
                    FeedVideoView.this.QQ.aO(true);
                }
            }
        };
        this.acM = runnable;
        this.acN = new o(runnable);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.aD(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.ca(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.aD(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.ab(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.dn(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.acq.setText(com.kwad.sdk.core.response.b.a.dm(i));
                }
            };
        }
        return this.cx;
    }

    private boolean tR() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.acG;
        if (j > 888) {
            this.acG = elapsedRealtime;
        }
        if (j > 888) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS() {
        boolean z;
        boolean z2;
        a aVar = this.acJ;
        if (aVar != null) {
            aVar.pP();
        }
        if (this.acD == 100) {
            z = true;
        } else {
            z = false;
        }
        if (z & tR()) {
            this.acz.setVisibility(0);
            this.acA.setText(this.mAdInfo.adBaseInfo.adDescription);
            if (com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.acE = aj.cy(getContext());
            getContext();
            this.acF = aj.ML();
            if (!z2) {
                aj.cA(getContext());
            } else {
                aj.cB(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.acB.getParent();
            this.acC = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.acB);
                View view = new View(this.acB.getContext());
                this.acK = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.acB.getWidth(), this.acB.getHeight()));
                viewGroup.addView(this.acK);
            }
            aj.b(getContext(), false);
            Activity dB = l.dB(getContext());
            if (dB != null) {
                ViewGroup viewGroup2 = (ViewGroup) dB.getWindow().getDecorView();
                this.acB.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z2 && viewGroup2.getWidth() != 0) {
                    this.acn.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.acB, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tT() {
        boolean z;
        if (this.acD == 101) {
            z = true;
        } else {
            z = false;
        }
        if (z & tR()) {
            this.acz.setVisibility(8);
            if (this.acE) {
                aj.cy(getContext());
            } else {
                aj.cz(getContext());
            }
            if (this.acF) {
                aj.cB(getContext());
            } else {
                aj.cA(getContext());
            }
            aj.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.acB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.acB);
            }
            this.acB.setLayoutParams(new ViewGroup.LayoutParams(this.acC.getWidth(), this.acC.getHeight()));
            this.acn.setRatio(0.5600000023841858d);
            View view = this.acK;
            if (view != null) {
                this.acC.removeView(view);
                this.acK = null;
            }
            this.acC.addView(this.acB, new FrameLayout.LayoutParams(-1, -2));
            this.acB.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.acJ;
        if (aVar != null) {
            aVar.pQ();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view) {
        super.A(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && !aVar.isPlaying()) {
            qA();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.acN);
                getHandler().postDelayed(this.acN, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        if (this.eN != null) {
            rT();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.acN);
                getHandler().postDelayed(this.acN, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.Qy = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.acn = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eB = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.acu = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.acu.setMinProgress(0);
        this.acq = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.acr = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.act = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.acs = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.aco = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.acp = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.acv = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.acx = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.acw = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.acy = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.acB = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.acz = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.acA = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Qy.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Qy.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Qy.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Qy.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.Qy.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.Qy.isNestedScrollingEnabled();
    }

    public final void qA() {
        this.QQ.sp();
        this.QQ.setVisibility(0);
        this.QQ.setAlpha(1.0f);
        this.acv.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.acx.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void qw() {
        this.QQ.sm();
    }

    public final void rT() {
        this.QQ.so();
        this.acx.setVisibility(0);
        this.acx.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.acv.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.QQ;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.Qy.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.bU = onClickListener;
    }

    public void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.acw.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.acw.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.acD = i;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.acJ = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.Qy.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.Qy.stopNestedScroll();
    }

    public final boolean tU() {
        if (this.acD == 101) {
            tT();
            return true;
        }
        return false;
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

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.acL = true;
        return true;
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((FeedVideoView) adResultData);
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.acL = false;
        com.kwad.sdk.core.response.model.b bs = com.kwad.sdk.core.response.b.a.bs(this.mAdInfo);
        this.acI = ksAdVideoPlayConfig;
        String url = bs.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        this.cB = com.kwad.sdk.core.response.b.a.bn(this.mAdInfo);
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        this.eN = AdVideoPlayerViewCache.getInstance().eG(K);
        if (com.kwad.sdk.core.response.b.a.ap(this.mAdInfo)) {
            this.eB.setVisibility(8);
            View view = this.acr;
            if (view != null) {
                view.setVisibility(0);
                this.acq.setText(com.kwad.sdk.core.response.b.a.aD(this.mAdInfo));
                this.act.setText(com.kwad.sdk.core.response.b.a.cd(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.acs, com.kwad.sdk.core.response.b.a.cg(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.acq.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.bU != null) {
                            FeedVideoView.this.bU.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.acr;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.eB.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.aa(this.mAdInfo);
            this.eN.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).da(com.kwad.sdk.core.response.b.e.dU(this.mAdTemplate)).db(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dT(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).BJ(), null);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
            this.QQ = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.QQ);
            this.QQ.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.Cd() == 2) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cB = (List) this.eN.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.eN.getController();
            this.QQ = eVar2;
            eVar2.setAutoRelease(false);
            this.QQ.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            this.QQ.sm();
        }
        if (this.acn.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.acn;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.acn.setTag(null);
        }
        this.acn.addView(this.eN);
        this.acn.setTag(this.eN);
        this.acy.setVisibility(8);
        this.acx.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.eB.setVisibility(8);
        } else {
            this.eB.setVisibility(0);
            this.eB.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.QQ, this.eN);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acD = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.acy.setVisibility(8);
                FeedVideoView.this.acx.setVisibility(8);
                if (FeedVideoView.this.QQ != null) {
                    FeedVideoView.this.QQ.aO(true);
                }
            }
        };
        this.acM = runnable;
        this.acN = new o(runnable);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acD = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.acy.setVisibility(8);
                FeedVideoView.this.acx.setVisibility(8);
                if (FeedVideoView.this.QQ != null) {
                    FeedVideoView.this.QQ.aO(true);
                }
            }
        };
        this.acM = runnable;
        this.acN = new o(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.acB.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.acy.getVisibility() == 8) {
                    if (!FeedVideoView.this.eN.isCompleted()) {
                        FeedVideoView.this.acy.setVisibility(0);
                        FeedVideoView.this.acx.setVisibility(0);
                        if (FeedVideoView.this.QQ != null) {
                            FeedVideoView.this.QQ.aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acM);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.acD == 101) {
                        FeedVideoView.this.acy.setVisibility(0);
                        FeedVideoView.this.acx.setVisibility(8);
                        if (FeedVideoView.this.QQ != null) {
                            FeedVideoView.this.QQ.aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acM);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.bU != null) {
                        FeedVideoView.this.bU.onClick(view);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acM);
                    if (!FeedVideoView.this.acH) {
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 1000L);
                    }
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            private boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!FeedVideoView.this.acL) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo));
                    }
                }
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.qI().b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.adlog.c.bN(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.acy.setVisibility(8);
                FeedVideoView.this.acx.setVisibility(8);
                FeedVideoView.this.acu.setProgress(100);
                FeedVideoView.this.acp.setText(bm.ai(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                FeedVideoView.this.c(j);
                float duration = (((float) j) * 100.0f) / ((float) aVar2.getDuration());
                if (!FeedVideoView.this.acH) {
                    FeedVideoView.this.acu.setProgress((int) duration);
                    FeedVideoView.this.acp.setText(bm.ai(j));
                }
                FeedVideoView.this.aco.setText(bm.ai(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.acL) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.bM(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aco.setText(bm.ai(aVar2.getDuration()));
            }
        });
        this.QQ.setAdClickListener(new a.InterfaceC0807a() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // com.kwad.components.core.video.a.InterfaceC0807a
            public final void a(int i, ac.a aVar3) {
                int i2 = EMachine.EM_MANIK;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) == 0) {
                                i2 = 108;
                            }
                        } else {
                            if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) != 0) {
                                i2 = 50;
                            } else {
                                i2 = 83;
                            }
                            i3 = 1;
                            z = true;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.am(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0788a(FeedVideoView.this.getContext()).ar(FeedVideoView.this.mAdTemplate).at(true).b(FeedVideoView.this.mApkDownloadHelper).an(i3).ao(z).aq(true).am(i2).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.tN();
                    }
                }));
            }
        });
        this.acu.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.acu.bo(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acN);
                    FeedVideoView.this.acH = true;
                    FeedVideoView.this.acp.setText(bm.ai((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void tV() {
                FeedVideoView.this.acu.bo(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acN);
                FeedVideoView.this.acH = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.acu.bo(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acN);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 5000L);
                }
                FeedVideoView.this.acH = false;
            }
        });
        this.acv.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!aVar2.isPaused() && !aVar2.isIdle()) {
                    if (aVar2.isPlaying()) {
                        FeedVideoView.this.QQ.so();
                        FeedVideoView.this.acx.setVisibility(0);
                        FeedVideoView.this.acx.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                        FeedVideoView.this.acv.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                    }
                } else {
                    FeedVideoView.this.QQ.sp();
                    FeedVideoView.this.acv.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.acx.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acN);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 5000L);
                }
            }
        });
        this.acx.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!FeedVideoView.this.eN.isPaused() && !FeedVideoView.this.eN.isIdle()) {
                    if (FeedVideoView.this.eN.isPlaying()) {
                        FeedVideoView.this.rT();
                    }
                } else {
                    FeedVideoView.this.qA();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acN);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acN, 5000L);
                }
            }
        });
        this.acz.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.tT();
            }
        });
        this.acw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.acD == 100) {
                    FeedVideoView.this.tS();
                } else if (FeedVideoView.this.acD == 101) {
                    FeedVideoView.this.tT();
                }
            }
        });
    }
}
