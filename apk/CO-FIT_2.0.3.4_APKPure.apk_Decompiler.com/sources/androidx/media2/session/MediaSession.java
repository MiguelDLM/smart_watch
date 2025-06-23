package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaInterface;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.VersionedParcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;

public class MediaSession implements Closeable {
    @GuardedBy("STATIC_LOCK")
    private static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP = new HashMap<>();
    private static final Object STATIC_LOCK = new Object();
    static final String TAG = "MediaSession";
    private final MediaSessionImpl mImpl;

    public static final class Builder extends BuilderBase<MediaSession, Builder, SessionCallback> {
        public Builder(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            super(context, sessionPlayer);
        }

        @NonNull
        public MediaSession build() {
            if (this.mCallbackExecutor == null) {
                this.mCallbackExecutor = ContextCompat.getMainExecutor(this.mContext);
            }
            if (this.mCallback == null) {
                this.mCallback = new SessionCallback() {
                };
            }
            return new MediaSession(this.mContext, this.mId, this.mPlayer, this.mSessionActivity, this.mCallbackExecutor, this.mCallback, this.mExtras);
        }

        @NonNull
        public Builder setExtras(@NonNull Bundle bundle) {
            return (Builder) super.setExtras(bundle);
        }

        @NonNull
        public Builder setId(@NonNull String str) {
            return (Builder) super.setId(str);
        }

        @NonNull
        public Builder setSessionActivity(@Nullable PendingIntent pendingIntent) {
            return (Builder) super.setSessionActivity(pendingIntent);
        }

