package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class b4 extends i4 {
    public final /* synthetic */ String b;
    public final /* synthetic */ String[] c;

    public b4(c4 c4Var, String str, String[] strArr) {
        this.b = str;
        this.c = strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0108 A[Catch: JSONException -> 0x010d, TryCatch #3 {JSONException -> 0x010d, blocks: (B:3:0x000a, B:22:0x00e6, B:24:0x0108, B:27:0x010f, B:32:0x00d0, B:37:0x003f, B:6:0x0029), top: B:2:0x000a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010f A[Catch: JSONException -> 0x010d, TRY_LEAVE, TryCatch #3 {JSONException -> 0x010d, blocks: (B:3:0x000a, B:22:0x00e6, B:24:0x0108, B:27:0x010f, B:32:0x00d0, B:37:0x003f, B:6:0x0029), top: B:2:0x000a, inners: #1 }] */
    @Override // com.baidu.tts.i4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8, java.lang.String r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.b4.a(int, java.util.Map, java.lang.String, byte[]):void");
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        LoggerProxy.d("HttpDNS", "onFailure statusCode: " + i + " responseBody: " + ((Object) null));
    }
}
