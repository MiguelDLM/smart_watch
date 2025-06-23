package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.OutputFormat;
import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.Recognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class MeetingTranscriber extends Recognizer {
    static Set<MeetingTranscriber> meetingTranscriberObjects = Collections.synchronizedSet(new HashSet());
    public final EventHandlerImpl<MeetingTranscriptionCanceledEventArgs> canceled;
    private PropertyCollection propertyHandle;
    public final EventHandlerImpl<MeetingTranscriptionEventArgs> transcribed;
    public final EventHandlerImpl<MeetingTranscriptionEventArgs> transcribing;

    public MeetingTranscriber() {
        super(null);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfNull(super.getImpl(), "recoHandle");
        Contracts.throwIfFail(createMeetingTranscriberFromConfig(super.getImpl(), null));
        initialize();
    }

    private void canceledEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            MeetingTranscriptionCanceledEventArgs meetingTranscriptionCanceledEventArgs = new MeetingTranscriptionCanceledEventArgs(j, true);
            EventHandlerImpl<MeetingTranscriptionCanceledEventArgs> eventHandlerImpl = this.canceled;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, meetingTranscriptionCanceledEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private final native long createMeetingTranscriberFromConfig(SafeHandle safeHandle, SafeHandle safeHandle2);

    private void initialize() {
        this.transcribing.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.5
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.recognizingSetCallback(this.getImpl().getValue()));
            }
        });
        this.transcribed.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.6
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.recognizedSetCallback(this.getImpl().getValue()));
            }
        });
        this.canceled.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.7
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.canceledSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStarted.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.8
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.sessionStartedSetCallback(this.getImpl().getValue()));
            }
        });
        this.sessionStopped.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.9
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.sessionStoppedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechStartDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.10
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.speechStartDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        this.speechEndDetected.updateNotificationOnConnected(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.11
            @Override // java.lang.Runnable
            public void run() {
                MeetingTranscriber.meetingTranscriberObjects.add(this);
                Contracts.throwIfFail(MeetingTranscriber.this.speechEndDetectedSetCallback(this.getImpl().getValue()));
            }
        });
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromRecognizerHandle(getImpl(), intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long joinMeeting(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long leaveMeeting(SafeHandle safeHandle);

    private void recognizedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            MeetingTranscriptionEventArgs meetingTranscriptionEventArgs = new MeetingTranscriptionEventArgs(j, true);
            EventHandlerImpl<MeetingTranscriptionEventArgs> eventHandlerImpl = this.transcribed;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, meetingTranscriptionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    private void recognizingEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            MeetingTranscriptionEventArgs meetingTranscriptionEventArgs = new MeetingTranscriptionEventArgs(j, true);
            EventHandlerImpl<MeetingTranscriptionEventArgs> eventHandlerImpl = this.transcribing;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, meetingTranscriptionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.microsoft.cognitiveservices.speech.Recognizer
    public void dispose(boolean z) {
        if (!this.disposed && z) {
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            meetingTranscriberObjects.remove(this);
            super.dispose(z);
        }
    }

    public OutputFormat getOutputFormat() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceResponse_RequestDetailedResultTrueFalse).equals("true") ? OutputFormat.Detailed : OutputFormat.Simple;
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public String getSpeechRecognitionLanguage() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceConnection_RecoLanguage);
    }

    public Future<Void> joinMeetingAsync(final Meeting meeting) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        this.joinMeeting(MeetingTranscriber.this.getImpl(), meeting.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> leaveMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        this.leaveMeeting(MeetingTranscriber.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> startTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.3
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        this.startContinuousRecognition(MeetingTranscriber.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> stopTranscribingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncRecognitionAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriber.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        this.stopContinuousRecognition(MeetingTranscriber.this.getImpl());
                    }
                });
                return null;
            }
        });
    }

    public MeetingTranscriber(AudioConfig audioConfig) {
        super(audioConfig);
        this.transcribing = new EventHandlerImpl<>(this.eventCounter);
        this.transcribed = new EventHandlerImpl<>(this.eventCounter);
        this.canceled = new EventHandlerImpl<>(this.eventCounter);
        this.propertyHandle = null;
        Contracts.throwIfFail(audioConfig == null ? createMeetingTranscriberFromConfig(super.getImpl(), null) : createMeetingTranscriberFromConfig(super.getImpl(), audioConfig.getImpl()));
        initialize();
    }
}
