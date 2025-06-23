package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.huawei.openalliance.ad.constant.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import jxl.read.biff.oI0IIXIo;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InAppPurchaseLoggerManager {
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;

    @OOXIXo
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";

    @OOXIXo
    private static final String LAST_QUERY_PURCHASE_HISTORY_TIME = "LAST_QUERY_PURCHASE_HISTORY_TIME";

    @OOXIXo
    private static final String PRODUCT_DETAILS_STORE = "com.facebook.internal.iap.PRODUCT_DETAILS";

    @OOXIXo
    private static final String PURCHASE_DETAILS_SET = "PURCHASE_DETAILS_SET";
    private static final int PURCHASE_IN_CACHE_INTERVAL = 86400;

    @OOXIXo
    private static final String PURCHASE_TIME = "purchaseTime";
    private static SharedPreferences sharedPreferences;

    @OOXIXo
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();

    @OOXIXo
    private static final Set<String> cachedPurchaseSet = new CopyOnWriteArraySet();

    @OOXIXo
    private static final Map<String, Long> cachedPurchaseMap = new ConcurrentHashMap();

    private InAppPurchaseLoggerManager() {
    }

    @x0XOIxOo
    public static final boolean eligibleQueryPurchaseHistory() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return false;
        }
        try {
            INSTANCE.readPurchaseCache();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                long j = sharedPreferences2.getLong(LAST_QUERY_PURCHASE_HISTORY_TIME, 0L);
                if (j != 0 && currentTimeMillis - j < 86400) {
                    return false;
                }
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 != null) {
                    sharedPreferences3.edit().putLong(LAST_QUERY_PURCHASE_HISTORY_TIME, currentTimeMillis).apply();
                    return true;
                }
                IIX0o.XOxIOxOx("sharedPreferences");
                throw null;
            }
            IIX0o.XOxIOxOx("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
            return false;
        }
    }

    @x0XOIxOo
    public static final void filterPurchaseLogging(@OOXIXo Map<String, JSONObject> purchaseDetailsMap, @OOXIXo Map<String, ? extends JSONObject> skuDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(purchaseDetailsMap, "purchaseDetailsMap");
            IIX0o.x0xO0oo(skuDetailsMap, "skuDetailsMap");
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
            inAppPurchaseLoggerManager.readPurchaseCache();
            inAppPurchaseLoggerManager.logPurchases(inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(purchaseDetailsMap), skuDetailsMap));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    private final void logPurchases(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                    AutomaticAnalyticsLogger.logPurchase(key, value, false);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void readPurchaseCache() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
            SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
            if (sharedPreferences2.contains(LAST_CLEARED_TIME)) {
                sharedPreferences2.edit().clear().apply();
                sharedPreferences3.edit().clear().apply();
            }
            SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, 0);
            IIX0o.oO(sharedPreferences4, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
            sharedPreferences = sharedPreferences4;
            Set<String> set = cachedPurchaseSet;
            if (sharedPreferences4 != null) {
                Set<String> stringSet = sharedPreferences4.getStringSet(PURCHASE_DETAILS_SET, new HashSet());
                if (stringSet == null) {
                    stringSet = new HashSet<>();
                }
                set.addAll(stringSet);
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(it.next(), new String[]{x.aL}, false, 2, 2, null);
                    cachedPurchaseMap.put(XXoO0oX2.get(0), Long.valueOf(Long.parseLong((String) XXoO0oX2.get(1))));
                }
                clearOutdatedProductInfoInCache$facebook_core_release();
                return;
            }
            IIX0o.XOxIOxOx("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final Map<String, JSONObject> cacheDeDupPurchase$facebook_core_release(@OOXIXo Map<String, JSONObject> purchaseDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(purchaseDetailsMap, "purchaseDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (Map.Entry entry : o0.OX00O0xII(purchaseDetailsMap).entrySet()) {
                String str = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                try {
                    if (jSONObject.has("purchaseToken")) {
                        String string = jSONObject.getString("purchaseToken");
                        if (cachedPurchaseMap.containsKey(string)) {
                            purchaseDetailsMap.remove(str);
                        } else {
                            Set<String> set = cachedPurchaseSet;
                            StringBuilder sb = new StringBuilder();
                            sb.append((Object) string);
                            sb.append(';');
                            sb.append(currentTimeMillis);
                            set.add(sb.toString());
                        }
                    }
                } catch (Exception unused) {
                }
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).apply();
                return new HashMap(purchaseDetailsMap);
            }
            IIX0o.XOxIOxOx("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @VisibleForTesting(otherwise = 2)
    public final void clearOutdatedProductInfoInCache$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                long j = sharedPreferences2.getLong(LAST_CLEARED_TIME, 0L);
                if (j == 0) {
                    SharedPreferences sharedPreferences3 = sharedPreferences;
                    if (sharedPreferences3 != null) {
                        sharedPreferences3.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        return;
                    } else {
                        IIX0o.XOxIOxOx("sharedPreferences");
                        throw null;
                    }
                }
                if (currentTimeMillis - j > 604800) {
                    for (Map.Entry entry : o0.OX00O0xII(cachedPurchaseMap).entrySet()) {
                        String str = (String) entry.getKey();
                        long longValue = ((Number) entry.getValue()).longValue();
                        if (currentTimeMillis - longValue > oI0IIXIo.f28349Oxx0xo) {
                            cachedPurchaseSet.remove(str + ';' + longValue);
                            cachedPurchaseMap.remove(str);
                        }
                    }
                    SharedPreferences sharedPreferences4 = sharedPreferences;
                    if (sharedPreferences4 != null) {
                        sharedPreferences4.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        return;
                    } else {
                        IIX0o.XOxIOxOx("sharedPreferences");
                        throw null;
                    }
                }
                return;
            }
            IIX0o.XOxIOxOx("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final Map<String, String> constructLoggingReadyMap$facebook_core_release(@OOXIXo Map<String, ? extends JSONObject> purchaseDetailsMap, @OOXIXo Map<String, ? extends JSONObject> skuDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(purchaseDetailsMap, "purchaseDetailsMap");
            IIX0o.x0xO0oo(skuDetailsMap, "skuDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends JSONObject> entry : purchaseDetailsMap.entrySet()) {
                String key = entry.getKey();
                JSONObject value = entry.getValue();
                JSONObject jSONObject = skuDetailsMap.get(key);
                if (value != null && value.has(PURCHASE_TIME)) {
                    try {
                        if (currentTimeMillis - (value.getLong(PURCHASE_TIME) / 1000) <= oI0IIXIo.f28349Oxx0xo && jSONObject != null) {
                            String jSONObject2 = value.toString();
                            IIX0o.oO(jSONObject2, "purchaseDetail.toString()");
                            String jSONObject3 = jSONObject.toString();
                            IIX0o.oO(jSONObject3, "skuDetail.toString()");
                            linkedHashMap.put(jSONObject2, jSONObject3);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
