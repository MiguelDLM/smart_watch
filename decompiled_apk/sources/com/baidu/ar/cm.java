package com.baidu.ar;

import android.os.Build;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.util.HashMap;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class cm {
    private static String a(IHttpRequest iHttpRequest) {
        if (iHttpRequest == null) {
            return null;
        }
        try {
            IHttpResponse execute = iHttpRequest.execute();
            if (execute.isSuccess()) {
                return execute.getContent();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str, HashMap hashMap, byte[] bArr) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return null;
        }
        newRequest.setMethod("POST").setUrl(str).setAsMultipart();
        if (hashMap != null) {
            newRequest.addPartMap(hashMap);
        }
        newRequest.addFile("image", bArr);
        newRequest.setAsMultipart();
        return a(newRequest);
    }

    public static void a(fa faVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConstants.HTTP_ENGINE_VERSION, Integer.valueOf(kg.getVersionCode()));
        hashMap.put("business", "cloud_recognize");
        hashMap.put(oO.f31192XO, "android");
        hashMap.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        String hC = kw.hC();
        Log.e("getLibrary", "http->" + hC);
        try {
            HttpFactory.newRequest().setUrl(hC).addHeader("Content-Type: application/x-www-form-urlencoded").setMethod("POST").addFormData(hashMap).enqueue(faVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(fa faVar, byte[] bArr) {
        String hB = kw.hB();
        Log.e("artracker", "http->" + hB);
        try {
            HttpFactory.newRequest().setUrl(hB).addHeader("Content-Type:application/protobuf").setMethod("POST").setBody(bArr).enqueue(faVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