        @NonNull
        public Builder setSessionCallback(@NonNull Executor executor, @NonNull SessionCallback sessionCallback) {
            return (Builder) super.setSessionCallback(executor, sessionCallback);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class BuilderBase<T extends MediaSession, U extends BuilderBase<T, U, C>, C extends SessionCallback> {
        C mCallback;
        Executor mCallbackExecutor;
        final Context mContext;
        Bundle mExtras;
        String mId;
        SessionPlayer mPlayer;
        PendingIntent mSessionActivity;

        public BuilderBase(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            if (context == null) {
                throw new NullPointerException("context shouldn't be null");
            } else if (sessionPlayer != null) {
                this.mContext = context;
                this.mPlayer = sessionPlayer;
                this.mId = "";
            } else {
                throw new NullPointerException("player shouldn't be null");
            }
        }

        @NonNull
        public abstract T build();

        @NonNull
        public U setExtras(@NonNull Bundle bundle) {
            if (bundle == null) {
                throw new NullPointerException("extras shouldn't be null");
            } else if (!MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                this.mExtras = new Bundle(bundle);
                return this;
            } else {
                throw new IllegalArgumentException("extras shouldn't contain any custom parcelables");
            }
        }

        @NonNull
        public U setId(@NonNull String str) {
            if (str != null) {
                this.mId = str;
                return this;
            }
            throw new NullPointerException("id shouldn't be null");
        }

        @NonNull
        public U setSessionActivity(@Nullable PendingIntent pendingIntent) {
            this.mSessionActivity = pendingIntent;
            return this;
        }

        @NonNull
        public U setSessionCallback(@NonNull Executor executor, @NonNull C c) {
            if (executor == null) {
                throw new NullPointerException("executor shouldn't be null");
            } else if (c != null) {
                this.mCallbackExecutor = executor;
                this.mCallback = c;
                return this;
            } else {
                throw new NullPointerException("callback shouldn't be null");
            }
        }
    }

    public static final class CommandButton implements VersionedParcelable {
        SessionCommand mCommand;
        CharSequence mDisplayName;
        boolean mEnabled;
        Bundle mExtras;
        int mIconResId;

        public static final class Builder {
            private SessionCommand mCommand;
            private CharSequence mDisplayName;
            private boolean mEnabled;
            private Bundle mExtras;
            private int mIconResId;

            @NonNull
            public CommandButton build() {
                return new CommandButton(this.mCommand, this.mIconResId, this.mDisplayName, this.mExtras, this.mEnabled);
            }

            @NonNull
            public Builder setCommand(@Nullable SessionCommand sessionCommand) {
                this.mCommand = sessionCommand;
                return this;
            }

            @NonNull
            public Builder setDisplayName(@Nullable CharSequence charSequence) {
                this.mDisplayName = charSequence;
                return this;
            }

            @NonNull
            public Builder setEnabled(boolean z) {
                this.mEnabled = z;
                return this;
            }

            @NonNull
            public Builder setExtras(@Nullable Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            @NonNull
            public Builder setIconResId(int i) {
                this.mIconResId = i;
                return this;
            }
        }

        public CommandButton() {
        }

        @Nullable
        public SessionCommand getCommand() {
            return this.mCommand;
        }

        @Nullable
        public CharSequence getDisplayName() {
            return this.mDisplayName;
        }

        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIconResId() {
            return this.mIconResId;
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public CommandButton(@Nullable SessionCommand sessionCommand, int i, @Nullable CharSequence charSequence, Bundle bundle, boolean z) {
            this.mCommand = sessionCommand;
            this.mIconResId = i;
            this.mDisplayName = charSequence;
            this.mExtras = bundle;
            this.mEnabled = z;
        }
    }

    public static abstract class ControllerCb {
        public abstract void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException;

        public abstract void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException;

        public abstract void onChildrenChanged(int i, @NonNull String str, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        public abstract void onCurrentMediaItemChanged(int i, @Nullable MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException;

        public abstract void onDisconnected(int i) throws RemoteException;

        public abstract void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException;

        public abstract void onPlaybackCompleted(int i) throws RemoteException;

        public abstract void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException;

        public abstract void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException;

        public abstract void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException;

        public abstract void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException;

        public abstract void onPlaylistChanged(int i, @NonNull List<MediaItem> list, @Nullable MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException;

        public abstract void onPlaylistMetadataChanged(int i, @Nullable MediaMetadata mediaMetadata) throws RemoteException;

        public abstract void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

        public abstract void onSearchResultChanged(int i, @NonNull String str, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        public abstract void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException;

        public abstract void onSessionResult(int i, SessionResult sessionResult) throws RemoteException;

        public abstract void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

        public abstract void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) throws RemoteException;

        public abstract void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException;

        public abstract void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException;

        public abstract void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException;

        public abstract void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException;

        public abstract void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) throws RemoteException;

        public abstract void setCustomLayout(int i, @NonNull List<CommandButton> list) throws RemoteException;
    }

    public static final class ControllerInfo {
        private final Bundle mConnectionHints;
        private final ControllerCb mControllerCb;
        private final int mControllerVersion;
        private final boolean mIsTrusted;
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerInfo(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, boolean z, @Nullable ControllerCb controllerCb, @Nullable Bundle bundle) {
            this.mRemoteUserInfo = remoteUserInfo;
            this.mControllerVersion = i;
            this.mIsTrusted = z;
            this.mControllerCb = controllerCb;
            if (bundle == null || MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                this.mConnectionHints = null;
            } else {
                this.mConnectionHints = bundle;
            }
        }

        @NonNull
        public static ControllerInfo createLegacyControllerInfo() {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1), -1, false, (ControllerCb) null, (Bundle) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.mControllerCb;
            if (controllerCb == null && controllerInfo.mControllerCb == null) {
                return this.mRemoteUserInfo.equals(controllerInfo.mRemoteUserInfo);
            }
            return ObjectsCompat.equals(controllerCb, controllerInfo.mControllerCb);
        }

        @NonNull
        public Bundle getConnectionHints() {
            if (this.mConnectionHints == null) {
                return Bundle.EMPTY;
            }
            return new Bundle(this.mConnectionHints);
        }

        @Nullable
        public ControllerCb getControllerCb() {
            return this.mControllerCb;
        }

        @NonNull
        public String getPackageName() {
            return this.mRemoteUserInfo.getPackageName();
        }

        public MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.mRemoteUserInfo;
        }

        public int getUid() {
            return this.mRemoteUserInfo.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mControllerCb, this.mRemoteUserInfo);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isTrusted() {
            return this.mIsTrusted;
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.mRemoteUserInfo.getPackageName() + ", uid=" + this.mRemoteUserInfo.getUid() + "})";
        }
    }

    public interface MediaSessionImpl extends MediaInterface.SessionPlayer, Closeable {
        void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void connectFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle);

        PlaybackStateCompat createPlaybackStateCompat();

        SessionCallback getCallback();

        Executor getCallbackExecutor();

        @NonNull
        List<ControllerInfo> getConnectedControllers();

        Context getContext();

        @NonNull
        String getId();

        MediaSession getInstance();

        IBinder getLegacyBrowserServiceBinder();

        MediaController.PlaybackInfo getPlaybackInfo();

        @NonNull
        SessionPlayer getPlayer();

        PendingIntent getSessionActivity();

        MediaSessionCompat getSessionCompat();

        @NonNull
        SessionToken getToken();

        @NonNull
        Uri getUri();

        boolean isClosed();

        boolean isConnected(@NonNull ControllerInfo controllerInfo);

        ListenableFuture<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup);

        ListenableFuture<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list);

        void setLegacyControllerConnectionTimeoutMs(long j);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2);
    }

    public static abstract class SessionCallback {
        ForegroundServiceEventCallback mForegroundServiceEventCallback;

        public static abstract class ForegroundServiceEventCallback {
            public void onNotificationUpdateNeeded(MediaSession mediaSession) {
            }

            public void onPlayerStateChanged(MediaSession mediaSession, int i) {
            }

            public void onSessionClosed(MediaSession mediaSession) {
            }
        }

        public int onCommandRequest(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand) {
            return 0;
        }

