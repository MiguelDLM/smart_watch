package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AccessTokenManager {

    @OXOo.OOXIXo
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";

    @OXOo.OOXIXo
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";

    @OXOo.OOXIXo
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";

    @OXOo.OOXIXo
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";

    @OXOo.OOXIXo
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;

    @OXOo.oOoXoXO
    private static AccessTokenManager instanceField;

    @OXOo.OOXIXo
    private final AccessTokenCache accessTokenCache;

    @OXOo.oOoXoXO
    private AccessToken currentAccessTokenField;

    @OXOo.OOXIXo
    private Date lastAttemptedTokenExtendDate;

    @OXOo.OOXIXo
    private final LocalBroadcastManager localBroadcastManager;

    @OXOo.OOXIXo
    private final AtomicBoolean tokenRefreshInProgress;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString(GraphRequest.FIELDS_PARAM, "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "permission,status");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            if (IIX0o.Oxx0IOOO(graphDomain, "instagram")) {
                return new InstagramRefreshTokenInfo();
            }
            return new FacebookRefreshTokenInfo();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 == null) {
                synchronized (this) {
                    accessTokenManager = AccessTokenManager.instanceField;
                    if (accessTokenManager == null) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                        IIX0o.oO(localBroadcastManager, "getInstance(applicationContext)");
                        AccessTokenManager accessTokenManager3 = new AccessTokenManager(localBroadcastManager, new AccessTokenCache());
                        Companion companion = AccessTokenManager.Companion;
                        AccessTokenManager.instanceField = accessTokenManager3;
                        accessTokenManager = accessTokenManager3;
                    }
                }
                return accessTokenManager;
            }
            return accessTokenManager2;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {

        @OXOo.OOXIXo
        private final String graphPath = "oauth/access_token";

        @OXOo.OOXIXo
        private final String grantType = "fb_extend_sso_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @OXOo.OOXIXo
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @OXOo.OOXIXo
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* loaded from: classes8.dex */
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {

        @OXOo.OOXIXo
        private final String graphPath = "refresh_access_token";

        @OXOo.OOXIXo
        private final String grantType = "ig_refresh_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @OXOo.OOXIXo
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @OXOo.OOXIXo
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* loaded from: classes8.dex */
    public static final class RefreshResult {

        @OXOo.oOoXoXO
        private String accessToken;

        @OXOo.oOoXoXO
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;

        @OXOo.oOoXoXO
        private String graphDomain;

        @OXOo.oOoXoXO
        public final String getAccessToken() {
            return this.accessToken;
        }

        @OXOo.oOoXoXO
        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        @OXOo.oOoXoXO
        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(@OXOo.oOoXoXO String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(@OXOo.oOoXoXO Long l) {
            this.dataAccessExpirationTime = l;
        }

        public final void setExpiresAt(int i) {
            this.expiresAt = i;
        }

        public final void setExpiresIn(int i) {
            this.expiresIn = i;
        }

        public final void setGraphDomain(@OXOo.oOoXoXO String str) {
            this.graphDomain = str;
        }
    }

    /* loaded from: classes8.dex */
    public interface RefreshTokenInfo {
        @OXOo.OOXIXo
        String getGrantType();

        @OXOo.OOXIXo
        String getGraphPath();
    }

    public AccessTokenManager(@OXOo.OOXIXo LocalBroadcastManager localBroadcastManager, @OXOo.OOXIXo AccessTokenCache accessTokenCache) {
        IIX0o.x0xO0oo(localBroadcastManager, "localBroadcastManager");
        IIX0o.x0xO0oo(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessToken$lambda-0, reason: not valid java name */
    public static final void m103refreshCurrentAccessToken$lambda0(AccessTokenManager this$0, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                return;
            }
            return;
        }
        if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
                return;
            }
            return;
        }
        this.lastAttemptedTokenExtendDate = new Date();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RefreshResult refreshResult = new RefreshResult();
        Companion companion = Companion;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch(companion.createGrantedPermissionsRequest(currentAccessToken, new GraphRequest.Callback() { // from class: com.facebook.oIX0oI
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.m104refreshCurrentAccessTokenImpl$lambda1(atomicBoolean, hashSet, hashSet2, hashSet3, graphResponse);
            }
        }), companion.createExtendAccessTokenRequest(currentAccessToken, new GraphRequest.Callback() { // from class: com.facebook.II0xO0
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.m105refreshCurrentAccessTokenImpl$lambda2(AccessTokenManager.RefreshResult.this, graphResponse);
            }
        }));
        graphRequestBatch.addCallback(new GraphRequestBatch.Callback() { // from class: com.facebook.I0Io
            @Override // com.facebook.GraphRequestBatch.Callback
            public final void onBatchCompleted(GraphRequestBatch graphRequestBatch2) {
                AccessTokenManager.m106refreshCurrentAccessTokenImpl$lambda3(AccessTokenManager.RefreshResult.this, currentAccessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this, graphRequestBatch2);
            }
        });
        graphRequestBatch.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-1, reason: not valid java name */
    public static final void m104refreshCurrentAccessTokenImpl$lambda1(AtomicBoolean permissionsCallSucceeded, Set permissions, Set declinedPermissions, Set expiredPermissions, GraphResponse response) {
        JSONArray optJSONArray;
        IIX0o.x0xO0oo(permissionsCallSucceeded, "$permissionsCallSucceeded");
        IIX0o.x0xO0oo(permissions, "$permissions");
        IIX0o.x0xO0oo(declinedPermissions, "$declinedPermissions");
        IIX0o.x0xO0oo(expiredPermissions, "$expiredPermissions");
        IIX0o.x0xO0oo(response, "response");
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null || (optJSONArray = jsonObject.optJSONArray("data")) == null) {
            return;
        }
        permissionsCallSucceeded.set(true);
        int length = optJSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("permission");
                    String status = optJSONObject.optString("status");
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(status)) {
                        IIX0o.oO(status, "status");
                        Locale US = Locale.US;
                        IIX0o.oO(US, "US");
                        String status2 = status.toLowerCase(US);
                        IIX0o.oO(status2, "(this as java.lang.String).toLowerCase(locale)");
                        IIX0o.oO(status2, "status");
                        int hashCode = status2.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && status2.equals("declined")) {
                                    declinedPermissions.add(optString);
                                }
                                Log.w(TAG, IIX0o.XIxXXX0x0("Unexpected status: ", status2));
                            } else {
                                if (status2.equals("granted")) {
                                    permissions.add(optString);
                                }
                                Log.w(TAG, IIX0o.XIxXXX0x0("Unexpected status: ", status2));
                            }
                        } else {
                            if (status2.equals("expired")) {
                                expiredPermissions.add(optString);
                            }
                            Log.w(TAG, IIX0o.XIxXXX0x0("Unexpected status: ", status2));
                        }
                    }
                }
                if (i2 < length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-2, reason: not valid java name */
    public static final void m105refreshCurrentAccessTokenImpl$lambda2(RefreshResult refreshResult, GraphResponse response) {
        IIX0o.x0xO0oo(refreshResult, "$refreshResult");
        IIX0o.x0xO0oo(response, "response");
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            return;
        }
        refreshResult.setAccessToken(jsonObject.optString("access_token"));
        refreshResult.setExpiresAt(jsonObject.optInt("expires_at"));
        refreshResult.setExpiresIn(jsonObject.optInt("expires_in"));
        refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
        refreshResult.setGraphDomain(jsonObject.optString("graph_domain", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-3, reason: not valid java name */
    public static final void m106refreshCurrentAccessTokenImpl$lambda3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean permissionsCallSucceeded, Set permissions, Set declinedPermissions, Set expiredPermissions, AccessTokenManager this$0, GraphRequestBatch it) {
        AccessToken accessToken2;
        String userId;
        Set permissions2;
        Set declinedPermissions2;
        Set expiredPermissions2;
        Date dataAccessExpirationTime;
        IIX0o.x0xO0oo(refreshResult, "$refreshResult");
        IIX0o.x0xO0oo(permissionsCallSucceeded, "$permissionsCallSucceeded");
        IIX0o.x0xO0oo(permissions, "$permissions");
        IIX0o.x0xO0oo(declinedPermissions, "$declinedPermissions");
        IIX0o.x0xO0oo(expiredPermissions, "$expiredPermissions");
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(it, "it");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime2 = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            Companion companion = Companion;
            if (companion.getInstance().getCurrentAccessToken() != null) {
                AccessToken currentAccessToken = companion.getInstance().getCurrentAccessToken();
                if (currentAccessToken == null) {
                    userId = null;
                } else {
                    userId = currentAccessToken.getUserId();
                }
                if (userId == accessToken.getUserId()) {
                    if (!permissionsCallSucceeded.get() && accessToken3 == null && expiresAt == 0) {
                        if (accessTokenRefreshCallback != null) {
                            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                        }
                        this$0.tokenRefreshInProgress.set(false);
                        return;
                    }
                    Date expires = accessToken.getExpires();
                    if (refreshResult.getExpiresAt() != 0) {
                        expires = new Date(refreshResult.getExpiresAt() * 1000);
                    } else if (refreshResult.getExpiresIn() != 0) {
                        expires = new Date((refreshResult.getExpiresIn() * 1000) + new Date().getTime());
                    }
                    Date date = expires;
                    if (accessToken3 == null) {
                        accessToken3 = accessToken.getToken();
                    }
                    String str = accessToken3;
                    String applicationId = accessToken.getApplicationId();
                    String userId2 = accessToken.getUserId();
                    if (permissionsCallSucceeded.get()) {
                        permissions2 = permissions;
                    } else {
                        permissions2 = accessToken.getPermissions();
                    }
                    if (permissionsCallSucceeded.get()) {
                        declinedPermissions2 = declinedPermissions;
                    } else {
                        declinedPermissions2 = accessToken.getDeclinedPermissions();
                    }
                    if (permissionsCallSucceeded.get()) {
                        expiredPermissions2 = expiredPermissions;
                    } else {
                        expiredPermissions2 = accessToken.getExpiredPermissions();
                    }
                    AccessTokenSource source = accessToken.getSource();
                    Date date2 = new Date();
                    if (dataAccessExpirationTime2 != null) {
                        dataAccessExpirationTime = new Date(dataAccessExpirationTime2.longValue() * 1000);
                    } else {
                        dataAccessExpirationTime = accessToken.getDataAccessExpirationTime();
                    }
                    Date date3 = dataAccessExpirationTime;
                    if (graphDomain == null) {
                        graphDomain = accessToken.getGraphDomain();
                    }
                    AccessToken accessToken4 = new AccessToken(str, applicationId, userId2, permissions2, declinedPermissions2, expiredPermissions2, source, date, date2, date3, graphDomain);
                    try {
                        companion.getInstance().setCurrentAccessToken(accessToken4);
                        this$0.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback != null) {
                            accessTokenRefreshCallback.OnTokenRefreshed(accessToken4);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessToken2 = accessToken4;
                        this$0.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback != null && accessToken2 != null) {
                            accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                        }
                        throw th;
                    }
                }
            }
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            this$0.tokenRefreshInProgress.set(false);
        } catch (Throwable th2) {
            th = th2;
            accessToken2 = null;
        }
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Date expires;
        PendingIntent broadcast;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (companion.isCurrentAccessTokenActive()) {
            if (currentAccessToken == null) {
                expires = null;
            } else {
                expires = currentAccessToken.getExpires();
            }
            if (expires != null && alarmManager != null) {
                Intent intent = new Intent(applicationContext, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                if (Build.VERSION.SDK_INT >= 23) {
                    broadcast = PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864);
                } else {
                    broadcast = PendingIntent.getBroadcast(applicationContext, 0, intent, 0);
                }
                try {
                    alarmManager.set(1, currentAccessToken.getExpires().getTime(), broadcast);
                } catch (Exception unused) {
                }
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!currentAccessToken.getSource().canExtendToken() || time - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || time - currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (!shouldExtendAccessToken()) {
            return;
        }
        refreshCurrentAccessToken(null);
    }

    @OXOo.oOoXoXO
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public final void refreshCurrentAccessToken(@OXOo.oOoXoXO final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    AccessTokenManager.m103refreshCurrentAccessToken$lambda0(AccessTokenManager.this, accessTokenRefreshCallback);
                }
            });
        }
    }

    public final void setCurrentAccessToken(@OXOo.oOoXoXO AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        Utility utility2 = Utility.INSTANCE;
        if (Utility.areObjectsEqual(accessToken2, accessToken)) {
            return;
        }
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
        setTokenExpirationBroadcastAlarm();
    }
}
