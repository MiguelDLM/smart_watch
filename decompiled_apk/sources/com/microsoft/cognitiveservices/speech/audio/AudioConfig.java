package com.microsoft.cognitiveservices.speech.audio;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bn;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class AudioConfig implements AutoCloseable {
    private SafeHandle audioConfigHandle;
    private boolean closeKeepAliveOnClose;
    private AudioInputStream inputStreamKeepAlive;
    private AudioOutputStream outputStreamKeepAlive;
    private PropertyCollection propertyHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public AudioConfig(IntRef intRef) {
        this.audioConfigHandle = null;
        this.inputStreamKeepAlive = null;
        this.outputStreamKeepAlive = null;
        this.closeKeepAliveOnClose = false;
        this.propertyHandle = null;
        Contracts.throwIfNull(intRef, "config");
        this.audioConfigHandle = new SafeHandle(intRef.getValue(), SafeHandleType.AudioConfig);
        this.inputStreamKeepAlive = null;
        this.outputStreamKeepAlive = null;
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.audioConfigHandle, intRef2));
        this.propertyHandle = new PropertyCollection(intRef2);
    }

    private static final native long createAudioInputFromDefaultMicrophone(IntRef intRef, SafeHandle safeHandle);

    private static final native long createAudioInputFromMicrophoneInput(IntRef intRef, String str, SafeHandle safeHandle);

    private static final native long createAudioInputFromStream(IntRef intRef, SafeHandle safeHandle, SafeHandle safeHandle2);

    private static final native long createAudioInputFromWavFileName(IntRef intRef, String str, SafeHandle safeHandle);

    private static final native long createAudioOutputFromDefaultSpeaker(IntRef intRef);

    private static final native long createAudioOutputFromSpeakerOutput(IntRef intRef, String str);

    private static final native long createAudioOutputFromStream(IntRef intRef, SafeHandle safeHandle);

    private static final native long createAudioOutputFromWavFileName(IntRef intRef, String str);

    public static AudioConfig fromDefaultMicrophoneInput() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromDefaultMicrophone(intRef, null));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromDefaultSpeakerOutput() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioOutputFromDefaultSpeaker(intRef));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromMicrophoneInput(String str) {
        Contracts.throwIfNull(str, "deviceName");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromMicrophoneInput(intRef, str, null));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromSpeakerOutput(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioOutputFromSpeakerOutput(intRef, str));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromStreamInput(AudioInputStream audioInputStream) {
        Contracts.throwIfNull(audioInputStream, "audioStream");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromStream(intRef, audioInputStream.getImpl(), null));
        return new AudioConfig(intRef, audioInputStream);
    }

    public static AudioConfig fromStreamOutput(AudioOutputStream audioOutputStream) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioOutputFromStream(intRef, audioOutputStream.getImpl()));
        return new AudioConfig(intRef, audioOutputStream);
    }

    public static AudioConfig fromWavFileInput(String str) {
        Contracts.throwIfNull(str, TTDownloadField.TT_FILE_NAME);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromWavFileName(intRef, str, null));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromWavFileOutput(String str) {
        Contracts.throwIfNull(str, TTDownloadField.TT_FILE_NAME);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioOutputFromWavFileName(intRef, str));
        return new AudioConfig(intRef);
    }

    private final native long getAudioProcessingOptions(SafeHandle safeHandle, IntRef intRef);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        AudioInputStream audioInputStream = this.inputStreamKeepAlive;
        if (audioInputStream != null && this.closeKeepAliveOnClose) {
            audioInputStream.close();
        }
        this.inputStreamKeepAlive = null;
        PropertyCollection propertyCollection = this.propertyHandle;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.propertyHandle = null;
        }
        SafeHandle safeHandle = this.audioConfigHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.audioConfigHandle = null;
        }
    }

    public AudioProcessingOptions getAudioProcessingOptions() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getAudioProcessingOptions(this.audioConfigHandle, intRef));
        return new AudioProcessingOptions(intRef);
    }

    public SafeHandle getImpl() {
        return this.audioConfigHandle;
    }

    public void setProperty(PropertyId propertyId, String str) {
        this.propertyHandle.setProperty(propertyId, str);
    }

    public AudioConfig(IntRef intRef, AudioInputStream audioInputStream) {
        this(intRef);
        this.inputStreamKeepAlive = audioInputStream;
    }

    public static AudioConfig fromDefaultMicrophoneInput(AudioProcessingOptions audioProcessingOptions) {
        Contracts.throwIfNull(audioProcessingOptions, "audioProcessingOptions");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromDefaultMicrophone(intRef, audioProcessingOptions.getImpl()));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromMicrophoneInput(String str, AudioProcessingOptions audioProcessingOptions) {
        Contracts.throwIfNull(str, "deviceName");
        Contracts.throwIfNull(audioProcessingOptions, "audioProcessingOptions");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromMicrophoneInput(intRef, str, audioProcessingOptions.getImpl()));
        return new AudioConfig(intRef);
    }

    public static AudioConfig fromStreamInput(AudioInputStream audioInputStream, AudioProcessingOptions audioProcessingOptions) {
        Contracts.throwIfNull(audioInputStream, "audioStream");
        Contracts.throwIfNull(audioProcessingOptions, "audioProcessingOptions");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromStream(intRef, audioInputStream.getImpl(), audioProcessingOptions.getImpl()));
        return new AudioConfig(intRef, audioInputStream);
    }

    public static AudioConfig fromWavFileInput(String str, AudioProcessingOptions audioProcessingOptions) {
        Contracts.throwIfNull(str, TTDownloadField.TT_FILE_NAME);
        Contracts.throwIfNull(audioProcessingOptions, "audioProcessingOptions");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromWavFileName(intRef, str, audioProcessingOptions.getImpl()));
        return new AudioConfig(intRef);
    }

    public void setProperty(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, "name");
        this.propertyHandle.setProperty(str, str2);
    }

    public AudioConfig(IntRef intRef, AudioOutputStream audioOutputStream) {
        this(intRef);
        this.outputStreamKeepAlive = audioOutputStream;
    }

    public static AudioConfig fromStreamInput(PullAudioInputStreamCallback pullAudioInputStreamCallback) {
        Contracts.throwIfNull(pullAudioInputStreamCallback, bn.f.L);
        PullAudioInputStream create = PullAudioInputStream.create(pullAudioInputStreamCallback);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromStream(intRef, create.getImpl(), null));
        AudioConfig audioConfig = new AudioConfig(intRef, create);
        audioConfig.closeKeepAliveOnClose = true;
        return audioConfig;
    }

    public static AudioConfig fromStreamInput(PullAudioInputStreamCallback pullAudioInputStreamCallback, AudioProcessingOptions audioProcessingOptions) {
        Contracts.throwIfNull(pullAudioInputStreamCallback, bn.f.L);
        Contracts.throwIfNull(audioProcessingOptions, "audioProcessingOptions");
        PullAudioInputStream create = PullAudioInputStream.create(pullAudioInputStreamCallback);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createAudioInputFromStream(intRef, create.getImpl(), audioProcessingOptions.getImpl()));
        AudioConfig audioConfig = new AudioConfig(intRef, create);
        audioConfig.closeKeepAliveOnClose = true;
        return audioConfig;
    }
}
