package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {

    @oOoXoXO
    private CameraEffectArguments arguments;

    @oOoXoXO
    private String effectId;

    @oOoXoXO
    private CameraEffectTextures textures;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() { // from class: com.facebook.share.model.ShareCameraEffectContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareCameraEffectContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new ShareCameraEffectContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {

        @oOoXoXO
        private CameraEffectArguments arguments;

        @oOoXoXO
        private String effectId;

        @oOoXoXO
        private CameraEffectTextures textures;

        @oOoXoXO
        public final CameraEffectArguments getArguments$facebook_common_release() {
            return this.arguments;
        }

        @oOoXoXO
        public final String getEffectId$facebook_common_release() {
            return this.effectId;
        }

        @oOoXoXO
        public final CameraEffectTextures getTextures$facebook_common_release() {
            return this.textures;
        }

        @OOXIXo
        public final Builder setArguments(@oOoXoXO CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final void setArguments$facebook_common_release(@oOoXoXO CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
        }

        @OOXIXo
        public final Builder setEffectId(@oOoXoXO String str) {
            this.effectId = str;
            return this;
        }

        public final void setEffectId$facebook_common_release(@oOoXoXO String str) {
            this.effectId = str;
        }

        @OOXIXo
        public final Builder setTextures(@oOoXoXO CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        public final void setTextures$facebook_common_release(@oOoXoXO CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO ShareCameraEffectContent shareCameraEffectContent) {
            return shareCameraEffectContent == null ? this : ((Builder) super.readFrom((Builder) shareCameraEffectContent)).setEffectId(shareCameraEffectContent.getEffectId()).setArguments(shareCameraEffectContent.getArguments()).setTextures(shareCameraEffectContent.getTextures());
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

    public /* synthetic */ ShareCameraEffectContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @oOoXoXO
    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    @oOoXoXO
    public final String getEffectId() {
        return this.effectId;
    }

    @oOoXoXO
    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.effectId);
        out.writeParcelable(this.arguments, 0);
        out.writeParcelable(this.textures, 0);
    }

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.getEffectId$facebook_common_release();
        this.arguments = builder.getArguments$facebook_common_release();
        this.textures = builder.getTextures$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCameraEffectContent(@OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }
}
