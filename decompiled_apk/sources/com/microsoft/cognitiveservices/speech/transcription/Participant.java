package com.microsoft.cognitiveservices.speech.transcription;

import com.huawei.openalliance.ad.constant.aw;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public final class Participant implements AutoCloseable {
    private String avatar;
    private String displayName;
    private boolean isHost;
    private boolean isMuted;
    private boolean isUsingTts;
    private SafeHandle participantHandle;
    private PropertyCollection propertyHandle;
    private String userId;
    private String voiceSignature;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public Participant(long j) {
        this.participantHandle = null;
        this.participantHandle = new SafeHandle(j, SafeHandleType.Participant);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.participantHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
        StringRef stringRef = new StringRef("");
        Contracts.logErrorIfFail(getUserId(this.participantHandle, stringRef));
        this.userId = stringRef.getValue();
        StringRef stringRef2 = new StringRef("");
        Contracts.logErrorIfFail(getDisplayName(this.participantHandle, stringRef2));
        this.displayName = stringRef2.getValue();
        StringRef stringRef3 = new StringRef("");
        Contracts.logErrorIfFail(getAvatar(this.participantHandle, stringRef3));
        this.avatar = stringRef3.getValue();
        this.isHost = getIsHost(this.participantHandle);
        this.isMuted = getIsMuted(this.participantHandle);
        this.isUsingTts = getIsUsingTts(this.participantHandle);
    }

    private static final native long createParticipantHandle(IntRef intRef, String str, String str2, String str3);

    public static Participant from(String str) {
        Contracts.throwIfNullOrWhitespace(str, aw.r);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createParticipantHandle(intRef, str, null, null));
        return new Participant(intRef.getValue());
    }

    private final native long getAvatar(SafeHandle safeHandle, StringRef stringRef);

    private final native long getDisplayName(SafeHandle safeHandle, StringRef stringRef);

    private final native boolean getIsHost(SafeHandle safeHandle);

    private final native boolean getIsMuted(SafeHandle safeHandle);

    private final native boolean getIsUsingTts(SafeHandle safeHandle);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    private final native long getUserId(SafeHandle safeHandle, StringRef stringRef);

    private final native long setPreferredLanguage(SafeHandle safeHandle, String str);

    private final native long setVoiceSignature(SafeHandle safeHandle, String str);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.participantHandle;
        if (safeHandle != null) {
            safeHandle.close();
        }
        this.participantHandle = null;
        PropertyCollection propertyCollection = this.propertyHandle;
        if (propertyCollection != null) {
            propertyCollection.close();
        }
        this.propertyHandle = null;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.userId;
    }

    public SafeHandle getImpl() {
        return this.participantHandle;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    public boolean isUsingTts() {
        return this.isUsingTts;
    }

    public void setPreferredLanguage(String str) {
        Contracts.throwIfNullOrWhitespace(str, "preferredLanguage");
        Contracts.throwIfFail(setPreferredLanguage(this.participantHandle, str));
    }

    public void setVoiceSignature(String str) {
        Contracts.throwIfNull(str, "voiceSignature");
        Contracts.throwIfFail(setVoiceSignature(this.participantHandle, str));
    }

    public static Participant from(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, aw.r);
        Contracts.throwIfNullOrWhitespace(str2, "preferredLanguage");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createParticipantHandle(intRef, str, str2, null));
        return new Participant(intRef.getValue());
    }

    public static Participant from(String str, String str2, String str3) {
        Contracts.throwIfNullOrWhitespace(str, aw.r);
        Contracts.throwIfNullOrWhitespace(str2, "preferredLanguage");
        Contracts.throwIfNull(str3, "voiceSignature");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createParticipantHandle(intRef, str, str2, str3));
        return new Participant(intRef.getValue());
    }
}
