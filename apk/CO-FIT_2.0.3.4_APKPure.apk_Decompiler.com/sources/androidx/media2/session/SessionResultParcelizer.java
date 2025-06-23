package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.common.MediaItem;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SessionResultParcelizer {
    public static SessionResult read(VersionedParcel versionedParcel) {
        SessionResult sessionResult = new SessionResult();
        sessionResult.mResultCode = versionedParcel.readInt(sessionResult.mResultCode, 1);
        sessionResult.mCompletionTime = versionedParcel.readLong(sessionResult.mCompletionTime, 2);
        sessionResult.mCustomCommandResult = versionedParcel.readBundle(sessionResult.mCustomCommandResult, 3);
        sessionResult.mParcelableItem = (MediaItem) versionedParcel.readVersionedParcelable(sessionResult.mParcelableItem, 4);
        sessionResult.onPostParceling();
        return sessionResult;
    }

    public static void write(SessionResult sessionResult, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        sessionResult.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeInt(sessionResult.mResultCode, 1);
        versionedParcel.writeLong(sessionResult.mCompletionTime, 2);
        versionedParcel.writeBundle(sessionResult.mCustomCommandResult, 3);
        versionedParcel.writeVersionedParcelable(sessionResult.mParcelableItem, 4);
    }
}
