package com.baidu.ar;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hv {
    private static final String TAG = "hv";
    private hw wT;
    private MediaMuxer xA;
    private volatile boolean xB = false;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.xA.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        kf.b(TAG, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean fI() {
        return this.xB;
    }

    public synchronized void fJ() {
        boolean z;
        try {
            this.xA.start();
            z = true;
            this.xB = true;
        } catch (Exception unused) {
            kf.b(TAG, "startMuxer error!!!");
            z = false;
        }
        hw hwVar = this.wT;
        if (hwVar != null) {
            hwVar.L(z);
        }
    }

    public synchronized void fK() {
        boolean z = false;
        try {
            this.xA.stop();
            this.xB = false;
            z = true;
        } catch (Exception unused) {
            kf.b(TAG, "stopMuxer error!!!");
        }
        hw hwVar = this.wT;
        if (hwVar != null) {
            hwVar.M(z);
        }
    }

    public void fL() {
        if (this.xB) {
            return;
        }
        this.xA.release();
        this.xA = null;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i == -1) {
            return false;
        }
        try {
            this.xA.writeSampleData(i, byteBuffer, bufferInfo);
            return true;
        } catch (Exception unused) {
            kf.b(TAG, "startMuxer error!!!");
            return false;
        }
    }

    public boolean a(String str, int i, hw hwVar) {
        if (!hy.bv(str)) {
            hy.bu(str);
        }
        try {
            this.xA = new MediaMuxer(str, i);
            this.wT = hwVar;
            this.xB = false;
            return true;
        } catch (Exception e) {
            kf.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }
}
