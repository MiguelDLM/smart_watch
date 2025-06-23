package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.szabh.smable3.entity.BleNotification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class NativeProtocol {

    @OXOo.OOXIXo
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";

    @OXOo.OOXIXo
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";

    @OXOo.OOXIXo
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";

    @OXOo.OOXIXo
    public static final String AUDIENCE_EVERYONE = "everyone";

    @OXOo.OOXIXo
    public static final String AUDIENCE_FRIENDS = "friends";

    @OXOo.OOXIXo
    public static final String AUDIENCE_ME = "only_me";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";

    @OXOo.OOXIXo
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";

    @OXOo.OOXIXo
    private static final String CONTENT_SCHEME = "content://";

    @OXOo.OOXIXo
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";

    @OXOo.OOXIXo
    public static final String ERROR_NETWORK_ERROR = "NetworkError";

    @OXOo.OOXIXo
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";

    @OXOo.OOXIXo
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";

    @OXOo.OOXIXo
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";

    @OXOo.OOXIXo
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";

    @OXOo.OOXIXo
    public static final String ERROR_USER_CANCELED = "UserCanceled";

    @OXOo.OOXIXo
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";

    @OXOo.OOXIXo
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";

    @OXOo.OOXIXo
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";

    @OXOo.OOXIXo
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";

    @OXOo.OOXIXo
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";

    @OXOo.OOXIXo
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";

    @OXOo.OOXIXo
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";

    @OXOo.OOXIXo
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";

    @OXOo.OOXIXo
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";

    @OXOo.OOXIXo
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";

    @OXOo.OOXIXo
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";

    @OXOo.OOXIXo
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";

    @OXOo.OOXIXo
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";

    @OXOo.OOXIXo
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";

    @OXOo.OOXIXo
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";

    @OXOo.OOXIXo
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";

    @OXOo.OOXIXo
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";

    @OXOo.OOXIXo
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";

    @OXOo.OOXIXo
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";

    @OXOo.OOXIXo
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";

    @OXOo.OOXIXo
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";

    @OXOo.OOXIXo
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";

    @OXOo.OOXIXo
    public static final String IMAGE_URL_KEY = "url";

    @OXOo.OOXIXo
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";

    @OXOo.OOXIXo
    public static final NativeProtocol INSTANCE;

    @OXOo.OOXIXo
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";

    @OXOo.OOXIXo
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";

    @OXOo.OOXIXo
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;

    @OXOo.OOXIXo
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";

    @OXOo.OOXIXo
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";

    @OXOo.OOXIXo
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";

    @OXOo.OOXIXo
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";

    @OXOo.OOXIXo
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";

    @OXOo.OOXIXo
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";

    @OXOo.OOXIXo
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";

    @OXOo.OOXIXo
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";

    @OXOo.OOXIXo
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";

    @OXOo.OOXIXo
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    public static final String WEB_DIALOG_ACTION = "action";

    @OXOo.OOXIXo
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";

    @OXOo.OOXIXo
    public static final String WEB_DIALOG_PARAMS = "params";

    @OXOo.OOXIXo
    public static final String WEB_DIALOG_URL = "url";

    @OXOo.OOXIXo
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;

    @OXOo.OOXIXo
    private static final List<NativeAppInfo> effectCameraAppInfoList;

    @OXOo.OOXIXo
    private static final List<NativeAppInfo> facebookAppInfoList;

    @OXOo.OOXIXo
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* loaded from: classes8.dex */
    public static final class EffectTestAppInfo extends NativeAppInfo {
        @OXOo.oOoXoXO
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m211getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m211getLoginActivity();
        }
    }

    /* loaded from: classes8.dex */
    public static final class InstagramAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getPackage() {
            return BleNotification.INSTAGRAM;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    /* loaded from: classes8.dex */
    public static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30) {
                return true;
            }
            return false;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getPackage() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                Log.w(NativeProtocol.access$getTAG$p(), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class MessengerAppInfo extends NativeAppInfo {
        @OXOo.oOoXoXO
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m212getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getPackage() {
            return "com.facebook.orca";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m212getLoginActivity();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class NativeAppInfo {

        @OXOo.oOoXoXO
        private TreeSet<Integer> availableVersions;

        public final synchronized void fetchAvailableVersions(boolean z) {
            Boolean valueOf;
            TreeSet<Integer> treeSet;
            if (!z) {
                try {
                    TreeSet<Integer> treeSet2 = this.availableVersions;
                    if (treeSet2 != null) {
                        if (treeSet2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(treeSet2.isEmpty());
                        }
                        if (!IIX0o.Oxx0IOOO(valueOf, Boolean.FALSE)) {
                        }
                        treeSet = this.availableVersions;
                        if (treeSet != null || treeSet.isEmpty()) {
                            onAvailableVersionsNullOrEmpty();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.availableVersions = NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol.INSTANCE, this);
            treeSet = this.availableVersions;
            if (treeSet != null) {
            }
            onAvailableVersionsNullOrEmpty();
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, java.lang.Boolean.FALSE) == false) goto L9;
         */
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.TreeSet<java.lang.Integer> getAvailableVersions() {
            /*
                r2 = this;
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                if (r0 == 0) goto L18
                if (r0 != 0) goto L8
                r0 = 0
                goto L10
            L8:
                boolean r0 = r0.isEmpty()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L10:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r0 != 0) goto L1c
            L18:
                r0 = 0
                r2.fetchAvailableVersions(r0)
            L1c:
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.getAvailableVersions():java.util.TreeSet");
        }

        @OXOo.oOoXoXO
        public abstract String getLoginActivity();

        @OXOo.OOXIXo
        public abstract String getPackage();

        @OXOo.OOXIXo
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST;
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ProtocolVersionQueryResult {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.oOoXoXO
        private NativeAppInfo appInfo;
        private int protocolVersion;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @XO0OX.x0XOIxOo
            @OXOo.OOXIXo
            public final ProtocolVersionQueryResult create(@OXOo.oOoXoXO NativeAppInfo nativeAppInfo, int i) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i;
                return protocolVersionQueryResult;
            }

            @XO0OX.x0XOIxOo
            @OXOo.OOXIXo
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ProtocolVersionQueryResult(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public static final ProtocolVersionQueryResult create(@OXOo.oOoXoXO NativeAppInfo nativeAppInfo, int i) {
            return Companion.create(nativeAppInfo, i);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        @OXOo.oOoXoXO
        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }

        private ProtocolVersionQueryResult() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @OXOo.OOXIXo
        public String getPackage() {
            return RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE_WAKIZASHI;
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        String name = NativeProtocol.class.getName();
        IIX0o.oO(name, "NativeProtocol::class.java.name");
        TAG = name;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20210906), Integer.valueOf(PROTOCOL_VERSION_20171115), Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20170411), Integer.valueOf(PROTOCOL_VERSION_20170213), Integer.valueOf(PROTOCOL_VERSION_20161017), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20150702), Integer.valueOf(PROTOCOL_VERSION_20150401), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140313), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20131024), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
            hashMap.put(ACTION_FEED_DIALOG, list);
            hashMap.put(ACTION_LIKE_DIALOG, list);
            hashMap.put(ACTION_APPINVITE_DIALOG, list);
            hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
            hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            hashMap.put(ACTION_SHARE_STORY, list);
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList Oxx0xo2 = CollectionsKt__CollectionsKt.Oxx0xo(new EffectTestAppInfo());
            Oxx0xo2.addAll(buildFacebookAppList());
            return Oxx0xo2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return CollectionsKt__CollectionsKt.Oxx0xo(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            IIX0o.oO(parse, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final int computeLatestAvailableVersionFromVersionSpec(@OXOo.oOoXoXO TreeSet<Integer> treeSet, int i, @OXOo.OOXIXo int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            IIX0o.x0xO0oo(versionSpec, "versionSpec");
            if (treeSet == null) {
                return -1;
            }
            int length = versionSpec.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i2 = -1;
            while (descendingIterator.hasNext()) {
                Integer fbAppVersion = descendingIterator.next();
                IIX0o.oO(fbAppVersion, "fbAppVersion");
                i2 = Math.max(i2, fbAppVersion.intValue());
                while (length >= 0 && versionSpec[length] > fbAppVersion.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (versionSpec[length] == fbAppVersion.intValue()) {
                    if (length % 2 != 0) {
                        return -1;
                    }
                    return Math.min(i2, i);
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle createBundleForException(@OXOo.oOoXoXO FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", ERROR_USER_CANCELED);
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent createInstagramIntent(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo Collection<String> permissions, @OXOo.OOXIXo String e2e, boolean z, boolean z2, @OXOo.OOXIXo DefaultAudience defaultAudience, @OXOo.OOXIXo String clientState, @OXOo.OOXIXo String authType, @OXOo.oOoXoXO String str, boolean z3, boolean z4, boolean z5) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(permissions, "permissions");
            IIX0o.x0xO0oo(e2e, "e2e");
            IIX0o.x0xO0oo(defaultAudience, "defaultAudience");
            IIX0o.x0xO0oo(clientState, "clientState");
            IIX0o.x0xO0oo(authType, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(instagramAppInfo, applicationId, permissions, e2e, z2, defaultAudience, clientState, authType, false, str, z3, LoginTargetApp.INSTAGRAM, z4, z5, "", null, null), instagramAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2, String str5, boolean z3, LoginTargetApp loginTargetApp, boolean z4, boolean z5, String str6, String str7, String str8) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
            IIX0o.oO(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra("state", str3);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, nativeAppInfo.getResponseType());
            putExtra.putExtra("nonce", str6);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
            if (z) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
            if (z2) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, str5);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, z3);
            if (z4) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, loginTargetApp.toString());
            }
            if (z5) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
            }
            return putExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent createPlatformActivityIntent(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO ProtocolVersionQueryResult protocolVersionQueryResult, @OXOo.oOoXoXO Bundle bundle) {
        NativeAppInfo appInfo;
        Intent validateActivityIntent;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
            return validateActivityIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent createPlatformServiceIntent(@OXOo.OOXIXo Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent createProtocolResultIntent(@OXOo.OOXIXo Intent requestIntent, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(requestIntent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(requestIntent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(requestIntent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", callIdFromIntent.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", createBundleForException(facebookException));
            }
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle != null) {
                intent.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<Intent> createProxyAuthIntents(@OXOo.oOoXoXO Context context, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo Collection<String> permissions, @OXOo.OOXIXo String e2e, boolean z, boolean z2, @OXOo.OOXIXo DefaultAudience defaultAudience, @OXOo.OOXIXo String clientState, @OXOo.OOXIXo String authType, boolean z3, @OXOo.oOoXoXO String str, boolean z4, boolean z5, boolean z6, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(permissions, "permissions");
            IIX0o.x0xO0oo(e2e, "e2e");
            IIX0o.x0xO0oo(defaultAudience, "defaultAudience");
            IIX0o.x0xO0oo(clientState, "clientState");
            IIX0o.x0xO0oo(authType, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                Intent createNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), applicationId, permissions, e2e, z2, defaultAudience, clientState, authType, z3, str, z4, LoginTargetApp.FACEBOOK, z5, z6, str2, str3, str4);
                if (createNativeAppIntent != null) {
                    arrayList2.add(createNativeAppIntent);
                }
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static /* synthetic */ List createProxyAuthIntents$default(Context context, String str, Collection collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3, String str5, boolean z4, boolean z5, boolean z6, String str6, String str7, String str8, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return createProxyAuthIntents(context, str, collection, str2, z, z2, defaultAudience, str3, str4, z3, str5, z4, z5, z6, str6, str7, (i & 65536) != 0 ? "S256" : str8);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[Catch: all -> 0x0088, TRY_ENTER, TryCatch #3 {all -> 0x0088, blocks: (B:6:0x000d, B:30:0x0090, B:31:0x008d, B:18:0x0084), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[EXC_TOP_SPLITTER, LOOP:0: B:20:0x0065->B:23:0x006b, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[Catch: all -> 0x0088, TryCatch #3 {all -> 0x0088, blocks: (B:6:0x000d, B:30:0x0090, B:31:0x008d, B:18:0x0084), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r13) {
        /*
            r12 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = "Failed to query content resolver."
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r3 = 0
            if (r2 == 0) goto Ld
            return r3
        Ld:
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch: java.lang.Throwable -> L88
            r2.<init>()     // Catch: java.lang.Throwable -> L88
            com.facebook.FacebookSdk r4 = com.facebook.FacebookSdk.INSTANCE     // Catch: java.lang.Throwable -> L88
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L88
            android.content.ContentResolver r5 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L88
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L88
            android.net.Uri r6 = r12.buildPlatformProviderVersionURI(r13)     // Catch: java.lang.Throwable -> L88
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L3c
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r13 = r13.getPackage()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = ".provider.PlatformProvider"
            java.lang.String r13 = kotlin.jvm.internal.IIX0o.XIxXXX0x0(r13, r8)     // Catch: java.lang.Throwable -> L3c
            r8 = 0
            android.content.pm.ProviderInfo r13 = r4.resolveContentProvider(r13, r8)     // Catch: java.lang.Throwable -> L3c java.lang.RuntimeException -> L3f
            goto L46
        L3c:
            r13 = move-exception
            r0 = r3
            goto L8a
        L3f:
            r13 = move-exception
            java.lang.String r4 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L3c
            android.util.Log.e(r4, r1, r13)     // Catch: java.lang.Throwable -> L3c
            r13 = r3
        L46:
            if (r13 == 0) goto L80
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L3c java.lang.IllegalArgumentException -> L50 java.lang.SecurityException -> L57 java.lang.NullPointerException -> L5d
            goto L63
        L50:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L3c
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L3c
        L55:
            r13 = r3
            goto L63
        L57:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L3c
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L3c
            goto L55
        L5d:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L3c
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L3c
            goto L55
        L63:
            if (r13 == 0) goto L81
        L65:
            boolean r1 = r13.moveToNext()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L81
            int r1 = r13.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            int r1 = r13.getInt(r1)     // Catch: java.lang.Throwable -> L7b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L7b
            r2.add(r1)     // Catch: java.lang.Throwable -> L7b
            goto L65
        L7b:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L8a
        L80:
            r13 = r3
        L81:
            if (r13 != 0) goto L84
            goto L87
        L84:
            r13.close()     // Catch: java.lang.Throwable -> L88
        L87:
            return r2
        L88:
            r13 = move-exception
            goto L91
        L8a:
            if (r0 != 0) goto L8d
            goto L90
        L8d:
            r0.close()     // Catch: java.lang.Throwable -> L88
        L90:
            throw r13     // Catch: java.lang.Throwable -> L88
        L91:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getBridgeArgumentsFromIntent(@OXOo.OOXIXo Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(intent, "intent");
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return null;
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final UUID getCallIdFromIntent(@OXOo.oOoXoXO Intent intent) {
        String stringExtra;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                if (bundleExtra != null) {
                    stringExtra = bundleExtra.getString("action_id");
                } else {
                    stringExtra = null;
                }
            } else {
                stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (stringExtra == null) {
                return null;
            }
            try {
                return UUID.fromString(stringExtra);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getErrorDataFromResultIntent(@OXOo.OOXIXo Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(resultIntent, "resultIntent");
            if (!isErrorResult(resultIntent)) {
                return null;
            }
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            if (bridgeArgumentsFromIntent != null) {
                return bridgeArgumentsFromIntent.getBundle("error");
            }
            return resultIntent.getExtras();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final FacebookException getExceptionFromErrorData(@OXOo.oOoXoXO Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString(STATUS_ERROR_TYPE);
            }
            String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
            }
            if (string != null && kotlin.text.OxI.oX0I0O(string, ERROR_USER_CANCELED, true)) {
                return new FacebookOperationCanceledException(string2);
            }
            return new FacebookException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(@OXOo.OOXIXo String action, @OXOo.OOXIXo int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(action, "action");
            IIX0o.x0xO0oo(versionSpec, "versionSpec");
            List<NativeAppInfo> list = actionToAppInfoMap.get(action);
            if (list == null) {
                list = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list, versionSpec);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : list) {
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final int getLatestAvailableProtocolVersionForService(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @XO0OX.x0XOIxOo
    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getMethodArgumentsFromIntent(@OXOo.OOXIXo Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(intent, "intent");
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final int getProtocolVersionFromIntent(@OXOo.OOXIXo Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            IIX0o.x0xO0oo(intent, "intent");
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getSuccessResultsFromIntent(@OXOo.OOXIXo Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(resultIntent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(resultIntent);
            Bundle extras = resultIntent.getExtras();
            if (isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) && extras != null) {
                return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
            }
            return extras;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean isErrorResult(@OXOo.OOXIXo Intent resultIntent) {
        Boolean valueOf;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(resultIntent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            if (bridgeArgumentsFromIntent == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(bridgeArgumentsFromIntent.containsKey("error"));
            }
            if (valueOf == null) {
                return resultIntent.hasExtra(STATUS_ERROR_TYPE);
            }
            return valueOf.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean isVersionCompatibleWithBucketedIntent(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            if (!ArraysKt___ArraysKt.OXO0oX(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i)) || i < 20140701) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setupProtocolRequestIntent(@OXOo.OOXIXo Intent intent, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, int i, @OXOo.oOoXoXO Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(intent, "intent");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String applicationId = FacebookSdk.getApplicationId();
            String applicationName = FacebookSdk.getApplicationName();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
            if (isVersionCompatibleWithBucketedIntent(i)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("action_id", str);
                Utility utility = Utility.INSTANCE;
                Utility.putNonEmptyString(bundle2, "app_name", applicationName);
                intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
                return;
            }
            intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
            Utility utility2 = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(applicationName)) {
                intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (!protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.x0xO0oo
                @Override // java.lang.Runnable
                public final void run() {
                    NativeProtocol.m210updateAllAvailableProtocolVersionsAsync$lambda1();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1, reason: not valid java name */
    public static final void m210updateAllAvailableProtocolVersionsAsync$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            try {
                Iterator<NativeAppInfo> it = facebookAppInfoList.iterator();
                while (it.hasNext()) {
                    it.next().fetchAvailableVersions(true);
                }
            } finally {
                protocolVersionsAsyncUpdating.set(false);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent validateActivityIntent(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO Intent intent, @OXOo.oOoXoXO NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveActivity.activityInfo.packageName;
            IIX0o.oO(str, "resolveInfo.activityInfo.packageName");
            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Intent validateServiceIntent(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO Intent intent, @OXOo.oOoXoXO NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveService.serviceInfo.packageName;
            IIX0o.oO(str, "resolveInfo.serviceInfo.packageName");
            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }
}
