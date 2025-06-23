package androidx.media2.session;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.media2.common.SessionPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public abstract class RemoteSessionPlayer extends SessionPlayer {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* loaded from: classes.dex */
    public static class Callback extends SessionPlayer.PlayerCallback {
        public void onVolumeChanged(@NonNull RemoteSessionPlayer remoteSessionPlayer, int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface VolumeControlType {
    }

    @NonNull
    public abstract Future<SessionPlayer.PlayerResult> adjustVolume(int i);

    public abstract int getMaxVolume();

    public abstract int getVolume();

    public abstract int getVolumeControlType();

    @NonNull
    public abstract Future<SessionPlayer.PlayerResult> setVolume(int i);
}
