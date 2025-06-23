package com.baidu.ar;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.IProgressCallback;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ie {
    private ICallbackWith<String> mErrorCallback;
    private File yk;
    private File yl;
    private IHttpRequest ym;

    public ie(Context context, File file) {
        this.yk = file;
        this.yl = new File(context.getFilesDir(), "tmp");
    }

    private IHttpRequest b(String str, final ICallback iCallback, IProgressCallback iProgressCallback) {
        if (TextUtils.isEmpty(str)) {
            bx("资源不存在");
            return null;
        }
        km.k(this.yk);
        km.d(this.yl);
        final File file = new File(this.yl, kp.cp(str) + OTAManager.OTA_ZIP_SUFFIX);
        if (!file.exists() || !kx.b(file, this.yk)) {
            return new Downloader(str).downloadAsync(file.getAbsolutePath(), new ICallbackWith<Integer>() { // from class: com.baidu.ar.ie.3
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void run(Integer num) {
                    if (!kx.b(file, ie.this.yk)) {
                        ie.this.bx("zip res fail");
                        return;
                    }
                    km.l(ie.this.yk);
                    ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        iCallback2.run();
                    }
                }
            }, new ICallbackWith<Exception>() { // from class: com.baidu.ar.ie.4
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void run(Exception exc) {
                    ie.this.bx(exc.getMessage());
                }
            }, iProgressCallback);
        }
        km.l(this.yk);
        if (iCallback != null) {
            iCallback.run();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(final String str) {
        kf.cl("dumixres fail: " + str);
        kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ie.2
            @Override // java.lang.Runnable
            public void run() {
                if (ie.this.mErrorCallback != null) {
                    ie.this.mErrorCallback.run(str);
                }
            }
        });
    }

    public void fO() {
        IHttpRequest iHttpRequest = this.ym;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
            this.ym = null;
        }
    }

    public void release() {
        this.mErrorCallback = null;
        fO();
    }

    public void setErrorCallback(ICallbackWith<String> iCallbackWith) {
        this.mErrorCallback = iCallbackWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(String[] strArr, IHttpResponse iHttpResponse) {
        JSONObject optJSONObject;
        if (!iHttpResponse.isSuccess()) {
            throw new Exception(iHttpResponse.getMessage());
        }
        String content = iHttpResponse.getContent();
        if (TextUtils.isEmpty(content)) {
            throw new Exception("response is empty");
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(content);
        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            for (String str : strArr) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                hashMap.put(str, optJSONObject2 == null ? "" : optJSONObject2.optString("url"));
            }
        }
        return hashMap;
    }

    public void a(String str, ICallback iCallback, IProgressCallback iProgressCallback) {
        IHttpRequest iHttpRequest = this.ym;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
        }
        this.ym = b(str, iCallback, iProgressCallback);
    }

    public void a(final String[] strArr, final ICallbackWith<Map<String, String>> iCallbackWith) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            bx("current dumix sdk is not support http request");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(strArr[i]);
        }
        newRequest.setMethod("POST").setUrl(kw.Dx + "/ar-client/get_library").addFormField(HttpConstants.HTTP_ENGINE_VERSION, Integer.valueOf(kg.getVersionCode())).addFormField(oO.f31192XO, "android").addFormField("business", sb.toString()).addFormField(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        newRequest.enqueue(new fa() { // from class: com.baidu.ar.ie.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                if (httpException.getCode() == 1) {
                    ie.this.bx("网络不给力");
                } else {
                    ie.this.bx(httpException.getMessage());
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    ICallbackWith iCallbackWith2 = iCallbackWith;
                    if (iCallbackWith2 != null) {
                        iCallbackWith2.run(ie.this.a(strArr, iHttpResponse));
                    }
                } catch (Exception e) {
                    ie.this.bx(e.getMessage());
                }
            }
        });
        this.ym = newRequest;
    }
}
