package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class LibraryParamsParcelizer {
    public static MediaLibraryService.LibraryParams read(VersionedParcel versionedParcel) {
        MediaLibraryService.LibraryParams libraryParams = new MediaLibraryService.LibraryParams();
        libraryParams.mBundle = versionedParcel.readBundle(libraryParams.mBundle, 1);
        libraryParams.mRecent = versionedParcel.readInt(libraryParams.mRecent, 2);
        libraryParams.mOffline = versionedParcel.readInt(libraryParams.mOffline, 3);
        libraryParams.mSuggested = versionedParcel.readInt(libraryParams.mSuggested, 4);
        return libraryParams;
    }

    public static void write(MediaLibraryService.LibraryParams libraryParams, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeBundle(libraryParams.mBundle, 1);
        versionedParcel.writeInt(libraryParams.mRecent, 2);
        versionedParcel.writeInt(libraryParams.mOffline, 3);
        versionedParcel.writeInt(libraryParams.mSuggested, 4);
    }
}
