package com.smart.opus;

import OXOo.OOXIXo;
import androidx.annotation.IntRange;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.garmin.fit.X0xOO;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class OpusConstants {

    @OOXIXo
    public static final OpusConstants INSTANCE = new OpusConstants();

    /* loaded from: classes7.dex */
    public static final class Application {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Application audio() {
                return new Application(2049, null);
            }

            @OOXIXo
            public final Application lowdelay() {
                return new Application(2051, null);
            }

            @OOXIXo
            public final Application voip() {
                return new Application(2048, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Application(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Application(int i) {
            this.v = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Bitrate {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Bitrate auto() {
                return new Bitrate(-1000, null);
            }

            @OOXIXo
            public final Bitrate instance(@IntRange(from = 500, to = 512000) int i) {
                IIXOooo iIXOooo = null;
                int i2 = 500;
                if (i < 500) {
                    return new Bitrate(i2, iIXOooo);
                }
                int i3 = IoUtils.DEFAULT_IMAGE_TOTAL_SIZE;
                if (i > 512000) {
                    return new Bitrate(i3, iIXOooo);
                }
                return new Bitrate(i, iIXOooo);
            }

            @OOXIXo
            public final Bitrate max() {
                return new Bitrate(-1, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Bitrate(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Bitrate(int i) {
            this.v = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Channels {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Channels mono() {
                return new Channels(1, null);
            }

            @OOXIXo
            public final Channels stereo() {
                return new Channels(2, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Channels(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Channels(int i) {
            this.v = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Complexity {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Complexity instance(@IntRange(from = 0, to = 10) int i) {
                IIXOooo iIXOooo = null;
                if (i < 0) {
                    return new Complexity(0, iIXOooo);
                }
                int i2 = 10;
                if (i > 10) {
                    return new Complexity(i2, iIXOooo);
                }
                return new Complexity(i, iIXOooo);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Complexity(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private Complexity(int i) {
            this.v = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class FrameSize {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final FrameSize _120() {
                return new FrameSize(120, null);
            }

            @OOXIXo
            public final FrameSize _1280() {
                return new FrameSize(1280, null);
            }

            @OOXIXo
            public final FrameSize _160() {
                return new FrameSize(160, null);
            }

            @OOXIXo
            public final FrameSize _1920() {
                return new FrameSize(ScreenUtil.DEFAULT_HEIGHT, null);
            }

            @OOXIXo
            public final FrameSize _240() {
                return new FrameSize(240, null);
            }

            @OOXIXo
            public final FrameSize _2560() {
                return new FrameSize(SubBinId.Bbpro.FACTORY_IAMGE, null);
            }

            @OOXIXo
            public final FrameSize _2880() {
                return new FrameSize(2880, null);
            }

            @OOXIXo
            public final FrameSize _320() {
                return new FrameSize(X0xOO.f13583O0o0, null);
            }

            @OOXIXo
            public final FrameSize _480() {
                return new FrameSize(480, null);
            }

            @OOXIXo
            public final FrameSize _640() {
                return new FrameSize(ScreenUtil.SCREEN_SIZE_Y_LARGE, null);
            }

            @OOXIXo
            public final FrameSize _960() {
                return new FrameSize(960, null);
            }

            @OOXIXo
            public final FrameSize _custom(int i) {
                return new FrameSize(i, null);
            }

            @OOXIXo
            public final FrameSize fromValue(int i) {
                switch (i) {
                    case 120:
                        return _120();
                    case 160:
                        return _160();
                    case 240:
                        return _240();
                    case X0xOO.f13583O0o0 /* 320 */:
                        return _320();
                    case 480:
                        return _480();
                    case ScreenUtil.SCREEN_SIZE_Y_LARGE /* 640 */:
                        return _640();
                    case 960:
                        return _960();
                    case 1280:
                        return _1280();
                    case ScreenUtil.DEFAULT_HEIGHT /* 1920 */:
                        return _1920();
                    case SubBinId.Bbpro.FACTORY_IAMGE /* 2560 */:
                        return _2560();
                    case 2880:
                        return _2880();
                    default:
                        return _custom(i);
                }
            }

            private Companion() {
            }
        }

        public /* synthetic */ FrameSize(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private FrameSize(int i) {
            this.v = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SampleRate {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int v;

        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final SampleRate _12000() {
                return new SampleRate(ErrorCode.MSP_ERROR_HTTP_BASE, null);
            }

            @OOXIXo
            public final SampleRate _16000() {
                return new SampleRate(16000, null);
            }

            @OOXIXo
            public final SampleRate _24000() {
                return new SampleRate(ErrorCode.ERROR_TTS_INVALID_PARA, null);
            }

            @OOXIXo
            public final SampleRate _48000() {
                return new SampleRate(OpusUtil.SAMPLE_RATE, null);
            }

            @OOXIXo
            public final SampleRate _8000() {
                return new SampleRate(8000, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ SampleRate(int i, IIXOooo iIXOooo) {
            this(i);
        }

        public final int getV() {
            return this.v;
        }

        private SampleRate(int i) {
            this.v = i;
        }
    }

    private OpusConstants() {
    }
}
