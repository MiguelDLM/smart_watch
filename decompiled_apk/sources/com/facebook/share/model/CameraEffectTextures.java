package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class CameraEffectTextures implements ShareModel {

    @oOoXoXO
    private final Bundle textures;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new Parcelable.Creator<CameraEffectTextures>() { // from class: com.facebook.share.model.CameraEffectTextures$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public CameraEffectTextures createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new CameraEffectTextures(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {

        @OOXIXo
        private final Bundle textures = new Bundle();

        private final Builder putParcelableTexture(String str, Parcelable parcelable) {
            if (str.length() > 0 && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            return this;
        }

        @OOXIXo
        public final Bundle getTextures$facebook_common_release() {
            return this.textures;
        }

        @OOXIXo
        public final Builder putTexture(@OOXIXo String key, @oOoXoXO Bitmap bitmap) {
            IIX0o.x0xO0oo(key, "key");
            return putParcelableTexture(key, bitmap);
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
        }

        @OOXIXo
        public final Builder putTexture(@OOXIXo String key, @oOoXoXO Uri uri) {
            IIX0o.x0xO0oo(key, "key");
            return putParcelableTexture(key, uri);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            return this;
        }

        @OOXIXo
        public final Builder readFrom(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ CameraEffectTextures(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Object get(@oOoXoXO String str) {
        Bundle bundle = this.textures;
        if (bundle == null) {
            return null;
        }
        return bundle.get(str);
    }

    @oOoXoXO
    public final Bitmap getTextureBitmap(@oOoXoXO String str) {
        Object obj;
        Bundle bundle = this.textures;
        if (bundle == null) {
            obj = null;
        } else {
            obj = bundle.get(str);
        }
        if (!(obj instanceof Bitmap)) {
            return null;
        }
        return (Bitmap) obj;
    }

    @oOoXoXO
    public final Uri getTextureUri(@oOoXoXO String str) {
        Object obj;
        Bundle bundle = this.textures;
        if (bundle == null) {
            obj = null;
        } else {
            obj = bundle.get(str);
        }
        if (!(obj instanceof Uri)) {
            return null;
        }
        return (Uri) obj;
    }

    @OOXIXo
    public final Set<String> keySet() {
        Set<String> keySet;
        Bundle bundle = this.textures;
        if (bundle == null) {
            keySet = null;
        } else {
            keySet = bundle.keySet();
        }
        if (keySet == null) {
            return Xo0.OOXIXo();
        }
        return keySet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeBundle(this.textures);
    }

    private CameraEffectTextures(Builder builder) {
        this.textures = builder.getTextures$facebook_common_release();
    }

    public CameraEffectTextures(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.textures = parcel.readBundle(CameraEffectTextures.class.getClassLoader());
    }
}
