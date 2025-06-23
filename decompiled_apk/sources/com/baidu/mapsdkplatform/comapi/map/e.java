package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6181a = "e";
    private AsyncHttpClient b;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, String str2);

        void a(String str);

        void a(boolean z, String str);
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f6182a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    private String b(String str) {
        if (HttpClient.isHttpsEnable) {
            return BNWebViewClient.URL_HTTPS_PREFIX + str;
        }
        return BNWebViewClient.URL_HTTP_PREFIX + str;
    }

    private e() {
        this.b = new AsyncHttpClient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, a aVar) {
        String a2 = a(context, str2);
        String str3 = a(a2) ? a2 : null;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.SERVER_ERROR;
                aVar.a(httpStateError.ordinal(), httpStateError.name(), str3);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            String optString = jSONObject.optString("message");
            if (!a(optInt, a2)) {
                if (aVar != null) {
                    aVar.a(false, str3);
                }
            } else {
                if (optInt != 0) {
                    if (aVar != null) {
                        aVar.a(optInt, optString, str3);
                        return;
                    }
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    a(context, optJSONObject.optString("pb_url", ""), str2, optJSONObject.optString("md5", ""), aVar);
                } else if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                }
            }
        } catch (JSONException unused) {
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
            }
        }
    }

    public static e a() {
        return b.f6182a;
    }

    public void a(Context context, String str, a aVar) {
        a(context, str, true, aVar);
    }

    private void a(Context context, String str, boolean z, a aVar) {
        String a2 = a(context, str);
        if (!a(a2)) {
            a2 = null;
        }
        if (aVar != null) {
            aVar.a(a2);
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (aVar != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.NETWORK_ERROR;
                aVar.a(httpStateError.ordinal(), httpStateError.name(), a2);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a3 = a(context, str, z);
        if (TextUtils.isEmpty(a3)) {
            Log.e(f6181a, "build request url failed");
        } else {
            a(context, a3, str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private String a(Context context, String str, boolean z) {
        if (context == null) {
            return "";
        }
        String b2 = b(context, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("style_id", str);
        if (z) {
            linkedHashMap.put("type", "publish");
        } else {
            linkedHashMap.put("type", "edit");
        }
        linkedHashMap.put("md5", b2);
        linkedHashMap.put("token", SyncSysInfo.getAuthToken());
        String str2 = a(linkedHashMap) + SyncSysInfo.getPhoneInfo();
        return b("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + LocationInfo.NA + (str2 + "&sign=" + AppMD5.getSignMD5String(str2));
    }

    private String b(Context context, String str) {
        try {
            JSONArray jSONArray = new JSONArray(a(context));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = ((JSONObject) jSONArray.opt(i)).optString(str);
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            }
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
            if (i == 0) {
                sb.append(str);
                sb.append("=");
                sb.append(encodeUrlParamsValue);
            } else {
                sb.append("&");
                sb.append(str);
                sb.append("=");
                sb.append(encodeUrlParamsValue);
            }
            i++;
        }
        return sb.toString();
    }

    private void a(Context context, String str, String str2, a aVar) {
        this.b.get(str, new f(this, context, str2, aVar));
    }

    private boolean a(int i, String str) {
        return (103 == i && a(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + str + ".sty";
    }

    private void a(Context context, String str, String str2, String str3, a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        String b2 = b(str);
        String a2 = a(context, str2);
        new com.baidu.mapsdkplatform.comapi.commonutils.a.c().a(b2, context.getFilesDir().getAbsolutePath(), str2 + OTAManager.OTA_ZIP_SUFFIX, 2, new g(this, context, str2, aVar, str3, a2));
    }

    private String a(Context context) {
        BufferedReader bufferedReader = null;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        if (!file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        JSONArray jSONArray;
        PrintWriter printWriter;
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        String a2 = a(context);
        PrintWriter printWriter2 = null;
        try {
            try {
                if (TextUtils.isEmpty(a2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(a2);
                }
                int length = jSONArray.length();
                if (length == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    jSONArray.put(jSONObject);
                } else {
                    int i = 0;
                    JSONObject jSONObject2 = null;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        }
                        jSONObject2 = (JSONObject) jSONArray.opt(i);
                        if (jSONObject2 != null && jSONObject2.has(str)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1 && jSONObject2 != null) {
                        jSONObject2.put(str, str2);
                        jSONArray.put(i, jSONObject2);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(str, str2);
                        jSONArray.put(jSONObject3);
                    }
                }
                printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter.write(jSONArray.toString());
            printWriter.close();
        } catch (Exception e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, File file, String str) {
        ZipFile zipFile;
        if (file == null || context == null) {
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(file.getAbsoluteFile());
                } catch (IOException e) {
                    Log.e(f6181a, "Close zipFile failed", e);
                    return false;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            } catch (IllegalStateException e4) {
                e = e4;
            } catch (NullPointerException e5) {
                e = e5;
            } catch (SecurityException e6) {
                e = e6;
            } catch (ZipException e7) {
                e = e7;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str + ".sty");
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                    Log.e(f6181a, "Close zipFile failed", e8);
                }
                return false;
            }
            boolean a2 = a(zipFile.getInputStream(entry), new FileOutputStream(new File(a(context, str))));
            file.delete();
            try {
                zipFile.close();
            } catch (IOException e9) {
                Log.e(f6181a, "Close zipFile failed", e9);
            }
            return a2;
        } catch (FileNotFoundException e10) {
            e = e10;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file FileNotFoundException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IOException e11) {
            e = e11;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file IOException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IllegalStateException e12) {
            e = e12;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file IllegalStateException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (NullPointerException e13) {
            e = e13;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file NullPointerException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (SecurityException e14) {
            e = e14;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file SecurityException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (ZipException e15) {
            e = e15;
            zipFile2 = zipFile;
            Log.e(f6181a, "unzip style file ZipException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Exception unused2) {
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e16) {
                    Log.e(f6181a, "Close zipFile failed", e16);
                }
            }
            throw th;
        }
    }

    private boolean a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException, NullPointerException {
        if (inputStream == null || fileOutputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e) {
            Log.e(f6181a, "Close InputStream error", e);
        }
        try {
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            Log.e(f6181a, "Close OutputStream error", e2);
            return true;
        }
    }
}
