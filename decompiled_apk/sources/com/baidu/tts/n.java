package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.o;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.Map;
import jxl.read.biff.oI0IIXIo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class n extends i4 {
    public final /* synthetic */ o.a b;

    public n(o oVar, o.a aVar) {
        this.b = aVar;
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr) {
        String str2 = new String(bArr);
        LoggerProxy.d("OnlineAuth", "body=" + str2 + "--code=" + i);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("access_token")) {
                this.b.b = jSONObject.getString("access_token");
            } else {
                this.b.a(c3.a().a(x2.d));
            }
            if (jSONObject.has("expires_in")) {
                this.b.c = System.nanoTime() + (Math.min(jSONObject.getInt("expires_in"), oI0IIXIo.f28349Oxx0xo) * C.NANOS_PER_SECOND);
            }
        } catch (JSONException e) {
            LoggerProxy.d("OnlineAuth", "parse:" + e.toString());
        } catch (Exception e2) {
            LoggerProxy.d("OnlineAuth", "parse:" + e2.toString());
        }
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        this.b.a(c3.a().a(x2.d));
    }
}
