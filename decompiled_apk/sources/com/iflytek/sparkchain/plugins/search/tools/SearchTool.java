package com.iflytek.sparkchain.plugins.search.tools;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.an;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.iflc.a;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class SearchTool extends BaseTool {
    private final String TAG = Utils.TAG;
    private String appID = "cf714658";
    private String apiKey = "d1961748909c404621b9f6dd6b1b18ce";
    private String apiSecret = "NTE0ZGI3ZDI3ZjYwOWM4OTNlOWY2OWUz";
    private String UID = "d17705645154";

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC0675a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f17493a;

        public a(SearchTool searchTool, String[] strArr) {
            this.f17493a = strArr;
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void a() {
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void b(String str) {
            Log.i(Utils.TAG, "search message: " + str);
            this.f17493a[0] = str;
        }

        @Override // com.iflytek.sparkchain.plugins.iflc.a.InterfaceC0675a
        public void a(String str) {
        }
    }

    public SearchTool() {
        init();
    }

    private String getJSONString(String str) throws IOException {
        Log.d(Utils.TAG, "search URI:" + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpURLConnection.setRequestProperty("Accept", an.d);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    private void init() {
        this.description = "实时互联网信息查询。";
        this.argsSchema = new com.iflytek.sparkchain.plugins.iflc.ifla.a();
        this.name = "search";
    }

    private String query(String str) throws JSONException, IOException {
        StringBuilder sb = new StringBuilder("");
        JSONArray jSONArray = new JSONArray(getJSONString("http://192.168.50.12:8000/search?q=" + str + "&max_results=3"));
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            sb.append((jSONObject.has("body") && jSONObject.get("body").getClass().equals(String.class)) ? jSONObject.getString("body") : "未查到结果");
        }
        return sb.toString();
    }

    private String reqJson(String str) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return "{\"header\":{\"app_id\":\"" + this.appID + "\",\"uid\":\"" + this.UID + "\"},\"parameter\":{\"chat\":{\"domain\":\"search\",\"chat_id\":\"" + ((Object) sb) + "\",\"random_threshold\":0,\"max_tokens\":2048,\"auditing\":\"default\",\"top_k\":4,\"temperature\":0.5}},\"payload\":{\"message\":{\"text\":[{\"role\":\"user\",\"content\":\"" + str + "\"}]}}}";
    }

    private String search(String str) throws InterruptedException {
        String a2 = com.iflytek.sparkchain.plugins.iflc.a.a("wss://spark-api-knowledge.xf-yun.com/v1/chat", this.apiKey, this.apiSecret, "GET");
        if (TextUtils.isEmpty("wss://spark-api-knowledge.xf-yun.com/v1/chat")) {
            return "未查到结果";
        }
        com.iflytek.sparkchain.plugins.iflc.a aVar = new com.iflytek.sparkchain.plugins.iflc.a(URI.create(a2));
        aVar.connect();
        String[] strArr = {""};
        aVar.a(new a(this, strArr));
        Log.d(Utils.TAG, "SocketClient connecting");
        do {
        } while (!aVar.isOpen());
        aVar.send(reqJson(str));
        Log.d(Utils.TAG, "wait socket result...");
        while (TextUtils.isEmpty(strArr[0])) {
            Thread.sleep(500L);
        }
        Log.i(Utils.TAG, "result: " + strArr[0]);
        aVar.close();
        return strArr[0];
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            if (jSONObject.has("keyword") && jSONObject.get("keyword").getClass().equals(String.class)) {
                return toResult(search(jSONObject.getString("keyword")), 0, "do search success!");
            }
        } catch (InterruptedException | JSONException e) {
            Log.e(Utils.TAG, e.getMessage() + " ");
        }
        return toResult("未查询到结果", 19000, "do search failure!");
    }
}
