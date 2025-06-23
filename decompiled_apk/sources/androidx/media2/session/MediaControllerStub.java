package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaController;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.ParcelImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaControllerStub extends IMediaController.Stub {
    private static final boolean DEBUG = true;
    private static final String TAG = "MediaControllerStub";
    private final WeakReference<MediaControllerImplBase> mController;
    final SequencedFutureManager mSequencedFutureManager;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface BrowserTask {
        void run(MediaBrowserImplBase mediaBrowserImplBase);
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface ControllerTask {
        void run(MediaControllerImplBase mediaControllerImplBase);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase, SequencedFutureManager sequencedFutureManager) {
        this.mController = new WeakReference<>(mediaControllerImplBase);
        this.mSequencedFutureManager = sequencedFutureManager;
    }

    private void dispatchBrowserTask(BrowserTask browserTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if ((mediaControllerImplBase instanceof MediaBrowserImplBase) && mediaControllerImplBase.isConnected()) {
                browserTask.run((MediaBrowserImplBase) mediaControllerImplBase);
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void dispatchControllerTask(ControllerTask controllerTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase != null && mediaControllerImplBase.isConnected()) {
                controllerTask.run(mediaControllerImplBase);
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void destroy() {
        this.mController.clear();
    }

    @Override // androidx.media2.session.IMediaController
    public void onAllowedCommandsChanged(int i, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.17
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionCommandGroup == null) {
                    Log.w(MediaControllerStub.TAG, "onAllowedCommandsChanged(): Ignoring null commands");
                } else {
                    mediaControllerImplBase.onAllowedCommandsChanged(sessionCommandGroup);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onBufferingStateChanged(int i, final ParcelImpl parcelImpl, final int i2, final long j, final long j2, final long j3) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.6
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(parcelImpl);
                if (mediaItem == null) {
                    Log.w(MediaControllerStub.TAG, "onBufferingStateChanged(): Ignoring null item");
                } else {
                    mediaControllerImplBase.notifyBufferingStateChanged(mediaItem, i2, j, j2, j3);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onChildrenChanged(int i, final String str, final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.23
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                mediaBrowserImplBase.notifyChildrenChanged(str, i2, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onConnected(int i, ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            onDisconnected(i);
            return;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase == null) {
                Log.d(TAG, "onConnected after MediaController.close()");
                return;
            }
            ConnectionResult connectionResult = (ConnectionResult) MediaParcelUtils.fromParcelable(parcelImpl);
            mediaControllerImplBase.onConnectedNotLocked(connectionResult.getVersion(), connectionResult.getSessionStub(), connectionResult.getAllowedCommands(), connectionResult.getPlayerState(), connectionResult.getCurrentMediaItem(), connectionResult.getPositionEventTimeMs(), connectionResult.getPositionMs(), connectionResult.getPlaybackSpeed(), connectionResult.getBufferedPositionMs(), connectionResult.getPlaybackInfo(), connectionResult.getRepeatMode(), connectionResult.getShuffleMode(), MediaUtils.convertParcelImplListSliceToMediaItemList(connectionResult.getPlaylistSlice()), connectionResult.getSessionActivity(), connectionResult.getCurrentMediaItemIndex(), connectionResult.getPreviousMediaItemIndex(), connectionResult.getNextMediaItemIndex(), connectionResult.getTokenExtras(), connectionResult.getVideoSize(), connectionResult.getTracks(), connectionResult.getSelectedVideoTrack(), connectionResult.getSelectedAudioTrack(), connectionResult.getSelectedSubtitleTrack(), connectionResult.getSelectedMetadataTrack(), connectionResult.getPlaylistMetadata(), connectionResult.getBufferingState());
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onCurrentMediaItemChanged(int i, final ParcelImpl parcelImpl, final int i2, final int i3, final int i4) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.3
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyCurrentMediaItemChanged((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl), i2, i3, i4);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onCustomCommand(final int i, final ParcelImpl parcelImpl, final Bundle bundle) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.18
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionCommand sessionCommand = (SessionCommand) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionCommand == null) {
                    Log.w(MediaControllerStub.TAG, "sendCustomCommand(): Ignoring null command");
                } else {
                    mediaControllerImplBase.onCustomCommand(i, sessionCommand, bundle);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onDisconnected(int i) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase == null) {
                Log.d(TAG, "onDisconnected after MediaController.close()");
            } else {
                mediaControllerImplBase.mInstance.close();
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onLibraryResult(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.2
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                LibraryResult libraryResult = (LibraryResult) MediaParcelUtils.fromParcelable(parcelImpl);
                if (libraryResult == null) {
                    return;
                }
                MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i, libraryResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackCompleted(int i) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.11
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackCompleted();
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackInfoChanged(int i, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl == null) {
            return;
        }
        Log.d(TAG, "onPlaybackInfoChanged");
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.12
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaController.PlaybackInfo playbackInfo = (MediaController.PlaybackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (playbackInfo == null) {
                    Log.w(MediaControllerStub.TAG, "onPlaybackInfoChanged(): Ignoring null playbackInfo");
                } else {
                    mediaControllerImplBase.notifyPlaybackInfoChanges(playbackInfo);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackSpeedChanged(int i, final long j, final long j2, final float f) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.5
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackSpeedChanges(j, j2, f);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlayerStateChanged(int i, final long j, final long j2, final int i2) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.4
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlayerStateChanges(j, j2, i2);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistChanged(int i, final ParcelImplListSlice parcelImplListSlice, final ParcelImpl parcelImpl, final int i2, final int i3, final int i4) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.7
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaylistChanges(MediaUtils.convertParcelImplListSliceToMediaItemList(parcelImplListSlice), (MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl), i2, i3, i4);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistMetadataChanged(int i, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.8
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaylistMetadataChanges((MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onRepeatModeChanged(int i, final int i2, final int i3, final int i4, final int i5) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.9
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyRepeatModeChanges(i2, i3, i4, i5);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSearchResultChanged(int i, final String str, final int i2, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        dispatchBrowserTask(new BrowserTask() { // from class: androidx.media2.session.MediaControllerStub.22
            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                mediaBrowserImplBase.notifySearchResultChanged(str, i2, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSeekCompleted(int i, final long j, final long j2, final long j3) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.13
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifySeekCompleted(j, j2, j3);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSessionResult(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.1
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionResult sessionResult = (SessionResult) MediaParcelUtils.fromParcelable(parcelImpl);
                if (sessionResult == null) {
                    return;
                }
                MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i, sessionResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSetCustomLayout(final int i, final List<ParcelImpl> list) {
        if (list == null) {
            Log.w(TAG, "setCustomLayout(): Ignoring null commandButtonList");
        } else {
            dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.16
                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MediaSession.CommandButton commandButton = (MediaSession.CommandButton) MediaParcelUtils.fromParcelable((ParcelImpl) list.get(i2));
                        if (commandButton != null) {
                            arrayList.add(commandButton);
                        }
                    }
                    mediaControllerImplBase.onSetCustomLayout(i, arrayList);
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onShuffleModeChanged(int i, final int i2, final int i3, final int i4, final int i5) {
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.10
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyShuffleModeChanges(i2, i3, i4, i5);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSubtitleData(int i, final ParcelImpl parcelImpl, final ParcelImpl parcelImpl2, final ParcelImpl parcelImpl3) {
        if (parcelImpl != null && parcelImpl2 != null && parcelImpl3 != null) {
            dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.15
                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(parcelImpl);
                    if (mediaItem == null) {
                        Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null MediaItem");
                        return;
                    }
                    SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl2);
                    if (trackInfo == null) {
                        Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null TrackInfo");
                        return;
                    }
                    SubtitleData subtitleData = (SubtitleData) MediaParcelUtils.fromParcelable(parcelImpl3);
                    if (subtitleData == null) {
                        Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null SubtitleData");
                    } else {
                        mediaControllerImplBase.notifySubtitleData(mediaItem, trackInfo, subtitleData);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackDeselected(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.21
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (trackInfo == null) {
                    Log.w(MediaControllerStub.TAG, "onTrackSelected(): Ignoring null track info");
                } else {
                    mediaControllerImplBase.notifyTrackDeselected(i, trackInfo);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackInfoChanged(final int i, final List<ParcelImpl> list, final ParcelImpl parcelImpl, final ParcelImpl parcelImpl2, final ParcelImpl parcelImpl3, final ParcelImpl parcelImpl4) {
        if (list == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.19
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyTracksChanged(i, MediaParcelUtils.fromParcelableList(list), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl2), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl3), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl4));
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackSelected(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.20
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl);
                if (trackInfo == null) {
                    Log.w(MediaControllerStub.TAG, "onTrackSelected(): Ignoring null track info");
                } else {
                    mediaControllerImplBase.notifyTrackSelected(i, trackInfo);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, final ParcelImpl parcelImpl2) {
        if (parcelImpl2 == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask() { // from class: androidx.media2.session.MediaControllerStub.14
            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                VideoSize videoSize = (VideoSize) MediaParcelUtils.fromParcelable(parcelImpl2);
                if (videoSize == null) {
                    Log.w(MediaControllerStub.TAG, "onVideoSizeChanged(): Ignoring null VideoSize");
                } else {
                    mediaControllerImplBase.notifyVideoSizeChanged(videoSize);
                }
            }
        });
    }
}
