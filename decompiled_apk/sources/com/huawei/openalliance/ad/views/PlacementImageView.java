package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ig;
import com.huawei.hms.ads.it;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.p;

/* loaded from: classes10.dex */
public class PlacementImageView extends PlacementMediaView implements kn {
    private ImageView D;
    private p L;

    /* renamed from: a, reason: collision with root package name */
    private it f17430a;
    private com.huawei.openalliance.ad.media.listener.f b;

    public PlacementImageView(Context context) {
        super(context);
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        com.huawei.openalliance.ad.media.listener.f fVar = this.b;
        if (fVar != null) {
            fVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code() {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        com.huawei.openalliance.ad.media.listener.f fVar = this.b;
        if (fVar != null) {
            fVar.Code();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.kw
    public void destroyView() {
        this.D.setImageDrawable(null);
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.b getMediaState() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        super.setPlacementAd(hVar);
        fb.Code("PlacementImageView", "setPlacementAd");
        n nVar = this.Code;
        if (nVar != null) {
            p S = nVar.S();
            this.L = S;
            if (S.V()) {
                return;
            }
            this.f17430a.Code(this.Code);
            ((PlacementMediaView) this).V = this.L.e();
        }
    }

    public PlacementImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i) {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.b = null;
    }

    public PlacementImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.f17430a = new ig(getContext(), this);
        this.D = new ImageView(context);
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
        this.D.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.huawei.hms.ads.kn
    public void Code(p pVar, Drawable drawable) {
        ((PlacementMediaView) this).B = true;
        if (pVar == null || drawable == null) {
            ((PlacementMediaView) this).C = false;
        } else if (this.L != null && TextUtils.equals(pVar.Z(), this.L.Z())) {
            ((PlacementMediaView) this).C = true;
            this.D.setImageDrawable(drawable);
        }
        if (((PlacementMediaView) this).S) {
            Code(true, true);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.b = fVar;
    }
}
