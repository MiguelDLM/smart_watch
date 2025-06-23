package com.facebook.gamingservices;

import android.content.Context;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;

/* loaded from: classes8.dex */
public class GamingVideoUploader {
    private Context context;

    public GamingVideoUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String caption, Uri videoUri) throws FileNotFoundException {
        uploadToMediaLibrary(caption, videoUri, null);
    }

    public void uploadToMediaLibrary(String caption, Uri videoUri, GraphRequest.OnProgressCallback callback) throws FileNotFoundException {
        uploadToMediaLibrary(caption, videoUri, false, callback);
    }

    public void uploadToMediaLibrary(String caption, Uri videoUri, boolean shouldLaunchMediaDialog, GraphRequest.OnProgressCallback callback) throws FileNotFoundException {
        ShareVideoContent build = new ShareVideoContent.Builder().setVideo(new ShareVideo.Builder().setLocalUrl(videoUri).build()).setContentDescription(caption).build();
        if (shouldLaunchMediaDialog) {
            callback = new OpenGamingMediaDialog(this.context, callback);
        }
        VideoUploader.uploadAsyncWithProgressCallback(build, callback);
    }
}
