package com.baidu.ar;

import XIXIX.OOXIXo;
import android.media.AudioRecord;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.VolumeListener;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes7.dex */
class br {
    private static final String TAG = "br";
    private static volatile boolean kR = false;
    private AudioRecord kJ;
    private AudioParams kK;
    private bp kO;
    private VolumeListener kP;
    private byte[] kL = null;
    private ArrayList<ByteBuffer> kM = null;
    private int kN = 0;
    private boolean kQ = false;

    private void a(long j, int i) {
        ByteBuffer byteBuffer = this.kM.get(this.kN);
        if (i == -3) {
            kf.b(TAG, "Audio read error");
        } else if (this.kO != null && byteBuffer != null && byteBuffer.capacity() >= i) {
            if (this.kK.getAmplifyVolume() != 1.0f) {
                bs.a(this.kL, this.kK.getAmplifyVolume());
            }
            try {
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(this.kL, 0, i);
                byteBuffer.flip();
                this.kO.onAudioFrameAvailable(byteBuffer, i, j);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i2 = this.kN + 1;
        this.kN = i2;
        this.kN = i2 % this.kK.getFrameBufferCount();
        if (this.kP != null) {
            this.kP.onRealtimeVolume((int) bs.c(this.kL));
        }
    }

    private void c(long j) {
        if (j >= 20) {
            r(false);
        } else if (bs.b(this.kL) == OOXIXo.f3760XO) {
            return;
        } else {
            r(true);
        }
        this.kQ = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cf() {
        /*
            r5 = this;
            android.media.AudioRecord r0 = r5.kJ
            int r0 = r0.getState()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L3d
            android.media.AudioRecord r0 = r5.kJ     // Catch: java.lang.IllegalStateException -> L31
            r0.startRecording()     // Catch: java.lang.IllegalStateException -> L31
            android.media.AudioRecord r0 = r5.kJ     // Catch: java.lang.IllegalStateException -> L31
            int r0 = r0.getRecordingState()     // Catch: java.lang.IllegalStateException -> L31
            r3 = 3
            if (r0 != r3) goto L19
            goto L3e
        L19:
            java.lang.String r2 = com.baidu.ar.br.TAG     // Catch: java.lang.IllegalStateException -> L31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalStateException -> L31
            r3.<init>()     // Catch: java.lang.IllegalStateException -> L31
            java.lang.String r4 = "startAudioRecord state = "
            r3.append(r4)     // Catch: java.lang.IllegalStateException -> L31
            r3.append(r0)     // Catch: java.lang.IllegalStateException -> L31
            java.lang.String r0 = r3.toString()     // Catch: java.lang.IllegalStateException -> L31
            com.baidu.ar.kf.b(r2, r0)     // Catch: java.lang.IllegalStateException -> L31
            goto L3d
        L31:
            r0 = move-exception
            java.lang.String r2 = com.baidu.ar.br.TAG
            java.lang.String r3 = "startAudioRecord error!!!"
            com.baidu.ar.kf.b(r2, r3)
            r0.printStackTrace()
        L3d:
            r2 = 0
        L3e:
            com.baidu.ar.br.kR = r2
            if (r2 != 0) goto L62
            java.lang.String r0 = com.baidu.ar.br.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "startAudioRecord error!!! mAudioRecord.getState() = "
            r2.append(r3)
            android.media.AudioRecord r3 = r5.kJ
            int r3 = r3.getState()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.baidu.ar.kf.b(r0, r2)
            r5.r(r1)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.br.cf():void");
    }

    private void cg() {
        if (this.kK.getFrameSize() <= 0) {
            return;
        }
        if (this.kM == null) {
            this.kM = new ArrayList<>();
            for (int i = 0; i < this.kK.getFrameBufferCount(); i++) {
                this.kM.add(ByteBuffer.allocate(this.kK.getFrameSize()));
            }
        }
        this.kN = 0;
        if (this.kL == null) {
            this.kL = new byte[this.kK.getFrameSize()];
        }
        int i2 = 0;
        while (kR) {
            long nanoTime = System.nanoTime();
            AudioRecord audioRecord = this.kJ;
            byte[] bArr = this.kL;
            int read = audioRecord.read(bArr, 0, bArr.length);
            if (!this.kQ || this.kK == null) {
                c(i2);
                i2++;
            } else {
                a(nanoTime, read);
            }
        }
        this.kM = null;
        this.kL = null;
        try {
            this.kJ.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bp bpVar = this.kO;
        if (bpVar != null) {
            bpVar.onAudioStop(true);
        }
    }

    private void r(boolean z) {
        bp bpVar = this.kO;
        if (bpVar != null) {
            bpVar.onAudioStart(z);
        }
    }

    public void b(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 2048);
        }
        this.kJ = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.kK = audioParams;
        this.kQ = false;
        bp bpVar = this.kO;
        if (bpVar != null) {
            bpVar.onAudioSetup(true);
        }
    }

    public AudioParams bX() {
        return this.kK;
    }

    public void cc() {
        cf();
        cg();
    }

    public void cd() {
        kR = false;
    }

    public void ce() {
        if (kR) {
            return;
        }
        this.kJ.release();
        this.kJ = null;
        bp bpVar = this.kO;
        if (bpVar != null) {
            bpVar.onAudioRelease();
        }
        this.kO = null;
        this.kP = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.kP = volumeListener;
    }

    public void a(bp bpVar) {
        this.kO = bpVar;
    }
}
