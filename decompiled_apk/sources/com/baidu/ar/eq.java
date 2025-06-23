package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.http.HttpRequestFactory;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.IProgressCallback;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class eq implements IHttpRequest {
    private IProgressCallback oe;
    private er rC;
    private HttpRequestFactory rN;
    private ez rO = new ez();
    private ev rP = null;
    private ew rQ;

    public eq(HttpRequestFactory httpRequestFactory) {
        this.rN = httpRequestFactory;
        er erVar = new er();
        this.rC = erVar;
        erVar.method = "GET";
        erVar.rU = new HashMap();
        this.rC.rT = new es();
        this.rQ = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        if (aA(str)) {
            ((ey) this.rP).setData(bArr);
        }
        return this;
    }

    private boolean aA(String str) {
        ev evVar = this.rP;
        if (evVar != null && !(evVar instanceof ey)) {
            this.rC.aB(a(evVar));
            return false;
        }
        if (evVar == null) {
            ey eyVar = new ey();
            this.rP = eyVar;
            eyVar.a(this.rC.rS);
        }
        if (TextUtils.isEmpty(str) || this.rC.rU.containsKey("Content-Type")) {
            return true;
        }
        addHeader("Content-Type", str);
        return true;
    }

    private boolean az(String str) {
        er erVar;
        String str2;
        ev evVar = this.rP;
        if (evVar != null && !(evVar instanceof ex)) {
            erVar = this.rC;
            str2 = a(evVar);
        } else {
            if (evVar == null) {
                ex exVar = new ex();
                this.rP = exVar;
                exVar.a(this.rC.rS);
                ex exVar2 = (ex) this.rP;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                exVar2.aF(str);
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            ex exVar3 = (ex) this.rP;
            if (exVar3.isEmpty() || str.equals(exVar3.getBoundary())) {
                return true;
            }
            erVar = this.rC;
            str2 = "已经添加请求体内容，不能再更改boundary";
        }
        erVar.aB(str2);
        return false;
    }

    private boolean dL() {
        ev evVar = this.rP;
        if (evVar != null && !(evVar instanceof em)) {
            this.rC.aB(a(evVar));
            return false;
        }
        if (evVar != null) {
            return true;
        }
        em emVar = new em();
        this.rP = emVar;
        emVar.a(this.rC.rS);
        return true;
    }

    private er dM() {
        if (this.rC.hasError()) {
            throw new HttpException(3, this.rC.dN());
        }
        Charset charset = this.rC.rS;
        if (charset != null) {
            addHeader("charset", charset.name());
        }
        try {
            this.rC.url = this.rO.dO();
            if (this.rP != null) {
                if (!this.rC.rU.containsKey("Content-Type")) {
                    String contentType = this.rP.getContentType();
                    if (!TextUtils.isEmpty(contentType)) {
                        this.rC.rU.put("Content-Type", contentType);
                    }
                }
                this.rC.rV = this.rP;
            }
            return this.rC;
        } catch (MalformedURLException e) {
            throw new HttpException(3, e);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        if (az(null)) {
            ((ex) this.rP).l(str, str2);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        if (map != null && dL()) {
            em emVar = (em) this.rP;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    emVar.j(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormField(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null && dL()) {
            ((em) this.rP).j(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        String[] aC = eu.aC(str);
        if (aC == null) {
            this.rC.aB(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
            return this;
        }
        addHeader(aC[0], aC[1]);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeaders(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                addHeader(str);
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPart(String str, Object obj) {
        if (obj != null && az(null)) {
            ((ex) this.rP).k(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        if (map != null && az(null)) {
            ex exVar = (ex) this.rP;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    exVar.k(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryField(String str, Object obj) {
        if (obj != null) {
            this.rO.m(str, obj.toString());
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    this.rO.m(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        this.oe = null;
        ew ewVar = this.rQ;
        if (ewVar != null) {
            ewVar.cancel();
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(fa faVar) {
        ew ewVar = this.rQ;
        if (ewVar != null) {
            ewVar.cancel();
        }
        ep executor = this.rN.getExecutor();
        try {
            er dM = dM();
            if (dM != null) {
                this.rQ = executor.a(dM, faVar, this.oe);
            }
        } catch (HttpException e) {
            this.rQ = executor.a(e, faVar);
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        ew ewVar = this.rQ;
        if (ewVar != null) {
            ewVar.cancel();
        }
        ew a2 = this.rN.getExecutor().a(dM(), this.oe);
        this.rQ = a2;
        return a2.dH();
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        ev evVar = this.rP;
        return (evVar == null || !(evVar instanceof ex)) ? setAsMultipart(eo.MULTIPART_BOUNDARY) : this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str.getBytes(this.rC.rS), URLEncodedUtils.CONTENT_TYPE);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        this.rC.rS = charset;
        this.rO.a(charset);
        ev evVar = this.rP;
        if (evVar != null) {
            evVar.a(charset);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i) {
        this.rC.rT.rX = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        if (str != null) {
            this.rC.method = str.toUpperCase();
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.oe = iProgressCallback;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i) {
        this.rC.rT.rY = i;
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        this.rO.aG(str);
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        this.rC.rT.rZ = z;
        return this;
    }

    private String a(ev evVar) {
        return evVar instanceof ey ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : evVar instanceof em ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : evVar instanceof ex ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "";
    }

    private void addHeader(String str, String str2) {
        this.rC.rU.put(str, str2);
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        if (az(null)) {
            ((ex) this.rP).a(str, bArr);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        if (az(str)) {
            ((ex) this.rP).aF(str);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject.toString().getBytes(this.rC.rS), com.baidu.mobads.sdk.internal.an.d);
        }
        return this;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        return a(bArr, null);
    }
}
