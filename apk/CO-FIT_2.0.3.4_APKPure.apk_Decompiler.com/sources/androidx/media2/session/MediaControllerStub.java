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

class MediaControllerStub extends IMediaController.Stub {
    private static final boolean DEBUG = true;
    private static final String TAG = "MediaControllerStub";
    private final WeakReference<MediaControllerImplBase> mController;
    final SequencedFutureManager mSequencedFutureManager;

    @FunctionalInterface
    public interface BrowserTask {
        void run(MediaBrowserImplBase mediaBrowserImplBase);
    }

    @FunctionalInterface
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
            if (mediaControllerImplBase instanceof MediaBrowserImplBase) {
                if (mediaControllerImplBase.isConnected()) {
                    browserTask.run((MediaBrowserImplBase) mediaControllerImplBase);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void dispatchControllerTask(ControllerTask controllerTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase != null) {
                if (mediaControllerImplBase.isConnected()) {
                    controllerTask.run(mediaControllerImplBase);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void destroy() {
        this.mController.clear();
    }

    public void onAllowedCommandsChanged(int i, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
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
    }

    public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) {
        if (parcelImpl != null) {
            final ParcelImpl parcelImpl2 = parcelImpl;
            final int i3 = i2;
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(parcelImpl2);
                    if (mediaItem == null) {
                        Log.w(MediaControllerStub.TAG, "onBufferingStateChanged(): Ignoring null item");
                        return;
                    }
                    mediaControllerImplBase.notifyBufferingStateChanged(mediaItem, i3, j4, j5, j6);
                }
            });
        }
    }

    public void onChildrenChanged(int i, final String str, final int i2, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
            } else if (i2 < 0) {
                Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i2);
            } else {
                dispatchBrowserTask(new BrowserTask() {
                    public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                        mediaBrowserImplBase.notifyChildrenChanged(str, i2, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
                    }
                });
            }
        }
    }

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
            Binder.restoreCallingIdentity(clearCallingIdentity);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) {
        if (parcelImpl != null) {
            final ParcelImpl parcelImpl2 = parcelImpl;
            final int i5 = i2;
            final int i6 = i3;
            final int i7 = i4;
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyCurrentMediaItemChanged((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl2), i5, i6, i7);
                }
            });
        }
    }

    public void onCustomCommand(final int i, final ParcelImpl parcelImpl, final Bundle bundle) {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
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
    }

    public void onDisconnected(int i) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.mController.get();
            if (mediaControllerImplBase == null) {
                Log.d(TAG, "onDisconnected after MediaController.close()");
                return;
            }
            mediaControllerImplBase.mInstance.close();
            Binder.restoreCallingIdentity(clearCallingIdentity);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void onLibraryResult(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            dispatchBrowserTask(new BrowserTask() {
                public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                    LibraryResult libraryResult = (LibraryResult) MediaParcelUtils.fromParcelable(parcelImpl);
                    if (libraryResult != null) {
                        MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i, libraryResult);
                    }
                }
            });
        }
    }

    public void onPlaybackCompleted(int i) {
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackCompleted();
            }
        });
    }

    public void onPlaybackInfoChanged(int i, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl != null) {
            Log.d(TAG, "onPlaybackInfoChanged");
            dispatchControllerTask(new ControllerTask() {
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
    }

    public void onPlaybackSpeedChanged(int i, long j, long j2, float f) {
        final long j3 = j;
        final long j4 = j2;
        final float f2 = f;
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlaybackSpeedChanges(j3, j4, f2);
            }
        });
    }

    public void onPlayerStateChanged(int i, long j, long j2, int i2) {
        final long j3 = j;
        final long j4 = j2;
        final int i3 = i2;
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyPlayerStateChanges(j3, j4, i3);
            }
        });
    }

    public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) {
        if (parcelImpl != null) {
            final ParcelImplListSlice parcelImplListSlice2 = parcelImplListSlice;
            final ParcelImpl parcelImpl2 = parcelImpl;
            final int i5 = i2;
            final int i6 = i3;
            final int i7 = i4;
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyPlaylistChanges(MediaUtils.convertParcelImplListSliceToMediaItemList(parcelImplListSlice2), (MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl2), i5, i6, i7);
                }
            });
        }
    }

    public void onPlaylistMetadataChanged(int i, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyPlaylistMetadataChanges((MediaMetadata) MediaParcelUtils.fromParcelable(parcelImpl));
                }
            });
        }
    }

    public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final int i9 = i5;
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyRepeatModeChanges(i6, i7, i8, i9);
            }
        });
    }

    public void onSearchResultChanged(int i, final String str, final int i2, final ParcelImpl parcelImpl) throws RuntimeException {
        if (parcelImpl != null) {
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
            } else if (i2 < 0) {
                Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
            } else {
                dispatchBrowserTask(new BrowserTask() {
                    public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                        mediaBrowserImplBase.notifySearchResultChanged(str, i2, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(parcelImpl));
                    }
                });
            }
        }
    }

    public void onSeekCompleted(int i, long j, long j2, long j3) {
        final long j4 = j;
        final long j5 = j2;
        final long j6 = j3;
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifySeekCompleted(j4, j5, j6);
            }
        });
    }

    public void onSessionResult(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    SessionResult sessionResult = (SessionResult) MediaParcelUtils.fromParcelable(parcelImpl);
                    if (sessionResult != null) {
                        MediaControllerStub.this.mSequencedFutureManager.setFutureResult(i, sessionResult);
                    }
                }
            });
        }
    }

    public void onSetCustomLayout(final int i, final List<ParcelImpl> list) {
        if (list == null) {
            Log.w(TAG, "setCustomLayout(): Ignoring null commandButtonList");
        } else {
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        MediaSession.CommandButton commandButton = (MediaSession.CommandButton) MediaParcelUtils.fromParcelable((ParcelImpl) list.get(i));
                        if (commandButton != null) {
                            arrayList.add(commandButton);
                        }
                    }
                    mediaControllerImplBase.onSetCustomLayout(i, arrayList);
                }
            });
        }
    }

    public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final int i9 = i5;
        dispatchControllerTask(new ControllerTask() {
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.notifyShuffleModeChanges(i6, i7, i8, i9);
            }
        });
    }

    public void onSubtitleData(int i, final ParcelImpl parcelImpl, final ParcelImpl parcelImpl2, final ParcelImpl parcelImpl3) {
        if (parcelImpl != null && parcelImpl2 != null && parcelImpl3 != null) {
            dispatchControllerTask(new ControllerTask() {
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

    public void onTrackDeselected(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
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
    }

    public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) {
        if (list != null) {
            final List<ParcelImpl> list2 = list;
            final ParcelImpl parcelImpl5 = parcelImpl;
            final ParcelImpl parcelImpl6 = parcelImpl2;
            final ParcelImpl parcelImpl7 = parcelImpl3;
            final ParcelImpl parcelImpl8 = parcelImpl4;
            final int i2 = i;
            dispatchControllerTask(new ControllerTask() {
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    MediaControllerImplBase mediaControllerImplBase2 = mediaControllerImplBase;
                    mediaControllerImplBase2.notifyTracksChanged(i2, MediaParcelUtils.fromParcelableList(list2), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl5), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl6), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl7), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(parcelImpl8));
                }
            });
        }
    }

    public void onTrackSelected(final int i, final ParcelImpl parcelImpl) {
        if (parcelImpl != null) {
            dispatchControllerTask(new ControllerTask() {
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
    }

    public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, final ParcelImpl parcelImpl2) {
        if (parcelImpl2 != null) {
            dispatchControllerTask(new ControllerTask() {
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
}
