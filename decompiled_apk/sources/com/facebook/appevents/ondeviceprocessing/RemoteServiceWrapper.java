package com.facebook.appevents.ondeviceprocessing;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class RemoteServiceWrapper {

    @OOXIXo
    public static final RemoteServiceWrapper INSTANCE = new RemoteServiceWrapper();

    @OOXIXo
    public static final String RECEIVER_SERVICE_ACTION = "ReceiverService";

    @OOXIXo
    public static final String RECEIVER_SERVICE_PACKAGE = "com.facebook.katana";

    @OOXIXo
    public static final String RECEIVER_SERVICE_PACKAGE_WAKIZASHI = "com.facebook.wakizashi";

    @OOXIXo
    private static final String TAG;

    @oOoXoXO
    private static Boolean isServiceAvailable;

    /* loaded from: classes8.dex */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");


        @OOXIXo
        private final String eventType;

        EventType(String str) {
            this.eventType = str;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EventType[] valuesCustom() {
            EventType[] valuesCustom = values();
            return (EventType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @Override // java.lang.Enum
        @OOXIXo
        public String toString() {
            return this.eventType;
        }
    }

    /* loaded from: classes8.dex */
    public static final class RemoteServiceConnection implements ServiceConnection {

        @oOoXoXO
        private IBinder binder;

        @OOXIXo
        private final CountDownLatch latch = new CountDownLatch(1);

        @oOoXoXO
        public final IBinder getBinder() throws InterruptedException {
            this.latch.await(5L, TimeUnit.SECONDS);
            return this.binder;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@OOXIXo ComponentName name) {
            IIX0o.x0xO0oo(name, "name");
            this.latch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@OOXIXo ComponentName name, @OOXIXo IBinder serviceBinder) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(serviceBinder, "serviceBinder");
            this.binder = serviceBinder;
            this.latch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@OOXIXo ComponentName name) {
            IIX0o.x0xO0oo(name, "name");
        }
    }

    /* loaded from: classes8.dex */
    public enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ServiceResult[] valuesCustom() {
            ServiceResult[] valuesCustom = values();
            return (ServiceResult[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    static {
        String simpleName = RemoteServiceWrapper.class.getSimpleName();
        IIX0o.oO(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        TAG = simpleName;
    }

    private RemoteServiceWrapper() {
    }

    private final Intent getVerifiedServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent(RECEIVER_SERVICE_ACTION);
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, "com.facebook.katana")) {
                        return intent;
                    }
                }
                Intent intent2 = new Intent(RECEIVER_SERVICE_ACTION);
                intent2.setPackage(RECEIVER_SERVICE_PACKAGE_WAKIZASHI);
                if (packageManager.resolveService(intent2, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator2 = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, RECEIVER_SERVICE_PACKAGE_WAKIZASHI)) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    public static final boolean isServiceAvailable() {
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return false;
        }
        try {
            if (isServiceAvailable == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (INSTANCE.getVerifiedServiceIntent(FacebookSdk.getApplicationContext()) != null) {
                    z = true;
                } else {
                    z = false;
                }
                isServiceAvailable = Boolean.valueOf(z);
            }
            Boolean bool = isServiceAvailable;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return false;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final ServiceResult sendCustomEvents(@OOXIXo String applicationId, @OOXIXo List<AppEvent> appEvents) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(appEvents, "appEvents");
            return INSTANCE.sendEvents(EventType.CUSTOM_APP_EVENTS, applicationId, appEvents);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    private final ServiceResult sendEvents(EventType eventType, String str, List<AppEvent> list) {
        ServiceResult serviceResult;
        String str2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ServiceResult serviceResult2 = ServiceResult.SERVICE_NOT_AVAILABLE;
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            AppEventUtility.assertIsNotMainThread();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intent verifiedServiceIntent = getVerifiedServiceIntent(applicationContext);
            if (verifiedServiceIntent != null) {
                RemoteServiceConnection remoteServiceConnection = new RemoteServiceConnection();
                try {
                    if (applicationContext.bindService(verifiedServiceIntent, remoteServiceConnection, 1)) {
                        try {
                            IBinder binder = remoteServiceConnection.getBinder();
                            if (binder != null) {
                                IReceiverService asInterface = IReceiverService.Stub.asInterface(binder);
                                RemoteServiceParametersHelper remoteServiceParametersHelper = RemoteServiceParametersHelper.INSTANCE;
                                Bundle buildEventsBundle = RemoteServiceParametersHelper.buildEventsBundle(eventType, str, list);
                                if (buildEventsBundle != null) {
                                    asInterface.sendEvents(buildEventsBundle);
                                    Utility utility = Utility.INSTANCE;
                                    Utility.logd(TAG, IIX0o.XIxXXX0x0("Successfully sent events to the remote service: ", buildEventsBundle));
                                }
                                serviceResult2 = ServiceResult.OPERATION_SUCCESS;
                            }
                            applicationContext.unbindService(remoteServiceConnection);
                            Utility utility2 = Utility.INSTANCE;
                            Utility.logd(TAG, "Unbound from the remote service");
                            return serviceResult2;
                        } catch (RemoteException e) {
                            serviceResult = ServiceResult.SERVICE_ERROR;
                            Utility utility3 = Utility.INSTANCE;
                            str2 = TAG;
                            Utility.logd(str2, e);
                            applicationContext.unbindService(remoteServiceConnection);
                            Utility.logd(str2, "Unbound from the remote service");
                            return serviceResult;
                        } catch (InterruptedException e2) {
                            serviceResult = ServiceResult.SERVICE_ERROR;
                            Utility utility4 = Utility.INSTANCE;
                            str2 = TAG;
                            Utility.logd(str2, e2);
                            applicationContext.unbindService(remoteServiceConnection);
                            Utility.logd(str2, "Unbound from the remote service");
                            return serviceResult;
                        }
                    }
                    return ServiceResult.SERVICE_ERROR;
                } catch (Throwable th) {
                    applicationContext.unbindService(remoteServiceConnection);
                    Utility utility5 = Utility.INSTANCE;
                    Utility.logd(TAG, "Unbound from the remote service");
                    throw th;
                }
            }
            return serviceResult2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final ServiceResult sendInstallEvent(@OOXIXo String applicationId) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(applicationId, "applicationId");
            return INSTANCE.sendEvents(EventType.MOBILE_APP_INSTALL, applicationId, CollectionsKt__CollectionsKt.ooXIXxIX());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }
}
