package androidx.media2.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;

/* loaded from: classes.dex */
public class CallbackMediaItem extends MediaItem {
    private final DataSourceCallback mDataSourceCallback;

    /* loaded from: classes.dex */
    public static final class Builder extends MediaItem.Builder {
        DataSourceCallback mDataSourceCallback;

        public Builder(@NonNull DataSourceCallback dataSourceCallback) {
            Preconditions.checkNotNull(dataSourceCallback);
            this.mDataSourceCallback = dataSourceCallback;
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public CallbackMediaItem build() {
            return new CallbackMediaItem(this);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j) {
            return (Builder) super.setEndPosition(j);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j) {
            return (Builder) super.setStartPosition(j);
        }
    }

    public CallbackMediaItem(Builder builder) {
        super(builder);
        this.mDataSourceCallback = builder.mDataSourceCallback;
    }

    @NonNull
    public DataSourceCallback getDataSourceCallback() {
        return this.mDataSourceCallback;
    }
}
