package androidx.media2.common;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MediaItemParcelizer {
    public static MediaItem read(VersionedParcel versionedParcel) {
        MediaItem mediaItem = new MediaItem();
        mediaItem.mMetadata = (MediaMetadata) versionedParcel.readVersionedParcelable(mediaItem.mMetadata, 1);
        mediaItem.mStartPositionMs = versionedParcel.readLong(mediaItem.mStartPositionMs, 2);
        mediaItem.mEndPositionMs = versionedParcel.readLong(mediaItem.mEndPositionMs, 3);
        mediaItem.onPostParceling();
        return mediaItem;
    }

    public static void write(MediaItem mediaItem, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        mediaItem.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeVersionedParcelable(mediaItem.mMetadata, 1);
        versionedParcel.writeLong(mediaItem.mStartPositionMs, 2);
        versionedParcel.writeLong(mediaItem.mEndPositionMs, 3);
    }
}
