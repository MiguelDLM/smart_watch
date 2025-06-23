package com.iflytek.sparkchain.media;

import com.iflytek.sparkchain.core.media.record.PcmRecorder;
import com.iflytek.sparkchain.media.listener.DecibelListener;
import com.iflytek.sparkchain.media.record.PcmRecorder;
import com.iflytek.sparkchain.media.record.b;
import com.iflytek.sparkchain.media.speech.SpeechError;

/* loaded from: classes10.dex */
public class RecorderHelper implements MediaRecorderHelper {
    protected PcmRecorder pcmRecorder = null;

    /* loaded from: classes10.dex */
    public static class BaseParams {
        protected DecibelListener listener;
        protected int source = 1;
        protected int rate = 16000;
        protected short channel = 1;
        protected int format = 2;
        protected int size = 0;
    }

    /* loaded from: classes10.dex */
    public static class Holder {
        private static RecorderHelper instance = new RecorderHelper();

        private Holder() {
        }
    }

    /* loaded from: classes10.dex */
    public static class Params extends BaseParams {

        /* loaded from: classes10.dex */
        public static class Builder extends BaseParams {
            public Params build() {
                return new Params(this);
            }

            public Builder channel(short s) {
                this.channel = s;
                return this;
            }

            public Builder format(int i) {
                this.format = i;
                return this;
            }

            public Builder listener(DecibelListener decibelListener) {
                this.listener = decibelListener;
                return this;
            }

            public Builder rate(int i) {
                this.rate = i;
                return this;
            }

            public Builder size(int i) {
                this.size = i;
                return this;
            }

            public Builder source(int i) {
                this.source = i;
                return this;
            }
        }

        private Params(Builder builder) {
            this.source = builder.source;
            this.rate = builder.rate;
            this.channel = builder.channel;
            this.format = builder.format;
            this.size = builder.size;
            this.listener = builder.listener;
        }

        public static Builder builder() {
            return new Builder();
        }

        public short getChannel() {
            return this.channel;
        }

        public int getFormat() {
            return this.format;
        }

        public DecibelListener getListener() {
            return this.listener;
        }

        public int getRate() {
            return this.rate;
        }

        public int getSize() {
            return this.size;
        }

        public int getSource() {
            return this.source;
        }
    }

    public static Params genFrom(PcmRecorder.Builder builder) {
        return Params.builder().source(builder.getAudioSource()).rate(builder.getRate()).channel(builder.getChannel()).format(builder.getAudioFormat()).size(builder.getBufferSize()).listener(builder.getDecibelListener()).build();
    }

    public static RecorderHelper getInst() {
        return Holder.instance;
    }

    private void release() {
        PcmRecorder pcmRecorder = this.pcmRecorder;
        if (pcmRecorder != null) {
            pcmRecorder.stopRecord(true);
            this.pcmRecorder.releaseRecord();
            this.pcmRecorder = null;
        }
    }

    public void init(Params params, b bVar) {
        if (this.pcmRecorder == null) {
            this.pcmRecorder = new PcmRecorder(params, bVar);
        }
    }

    public void stop() {
        release();
    }

    public static b genFrom(final PcmRecorder.PcmRecordListener pcmRecordListener) {
        return new b() { // from class: com.iflytek.sparkchain.media.RecorderHelper.1
            @Override // com.iflytek.sparkchain.media.record.b
            public void onBuffer(byte[] bArr, int i, int i2) {
                PcmRecorder.PcmRecordListener.this.onRecordBuffer(bArr, i, i2);
            }

            @Override // com.iflytek.sparkchain.media.record.b
            public void onDecibel(int i) {
                PcmRecorder.PcmRecordListener.this.onDecibel(i);
            }

            @Override // com.iflytek.sparkchain.media.record.b
            public void onError(SpeechError speechError) {
                PcmRecorder.PcmRecordListener.this.onError((com.iflytek.sparkchain.core.media.speech.SpeechError) speechError);
            }

            @Override // com.iflytek.sparkchain.media.record.b
            public void onRelease() {
                PcmRecorder.PcmRecordListener.this.onRecordReleased();
            }

            @Override // com.iflytek.sparkchain.media.record.b
            public void onStart(boolean z) {
                PcmRecorder.PcmRecordListener.this.onRecordStarted(z);
            }
        };
    }
}
