package androidx.media2.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SequencedFutureManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    private static final boolean THROW_EXCEPTION_FOR_NULL_RESULT = true;

    @GuardedBy("mLock")
    private SessionCommandGroup mAllowedCommands;

    @GuardedBy("mLock")
    private long mBufferedPositionMs;

    @GuardedBy("mLock")
    private int mBufferingState;

    @GuardedBy("mLock")
    private SessionToken mConnectedToken;
    private final Context mContext;
    final MediaControllerStub mControllerStub;

    @GuardedBy("mLock")
    private MediaItem mCurrentMediaItem;
    private final IBinder.DeathRecipient mDeathRecipient;

    @GuardedBy("mLock")
    private volatile IMediaSession mISession;
    final MediaController mInstance;

    @GuardedBy("mLock")
    private boolean mIsReleased;

    @GuardedBy("mLock")
    private MediaController.PlaybackInfo mPlaybackInfo;

    @GuardedBy("mLock")
    private float mPlaybackSpeed;

    @GuardedBy("mLock")
    private int mPlayerState;

    @GuardedBy("mLock")
    private List<MediaItem> mPlaylist;

    @GuardedBy("mLock")
    private MediaMetadata mPlaylistMetadata;

    @GuardedBy("mLock")
    private long mPositionEventTimeMs;

    @GuardedBy("mLock")
    private long mPositionMs;

    @GuardedBy("mLock")
    private int mRepeatMode;
    final SequencedFutureManager mSequencedFutureManager;

    @GuardedBy("mLock")
    private SessionServiceConnection mServiceConnection;

    @GuardedBy("mLock")
    private PendingIntent mSessionActivity;

    @GuardedBy("mLock")
    private int mShuffleMode;
    final SessionToken mToken;
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    static final String TAG = "MC2ImplBase";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mCurrentMediaItemIndex = -1;

    @GuardedBy("mLock")
    private int mPreviousMediaItemIndex = -1;

    @GuardedBy("mLock")
    private int mNextMediaItemIndex = -1;

    @GuardedBy("mLock")
    private VideoSize mVideoSize = new VideoSize(0, 0);

    @GuardedBy("mLock")
    private List<SessionPlayer.TrackInfo> mTracks = Collections.emptyList();

    @GuardedBy("mLock")
    private SparseArray<SessionPlayer.TrackInfo> mSelectedTracks = new SparseArray<>();

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public class SessionServiceConnection implements ServiceConnection {
        private final Bundle mConnectionHints;

        public SessionServiceConnection(@Nullable Bundle bundle) {
            this.mConnectionHints = bundle;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            MediaControllerImplBase.this.mInstance.close();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                try {
                    if (MediaControllerImplBase.DEBUG) {
                        Log.d(MediaControllerImplBase.TAG, "onServiceConnected " + componentName + " " + this);
                    }
                    if (!MediaControllerImplBase.this.mToken.getPackageName().equals(componentName.getPackageName())) {
                        Log.wtf(MediaControllerImplBase.TAG, "Expected connection to " + MediaControllerImplBase.this.mToken.getPackageName() + " but is connected to " + componentName);
                        MediaControllerImplBase.this.mInstance.close();
                        return;
                    }
                    IMediaSessionService asInterface = IMediaSessionService.Stub.asInterface(iBinder);
                    if (asInterface == null) {
                        Log.wtf(MediaControllerImplBase.TAG, "Service interface is missing.");
                        MediaControllerImplBase.this.mInstance.close();
                    } else {
                        asInterface.connect(MediaControllerImplBase.this.mControllerStub, MediaParcelUtils.toParcelable(new ConnectionRequest(MediaControllerImplBase.this.getContext().getPackageName(), Process.myPid(), this.mConnectionHints)));
                    }
                } catch (RemoteException unused) {
                    Log.w(MediaControllerImplBase.TAG, "Service " + componentName + " has died prematurely");
                    MediaControllerImplBase.this.mInstance.close();
                }
            } catch (Throwable th) {
                MediaControllerImplBase.this.mInstance.close();
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (MediaControllerImplBase.DEBUG) {
                Log.w(MediaControllerImplBase.TAG, "Session service " + componentName + " is disconnected.");
            }
            MediaControllerImplBase.this.mInstance.close();
        }
    }

    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        boolean requestConnectToService;
        this.mInstance = mediaController;
        if (context != null) {
            if (sessionToken != null) {
                this.mContext = context;
                SequencedFutureManager sequencedFutureManager = new SequencedFutureManager();
                this.mSequencedFutureManager = sequencedFutureManager;
                this.mControllerStub = new MediaControllerStub(this, sequencedFutureManager);
                this.mToken = sessionToken;
                this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: androidx.media2.session.MediaControllerImplBase.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        MediaControllerImplBase.this.mInstance.close();
                    }
                };
                if (sessionToken.getType() == 0) {
                    this.mServiceConnection = null;
                    requestConnectToService = requestConnectToSession(bundle);
                } else {
                    this.mServiceConnection = new SessionServiceConnection(bundle);
                    requestConnectToService = requestConnectToService();
                }
                if (!requestConnectToService) {
                    mediaController.close();
                    return;
                }
                return;
            }
            throw new NullPointerException("token shouldn't be null");
        }
        throw new NullPointerException("context shouldn't be null");
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTask(int i, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskInternal(i, null, remoteSessionTask);
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTaskInternal(int i, SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        IMediaSession sessionInterfaceIfAble;
        if (sessionCommand != null) {
            sessionInterfaceIfAble = getSessionInterfaceIfAble(sessionCommand);
        } else {
            sessionInterfaceIfAble = getSessionInterfaceIfAble(i);
        }
        if (sessionInterfaceIfAble != null) {
            SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
            try {
                remoteSessionTask.run(sessionInterfaceIfAble, createSequencedFuture.getSequenceNumber());
            } catch (RemoteException e) {
                Log.w(TAG, "Cannot connect to the service or the session is gone", e);
                createSequencedFuture.set(new SessionResult(-100));
            }
            return createSequencedFuture;
        }
        return SessionResult.createFutureWithResult(-4);
    }

    private boolean requestConnectToService() {
        Intent intent = new Intent(MediaSessionService.SERVICE_INTERFACE);
        intent.setClassName(this.mToken.getPackageName(), this.mToken.getServiceName());
        synchronized (this.mLock) {
            try {
                if (!this.mContext.bindService(intent, this.mServiceConnection, 4097)) {
                    Log.w(TAG, "bind to " + this.mToken + " failed");
                    return false;
                }
                if (DEBUG) {
                    Log.d(TAG, "bind to " + this.mToken + " succeeded");
                    return true;
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean requestConnectToSession(@Nullable Bundle bundle) {
        try {
            IMediaSession.Stub.asInterface((IBinder) this.mToken.getBinder()).connect(this.mControllerStub, this.mSequencedFutureManager.obtainNextSequenceNumber(), MediaParcelUtils.toParcelable(new ConnectionRequest(this.mContext.getPackageName(), Process.myPid(), bundle)));
            return true;
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to call connection request.", e);
            return false;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> addPlaylistItem(final int i, @NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.20
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.addPlaylistItem(MediaControllerImplBase.this.mControllerStub, i2, i, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> adjustVolume(final int i, final int i2) {
        return dispatchRemoteSessionTask(30001, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.12
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                iMediaSession.adjustVolume(MediaControllerImplBase.this.mControllerStub, i3, i, i2);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (DEBUG) {
            Log.d(TAG, "release from " + this.mToken);
        }
        synchronized (this.mLock) {
            try {
                IMediaSession iMediaSession = this.mISession;
                if (this.mIsReleased) {
                    return;
                }
                this.mIsReleased = true;
                SessionServiceConnection sessionServiceConnection = this.mServiceConnection;
                if (sessionServiceConnection != null) {
                    this.mContext.unbindService(sessionServiceConnection);
                    this.mServiceConnection = null;
                }
                this.mISession = null;
                this.mControllerStub.destroy();
                if (iMediaSession != null) {
                    int obtainNextSequenceNumber = this.mSequencedFutureManager.obtainNextSequenceNumber();
                    try {
                        iMediaSession.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
                        iMediaSession.release(this.mControllerStub, obtainNextSequenceNumber);
                    } catch (RemoteException unused) {
                    }
                }
                this.mSequencedFutureManager.close();
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.2
                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        controllerCallback.onDisconnected(MediaControllerImplBase.this.mInstance);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(11002, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.30
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.deselectTrack(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(trackInfo));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> fastForward() {
        return dispatchRemoteSessionTask(40000, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.6
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.fastForward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
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
        return null;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                return this.mBufferedPositionMs;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mBufferingState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            try {
                if (isConnected()) {
                    sessionToken = this.mConnectedToken;
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
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        return mediaItem;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mCurrentMediaItemIndex;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        long elapsedRealtime;
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                if (this.mPlayerState == 2 && this.mBufferingState != 2) {
                    Long l = this.mInstance.mTimeDiff;
                    if (l != null) {
                        elapsedRealtime = l.longValue();
                    } else {
                        elapsedRealtime = SystemClock.elapsedRealtime() - this.mPositionEventTimeMs;
                    }
                    return Math.max(0L, this.mPositionMs + (this.mPlaybackSpeed * ((float) elapsedRealtime)));
                }
                return this.mPositionMs;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        MediaMetadata metadata;
        synchronized (this.mLock) {
            try {
                MediaItem mediaItem = this.mCurrentMediaItem;
                if (mediaItem == null) {
                    metadata = null;
                } else {
                    metadata = mediaItem.getMetadata();
                }
                if (metadata != null && metadata.containsKey("android.media.metadata.DURATION")) {
                    return metadata.getLong("android.media.metadata.DURATION");
                }
                return Long.MIN_VALUE;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mNextMediaItemIndex;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0.0f;
                }
                return this.mPlaybackSpeed;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        int i;
        synchronized (this.mLock) {
            i = this.mPlayerState;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public List<MediaItem> getPlaylist() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            if (this.mPlaylist == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(this.mPlaylist);
            }
        }
        return arrayList;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mPlaylistMetadata;
        }
        return mediaMetadata;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mPreviousMediaItemIndex;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        int i;
        synchronized (this.mLock) {
            i = this.mRepeatMode;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        SessionPlayer.TrackInfo trackInfo;
        synchronized (this.mLock) {
            trackInfo = this.mSelectedTracks.get(i);
        }
        return trackInfo;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public PendingIntent getSessionActivity() {
        PendingIntent pendingIntent;
        synchronized (this.mLock) {
            pendingIntent = this.mSessionActivity;
        }
        return pendingIntent;
    }

    public IMediaSession getSessionInterfaceIfAble(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mAllowedCommands.hasCommand(i)) {
                    Log.w(TAG, "Controller isn't allowed to call command, commandCode=" + i);
                    return null;
                }
                return this.mISession;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        int i;
        synchronized (this.mLock) {
            i = this.mShuffleMode;
        }
        return i;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        List<SessionPlayer.TrackInfo> list;
        synchronized (this.mLock) {
            list = this.mTracks;
        }
        return list;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        VideoSize videoSize;
        synchronized (this.mLock) {
            videoSize = this.mVideoSize;
        }
        return videoSize;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mISession != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> movePlaylistItem(final int i, final int i2) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.23
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                iMediaSession.movePlaylistItem(MediaControllerImplBase.this.mControllerStub, i3, i, i2);
            }
        });
    }

    public void notifyBufferingStateChanged(final MediaItem mediaItem, final int i, long j, long j2, long j3) {
        synchronized (this.mLock) {
            this.mBufferingState = i;
            this.mBufferedPositionMs = j;
            this.mPositionEventTimeMs = j2;
            this.mPositionMs = j3;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.35
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onBufferingStateChanged(MediaControllerImplBase.this.mInstance, mediaItem, i);
            }
        });
    }

    public void notifyCurrentMediaItemChanged(final MediaItem mediaItem, int i, int i2, int i3) {
        synchronized (this.mLock) {
            try {
                this.mCurrentMediaItem = mediaItem;
                this.mCurrentMediaItemIndex = i;
                this.mPreviousMediaItemIndex = i2;
                this.mNextMediaItemIndex = i3;
                List<MediaItem> list = this.mPlaylist;
                if (list != null && i >= 0 && i < list.size()) {
                    this.mPlaylist.set(i, mediaItem);
                }
                this.mPositionEventTimeMs = SystemClock.elapsedRealtime();
                this.mPositionMs = 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.32
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplBase.this.mInstance, mediaItem);
            }
        });
    }

    public void notifyPlaybackCompleted() {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.41
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlaybackCompleted(MediaControllerImplBase.this.mInstance);
            }
        });
    }

    public void notifyPlaybackInfoChanges(final MediaController.PlaybackInfo playbackInfo) {
        synchronized (this.mLock) {
            this.mPlaybackInfo = playbackInfo;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.38
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlaybackInfoChanged(MediaControllerImplBase.this.mInstance, playbackInfo);
            }
        });
    }

    public void notifyPlaybackSpeedChanges(long j, long j2, final float f) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
            this.mPlaybackSpeed = f;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.34
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlaybackSpeedChanged(MediaControllerImplBase.this.mInstance, f);
            }
        });
    }

    public void notifyPlayerStateChanges(long j, long j2, final int i) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
            this.mPlayerState = i;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.33
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlayerStateChanged(MediaControllerImplBase.this.mInstance, i);
            }
        });
    }

    public void notifyPlaylistChanges(final List<MediaItem> list, final MediaMetadata mediaMetadata, int i, int i2, int i3) {
        synchronized (this.mLock) {
            try {
                this.mPlaylist = list;
                this.mPlaylistMetadata = mediaMetadata;
                this.mCurrentMediaItemIndex = i;
                this.mPreviousMediaItemIndex = i2;
                this.mNextMediaItemIndex = i3;
                if (i >= 0 && list != null && i < list.size()) {
                    this.mCurrentMediaItem = list.get(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.36
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlaylistChanged(MediaControllerImplBase.this.mInstance, list, mediaMetadata);
            }
        });
    }

    public void notifyPlaylistMetadataChanges(final MediaMetadata mediaMetadata) {
        synchronized (this.mLock) {
            this.mPlaylistMetadata = mediaMetadata;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.37
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onPlaylistMetadataChanged(MediaControllerImplBase.this.mInstance, mediaMetadata);
            }
        });
    }

    public void notifyRepeatModeChanges(final int i, int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mRepeatMode = i;
            this.mCurrentMediaItemIndex = i2;
            this.mPreviousMediaItemIndex = i3;
            this.mNextMediaItemIndex = i4;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.39
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onRepeatModeChanged(MediaControllerImplBase.this.mInstance, i);
            }
        });
    }

    public void notifySeekCompleted(long j, long j2, final long j3) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.42
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onSeekCompleted(MediaControllerImplBase.this.mInstance, j3);
            }
        });
    }

    public void notifyShuffleModeChanges(final int i, int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mShuffleMode = i;
            this.mCurrentMediaItemIndex = i2;
            this.mPreviousMediaItemIndex = i3;
            this.mNextMediaItemIndex = i4;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.40
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onShuffleModeChanged(MediaControllerImplBase.this.mInstance, i);
            }
        });
    }

    public void notifySubtitleData(final MediaItem mediaItem, final SessionPlayer.TrackInfo trackInfo, final SubtitleData subtitleData) {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.47
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onSubtitleData(MediaControllerImplBase.this.mInstance, mediaItem, trackInfo, subtitleData);
            }
        });
    }

    public void notifyTrackDeselected(int i, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.remove(trackInfo.getTrackType());
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.46
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onTrackDeselected(MediaControllerImplBase.this.mInstance, trackInfo);
            }
        });
    }

    public void notifyTrackSelected(int i, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.put(trackInfo.getTrackType(), trackInfo);
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.45
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onTrackSelected(MediaControllerImplBase.this.mInstance, trackInfo);
            }
        });
    }

    public void notifyTracksChanged(int i, final List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        synchronized (this.mLock) {
            this.mTracks = list;
            this.mSelectedTracks.put(1, trackInfo);
            this.mSelectedTracks.put(2, trackInfo2);
            this.mSelectedTracks.put(4, trackInfo3);
            this.mSelectedTracks.put(5, trackInfo4);
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.44
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                controllerCallback.onTracksChanged(MediaControllerImplBase.this.mInstance, list);
            }
        });
    }

    public void notifyVideoSizeChanged(final VideoSize videoSize) {
        final MediaItem mediaItem;
        synchronized (this.mLock) {
            this.mVideoSize = videoSize;
            mediaItem = this.mCurrentMediaItem;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.43
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (!MediaControllerImplBase.this.mInstance.isConnected()) {
                    return;
                }
                MediaItem mediaItem2 = mediaItem;
                if (mediaItem2 != null) {
                    controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, mediaItem2, videoSize);
                }
                controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, videoSize);
            }
        });
    }

    public void onAllowedCommandsChanged(final SessionCommandGroup sessionCommandGroup) {
        synchronized (this.mLock) {
            this.mAllowedCommands = sessionCommandGroup;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.50
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                controllerCallback.onAllowedCommandsChanged(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
            }
        });
    }

    public void onConnectedNotLocked(int i, IMediaSession iMediaSession, final SessionCommandGroup sessionCommandGroup, int i2, MediaItem mediaItem, long j, long j2, float f, long j3, MediaController.PlaybackInfo playbackInfo, int i3, int i4, List<MediaItem> list, PendingIntent pendingIntent, int i5, int i6, int i7, Bundle bundle, VideoSize videoSize, List<SessionPlayer.TrackInfo> list2, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4, MediaMetadata mediaMetadata, int i8) {
        if (DEBUG) {
            Log.d(TAG, "onConnectedNotLocked sessionBinder=" + iMediaSession + ", allowedCommands=" + sessionCommandGroup);
        }
        if (iMediaSession != null && sessionCommandGroup != null) {
            try {
                synchronized (this.mLock) {
                    try {
                        if (this.mIsReleased) {
                            return;
                        }
                        try {
                            if (this.mISession != null) {
                                Log.e(TAG, "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                                this.mInstance.close();
                                return;
                            }
                            this.mAllowedCommands = sessionCommandGroup;
                            this.mPlayerState = i2;
                            this.mCurrentMediaItem = mediaItem;
                            this.mPositionEventTimeMs = j;
                            this.mPositionMs = j2;
                            this.mPlaybackSpeed = f;
                            this.mBufferedPositionMs = j3;
                            this.mPlaybackInfo = playbackInfo;
                            this.mRepeatMode = i3;
                            this.mShuffleMode = i4;
                            this.mPlaylist = list;
                            this.mSessionActivity = pendingIntent;
                            this.mISession = iMediaSession;
                            this.mCurrentMediaItemIndex = i5;
                            this.mPreviousMediaItemIndex = i6;
                            this.mNextMediaItemIndex = i7;
                            this.mVideoSize = videoSize;
                            this.mTracks = list2;
                            this.mSelectedTracks.put(1, trackInfo);
                            this.mSelectedTracks.put(2, trackInfo2);
                            this.mSelectedTracks.put(4, trackInfo3);
                            this.mSelectedTracks.put(5, trackInfo4);
                            this.mPlaylistMetadata = mediaMetadata;
                            this.mBufferingState = i8;
                            try {
                                this.mISession.asBinder().linkToDeath(this.mDeathRecipient, 0);
                                this.mConnectedToken = new SessionToken(new SessionTokenImplBase(this.mToken.getUid(), 0, this.mToken.getPackageName(), iMediaSession, bundle));
                                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.48
                                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                        controllerCallback.onConnected(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
                                    }
                                });
                            } catch (RemoteException e) {
                                if (DEBUG) {
                                    Log.d(TAG, "Session died too early.", e);
                                }
                                this.mInstance.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    this.mInstance.close();
                }
                throw th3;
            }
        } else {
            this.mInstance.close();
        }
    }

    public void onCustomCommand(final int i, final SessionCommand sessionCommand, final Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "onCustomCommand cmd=" + sessionCommand.getCustomAction());
        }
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.49
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                SessionResult onCustomCommand = controllerCallback.onCustomCommand(MediaControllerImplBase.this.mInstance, sessionCommand, bundle);
                if (onCustomCommand != null) {
                    MediaControllerImplBase.this.sendControllerResult(i, onCustomCommand);
                    return;
                }
                throw new RuntimeException("ControllerCallback#onCustomCommand() has returned null, command=" + sessionCommand.getCustomAction());
            }
        });
    }

    public void onSetCustomLayout(final int i, final List<MediaSession.CommandButton> list) {
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplBase.51
            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                MediaControllerImplBase.this.sendControllerResult(i, new SessionResult(controllerCallback.onSetCustomLayout(MediaControllerImplBase.this.mInstance, list)));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> pause() {
        return dispatchRemoteSessionTask(10001, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.4
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.pause(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> play() {
        return dispatchRemoteSessionTask(10000, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.3
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.play(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> prepare() {
        return dispatchRemoteSessionTask(10002, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.5
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.prepare(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> removePlaylistItem(final int i) {
        return dispatchRemoteSessionTask(10014, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.21
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.removePlaylistItem(MediaControllerImplBase.this.mControllerStub, i2, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> replacePlaylistItem(final int i, @NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_REPLACE_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.22
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.replacePlaylistItem(MediaControllerImplBase.this.mControllerStub, i2, i, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> rewind() {
        return dispatchRemoteSessionTask(40001, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.7
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.rewind(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> seekTo(final long j) {
        if (j >= 0) {
            return dispatchRemoteSessionTask(10003, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.10
                @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    iMediaSession.seekTo(MediaControllerImplBase.this.mControllerStub, i, j);
                }
            });
        }
        throw new IllegalArgumentException("position shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(11001, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.29
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.selectTrack(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(trackInfo));
            }
        });
    }

    public void sendControllerResult(int i, @NonNull SessionResult sessionResult) {
        IMediaSession iMediaSession;
        synchronized (this.mLock) {
            iMediaSession = this.mISession;
        }
        if (iMediaSession == null) {
            return;
        }
        try {
            iMediaSession.onControllerResult(this.mControllerStub, i, MediaParcelUtils.toParcelable(sessionResult));
        } catch (RemoteException unused) {
            Log.w(TAG, "Error in sending");
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask(sessionCommand, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.15
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.onCustomCommand(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(sessionCommand), bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaItem(@NonNull final String str) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.17
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setMediaItem(MediaControllerImplBase.this.mControllerStub, i, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaUri(@NonNull final Uri uri, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.18
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setMediaUri(MediaControllerImplBase.this.mControllerStub, i, uri, bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaybackSpeed(final float f) {
        return dispatchRemoteSessionTask(10004, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.13
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setPlaybackSpeed(MediaControllerImplBase.this.mControllerStub, i, f);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaylist(@NonNull final List<String> list, @Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask(10006, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.16
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setPlaylist(MediaControllerImplBase.this.mControllerStub, i, list, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRating(@NonNull final String str, @NonNull final Rating rating) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.14
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setRating(MediaControllerImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(rating));
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRepeatMode(final int i) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.27
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.setRepeatMode(MediaControllerImplBase.this.mControllerStub, i2, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setShuffleMode(final int i) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.28
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.setShuffleMode(MediaControllerImplBase.this.mControllerStub, i2, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setSurface(@Nullable final Surface surface) {
        return dispatchRemoteSessionTask(11000, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.31
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setSurface(MediaControllerImplBase.this.mControllerStub, i, surface);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setVolumeTo(final int i, final int i2) {
        return dispatchRemoteSessionTask(30000, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.11
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                iMediaSession.setVolumeTo(MediaControllerImplBase.this.mControllerStub, i3, i, i2);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipBackward() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.9
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipBackward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipForward() {
        return dispatchRemoteSessionTask(40002, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.8
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipForward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToNextItem() {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.25
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipToNextItem(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPlaylistItem(final int i) {
        return dispatchRemoteSessionTask(10007, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.26
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                iMediaSession.skipToPlaylistItem(MediaControllerImplBase.this.mControllerStub, i2, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPreviousItem() {
        return dispatchRemoteSessionTask(10008, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.24
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipToPreviousItem(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, new RemoteSessionTask() { // from class: androidx.media2.session.MediaControllerImplBase.19
            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.updatePlaylistMetadata(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        });
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTask(SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskInternal(0, sessionCommand, remoteSessionTask);
    }

    public IMediaSession getSessionInterfaceIfAble(SessionCommand sessionCommand) {
        synchronized (this.mLock) {
            try {
                if (!this.mAllowedCommands.hasCommand(sessionCommand)) {
                    Log.w(TAG, "Controller isn't allowed to call command, command=" + sessionCommand);
                    return null;
                }
                return this.mISession;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
