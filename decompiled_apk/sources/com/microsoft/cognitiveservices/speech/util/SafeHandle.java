package com.microsoft.cognitiveservices.speech.util;

/* loaded from: classes11.dex */
public class SafeHandle implements AutoCloseable {
    private SafeHandleType handleType;
    private long value;

    public SafeHandle(long j, SafeHandleType safeHandleType) {
        this.value = 0L;
        SafeHandleType safeHandleType2 = SafeHandleType.UnInitialized;
        this.value = j;
        this.handleType = safeHandleType;
    }

    private final native long releaseActivityReceivedEventHandle(long j);

    private final native long releaseAudioConfigHandle(long j);

    private final native long releaseAudioDataStreamHandle(long j);

    private final native long releaseAudioInputStreamHandle(long j);

    private final native long releaseAudioOutputStreamHandle(long j);

    private final native long releaseAudioProcessingOptionsHandle(long j);

    private final native long releaseAudioStreamFormatHandle(long j);

    private final native long releaseAutoDetectSourceLanguageConfigHandle(long j);

    private final native long releaseConnectionHandle(long j);

    private final native long releaseConnectionMessageEventHandle(long j);

    private final native long releaseConnectionMessageHandle(long j);

    private final native long releaseConversationHandle(long j);

    private final native long releaseConversationTranslatorHandle(long j);

    private final native long releaseDialogServiceConnectorHandle(long j);

    private final native long releaseEventHandle(long j);

    private final native long releaseEventLoggerCallbackHandle(long j);

    private final native long releaseGrammarHandle(long j);

    private final native long releaseIntentTriggerHandle(long j);

    private final native long releaseJsonBuilderHandle(long j);

    private final native long releaseJsonValueHandle(long j);

    private final native long releaseKeywordModelHandle(long j);

    private final native long releaseKeywordRecognizerHandle(long j);

    private final native long releaseLanguageUnderstandingModelHandle(long j);

    private final native long releaseMeetingHandle(long j);

    private final native long releaseParticipantHandle(long j);

    private final native long releasePronunciationAssessmentConfig(long j);

    private final native long releasePropertyHandle(long j);

    private final native long releaseRecognizerHandle(long j);

    private final native long releaseRecognizerResultHandle(long j);

    private final native long releaseSourceLanguageConfigHandle(long j);

    private final native long releaseSpeakerIdentificationModelHandle(long j);

    private final native long releaseSpeakerRecognitionResultHandle(long j);

    private final native long releaseSpeakerRecognizerHandle(long j);

    private final native long releaseSpeakerVerificationModelHandle(long j);

    private final native long releaseSpeechConfigHandle(long j);

    private final native long releaseSpeechRecognitionModelHandle(long j);

    private final native long releaseSpeechTranslationModelHandle(long j);

    private final native long releaseSynthesisEventHandle(long j);

    private final native long releaseSynthesisResultHandle(long j);

    private final native long releaseSynthesizerHandle(long j);

    private final native long releaseTranslationSynthesisHandle(long j);

    private final native long releaseTurnStatusReceivedEventHandle(long j);

    private final native long releaseUserHandle(long j);

    private final native long releaseVoiceInfoHandle(long j);

    private final native long releaseVoiceProfileClientHandle(long j);

    private final native long releaseVoiceProfileEnrollmentResultHandle(long j);

    private final native long releaseVoiceProfileHandle(long j);

    private final native long releaseVoiceProfilePhraseResultHandle(long j);

