package com.iflytek.sparkchain.media.player;

import android.media.AudioTrack;
import android.util.Log;

/* loaded from: classes10.dex */
public class SimplePlayer {
    private static final int MIN_SLEEP = 5;
    public static final int STATE_MSG_ID = 16;
    private static final String TAG = "AudioPlayer";
    private c listener;
    private a mAudioParam;
    private AudioTrack mAudioTrack;
    private byte[] mData;
    private PlayAudioThread mPlayAudioThread;
    private PlayerListener oldListener;
    private boolean mBReady = false;
    private Object mSyncObj = this;
    private boolean mThreadExitFlag = false;
    private int mPrimePlaySize = 0;
    private int mPlayOffset = 0;
    private int mPlayState = 0;

    /* loaded from: classes10.dex */
    public class PlayAudioThread extends Thread {
        private PlayAudioThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    SimplePlayer.this.oldListener.onStart();
                    synchronized (SimplePlayer.this.mSyncObj) {
                        try {
                            if (SimplePlayer.this.mPlayState != 0 && SimplePlayer.this.mPlayState != 3) {
                                SimplePlayer.this.mPlayState = 2;
                            }
                        } finally {
                        }
                    }
                    while (true) {
                        if (SimplePlayer.this.mThreadExitFlag) {
                            SimplePlayer.this.oldListener.onStop();
                            break;
                        }
                        if (SimplePlayer.this.mPlayState == 3) {
                            SimplePlayer.this.oldListener.onPause();
                            SimplePlayer.this.mAudioTrack.pause();
                        } else if (SimplePlayer.this.mPlayState == 2) {
                            SimplePlayer.this.mAudioTrack.play();
                        }
                        SimplePlayer.this.mAudioTrack.write(SimplePlayer.this.mData, SimplePlayer.this.mPlayOffset, SimplePlayer.this.mPrimePlaySize);
                        SimplePlayer simplePlayer = SimplePlayer.this;
                        SimplePlayer.access$712(simplePlayer, simplePlayer.mPrimePlaySize);
                        if (SimplePlayer.this.mPlayOffset >= SimplePlayer.this.mData.length) {
                            SimplePlayer.this.onPlayComplete();
                            break;
                        }
                    }
                    synchronized (SimplePlayer.this.mSyncObj) {
                        SimplePlayer.this.mPlayState = 1;
                    }
                    if (SimplePlayer.this.mAudioTrack == null) {
                        return;
                    }
                } catch (Throwable th) {
                    synchronized (SimplePlayer.this.mSyncObj) {
                        SimplePlayer.this.mPlayState = 1;
                        if (SimplePlayer.this.mAudioTrack != null) {
                            SimplePlayer.this.mAudioTrack.release();
                            SimplePlayer.this.mAudioTrack = null;
                        }
                        throw th;
                    }
                }
            } catch (Exception e) {
                Log.e(SimplePlayer.TAG, "play media failed:" + e);
                synchronized (SimplePlayer.this.mSyncObj) {
                    SimplePlayer.this.mPlayState = 1;
                    if (SimplePlayer.this.mAudioTrack == null) {
                        return;
                    }
                }
            }
            SimplePlayer.this.mAudioTrack.release();
            SimplePlayer.this.mAudioTrack = null;
        }
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public interface PlayerListener {
        void onCompleted();

        void onError(int i);

        void onPause();

        void onStart();

        void onStop();
    }

    @Deprecated
    public SimplePlayer(PlayerListener playerListener) {
        this.oldListener = playerListener;
    }

    public static /* synthetic */ int access$712(SimplePlayer simplePlayer, int i) {
        int i2 = simplePlayer.mPlayOffset + i;
        simplePlayer.mPlayOffset = i2;
        return i2;
    }

    private void createAudioTrack() throws Exception {
        a aVar = this.mAudioParam;
        int minBufferSize = AudioTrack.getMinBufferSize(aVar.f17470a, aVar.b, aVar.c);
        this.mPrimePlaySize = minBufferSize * 2;
        a aVar2 = this.mAudioParam;
        this.mAudioTrack = new AudioTrack(3, aVar2.f17470a, aVar2.b, aVar2.c, minBufferSize, 1);
    }

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.stop();
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    private boolean setPlayState(int i) {
        synchronized (this.mSyncObj) {
            this.mPlayState = i;
        }
        return true;
    }

    private void startThread() {
        if (this.mPlayAudioThread == null) {
            this.mThreadExitFlag = false;
            PlayAudioThread playAudioThread = new PlayAudioThread();
            this.mPlayAudioThread = playAudioThread;
            playAudioThread.start();
        }
    }

    private void stopThread() {
        if (this.mPlayAudioThread != null) {
            this.mThreadExitFlag = true;
            this.mPlayAudioThread = null;
        }
    }

    public void onPlayComplete() {
        this.mPlayAudioThread = null;
        if (this.mPlayState != 3) {
            setPlayState(1);
            PlayerListener playerListener = this.oldListener;
            if (playerListener != null) {
                playerListener.onCompleted();
            }
        }
    }

    public boolean pause() {
        if (!this.mBReady) {
            return false;
        }
        if (this.mPlayState != 2) {
            return true;
        }
        setPlayState(3);
        stopThread();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
    
        if (r0 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean play() {
        /*
            r4 = this;
            boolean r0 = r4.mBReady
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r4.mPlayState
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L17
            r1 = 3
            if (r0 == r1) goto L10
            goto L1a
        L10:
            r4.setPlayState(r2)
            r4.startThread()
            goto L1a
        L17:
            r4.mPlayOffset = r1
            goto L10
        L1a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.media.player.SimplePlayer.play():boolean");
    }

    public boolean prepare() {
        if (this.mData != null && this.mAudioParam != null) {
            if (this.mBReady) {
                return true;
            }
            try {
                createAudioTrack();
                this.mBReady = true;
                setPlayState(1);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean release() {
        stop();
        releaseAudioTrack();
        this.mBReady = false;
        setPlayState(0);
        return true;
    }

    public boolean resume() {
        return true;
    }

    public void setAudioParam(a aVar) {
        this.mAudioParam = aVar;
    }

    public void setDataSource(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.mData = bArr;
    }

    public void setListener(PlayerListener playerListener) {
        this.oldListener = playerListener;
    }

    public boolean stop() {
        if (!this.mBReady) {
            return false;
        }
        setPlayState(1);
        stopThread();
        return true;
    }

    @Deprecated
    public SimplePlayer(PlayerListener playerListener, a aVar) {
        this.oldListener = playerListener;
        setAudioParam(aVar);
    }

    public void setListener(c cVar) {
        this.listener = cVar;
    }

    public SimplePlayer(c cVar) {
        setListener(cVar);
    }

    public SimplePlayer(c cVar, a aVar) {
        setListener(cVar);
        setAudioParam(aVar);
    }
}
