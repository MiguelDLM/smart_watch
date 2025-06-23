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

class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    private static final String TAG = "MediaSessionLegacyStub";
    static final SparseArray<SessionCommand> sCommandsForOnCommandRequest = new SparseArray<>();
    final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    final ConnectionTimeoutHandler mConnectionTimeoutHandler;
    volatile long mConnectionTimeoutMs;
    final Context mContext;
    final MediaSession.ControllerCb mControllerLegacyCbForBroadcast = new ControllerLegacyCbForBroadcast();
    final MediaSession.MediaSessionImpl mSessionImpl;
    final MediaSessionManager mSessionManager;

    public class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;

        public ConnectionTimeoutHandler(Looper looper) {
            super(looper);
        }

        public void disconnectControllerAfterTimeout(@NonNull MediaSession.ControllerInfo controllerInfo, long j) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j);
        }

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

    public final class ControllerLegacyCb extends MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return ObjectsCompat.equals(this.mRemoteUserInfo, ((ControllerLegacyCb) obj).mRemoteUserInfo);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mRemoteUserInfo);
        }

        public void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
        }

        public void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onDisconnected(int i) throws RemoteException {
        }

        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
        }

        public void onPlaybackCompleted(int i) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
        }

        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
        }

        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
        }

        public void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        public void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
        }
    }

    public final class ControllerLegacyCbForBroadcast extends MediaSession.ControllerCb {
        public ControllerLegacyCbForBroadcast() {
        }

        public void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }

        public void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            MediaMetadataCompat mediaMetadataCompat;
            MediaSessionCompat sessionCompat = MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat();
            if (mediaItem == null) {
                mediaMetadataCompat = null;
            } else {
                mediaMetadataCompat = MediaUtils.convertToMediaMetadataCompat(mediaItem.getMetadata());
            }
            sessionCompat.setMetadata(mediaMetadataCompat);
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        public void onDisconnected(int i) throws RemoteException {
        }

        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
        }

        public void onPlaybackCompleted(int i) throws RemoteException {
            PlaybackStateCompat createPlaybackStateCompat = MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat();
            if (createPlaybackStateCompat.getState() != 2) {
                createPlaybackStateCompat = new PlaybackStateCompat.Builder(createPlaybackStateCompat).setState(2, createPlaybackStateCompat.getPosition(), createPlaybackStateCompat.getPlaybackSpeed()).build();
            }
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(createPlaybackStateCompat);
        }

        public void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
        }

        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
        }

        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        public void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setQueue(MediaUtils.convertToQueueItemList(list));
            onPlaylistMetadataChanged(i, mediaMetadata);
        }

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

        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setRepeatMode(i2);
        }

        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.mSessionImpl.createPlaybackStateCompat());
        }

        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            MediaSessionLegacyStub.this.mSessionImpl.getSessionCompat().setShuffleMode(i2);
        }

        public void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
        }

        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
        }

        public void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        public void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
            throw new AssertionError("This shouldn't be called");
        }
    }

    @FunctionalInterface
    public interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    static {
        for (SessionCommand next : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(next.getCommandCode(), next);
        }
    }

    public MediaSessionLegacyStub(MediaSession.MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = MediaSessionManager.getSessionManager(context);
        this.mConnectionTimeoutHandler = new ConnectionTimeoutHandler(handler.getLooper());
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
        this.mConnectionTimeoutMs = 300000;
    }

    private void dispatchSessionTask(int i, @NonNull SessionTask sessionTask) {
        dispatchSessionTaskInternal((SessionCommand) null, i, sessionTask);
    }

    private void dispatchSessionTaskInternal(@Nullable SessionCommand sessionCommand, int i, @NonNull SessionTask sessionTask) {
        if (!this.mSessionImpl.isClosed()) {
            final MediaSessionManager.RemoteUserInfo currentControllerInfo = this.mSessionImpl.getSessionCompat().getCurrentControllerInfo();
            if (currentControllerInfo == null) {
                Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + sessionCommand + ", commandCode=" + i);
                return;
            }
            final SessionCommand sessionCommand2 = sessionCommand;
            final int i2 = i;
            final SessionTask sessionTask2 = sessionTask;
            this.mSessionImpl.getCallbackExecutor().execute(new Runnable() {
                public void run() {
                    if (!MediaSessionLegacyStub.this.mSessionImpl.isClosed()) {
                        MediaSession.ControllerInfo controller = MediaSessionLegacyStub.this.mConnectedControllersManager.getController(currentControllerInfo);
                        if (controller == null) {
                            MediaSessionManager.RemoteUserInfo remoteUserInfo = currentControllerInfo;
                            controller = new MediaSession.ControllerInfo(remoteUserInfo, -1, MediaSessionLegacyStub.this.mSessionManager.isTrustedForMediaControl(remoteUserInfo), new ControllerLegacyCb(currentControllerInfo), (Bundle) null);
                            SessionCommandGroup onConnect = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onConnect(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controller);
                            if (onConnect == null) {
                                try {
                                    controller.getControllerCb().onDisconnected(0);
                                    return;
                                } catch (RemoteException unused) {
                                    return;
                                }
                            } else {
                                MediaSessionLegacyStub.this.mConnectedControllersManager.addController(controller.getRemoteUserInfo(), controller, onConnect);
                            }
                        }
                        MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                        mediaSessionLegacyStub.mConnectionTimeoutHandler.disconnectControllerAfterTimeout(controller, mediaSessionLegacyStub.mConnectionTimeoutMs);
                        MediaSessionLegacyStub.this.handleTaskOnExecutor(controller, sessionCommand2, i2, sessionTask2);
                    }
                }
            });
        }
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
            if (this.mConnectedControllersManager.isAllowedCommand(controllerInfo, sessionCommand)) {
                sessionCommand2 = sCommandsForOnCommandRequest.get(sessionCommand.getCommandCode());
            } else {
                return;
            }
        } else if (this.mConnectedControllersManager.isAllowedCommand(controllerInfo, i)) {
            sessionCommand2 = sCommandsForOnCommandRequest.get(i);
        } else {
            return;
        }
        if (sessionCommand2 == null || this.mSessionImpl.getCallback().onCommandRequest(this.mSessionImpl.getInstance(), controllerInfo, sessionCommand2) == 0) {
            try {
                sessionTask.run(controllerInfo);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo, e);
            }
        } else if (DEBUG) {
            Log.d(TAG, "Command (" + sessionCommand2 + ") from " + controllerInfo + " was rejected by " + this.mSessionImpl);
        }
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        onAddQueueItem(mediaDescriptionCompat, Integer.MAX_VALUE);
    }

    public void onCommand(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (str != null) {
            final SessionCommand sessionCommand = new SessionCommand(str, (Bundle) null);
            dispatchSessionTask(sessionCommand, (SessionTask) new SessionTask() {
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    SessionResult onCustomCommand = MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCustomCommand(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, sessionCommand, bundle);
                    ResultReceiver resultReceiver = resultReceiver;
                    if (resultReceiver != null) {
                        resultReceiver.send(onCustomCommand.getResultCode(), onCustomCommand.getCustomCommandResult());
                    }
                }
            });
        }
    }

    public void onCustomAction(@NonNull String str, @Nullable Bundle bundle) {
    }

    public void onFastForward() {
        dispatchSessionTask(40000, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onFastForward(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    public void onPause() {
        dispatchSessionTask(10001, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.pause();
            }
        });
    }

    public void onPlay() {
        dispatchSessionTask(10000, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.play();
            }
        });
    }

    public void onPlayFromMediaId(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    public void onPlayFromSearch(String str, Bundle bundle) {
        onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
    }

    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.play();
                }
            }
        });
    }

    public void onPrepare() {
        dispatchSessionTask(10002, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.prepare();
            }
        });
    }

    public void onPrepareFromMediaId(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
    }

    public void onPrepareFromSearch(String str, Bundle bundle) {
        onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
    }

    public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        dispatchSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetMediaUri(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, uri, bundle) == 0) {
                    MediaSessionLegacyStub.this.mSessionImpl.prepare();
                }
            }
        });
    }

    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat != null) {
            dispatchSessionTask(10014, (SessionTask) new SessionTask() {
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
    }

    public void onRemoveQueueItemAt(final int i) {
        dispatchSessionTask(10014, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                int i = i;
                if (i < 0) {
                    Log.w(MediaSessionLegacyStub.TAG, "onRemoveQueueItem(): index shouldn't be negative");
                } else {
                    MediaSessionLegacyStub.this.mSessionImpl.removePlaylistItem(i);
                }
            }
        });
    }

    public void onRewind() {
        dispatchSessionTask(40001, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.getCallback().onRewind(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo);
            }
        });
    }

    public void onSeekTo(final long j) {
        dispatchSessionTask(10003, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.seekTo(j);
            }
        });
    }

    public void onSetCaptioningEnabled(boolean z) {
    }

    public void onSetPlaybackSpeed(final float f) {
        dispatchSessionTask(10004, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setPlaybackSpeed(f);
            }
        });
    }

    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, (Bundle) null);
    }

    public void onSetRepeatMode(final int i) {
        dispatchSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setRepeatMode(i);
            }
        });
    }

    public void onSetShuffleMode(final int i) {
        dispatchSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.setShuffleMode(i);
            }
        });
    }

    public void onSkipToNext() {
        dispatchSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.skipToNextItem();
            }
        });
    }

    public void onSkipToPrevious() {
        dispatchSessionTask(10008, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.mSessionImpl.skipToPreviousItem();
            }
        });
    }

    public void onSkipToQueueItem(final long j) {
        dispatchSessionTask(10007, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                if (MediaSessionLegacyStub.this.mSessionImpl.getPlayer().getPlaylist() != null) {
                    MediaSessionLegacyStub.this.mSessionImpl.skipToPlaylistItem((int) j);
                }
            }
        });
    }

    public void onStop() {
        dispatchSessionTask(10001, (SessionTask) new SessionTask() {
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaSessionLegacyStub.this.handleTaskOnExecutor(controllerInfo, (SessionCommand) null, 10003, new SessionTask() {
                    public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                        MediaSessionLegacyStub.this.mSessionImpl.pause();
                        MediaSessionLegacyStub.this.mSessionImpl.seekTo(0);
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

    public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int i) {
        if (mediaDescriptionCompat != null) {
            dispatchSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, (SessionTask) new SessionTask() {
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    String mediaId = mediaDescriptionCompat.getMediaId();
                    if (TextUtils.isEmpty(mediaId)) {
                        Log.w(MediaSessionLegacyStub.TAG, "onAddQueueItem(): Media ID shouldn't be empty");
                        return;
                    }
                    MediaSessionLegacyStub.this.mSessionImpl.addPlaylistItem(i, MediaSessionLegacyStub.this.mSessionImpl.getCallback().onCreateMediaItem(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, mediaId));
                }
            });
        }
    }

    public void onSetRating(final RatingCompat ratingCompat, Bundle bundle) {
        if (ratingCompat != null) {
            dispatchSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SET_RATING, (SessionTask) new SessionTask() {
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    MediaItem currentMediaItem = MediaSessionLegacyStub.this.mSessionImpl.getCurrentMediaItem();
                    if (currentMediaItem != null) {
                        MediaSessionLegacyStub.this.mSessionImpl.getCallback().onSetRating(MediaSessionLegacyStub.this.mSessionImpl.getInstance(), controllerInfo, currentMediaItem.getMediaId(), MediaUtils.convertToRating(ratingCompat));
                    }
                }
            });
        }
    }
}
