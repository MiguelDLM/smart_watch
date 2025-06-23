package com.baidu.platform.comapi.walknavi.e.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.platform.comapi.walknavi.e.a.f.f;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d extends AsyncTask<String, Void, String> implements c {

    /* renamed from: a, reason: collision with root package name */
    f.a<JSONObject> f9736a;
    private String b;

    public d(String str, f.a<JSONObject> aVar) {
        this.f9736a = aVar;
        this.b = str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", an.d);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("post params = " + strArr[0]);
            dataOutputStream.write(strArr[0].getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return readLine;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            f.a<JSONObject> aVar = this.f9736a;
            if (aVar != null) {
                aVar.b("http error! result is null");
                return;
            }
            return;
        }
        try {
            if (this.f9736a != null) {
                this.f9736a.a(new JSONObject(str));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.f.c
    public void a() {
        cancel(true);
        this.f9736a = null;
    }
}
