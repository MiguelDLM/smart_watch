package com.baidu.datahub;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HttpClient {
    public static final String HTTP_CLIENT_ERROR = "请求异常";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_NETWORK_ERROR = "网络异常";
    public static final String HTTP_SERVER_ERROE = "服务异常";
    public static final String HTTP_UNKONW_ERROR = "未知异常";
    private static final String TAG = "HttpClient";
    public static boolean isHttpsEnable = true;
    public static Context mContext;
    private ProtoResultCallBack callback;
    private HttpURLConnection connection;
    private int mReadTimeOut;
    private int maxTimeOut;
    private String method;
    private String mUrlStr = null;
    private String mResult = null;
    private HttpStateError error = HttpStateError.NO_ERROR;
    private ContentType contentType = ContentType.FORM_DATA;

    /* renamed from: com.baidu.datahub.HttpClient$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$datahub$HttpClient$ContentType;

        static {
            int[] iArr = new int[ContentType.values().length];
            $SwitchMap$com$baidu$datahub$HttpClient$ContentType = iArr;
            try {
                iArr[ContentType.FORM_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$datahub$HttpClient$ContentType[ContentType.JSON_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum ContentType {
        FORM_DATA,
        JSON_DATA
    }

    /* loaded from: classes7.dex */
    public class ErrorType {
        static final int APP_DISABLED_BY_ADMIN = 202;
        static final int APP_SERVER_DISABLED_BY_ADMIN = 240;
        static final int DAY_QUOTA_OVER_LIMIT = 302;
        static final int NO_ERROR = 0;
        static final int ORDER_ATTR_DISMATCH = 1102;
        static final int ORDER_EXIST = 1100;
        static final int ORDER_INVALID = 1101;
        static final int PARAMETER_ERROR = 1000;
        static final int PARENT_ORDER_FINISH = 1106;
        static final int PARENT_ORDER_NOT_EXIST = 1105;
        static final int PART_ORDERS_REG_FAILED = 1104;
        static final int SERVER_INNER = 1;
        static final int SESSION_ROUTE_INVALID = 1200;
        static final int USER_DELETED_BY_ADMIN = 252;

        public ErrorType() {
        }
    }

    /* loaded from: classes7.dex */
    public enum HttpStateError {
        NO_ERROR(0),
        NETWORK_ERROR(-2),
        INNER_ERROR(-3),
        URL_ERROR(-4),
        REQUEST_ERROR(400),
        SERVER_ERROR(500),
        SERVER_INNER(1),
        APP_DISABLED_BY_ADMIN(202),
        APP_SERVER_DISABLED_BY_ADMIN(240),
        USER_DELETED_BY_ADMIN(252),
        DAY_QUOTA_OVER_LIMIT(302),
        PARAM_ERROR(1000),
        ORDER_EXIST(1100),
        ORDER_NOT_EXIST(1101),
        ORDER_ATTR_DISMATCH(1102),
        PART_ORDERS_REG_FAILED(1104),
        PARENT_ORDER_NOT_EXIST(1105),
        PARENT_ORDER_FINISH(1106),
        NO_ROUTE_IN_THE_STATE(1201);

        private int value;

        HttpStateError(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class ProtoResultCallBack {
        public abstract void onFailed(HttpStateError httpStateError, String str);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallBack protoResultCallBack) {
        this.method = str;
        this.callback = protoResultCallBack;
    }

    private boolean handleResponseMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i != 0) {
                    if (i != 1) {
                        if (i != 202) {
                            if (i != 240) {
                                if (i != 252) {
                                    if (i != 302) {
                                        if (i != 1000) {
                                            if (i != 1200) {
                                                switch (i) {
                                                    case 1100:
                                                        BDLog.e(TAG, "order already exist");
                                                        this.error = HttpStateError.ORDER_EXIST;
                                                        return true;
                                                    case 1101:
                                                        BDLog.e(TAG, "order doesn't exist");
                                                        this.error = HttpStateError.ORDER_NOT_EXIST;
                                                        break;
                                                    case 1102:
                                                        BDLog.e(TAG, "orderInfo attributes dismatch");
                                                        this.error = HttpStateError.ORDER_ATTR_DISMATCH;
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 1104:
                                                                BDLog.e(TAG, "part of orders register failed");
                                                                this.error = HttpStateError.PART_ORDERS_REG_FAILED;
                                                                break;
                                                            case 1105:
                                                                BDLog.e(TAG, "parent order not exist");
                                                                this.error = HttpStateError.PARENT_ORDER_NOT_EXIST;
                                                                break;
                                                            case 1106:
                                                                BDLog.e(TAG, "parent order finish");
                                                                this.error = HttpStateError.PARENT_ORDER_FINISH;
                                                                break;
                                                        }
                                                }
                                            } else {
                                                BDLog.e(TAG, "invalid session_id or route_id");
                                                this.error = HttpStateError.PARAM_ERROR;
                                            }
                                        } else {
                                            BDLog.e(TAG, "parameter error");
                                            this.error = HttpStateError.PARAM_ERROR;
                                        }
                                    } else {
                                        BDLog.e(TAG, "day quota is over limit");
                                        this.error = HttpStateError.DAY_QUOTA_OVER_LIMIT;
                                    }
                                } else {
                                    BDLog.e(TAG, "user is deleted by admin");
                                    this.error = HttpStateError.USER_DELETED_BY_ADMIN;
                                }
                            } else {
                                BDLog.e(TAG, "app server is disabled by admin");
                                this.error = HttpStateError.APP_SERVER_DISABLED_BY_ADMIN;
                            }
                        } else {
                            BDLog.e(TAG, "app is disabled by admin");
                            this.error = HttpStateError.APP_DISABLED_BY_ADMIN;
                        }
                    } else {
                        this.error = HttpStateError.SERVER_INNER;
                        BDLog.e(TAG, "Server inner error");
                    }
                } else {
                    this.error = HttpStateError.NO_ERROR;
                    return true;
                }
            }
        } catch (JSONException e) {
            BDLog.e(TAG, "Parse json happened exception");
            e.printStackTrace();
        }
        return false;
    }

    private HttpURLConnection initHttpsUrlConnection(ContentType contentType) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.mUrlStr);
            if (isHttpsEnable) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.datahub.HttpClient.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                    }
                });
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.method);
            if (this.method.equals("POST")) {
                httpURLConnection.setDoOutput(true);
                setContentType(httpURLConnection, contentType);
            } else if (this.method.equals("GET")) {
                httpURLConnection.setDoOutput(false);
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.maxTimeOut);
            httpURLConnection.setReadTimeout(this.mReadTimeOut);
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setContentType(URLConnection uRLConnection, ContentType contentType) {
        if (uRLConnection != null && contentType != null && AnonymousClass2.$SwitchMap$com$baidu$datahub$HttpClient$ContentType[contentType.ordinal()] == 2) {
            uRLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        }
    }

    public boolean checkNetwork() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        try {
            Context context = mContext;
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                    return false;
                }
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0138 A[Catch: Exception -> 0x00bd, TRY_ENTER, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0044, B:33:0x00b9, B:35:0x00c2, B:36:0x00c8, B:38:0x00cc, B:43:0x00d2, B:45:0x00d7, B:46:0x00dd, B:48:0x00e1, B:69:0x0152, B:72:0x0159, B:73:0x015f, B:75:0x0163, B:76:0x0166, B:55:0x0138, B:58:0x013f, B:59:0x0145, B:61:0x0149, B:90:0x011b, B:91:0x011e, B:93:0x0122), top: B:14:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0149 A[Catch: Exception -> 0x00bd, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0044, B:33:0x00b9, B:35:0x00c2, B:36:0x00c8, B:38:0x00cc, B:43:0x00d2, B:45:0x00d7, B:46:0x00dd, B:48:0x00e1, B:69:0x0152, B:72:0x0159, B:73:0x015f, B:75:0x0163, B:76:0x0166, B:55:0x0138, B:58:0x013f, B:59:0x0145, B:61:0x0149, B:90:0x011b, B:91:0x011e, B:93:0x0122), top: B:14:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0152 A[Catch: Exception -> 0x00bd, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0044, B:33:0x00b9, B:35:0x00c2, B:36:0x00c8, B:38:0x00cc, B:43:0x00d2, B:45:0x00d7, B:46:0x00dd, B:48:0x00e1, B:69:0x0152, B:72:0x0159, B:73:0x015f, B:75:0x0163, B:76:0x0166, B:55:0x0138, B:58:0x013f, B:59:0x0145, B:61:0x0149, B:90:0x011b, B:91:0x011e, B:93:0x0122), top: B:14:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0163 A[Catch: Exception -> 0x00bd, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0044, B:33:0x00b9, B:35:0x00c2, B:36:0x00c8, B:38:0x00cc, B:43:0x00d2, B:45:0x00d7, B:46:0x00dd, B:48:0x00e1, B:69:0x0152, B:72:0x0159, B:73:0x015f, B:75:0x0163, B:76:0x0166, B:55:0x0138, B:58:0x013f, B:59:0x0145, B:61:0x0149, B:90:0x011b, B:91:0x011e, B:93:0x0122), top: B:14:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[Catch: Exception -> 0x00bd, SYNTHETIC, TRY_LEAVE, TryCatch #1 {Exception -> 0x00bd, blocks: (B:15:0x0044, B:33:0x00b9, B:35:0x00c2, B:36:0x00c8, B:38:0x00cc, B:43:0x00d2, B:45:0x00d7, B:46:0x00dd, B:48:0x00e1, B:69:0x0152, B:72:0x0159, B:73:0x015f, B:75:0x0163, B:76:0x0166, B:55:0x0138, B:58:0x013f, B:59:0x0145, B:61:0x0149, B:90:0x011b, B:91:0x011e, B:93:0x0122), top: B:14:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void request(java.lang.String r7, java.lang.String r8, com.baidu.datahub.HttpClient.ContentType r9) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.HttpClient.request(java.lang.String, java.lang.String, com.baidu.datahub.HttpClient$ContentType):void");
    }

    public void setMaxTimeOut(int i) {
        this.maxTimeOut = i;
    }

    public void setReadTimeOut(int i) {
        this.mReadTimeOut = i;
    }
}
