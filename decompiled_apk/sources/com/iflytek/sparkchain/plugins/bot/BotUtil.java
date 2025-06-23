package com.iflytek.sparkchain.plugins.bot;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import com.iflytek.sparkchain.plugins.iflc.a;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import o0oIxXOx.XIxXXX0x0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.time.xoIox;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class BotUtil {
    public static final int GET_TYPE = 3;
    public static final int POST_TYPE = 2;
    public static final int SOCKET_TYPE = 1;
    public static final int UPLOAD_TYPE = 0;
    private String apiKey;
    private String apiSecret;
    private String appId;
    private h callback;
    private com.iflytek.sparkchain.plugins.iflc.a client;
    private final String TAG = Utils.TAG;
    private String wsUrl = "ws://sparkbot.xf-yun.com/api/v1/chat";
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    /* loaded from: classes10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f17478a;

        public a(File file) {
            this.f17478a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            BotUtil.this.doUpload(this.f17478a);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17479a;
        final /* synthetic */ String[] b;

        public b(boolean z, String[] strArr) {
            this.f17479a = z;
            this.b = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = this.f17479a;
            BotUtil.this.doDelete(z ? 1 : 0, this.b);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_id", BotUtil.this.appId);
                String doPostRequest = BotUtil.this.doPostRequest("http://sparkbot.xf-yun.com/api/v1/ingest_data/list", jSONObject);
                if (BotUtil.this.callback != null) {
                    BotUtil.this.callback.a(doPostRequest, 2);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements a.InterfaceC0675a {
        public d() {
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void a() {
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void b(String str) {
            if (BotUtil.this.callback != null) {
                BotUtil.this.callback.a(str, 1);
            }
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void a(String str) {
        }
    }

    /* loaded from: classes10.dex */
    public class e implements Callback {
        public e() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            BotUtil.this.doCallback("", 0);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            BotUtil.this.doCallback(new String(response.body().bytes(), "UTF-8"), 0);
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17483a;
        final /* synthetic */ String b;

        public f(String str, String str2) {
            this.f17483a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BotUtil botUtil = BotUtil.this;
                String assemble_ws_auth_url = botUtil.assemble_ws_auth_url(botUtil.wsUrl, "GET", this.f17483a, this.b);
                BotUtil botUtil2 = BotUtil.this;
                botUtil2.client = botUtil2.createClient(this.f17483a, this.b);
                Log.i(Utils.TAG, "assembledUrl: " + assemble_ws_auth_url);
            } catch (g e) {
                e.printStackTrace();
                Log.e(Utils.TAG, "exception: " + e.getMessage());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g extends Exception {
        public g(String str) {
            super(str);
        }
    }

    /* loaded from: classes10.dex */
    public interface h {
        void a(String str, int i);
    }

    /* loaded from: classes10.dex */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        private String f17485a;
        private String b;

        public i(String str, String str2, String str3) {
            this.f17485a = str;
            this.b = str2;
        }

        public String a() {
            return this.f17485a;
        }

        public String b() {
            return this.b;
        }
    }

    public BotUtil(String str, String str2, String str3) {
        auth(str, str2, str3);
    }

    private Map<String, String> assembleRequestHeader(String str, String str2, String str3, String str4, byte[] bArr) {
        Base64.Encoder encoder;
        String encodeToString;
        Base64.Encoder encoder2;
        String encodeToString2;
        try {
            URL url = new URL(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date());
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append("SHA256=");
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(messageDigest.digest());
            sb.append(encodeToString);
            String sb2 = sb.toString();
            String host = url.getHost();
            int port = url.getPort();
            if (port > 0) {
                host = host + ":" + port;
            }
            Charset forName = Charset.forName("UTF-8");
            Mac mac = Mac.getInstance("hmacsha256");
            mac.init(new SecretKeySpec(str3.getBytes(forName), "hmacsha256"));
            byte[] doFinal = mac.doFinal(("host: " + host + "\ndate: " + format + "\n" + str4 + " " + url.getPath() + " HTTP/1.1\ndigest: " + sb2).getBytes(forName));
            encoder2 = Base64.getEncoder();
            encodeToString2 = encoder2.encodeToString(doFinal);
            String format2 = String.format("hmac-auth api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", str2, "hmac-sha256", "host date request-line digest", encodeToString2);
            HashMap hashMap = new HashMap();
            hashMap.put("authorization", format2);
            hashMap.put("host", host);
            hashMap.put(XIxXXX0x0.f31178xoIox, format);
            hashMap.put("digest", sb2);
            return hashMap;
        } catch (Exception e2) {
            throw new RuntimeException("assemble requestHeader  error:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String assemble_ws_auth_url(String str, String str2, String str3, String str4) throws g {
        Base64.Encoder encoder;
        String encodeToString;
        i parse_url = parse_url(str);
        String a2 = parse_url.a();
        String b2 = parse_url.b();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(xoIox.f32917oIX0oI));
        String format = simpleDateFormat.format(new Date());
        PrintStream printStream = System.out;
        printStream.println(format);
        String format2 = String.format("host: %s\ndate: %s\n%s %s HTTP/1.1", a2, format, str2, b2);
        printStream.println(format2);
        try {
            String format3 = String.format("api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", str3, "hmac-sha256", "host date request-line", sha256base64(format2));
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(format3.getBytes(StandardCharsets.UTF_8));
            printStream.println(encodeToString);
            return str + LocationInfo.NA + ("host=" + URLEncoder.encode(a2) + "&date=" + URLEncoder.encode(format) + "&authorization=" + URLEncoder.encode(encodeToString));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void auth(String str, String str2, String str3) {
        this.apiKey = str;
        this.apiSecret = str2;
        this.appId = str3;
        this.executorService.execute(new f(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.iflytek.sparkchain.plugins.iflc.a createClient(String str, String str2) {
        String a2 = com.iflytek.sparkchain.plugins.iflc.a.a(this.wsUrl, str, str2, "GET");
        if (TextUtils.isEmpty(this.wsUrl)) {
            Log.e(Utils.TAG, "wsUrl is null");
            return null;
        }
        com.iflytek.sparkchain.plugins.iflc.a aVar = new com.iflytek.sparkchain.plugins.iflc.a(URI.create(a2), 1);
        aVar.a(new d());
        aVar.connect();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str, int i2) {
        Log.w(Utils.TAG, "result: " + str);
        h hVar = this.callback;
        if (hVar != null) {
            hVar.a(str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDelete(int i2, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", this.appId);
            if (strArr != null && strArr.length != 0) {
                jSONObject.put("source_ids", this.appId);
            }
            jSONObject.put("delete_all", i2);
            String doPostRequest = doPostRequest("https://sparkbot.xf-yun.com/api/v1/ingest_data/delete", jSONObject);
            h hVar = this.callback;
            if (hVar != null) {
                hVar.a(doPostRequest, 2);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void doGetRequest(String str) {
        String str2;
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            if (execute.isSuccessful()) {
                str2 = execute.body().string();
            } else {
                str2 = "code: " + execute.code() + " message: " + execute.message();
            }
            doCallback(str2, 3);
            execute.close();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doPostRequest(String str, JSONObject jSONObject) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder post = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jSONObject.toString()));
            for (Map.Entry<String, String> entry : assembleRequestHeader(str, this.apiKey, this.apiSecret, "POST", jSONObject.toString().getBytes()).entrySet()) {
                post.addHeader(entry.getKey(), entry.getValue());
            }
            Response execute = okHttpClient.newCall(post.build()).execute();
            String str2 = execute.isSuccessful() ? new String(execute.body().bytes(), "UTF-8") : "code: " + execute.code() + " message: " + execute.message();
            execute.close();
            return str2;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpload(File file) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody create = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        try {
            Request.Builder post = new Request.Builder().url("https://sparkbot.xf-yun.com/api/v1/ingest_data/document").post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("app_id", this.appId).addFormDataPart("file", new String(file.getName().getBytes(), "UTF-8"), create).build());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_id", this.appId);
                for (Map.Entry<String, String> entry : assembleRequestHeader("https://sparkbot.xf-yun.com/api/v1/ingest_data/document", this.apiKey, this.apiSecret, "POST", jSONObject.toString().getBytes()).entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
                okHttpClient.newCall(post.build()).enqueue(new e());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    private i parse_url(String str) throws g {
        int indexOf = str.indexOf("://") + 3;
        String substring = str.substring(indexOf);
        String substring2 = str.substring(0, indexOf);
        int indexOf2 = substring.indexOf("/");
        if (indexOf2 > 0) {
            return new i(substring.substring(0, indexOf2), substring.substring(indexOf2), substring2);
        }
        throw new g("invalid request url: " + str);
    }

    private static String sha256base64(String str) throws NoSuchAlgorithmException {
        Base64.Encoder encoder;
        byte[] encode;
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = StandardCharsets.UTF_8;
        try {
            mac.init(new SecretKeySpec(str.getBytes(charset), "HmacSHA256"));
            byte[] doFinal = mac.doFinal();
            encoder = Base64.getEncoder();
            encode = encoder.encode(doFinal);
            return new String(encode, charset);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void chat(String str) {
        if (this.client == null) {
            if (TextUtils.isEmpty(this.apiSecret) && TextUtils.isEmpty(this.apiKey)) {
                this.client = createClient(this.apiKey, this.apiSecret);
                do {
                } while (!this.client.isOpen());
                this.client.send(str);
            }
            return;
        }
        do {
        } while (!this.client.isOpen());
        this.client.send(str);
    }

    public void deleteFile(String[] strArr, boolean z) {
        this.executorService.execute(new b(z, strArr));
    }

    public void finalize() throws Throwable {
        com.iflytek.sparkchain.plugins.iflc.a aVar = this.client;
        if (aVar != null && aVar.isOpen()) {
            this.client.close();
        }
        super.finalize();
    }

    public void getDocuments() {
        this.executorService.execute(new c());
    }

    public void setCallback(h hVar) {
        this.callback = hVar;
    }

    public void uploadFile(@NonNull File file) {
        this.executorService.execute(new a(file));
    }

    public void uploadFile(@NonNull String str) {
        File file = new File(str);
        if (file.exists()) {
            uploadFile(file);
            return;
        }
        Log.e(Utils.TAG, "file: " + str + " not exist");
    }
}
