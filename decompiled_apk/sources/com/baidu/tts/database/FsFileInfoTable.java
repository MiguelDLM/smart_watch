package com.baidu.tts.database;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.tts.o4;
import com.baidu.tts.tools.CommonUtility;
import javax.net.ssl.HostnameVerifier;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class FsFileInfoTable {

    /* loaded from: classes8.dex */
    public enum Field {
        ABS_PATH("absPath", "varchar primary key"),
        STATE("state", TypedValues.Custom.S_INT);


        /* renamed from: a, reason: collision with root package name */
        public final String f10074a;
        public final String b;

        Field(String str, String str2) {
            this.f10074a = str;
            this.b = str2;
        }

        public String getColumnName() {
            return this.f10074a;
        }

        public String getDataType() {
            return this.b;
        }
    }

    public static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("System", Build.VERSION.RELEASE);
            jSONObject.put("SystemVersion", Build.VERSION.SDK + "");
            jSONObject.put("PhoneModel", Build.MODEL);
            jSONObject.put("CPU", Build.CPU_ABI);
            jSONObject.put("NetworkType", CommonUtility.getNetworkInfo(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static HostnameVerifier a() {
        return new o4();
    }
}
