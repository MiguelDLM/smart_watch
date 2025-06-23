package com.microsoft.cognitiveservices.speech.audio;

import android.content.Context;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.ContextHolder;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class AudioProcessingOptions implements AutoCloseable {
    private SafeHandle audioProcessingOptionsHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public AudioProcessingOptions(IntRef intRef) {
        this.audioProcessingOptionsHandle = null;
        Contracts.throwIfNull(intRef, "audioProcessingOptions");
        SafeHandle safeHandle = new SafeHandle(intRef.getValue(), SafeHandleType.AudioProcessingOptions);
        this.audioProcessingOptionsHandle = safeHandle;
        Contracts.throwIfFail(extractAssets(safeHandle, ContextHolder.getInstance().getContext()));
    }

    private static final native long create(IntRef intRef, int i);

    public static AudioProcessingOptions create(int i) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(create(intRef, i));
        return new AudioProcessingOptions(intRef);
    }

    private static final native long createFromMicrophoneArrayGeometry(IntRef intRef, int i, MicrophoneArrayGeometry microphoneArrayGeometry, int i2);

    private static final native long createFromPresetMicrophoneArrayGeometry(IntRef intRef, int i, int i2, int i3);

    private final native long extractAssets(SafeHandle safeHandle, Context context);

    private final native long getAudioProcessingFlags(SafeHandle safeHandle, IntRef intRef);

    private final native long getBeamformingEndAngle(SafeHandle safeHandle, IntRef intRef);

    private final native long getBeamformingStartAngle(SafeHandle safeHandle, IntRef intRef);

    private final native long getMicrophoneArrayType(SafeHandle safeHandle, IntRef intRef);

    private final native MicrophoneCoordinates[] getMicrophoneCoordinates(SafeHandle safeHandle, IntRef intRef);

    private final native long getPresetMicrophoneArrayGeometry(SafeHandle safeHandle, IntRef intRef);

    private final native long getSpeakerReferenceChannel(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.audioProcessingOptionsHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.audioProcessingOptionsHandle = null;
        }
    }

    public int getAudioProcessingFlags() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getAudioProcessingFlags(this.audioProcessingOptionsHandle, intRef));
        return (int) intRef.getValue();
    }

    public int getBeamformingEndAngle() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getBeamformingEndAngle(this.audioProcessingOptionsHandle, intRef));
        return (int) intRef.getValue();
    }

    public int getBeamformingStartAngle() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getBeamformingStartAngle(this.audioProcessingOptionsHandle, intRef));
        return (int) intRef.getValue();
    }

    public SafeHandle getImpl() {
        return this.audioProcessingOptionsHandle;
    }

    public MicrophoneArrayType getMicrophoneArrayType() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getMicrophoneArrayType(this.audioProcessingOptionsHandle, intRef));
        return MicrophoneArrayType.values()[(int) intRef.getValue()];
    }

    public MicrophoneCoordinates[] getMicrophoneCoordinates() {
        IntRef intRef = new IntRef(0L);
        MicrophoneCoordinates[] microphoneCoordinates = getMicrophoneCoordinates(this.audioProcessingOptionsHandle, intRef);
        Contracts.throwIfFail(intRef.getValue());
        return microphoneCoordinates;
    }

    public PresetMicrophoneArrayGeometry getPresetMicrophoneArrayGeometry() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPresetMicrophoneArrayGeometry(this.audioProcessingOptionsHandle, intRef));
        return PresetMicrophoneArrayGeometry.values()[(int) intRef.getValue()];
    }

    public SpeakerReferenceChannel getSpeakerReferenceChannel() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getSpeakerReferenceChannel(this.audioProcessingOptionsHandle, intRef));
        return SpeakerReferenceChannel.values()[(int) intRef.getValue()];
    }

    public static AudioProcessingOptions create(int i, MicrophoneArrayGeometry microphoneArrayGeometry) {
        return create(i, microphoneArrayGeometry, SpeakerReferenceChannel.None);
    }

    public static AudioProcessingOptions create(int i, MicrophoneArrayGeometry microphoneArrayGeometry, SpeakerReferenceChannel speakerReferenceChannel) {
        Contracts.throwIfNull(microphoneArrayGeometry, "microphoneArrayGeometry");
        Contracts.throwIfNull(speakerReferenceChannel, "speakerReferenceChannel");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromMicrophoneArrayGeometry(intRef, i, microphoneArrayGeometry, speakerReferenceChannel.ordinal()));
        return new AudioProcessingOptions(intRef);
    }

    public static AudioProcessingOptions create(int i, PresetMicrophoneArrayGeometry presetMicrophoneArrayGeometry) {
        return create(i, presetMicrophoneArrayGeometry, SpeakerReferenceChannel.None);
    }

    public static AudioProcessingOptions create(int i, PresetMicrophoneArrayGeometry presetMicrophoneArrayGeometry, SpeakerReferenceChannel speakerReferenceChannel) {
        Contracts.throwIfNull(presetMicrophoneArrayGeometry, "microphoneArrayGeometry");
        Contracts.throwIfNull(speakerReferenceChannel, "speakerReferenceChannel");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromPresetMicrophoneArrayGeometry(intRef, i, presetMicrophoneArrayGeometry.ordinal(), speakerReferenceChannel.ordinal()));
        return new AudioProcessingOptions(intRef);
    }
}
