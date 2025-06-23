package com.iflytek.sparkchain.core.media.record;

import com.iflytek.sparkchain.core.media.speech.SpeechError;
import com.iflytek.sparkchain.media.record.PcmRecorder;

@Deprecated
/* loaded from: classes10.dex */
public class PcmRecorder extends com.iflytek.sparkchain.media.record.PcmRecorder {

    /* loaded from: classes10.dex */
    public interface PcmRecordListener {
        void onDecibel(int i);

        void onError(SpeechError speechError);

        void onRecordBuffer(byte[] bArr, int i, int i2);

        void onRecordReleased();

        void onRecordStarted(boolean z);
    }

    public PcmRecorder(PcmRecorder.Builder builder, PcmRecordListener pcmRecordListener) {
        super(builder, pcmRecordListener);
    }
}
