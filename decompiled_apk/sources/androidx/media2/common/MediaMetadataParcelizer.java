package androidx.media2.common;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class MediaMetadataParcelizer {
    public static MediaMetadata read(VersionedParcel versionedParcel) {
        MediaMetadata mediaMetadata = new MediaMetadata();
        mediaMetadata.mParcelableWithoutBitmapBundle = versionedParcel.readBundle(mediaMetadata.mParcelableWithoutBitmapBundle, 1);
        mediaMetadata.mBitmapListSlice = (ParcelImplListSlice) versionedParcel.readParcelable(mediaMetadata.mBitmapListSlice, 2);
        mediaMetadata.onPostParceling();
        return mediaMetadata;
    }

    public static void write(MediaMetadata mediaMetadata, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        mediaMetadata.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeBundle(mediaMetadata.mParcelableWithoutBitmapBundle, 1);
        versionedParcel.writeParcelable(mediaMetadata.mBitmapListSlice, 2);
    }
}
