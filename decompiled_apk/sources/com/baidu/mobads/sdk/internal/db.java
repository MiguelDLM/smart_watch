package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.api.CPUAdType;
import com.baidu.mobads.sdk.api.CPUDramaDetailConfig;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.CPUDramaRequestParams;
import com.baidu.mobads.sdk.api.CPUDramaResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class db extends bj {

    /* renamed from: a, reason: collision with root package name */
    private CPUDramaRequestParams f6302a;
    private CPUDramaResponse q;
    private boolean r;
    private CPUDramaListener s;

    public db(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f6302a = cPUDramaRequestParams;
        this.s = cPUDramaListener;
        this.r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOAdEvent iOAdEvent) {
        CPUDramaResponse coverImageUrl;
        if (this.s != null) {
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    coverImageUrl = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.s.onVideoCollect(coverImageUrl);
            }
            coverImageUrl = null;
            this.s.onVideoCollect(coverImageUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(IOAdEvent iOAdEvent) {
        CPUDramaResponse coverImageUrl;
        if (this.s != null) {
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    coverImageUrl = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.s.onVideoPlay(coverImageUrl);
            }
            coverImageUrl = null;
            this.s.onVideoPlay(coverImageUrl);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.s != null && iOAdEvent != null && (data = iOAdEvent.getData()) != null) {
            Object obj = data.get("adType");
            if (obj instanceof String) {
                this.s.onADExposed(CPUAdType.parse((String) obj));
            }
        }
    }

    public void f() {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "refresh");
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.s != null && iOAdEvent != null && (data = iOAdEvent.getData()) != null) {
            Object obj = data.get("adType");
            if (obj instanceof String) {
                this.s.onAdClick(CPUAdType.parse((String) obj));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
    }

    public Fragment b(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getSupportFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (!(obj instanceof FragmentV4Delegate)) {
                return null;
            }
            FragmentV4Delegate fragmentV4Delegate = (FragmentV4Delegate) obj;
            fragmentV4Delegate.setProxy(eVar);
            return fragmentV4Delegate;
        } catch (JSONException e) {
            bv.a().a(e);
            return null;
        }
    }

    public db(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f6302a = cPUDramaRequestParams;
        this.q = cPUDramaResponse;
        this.s = cPUDramaListener;
        this.r = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        HashMap hashMap;
        String str;
        Object remove;
        String str2;
        if (this.k != null && this.f6302a != null) {
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                this.k.createProdHandler(jSONObject3);
                n();
                dc dcVar = new dc(this);
                this.k.addEventListener("onContentLoaded", dcVar);
                this.k.addEventListener("onContentFailed", dcVar);
                this.k.addEventListener(x.as, dcVar);
                this.k.addEventListener(x.at, dcVar);
                hashMap = new HashMap(this.f6302a.getExtras());
                str = (String) hashMap.remove("subChannelId");
                remove = hashMap.remove("dramaDetailConfig");
                str2 = (String) hashMap.remove("appsid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                jSONObject.put("subChannelId", str);
                jSONObject.put("appid", str2);
                jSONObject.put("isDramaListRequest", this.r);
                CPUDramaResponse cPUDramaResponse = this.q;
                if (cPUDramaResponse != null) {
                    jSONObject.put("dramaContentId", cPUDramaResponse.getDramaContentId());
                    jSONObject.put("dramaSubVideoId", this.q.getDramaSubVideoId());
                    jSONObject.put("dramaRepresent", this.q.getRepresent());
                }
                jSONObject2 = k.a((HashMap<String, Object>) hashMap);
                if (remove instanceof CPUDramaDetailConfig) {
                    jSONObject2.put("freeCount", ((CPUDramaDetailConfig) remove).mFreeCount);
                    jSONObject2.put("unLockCount", ((CPUDramaDetailConfig) remove).mUnLockCount);
                }
                this.k.loadAd(jSONObject, jSONObject2);
                return;
            }
            CPUDramaListener cPUDramaListener = this.s;
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "短剧请求缺少sid 或 scid！");
            }
            az.c().e("短剧请求缺少sid 或 scid！");
            return;
        }
        this.l = false;
        CPUDramaListener cPUDramaListener2 = this.s;
        if (cPUDramaListener2 != null) {
            cPUDramaListener2.onContentFailed(-2, "短剧请求缺少必要参数！");
        }
        az.c().e("短剧请求缺少必要参数！");
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.s.onADExposureFailed(CPUAdType.parse((String) obj));
        }
    }

    public android.app.Fragment a(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (!(obj instanceof FragmentDelegate)) {
                return null;
            }
            FragmentDelegate fragmentDelegate = (FragmentDelegate) obj;
            fragmentDelegate.setProxy(eVar);
            return fragmentDelegate;
        } catch (JSONException e) {
            bv.a().a(e);
            return null;
        }
    }
}
