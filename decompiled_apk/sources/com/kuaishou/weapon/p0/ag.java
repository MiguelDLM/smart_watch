package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ag {
    public static JSONObject a(Context context) {
        File file;
        File dataDir;
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                dataDir = context.getDataDir();
                file = new File(dataDir, "xreplace");
            } else {
                file = new File("/data/data/" + context.getPackageName() + "/xreplace");
            }
            if (file.exists()) {
                jSONObject.put("xreplace", 1);
            }
            if (new File("/storage/emulated/0/xxsq").exists()) {
                jSONObject.put("xxsq", 1);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
