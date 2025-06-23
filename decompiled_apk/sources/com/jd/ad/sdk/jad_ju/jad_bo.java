package com.jd.ad.sdk.jad_ju;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes10.dex */
public final class jad_bo {
    public static boolean jad_an(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean jad_an(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority());
    }
}
