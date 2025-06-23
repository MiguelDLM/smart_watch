package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.huawei.openalliance.ad.constant.x;
import com.sma.smartv3.network.GetGooglePayCheckOrder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jxl.read.biff.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InAppPurchaseEventManager {

    @OOXIXo
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;

    @OOXIXo
    private static final String DETAILS_LIST = "DETAILS_LIST";

    @OOXIXo
    private static final String GET_PURCHASES = "getPurchases";

    @OOXIXo
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";

    @OOXIXo
    private static final String GET_SKU_DETAILS = "getSkuDetails";

    @OOXIXo
    private static final String INAPP = "inapp";

    @OOXIXo
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";

    @OOXIXo
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";

    @OOXIXo
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";

    @OOXIXo
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";

    @OOXIXo
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";

    @OOXIXo
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";

    @OOXIXo
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;

    @OOXIXo
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;

    @OOXIXo
    private static final String RESPONSE_CODE = "RESPONSE_CODE";

    @OOXIXo
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;

    @OOXIXo
    private static final String SUBSCRIPTION = "subs";
    private static final SharedPreferences purchaseInappSharedPrefs;
    private static final SharedPreferences skuDetailSharedPrefs;

    @OOXIXo
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();

    @OOXIXo
    private static final HashMap<String, Method> methodMap = new HashMap<>();

    @OOXIXo
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
        skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
        purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    }

    private InAppPurchaseEventManager() {
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Object asInterface(@OOXIXo Context context, @oOoXoXO IBinder iBinder) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void clearSkuDetailsCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences = skuDetailSharedPrefs;
            long j = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
            if (j == 0) {
                sharedPreferences.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            } else if (currentTimeMillis - j > CACHE_CLEAR_TIME_LIMIT_SEC) {
                sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString(GetGooglePayCheckOrder.PRODUCT_IT);
                    long j = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j / 1000) <= oI0IIXIo.f28349Oxx0xo && !IIX0o.Oxx0IOOO(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(next);
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Class<?>> hashMap = classMap;
            Class<?> cls = hashMap.get(str);
            if (cls != null) {
                return cls;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, str);
            if (classFromContext$facebook_core_release != null) {
                hashMap.put(str, classFromContext$facebook_core_release);
            }
            return classFromContext$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Method getMethod(Class<?> cls, String str) {
        Class[] clsArr;
        Method declaredMethod$facebook_core_release;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Method> hashMap = methodMap;
            Method method = hashMap.get(str);
            if (method != null) {
                return method;
            }
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals(GET_PURCHASES)) {
                        Class TYPE = Integer.TYPE;
                        IIX0o.oO(TYPE, "TYPE");
                        clsArr = new Class[]{TYPE, String.class, String.class, String.class};
                        break;
                    }
                    clsArr = null;
                    break;
                case -1450694211:
                    if (str.equals(IS_BILLING_SUPPORTED)) {
                        Class TYPE2 = Integer.TYPE;
                        IIX0o.oO(TYPE2, "TYPE");
                        clsArr = new Class[]{TYPE2, String.class, String.class};
                        break;
                    } else {
                        clsArr = null;
                        break;
                    }
                case -1123215065:
                    if (str.equals(AS_INTERFACE)) {
                        clsArr = new Class[]{IBinder.class};
                        break;
                    } else {
                        clsArr = null;
                        break;
                    }
                case -594356707:
                    if (str.equals(GET_PURCHASE_HISTORY)) {
                        Class TYPE3 = Integer.TYPE;
                        IIX0o.oO(TYPE3, "TYPE");
                        clsArr = new Class[]{TYPE3, String.class, String.class, String.class, Bundle.class};
                        break;
                    } else {
                        clsArr = null;
                        break;
                    }
                case -573310373:
                    if (str.equals(GET_SKU_DETAILS)) {
                        Class TYPE4 = Integer.TYPE;
                        IIX0o.oO(TYPE4, "TYPE");
                        clsArr = new Class[]{TYPE4, String.class, String.class, Bundle.class};
                        break;
                    } else {
                        clsArr = null;
                        break;
                    }
                default:
                    clsArr = null;
                    break;
            }
            if (clsArr == null) {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                declaredMethod$facebook_core_release = InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(cls, str, null);
            } else {
                InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                declaredMethod$facebook_core_release = InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(cls, str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            if (declaredMethod$facebook_core_release != null) {
                hashMap.put(str, declaredMethod$facebook_core_release);
            }
            return declaredMethod$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str)) {
                String str2 = null;
                int i = 0;
                boolean z = false;
                do {
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt(RESPONSE_CODE) == 0 && (stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST)) != null) {
                            Iterator<String> it = stringArrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    z = true;
                                    break;
                                }
                                arrayList.add(next);
                                i++;
                            }
                            str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                            if (i < 30 || str2 == null) {
                                break;
                                break;
                            }
                        }
                    }
                    str2 = null;
                    if (i < 30) {
                        break;
                    }
                } while (!z);
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final ArrayList<String> getPurchaseHistoryInapp(@OOXIXo Context context, @oOoXoXO Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            ArrayList<String> arrayList = new ArrayList<>();
            if (obj == null) {
                return arrayList;
            }
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            Class<?> cls = inAppPurchaseEventManager.getClass(context, IN_APP_BILLING_SERVICE);
            if (cls == null) {
                return arrayList;
            }
            if (inAppPurchaseEventManager.getMethod(cls, GET_PURCHASE_HISTORY) == null) {
                return arrayList;
            }
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchaseHistory(context, obj, INAPP));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[EDGE_INSN: B:24:0x0066->B:28:0x0066 BREAK  A[LOOP:0: B:12:0x001a->B:23:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r15, java.lang.Object r16, java.lang.String r17) {
        /*
            r14 = this;
            r0 = 3
            r1 = 0
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r14)
            r3 = 0
            if (r2 == 0) goto La
            return r3
        La:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5c
            r2.<init>()     // Catch: java.lang.Throwable -> L5c
            if (r16 != 0) goto L12
            return r2
        L12:
            boolean r4 = r14.isBillingSupported(r15, r16, r17)     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L66
            r4 = r3
            r5 = 0
        L1a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L5c
            r7 = 4
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L5c
            r13[r1] = r6     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L5c
            r7 = 1
            r13[r7] = r6     // Catch: java.lang.Throwable -> L5c
            r6 = 2
            r13[r6] = r17     // Catch: java.lang.Throwable -> L5c
            r13[r0] = r4     // Catch: java.lang.Throwable -> L5c
            java.lang.String r10 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r11 = "getPurchases"
            r8 = r14
            r9 = r15
            r12 = r16
            java.lang.Object r4 = r8.invokeMethod(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L5f
            android.os.Bundle r4 = (android.os.Bundle) r4     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = "RESPONSE_CODE"
            int r6 = r4.getInt(r6)     // Catch: java.lang.Throwable -> L5c
            if (r6 != 0) goto L5f
            java.lang.String r6 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r6 = r4.getStringArrayList(r6)     // Catch: java.lang.Throwable -> L5c
            if (r6 == 0) goto L66
            int r7 = r6.size()     // Catch: java.lang.Throwable -> L5c
            int r5 = r5 + r7
            r2.addAll(r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r4 = r4.getString(r6)     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5c:
            r0 = move-exception
            r1 = r14
            goto L67
        L5f:
            r4 = r3
        L60:
            r6 = 30
            if (r5 >= r6) goto L66
            if (r4 != 0) goto L1a
        L66:
            return r2
        L67:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @x0XOIxOo
    @OOXIXo
    public static final ArrayList<String> getPurchasesInapp(@OOXIXo Context context, @oOoXoXO Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, INAPP));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final ArrayList<String> getPurchasesSubs(@OOXIXo Context context, @oOoXoXO Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, SUBSCRIPTION));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final Map<String, String> getSkuDetails(@OOXIXo Context context, @OOXIXo ArrayList<String> skuList, @oOoXoXO Object obj, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(skuList, "skuList");
            Map<String, String> readSkuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(skuList);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = skuList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!readSkuDetailsFromCache.containsKey(next)) {
                    arrayList.add(next);
                }
            }
            readSkuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList, obj, z));
            return readSkuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Object obj2;
        int size;
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            if (obj != null && !arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                if (z) {
                    obj2 = SUBSCRIPTION;
                } else {
                    obj2 = INAPP;
                }
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, new Object[]{3, PACKAGE_NAME, obj2, bundle});
                if (invokeMethod != null) {
                    Bundle bundle2 = (Bundle) invokeMethod;
                    if (bundle2.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                        if (stringArrayList != null && arrayList.size() == stringArrayList.size() && arrayList.size() - 1 >= 0) {
                            while (true) {
                                int i2 = i + 1;
                                String str = arrayList.get(i);
                                IIX0o.oO(str, "skuList[i]");
                                String str2 = stringArrayList.get(i);
                                IIX0o.oO(str2, "skuDetailsList[i]");
                                linkedHashMap.put(str, str2);
                                if (i2 > size) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        writeSkuDetailsToCache(linkedHashMap);
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (invokeMethod != null) {
                if (((Integer) invokeMethod).intValue() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String sku = it.next();
                String string = skuDetailSharedPrefs.getString(sku, null);
                if (string != null) {
                    List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(string, new String[]{x.aL}, false, 2, 2, null);
                    if (currentTimeMillis - Long.parseLong((String) XXoO0oX2.get(0)) < 43200) {
                        IIX0o.oO(sku, "sku");
                        linkedHashMap.put(sku, XXoO0oX2.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), currentTimeMillis + ';' + entry.getValue());
            }
            edit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final boolean hasFreeTrialPeirod(@OOXIXo String skuDetail) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(skuDetail, "skuDetail");
            try {
                String optString = new JSONObject(skuDetail).optString("freeTrialPeriod");
                if (optString == null) {
                    return false;
                }
                if (optString.length() <= 0) {
                    return false;
                }
                return true;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
