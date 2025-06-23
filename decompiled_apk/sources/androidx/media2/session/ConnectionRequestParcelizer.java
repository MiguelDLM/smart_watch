package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class ConnectionRequestParcelizer {
    public static ConnectionRequest read(VersionedParcel versionedParcel) {
        ConnectionRequest connectionRequest = new ConnectionRequest();
        connectionRequest.mVersion = versionedParcel.readInt(connectionRequest.mVersion, 0);
        connectionRequest.mPackageName = versionedParcel.readString(connectionRequest.mPackageName, 1);
        connectionRequest.mPid = versionedParcel.readInt(connectionRequest.mPid, 2);
        connectionRequest.mConnectionHints = versionedParcel.readBundle(connectionRequest.mConnectionHints, 3);
        return connectionRequest;
    }

    public static void write(ConnectionRequest connectionRequest, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(connectionRequest.mVersion, 0);
        versionedParcel.writeString(connectionRequest.mPackageName, 1);
        versionedParcel.writeInt(connectionRequest.mPid, 2);
        versionedParcel.writeBundle(connectionRequest.mConnectionHints, 3);
    }
}
