package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.huawei.openalliance.ad.constant.aw;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class ImageRequest {

    @OXOo.OOXIXo
    private static final String ACCESS_TOKEN_PARAM = "access_token";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String HEIGHT_PARAM = "height";

    @OXOo.OOXIXo
    private static final String MIGRATION_PARAM = "migration_overrides";

    @OXOo.OOXIXo
    private static final String MIGRATION_VALUE = "{october_2012:true}";

    @OXOo.OOXIXo
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;

    @OXOo.OOXIXo
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;

    @OXOo.oOoXoXO
    private final Callback callback;

    @OXOo.OOXIXo
    private final Object callerTag;

    @OXOo.OOXIXo
    private final Context context;

    @OXOo.OOXIXo
    private final Uri imageUri;

    /* loaded from: classes8.dex */
    public static final class Builder {
        private boolean allowCachedRedirects;

        @OXOo.oOoXoXO
        private Callback callback;

        @OXOo.oOoXoXO
        private Object callerTag;

        @OXOo.OOXIXo
        private final Context context;

        @OXOo.OOXIXo
        private final Uri imageUri;

        public Builder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Uri imageUri) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(imageUri, "imageUri");
            this.context = context;
            this.imageUri = imageUri;
        }

        private final Context component1() {
            return this.context;
        }

        private final Uri component2() {
            return this.imageUri;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                context = builder.context;
            }
            if ((i & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context, uri);
        }

        @OXOo.OOXIXo
        public final ImageRequest build() {
            Context context = this.context;
            Uri uri = this.imageUri;
            Callback callback = this.callback;
            boolean z = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return new ImageRequest(context, uri, callback, z, obj, null);
        }

        @OXOo.OOXIXo
        public final Builder copy(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Uri imageUri) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(imageUri, "imageUri");
            return new Builder(context, imageUri);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return IIX0o.Oxx0IOOO(this.context, builder.context) && IIX0o.Oxx0IOOO(this.imageUri, builder.imageUri);
        }

        public int hashCode() {
            return (this.context.hashCode() * 31) + this.imageUri.hashCode();
        }

        @OXOo.OOXIXo
        public final Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setCallback(@OXOo.oOoXoXO Callback callback) {
            this.callback = callback;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setCallerTag(@OXOo.oOoXoXO Object obj) {
            this.callerTag = obj;
            return this;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCompleted(@OXOo.oOoXoXO ImageResponse imageResponse);
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Uri getProfilePictureUri(@OXOo.oOoXoXO String str, int i, int i2) {
            return getProfilePictureUri(str, i, i2, "");
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Uri getProfilePictureUri(@OXOo.oOoXoXO String str, int i, int i2, @OXOo.oOoXoXO String str2) {
            Validate validate = Validate.INSTANCE;
            Validate.notNullOrEmpty(str, aw.r);
            int max = Math.max(i, 0);
            int max2 = Math.max(i2, 0);
            if ((max == 0 && max2 == 0) ? false : true) {
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                Uri.Builder buildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                Locale locale = Locale.US;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String format = String.format(locale, ImageRequest.PATH, Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), str}, 2));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                Uri.Builder path = buildUpon.path(format);
                if (max2 != 0) {
                    path.appendQueryParameter("height", String.valueOf(max2));
                }
                if (max != 0) {
                    path.appendQueryParameter("width", String.valueOf(max));
                }
                path.appendQueryParameter(ImageRequest.MIGRATION_PARAM, ImageRequest.MIGRATION_VALUE);
                Utility utility = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(str2)) {
                    path.appendQueryParameter("access_token", str2);
                } else if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken()) && !Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                    path.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + '|' + FacebookSdk.getClientToken());
                } else {
                    Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
                }
                Uri build = path.build();
                IIX0o.oO(build, "builder.build()");
                return build;
            }
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
    }

    public /* synthetic */ ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(context, uri, callback, z, obj);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Uri getProfilePictureUri(@OXOo.oOoXoXO String str, int i, int i2) {
        return Companion.getProfilePictureUri(str, i, i2);
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    @OXOo.oOoXoXO
    public final Callback getCallback() {
        return this.callback;
    }

    @OXOo.OOXIXo
    public final Object getCallerTag() {
        return this.callerTag;
    }

    @OXOo.OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @OXOo.OOXIXo
    public final Uri getImageUri() {
        return this.imageUri;
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    private ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj) {
        this.context = context;
        this.imageUri = uri;
        this.callback = callback;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Uri getProfilePictureUri(@OXOo.oOoXoXO String str, int i, int i2, @OXOo.oOoXoXO String str2) {
        return Companion.getProfilePictureUri(str, i, i2, str2);
    }
}
