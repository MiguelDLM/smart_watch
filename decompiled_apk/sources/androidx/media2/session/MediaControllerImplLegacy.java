package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    private static final int ITEM_NONE = -1;
    private static final long POSITION_DIFF_TOLERANCE = 100;
    static final String SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED = "android.media.session.command.ON_CAPTIONING_ENALBED_CHANGED";
    static final String SESSION_COMMAND_ON_EXTRAS_CHANGED = "android.media.session.command.ON_EXTRAS_CHANGED";

    @GuardedBy("mLock")
    SessionCommandGroup mAllowedCommands;

    @GuardedBy("mLock")
    MediaBrowserCompat mBrowserCompat;

    @GuardedBy("mLock")
    long mBufferedPosition;

    @GuardedBy("mLock")
    int mBufferingState;

    @GuardedBy("mLock")
    boolean mClosed;

    @GuardedBy("mLock")
    boolean mConnected;
    final Context mContext;

    @GuardedBy("mLock")
    MediaControllerCompat mControllerCompat;

    @GuardedBy("mLock")
    ControllerCompatCallback mControllerCompatCallback;

    @GuardedBy("mLock")
    MediaItem mCurrentMediaItem;
    int mCurrentMediaItemIndex;

    @GuardedBy("mLock")
    List<MediaSession.CommandButton> mCustomLayout;
    final Handler mHandler;
    final HandlerThread mHandlerThread;
    MediaController mInstance;
    final Object mLock;

    @GuardedBy("mLock")
    MediaMetadataCompat mMediaMetadataCompat;

    @GuardedBy("mLock")
    MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    PlaybackStateCompat mPlaybackStateCompat;

    @GuardedBy("mLock")
    int mPlayerState;

    @GuardedBy("mLock")
    List<MediaItem> mPlaylist;

    @GuardedBy("mLock")
    MediaMetadata mPlaylistMetadata;
    List<MediaSessionCompat.QueueItem> mQueue;

    @GuardedBy("mLock")
    int mRepeatMode;

    @GuardedBy("mLock")
    int mShuffleMode;

    @GuardedBy("mLock")
    int mSkipToPlaylistIndex;
    final SessionToken mToken;
    private static final String TAG = "MC2ImplLegacy";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* loaded from: classes.dex */
    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public ConnectionCallback() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            } else if (MediaControllerImplLegacy.DEBUG) {
                Log.d(MediaControllerImplLegacy.TAG, "Controller is closed prematually", new IllegalStateException());
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.close();
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        public ControllerCompatCallback() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            final MediaController.PlaybackInfo playbackInfo2 = MediaUtils.toPlaybackInfo2(playbackInfo);
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mPlaybackInfo = playbackInfo2;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.14
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaybackInfoChanged(MediaControllerImplLegacy.this.mInstance, playbackInfo2);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(final boolean z) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.15
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("androidx.media2.argument.CAPTIONING_ENABLED", z);
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onExtrasChanged(final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.13
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_EXTRAS_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    MediaItem mediaItem = mediaControllerImplLegacy.mCurrentMediaItem;
                    mediaControllerImplLegacy.setCurrentMediaItemLocked(mediaMetadataCompat);
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    final MediaItem mediaItem2 = mediaControllerImplLegacy2.mCurrentMediaItem;
                    if (mediaItem != mediaItem2) {
                        mediaControllerImplLegacy2.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.10
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2);
                            }
                        });
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x015c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x015d  */
        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onPlaybackStateChanged(final android.support.v4.media.session.PlaybackStateCompat r15) {
            /*
                Method dump skipped, instructions count: 387
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                try {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mQueue = MediaUtils.removeNullElements(list);
                        List<MediaSessionCompat.QueueItem> list2 = MediaControllerImplLegacy.this.mQueue;
                        if (list2 != null && list2.size() != 0) {
                            MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                            mediaControllerImplLegacy2.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(mediaControllerImplLegacy2.mQueue);
                            MediaControllerImplLegacy mediaControllerImplLegacy3 = MediaControllerImplLegacy.this;
                            final List<MediaItem> list3 = mediaControllerImplLegacy3.mPlaylist;
                            final MediaMetadata mediaMetadata = mediaControllerImplLegacy3.mPlaylistMetadata;
                            mediaControllerImplLegacy3.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list3, mediaMetadata);
                                }
                            });
                        }
                        MediaControllerImplLegacy mediaControllerImplLegacy4 = MediaControllerImplLegacy.this;
                        mediaControllerImplLegacy4.mQueue = null;
                        mediaControllerImplLegacy4.mPlaylist = null;
                        MediaControllerImplLegacy mediaControllerImplLegacy32 = MediaControllerImplLegacy.this;
                        final List list32 = mediaControllerImplLegacy32.mPlaylist;
                        final MediaMetadata mediaMetadata2 = mediaControllerImplLegacy32.mPlaylistMetadata;
                        mediaControllerImplLegacy32.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list32, mediaMetadata2);
                            }
                        });
                    }
                } finally {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(charSequence);
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    final MediaMetadata mediaMetadata = mediaControllerImplLegacy2.mPlaylistMetadata;
                    mediaControllerImplLegacy2.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.12
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaylistMetadataChanged(MediaControllerImplLegacy.this.mInstance, mediaMetadata);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mRepeatMode = i;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.16
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onRepeatModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(final String str, final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.1
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(str, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionReady() {
            MediaControllerImplLegacy mediaControllerImplLegacy;
            boolean z;
            PlaybackStateCompat playbackState;
            int shuffleMode;
            int repeatMode;
            boolean isCaptioningEnabled;
            synchronized (MediaControllerImplLegacy.this.mLock) {
                mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                z = mediaControllerImplLegacy.mConnected;
            }
            if (!z) {
                mediaControllerImplLegacy.onConnectedNotLocked();
                return;
            }
            synchronized (mediaControllerImplLegacy.mLock) {
                playbackState = MediaControllerImplLegacy.this.mControllerCompat.getPlaybackState();
                shuffleMode = MediaControllerImplLegacy.this.mControllerCompat.getShuffleMode();
                repeatMode = MediaControllerImplLegacy.this.mControllerCompat.getRepeatMode();
                isCaptioningEnabled = MediaControllerImplLegacy.this.mControllerCompat.isCaptioningEnabled();
            }
            onPlaybackStateChanged(playbackState);
            onShuffleModeChanged(shuffleMode);
            onRepeatModeChanged(repeatMode);
            onCaptioningEnabledChanged(isCaptioningEnabled);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed && mediaControllerImplLegacy.mConnected) {
                    mediaControllerImplLegacy.mShuffleMode = i;
                    mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.17
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onShuffleModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                        }
                    });
                }
            }
        }
    }

    public MediaControllerImplLegacy(@NonNull Context context, @NonNull MediaController mediaController, @NonNull SessionToken sessionToken) {
        Object obj = new Object();
        this.mLock = obj;
        this.mSkipToPlaylistIndex = -1;
        this.mContext = context;
        this.mInstance = mediaController;
        HandlerThread handlerThread = new HandlerThread("MediaController_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mToken = sessionToken;
        if (sessionToken.getType() == 0) {
            synchronized (obj) {
                this.mBrowserCompat = null;
            }
            connectToSession((MediaSessionCompat.Token) sessionToken.getBinder());
            return;
        }
        connectToService();
    }

    private void connectToService() {
        this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MediaControllerImplLegacy.this.mLock) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    mediaControllerImplLegacy.mBrowserCompat = new MediaBrowserCompat(mediaControllerImplLegacy2.mContext, mediaControllerImplLegacy2.mToken.getComponentName(), new ConnectionCallback(), null);
                    MediaControllerImplLegacy.this.mBrowserCompat.connect();
                }
            }
        });
    }

    private ListenableFuture<SessionResult> createFutureWithResult(int i) {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionResult(i, null, mediaItem));
        return create;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.adjustVolume(i, i2);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (DEBUG) {
            Log.d(TAG, "close from " + this.mToken);
        }
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandlerThread.quitSafely();
                this.mClosed = true;
                MediaBrowserCompat mediaBrowserCompat = this.mBrowserCompat;
                if (mediaBrowserCompat != null) {
                    mediaBrowserCompat.disconnect();
                    this.mBrowserCompat = null;
                }
                MediaControllerCompat mediaControllerCompat = this.mControllerCompat;
                if (mediaControllerCompat != null) {
                    mediaControllerCompat.unregisterCallback(this.mControllerCompatCallback);
                    this.mControllerCompat = null;
                }
                this.mConnected = false;
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.1
                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        controllerCallback.onDisconnected(MediaControllerImplLegacy.this.mInstance);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        boolean isSessionReady;
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, token);
        synchronized (this.mLock) {
            this.mControllerCompat = mediaControllerCompat;
            this.mControllerCompatCallback = new ControllerCompatCallback();
            isSessionReady = this.mControllerCompat.isSessionReady();
            this.mControllerCompat.registerCallback(this.mControllerCompatCallback, this.mHandler);
        }
        if (!isSessionReady) {
            onConnectedNotLocked();
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support deselecting track");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> fastForward() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().fastForward();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mAllowedCommands;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (this.mLock) {
            mediaBrowserCompat = this.mBrowserCompat;
        }
        return mediaBrowserCompat;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        synchronized (this.mLock) {
            try {
                long j = Long.MIN_VALUE;
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                if (playbackStateCompat != null) {
                    j = playbackStateCompat.getBufferedPosition();
                }
                return j;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        synchronized (this.mLock) {
            try {
                int i = 0;
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                if (playbackStateCompat != null) {
                    i = MediaUtils.toBufferingState(playbackStateCompat.getState());
                }
                return i;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            try {
                if (this.mConnected) {
                    sessionToken = this.mToken;
                } else {
                    sessionToken = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionToken;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaItem getCurrentMediaItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mCurrentMediaItem;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return this.mCurrentMediaItemIndex;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                if (playbackStateCompat == null) {
                    return Long.MIN_VALUE;
                }
                return playbackStateCompat.getCurrentPosition(this.mInstance.mTimeDiff);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                MediaMetadataCompat mediaMetadataCompat = this.mMediaMetadataCompat;
                if (mediaMetadataCompat == null || !mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                    return Long.MIN_VALUE;
                }
                return this.mMediaMetadataCompat.getLong("android.media.metadata.DURATION");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaController.PlaybackInfo getPlaybackInfo() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mPlaybackInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            try {
                float f = 0.0f;
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0.0f;
                }
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                if (playbackStateCompat != null) {
                    f = playbackStateCompat.getPlaybackSpeed();
                }
                return f;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 3;
                }
                return this.mPlayerState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public List<MediaItem> getPlaylist() {
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = null;
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                List<MediaItem> list = this.mPlaylist;
                if (list != null && list.size() != 0) {
                    arrayList = new ArrayList(this.mPlaylist);
                }
                return arrayList;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mPlaylistMetadata;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mRepeatMode;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        Log.w(TAG, "Session doesn't support getting selected track");
        return null;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public PendingIntent getSessionActivity() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mControllerCompat.getSessionActivity();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mShuffleMode;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        Log.w(TAG, "Session doesn't support getting TrackInfo");
        return Collections.emptyList();
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        Log.w(TAG, "Session doesn't support getting VideoSize");
        return new VideoSize(0, 0);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnected;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> movePlaylistItem(int i, int i2) {
        return createFutureWithResult(-6);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onConnectedNotLocked() {
        /*
            r4 = this;
            boolean r0 = androidx.media2.session.MediaControllerImplLegacy.DEBUG
            if (r0 == 0) goto L1c
            java.lang.String r0 = "MC2ImplLegacy"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onConnectedNotLocked token="
            r1.append(r2)
            androidx.media2.session.SessionToken r2 = r4.mToken
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L1c:
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r4.mClosed     // Catch: java.lang.Throwable -> L98
            if (r1 != 0) goto Ld3
            boolean r1 = r4.mConnected     // Catch: java.lang.Throwable -> L98
            if (r1 == 0) goto L29
            goto Ld3
        L29:
            android.support.v4.media.session.MediaControllerCompat r1 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.PlaybackStateCompat r1 = r1.getPlaybackState()     // Catch: java.lang.Throwable -> L98
            r4.mPlaybackStateCompat = r1     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r1 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            long r1 = r1.getFlags()     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.PlaybackStateCompat r3 = r4.mPlaybackStateCompat     // Catch: java.lang.Throwable -> L98
            androidx.media2.session.SessionCommandGroup r1 = androidx.media2.session.MediaUtils.convertToSessionCommandGroup(r1, r3)     // Catch: java.lang.Throwable -> L98
            r4.mAllowedCommands = r1     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch: java.lang.Throwable -> L98
            int r1 = androidx.media2.session.MediaUtils.convertToPlayerState(r1)     // Catch: java.lang.Throwable -> L98
            r4.mPlayerState = r1     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch: java.lang.Throwable -> L98
            if (r1 != 0) goto L4e
            r1 = -9223372036854775808
            goto L52
        L4e:
            long r1 = r1.getBufferedPosition()     // Catch: java.lang.Throwable -> L98
        L52:
            r4.mBufferedPosition = r1     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch: java.lang.Throwable -> L98
            java.util.List r1 = androidx.media2.session.MediaUtils.convertToCustomLayout(r1)     // Catch: java.lang.Throwable -> L98
            r4.mCustomLayout = r1     // Catch: java.lang.Throwable -> L98
            androidx.media2.session.SessionCommandGroup r2 = r4.mAllowedCommands     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat$PlaybackInfo r3 = r3.getPlaybackInfo()     // Catch: java.lang.Throwable -> L98
            androidx.media2.session.MediaController$PlaybackInfo r3 = androidx.media2.session.MediaUtils.toPlaybackInfo2(r3)     // Catch: java.lang.Throwable -> L98
            r4.mPlaybackInfo = r3     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            int r3 = r3.getRepeatMode()     // Catch: java.lang.Throwable -> L98
            r4.mRepeatMode = r3     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            int r3 = r3.getShuffleMode()     // Catch: java.lang.Throwable -> L98
            r4.mShuffleMode = r3     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            java.util.List r3 = r3.getQueue()     // Catch: java.lang.Throwable -> L98
            java.util.List r3 = androidx.media2.session.MediaUtils.removeNullElements(r3)     // Catch: java.lang.Throwable -> L98
            r4.mQueue = r3     // Catch: java.lang.Throwable -> L98
            if (r3 == 0) goto L9a
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L98
            if (r3 != 0) goto L8f
            goto L9a
        L8f:
            java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r3 = r4.mQueue     // Catch: java.lang.Throwable -> L98
            java.util.List r3 = androidx.media2.session.MediaUtils.convertQueueItemListToMediaItemList(r3)     // Catch: java.lang.Throwable -> L98
            r4.mPlaylist = r3     // Catch: java.lang.Throwable -> L98
            goto L9f
        L98:
            r1 = move-exception
            goto Ld5
        L9a:
            r3 = 0
            r4.mQueue = r3     // Catch: java.lang.Throwable -> L98
            r4.mPlaylist = r3     // Catch: java.lang.Throwable -> L98
        L9f:
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            java.lang.CharSequence r3 = r3.getQueueTitle()     // Catch: java.lang.Throwable -> L98
            androidx.media2.common.MediaMetadata r3 = androidx.media2.session.MediaUtils.convertToMediaMetadata(r3)     // Catch: java.lang.Throwable -> L98
            r4.mPlaylistMetadata = r3     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch: java.lang.Throwable -> L98
            android.support.v4.media.MediaMetadataCompat r3 = r3.getMetadata()     // Catch: java.lang.Throwable -> L98
            r4.setCurrentMediaItemLocked(r3)     // Catch: java.lang.Throwable -> L98
            r3 = 1
            r4.mConnected = r3     // Catch: java.lang.Throwable -> L98
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
            androidx.media2.session.MediaController r0 = r4.mInstance
            androidx.media2.session.MediaControllerImplLegacy$3 r3 = new androidx.media2.session.MediaControllerImplLegacy$3
            r3.<init>()
            r0.notifyAllControllerCallbacks(r3)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto Ld2
            androidx.media2.session.MediaController r0 = r4.mInstance
            androidx.media2.session.MediaControllerImplLegacy$4 r2 = new androidx.media2.session.MediaControllerImplLegacy$4
            r2.<init>()
            r0.notifyPrimaryControllerCallback(r2)
        Ld2:
            return
        Ld3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
            return
        Ld5:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.onConnectedNotLocked():void");
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> pause() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().pause();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> play() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().play();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> prepare() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().prepare();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> removePlaylistItem(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                List<MediaSessionCompat.QueueItem> list = this.mQueue;
                if (list != null && i >= 0 && i < list.size()) {
                    this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                    return createFutureWithResult(0);
                }
                return createFutureWithResult(-3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                List<MediaSessionCompat.QueueItem> list = this.mQueue;
                if (list != null && i >= 0 && i < list.size()) {
                    this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                    this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                    return createFutureWithResult(0);
                }
                return createFutureWithResult(-3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> rewind() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().rewind();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> seekTo(long j) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().seekTo(j);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support selecting track");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                if (this.mAllowedCommands.hasCommand(sessionCommand)) {
                    this.mControllerCompat.getTransportControls().sendCustomAction(sessionCommand.getCustomAction(), bundle);
                    return createFutureWithResult(0);
                }
                final ResolvableFuture create = ResolvableFuture.create();
                this.mControllerCompat.sendCommand(sessionCommand.getCustomAction(), bundle, new ResultReceiver(this.mHandler) { // from class: androidx.media2.session.MediaControllerImplLegacy.2
                    @Override // android.os.ResultReceiver
                    public void onReceiveResult(int i, Bundle bundle2) {
                        create.set(new SessionResult(i, bundle2));
                    }
                });
                return create;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setCurrentMediaItemLocked(MediaMetadataCompat mediaMetadataCompat) {
        this.mMediaMetadataCompat = mediaMetadataCompat;
        if (mediaMetadataCompat == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = null;
            return;
        }
        if (this.mQueue == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            return;
        }
        PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
        if (playbackStateCompat != null) {
            long activeQueueItemId = playbackStateCompat.getActiveQueueItemId();
            for (int i = 0; i < this.mQueue.size(); i++) {
                if (this.mQueue.get(i).getQueueId() == activeQueueItemId) {
                    this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                    this.mCurrentMediaItemIndex = i;
                    return;
                }
            }
        }
        String string = mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID");
        if (string == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            return;
        }
        int i2 = this.mSkipToPlaylistIndex;
        if (i2 >= 0 && i2 < this.mQueue.size() && TextUtils.equals(string, this.mQueue.get(this.mSkipToPlaylistIndex).getDescription().getMediaId())) {
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            this.mCurrentMediaItemIndex = this.mSkipToPlaylistIndex;
            this.mSkipToPlaylistIndex = -1;
            return;
        }
        for (int i3 = 0; i3 < this.mQueue.size(); i3++) {
            if (TextUtils.equals(string, this.mQueue.get(i3).getDescription().getMediaId())) {
                this.mCurrentMediaItemIndex = i3;
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                return;
            }
        }
        this.mCurrentMediaItemIndex = -1;
        this.mCurrentMediaItem = MediaUtils.convertToMediaItem(this.mMediaMetadataCompat);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setPlaybackSpeed(f);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                MediaItem mediaItem = this.mCurrentMediaItem;
                if (mediaItem != null && str.equals(mediaItem.getMediaId())) {
                    this.mControllerCompat.getTransportControls().setRating(MediaUtils.convertToRatingCompat(rating));
                }
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setRepeatMode(i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setShuffleMode(i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        Log.w(TAG, "Session doesn't support setting Surface");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.setVolumeTo(i, i2);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipBackward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipForward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToNextItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().skipToNext();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPlaylistItem(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mSkipToPlaylistIndex = i;
                this.mControllerCompat.getTransportControls().skipToQueueItem(this.mQueue.get(i).getQueueId());
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPreviousItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().skipToPrevious();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }
}
