package androidx.media2.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.VolumeProviderCompat;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.RemoteSessionPlayer;
import androidx.media2.session.SequencedFutureManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaSessionImplBase implements MediaSession.MediaSessionImpl {
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media2.session.id";

    @GuardedBy("STATIC_LOCK")
    private static boolean sComponentNamesInitialized = false;

    @GuardedBy("STATIC_LOCK")
    private static ComponentName sServiceComponentName;
    private final AudioManager mAudioManager;
    private final BroadcastReceiver mBroadcastReceiver;

    @GuardedBy("mLock")
    private MediaBrowserServiceCompat mBrowserServiceLegacyStub;
    final MediaSession.SessionCallback mCallback;
    final Executor mCallbackExecutor;

    @GuardedBy("mLock")
    private boolean mClosed;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final MediaSession mInstance;
    final Object mLock = new Object();
    private final PendingIntent mMediaButtonIntent;

    @GuardedBy("mLock")
    MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    SessionPlayer mPlayer;
    private final SessionPlayerCallback mPlayerCallback;
    private final PendingIntent mSessionActivity;
    private final MediaSessionCompat mSessionCompat;
    private final String mSessionId;
    private final MediaSessionLegacyStub mSessionLegacyStub;
    private final MediaSessionStub mSessionStub;
    private final SessionToken mSessionToken;
    final Uri mSessionUri;

    @Nullable
    @GuardedBy("mLock")
    VolumeProviderCompat mVolumeProviderCompat;
    private static final Object STATIC_LOCK = new Object();
    static final String TAG = "MSImplBase";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);

    /* loaded from: classes.dex */
    public static final class CombinedCommandResultFuture<T extends BaseResult> extends AbstractResolvableFuture<T> {
        final ListenableFuture<T>[] mFutures;
        AtomicInteger mSuccessCount = new AtomicInteger(0);

        private CombinedCommandResultFuture(Executor executor, ListenableFuture<T>[] listenableFutureArr) {
            final int i = 0;
            this.mFutures = listenableFutureArr;
            while (true) {
                ListenableFuture<T>[] listenableFutureArr2 = this.mFutures;
                if (i < listenableFutureArr2.length) {
                    listenableFutureArr2[i].addListener(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.CombinedCommandResultFuture.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = 0;
                            try {
                                T t = CombinedCommandResultFuture.this.mFutures[i].get();
                                int resultCode = t.getResultCode();
                                if (resultCode != 0 && resultCode != 1) {
                                    int i3 = 0;
                                    while (true) {
                                        CombinedCommandResultFuture combinedCommandResultFuture = CombinedCommandResultFuture.this;
                                        ListenableFuture<T>[] listenableFutureArr3 = combinedCommandResultFuture.mFutures;
                                        if (i3 >= listenableFutureArr3.length) {
                                            combinedCommandResultFuture.set(t);
                                            return;
                                        }
                                        if (!listenableFutureArr3[i3].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i3].isDone() && i != i3) {
                                            CombinedCommandResultFuture.this.mFutures[i3].cancel(true);
                                        }
                                        i3++;
                                    }
                                } else {
                                    int incrementAndGet = CombinedCommandResultFuture.this.mSuccessCount.incrementAndGet();
                                    CombinedCommandResultFuture combinedCommandResultFuture2 = CombinedCommandResultFuture.this;
                                    if (incrementAndGet == combinedCommandResultFuture2.mFutures.length) {
                                        combinedCommandResultFuture2.set(t);
                                    }
                                }
                            } catch (Exception e) {
                                while (true) {
                                    CombinedCommandResultFuture combinedCommandResultFuture3 = CombinedCommandResultFuture.this;
                                    ListenableFuture<T>[] listenableFutureArr4 = combinedCommandResultFuture3.mFutures;
                                    if (i2 >= listenableFutureArr4.length) {
                                        combinedCommandResultFuture3.setException(e);
                                        return;
                                    }
                                    if (!listenableFutureArr4[i2].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i2].isDone() && i != i2) {
                                        CombinedCommandResultFuture.this.mFutures[i2].cancel(true);
                                    }
                                    i2++;
                                }
                            }
                        }
                    }, executor);
                    i++;
                } else {
                    return;
                }
            }
        }

        @SafeVarargs
        public static <U extends BaseResult> CombinedCommandResultFuture<U> create(Executor executor, ListenableFuture<U>... listenableFutureArr) {
            return new CombinedCommandResultFuture<>(executor, listenableFutureArr);
        }
    }

    /* loaded from: classes.dex */
    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (!"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !ObjectsCompat.equals(intent.getData(), MediaSessionImplBase.this.mSessionUri) || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null) {
                return;
            }
            MediaSessionImplBase.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
        }
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface PlayerTask<T> {
        T run(@NonNull SessionPlayer sessionPlayer) throws Exception;
    }

    /* loaded from: classes.dex */
    public static class PlaylistItemListener implements MediaItem.OnMetadataChangedListener {
        private final WeakReference<MediaSessionImplBase> mSession;

        public PlaylistItemListener(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, MediaMetadata mediaMetadata) {
            final List<MediaItem> playlist;
            final MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null || mediaItem == null || (playlist = mediaSessionImplBase.getPlaylist()) == null) {
                return;
            }
            for (int i = 0; i < playlist.size(); i++) {
                if (mediaItem.equals(playlist.get(i))) {
                    mediaSessionImplBase.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.PlaylistItemListener.1
                        @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                        public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                            controllerCb.onPlaylistChanged(i2, playlist, mediaSessionImplBase.getPlaylistMetadata(), mediaSessionImplBase.getCurrentMediaItemIndex(), mediaSessionImplBase.getPreviousMediaItemIndex(), mediaSessionImplBase.getNextMediaItemIndex());
                        }
                    });
                    return;
                }
            }
        }
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    public MediaSessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        ComponentName componentName;
        PendingIntent foregroundService;
        this.mContext = context;
        this.mInstance = mediaSession;
        HandlerThread handlerThread = new HandlerThread("MediaSession_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.mSessionStub = mediaSessionStub;
        this.mSessionActivity = pendingIntent;
        this.mCallback = sessionCallback;
        this.mCallbackExecutor = executor;
        this.mAudioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.mPlayerCallback = new SessionPlayerCallback(this);
        this.mSessionId = str;
        Uri build = new Uri.Builder().scheme(MediaSessionImplBase.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.mSessionUri = build;
        SessionToken sessionToken = new SessionToken(new SessionTokenImplBase(Process.myUid(), 0, context.getPackageName(), mediaSessionStub, bundle));
        this.mSessionToken = sessionToken;
        String join = TextUtils.join(".", new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, str});
        synchronized (STATIC_LOCK) {
            try {
                if (!sComponentNamesInitialized) {
                    ComponentName serviceComponentByAction = getServiceComponentByAction(MediaLibraryService.SERVICE_INTERFACE);
                    sServiceComponentName = serviceComponentByAction;
                    if (serviceComponentByAction == null) {
                        sServiceComponentName = getServiceComponentByAction(MediaSessionService.SERVICE_INTERFACE);
                    }
                    sComponentNamesInitialized = true;
                }
                componentName = sServiceComponentName;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (componentName == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", build);
            intent.setPackage(context.getPackageName());
            this.mMediaButtonIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            ComponentName componentName2 = new ComponentName(context, context.getClass());
            MediaButtonReceiver mediaButtonReceiver = new MediaButtonReceiver();
            this.mBroadcastReceiver = mediaButtonReceiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(build.getScheme());
            context.registerReceiver(mediaButtonReceiver, intentFilter);
            componentName = componentName2;
        } else {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", build);
            intent2.setComponent(componentName);
            if (Build.VERSION.SDK_INT >= 26) {
                foregroundService = PendingIntent.getForegroundService(context, 0, intent2, 0);
                this.mMediaButtonIntent = foregroundService;
            } else {
                this.mMediaButtonIntent = PendingIntent.getService(context, 0, intent2, 0);
            }
            this.mBroadcastReceiver = null;
        }
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, join, componentName, this.mMediaButtonIntent, sessionToken.getExtras(), sessionToken);
        this.mSessionCompat = mediaSessionCompat;
        MediaSessionLegacyStub mediaSessionLegacyStub = new MediaSessionLegacyStub(this, handler);
        this.mSessionLegacyStub = mediaSessionLegacyStub;
        mediaSessionCompat.setSessionActivity(pendingIntent);
        mediaSessionCompat.setFlags(4);
        updatePlayer(sessionPlayer);
        mediaSessionCompat.setCallback(mediaSessionLegacyStub, handler);
        mediaSessionCompat.setActive(true);
    }

    private static VolumeProviderCompat createVolumeProviderCompat(@NonNull final RemoteSessionPlayer remoteSessionPlayer) {
        return new VolumeProviderCompat(remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume()) { // from class: androidx.media2.session.MediaSessionImplBase.53
            @Override // androidx.media.VolumeProviderCompat
            public void onAdjustVolume(int i) {
                remoteSessionPlayer.adjustVolume(i);
            }

            @Override // androidx.media.VolumeProviderCompat
            public void onSetVolumeTo(int i) {
                remoteSessionPlayer.setVolume(i);
            }
        };
    }

    private ListenableFuture<SessionPlayer.PlayerResult> dispatchPlayerTask(@NonNull PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>> playerTask) {
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionPlayer.PlayerResult(-2, null));
        return (ListenableFuture) dispatchPlayerTask(playerTask, create);
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        int i;
        ListenableFuture<SessionResult> listenableFuture;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                i = createSequencedFuture.getSequenceNumber();
                listenableFuture = createSequencedFuture;
            } else {
                if (!isConnected(controllerInfo)) {
                    return SessionResult.createFutureWithResult(-100);
                }
                i = 0;
                listenableFuture = SessionResult.createFutureWithResult(0);
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
            return listenableFuture;
        } catch (DeadObjectException e) {
            onDeadObjectException(controllerInfo, e);
            return SessionResult.createFutureWithResult(-100);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
            return SessionResult.createFutureWithResult(-1);
        }
    }

    @Nullable
    private MediaItem getCurrentMediaItemOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getCurrentMediaItem();
        }
        return null;
    }

    public static int getLegacyStreamType(@Nullable AudioAttributesCompat audioAttributesCompat) {
        int legacyStreamType;
        if (audioAttributesCompat == null || (legacyStreamType = audioAttributesCompat.getLegacyStreamType()) == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    @Nullable
    private List<MediaItem> getPlaylistOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getPlaylist();
        }
        return null;
    }

    @Nullable
    private ComponentName getServiceComponentByAction(@NonNull String str) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    private void notifyPlayerUpdatedNotLocked(SessionPlayer sessionPlayer) {
        List<MediaItem> playlist = sessionPlayer.getPlaylist();
        final List<MediaItem> playlistOrNull = getPlaylistOrNull();
        if (!ObjectsCompat.equals(playlist, playlistOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.44
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistChanged(i, playlistOrNull, MediaSessionImplBase.this.getPlaylistMetadata(), MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        } else {
            MediaMetadata playlistMetadata = sessionPlayer.getPlaylistMetadata();
            final MediaMetadata playlistMetadata2 = getPlaylistMetadata();
            if (!ObjectsCompat.equals(playlistMetadata, playlistMetadata2)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.45
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onPlaylistMetadataChanged(i, playlistMetadata2);
                    }
                });
            }
        }
        MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
        final MediaItem currentMediaItemOrNull = getCurrentMediaItemOrNull();
        if (!ObjectsCompat.equals(currentMediaItem, currentMediaItemOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.46
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onCurrentMediaItemChanged(i, currentMediaItemOrNull, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int repeatMode = getRepeatMode();
        if (sessionPlayer.getRepeatMode() != repeatMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.47
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i, repeatMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int shuffleMode = getShuffleMode();
        if (sessionPlayer.getShuffleMode() != shuffleMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.48
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i, shuffleMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentPosition = getCurrentPosition();
        final int playerState = getPlayerState();
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.49
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlayerStateChanged(i, elapsedRealtime, currentPosition, playerState);
            }
        });
        final MediaItem currentMediaItemOrNull2 = getCurrentMediaItemOrNull();
        if (currentMediaItemOrNull2 != null) {
            final int bufferingState = getBufferingState();
            final long bufferedPosition = getBufferedPosition();
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.50
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i, currentMediaItemOrNull2, bufferingState, bufferedPosition, SystemClock.elapsedRealtime(), MediaSessionImplBase.this.getCurrentPosition());
                }
            });
        }
        final float playbackSpeed = getPlaybackSpeed();
        if (playbackSpeed != sessionPlayer.getPlaybackSpeed()) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.51
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, elapsedRealtime, currentPosition, playbackSpeed);
                }
            });
        }
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo, DeadObjectException deadObjectException) {
        if (DEBUG) {
            Log.d(TAG, controllerInfo.toString() + " is gone", deadObjectException);
        }
        this.mSessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> addPlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i >= 0) {
            if (mediaItem != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.25
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                        return sessionPlayer.addPlaylistItem(i, mediaItem);
                    }
                });
            }
            throw new NullPointerException("item shouldn't be null");
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void broadcastCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.5
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                this.mClosed = true;
                if (DEBUG) {
                    Log.d(TAG, "Closing session, id=" + getId() + ", token=" + getToken());
                }
                this.mPlayer.unregisterPlayerCallback(this.mPlayerCallback);
                this.mSessionCompat.release();
                this.mMediaButtonIntent.cancel();
                BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
                if (broadcastReceiver != null) {
                    this.mContext.unregisterReceiver(broadcastReceiver);
                }
                this.mCallback.onSessionClosed(this.mInstance);
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.2
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onDisconnected(i);
                    }
                });
                this.mHandler.removeCallbacksAndMessages(null);
                if (this.mHandlerThread.isAlive()) {
                    this.mHandlerThread.quitSafely();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void connectFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle) {
        this.mSessionStub.connect(iMediaController, i, str, i2, i3, bundle);
    }

    public MediaBrowserServiceCompat createLegacyBrowserServiceLocked(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaSessionServiceLegacyStub(context, this, token);
    }

    @NonNull
    public MediaController.PlaybackInfo createPlaybackInfo(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
        if (audioAttributesCompat == null) {
            audioAttributesCompat = sessionPlayer.getAudioAttributes();
        }
        int i = 2;
        if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
            int legacyStreamType = getLegacyStreamType(audioAttributesCompat);
            if (this.mAudioManager.isVolumeFixed()) {
                i = 0;
            }
            return MediaController.PlaybackInfo.createPlaybackInfo(1, audioAttributesCompat, i, this.mAudioManager.getStreamMaxVolume(legacyStreamType), this.mAudioManager.getStreamVolume(legacyStreamType));
        }
        RemoteSessionPlayer remoteSessionPlayer = (RemoteSessionPlayer) sessionPlayer;
        return MediaController.PlaybackInfo.createPlaybackInfo(2, audioAttributesCompat, remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume());
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PlaybackStateCompat createPlaybackStateCompat() {
        int convertToPlaybackStateCompatState = MediaUtils.convertToPlaybackStateCompatState(getPlayerState(), getBufferingState());
        return new PlaybackStateCompat.Builder().setState(convertToPlaybackStateCompatState, getCurrentPosition(), getPlaybackSpeed(), SystemClock.elapsedRealtime()).setActions(3670015L).setActiveQueueItemId(MediaUtils.convertToQueueItemId(getCurrentMediaItemIndex())).setBufferedPosition(getBufferedPosition()).build();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> deselectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.42
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.deselectTrack(trackInfo);
            }
        });
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull RemoteControllerTask remoteControllerTask) {
        List<MediaSession.ControllerInfo> connectedControllers = this.mSessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.mSessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in using media1 API", e);
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getBufferedPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getBufferedPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getBufferingState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getBufferingState());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSession.SessionCallback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Executor getCallbackExecutor() {
        return this.mCallbackExecutor;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mSessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.mSessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaItem getCurrentMediaItem() {
        return (MediaItem) dispatchPlayerTask(new PlayerTask<MediaItem>() { // from class: androidx.media2.session.MediaSessionImplBase.29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaItem run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getCurrentMediaItem();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getCurrentMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getCurrentMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getCurrentPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getCurrentPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getDuration() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getDuration());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public String getId() {
        return this.mSessionId;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaSession getInstance() {
        return this.mInstance;
    }

    public MediaBrowserServiceCompat getLegacyBrowserService() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
        }
        return mediaBrowserServiceCompat;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public IBinder getLegacyBrowserServiceBinder() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            try {
                if (this.mBrowserServiceLegacyStub == null) {
                    this.mBrowserServiceLegacyStub = createLegacyBrowserServiceLocked(this.mContext, this.mSessionToken, this.mSessionCompat.getSessionToken());
                }
                mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaBrowserServiceCompat.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getNextMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getNextMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public float getPlaybackSpeed() {
        return ((Float) dispatchPlayerTask(new PlayerTask<Float>() { // from class: androidx.media2.session.MediaSessionImplBase.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Float run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Float.valueOf(sessionPlayer.getPlaybackSpeed());
                }
                return null;
            }
        }, Float.valueOf(1.0f))).floatValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionPlayer getPlayer() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        return sessionPlayer;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getPlayerState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPlayerState());
            }
        }, 3)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public List<MediaItem> getPlaylist() {
        return (List) dispatchPlayerTask(new PlayerTask<List<MediaItem>>() { // from class: androidx.media2.session.MediaSessionImplBase.18
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<MediaItem> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylist();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaMetadata getPlaylistMetadata() {
        return (MediaMetadata) dispatchPlayerTask(new PlayerTask<MediaMetadata>() { // from class: androidx.media2.session.MediaSessionImplBase.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaMetadata run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylistMetadata();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getPreviousMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPreviousMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getRepeatMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getRepeatMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public SessionPlayer.TrackInfo getSelectedTrack(final int i) {
        return (SessionPlayer.TrackInfo) dispatchPlayerTask(new PlayerTask<SessionPlayer.TrackInfo>() { // from class: androidx.media2.session.MediaSessionImplBase.43
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public SessionPlayer.TrackInfo run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getSelectedTrack(i));
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PendingIntent getSessionActivity() {
        return this.mSessionActivity;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSessionCompat getSessionCompat() {
        return this.mSessionCompat;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getShuffleMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getShuffleMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionToken getToken() {
        return this.mSessionToken;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public List<SessionPlayer.TrackInfo> getTracks() {
        return (List) dispatchPlayerTask(new PlayerTask<List<SessionPlayer.TrackInfo>>() { // from class: androidx.media2.session.MediaSessionImplBase.40
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<SessionPlayer.TrackInfo> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getTracks());
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public Uri getUri() {
        return this.mSessionUri;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public VideoSize getVideoSize() {
        return (VideoSize) dispatchPlayerTask(new PlayerTask<VideoSize>() { // from class: androidx.media2.session.MediaSessionImplBase.38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public VideoSize run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getVideoSize());
            }
        }, new VideoSize(0, 0));
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo == null) {
            return false;
        }
        if (!this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo) && !this.mSessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            return false;
        }
        return true;
    }

    public boolean isInPlaybackState(@NonNull SessionPlayer sessionPlayer) {
        if (!isClosed() && sessionPlayer.getPlayerState() != 0 && sessionPlayer.getPlayerState() != 3) {
            return true;
        }
        return false;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> movePlaylistItem(final int i, final int i2) {
        if (i >= 0 && i2 >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.28
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.movePlaylistItem(i, i2);
                }
            });
        }
        throw new IllegalArgumentException("indices shouldn't be negative");
    }

    public void notifyPlaybackInfoChangedNotLocked(final MediaController.PlaybackInfo playbackInfo) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.52
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlaybackInfoChanged(i, playbackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> pause() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.pause();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> play() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (sessionPlayer.getPlayerState() != 0) {
                    return sessionPlayer.play();
                }
                ListenableFuture<SessionPlayer.PlayerResult> prepare = sessionPlayer.prepare();
                ListenableFuture<SessionPlayer.PlayerResult> play = sessionPlayer.play();
                if (prepare == null || play == null) {
                    return null;
                }
                return CombinedCommandResultFuture.create(MediaUtils.DIRECT_EXECUTOR, prepare, play);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> prepare() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.prepare();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> removePlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.26
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    if (i >= sessionPlayer.getPlaylist().size()) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return sessionPlayer.removePlaylistItem(i);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> replacePlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i >= 0) {
            if (mediaItem != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.27
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                        return sessionPlayer.replacePlaylistItem(i, mediaItem);
                    }
                });
            }
            throw new NullPointerException("item shouldn't be null");
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> seekTo(final long j) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.seekTo(j);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> selectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.41
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.selectTrack(trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.6
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setAllowedCommands(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommandGroup sessionCommandGroup) {
        if (this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.mSessionStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAllowedCommandsChanged(i, sessionCommandGroup);
                }
            });
        } else {
            this.mSessionLegacyStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> setCustomLayout(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final List<MediaSession.CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.3
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, list);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.mSessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setMediaItem(@NonNull final MediaItem mediaItem) {
        if (mediaItem != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.20
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setMediaItem(mediaItem);
                }
            });
        }
        throw new NullPointerException("item shouldn't be null");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaybackSpeed(final float f) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setPlaybackSpeed(f);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaylist(@NonNull final List<MediaItem> list, @Nullable final MediaMetadata mediaMetadata) {
        if (list != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.19
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setPlaylist(list, mediaMetadata);
                }
            });
        }
        throw new NullPointerException("list shouldn't be null");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setRepeatMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setRepeatMode(i);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setShuffleMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setShuffleMode(i);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> setSurface(final Surface surface) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setSurface(surface);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToNextItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToNextPlaylistItem();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    if (i >= sessionPlayer.getPlaylist().size()) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return sessionPlayer.skipToPlaylistItem(i);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPreviousItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToPreviousPlaylistItem();
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2) {
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.updatePlaylistMetadata(mediaMetadata);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @SuppressLint({"WrongConstant"})
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        boolean equals;
        SessionPlayer sessionPlayer2;
        MediaController.PlaybackInfo createPlaybackInfo = createPlaybackInfo(sessionPlayer, null);
        boolean z = sessionPlayer instanceof RemoteSessionPlayer;
        VolumeProviderCompat createVolumeProviderCompat = z ? createVolumeProviderCompat((RemoteSessionPlayer) sessionPlayer) : null;
        synchronized (this.mLock) {
            equals = createPlaybackInfo.equals(this.mPlaybackInfo);
            sessionPlayer2 = this.mPlayer;
            this.mPlayer = sessionPlayer;
            this.mPlaybackInfo = createPlaybackInfo;
            this.mVolumeProviderCompat = createVolumeProviderCompat;
        }
        if (sessionPlayer2 != sessionPlayer) {
            if (sessionPlayer2 != null) {
                sessionPlayer2.unregisterPlayerCallback(this.mPlayerCallback);
            }
            sessionPlayer.registerPlayerCallback(this.mCallbackExecutor, this.mPlayerCallback);
        }
        if (sessionPlayer2 == null) {
            this.mSessionCompat.setPlaybackState(createPlaybackStateCompat());
        } else {
            if (sessionPlayer != sessionPlayer2) {
                final int playerState = getPlayerState();
                this.mCallbackExecutor.execute(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                        mediaSessionImplBase.mCallback.onPlayerStateChanged(mediaSessionImplBase.getInstance(), playerState);
                    }
                });
                notifyPlayerUpdatedNotLocked(sessionPlayer2);
            }
            if (!equals) {
                notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
            }
        }
        if (z) {
            this.mSessionCompat.setPlaybackToRemote(createVolumeProviderCompat);
        } else {
            this.mSessionCompat.setPlaybackToLocal(getLegacyStreamType(sessionPlayer.getAudioAttributes()));
        }
    }

    /* loaded from: classes.dex */
    public static class SessionPlayerCallback extends RemoteSessionPlayer.Callback implements MediaItem.OnMetadataChangedListener {
        private MediaItem mMediaItem;
        private List<MediaItem> mPlaylist;
        private final PlaylistItemListener mPlaylistItemChangedListener;
        private final WeakReference<MediaSessionImplBase> mSession;

        public SessionPlayerCallback(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
            this.mPlaylistItemChangedListener = new PlaylistItemListener(mediaSessionImplBase);
        }

        private void dispatchRemoteControllerTask(@NonNull SessionPlayer sessionPlayer, @NonNull RemoteControllerTask remoteControllerTask) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
            }
        }

        private MediaSessionImplBase getSession() {
            MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null && MediaSessionImplBase.DEBUG) {
                Log.d(MediaSessionImplBase.TAG, "Session is closed", new IllegalStateException());
            }
            return mediaSessionImplBase;
        }

        private void notifyCurrentMediaItemChanged(@Nullable final MediaItem mediaItem) {
            final MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            dispatchRemoteControllerTask(session.getPlayer(), new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.15
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onCurrentMediaItemChanged(i, mediaItem, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer) {
            MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
            if (currentMediaItem == null) {
                return false;
            }
            return updateCurrentMediaItemMetadataWithDuration(sessionPlayer, currentMediaItem, currentMediaItem.getMetadata());
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            MediaController.PlaybackInfo playbackInfo;
            AudioAttributesCompat audioAttributes;
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(sessionPlayer, audioAttributesCompat);
                synchronized (session.mLock) {
                    playbackInfo = session.mPlaybackInfo;
                    session.mPlaybackInfo = createPlaybackInfo;
                }
                if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                    if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
                        if (playbackInfo == null) {
                            audioAttributes = null;
                        } else {
                            audioAttributes = playbackInfo.getAudioAttributes();
                        }
                        int legacyStreamType = MediaSessionImplBase.getLegacyStreamType(audioAttributes);
                        int legacyStreamType2 = MediaSessionImplBase.getLegacyStreamType(createPlaybackInfo.getAudioAttributes());
                        if (legacyStreamType != legacyStreamType2) {
                            session.getSessionCompat().setPlaybackToLocal(legacyStreamType2);
                        }
                    }
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onBufferingStateChanged(@NonNull final SessionPlayer sessionPlayer, final MediaItem mediaItem, final int i) {
            updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.2
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i2, mediaItem, i, sessionPlayer.getBufferedPosition(), SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onCurrentMediaItemChanged(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem) {
            boolean z;
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                MediaItem mediaItem2 = this.mMediaItem;
                if (mediaItem2 != null) {
                    mediaItem2.removeOnMetadataChangedListener(this);
                }
                if (mediaItem != null) {
                    mediaItem.addOnMetadataChangedListener(session.mCallbackExecutor, this);
                }
                this.mMediaItem = mediaItem;
                session.getCallback().onCurrentMediaItemChanged(session.getInstance());
                if (mediaItem != null) {
                    z = updateCurrentMediaItemMetadataWithDuration(sessionPlayer, mediaItem, mediaItem.getMetadata());
                } else {
                    z = false;
                }
                if (!z) {
                    notifyCurrentMediaItemChanged(mediaItem);
                }
            }
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaSessionImplBase session = getSession();
            if (session != null && !updateCurrentMediaItemMetadataWithDuration(session.getPlayer(), mediaItem, mediaMetadata)) {
                notifyCurrentMediaItemChanged(mediaItem);
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.9
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackCompleted(i);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackSpeedChanged(@NonNull final SessionPlayer sessionPlayer, final float f) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.3
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), f);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlayerStateChanged(@NonNull final SessionPlayer sessionPlayer, final int i) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.getCallback().onPlayerStateChanged(session.getInstance(), i);
                updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
                session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.1
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        controllerCb.onPlayerStateChanged(i2, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), i);
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistChanged(@NonNull SessionPlayer sessionPlayer, final List<MediaItem> list, final MediaMetadata mediaMetadata) {
            final MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                if (this.mPlaylist != null) {
                    for (int i = 0; i < this.mPlaylist.size(); i++) {
                        this.mPlaylist.get(i).removeOnMetadataChangedListener(this.mPlaylistItemChangedListener);
                    }
                }
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        list.get(i2).addOnMetadataChangedListener(session.mCallbackExecutor, this.mPlaylistItemChangedListener);
                    }
                }
                this.mPlaylist = list;
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.5
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i3) throws RemoteException {
                        controllerCb.onPlaylistChanged(i3, list, mediaMetadata, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, final MediaMetadata mediaMetadata) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.6
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.7
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i2, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSeekCompleted(@NonNull final SessionPlayer sessionPlayer, final long j) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekCompleted(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), j);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.8
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i2, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull final MediaItem mediaItem, @NonNull final SessionPlayer.TrackInfo trackInfo, @NonNull final SubtitleData subtitleData) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.14
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSubtitleData(i, mediaItem, trackInfo, subtitleData);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.13
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackDeselected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.12
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackSelected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final List<SessionPlayer.TrackInfo> list) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.11
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTracksChanged(i, MediaUtils.upcastForPreparceling((List<SessionPlayer.TrackInfo>) list), MediaUtils.upcastForPreparceling(session.getSelectedTrack(1)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(2)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(4)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(5)));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final VideoSize videoSize) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.10
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVideoSizeChanged(i, MediaUtils.upcastForPreparceling(videoSize));
                }
            });
        }

        @Override // androidx.media2.session.RemoteSessionPlayer.Callback
        public void onVolumeChanged(@NonNull RemoteSessionPlayer remoteSessionPlayer, int i) {
            MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(remoteSessionPlayer, null);
            synchronized (session.mLock) {
                try {
                    if (session.mPlayer != remoteSessionPlayer) {
                        return;
                    }
                    MediaController.PlaybackInfo playbackInfo = session.mPlaybackInfo;
                    session.mPlaybackInfo = createPlaybackInfo;
                    VolumeProviderCompat volumeProviderCompat = session.mVolumeProviderCompat;
                    if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                        session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                    }
                    if (volumeProviderCompat != null) {
                        volumeProviderCompat.setCurrentVolume(i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaMetadata build;
            long duration = sessionPlayer.getDuration();
            if (mediaItem != sessionPlayer.getCurrentMediaItem() || sessionPlayer.getPlayerState() == 0 || duration <= 0 || duration == Long.MIN_VALUE) {
                return false;
            }
            if (mediaMetadata != null) {
                if (!mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                    build = new MediaMetadata.Builder(mediaMetadata).putLong("android.media.metadata.DURATION", duration).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                } else {
                    long j = mediaMetadata.getLong("android.media.metadata.DURATION");
                    if (duration != j) {
                        Log.w(MediaSessionImplBase.TAG, "duration mismatch for an item. duration from player=" + duration + " duration from metadata=" + j + ". May be a timing issue?");
                    }
                    build = null;
                }
            } else {
                build = new MediaMetadata.Builder().putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.MEDIA_ID", mediaItem.getMediaId()).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
            }
            if (build == null) {
                return false;
            }
            mediaItem.setMetadata(build);
            return true;
        }
    }

    private <T> T dispatchPlayerTask(@NonNull PlayerTask<T> playerTask, T t) {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        try {
            if (!isClosed()) {
                T run = playerTask.run(sessionPlayer);
                if (run != null) {
                    return run;
                }
            } else if (DEBUG) {
                Log.d(TAG, "API calls after the close()", new IllegalStateException());
            }
        } catch (Exception unused) {
        }
        return t;
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        int i;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                i = sequencedFutureManager.obtainNextSequenceNumber();
            } else {
                if (!isConnected(controllerInfo)) {
                    if (DEBUG) {
                        Log.d(TAG, "Skipping dispatching task to disconnected controller, controller=" + controllerInfo);
                        return;
                    }
                    return;
                }
                i = 0;
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
        } catch (DeadObjectException e) {
            onDeadObjectException(controllerInfo, e);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
        }
    }
}
