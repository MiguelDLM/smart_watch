package com.baidu.ar;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes7.dex */
public class dm implements dn {
    private Handler mHandler;
    private AudioTrack pu = new AudioTrack(3, 16000, 4, 2, AudioTrack.getMinBufferSize(16000, 4, 2), 1);
    private HandlerThread pv;

    public dm() {
        HandlerThread handlerThread = new HandlerThread("AudioTrackPlayer");
        this.pv = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.pv.getLooper()) { // from class: com.baidu.ar.dm.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 2) {
                    if (dm.this.pu != null) {
                        dm.this.pu.play();
                    }
                } else if (i == 7 && (message.obj instanceof byte[]) && dm.this.pu != null) {
                    if (dm.this.pu.getPlayState() != 3) {
                        dm.this.pu.play();
                    }
                    byte[] bArr = (byte[]) message.obj;
                    dm.this.pu.write(bArr, 0, bArr.length);
                }
            }
        };
    }

    @Override // com.baidu.ar.dn
    public void f(byte[] bArr) {
        Message.obtain(this.mHandler, 7, bArr).sendToTarget();
    }

    @Override // com.baidu.ar.dn
    public boolean isPlaying() {
        AudioTrack audioTrack = this.pu;
        return audioTrack != null && audioTrack.getPlayState() == 3;
    }

    @Override // com.baidu.ar.dn
    public void pause() {
        AudioTrack audioTrack = this.pu;
        if (audioTrack == null || audioTrack.getState() != 1) {
            return;
        }
        this.pu.pause();
    }

    @Override // com.baidu.ar.dn
    public void release() {
        AudioTrack audioTrack = this.pu;
        if (audioTrack != null) {
            audioTrack.release();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.pv.quitSafely();
    }

    @Override // com.baidu.ar.dn
    public void resume() {
        AudioTrack audioTrack = this.pu;
        if (audioTrack == null || audioTrack.getState() != 1) {
            return;
        }
        this.pu.play();
    }

    @Override // com.baidu.ar.dn
    public void start() {
        Message.obtain(this.mHandler, 2).sendToTarget();
    }

    @Override // com.baidu.ar.dn
    public void stop() {
        AudioTrack audioTrack = this.pu;
        if (audioTrack != null) {
            audioTrack.stop();
        }
    }
}
