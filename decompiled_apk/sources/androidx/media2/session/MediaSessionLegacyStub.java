package androidx.media2.session;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    final ConnectionTimeoutHandler mConnectionTimeoutHandler;
    volatile long mConnectionTimeoutMs;
    final Context mContext;
    final MediaSession.ControllerCb mControllerLegacyCbForBroadcast;
    final MediaSession.MediaSessionImpl mSessionImpl;
    final androidx.media.MediaSessionManager mSessionManager;
    private static final String TAG = "MediaSessionLegacyStub";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final SparseArray<SessionCommand> sCommandsForOnCommandRequest = new SparseArray<>();

    /* loaded from: classes.dex */
    public class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;

        public ConnectionTimeoutHandler(Looper looper) {
            super(looper);
        }

        public void disconnectControllerAfterTimeout(@NonNull MediaSession.ControllerInfo controllerInfo, long j) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            if (MediaSessionLegacyStub.this.mConnectedControllersManager.isConnected(controllerInfo)) {
                try {
                    controllerInfo.getControllerCb().onDisconnected(0);
                } catch (RemoteException unused) {
                }
                MediaSessionLegacyStub.this.mConnectedControllersManager.removeController(controllerInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerLegacyCb extends MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == ControllerLegacyCb.class) {
                return ObjectsCompat.equals(this.mRemoteUserInfo, ((ControllerLegacyCb) obj).mRemoteUserInfo);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mRemoteUserInfo);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerLegacyCbForBroadcast extends MediaSession.ControllerCb {
        public ControllerLegacyCbForBroadcast() {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            MediaMetadataCompat convertToMediaMetadataCompat;
            MediaSessionCompat sessionCompat = MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat();
            if (mediaItem == null) {
                convertToMediaMetadataCompat = null;
            } else {
                convertToMediaMetadataCompat = MediaUtils.convertToMediaMetadataCompat(mediaItem.getMetadata());
            }
            sessionCompat.setMetadata(convertToMediaMetadataCompat);
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i) throws RemoteException {
            PlaybackStateCompat createPlaybackStateCompat = MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat();
            if (createPlaybackStateCompat.getState() != 2) {
                createPlaybackStateCompat = new PlaybackStateCompat.Builder(createPlaybackStateCompat).setState(2, createPlaybackStateCompat.getPosition(), createPlaybackStateCompat.getPlaybackSpeed()).build();
            }
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(createPlaybackStateCompat);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setQueue(MediaUtils.convertToQueueItemList(list));
            onPlaylistMetadataChanged(i, mediaMetadata);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            CharSequence charSequence;
            CharSequence queueTitle = MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().getController().getQueueTitle();
            if (mediaMetadata != null) {
                charSequence = mediaMetadata.getText("android.media.metadata.DISPLAY_TITLE");
                if (charSequence == null) {
                    charSequence = mediaMetadata.getText("android.media.metadata.TITLE");
                }
            } else {
                charSequence = null;
            }
            if (!TextUtils.equals(queueTitle, charSequence)) {
                MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setQueueTitle(charSequence);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setRepeatMode(i2);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setShuffleMode(i2);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    static {
        for (SessionCommand sessionCommand : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(sessionCommand.getCommandCode(), sessionCommand);
        }
    }

    public MediaSessionLegacyStub(MediaSession.MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mControllerLegacyCbForBroadcast = new ControllerLegacyCbForBroadcast();
        this.mConnectionTimeoutHandler = new ConnectionTimeoutHandler(handler.getLooper());
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
        this.mConnectionTimeoutMs = 300000L;
    }

    private void dispatchSessionTask(int i, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(null, i, sessionTask);
    }

    private void dispatchSessionTaskInternal(@Nullable final SessionCommand sessionCommand, final int i, @NonNull final SessionTask sessionTask) {
        if (this.mSessionImpl.isClosed()) {
            return;
        }
        final MediaSessionManager.RemoteUserInfo currentControllerInfo = this.mSessionImpl.getSessionCompat().getCurrentControllerInfo();
        if (currentControllerInfo == null) {
            Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + sessionCommand + ", commandCode=" + i);
            return;
        }
        this.mSessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaSessionLegacyStub.21
            @Override // java.lang.Runnable
            public void run() {
                if (MediaSessionLegacyStub.this.mSessionImpl.isClosed()) {
                    return;
                }
                MediaSession.ControllerInfo controller = MediaSessionLegacyStub.this.mConnectedControllersManager.getController(currentControllerInfo);
                if (controller == null) {
                    MediaSessionManager.RemoteUserInfo remoteUserInfo = currentControllerInfo;
                    controller = new MediaSession.ControllerInfo(remoteUserInfo, -1, MediaSessionLegacyStub.this.mSessionManager.isTrustedForMediaControl(remoteUserInfo), new ControllerLegacyCb(currentControllerInfo), null);
                    SessionCommandGroup onConnect = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onConnect(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controller);
                    if (onConnect == null) {
                        try {
                            controller.getControllerCb().onDisconnected(0);
                            return;
                        } catch (RemoteException unused) {
                            return;
                        }
                    }
                    MediaSessionLegacyStub.this.mConnectedControllersManager.addController(controller.getRemoteUserInfo(), controller, onConnect);
                }
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.mConnectionTimeoutHandler.disconnectControllerAfterTimeout(controller, mediaSessionLegacyStub.mConnectionTimeoutMs);
                MediaSessionLegacyStub.this.handleTaskOnExecutor(controller, sessionCommand, i, sessionTask);
            }
        });
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.mConnectedControllersManager;
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        return this.mControllerLegacyCbForBroadcast;
    }

    public void handleTaskOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @Nullable SessionCommand sessionCommand, int i, @NonNull SessionTask sessionTask) {
        SessionCommand sessionCommand2;
        if (sessionCommand != null) {
            if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, sessionCommand)) {
                return;
            } else {
                sessionCommand2 = sCommandsForOnCommandRequest.get(sessionCommand.getCommandCode());
            }
        } else if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, i)) {
            return;
        } else {
            sessionCommand2 = sCommandsForOnCommandRequest.get(i);
        }
        if (sessionCommand2 != null && this.mSessionImpl.getCallback().onCommandRequest(this.mSessionImpl.getInstance(), controllerInfo, sessionCommand2) != 0) {
            if (DEBUG) {
                Log.d(TAG, "Command (" + sessionCommand2 + ") from " + controllerInfo + " was rejected by " + this.mSessionImpl);
                return;
            }
            return;
        }
        try {
            sessionTask.run(controllerInfo);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfo, e);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        onAddQueueItem(mediaDescriptionCompat, Integer.MAX_VALUE);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (str == null) {
            return;
        }
        final SessionCommand sessionCommand = new SessionCommand(str, null);
        dispatchSessionTask(sessionCommand, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.1
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                SessionResult onCustomCommand = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCustomCommand(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, sessionCommand, bundle);
                ResultReceiver resultReceiver2 = resultReceiver;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(onCustomCommand.getResultCode(), onCustomCommand.getCustomCommandResult());
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(@NonNull String str, @Nullable Bundle bundle) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        dispatchSessionTask(40000, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.13
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onFastForward(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        dispatchSessionTask(10001, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.6
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.pause();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        dispatchSessionTask(10000, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.4
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.play();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.5
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.play();
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        dispatchSessionTask(10002, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.2
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.prepare();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.3
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.prepare();
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(10014, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.19
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                String mediaId = mediaDescriptionCompat.getMediaId();
                if (TextUtils.isEmpty(mediaId)) {
                    Log.w(MediaSessionLegacyStub.TAG, "onRemoveQueueItem(): Media ID shouldn't be null");
                    return;
                }
                List<MediaItem> playlist = MediaSessionLegacyStub.this.mSessionImpl.getPlaylist();
                for (int i = 0; i < playlist.size(); i++) {
                    if (TextUtils.equals(playlist.get(i).getMediaId(), mediaId)) {
                        MediaSessionLegacyStub.this.mSessionImpl.removePlaylistItem(i);
                        return;
                    }
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(final int i) {
        dispatchSessionTask(10014, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.20
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                int i2 = i;
                if (i2 < 0) {
                    Log.w(MediaSessionLegacyStub.TAG, "onRemoveQueueItem(): index shouldn't be negative");
                } else {
                    MediaSessionLegacyStub.this.mSessionImpl.removePlaylistItem(i2);
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        dispatchSessionTask(40001, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.14
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onRewind(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(final long j) {
        dispatchSessionTask(10003, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.8
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.seekTo(j);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(final float f) {
        dispatchSessionTask(10004, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.11
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setPlaybackSpeed(f);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, null);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(final int i) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.16
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setRepeatMode(i);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(final int i) {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.17
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setShuffleMode(i);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.9
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.skipToNextItem();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        dispatchSessionTask(10008, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.10
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.skipToPreviousItem();
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(final long j) {
        dispatchSessionTask(10007, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.12
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getPlayer().getPlaylist() == null) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.skipToPlaylistItem((int) j);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        dispatchSessionTask(10001, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.7
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.handleTaskOnExecutor(controllerInfo, null, 10003, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.7.1
                    @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                    public void run(MediaSession.ControllerInfo controllerInfo2) throws RemoteException {
                        MediaSessionLegacyStub.this.mSessionImpl.pause();
                        MediaSessionLegacyStub.this.mSessionImpl.seekTo(0L);
                    }
                });
            }
        });
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j) {
        this.mConnectionTimeoutMs = j;
    }

    private void dispatchSessionTask(@NonNull SessionCommand sessionCommand, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal(sessionCommand, 0, sessionTask);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int i) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.18
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                String mediaId = mediaDescriptionCompat.getMediaId();
                if (TextUtils.isEmpty(mediaId)) {
                    Log.w(MediaSessionLegacyStub.TAG, "onAddQueueItem(): Media ID shouldn't be empty");
                } else {
                    MediaSessionLegacyStub.this.mSessionImpl.addPlaylistItem(i, MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCreateMediaItem(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, mediaId));
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(final RatingCompat ratingCompat, Bundle bundle) {
        if (ratingCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask() { // from class: androidx.media2.session.MediaSessionLegacyStub.15
            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaItem currentMediaItem = MediaSessionLegacyStub.this.mSessionImpl.getCurrentMediaItem();
                if (currentMediaItem == null) {
                    return;
                }
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetRating(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, currentMediaItem.getMediaId(), MediaUtils.convertToRating(ratingCompat));
            }
        });
    }
}
