package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes8.dex */
public class GamingImageUploader {
    private static final String photoUploadEdge = "me/photos";
    private Context context;

    public GamingImageUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String caption, Bitmap imageBitmap, boolean shouldLaunchMediaDialog) {
        uploadToMediaLibrary(caption, imageBitmap, shouldLaunchMediaDialog, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String caption, Bitmap imageBitmap, boolean shouldLaunchMediaDialog, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, imageBitmap, caption, (Bundle) null, shouldLaunchMediaDialog ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String caption, File imageFile, boolean shouldLaunchMediaDialog) throws FileNotFoundException {
        uploadToMediaLibrary(caption, imageFile, shouldLaunchMediaDialog, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String caption, File imageFile, boolean shouldLaunchMediaDialog, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, imageFile, caption, (Bundle) null, shouldLaunchMediaDialog ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String caption, Uri imageUri, boolean shouldLaunchMediaDialog) throws FileNotFoundException {
        uploadToMediaLibrary(caption, imageUri, shouldLaunchMediaDialog, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String caption, Uri imageUri, boolean shouldLaunchMediaDialog, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, imageUri, caption, (Bundle) null, shouldLaunchMediaDialog ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }
}
