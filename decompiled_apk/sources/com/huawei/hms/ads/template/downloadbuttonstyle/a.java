package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import com.huawei.openalliance.ad.views.AppDownloadButton;

/* loaded from: classes10.dex */
public abstract class a {
    protected Context Code;
    protected AppDownloadButton V;

    public a(Context context, AppDownloadButton appDownloadButton) {
        this.Code = context;
        this.V = appDownloadButton;
    }

    public abstract void Code();

    public void Code(Context context) {
        V(context);
        Code();
    }

    public abstract void Code(String str);

    public abstract void V(Context context);
}
