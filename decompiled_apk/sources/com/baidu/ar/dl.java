package com.baidu.ar;

import com.baidu.ar.digital.IDigital;
import com.baidu.ar.digital.IDigitalListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class dl extends e implements IDigital {
    private IDigitalListener pc;
    private WeakReference<IDigital> pt;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar == 0) {
            WeakReference<IDigital> weakReference = this.pt;
            if (weakReference != null) {
                weakReference.clear();
                this.pt = null;
                return;
            }
            return;
        }
        if (dVar instanceof IDigital) {
            WeakReference<IDigital> weakReference2 = new WeakReference<>((IDigital) dVar);
            this.pt = weakReference2;
            weakReference2.get().setDigitalListener(this.pc);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void initDigital(HashMap<String, Object> hashMap) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().initDigital(hashMap);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void playAudio(byte[] bArr) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().playAudio(bArr);
        }
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.clear();
            this.pt = null;
        }
        this.pc = null;
    }

    @Override // com.baidu.ar.digital.IDigital
    public void sendChatMessage(String str) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().sendChatMessage(str);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void sendReadingMessage(String str) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().sendReadingMessage(str);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setBlendShape(HashMap<String, Double> hashMap) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().setBlendShape(hashMap);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setDigitalListener(IDigitalListener iDigitalListener) {
        this.pc = iDigitalListener;
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().setDigitalListener(this.pc);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void setSkeletonData(HashMap<String, List<Double>> hashMap) {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().setSkeletonData(hashMap);
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void startRecord() {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().startRecord();
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void stop() {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().stop();
        }
    }

    @Override // com.baidu.ar.digital.IDigital
    public void stopRecord() {
        WeakReference<IDigital> weakReference = this.pt;
        if (weakReference != null) {
            weakReference.get().stopRecord();
        }
    }
}
