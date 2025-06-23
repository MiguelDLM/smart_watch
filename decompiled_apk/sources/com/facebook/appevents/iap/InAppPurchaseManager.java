package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.StringsKt__StringsKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InAppPurchaseManager {

    @OOXIXo
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";

    @OOXIXo
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();

    @OOXIXo
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private InAppPurchaseManager() {
    }

    @x0XOIxOo
    public static final void enableAutoLogging() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            enabled.set(true);
            startTracking();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    @x0XOIxOo
    public static final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                if (INSTANCE.usingBillingLib2Plus()) {
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                        InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseAutoLogger.INSTANCE;
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext());
                        return;
                    }
                }
                InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                InAppPurchaseActivityLifecycleTracker.startIapLogging();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    private final boolean usingBillingLib2Plus() {
        String string;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo == null || (string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION)) == null) {
                return false;
            }
            if (Integer.parseInt((String) StringsKt__StringsKt.XXoO0oX(string, new String[]{FileUtils.FILE_EXTENSION_SEPARATOR}, false, 3, 2, null).get(0)) < 2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
        return false;
    }
}
