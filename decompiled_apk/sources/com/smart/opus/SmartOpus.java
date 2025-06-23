package com.smart.opus;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.Log;
import com.smart.opus.OpusConstants;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class SmartOpus {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String TAG = "SmartOpus";

    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String getTAG() {
            return SmartOpus.TAG;
        }

        private Companion() {
        }
    }

    static {
        try {
            System.loadLibrary("easyopus");
        } catch (Exception e) {
            Log.e(TAG, "Couldn't load opus library: " + e);
        }
    }

    private final native byte[] decode(byte[] bArr, int i, int i2);

    private final native short[] decode(short[] sArr, int i, int i2);

    public static /* synthetic */ byte[] decode$default(SmartOpus smartOpus, byte[] bArr, OpusConstants.FrameSize frameSize, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return smartOpus.decode(bArr, frameSize, i);
    }

    private final native int decoderInit(int i, int i2);

    private final native byte[] encode(byte[] bArr, int i);

    private final native short[] encode(short[] sArr, int i);

    private final native int encoderInit(int i, int i2, int i3);

    private final native int encoderSetBitrate(int i);

    private final native int encoderSetComplexity(int i);

    @oOoXoXO
    public final native byte[] convert(@OOXIXo short[] sArr);

    @oOoXoXO
    public final native short[] convert(@OOXIXo byte[] bArr);

    @oOoXoXO
    public final byte[] decode(@OOXIXo byte[] bytes, @OOXIXo OpusConstants.FrameSize frameSize, int i) {
        IIX0o.x0xO0oo(bytes, "bytes");
        IIX0o.x0xO0oo(frameSize, "frameSize");
        return decode(bytes, frameSize.getV(), i);
    }

    public final int decoderInit(@OOXIXo OpusConstants.SampleRate sampleRate, @OOXIXo OpusConstants.Channels channels) {
        IIX0o.x0xO0oo(sampleRate, "sampleRate");
        IIX0o.x0xO0oo(channels, "channels");
        return decoderInit(sampleRate.getV(), channels.getV());
    }

    public final native void decoderRelease();

    @oOoXoXO
    public final byte[] encode(@OOXIXo byte[] bytes, @OOXIXo OpusConstants.FrameSize frameSize) {
        IIX0o.x0xO0oo(bytes, "bytes");
        IIX0o.x0xO0oo(frameSize, "frameSize");
        return encode(bytes, frameSize.getV());
    }

    public final int encoderInit(@OOXIXo OpusConstants.SampleRate sampleRate, @OOXIXo OpusConstants.Channels channels, @OOXIXo OpusConstants.Application application) {
        IIX0o.x0xO0oo(sampleRate, "sampleRate");
        IIX0o.x0xO0oo(channels, "channels");
        IIX0o.x0xO0oo(application, "application");
        return encoderInit(sampleRate.getV(), channels.getV(), application.getV());
    }

    public final native void encoderRelease();

    public final int encoderSetBitrate(@OOXIXo OpusConstants.Bitrate bitrate) {
        IIX0o.x0xO0oo(bitrate, "bitrate");
        return encoderSetBitrate(bitrate.getV());
    }

    public final int encoderSetComplexity(@OOXIXo OpusConstants.Complexity complexity) {
        IIX0o.x0xO0oo(complexity, "complexity");
        return encoderSetComplexity(complexity.getV());
    }

    public static /* synthetic */ short[] decode$default(SmartOpus smartOpus, short[] sArr, OpusConstants.FrameSize frameSize, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return smartOpus.decode(sArr, frameSize, i);
    }

    @oOoXoXO
    public final short[] decode(@OOXIXo short[] shorts, @OOXIXo OpusConstants.FrameSize frameSize, int i) {
        IIX0o.x0xO0oo(shorts, "shorts");
        IIX0o.x0xO0oo(frameSize, "frameSize");
        return decode(shorts, frameSize.getV(), i);
    }

    @oOoXoXO
    public final short[] encode(@OOXIXo short[] shorts, @OOXIXo OpusConstants.FrameSize frameSize) {
        IIX0o.x0xO0oo(shorts, "shorts");
        IIX0o.x0xO0oo(frameSize, "frameSize");
        return encode(shorts, frameSize.getV());
    }
}
