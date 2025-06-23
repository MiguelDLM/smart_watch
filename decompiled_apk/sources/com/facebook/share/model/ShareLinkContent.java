package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {

    @oOoXoXO
    private final String quote;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() { // from class: com.facebook.share.model.ShareLinkContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareLinkContent createFromParcel(@OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new ShareLinkContent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {

        @oOoXoXO
        private String quote;

        @oOoXoXO
        public final String getQuote$facebook_common_release() {
            return this.quote;
        }

        @OOXIXo
        public final Builder setQuote(@oOoXoXO String str) {
            this.quote = str;
            return this;
        }

        public final void setQuote$facebook_common_release(@oOoXoXO String str) {
            this.quote = str;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareLinkContent build() {
            return new ShareLinkContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareLinkContent shareLinkContent) {
            return shareLinkContent == null ? this : ((Builder) super.readFrom((Builder) shareLinkContent)).setQuote(shareLinkContent.getQuote());
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

    public /* synthetic */ ShareLinkContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getQuote() {
        return this.quote;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.quote);
    }

    private ShareLinkContent(Builder builder) {
        super(builder);
        this.quote = builder.getQuote$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLinkContent(@OOXIXo Parcel source) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        this.quote = source.readString();
    }
}
