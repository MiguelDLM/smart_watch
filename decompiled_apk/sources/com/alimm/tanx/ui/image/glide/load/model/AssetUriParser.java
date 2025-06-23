package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;

/* loaded from: classes.dex */
final class AssetUriParser {
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;

    private AssetUriParser() {
    }

    public static boolean isAssetUri(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public static String toAssetPath(Uri uri) {
        return uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
