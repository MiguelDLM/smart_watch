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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaSessionServiceImplBase implements MediaSessionService.MediaSessionServiceImpl {
    private static final boolean DEBUG = true;
    private static final String TAG = "MSS2ImplBase";

    @GuardedBy("mLock")
    MediaSessionService mInstance;

    @GuardedBy("mLock")
    private MediaNotificationHandler mNotificationHandler;

    @GuardedBy("mLock")
    MediaSessionServiceStub mStub;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private Map<String, MediaSession> mSessions = new ArrayMap();

    /* loaded from: classes.dex */
    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub implements Closeable {
        final Handler mHandler;
        final androidx.media.MediaSessionManager mMediaSessionManager;
        final WeakReference<MediaSessionServiceImplBase> mServiceImpl;

        public MediaSessionServiceStub(MediaSessionServiceImplBase mediaSessionServiceImplBase) {
            this.mServiceImpl = new WeakReference<>(mediaSessionServiceImplBase);
            this.mHandler = new Handler(mediaSessionServiceImplBase.getInstance().getMainLooper());
            this.mMediaSessionManager = androidx.media.MediaSessionManager.getSessionManager(mediaSessionServiceImplBase.getInstance());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mServiceImpl.clear();
            this.mHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media2.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, ParcelImpl parcelImpl) {
            final String packageName;
            final Bundle connectionHints;
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
                packageName = null;
            } else {
                packageName = connectionRequest.getPackageName();
            }
            if (parcelImpl == null) {
                connectionHints = null;
            } else {
                connectionHints = connectionRequest.getConnectionHints();
            }
            try {
                this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.1
                    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0  */
                    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            r20 = this;
                            r1 = r20
                            java.lang.String r2 = "Notifying the controller of its disconnection"
                            java.lang.String r3 = "MSS2ImplBase"
                            r4 = 0
                            r5 = 1
                            androidx.media2.session.MediaSessionServiceImplBase$MediaSessionServiceStub r0 = androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.this     // Catch: java.lang.Throwable -> L22
                            java.lang.ref.WeakReference<androidx.media2.session.MediaSessionServiceImplBase> r0 = r0.mServiceImpl     // Catch: java.lang.Throwable -> L22
                            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L22
                            androidx.media2.session.MediaSessionServiceImplBase r0 = (androidx.media2.session.MediaSessionServiceImplBase) r0     // Catch: java.lang.Throwable -> L22
                            if (r0 != 0) goto L25
                            java.lang.String r0 = "ServiceImpl isn't available"
                            android.util.Log.d(r3, r0)     // Catch: java.lang.Throwable -> L22
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r7     // Catch: android.os.RemoteException -> L21
                            r0.onDisconnected(r4)     // Catch: android.os.RemoteException -> L21
                        L21:
                            return
                        L22:
                            r0 = move-exception
                            goto Lc9
                        L25:
                            androidx.media2.session.MediaSessionService r0 = r0.getInstance()     // Catch: java.lang.Throwable -> L22
                            if (r0 != 0) goto L39
                            java.lang.String r0 = "Service isn't available"
                            android.util.Log.d(r3, r0)     // Catch: java.lang.Throwable -> L22
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r7     // Catch: android.os.RemoteException -> L38
                            r0.onDisconnected(r4)     // Catch: android.os.RemoteException -> L38
                        L38:
                            return
                        L39:
                            androidx.media.MediaSessionManager$RemoteUserInfo r7 = new androidx.media.MediaSessionManager$RemoteUserInfo     // Catch: java.lang.Throwable -> L22
                            java.lang.String r6 = r2     // Catch: java.lang.Throwable -> L22
                            int r8 = r3     // Catch: java.lang.Throwable -> L22
                            int r9 = r4     // Catch: java.lang.Throwable -> L22
                            r7.<init>(r6, r8, r9)     // Catch: java.lang.Throwable -> L22
                            androidx.media2.session.MediaSessionServiceImplBase$MediaSessionServiceStub r6 = androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.this     // Catch: java.lang.Throwable -> L22
                            androidx.media.MediaSessionManager r6 = r6.mMediaSessionManager     // Catch: java.lang.Throwable -> L22
                            boolean r9 = r6.isTrustedForMediaControl(r7)     // Catch: java.lang.Throwable -> L22
                            androidx.media2.session.MediaSession$ControllerInfo r12 = new androidx.media2.session.MediaSession$ControllerInfo     // Catch: java.lang.Throwable -> L22
                            androidx.media2.session.ConnectionRequest r6 = r5     // Catch: java.lang.Throwable -> L22
                            int r8 = r6.getVersion()     // Catch: java.lang.Throwable -> L22
                            android.os.Bundle r11 = r6     // Catch: java.lang.Throwable -> L22
                            r10 = 0
                            r6 = r12
                            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L22
                            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22
                            r6.<init>()     // Catch: java.lang.Throwable -> L22
                            java.lang.String r7 = "Handling incoming connection request from the controller="
                            r6.append(r7)     // Catch: java.lang.Throwable -> L22
                            r6.append(r12)     // Catch: java.lang.Throwable -> L22
                            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L22
                            android.util.Log.d(r3, r6)     // Catch: java.lang.Throwable -> L22
                            androidx.media2.session.MediaSession r13 = r0.onGetSession(r12)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            if (r13 != 0) goto L94
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            r0.<init>()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            java.lang.String r6 = "Rejecting incoming connection request from the controller="
                            r0.append(r6)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            r0.append(r12)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            android.util.Log.w(r3, r0)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r7     // Catch: android.os.RemoteException -> L91
                            r0.onDisconnected(r4)     // Catch: android.os.RemoteException -> L91
                        L91:
                            return
                        L92:
                            r0 = move-exception
                            goto Lb9
                        L94:
                            r0.addSession(r13)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L92
                            androidx.media2.session.IMediaController r14 = r7     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            androidx.media2.session.ConnectionRequest r0 = r5     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            int r15 = r0.getVersion()     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            java.lang.String r0 = r2     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            int r5 = r3     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            int r6 = r4     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            android.os.Bundle r7 = r6     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            r16 = r0
                            r17 = r5
                            r18 = r6
                            r19 = r7
                            r13.handleControllerConnectionFromService(r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb7
                            r5 = 0
                            goto Lbe
                        Lb4:
                            r0 = move-exception
                            r5 = 0
                            goto Lc9
                        Lb7:
                            r0 = move-exception
                            r5 = 0
                        Lb9:
                            java.lang.String r6 = "Failed to add a session to session service"
                            android.util.Log.w(r3, r6, r0)     // Catch: java.lang.Throwable -> L22
                        Lbe:
                            if (r5 == 0) goto Lc8
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r0 = r7     // Catch: android.os.RemoteException -> Lc8
                            r0.onDisconnected(r4)     // Catch: android.os.RemoteException -> Lc8
                        Lc8:
                            return
                        Lc9:
                            if (r5 == 0) goto Ld3
                            android.util.Log.d(r3, r2)
                            androidx.media2.session.IMediaController r2 = r7     // Catch: android.os.RemoteException -> Ld3
                            r2.onDisconnected(r4)     // Catch: android.os.RemoteException -> Ld3
                        Ld3:
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            try {
                mediaSession2 = this.mSessions.get(mediaSession.getId());
                if (mediaSession2 != null && mediaSession2 != mediaSession) {
                    throw new IllegalArgumentException("Session ID should be unique");
                }
                this.mSessions.put(mediaSession.getId(), mediaSession);
            } catch (Throwable th) {
                throw th;
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public List<MediaSession> getSessions() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mSessions.values());
        }
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
        MediaSessionService mediaSessionServiceImplBase = getInstance();
        if (mediaSessionServiceImplBase == null) {
            Log.w(TAG, "Service hasn't created before onBind()");
            return null;
        }
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals(MediaSessionService.SERVICE_INTERFACE)) {
            if (!action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE)) {
                return null;
            }
            MediaSession onGetSession = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
            if (onGetSession == null) {
                Log.d(TAG, "Rejecting incoming connection request from legacy media browsers.");
                return null;
            }
            addSession(onGetSession);
            return onGetSession.getLegacyBrowerServiceBinder();
        }
        return getServiceBinder();
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onCreate(MediaSessionService mediaSessionService) {
        synchronized (this.mLock) {
            this.mInstance = mediaSessionService;
            this.mStub = new MediaSessionServiceStub(this);
            this.mNotificationHandler = new MediaNotificationHandler(mediaSessionService);
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                MediaSessionService mediaSessionServiceImplBase = getInstance();
                if (mediaSessionServiceImplBase == null) {
                    Log.wtf(TAG, "Service hasn't created");
                }
                MediaSession session = MediaSession.getSession(intent.getData());
                if (session == null) {
                    session = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void removeSession(MediaSession mediaSession) {
        synchronized (this.mLock) {
            this.mSessions.remove(mediaSession.getId());
        }
    }
}
