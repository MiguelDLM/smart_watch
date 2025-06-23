package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class gc {
    private SparseArray<gb> uv = new SparseArray<>();

    /* JADX WARN: Removed duplicated region for block: B:34:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String b(java.io.File r3) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r3.<init>()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
        L10:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            if (r2 == 0) goto L1f
            r3.append(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            goto L10
        L1a:
            r3 = move-exception
            r0 = r1
            goto L3e
        L1d:
            r3 = move-exception
            goto L30
        L1f:
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r1.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r0 = move-exception
            r0.printStackTrace()
        L2b:
            return r3
        L2c:
            r3 = move-exception
            goto L3e
        L2e:
            r3 = move-exception
            r1 = r0
        L30:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r3 = move-exception
            r3.printStackTrace()
        L3d:
            return r0
        L3e:
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r0 = move-exception
            r0.printStackTrace()
        L48:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.gc.b(java.io.File):java.lang.String");
    }

    private static String e(Context context, String str) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(str), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, Context context) {
        String b;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            b = e(context, str + "dl_config.json");
            z = true;
        } else {
            b = b(new File(str, "dl_config.json"));
            z = false;
        }
        a(b, str, z);
    }

    public SparseArray<gb> ev() {
        return this.uv;
    }

    private void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("type");
                JSONArray jSONArray2 = jSONObject.getJSONArray("models");
                int length2 = jSONArray2.length();
                gb gbVar = new gb();
                gbVar.type = i2;
                gbVar.ut = z;
                gbVar.uu = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    int optInt = jSONObject2.optInt("model_type", i3);
                    File file = new File(str2, jSONObject2.getString(MapBundleKey.MapObjKey.OBJ_DIR));
                    String optString = jSONObject2.optString("design_model", "");
                    if (!TextUtils.isEmpty(optString)) {
                        file = new File(file, optString);
                    }
                    String absolutePath = file.getAbsolutePath();
                    if (z) {
                        absolutePath = absolutePath.substring(1);
                    }
                    gbVar.uu[optInt] = absolutePath;
                }
                try {
                    this.uv.put(i2, gbVar);
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
