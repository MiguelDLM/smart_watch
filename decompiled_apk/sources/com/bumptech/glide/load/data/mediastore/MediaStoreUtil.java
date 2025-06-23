package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes8.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    private MediaStoreUtil() {
    }

    public static boolean isAndroidPickerUri(Uri uri) {
        if (isMediaStoreUri(uri) && uri.getPathSegments().contains("picker")) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        if (isMediaStoreUri(uri) && !isVideoUri(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        if (isMediaStoreUri(uri) && isVideoUri(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
