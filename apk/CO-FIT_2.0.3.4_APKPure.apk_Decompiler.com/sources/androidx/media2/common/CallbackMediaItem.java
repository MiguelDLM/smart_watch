package androidx.media2.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;

public class CallbackMediaItem extends MediaItem {
    private final DataSourceCallback mDataSourceCallback;

    public static final class Builder extends MediaItem.Builder {
        DataSourceCallback mDataSourceCallback;

        public Builder(@NonNull DataSourceCallback dataSourceCallback) {
            Preconditions.checkNotNull(dataSourceCallback);
            this.mDataSourceCallback = dataSourceCallback;
        }

        @NonNull
        public CallbackMediaItem build() {
            return new CallbackMediaItem(this);
        }

        @NonNull
        public Builder setEndPosition(long j) {
            return (Builder) super.setEndPosition(j);
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        @NonNull
        public Builder setStartPosition(long j) {
            return (Builder) super.setStartPosition(j);
        }
    }

    public CallbackMediaItem(Builder builder) {
        super((MediaItem.Builder) builder);
        this.mDataSourceCallback = builder.mDataSourceCallback;
    }

    @NonNull
    public DataSourceCallback getDataSourceCallback() {
        return this.mDataSourceCallback;
    }
}
