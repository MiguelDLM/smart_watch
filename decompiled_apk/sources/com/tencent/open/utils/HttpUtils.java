package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.api.net.proxy.Constants;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.params.ConnRoutePNames;
import com.tencent.open.utils.II0xO0;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONException;
import org.json.JSONObject;
import xox.oO;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class HttpUtils {

    /* loaded from: classes13.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f26950II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f26951oIX0oI;

        public /* synthetic */ II0xO0(String str, int i, oIX0oI oix0oi) {
            this(str, i);
        }

        public II0xO0(String str, int i) {
            this.f26951oIX0oI = str;
            this.f26950II0xO0 = i;
        }
    }

    /* loaded from: classes13.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI extends Thread {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f26952IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f26953Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ Bundle f26954Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ o0Oo.oIX0oI f26955OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ xIxooxXX.II0xO0 f26956XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ String f26957oI0IIXIo;

        public oIX0oI(xIxooxXX.II0xO0 iI0xO0, Context context, String str, Bundle bundle, String str2, o0Oo.oIX0oI oix0oi) {
            this.f26956XO = iI0xO0;
            this.f26953Oo = context;
            this.f26952IXxxXO = str;
            this.f26954Oxx0xo = bundle;
            this.f26957oI0IIXIo = str2;
            this.f26955OxxIIOOXO = oix0oi;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                JSONObject OOXIXo2 = HttpUtils.OOXIXo(this.f26956XO, this.f26953Oo, this.f26952IXxxXO, this.f26954Oxx0xo, this.f26957oI0IIXIo);
                o0Oo.oIX0oI oix0oi = this.f26955OxxIIOOXO;
                if (oix0oi != null) {
                    oix0oi.X0o0xo(OOXIXo2);
                    xxIXOIIO.oOoXoXO("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                }
            } catch (HttpStatusException e) {
                o0Oo.oIX0oI oix0oi2 = this.f26955OxxIIOOXO;
                if (oix0oi2 != null) {
                    oix0oi2.Oxx0IOOO(e);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e.toString());
                }
            } catch (NetworkUnavailableException e2) {
                o0Oo.oIX0oI oix0oi3 = this.f26955OxxIIOOXO;
                if (oix0oi3 != null) {
                    oix0oi3.xxIXOIIO(e2);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e2.toString());
                }
            } catch (MalformedURLException e3) {
                o0Oo.oIX0oI oix0oi4 = this.f26955OxxIIOOXO;
                if (oix0oi4 != null) {
                    oix0oi4.XO(e3);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e3.toString());
                }
            } catch (SocketTimeoutException e4) {
                o0Oo.oIX0oI oix0oi5 = this.f26955OxxIIOOXO;
                if (oix0oi5 != null) {
                    oix0oi5.II0xO0(e4);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e4.toString());
                }
            } catch (ConnectTimeoutException e5) {
                o0Oo.oIX0oI oix0oi6 = this.f26955OxxIIOOXO;
                if (oix0oi6 != null) {
                    oix0oi6.II0XooXoX(e5);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException" + e5.toString());
                }
            } catch (IOException e6) {
                o0Oo.oIX0oI oix0oi7 = this.f26955OxxIIOOXO;
                if (oix0oi7 != null) {
                    oix0oi7.oIX0oI(e6);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                }
            } catch (JSONException e7) {
                o0Oo.oIX0oI oix0oi8 = this.f26955OxxIIOOXO;
                if (oix0oi8 != null) {
                    oix0oi8.oxoX(e7);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                }
            } catch (Exception e8) {
                o0Oo.oIX0oI oix0oi9 = this.f26955OxxIIOOXO;
                if (oix0oi9 != null) {
                    oix0oi9.I0Io(e8);
                    xxIXOIIO.II0XooXoX("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                }
            }
        }
    }

    public static void I0Io(Context context, xIxooxXX.II0xO0 iI0xO0, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            oO.oIX0oI(context, iI0xO0, "requireApi", str);
        }
    }

    public static HttpClient II0XooXoX(Context context, String str, String str2) {
        com.tencent.open.utils.oIX0oI oix0oi;
        int i;
        int i2;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", socketFactory, 443));
            } else {
                schemeRegistry.register(new Scheme("https", new XxXX.xxIXOIIO(), 443));
            }
        } catch (Exception unused) {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        if (context != null) {
            oix0oi = com.tencent.open.utils.oIX0oI.oxoX(context, str);
        } else {
            oix0oi = null;
        }
        if (oix0oi != null) {
            i = oix0oi.II0xO0("Common_HttpConnectionTimeout");
            i2 = oix0oi.II0xO0("Common_SocketConnectionTimeout");
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0) {
            i = 15000;
        }
        if (i2 == 0) {
            i2 = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        II0xO0 xxIXOIIO2 = xxIXOIIO(context);
        if (xxIXOIIO2 != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(xxIXOIIO2.f26951oIX0oI, xxIXOIIO2.f26950II0xO0));
        }
        return defaultHttpClient;
    }

    public static String II0xO0(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
            content = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = content.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                content.close();
                return str;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[LOOP:0: B:8:0x00af->B:50:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject OOXIXo(xIxooxXX.II0xO0 r11, android.content.Context r12, java.lang.String r13, android.os.Bundle r14, java.lang.String r15) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.OOXIXo(xIxooxXX.II0xO0, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static int Oxx0IOOO(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }

    public static String X0o0xo(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            i++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                if (i < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
            }
        }
        return sb.toString();
    }

    public static String XO(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static int oIX0oI(Context context) {
        String property = System.getProperty(Constants.HTTP_PROXY_PORT_PROP);
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static void oOoXoXO(xIxooxXX.II0xO0 iI0xO0, Context context, String str, Bundle bundle, String str2, o0Oo.oIX0oI oix0oi) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new oIX0oI(iI0xO0, context, str, bundle, str2, oix0oi).start();
    }

    public static String oxoX(Context context) {
        return System.getProperty(Constants.HTTP_PROXY_HOST_PROP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0.C1091II0xO0 xoIox(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        HttpGet httpGet;
        int i;
        String str3;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient II0XooXoX2 = II0XooXoX(context, string, str);
        int i2 = -1;
        if (str2.equals("GET")) {
            String XO2 = XO(bundle2);
            i = XO2.length();
            xxIXOIIO.IXxxXO("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            if (str.indexOf(LocationInfo.NA) == -1) {
                str3 = str + LocationInfo.NA;
            } else {
                str3 = str + "&";
            }
            Bundle I0Io2 = xx0.oO.I0Io(bundle2);
            if (I0Io2 != bundle2) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + XO(I0Io2) + " -- url = " + str3);
            } else {
                xxIXOIIO.oOoXoXO("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + XO2 + " -- url = " + str3);
            }
            httpGet = new HttpGet(str3 + XO2);
            httpGet.addHeader("Accept-Encoding", "gzip");
        } else if (str2.equals("POST")) {
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            Bundle bundle3 = new Bundle();
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str4, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0(X0o0xo(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (String str5 : bundle3.keySet()) {
                    i2++;
                    byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                    byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i2 < size - 1) {
                        byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(com.tencent.open.utils.II0xO0.OI0("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            int length = byteArray2.length;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(byteArray2));
            httpGet = httpPost;
            i = length;
        } else {
            httpGet = null;
            i = 0;
        }
        HttpResponse execute = II0XooXoX2.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        xxIXOIIO.oOoXoXO("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =" + statusCode);
        if (statusCode == 200) {
            return new II0xO0.C1091II0xO0(II0xO0(execute), i);
        }
        throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
    }

    public static II0xO0 xxIXOIIO(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        oIX0oI oix0oi = null;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
            String oxoX2 = oxoX(context);
            int oIX0oI2 = oIX0oI(context);
            if (!TextUtils.isEmpty(oxoX2) && oIX0oI2 >= 0) {
                return new II0xO0(oxoX2, oIX0oI2, oix0oi);
            }
        }
        return null;
    }
}
