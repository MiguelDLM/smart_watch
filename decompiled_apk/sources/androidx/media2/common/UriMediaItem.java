package androidx.media2.common;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class UriMediaItem extends MediaItem {
    private final Uri mUri;
    private final List<HttpCookie> mUriCookies;
    private final Map<String, String> mUriHeader;

    /* loaded from: classes.dex */
    public static final class Builder extends MediaItem.Builder {
        Uri mUri;
        List<HttpCookie> mUriCookies;
        Map<String, String> mUriHeader;

        public Builder(@NonNull Uri uri) {
            this(uri, null, null);
        }

        public Builder(@NonNull Uri uri, @Nullable Map<String, String> map, @Nullable List<HttpCookie> list) {
            CookieHandler cookieHandler;
            Preconditions.checkNotNull(uri, "uri cannot be null");
            this.mUri = uri;
            if (list != null && (cookieHandler = CookieHandler.getDefault()) != null && !(cookieHandler instanceof CookieManager)) {
                throw new IllegalArgumentException("The cookie handler has to be of CookieManager type when cookies are provided");
            }
            this.mUri = uri;
            if (map != null) {
                this.mUriHeader = new HashMap(map);
            }
            if (list != null) {
                this.mUriCookies = new ArrayList(list);
            }
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public UriMediaItem build() {
            return new UriMediaItem(this);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j) {
            return (Builder) super.setEndPosition(j);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j) {
            return (Builder) super.setStartPosition(j);
        }
    }

    public UriMediaItem(Builder builder) {
        super(builder);
        this.mUri = builder.mUri;
        this.mUriHeader = builder.mUriHeader;
        this.mUriCookies = builder.mUriCookies;
    }

    @NonNull
    public Uri getUri() {
        return this.mUri;
    }

    @Nullable
    public List<HttpCookie> getUriCookies() {
        if (this.mUriCookies == null) {
            return null;
        }
        return new ArrayList(this.mUriCookies);
    }

    @Nullable
    public Map<String, String> getUriHeaders() {
        if (this.mUriHeader == null) {
            return null;
        }
        return new HashMap(this.mUriHeader);
    }
}
