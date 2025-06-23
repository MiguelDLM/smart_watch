package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InAppPurchaseBillingClientWrapper {

    @OOXIXo
    private static final String CLASSNAME_BILLING_CLIENT = "com.android.billingclient.api.BillingClient";

    @OOXIXo
    private static final String CLASSNAME_BILLING_CLIENT_BUILDER = "com.android.billingclient.api.BillingClient$Builder";

    @OOXIXo
    private static final String CLASSNAME_BILLING_CLIENT_STATE_LISTENER = "com.android.billingclient.api.BillingClientStateListener";

    @OOXIXo
    private static final String CLASSNAME_PURCHASE = "com.android.billingclient.api.Purchase";

    @OOXIXo
    private static final String CLASSNAME_PURCHASES_RESULT = "com.android.billingclient.api.Purchase$PurchasesResult";

    @OOXIXo
    private static final String CLASSNAME_PURCHASE_HISTORY_RECORD = "com.android.billingclient.api.PurchaseHistoryRecord";

    @OOXIXo
    private static final String CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER = "com.android.billingclient.api.PurchaseHistoryResponseListener";

    @OOXIXo
    private static final String CLASSNAME_PURCHASE_UPDATED_LISTENER = "com.android.billingclient.api.PurchasesUpdatedListener";

    @OOXIXo
    private static final String CLASSNAME_SKU_DETAILS = "com.android.billingclient.api.SkuDetails";

    @OOXIXo
    private static final String CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER = "com.android.billingclient.api.SkuDetailsResponseListener";

    @OOXIXo
    private static final String IN_APP = "inapp";

    @OOXIXo
    private static final String METHOD_BUILD = "build";

    @OOXIXo
    private static final String METHOD_ENABLE_PENDING_PURCHASES = "enablePendingPurchases";

    @OOXIXo
    private static final String METHOD_GET_ORIGINAL_JSON = "getOriginalJson";

    @OOXIXo
    private static final String METHOD_GET_PURCHASE_LIST = "getPurchasesList";

    @OOXIXo
    private static final String METHOD_NEW_BUILDER = "newBuilder";

    @OOXIXo
    private static final String METHOD_ON_BILLING_SERVICE_DISCONNECTED = "onBillingServiceDisconnected";

    @OOXIXo
    private static final String METHOD_ON_BILLING_SETUP_FINISHED = "onBillingSetupFinished";

    @OOXIXo
    private static final String METHOD_ON_PURCHASE_HISTORY_RESPONSE = "onPurchaseHistoryResponse";

    @OOXIXo
    private static final String METHOD_ON_SKU_DETAILS_RESPONSE = "onSkuDetailsResponse";

    @OOXIXo
    private static final String METHOD_QUERY_PURCHASES = "queryPurchases";

    @OOXIXo
    private static final String METHOD_QUERY_PURCHASE_HISTORY_ASYNC = "queryPurchaseHistoryAsync";

    @OOXIXo
    private static final String METHOD_QUERY_SKU_DETAILS_ASYNC = "querySkuDetailsAsync";

    @OOXIXo
    private static final String METHOD_SET_LISTENER = "setListener";

    @OOXIXo
    private static final String METHOD_START_CONNECTION = "startConnection";

    @OOXIXo
    private static final String PACKAGE_NAME = "packageName";

    @OOXIXo
    private static final String PRODUCT_ID = "productId";

    @oOoXoXO
    private static InAppPurchaseBillingClientWrapper instance;

    @OOXIXo
    private final Object billingClient;

    @OOXIXo
    private final Class<?> billingClientClazz;

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final Method getOriginalJsonMethod;

    @OOXIXo
    private final Method getOriginalJsonPurchaseHistoryMethod;

    @OOXIXo
    private final Method getOriginalJsonSkuMethod;

    @OOXIXo
    private final Method getPurchaseListMethod;

    @OOXIXo
    private final Set<String> historyPurchaseSet;

    @OOXIXo
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;

    @OOXIXo
    private final Class<?> purchaseClazz;

    @OOXIXo
    private final Class<?> purchaseHistoryRecordClazz;

    @OOXIXo
    private final Class<?> purchaseHistoryResponseListenerClazz;

    @OOXIXo
    private final Class<?> purchaseResultClazz;

    @OOXIXo
    private final Method queryPurchaseHistoryAsyncMethod;

    @OOXIXo
    private final Method queryPurchasesMethod;

    @OOXIXo
    private final Method querySkuDetailsAsyncMethod;

    @OOXIXo
    private final Class<?> skuDetailsClazz;

    @OOXIXo
    private final Class<?> skuDetailsResponseListenerClazz;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    @OOXIXo
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);

    @OOXIXo
    private static final Map<String, JSONObject> purchaseDetailsMap = new ConcurrentHashMap();

    @OOXIXo
    private static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();

    /* loaded from: classes8.dex */
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        @oOoXoXO
        public Object invoke(@OOXIXo Object proxy, @OOXIXo Method m, @oOoXoXO Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                IIX0o.x0xO0oo(proxy, "proxy");
                IIX0o.x0xO0oo(m, "m");
                if (IIX0o.Oxx0IOOO(m.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SETUP_FINISHED)) {
                    InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(true);
                } else {
                    String name = m.getName();
                    IIX0o.oO(name, "m.name");
                    if (OxI.XO0o(name, InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SERVICE_DISCONNECTED, false, 2, null)) {
                        InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(false);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls) {
            Object invokeMethod;
            Object invokeMethod2;
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_UPDATED_LISTENER);
            if (cls2 == null || cls3 == null) {
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_NEW_BUILDER, Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_SET_LISTENER, cls3);
            Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_BUILD, new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, null, context)) == null) {
                return null;
            }
            Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper());
            IIX0o.oO(newProxyInstance, "newProxyInstance(\n              listenerClazz.classLoader, arrayOf(listenerClazz), PurchasesUpdatedListenerWrapper())");
            Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method3, invokeMethod, newProxyInstance);
            if (invokeMethod3 == null || (invokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method2, invokeMethod3, new Object[0])) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls2, method4, invokeMethod2, new Object[0]);
        }

        private final void createInstance(Context context) {
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if (orCreateInstance == null) {
                return;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASES_RESULT);
            Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS);
            Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RECORD);
            Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
            Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
            if (cls != null && cls3 != null && cls2 != null && cls4 != null && cls6 != null && cls5 != null && cls7 != null) {
                Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASES, String.class);
                Method method2 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseBillingClientWrapper.METHOD_GET_PURCHASE_LIST, new Class[0]);
                Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method4 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method5 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method6 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_SKU_DETAILS_ASYNC, orCreateInstance.getSkuDetailsParamsClazz(), cls6);
                Method method7 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, String.class, cls7);
                if (method != null && method2 != null && method3 != null && method4 != null && method5 != null && method6 != null && method7 != null) {
                    Object createBillingClient = createBillingClient(context, cls);
                    if (createBillingClient == null) {
                        return;
                    }
                    InAppPurchaseBillingClientWrapper.access$setInstance$cp(new InAppPurchaseBillingClientWrapper(context, createBillingClient, cls, cls3, cls2, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, orCreateInstance, null));
                    InAppPurchaseBillingClientWrapper access$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    if (access$getInstance$cp != null) {
                        InAppPurchaseBillingClientWrapper.access$startConnection(access$getInstance$cp);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                }
            }
        }

        @x0XOIxOo
        @oOoXoXO
        public final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            if (InAppPurchaseBillingClientWrapper.access$getInitialized$cp().get()) {
                return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
            }
            createInstance(context);
            InAppPurchaseBillingClientWrapper.access$getInitialized$cp().set(true);
            return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
        }

        @OOXIXo
        public final Map<String, JSONObject> getPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getPurchaseDetailsMap$cp();
        }

        @OOXIXo
        public final Map<String, JSONObject> getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getSkuDetailsMap$cp();
        }

        @OOXIXo
        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapper.access$isServiceConnected$cp();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {

        @OOXIXo
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public PurchaseHistoryResponseListenerWrapper(@OOXIXo InAppPurchaseBillingClientWrapper this$0, Runnable runnable) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(runnable, "runnable");
            this.this$0 = this$0;
            this.runnable = runnable;
        }

        private final void getPurchaseHistoryRecord(List<?> list) {
            String str;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                for (Object obj : list) {
                    try {
                        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                        Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getPurchaseHistoryRecordClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonPurchaseHistoryMethod$p(this.this$0), obj, new Object[0]);
                        if (invokeMethod instanceof String) {
                            str = (String) invokeMethod;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            jSONObject.put("packageName", InAppPurchaseBillingClientWrapper.access$getContext$p(this.this$0).getPackageName());
                            if (jSONObject.has("productId")) {
                                String skuID = jSONObject.getString("productId");
                                InAppPurchaseBillingClientWrapper.access$getHistoryPurchaseSet$p(this.this$0).add(skuID);
                                Map<String, JSONObject> purchaseDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap();
                                IIX0o.oO(skuID, "skuID");
                                purchaseDetailsMap.put(skuID, jSONObject);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                this.runnable.run();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        @OOXIXo
        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @oOoXoXO
        public Object invoke(@OOXIXo Object proxy, @OOXIXo Method method, @oOoXoXO Object[] objArr) {
            Object obj;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                IIX0o.x0xO0oo(proxy, "proxy");
                IIX0o.x0xO0oo(method, "method");
                if (IIX0o.Oxx0IOOO(method.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                    if (objArr == null) {
                        obj = null;
                    } else {
                        obj = objArr[1];
                    }
                    if (obj != null && (obj instanceof List)) {
                        getPurchaseHistoryRecord((List) obj);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public final void setRunnable(@OOXIXo Runnable runnable) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(runnable, "<set-?>");
                this.runnable = runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        @oOoXoXO
        public Object invoke(@OOXIXo Object proxy, @OOXIXo Method m, @oOoXoXO Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                IIX0o.x0xO0oo(proxy, "proxy");
                IIX0o.x0xO0oo(m, "m");
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {

        @OOXIXo
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(@OOXIXo InAppPurchaseBillingClientWrapper this$0, Runnable runnable) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(runnable, "runnable");
            this.this$0 = this$0;
            this.runnable = runnable;
        }

        @OOXIXo
        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @oOoXoXO
        public Object invoke(@OOXIXo Object proxy, @OOXIXo Method m, @oOoXoXO Object[] objArr) {
            Object obj;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                IIX0o.x0xO0oo(proxy, "proxy");
                IIX0o.x0xO0oo(m, "m");
                if (IIX0o.Oxx0IOOO(m.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_SKU_DETAILS_RESPONSE)) {
                    if (objArr == null) {
                        obj = null;
                    } else {
                        obj = objArr[1];
                    }
                    if (obj != null && (obj instanceof List)) {
                        parseSkuDetails((List) obj);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public final void parseSkuDetails(@OOXIXo List<?> skuDetailsObjectList) {
            String str;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(skuDetailsObjectList, "skuDetailsObjectList");
                for (Object obj : skuDetailsObjectList) {
                    try {
                        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                        Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getSkuDetailsClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonSkuMethod$p(this.this$0), obj, new Object[0]);
                        if (invokeMethod instanceof String) {
                            str = (String) invokeMethod;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("productId")) {
                                String skuID = jSONObject.getString("productId");
                                Map<String, JSONObject> skuDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap();
                                IIX0o.oO(skuID, "skuID");
                                skuDetailsMap.put(skuID, jSONObject);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                this.runnable.run();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        public final void setRunnable(@OOXIXo Runnable runnable) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(runnable, "<set-?>");
                this.runnable = runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapper(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper, IIXOooo iIXOooo) {
        this(context, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, inAppPurchaseSkuDetailsWrapper);
    }

    public static final /* synthetic */ Context access$getContext$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.context;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonPurchaseHistoryMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonSkuMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Set access$getHistoryPurchaseSet$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.historyPurchaseSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapper access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return purchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.purchaseHistoryRecordClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.skuDetailsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSkuDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return skuDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            instance = inAppPurchaseBillingClientWrapper;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
        }
    }

    public static final /* synthetic */ void access$startConnection(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapper.startConnection();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(@OOXIXo Context context) {
        synchronized (InAppPurchaseBillingClientWrapper.class) {
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                return null;
            }
            try {
                return Companion.getOrCreateInstance(context);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryPurchaseHistory$lambda-0, reason: not valid java name */
    public static final void m161queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper this$0, Runnable queryPurchaseHistoryRunnable) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(queryPurchaseHistoryRunnable, "$queryPurchaseHistoryRunnable");
            this$0.querySkuDetailsAsync(IN_APP, new ArrayList(this$0.historyPurchaseSet), queryPurchaseHistoryRunnable);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
        }
    }

    private final void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this, runnable));
            IIX0o.oO(newProxyInstance, "newProxyInstance(\n            purchaseHistoryResponseListenerClazz.classLoader,\n            arrayOf(purchaseHistoryResponseListenerClazz),\n            PurchaseHistoryResponseListenerWrapper(runnable))");
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this, runnable));
            IIX0o.oO(newProxyInstance, "newProxyInstance(\n            skuDetailsResponseListenerClazz.classLoader,\n            arrayOf(skuDetailsResponseListenerClazz),\n            SkuDetailsResponseListenerWrapper(runnable))");
            Object skuDetailsParams = this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list);
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, skuDetailsParams, newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void startConnection() {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
            if (cls == null || (method = InAppPurchaseUtils.getMethod(this.billingClientClazz, METHOD_START_CONNECTION, cls)) == null) {
                return;
            }
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper());
            IIX0o.oO(newProxyInstance, "newProxyInstance(\n            listenerClazz.classLoader, arrayOf(listenerClazz), BillingClientStateListenerWrapper())");
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void queryPurchase(@OOXIXo String skuType, @OOXIXo Runnable querySkuRunnable) {
        List list;
        String str;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(skuType, "skuType");
            IIX0o.x0xO0oo(querySkuRunnable, "querySkuRunnable");
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, IN_APP), new Object[0]);
            if (invokeMethod instanceof List) {
                list = (List) invokeMethod;
            } else {
                list = null;
            }
            if (list == null) {
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                    Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, obj, new Object[0]);
                    if (invokeMethod2 instanceof String) {
                        str = (String) invokeMethod2;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("productId")) {
                            String skuID = jSONObject.getString("productId");
                            arrayList.add(skuID);
                            Map<String, JSONObject> map = purchaseDetailsMap;
                            IIX0o.oO(skuID, "skuID");
                            map.put(skuID, jSONObject);
                        }
                    }
                }
                querySkuDetailsAsync(skuType, arrayList, querySkuRunnable);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void queryPurchaseHistory(@OOXIXo String skuType, @OOXIXo final Runnable queryPurchaseHistoryRunnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(skuType, "skuType");
            IIX0o.x0xO0oo(queryPurchaseHistoryRunnable, "queryPurchaseHistoryRunnable");
            queryPurchaseHistoryAsync(skuType, new Runnable() { // from class: com.facebook.appevents.iap.X0o0xo
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapper.m161queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper.this, queryPurchaseHistoryRunnable);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private InAppPurchaseBillingClientWrapper(Context context, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        this.context = context;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper;
        this.historyPurchaseSet = new CopyOnWriteArraySet();
    }
}
