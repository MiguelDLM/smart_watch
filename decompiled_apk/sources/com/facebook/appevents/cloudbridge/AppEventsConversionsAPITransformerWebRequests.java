package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.x0XOIxOo;
import com.baidu.mobads.sdk.internal.an;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AppEventsConversionsAPITransformerWebRequests {
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;

    @OOXIXo
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    @OOXIXo
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();

    @OOXIXo
    private static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = Xo0.ooOOo0oXI(200, 202);

    @OOXIXo
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = Xo0.ooOOo0oXI(503, 504, 429);

    /* loaded from: classes8.dex */
    public static final class CloudBridgeCredentials {

        @OOXIXo
        private final String accessKey;

        @OOXIXo
        private final String cloudBridgeURL;

        @OOXIXo
        private final String datasetID;

        public CloudBridgeCredentials(@OOXIXo String datasetID, @OOXIXo String cloudBridgeURL, @OOXIXo String accessKey) {
            IIX0o.x0xO0oo(datasetID, "datasetID");
            IIX0o.x0xO0oo(cloudBridgeURL, "cloudBridgeURL");
            IIX0o.x0xO0oo(accessKey, "accessKey");
            this.datasetID = datasetID;
            this.cloudBridgeURL = cloudBridgeURL;
            this.accessKey = accessKey;
        }

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        @OOXIXo
        public final String component1() {
            return this.datasetID;
        }

        @OOXIXo
        public final String component2() {
            return this.cloudBridgeURL;
        }

        @OOXIXo
        public final String component3() {
            return this.accessKey;
        }

        @OOXIXo
        public final CloudBridgeCredentials copy(@OOXIXo String datasetID, @OOXIXo String cloudBridgeURL, @OOXIXo String accessKey) {
            IIX0o.x0xO0oo(datasetID, "datasetID");
            IIX0o.x0xO0oo(cloudBridgeURL, "cloudBridgeURL");
            IIX0o.x0xO0oo(accessKey, "accessKey");
            return new CloudBridgeCredentials(datasetID, cloudBridgeURL, accessKey);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return IIX0o.Oxx0IOOO(this.datasetID, cloudBridgeCredentials.datasetID) && IIX0o.Oxx0IOOO(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && IIX0o.Oxx0IOOO(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        @OOXIXo
        public final String getAccessKey() {
            return this.accessKey;
        }

        @OOXIXo
        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        @OOXIXo
        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    @x0XOIxOo
    public static final void configure(@OOXIXo String datasetID, @OOXIXo String url, @OOXIXo String accessKey) {
        IIX0o.x0xO0oo(datasetID, "datasetID");
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(accessKey, "accessKey");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", datasetID, url, accessKey);
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(datasetID, url, accessKey));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i);
    }

    public static /* synthetic */ void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, String str, String str2, String str3, Map map, int i, x0xO0oo x0xo0oo, int i2, Object obj) {
        int i3;
        if ((i2 & 16) != 0) {
            i3 = 60000;
        } else {
            i3 = i;
        }
        appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, str2, str3, map, i3, x0xo0oo);
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest graphRequest) {
        JSONObject graphObject = graphRequest.getGraphObject();
        if (graphObject != null) {
            Utility utility = Utility.INSTANCE;
            Map<String, ? extends Object> O0X2 = o0.O0X(Utility.convertJSONObjectToHashMap(graphObject));
            Object tag = graphRequest.getTag();
            if (tag != null) {
                O0X2.put("custom_events", tag);
                StringBuilder sb = new StringBuilder();
                for (String str : O0X2.keySet()) {
                    sb.append(str);
                    sb.append(" : ");
                    sb.append(O0X2.get(str));
                    sb.append(System.getProperty("line.separator"));
                }
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb);
                return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(O0X2);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
        return null;
    }

    @x0XOIxOo
    public static final void transformGraphRequestAndSendToCAPIGEndPoint(@OOXIXo final GraphRequest request) {
        IIX0o.x0xO0oo(request, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.cloudbridge.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                AppEventsConversionsAPITransformerWebRequests.m148transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0, reason: not valid java name */
    public static final void m148transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest request) {
        List XXoO0oX2;
        IIX0o.x0xO0oo(request, "$request");
        String graphPath = request.getGraphPath();
        if (graphPath == null) {
            XXoO0oX2 = null;
        } else {
            XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(graphPath, new String[]{"/"}, false, 0, 6, null);
        }
        if (XXoO0oX2 != null && XXoO0oX2.size() == 2) {
            try {
                AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
                String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
                List<Map<String, Object>> transformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(request);
                if (transformAppEventRequestForCAPIG == null) {
                    return;
                }
                appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
                int min = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                List xXXxoI2 = CollectionsKt___CollectionsKt.xXXxoI(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new X0.oOoXoXO(0, min - 1));
                appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, min).clear();
                JSONArray jSONArray = new JSONArray((Collection) xXXxoI2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray);
                linkedHashMap.put("accessKey", appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
                JSONObject jSONObject = new JSONObject(linkedHashMap);
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String jSONObject2 = jSONObject.toString(2);
                IIX0o.oO(jSONObject2, "jsonBodyStr.toString(2)");
                companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, request, jSONObject2);
                appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", jSONObject.toString(), OI0.OOXIXo(kotlin.Xo0.oIX0oI("Content-Type", an.d)), 60000, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(xXXxoI2));
                return;
            } catch (UninitializedPropertyAccessException e) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e);
                return;
            }
        }
        Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", request);
    }

    public final void appendEvents$facebook_core_release(@oOoXoXO List<? extends Map<String, ? extends Object>> list) {
        if (list != null) {
            getTransformedEvents$facebook_core_release().addAll(list);
        }
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            setTransformedEvents$facebook_core_release(XoX.Oxx0IOOO(CollectionsKt___CollectionsKt.xIx0XO(getTransformedEvents$facebook_core_release(), max)));
        }
    }

    @OOXIXo
    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        IIX0o.XOxIOxOx("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    @OOXIXo
    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(@oOoXoXO Integer num, @OOXIXo List<? extends Map<String, ? extends Object>> processedEvents, int i) {
        IIX0o.x0xO0oo(processedEvents, "processedEvents");
        if (CollectionsKt___CollectionsKt.X00xOoXI(RETRY_EVENTS_HTTP_RESPONSE, num)) {
            if (currentRetryCount >= i) {
                getTransformedEvents$facebook_core_release().clear();
                currentRetryCount = 0;
            } else {
                getTransformedEvents$facebook_core_release().addAll(0, processedEvents);
                currentRetryCount++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a2 A[Catch: IOException -> 0x0046, UnknownHostException -> 0x0049, TRY_LEAVE, TryCatch #4 {UnknownHostException -> 0x0049, IOException -> 0x0046, blocks: (B:3:0x0012, B:5:0x001d, B:8:0x004c, B:10:0x0058, B:14:0x0068, B:16:0x00a2, B:23:0x00be, B:31:0x00c4, B:32:0x00c7, B:34:0x00c8, B:36:0x00eb, B:40:0x0025, B:43:0x002c, B:44:0x0030, B:46:0x0036, B:48:0x00f7, B:49:0x00fe), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb A[Catch: IOException -> 0x0046, UnknownHostException -> 0x0049, TryCatch #4 {UnknownHostException -> 0x0049, IOException -> 0x0046, blocks: (B:3:0x0012, B:5:0x001d, B:8:0x004c, B:10:0x0058, B:14:0x0068, B:16:0x00a2, B:23:0x00be, B:31:0x00c4, B:32:0x00c7, B:34:0x00c8, B:36:0x00eb, B:40:0x0025, B:43:0x002c, B:44:0x0030, B:46:0x0036, B:48:0x00f7, B:49:0x00fe), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void makeHttpRequest$facebook_core_release(@OXOo.OOXIXo java.lang.String r8, @OXOo.OOXIXo java.lang.String r9, @OXOo.oOoXoXO java.lang.String r10, @OXOo.oOoXoXO java.util.Map<java.lang.String, java.lang.String> r11, int r12, @OXOo.oOoXoXO Oox.x0xO0oo<? super java.lang.String, ? super java.lang.Integer, kotlin.oXIO0o0XI> r13) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, Oox.x0xO0oo):void");
    }

    public final void setCredentials$facebook_core_release(@OOXIXo CloudBridgeCredentials cloudBridgeCredentials) {
        IIX0o.x0xO0oo(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i) {
        currentRetryCount = i;
    }

    public final void setTransformedEvents$facebook_core_release(@OOXIXo List<Map<String, Object>> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        transformedEvents = list;
    }
}
