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

class MediaSessionImplBase implements MediaSession.MediaSessionImpl {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media2.session.id";
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    private static final Object STATIC_LOCK = new Object();
    static final String TAG = "MSImplBase";
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
    @GuardedBy("mLock")
    @Nullable
    VolumeProviderCompat mVolumeProviderCompat;

    public static final class CombinedCommandResultFuture<T extends BaseResult> extends AbstractResolvableFuture<T> {
        final ListenableFuture<T>[] mFutures;
        AtomicInteger mSuccessCount = new AtomicInteger(0);

        private CombinedCommandResultFuture(Executor executor, ListenableFuture<T>[] listenableFutureArr) {
            final int i = 0;
            this.mFutures = listenableFutureArr;
            while (true) {
                ListenableFuture<T>[] listenableFutureArr2 = this.mFutures;
                if (i < listenableFutureArr2.length) {
                    listenableFutureArr2[i].addListener(new Runnable() {
                        public void run() {
                            int i = 0;
                            try {
                                BaseResult baseResult = (BaseResult) CombinedCommandResultFuture.this.mFutures[i].get();
                                int resultCode = baseResult.getResultCode();
                                if (resultCode == 0 || resultCode == 1) {
                                    int incrementAndGet = CombinedCommandResultFuture.this.mSuccessCount.incrementAndGet();
                                    CombinedCommandResultFuture combinedCommandResultFuture = CombinedCommandResultFuture.this;
                                    if (incrementAndGet == combinedCommandResultFuture.mFutures.length) {
                                        boolean unused = combinedCommandResultFuture.set(baseResult);
                                        return;
                                    }
                                    return;
                                }
                                int i2 = 0;
                                while (true) {
                                    CombinedCommandResultFuture combinedCommandResultFuture2 = CombinedCommandResultFuture.this;
                                    ListenableFuture<T>[] listenableFutureArr = combinedCommandResultFuture2.mFutures;
                                    if (i2 < listenableFutureArr.length) {
                                        if (!listenableFutureArr[i2].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i2].isDone() && i != i2) {
                                            CombinedCommandResultFuture.this.mFutures[i2].cancel(true);
                                        }
                                        i2++;
                                    } else {
                                        boolean unused2 = combinedCommandResultFuture2.set(baseResult);
                                        return;
                                    }
                                }
                            } catch (Exception e) {
                                while (true) {
                                    CombinedCommandResultFuture combinedCommandResultFuture3 = CombinedCommandResultFuture.this;
                                    ListenableFuture<T>[] listenableFutureArr2 = combinedCommandResultFuture3.mFutures;
                                    if (i < listenableFutureArr2.length) {
                                        if (!listenableFutureArr2[i].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i].isDone() && i != i) {
                                            CombinedCommandResultFuture.this.mFutures[i].cancel(true);
                                        }
                                        i++;
                                    } else {
                                        boolean unused3 = combinedCommandResultFuture3.setException(e);
                                        return;
                                    }
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

    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && ObjectsCompat.equals(intent.getData(), MediaSessionImplBase.this.mSessionUri) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                MediaSessionImplBase.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
            }
        }
    }

    @FunctionalInterface
    public interface PlayerTask<T> {
        T run(@NonNull SessionPlayer sessionPlayer) throws Exception;
    }

    public static class PlaylistItemListener implements MediaItem.OnMetadataChangedListener {
        private final WeakReference<MediaSessionImplBase> mSession;

        public PlaylistItemListener(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
            r0 = r5.getPlaylist();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMetadataChanged(@androidx.annotation.NonNull androidx.media2.common.MediaItem r4, androidx.media2.common.MediaMetadata r5) {
            /*
                r3 = this;
                java.lang.ref.WeakReference<androidx.media2.session.MediaSessionImplBase> r5 = r3.mSession
                java.lang.Object r5 = r5.get()
                androidx.media2.session.MediaSessionImplBase r5 = (androidx.media2.session.MediaSessionImplBase) r5
                if (r5 == 0) goto L_0x0031
                if (r4 != 0) goto L_0x000d
                goto L_0x0031
            L_0x000d:
                java.util.List r0 = r5.getPlaylist()
                if (r0 != 0) goto L_0x0014
                return
            L_0x0014:
                r1 = 0
            L_0x0015:
                int r2 = r0.size()
                if (r1 >= r2) goto L_0x0031
                java.lang.Object r2 = r0.get(r1)
                boolean r2 = r4.equals(r2)
                if (r2 == 0) goto L_0x002e
                androidx.media2.session.MediaSessionImplBase$PlaylistItemListener$1 r4 = new androidx.media2.session.MediaSessionImplBase$PlaylistItemListener$1
                r4.<init>(r0, r5)
                r5.dispatchRemoteControllerTaskWithoutReturn(r4)
                return
            L_0x002e:
                int r1 = r1 + 1
                goto L_0x0015
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaSessionImplBase.PlaylistItemListener.onMetadataChanged(androidx.media2.common.MediaItem, androidx.media2.common.MediaMetadata):void");
        }
    }

    @FunctionalInterface
    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    public MediaSessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        ComponentName componentName;
        Context context2 = context;
        String str2 = str;
        PendingIntent pendingIntent2 = pendingIntent;
        this.mContext = context2;
        this.mInstance = mediaSession;
        HandlerThread handlerThread = new HandlerThread("MediaSession_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.mSessionStub = mediaSessionStub;
        this.mSessionActivity = pendingIntent2;
        this.mCallback = sessionCallback;
        this.mCallbackExecutor = executor;
        this.mAudioManager = (AudioManager) context2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.mPlayerCallback = new SessionPlayerCallback(this);
        this.mSessionId = str2;
        Uri build = new Uri.Builder().scheme(MediaSessionImplBase.class.getName()).appendPath(str2).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.mSessionUri = build;
        SessionToken sessionToken = new SessionToken(new SessionTokenImplBase(Process.myUid(), 0, context.getPackageName(), mediaSessionStub, bundle));
        this.mSessionToken = sessionToken;
        String join = TextUtils.join(".", new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, str2});
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
                while (true) {
                    throw th;
                }
            }
        }
        if (componentName == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", build);
            intent.setPackage(context.getPackageName());
            this.mMediaButtonIntent = PendingIntent.getBroadcast(context2, 0, intent, 0);
            ComponentName componentName2 = new ComponentName(context2, context.getClass());
            MediaButtonReceiver mediaButtonReceiver = new MediaButtonReceiver();
            this.mBroadcastReceiver = mediaButtonReceiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(build.getScheme());
            context2.registerReceiver(mediaButtonReceiver, intentFilter);
            componentName = componentName2;
        } else {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", build);
            intent2.setComponent(componentName);
            if (Build.VERSION.SDK_INT >= 26) {
                this.mMediaButtonIntent = PendingIntent.getForegroundService(context2, 0, intent2, 0);
            } else {
                this.mMediaButtonIntent = PendingIntent.getService(context2, 0, intent2, 0);
            }
            this.mBroadcastReceiver = null;
        }
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, join, componentName, this.mMediaButtonIntent, sessionToken.getExtras(), sessionToken);
        this.mSessionCompat = mediaSessionCompat;
        MediaSessionLegacyStub mediaSessionLegacyStub = new MediaSessionLegacyStub(this, handler);
        this.mSessionLegacyStub = mediaSessionLegacyStub;
        mediaSessionCompat.setSessionActivity(pendingIntent2);
        mediaSessionCompat.setFlags(4);
        updatePlayer(sessionPlayer);
        mediaSessionCompat.setCallback(mediaSessionLegacyStub, handler);
        mediaSessionCompat.setActive(true);
    }

    private static VolumeProviderCompat createVolumeProviderCompat(@NonNull final RemoteSessionPlayer remoteSessionPlayer) {
        return new VolumeProviderCompat(remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume()) {
            public void onAdjustVolume(int i) {
                remoteSessionPlayer.adjustVolume(i);
            }

            public void onSetVolumeTo(int i) {
                remoteSessionPlayer.setVolume(i);
            }
        };
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [androidx.media2.session.MediaSessionImplBase$PlayerTask, androidx.media2.session.MediaSessionImplBase$PlayerTask<com.google.common.util.concurrent.ListenableFuture<androidx.media2.common.SessionPlayer$PlayerResult>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.common.util.concurrent.ListenableFuture<androidx.media2.common.SessionPlayer.PlayerResult> dispatchPlayerTask(@androidx.annotation.NonNull androidx.media2.session.MediaSessionImplBase.PlayerTask<com.google.common.util.concurrent.ListenableFuture<androidx.media2.common.SessionPlayer.PlayerResult>> r5) {
        /*
            r4 = this;
            androidx.concurrent.futures.ResolvableFuture r0 = androidx.concurrent.futures.ResolvableFuture.create()
            androidx.media2.common.SessionPlayer$PlayerResult r1 = new androidx.media2.common.SessionPlayer$PlayerResult
            r2 = -2
            r3 = 0
            r1.<init>(r2, r3)
            r0.set(r1)
            java.lang.Object r5 = r4.dispatchPlayerTask(r5, r0)
            com.google.common.util.concurrent.ListenableFuture r5 = (com.google.common.util.concurrent.ListenableFuture) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaSessionImplBase.dispatchPlayerTask(androidx.media2.session.MediaSessionImplBase$PlayerTask):com.google.common.util.concurrent.ListenableFuture");
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        int i;
        SequencedFutureManager.SequencedFuture sequencedFuture;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                i = createSequencedFuture.getSequenceNumber();
                sequencedFuture = createSequencedFuture;
            } else if (!isConnected(controllerInfo)) {
                return SessionResult.createFutureWithResult(-100);
            } else {
                i = 0;
                sequencedFuture = SessionResult.createFutureWithResult(0);
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
            return sequencedFuture;
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
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    @SuppressLint({"WrongConstant"})
    private void notifyPlayerUpdatedNotLocked(SessionPlayer sessionPlayer) {
        List<MediaItem> playlist = sessionPlayer.getPlaylist();
        final List<MediaItem> playlistOrNull = getPlaylistOrNull();
        if (!ObjectsCompat.equals(playlist, playlistOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistChanged(i, playlistOrNull, MediaSessionImplBase.this.getPlaylistMetadata(), MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        } else {
            MediaMetadata playlistMetadata = sessionPlayer.getPlaylistMetadata();
            final MediaMetadata playlistMetadata2 = getPlaylistMetadata();
            if (!ObjectsCompat.equals(playlistMetadata, playlistMetadata2)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onPlaylistMetadataChanged(i, playlistMetadata2);
                    }
                });
            }
        }
        MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
        final MediaItem currentMediaItemOrNull = getCurrentMediaItemOrNull();
        if (!ObjectsCompat.equals(currentMediaItem, currentMediaItemOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onCurrentMediaItemChanged(i, currentMediaItemOrNull, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int repeatMode = getRepeatMode();
        if (sessionPlayer.getRepeatMode() != repeatMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i, repeatMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int shuffleMode = getShuffleMode();
        if (sessionPlayer.getShuffleMode() != shuffleMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i, shuffleMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentPosition = getCurrentPosition();
        final int playerState = getPlayerState();
        final long j = elapsedRealtime;
        final long j2 = currentPosition;
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlayerStateChanged(i, j, j2, playerState);
            }
        });
        final MediaItem currentMediaItemOrNull2 = getCurrentMediaItemOrNull();
        if (currentMediaItemOrNull2 != null) {
            final int bufferingState = getBufferingState();
            final long bufferedPosition = getBufferedPosition();
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i, currentMediaItemOrNull2, bufferingState, bufferedPosition, SystemClock.elapsedRealtime(), MediaSessionImplBase.this.getCurrentPosition());
                }
            });
        }
        final float playbackSpeed = getPlaybackSpeed();
        if (playbackSpeed != sessionPlayer.getPlaybackSpeed()) {
            final long j3 = elapsedRealtime;
            final long j4 = currentPosition;
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, j3, j4, playbackSpeed);
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

    public ListenableFuture<SessionPlayer.PlayerResult> addPlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (mediaItem != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.addPlaylistItem(i, mediaItem);
                }
            });
        } else {
            throw new NullPointerException("item shouldn't be null");
        }
    }

    public void broadcastCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r1.unregisterPlayerCallback(r4.mPlayerCallback);
        r4.mSessionCompat.release();
        r4.mMediaButtonIntent.cancel();
        r0 = r4.mBroadcastReceiver;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        if (r0 == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r4.mContext.unregisterReceiver(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r4.mCallback.onSessionClosed(r4.mInstance);
        dispatchRemoteControllerTaskWithoutReturn(new androidx.media2.session.MediaSessionImplBase.AnonymousClass2(r4));
        r4.mHandler.removeCallbacksAndMessages((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        if (r4.mHandlerThread.isAlive() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        r4.mHandlerThread.quitSafely();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r4.mClosed     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r1 = move-exception
            goto L_0x0076
        L_0x000b:
            r1 = 1
            r4.mClosed = r1     // Catch:{ all -> 0x0009 }
            boolean r1 = DEBUG     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = "MSImplBase"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0009 }
            r2.<init>()     // Catch:{ all -> 0x0009 }
            java.lang.String r3 = "Closing session, id="
            r2.append(r3)     // Catch:{ all -> 0x0009 }
            java.lang.String r3 = r4.getId()     // Catch:{ all -> 0x0009 }
            r2.append(r3)     // Catch:{ all -> 0x0009 }
            java.lang.String r3 = ", token="
            r2.append(r3)     // Catch:{ all -> 0x0009 }
            androidx.media2.session.SessionToken r3 = r4.getToken()     // Catch:{ all -> 0x0009 }
            r2.append(r3)     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0009 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0009 }
        L_0x0038:
            androidx.media2.common.SessionPlayer r1 = r4.mPlayer     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            androidx.media2.session.MediaSessionImplBase$SessionPlayerCallback r0 = r4.mPlayerCallback
            r1.unregisterPlayerCallback(r0)
            android.support.v4.media.session.MediaSessionCompat r0 = r4.mSessionCompat
            r0.release()
            android.app.PendingIntent r0 = r4.mMediaButtonIntent
            r0.cancel()
            android.content.BroadcastReceiver r0 = r4.mBroadcastReceiver
            if (r0 == 0) goto L_0x0053
            android.content.Context r1 = r4.mContext
            r1.unregisterReceiver(r0)
        L_0x0053:
            androidx.media2.session.MediaSession$SessionCallback r0 = r4.mCallback
            androidx.media2.session.MediaSession r1 = r4.mInstance
            r0.onSessionClosed(r1)
            androidx.media2.session.MediaSessionImplBase$2 r0 = new androidx.media2.session.MediaSessionImplBase$2
            r0.<init>()
            r4.dispatchRemoteControllerTaskWithoutReturn(r0)
            android.os.Handler r0 = r4.mHandler
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.HandlerThread r0 = r4.mHandlerThread
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L_0x0075
            android.os.HandlerThread r0 = r4.mHandlerThread
            r0.quitSafely()
        L_0x0075:
            return
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaSessionImplBase.close():void");
    }

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

    public PlaybackStateCompat createPlaybackStateCompat() {
        int convertToPlaybackStateCompatState = MediaUtils.convertToPlaybackStateCompatState(getPlayerState(), getBufferingState());
        return new PlaybackStateCompat.Builder().setState(convertToPlaybackStateCompatState, getCurrentPosition(), getPlaybackSpeed(), SystemClock.elapsedRealtime()).setActions(3670015).setActiveQueueItemId(MediaUtils.convertToQueueItemId(getCurrentMediaItemIndex())).setBufferedPosition(getBufferedPosition()).build();
    }

    public ListenableFuture<SessionPlayer.PlayerResult> deselectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
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

    public long getBufferedPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() {
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getBufferedPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    public int getBufferingState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getBufferingState());
            }
        }, 0)).intValue();
    }

    public MediaSession.SessionCallback getCallback() {
        return this.mCallback;
    }

    public Executor getCallbackExecutor() {
        return this.mCallbackExecutor;
    }

    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mSessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.mSessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MediaItem getCurrentMediaItem() {
        return (MediaItem) dispatchPlayerTask(new PlayerTask<MediaItem>() {
            public MediaItem run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getCurrentMediaItem();
            }
        }, (Object) null);
    }

    public int getCurrentMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getCurrentMediaItemIndex());
            }
        }, -1)).intValue();
    }

    public long getCurrentPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() {
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getCurrentPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    public long getDuration() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() {
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getDuration());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @NonNull
    public String getId() {
        return this.mSessionId;
    }

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

    public IBinder getLegacyBrowserServiceBinder() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            try {
                if (this.mBrowserServiceLegacyStub == null) {
                    this.mBrowserServiceLegacyStub = createLegacyBrowserServiceLocked(this.mContext, this.mSessionToken, this.mSessionCompat.getSessionToken());
                }
                mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return mediaBrowserServiceCompat.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    public int getNextMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getNextMediaItemIndex());
            }
        }, -1)).intValue();
    }

    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    public float getPlaybackSpeed() {
        return ((Float) dispatchPlayerTask(new PlayerTask<Float>() {
            public Float run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Float.valueOf(sessionPlayer.getPlaybackSpeed());
                }
                return null;
            }
        }, Float.valueOf(1.0f))).floatValue();
    }

    @NonNull
    public SessionPlayer getPlayer() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        return sessionPlayer;
    }

    public int getPlayerState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPlayerState());
            }
        }, 3)).intValue();
    }

    public List<MediaItem> getPlaylist() {
        return (List) dispatchPlayerTask(new PlayerTask<List<MediaItem>>() {
            public List<MediaItem> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylist();
            }
        }, (Object) null);
    }

    public MediaMetadata getPlaylistMetadata() {
        return (MediaMetadata) dispatchPlayerTask(new PlayerTask<MediaMetadata>() {
            public MediaMetadata run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylistMetadata();
            }
        }, (Object) null);
    }

    public int getPreviousMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPreviousMediaItemIndex());
            }
        }, -1)).intValue();
    }

    public int getRepeatMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getRepeatMode());
            }
        }, 0)).intValue();
    }

    public SessionPlayer.TrackInfo getSelectedTrack(final int i) {
        return (SessionPlayer.TrackInfo) dispatchPlayerTask(new PlayerTask<SessionPlayer.TrackInfo>() {
            public SessionPlayer.TrackInfo run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getSelectedTrack(i));
            }
        }, (Object) null);
    }

    public PendingIntent getSessionActivity() {
        return this.mSessionActivity;
    }

    public MediaSessionCompat getSessionCompat() {
        return this.mSessionCompat;
    }

    public int getShuffleMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() {
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getShuffleMode());
            }
        }, 0)).intValue();
    }

    @NonNull
    public SessionToken getToken() {
        return this.mSessionToken;
    }

    public List<SessionPlayer.TrackInfo> getTracks() {
        return (List) dispatchPlayerTask(new PlayerTask<List<SessionPlayer.TrackInfo>>() {
            public List<SessionPlayer.TrackInfo> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getTracks());
            }
        }, (Object) null);
    }

    @NonNull
    public Uri getUri() {
        return this.mSessionUri;
    }

    public VideoSize getVideoSize() {
        return (VideoSize) dispatchPlayerTask(new PlayerTask<VideoSize>() {
            public VideoSize run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getVideoSize());
            }
        }, new VideoSize(0, 0));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }

    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo == null) {
            return false;
        }
        if (this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo) || this.mSessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            return true;
        }
        return false;
    }

    public boolean isInPlaybackState(@NonNull SessionPlayer sessionPlayer) {
        if (isClosed() || sessionPlayer.getPlayerState() == 0 || sessionPlayer.getPlayerState() == 3) {
            return false;
        }
        return true;
    }

    public ListenableFuture<SessionPlayer.PlayerResult> movePlaylistItem(final int i, final int i2) {
        if (i >= 0 && i2 >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.movePlaylistItem(i, i2);
                }
            });
        }
        throw new IllegalArgumentException("indices shouldn't be negative");
    }

    public void notifyPlaybackInfoChangedNotLocked(final MediaController.PlaybackInfo playbackInfo) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlaybackInfoChanged(i, playbackInfo);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> pause() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.pause();
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> play() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
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

    public ListenableFuture<SessionPlayer.PlayerResult> prepare() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.prepare();
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> removePlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
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

    public ListenableFuture<SessionPlayer.PlayerResult> replacePlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (mediaItem != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.replacePlaylistItem(i, mediaItem);
                }
            });
        } else {
            throw new NullPointerException("item shouldn't be null");
        }
    }

    public ListenableFuture<SessionPlayer.PlayerResult> seekTo(final long j) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.seekTo(j);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> selectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.selectTrack(trackInfo);
            }
        });
    }

    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    public void setAllowedCommands(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommandGroup sessionCommandGroup) {
        if (this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.mSessionStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAllowedCommandsChanged(i, sessionCommandGroup);
                }
            });
            return;
        }
        this.mSessionLegacyStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
    }

    public ListenableFuture<SessionResult> setCustomLayout(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final List<MediaSession.CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, list);
            }
        });
    }

    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.mSessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setMediaItem(@NonNull final MediaItem mediaItem) {
        if (mediaItem != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setMediaItem(mediaItem);
                }
            });
        }
        throw new NullPointerException("item shouldn't be null");
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setPlaybackSpeed(final float f) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setPlaybackSpeed(f);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setPlaylist(@NonNull final List<MediaItem> list, @Nullable final MediaMetadata mediaMetadata) {
        if (list != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setPlaylist(list, mediaMetadata);
                }
            });
        }
        throw new NullPointerException("list shouldn't be null");
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setRepeatMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setRepeatMode(i);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setShuffleMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setShuffleMode(i);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> setSurface(final Surface surface) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setSurface(surface);
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> skipToNextItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToNextPlaylistItem();
            }
        });
    }

    public ListenableFuture<SessionPlayer.PlayerResult> skipToPlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
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

    public ListenableFuture<SessionPlayer.PlayerResult> skipToPreviousItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToPreviousPlaylistItem();
            }
        });
    }

    public void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2) {
    }

    public ListenableFuture<SessionPlayer.PlayerResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() {
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.updatePlaylistMetadata(mediaMetadata);
            }
        });
    }

    @SuppressLint({"WrongConstant"})
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        boolean equals;
        SessionPlayer sessionPlayer2;
        VolumeProviderCompat volumeProviderCompat = null;
        MediaController.PlaybackInfo createPlaybackInfo = createPlaybackInfo(sessionPlayer, (AudioAttributesCompat) null);
        boolean z = sessionPlayer instanceof RemoteSessionPlayer;
        if (z) {
            volumeProviderCompat = createVolumeProviderCompat((RemoteSessionPlayer) sessionPlayer);
        }
        synchronized (this.mLock) {
            equals = createPlaybackInfo.equals(this.mPlaybackInfo);
            sessionPlayer2 = this.mPlayer;
            this.mPlayer = sessionPlayer;
            this.mPlaybackInfo = createPlaybackInfo;
            this.mVolumeProviderCompat = volumeProviderCompat;
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
                this.mCallbackExecutor.execute(new Runnable() {
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
            this.mSessionCompat.setPlaybackToRemote(volumeProviderCompat);
            return;
        }
        this.mSessionCompat.setPlaybackToLocal(getLegacyStreamType(sessionPlayer.getAudioAttributes()));
    }

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
            if (session != null) {
                dispatchRemoteControllerTask(session.getPlayer(), new RemoteControllerTask() {
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onCurrentMediaItemChanged(i, mediaItem, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                    }
                });
            }
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer) {
            MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
            if (currentMediaItem == null) {
                return false;
            }
            return updateCurrentMediaItemMetadataWithDuration(sessionPlayer, currentMediaItem, currentMediaItem.getMetadata());
        }

        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            MediaController.PlaybackInfo playbackInfo;
            AudioAttributesCompat audioAttributesCompat2;
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
                            audioAttributesCompat2 = null;
                        } else {
                            audioAttributesCompat2 = playbackInfo.getAudioAttributes();
                        }
                        int legacyStreamType = MediaSessionImplBase.getLegacyStreamType(audioAttributesCompat2);
                        int legacyStreamType2 = MediaSessionImplBase.getLegacyStreamType(createPlaybackInfo.getAudioAttributes());
                        if (legacyStreamType != legacyStreamType2) {
                            session.getSessionCompat().setPlaybackToLocal(legacyStreamType2);
                        }
                    }
                }
            }
        }

        public void onBufferingStateChanged(@NonNull final SessionPlayer sessionPlayer, final MediaItem mediaItem, final int i) {
            updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i, mediaItem, i, sessionPlayer.getBufferedPosition(), SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition());
                }
            });
        }

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

        public void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaSessionImplBase session = getSession();
            if (session != null && !updateCurrentMediaItemMetadataWithDuration(session.getPlayer(), mediaItem, mediaMetadata)) {
                notifyCurrentMediaItemChanged(mediaItem);
            }
        }

        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackCompleted(i);
                }
            });
        }

        public void onPlaybackSpeedChanged(@NonNull final SessionPlayer sessionPlayer, final float f) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), f);
                }
            });
        }

        public void onPlayerStateChanged(@NonNull final SessionPlayer sessionPlayer, final int i) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.getCallback().onPlayerStateChanged(session.getInstance(), i);
                updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
                session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() {
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onPlayerStateChanged(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), i);
                    }
                });
            }
        }

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
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onPlaylistChanged(i, list, mediaMetadata, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                    }
                });
            }
        }

        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, final MediaMetadata mediaMetadata) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistMetadataChanged(i, mediaMetadata);
                }
            });
        }

        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        public void onSeekCompleted(@NonNull final SessionPlayer sessionPlayer, final long j) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekCompleted(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), j);
                }
            });
        }

        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull final MediaItem mediaItem, @NonNull final SessionPlayer.TrackInfo trackInfo, @NonNull final SubtitleData subtitleData) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSubtitleData(i, mediaItem, trackInfo, subtitleData);
                }
            });
        }

        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackDeselected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackSelected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final List<SessionPlayer.TrackInfo> list) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTracksChanged(i, MediaUtils.upcastForPreparceling((List<SessionPlayer.TrackInfo>) list), MediaUtils.upcastForPreparceling(session.getSelectedTrack(1)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(2)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(4)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(5)));
                }
            });
        }

        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final VideoSize videoSize) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() {
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVideoSizeChanged(i, MediaUtils.upcastForPreparceling(videoSize));
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            if (androidx.core.util.ObjectsCompat.equals(r1, r5) != false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            r0.notifyPlaybackInfoChangedNotLocked(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r3 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r3.setCurrentVolume(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onVolumeChanged(@androidx.annotation.NonNull androidx.media2.session.RemoteSessionPlayer r5, int r6) {
            /*
                r4 = this;
                androidx.media2.session.MediaSessionImplBase r0 = r4.getSession()
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                r1 = 0
                androidx.media2.session.MediaController$PlaybackInfo r1 = r0.createPlaybackInfo(r5, r1)
                java.lang.Object r2 = r0.mLock
                monitor-enter(r2)
                androidx.media2.common.SessionPlayer r3 = r0.mPlayer     // Catch:{ all -> 0x0015 }
                if (r3 == r5) goto L_0x0017
                monitor-exit(r2)     // Catch:{ all -> 0x0015 }
                return
            L_0x0015:
                r5 = move-exception
                goto L_0x002d
            L_0x0017:
                androidx.media2.session.MediaController$PlaybackInfo r5 = r0.mPlaybackInfo     // Catch:{ all -> 0x0015 }
                r0.mPlaybackInfo = r1     // Catch:{ all -> 0x0015 }
                androidx.media.VolumeProviderCompat r3 = r0.mVolumeProviderCompat     // Catch:{ all -> 0x0015 }
                monitor-exit(r2)     // Catch:{ all -> 0x0015 }
                boolean r5 = androidx.core.util.ObjectsCompat.equals(r1, r5)
                if (r5 != 0) goto L_0x0027
                r0.notifyPlaybackInfoChangedNotLocked(r1)
            L_0x0027:
                if (r3 == 0) goto L_0x002c
                r3.setCurrentVolume(r6)
            L_0x002c:
                return
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0015 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.onVolumeChanged(androidx.media2.session.RemoteSessionPlayer, int):void");
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaMetadata mediaMetadata2;
            long duration = sessionPlayer.getDuration();
            if (mediaItem != sessionPlayer.getCurrentMediaItem() || sessionPlayer.getPlayerState() == 0 || duration <= 0 || duration == Long.MIN_VALUE) {
                return false;
            }
            if (mediaMetadata == null) {
                mediaMetadata2 = new MediaMetadata.Builder().putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.MEDIA_ID", mediaItem.getMediaId()).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1).build();
            } else if (!mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                mediaMetadata2 = new MediaMetadata.Builder(mediaMetadata).putLong("android.media.metadata.DURATION", duration).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1).build();
            } else {
                long j = mediaMetadata.getLong("android.media.metadata.DURATION");
                if (duration != j) {
                    Log.w(MediaSessionImplBase.TAG, "duration mismatch for an item. duration from player=" + duration + " duration from metadata=" + j + ". May be a timing issue?");
                }
                mediaMetadata2 = null;
            }
            if (mediaMetadata2 == null) {
                return false;
            }
            mediaItem.setMetadata(mediaMetadata2);
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
            } else if (isConnected(controllerInfo)) {
                i = 0;
            } else if (DEBUG) {
                Log.d(TAG, "Skipping dispatching task to disconnected controller, controller=" + controllerInfo);
                return;
            } else {
                return;
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
        } catch (DeadObjectException e) {
            onDeadObjectException(controllerInfo, e);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
        }
    }
}
