package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class dd extends fu<com.huawei.openalliance.ad.augreality.views.a> implements de<com.huawei.openalliance.ad.augreality.views.a> {
    private static final String V = "com.huawei.hms.ads.dd";
    private Context I;

    public dd(Context context, com.huawei.openalliance.ad.augreality.views.a aVar) {
        this.I = context;
        Code((dd) aVar);
    }

    private void V(ImageInfo imageInfo, com.huawei.openalliance.ad.utils.an anVar) {
        String str;
        String str2;
        if (imageInfo == null) {
            fb.I(V, "loadImage imageInfo is null");
            anVar.Code();
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            str = adContentData.a();
            str2 = this.Code.L();
        } else {
            str = null;
            str2 = null;
        }
        com.huawei.openalliance.ad.utils.z.Code(this.I, sourceParam, str, str2, anVar);
    }

    @Override // com.huawei.hms.ads.de
    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.Code = adContentData;
    }

    private void V(String str) {
        if (this.Code == null) {
            return;
        }
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B(1);
        jc.Code(this.I, this.Code, (String) null, 0, 0, str, 1, com.huawei.openalliance.ad.utils.b.Code(I()), materialClickInfo);
    }

    @Override // com.huawei.hms.ads.de
    public void Code(ImageInfo imageInfo, com.huawei.openalliance.ad.utils.an anVar) {
        String str = V;
        fb.V(str, "checkArImageHashAndLoad " + imageInfo);
        if (imageInfo == null) {
            fb.I(str, "checkArImageHashAndLoad imageInfo is null");
        } else {
            V(imageInfo, anVar);
        }
    }

    @Override // com.huawei.hms.ads.de
    public boolean Code() {
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(this.I, this.Code, new HashMap(0));
        if (!Code.Code()) {
            return true;
        }
        V(Code.I());
        return true;
    }

    @Override // com.huawei.hms.ads.de
    public boolean V() {
        return false;
    }
}
