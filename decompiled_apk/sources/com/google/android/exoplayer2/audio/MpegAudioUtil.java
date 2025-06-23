package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.dfu.DfuConstants;

/* loaded from: classes9.dex */
public final class MpegAudioUtil {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public static final int MAX_RATE_BYTES_PER_SECOND = 40000;
    private static final int SAMPLES_PER_FRAME_L1 = 384;
    private static final int SAMPLES_PER_FRAME_L2 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V1 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V2 = 576;
    private static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    private static final int[] SAMPLING_RATE_V1 = {44100, OpusUtil.SAMPLE_RATE, DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT};
    private static final int[] BITRATE_V1_L1 = {DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, 64000, 96000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] BITRATE_V2_L1 = {DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] BITRATE_V1_L2 = {DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};
    private static final int[] BITRATE_V1_L3 = {DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, 40000, OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};
    private static final int[] BITRATE_V2 = {8000, 16000, ErrorCode.ERROR_TTS_INVALID_PARA, DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, 40000, OpusUtil.SAMPLE_RATE, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* loaded from: classes9.dex */
    public static final class Header {
        public int bitrate;
        public int channels;
        public int frameSize;

        @Nullable
        public String mimeType;
        public int sampleRate;
        public int samplesPerFrame;
        public int version;

        public boolean setForHeaderData(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            if (!MpegAudioUtil.isMagicPresent(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.version = i2;
            this.mimeType = MpegAudioUtil.MIME_TYPE_BY_LAYER[3 - i3];
            int i8 = MpegAudioUtil.SAMPLING_RATE_V1[i5];
            this.sampleRate = i8;
            int i9 = 2;
            if (i2 == 2) {
                this.sampleRate = i8 / 2;
            } else if (i2 == 0) {
                this.sampleRate = i8 / 4;
            }
            int i10 = (i >>> 9) & 1;
            this.samplesPerFrame = MpegAudioUtil.getFrameSizeInSamples(i2, i3);
            if (i3 == 3) {
                if (i2 == 3) {
                    i7 = MpegAudioUtil.BITRATE_V1_L1[i4 - 1];
                } else {
                    i7 = MpegAudioUtil.BITRATE_V2_L1[i4 - 1];
                }
                this.bitrate = i7;
                this.frameSize = (((i7 * 12) / this.sampleRate) + i10) * 4;
            } else {
                int i11 = 144;
                if (i2 == 3) {
                    if (i3 == 2) {
                        i6 = MpegAudioUtil.BITRATE_V1_L2[i4 - 1];
                    } else {
                        i6 = MpegAudioUtil.BITRATE_V1_L3[i4 - 1];
                    }
                    this.bitrate = i6;
                    this.frameSize = ((i6 * 144) / this.sampleRate) + i10;
                } else {
                    int i12 = MpegAudioUtil.BITRATE_V2[i4 - 1];
                    this.bitrate = i12;
                    if (i3 == 1) {
                        i11 = 72;
                    }
                    this.frameSize = ((i11 * i12) / this.sampleRate) + i10;
                }
            }
            if (((i >> 6) & 3) == 3) {
                i9 = 1;
            }
            this.channels = i9;
            return true;
        }
    }

    private MpegAudioUtil() {
    }

    public static int getFrameSize(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!isMagicPresent(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i8 /= 2;
        } else if (i2 == 0) {
            i8 /= 4;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            if (i2 == 3) {
                i7 = BITRATE_V1_L1[i4 - 1];
            } else {
                i7 = BITRATE_V2_L1[i4 - 1];
            }
            return (((i7 * 12) / i8) + i9) * 4;
        }
        if (i2 == 3) {
            if (i3 == 2) {
                i6 = BITRATE_V1_L2[i4 - 1];
            } else {
                i6 = BITRATE_V1_L3[i4 - 1];
            }
        } else {
            i6 = BITRATE_V2[i4 - 1];
        }
        int i10 = 144;
        if (i2 == 3) {
            return ((i6 * 144) / i8) + i9;
        }
        if (i3 == 1) {
            i10 = 72;
        }
        return ((i10 * i6) / i8) + i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getFrameSizeInSamples(int i, int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return 1152;
            }
            if (i2 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        }
        if (i == 3) {
            return 1152;
        }
        return SAMPLES_PER_FRAME_L3_V2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMagicPresent(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int parseMpegAudioFrameSampleCount(int i) {
        int i2;
        int i3;
        if (!isMagicPresent(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return getFrameSizeInSamples(i2, i3);
    }
}
