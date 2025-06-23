package com.facebook.messenger;

import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.bf;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class ShareToMessengerParams {
    public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
    public static final Set<String> VALID_MIME_TYPES;
    public static final Set<String> VALID_URI_SCHEMES;
    public final Uri externalUri;
    public final String metaData;
    public final String mimeType;
    public final Uri uri;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("image/*");
        hashSet.add("image/jpeg");
        hashSet.add(bf.Z);
        hashSet.add(bf.B);
        hashSet.add("image/webp");
        hashSet.add("video/*");
        hashSet.add("video/mp4");
        hashSet.add("audio/*");
        hashSet.add(MimeTypes.AUDIO_MPEG);
        VALID_MIME_TYPES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("content");
        hashSet2.add("android.resource");
        hashSet2.add("file");
        VALID_URI_SCHEMES = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add("http");
        hashSet3.add("https");
        VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(hashSet3);
    }

    public ShareToMessengerParams(ShareToMessengerParamsBuilder builder) {
        Uri uri = builder.getUri();
        this.uri = uri;
        String mimeType = builder.getMimeType();
        this.mimeType = mimeType;
        this.metaData = builder.getMetaData();
        Uri externalUri = builder.getExternalUri();
        this.externalUri = externalUri;
        if (uri != null) {
            if (mimeType != null) {
                if (VALID_URI_SCHEMES.contains(uri.getScheme())) {
                    if (VALID_MIME_TYPES.contains(mimeType)) {
                        if (externalUri != null && !VALID_EXTERNAL_URI_SCHEMES.contains(externalUri.getScheme())) {
                            throw new IllegalArgumentException("Unsupported external uri scheme: " + externalUri.getScheme());
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported mime-type: " + mimeType);
                }
                throw new IllegalArgumentException("Unsupported URI scheme: " + uri.getScheme());
            }
            throw new NullPointerException("Must provide mimeType");
        }
        throw new NullPointerException("Must provide non-null uri");
    }

    public static ShareToMessengerParamsBuilder newBuilder(Uri uri, String mimeType) {
        return new ShareToMessengerParamsBuilder(uri, mimeType);
    }
}
