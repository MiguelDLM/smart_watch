package com.huawei.hms.ads.nativead;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.by;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.jp;
import com.huawei.hms.ads.kc;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GlobalApi
/* loaded from: classes10.dex */
public class NativeView extends PPSNativeView implements INativeView {
    private ChoicesView B;
    private View C;
    private View D;
    private View F;
    private final Map<String, View> I;
    private View L;
    private View S;

    /* renamed from: a, reason: collision with root package name */
    private View f17322a;
    private MediaView b;
    private View c;
    private View d;
    private View e;
    private by f;
    private MaterialClickInfo.a g;

    @GlobalApi
    public NativeView(Context context) {
        super(context);
        this.I = new HashMap();
        this.g = new MaterialClickInfo.a();
    }

    private void a() {
        if (this.f != null) {
            this.g.V(jp.Code(this));
            this.g.I(x.dd);
            this.g.Code(Float.valueOf(d.a(getContext())));
            fb.Code("NativeView", "fastAppClickInfo is %s ", this.g.Code().toString());
            this.f.Code().Code(this.g.Code());
        }
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void destroy() {
        this.I.clear();
        by byVar = this.f;
        if (byVar != null) {
            byVar.destroy();
        }
        MediaView mediaView = this.b;
        if (mediaView != null) {
            mediaView.Code();
        }
        super.B();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getAdSourceView() {
        return this.I.get("5");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getCallToActionView() {
        return this.I.get("2");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public ChoicesView getChoicesView() {
        View view = this.I.get("11");
        if (view instanceof ChoicesView) {
            return (ChoicesView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getDescriptionView() {
        return this.I.get("4");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getIconView() {
        return this.I.get("3");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getImageView() {
        return this.I.get("8");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getMarketView() {
        return this.I.get("6");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public MediaView getMediaView() {
        View view = this.I.get("10");
        if (view instanceof MediaView) {
            return (MediaView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getPriceView() {
        return this.I.get("7");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getRatingView() {
        return this.I.get("9");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getTitleView() {
        return this.I.get("1");
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void gotoWhyThisAdPage() {
        super.gotoWhyThisAdPage();
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void hideAdvertiserInfoDialog() {
        super.hideAdvertiserInfoDialog();
    }

    @GlobalApi
    public void listenClickButtonInfo(MotionEvent motionEvent, String str) {
        Context context = getContext();
        if (context == null || !w.V(context, context.getPackageName())) {
            fb.Code("NativeView", "context is null or the app is not trust app");
            return;
        }
        if (motionEvent == null || !ClickAreaSource.ADBUTTON.equals(str)) {
            return;
        }
        int Code = jo.Code(motionEvent);
        if (Code == 0) {
            Rect V = jp.V(this);
            if (V != null) {
                this.g.Code(Integer.valueOf(((int) motionEvent.getRawX()) - V.left));
                this.g.V(Integer.valueOf(((int) motionEvent.getRawY()) - V.top));
            }
            this.g.V(Long.valueOf(w.Code(motionEvent.getEventTime())));
        }
        if (1 == Code) {
            Rect V2 = jp.V(this);
            if (V2 != null) {
                this.g.Z(Integer.valueOf(((int) motionEvent.getRawX()) - V2.left));
                this.g.B(Integer.valueOf(((int) motionEvent.getRawY()) - V2.top));
            }
            this.g.Code(Long.valueOf(w.Code(motionEvent.getEventTime())));
            a();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView, com.huawei.hms.ads.nativead.INativeView
    @GlobalApi
    public void onViewUpdate() {
        super.onViewUpdate();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public boolean register(AppDownloadButton appDownloadButton) {
        return super.Code((kc) appDownloadButton);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setAdSourceView(View view) {
        this.C = view;
        this.I.put("5", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setCallToActionView(View view) {
        this.F = view;
        this.I.put("2", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setChoicesView(ChoicesView choicesView) {
        this.B = choicesView;
        this.I.put("11", choicesView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setDescriptionView(View view) {
        this.S = view;
        this.I.put("4", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setIconView(View view) {
        this.L = view;
        this.I.put("3", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setImageView(View view) {
        this.f17322a = view;
        this.I.put("8", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMarketView(View view) {
        this.e = view;
        this.I.put("6", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMediaView(MediaView mediaView) {
        this.b = mediaView;
        this.I.put("10", mediaView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setNativeAd(NativeAd nativeAd) {
        View view;
        NativeAdConfiguration aq;
        if (nativeAd instanceof by) {
            by byVar = (by) nativeAd;
            this.f = byVar;
            byVar.Code(this);
            setIsCustomDislikeThisAdEnabled(nativeAd.isCustomDislikeThisAdEnabled());
            MediaView mediaView = this.b;
            if (mediaView != null) {
                b mediaViewAdapter = mediaView.getMediaViewAdapter();
                mediaViewAdapter.Code(nativeAd);
                view = mediaViewAdapter.B();
                VideoOperator videoOperator = this.f.getVideoOperator();
                if (videoOperator instanceof c) {
                    ((c) videoOperator).Code(this.b);
                }
            } else {
                view = null;
            }
            l Code = this.f.Code();
            List<View> arrayList = new ArrayList<>();
            arrayList.add(this);
            View callToActionView = getCallToActionView();
            if (callToActionView != null && callToActionView.isEnabled()) {
                arrayList.add(callToActionView);
            }
            if ((Code instanceof l) && (aq = Code.aq()) != null) {
                setChoiceViewPosition(aq.getChoicesPosition());
            }
            if (view instanceof NativeWindowImageView) {
                Code(Code, arrayList, (NativeWindowImageView) view);
            } else {
                if (!(view instanceof NativeVideoView)) {
                    Code(Code, arrayList);
                    return;
                }
                NativeVideoView nativeVideoView = (NativeVideoView) view;
                arrayList.add(nativeVideoView.getPreviewImageView());
                Code(Code, arrayList, nativeVideoView);
            }
        }
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setPriceView(View view) {
        this.c = view;
        this.I.put("7", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setRatingView(View view) {
        this.d = view;
        this.I.put("9", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setTitleView(View view) {
        this.D = view;
        this.I.put("1", view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void showAdvertiserInfoDialog(View view, boolean z) {
        super.showAdvertiserInfoDialog(view, z);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void showFeedback(View view) {
        super.showFeedback(view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void unregister(AppDownloadButton appDownloadButton) {
        super.V((kc) appDownloadButton);
    }

    @GlobalApi
    public NativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = new HashMap();
        this.g = new MaterialClickInfo.a();
    }

    @GlobalApi
    public NativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = new HashMap();
        this.g = new MaterialClickInfo.a();
    }

    @GlobalApi
    @SuppressLint({"NewApi"})
    public NativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = new HashMap();
        this.g = new MaterialClickInfo.a();
    }
}
