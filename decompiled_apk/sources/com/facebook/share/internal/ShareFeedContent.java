package com.facebook.share.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {

    @oOoXoXO
    private final String link;

    @oOoXoXO
    private final String linkCaption;

    @oOoXoXO
    private final String linkDescription;

    @oOoXoXO
    private final String linkName;

    @oOoXoXO
    private final String mediaSource;

    @oOoXoXO
    private final String picture;

    @oOoXoXO
    private final String toId;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareFeedContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new ShareFeedContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {

        @oOoXoXO
        private String link;

        @oOoXoXO
        private String linkCaption;

        @oOoXoXO
        private String linkDescription;

        @oOoXoXO
        private String linkName;

        @oOoXoXO
        private String mediaSource;

        @oOoXoXO
        private String picture;

        @oOoXoXO
        private String toId;

        @oOoXoXO
        public final String getLink$facebook_common_release() {
            return this.link;
        }

        @oOoXoXO
        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        @oOoXoXO
        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        @oOoXoXO
        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        @oOoXoXO
        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        @oOoXoXO
        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        @oOoXoXO
        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        @OOXIXo
        public final Builder setLink(@oOoXoXO String str) {
            this.link = str;
            return this;
        }

        public final void setLink$facebook_common_release(@oOoXoXO String str) {
            this.link = str;
        }

        @OOXIXo
        public final Builder setLinkCaption(@oOoXoXO String str) {
            this.linkCaption = str;
            return this;
        }

        public final void setLinkCaption$facebook_common_release(@oOoXoXO String str) {
            this.linkCaption = str;
        }

        @OOXIXo
        public final Builder setLinkDescription(@oOoXoXO String str) {
            this.linkDescription = str;
            return this;
        }

        public final void setLinkDescription$facebook_common_release(@oOoXoXO String str) {
            this.linkDescription = str;
        }

        @OOXIXo
        public final Builder setLinkName(@oOoXoXO String str) {
            this.linkName = str;
            return this;
        }

        public final void setLinkName$facebook_common_release(@oOoXoXO String str) {
            this.linkName = str;
        }

        @OOXIXo
        public final Builder setMediaSource(@oOoXoXO String str) {
            this.mediaSource = str;
            return this;
        }

        public final void setMediaSource$facebook_common_release(@oOoXoXO String str) {
            this.mediaSource = str;
        }

        @OOXIXo
        public final Builder setPicture(@oOoXoXO String str) {
            this.picture = str;
            return this;
        }

        public final void setPicture$facebook_common_release(@oOoXoXO String str) {
            this.picture = str;
        }

        @OOXIXo
        public final Builder setToId(@oOoXoXO String str) {
            this.toId = str;
            return this;
        }

        public final void setToId$facebook_common_release(@oOoXoXO String str) {
            this.toId = str;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareFeedContent shareFeedContent) {
            return shareFeedContent == null ? this : ((Builder) super.readFrom((Builder) shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
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

    public /* synthetic */ ShareFeedContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getLink() {
        return this.link;
    }

    @oOoXoXO
    public final String getLinkCaption() {
        return this.linkCaption;
    }

    @oOoXoXO
    public final String getLinkDescription() {
        return this.linkDescription;
    }

    @oOoXoXO
    public final String getLinkName() {
        return this.linkName;
    }

    @oOoXoXO
    public final String getMediaSource() {
        return this.mediaSource;
    }

    @oOoXoXO
    public final String getPicture() {
        return this.picture;
    }

    @oOoXoXO
    public final String getToId() {
        return this.toId;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.toId);
        out.writeString(this.link);
        out.writeString(this.linkName);
        out.writeString(this.linkCaption);
        out.writeString(this.linkDescription);
        out.writeString(this.picture);
        out.writeString(this.mediaSource);
    }

    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId$facebook_common_release();
        this.link = builder.getLink$facebook_common_release();
        this.linkName = builder.getLinkName$facebook_common_release();
        this.linkCaption = builder.getLinkCaption$facebook_common_release();
        this.linkDescription = builder.getLinkDescription$facebook_common_release();
        this.picture = builder.getPicture$facebook_common_release();
        this.mediaSource = builder.getMediaSource$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFeedContent(@OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }
}
