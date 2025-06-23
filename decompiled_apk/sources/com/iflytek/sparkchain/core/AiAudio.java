package com.iflytek.sparkchain.core;

import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class AiAudio extends a {
    public static String ENCODING_DEFAULT = "speex-wb";
    public static String ENCODING_ICO = "ico";
    public static String ENCODING_LAME = "lame";
    public static String ENCODING_OPUS = "opus";
    public static String ENCODING_OPUS_WB = "opus-wb";
    public static String ENCODING_PCM = "pcm";
    public static String ENCODING_RAW = "raw";
    public static String ENCODING_SPEEX = "speex";
    public static String ENCODING_SPEEX_WB = "speex-wb";

    /* loaded from: classes10.dex */
    public static class Holder extends AiDataHolder<Holder, AiAudio> {
        private int bitDepth;
        private int channels;
        private String encoding;
        private int sampleRate;

        public Holder(String str) {
            super(new AiAudio(), str);
            this.encoding = AiAudio.ENCODING_DEFAULT;
            this.sampleRate = 16000;
            this.channels = 1;
            this.bitDepth = 16;
        }

        public Holder bitDepth(int i) {
            this.bitDepth = ((Integer) update(Integer.valueOf(this.bitDepth), Integer.valueOf(i))).intValue();
            return this;
        }

        public Holder channels(int i) {
            this.channels = ((Integer) update(Integer.valueOf(this.channels), Integer.valueOf(i))).intValue();
            return this;
        }

        public Holder encoding(String str) {
            this.encoding = (String) update(this.encoding, str);
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AiDataHolder
        public void paramSync(int i) {
            sync(i, "encoding", this.encoding.getBytes());
            sync(i, "sample_rate", Integer.valueOf(this.sampleRate));
            sync(i, "channels", Integer.valueOf(this.channels));
            sync(i, "bit_depth", Integer.valueOf(this.bitDepth));
            ByteBuffer byteBuffer = this.buffer;
            sync(i, "frame_size", Integer.valueOf(byteBuffer != null ? byteBuffer.capacity() : 0));
        }

        public Holder sampleRate(int i) {
            this.sampleRate = ((Integer) update(Integer.valueOf(this.sampleRate), Integer.valueOf(i))).intValue();
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AiDataHolder
        public c type() {
            return c.AUDIO;
        }
    }

    public static Holder get(String str) {
        return new Holder(str);
    }

    public static void main(String[] strArr) {
        get("haha").data("111").status(AiStatus.BEGIN).bitDepth(1).valid().syncCtrl(1);
    }
}
