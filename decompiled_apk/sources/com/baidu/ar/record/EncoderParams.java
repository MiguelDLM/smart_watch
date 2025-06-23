package com.baidu.ar.record;

/* loaded from: classes7.dex */
public class EncoderParams {
    private static final int AAC_SAMPLES_PER_FRAME = 1024;
    private static final int AUDIO_BIT_RATE = 128000;
    private static final int AUDIO_CHANNEL = 1;
    private static final int AUDIO_FRAME_SIZE = 10240;
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int AUDIO_SAMPLE_RATE = 44100;
    private static final String OUTPUT_FILE = "/sdcard/AR/arvideo/video/arvideo.mp4";
    private static final int OUTPUT_FORMAT = 0;
    private static final long OUTPUT_TOTAL_MS = 0;
    private static final int VIDEO_BIT_RATE = 3145728;
    private static final int VIDEO_FRAME_RATE = 30;
    private static final int VIDEO_HEIGHT = 1280;
    private static final int VIDEO_I_FRAME_INTERVAL = 1;
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private static final int VIDEO_WIDTH = 720;
    private String mOutputFile = OUTPUT_FILE;
    private int mOutputFormat = 0;
    private long mOutputTotalMs = 0;
    private boolean mVideoIncluded = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String mVideoCodec = "video/avc";
    private int mVideoBitrate = VIDEO_BIT_RATE;
    private int mVideoFrameRate = 30;
    private int mVideoIFrameInterval = 1;
    private boolean mAudioIncluded = true;
    private String mAudioCodec = "audio/mp4a-latm";
    private int mAudioChannel = 1;
    private int mAudioBitrate = AUDIO_BIT_RATE;
    private int mAudioSampleRate = AUDIO_SAMPLE_RATE;
    private int mAudioFrameSize = 10240;

    public int getAudioBitrate() {
        return this.mAudioBitrate;
    }

    public int getAudioChannel() {
        return this.mAudioChannel;
    }

    public String getAudioCodec() {
        return this.mAudioCodec;
    }

    public int getAudioFrameSize() {
        return this.mAudioFrameSize;
    }

    public int getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public String getOutputFile() {
        return this.mOutputFile;
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }

    public long getOutputTotalMs() {
        return this.mOutputTotalMs;
    }

    public int getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public String getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoFrameRate() {
        return this.mVideoFrameRate;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoIFrameInterval() {
        return this.mVideoIFrameInterval;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isAudioIncluded() {
        return this.mAudioIncluded;
    }

    public boolean isVideoIncluded() {
        return this.mVideoIncluded;
    }

    public void setAudioBitrate(int i) {
        this.mAudioBitrate = i;
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }

    public void setAudioCodec(String str) {
        this.mAudioCodec = str;
    }

    public void setAudioFrameSize(int i) {
        this.mAudioFrameSize = i;
    }

    public void setAudioIncluded(boolean z) {
        this.mAudioIncluded = z;
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSampleRate = i;
    }

    public void setOutputFile(String str) {
        this.mOutputFile = str;
    }

    public void setOutputFormat(int i) {
        this.mOutputFormat = i;
    }

    public void setOutputTotalMs(long j) {
        this.mOutputTotalMs = j;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str;
    }

    public void setVideoFrameRate(int i) {
        this.mVideoFrameRate = i;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    public void setVideoIFrameInterval(int i) {
        this.mVideoIFrameInterval = i;
    }

    public void setVideoIncluded(boolean z) {
        this.mVideoIncluded = z;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }
}
