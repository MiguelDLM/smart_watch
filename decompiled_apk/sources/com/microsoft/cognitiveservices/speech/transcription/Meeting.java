package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public final class Meeting implements AutoCloseable {
    private SafeHandle meetingHandle;
    private PropertyCollection propertyHandle;
    private boolean disposed = false;
    private final Object meetingLock = new Object();
    private int activeAsyncMeetingCounter = 0;

    public Meeting(long j) {
        this.meetingHandle = new SafeHandle(j, SafeHandleType.Meeting);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.meetingHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long addParticipant(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long addParticipantByUser(SafeHandle safeHandle, SafeHandle safeHandle2);

    public static Future<Meeting> createMeetingAsync(final SpeechConfig speechConfig) {
        Contracts.throwIfNull(speechConfig, "speechConfig");
        AsyncThreadService.initialize();
        return AsyncThreadService.submit(new Callable<Meeting>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Meeting call() {
                IntRef intRef = new IntRef(0L);
                Contracts.throwIfFail(Meeting.createMeetingFromConfig(intRef, SpeechConfig.this.getImpl(), ""));
                return new Meeting(intRef.getValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native long createMeetingFromConfig(IntRef intRef, SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long deleteMeeting(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public void doAsyncMeetingAction(Runnable runnable) {
        synchronized (this.meetingLock) {
            this.activeAsyncMeetingCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(Meeting.class.getName());
        }
        try {
            runnable.run();
            synchronized (this.meetingLock) {
                this.activeAsyncMeetingCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.meetingLock) {
                this.activeAsyncMeetingCounter--;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long endMeeting(SafeHandle safeHandle);

    private final native long getMeetingId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long lockMeeting(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long muteAll(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long muteParticipant(SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipant(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipantByUser(SafeHandle safeHandle, SafeHandle safeHandle2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long removeParticipantByUserId(SafeHandle safeHandle, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long startMeeting(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unlockMeeting(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unmuteAll(SafeHandle safeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long unmuteParticipant(SafeHandle safeHandle, String str);

    public Future<Participant> addParticipantAsync(final Participant participant) {
        return AsyncThreadService.submit(new Callable<Participant>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Participant call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.addParticipant(meeting.meetingHandle, participant.getImpl()));
                    }
                });
                return participant;
            }
        });
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.meetingLock) {
            try {
                if (this.activeAsyncMeetingCounter != 0) {
                    throw new IllegalStateException("Cannot dispose a recognizer while async recognition is running. Await async recognitions to avoid unexpected disposals.");
                }
                dispose(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Future<Void> deleteMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.11
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.deleteMeeting(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public void dispose(boolean z) {
        if (!this.disposed && z) {
            SafeHandle safeHandle = this.meetingHandle;
            if (safeHandle != null) {
                safeHandle.close();
                this.meetingHandle = null;
            }
            PropertyCollection propertyCollection = this.propertyHandle;
            if (propertyCollection != null) {
                propertyCollection.close();
                this.propertyHandle = null;
            }
            AsyncThreadService.shutdown();
            this.disposed = true;
        }
    }

    public Future<Void> endMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.9
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.endMeeting(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public String getAuthorizationToken() {
        return this.propertyHandle.getProperty(PropertyId.SpeechServiceAuthorization_Token);
    }

    public SafeHandle getImpl() {
        return this.meetingHandle;
    }

    public String getMeetingId() {
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getMeetingId(this.meetingHandle, stringRef));
        return stringRef.getValue();
    }

    public PropertyCollection getProperties() {
        return this.propertyHandle;
    }

    public Future<Void> lockMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.12
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.lockMeeting(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> muteAllParticipantsAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.14
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.muteAll(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> muteParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.16
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.muteParticipant(meeting.meetingHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> removeParticipantAsync(final Participant participant) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.7
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.removeParticipant(meeting.meetingHandle, participant.getImpl()));
                    }
                });
                return null;
            }
        });
    }

    public void setAuthorizationToken(String str) {
        Contracts.throwIfNullOrWhitespace(str, "token");
        this.propertyHandle.setProperty(PropertyId.SpeechServiceAuthorization_Token, str);
    }

    public Future<Void> startMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.10
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.startMeeting(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unlockMeetingAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.13
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.unlockMeeting(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unmuteAllParticipantsAsync() {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.15
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.unmuteAll(meeting.meetingHandle));
                    }
                });
                return null;
            }
        });
    }

    public Future<Void> unmuteParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.17
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.unmuteParticipant(meeting.meetingHandle, str));
                    }
                });
                return null;
            }
        });
    }

    public static Future<Meeting> createMeetingAsync(final SpeechConfig speechConfig, final String str) {
        Contracts.throwIfNull(speechConfig, "speechConfig");
        Contracts.throwIfNull(str, "meetingId");
        AsyncThreadService.initialize();
        return AsyncThreadService.submit(new Callable<Meeting>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Meeting call() {
                IntRef intRef = new IntRef(0L);
                Contracts.throwIfFail(Meeting.createMeetingFromConfig(intRef, SpeechConfig.this.getImpl(), str));
                return new Meeting(intRef.getValue());
            }
        });
    }

    public Future<User> addParticipantAsync(final User user) {
        return AsyncThreadService.submit(new Callable<User>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public User call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.addParticipantByUser(meeting.meetingHandle, user.getImpl()));
                    }
                });
                return user;
            }
        });
    }

    public Future<Void> removeParticipantAsync(final User user) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.removeParticipantByUser(meeting.meetingHandle, user.getImpl()));
                    }
                });
                return null;
            }
        });
    }

    public Future<Participant> addParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Participant>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Participant call() {
                final Participant[] participantArr = new Participant[1];
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Participant from = Participant.from(str);
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.addParticipant(meeting.meetingHandle, from.getImpl()));
                        participantArr[0] = from;
                    }
                });
                return participantArr[0];
            }
        });
    }

    public Future<Void> removeParticipantAsync(final String str) {
        return AsyncThreadService.submit(new Callable<Void>() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.8
            @Override // java.util.concurrent.Callable
            public Void call() {
                this.doAsyncMeetingAction(new Runnable() { // from class: com.microsoft.cognitiveservices.speech.transcription.Meeting.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Meeting meeting = Meeting.this;
                        Contracts.throwIfFail(meeting.removeParticipantByUserId(meeting.meetingHandle, str));
                    }
                });
                return null;
            }
        });
    }
}
