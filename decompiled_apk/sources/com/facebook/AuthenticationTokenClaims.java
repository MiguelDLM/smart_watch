package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XxX0x0xxx;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AuthenticationTokenClaims implements Parcelable {

    @OXOo.OOXIXo
    public static final String JSON_KEY_AUD = "aud";

    @OXOo.OOXIXo
    public static final String JSON_KEY_EMAIL = "email";

    @OXOo.OOXIXo
    public static final String JSON_KEY_EXP = "exp";

    @OXOo.OOXIXo
    public static final String JSON_KEY_FAMILY_NAME = "family_name";

    @OXOo.OOXIXo
    public static final String JSON_KEY_GIVEN_NAME = "given_name";

    @OXOo.OOXIXo
    public static final String JSON_KEY_IAT = "iat";

    @OXOo.OOXIXo
    public static final String JSON_KEY_ISS = "iss";

    @OXOo.OOXIXo
    public static final String JSON_KEY_JIT = "jti";

    @OXOo.OOXIXo
    public static final String JSON_KEY_MIDDLE_NAME = "middle_name";

    @OXOo.OOXIXo
    public static final String JSON_KEY_NAME = "name";

    @OXOo.OOXIXo
    public static final String JSON_KEY_NONCE = "nonce";

    @OXOo.OOXIXo
    public static final String JSON_KEY_PICTURE = "picture";

    @OXOo.OOXIXo
    public static final String JSON_KEY_SUB = "sub";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_AGE_RANGE = "user_age_range";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_BIRTHDAY = "user_birthday";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_FRIENDS = "user_friends";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_GENDER = "user_gender";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_HOMETOWN = "user_hometown";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_LINK = "user_link";

    @OXOo.OOXIXo
    public static final String JSON_KEY_USER_LOCATION = "user_location";
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000;

    @OXOo.OOXIXo
    private final String aud;

    @OXOo.oOoXoXO
    private final String email;
    private final long exp;

    @OXOo.oOoXoXO
    private final String familyName;

    @OXOo.oOoXoXO
    private final String givenName;
    private final long iat;

    @OXOo.OOXIXo
    private final String iss;

    @OXOo.OOXIXo
    private final String jti;

    @OXOo.oOoXoXO
    private final String middleName;

    @OXOo.oOoXoXO
    private final String name;

    @OXOo.OOXIXo
    private final String nonce;

    @OXOo.oOoXoXO
    private final String picture;

    @OXOo.OOXIXo
    private final String sub;

    @OXOo.oOoXoXO
    private final Map<String, Integer> userAgeRange;

    @OXOo.oOoXoXO
    private final String userBirthday;

    @OXOo.oOoXoXO
    private final Set<String> userFriends;

    @OXOo.oOoXoXO
    private final String userGender;

    @OXOo.oOoXoXO
    private final Map<String, String> userHometown;

    @OXOo.oOoXoXO
    private final String userLink;

    @OXOo.oOoXoXO
    private final Map<String, String> userLocation;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new Parcelable.Creator<AuthenticationTokenClaims>() { // from class: com.facebook.AuthenticationTokenClaims$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationTokenClaims createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new AuthenticationTokenClaims(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public AuthenticationTokenClaims[] newArray(int i) {
            return new AuthenticationTokenClaims[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(@OXOo.OOXIXo JSONObject jsonObject) throws JSONException {
            List<String> jsonArrayToStringList;
            Map<String, Object> convertJSONObjectToHashMap;
            Map<String, String> convertJSONObjectToStringMap;
            IIX0o.x0xO0oo(jsonObject, "jsonObject");
            String jti = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_JIT);
            String iss = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_ISS);
            String aud = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_AUD);
            String nonce = jsonObject.getString("nonce");
            long j = jsonObject.getLong(AuthenticationTokenClaims.JSON_KEY_EXP);
            long j2 = jsonObject.getLong(AuthenticationTokenClaims.JSON_KEY_IAT);
            String sub = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_SUB);
            String nullableString$facebook_core_release = getNullableString$facebook_core_release(jsonObject, "name");
            String nullableString$facebook_core_release2 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_GIVEN_NAME);
            String nullableString$facebook_core_release3 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
            String nullableString$facebook_core_release4 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_FAMILY_NAME);
            String nullableString$facebook_core_release5 = getNullableString$facebook_core_release(jsonObject, "email");
            String nullableString$facebook_core_release6 = getNullableString$facebook_core_release(jsonObject, "picture");
            JSONArray optJSONArray = jsonObject.optJSONArray(AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS);
            String nullableString$facebook_core_release7 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_BIRTHDAY);
            JSONObject optJSONObject = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_AGE_RANGE);
            JSONObject optJSONObject2 = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_HOMETOWN);
            JSONObject optJSONObject3 = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION);
            String nullableString$facebook_core_release8 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_GENDER);
            String nullableString$facebook_core_release9 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_LINK);
            IIX0o.oO(jti, "jti");
            IIX0o.oO(iss, "iss");
            IIX0o.oO(aud, "aud");
            IIX0o.oO(nonce, "nonce");
            IIX0o.oO(sub, "sub");
            Map<String, String> map = null;
            if (optJSONArray == null) {
                jsonArrayToStringList = null;
            } else {
                Utility utility = Utility.INSTANCE;
                jsonArrayToStringList = Utility.jsonArrayToStringList(optJSONArray);
            }
            List<String> list = jsonArrayToStringList;
            if (optJSONObject == null) {
                convertJSONObjectToHashMap = null;
            } else {
                Utility utility2 = Utility.INSTANCE;
                convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(optJSONObject);
            }
            if (optJSONObject2 == null) {
                convertJSONObjectToStringMap = null;
            } else {
                Utility utility3 = Utility.INSTANCE;
                convertJSONObjectToStringMap = Utility.convertJSONObjectToStringMap(optJSONObject2);
            }
            if (optJSONObject3 != null) {
                Utility utility4 = Utility.INSTANCE;
                map = Utility.convertJSONObjectToStringMap(optJSONObject3);
            }
            return new AuthenticationTokenClaims(jti, iss, aud, nonce, j, j2, sub, nullableString$facebook_core_release, nullableString$facebook_core_release2, nullableString$facebook_core_release3, nullableString$facebook_core_release4, nullableString$facebook_core_release5, nullableString$facebook_core_release6, list, nullableString$facebook_core_release7, convertJSONObjectToHashMap, convertJSONObjectToStringMap, map, nullableString$facebook_core_release8, nullableString$facebook_core_release9);
        }

        @OXOo.oOoXoXO
        public final String getNullableString$facebook_core_release(@OXOo.OOXIXo JSONObject jSONObject, @OXOo.OOXIXo String name) {
            IIX0o.x0xO0oo(jSONObject, "<this>");
            IIX0o.x0xO0oo(name, "name");
            if (jSONObject.has(name)) {
                return jSONObject.getString(name);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub) {
        this(jti, iss, aud, nonce, j, j2, sub, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048448, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(new java.net.URL(r2).getHost(), "www.facebook.com") == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isValidClaims(org.json.JSONObject r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "iss"
            r1 = 0
            if (r7 != 0) goto L6
            return r1
        L6:
            java.lang.String r2 = "jti"
            java.lang.String r3 = r7.optString(r2)
            kotlin.jvm.internal.IIX0o.oO(r3, r2)
            int r2 = r3.length()
            if (r2 != 0) goto L16
            return r1
        L16:
            java.lang.String r2 = r7.optString(r0)     // Catch: java.net.MalformedURLException -> Lc7
            kotlin.jvm.internal.IIX0o.oO(r2, r0)     // Catch: java.net.MalformedURLException -> Lc7
            int r0 = r2.length()     // Catch: java.net.MalformedURLException -> Lc7
            if (r0 != 0) goto L24
            goto L47
        L24:
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> Lc7
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> Lc7
            java.lang.String r0 = r0.getHost()     // Catch: java.net.MalformedURLException -> Lc7
            java.lang.String r3 = "facebook.com"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r3)     // Catch: java.net.MalformedURLException -> Lc7
            if (r0 != 0) goto L48
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> Lc7
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> Lc7
            java.lang.String r0 = r0.getHost()     // Catch: java.net.MalformedURLException -> Lc7
            java.lang.String r2 = "www.facebook.com"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r2)     // Catch: java.net.MalformedURLException -> Lc7
            if (r0 != 0) goto L48
        L47:
            return r1
        L48:
            java.lang.String r0 = "aud"
            java.lang.String r2 = r7.optString(r0)
            kotlin.jvm.internal.IIX0o.oO(r2, r0)
            int r0 = r2.length()
            if (r0 != 0) goto L58
            goto L64
        L58:
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r2, r0)
            if (r0 != 0) goto L65
        L64:
            return r1
        L65:
            java.util.Date r0 = new java.util.Date
            java.lang.String r2 = "exp"
            long r2 = r7.optLong(r2)
            r4 = 1000(0x3e8, float:1.401E-42)
            long r4 = (long) r4
            long r2 = r2 * r4
            r0.<init>(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            boolean r0 = r2.after(r0)
            if (r0 == 0) goto L81
            return r1
        L81:
            java.lang.String r0 = "iat"
            long r2 = r7.optLong(r0)
            java.util.Date r0 = new java.util.Date
            long r2 = r2 * r4
            r4 = 600000(0x927c0, double:2.964394E-318)
            long r2 = r2 + r4
            r0.<init>(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            boolean r0 = r2.after(r0)
            if (r0 == 0) goto L9e
            return r1
        L9e:
            java.lang.String r0 = "sub"
            java.lang.String r2 = r7.optString(r0)
            kotlin.jvm.internal.IIX0o.oO(r2, r0)
            int r0 = r2.length()
            if (r0 != 0) goto Lae
            return r1
        Lae:
            java.lang.String r0 = "nonce"
            java.lang.String r7 = r7.optString(r0)
            kotlin.jvm.internal.IIX0o.oO(r7, r0)
            int r0 = r7.length()
            if (r0 != 0) goto Lbe
            goto Lc4
        Lbe:
            boolean r7 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r7, r8)
            if (r7 != 0) goto Lc5
        Lc4:
            return r1
        Lc5:
            r7 = 1
            return r7
        Lc7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.isValidClaims(org.json.JSONObject, java.lang.String):boolean");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        if (IIX0o.Oxx0IOOO(this.jti, authenticationTokenClaims.jti) && IIX0o.Oxx0IOOO(this.iss, authenticationTokenClaims.iss) && IIX0o.Oxx0IOOO(this.aud, authenticationTokenClaims.aud) && IIX0o.Oxx0IOOO(this.nonce, authenticationTokenClaims.nonce) && this.exp == authenticationTokenClaims.exp && this.iat == authenticationTokenClaims.iat && IIX0o.Oxx0IOOO(this.sub, authenticationTokenClaims.sub) && IIX0o.Oxx0IOOO(this.name, authenticationTokenClaims.name) && IIX0o.Oxx0IOOO(this.givenName, authenticationTokenClaims.givenName) && IIX0o.Oxx0IOOO(this.middleName, authenticationTokenClaims.middleName) && IIX0o.Oxx0IOOO(this.familyName, authenticationTokenClaims.familyName) && IIX0o.Oxx0IOOO(this.email, authenticationTokenClaims.email) && IIX0o.Oxx0IOOO(this.picture, authenticationTokenClaims.picture) && IIX0o.Oxx0IOOO(this.userFriends, authenticationTokenClaims.userFriends) && IIX0o.Oxx0IOOO(this.userBirthday, authenticationTokenClaims.userBirthday) && IIX0o.Oxx0IOOO(this.userAgeRange, authenticationTokenClaims.userAgeRange) && IIX0o.Oxx0IOOO(this.userHometown, authenticationTokenClaims.userHometown) && IIX0o.Oxx0IOOO(this.userLocation, authenticationTokenClaims.userLocation) && IIX0o.Oxx0IOOO(this.userGender, authenticationTokenClaims.userGender) && IIX0o.Oxx0IOOO(this.userLink, authenticationTokenClaims.userLink)) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final String getAud() {
        return this.aud;
    }

    @OXOo.oOoXoXO
    public final String getEmail() {
        return this.email;
    }

    public final long getExp() {
        return this.exp;
    }

    @OXOo.oOoXoXO
    public final String getFamilyName() {
        return this.familyName;
    }

    @OXOo.oOoXoXO
    public final String getGivenName() {
        return this.givenName;
    }

    public final long getIat() {
        return this.iat;
    }

    @OXOo.OOXIXo
    public final String getIss() {
        return this.iss;
    }

    @OXOo.OOXIXo
    public final String getJti() {
        return this.jti;
    }

    @OXOo.oOoXoXO
    public final String getMiddleName() {
        return this.middleName;
    }

    @OXOo.oOoXoXO
    public final String getName() {
        return this.name;
    }

    @OXOo.OOXIXo
    public final String getNonce() {
        return this.nonce;
    }

    @OXOo.oOoXoXO
    public final String getPicture() {
        return this.picture;
    }

    @OXOo.OOXIXo
    public final String getSub() {
        return this.sub;
    }

    @OXOo.oOoXoXO
    public final Map<String, Integer> getUserAgeRange() {
        return this.userAgeRange;
    }

    @OXOo.oOoXoXO
    public final String getUserBirthday() {
        return this.userBirthday;
    }

    @OXOo.oOoXoXO
    public final Set<String> getUserFriends() {
        return this.userFriends;
    }

    @OXOo.oOoXoXO
    public final String getUserGender() {
        return this.userGender;
    }

    @OXOo.oOoXoXO
    public final Map<String, String> getUserHometown() {
        return this.userHometown;
    }

    @OXOo.oOoXoXO
    public final String getUserLink() {
        return this.userLink;
    }

    @OXOo.oOoXoXO
    public final Map<String, String> getUserLocation() {
        return this.userLocation;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13 = (((((((((((((527 + this.jti.hashCode()) * 31) + this.iss.hashCode()) * 31) + this.aud.hashCode()) * 31) + this.nonce.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.exp)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.iat)) * 31) + this.sub.hashCode()) * 31;
        String str = this.name;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i2 = (hashCode13 + hashCode) * 31;
        String str2 = this.givenName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i3 = (i2 + hashCode2) * 31;
        String str3 = this.middleName;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i4 = (i3 + hashCode3) * 31;
        String str4 = this.familyName;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i5 = (i4 + hashCode4) * 31;
        String str5 = this.email;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i6 = (i5 + hashCode5) * 31;
        String str6 = this.picture;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i7 = (i6 + hashCode6) * 31;
        Set<String> set = this.userFriends;
        if (set == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = set.hashCode();
        }
        int i8 = (i7 + hashCode7) * 31;
        String str7 = this.userBirthday;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i9 = (i8 + hashCode8) * 31;
        Map<String, Integer> map = this.userAgeRange;
        if (map == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = map.hashCode();
        }
        int i10 = (i9 + hashCode9) * 31;
        Map<String, String> map2 = this.userHometown;
        if (map2 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = map2.hashCode();
        }
        int i11 = (i10 + hashCode10) * 31;
        Map<String, String> map3 = this.userLocation;
        if (map3 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = map3.hashCode();
        }
        int i12 = (i11 + hashCode11) * 31;
        String str8 = this.userGender;
        if (str8 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = str8.hashCode();
        }
        int i13 = (i12 + hashCode12) * 31;
        String str9 = this.userLink;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return i13 + i;
    }

    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final String toEnCodedString() {
        String authenticationTokenClaims = toString();
        Charset charset = kotlin.text.oxoX.f29581II0xO0;
        if (authenticationTokenClaims != null) {
            byte[] bytes = authenticationTokenClaims.getBytes(charset);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 8);
            IIX0o.oO(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.URL_SAFE)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JSON_KEY_JIT, this.jti);
        jSONObject.put(JSON_KEY_ISS, this.iss);
        jSONObject.put(JSON_KEY_AUD, this.aud);
        jSONObject.put("nonce", this.nonce);
        jSONObject.put(JSON_KEY_EXP, this.exp);
        jSONObject.put(JSON_KEY_IAT, this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put(JSON_KEY_SUB, str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put(JSON_KEY_GIVEN_NAME, str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put(JSON_KEY_MIDDLE_NAME, str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put(JSON_KEY_FAMILY_NAME, str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.userFriends != null) {
            jSONObject.put(JSON_KEY_USER_FRIENDS, new JSONArray((Collection) this.userFriends));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put(JSON_KEY_USER_BIRTHDAY, str8);
        }
        if (this.userAgeRange != null) {
            jSONObject.put(JSON_KEY_USER_AGE_RANGE, new JSONObject(this.userAgeRange));
        }
        if (this.userHometown != null) {
            jSONObject.put(JSON_KEY_USER_HOMETOWN, new JSONObject(this.userHometown));
        }
        if (this.userLocation != null) {
            jSONObject.put(JSON_KEY_USER_LOCATION, new JSONObject(this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put(JSON_KEY_USER_GENDER, str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put(JSON_KEY_USER_LINK, str10);
        }
        return jSONObject;
    }

    @OXOo.OOXIXo
    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        IIX0o.oO(jSONObject, "claimsJsonObject.toString()");
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.jti);
        dest.writeString(this.iss);
        dest.writeString(this.aud);
        dest.writeString(this.nonce);
        dest.writeLong(this.exp);
        dest.writeLong(this.iat);
        dest.writeString(this.sub);
        dest.writeString(this.name);
        dest.writeString(this.givenName);
        dest.writeString(this.middleName);
        dest.writeString(this.familyName);
        dest.writeString(this.email);
        dest.writeString(this.picture);
        if (this.userFriends == null) {
            dest.writeStringList(null);
        } else {
            dest.writeStringList(new ArrayList(this.userFriends));
        }
        dest.writeString(this.userBirthday);
        dest.writeMap(this.userAgeRange);
        dest.writeMap(this.userHometown);
        dest.writeMap(this.userLocation);
        dest.writeString(this.userGender);
        dest.writeString(this.userLink);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str) {
        this(jti, iss, aud, nonce, j, j2, sub, str, null, null, null, null, null, null, null, null, null, null, null, null, 1048320, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, null, null, null, null, null, null, null, null, null, null, null, 1048064, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, null, null, null, null, null, null, null, null, null, null, 1047552, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, null, null, null, null, null, null, null, null, null, 1046528, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, null, null, null, null, null, null, null, null, 1044480, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, null, null, null, null, null, null, null, 1040384, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, null, null, null, null, null, null, 1032192, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, str7, null, null, null, null, null, 1015808, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO Map<String, Integer> map) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, str7, map, null, null, null, null, 983040, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO Map<String, Integer> map, @OXOo.oOoXoXO Map<String, String> map2) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, null, null, null, 917504, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO Map<String, Integer> map, @OXOo.oOoXoXO Map<String, String> map2, @OXOo.oOoXoXO Map<String, String> map3) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, map3, null, null, 786432, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO Map<String, Integer> map, @OXOo.oOoXoXO Map<String, String> map2, @OXOo.oOoXoXO Map<String, String> map3, @OXOo.oOoXoXO String str8) {
        this(jti, iss, aud, nonce, j, j2, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, map3, str8, null, 524288, null);
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
    }

    @XO0OX.xoIox
    public AuthenticationTokenClaims(@OXOo.OOXIXo String encodedClaims, @OXOo.OOXIXo String expectedNonce) {
        Set<String> unmodifiableSet;
        Map<String, Integer> unmodifiableMap;
        Map<String, String> unmodifiableMap2;
        IIX0o.x0xO0oo(encodedClaims, "encodedClaims");
        IIX0o.x0xO0oo(expectedNonce, "expectedNonce");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(encodedClaims, "encodedClaims");
        byte[] decodedBytes = Base64.decode(encodedClaims, 8);
        IIX0o.oO(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, kotlin.text.oxoX.f29581II0xO0));
        if (isValidClaims(jSONObject, expectedNonce)) {
            String string = jSONObject.getString(JSON_KEY_JIT);
            IIX0o.oO(string, "jsonObj.getString(JSON_KEY_JIT)");
            this.jti = string;
            String string2 = jSONObject.getString(JSON_KEY_ISS);
            IIX0o.oO(string2, "jsonObj.getString(JSON_KEY_ISS)");
            this.iss = string2;
            String string3 = jSONObject.getString(JSON_KEY_AUD);
            IIX0o.oO(string3, "jsonObj.getString(JSON_KEY_AUD)");
            this.aud = string3;
            String string4 = jSONObject.getString("nonce");
            IIX0o.oO(string4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.nonce = string4;
            this.exp = jSONObject.getLong(JSON_KEY_EXP);
            this.iat = jSONObject.getLong(JSON_KEY_IAT);
            String string5 = jSONObject.getString(JSON_KEY_SUB);
            IIX0o.oO(string5, "jsonObj.getString(JSON_KEY_SUB)");
            this.sub = string5;
            Companion companion = Companion;
            this.name = companion.getNullableString$facebook_core_release(jSONObject, "name");
            this.givenName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_GIVEN_NAME);
            this.middleName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_MIDDLE_NAME);
            this.familyName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_FAMILY_NAME);
            this.email = companion.getNullableString$facebook_core_release(jSONObject, "email");
            this.picture = companion.getNullableString$facebook_core_release(jSONObject, "picture");
            JSONArray optJSONArray = jSONObject.optJSONArray(JSON_KEY_USER_FRIENDS);
            Map<String, String> map = null;
            if (optJSONArray == null) {
                unmodifiableSet = null;
            } else {
                Utility utility = Utility.INSTANCE;
                unmodifiableSet = Collections.unmodifiableSet(Utility.jsonArrayToSet(optJSONArray));
            }
            this.userFriends = unmodifiableSet;
            this.userBirthday = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_BIRTHDAY);
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_USER_AGE_RANGE);
            if (optJSONObject == null) {
                unmodifiableMap = null;
            } else {
                Utility utility2 = Utility.INSTANCE;
                unmodifiableMap = Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(optJSONObject));
            }
            this.userAgeRange = unmodifiableMap;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(JSON_KEY_USER_HOMETOWN);
            if (optJSONObject2 == null) {
                unmodifiableMap2 = null;
            } else {
                Utility utility3 = Utility.INSTANCE;
                unmodifiableMap2 = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject2));
            }
            this.userHometown = unmodifiableMap2;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(JSON_KEY_USER_LOCATION);
            if (optJSONObject3 != null) {
                Utility utility4 = Utility.INSTANCE;
                map = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject3));
            }
            this.userLocation = map;
            this.userGender = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_GENDER);
            this.userLink = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_LINK);
            return;
        }
        throw new IllegalArgumentException("Invalid claims");
    }

    public /* synthetic */ AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection collection, String str12, Map map, Map map2, Map map3, String str13, String str14, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, str2, str3, str4, j, j2, str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : collection, (i & 16384) != 0 ? null : str12, (32768 & i) != 0 ? null : map, (65536 & i) != 0 ? null : map2, (131072 & i) != 0 ? null : map3, (262144 & i) != 0 ? null : str13, (i & 524288) != 0 ? null : str14);
    }

    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenClaims(@OXOo.OOXIXo String jti, @OXOo.OOXIXo String iss, @OXOo.OOXIXo String aud, @OXOo.OOXIXo String nonce, long j, long j2, @OXOo.OOXIXo String sub, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO Map<String, Integer> map, @OXOo.oOoXoXO Map<String, String> map2, @OXOo.oOoXoXO Map<String, String> map3, @OXOo.oOoXoXO String str8, @OXOo.oOoXoXO String str9) {
        IIX0o.x0xO0oo(jti, "jti");
        IIX0o.x0xO0oo(iss, "iss");
        IIX0o.x0xO0oo(aud, "aud");
        IIX0o.x0xO0oo(nonce, "nonce");
        IIX0o.x0xO0oo(sub, "sub");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(jti, JSON_KEY_JIT);
        Validate.notEmpty(iss, JSON_KEY_ISS);
        Validate.notEmpty(aud, JSON_KEY_AUD);
        Validate.notEmpty(nonce, "nonce");
        Validate.notEmpty(sub, JSON_KEY_SUB);
        this.jti = jti;
        this.iss = iss;
        this.aud = aud;
        this.nonce = nonce;
        this.exp = j;
        this.iat = j2;
        this.sub = sub;
        this.name = str;
        this.givenName = str2;
        this.middleName = str3;
        this.familyName = str4;
        this.email = str5;
        this.picture = str6;
        this.userFriends = collection != null ? Collections.unmodifiableSet(new HashSet(collection)) : null;
        this.userBirthday = str7;
        this.userAgeRange = map != null ? Collections.unmodifiableMap(new HashMap(map)) : null;
        this.userHometown = map2 != null ? Collections.unmodifiableMap(new HashMap(map2)) : null;
        this.userLocation = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
        this.userGender = str8;
        this.userLink = str9;
    }

    public AuthenticationTokenClaims(@OXOo.OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.jti = Validate.notNullOrEmpty(readString, JSON_KEY_JIT);
        this.iss = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_ISS);
        this.aud = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_AUD);
        this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        this.sub = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_SUB);
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.userFriends = createStringArrayList != null ? Collections.unmodifiableSet(new HashSet(createStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(XxX0x0xxx.f29326oIX0oI.getClass().getClassLoader());
        readHashMap = readHashMap instanceof HashMap ? readHashMap : null;
        this.userAgeRange = readHashMap != null ? Collections.unmodifiableMap(readHashMap) : null;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        HashMap readHashMap2 = parcel.readHashMap(oxxxoxo.getClass().getClassLoader());
        readHashMap2 = readHashMap2 instanceof HashMap ? readHashMap2 : null;
        this.userHometown = readHashMap2 != null ? Collections.unmodifiableMap(readHashMap2) : null;
        HashMap readHashMap3 = parcel.readHashMap(oxxxoxo.getClass().getClassLoader());
        readHashMap3 = readHashMap3 instanceof HashMap ? readHashMap3 : null;
        this.userLocation = readHashMap3 != null ? Collections.unmodifiableMap(readHashMap3) : null;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }
}
