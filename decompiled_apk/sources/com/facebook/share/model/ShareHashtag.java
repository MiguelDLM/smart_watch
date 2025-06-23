package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareHashtag implements ShareModel {

    @oOoXoXO
    private final String hashtag;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() { // from class: com.facebook.share.model.ShareHashtag$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareHashtag createFromParcel(@OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new ShareHashtag(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<ShareHashtag, Builder> {

        @oOoXoXO
        private String hashtag;

        @oOoXoXO
        public final String getHashtag() {
            return this.hashtag;
        }

        @OOXIXo
        public final Builder readFrom$facebook_common_release(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        @OOXIXo
        public final Builder setHashtag(@oOoXoXO String str) {
            this.hashtag = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareHashtag build() {
            return new ShareHashtag(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : setHashtag(shareHashtag.getHashtag());
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

    public /* synthetic */ ShareHashtag(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getHashtag() {
        return this.hashtag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.hashtag);
    }

    private ShareHashtag(Builder builder) {
        this.hashtag = builder.getHashtag();
    }

    public ShareHashtag(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.hashtag = parcel.readString();
    }
}
