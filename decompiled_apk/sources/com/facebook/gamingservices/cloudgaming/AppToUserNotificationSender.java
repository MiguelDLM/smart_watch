package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes8.dex */
public abstract class AppToUserNotificationSender {
    private static Bundle getParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("upload_source", "A2U");
        return bundle;
    }

    public static void scheduleAppToUserNotification(String title, String body, Bitmap media, int timeInterval, @Nullable String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }

    public static void scheduleAppToUserNotification(String title, String body, File media, int timeInterval, @Nullable String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }

    public static void scheduleAppToUserNotification(String title, String body, Uri media, int timeInterval, @Nullable String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }
}
