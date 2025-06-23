package androidx.media2.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
public final class SessionToken implements VersionedParcelable {
    private static final int MSG_SEND_TOKEN2_FOR_LEGACY_SESSION = 1000;
    private static final String TAG = "SessionToken";
    static final int TYPE_BROWSER_SERVICE_LEGACY = 101;
    public static final int TYPE_LIBRARY_SERVICE = 2;
    public static final int TYPE_SESSION = 0;
    static final int TYPE_SESSION_LEGACY = 100;
    public static final int TYPE_SESSION_SERVICE = 1;
    private static final long WAIT_TIME_MS_FOR_SESSION_READY = 300;
    SessionTokenImpl mImpl;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public interface OnSessionTokenCreatedListener {
        void onSessionTokenCreated(MediaSessionCompat.Token token, SessionToken sessionToken);
    }

    /* loaded from: classes.dex */
    public interface SessionTokenImpl extends VersionedParcelable {
        Object getBinder();

        @Nullable
        ComponentName getComponentName();

        @Nullable
        Bundle getExtras();

        @NonNull
        String getPackageName();

        @Nullable
        String getServiceName();

        int getType();

        int getUid();

        boolean isLegacySession();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface TokenType {
    }

    public SessionToken(@NonNull Context context, @NonNull ComponentName componentName) {
        int i;
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        }
        if (componentName != null) {
            PackageManager packageManager = context.getPackageManager();
            int uid = getUid(packageManager, componentName.getPackageName());
            if (isInterfaceDeclared(packageManager, MediaLibraryService.SERVICE_INTERFACE, componentName)) {
                i = 2;
            } else if (isInterfaceDeclared(packageManager, MediaSessionService.SERVICE_INTERFACE, componentName)) {
                i = 1;
            } else {
                if (!isInterfaceDeclared(packageManager, MediaBrowserServiceCompat.SERVICE_INTERFACE, componentName)) {
                    throw new IllegalArgumentException(componentName + " doesn't implement none of MediaSessionService, MediaLibraryService, MediaBrowserService nor MediaBrowserServiceCompat. Use service's full name");
                }
                i = 101;
            }
            if (i != 101) {
                this.mImpl = new SessionTokenImplBase(componentName, uid, i);
                return;
            } else {
                this.mImpl = new SessionTokenImplLegacy(componentName, uid);
                return;
            }
        }
        throw new NullPointerException("serviceComponent shouldn't be null");
    }

    private static MediaControllerCompat createMediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        return new MediaControllerCompat(context, token);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void createSessionToken(@NonNull Context context, @NonNull final MediaSessionCompat.Token token, @NonNull final OnSessionTokenCreatedListener onSessionTokenCreatedListener) {
        if (context != null) {
            if (token != null) {
                if (onSessionTokenCreatedListener != null) {
                    VersionedParcelable session2Token = token.getSession2Token();
                    if (session2Token instanceof SessionToken) {
                        onSessionTokenCreatedListener.onSessionTokenCreated(token, (SessionToken) session2Token);
                        return;
                    }
                    final MediaControllerCompat createMediaControllerCompat = createMediaControllerCompat(context, token);
                    final String packageName = createMediaControllerCompat.getPackageName();
                    final int uid = getUid(context.getPackageManager(), packageName);
                    final HandlerThread handlerThread = new HandlerThread(TAG);
                    handlerThread.start();
                    final Handler handler = new Handler(handlerThread.getLooper()) { // from class: androidx.media2.session.SessionToken.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            synchronized (onSessionTokenCreatedListener) {
                                try {
                                    if (message.what != 1000) {
                                        return;
                                    }
                                    createMediaControllerCompat.unregisterCallback((MediaControllerCompat.Callback) message.obj);
                                    SessionToken sessionToken = new SessionToken(new SessionTokenImplLegacy(token, packageName, uid, createMediaControllerCompat.getSessionInfo()));
                                    token.setSession2Token(sessionToken);
                                    onSessionTokenCreatedListener.onSessionTokenCreated(token, sessionToken);
                                    SessionToken.quitHandlerThread(handlerThread);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    MediaControllerCompat.Callback callback = new MediaControllerCompat.Callback() { // from class: androidx.media2.session.SessionToken.2
                        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
                        public void onSessionReady() {
                            SessionToken sessionToken;
                            synchronized (OnSessionTokenCreatedListener.this) {
                                try {
                                    handler.removeMessages(1000);
                                    createMediaControllerCompat.unregisterCallback(this);
                                    if (token.getSession2Token() instanceof SessionToken) {
                                        sessionToken = (SessionToken) token.getSession2Token();
                                    } else {
                                        sessionToken = new SessionToken(new SessionTokenImplLegacy(token, packageName, uid, createMediaControllerCompat.getSessionInfo()));
                                        token.setSession2Token(sessionToken);
                                    }
                                    OnSessionTokenCreatedListener.this.onSessionTokenCreated(token, sessionToken);
                                    SessionToken.quitHandlerThread(handlerThread);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    synchronized (onSessionTokenCreatedListener) {
                        createMediaControllerCompat.registerCallback(callback, handler);
                        handler.sendMessageDelayed(handler.obtainMessage(1000, callback), 300L);
                    }
                    return;
                }
                throw new NullPointerException("listener shouldn't be null");
            }
            throw new NullPointerException("compatToken shouldn't be null");
        }
        throw new NullPointerException("context shouldn't be null");
    }

    private static boolean isInterfaceDeclared(PackageManager packageManager, String str, ComponentName componentName) {
        ServiceInfo serviceInfo;
        Intent intent = new Intent(str);
        intent.setPackage(componentName.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices != null) {
            for (int i = 0; i < queryIntentServices.size(); i++) {
                ResolveInfo resolveInfo = queryIntentServices.get(i);
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void quitHandlerThread(HandlerThread handlerThread) {
        handlerThread.quitSafely();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionToken)) {
            return false;
        }
        return this.mImpl.equals(((SessionToken) obj).mImpl);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Object getBinder() {
        return this.mImpl.getBinder();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ComponentName getComponentName() {
        return this.mImpl.getComponentName();
    }

    @NonNull
    public Bundle getExtras() {
        Bundle extras = this.mImpl.getExtras();
        if (extras != null && !MediaUtils.doesBundleHaveCustomParcelable(extras)) {
            return new Bundle(extras);
        }
        return Bundle.EMPTY;
    }

    @NonNull
    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    @Nullable
    public String getServiceName() {
        return this.mImpl.getServiceName();
    }

    public int getType() {
        return this.mImpl.getType();
    }

    public int getUid() {
        return this.mImpl.getUid();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isLegacySession() {
        return this.mImpl.isLegacySession();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    private static int getUid(PackageManager packageManager, String str) {
        try {
            return packageManager.getApplicationInfo(str, 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalArgumentException("Cannot find package " + str);
        }
    }

    public SessionToken(SessionTokenImpl sessionTokenImpl) {
        this.mImpl = sessionTokenImpl;
    }

    public SessionToken() {
    }
}
