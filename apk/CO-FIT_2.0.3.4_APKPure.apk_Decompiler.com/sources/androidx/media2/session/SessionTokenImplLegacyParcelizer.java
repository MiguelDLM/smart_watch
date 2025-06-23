package androidx.media2.session;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SessionTokenImplLegacyParcelizer {
    public static SessionTokenImplLegacy read(VersionedParcel versionedParcel) {
        SessionTokenImplLegacy sessionTokenImplLegacy = new SessionTokenImplLegacy();
        sessionTokenImplLegacy.mLegacyTokenBundle = versionedParcel.readBundle(sessionTokenImplLegacy.mLegacyTokenBundle, 1);
        sessionTokenImplLegacy.mUid = versionedParcel.readInt(sessionTokenImplLegacy.mUid, 2);
        sessionTokenImplLegacy.mType = versionedParcel.readInt(sessionTokenImplLegacy.mType, 3);
        sessionTokenImplLegacy.mComponentName = (ComponentName) versionedParcel.readParcelable(sessionTokenImplLegacy.mComponentName, 4);
        sessionTokenImplLegacy.mPackageName = versionedParcel.readString(sessionTokenImplLegacy.mPackageName, 5);
        sessionTokenImplLegacy.mExtras = versionedParcel.readBundle(sessionTokenImplLegacy.mExtras, 6);
        sessionTokenImplLegacy.onPostParceling();
        return sessionTokenImplLegacy;
    }

    public static void write(SessionTokenImplLegacy sessionTokenImplLegacy, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        sessionTokenImplLegacy.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeBundle(sessionTokenImplLegacy.mLegacyTokenBundle, 1);
        versionedParcel.writeInt(sessionTokenImplLegacy.mUid, 2);
        versionedParcel.writeInt(sessionTokenImplLegacy.mType, 3);
        versionedParcel.writeParcelable(sessionTokenImplLegacy.mComponentName, 4);
        versionedParcel.writeString(sessionTokenImplLegacy.mPackageName, 5);
        versionedParcel.writeBundle(sessionTokenImplLegacy.mExtras, 6);
    }
}
