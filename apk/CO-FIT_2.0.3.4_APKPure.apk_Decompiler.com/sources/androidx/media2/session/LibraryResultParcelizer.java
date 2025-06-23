package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class LibraryResultParcelizer {
    public static LibraryResult read(VersionedParcel versionedParcel) {
        LibraryResult libraryResult = new LibraryResult();
        libraryResult.mResultCode = versionedParcel.readInt(libraryResult.mResultCode, 1);
        libraryResult.mCompletionTime = versionedParcel.readLong(libraryResult.mCompletionTime, 2);
        libraryResult.mParcelableItem = (MediaItem) versionedParcel.readVersionedParcelable(libraryResult.mParcelableItem, 3);
        libraryResult.mParams = (MediaLibraryService.LibraryParams) versionedParcel.readVersionedParcelable(libraryResult.mParams, 4);
        libraryResult.mItemListSlice = (ParcelImplListSlice) versionedParcel.readParcelable(libraryResult.mItemListSlice, 5);
        libraryResult.onPostParceling();
        return libraryResult;
    }

    public static void write(LibraryResult libraryResult, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        libraryResult.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeInt(libraryResult.mResultCode, 1);
        versionedParcel.writeLong(libraryResult.mCompletionTime, 2);
        versionedParcel.writeVersionedParcelable(libraryResult.mParcelableItem, 3);
        versionedParcel.writeVersionedParcelable(libraryResult.mParams, 4);
        versionedParcel.writeParcelable(libraryResult.mItemListSlice, 5);
    }
}
