package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: classes8.dex */
public class ContextCreateContent implements ShareModel {

    @Nullable
    private final String suggestedPlayerID;

    /* loaded from: classes8.dex */
    public static class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {

        @Nullable
        private String suggestedPlayerID;

        public Builder setSuggestedPlayerID(@Nullable final String suggestedPlayerID) {
            this.suggestedPlayerID = suggestedPlayerID;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextCreateContent build() {
            return new ContextCreateContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextCreateContent content) {
            return content == null ? this : setSuggestedPlayerID(content.getSuggestedPlayerID());
        }

        public Builder readFrom(final Parcel parcel) {
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getSuggestedPlayerID() {
        return this.suggestedPlayerID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeString(this.suggestedPlayerID);
    }

    private ContextCreateContent(final Builder builder) {
        this.suggestedPlayerID = builder.suggestedPlayerID;
    }

    public ContextCreateContent(final Parcel parcel) {
        this.suggestedPlayerID = parcel.readString();
    }
}
