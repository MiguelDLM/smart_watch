package com.baidu.ar.audio;

import com.baidu.ar.bp;
import com.baidu.ar.bq;
import com.baidu.ar.kf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, bp {
    private static final String TAG = "EasyAudio";
    private static volatile EasyAudio kX;
    private bq kS;
    private ArrayList<EasyAudioCallback> kT;
    private ArrayList<VolumeListener> kU;
    private final Lock kV = new ReentrantLock(true);
    private final Lock kW = new ReentrantLock(true);

    private EasyAudio() {
    }

    private synchronized void ch() {
        bq bqVar = this.kS;
        if (bqVar != null) {
            bqVar.bV();
            this.kS.bW();
            this.kS = null;
        }
    }

    private synchronized void ci() {
        try {
            this.kV.lock();
            try {
                ArrayList<EasyAudioCallback> arrayList = this.kT;
                if (arrayList != null) {
                    arrayList.clear();
                    this.kT = null;
                }
                this.kV.unlock();
                ArrayList<VolumeListener> arrayList2 = this.kU;
                if (arrayList2 != null) {
                    arrayList2.clear();
                    this.kU = null;
                }
                releaseInstance();
            } catch (Throwable th) {
                this.kV.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static EasyAudio getInstance() {
        if (kX == null) {
            synchronized (EasyAudio.class) {
                try {
                    if (kX == null) {
                        kX = new EasyAudio();
                    }
                } finally {
                }
            }
        }
        return kX;
    }

    private static void releaseInstance() {
        kX = null;
    }

    @Override // com.baidu.ar.bp
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.kV.lock();
        try {
            ArrayList<EasyAudioCallback> arrayList = this.kT;
            if (arrayList != null) {
                Iterator<EasyAudioCallback> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.kV.unlock();
        }
    }

    @Override // com.baidu.ar.bp
    public void onAudioRelease() {
        ci();
    }

    @Override // com.baidu.ar.bp
    public void onAudioSetup(boolean z) {
        if (z) {
            bq bqVar = this.kS;
            if (bqVar != null) {
                bqVar.startAudio();
                return;
            }
            return;
        }
        ArrayList<EasyAudioCallback> arrayList = this.kT;
        if (arrayList == null || arrayList.get(0) == null) {
            return;
        }
        this.kT.get(0).onAudioStart(false, null);
        release();
    }

    @Override // com.baidu.ar.bp
    public void onAudioStart(boolean z) {
        ArrayList<EasyAudioCallback> arrayList = this.kT;
        if (arrayList != null && arrayList.get(0) != null && this.kS != null) {
            this.kT.get(0).onAudioStart(z, this.kS.bX());
        }
        if (z) {
            return;
        }
        release();
    }

    @Override // com.baidu.ar.bp
    public void onAudioStop(boolean z) {
        ArrayList<EasyAudioCallback> arrayList = this.kT;
        if (arrayList == null || arrayList.get(0) == null) {
            return;
        }
        this.kT.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i) {
        this.kW.lock();
        try {
            ArrayList<VolumeListener> arrayList = this.kU;
            if (arrayList != null) {
                Iterator<VolumeListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.kW.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        ch();
        ci();
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            kf.b(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.kW.lock();
        try {
            ArrayList<VolumeListener> arrayList = this.kU;
            if (arrayList != null && arrayList.size() > 0 && this.kU.contains(volumeListener)) {
                this.kU.remove(volumeListener);
            }
        } finally {
            this.kW.unlock();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        String str;
        String str2;
        if (volumeListener == null) {
            str = TAG;
            str2 = "VolumeListener can not be null!!!";
        } else {
            if (this.kU == null) {
                this.kU = new ArrayList<>();
            }
            if (!this.kU.contains(volumeListener)) {
                if (this.kS == null) {
                    this.kS = bq.bT();
                }
                this.kW.lock();
                try {
                    if (this.kU.size() == 0) {
                        this.kS.setVolumeListener(this);
                    }
                    this.kU.add(volumeListener);
                    this.kW.unlock();
                    return;
                } catch (Throwable th) {
                    this.kW.unlock();
                    throw th;
                }
            }
            str = TAG;
            str2 = "setVolumeListener volumeListener has been added!!!";
        }
        kf.b(str, str2);
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        String str;
        String str2;
        if (audioParams == null || easyAudioCallback == null) {
            str = TAG;
            str2 = "AudioParams && EasyAudioCallback can not be null!!!";
        } else {
            if (this.kS == null) {
                this.kS = bq.bT();
            }
            if (this.kT == null) {
                this.kT = new ArrayList<>();
            }
            if (!this.kT.contains(easyAudioCallback)) {
                if (this.kS.isRunning()) {
                    easyAudioCallback.onAudioStart(true, this.kS.bX());
                } else {
                    this.kT.clear();
                    this.kS.a(audioParams, this);
                }
                this.kV.lock();
                try {
                    ArrayList<EasyAudioCallback> arrayList = this.kT;
                    if (arrayList != null) {
                        arrayList.add(easyAudioCallback);
                    }
                    return;
                } finally {
                    this.kV.unlock();
                }
            }
            str = TAG;
            str2 = "EasyAudio has been started!!!";
        }
        kf.b(str, str2);
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            kf.b(TAG, "EasyAudioCallback can not be null!!!");
            return;
        }
        ArrayList<EasyAudioCallback> arrayList = this.kT;
        if (arrayList == null || !arrayList.contains(easyAudioCallback)) {
            kf.b(TAG, "Please confirm EasyAudio has been started!!!");
            return;
        }
        if (this.kT.size() <= 1) {
            ch();
            return;
        }
        this.kV.lock();
        try {
            boolean remove = this.kT.remove(easyAudioCallback);
            this.kV.unlock();
            easyAudioCallback.onAudioStop(remove);
        } catch (Throwable th) {
            this.kV.unlock();
            throw th;
        }
    }
}
