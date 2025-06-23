package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.algo.ARVPASJniClient;
import com.baidu.ar.algo.FrameType;
import com.baidu.ar.algo.JNICCallJava;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class ly implements lx, z {
    private fh DC;
    private x Fa;
    private ARVPASJniClient Fb;
    private String Fc;
    private boolean Fd;
    private a Fe;
    private int height;
    private double[] mGPSInfo;
    private int width;
    private float[] EG = new float[12];
    private float[] nF = {1200.0f, 0.0f, 640.0f, 0.0f, 1200.0f, 360.0f, 0.0f, 0.0f, 1.0f};

    /* loaded from: classes7.dex */
    public interface a {
        void p(byte[] bArr);
    }

    public ly(int i, int i2, v vVar) {
        this.Fa = x.d(i, i2);
        this.width = i;
        this.height = i2;
        JNICCallJava.setGravityCallBack(vVar);
        JNICCallJava.setAlgoGeneraProtobufCallBack(new u() { // from class: com.baidu.ar.ly.1
            @Override // com.baidu.ar.u
            public void a(byte[] bArr) {
                if (ly.this.Fe != null) {
                    ly.this.Fe.p(bArr);
                }
            }
        });
        JNICCallJava.setVPASsParamsTransCallback(this);
    }

    public boolean addTrackingVPS(String str) {
        try {
            ARVPASJniClient aRVPASJniClient = this.Fb;
            if (aRVPASJniClient == null) {
                return false;
            }
            return aRVPASJniClient.addTrackingVPS(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.ar.z
    public String ay() {
        return this.Fc;
    }

    @Override // com.baidu.ar.z
    public double[] az() {
        double[] dArr = this.mGPSInfo;
        return dArr != null ? dArr : new double[]{40.019802d, 116.318888d};
    }

    public void hV() {
        this.Fd = true;
    }

    /* renamed from: if, reason: not valid java name */
    public void m49if() {
        this.Fd = false;
    }

    @Override // com.baidu.ar.lx
    public void init() {
        this.Fb = new ARVPASJniClient();
    }

    public void r(byte[] bArr) {
        ARVPASJniClient aRVPASJniClient = this.Fb;
        if (aRVPASJniClient != null) {
            aRVPASJniClient.reciveProtobufBuffer(bArr);
        }
    }

    public void releaseVPS() {
        JNICCallJava.removeAllCallback();
        a((a) null);
        a((w) null);
        ARVPASJniClient aRVPASJniClient = this.Fb;
        if (aRVPASJniClient != null) {
            aRVPASJniClient.releaseVPS();
        }
    }

    public void resetVPSAlgo() {
        ARVPASJniClient aRVPASJniClient = this.Fb;
        if (aRVPASJniClient == null) {
            return;
        }
        aRVPASJniClient.resetVPSAlgo();
    }

    public void setSession(String str) {
        this.Fc = str;
    }

    public void setUserID(String str) {
        JNICCallJava.setUserID(str);
    }

    public boolean start() {
        ARVPASJniClient aRVPASJniClient = this.Fb;
        if (aRVPASJniClient == null) {
            return false;
        }
        return aRVPASJniClient.start(this.width, this.height, this.nF, this.Fa.ax());
    }

    @Override // com.baidu.ar.lx
    public void a(FramePixels framePixels, ICallbackWith<ma> iCallbackWith) {
        boolean z;
        if (this.Fb == null || this.DC == null || TextUtils.isEmpty(this.Fc) || !this.Fd) {
            return;
        }
        ByteBuffer pixelsAddress = framePixels.getPixelsAddress();
        byte[] bArr = new byte[pixelsAddress.remaining()];
        pixelsAddress.get(bArr);
        if (this.Fb.trackFrame(bArr, this.DC.getMatrix(), System.currentTimeMillis(), FrameType.TYPE_YUV) == -1) {
            return;
        }
        int trackerPose = this.Fb.getTrackerPose(this.EG);
        y yVar = new y();
        mb mbVar = new mb(framePixels.getTimestamp());
        if (trackerPose == 0) {
            yVar.setPose(this.EG);
            z = true;
        } else {
            z = false;
        }
        mbVar.D(z);
        mbVar.a(yVar);
        iCallbackWith.run(new ma(mbVar));
    }

    public void a(fh fhVar) {
        this.DC = fhVar;
    }

    public void a(a aVar) {
        this.Fe = aVar;
    }

    public void a(w wVar) {
        JNICCallJava.setsITransModelPointCallback(wVar);
    }
}
