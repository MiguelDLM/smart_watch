package com.huawei.hms.ads.instreamad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.MediaMuteListener;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.kp;
import com.huawei.hms.ads.x;
import com.huawei.openalliance.ad.inter.data.h;
import com.huawei.openalliance.ad.media.listener.f;
import com.huawei.openalliance.ad.views.PPSPlacementView;
import java.util.ArrayList;
import java.util.List;

@GlobalApi
/* loaded from: classes10.dex */
public class InstreamView extends PPSPlacementView implements IInstreamView {
    private View C;
    private InstreamMediaChangeListener D;
    private f F;
    private InstreamMediaStateListener L;
    private OnInstreamAdClickListener S;

    /* renamed from: a, reason: collision with root package name */
    private MediaMuteListener f17305a;

    @GlobalApi
    /* loaded from: classes10.dex */
    public interface OnInstreamAdClickListener {
        void onClick();
    }

    /* loaded from: classes10.dex */
    public class a implements f {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.media.listener.f
        public void Code() {
            if (InstreamView.this.f17305a != null) {
                InstreamView.this.f17305a.onMute();
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.f
        public void V() {
            if (InstreamView.this.f17305a != null) {
                InstreamView.this.f17305a.onUnmute();
            }
        }
    }

    @GlobalApi
    public InstreamView(Context context) {
        super(context);
        this.D = null;
        this.L = null;
        this.f17305a = null;
        Code(context);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void destroy() {
        super.destroyView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public View getCallToActionView() {
        return this.C;
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    @GlobalApi
    public void hideAdvertiserInfoDialog() {
        super.hideAdvertiserInfoDialog();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    @GlobalApi
    public void hideTransparencyDialog() {
        super.hideTransparencyDialog();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public boolean isPlaying() {
        return super.isPlaying();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void mute() {
        super.C();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void onClose() {
        super.Code((Integer) 3);
        super.onClose();
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void pause() {
        super.pauseView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void play() {
        super.resumeView();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void registerOverlays(List<View> list) {
        setOverlays(list);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeInstreamMediaChangeListener() {
        this.D = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeInstreamMediaStateListener() {
        this.L = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void removeMediaMuteListener() {
        V(this.F);
        this.F = null;
        this.f17305a = null;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setCallToActionView(View view) {
        this.C = view;
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        V(arrayList);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamAds(List<InstreamAd> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (InstreamAd instreamAd : list) {
            if (instreamAd instanceof x) {
                arrayList.add(((x) instreamAd).Code());
            }
        }
        Code(arrayList);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamMediaChangeListener(InstreamMediaChangeListener instreamMediaChangeListener) {
        this.D = instreamMediaChangeListener;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setInstreamMediaStateListener(InstreamMediaStateListener instreamMediaStateListener) {
        this.L = instreamMediaStateListener;
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setMediaMuteListener(MediaMuteListener mediaMuteListener) {
        this.f17305a = mediaMuteListener;
        f fVar = this.F;
        if (fVar == null) {
            fVar = new a();
            this.F = fVar;
        }
        Code(fVar);
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void setOnInstreamAdClickListener(OnInstreamAdClickListener onInstreamAdClickListener) {
        this.S = onInstreamAdClickListener;
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    @GlobalApi
    public void showAdvertiserInfoDialog(View view, boolean z) {
        super.showAdvertiserInfoDialog(view, z);
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    @GlobalApi
    public void showTransparencyDialog(View view) {
        super.showTransparencyDialog(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView, com.huawei.hms.ads.instreamad.IInstreamView
    public void stop() {
        super.stop();
    }

    @Override // com.huawei.hms.ads.instreamad.IInstreamView
    public void unmute() {
        super.S();
    }

    @GlobalApi
    public InstreamView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = null;
        this.L = null;
        this.f17305a = null;
        Code(context);
    }

    private void Code(final Context context) {
        setGravity(17);
        Code(new kp() { // from class: com.huawei.hms.ads.instreamad.InstreamView.1
            @Override // com.huawei.hms.ads.kp
            public void Code(int i) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaStart(i);
                }
            }

            @Override // com.huawei.hms.ads.kp
            public void I(int i) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaStop(i);
                }
            }

            @Override // com.huawei.hms.ads.kp
            public void V(int i) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaPause(i);
                }
            }

            @Override // com.huawei.hms.ads.kp
            public void Z(int i) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaCompletion(i);
                }
            }

            @Override // com.huawei.hms.ads.kp
            public void Code(int i, int i2) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaProgress(i, i2);
                }
            }

            @Override // com.huawei.hms.ads.kp
            public void Code(int i, int i2, int i3) {
                if (InstreamView.this.L != null) {
                    InstreamView.this.L.onMediaError(i, i2, i3);
                }
            }
        });
        Code(new ko() { // from class: com.huawei.hms.ads.instreamad.InstreamView.2
            @Override // com.huawei.hms.ads.ko
            public void Code(h hVar) {
                if (InstreamView.this.D != null) {
                    InstreamView.this.D.onSegmentMediaChange(new x(context, hVar));
                }
            }
        });
        setOnPlacementAdClickListener(new PPSPlacementView.a() { // from class: com.huawei.hms.ads.instreamad.InstreamView.3
            @Override // com.huawei.openalliance.ad.views.PPSPlacementView.a
            public void Code() {
                if (InstreamView.this.S != null) {
                    InstreamView.this.S.onClick();
                }
            }
        });
        a aVar = new a();
        this.F = aVar;
        Code(aVar);
    }

    @Override // com.huawei.openalliance.ad.views.PPSPlacementView
    @GlobalApi
    public void showTransparencyDialog(View view, int[] iArr) {
        super.showTransparencyDialog(view, iArr);
    }

    @GlobalApi
    public InstreamView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = null;
        this.L = null;
        this.f17305a = null;
        Code(context);
    }
}
