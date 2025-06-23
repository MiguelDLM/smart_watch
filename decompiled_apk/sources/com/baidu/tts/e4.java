package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e4 extends i4 {
    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
    }

    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        throw null;
    }

    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        throw null;
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr) {
        try {
            JSONObject a2 = a(bArr);
            if (a2 != null) {
                a(i, map, a2);
            } else {
                a(i, map, new JSONException("Unexpected response type JsonResponseHandler"), (JSONObject) null);
            }
        } catch (JSONException e) {
            a(i, map, e, (JSONObject) null);
            e.printStackTrace();
        }
    }

    public final JSONObject a(byte[] bArr) throws JSONException {
        String str;
        if (bArr == null) {
            return null;
        }
        try {
            str = new String(bArr, "utf-8");
            if (str.startsWith("\ufeff")) {
                str = str.substring(1);
            }
        } catch (UnsupportedEncodingException e) {
            LoggerProxy.e("JsonResponseHandler", "Encoding response into string failed" + e.toString());
            str = null;
        }
        if (str != null) {
            return new JSONObject(str.trim());
        }
        return null;
    }
}
