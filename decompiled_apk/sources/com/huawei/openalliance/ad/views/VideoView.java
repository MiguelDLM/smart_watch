package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.views.BaseVideoView;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class VideoView extends BaseVideoView {
    private static final String Code = "VideoView";

    public VideoView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        super.B();
        Surface surface = this.g;
        if (surface != null) {
            surface.release();
        }
        this.g = null;
        this.h = null;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_view_video, this);
        TextureView textureView = (TextureView) findViewById(R.id.hiad_id_video_texture_view);
        this.b = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    public Bitmap getSurfaceBitmap() {
        return this.b.getBitmap();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        S();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        fb.V(Code, "onSurfaceTextureAvailable width: %d height: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.d = true;
        Surface surface = this.g;
        if (surface == null || this.h != surfaceTexture) {
            if (surface != null) {
                fb.V(Code, "release old surface when onSurfaceTextureAvailable");
                this.g.release();
            }
            if (this.h != null) {
                fb.V(Code, "release old SurfaceTexture when onSurfaceTextureAvailable");
                this.h.release();
            }
            Surface surface2 = new Surface(surfaceTexture);
            this.g = surface2;
            this.e.Code(surface2);
            this.h = surfaceTexture;
        }
        if (this.l == null) {
            BaseVideoView.i iVar = new BaseVideoView.i(this.o);
            this.l = iVar;
            this.e.Code(iVar);
        }
        if (this.c) {
            Code(this.i);
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        fb.V(Code, "onSurfaceTextureDestroyed");
        this.d = false;
        if (this.k) {
            L();
        }
        d();
        if (this.g != null) {
            fb.V(Code, "release old surface when onSurfaceTextureDestroyed");
            this.g.release();
            this.g = null;
        }
        if (this.h == null) {
            return true;
        }
        fb.V(Code, "release old surfaceTexture when onSurfaceTextureDestroyed");
        this.h.release();
        this.h = null;
        return true;
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
