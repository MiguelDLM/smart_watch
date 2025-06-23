package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class AppGroupCreationContent implements ShareModel {

    @oOoXoXO
    private final AppGroupPrivacy appGroupPrivacy;

    @oOoXoXO
    private final String description;

    @oOoXoXO
    private final String name;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator<AppGroupCreationContent>() { // from class: com.facebook.share.model.AppGroupCreationContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @oOoXoXO
        public AppGroupCreationContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new AppGroupCreationContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public enum AppGroupPrivacy {
        Open,
        Closed;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static AppGroupPrivacy[] valuesCustom() {
            AppGroupPrivacy[] valuesCustom = values();
            return (AppGroupPrivacy[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {

        @oOoXoXO
        private AppGroupPrivacy appGroupPrivacy;

        @oOoXoXO
        private String description;

        @oOoXoXO
        private String name;

        @oOoXoXO
        public final AppGroupPrivacy getAppGroupPrivacy$facebook_common_release() {
            return this.appGroupPrivacy;
        }

        @oOoXoXO
        public final String getDescription$facebook_common_release() {
            return this.description;
        }

        @oOoXoXO
        public final String getName$facebook_common_release() {
            return this.name;
        }

        @OOXIXo
        public final Builder setAppGroupPrivacy(@oOoXoXO AppGroupPrivacy appGroupPrivacy) {
            this.appGroupPrivacy = appGroupPrivacy;
            return this;
        }

        public final void setAppGroupPrivacy$facebook_common_release(@oOoXoXO AppGroupPrivacy appGroupPrivacy) {
            this.appGroupPrivacy = appGroupPrivacy;
        }

        @OOXIXo
        public final Builder setDescription(@oOoXoXO String str) {
            this.description = str;
            return this;
        }

        public final void setDescription$facebook_common_release(@oOoXoXO String str) {
            this.description = str;
        }

        @OOXIXo
        public final Builder setName(@oOoXoXO String str) {
            this.name = str;
            return this;
        }

        public final void setName$facebook_common_release(@oOoXoXO String str) {
            this.name = str;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO AppGroupCreationContent appGroupCreationContent) {
            return appGroupCreationContent == null ? this : setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
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

    public /* synthetic */ AppGroupCreationContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.appGroupPrivacy;
    }

    @oOoXoXO
    public final String getDescription() {
        return this.description;
    }

    @oOoXoXO
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeSerializable(this.appGroupPrivacy);
    }

    private AppGroupCreationContent(Builder builder) {
        this.name = builder.getName$facebook_common_release();
        this.description = builder.getDescription$facebook_common_release();
        this.appGroupPrivacy = builder.getAppGroupPrivacy$facebook_common_release();
    }

    public AppGroupCreationContent(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.appGroupPrivacy = (AppGroupPrivacy) parcel.readSerializable();
    }
}
