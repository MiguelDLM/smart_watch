package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class ContextChooseContent implements ShareModel {

    @Nullable
    private final List<String> filters;

    @Nullable
    private final Integer maxSize;

    @Nullable
    private final Integer minSize;

    /* loaded from: classes8.dex */
    public static class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {

        @Nullable
        private List<String> filters;

        @Nullable
        private Integer maxSize;

        @Nullable
        private Integer minSize;

        public Builder setFilters(@Nullable final List<String> filters) {
            this.filters = filters;
            return this;
        }

        public Builder setMaxSize(@Nullable final Integer maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder setMinSize(@Nullable final Integer minSize) {
            this.minSize = minSize;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextChooseContent content) {
            return content == null ? this : setFilters(content.getFilters()).setMaxSize(content.getMaxSize()).setMinSize(content.getMinSize());
        }

        public Builder readFrom(final Parcel parcel) {
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    @Nullable
    public Integer getMaxSize() {
        return this.maxSize;
    }

    @Nullable
    public Integer getMinSize() {
        return this.minSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeStringList(this.filters);
        out.writeInt(this.maxSize.intValue());
        out.writeInt(this.minSize.intValue());
    }

    private ContextChooseContent(final Builder builder) {
        this.filters = builder.filters;
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    public ContextChooseContent(final Parcel parcel) {
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }
}
