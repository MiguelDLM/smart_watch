package androidx.media2.session;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.ParcelImpl;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MediaSessionServiceImplBase implements MediaSessionService.MediaSessionServiceImpl {
    private static final boolean DEBUG = true;
    private static final String TAG = "MSS2ImplBase";
    @GuardedBy("mLock")
    MediaSessionService mInstance;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private MediaNotificationHandler mNotificationHandler;
    @GuardedBy("mLock")
    private Map<String, MediaSession> mSessions = new ArrayMap();
    @GuardedBy("mLock")
    MediaSessionServiceStub mStub;

    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub implements Closeable {
        final Handler mHandler;
        final MediaSessionManager mMediaSessionManager;
        final WeakReference<MediaSessionServiceImplBase> mServiceImpl;

        public MediaSessionServiceStub(MediaSessionServiceImplBase mediaSessionServiceImplBase) {
            this.mServiceImpl = new WeakReference<>(mediaSessionServiceImplBase);
            this.mHandler = new Handler(mediaSessionServiceImplBase.getInstance().getMainLooper());
            this.mMediaSessionManager = MediaSessionManager.getSessionManager(mediaSessionServiceImplBase.getInstance());
        }

        public void close() {
            this.mServiceImpl.clear();
            this.mHandler.removeCallbacksAndMessages((Object) null);
        }

        public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) {
            final String str;
            final Bundle bundle;
            if (this.mServiceImpl.get() == null) {
                Log.d(MediaSessionServiceImplBase.TAG, "ServiceImpl isn't available");
                return;
            }
            int callingPid = Binder.getCallingPid();
            final int callingUid = Binder.getCallingUid();
            long clearCallingIdentity = Binder.clearCallingIdentity();
            final ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
            if (callingPid == 0) {
                callingPid = connectionRequest.getPid();
            }
            final int i = callingPid;
            if (parcelImpl == null) {
                str = null;
            } else {
                str = connectionRequest.getPackageName();
            }
            if (parcelImpl == null) {
                bundle = null;
            } else {
                bundle = connectionRequest.getConnectionHints();
            }
            try {
                final IMediaController iMediaController2 = iMediaController;
                this.mHandler.post(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c0  */
                    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cb  */
                    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r20 = this;
                            r1 = r20
                            java.lang.String r2 = "Notifying the controller of its disconnection"
                            java.lang.String r3 = "MSS2ImplBase"
                            r4 = 0
                            r5 = 1
                            androidx.media2.session.MediaSessionServiceImplBase$MediaSessionServiceStub r0 = androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.this     // Catch:{ all -> 0x0022 }
                            java.lang.ref.WeakReference<androidx.media2.session.MediaSessionServiceImplBase> r0 = r0.mServiceImpl     // Catch:{ all -> 0x0022 }
                            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0022 }
                            androidx.media2.session.MediaSessionServiceImplBase r0 = (androidx.media2.session.MediaSessionServiceImplBase) r0     // Catch:{ all -> 0x0022 }
                            if (r0 != 0) goto L_0x0025
                            java.lang.String r0 = "ServiceImpl isn't available"
                            android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0022 }
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r8     // Catch:{ RemoteException -> 0x0021 }
                            r0.onDisconnected(r4)     // Catch:{ RemoteException -> 0x0021 }
                        L_0x0021:
                            return
                        L_0x0022:
                            r0 = move-exception
                            goto L_0x00c9
                        L_0x0025:
                            androidx.media2.session.MediaSessionService r0 = r0.getInstance()     // Catch:{ all -> 0x0022 }
                            if (r0 != 0) goto L_0x0039
                            java.lang.String r0 = "Service isn't available"
                            android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0022 }
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r8     // Catch:{ RemoteException -> 0x0038 }
                            r0.onDisconnected(r4)     // Catch:{ RemoteException -> 0x0038 }
                        L_0x0038:
                            return
                        L_0x0039:
                            androidx.media.MediaSessionManager$RemoteUserInfo r7 = new androidx.media.MediaSessionManager$RemoteUserInfo     // Catch:{ all -> 0x0022 }
                            java.lang.String r6 = r3     // Catch:{ all -> 0x0022 }
                            int r8 = r4     // Catch:{ all -> 0x0022 }
                            int r9 = r5     // Catch:{ all -> 0x0022 }
                            r7.<init>(r6, r8, r9)     // Catch:{ all -> 0x0022 }
                            androidx.media2.session.MediaSessionServiceImplBase$MediaSessionServiceStub r6 = androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.this     // Catch:{ all -> 0x0022 }
                            androidx.media.MediaSessionManager r6 = r6.mMediaSessionManager     // Catch:{ all -> 0x0022 }
                            boolean r9 = r6.isTrustedForMediaControl(r7)     // Catch:{ all -> 0x0022 }
                            androidx.media2.session.MediaSession$ControllerInfo r12 = new androidx.media2.session.MediaSession$ControllerInfo     // Catch:{ all -> 0x0022 }
                            androidx.media2.session.ConnectionRequest r6 = r6     // Catch:{ all -> 0x0022 }
                            int r8 = r6.getVersion()     // Catch:{ all -> 0x0022 }
                            android.os.Bundle r11 = r7     // Catch:{ all -> 0x0022 }
                            r10 = 0
                            r6 = r12
                            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0022 }
                            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
                            r6.<init>()     // Catch:{ all -> 0x0022 }
                            java.lang.String r7 = "Handling incoming connection request from the controller="
                            r6.append(r7)     // Catch:{ all -> 0x0022 }
                            r6.append(r12)     // Catch:{ all -> 0x0022 }
                            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0022 }
                            android.util.Log.d(r3, r6)     // Catch:{ all -> 0x0022 }
                            androidx.media2.session.MediaSession r13 = r0.onGetSession(r12)     // Catch:{ Exception -> 0x0092 }
                            if (r13 != 0) goto L_0x0094
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0092 }
                            r0.<init>()     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r6 = "Rejecting incoming connection request from the controller="
                            r0.append(r6)     // Catch:{ Exception -> 0x0092 }
                            r0.append(r12)     // Catch:{ Exception -> 0x0092 }
                            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0092 }
                            android.util.Log.w(r3, r0)     // Catch:{ Exception -> 0x0092 }
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r8     // Catch:{ RemoteException -> 0x0091 }
                            r0.onDisconnected(r4)     // Catch:{ RemoteException -> 0x0091 }
                        L_0x0091:
                            return
                        L_0x0092:
                            r0 = move-exception
                            goto L_0x00b9
                        L_0x0094:
                            r0.addSession(r13)     // Catch:{ Exception -> 0x0092 }
                            androidx.media2.session.IMediaController r14 = r8     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            androidx.media2.session.ConnectionRequest r0 = r6     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            int r15 = r0.getVersion()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            java.lang.String r0 = r3     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            int r5 = r4     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            int r6 = r5     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            android.os.Bundle r7 = r7     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            r16 = r0
                            r17 = r5
                            r18 = r6
                            r19 = r7
                            r13.handleControllerConnectionFromService(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                            r5 = 0
                            goto L_0x00be
                        L_0x00b4:
                            r0 = move-exception
                            r5 = 0
                            goto L_0x00c9
                        L_0x00b7:
                            r0 = move-exception
                            r5 = 0
                        L_0x00b9:
                            java.lang.String r6 = "Failed to add a session to session service"
                            android.util.Log.w(r3, r6, r0)     // Catch:{ all -> 0x0022 }
                        L_0x00be:
                            if (r5 == 0) goto L_0x00c8
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r8     // Catch:{ RemoteException -> 0x00c8 }
                            r0.onDisconnected(r4)     // Catch:{ RemoteException -> 0x00c8 }
                        L_0x00c8:
                            return
                        L_0x00c9:
                            if (r5 == 0) goto L_0x00d3
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r2 = r8     // Catch:{ RemoteException -> 0x00d3 }
                            r2.onDisconnected(r4)     // Catch:{ RemoteException -> 0x00d3 }
                        L_0x00d3:
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.AnonymousClass1.run():void");
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            try {
                mediaSession2 = this.mSessions.get(mediaSession.getId());
                if (mediaSession2 != null) {
                    if (mediaSession2 != mediaSession) {
                        throw new IllegalArgumentException("Session ID should be unique");
                    }
                }
                this.mSessions.put(mediaSession.getId(), mediaSession);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (mediaSession2 == null) {
            synchronized (this.mLock) {
                mediaNotificationHandler = this.mNotificationHandler;
            }
            mediaNotificationHandler.onPlayerStateChanged(mediaSession, mediaSession.getPlayer().getPlayerState());
            mediaSession.getCallback().setForegroundServiceEventCallback(mediaNotificationHandler);
        }
    }

    public MediaSessionService getInstance() {
        MediaSessionService mediaSessionService;
        synchronized (this.mLock) {
            mediaSessionService = this.mInstance;
        }
        return mediaSessionService;
    }

    public IBinder getServiceBinder() {
        IBinder iBinder;
        synchronized (this.mLock) {
            try {
                MediaSessionServiceStub mediaSessionServiceStub = this.mStub;
                if (mediaSessionServiceStub != null) {
                    iBinder = mediaSessionServiceStub.asBinder();
                } else {
                    iBinder = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iBinder;
    }

    public List<MediaSession> getSessions() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mSessions.values());
        }
        return arrayList;
    }

    public IBinder onBind(Intent intent) {
        MediaSessionService instance = getInstance();
        if (instance == null) {
            Log.w(TAG, "Service hasn't created before onBind()");
            return null;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(MediaSessionService.SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE)) {
            return null;
        }
        MediaSession onGetSession = instance.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
        if (onGetSession == null) {
            Log.d(TAG, "Rejecting incoming connection request from legacy media browsers.");
            return null;
        }
        addSession(onGetSession);
        return onGetSession.getLegacyBrowerServiceBinder();
    }

    public void onCreate(MediaSessionService mediaSessionService) {
        synchronized (this.mLock) {
            this.mInstance = mediaSessionService;
            this.mStub = new MediaSessionServiceStub(this);
            this.mNotificationHandler = new MediaNotificationHandler(mediaSessionService);
        }
    }

    public void onDestroy() {
        synchronized (this.mLock) {
            try {
                this.mInstance = null;
                MediaSessionServiceStub mediaSessionServiceStub = this.mStub;
                if (mediaSessionServiceStub != null) {
                    mediaSessionServiceStub.close();
                    this.mStub = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!(intent == null || intent.getAction() == null)) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                MediaSessionService instance = getInstance();
                if (instance == null) {
                    Log.wtf(TAG, "Service hasn't created");
                }
                MediaSession session = MediaSession.getSession(intent.getData());
                if (session == null) {
                    session = instance.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                }
                if (session == null) {
                    Log.d(TAG, "Rejecting wake-up of the service from media key events.");
                } else {
                    KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    if (keyEvent != null) {
                        session.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
                    }
                }
            }
        }
        return 1;
    }

    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            mediaNotificationHandler = this.mNotificationHandler;
        }
        if (mediaNotificationHandler != null) {
            return mediaNotificationHandler.onUpdateNotification(mediaSession);
        }
        throw new IllegalStateException("Service hasn't created");
    }

    public void removeSession(MediaSession mediaSession) {
        synchronized (this.mLock) {
            this.mSessions.remove(mediaSession.getId());
        }
    }
}
