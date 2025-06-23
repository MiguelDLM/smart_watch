package com.microsoft.cognitiveservices.speech.dialog;

import com.microsoft.cognitiveservices.speech.audio.PullAudioOutputStream;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class ActivityReceivedEventArgs {
    private String activity;
    private SafeHandle activityReceivedEventHandle;
    private boolean hasAudio;

    public ActivityReceivedEventArgs(long j) {
        this.activityReceivedEventHandle = null;
        this.activity = "";
        this.hasAudio = false;
        Contracts.throwIfNull(j, "eventArgs");
        this.activityReceivedEventHandle = new SafeHandle(j, SafeHandleType.ActivityReceivedEvent);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getActivity(this.activityReceivedEventHandle, stringRef));
        this.activity = stringRef.getValue();
        this.hasAudio = hasAudio(this.activityReceivedEventHandle);
    }

    private final native long getActivity(SafeHandle safeHandle, StringRef stringRef);

    private final native long getAudio(SafeHandle safeHandle, IntRef intRef);

    private final native boolean hasAudio(SafeHandle safeHandle);

    public String getActivity() {
        return this.activity;
    }

    public PullAudioOutputStream getAudio() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getAudio(this.activityReceivedEventHandle, intRef));
        return new PullAudioOutputStream(intRef);
    }

    public boolean hasAudio() {
        return this.hasAudio;
    }
}
