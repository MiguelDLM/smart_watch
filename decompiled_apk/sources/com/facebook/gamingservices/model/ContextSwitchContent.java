package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: classes8.dex */
public final class ContextSwitchContent implements ShareModel {

    @Nullable
    private final String contextID;

    /* loaded from: classes8.dex */
    public static class Builder implements ShareModelBuilder<ContextSwitchContent, Builder> {

        @Nullable
        private String contextID;

        public Builder setContextID(@Nullable final String contextID) {
            this.contextID = contextID;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextSwitchContent build() {
            return new ContextSwitchContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextSwitchContent content) {
            return content == null ? this : setContextID(content.getContextID());
        }

        public Builder readFrom(final Parcel parcel) {
            return readFrom((ContextSwitchContent) parcel.readParcelable(ContextSwitchContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getContextID() {
        return this.contextID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeString(this.contextID);
    }

    private ContextSwitchContent(final Builder builder) {
        this.contextID = builder.contextID;
    }

    public ContextSwitchContent(final Parcel parcel) {
        this.contextID = parcel.readString();
    }
}
