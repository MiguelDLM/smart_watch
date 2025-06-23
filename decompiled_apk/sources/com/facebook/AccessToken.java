package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.LegacyTokenHelper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.huawei.openalliance.ad.constant.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AccessToken implements Parcelable {

    @OXOo.OOXIXo
    public static final String ACCESS_TOKEN_KEY = "access_token";

    @OXOo.OOXIXo
    private static final String APPLICATION_ID_KEY = "application_id";

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<AccessToken> CREATOR;
    private static final int CURRENT_JSON_FORMAT = 1;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";

    @OXOo.OOXIXo
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";

    @OXOo.OOXIXo
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE;

    @OXOo.OOXIXo
    private static final Date DEFAULT_EXPIRATION_TIME;

    @OXOo.OOXIXo
    public static final String DEFAULT_GRAPH_DOMAIN = "facebook";

    @OXOo.OOXIXo
    private static final Date DEFAULT_LAST_REFRESH_TIME;

    @OXOo.OOXIXo
    private static final String EXPIRED_PERMISSIONS_KEY = "expired_permissions";

    @OXOo.OOXIXo
    private static final String EXPIRES_AT_KEY = "expires_at";

    @OXOo.OOXIXo
    public static final String EXPIRES_IN_KEY = "expires_in";

    @OXOo.OOXIXo
    public static final String GRAPH_DOMAIN = "graph_domain";

    @OXOo.OOXIXo
    private static final String LAST_REFRESH_KEY = "last_refresh";

    @OXOo.OOXIXo
    private static final Date MAX_DATE;

    @OXOo.OOXIXo
    private static final String PERMISSIONS_KEY = "permissions";

    @OXOo.OOXIXo
    private static final String SOURCE_KEY = "source";

    @OXOo.OOXIXo
    private static final String TOKEN_KEY = "token";

    @OXOo.OOXIXo
    public static final String USER_ID_KEY = "user_id";

    @OXOo.OOXIXo
    private static final String VERSION_KEY = "version";

    @OXOo.OOXIXo
    private final String applicationId;

    @OXOo.OOXIXo
    private final Date dataAccessExpirationTime;

    @OXOo.OOXIXo
    private final Set<String> declinedPermissions;

    @OXOo.OOXIXo
    private final Set<String> expiredPermissions;

    @OXOo.OOXIXo
    private final Date expires;

    @OXOo.oOoXoXO
    private final String graphDomain;

    @OXOo.OOXIXo
    private final Date lastRefresh;

    @OXOo.OOXIXo
    private final Set<String> permissions;

    @OXOo.OOXIXo
    private final AccessTokenSource source;

    @OXOo.OOXIXo
    private final String token;

    @OXOo.OOXIXo
    private final String userId;

    /* loaded from: classes8.dex */
    public interface AccessTokenCreationCallback {
        void onError(@OXOo.oOoXoXO FacebookException facebookException);

        void onSuccess(@OXOo.oOoXoXO AccessToken accessToken);
    }

    /* loaded from: classes8.dex */
    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(@OXOo.oOoXoXO FacebookException facebookException);

        void OnTokenRefreshed(@OXOo.oOoXoXO AccessToken accessToken);
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
            String string;
            String string2 = bundle.getString("access_token");
            if (string2 == null) {
                return null;
            }
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", date);
            if (bundleLongAsDate == null || (string = bundle.getString("user_id")) == null) {
                return null;
            }
            return new AccessToken(string2, str, string, list, null, null, accessTokenSource, bundleLongAsDate, new Date(), Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0L)), null, 1024, null);
        }

        @OXOo.OOXIXo
        public final AccessToken createExpired$facebook_core_release(@OXOo.OOXIXo AccessToken current) {
            IIX0o.x0xO0oo(current, "current");
            return new AccessToken(current.getToken(), current.getApplicationId(), current.getUserId(), current.getPermissions(), current.getDeclinedPermissions(), current.getExpiredPermissions(), current.getSource(), new Date(), new Date(), current.getDataAccessExpirationTime(), null, 1024, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AccessToken createFromJSONObject$facebook_core_release(@OXOo.OOXIXo JSONObject jsonObject) throws JSONException {
            Collection jsonArrayToStringList;
            IIX0o.x0xO0oo(jsonObject, "jsonObject");
            if (jsonObject.getInt("version") <= 1) {
                String token = jsonObject.getString("token");
                Date date = new Date(jsonObject.getLong(AccessToken.EXPIRES_AT_KEY));
                JSONArray permissionsArray = jsonObject.getJSONArray("permissions");
                JSONArray declinedPermissionsArray = jsonObject.getJSONArray(AccessToken.DECLINED_PERMISSIONS_KEY);
                JSONArray optJSONArray = jsonObject.optJSONArray(AccessToken.EXPIRED_PERMISSIONS_KEY);
                Date date2 = new Date(jsonObject.getLong(AccessToken.LAST_REFRESH_KEY));
                String string = jsonObject.getString("source");
                IIX0o.oO(string, "jsonObject.getString(SOURCE_KEY)");
                AccessTokenSource valueOf = AccessTokenSource.valueOf(string);
                String applicationId = jsonObject.getString(AccessToken.APPLICATION_ID_KEY);
                String userId = jsonObject.getString("user_id");
                Date date3 = new Date(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME, 0L));
                String optString = jsonObject.optString("graph_domain", null);
                IIX0o.oO(token, "token");
                IIX0o.oO(applicationId, "applicationId");
                IIX0o.oO(userId, "userId");
                Utility utility = Utility.INSTANCE;
                IIX0o.oO(permissionsArray, "permissionsArray");
                List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(permissionsArray);
                IIX0o.oO(declinedPermissionsArray, "declinedPermissionsArray");
                List<String> jsonArrayToStringList3 = Utility.jsonArrayToStringList(declinedPermissionsArray);
                if (optJSONArray == null) {
                    jsonArrayToStringList = new ArrayList();
                } else {
                    jsonArrayToStringList = Utility.jsonArrayToStringList(optJSONArray);
                }
                return new AccessToken(token, applicationId, userId, jsonArrayToStringList2, jsonArrayToStringList3, jsonArrayToStringList, valueOf, date, date2, date3, optString);
            }
            throw new FacebookException("Unknown AccessToken serialization format.");
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AccessToken createFromLegacyCache$facebook_core_release(@OXOo.OOXIXo Bundle bundle) {
            String string;
            IIX0o.x0xO0oo(bundle, "bundle");
            List<String> permissionsFromBundle$facebook_core_release = getPermissionsFromBundle$facebook_core_release(bundle, LegacyTokenHelper.PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release2 = getPermissionsFromBundle$facebook_core_release(bundle, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release3 = getPermissionsFromBundle$facebook_core_release(bundle, LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY);
            LegacyTokenHelper.Companion companion = LegacyTokenHelper.Companion;
            String applicationId = companion.getApplicationId(bundle);
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(applicationId)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                applicationId = FacebookSdk.getApplicationId();
            }
            String str = applicationId;
            String token = companion.getToken(bundle);
            if (token == null) {
                return null;
            }
            JSONObject awaitGetGraphMeRequestWithCache = Utility.awaitGetGraphMeRequestWithCache(token);
            if (awaitGetGraphMeRequestWithCache == null) {
                string = null;
            } else {
                try {
                    string = awaitGetGraphMeRequestWithCache.getString("id");
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (str == null || string == null) {
                return null;
            }
            return new AccessToken(token, str, string, permissionsFromBundle$facebook_core_release, permissionsFromBundle$facebook_core_release2, permissionsFromBundle$facebook_core_release3, companion.getSource(bundle), companion.getExpirationDate(bundle), companion.getLastRefreshDate(bundle), null, null, 1024, null);
        }

        @XO0OX.x0XOIxOo
        public final void createFromNativeLinkingIntent(@OXOo.OOXIXo Intent intent, @OXOo.OOXIXo final String applicationId, @OXOo.OOXIXo final AccessTokenCreationCallback accessTokenCallback) {
            IIX0o.x0xO0oo(intent, "intent");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(accessTokenCallback, "accessTokenCallback");
            if (intent.getExtras() == null) {
                accessTokenCallback.onError(new FacebookException("No extras found on intent"));
                return;
            }
            final Bundle bundle = new Bundle(intent.getExtras());
            String string = bundle.getString("access_token");
            if (string != null && string.length() != 0) {
                String string2 = bundle.getString("user_id");
                if (string2 != null && string2.length() != 0) {
                    accessTokenCallback.onSuccess(createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), applicationId));
                    return;
                } else {
                    Utility utility = Utility.INSTANCE;
                    Utility.getGraphMeRequestWithCacheAsync(string, new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.AccessToken$Companion$createFromNativeLinkingIntent$1
                        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                        public void onFailure(@OXOo.oOoXoXO FacebookException facebookException) {
                            accessTokenCallback.onError(facebookException);
                        }

                        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                        public void onSuccess(@OXOo.oOoXoXO JSONObject jSONObject) {
                            String string3;
                            AccessToken createFromBundle;
                            if (jSONObject == null) {
                                string3 = null;
                            } else {
                                try {
                                    string3 = jSONObject.getString("id");
                                } catch (Exception unused) {
                                    accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                                    return;
                                }
                            }
                            if (string3 != null) {
                                bundle.putString("user_id", string3);
                                AccessToken.AccessTokenCreationCallback accessTokenCreationCallback = accessTokenCallback;
                                createFromBundle = AccessToken.Companion.createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), applicationId);
                                accessTokenCreationCallback.onSuccess(createFromBundle);
                                return;
                            }
                            throw new IllegalStateException("Required value was null.");
                        }
                    });
                    return;
                }
            }
            accessTokenCallback.onError(new FacebookException("No access token found on intent"));
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        @SuppressLint({"FieldGetter"})
        public final AccessToken createFromRefresh$facebook_core_release(@OXOo.OOXIXo AccessToken current, @OXOo.OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(current, "current");
            IIX0o.x0xO0oo(bundle, "bundle");
            if (current.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_WEB && current.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE && current.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
                throw new FacebookException(IIX0o.XIxXXX0x0("Invalid token source: ", current.getSource()));
            }
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date(0L));
            String string = bundle.getString("access_token");
            if (string == null) {
                return null;
            }
            String string2 = bundle.getString("graph_domain");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, current.getApplicationId(), current.getUserId(), current.getPermissions(), current.getDeclinedPermissions(), current.getExpiredPermissions(), current.getSource(), bundleLongAsDate, new Date(), bundleLongAsDate2, string2);
        }

        @XO0OX.x0XOIxOo
        public final void expireCurrentAccessToken() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null) {
                setCurrentAccessToken(createExpired$facebook_core_release(currentAccessToken));
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<String> getPermissionsFromBundle$facebook_core_release(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList == null) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
            IIX0o.oO(unmodifiableList, "{\n            Collections.unmodifiableList(ArrayList(originalPermissions))\n          }");
            return unmodifiableList;
        }

        @XO0OX.x0XOIxOo
        public final boolean isCurrentAccessTokenActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null && !currentAccessToken.isExpired()) {
                return true;
            }
            return false;
        }

        @XO0OX.x0XOIxOo
        public final boolean isDataAccessActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null && !currentAccessToken.isDataAccessExpired()) {
                return true;
            }
            return false;
        }

        @XO0OX.x0XOIxOo
        public final boolean isLoggedInWithInstagram() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null && !currentAccessToken.isExpired() && currentAccessToken.isInstagramToken()) {
                return true;
            }
            return false;
        }

        @XO0OX.x0XOIxOo
        public final void refreshCurrentAccessTokenAsync() {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(null);
        }

        @XO0OX.x0XOIxOo
        public final void setCurrentAccessToken(@OXOo.oOoXoXO AccessToken accessToken) {
            AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        public final void refreshCurrentAccessTokenAsync(@OXOo.oOoXoXO AccessTokenRefreshCallback accessTokenRefreshCallback) {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccessTokenSource.valuesCustom().length];
            iArr[AccessTokenSource.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
            iArr[AccessTokenSource.CHROME_CUSTOM_TAB.ordinal()] = 2;
            iArr[AccessTokenSource.WEB_VIEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
        DEFAULT_LAST_REFRESH_TIME = new Date();
        DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
        CREATOR = new Parcelable.Creator<AccessToken>() { // from class: com.facebook.AccessToken$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public AccessToken createFromParcel(@OXOo.OOXIXo Parcel source) {
                IIX0o.x0xO0oo(source, "source");
                return new AccessToken(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public AccessToken[] newArray(int i) {
                return new AccessToken[i];
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AccessToken(@OXOo.OOXIXo String accessToken, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String userId, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO Collection<String> collection2, @OXOo.oOoXoXO Collection<String> collection3, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.oOoXoXO Date date, @OXOo.oOoXoXO Date date2, @OXOo.oOoXoXO Date date3) {
        this(accessToken, applicationId, userId, collection, collection2, collection3, accessTokenSource, date, date2, date3, null, 1024, null);
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(userId, "userId");
    }

    private final void appendPermissions(StringBuilder sb) {
        sb.append(" permissions:");
        sb.append("[");
        sb.append(TextUtils.join(", ", this.permissions));
        sb.append("]");
    }

    private final AccessTokenSource convertTokenSourceForGraphDomain(AccessTokenSource accessTokenSource, String str) {
        if (str != null && str.equals("instagram")) {
            int i = WhenMappings.$EnumSwitchMapping$0[accessTokenSource.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return AccessTokenSource.INSTAGRAM_WEB_VIEW;
                    }
                    return accessTokenSource;
                }
                return AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
            }
            return AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
        }
        return accessTokenSource;
    }

    @XO0OX.x0XOIxOo
    public static final void createFromNativeLinkingIntent(@OXOo.OOXIXo Intent intent, @OXOo.OOXIXo String str, @OXOo.OOXIXo AccessTokenCreationCallback accessTokenCreationCallback) {
        Companion.createFromNativeLinkingIntent(intent, str, accessTokenCreationCallback);
    }

    @XO0OX.x0XOIxOo
    public static final void expireCurrentAccessToken() {
        Companion.expireCurrentAccessToken();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AccessToken getCurrentAccessToken() {
        return Companion.getCurrentAccessToken();
    }

    @XO0OX.x0XOIxOo
    public static final boolean isCurrentAccessTokenActive() {
        return Companion.isCurrentAccessTokenActive();
    }

    @XO0OX.x0XOIxOo
    public static final boolean isDataAccessActive() {
        return Companion.isDataAccessActive();
    }

    @XO0OX.x0XOIxOo
    public static final boolean isLoggedInWithInstagram() {
        return Companion.isLoggedInWithInstagram();
    }

    @XO0OX.x0XOIxOo
    public static final void refreshCurrentAccessTokenAsync() {
        Companion.refreshCurrentAccessTokenAsync();
    }

    @XO0OX.x0XOIxOo
    public static final void setCurrentAccessToken(@OXOo.oOoXoXO AccessToken accessToken) {
        Companion.setCurrentAccessToken(accessToken);
    }

    private final String tokenToString() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            return this.token;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        boolean Oxx0IOOO2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (IIX0o.Oxx0IOOO(this.expires, accessToken.expires) && IIX0o.Oxx0IOOO(this.permissions, accessToken.permissions) && IIX0o.Oxx0IOOO(this.declinedPermissions, accessToken.declinedPermissions) && IIX0o.Oxx0IOOO(this.expiredPermissions, accessToken.expiredPermissions) && IIX0o.Oxx0IOOO(this.token, accessToken.token) && this.source == accessToken.source && IIX0o.Oxx0IOOO(this.lastRefresh, accessToken.lastRefresh) && IIX0o.Oxx0IOOO(this.applicationId, accessToken.applicationId) && IIX0o.Oxx0IOOO(this.userId, accessToken.userId) && IIX0o.Oxx0IOOO(this.dataAccessExpirationTime, accessToken.dataAccessExpirationTime)) {
            String str = this.graphDomain;
            String str2 = accessToken.graphDomain;
            if (str == null) {
                if (str2 == null) {
                    Oxx0IOOO2 = true;
                } else {
                    Oxx0IOOO2 = false;
                }
            } else {
                Oxx0IOOO2 = IIX0o.Oxx0IOOO(str, str2);
            }
            if (Oxx0IOOO2) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    public final String getApplicationId() {
        return this.applicationId;
    }

    @OXOo.OOXIXo
    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    @OXOo.OOXIXo
    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    @OXOo.OOXIXo
    public final Set<String> getExpiredPermissions() {
        return this.expiredPermissions;
    }

    @OXOo.OOXIXo
    public final Date getExpires() {
        return this.expires;
    }

    @OXOo.oOoXoXO
    public final String getGraphDomain() {
        return this.graphDomain;
    }

    @OXOo.OOXIXo
    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    @OXOo.OOXIXo
    public final Set<String> getPermissions() {
        return this.permissions;
    }

    @OXOo.OOXIXo
    public final AccessTokenSource getSource() {
        return this.source;
    }

    @OXOo.OOXIXo
    public final String getToken() {
        return this.token;
    }

    @OXOo.OOXIXo
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((((((((((527 + this.expires.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.expiredPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31) + this.applicationId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode()) * 31;
        String str = this.graphDomain;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final boolean isInstagramToken() {
        String str = this.graphDomain;
        if (str != null && str.equals("instagram")) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put(EXPIRES_AT_KEY, this.expires.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.permissions));
        jSONObject.put(DECLINED_PERMISSIONS_KEY, new JSONArray((Collection) this.declinedPermissions));
        jSONObject.put(EXPIRED_PERMISSIONS_KEY, new JSONArray((Collection) this.expiredPermissions));
        jSONObject.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        jSONObject.put("source", this.source.name());
        jSONObject.put(APPLICATION_ID_KEY, this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:");
        sb.append(tokenToString());
        appendPermissions(sb);
        sb.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "builder.toString()");
        return sb2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeLong(this.expires.getTime());
        dest.writeStringList(new ArrayList(this.permissions));
        dest.writeStringList(new ArrayList(this.declinedPermissions));
        dest.writeStringList(new ArrayList(this.expiredPermissions));
        dest.writeString(this.token);
        dest.writeString(this.source.name());
        dest.writeLong(this.lastRefresh.getTime());
        dest.writeString(this.applicationId);
        dest.writeString(this.userId);
        dest.writeLong(this.dataAccessExpirationTime.getTime());
        dest.writeString(this.graphDomain);
    }

    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, (i & 1024) != 0 ? DEFAULT_GRAPH_DOMAIN : str4);
    }

    @XO0OX.x0XOIxOo
    public static final void refreshCurrentAccessTokenAsync(@OXOo.oOoXoXO AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Companion.refreshCurrentAccessTokenAsync(accessTokenRefreshCallback);
    }

    @XO0OX.xoIox
    public AccessToken(@OXOo.OOXIXo String accessToken, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String userId, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO Collection<String> collection2, @OXOo.oOoXoXO Collection<String> collection3, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.oOoXoXO Date date, @OXOo.oOoXoXO Date date2, @OXOo.oOoXoXO Date date3, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(userId, "userId");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(accessToken, "accessToken");
        Validate.notEmpty(applicationId, "applicationId");
        Validate.notEmpty(userId, aw.r);
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        Set<String> unmodifiableSet = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        IIX0o.oO(unmodifiableSet, "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())");
        this.permissions = unmodifiableSet;
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        IIX0o.oO(unmodifiableSet2, "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())");
        this.declinedPermissions = unmodifiableSet2;
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        IIX0o.oO(unmodifiableSet3, "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())");
        this.expiredPermissions = unmodifiableSet3;
        this.token = accessToken;
        this.source = convertTokenSourceForGraphDomain(accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource, str);
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = applicationId;
        this.userId = userId;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
        this.graphDomain = str == null ? DEFAULT_GRAPH_DOMAIN : str;
    }

    public AccessToken(@OXOo.OOXIXo Parcel parcel) {
        AccessTokenSource accessTokenSource;
        IIX0o.x0xO0oo(parcel, "parcel");
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        IIX0o.oO(unmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = unmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        IIX0o.oO(unmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        IIX0o.oO(unmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = unmodifiableSet3;
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.token = Validate.notNullOrEmpty(readString, "token");
        String readString2 = parcel.readString();
        if (readString2 != null) {
            accessTokenSource = AccessTokenSource.valueOf(readString2);
        } else {
            accessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSource;
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
        this.userId = Validate.notNullOrEmpty(parcel.readString(), aw.r);
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }
}
