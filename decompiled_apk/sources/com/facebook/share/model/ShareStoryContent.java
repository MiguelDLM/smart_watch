package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {

    @oOoXoXO
    private final String attributionLink;

    @oOoXoXO
    private final ShareMedia<?, ?> backgroundAsset;

    @oOoXoXO
    private final List<String> backgroundColorList;

    @oOoXoXO
    private final SharePhoto stickerAsset;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() { // from class: com.facebook.share.model.ShareStoryContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareStoryContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new ShareStoryContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {

        @oOoXoXO
        private String attributionLink;

        @oOoXoXO
        private ShareMedia<?, ?> backgroundAsset;

        @oOoXoXO
        private List<String> backgroundColorList;

        @oOoXoXO
        private SharePhoto stickerAsset;

        @oOoXoXO
        public final String getAttributionLink$facebook_common_release() {
            return this.attributionLink;
        }

        @oOoXoXO
        public final ShareMedia<?, ?> getBackgroundAsset$facebook_common_release() {
            return this.backgroundAsset;
        }

        @oOoXoXO
        public final List<String> getBackgroundColorList$facebook_common_release() {
            return this.backgroundColorList;
        }

        @oOoXoXO
        public final SharePhoto getStickerAsset$facebook_common_release() {
            return this.stickerAsset;
        }

        @OOXIXo
        public final Builder setAttributionLink(@oOoXoXO String str) {
            this.attributionLink = str;
            return this;
        }

        public final void setAttributionLink$facebook_common_release(@oOoXoXO String str) {
            this.attributionLink = str;
        }

        @OOXIXo
        public final Builder setBackgroundAsset(@oOoXoXO ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
            return this;
        }

        public final void setBackgroundAsset$facebook_common_release(@oOoXoXO ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
        }

        @OOXIXo
        public final Builder setBackgroundColorList(@oOoXoXO List<String> list) {
            List<String> oOo0o;
            if (list == null) {
                oOo0o = null;
            } else {
                oOo0o = CollectionsKt___CollectionsKt.oOo0o(list);
            }
            this.backgroundColorList = oOo0o;
            return this;
        }

        public final void setBackgroundColorList$facebook_common_release(@oOoXoXO List<String> list) {
            this.backgroundColorList = list;
        }

        @OOXIXo
        public final Builder setStickerAsset(@oOoXoXO SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
            return this;
        }

        public final void setStickerAsset$facebook_common_release(@oOoXoXO SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareStoryContent shareStoryContent) {
            return shareStoryContent == null ? this : ((Builder) super.readFrom((Builder) shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
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

    public /* synthetic */ ShareStoryContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt___CollectionsKt.oOo0o(arrayList);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getAttributionLink() {
        return this.attributionLink;
    }

    @oOoXoXO
    public final ShareMedia<?, ?> getBackgroundAsset() {
        return this.backgroundAsset;
    }

    @oOoXoXO
    public final List<String> getBackgroundColorList() {
        List<String> list = this.backgroundColorList;
        if (list == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.oOo0o(list);
    }

    @oOoXoXO
    public final SharePhoto getStickerAsset() {
        return this.stickerAsset;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeParcelable(this.backgroundAsset, 0);
        out.writeParcelable(this.stickerAsset, 0);
        out.writeStringList(getBackgroundColorList());
        out.writeString(this.attributionLink);
    }

    private ShareStoryContent(Builder builder) {
        super(builder);
        this.backgroundAsset = builder.getBackgroundAsset$facebook_common_release();
        this.stickerAsset = builder.getStickerAsset$facebook_common_release();
        this.backgroundColorList = builder.getBackgroundColorList$facebook_common_release();
        this.attributionLink = builder.getAttributionLink$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStoryContent(@OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.backgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.backgroundColorList = readUnmodifiableStringList(parcel);
        this.attributionLink = parcel.readString();
    }
}