        @Nullable
        public SessionCommandGroup onConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return new SessionCommandGroup.Builder().addAllPredefinedCommands(2).build();
        }

        @Nullable
        public MediaItem onCreateMediaItem(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str) {
            return null;
        }

        public final void onCurrentMediaItemChanged(MediaSession mediaSession) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onNotificationUpdateNeeded(mediaSession);
            }
        }

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            return new SessionResult(-6, (Bundle) null);
        }

        public void onDisconnected(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
        }

        public int onFastForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public final void onPlayerStateChanged(MediaSession mediaSession, int i) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onPlayerStateChanged(mediaSession, i);
            }
        }

        public void onPostConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
        }

        public int onRewind(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public final void onSessionClosed(MediaSession mediaSession) {
            ForegroundServiceEventCallback foregroundServiceEventCallback = this.mForegroundServiceEventCallback;
            if (foregroundServiceEventCallback != null) {
                foregroundServiceEventCallback.onSessionClosed(mediaSession);
            }
        }

        public int onSetMediaUri(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull Uri uri, @Nullable Bundle bundle) {
            return -6;
        }

        public int onSetRating(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str, @NonNull Rating rating) {
            return -6;
        }

        public int onSkipBackward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public int onSkipForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            return -6;
        }

        public void setForegroundServiceEventCallback(ForegroundServiceEventCallback foregroundServiceEventCallback) {
            this.mForegroundServiceEventCallback = foregroundServiceEventCallback;
        }
    }

    public MediaSession(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        synchronized (STATIC_LOCK) {
            HashMap<String, MediaSession> hashMap = SESSION_ID_TO_SESSION_MAP;
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, this);
            } else {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
        }
        this.mImpl = createImpl(context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    public static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            try {
                for (MediaSession next : SESSION_ID_TO_SESSION_MAP.values()) {
                    if (ObjectsCompat.equals(next.getUri(), uri)) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private Uri getUri() {
        return this.mImpl.getUri();
    }

    public void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        if (sessionCommand == null) {
            throw new NullPointerException("command shouldn't be null");
        } else if (sessionCommand.getCommandCode() == 0) {
            this.mImpl.broadcastCustomCommand(sessionCommand, bundle);
        } else {
            throw new IllegalArgumentException("command should be a custom command");
        }
    }

    public void close() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.mImpl.getId());
            }
            this.mImpl.close();
        } catch (Exception unused) {
        }
    }

    public MediaSessionImpl createImpl(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        return new MediaSessionImplBase(this, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    @NonNull
    public SessionCallback getCallback() {
        return this.mImpl.getCallback();
    }

    @NonNull
    public Executor getCallbackExecutor() {
        return this.mImpl.getCallbackExecutor();
    }

    @NonNull
    public List<ControllerInfo> getConnectedControllers() {
        return this.mImpl.getConnectedControllers();
    }

    @NonNull
    public Context getContext() {
        return this.mImpl.getContext();
    }

    @NonNull
    public String getId() {
        return this.mImpl.getId();
    }

    public MediaSessionImpl getImpl() {
        return this.mImpl;
    }

    public IBinder getLegacyBrowerServiceBinder() {
        return this.mImpl.getLegacyBrowserServiceBinder();
    }

    @NonNull
    public SessionPlayer getPlayer() {
        return this.mImpl.getPlayer();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MediaSessionCompat getSessionCompat() {
        return this.mImpl.getSessionCompat();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionCompatToken() {
        return this.mImpl.getSessionCompat().getSessionToken();
    }

    @NonNull
    public SessionToken getToken() {
        return this.mImpl.getToken();
    }

    public void handleControllerConnectionFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle) {
        this.mImpl.connectFromService(iMediaController, i, str, i2, i3, bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isClosed() {
        return this.mImpl.isClosed();
    }

    @NonNull
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        if (controllerInfo == null) {
            throw new NullPointerException("controller shouldn't be null");
        } else if (sessionCommand == null) {
            throw new NullPointerException("command shouldn't be null");
        } else if (sessionCommand.getCommandCode() == 0) {
            return this.mImpl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
        } else {
            throw new IllegalArgumentException("command should be a custom command");
        }
    }

    public void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup) {
        if (controllerInfo == null) {
            throw new NullPointerException("controller shouldn't be null");
        } else if (sessionCommandGroup != null) {
            this.mImpl.setAllowedCommands(controllerInfo, sessionCommandGroup);
        } else {
            throw new NullPointerException("commands shouldn't be null");
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list) {
        if (controllerInfo == null) {
            throw new NullPointerException("controller shouldn't be null");
        } else if (list != null) {
            return this.mImpl.setCustomLayout(controllerInfo, list);
        } else {
            throw new NullPointerException("layout shouldn't be null");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.mImpl.setLegacyControllerConnectionTimeoutMs(j);
    }

    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        if (sessionPlayer != null) {
            this.mImpl.updatePlayer(sessionPlayer);
            return;
        }
        throw new NullPointerException("player shouldn't be null");
    }
}
