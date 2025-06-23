package com.iflytek.sparkchain.plugins.iflc;

import android.util.Base64;
import android.util.Log;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class a extends WebSocketClient {

    /* renamed from: a, reason: collision with root package name */
    private StringBuffer f17487a;
    private int b;
    private InterfaceC0675a c;

    /* renamed from: com.iflytek.sparkchain.plugins.iflc.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0675a {
        void a();

        void a(String str);

        void b(String str);
    }

    public a(URI uri) {
        super(uri);
        this.b = 0;
        Log.d(Utils.TAG, "connection uri: " + uri);
    }

    public static String a(String str, String str2, String str3, String str4) {
        try {
            URL url = new URL(str.replace("ws://", BNWebViewClient.URL_HTTP_PREFIX).replace("wss://", BNWebViewClient.URL_HTTPS_PREFIX));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date());
            String host = url.getHost();
            StringBuilder sb = new StringBuilder("host: ");
            sb.append(host);
            sb.append("\n");
            sb.append("date: ");
            sb.append(format);
            sb.append("\n");
            sb.append(str4);
            sb.append(" ");
            sb.append(url.getPath());
            sb.append(" HTTP/1.1");
            Charset forName = Charset.forName("UTF-8");
            Mac mac = Mac.getInstance("hmacsha256");
            System.out.println(sb.toString());
            mac.init(new SecretKeySpec(str3.getBytes(forName), "hmacsha256"));
            return String.format("%s?host=%s&date=%s&authorization=%s", str, URLEncoder.encode(host), URLEncoder.encode(format), URLEncoder.encode(Base64.encodeToString(String.format("hmac username=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", str2, "hmac-sha256", "host date request-line", Base64.encodeToString(mac.doFinal(sb.toString().getBytes(forName)), 2)).getBytes(forName), 2)));
        } catch (Exception e) {
            throw new RuntimeException("assemble requestUrl error:" + e.getMessage());
        }
    }

    private void b(String str) {
        InterfaceC0675a interfaceC0675a;
        StringBuffer stringBuffer;
        InterfaceC0675a interfaceC0675a2;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        Log.d(Utils.TAG, "receive message: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("payload") && jSONObject.get("payload").getClass().equals(JSONObject.class)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
                if (jSONObject2.has("choices") && jSONObject2.get("choices").getClass().equals(JSONObject.class)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("choices");
                    if (jSONObject3.has("text") && jSONObject3.get("text").getClass().equals(JSONArray.class)) {
                        JSONArray jSONArray = jSONObject3.getJSONArray("text");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                            if (jSONObject4.has("content") && jSONObject4.get("content").getClass().equals(String.class) && (stringBuffer3 = this.f17487a) != null) {
                                stringBuffer3.append(jSONObject4.getString("content"));
                            }
                        }
                    }
                    if (jSONObject3.has("status") && jSONObject3.get("status").getClass().equals(Integer.class) && jSONObject3.getInt("status") == 2 && (interfaceC0675a2 = this.c) != null && (stringBuffer2 = this.f17487a) != null) {
                        interfaceC0675a2.b(stringBuffer2.toString());
                    }
                }
            }
            if (jSONObject.has("header") && jSONObject.get("header").getClass().equals(JSONObject.class)) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("header");
                if (!jSONObject5.has("code") || !jSONObject5.get("code").getClass().equals(Integer.class) || jSONObject5.getInt("code") == 0 || (interfaceC0675a = this.c) == null || (stringBuffer = this.f17487a) == null) {
                    return;
                }
                interfaceC0675a.b(stringBuffer.toString());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onClose(int i, String str, boolean z) {
        Log.d(Utils.TAG, "Search Socket Disconnected");
        this.f17487a = null;
    }

    public void onError(Exception exc) {
        Log.e(Utils.TAG, "Search Socket error: " + exc.getMessage().toString());
    }

    public void onMessage(String str) {
        InterfaceC0675a interfaceC0675a = this.c;
        if (interfaceC0675a != null) {
            interfaceC0675a.a(str);
        }
        int i = this.b;
        if (i == 0) {
            b(str);
        } else if (i == 1) {
            a(str);
        }
    }

    public void onOpen(ServerHandshake serverHandshake) {
        do {
        } while (!getReadyState().equals(ReadyState.OPEN));
        Log.d(Utils.TAG, "Search Socket Connected");
        InterfaceC0675a interfaceC0675a = this.c;
        if (interfaceC0675a != null) {
            interfaceC0675a.a();
        }
    }

    public void send(String str) {
        Log.d(Utils.TAG, "Search send message: " + str);
        this.f17487a = new StringBuffer();
        super.send(str);
    }

    public void sendPing() {
        super.sendPing();
    }

    public a(URI uri, int i) {
        super(uri);
        this.b = i;
        Log.d(Utils.TAG, "connection uri: " + uri);
    }

    public void a(InterfaceC0675a interfaceC0675a) {
        this.c = interfaceC0675a;
    }

    public void onMessage(ByteBuffer byteBuffer) {
        super.onMessage(byteBuffer);
        InterfaceC0675a interfaceC0675a = this.c;
        if (interfaceC0675a != null) {
            interfaceC0675a.a(byteBuffer.toString());
        }
        int i = this.b;
        if (i == 0) {
            b(byteBuffer.toString());
        } else if (i == 1) {
            a(byteBuffer.toString());
        }
    }

    private void a(String str) {
        InterfaceC0675a interfaceC0675a;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("code") || !jSONObject.get("code").getClass().equals(Integer.class) || jSONObject.getInt("code") != 0) {
                String str2 = "请求失败: " + jSONObject;
                Log.e(Utils.TAG, str2);
                this.c.b(str2);
                return;
            }
            if (jSONObject.has("data") && jSONObject.get("data").getClass().equals(JSONObject.class)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("answer") && jSONObject2.get("answer").getClass().equals(String.class) && (stringBuffer2 = this.f17487a) != null) {
                    stringBuffer2.append(jSONObject2.getString("answer"));
                }
                if (jSONObject2.has("status") && jSONObject2.get("status").getClass().equals(Integer.class) && jSONObject2.getInt("status") == 2 && (interfaceC0675a = this.c) != null && (stringBuffer = this.f17487a) != null) {
                    interfaceC0675a.b(stringBuffer.toString());
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
