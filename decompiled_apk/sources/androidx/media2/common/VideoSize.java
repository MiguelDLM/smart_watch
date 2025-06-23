package androidx.media2.common;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public class VideoSize implements VersionedParcelable {
    int mHeight;
    int mWidth;

    public VideoSize() {
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.mWidth != videoSize.mWidth || this.mHeight != videoSize.mHeight) {
            return false;
        }
        return true;
    }

    @IntRange(from = 0)
    public int getHeight() {
        return this.mHeight;
    }

    @IntRange(from = 0)
    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @NonNull
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("width can not be negative");
        }
        if (i2 >= 0) {
            this.mWidth = i;
            this.mHeight = i2;
            return;
        }
        throw new IllegalArgumentException("height can not be negative");
    }
}
