package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b UY;
    private b UZ;
    private SurfaceTexture Va;
    public Surface Vb;
    private a Vc;
    private PhotoInfo.VideoInfo Vd;
    private final RectF Ve;
    private int Vf;
    private int Vg;

    @NonNull
    private final d Vh;
    private Matrix mMatrix;

    /* loaded from: classes11.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Ve = new RectF();
        this.Vf = 0;
        this.Vg = 0;
        this.Vh = new d();
        A(context);
    }

    private void A(Context context) {
        this.mMatrix = new Matrix();
        this.UY = new com.kwad.components.core.page.widget.b(context);
        addView(this.UY, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        sd();
    }

    private void sd() {
        this.UY.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.Va != surfaceTexture) {
                    DetailVideoView.this.Va = surfaceTexture;
                    DetailVideoView.this.se();
                    DetailVideoView.this.Vb = new Surface(surfaceTexture);
                    if (DetailVideoView.this.UZ != null) {
                        DetailVideoView.this.UZ.setSurface(DetailVideoView.this.Vb);
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se() {
        Surface surface = this.Vb;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            this.Vb = null;
        }
    }

    public final void adaptVideoSize(int i, int i2) {
        c cVar;
        if (this.UY == null) {
            com.kwad.sdk.core.e.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Vg = i2;
        this.Vf = i;
        if (this.Vh.sf()) {
            int sg = this.Vh.sg();
            if (sg != 1) {
                if (sg != 2) {
                    cVar = null;
                } else {
                    cVar = new VideoAdapters.b();
                }
            } else {
                cVar = new VideoAdapters.c();
            }
            if (cVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.UY;
                cVar.a(bVar, (View) bVar.getParent(), i, i2);
                return;
            }
            return;
        }
        if (this.Vh.sl()) {
            com.kwad.sdk.c.a.a.D(this.UY);
            return;
        }
        if (this.Vh.sh()) {
            com.kwad.sdk.c.a.a.e(this.UY, i, i2);
            return;
        }
        if (this.Vh.sj()) {
            com.kwad.sdk.c.a.a.f(this.UY, i, i2);
            return;
        }
        if (this.Vh.si()) {
            com.kwad.sdk.c.a.a.d(this.UY, i, i2);
            return;
        }
        if (this.Vh.sk()) {
            a(this.UY, i, i2);
            return;
        }
        View view = (View) this.UY.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width != 0 && height != 0) {
            PhotoInfo.VideoInfo videoInfo = this.Vd;
            if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.UY.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.UY.setTransform(this.mMatrix);
                this.UY.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.UY.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
                this.mMatrix.reset();
                this.UY.setTransform(this.mMatrix);
                this.UY.setLayoutParams(layoutParams2);
            }
            this.Ve.set(this.UY.getLeft(), this.UY.getTop(), this.UY.getRight(), this.UY.getBottom());
        }
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.Vh.aR(z);
    }

    public final void g(boolean z, int i) {
        this.Vh.setAd(true);
        this.Vh.aN(i);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.UY;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return 17;
        }
        return ((FrameLayout.LayoutParams) layoutParams).gravity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.UY) {
            a aVar = this.Vc;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Vc;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        se();
        SurfaceTexture surfaceTexture = this.Va;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Va = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.Vf;
        if (i6 > 0 && (i5 = this.Vg) > 0) {
            adaptVideoSize(i6, i5);
        }
    }

    @Deprecated
    public void setAd(boolean z) {
        this.Vh.setAd(z);
    }

    public void setClickListener(a aVar) {
        this.Vc = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.Vh.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.Vh.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.Vh.setHorizontalVideo(z);
    }

    public void setMediaPlayer(b bVar) {
        this.UZ = bVar;
        Surface surface = this.Vb;
        if (surface != null && bVar != null) {
            bVar.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        com.kwad.components.core.widget.h.b(this, f);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Vd = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.UY;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.UY.requestLayout();
        }
    }

    private void a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f = ((float) j) / ((float) j2);
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.UY.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ve = new RectF();
        this.Vf = 0;
        this.Vg = 0;
        this.Vh = new d();
        A(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean V = com.kwad.sdk.core.response.b.a.V(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (V) {
                    int i2 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }
}
