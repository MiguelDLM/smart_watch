package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class a {
    private SearchType f;
    private AsyncHttpClient b = new AsyncHttpClient();
    private Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    protected final Lock f9526a = new ReentrantLock();
    private boolean d = true;
    private DistrictResult e = null;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        int i;
        int permissionCheck;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                if (jSONObject.has("status")) {
                    i = jSONObject.getInt("status");
                } else {
                    i = jSONObject.getInt("status_sp");
                }
                if ((i == 105 || i == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                    Log.e("BaseSearch", "permissionCheck result is: " + permissionCheck);
                    return true;
                }
                return true;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private int b(String str) {
        JSONObject optJSONObject;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                return (!jSONObject.has("result") || (optJSONObject = jSONObject.optJSONObject("result")) == null) ? ErrorCode.MSP_ERROR_NET_SENDSOCK : optJSONObject.optInt("error");
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return ErrorCode.MSP_ERROR_NET_SENDSOCK;
    }

    public boolean a(e eVar, Object obj, d dVar) {
        if (dVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        SearchType a2 = dVar.a();
        this.f = a2;
        String a3 = eVar.a(a2);
        if (a3 == null) {
            Log.e("BaseSearch", "The sendurl is: " + a3);
            a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
            return false;
        }
        this.b.get(a3, new b(this, dVar, obj));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        byte[] bArr = {102, 97, 105, 108, 100};
        try {
            bArr = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            Log.e("BaseSearch", "transform result failed");
        }
        return new String(bArr).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult a2 = dVar.a(str);
        a2.status = b(str);
        if (a(dVar, a2)) {
            a(asyncHttpClient, protoResultCallback, a2);
            return;
        }
        if (dVar instanceof com.baidu.platform.core.b.b) {
            DistrictResult districtResult = this.e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) a2;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.e.getCenterPt());
            }
            a(a2, obj, dVar);
            this.d = true;
            this.e = null;
            ((com.baidu.platform.core.b.b) dVar).a(false);
            return;
        }
        a(a2, obj, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        this.c.post(new c(this, dVar, searchResult, obj));
    }

    private boolean a(d dVar, SearchResult searchResult) {
        if (!(dVar instanceof com.baidu.platform.core.b.b)) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) searchResult;
        if (SearchResult.ERRORNO.RESULT_NOT_FOUND != districtResult.error || districtResult.getCityName() == null || !this.d) {
            return false;
        }
        this.d = false;
        this.e = districtResult;
        ((com.baidu.platform.core.b.b) dVar).a(true);
        return true;
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.b.c(((DistrictResult) searchResult).getCityName()).a(this.f), protoResultCallback);
    }
}
