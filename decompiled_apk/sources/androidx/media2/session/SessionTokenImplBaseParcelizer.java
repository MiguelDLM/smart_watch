package androidx.media2.session;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SessionTokenImplBaseParcelizer {
    public static SessionTokenImplBase read(VersionedParcel versionedParcel) {
        SessionTokenImplBase sessionTokenImplBase = new SessionTokenImplBase();
        sessionTokenImplBase.mUid = versionedParcel.readInt(sessionTokenImplBase.mUid, 1);
        sessionTokenImplBase.mType = versionedParcel.readInt(sessionTokenImplBase.mType, 2);
        sessionTokenImplBase.mPackageName = versionedParcel.readString(sessionTokenImplBase.mPackageName, 3);
        sessionTokenImplBase.mServiceName = versionedParcel.readString(sessionTokenImplBase.mServiceName, 4);
        sessionTokenImplBase.mISession = versionedParcel.readStrongBinder(sessionTokenImplBase.mISession, 5);
        sessionTokenImplBase.mComponentName = (ComponentName) versionedParcel.readParcelable(sessionTokenImplBase.mComponentName, 6);
        sessionTokenImplBase.mExtras = versionedParcel.readBundle(sessionTokenImplBase.mExtras, 7);
        return sessionTokenImplBase;
    }

    public static void write(SessionTokenImplBase sessionTokenImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(sessionTokenImplBase.mUid, 1);
        versionedParcel.writeInt(sessionTokenImplBase.mType, 2);
        versionedParcel.writeString(sessionTokenImplBase.mPackageName, 3);
        versionedParcel.writeString(sessionTokenImplBase.mServiceName, 4);
        versionedParcel.writeStrongBinder(sessionTokenImplBase.mISession, 5);
        versionedParcel.writeParcelable(sessionTokenImplBase.mComponentName, 6);
        versionedParcel.writeBundle(sessionTokenImplBase.mExtras, 7);
    }
}
