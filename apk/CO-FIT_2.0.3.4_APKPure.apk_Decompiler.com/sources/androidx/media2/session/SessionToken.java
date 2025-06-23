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
    public interface OnSessionTokenCreatedListener {
        void onSessionTokenCreated(MediaSessionCompat.Token token, SessionToken sessionToken);
    }

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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TokenType {
    }

    public SessionToken(@NonNull Context context, @NonNull ComponentName componentName) {
        int i;
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        } else if (componentName != null) {
            PackageManager packageManager = context.getPackageManager();
            int uid = getUid(packageManager, componentName.getPackageName());
            if (isInterfaceDeclared(packageManager, MediaLibraryService.SERVICE_INTERFACE, componentName)) {
                i = 2;
            } else if (isInterfaceDeclared(packageManager, MediaSessionService.SERVICE_INTERFACE, componentName)) {
                i = 1;
            } else if (isInterfaceDeclared(packageManager, MediaBrowserServiceCompat.SERVICE_INTERFACE, componentName)) {
                i = 101;
            } else {
                throw new IllegalArgumentException(componentName + " doesn't implement none of MediaSessionService, MediaLibraryService, MediaBrowserService nor MediaBrowserServiceCompat. Use service's full name");
            }
            if (i != 101) {
                this.mImpl = new SessionTokenImplBase(componentName, uid, i);
            } else {
                this.mImpl = new SessionTokenImplLegacy(componentName, uid);
            }
        } else {
            throw new NullPointerException("serviceComponent shouldn't be null");
        }
    }

    private static MediaControllerCompat createMediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        return new MediaControllerCompat(context, token);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void createSessionToken(@NonNull Context context, @NonNull MediaSessionCompat.Token token, @NonNull OnSessionTokenCreatedListener onSessionTokenCreatedListener) {
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        } else if (token == null) {
            throw new NullPointerException("compatToken shouldn't be null");
        } else if (onSessionTokenCreatedListener != null) {
            VersionedParcelable session2Token = token.getSession2Token();
            if (session2Token instanceof SessionToken) {
                onSessionTokenCreatedListener.onSessionTokenCreated(token, (SessionToken) session2Token);
                return;
            }
            MediaControllerCompat createMediaControllerCompat = createMediaControllerCompat(context, token);
            String packageName = createMediaControllerCompat.getPackageName();
            int uid = getUid(context.getPackageManager(), packageName);
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            final OnSessionTokenCreatedListener onSessionTokenCreatedListener2 = onSessionTokenCreatedListener;
            final MediaControllerCompat mediaControllerCompat = createMediaControllerCompat;
            final MediaSessionCompat.Token token2 = token;
            final String str = packageName;
            final int i = uid;
            final HandlerThread handlerThread2 = handlerThread;
            AnonymousClass1 r1 = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    synchronized (onSessionTokenCreatedListener2) {
                        try {
                            if (message.what == 1000) {
                                mediaControllerCompat.unregisterCallback((MediaControllerCompat.Callback) message.obj);
                                SessionToken sessionToken = new SessionToken(new SessionTokenImplLegacy(token2, str, i, mediaControllerCompat.getSessionInfo()));
                                token2.setSession2Token(sessionToken);
                                onSessionTokenCreatedListener2.onSessionTokenCreated(token2, sessionToken);
                                SessionToken.quitHandlerThread(handlerThread2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            final OnSessionTokenCreatedListener onSessionTokenCreatedListener3 = onSessionTokenCreatedListener;
            final AnonymousClass1 r3 = r1;
            AnonymousClass2 r12 = new MediaControllerCompat.Callback() {
                public void onSessionReady() {
                    SessionToken sessionToken;
                    synchronized (OnSessionTokenCreatedListener.this) {
                        try {
                            r3.removeMessages(1000);
                            mediaControllerCompat.unregisterCallback(this);
                            if (token2.getSession2Token() instanceof SessionToken) {
                                sessionToken = (SessionToken) token2.getSession2Token();
                            } else {
                                sessionToken = new SessionToken(new SessionTokenImplLegacy(token2, str, i, mediaControllerCompat.getSessionInfo()));
                                token2.setSession2Token(sessionToken);
                            }
                            OnSessionTokenCreatedListener.this.onSessionTokenCreated(token2, sessionToken);
                            SessionToken.quitHandlerThread(handlerThread2);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            synchronized (onSessionTokenCreatedListener) {
                createMediaControllerCompat.registerCallback(r12, r1);
                r1.sendMessageDelayed(r1.obtainMessage(1000, r12), 300);
            }
        } else {
            throw new NullPointerException("listener shouldn't be null");
        }
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
        if (extras == null || MediaUtils.doesBundleHaveCustomParcelable(extras)) {
            return Bundle.EMPTY;
        }
        return new Bundle(extras);
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
