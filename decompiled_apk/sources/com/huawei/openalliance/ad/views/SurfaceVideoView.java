package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class SurfaceVideoView extends BaseGlVideoView {
    private final int q;
    private SurfaceHolder.Callback r;

    public SurfaceVideoView(Context context) {
        super(context);
        this.q = hashCode();
        this.r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                SurfaceVideoView.this.V(i2, i3);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                fb.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }

    private void V(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_surfaceview_video, this);
        ((SurfaceView) findViewById(R.id.hiad_id_video_surface_view)).getHolder().addCallback(this.r);
    }

    @Override // com.huawei.openalliance.ad.views.BaseGlVideoView
    public String getLogTag() {
        return "SurfaceVideoView" + this.q;
    }

    public SurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = hashCode();
        this.r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                SurfaceVideoView.this.V(i2, i3);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                fb.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }

    public SurfaceVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = hashCode();
        this.r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i22, int i3) {
                SurfaceVideoView.this.V(i22, i3);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                fb.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }
}