    private final native long releaseVoiceProfileResultHandle(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.value;
        if (j != 0) {
            SafeHandleType safeHandleType = this.handleType;
            if (safeHandleType == SafeHandleType.Event) {
                releaseEventHandle(j);
            } else if (safeHandleType == SafeHandleType.Recognizer) {
                releaseRecognizerHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeechConfig) {
                releaseSpeechConfigHandle(j);
            } else if (safeHandleType == SafeHandleType.PropertyCollection) {
                releasePropertyHandle(j);
            } else if (safeHandleType == SafeHandleType.RecognitionResult) {
                releaseRecognizerResultHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioConfig) {
                releaseAudioConfigHandle(j);
            } else if (safeHandleType == SafeHandleType.Connection) {
                releaseConnectionHandle(j);
            } else if (safeHandleType == SafeHandleType.ConnectionMessage) {
                releaseConnectionMessageHandle(j);
            } else if (safeHandleType == SafeHandleType.ConnectionMessageEvent) {
                releaseConnectionMessageEventHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioInputStream) {
                releaseAudioInputStreamHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioStreamFormat) {
                releaseAudioStreamFormatHandle(j);
            } else if (safeHandleType == SafeHandleType.KeywordModel) {
                releaseKeywordModelHandle(j);
            } else if (safeHandleType == SafeHandleType.LanguageUnderstandingModel) {
                releaseLanguageUnderstandingModelHandle(j);
            } else if (safeHandleType == SafeHandleType.IntentTrigger) {
                releaseIntentTriggerHandle(j);
            } else if (safeHandleType == SafeHandleType.User) {
                releaseUserHandle(j);
            } else if (safeHandleType == SafeHandleType.Participant) {
                releaseParticipantHandle(j);
            } else if (safeHandleType == SafeHandleType.Conversation) {
                releaseConversationHandle(j);
            } else if (safeHandleType == SafeHandleType.Meeting) {
                releaseMeetingHandle(j);
            } else if (safeHandleType == SafeHandleType.DialogServiceConnector) {
                releaseDialogServiceConnectorHandle(j);
            } else if (safeHandleType == SafeHandleType.TurnStatusReceivedEvent) {
                releaseTurnStatusReceivedEventHandle(j);
            } else if (safeHandleType == SafeHandleType.ActivityReceivedEvent) {
                releaseActivityReceivedEventHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioOutputStream) {
                releaseAudioOutputStreamHandle(j);
            } else if (safeHandleType == SafeHandleType.AutoDetectSourceLanguageConfig) {
                releaseAutoDetectSourceLanguageConfigHandle(j);
            } else if (safeHandleType == SafeHandleType.SourceLanguageConfig) {
                releaseSourceLanguageConfigHandle(j);
            } else if (safeHandleType == SafeHandleType.SynthesisEvent) {
                releaseSynthesisEventHandle(j);
            } else if (safeHandleType == SafeHandleType.SynthesisResult) {
                releaseSynthesisResultHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceInfo) {
                releaseVoiceInfoHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioDataStream) {
                releaseAudioDataStreamHandle(j);
            } else if (safeHandleType == SafeHandleType.Synthesizer) {
                releaseSynthesizerHandle(j);
            } else if (safeHandleType == SafeHandleType.Grammar) {
                releaseGrammarHandle(j);
            } else if (safeHandleType == SafeHandleType.TranslationSynthesis) {
                releaseTranslationSynthesisHandle(j);
            } else if (safeHandleType == SafeHandleType.ConversationTranslator) {
                releaseConversationTranslatorHandle(j);
            } else if (safeHandleType == SafeHandleType.KeywordRecognizer) {
                releaseKeywordRecognizerHandle(j);
            } else if (safeHandleType == SafeHandleType.PronunciationAssessmentConfig) {
                releasePronunciationAssessmentConfig(j);
            } else if (safeHandleType == SafeHandleType.SpeakerRecognizer) {
                releaseSpeakerRecognizerHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeakerIdentificationModel) {
                releaseSpeakerIdentificationModelHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeakerRecognitionResult) {
                releaseSpeakerRecognitionResultHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeakerVerificationModel) {
                releaseSpeakerVerificationModelHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceProfileResult) {
                releaseVoiceProfileResultHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceProfileEnrollmentResult) {
                releaseVoiceProfileEnrollmentResultHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceProfilePhraseResult) {
                releaseVoiceProfilePhraseResultHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceProfileClient) {
                releaseVoiceProfileClientHandle(j);
            } else if (safeHandleType == SafeHandleType.VoiceProfile) {
                releaseVoiceProfileHandle(j);
            } else if (safeHandleType == SafeHandleType.AudioProcessingOptions) {
                releaseAudioProcessingOptionsHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeechRecognitionModel) {
                releaseSpeechRecognitionModelHandle(j);
            } else if (safeHandleType == SafeHandleType.SpeechTranslationModel) {
                releaseSpeechTranslationModelHandle(j);
            } else if (safeHandleType == SafeHandleType.JSONVALUE) {
                releaseJsonValueHandle(j);
            } else if (safeHandleType == SafeHandleType.JSONBUILDER) {
                releaseJsonBuilderHandle(j);
            } else if (safeHandleType == SafeHandleType.EventLoggerCallback) {
                releaseEventLoggerCallbackHandle(j);
            } else {
                System.out.println("Java SafeHandle close, invalid handle value: " + String.valueOf(this.value));
            }
            this.value = 0L;
            this.handleType = SafeHandleType.UnInitialized;
        }
    }

    public void finalize() throws Throwable {
        close();
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
