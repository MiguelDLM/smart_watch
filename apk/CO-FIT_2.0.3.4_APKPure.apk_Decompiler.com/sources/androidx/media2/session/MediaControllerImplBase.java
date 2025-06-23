package androidx.media2.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
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
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SequencedFutureManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    static final String TAG = "MC2ImplBase";
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
    @GuardedBy("mLock")
    private int mCurrentMediaItemIndex = -1;
    private final IBinder.DeathRecipient mDeathRecipient;
    @GuardedBy("mLock")
    private volatile IMediaSession mISession;
    final MediaController mInstance;
    @GuardedBy("mLock")
    private boolean mIsReleased;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private int mNextMediaItemIndex = -1;
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
    private int mPreviousMediaItemIndex = -1;
    @GuardedBy("mLock")
    private int mRepeatMode;
    @GuardedBy("mLock")
    private SparseArray<SessionPlayer.TrackInfo> mSelectedTracks = new SparseArray<>();
    final SequencedFutureManager mSequencedFutureManager;
    @GuardedBy("mLock")
    private SessionServiceConnection mServiceConnection;
    @GuardedBy("mLock")
    private PendingIntent mSessionActivity;
    @GuardedBy("mLock")
    private int mShuffleMode;
    final SessionToken mToken;
    @GuardedBy("mLock")
    private List<SessionPlayer.TrackInfo> mTracks = Collections.emptyList();
    @GuardedBy("mLock")
    private VideoSize mVideoSize = new VideoSize(0, 0);

    @FunctionalInterface
    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    public class SessionServiceConnection implements ServiceConnection {
        private final Bundle mConnectionHints;

        public SessionServiceConnection(@Nullable Bundle bundle) {
            this.mConnectionHints = bundle;
        }

        public void onBindingDied(ComponentName componentName) {
            MediaControllerImplBase.this.mInstance.close();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|20|21|22|25) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b9, code lost:
            r5.this$0.mInstance.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c0, code lost:
            throw r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0098 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(android.content.ComponentName r6, android.os.IBinder r7) {
            /*
                r5 = this;
                java.lang.String r0 = "MC2ImplBase"
                boolean r1 = androidx.media2.session.MediaControllerImplBase.DEBUG     // Catch:{ RemoteException -> 0x0098 }
                if (r1 == 0) goto L_0x0026
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0098 }
                r1.<init>()     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r2 = "onServiceConnected "
                r1.append(r2)     // Catch:{ RemoteException -> 0x0098 }
                r1.append(r6)     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r2 = " "
                r1.append(r2)     // Catch:{ RemoteException -> 0x0098 }
                r1.append(r5)     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r1 = r1.toString()     // Catch:{ RemoteException -> 0x0098 }
                android.util.Log.d(r0, r1)     // Catch:{ RemoteException -> 0x0098 }
                goto L_0x0026
            L_0x0023:
                r6 = move-exception
                goto L_0x00b9
            L_0x0026:
                androidx.media2.session.MediaControllerImplBase r1 = androidx.media2.session.MediaControllerImplBase.this     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.SessionToken r1 = r1.mToken     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r2 = r6.getPackageName()     // Catch:{ RemoteException -> 0x0098 }
                boolean r1 = r1.equals(r2)     // Catch:{ RemoteException -> 0x0098 }
                if (r1 != 0) goto L_0x0064
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0098 }
                r7.<init>()     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r1 = "Expected connection to "
                r7.append(r1)     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerImplBase r1 = androidx.media2.session.MediaControllerImplBase.this     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.SessionToken r1 = r1.mToken     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ RemoteException -> 0x0098 }
                r7.append(r1)     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r1 = " but is connected to "
                r7.append(r1)     // Catch:{ RemoteException -> 0x0098 }
                r7.append(r6)     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r7 = r7.toString()     // Catch:{ RemoteException -> 0x0098 }
                android.util.Log.wtf(r0, r7)     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerImplBase r6 = androidx.media2.session.MediaControllerImplBase.this
                androidx.media2.session.MediaController r6 = r6.mInstance
                r6.close()
                return
            L_0x0064:
                androidx.media2.session.IMediaSessionService r7 = androidx.media2.session.IMediaSessionService.Stub.asInterface(r7)     // Catch:{ RemoteException -> 0x0098 }
                if (r7 != 0) goto L_0x0077
                java.lang.String r7 = "Service interface is missing."
                android.util.Log.wtf(r0, r7)     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerImplBase r6 = androidx.media2.session.MediaControllerImplBase.this
                androidx.media2.session.MediaController r6 = r6.mInstance
                r6.close()
                return
            L_0x0077:
                androidx.media2.session.ConnectionRequest r1 = new androidx.media2.session.ConnectionRequest     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerImplBase r2 = androidx.media2.session.MediaControllerImplBase.this     // Catch:{ RemoteException -> 0x0098 }
                android.content.Context r2 = r2.getContext()     // Catch:{ RemoteException -> 0x0098 }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ RemoteException -> 0x0098 }
                int r3 = android.os.Process.myPid()     // Catch:{ RemoteException -> 0x0098 }
                android.os.Bundle r4 = r5.mConnectionHints     // Catch:{ RemoteException -> 0x0098 }
                r1.<init>(r2, r3, r4)     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerImplBase r2 = androidx.media2.session.MediaControllerImplBase.this     // Catch:{ RemoteException -> 0x0098 }
                androidx.media2.session.MediaControllerStub r2 = r2.mControllerStub     // Catch:{ RemoteException -> 0x0098 }
                androidx.versionedparcelable.ParcelImpl r1 = androidx.media2.common.MediaParcelUtils.toParcelable(r1)     // Catch:{ RemoteException -> 0x0098 }
                r7.connect(r2, r1)     // Catch:{ RemoteException -> 0x0098 }
                goto L_0x00b8
            L_0x0098:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
                r7.<init>()     // Catch:{ all -> 0x0023 }
                java.lang.String r1 = "Service "
                r7.append(r1)     // Catch:{ all -> 0x0023 }
                r7.append(r6)     // Catch:{ all -> 0x0023 }
                java.lang.String r6 = " has died prematurely"
                r7.append(r6)     // Catch:{ all -> 0x0023 }
                java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0023 }
                android.util.Log.w(r0, r6)     // Catch:{ all -> 0x0023 }
                androidx.media2.session.MediaControllerImplBase r6 = androidx.media2.session.MediaControllerImplBase.this
                androidx.media2.session.MediaController r6 = r6.mInstance
                r6.close()
            L_0x00b8:
                return
            L_0x00b9:
                androidx.media2.session.MediaControllerImplBase r7 = androidx.media2.session.MediaControllerImplBase.this
                androidx.media2.session.MediaController r7 = r7.mInstance
                r7.close()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplBase.SessionServiceConnection.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (MediaControllerImplBase.DEBUG) {
                Log.w(MediaControllerImplBase.TAG, "Session service " + componentName + " is disconnected.");
            }
            MediaControllerImplBase.this.mInstance.close();
        }
    }

    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        boolean z;
        this.mInstance = mediaController;
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        } else if (sessionToken != null) {
            this.mContext = context;
            SequencedFutureManager sequencedFutureManager = new SequencedFutureManager();
            this.mSequencedFutureManager = sequencedFutureManager;
            this.mControllerStub = new MediaControllerStub(this, sequencedFutureManager);
            this.mToken = sessionToken;
            this.mDeathRecipient = new IBinder.DeathRecipient() {
                public void binderDied() {
                    MediaControllerImplBase.this.mInstance.close();
                }
            };
            if (sessionToken.getType() == 0) {
                this.mServiceConnection = null;
                z = requestConnectToSession(bundle);
            } else {
                this.mServiceConnection = new SessionServiceConnection(bundle);
                z = requestConnectToService();
            }
            if (!z) {
                mediaController.close();
            }
        } else {
            throw new NullPointerException("token shouldn't be null");
        }
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTask(int i, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskInternal(i, (SessionCommand) null, remoteSessionTask);
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTaskInternal(int i, SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        IMediaSession iMediaSession;
        if (sessionCommand != null) {
            iMediaSession = getSessionInterfaceIfAble(sessionCommand);
        } else {
            iMediaSession = getSessionInterfaceIfAble(i);
        }
        if (iMediaSession == null) {
            return SessionResult.createFutureWithResult(-4);
        }
        SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
        try {
            remoteSessionTask.run(iMediaSession, createSequencedFuture.getSequenceNumber());
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to the service or the session is gone", e);
            createSequencedFuture.set(new SessionResult(-100));
        }
        return createSequencedFuture;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (DEBUG == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        android.util.Log.d(TAG, "bind to " + r5.mToken + " succeeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean requestConnectToService() {
        /*
            r5 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.media2.session.MediaSessionService"
            r0.<init>(r1)
            androidx.media2.session.SessionToken r1 = r5.mToken
            java.lang.String r1 = r1.getPackageName()
            androidx.media2.session.SessionToken r2 = r5.mToken
            java.lang.String r2 = r2.getServiceName()
            r0.setClassName(r1, r2)
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            android.content.Context r2 = r5.mContext     // Catch:{ all -> 0x0045 }
            androidx.media2.session.MediaControllerImplBase$SessionServiceConnection r3 = r5.mServiceConnection     // Catch:{ all -> 0x0045 }
            r4 = 4097(0x1001, float:5.741E-42)
            boolean r0 = r2.bindService(r0, r3, r4)     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "MC2ImplBase"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r2.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "bind to "
            r2.append(r3)     // Catch:{ all -> 0x0045 }
            androidx.media2.session.SessionToken r3 = r5.mToken     // Catch:{ all -> 0x0045 }
            r2.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = " failed"
            r2.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0045 }
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x0045 }
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            r0 = 0
            return r0
        L_0x0045:
            r0 = move-exception
            goto L_0x006b
        L_0x0047:
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "MC2ImplBase"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "bind to "
            r1.append(r2)
            androidx.media2.session.SessionToken r2 = r5.mToken
            r1.append(r2)
            java.lang.String r2 = " succeeded"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x0069:
            r0 = 1
            return r0
        L_0x006b:
            monitor-exit(r1)     // Catch:{ all -> 0x0045 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplBase.requestConnectToService():boolean");
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

    public ListenableFuture<SessionResult> addPlaylistItem(final int i, @NonNull final String str) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.addPlaylistItem(MediaControllerImplBase.this.mControllerStub, i, i, str);
            }
        });
    }

    public ListenableFuture<SessionResult> adjustVolume(final int i, final int i2) {
        return dispatchRemoteSessionTask(30001, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.adjustVolume(MediaControllerImplBase.this.mControllerStub, i, i, i2);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r1 == null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r0 = r5.mSequencedFutureManager.obtainNextSequenceNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.asBinder().unlinkToDeath(r5.mDeathRecipient, 0);
        r1.release(r5.mControllerStub, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r5 = this;
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = "MC2ImplBase"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "release from "
            r1.append(r2)
            androidx.media2.session.SessionToken r2 = r5.mToken
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x001c:
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            androidx.media2.session.IMediaSession r1 = r5.mISession     // Catch:{ all -> 0x0027 }
            boolean r2 = r5.mIsReleased     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0029
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r1 = move-exception
            goto L_0x0067
        L_0x0029:
            r2 = 1
            r5.mIsReleased = r2     // Catch:{ all -> 0x0027 }
            androidx.media2.session.MediaControllerImplBase$SessionServiceConnection r2 = r5.mServiceConnection     // Catch:{ all -> 0x0027 }
            r3 = 0
            if (r2 == 0) goto L_0x0038
            android.content.Context r4 = r5.mContext     // Catch:{ all -> 0x0027 }
            r4.unbindService(r2)     // Catch:{ all -> 0x0027 }
            r5.mServiceConnection = r3     // Catch:{ all -> 0x0027 }
        L_0x0038:
            r5.mISession = r3     // Catch:{ all -> 0x0027 }
            androidx.media2.session.MediaControllerStub r2 = r5.mControllerStub     // Catch:{ all -> 0x0027 }
            r2.destroy()     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0057
            androidx.media2.session.SequencedFutureManager r0 = r5.mSequencedFutureManager
            int r0 = r0.obtainNextSequenceNumber()
            android.os.IBinder r2 = r1.asBinder()     // Catch:{ RemoteException -> 0x0057 }
            android.os.IBinder$DeathRecipient r3 = r5.mDeathRecipient     // Catch:{ RemoteException -> 0x0057 }
            r4 = 0
            r2.unlinkToDeath(r3, r4)     // Catch:{ RemoteException -> 0x0057 }
            androidx.media2.session.MediaControllerStub r2 = r5.mControllerStub     // Catch:{ RemoteException -> 0x0057 }
            r1.release(r2, r0)     // Catch:{ RemoteException -> 0x0057 }
        L_0x0057:
            androidx.media2.session.SequencedFutureManager r0 = r5.mSequencedFutureManager
            r0.close()
            androidx.media2.session.MediaController r0 = r5.mInstance
            androidx.media2.session.MediaControllerImplBase$2 r1 = new androidx.media2.session.MediaControllerImplBase$2
            r1.<init>()
            r0.notifyAllControllerCallbacks(r1)
            return
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplBase.close():void");
    }

    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(11002, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.deselectTrack(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(trackInfo));
            }
        });
    }

    public ListenableFuture<SessionResult> fastForward() {
        return dispatchRemoteSessionTask(40000, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.fastForward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
                return sessionCommandGroup;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        return null;
    }

    public long getBufferedPosition() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                long j = this.mBufferedPositionMs;
                return j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getBufferingState() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                int i = this.mBufferingState;
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

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

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public MediaItem getCurrentMediaItem() {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        return mediaItem;
    }

    public int getCurrentMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mCurrentMediaItemIndex;
        }
        return i;
    }

    public long getCurrentPosition() {
        long j;
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                } else if (this.mPlayerState != 2 || this.mBufferingState == 2) {
                    long j2 = this.mPositionMs;
                    return j2;
                } else {
                    Long l = this.mInstance.mTimeDiff;
                    if (l != null) {
                        j = l.longValue();
                    } else {
                        j = SystemClock.elapsedRealtime() - this.mPositionEventTimeMs;
                    }
                    long max = Math.max(0, this.mPositionMs + ((long) (this.mPlaybackSpeed * ((float) j))));
                    return max;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return Long.MIN_VALUE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getDuration() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            androidx.media2.common.MediaItem r1 = r3.mCurrentMediaItem     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0009
            r1 = 0
            goto L_0x000d
        L_0x0009:
            androidx.media2.common.MediaMetadata r1 = r1.getMetadata()     // Catch:{ all -> 0x001f }
        L_0x000d:
            if (r1 == 0) goto L_0x0021
            java.lang.String r2 = "android.media.metadata.DURATION"
            boolean r2 = r1.containsKey(r2)     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x0021
            java.lang.String r2 = "android.media.metadata.DURATION"
            long r1 = r1.getLong(r2)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return r1
        L_0x001f:
            r1 = move-exception
            goto L_0x0025
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            r0 = -9223372036854775808
            return r0
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplBase.getDuration():long");
    }

    public int getNextMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mNextMediaItemIndex;
        }
        return i;
    }

    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            try {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0.0f;
                }
                float f = this.mPlaybackSpeed;
                return f;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getPlayerState() {
        int i;
        synchronized (this.mLock) {
            i = this.mPlayerState;
        }
        return i;
    }

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

    public MediaMetadata getPlaylistMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mPlaylistMetadata;
        }
        return mediaMetadata;
    }

    public int getPreviousMediaItemIndex() {
        int i;
        synchronized (this.mLock) {
            i = this.mPreviousMediaItemIndex;
        }
        return i;
    }

    public int getRepeatMode() {
        int i;
        synchronized (this.mLock) {
            i = this.mRepeatMode;
        }
        return i;
    }

    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        SessionPlayer.TrackInfo trackInfo;
        synchronized (this.mLock) {
            trackInfo = this.mSelectedTracks.get(i);
        }
        return trackInfo;
    }

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
                IMediaSession iMediaSession = this.mISession;
                return iMediaSession;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getShuffleMode() {
        int i;
        synchronized (this.mLock) {
            i = this.mShuffleMode;
        }
        return i;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        List<SessionPlayer.TrackInfo> list;
        synchronized (this.mLock) {
            list = this.mTracks;
        }
        return list;
    }

    @NonNull
    public VideoSize getVideoSize() {
        VideoSize videoSize;
        synchronized (this.mLock) {
            videoSize = this.mVideoSize;
        }
        return videoSize;
    }

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

    public ListenableFuture<SessionResult> movePlaylistItem(final int i, final int i2) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.movePlaylistItem(MediaControllerImplBase.this.mControllerStub, i, i, i2);
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
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onBufferingStateChanged(MediaControllerImplBase.this.mInstance, mediaItem, i);
                }
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
                this.mPositionMs = 0;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onCurrentMediaItemChanged(MediaControllerImplBase.this.mInstance, mediaItem);
                }
            }
        });
    }

    public void notifyPlaybackCompleted() {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackCompleted(MediaControllerImplBase.this.mInstance);
                }
            }
        });
    }

    public void notifyPlaybackInfoChanges(final MediaController.PlaybackInfo playbackInfo) {
        synchronized (this.mLock) {
            this.mPlaybackInfo = playbackInfo;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackInfoChanged(MediaControllerImplBase.this.mInstance, playbackInfo);
                }
            }
        });
    }

    public void notifyPlaybackSpeedChanges(long j, long j2, final float f) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
            this.mPlaybackSpeed = f;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaybackSpeedChanged(MediaControllerImplBase.this.mInstance, f);
                }
            }
        });
    }

    public void notifyPlayerStateChanges(long j, long j2, final int i) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
            this.mPlayerState = i;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlayerStateChanged(MediaControllerImplBase.this.mInstance, i);
                }
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
                while (true) {
                    throw th;
                }
            }
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaylistChanged(MediaControllerImplBase.this.mInstance, list, mediaMetadata);
                }
            }
        });
    }

    public void notifyPlaylistMetadataChanges(final MediaMetadata mediaMetadata) {
        synchronized (this.mLock) {
            this.mPlaylistMetadata = mediaMetadata;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onPlaylistMetadataChanged(MediaControllerImplBase.this.mInstance, mediaMetadata);
                }
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
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onRepeatModeChanged(MediaControllerImplBase.this.mInstance, i);
                }
            }
        });
    }

    public void notifySeekCompleted(long j, long j2, final long j3) {
        synchronized (this.mLock) {
            this.mPositionEventTimeMs = j;
            this.mPositionMs = j2;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onSeekCompleted(MediaControllerImplBase.this.mInstance, j3);
                }
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
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onShuffleModeChanged(MediaControllerImplBase.this.mInstance, i);
                }
            }
        });
    }

    public void notifySubtitleData(final MediaItem mediaItem, final SessionPlayer.TrackInfo trackInfo, final SubtitleData subtitleData) {
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onSubtitleData(MediaControllerImplBase.this.mInstance, mediaItem, trackInfo, subtitleData);
                }
            }
        });
    }

    public void notifyTrackDeselected(int i, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.remove(trackInfo.getTrackType());
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTrackDeselected(MediaControllerImplBase.this.mInstance, trackInfo);
                }
            }
        });
    }

    public void notifyTrackSelected(int i, final SessionPlayer.TrackInfo trackInfo) {
        synchronized (this.mLock) {
            this.mSelectedTracks.put(trackInfo.getTrackType(), trackInfo);
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTrackSelected(MediaControllerImplBase.this.mInstance, trackInfo);
                }
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
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    controllerCallback.onTracksChanged(MediaControllerImplBase.this.mInstance, list);
                }
            }
        });
    }

    public void notifyVideoSizeChanged(final VideoSize videoSize) {
        final MediaItem mediaItem;
        synchronized (this.mLock) {
            this.mVideoSize = videoSize;
            mediaItem = this.mCurrentMediaItem;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                if (MediaControllerImplBase.this.mInstance.isConnected()) {
                    MediaItem mediaItem = mediaItem;
                    if (mediaItem != null) {
                        controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, mediaItem, videoSize);
                    }
                    controllerCallback.onVideoSizeChanged(MediaControllerImplBase.this.mInstance, videoSize);
                }
            }
        });
    }

    public void onAllowedCommandsChanged(final SessionCommandGroup sessionCommandGroup) {
        synchronized (this.mLock) {
            this.mAllowedCommands = sessionCommandGroup;
        }
        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                controllerCallback.onAllowedCommandsChanged(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
            }
        });
    }

    public void onConnectedNotLocked(int i, IMediaSession iMediaSession, final SessionCommandGroup sessionCommandGroup, int i2, MediaItem mediaItem, long j, long j2, float f, long j3, MediaController.PlaybackInfo playbackInfo, int i3, int i4, List<MediaItem> list, PendingIntent pendingIntent, int i5, int i6, int i7, Bundle bundle, VideoSize videoSize, List<SessionPlayer.TrackInfo> list2, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4, MediaMetadata mediaMetadata, int i8) {
        IMediaSession iMediaSession2 = iMediaSession;
        SessionCommandGroup sessionCommandGroup2 = sessionCommandGroup;
        if (DEBUG) {
            Log.d(TAG, "onConnectedNotLocked sessionBinder=" + iMediaSession + ", allowedCommands=" + sessionCommandGroup);
        }
        if (iMediaSession2 == null || sessionCommandGroup2 == null) {
            this.mInstance.close();
            return;
        }
        boolean z = false;
        try {
            synchronized (this.mLock) {
                try {
                    if (!this.mIsReleased) {
                        if (this.mISession != null) {
                            Log.e(TAG, "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                            try {
                                this.mInstance.close();
                            } catch (Throwable th) {
                                th = th;
                                z = true;
                                throw th;
                            }
                        } else {
                            this.mAllowedCommands = sessionCommandGroup2;
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
                            this.mISession = iMediaSession2;
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
                            this.mISession.asBinder().linkToDeath(this.mDeathRecipient, 0);
                            this.mConnectedToken = new SessionToken(new SessionTokenImplBase(this.mToken.getUid(), 0, this.mToken.getPackageName(), iMediaSession, bundle));
                            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onConnected(MediaControllerImplBase.this.mInstance, sessionCommandGroup);
                                }
                            });
                        }
                    }
                } catch (RemoteException e) {
                    if (DEBUG) {
                        Log.d(TAG, "Session died too early.", e);
                    }
                    this.mInstance.close();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (z) {
                this.mInstance.close();
            }
            throw th3;
        }
    }

    public void onCustomCommand(final int i, final SessionCommand sessionCommand, final Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "onCustomCommand cmd=" + sessionCommand.getCustomAction());
        }
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() {
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
        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() {
            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                MediaControllerImplBase.this.sendControllerResult(i, new SessionResult(controllerCallback.onSetCustomLayout(MediaControllerImplBase.this.mInstance, list)));
            }
        });
    }

    public ListenableFuture<SessionResult> pause() {
        return dispatchRemoteSessionTask(10001, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.pause(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> play() {
        return dispatchRemoteSessionTask(10000, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.play(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> prepare() {
        return dispatchRemoteSessionTask(10002, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.prepare(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> removePlaylistItem(final int i) {
        return dispatchRemoteSessionTask(10014, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.removePlaylistItem(MediaControllerImplBase.this.mControllerStub, i, i);
            }
        });
    }

    public ListenableFuture<SessionResult> replacePlaylistItem(final int i, @NonNull final String str) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_REPLACE_PLAYLIST_ITEM, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.replacePlaylistItem(MediaControllerImplBase.this.mControllerStub, i, i, str);
            }
        });
    }

    public ListenableFuture<SessionResult> rewind() {
        return dispatchRemoteSessionTask(40001, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.rewind(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> seekTo(final long j) {
        if (j >= 0) {
            return dispatchRemoteSessionTask(10003, (RemoteSessionTask) new RemoteSessionTask() {
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    iMediaSession.seekTo(MediaControllerImplBase.this.mControllerStub, i, j);
                }
            });
        }
        throw new IllegalArgumentException("position shouldn't be negative");
    }

    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull final SessionPlayer.TrackInfo trackInfo) {
        return dispatchRemoteSessionTask(11001, (RemoteSessionTask) new RemoteSessionTask() {
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
        if (iMediaSession != null) {
            try {
                iMediaSession.onControllerResult(this.mControllerStub, i, MediaParcelUtils.toParcelable(sessionResult));
            } catch (RemoteException unused) {
                Log.w(TAG, "Error in sending");
            }
        }
    }

    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask(sessionCommand, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.onCustomCommand(MediaControllerImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(sessionCommand), bundle);
            }
        });
    }

    public ListenableFuture<SessionResult> setMediaItem(@NonNull final String str) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setMediaItem(MediaControllerImplBase.this.mControllerStub, i, str);
            }
        });
    }

    public ListenableFuture<SessionResult> setMediaUri(@NonNull final Uri uri, @Nullable final Bundle bundle) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setMediaUri(MediaControllerImplBase.this.mControllerStub, i, uri, bundle);
            }
        });
    }

    public ListenableFuture<SessionResult> setPlaybackSpeed(final float f) {
        return dispatchRemoteSessionTask(10004, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setPlaybackSpeed(MediaControllerImplBase.this.mControllerStub, i, f);
            }
        });
    }

    public ListenableFuture<SessionResult> setPlaylist(@NonNull final List<String> list, @Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask(10006, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setPlaylist(MediaControllerImplBase.this.mControllerStub, i, list, MediaParcelUtils.toParcelable(mediaMetadata));
            }
        });
    }

    public ListenableFuture<SessionResult> setRating(@NonNull final String str, @NonNull final Rating rating) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SET_RATING, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setRating(MediaControllerImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(rating));
            }
        });
    }

    public ListenableFuture<SessionResult> setRepeatMode(final int i) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setRepeatMode(MediaControllerImplBase.this.mControllerStub, i, i);
            }
        });
    }

    public ListenableFuture<SessionResult> setShuffleMode(final int i) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setShuffleMode(MediaControllerImplBase.this.mControllerStub, i, i);
            }
        });
    }

    public ListenableFuture<SessionResult> setSurface(@Nullable final Surface surface) {
        return dispatchRemoteSessionTask(11000, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setSurface(MediaControllerImplBase.this.mControllerStub, i, surface);
            }
        });
    }

    public ListenableFuture<SessionResult> setVolumeTo(final int i, final int i2) {
        return dispatchRemoteSessionTask(30000, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.setVolumeTo(MediaControllerImplBase.this.mControllerStub, i, i, i2);
            }
        });
    }

    public ListenableFuture<SessionResult> skipBackward() {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipBackward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> skipForward() {
        return dispatchRemoteSessionTask(40002, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipForward(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> skipToNextItem() {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipToNextItem(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> skipToPlaylistItem(final int i) {
        return dispatchRemoteSessionTask(10007, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipToPlaylistItem(MediaControllerImplBase.this.mControllerStub, i, i);
            }
        });
    }

    public ListenableFuture<SessionResult> skipToPreviousItem() {
        return dispatchRemoteSessionTask(10008, (RemoteSessionTask) new RemoteSessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.skipToPreviousItem(MediaControllerImplBase.this.mControllerStub, i);
            }
        });
    }

    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchRemoteSessionTask((int) SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, (RemoteSessionTask) new RemoteSessionTask() {
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
                IMediaSession iMediaSession = this.mISession;
                return iMediaSession;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
