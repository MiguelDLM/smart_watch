package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class SharePhoto extends ShareMedia<SharePhoto, Builder> {

    @oOoXoXO
    private final Bitmap bitmap;

    @oOoXoXO
    private final String caption;

    @oOoXoXO
    private final Uri imageUrl;

    @OOXIXo
    private final ShareMedia.Type mediaType;
    private final boolean userGenerated;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() { // from class: com.facebook.share.model.SharePhoto$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public SharePhoto createFromParcel(@OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new SharePhoto(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @oOoXoXO
        private Bitmap bitmap;

        @oOoXoXO
        private String caption;

        @oOoXoXO
        private Uri imageUrl;
        private boolean userGenerated;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final List<SharePhoto> readPhotoListFrom$facebook_common_release(@OOXIXo Parcel parcel) {
                IIX0o.x0xO0oo(parcel, "parcel");
                List<ShareMedia<?, ?>> readListFrom$facebook_common_release = ShareMedia.Builder.Companion.readListFrom$facebook_common_release(parcel);
                ArrayList arrayList = new ArrayList();
                for (Object obj : readListFrom$facebook_common_release) {
                    if (obj instanceof SharePhoto) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }

            public final void writePhotoListTo$facebook_common_release(@OOXIXo Parcel out, int i, @OOXIXo List<SharePhoto> photos) {
                IIX0o.x0xO0oo(out, "out");
                IIX0o.x0xO0oo(photos, "photos");
                Object[] array = photos.toArray(new SharePhoto[0]);
                if (array != null) {
                    out.writeParcelableArray((SharePhoto[]) array, i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            private Companion() {
            }
        }

        @oOoXoXO
        public final Bitmap getBitmap$facebook_common_release() {
            return this.bitmap;
        }

        @oOoXoXO
        public final String getCaption$facebook_common_release() {
            return this.caption;
        }

        @oOoXoXO
        public final Uri getImageUrl$facebook_common_release() {
            return this.imageUrl;
        }

        public final boolean getUserGenerated$facebook_common_release() {
            return this.userGenerated;
        }

        @OOXIXo
        public final Builder readFrom$facebook_common_release(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        @OOXIXo
        public final Builder setBitmap(@oOoXoXO Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        @OOXIXo
        public final Builder setCaption(@oOoXoXO String str) {
            this.caption = str;
            return this;
        }

        @OOXIXo
        public final Builder setImageUrl(@oOoXoXO Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        @OOXIXo
        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public SharePhoto build() {
            return new SharePhoto(this, null);
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((Builder) super.readFrom((Builder) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
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

    public /* synthetic */ SharePhoto(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @oOoXoXO
    public final String getCaption() {
        return this.caption;
    }

    @oOoXoXO
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.facebook.share.model.ShareMedia
    @OOXIXo
    public ShareMedia.Type getMediaType() {
        return this.mediaType;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeParcelable(this.bitmap, 0);
        out.writeParcelable(this.imageUrl, 0);
        out.writeByte(this.userGenerated ? (byte) 1 : (byte) 0);
        out.writeString(this.caption);
    }

    private SharePhoto(Builder builder) {
        super(builder);
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = builder.getBitmap$facebook_common_release();
        this.imageUrl = builder.getImageUrl$facebook_common_release();
        this.userGenerated = builder.getUserGenerated$facebook_common_release();
        this.caption = builder.getCaption$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePhoto(@OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }
}
