package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes8.dex */
public final class Utility {

    @OXOo.OOXIXo
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;

    @OXOo.OOXIXo
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";

    @OXOo.OOXIXo
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";

    @OXOo.OOXIXo
    private static final String HASH_ALGORITHM_MD5 = "MD5";

    @OXOo.OOXIXo
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";

    @OXOo.OOXIXo
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";

    @OXOo.OOXIXo
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";

    @OXOo.OOXIXo
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;

    @OXOo.OOXIXo
    private static final String URL_SCHEME = "https";

    @OXOo.OOXIXo
    private static final String UTF8 = "UTF-8";
    private static int numCPUCores;

    @OXOo.OOXIXo
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;

    @OXOo.OOXIXo
    private static String deviceTimezoneAbbreviation = "";

    @OXOo.OOXIXo
    private static String deviceTimeZoneName = "";

    @OXOo.OOXIXo
    private static final String NO_CARRIER = "NoCarrier";

    @OXOo.OOXIXo
    private static String carrierName = NO_CARRIER;

    /* loaded from: classes8.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(@OXOo.oOoXoXO FacebookException facebookException);

        void onSuccess(@OXOo.oOoXoXO JSONObject jSONObject);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, Context context) {
        if (Build.VERSION.SDK_INT >= 31 && isGooglePlayServicesAvailable(context)) {
            if (!attributionIdentifiers.isTrackingLimited()) {
                jSONObject.put("anon_id", str);
                return;
            }
            return;
        }
        jSONObject.put("anon_id", str);
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, Context context) {
        if (Build.VERSION.SDK_INT >= 31 && isGooglePlayServicesAvailable(context)) {
            if (!attributionIdentifiers.isTrackingLimited()) {
                jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
                return;
            }
            return;
        }
        jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
    }

    @XO0OX.x0XOIxOo
    public static final <T> boolean areObjectsEqual(@OXOo.oOoXoXO T t, @OXOo.oOoXoXO T t2) {
        if (t == null) {
            if (t2 == null) {
                return true;
            }
            return false;
        }
        return IIX0o.Oxx0IOOO(t, t2);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final JSONObject awaitGetGraphMeRequestWithCache(@OXOo.OOXIXo String accessToken) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(accessToken).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJsonObject();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Uri buildUri(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        IIX0o.oO(build, "builder.build()");
        return build;
    }

    private final void clearCookiesForDomain(Context context, String str) {
        int i;
        boolean z;
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        Object[] array = StringsKt__StringsKt.XXoO0oX(cookie, new String[]{x.aL}, false, 0, 6, null).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                i2++;
                Object[] array2 = StringsKt__StringsKt.XXoO0oX(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length > 0) {
                        String str3 = strArr2[0];
                        int length2 = str3.length() - 1;
                        int i3 = 0;
                        boolean z2 = false;
                        while (i3 <= length2) {
                            if (!z2) {
                                i = i3;
                            } else {
                                i = length2;
                            }
                            if (IIX0o.oI0IIXIo(str3.charAt(i), 32) <= 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z2) {
                                if (!z) {
                                    z2 = true;
                                } else {
                                    i3++;
                                }
                            } else if (!z) {
                                break;
                            } else {
                                length2--;
                            }
                        }
                        cookieManager.setCookie(str, IIX0o.XIxXXX0x0(str3.subSequence(i3, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            cookieManager.removeExpiredCookie();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @XO0OX.x0XOIxOo
    public static final void clearFacebookCookies(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, FacebookSdk.FACEBOOK_COM);
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    @XO0OX.x0XOIxOo
    public static final void closeQuietly(@OXOo.oOoXoXO Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String coerceValueIfNullOrEmpty(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        if (isNullOrEmpty(str)) {
            return str2;
        }
        return str;
    }

    private final long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<String> convertJSONArrayToList(@OXOo.OOXIXo JSONArray jsonArray) {
        IIX0o.x0xO0oo(jsonArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String string = jsonArray.getString(i);
                    IIX0o.oO(string, "jsonArray.getString(i)");
                    arrayList.add(string);
                    if (i2 < length) {
                        i = i2;
                    } else {
                        return arrayList;
                    }
                }
            } else {
                return arrayList;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Map<String, Object> convertJSONObjectToHashMap(@OXOo.OOXIXo JSONObject jsonObject) {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jsonObject.names();
        if (names == null) {
            return hashMap;
        }
        int length = names.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    String string = names.getString(i);
                    IIX0o.oO(string, "keys.getString(i)");
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject) value);
                    }
                    IIX0o.oO(value, "value");
                    hashMap.put(string, value);
                } catch (JSONException unused) {
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashMap;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Map<String, String> convertJSONObjectToStringMap(@OXOo.OOXIXo JSONObject jsonObject) {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String optString = jsonObject.optString(key);
            if (optString != null) {
                IIX0o.oO(key, "key");
                hashMap.put(key, optString);
            }
        }
        return hashMap;
    }

    @XO0OX.x0XOIxOo
    public static final int copyAndCloseInputStream(@OXOo.oOoXoXO InputStream inputStream, @OXOo.OOXIXo OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        IIX0o.x0xO0oo(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            bufferedInputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void disconnectQuietly(@OXOo.oOoXoXO URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    private final boolean externalStorageExists() {
        return IIX0o.Oxx0IOOO("mounted", Environment.getExternalStorageState());
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String generateRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        IIX0o.oO(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getActivityName(@OXOo.oOoXoXO Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        IIX0o.oO(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getAppName(@OXOo.OOXIXo Context context) {
        String string;
        IIX0o.x0xO0oo(context, "context");
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                IIX0o.oO(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getAppVersion() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Date getBundleLongAsDate(@OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO String str, @OXOo.OOXIXo Date dateBase) {
        long parseLong;
        IIX0o.x0xO0oo(dateBase, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    parseLong = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(dateBase.getTime() + (parseLong * 1000));
    }

    @XO0OX.x0XOIxOo
    public static final long getContentSize(@OXOo.OOXIXo Uri contentUri) {
        IIX0o.x0xO0oo(contentUri, "contentUri");
        Cursor cursor = null;
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
            if (cursor == null) {
                return 0L;
            }
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j = cursor.getLong(columnIndex);
            cursor.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale == null) {
            Locale locale = Locale.getDefault();
            IIX0o.oO(locale, "getDefault()");
            return locale;
        }
        return resourceLocale;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken != null && currentAccessToken.getGraphDomain() != null) {
            return currentAccessToken.getGraphDomain();
        }
        return AccessToken.DEFAULT_GRAPH_DOMAIN;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphDomainFromTokenDomain(@OXOo.oOoXoXO String str) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str == null) {
            return facebookDomain;
        }
        if (IIX0o.Oxx0IOOO(str, FacebookSdk.GAMING)) {
            return kotlin.text.OxI.IIOIX(facebookDomain, FacebookSdk.FACEBOOK_COM, "fb.gg", false, 4, null);
        }
        if (IIX0o.Oxx0IOOO(str, "instagram")) {
            return kotlin.text.OxI.IIOIX(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.INSTAGRAM_COM, false, 4, null);
        }
        return facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        GraphRequest newMeRequest = GraphRequest.Companion.newMeRequest(null, null);
        newMeRequest.setParameters(bundle);
        newMeRequest.setHttpMethod(HttpMethod.GET);
        return newMeRequest;
    }

    @XO0OX.x0XOIxOo
    public static final void getGraphMeRequestWithCacheAsync(@OXOo.OOXIXo final String accessToken, @OXOo.OOXIXo final GraphMeRequestWithCacheCallback callback) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(callback, "callback");
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            callback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.internal.IIXOooo
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                Utility.m213getGraphMeRequestWithCacheAsync$lambda3(Utility.GraphMeRequestWithCacheCallback.this, accessToken, graphResponse);
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(accessToken);
        graphMeRequestWithCache.setCallback(callback2);
        graphMeRequestWithCache.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3, reason: not valid java name */
    public static final void m213getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback callback, String accessToken, GraphResponse response) {
        IIX0o.x0xO0oo(callback, "$callback");
        IIX0o.x0xO0oo(accessToken, "$accessToken");
        IIX0o.x0xO0oo(response, "response");
        if (response.getError() != null) {
            callback.onFailure(response.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject != null) {
            ProfileInformationCache.putProfileInformation(accessToken, jsonObject);
            callback.onSuccess(response.getJsonObject());
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getMetadataApplicationId(@OXOo.oOoXoXO Context context) {
        Validate validate = Validate.INSTANCE;
        Validate.notNull(context, bn.f.o);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationId();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Method getMethodQuietly(@OXOo.OOXIXo Class<?> clazz, @OXOo.OOXIXo String methodName, @OXOo.OOXIXo Class<?>... parameterTypes) {
        IIX0o.x0xO0oo(clazz, "clazz");
        IIX0o.x0xO0oo(methodName, "methodName");
        IIX0o.x0xO0oo(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        if (IIX0o.Oxx0IOOO(str, "instagram")) {
            return INSTAGRAM_PROFILE_FIELDS;
        }
        return FACEBOOK_PROFILE_FIELDS;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Locale getResourceLocale() {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Object getStringPropertyAsJSON(@OXOo.OOXIXo JSONObject jsonObject, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) throws JSONException {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        Object opt = jsonObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
            if (str2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(str2, opt);
                return jSONObject;
            }
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        return opt;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getUriString(@OXOo.oOoXoXO Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        IIX0o.oO(digest, "digest");
        int length = digest.length;
        int i = 0;
        while (i < length) {
            byte b = digest[i];
            i++;
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "builder.toString()");
        return sb2;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = kotlin.text.oxoX.f29581II0xO0;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str2.getBytes(charset);
        IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(str, bytes);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Object invokeMethodQuietly(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Method method, @OXOo.OOXIXo Object... args) {
        IIX0o.x0xO0oo(method, "method");
        IIX0o.x0xO0oo(args, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                if (IIX0o.Oxx0IOOO(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean isAutofillAvailable(@OXOo.OOXIXo Context context) {
        Object systemService;
        boolean isAutofillSupported;
        boolean isEnabled;
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            systemService = context.getSystemService((Class<Object>) IXxxXO.oIX0oI());
            AutofillManager oIX0oI2 = Oxx0xo.oIX0oI(systemService);
            if (oIX0oI2 != null) {
                isAutofillSupported = oIX0oI2.isAutofillSupported();
                if (isAutofillSupported) {
                    isEnabled = oIX0oI2.isEnabled();
                    if (!isEnabled) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isChromeOS(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String DEVICE = Build.DEVICE;
        if (DEVICE != null) {
            IIX0o.oO(DEVICE, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(DEVICE)) {
                return true;
            }
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isContentUri(@OXOo.oOoXoXO Uri uri) {
        if (uri != null && kotlin.text.OxI.oX0I0O("content", uri.getScheme(), true)) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isCurrentAccessToken(@OXOo.oOoXoXO AccessToken accessToken) {
        if (accessToken != null && IIX0o.Oxx0IOOO(accessToken, AccessToken.Companion.getCurrentAccessToken())) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        String string = jSONArray.getString(i);
                        IIX0o.oO(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (IIX0o.Oxx0IOOO(lowerCase, "ldu")) {
                            return true;
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean isFileUri(@OXOo.oOoXoXO Uri uri) {
        if (uri != null && kotlin.text.OxI.oX0I0O("file", uri.getScheme(), true)) {
            return true;
        }
        return false;
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = invokeMethodQuietly(null, methodQuietly, context);
        if ((invokeMethodQuietly instanceof Integer) && IIX0o.Oxx0IOOO(invokeMethodQuietly, 0)) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isNullOrEmpty(@OXOo.oOoXoXO Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @XO0OX.x0XOIxOo
    public static final boolean isWebUri(@OXOo.oOoXoXO Uri uri) {
        if (uri != null && (kotlin.text.OxI.oX0I0O("http", uri.getScheme(), true) || kotlin.text.OxI.oX0I0O("https", uri.getScheme(), true) || kotlin.text.OxI.oX0I0O("fbstaging", uri.getScheme(), true))) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Set<String> jsonArrayToSet(@OXOo.OOXIXo JSONArray jsonArray) throws JSONException {
        IIX0o.x0xO0oo(jsonArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String string = jsonArray.getString(i);
                IIX0o.oO(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashSet;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<String> jsonArrayToStringList(@OXOo.OOXIXo JSONArray jsonArray) throws JSONException {
        IIX0o.x0xO0oo(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayList.add(jsonArray.getString(i));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Map<String, String> jsonStrToMap(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                IIX0o.oO(key, "key");
                String string = jSONObject.getString(key);
                IIX0o.oO(string, "jsonObject.getString(key)");
                hashMap.put(key, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @XO0OX.x0XOIxOo
    public static final void logd(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Exception exc) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + ((Object) exc.getMessage()));
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String mapToJsonStr(@OXOo.OOXIXo Map<String, String> map) {
        IIX0o.x0xO0oo(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            IIX0o.oO(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String md5hash(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return INSTANCE.hashWithAlgorithm("MD5", key);
    }

    @XO0OX.x0XOIxOo
    public static final boolean mustFixWindowParamsForAutofill(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return isAutofillAvailable(context);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Bundle parseUrlQueryString(@OXOo.oOoXoXO String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = StringsKt__StringsKt.XXoO0oX(str, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArr[i];
                        i++;
                        Object[] array2 = StringsKt__StringsKt.XXoO0oX(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e) {
                                logd(LOG_TAG, e);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        return bundle;
    }

    @XO0OX.x0XOIxOo
    public static final void putCommaSeparatedStringList(@OXOo.OOXIXo Bundle b, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO List<String> list) {
        IIX0o.x0xO0oo(b, "b");
        if (list != null) {
            b.putString(str, TextUtils.join(",", list));
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean putJSONValueInBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Object obj) {
        IIX0o.x0xO0oo(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
            return true;
        }
        if (obj instanceof JSONObject) {
            bundle.putString(str, ((JSONObject) obj).toString());
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final void putNonEmptyString(@OXOo.OOXIXo Bundle b, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        IIX0o.x0xO0oo(b, "b");
        if (!isNullOrEmpty(str2)) {
            b.putString(str, str2);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void putUri(@OXOo.OOXIXo Bundle b, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Uri uri) {
        IIX0o.x0xO0oo(b, "b");
        if (uri != null) {
            putNonEmptyString(b, str, uri.toString());
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Map<String, String> readNonnullStringMapFromParcel(@OXOo.OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i = 0;
            do {
                i++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (readString != null && readString2 != null) {
                    hashMap.put(readString, readString2);
                }
            } while (i < readInt);
        }
        return hashMap;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String readStreamToString(@OXOo.oOoXoXO InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            IIX0o.oO(sb2, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Map<String, String> readStringMapFromParcel(@OXOo.OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i = 0;
            do {
                i++;
                hashMap.put(parcel.readString(), parcel.readString());
            } while (i < readInt);
        }
        return hashMap;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.xoXoI
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    boolean m214refreshBestGuessNumberOfCPUCores$lambda4;
                    m214refreshBestGuessNumberOfCPUCores$lambda4 = Utility.m214refreshBestGuessNumberOfCPUCores$lambda4(file, str);
                    return m214refreshBestGuessNumberOfCPUCores$lambda4;
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4, reason: not valid java name */
    public static final boolean m214refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context context) {
        if (IIX0o.Oxx0IOOO(carrierName, NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    IIX0o.oO(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            IIX0o.oO(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id = timeZone.getID();
            IIX0o.oO(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    @XO0OX.x0XOIxOo
    public static final void runOnNonUiThread(@OXOo.oOoXoXO Runnable runnable) {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String safeGetStringFromResponse(@OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        IIX0o.oO(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    @XO0OX.x0XOIxOo
    public static final void setAppEventAttributionParameters(@OXOo.OOXIXo JSONObject params, @OXOo.oOoXoXO AttributionIdentifiers attributionIdentifiers, @OXOo.oOoXoXO String str, boolean z, @OXOo.OOXIXo Context context) throws JSONException {
        IIX0o.x0xO0oo(params, "params");
        IIX0o.x0xO0oo(context, "context");
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            params.put("anon_id", str);
        }
        params.put("application_tracking_enabled", !z);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        params.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(params, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(params, attributionIdentifiers, context);
                } else {
                    params.put("attribution", attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                params.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                params.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                UserDataStore userDataStore = UserDataStore.INSTANCE;
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    params.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setAppEventExtendedDeviceInfoParameters(@OXOo.OOXIXo JSONObject params, @OXOo.OOXIXo Context appContext) throws JSONException {
        String str;
        Locale locale;
        int i;
        Display display;
        DisplayManager displayManager;
        PackageInfo packageInfo;
        IIX0o.x0xO0oo(params, "params");
        IIX0o.x0xO0oo(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(appContext);
        String packageName = appContext.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        if (packageInfo == null) {
            return;
        }
        i3 = packageInfo.versionCode;
        str = packageInfo.versionName;
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = appContext.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + '_' + ((Object) locale.getCountry()));
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d = XIXIX.OOXIXo.f3760XO;
        try {
            Object systemService = appContext.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            display = null;
            if (systemService instanceof DisplayManager) {
                displayManager = (DisplayManager) systemService;
            } else {
                displayManager = null;
            }
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            }
        } catch (Exception unused3) {
        }
        if (display != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            int i4 = displayMetrics.widthPixels;
            try {
                int i5 = displayMetrics.heightPixels;
                try {
                    d = displayMetrics.density;
                } catch (Exception unused4) {
                }
                i = i5;
                i2 = i4;
            } catch (Exception unused5) {
                i2 = i4;
            }
            jSONArray.put(i2);
            jSONArray.put(i);
            jSONArray.put(new DecimalFormat("#.##").format(d));
            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            params.put(Constants.EXTINFO, jSONArray.toString());
        }
        i = 0;
        jSONArray.put(i2);
        jSONArray.put(i);
        jSONArray.put(new DecimalFormat("#.##").format(d));
        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        params.put(Constants.EXTINFO, jSONArray.toString());
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String sha1hash(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return INSTANCE.hashWithAlgorithm("SHA-1", key);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String sha256hash(@OXOo.oOoXoXO String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", str);
    }

    @XO0OX.x0XOIxOo
    public static final boolean stringsEqualOrEmpty(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        boolean z;
        boolean z2;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return IIX0o.Oxx0IOOO(str, str2);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final JSONArray tryGetJSONArrayFromResponse(@OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray(str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final JSONObject tryGetJSONObjectFromResponse(@OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    @XO0OX.x0XOIxOo
    public static final void writeNonnullStringMapToParcel(@OXOo.OOXIXo Parcel parcel, @OXOo.oOoXoXO Map<String, String> map) {
        IIX0o.x0xO0oo(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void writeStringMapToParcel(@OXOo.OOXIXo Parcel parcel, @OXOo.oOoXoXO Map<String, String> map) {
        IIX0o.x0xO0oo(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Method getMethodQuietly(@OXOo.OOXIXo String className, @OXOo.OOXIXo String methodName, @OXOo.OOXIXo Class<?>... parameterTypes) {
        IIX0o.x0xO0oo(className, "className");
        IIX0o.x0xO0oo(methodName, "methodName");
        IIX0o.x0xO0oo(parameterTypes, "parameterTypes");
        try {
            Class<?> cls = Class.forName(className);
            IIX0o.oO(cls, "forName(className)");
            return getMethodQuietly(cls, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest hash = MessageDigest.getInstance(str);
            IIX0o.oO(hash, "hash");
            return hashBytes(hash, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean isNullOrEmpty(@OXOo.oOoXoXO String str) {
        return str == null || str.length() == 0;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String sha1hash(@OXOo.OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        return INSTANCE.hashWithAlgorithm("SHA-1", bytes);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String sha256hash(@OXOo.oOoXoXO byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", bArr);
    }

    @XO0OX.x0XOIxOo
    public static final void logd(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @XO0OX.x0XOIxOo
    public static final void logd(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Throwable th) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }
}
