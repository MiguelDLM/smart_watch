package com.facebook;

import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes8.dex */
public final class GraphResponse {

    @OXOo.OOXIXo
    private static final String BODY_KEY = "body";

    @OXOo.OOXIXo
    private static final String CODE_KEY = "code";

    @OXOo.OOXIXo
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";

    @OXOo.OOXIXo
    private static final String RESPONSE_LOG_TAG = "Response";

    @OXOo.OOXIXo
    public static final String SUCCESS_KEY = "success";

    @OXOo.oOoXoXO
    private final HttpURLConnection connection;

    @OXOo.oOoXoXO
    private final FacebookRequestError error;

    @OXOo.oOoXoXO
    private final JSONObject graphObject;

    @OXOo.oOoXoXO
    private final JSONArray graphObjectArray;

    @OXOo.oOoXoXO
    private final JSONArray jsonArray;

    @OXOo.oOoXoXO
    private final JSONObject jsonObject;

    @OXOo.oOoXoXO
    private final String rawResponse;

    @OXOo.OOXIXo
    private final GraphRequest request;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private static final String TAG = GraphResponse.class.getCanonicalName();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private final GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object NULL, Object obj) throws JSONException {
            Boolean bool = null;
            if (NULL instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) NULL;
                FacebookRequestError checkResponseAndCreateError = FacebookRequestError.Companion.checkResponseAndCreateError(jSONObject, obj, httpURLConnection);
                if (checkResponseAndCreateError != null) {
                    Log.e(GraphResponse.TAG, checkResponseAndCreateError.toString());
                    if (checkResponseAndCreateError.getErrorCode() == 190) {
                        Utility utility = Utility.INSTANCE;
                        if (Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                            if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                                AccessToken.Companion.setCurrentAccessToken(null);
                            } else {
                                AccessToken.Companion companion = AccessToken.Companion;
                                AccessToken currentAccessToken = companion.getCurrentAccessToken();
                                if (currentAccessToken != null) {
                                    bool = Boolean.valueOf(currentAccessToken.isExpired());
                                }
                                if (IIX0o.Oxx0IOOO(bool, Boolean.FALSE)) {
                                    companion.expireCurrentAccessToken();
                                }
                            }
                        }
                    }
                    return new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                }
                Utility utility2 = Utility.INSTANCE;
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONObject2.toString(), jSONObject2);
                }
                if (stringPropertyAsJSON instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONArray.toString(), jSONArray);
                }
                NULL = JSONObject.NULL;
                IIX0o.oO(NULL, "NULL");
            }
            if (NULL == JSONObject.NULL) {
                return new GraphResponse(graphRequest, httpURLConnection, NULL.toString(), (JSONObject) null);
            }
            throw new FacebookException(IIX0o.XIxXXX0x0("Got unexpected object type in response, class: ", NULL.getClass().getSimpleName()));
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.util.List<com.facebook.GraphResponse> createResponsesFromObject(java.net.HttpURLConnection r9, java.util.List<com.facebook.GraphRequest> r10, java.lang.Object r11) throws com.facebook.FacebookException, org.json.JSONException {
            /*
                r8 = this;
                int r0 = r10.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 1
                r3 = 0
                if (r0 != r2) goto L53
                java.lang.Object r2 = r10.get(r3)
                com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                r4.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                java.lang.String r5 = "body"
                r4.put(r5, r11)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                if (r9 != 0) goto L22
                r5 = 200(0xc8, float:2.8E-43)
                goto L26
            L22:
                int r5 = r9.getResponseCode()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
            L26:
                java.lang.String r6 = "code"
                r4.put(r6, r5)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                r5.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                r5.put(r4)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L36
                goto L54
            L34:
                r4 = move-exception
                goto L38
            L36:
                r4 = move-exception
                goto L46
            L38:
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r9, r4)
                r5.<init>(r2, r9, r6)
                r1.add(r5)
                goto L53
            L46:
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r9, r4)
                r5.<init>(r2, r9, r6)
                r1.add(r5)
            L53:
                r5 = r11
            L54:
                boolean r2 = r5 instanceof org.json.JSONArray
                if (r2 == 0) goto La8
                r2 = r5
                org.json.JSONArray r2 = (org.json.JSONArray) r2
                int r4 = r2.length()
                if (r4 != r0) goto La8
                int r0 = r2.length()
                if (r0 <= 0) goto La7
            L67:
                int r2 = r3 + 1
                java.lang.Object r4 = r10.get(r3)
                com.facebook.GraphRequest r4 = (com.facebook.GraphRequest) r4
                r6 = r5
                org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch: com.facebook.FacebookException -> L83 org.json.JSONException -> L85
                java.lang.Object r3 = r6.get(r3)     // Catch: com.facebook.FacebookException -> L83 org.json.JSONException -> L85
                java.lang.String r6 = "obj"
                kotlin.jvm.internal.IIX0o.oO(r3, r6)     // Catch: com.facebook.FacebookException -> L83 org.json.JSONException -> L85
                com.facebook.GraphResponse r3 = r8.createResponseFromObject(r4, r9, r3, r11)     // Catch: com.facebook.FacebookException -> L83 org.json.JSONException -> L85
                r1.add(r3)     // Catch: com.facebook.FacebookException -> L83 org.json.JSONException -> L85
                goto La2
            L83:
                r3 = move-exception
                goto L87
            L85:
                r3 = move-exception
                goto L95
            L87:
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>(r9, r3)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
                goto La2
            L95:
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>(r9, r3)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
            La2:
                if (r2 < r0) goto La5
                goto La7
            La5:
                r3 = r2
                goto L67
            La7:
                return r1
            La8:
                com.facebook.FacebookException r9 = new com.facebook.FacebookException
                java.lang.String r10 = "Unexpected number of results"
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.Companion.createResponsesFromObject(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> constructErrorResponses(@OXOo.OOXIXo List<GraphRequest> requests, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.oOoXoXO FacebookException facebookException) {
            IIX0o.x0xO0oo(requests, "requests");
            List<GraphRequest> list = requests;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GraphResponse((GraphRequest) it.next(), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
            }
            return arrayList;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> createResponsesFromStream$facebook_core_release(@OXOo.oOoXoXO InputStream inputStream, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch requests) throws FacebookException, JSONException, IOException {
            IIX0o.x0xO0oo(requests, "requests");
            Utility utility = Utility.INSTANCE;
            String readStreamToString = Utility.readStreamToString(inputStream);
            Logger.Companion.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, GraphResponse.RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
            return createResponsesFromString$facebook_core_release(readStreamToString, httpURLConnection, requests);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> createResponsesFromString$facebook_core_release(@OXOo.OOXIXo String responseString, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo GraphRequestBatch requests) throws FacebookException, JSONException, IOException {
            IIX0o.x0xO0oo(responseString, "responseString");
            IIX0o.x0xO0oo(requests, "requests");
            Object resultObject = new JSONTokener(responseString).nextValue();
            IIX0o.oO(resultObject, "resultObject");
            List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, requests, resultObject);
            Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requests.getId(), Integer.valueOf(responseString.length()), createResponsesFromObject);
            return createResponsesFromObject;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final List<GraphResponse> fromHttpConnection$facebook_core_release(@OXOo.OOXIXo HttpURLConnection connection, @OXOo.OOXIXo GraphRequestBatch requests) {
            List<GraphResponse> constructErrorResponses;
            IIX0o.x0xO0oo(connection, "connection");
            IIX0o.x0xO0oo(requests, "requests");
            InputStream inputStream = null;
            try {
                try {
                    try {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    } catch (Exception e) {
                        Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e);
                        constructErrorResponses = constructErrorResponses(requests, connection, new FacebookException(e));
                    }
                } catch (FacebookException e2) {
                    Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
                    constructErrorResponses = constructErrorResponses(requests, connection, e2);
                }
                if (FacebookSdk.isFullyInitialized()) {
                    if (connection.getResponseCode() >= 400) {
                        inputStream = connection.getErrorStream();
                    } else {
                        inputStream = connection.getInputStream();
                    }
                    constructErrorResponses = createResponsesFromStream$facebook_core_release(inputStream, connection, requests);
                    Utility utility = Utility.INSTANCE;
                    Utility.closeQuietly(inputStream);
                    return constructErrorResponses;
                }
                Log.e(GraphResponse.TAG, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (Throwable th) {
                Utility utility2 = Utility.INSTANCE;
                Utility.closeQuietly(null);
                throw th;
            }
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum PagingDirection {
        NEXT,
        PREVIOUS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static PagingDirection[] valuesCustom() {
            PagingDirection[] valuesCustom = values();
            return (PagingDirection[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public GraphResponse(@OXOo.OOXIXo GraphRequest request, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO JSONArray jSONArray, @OXOo.oOoXoXO FacebookRequestError facebookRequestError) {
        IIX0o.x0xO0oo(request, "request");
        this.request = request;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
        this.jsonArray = jSONArray;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphResponse> constructErrorResponses(@OXOo.OOXIXo List<GraphRequest> list, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.oOoXoXO FacebookException facebookException) {
        return Companion.constructErrorResponses(list, httpURLConnection, facebookException);
    }

    @OXOo.oOoXoXO
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    @OXOo.oOoXoXO
    public final FacebookRequestError getError() {
        return this.error;
    }

    @OXOo.oOoXoXO
    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    @OXOo.oOoXoXO
    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    @OXOo.oOoXoXO
    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    @OXOo.oOoXoXO
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @OXOo.oOoXoXO
    public final String getRawResponse() {
        return this.rawResponse;
    }

    @OXOo.OOXIXo
    public final GraphRequest getRequest() {
        return this.request;
    }

    @OXOo.oOoXoXO
    public final GraphRequest getRequestForPagedResults(@OXOo.OOXIXo PagingDirection direction) {
        String str;
        JSONObject optJSONObject;
        IIX0o.x0xO0oo(direction, "direction");
        JSONObject jSONObject = this.graphObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("paging")) != null) {
            if (direction == PagingDirection.NEXT) {
                str = optJSONObject.optString("next");
            } else {
                str = optJSONObject.optString("previous");
            }
        } else {
            str = null;
        }
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && IIX0o.Oxx0IOOO(str, this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        String str;
        int responseCode;
        try {
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection == null) {
                responseCode = 200;
            } else {
                responseCode = httpURLConnection.getResponseCode();
            }
            str = String.format(locale, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(responseCode)}, 1));
            IIX0o.oO(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response:  responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(@OXOo.OOXIXo GraphRequest request, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo String rawResponse, @OXOo.oOoXoXO JSONObject jSONObject) {
        this(request, httpURLConnection, rawResponse, jSONObject, null, null);
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(rawResponse, "rawResponse");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(@OXOo.OOXIXo GraphRequest request, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo String rawResponse, @OXOo.OOXIXo JSONArray graphObjects) {
        this(request, httpURLConnection, rawResponse, null, graphObjects, null);
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(rawResponse, "rawResponse");
        IIX0o.x0xO0oo(graphObjects, "graphObjects");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(@OXOo.OOXIXo GraphRequest request, @OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.OOXIXo FacebookRequestError error) {
        this(request, httpURLConnection, null, null, null, error);
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(error, "error");
    }
}
