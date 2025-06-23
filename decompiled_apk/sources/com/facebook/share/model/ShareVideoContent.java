package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {

    @oOoXoXO
    private final String contentDescription;

    @oOoXoXO
    private final String contentTitle;

    @oOoXoXO
    private final SharePhoto previewPhoto;

    @oOoXoXO
    private final ShareVideo video;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareVideoContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new ShareVideoContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {

        @oOoXoXO
        private String contentDescription;

        @oOoXoXO
        private String contentTitle;

        @oOoXoXO
        private SharePhoto previewPhoto;

        @oOoXoXO
        private ShareVideo video;

        @oOoXoXO
        public final String getContentDescription$facebook_common_release() {
            return this.contentDescription;
        }

        @oOoXoXO
        public final String getContentTitle$facebook_common_release() {
            return this.contentTitle;
        }

        @oOoXoXO
        public final SharePhoto getPreviewPhoto$facebook_common_release() {
            return this.previewPhoto;
        }

        @oOoXoXO
        public final ShareVideo getVideo$facebook_common_release() {
            return this.video;
        }

        @OOXIXo
        public final Builder setContentDescription(@oOoXoXO String str) {
            this.contentDescription = str;
            return this;
        }

        public final void setContentDescription$facebook_common_release(@oOoXoXO String str) {
            this.contentDescription = str;
        }

        @OOXIXo
        public final Builder setContentTitle(@oOoXoXO String str) {
            this.contentTitle = str;
            return this;
        }

        public final void setContentTitle$facebook_common_release(@oOoXoXO String str) {
            this.contentTitle = str;
        }

        @OOXIXo
        public final Builder setPreviewPhoto(@oOoXoXO SharePhoto sharePhoto) {
            SharePhoto build;
            if (sharePhoto == null) {
                build = null;
            } else {
                build = new SharePhoto.Builder().readFrom(sharePhoto).build();
            }
            this.previewPhoto = build;
            return this;
        }

        public final void setPreviewPhoto$facebook_common_release(@oOoXoXO SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto;
        }

        @OOXIXo
        public final Builder setVideo(@oOoXoXO ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.video = new ShareVideo.Builder().readFrom(shareVideo).build();
            return this;
        }

        public final void setVideo$facebook_common_release(@oOoXoXO ShareVideo shareVideo) {
            this.video = shareVideo;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareVideoContent shareVideoContent) {
            return shareVideoContent == null ? this : ((Builder) super.readFrom((Builder) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
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

    public /* synthetic */ ShareVideoContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @oOoXoXO
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @oOoXoXO
    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    @oOoXoXO
    public final ShareVideo getVideo() {
        return this.video;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.contentDescription);
        out.writeString(this.contentTitle);
        out.writeParcelable(this.previewPhoto, 0);
        out.writeParcelable(this.video, 0);
    }

    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.getContentDescription$facebook_common_release();
        this.contentTitle = builder.getContentTitle$facebook_common_release();
        this.previewPhoto = builder.getPreviewPhoto$facebook_common_release();
        this.video = builder.getVideo$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareVideoContent(@OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom$facebook_common_release = new SharePhoto.Builder().readFrom$facebook_common_release(parcel);
        this.previewPhoto = (readFrom$facebook_common_release.getImageUrl$facebook_common_release() == null && readFrom$facebook_common_release.getBitmap$facebook_common_release() == null) ? null : readFrom$facebook_common_release.build();
        this.video = new ShareVideo.Builder().readFrom$facebook_common_release(parcel).build();
    }
}
