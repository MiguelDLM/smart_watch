package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.math.BigInteger;

/* loaded from: classes11.dex */
public final class VoiceProfileEnrollmentResult implements AutoCloseable {
    private BigInteger audioLength;
    private BigInteger audioSpeechLength;
    private String createdTime;
    private int enrollmentsCount;
    private BigInteger enrollmentsLength;
    private BigInteger enrollmentsSpeechLength;
    private String lastUpdatedDateTime;
    private String profileId;
    private PropertyCollection properties;
    private ResultReason reason;
    private int remainingEnrollmentsCount;
    private BigInteger remainingEnrollmentsSpeechLength;
    private SafeHandle resultHandle;
    private String resultId;

    public VoiceProfileEnrollmentResult(long j) {
        this.resultHandle = null;
        this.properties = null;
        this.resultId = "";
        this.profileId = "";
        this.enrollmentsCount = 0;
        this.remainingEnrollmentsCount = 0;
        this.createdTime = "";
        this.lastUpdatedDateTime = "";
        this.resultHandle = new SafeHandle(j, SafeHandleType.VoiceProfileEnrollmentResult);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(this.resultHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getResultReason(this.resultHandle, intRef));
        this.reason = ResultReason.values()[(int) intRef.getValue()];
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromResult(this.resultHandle, intRef2));
        PropertyCollection propertyCollection = new PropertyCollection(intRef2);
        this.properties = propertyCollection;
        this.profileId = propertyCollection.getProperty("enrollment.profileId");
        String property = this.properties.getProperty("enrollment.enrollmentsCount");
        this.enrollmentsCount = property.isEmpty() ? 0 : Integer.parseInt(property);
        String property2 = this.properties.getProperty("enrollment.remainingEnrollmentsCount");
        this.remainingEnrollmentsCount = property2.isEmpty() ? 0 : Integer.parseInt(property2);
        String property3 = this.properties.getProperty("enrollment.enrollmentsLengthInSec");
        this.enrollmentsLength = property3.isEmpty() ? BigInteger.ZERO : new BigInteger(property3);
        String property4 = this.properties.getProperty("enrollment.remainingEnrollmentsSpeechLengthInSec");
        this.remainingEnrollmentsSpeechLength = property4.isEmpty() ? BigInteger.ZERO : new BigInteger(property4);
        String property5 = this.properties.getProperty("enrollment.audioLengthInSec");
        this.audioLength = property5.isEmpty() ? BigInteger.ZERO : new BigInteger(property5);
        String property6 = this.properties.getProperty("enrollment.audioSpeechLengthInSec");
        this.audioSpeechLength = property6.isEmpty() ? BigInteger.ZERO : new BigInteger(property6);
        String property7 = this.properties.getProperty("enrollment.enrollmentsSpeechLengthInSec");
        this.enrollmentsSpeechLength = property7.isEmpty() ? BigInteger.ZERO : new BigInteger(property7);
        this.createdTime = this.properties.getProperty("enrollment.createdDateTime");
        this.lastUpdatedDateTime = this.properties.getProperty("enrollment.lastUpdatedDateTime");
    }

    private final native long getPropertyBagFromResult(SafeHandle safeHandle, IntRef intRef);

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getResultReason(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        PropertyCollection propertyCollection = this.properties;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.properties = null;
        }
        SafeHandle safeHandle = this.resultHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.resultHandle = null;
        }
    }

    public BigInteger getAudioLength() {
        return this.audioLength;
    }

    public BigInteger getAudioSpeechLength() {
        return this.audioSpeechLength;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public int getEnrollmentsCount() {
        return this.enrollmentsCount;
    }

    public BigInteger getEnrollmentsLength() {
        return this.enrollmentsLength;
    }

    public BigInteger getEnrollmentsSpeechLength() {
        return this.enrollmentsSpeechLength;
    }

    public SafeHandle getImpl() {
        Contracts.throwIfNull(this.resultHandle, "result");
        return this.resultHandle;
    }

    public String getLastUpdatedDateTime() {
        return this.lastUpdatedDateTime;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public PropertyCollection getProperties() {
        return this.properties;
    }

    public ResultReason getReason() {
        return this.reason;
    }

    public int getRemainingEnrollmentsCount() {
        return this.remainingEnrollmentsCount;
    }

    public BigInteger getRemainingEnrollmentsSpeechLength() {
        return this.remainingEnrollmentsSpeechLength;
    }

    public String getResultId() {
        return this.resultId;
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Reason:" + getReason() + " Json:" + this.properties.getProperty(PropertyId.SpeechServiceResponse_JsonResult);
    }
}
