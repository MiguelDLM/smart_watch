package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.garmin.fit.xOxOoo;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import com.huawei.openalliance.ad.constant.bf;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class GraphRequest {

    @OXOo.OOXIXo
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";

    @OXOo.OOXIXo
    public static final String ACCESS_TOKEN_PARAM = "access_token";

    @OXOo.OOXIXo
    private static final String ATTACHED_FILES_PARAM = "attached_files";

    @OXOo.OOXIXo
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";

    @OXOo.OOXIXo
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";

    @OXOo.OOXIXo
    private static final String BATCH_BODY_PARAM = "body";

    @OXOo.OOXIXo
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";

    @OXOo.OOXIXo
    private static final String BATCH_ENTRY_NAME_PARAM = "name";

    @OXOo.OOXIXo
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";

    @OXOo.OOXIXo
    private static final String BATCH_METHOD_PARAM = "method";

    @OXOo.OOXIXo
    private static final String BATCH_PARAM = "batch";

    @OXOo.OOXIXo
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";

    @OXOo.OOXIXo
    private static final String CAPTION_PARAM = "caption";

    @OXOo.OOXIXo
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";

    @OXOo.OOXIXo
    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String DEBUG_KEY = "__debug__";

    @OXOo.OOXIXo
    private static final String DEBUG_MESSAGES_KEY = "messages";

    @OXOo.OOXIXo
    private static final String DEBUG_MESSAGE_KEY = "message";

    @OXOo.OOXIXo
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";

    @OXOo.OOXIXo
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";

    @OXOo.OOXIXo
    private static final String DEBUG_PARAM = "debug";

    @OXOo.OOXIXo
    private static final String DEBUG_SEVERITY_INFO = "info";

    @OXOo.OOXIXo
    private static final String DEBUG_SEVERITY_WARNING = "warning";

    @OXOo.OOXIXo
    public static final String FIELDS_PARAM = "fields";

    @OXOo.OOXIXo
    private static final String FORMAT_JSON = "json";

    @OXOo.OOXIXo
    private static final String FORMAT_PARAM = "format";

    @OXOo.OOXIXo
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;

    @OXOo.OOXIXo
    private static final String ME = "me";

    @OXOo.OOXIXo
    private static final String MIME_BOUNDARY;

    @OXOo.OOXIXo
    private static final String MY_FRIENDS = "me/friends";

    @OXOo.OOXIXo
    private static final String MY_PHOTOS = "me/photos";

    @OXOo.OOXIXo
    private static final String PICTURE_PARAM = "picture";

    @OXOo.OOXIXo
    private static final String SDK_ANDROID = "android";

    @OXOo.OOXIXo
    private static final String SDK_PARAM = "sdk";

    @OXOo.OOXIXo
    private static final String SEARCH = "search";

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String TAG;

    @OXOo.OOXIXo
    private static final String USER_AGENT_BASE = "FBAndroidSDK";

    @OXOo.OOXIXo
    private static final String USER_AGENT_HEADER = "User-Agent";

    @OXOo.OOXIXo
    private static final String VIDEOS_SUFFIX = "/videos";

    @OXOo.oOoXoXO
    private static String defaultBatchApplicationId;

    @OXOo.oOoXoXO
    private static volatile String userAgent;
    private static final Pattern versionPattern;

    @OXOo.oOoXoXO
    private AccessToken accessToken;

    @OXOo.oOoXoXO
    private String batchEntryDependsOn;

    @OXOo.oOoXoXO
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;

    @OXOo.oOoXoXO
    private Callback callback;
    private boolean forceApplicationRequest;

    @OXOo.oOoXoXO
    private JSONObject graphObject;

    @OXOo.oOoXoXO
    private String graphPath;

    @OXOo.oOoXoXO
    private HttpMethod httpMethod;

    @OXOo.oOoXoXO
    private String overriddenURL;

    @OXOo.OOXIXo
    private Bundle parameters;

    @OXOo.oOoXoXO
    private Object tag;

    @OXOo.oOoXoXO
    private String version;

    /* loaded from: classes8.dex */
    public static final class Attachment {

        @OXOo.OOXIXo
        private final GraphRequest request;

        @OXOo.oOoXoXO
        private final Object value;

        public Attachment(@OXOo.OOXIXo GraphRequest request, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(request, "request");
            this.request = request;
            this.value = obj;
        }

        @OXOo.OOXIXo
        public final GraphRequest getRequest() {
            return this.request;
        }

        @OXOo.oOoXoXO
        public final Object getValue() {
            return this.value;
        }
    }

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCompleted(@OXOo.OOXIXo GraphResponse graphResponse);
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
                httpURLConnection.setChunkedStreamingMode(0);
                return httpURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        private final String getBatchAppId(GraphRequestBatch graphRequestBatch) {
            String batchApplicationId = graphRequestBatch.getBatchApplicationId();
            if (batchApplicationId != null && !graphRequestBatch.isEmpty()) {
                return batchApplicationId;
            }
            Iterator<GraphRequest> it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = it.next().getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String str = GraphRequest.defaultBatchApplicationId;
            if (str == null || str.length() <= 0) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                return FacebookSdk.getApplicationId();
            }
            return str;
        }

        private final String getDefaultPhotoPathIfNull(String str) {
            if (str == null) {
                return GraphRequest.MY_PHOTOS;
            }
            return str;
        }

        private final String getMimeContentType() {
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            return format;
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, FacebookSdkVersion.BUILD}, 2));
                IIX0o.oO(format, "java.lang.String.format(format, *args)");
                GraphRequest.userAgent = format;
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                Utility utility = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    String format2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    IIX0o.oO(format2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.userAgent = format2;
                }
            }
            return GraphRequest.userAgent;
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
            Iterator<GraphRequestBatch.Callback> it = graphRequestBatch.getCallbacks().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof GraphRequestBatch.OnProgressCallback) {
                    return true;
                }
            }
            Iterator<GraphRequest> it2 = graphRequestBatch.iterator();
            while (it2.hasNext()) {
                if (it2.next().getCallback() instanceof OnProgressCallback) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
            Iterator<GraphRequest> it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                Iterator<String> it2 = next.getParameters().keySet().iterator();
                while (it2.hasNext()) {
                    if (isSupportedAttachmentType(next.getParameters().get(it2.next()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isMeRequest(String str) {
            Matcher matcher = GraphRequest.versionPattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                IIX0o.oO(str, "matcher.group(1)");
            }
            if (OxI.IOOoXo0Ix(str, "me/", false, 2, null) || OxI.IOOoXo0Ix(str, "/me/", false, 2, null)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object obj) {
            if (!(obj instanceof Bitmap) && !(obj instanceof byte[]) && !(obj instanceof Uri) && !(obj instanceof ParcelFileDescriptor) && !(obj instanceof ParcelableResourceWithMimeType)) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object obj) {
            if (!(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Number) && !(obj instanceof Date)) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: newMeRequest$lambda-0, reason: not valid java name */
        public static final void m119newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse response) {
            IIX0o.x0xO0oo(response, "response");
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(response.getJSONObject(), response);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: newPlacesSearchRequest$lambda-1, reason: not valid java name */
        public static final void m120newPlacesSearchRequest$lambda1(GraphJSONArrayCallback graphJSONArrayCallback, GraphResponse response) {
            JSONArray optJSONArray;
            IIX0o.x0xO0oo(response, "response");
            if (graphJSONArrayCallback != null) {
                JSONObject jSONObject = response.getJSONObject();
                if (jSONObject == null) {
                    optJSONArray = null;
                } else {
                    optJSONArray = jSONObject.optJSONArray("data");
                }
                graphJSONArrayCallback.onCompleted(optJSONArray, response);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String parameterToString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Number)) {
                if (obj instanceof Date) {
                    String format = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                    IIX0o.oO(format, "iso8601DateFormat.format(value)");
                    return format;
                }
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            return obj.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void processGraphObject(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest.KeyValueSerializer r12) {
            /*
                r9 = this;
                boolean r0 = r9.isMeRequest(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L23
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r5 = 0
                r6 = 0
                r3 = r11
                int r0 = kotlin.text.StringsKt__StringsKt.O0O0Io00X(r3, r4, r5, r6, r7, r8)
                java.lang.String r4 = "?"
                int r11 = kotlin.text.StringsKt__StringsKt.O0O0Io00X(r3, r4, r5, r6, r7, r8)
                r3 = 3
                if (r0 <= r3) goto L23
                r3 = -1
                if (r11 == r3) goto L21
                if (r0 >= r11) goto L23
            L21:
                r11 = 1
                goto L24
            L23:
                r11 = 0
            L24:
                java.util.Iterator r0 = r10.keys()
            L28:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L54
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L44
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.OxI.oX0I0O(r3, r5, r1)
                if (r5 == 0) goto L44
                r5 = 1
                goto L45
            L44:
                r5 = 0
            L45:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.IIX0o.oO(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.IIX0o.oO(r4, r6)
                r9.processGraphObjectProperty(r3, r4, r12, r5)
                goto L28
            L54:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        private final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                        String format = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        IIX0o.oO(format, "java.lang.String.format(format, *args)");
                        Object opt = jSONObject.opt(next);
                        IIX0o.oO(opt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(format, opt, keyValueSerializer, z);
                    }
                    return;
                }
                if (jSONObject.has("id")) {
                    String optString = jSONObject.optString("id");
                    IIX0o.oO(optString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, optString, keyValueSerializer, z);
                    return;
                } else if (jSONObject.has("url")) {
                    String optString2 = jSONObject.optString("url");
                    IIX0o.oO(optString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, optString2, keyValueSerializer, z);
                    return;
                } else {
                    if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                        String jSONObject2 = jSONObject.toString();
                        IIX0o.oO(jSONObject2, "jsonObject.toString()");
                        processGraphObjectProperty(str, jSONObject2, keyValueSerializer, z);
                        return;
                    }
                    return;
                }
            }
            if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
                        String format2 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
                        IIX0o.oO(format2, "java.lang.String.format(locale, format, *args)");
                        Object opt2 = jSONArray.opt(i);
                        IIX0o.oO(opt2, "jsonArray.opt(i)");
                        processGraphObjectProperty(format2, opt2, keyValueSerializer, z);
                        if (i2 < length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                if (!String.class.isAssignableFrom(cls) && !Number.class.isAssignableFrom(cls) && !Boolean.class.isAssignableFrom(cls)) {
                    if (Date.class.isAssignableFrom(cls)) {
                        String format3 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                        IIX0o.oO(format3, "iso8601DateFormat.format(date)");
                        keyValueSerializer.writeString(str, format3);
                        return;
                    }
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(GraphRequest.TAG, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
                    return;
                }
                keyValueSerializer.writeString(str, obj.toString());
            }
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
            Serializer serializer = new Serializer(outputStream, logger, z);
            if (i == 1) {
                GraphRequest graphRequest = graphRequestBatch.get(0);
                HashMap hashMap = new HashMap();
                for (String key : graphRequest.getParameters().keySet()) {
                    Object obj = graphRequest.getParameters().get(key);
                    if (isSupportedAttachmentType(obj)) {
                        IIX0o.oO(key, "key");
                        hashMap.put(key, new Attachment(graphRequest, obj));
                    }
                }
                if (logger != null) {
                    logger.append("  Parameters:\n");
                }
                serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap, serializer);
                JSONObject graphObject = graphRequest.getGraphObject();
                if (graphObject != null) {
                    String path = url.getPath();
                    IIX0o.oO(path, "url.path");
                    processGraphObject(graphObject, path, serializer);
                    return;
                }
                return;
            }
            String batchAppId = getBatchAppId(graphRequestBatch);
            if (batchAppId.length() != 0) {
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                HashMap hashMap2 = new HashMap();
                serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap2, serializer);
                return;
            }
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runCallbacks$lambda-2, reason: not valid java name */
        public static final void m121runCallbacks$lambda2(ArrayList callbacks, GraphRequestBatch requests) {
            IIX0o.x0xO0oo(callbacks, "$callbacks");
            IIX0o.x0xO0oo(requests, "$requests");
            Iterator it = callbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Callback callback = (Callback) pair.first;
                Object obj = pair.second;
                IIX0o.oO(obj, "pair.second");
                callback.onCompleted((GraphResponse) obj);
            }
            Iterator<GraphRequestBatch.Callback> it2 = requests.getCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onBatchCompleted(requests);
            }
        }

        private final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
            for (Map.Entry<String, Attachment> entry : map.entrySet()) {
                if (GraphRequest.Companion.isSupportedAttachmentType(entry.getValue().getValue())) {
                    serializer.writeObject(entry.getKey(), entry.getValue().getValue(), entry.getValue().getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (isSupportedParameterType(obj)) {
                    IIX0o.oO(key, "key");
                    serializer.writeObject(key, obj, graphRequest);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
            JSONArray jSONArray = new JSONArray();
            Iterator<GraphRequest> it = collection.iterator();
            while (it.hasNext()) {
                it.next().serializeToBatch(jSONArray, map);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, jSONArray, collection);
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
            if (z) {
                httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            } else {
                httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphResponse executeAndWait(@OXOo.OOXIXo GraphRequest request) {
            IIX0o.x0xO0oo(request, "request");
            List<GraphResponse> executeBatchAndWait = executeBatchAndWait(request);
            if (executeBatchAndWait.size() == 1) {
                return executeBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo GraphRequest... requests) {
            IIX0o.x0xO0oo(requests, "requests");
            return executeBatchAndWait(ArraysKt___ArraysKt.IoXOX(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo GraphRequest... requests) {
            IIX0o.x0xO0oo(requests, "requests");
            return executeBatchAsync(ArraysKt___ArraysKt.IoXOX(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> executeConnectionAndWait(@OXOo.OOXIXo HttpURLConnection connection, @OXOo.OOXIXo Collection<GraphRequest> requests) {
            IIX0o.x0xO0oo(connection, "connection");
            IIX0o.x0xO0oo(requests, "requests");
            return executeConnectionAndWait(connection, new GraphRequestBatch(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequestAsyncTask executeConnectionAsync(@OXOo.OOXIXo HttpURLConnection connection, @OXOo.OOXIXo GraphRequestBatch requests) {
            IIX0o.x0xO0oo(connection, "connection");
            IIX0o.x0xO0oo(requests, "requests");
            return executeConnectionAsync(null, connection, requests);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
            IIX0o.x0xO0oo(context, "context");
            if (str == null && accessToken != null) {
                str = accessToken.getApplicationId();
            }
            if (str == null) {
                Utility utility = Utility.INSTANCE;
                str = Utility.getMetadataApplicationId(context);
            }
            if (str != null) {
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(str, "/custom_audience_third_party_id");
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                Bundle bundle = new Bundle();
                if (accessToken == null) {
                    if (attributionIdentifiers != null) {
                        String attributionId = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
                        if (attributionId != null) {
                            bundle.putString("udid", attributionId);
                        }
                    } else {
                        throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                    }
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                    bundle.putString("limit_event_usage", "1");
                }
                return new GraphRequest(accessToken, XIxXXX0x02, bundle, HttpMethod.GET, callback, null, 32, null);
            }
            throw new FacebookException("Facebook App ID cannot be determined");
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newDeleteObjectRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
            return new GraphRequest(accessToken, str, null, HttpMethod.DELETE, callback, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newGraphPathRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
            return new GraphRequest(accessToken, str, null, null, callback, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newMeRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO final GraphJSONObjectCallback graphJSONObjectCallback) {
            return new GraphRequest(accessToken, "me", null, null, new Callback() { // from class: com.facebook.Oxx0xo
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.m119newMeRequest$lambda0(GraphRequest.GraphJSONObjectCallback.this, graphResponse);
                }
            }, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newMyFriendsRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO final GraphJSONArrayCallback graphJSONArrayCallback) {
            return new GraphRequest(accessToken, GraphRequest.MY_FRIENDS, null, null, new Callback() { // from class: com.facebook.GraphRequest$Companion$newMyFriendsRequest$wrapper$1
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(@OXOo.OOXIXo GraphResponse response) {
                    JSONArray optJSONArray;
                    IIX0o.x0xO0oo(response, "response");
                    if (GraphRequest.GraphJSONArrayCallback.this != null) {
                        JSONObject jSONObject = response.getJSONObject();
                        if (jSONObject == null) {
                            optJSONArray = null;
                        } else {
                            optJSONArray = jSONObject.optJSONArray("data");
                        }
                        GraphRequest.GraphJSONArrayCallback.this.onCompleted(optJSONArray, response);
                    }
                }
            }, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newPlacesSearchRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO Location location, int i, int i2, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO final GraphJSONArrayCallback graphJSONArrayCallback) {
            if (location == null) {
                Utility utility = Utility.INSTANCE;
                if (Utility.isNullOrEmpty(str)) {
                    throw new FacebookException("Either location or searchText must be specified.");
                }
            }
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", i2);
            if (location != null) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                bundle.putString(TtmlNode.CENTER, format);
                bundle.putInt(xOxOoo.f15470o00, i);
            }
            Utility utility2 = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString("q", str);
            }
            return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new Callback() { // from class: com.facebook.IXxxXO
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.m120newPlacesSearchRequest$lambda1(GraphRequest.GraphJSONArrayCallback.this, graphResponse);
                }
            }, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newPostRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback, null, 32, null);
            graphRequest.setGraphObject(jSONObject);
            return graphRequest;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newPostRequestWithBundle(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) {
            return new GraphRequest(accessToken, str, bundle, HttpMethod.POST, callback, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo Bitmap image, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) {
            IIX0o.x0xO0oo(image, "image");
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", image);
            if (str2 != null && str2.length() > 0) {
                bundle2.putString("caption", str2);
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        public final void runCallbacks$facebook_core_release(@OXOo.OOXIXo final GraphRequestBatch requests, @OXOo.OOXIXo List<GraphResponse> responses) {
            Boolean valueOf;
            IIX0o.x0xO0oo(requests, "requests");
            IIX0o.x0xO0oo(responses, "responses");
            int size = requests.size();
            final ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    GraphRequest graphRequest = requests.get(i);
                    if (graphRequest.getCallback() != null) {
                        arrayList.add(new Pair(graphRequest.getCallback(), responses.get(i)));
                    }
                    if (i2 >= size) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            if (arrayList.size() > 0) {
                Runnable runnable = new Runnable() { // from class: com.facebook.oI0IIXIo
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphRequest.Companion.m121runCallbacks$lambda2(arrayList, requests);
                    }
                };
                Handler callbackHandler = requests.getCallbackHandler();
                if (callbackHandler == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(callbackHandler.post(runnable));
                }
                if (valueOf == null) {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
        @XO0OX.x0XOIxOo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void serializeToUrlConnection$facebook_core_release(@OXOo.OOXIXo com.facebook.GraphRequestBatch r14, @OXOo.OOXIXo java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        @XO0OX.x0XOIxOo
        public final void setDefaultBatchApplicationId(@OXOo.oOoXoXO String str) {
            GraphRequest.defaultBatchApplicationId = str;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final HttpURLConnection toHttpConnection(@OXOo.OOXIXo GraphRequest... requests) {
            IIX0o.x0xO0oo(requests, "requests");
            return toHttpConnection(ArraysKt___ArraysKt.IoXOX(requests));
        }

        @XO0OX.x0XOIxOo
        public final void validateFieldsParamForGetRequests$facebook_core_release(@OXOo.OOXIXo GraphRequestBatch requests) {
            IIX0o.x0xO0oo(requests, "requests");
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                if (HttpMethod.GET == next.getHttpMethod()) {
                    Utility utility = Utility.INSTANCE;
                    if (Utility.isNullOrEmpty(next.getParameters().getString(GraphRequest.FIELDS_PARAM))) {
                        Logger.Companion companion = Logger.Companion;
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        StringBuilder sb = new StringBuilder();
                        sb.append("GET requests for /");
                        String graphPath = next.getGraphPath();
                        if (graphPath == null) {
                            graphPath = "";
                        }
                        sb.append(graphPath);
                        sb.append(" should contain an explicit \"fields\" parameter.");
                        companion.log(loggingBehavior, 5, "Request", sb.toString());
                    }
                }
            }
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo Collection<GraphRequest> requests) {
            IIX0o.x0xO0oo(requests, "requests");
            return executeBatchAndWait(new GraphRequestBatch(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo Collection<GraphRequest> requests) {
            IIX0o.x0xO0oo(requests, "requests");
            return executeBatchAsync(new GraphRequestBatch(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> executeConnectionAndWait(@OXOo.OOXIXo HttpURLConnection connection, @OXOo.OOXIXo GraphRequestBatch requests) {
            IIX0o.x0xO0oo(connection, "connection");
            IIX0o.x0xO0oo(requests, "requests");
            List<GraphResponse> fromHttpConnection$facebook_core_release = GraphResponse.Companion.fromHttpConnection$facebook_core_release(connection, requests);
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(connection);
            int size = requests.size();
            if (size == fromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(requests, fromHttpConnection$facebook_core_release);
                AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
                return fromHttpConnection$facebook_core_release;
            }
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(fromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequestAsyncTask executeConnectionAsync(@OXOo.oOoXoXO Handler handler, @OXOo.OOXIXo HttpURLConnection connection, @OXOo.OOXIXo GraphRequestBatch requests) {
            IIX0o.x0xO0oo(connection, "connection");
            IIX0o.x0xO0oo(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(connection, requests);
            requests.setCallbackHandler(handler);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final HttpURLConnection toHttpConnection(@OXOo.OOXIXo Collection<GraphRequest> requests) {
            IIX0o.x0xO0oo(requests, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmpty(requests, "requests");
            return toHttpConnection(new GraphRequestBatch(requests));
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo GraphRequestBatch requests) {
            Exception exc;
            HttpURLConnection httpURLConnection;
            List<GraphResponse> list;
            IIX0o.x0xO0oo(requests, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = toHttpConnection(requests);
                exc = null;
            } catch (Exception e) {
                exc = e;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility utility = Utility.INSTANCE;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
            try {
                if (httpURLConnection != null) {
                    list = executeConnectionAndWait(httpURLConnection, requests);
                } else {
                    List<GraphResponse> constructErrorResponses = GraphResponse.Companion.constructErrorResponses(requests.getRequests(), null, new FacebookException(exc));
                    runCallbacks$facebook_core_release(requests, constructErrorResponses);
                    list = constructErrorResponses;
                }
                Utility utility2 = Utility.INSTANCE;
                Utility.disconnectQuietly(httpURLConnection);
                return list;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                Utility utility3 = Utility.INSTANCE;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo GraphRequestBatch requests) {
            IIX0o.x0xO0oo(requests, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(requests);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final HttpURLConnection toHttpConnection(@OXOo.OOXIXo GraphRequestBatch requests) {
            URL url;
            IIX0o.x0xO0oo(requests, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(requests);
            try {
                if (requests.size() == 1) {
                    url = new URL(requests.get(0).getUrlForSingleRequest());
                } else {
                    ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(requests, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e) {
                    Utility utility = Utility.INSTANCE;
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e);
                } catch (JSONException e2) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e2);
                }
            } catch (MalformedURLException e3) {
                throw new FacebookException("could not construct URL for request", e3);
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo File file, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) throws FileNotFoundException {
            IIX0o.x0xO0oo(file, "file");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", open);
            if (str2 != null && str2.length() > 0) {
                bundle2.putString("caption", str2);
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.OOXIXo Context context, @OXOo.oOoXoXO Callback callback) {
            IIX0o.x0xO0oo(context, "context");
            return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo Uri photoUri, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) throws FileNotFoundException, FacebookException {
            IIX0o.x0xO0oo(photoUri, "photoUri");
            Utility utility = Utility.INSTANCE;
            if (Utility.isFileUri(photoUri)) {
                return newUploadPhotoRequest(accessToken, str, new File(photoUri.getPath()), str2, bundle, callback);
            }
            if (Utility.isContentUri(photoUri)) {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putParcelable("picture", photoUri);
                if (str2 != null && str2.length() > 0) {
                    bundle2.putString("caption", str2);
                }
                return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
            }
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        }
    }

    /* loaded from: classes8.dex */
    public interface GraphJSONArrayCallback {
        void onCompleted(@OXOo.oOoXoXO JSONArray jSONArray, @OXOo.oOoXoXO GraphResponse graphResponse);
    }

    /* loaded from: classes8.dex */
    public interface GraphJSONObjectCallback {
        void onCompleted(@OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO GraphResponse graphResponse);
    }

    /* loaded from: classes8.dex */
    public interface KeyValueSerializer {
        void writeString(@OXOo.OOXIXo String str, @OXOo.OOXIXo String str2);
    }

    /* loaded from: classes8.dex */
    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    /* loaded from: classes8.dex */
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {

        @OXOo.oOoXoXO
        private final String mimeType;

        @OXOo.oOoXoXO
        private final RESOURCE resource;

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        @XO0OX.XO
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType<?>>() { // from class: com.facebook.GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public GraphRequest.ParcelableResourceWithMimeType<?> createFromParcel(@OXOo.OOXIXo Parcel source) {
                IIX0o.x0xO0oo(source, "source");
                return new GraphRequest.ParcelableResourceWithMimeType<>(source, (kotlin.jvm.internal.IIXOooo) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public GraphRequest.ParcelableResourceWithMimeType<?>[] newArray(int i) {
                return new GraphRequest.ParcelableResourceWithMimeType[i];
            }
        };

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @OXOo.oOoXoXO
        public final String getMimeType() {
            return this.mimeType;
        }

        @OXOo.oOoXoXO
        public final RESOURCE getResource() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@OXOo.OOXIXo Parcel out, int i) {
            IIX0o.x0xO0oo(out, "out");
            out.writeString(this.mimeType);
            out.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, @OXOo.oOoXoXO String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    /* loaded from: classes8.dex */
    public static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite;

        @OXOo.oOoXoXO
        private final Logger logger;

        @OXOo.OOXIXo
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(@OXOo.OOXIXo OutputStream outputStream, @OXOo.oOoXoXO Logger logger, boolean z) {
            IIX0o.x0xO0oo(outputStream, "outputStream");
            this.outputStream = outputStream;
            this.logger = logger;
            this.firstWrite = true;
            this.useUrlEncode = z;
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(@OXOo.OOXIXo String format, @OXOo.OOXIXo Object... args) {
            IIX0o.x0xO0oo(format, "format");
            IIX0o.x0xO0oo(args, "args");
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    OutputStream outputStream = this.outputStream;
                    Charset charset = kotlin.text.oxoX.f29581II0xO0;
                    byte[] bytes = HelpFormatter.DEFAULT_LONG_OPT_PREFIX.getBytes(charset);
                    IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes);
                    OutputStream outputStream2 = this.outputStream;
                    String str = GraphRequest.MIME_BOUNDARY;
                    if (str != null) {
                        byte[] bytes2 = str.getBytes(charset);
                        IIX0o.oO(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream2.write(bytes2);
                        OutputStream outputStream3 = this.outputStream;
                        byte[] bytes3 = "\r\n".getBytes(charset);
                        IIX0o.oO(bytes3, "(this as java.lang.String).getBytes(charset)");
                        outputStream3.write(bytes3);
                        this.firstWrite = false;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                OutputStream outputStream4 = this.outputStream;
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                IIX0o.oO(format2, "java.lang.String.format(format, *args)");
                byte[] bytes4 = format2.getBytes(kotlin.text.oxoX.f29581II0xO0);
                IIX0o.oO(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                return;
            }
            OutputStream outputStream5 = this.outputStream;
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            Locale locale = Locale.US;
            Object[] copyOf2 = Arrays.copyOf(args, args.length);
            String format3 = String.format(locale, format, Arrays.copyOf(copyOf2, copyOf2.length));
            IIX0o.oO(format3, "java.lang.String.format(locale, format, *args)");
            String encode = URLEncoder.encode(format3, "UTF-8");
            IIX0o.oO(encode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
            byte[] bytes5 = encode.getBytes(kotlin.text.oxoX.f29581II0xO0);
            IIX0o.oO(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream5.write(bytes5);
        }

        public final void writeBitmap(@OXOo.OOXIXo String key, @OXOo.OOXIXo Bitmap bitmap) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(bitmap, "bitmap");
            writeContentDisposition(key, key, bf.Z);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                logger.appendKeyValue(IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key), "<Image>");
            }
        }

        public final void writeBytes(@OXOo.OOXIXo String key, @OXOo.OOXIXo byte[] bytes) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(bytes, "bytes");
            writeContentDisposition(key, key, "content/unknown");
            this.outputStream.write(bytes);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key);
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bytes.length)}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                logger.appendKeyValue(XIxXXX0x02, format);
            }
        }

        public final void writeContentDisposition(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", "Content-Type", str3);
                }
                writeLine("", new Object[0]);
                return;
            }
            OutputStream outputStream = this.outputStream;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            byte[] bytes = format.getBytes(kotlin.text.oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeContentUri(@OXOo.OOXIXo String key, @OXOo.OOXIXo Uri contentUri, @OXOo.oOoXoXO String str) {
            int copyAndCloseInputStream;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(contentUri, "contentUri");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                Utility utility = Utility.INSTANCE;
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(contentUri));
                copyAndCloseInputStream = 0;
            } else {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                InputStream openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri);
                Utility utility2 = Utility.INSTANCE;
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(openInputStream, this.outputStream);
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key);
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                logger.appendKeyValue(XIxXXX0x02, format);
            }
        }

        public final void writeFile(@OXOo.OOXIXo String key, @OXOo.OOXIXo ParcelFileDescriptor descriptor, @OXOo.oOoXoXO String str) {
            int copyAndCloseInputStream;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(descriptor, "descriptor");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            OutputStream outputStream = this.outputStream;
            if (outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream).addProgress(descriptor.getStatSize());
                copyAndCloseInputStream = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(descriptor);
                Utility utility = Utility.INSTANCE;
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(autoCloseInputStream, this.outputStream);
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key);
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                logger.appendKeyValue(XIxXXX0x02, format);
            }
        }

        public final void writeLine(@OXOo.OOXIXo String format, @OXOo.OOXIXo Object... args) {
            IIX0o.x0xO0oo(format, "format");
            IIX0o.x0xO0oo(args, "args");
            write(format, Arrays.copyOf(args, args.length));
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }

        public final void writeObject(@OXOo.OOXIXo String key, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO GraphRequest graphRequest) {
            IIX0o.x0xO0oo(key, "key");
            Closeable closeable = this.outputStream;
            if (closeable instanceof RequestOutputStream) {
                ((RequestOutputStream) closeable).setCurrentRequest(graphRequest);
            }
            Companion companion = GraphRequest.Companion;
            if (companion.isSupportedParameterType(obj)) {
                writeString(key, companion.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                writeBitmap(key, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                writeBytes(key, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                writeContentUri(key, (Uri) obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) obj, null);
                return;
            }
            if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(key, (ParcelFileDescriptor) resource, mimeType);
                    return;
                } else {
                    if (resource instanceof Uri) {
                        writeContentUri(key, (Uri) resource, mimeType);
                        return;
                    }
                    throw getInvalidTypeError();
                }
            }
            throw getInvalidTypeError();
        }

        public final void writeRecordBoundary() {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream = this.outputStream;
            byte[] bytes = "&".getBytes(kotlin.text.oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeRequestsAsJson(@OXOo.OOXIXo String key, @OXOo.OOXIXo JSONArray requestJsonArray, @OXOo.OOXIXo Collection<GraphRequest> requests) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(requestJsonArray, "requestJsonArray");
            IIX0o.x0xO0oo(requests, "requests");
            Closeable closeable = this.outputStream;
            if (!(closeable instanceof RequestOutputStream)) {
                String jSONArray = requestJsonArray.toString();
                IIX0o.oO(jSONArray, "requestJsonArray.toString()");
                writeString(key, jSONArray);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) closeable;
            writeContentDisposition(key, null, null);
            write("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : requests) {
                int i2 = i + 1;
                JSONObject jSONObject = requestJsonArray.getJSONObject(i);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i = i2;
            }
            write("]", new Object[0]);
            Logger logger = this.logger;
            if (logger != null) {
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key);
                String jSONArray2 = requestJsonArray.toString();
                IIX0o.oO(jSONArray2, "requestJsonArray.toString()");
                logger.appendKeyValue(XIxXXX0x02, jSONArray2);
            }
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(@OXOo.OOXIXo String key, @OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                logger.appendKeyValue(IIX0o.XIxXXX0x0(OIII0O.OOXIXo.f1567xI, key), value);
            }
        }
    }

    static {
        String simpleName = GraphRequest.class.getSimpleName();
        IIX0o.oO(simpleName, "GraphRequest::class.java.simpleName");
        TAG = simpleName;
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        IIX0o.oO(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        if (nextInt > 0) {
            int i = 0;
            do {
                i++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i < nextInt);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "buffer.toString()");
        MIME_BOUNDARY = sb2;
        versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    @XO0OX.xoIox
    public GraphRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _set_callback_$lambda-0, reason: not valid java name */
    public static final void m118_set_callback_$lambda0(Callback callback, GraphResponse response) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        int length;
        String optString;
        String optString2;
        String optString3;
        IIX0o.x0xO0oo(response, "response");
        JSONObject jSONObject = response.getJSONObject();
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject(DEBUG_KEY);
        }
        if (optJSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = optJSONObject.optJSONArray(DEBUG_MESSAGES_KEY);
        }
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 == null) {
                    optString = null;
                } else {
                    optString = optJSONObject2.optString("message");
                }
                if (optJSONObject2 == null) {
                    optString2 = null;
                } else {
                    optString2 = optJSONObject2.optString("type");
                }
                if (optJSONObject2 == null) {
                    optString3 = null;
                } else {
                    optString3 = optJSONObject2.optString("link");
                }
                if (optString != null && optString2 != null) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if (IIX0o.Oxx0IOOO(optString2, DEBUG_SEVERITY_WARNING)) {
                        loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                    }
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(optString3)) {
                        optString = ((Object) optString) + " Link: " + ((Object) optString3);
                    }
                    Logger.Companion.log(loggingBehavior, TAG, optString);
                }
                if (i2 >= length) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        if (callback != null) {
            callback.onCompleted(response);
        }
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token")) {
            Utility utility = Utility.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                Log.w(TAG, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString(FORMAT_PARAM, FORMAT_JSON);
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString("debug", DEBUG_SEVERITY_INFO);
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString("debug", DEBUG_SEVERITY_WARNING);
        }
    }

    private final String appendParametersToBaseUrl(String str, boolean z) {
        if (!z && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            Companion companion = Companion;
            if (companion.isSupportedParameterType(obj)) {
                buildUpon.appendQueryParameter(str2, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format);
            }
        }
        String builder = buildUpon.toString();
        IIX0o.oO(builder, "uriBuilder.toString()");
        return builder;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphResponse executeAndWait(@OXOo.OOXIXo GraphRequest graphRequest) {
        return Companion.executeAndWait(graphRequest);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAndWait(graphRequestBatch);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAsync(graphRequestBatch);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> executeConnectionAndWait(@OXOo.OOXIXo HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAndWait(httpURLConnection, graphRequestBatch);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequestAsyncTask executeConnectionAsync(@OXOo.oOoXoXO Handler handler, @OXOo.OOXIXo HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(handler, httpURLConnection, graphRequestBatch);
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken.getToken();
                Logger.Companion.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String clientToken = FacebookSdk.getClientToken();
        if (applicationId.length() > 0 && clientToken.length() > 0) {
            return applicationId + '|' + clientToken;
        }
        Utility utility = Utility.INSTANCE;
        Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getDefaultBatchApplicationId() {
        return Companion.getDefaultBatchApplicationId();
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String getUrlWithGraphPath(String str) {
        if (!isValidGraphRequestForDomain()) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            str = ServerProtocol.getFacebookGraphUrlBase();
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{str, getGraphPathWithVersion()}, 2));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("^/?");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        sb.append(FacebookSdk.getApplicationId());
        sb.append("/?.*");
        String sb2 = sb.toString();
        if (!this.forceApplicationRequest && !Pattern.matches(sb2, this.graphPath) && !Pattern.matches("^/?app/?.*", this.graphPath)) {
            return false;
        }
        return true;
    }

    private final boolean isValidGraphRequestForDomain() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!IIX0o.Oxx0IOOO(FacebookSdk.getGraphDomain(), FacebookSdk.INSTAGRAM_COM)) {
            return true;
        }
        return !isApplicationRequest();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.OOXIXo Context context, @OXOo.oOoXoXO Callback callback) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken, context, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newDeleteObjectRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
        return Companion.newDeleteObjectRequest(accessToken, str, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newGraphPathRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
        return Companion.newGraphPathRequest(accessToken, str, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newMeRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO GraphJSONObjectCallback graphJSONObjectCallback) {
        return Companion.newMeRequest(accessToken, graphJSONObjectCallback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newMyFriendsRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newMyFriendsRequest(accessToken, graphJSONArrayCallback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newPlacesSearchRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO Location location, int i, int i2, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newPlacesSearchRequest(accessToken, location, i, i2, str, graphJSONArrayCallback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newPostRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO Callback callback) {
        return Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newPostRequestWithBundle(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) {
        return Companion.newPostRequestWithBundle(accessToken, str, bundle, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo Bitmap bitmap, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) {
        return Companion.newUploadPhotoRequest(accessToken, str, bitmap, str2, bundle, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            Logger.Companion.registerAccessToken(accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get(it.next());
            if (Companion.isSupportedAttachmentType(obj)) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.graphObject;
        if (jSONObject2 != null) {
            final ArrayList arrayList2 = new ArrayList();
            Companion.processGraphObject(jSONObject2, relativeUrlForBatchedRequest, new KeyValueSerializer() { // from class: com.facebook.GraphRequest$serializeToBatch$1
                @Override // com.facebook.GraphRequest.KeyValueSerializer
                public void writeString(@OXOo.OOXIXo String key, @OXOo.OOXIXo String value) throws IOException {
                    IIX0o.x0xO0oo(key, "key");
                    IIX0o.x0xO0oo(value, "value");
                    ArrayList<String> arrayList3 = arrayList2;
                    oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
                    String format2 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{key, URLEncoder.encode(value, "UTF-8")}, 2));
                    IIX0o.oO(format2, "java.lang.String.format(locale, format, *args)");
                    arrayList3.add(format2);
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    @XO0OX.x0XOIxOo
    public static final void setDefaultBatchApplicationId(@OXOo.oOoXoXO String str) {
        Companion.setDefaultBatchApplicationId(str);
    }

    private final boolean shouldForceClientTokenForRequest() {
        boolean o00xOoIO2;
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        if (accessTokenToUseForRequest == null) {
            o00xOoIO2 = false;
        } else {
            o00xOoIO2 = StringsKt__StringsKt.o00xOoIO(accessTokenToUseForRequest, "|", false, 2, null);
        }
        if (accessTokenToUseForRequest != null && OxI.IOOoXo0Ix(accessTokenToUseForRequest, "IG", false, 2, null) && !o00xOoIO2 && isApplicationRequest()) {
            return true;
        }
        if (isValidGraphRequestForDomain() || o00xOoIO2) {
            return false;
        }
        return true;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final HttpURLConnection toHttpConnection(@OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.toHttpConnection(graphRequestBatch);
    }

    @OXOo.OOXIXo
    public final GraphRequestAsyncTask executeAsync() {
        return Companion.executeBatchAsync(this);
    }

    @OXOo.oOoXoXO
    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    @OXOo.oOoXoXO
    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    @OXOo.oOoXoXO
    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    @OXOo.oOoXoXO
    public final Callback getCallback() {
        return this.callback;
    }

    @OXOo.oOoXoXO
    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    @OXOo.oOoXoXO
    public final String getGraphPath() {
        return this.graphPath;
    }

    @OXOo.oOoXoXO
    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @OXOo.OOXIXo
    public final Bundle getParameters() {
        return this.parameters;
    }

    @OXOo.OOXIXo
    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL == null) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
            addCommonParameters();
            Uri parse = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            return format;
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    @OXOo.oOoXoXO
    public final Object getTag() {
        return this.tag;
    }

    @OXOo.OOXIXo
    public final String getUrlForSingleRequest() {
        String graphUrlBaseForSubdomain;
        String str = this.overriddenURL;
        if (str != null) {
            return String.valueOf(str);
        }
        String str2 = this.graphPath;
        if (this.httpMethod == HttpMethod.POST && str2 != null && OxI.XO0o(str2, VIDEOS_SUFFIX, false, 2, null)) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            graphUrlBaseForSubdomain = ServerProtocol.getGraphVideoUrlBase();
        } else {
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphUrlBaseForSubdomain = ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain());
        }
        String urlWithGraphPath = getUrlWithGraphPath(graphUrlBaseForSubdomain);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    @OXOo.oOoXoXO
    public final String getVersion() {
        return this.version;
    }

    public final void setAccessToken(@OXOo.oOoXoXO AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public final void setBatchEntryDependsOn(@OXOo.oOoXoXO String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(@OXOo.oOoXoXO String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public final void setCallback(@OXOo.oOoXoXO final Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = callback;
        } else {
            this.callback = new Callback() { // from class: com.facebook.x0xO0oo
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.m118_set_callback_$lambda0(GraphRequest.Callback.this, graphResponse);
                }
            };
        }
    }

    public final void setForceApplicationRequest(boolean z) {
        this.forceApplicationRequest = z;
    }

    public final void setGraphObject(@OXOo.oOoXoXO JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final void setGraphPath(@OXOo.oOoXoXO String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(@OXOo.oOoXoXO HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final void setParameters(@OXOo.OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final void setTag(@OXOo.oOoXoXO Object obj) {
        this.tag = obj;
    }

    public final void setVersion(@OXOo.oOoXoXO String str) {
        this.version = str;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return sb2;
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken) {
        this(accessToken, null, null, null, null, null, 62, null);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo Collection<GraphRequest> collection) {
        return Companion.executeBatchAndWait(collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo Collection<GraphRequest> collection) {
        return Companion.executeBatchAsync(collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> executeConnectionAndWait(@OXOo.OOXIXo HttpURLConnection httpURLConnection, @OXOo.OOXIXo Collection<GraphRequest> collection) {
        return Companion.executeConnectionAndWait(httpURLConnection, collection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequestAsyncTask executeConnectionAsync(@OXOo.OOXIXo HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(httpURLConnection, graphRequestBatch);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Callback callback) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken, context, str, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) throws FileNotFoundException, FacebookException {
        return Companion.newUploadPhotoRequest(accessToken, str, uri, str2, bundle, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final HttpURLConnection toHttpConnection(@OXOo.OOXIXo Collection<GraphRequest> collection) {
        return Companion.toHttpConnection(collection);
    }

    @OXOo.OOXIXo
    public final GraphResponse executeAndWait() {
        return Companion.executeAndWait(this);
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str) {
        this(accessToken, str, null, null, null, null, 60, null);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> executeBatchAndWait(@OXOo.OOXIXo GraphRequest... graphRequestArr) {
        return Companion.executeBatchAndWait(graphRequestArr);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequestAsyncTask executeBatchAsync(@OXOo.OOXIXo GraphRequest... graphRequestArr) {
        return Companion.executeBatchAsync(graphRequestArr);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final GraphRequest newUploadPhotoRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.OOXIXo File file, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Callback callback) throws FileNotFoundException {
        return Companion.newUploadPhotoRequest(accessToken, str, file, str2, bundle, callback);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final HttpURLConnection toHttpConnection(@OXOo.OOXIXo GraphRequest... graphRequestArr) {
        return Companion.toHttpConnection(graphRequestArr);
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        this(accessToken, str, bundle, null, null, null, 56, null);
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null, null, 48, null);
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO HttpMethod httpMethod, @OXOo.oOoXoXO Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null, 32, null);
    }

    public /* synthetic */ GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : accessToken, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bundle, (i & 8) != 0 ? null : httpMethod, (i & 16) != 0 ? null : callback, (i & 32) != 0 ? null : str2);
    }

    @XO0OX.xoIox
    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO HttpMethod httpMethod, @OXOo.oOoXoXO Callback callback, @OXOo.oOoXoXO String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    public GraphRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.OOXIXo URL overriddenURL) {
        IIX0o.x0xO0oo(overriddenURL, "overriddenURL");
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.overriddenURL = overriddenURL.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }
}
