package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private dm f6325a;
    private String b;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(int i, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i);

        void a(List<NativeResponse> list);

        void b();

        void b(int i, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public f(Context context, String str, a aVar, boolean z, int i) {
        this(context, aVar, new dm(context, str, "feed", z, i));
    }

    public void a() {
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public f(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        dm dmVar = new dm(context, str, "feed", z, i);
        this.f6325a = dmVar;
        dmVar.a(expressAdListener);
        this.f6325a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.h(this.b);
        }
        this.f6325a.a(requestParameters);
        this.f6325a.a();
    }

    public void a(b bVar) {
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.a(bVar);
        }
    }

    public void a(int i) {
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.p = i;
        }
    }

    public f(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        dm dmVar = new dm(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.f6325a = dmVar;
        dmVar.a(entryAdListener);
    }

    public void a(boolean z) {
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.c(z);
        }
    }

    public void b(String str) {
        this.b = str;
    }

    public f(Context context, String str, a aVar, boolean z, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f6325a = new dm(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f6325a = new dm(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f6325a = new dm(context, str, "video", z, i);
            } else {
                this.f6325a = new dm(context, str, "feed", z, i);
            }
        }
        this.f6325a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f6325a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f6325a.h(this.b);
        this.f6325a.a(requestParameters);
        return this.f6325a.m();
    }

    public void a(String str) {
        dm dmVar = this.f6325a;
        if (dmVar != null) {
            dmVar.b(str);
        }
    }

    public f(Context context, a aVar, dm dmVar) {
        this.f6325a = dmVar;
        dmVar.a(aVar);
    }
}
