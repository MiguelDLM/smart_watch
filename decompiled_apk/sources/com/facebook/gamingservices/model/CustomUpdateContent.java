package com.facebook.gamingservices.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Bitmap;
import android.util.Base64;
import com.facebook.gamingservices.GamingContext;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class CustomUpdateContent {

    @OOXIXo
    private final String contextTokenId;

    @oOoXoXO
    private final CustomUpdateLocalizedText cta;

    @oOoXoXO
    private final String data;

    @oOoXoXO
    private final String image;

    @oOoXoXO
    private final CustomUpdateMedia media;

    @OOXIXo
    private final CustomUpdateLocalizedText text;

    public /* synthetic */ CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3, IIXOooo iIXOooo) {
        this(str, customUpdateLocalizedText, customUpdateLocalizedText2, str2, customUpdateMedia, str3);
    }

    @OOXIXo
    public final String getContextTokenId() {
        return this.contextTokenId;
    }

    @oOoXoXO
    public final CustomUpdateLocalizedText getCta() {
        return this.cta;
    }

    @oOoXoXO
    public final String getData() {
        return this.data;
    }

    @oOoXoXO
    public final String getImage() {
        return this.image;
    }

    @oOoXoXO
    public final CustomUpdateMedia getMedia() {
        return this.media;
    }

    @OOXIXo
    public final CustomUpdateLocalizedText getText() {
        return this.text;
    }

    @OOXIXo
    public final JSONObject toGraphRequestContent() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("context_token_id", this.contextTokenId);
        jSONObject.put("text", this.text.toJSONObject().toString());
        CustomUpdateLocalizedText customUpdateLocalizedText = this.cta;
        if (customUpdateLocalizedText != null) {
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, customUpdateLocalizedText.toJSONObject().toString());
        }
        String str = this.image;
        if (str != null) {
            jSONObject.put("image", str);
        }
        CustomUpdateMedia customUpdateMedia = this.media;
        if (customUpdateMedia != null) {
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MEDIA, customUpdateMedia.toJSONObject().toString());
        }
        String str2 = this.data;
        if (str2 != null) {
            jSONObject.put("data", str2);
        }
        return jSONObject;
    }

    private CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3) {
        this.contextTokenId = str;
        this.text = customUpdateLocalizedText;
        this.cta = customUpdateLocalizedText2;
        this.image = str2;
        this.media = customUpdateMedia;
        this.data = str3;
    }

    /* loaded from: classes8.dex */
    public static final class Builder {

        @oOoXoXO
        private final String contextTokenId;

        @oOoXoXO
        private CustomUpdateLocalizedText cta;

        @oOoXoXO
        private String data;

        @oOoXoXO
        private final Bitmap image;

        @oOoXoXO
        private final CustomUpdateMedia media;

        @OOXIXo
        private final CustomUpdateLocalizedText text;

        private Builder(String str, CustomUpdateLocalizedText customUpdateLocalizedText, Bitmap bitmap, CustomUpdateMedia customUpdateMedia) {
            this.contextTokenId = str;
            this.text = customUpdateLocalizedText;
            this.image = bitmap;
            this.media = customUpdateMedia;
        }

        private final String bitmapToBase64String(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return IIX0o.XIxXXX0x0("data:image/png;base64,", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        }

        @OOXIXo
        public final CustomUpdateContent build() {
            boolean z;
            CustomUpdateMedia customUpdateMedia = this.media;
            if (customUpdateMedia != null) {
                boolean z2 = false;
                if (customUpdateMedia.getGif() != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.media.getVideo() != null) {
                    z2 = true;
                }
                if (!(z ^ z2)) {
                    throw new IllegalArgumentException("Invalid CustomUpdateMedia, please set either gif or video");
                }
            }
            String bitmapToBase64String = bitmapToBase64String(this.image);
            String str = this.contextTokenId;
            if (str != null) {
                return new CustomUpdateContent(str, this.text, this.cta, bitmapToBase64String, this.media, this.data, null);
            }
            throw new IllegalArgumentException("parameter contextToken must not be null");
        }

        @oOoXoXO
        public final CustomUpdateLocalizedText getCta() {
            return this.cta;
        }

        @oOoXoXO
        public final String getData() {
            return this.data;
        }

        @OOXIXo
        public final Builder setCta(@OOXIXo CustomUpdateLocalizedText cta) {
            IIX0o.x0xO0oo(cta, "cta");
            this.cta = cta;
            return this;
        }

        @OOXIXo
        public final Builder setData(@OOXIXo String data) {
            IIX0o.x0xO0oo(data, "data");
            this.data = data;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo GamingContext contextToken, @OOXIXo CustomUpdateLocalizedText text, @OOXIXo Bitmap image) {
            this(contextToken.getContextID(), text, image, null);
            IIX0o.x0xO0oo(contextToken, "contextToken");
            IIX0o.x0xO0oo(text, "text");
            IIX0o.x0xO0oo(image, "image");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo GamingContext contextToken, @OOXIXo CustomUpdateLocalizedText text, @OOXIXo CustomUpdateMedia media) {
            this(contextToken.getContextID(), text, null, media);
            IIX0o.x0xO0oo(contextToken, "contextToken");
            IIX0o.x0xO0oo(text, "text");
            IIX0o.x0xO0oo(media, "media");
        }
    }

    public /* synthetic */ CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3, int i, IIXOooo iIXOooo) {
        this(str, customUpdateLocalizedText, (i & 4) != 0 ? null : customUpdateLocalizedText2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : customUpdateMedia, (i & 32) != 0 ? null : str3);
    }
}
