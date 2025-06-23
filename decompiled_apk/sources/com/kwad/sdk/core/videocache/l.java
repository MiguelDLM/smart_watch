package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.utils.aq;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes11.dex */
public final class l {
    public static void b(byte[] bArr, long j, int i) {
        boolean z;
        aq.g(bArr, "Buffer must be not null!");
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        aq.checkArgument(z, "Data offset must be positive!");
        if (i >= 0 && i <= bArr.length) {
            z2 = true;
        }
        aq.checkArgument(z2, "Length must be in range [0..buffer.length]");
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String eR(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }
}
