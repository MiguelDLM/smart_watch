package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.camera.CameraManager;

/* loaded from: classes7.dex */
public class ng extends di {
    private int Hl = 1280;
    private int Hm = CameraManager.DEFAULTHEIGHT;
    private mp Hn;
    private long Ho;

    public ng(Context context, int i, int i2) {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(i);
        this.oW.setOutputHeight(i2);
        if (this.Hn == null) {
            Object cq = kr.cq("com.baidu.ar.maprecord.NavigationRecoderController");
            if (cq instanceof mp) {
                mp mpVar = (mp) cq;
                this.Hn = mpVar;
                mpVar.a(context, i, i2);
            }
        }
    }

    public void D(float[] fArr) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.x(fArr);
        }
    }

    public void E(float[] fArr) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.y(fArr);
        }
    }

    @Override // com.baidu.ar.di
    public boolean a(FramePixels framePixels) {
        mp mpVar = this.Hn;
        if (mpVar == null) {
            return false;
        }
        this.Ho++;
        mpVar.s(framePixels.getPixelData());
        return false;
    }

    public void cA(String str) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.cy(str);
        }
    }

    @Override // com.baidu.ar.di
    public void cB() {
    }

    @Override // com.baidu.ar.di
    public void cC() {
    }

    public void d(float[] fArr, int i) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.c(fArr, i);
        }
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return "NavigationRecoderDetector";
    }

    public void pause() {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.stopRecord();
            this.Hn = null;
        }
    }

    public void updateHeading(float f, float f2) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.b(f, f2);
        }
    }

    public void updateLocation(float[] fArr, int i, boolean z) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.a(fArr, i, z);
        }
    }

    public void updateMeters(float f) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.h(f);
        }
    }

    public void z(float[] fArr) {
        mp mpVar = this.Hn;
        if (mpVar != null) {
            mpVar.z(fArr);
        }
    }
}
