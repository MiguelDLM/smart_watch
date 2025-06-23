package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class LegacyTokenHelper {

    @OXOo.OOXIXo
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";

    @OXOo.OOXIXo
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";

    @OXOo.OOXIXo
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";

    @OXOo.OOXIXo
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;

    @OXOo.OOXIXo
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";

    @OXOo.OOXIXo
    private static final String JSON_VALUE = "value";

    @OXOo.OOXIXo
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";

    @OXOo.OOXIXo
    private static final String JSON_VALUE_TYPE = "valueType";

    @OXOo.OOXIXo
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";

    @OXOo.OOXIXo
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";

    @OXOo.OOXIXo
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";

    @OXOo.OOXIXo
    private static final String TYPE_BOOLEAN = "bool";

    @OXOo.OOXIXo
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";

    @OXOo.OOXIXo
    private static final String TYPE_BYTE = "byte";

    @OXOo.OOXIXo
    private static final String TYPE_BYTE_ARRAY = "byte[]";

    @OXOo.OOXIXo
    private static final String TYPE_CHAR = "char";

    @OXOo.OOXIXo
    private static final String TYPE_CHAR_ARRAY = "char[]";

    @OXOo.OOXIXo
    private static final String TYPE_DOUBLE = "double";

    @OXOo.OOXIXo
    private static final String TYPE_DOUBLE_ARRAY = "double[]";

    @OXOo.OOXIXo
    private static final String TYPE_ENUM = "enum";

    @OXOo.OOXIXo
    private static final String TYPE_FLOAT = "float";

    @OXOo.OOXIXo
    private static final String TYPE_FLOAT_ARRAY = "float[]";

    @OXOo.OOXIXo
    private static final String TYPE_INTEGER = "int";

    @OXOo.OOXIXo
    private static final String TYPE_INTEGER_ARRAY = "int[]";

    @OXOo.OOXIXo
    private static final String TYPE_LONG = "long";

    @OXOo.OOXIXo
    private static final String TYPE_LONG_ARRAY = "long[]";

    @OXOo.OOXIXo
    private static final String TYPE_SHORT = "short";

    @OXOo.OOXIXo
    private static final String TYPE_SHORT_ARRAY = "short[]";

    @OXOo.OOXIXo
    private static final String TYPE_STRING = "string";

    @OXOo.OOXIXo
    private static final String TYPE_STRING_LIST = "stringList";

    @OXOo.OOXIXo
    private final SharedPreferences cache;

    @OXOo.OOXIXo
    private final String cacheKey;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private final Date getDate(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j = bundle.getLong(str, Long.MIN_VALUE);
            if (j == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final String getApplicationId(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final Date getExpirationDate(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @XO0OX.x0XOIxOo
        public final long getExpirationMilliseconds(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final Date getLastRefreshDate(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @XO0OX.x0XOIxOo
        public final long getLastRefreshMilliseconds(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final Set<String> getPermissions(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AccessTokenSource getSource(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            if (bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY)) {
                return (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY);
            }
            if (bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY)) {
                return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            }
            return AccessTokenSource.WEB_VIEW;
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final String getToken(@OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @XO0OX.x0XOIxOo
        public final boolean hasTokenInformation(@OXOo.oOoXoXO Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null || string.length() == 0 || bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0L) == 0) {
                return false;
            }
            return true;
        }

        @XO0OX.x0XOIxOo
        public final void putApplicationId(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        @XO0OX.x0XOIxOo
        public final void putDeclinedPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @XO0OX.x0XOIxOo
        public final void putExpirationDate(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Date value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, value);
        }

        @XO0OX.x0XOIxOo
        public final void putExpirationMilliseconds(@OXOo.OOXIXo Bundle bundle, long j) {
            IIX0o.x0xO0oo(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j);
        }

        @XO0OX.x0XOIxOo
        public final void putExpiredPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @XO0OX.x0XOIxOo
        public final void putLastRefreshDate(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Date value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, value);
        }

        @XO0OX.x0XOIxOo
        public final void putLastRefreshMilliseconds(@OXOo.OOXIXo Bundle bundle, long j) {
            IIX0o.x0xO0oo(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j);
        }

        @XO0OX.x0XOIxOo
        public final void putPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @XO0OX.x0XOIxOo
        public final void putSource(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo AccessTokenSource value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, value);
        }

        @XO0OX.x0XOIxOo
        public final void putToken(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(value, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, value);
        }

        private Companion() {
        }
    }

    static {
        String simpleName = LegacyTokenHelper.class.getSimpleName();
        IIX0o.oO(simpleName, "LegacyTokenHelper::class.java.simpleName");
        TAG = simpleName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public LegacyTokenHelper(@OXOo.OOXIXo Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.cache.getString(str, "{}");
        if (string2 != null) {
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString(JSON_VALUE_TYPE);
            if (string3 != null) {
                int i = 0;
                switch (string3.hashCode()) {
                    case -1573317553:
                        if (string3.equals(TYPE_STRING_LIST)) {
                            JSONArray jSONArray = jSONObject.getJSONArray("value");
                            int length = jSONArray.length();
                            ArrayList<String> arrayList = new ArrayList<>(length);
                            if (length > 0) {
                                while (true) {
                                    int i2 = i + 1;
                                    Object obj = jSONArray.get(i);
                                    if (obj == JSONObject.NULL) {
                                        str2 = null;
                                    } else if (obj != null) {
                                        str2 = (String) obj;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    arrayList.add(i, str2);
                                    if (i2 < length) {
                                        i = i2;
                                    }
                                }
                            }
                            bundle.putStringArrayList(str, arrayList);
                            return;
                        }
                        return;
                    case -1383386164:
                        if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                            int length2 = jSONArray2.length();
                            boolean[] zArr = new boolean[length2];
                            int i3 = length2 - 1;
                            if (i3 >= 0) {
                                while (true) {
                                    int i4 = i + 1;
                                    zArr[i] = jSONArray2.getBoolean(i);
                                    if (i4 <= i3) {
                                        i = i4;
                                    }
                                }
                            }
                            bundle.putBooleanArray(str, zArr);
                            return;
                        }
                        return;
                    case -1374008726:
                        if (string3.equals(TYPE_BYTE_ARRAY)) {
                            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                            int length3 = jSONArray3.length();
                            byte[] bArr = new byte[length3];
                            int i5 = length3 - 1;
                            if (i5 >= 0) {
                                while (true) {
                                    int i6 = i + 1;
                                    bArr[i] = (byte) jSONArray3.getInt(i);
                                    if (i6 <= i5) {
                                        i = i6;
                                    }
                                }
                            }
                            bundle.putByteArray(str, bArr);
                            return;
                        }
                        return;
                    case -1361632968:
                        if (string3.equals(TYPE_CHAR_ARRAY)) {
                            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                            int length4 = jSONArray4.length();
                            char[] cArr = new char[length4];
                            int i7 = length4 - 1;
                            if (i7 >= 0) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8 + 1;
                                    String string4 = jSONArray4.getString(i8);
                                    if (string4 != null && string4.length() == 1) {
                                        cArr[i8] = string4.charAt(0);
                                    }
                                    if (i9 <= i7) {
                                        i8 = i9;
                                    }
                                }
                            }
                            bundle.putCharArray(str, cArr);
                            return;
                        }
                        return;
                    case -1325958191:
                        if (string3.equals(TYPE_DOUBLE)) {
                            bundle.putDouble(str, jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case -1097129250:
                        if (string3.equals(TYPE_LONG_ARRAY)) {
                            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                            int length5 = jSONArray5.length();
                            long[] jArr = new long[length5];
                            int i10 = length5 - 1;
                            if (i10 >= 0) {
                                while (true) {
                                    int i11 = i + 1;
                                    jArr[i] = jSONArray5.getLong(i);
                                    if (i11 <= i10) {
                                        i = i11;
                                    }
                                }
                            }
                            bundle.putLongArray(str, jArr);
                            return;
                        }
                        return;
                    case -891985903:
                        if (string3.equals("string")) {
                            bundle.putString(str, jSONObject.getString("value"));
                            return;
                        }
                        return;
                    case -766441794:
                        if (string3.equals(TYPE_FLOAT_ARRAY)) {
                            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                            int length6 = jSONArray6.length();
                            float[] fArr = new float[length6];
                            int i12 = length6 - 1;
                            if (i12 >= 0) {
                                while (true) {
                                    int i13 = i + 1;
                                    fArr[i] = (float) jSONArray6.getDouble(i);
                                    if (i13 <= i12) {
                                        i = i13;
                                    }
                                }
                            }
                            bundle.putFloatArray(str, fArr);
                            return;
                        }
                        return;
                    case 104431:
                        if (string3.equals("int")) {
                            bundle.putInt(str, jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3029738:
                        if (string3.equals(TYPE_BOOLEAN)) {
                            bundle.putBoolean(str, jSONObject.getBoolean("value"));
                            return;
                        }
                        return;
                    case 3039496:
                        if (string3.equals(TYPE_BYTE)) {
                            bundle.putByte(str, (byte) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3052374:
                        if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString("value")) != null && string.length() == 1) {
                            bundle.putChar(str, string.charAt(0));
                            return;
                        }
                        return;
                    case 3118337:
                        if (string3.equals(TYPE_ENUM)) {
                            try {
                                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
                                return;
                            } catch (ClassNotFoundException | IllegalArgumentException unused) {
                                return;
                            }
                        }
                        return;
                    case 3327612:
                        if (string3.equals(TYPE_LONG)) {
                            bundle.putLong(str, jSONObject.getLong("value"));
                            return;
                        }
                        return;
                    case 97526364:
                        if (string3.equals("float")) {
                            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case 100361105:
                        if (string3.equals(TYPE_INTEGER_ARRAY)) {
                            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                            int length7 = jSONArray7.length();
                            int[] iArr = new int[length7];
                            int i14 = length7 - 1;
                            if (i14 >= 0) {
                                while (true) {
                                    int i15 = i + 1;
                                    iArr[i] = jSONArray7.getInt(i);
                                    if (i15 <= i14) {
                                        i = i15;
                                    }
                                }
                            }
                            bundle.putIntArray(str, iArr);
                            return;
                        }
                        return;
                    case 109413500:
                        if (string3.equals(TYPE_SHORT)) {
                            bundle.putShort(str, (short) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 1359468275:
                        if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                            int length8 = jSONArray8.length();
                            double[] dArr = new double[length8];
                            int i16 = length8 - 1;
                            if (i16 >= 0) {
                                while (true) {
                                    int i17 = i + 1;
                                    dArr[i] = jSONArray8.getDouble(i);
                                    if (i17 <= i16) {
                                        i = i17;
                                    }
                                }
                            }
                            bundle.putDoubleArray(str, dArr);
                            return;
                        }
                        return;
                    case 2067161310:
                        if (string3.equals(TYPE_SHORT_ARRAY)) {
                            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                            int length9 = jSONArray9.length();
                            short[] sArr = new short[length9];
                            int i18 = length9 - 1;
                            if (i18 >= 0) {
                                while (true) {
                                    int i19 = i + 1;
                                    sArr[i] = (short) jSONArray9.getInt(i);
                                    if (i19 <= i18) {
                                        i = i19;
                                    }
                                }
                            }
                            bundle.putShortArray(str, sArr);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getApplicationId(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getApplicationId(bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Date getExpirationDate(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getExpirationDate(bundle);
    }

    @XO0OX.x0XOIxOo
    public static final long getExpirationMilliseconds(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getExpirationMilliseconds(bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Date getLastRefreshDate(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getLastRefreshDate(bundle);
    }

    @XO0OX.x0XOIxOo
    public static final long getLastRefreshMilliseconds(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getLastRefreshMilliseconds(bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Set<String> getPermissions(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getPermissions(bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AccessTokenSource getSource(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getSource(bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getToken(@OXOo.OOXIXo Bundle bundle) {
        return Companion.getToken(bundle);
    }

    @XO0OX.x0XOIxOo
    public static final boolean hasTokenInformation(@OXOo.oOoXoXO Bundle bundle) {
        return Companion.hasTokenInformation(bundle);
    }

    @XO0OX.x0XOIxOo
    public static final void putApplicationId(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) {
        Companion.putApplicationId(bundle, str);
    }

    @XO0OX.x0XOIxOo
    public static final void putDeclinedPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> collection) {
        Companion.putDeclinedPermissions(bundle, collection);
    }

    @XO0OX.x0XOIxOo
    public static final void putExpirationDate(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Date date) {
        Companion.putExpirationDate(bundle, date);
    }

    @XO0OX.x0XOIxOo
    public static final void putExpirationMilliseconds(@OXOo.OOXIXo Bundle bundle, long j) {
        Companion.putExpirationMilliseconds(bundle, j);
    }

    @XO0OX.x0XOIxOo
    public static final void putExpiredPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> collection) {
        Companion.putExpiredPermissions(bundle, collection);
    }

    @XO0OX.x0XOIxOo
    public static final void putLastRefreshDate(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Date date) {
        Companion.putLastRefreshDate(bundle, date);
    }

    @XO0OX.x0XOIxOo
    public static final void putLastRefreshMilliseconds(@OXOo.OOXIXo Bundle bundle, long j) {
        Companion.putLastRefreshMilliseconds(bundle, j);
    }

    @XO0OX.x0XOIxOo
    public static final void putPermissions(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo Collection<String> collection) {
        Companion.putPermissions(bundle, collection);
    }

    @XO0OX.x0XOIxOo
    public static final void putSource(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo AccessTokenSource accessTokenSource) {
        Companion.putSource(bundle, accessTokenSource);
    }

    @XO0OX.x0XOIxOo
    public static final void putToken(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String str) {
        Companion.putToken(bundle, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    @OXOo.oOoXoXO
    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String key : this.cache.getAll().keySet()) {
            try {
                IIX0o.oO(key, "key");
                deserializeKey(key, bundle);
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + ((Object) key) + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public final void save(@OXOo.OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "bundle");
        SharedPreferences.Editor editor = this.cache.edit();
        for (String key : bundle.keySet()) {
            try {
                IIX0o.oO(key, "key");
                IIX0o.oO(editor, "editor");
                serializeKey(key, bundle, editor);
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + ((Object) key) + "' -- " + e);
                return;
            }
        }
        editor.apply();
    }

    @XO0OX.xoIox
    public LegacyTokenHelper(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(context, "context");
        str = (str == null || str.length() == 0) ? DEFAULT_CACHE_KEY : str;
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        IIX0o.oO(sharedPreferences, "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)");
        this.cache = sharedPreferences;
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(context, (i & 2) != 0 ? null : str);
    }
}
