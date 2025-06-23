package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.platform.comapi.pano.c;

/* loaded from: classes7.dex */
final class a implements a.InterfaceC0530a<c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6021a;

    public a(Context context) {
        this.f6021a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0530a
    public void a(c cVar) {
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        int i = b.f6022a[cVar.a().ordinal()];
        if (i == 1) {
            Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
            return;
        }
        if (i == 2) {
            Log.d("baidumapsdk", "pano id not found for this poi point");
            return;
        }
        if (i == 3) {
            Log.d("baidumapsdk", "please check ak for permission");
            return;
        }
        if (i != 4) {
            return;
        }
        if (cVar.c() != 1) {
            Log.d("baidumapsdk", "this point do not support for pano show");
            return;
        }
        try {
            BaiduMapPoiSearch.b(cVar.b(), this.f6021a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0530a
    public void a(HttpClient.HttpStateError httpStateError) {
        int i = b.b[httpStateError.ordinal()];
        if (i == 1) {
            Log.d("baidumapsdk", "current network is not available");
        } else {
            if (i != 2) {
                return;
            }
            Log.d("baidumapsdk", "network inner error, please check network");
        }
    }
}
