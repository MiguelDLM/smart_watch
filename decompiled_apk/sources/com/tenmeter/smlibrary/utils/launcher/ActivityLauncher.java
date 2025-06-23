package com.tenmeter.smlibrary.utils.launcher;

import android.net.Uri;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import java.util.Map;

/* loaded from: classes13.dex */
public class ActivityLauncher {
    private static volatile ActivityLauncher instance;

    public static ActivityLauncher getInstance() {
        if (instance == null) {
            synchronized (ActivityLauncher.class) {
                try {
                    if (instance == null) {
                        instance = new ActivityLauncher();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public Launcher<PickVisualMediaRequest, Uri> pickVisualMedia(ActivityResultRegistry activityResultRegistry) {
        return new LauncherImpl(activityResultRegistry, new ActivityResultContracts.PickVisualMedia());
    }

    public Launcher<String[], Map<String, Boolean>> requestMultiplePermissions(ActivityResultRegistry activityResultRegistry) {
        return new LauncherImpl(activityResultRegistry, new ActivityResultContracts.RequestMultiplePermissions());
    }

    public Launcher<String, Boolean> requestPermission(ActivityResultRegistry activityResultRegistry) {
        return new LauncherImpl(activityResultRegistry, new ActivityResultContracts.RequestPermission());
    }

    public Launcher<Uri, Boolean> takePicture(ActivityResultRegistry activityResultRegistry) {
        return new LauncherImpl(activityResultRegistry, new ActivityResultContracts.TakePicture());
    }
}
