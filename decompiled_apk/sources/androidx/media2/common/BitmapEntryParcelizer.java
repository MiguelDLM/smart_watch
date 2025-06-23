package androidx.media2.common;

import android.graphics.Bitmap;
import androidx.annotation.RestrictTo;
import androidx.media2.common.MediaMetadata;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class BitmapEntryParcelizer {
    public static MediaMetadata.BitmapEntry read(VersionedParcel versionedParcel) {
        MediaMetadata.BitmapEntry bitmapEntry = new MediaMetadata.BitmapEntry();
        bitmapEntry.mKey = versionedParcel.readString(bitmapEntry.mKey, 1);
        bitmapEntry.mBitmap = (Bitmap) versionedParcel.readParcelable(bitmapEntry.mBitmap, 2);
        return bitmapEntry;
    }

    public static void write(MediaMetadata.BitmapEntry bitmapEntry, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeString(bitmapEntry.mKey, 1);
        versionedParcel.writeParcelable(bitmapEntry.mBitmap, 2);
    }
}
