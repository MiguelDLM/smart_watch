package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class JNIVoicePersonalityControl {
    public static JNIVoicePersonalityControl sInstance = new JNIVoicePersonalityControl();

    private JNIVoicePersonalityControl() {
    }

    public native boolean CopyMaiDouPath(String str);

    public native boolean appendTaskToTaskArray(String str, boolean z);

    public native boolean getDownloadVoiceInfo(String str, Bundle bundle);

    public native boolean getDownloadVoiceTask(ArrayList<Bundle> arrayList);

    public native boolean getNeedUnZipVoiceIdTable(ArrayList<String> arrayList);

    public native boolean getNewVoiceInfo(ArrayList<Bundle> arrayList);

    public native boolean getRecordVoiceItems(String str, ArrayList<Bundle> arrayList);

    public native String getTaskFilePath(String str, boolean z);

    public native String getTaskFilePathWithWord(String str, String str2);

    public native boolean getVoiceInfo(String str, Bundle bundle, String str2);

    public native boolean isTaskDowned(String str, VoiceDataStatus voiceDataStatus);

    public native boolean mergeAndUpdateVoiceFile();

    public native boolean pauseTask(String str);

    public boolean removeTask(String str) {
        return removeTask(str, 0);
    }

    public native boolean removeTask(String str, int i);

    public native boolean resumeTask(String str);

    public native boolean triggerUpdateVoiceData(boolean z);

    public native boolean updateTaskToServer(String str, String str2);
}
