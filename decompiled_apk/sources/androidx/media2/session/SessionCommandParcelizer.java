package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SessionCommandParcelizer {
    public static SessionCommand read(VersionedParcel versionedParcel) {
        SessionCommand sessionCommand = new SessionCommand();
        sessionCommand.mCommandCode = versionedParcel.readInt(sessionCommand.mCommandCode, 1);
        sessionCommand.mCustomAction = versionedParcel.readString(sessionCommand.mCustomAction, 2);
        sessionCommand.mCustomExtras = versionedParcel.readBundle(sessionCommand.mCustomExtras, 3);
        return sessionCommand;
    }

    public static void write(SessionCommand sessionCommand, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(sessionCommand.mCommandCode, 1);
        versionedParcel.writeString(sessionCommand.mCustomAction, 2);
        versionedParcel.writeBundle(sessionCommand.mCustomExtras, 3);
    }
}
