package com.iflytek.sparkchain.core.media.record;

import com.iflytek.sparkchain.core.media.record.PcmRecorder;
import com.iflytek.sparkchain.media.RecorderHelper;
import com.iflytek.sparkchain.media.SimplePlayerHelper;
import com.iflytek.sparkchain.media.player.SimplePlayer;
import com.iflytek.sparkchain.media.record.PcmRecorder;

@Deprecated
/* loaded from: classes10.dex */
public class IFlyAudioManager extends RecorderHelper {

    /* loaded from: classes10.dex */
    public static class Holder {
        private static IFlyAudioManager instance = new IFlyAudioManager();

        private Holder() {
        }
    }

    public static IFlyAudioManager getInst() {
        return Holder.instance;
    }

    @Deprecated
    public void initPcmRecorder(PcmRecorder.Builder builder, PcmRecorder.PcmRecordListener pcmRecordListener) {
        RecorderHelper.getInst().init(RecorderHelper.genFrom(builder), RecorderHelper.genFrom(pcmRecordListener));
    }

    @Deprecated
    public void pausePlay() {
        SimplePlayerHelper.getInst().pause();
    }

    @Deprecated
    public void playerInit(String str, SimplePlayer.PlayerListener playerListener) {
        SimplePlayerHelper.getInst().init(str, playerListener);
    }

    @Deprecated
    public void startPcmPlay() {
        SimplePlayerHelper.getInst().play();
    }

    @Deprecated
    public void stopPlay() {
        SimplePlayerHelper.getInst().stop();
    }

    @Deprecated
    public void playerInit(byte[] bArr, SimplePlayer.PlayerListener playerListener) {
        SimplePlayerHelper.getInst().init(bArr, playerListener);
    }
}
