package androidx.media2.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SubtitleData implements VersionedParcelable {
    private static final String TAG = "SubtitleData";
    byte[] mData;
    long mDurationUs;
    long mStartTimeUs;

    public SubtitleData() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SubtitleData.class != obj.getClass()) {
            return false;
        }
        SubtitleData subtitleData = (SubtitleData) obj;
        if (this.mStartTimeUs == subtitleData.mStartTimeUs && this.mDurationUs == subtitleData.mDurationUs && Arrays.equals(this.mData, subtitleData.mData)) {
            return true;
        }
        return false;
    }

    @NonNull
    public byte[] getData() {
        return this.mData;
    }

    public long getDurationUs() {
        return this.mDurationUs;
    }

    public long getStartTimeUs() {
        return this.mStartTimeUs;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Long.valueOf(this.mStartTimeUs), Long.valueOf(this.mDurationUs), Integer.valueOf(Arrays.hashCode(this.mData)));
    }

    public SubtitleData(long j, long j2, @NonNull byte[] bArr) {
        this.mStartTimeUs = j;
        this.mDurationUs = j2;
        this.mData = bArr;
    }
}
