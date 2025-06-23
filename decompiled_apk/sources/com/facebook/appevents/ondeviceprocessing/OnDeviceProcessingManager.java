package com.facebook.appevents.ondeviceprocessing;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.collections.Xo0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class OnDeviceProcessingManager {

    @OOXIXo
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();

    @OOXIXo
    private static final Set<String> ALLOWED_IMPLICIT_EVENTS = Xo0.OxxIIOOXO(AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE);

    private OnDeviceProcessingManager() {
    }

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent) {
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (appEvent.isImplicit() && ALLOWED_IMPLICIT_EVENTS.contains(appEvent.getName())) {
                z = true;
            } else {
                z = false;
            }
            if (appEvent.isImplicit() && !z) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @x0XOIxOo
    public static final boolean isOnDeviceProcessingEnabled() {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return false;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext())) {
                return false;
            }
            Utility utility = Utility.INSTANCE;
            if (Utility.isDataProcessingRestricted()) {
                return false;
            }
            RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
            if (!RemoteServiceWrapper.isServiceAvailable()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final void sendCustomEventAsync(@OOXIXo final String applicationId, @OOXIXo final AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(event, "event");
            if (INSTANCE.isEventEligibleForOnDeviceProcessing(event)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.ondeviceprocessing.II0xO0
                    @Override // java.lang.Runnable
                    public final void run() {
                        OnDeviceProcessingManager.m172sendCustomEventAsync$lambda1(applicationId, event);
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendCustomEventAsync$lambda-1, reason: not valid java name */
    public static final void m172sendCustomEventAsync$lambda1(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(applicationId, "$applicationId");
            IIX0o.x0xO0oo(event, "$event");
            RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
            RemoteServiceWrapper.sendCustomEvents(applicationId, oI0IIXIo.OOXIXo(event));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }

    @x0XOIxOo
    public static final void sendInstallEventAsync(@oOoXoXO final String str, @oOoXoXO final String str2) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext != null && str != null && str2 != null) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.ondeviceprocessing.oIX0oI
                    @Override // java.lang.Runnable
                    public final void run() {
                        OnDeviceProcessingManager.m173sendInstallEventAsync$lambda0(applicationContext, str2, str);
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendInstallEventAsync$lambda-0, reason: not valid java name */
    public static final void m173sendInstallEventAsync$lambda0(Context context, String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(context, "$context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            String XIxXXX0x02 = IIX0o.XIxXXX0x0(str2, "pingForOnDevice");
            if (sharedPreferences.getLong(XIxXXX0x02, 0L) == 0) {
                RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
                RemoteServiceWrapper.sendInstallEvent(str2);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(XIxXXX0x02, System.currentTimeMillis());
                edit.apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }
}
