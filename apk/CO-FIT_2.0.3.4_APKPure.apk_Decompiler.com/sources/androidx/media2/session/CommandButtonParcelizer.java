package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class CommandButtonParcelizer {
    public static MediaSession.CommandButton read(VersionedParcel versionedParcel) {
        MediaSession.CommandButton commandButton = new MediaSession.CommandButton();
        commandButton.mCommand = (SessionCommand) versionedParcel.readVersionedParcelable(commandButton.mCommand, 1);
        commandButton.mIconResId = versionedParcel.readInt(commandButton.mIconResId, 2);
        commandButton.mDisplayName = versionedParcel.readCharSequence(commandButton.mDisplayName, 3);
        commandButton.mExtras = versionedParcel.readBundle(commandButton.mExtras, 4);
        commandButton.mEnabled = versionedParcel.readBoolean(commandButton.mEnabled, 5);
        return commandButton;
    }

    public static void write(MediaSession.CommandButton commandButton, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(commandButton.mCommand, 1);
        versionedParcel.writeInt(commandButton.mIconResId, 2);
        versionedParcel.writeCharSequence(commandButton.mDisplayName, 3);
        versionedParcel.writeBundle(commandButton.mExtras, 4);
        versionedParcel.writeBoolean(commandButton.mEnabled, 5);
    }
}
