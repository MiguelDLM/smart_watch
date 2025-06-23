package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.Regex;

public class NavDeepLinkRequest {
    @oOoXoXO
    private final String action;
    @oOoXoXO
    private final String mimeType;
    @oOoXoXO
    private final Uri uri;

    @XX({"SMAP\nNavDeepLinkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLinkRequest.kt\nandroidx/navigation/NavDeepLinkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
    public static final class Builder {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @oOoXoXO
        private String action;
        @oOoXoXO
        private String mimeType;
        @oOoXoXO
        private Uri uri;

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromAction(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, "action");
                if (str.length() > 0) {
                    Builder builder = new Builder((IIXOooo) null);
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromMimeType(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
                Builder builder = new Builder((IIXOooo) null);
                builder.setMimeType(str);
                return builder;
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromUri(@OOXIXo Uri uri) {
                IIX0o.x0xO0oo(uri, "uri");
                Builder builder = new Builder((IIXOooo) null);
                builder.setUri(uri);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromAction(@OOXIXo String str) {
            return Companion.fromAction(str);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromMimeType(@OOXIXo String str) {
            return Companion.fromMimeType(str);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromUri(@OOXIXo Uri uri2) {
            return Companion.fromUri(uri2);
        }

        @OOXIXo
        public final NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.uri, this.action, this.mimeType);
        }

        @OOXIXo
        public final Builder setAction(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "action");
            if (str.length() > 0) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
        }

        @OOXIXo
        public final Builder setMimeType(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
            if (new Regex("^[-\\w*.]+/[-\\w+*.]+$").matches(str)) {
                this.mimeType = str;
                return this;
            }
            throw new IllegalArgumentException(("The given mimeType " + str + " does not match to required \"type/subtype\" format").toString());
        }

        @OOXIXo
        public final Builder setUri(@OOXIXo Uri uri2) {
            IIX0o.x0xO0oo(uri2, "uri");
            this.uri = uri2;
            return this;
        }

        private Builder() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(@oOoXoXO Uri uri2, @oOoXoXO String str, @oOoXoXO String str2) {
        this.uri = uri2;
        this.action = str;
        this.mimeType = str2;
    }

    @oOoXoXO
    public String getAction() {
        return this.action;
    }

    @oOoXoXO
    public String getMimeType() {
        return this.mimeType;
    }

    @oOoXoXO
    public Uri getUri() {
        return this.uri;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (getUri() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(getUri()));
        }
        if (getAction() != null) {
            sb.append(" action=");
            sb.append(getAction());
        }
        if (getMimeType() != null) {
            sb.append(" mimetype=");
            sb.append(getMimeType());
        }
        sb.append(" }");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(@OOXIXo Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
    }
}
