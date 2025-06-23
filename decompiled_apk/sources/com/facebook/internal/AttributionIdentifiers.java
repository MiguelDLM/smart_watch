package com.facebook.internal;

import X0IOOI.oIX0oI;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AttributionIdentifiers {

    @OXOo.OOXIXo
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";

    @OXOo.OOXIXo
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";

    @OXOo.OOXIXo
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";

    @OXOo.OOXIXo
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;

    @OXOo.OOXIXo
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";

    @XO0OX.XO
    @OXOo.oOoXoXO
    public static AttributionIdentifiers cachedIdentifiers;

    @OXOo.oOoXoXO
    private String androidAdvertiserIdValue;

    @OXOo.oOoXoXO
    private String androidInstallerPackage;

    @OXOo.oOoXoXO
    private String attributionId;
    private long fetchTime;
    private boolean isTrackingLimited;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
            return attributionIdentifiers;
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations() {
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
            if (androidIdViaReflection == null) {
                AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
                if (androidIdViaService == null) {
                    return new AttributionIdentifiers();
                }
                return androidIdViaService;
            }
            return androidIdViaReflection;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            Object invokeMethodQuietly;
            boolean z = false;
            try {
                if (!isGooglePlayServicesAvailable(context)) {
                    return null;
                }
                Utility utility = Utility.INSTANCE;
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null || (invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                    return null;
                }
                Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly2 != null && methodQuietly3 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                    Boolean bool = (Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                    attributionIdentifiers.isTrackingLimited = z;
                    return attributionIdentifiers;
                }
                return null;
            } catch (Exception e) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd("android_id", e);
                return null;
            }
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, googleAdServiceConnection, 1)) {
                    try {
                        GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                        attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                        return attributionIdentifiers;
                    } catch (Exception e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd("android_id", e);
                    } finally {
                        context.unbindService(googleAdServiceConnection);
                    }
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getCachedIdentifiers$facebook_core_release$annotations() {
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getInstallerPackageName(context.getPackageName());
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Utility utility = Utility.INSTANCE;
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if ((invokeMethodQuietly instanceof Integer) && IIX0o.Oxx0IOOO(invokeMethodQuietly, 0)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #4 {Exception -> 0x0036, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x003a, B:13:0x0055, B:15:0x0064, B:17:0x0086, B:19:0x008c, B:21:0x0091, B:23:0x0096, B:57:0x006e, B:59:0x007e, B:61:0x00f6, B:62:0x00fd), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0091 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #4 {Exception -> 0x0036, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x003a, B:13:0x0055, B:15:0x0064, B:17:0x0086, B:19:0x008c, B:21:0x0091, B:23:0x0096, B:57:0x006e, B:59:0x007e, B:61:0x00f6, B:62:0x00fd), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_LEAVE, TryCatch #4 {Exception -> 0x0036, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x003a, B:13:0x0055, B:15:0x0064, B:17:0x0086, B:19:0x008c, B:21:0x0091, B:23:0x0096, B:57:0x006e, B:59:0x007e, B:61:0x00f6, B:62:0x00fd), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(@OXOo.OOXIXo android.content.Context r13) {
            /*
                Method dump skipped, instructions count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        @XO0OX.x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isTrackingLimited(@OXOo.OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            if (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited()) {
                return true;
            }
            return false;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class GoogleAdInfo implements IInterface {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;

        @OXOo.OOXIXo
        private final IBinder binder;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public GoogleAdInfo(@OXOo.OOXIXo IBinder binder) {
            IIX0o.x0xO0oo(binder, "binder");
            this.binder = binder;
        }

        @Override // android.os.IInterface
        @OXOo.OOXIXo
        public IBinder asBinder() {
            return this.binder;
        }

        @OXOo.oOoXoXO
        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            IIX0o.oO(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            IIX0o.oO(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken(oIX0oI.II0xO0.f3239XO);
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            IIX0o.oO(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            IIX0o.oO(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken(oIX0oI.II0xO0.f3239XO);
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class GoogleAdServiceConnection implements ServiceConnection {

        @OXOo.OOXIXo
        private final AtomicBoolean consumed = new AtomicBoolean(false);

        @OXOo.OOXIXo
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        @OXOo.OOXIXo
        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                IBinder take = this.queue.take();
                IIX0o.oO(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@OXOo.oOoXoXO ComponentName componentName, @OXOo.oOoXoXO IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@OXOo.oOoXoXO ComponentName componentName) {
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AttributionIdentifiers getAttributionIdentifiers(@OXOo.OOXIXo Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isTrackingLimited(@OXOo.OOXIXo Context context) {
        return Companion.isTrackingLimited(context);
    }

    @OXOo.oOoXoXO
    public final String getAndroidAdvertiserId() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isInitialized() && FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return this.androidAdvertiserIdValue;
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    @OXOo.oOoXoXO
    public final String getAttributionId() {
        return this.attributionId;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }
}
