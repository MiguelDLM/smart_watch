package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class AudioStreamFormat {
    private SafeHandle formatHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public AudioStreamFormat(SafeHandle safeHandle) {
        this.formatHandle = null;
        Contracts.throwIfNull(safeHandle, "format");
        this.formatHandle = safeHandle;
    }

    private static final native long createFromCompressedFormat(SafeHandle safeHandle, int i);

    private static final native long createFromDefaultInput(SafeHandle safeHandle);

    private static final native long createFromWaveFormat(SafeHandle safeHandle, long j, short s, short s2, int i);

    public static AudioStreamFormat getCompressedFormat(AudioStreamContainerFormat audioStreamContainerFormat) {
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.AudioStreamFormat);
        Contracts.throwIfFail(createFromCompressedFormat(safeHandle, AudioStreamContainerFormat.values()[audioStreamContainerFormat.ordinal()].getValue()));
        return new AudioStreamFormat(safeHandle);
    }

    public static AudioStreamFormat getDefaultInputFormat() {
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.AudioStreamFormat);
        Contracts.throwIfFail(createFromDefaultInput(safeHandle));
        return new AudioStreamFormat(safeHandle);
    }

    public static AudioStreamFormat getWaveFormat(long j, short s, short s2, AudioStreamWaveFormat audioStreamWaveFormat) {
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.AudioStreamFormat);
        Contracts.throwIfFail(createFromWaveFormat(safeHandle, j, s, s2, AudioStreamWaveFormat.values()[audioStreamWaveFormat.ordinal()].getValue()));
        return new AudioStreamFormat(safeHandle);
    }

    public static AudioStreamFormat getWaveFormatPCM(long j, short s, short s2) {
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.AudioStreamFormat);
        Contracts.throwIfFail(createFromWaveFormat(safeHandle, j, s, s2, AudioStreamWaveFormat.PCM.getValue()));
        return new AudioStreamFormat(safeHandle);
    }

    public void close() {
        SafeHandle safeHandle = this.formatHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.formatHandle = null;
        }
    }

    public SafeHandle getImpl() {
        return this.formatHandle;
    }
}
