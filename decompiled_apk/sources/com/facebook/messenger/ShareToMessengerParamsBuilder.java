package com.facebook.messenger;

import android.net.Uri;

/* loaded from: classes8.dex */
public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    public ShareToMessengerParamsBuilder(Uri uri, String mimeType) {
        this.mUri = uri;
        this.mMimeType = mimeType;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }

    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri externalUri) {
        this.mExternalUri = externalUri;
        return this;
    }

    public ShareToMessengerParamsBuilder setMetaData(String metaData) {
        this.mMetaData = metaData;
        return this;
    }
}
