package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.sma.smartv3.network.GetGooglePayCheckOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class InAppPurchaseActivityLifecycleTracker {

    @OOXIXo
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";

    @OOXIXo
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static Application.ActivityLifecycleCallbacks callbacks;

    @oOoXoXO
    private static Boolean hasBillingActivity;

    @oOoXoXO
    private static Boolean hasBillingService;

    @oOoXoXO
    private static Object inAppBillingObj;
    private static Intent intent;
    private static ServiceConnection serviceConnection;

    @OOXIXo
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = new InAppPurchaseActivityLifecycleTracker();

    @oOoXoXO
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();

    @OOXIXo
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);

    private InAppPurchaseActivityLifecycleTracker() {
    }

    private final void initializeIfNotInitialized() {
        boolean z;
        if (hasBillingService != null) {
            return;
        }
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        boolean z2 = false;
        if (InAppPurchaseUtils.getClass(SERVICE_INTERFACE_NAME) != null) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        hasBillingService = valueOf;
        if (IIX0o.Oxx0IOOO(valueOf, Boolean.FALSE)) {
            return;
        }
        if (InAppPurchaseUtils.getClass(BILLING_ACTIVITY_NAME) != null) {
            z2 = true;
        }
        hasBillingActivity = Boolean.valueOf(z2);
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        InAppPurchaseEventManager.clearSkuDetailsCache();
        Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
        IIX0o.oO(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
        intent = intent2;
        serviceConnection = new ServiceConnection() { // from class: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(@OOXIXo ComponentName name, @OOXIXo IBinder service) {
                IIX0o.x0xO0oo(name, "name");
                IIX0o.x0xO0oo(service, "service");
                InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), service);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(@OOXIXo ComponentName name) {
                IIX0o.x0xO0oo(name, "name");
            }
        };
        callbacks = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPurchase(Context context, ArrayList<String> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String purchase = it.next();
            try {
                String sku = new JSONObject(purchase).getString(GetGooglePayCheckOrder.PRODUCT_IT);
                IIX0o.oO(sku, "sku");
                IIX0o.oO(purchase, "purchase");
                hashMap.put(sku, purchase);
                arrayList2.add(sku);
            } catch (JSONException e) {
                Log.e(TAG, "Error parsing in-app purchase data.", e);
            }
        }
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        for (Map.Entry<String, String> entry : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, z).entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String str = (String) hashMap.get(key);
            if (str != null) {
                AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                AutomaticAnalyticsLogger.logPurchase(str, value, z);
            }
        }
    }

    @x0XOIxOo
    public static final void startIapLogging() {
        InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = INSTANCE;
        inAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized();
        if (IIX0o.Oxx0IOOO(hasBillingService, Boolean.FALSE)) {
            return;
        }
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            inAppPurchaseActivityLifecycleTracker.startTracking();
        }
    }

    private final void startTracking() {
        if (!isTracking.compareAndSet(false, true)) {
            return;
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = callbacks;
            if (activityLifecycleCallbacks != null) {
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                Intent intent2 = intent;
                if (intent2 != null) {
                    ServiceConnection serviceConnection2 = serviceConnection;
                    if (serviceConnection2 != null) {
                        applicationContext.bindService(intent2, serviceConnection2, 1);
                        return;
                    } else {
                        IIX0o.XOxIOxOx("serviceConnection");
                        throw null;
                    }
                }
                IIX0o.XOxIOxOx(SDKConstants.PARAM_INTENT);
                throw null;
            }
            IIX0o.XOxIOxOx("callbacks");
            throw null;
        }
    }
}
