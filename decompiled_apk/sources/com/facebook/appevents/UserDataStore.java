package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.RestrictTo;
import com.baidu.mapsdkplatform.comapi.f;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.Regex;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class UserDataStore {

    @OXOo.OOXIXo
    public static final String CITY = "ct";

    @OXOo.OOXIXo
    public static final String COUNTRY = "country";

    @OXOo.OOXIXo
    private static final String DATA_SEPARATOR = ",";

    @OXOo.OOXIXo
    public static final String DATE_OF_BIRTH = "db";

    @OXOo.OOXIXo
    public static final String EMAIL = "em";

    @OXOo.OOXIXo
    public static final String FIRST_NAME = "fn";

    @OXOo.OOXIXo
    public static final String GENDER = "ge";

    @OXOo.OOXIXo
    public static final UserDataStore INSTANCE = new UserDataStore();

    @OXOo.OOXIXo
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";

    @OXOo.OOXIXo
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;

    @OXOo.OOXIXo
    public static final String PHONE = "ph";

    @OXOo.OOXIXo
    public static final String STATE = "st";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";

    @OXOo.OOXIXo
    public static final String ZIP = "zp";

    @OXOo.OOXIXo
    private static final ConcurrentHashMap<String, String> externalHashedUserData;

    @OXOo.OOXIXo
    private static final AtomicBoolean initialized;

    @OXOo.OOXIXo
    private static final ConcurrentHashMap<String, String> internalHashedUserData;
    private static SharedPreferences sharedPreferences;

    static {
        String simpleName = UserDataStore.class.getSimpleName();
        IIX0o.oO(simpleName, "UserDataStore::class.java.simpleName");
        TAG = simpleName;
        initialized = new AtomicBoolean(false);
        externalHashedUserData = new ConcurrentHashMap<>();
        internalHashedUserData = new ConcurrentHashMap<>();
    }

    private UserDataStore() {
    }

    @XO0OX.x0XOIxOo
    public static final void clear() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.oI0IIXIo
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.m142clear$lambda2();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* renamed from: clear$lambda-2 */
    public static final void m142clear$lambda2() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserData");
                INSTANCE.initAndWait();
            }
            externalHashedUserData.clear();
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putString(USER_DATA_KEY, null).apply();
            } else {
                IIX0o.XOxIOxOx("sharedPreferences");
                throw null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getAllHashedUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(INSTANCE.getEnabledInternalUserData());
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
            for (String str : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(str)) {
                    hashMap.put(str, internalHashedUserData.get(str));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getHashedUserData$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserID");
                INSTANCE.initAndWait();
            }
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            IIX0o.oO(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
            sharedPreferences = defaultSharedPreferences;
            if (defaultSharedPreferences != null) {
                String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                if (string == null) {
                    string = "";
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
                    if (string2 == null) {
                        string2 = "";
                    }
                    ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                    Utility utility = Utility.INSTANCE;
                    concurrentHashMap.putAll(Utility.jsonStrToMap(string));
                    internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
                    atomicBoolean.set(true);
                    return;
                }
                IIX0o.XOxIOxOx("sharedPreferences");
                throw null;
            }
            IIX0o.XOxIOxOx("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void initStore() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (initialized.get()) {
                return;
            }
            INSTANCE.initAndWait();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return new Regex("[A-Fa-f0-9]{64}").matches(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final String normalizeData(String str, String str2) {
        String str3;
        int i;
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                if (!z2) {
                    i = i2;
                } else {
                    i = length;
                }
                if (IIX0o.oI0IIXIo(str2.charAt(i), 32) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z2) {
                    if (!z) {
                        z2 = true;
                    } else {
                        i2++;
                    }
                } else {
                    if (!z) {
                        break;
                    }
                    length--;
                }
            }
            String obj = str2.subSequence(i2, length + 1).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (IIX0o.Oxx0IOOO(EMAIL, str)) {
                    if (!Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        Log.e(TAG, "Setting email failure: this is not a valid email address");
                        return "";
                    }
                    return lowerCase;
                }
                if (IIX0o.Oxx0IOOO(PHONE, str)) {
                    return new Regex("[^0-9]").replace(lowerCase, "");
                }
                if (IIX0o.Oxx0IOOO(GENDER, str)) {
                    if (lowerCase.length() <= 0) {
                        str3 = "";
                    } else if (lowerCase != null) {
                        str3 = lowerCase.substring(0, 1);
                        IIX0o.oO(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (!IIX0o.Oxx0IOOO(f.f6163a, str3) && !IIX0o.Oxx0IOOO("m", str3)) {
                        Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                        return "";
                    }
                    return str3;
                }
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        r4 = new java.lang.String[0];
     */
    @XO0OX.x0XOIxOo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void setInternalUd(@OXOo.OOXIXo java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.UserDataStore.setInternalUd(java.util.Map):void");
    }

    @XO0OX.x0XOIxOo
    public static final void setUserDataAndHash(@OXOo.oOoXoXO final Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.IXxxXO
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.m143setUserDataAndHash$lambda1(bundle);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    /* renamed from: setUserDataAndHash$lambda-1 */
    public static final void m143setUserDataAndHash$lambda1(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserData");
                INSTANCE.initAndWait();
            }
            UserDataStore userDataStore = INSTANCE;
            userDataStore.updateHashUserData(bundle);
            Utility utility = Utility.INSTANCE;
            userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
            userDataStore.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final void updateHashUserData(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this) || bundle == null) {
            return;
        }
        try {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                        if (obj2 != null) {
                            String lowerCase = obj2.toLowerCase();
                            IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase()");
                            concurrentHashMap.put(key, lowerCase);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        Utility utility = Utility.INSTANCE;
                        IIX0o.oO(key, "key");
                        String sha256hash = Utility.sha256hash(normalizeData(key, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(key, sha256hash);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void writeDataIntoCache(final String str, final String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.Oxx0xo
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.m144writeDataIntoCache$lambda0(str, str2);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* renamed from: writeDataIntoCache$lambda-0 */
    public static final void m144writeDataIntoCache$lambda0(String key, String value) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(key, "$key");
            IIX0o.x0xO0oo(value, "$value");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putString(key, value).apply();
            } else {
                IIX0o.XOxIOxOx("sharedPreferences");
                throw null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setUserDataAndHash(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO String str8, @OXOo.oOoXoXO String str9, @OXOo.oOoXoXO String str10) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(EMAIL, str);
            }
            if (str2 != null) {
                bundle.putString(FIRST_NAME, str2);
            }
            if (str3 != null) {
                bundle.putString(LAST_NAME, str3);
            }
            if (str4 != null) {
                bundle.putString(PHONE, str4);
            }
            if (str5 != null) {
                bundle.putString(DATE_OF_BIRTH, str5);
            }
            if (str6 != null) {
                bundle.putString(GENDER, str6);
            }
            if (str7 != null) {
                bundle.putString(CITY, str7);
            }
            if (str8 != null) {
                bundle.putString(STATE, str8);
            }
            if (str9 != null) {
                bundle.putString(ZIP, str9);
            }
            if (str10 != null) {
                bundle.putString("country", str10);
            }
            setUserDataAndHash(bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }
}
