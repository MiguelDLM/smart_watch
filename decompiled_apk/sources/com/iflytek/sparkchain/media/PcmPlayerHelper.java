package com.iflytek.sparkchain.media;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.iflytek.sparkchain.core.media.player.PcmPlayer;
import com.iflytek.sparkchain.media.player.b;
import com.iflytek.sparkchain.media.player.c;
import com.iflytek.sparkchain.media.record.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class PcmPlayerHelper implements MediaPlayerHelper, PcmPlayerWriter {
    private Context mContext;
    private b mPlayer = null;
    private a mBuffer = null;
    private AtomicBoolean isInit = new AtomicBoolean(false);
    private AtomicInteger totalPercent = new AtomicInteger(100);

    /* loaded from: classes10.dex */
    public static class Holder {
        private static PcmPlayerHelper instance = new PcmPlayerHelper();

        private Holder() {
        }
    }

    private void doInitPlayer(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (this.mPlayer == null) {
            this.mPlayer = new b(applicationContext, 3, true, false, false);
        }
        this.isInit.set(true);
    }

    public static PcmPlayerHelper getInst() {
        return Holder.instance;
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void init(Context context, c cVar) {
        doInitPlayer(context);
        this.mPlayer.setListener(cVar);
    }

    @Deprecated
    public void initPlayer(@NonNull Context context) {
        doInitPlayer(context);
    }

    public boolean isInit() {
        return this.isInit.get();
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public boolean isPlaying() {
        b bVar = this.mPlayer;
        return bVar != null && bVar.getState() == 2;
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void pause() {
        b bVar = this.mPlayer;
        if (bVar != null) {
            bVar.pause();
        }
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void play() {
        b bVar = this.mPlayer;
        if (bVar == null) {
            return;
        }
        if (bVar.getState() == 2 || this.mPlayer.getState() == 3) {
            this.mPlayer.stop();
            SystemClock.sleep(200L);
        }
        try {
            this.mPlayer.play(this.mBuffer);
        } catch (IllegalThreadStateException e) {
            Log.w("AEE", "play:" + e.toString());
        }
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void release() {
        this.mContext = null;
        b bVar = this.mPlayer;
        if (bVar != null) {
            bVar.stop();
            this.mPlayer.release();
        }
        this.mPlayer = null;
        this.mBuffer = null;
        this.isInit.set(false);
    }

    public void resetBuffer(int i) {
        if (this.mPlayer == null) {
            return;
        }
        a aVar = this.mBuffer;
        if (aVar == null) {
            this.mBuffer = new a(this.mContext, 16000, i <= 0 ? 1 : i, null, 100);
        } else {
            aVar.reset(this.mContext, 16000, i <= 0 ? 1 : i, null, 100);
            this.mBuffer.deleteFile();
        }
    }

    public void resetPercent(int i) {
        if (this.isInit.get()) {
            this.totalPercent.set(i);
        }
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void resume() {
        b bVar = this.mPlayer;
        if (bVar != null) {
            bVar.resume();
        }
    }

    public void setLocalDataSize(int i) {
        resetBuffer(1);
        this.mBuffer.setMaxFileSize(i);
    }

    @Deprecated
    public synchronized int startPlay(PcmPlayer.PcmPlayerListener pcmPlayerListener) {
        b bVar = this.mPlayer;
        if (bVar == null) {
            return -1;
        }
        bVar.setListener(pcmPlayerListener);
        play();
        return 0;
    }

    @Override // com.iflytek.sparkchain.media.MediaPlayerHelper
    public void stop() {
        b bVar = this.mPlayer;
        if (bVar != null) {
            bVar.stop();
        }
        resetBuffer(0);
    }

    public boolean write(ArrayList<byte[]> arrayList, int i, int i2) {
        a aVar = this.mBuffer;
        if (aVar == null) {
            return false;
        }
        return aVar.writeStream(arrayList, this.totalPercent.get(), i, i2);
    }

    @Override // com.iflytek.sparkchain.media.PcmPlayerWriter
    public boolean write(byte[] bArr, int i, int i2) {
        if (this.mBuffer == null) {
            return false;
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        arrayList.add(bArr);
        return this.mBuffer.writeStream(arrayList, this.totalPercent.get(), i, i2);
    }
}
