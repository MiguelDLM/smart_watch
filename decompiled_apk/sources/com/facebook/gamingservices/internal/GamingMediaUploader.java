package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileNotFoundException;

@AutoHandleExceptions
/* loaded from: classes8.dex */
public abstract class GamingMediaUploader {
    private static final String photoUploadEdge = "me/photos";

    public static void uploadToGamingServices(String caption, Bitmap imageBitmap, Bundle params, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, imageBitmap, caption, params, callback).executeAsync();
    }

    public static void uploadToGamingServices(String caption, File imageFile, Bundle params, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, imageFile, caption, params, callback).executeAsync();
    }

    public static void uploadToGamingServices(String caption, Uri imageUri, Bundle params, GraphRequest.Callback callback) throws FileNotFoundException {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!Utility.isFileUri(imageUri) && !Utility.isContentUri(imageUri)) {
            Bundle bundle = new Bundle();
            if (params != null) {
                bundle.putAll(params);
            }
            bundle.putString("url", imageUri.toString());
            if (caption != null && !caption.isEmpty()) {
                bundle.putString(ShareConstants.FEED_CAPTION_PARAM, caption);
            }
            new GraphRequest(currentAccessToken, photoUploadEdge, bundle, HttpMethod.POST, callback).executeAsync();
            return;
        }
        GraphRequest.newUploadPhotoRequest(currentAccessToken, photoUploadEdge, imageUri, caption, params, callback).executeAsync();
    }
}
