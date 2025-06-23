package com.baidu.location.b;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ap {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final ap f5631a = new ap();
    }

    private ap() {
    }

    public static ap a() {
        return a.f5631a;
    }

    public void a(Context context) {
        Log.d("UrlConfigManger", "updateUrl");
        if (context == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getExternalFilesDir(Environment.DIRECTORY_MOVIES));
            String str = File.separator;
            sb.append(str);
            sb.append("baiduLocDev");
            sb.append(str);
            sb.append("loc_local_config");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            try {
                if (!new File(sb2).exists()) {
                    Log.d("baidu_location_dev", "loc_local_config not exit...");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(sb2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        a(sb3.toString());
                        return;
                    }
                    sb3.append(new String(bArr, 0, read));
                }
            } catch (FileNotFoundException e) {
                e = e;
                e.printStackTrace();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void a(String str, String str2, String str3) {
        Log.d("UrlConfigManger", "setConfig");
        Log.d("baidu_location_dev", "type:" + str + ", owner: " + str2 + " ,url: " + str3);
        if (str2.contains("default_owner") || "default_url".equals(str3) || !str3.contains("https")) {
            Log.d("baidu_location_dev", "url 不合法");
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2127949679:
                if (str.equals("indoor_roadnet")) {
                    c = 0;
                    break;
                }
                break;
            case -1995140673:
                if (str.equals("vdr_log_update")) {
                    c = 1;
                    break;
                }
                break;
            case -1085732228:
                if (str.equals("hdyawupdate")) {
                    c = 2;
                    break;
                }
                break;
            case -821738631:
                if (str.equals("basement_inout")) {
                    c = 3;
                    break;
                }
                break;
            case -508470037:
                if (str.equals("indoor_poi_data")) {
                    c = 4;
                    break;
                }
                break;
            case 107328:
                if (str.equals("loc")) {
                    c = 5;
                    break;
                }
                break;
            case 3050639:
                if (str.equals("cfgs")) {
                    c = 6;
                    break;
                }
                break;
            case 439947811:
                if (str.equals("indoor_rects")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.location.e.e.f = str3;
                return;
            case 1:
                com.baidu.location.e.e.i = str3;
                return;
            case 2:
                com.baidu.location.e.e.j = str3;
                return;
            case 3:
                com.baidu.location.e.e.k = str3;
                return;
            case 4:
                com.baidu.location.e.e.h = str3;
                return;
            case 5:
                com.baidu.location.e.e.c = str3;
                return;
            case 6:
                com.baidu.location.e.e.d = str3;
                return;
            case 7:
                com.baidu.location.e.e.g = str3;
                return;
            default:
                return;
        }
    }

    private boolean a(String str) {
        JSONArray optJSONArray;
        Log.d("UrlConfigManger", "parseConfig");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("url_config") || (optJSONArray = jSONObject.optJSONArray("url_config")) == null) {
                return true;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a(optJSONObject.optString("type"), optJSONObject.optString("owner"), optJSONObject.optString("url"));
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
