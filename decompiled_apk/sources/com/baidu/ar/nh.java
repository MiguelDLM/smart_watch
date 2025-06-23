package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.marker.IMarkerLocationTimeCallBack;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.MarkerFrameInfo;
import com.baidu.ar.marker.OnTrackerSessionCallback;
import com.baidu.ar.marker.TrackerType;
import com.baidu.ar.vps.marker.VisualManager;

/* loaded from: classes7.dex */
public class nh extends di {
    private VisualManager Hp;
    private float[] Hq = new float[16];
    private float[] Hr = null;
    private long Hs;
    private int mInputHeight;
    private int mInputWidth;

    public nh(Context context, int i, int i2, IMarkerStateListener iMarkerStateListener, nb nbVar) {
        if (ARConfig.isQAMockOpen) {
            this.mInputHeight = kt.Dv;
            this.mInputWidth = kt.Du;
        } else {
            this.mInputWidth = i;
            this.mInputHeight = i2;
        }
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(i);
        this.oW.setOutputHeight(i2);
        VisualManager visualManager = new VisualManager(context, i, i2, 1);
        this.Hp = visualManager;
        visualManager.setMarkerStateListener(iMarkerStateListener);
        this.Hp.setVisualLocatingServiceLocatingListener(nbVar);
    }

    public void a(fx fxVar) {
        VisualManager visualManager = this.Hp;
        if (visualManager != null) {
            visualManager.setiMarkerPositionCallback(fxVar);
        }
    }

    @Override // com.baidu.ar.di
    public void cB() {
    }

    @Override // com.baidu.ar.di
    public void cC() {
        VisualManager visualManager = this.Hp;
        if (visualManager != null) {
            visualManager.setMarkerStateListener(null);
            this.Hp.release();
            this.Hp = null;
        }
    }

    public void d(float[] fArr, float[] fArr2) {
        VisualManager visualManager = this.Hp;
        if (visualManager == null) {
            return;
        }
        this.Hq = fArr;
        if (fArr2 != null) {
            visualManager.updateGrative(fArr2);
        }
    }

    public void e(float f, float f2, float f3) {
        if (this.Hp == null) {
            return;
        }
        this.Hr = new float[]{f, f2, f3};
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return "MarkerDetector";
    }

    public VisualManager iP() {
        return this.Hp;
    }

    public void pause() {
        VisualManager visualManager = this.Hp;
        if (visualManager == null) {
            return;
        }
        visualManager.onPause();
    }

    public void resume() {
        VisualManager visualManager = this.Hp;
        if (visualManager == null) {
            return;
        }
        visualManager.onResume();
    }

    public void a(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack) {
        VisualManager visualManager = this.Hp;
        if (visualManager != null) {
            visualManager.setMarkerLocationTimeCallBack(iMarkerLocationTimeCallBack);
        }
    }

    public void a(MarkerFrameInfo markerFrameInfo) {
        if (this.Hp == null) {
            return;
        }
        this.Hq = markerFrameInfo.getPoseMat();
        this.Hp.setCameraParams(markerFrameInfo.getIntrinsics(), markerFrameInfo.getDistort(), markerFrameInfo.getTrackingState(), markerFrameInfo.getMagnet());
    }

    public void a(OnTrackerSessionCallback onTrackerSessionCallback) {
        VisualManager visualManager = this.Hp;
        if (visualManager != null) {
            visualManager.setTrackerSessionCallback(onTrackerSessionCallback);
        }
    }

    public void a(TrackerType trackerType) {
        VisualManager visualManager = this.Hp;
        if (visualManager != null) {
            visualManager.loadMarkerSO(trackerType);
        }
    }

    @Override // com.baidu.ar.di
    public boolean a(FramePixels framePixels) {
        VisualManager visualManager = this.Hp;
        if (visualManager != null && this.Hq != null) {
            this.Hs++;
            visualManager.setYUVFile(framePixels.getPixelData(), this.mInputWidth, this.mInputHeight, this.Hq, this.Hr);
        }
        return false;
    }
}
