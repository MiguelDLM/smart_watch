package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public final class a {
    private ImageView Jn;

    @Nullable
    private WindowManager QM;
    private com.kwad.components.core.page.splitLandingPage.a.a QN;
    private FrameLayout QO;
    private FrameLayout QP;
    private e QQ;
    private final WindowManager.LayoutParams QR = new WindowManager.LayoutParams();
    private InterfaceC0802a QS;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private Context mContext;
    private ViewGroup yH;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0802a {
        boolean qx();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = l.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.QN = aVar;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
        this.QM = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.yH = viewGroup;
        this.QO = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.QP = (FrameLayout) this.yH.findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) this.yH.findViewById(R.id.ksad_video_first_frame_container);
        this.Jn = (ImageView) this.yH.findViewById(R.id.ksad_split_mini_close_btn);
        this.QO.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float QT = 0.0f;
            float QU = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long QV = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.QR == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.QT = motionEvent.getRawX();
                    this.QU = motionEvent.getRawY();
                    this.left = a.this.QR.x;
                    this.top = a.this.QR.y;
                    this.QV = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.QT + " actionDownX " + this.QT);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.QT;
                        float rawY = motionEvent.getRawY() - this.QU;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.QR.x = (int) (this.left + rawX);
                            a.this.QR.y = (int) (this.top + rawY);
                            if (a.this.QM != null) {
                                try {
                                    a.this.QM.updateViewLayout(a.this.yH, a.this.QR);
                                } catch (Exception e) {
                                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                                    c.printStackTraceOnly(e);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.QT;
                        float rawY2 = motionEvent.getRawY() - this.QU;
                        float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.QV);
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.QS != null && a.this.QN != null && com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(a.this.QN.getAdTemplate()))) {
                            a.this.QS.qx();
                        }
                    }
                }
                return true;
            }
        });
    }

    public final Animator aH(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(n.h(this.yH, z), n.h(this.eM, z));
        return animatorSet;
    }

    public final boolean isVisible() {
        if (this.yH.getAlpha() > 0.0f) {
            return true;
        }
        return false;
    }

    public final void qA() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && !aVar.isPlaying()) {
            this.QQ.sp();
        }
    }

    public final void qw() {
        this.QQ.ad();
    }

    public final boolean qz() {
        if (this.QN != null && this.QM != null) {
            b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.QN.getAdTemplate().mIsAudioEnable).build());
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.QN.getAdTemplate());
            int R = com.kwad.sdk.core.response.b.a.R(dS);
            int Q = com.kwad.sdk.core.response.b.a.Q(dS);
            Rect rect = new Rect();
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (R > Q) {
                int i = displayMetrics.widthPixels;
                rect.right = i;
                rect.left = i - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
                int a2 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
                rect.bottom = a2;
                rect.top = a2 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            } else {
                int i2 = displayMetrics.widthPixels;
                rect.right = i2;
                rect.left = i2 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
                int a3 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
                rect.bottom = a3;
                rect.top = a3 - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            }
            rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
            int a4 = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
            rect.right = a4;
            WindowManager.LayoutParams layoutParams = this.QR;
            layoutParams.type = 1003;
            layoutParams.flags = 8;
            layoutParams.gravity = 51;
            layoutParams.format = 1;
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
            int i3 = rect.left;
            layoutParams.x = i3;
            layoutParams.y = rect.top;
            layoutParams.width = (a4 - i3) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
            this.QR.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
            float f = (rect.left * displayMetrics.widthPixels) / ((r0 + r4) - rect.right);
            float f2 = (rect.top * displayMetrics.heightPixels) / ((r0 + r3) - rect.bottom);
            this.yH.setPivotX(f);
            this.yH.setPivotY(f2);
            this.yH.setAlpha(0.0f);
            if (this.QM != null) {
                try {
                    if (this.yH.getWindowToken() == null) {
                        this.QM.addView(this.yH, this.QR);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                    c.printStackTraceOnly(e);
                }
            }
            this.Jn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.qw();
                    a.this.aH(false).start();
                }
            });
            return true;
        }
        return false;
    }

    private void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.QN.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.bs(dS).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, adTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        String K = com.kwad.sdk.core.response.b.a.K(dS);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a eG = AdVideoPlayerViewCache.getInstance().eG(K);
        this.eN = eG;
        if (eG == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.aa(dS);
            this.eN.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).da(com.kwad.sdk.core.response.b.e.dU(adTemplate)).db(h.b(com.kwad.sdk.core.response.b.e.dT(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).BJ(), null);
            this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.eN, ksAdVideoPlayConfig);
            this.QQ = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.QQ);
            this.QQ.setAutoRelease(false);
        } else {
            e eVar2 = (e) eG.getController();
            this.QQ = eVar2;
            eVar2.setAutoRelease(false);
            this.QQ.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
        }
        if (this.QP.getTag() != null) {
            FrameLayout frameLayout = this.QP;
            frameLayout.removeView((View) frameLayout.getTag());
            this.QP.setTag(null);
        }
        this.QP.addView(this.eN);
        this.QP.setTag(this.eN);
        this.QQ.setAlpha(0.01f);
        this.QQ.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                a.this.qw();
                a.this.aH(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }
        });
    }

    public final void a(InterfaceC0802a interfaceC0802a) {
        this.QS = interfaceC0802a;
    }
}
