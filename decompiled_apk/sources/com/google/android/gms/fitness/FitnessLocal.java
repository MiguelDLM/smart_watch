package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public class FitnessLocal {
    private FitnessLocal() {
    }

    @NonNull
    public static LocalRecordingClient getLocalRecordingClient(@NonNull Activity activity) {
        return new LocalRecordingClient(activity);
    }

    @NonNull
    public static LocalRecordingClient getLocalRecordingClient(@NonNull Context context) {
        return new LocalRecordingClient(context);
    }
}
