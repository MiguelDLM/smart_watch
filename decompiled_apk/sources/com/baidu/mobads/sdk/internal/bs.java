package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.LinkedHashMap;

/* loaded from: classes7.dex */
public class bs implements ExpressResponse {

    /* renamed from: a, reason: collision with root package name */
    private Context f6256a;
    private int b = 1;
    private ExpressResponse.ExpressInteractionListener c;
    private ExpressResponse.ExpressAdDownloadWindowListener d;
    private ExpressResponse.ExpressDislikeListener e;
    private ExpressResponse.ExpressCloseListener f;
    private final dm g;
    private final a h;
    private ViewGroup i;
    private ExpressAdData j;

    public bs(Context context, dm dmVar, a aVar) {
        this.f6256a = context;
        this.g = dmVar;
        this.h = aVar;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dm dmVar = this.g;
        if (dmVar != null) {
            dmVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.h != null) {
            if ("request_id".equals(str)) {
                return this.h.U();
            }
            return this.h.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.z();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.i == null && (aVar = this.h) != null) {
            this.i = this.g.a(aVar);
        }
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        if (this.h == null || System.currentTimeMillis() - this.h.y() > this.h.F()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dm dmVar = this.g;
        if (dmVar != null && (aVar = this.h) != null) {
            if (this.i == null) {
                this.i = dmVar.a(aVar);
            }
            this.g.a(this.i, this.h);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i) {
        dm dmVar = this.g;
        if (dmVar != null) {
            return dmVar.a(this.i, this.h, i);
        }
        return false;
    }

    public String a() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.H();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.h;
        if (aVar == null || (dmVar = this.g) == null) {
            return;
        }
        dmVar.a(aVar.H(), false, str, linkedHashMap);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.h;
        if (aVar == null || (dmVar = this.g) == null) {
            return;
        }
        dmVar.a(aVar.H(), true, str, linkedHashMap);
    }

    public void b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i, i2);
        }
    }

    public void a(View view, String str, int i) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(String str) {
        dm dmVar;
        a aVar = this.h;
        if (aVar != null && (dmVar = this.g) != null) {
            this.j = new ExpressAdData(aVar, dmVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
