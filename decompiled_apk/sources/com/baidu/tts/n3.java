package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class n3 extends i4 {
    public final /* synthetic */ String[] b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public n3(o3 o3Var, String[] strArr, String str, String str2) {
        this.b = strArr;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr) {
        String str2 = new String(bArr);
        LoggerProxy.d("GetServerModelsWork", "statusCode: " + i + " response: " + new String(bArr));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if ("0".equals(jSONObject.optString("err_no"))) {
                this.b[0] = jSONObject.optString("info");
                c4.a().a(this.c, this.d);
            }
        } catch (Exception e) {
            LoggerProxy.d("GetServerModelsWork", "parse:" + e.toString());
        }
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        LoggerProxy.d("GetServerModelsWork", "onFileure statusCode:" + i);
    }
}
