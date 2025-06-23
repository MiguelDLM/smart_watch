package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;

/* loaded from: classes10.dex */
public class b extends com.huawei.hms.ads.template.downloadbuttonstyle.a {
    protected int I;
    protected int Z;

    /* loaded from: classes10.dex */
    public static class a extends com.huawei.openalliance.ad.views.c {
        public a(Context context, int i) {
            super(context);
            Resources resources = context.getResources();
            a.C0672a c0672a = this.V;
            int i2 = R.drawable.hiad_native_tpt_list_page_btn;
            c0672a.Code(resources.getDrawable(i2));
            this.V.V(i);
            this.V.Code(resources.getColor(R.color.hiad_down_btn_normal));
            this.I.Code(resources.getDrawable(i2));
            this.I.V(i);
            this.I.Code(resources.getColor(R.color.hiad_down_btn_process));
            this.Z.Code(resources.getDrawable(i2));
            this.Z.V(i);
            this.Z.Code(resources.getColor(R.color.hiad_down_btn_installing));
        }
    }

    public b(Context context, AppDownloadButton appDownloadButton) {
        super(context, appDownloadButton);
        this.I = (int) context.getResources().getDimension(R.dimen.hiad_12_dp);
        this.Z = (int) context.getResources().getDimension(R.dimen.hiad_6_dp);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void Code() {
        this.V.setAppDownloadButtonStyle(new a(this.Code, this.I));
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void V(Context context) {
        this.V.setMinWidth((int) context.getResources().getDimension(R.dimen.hiad_64_dp));
        this.V.setPadding(0, 0, 0, this.Z);
        this.V.setMaxWidth((int) context.getResources().getDimension(R.dimen.hiad_144_dp));
        this.V.setFontFamily(x.db);
        this.V.setTextSize(this.I);
        this.V.updateLayoutHeight();
        this.V.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void Code(String str) {
        this.V.setMinWidth((int) this.Code.getResources().getDimension(R.dimen.hiad_64_dp));
        this.V.setPadding(0, 0, 0, this.Z);
        this.V.setMaxWidth((int) this.Code.getResources().getDimension(R.dimen.hiad_144_dp));
        this.V.setFontFamily(x.db);
        this.V.setTextSize(this.I);
        this.V.setTextColor(this.Code.getResources().getColor(R.color.hiad_down_btn_normal));
        this.V.setBackground(this.Code.getResources().getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
        if (TextUtils.isEmpty(str)) {
            this.V.setText(this.Code.getString(R.string.hiad_detail));
        } else {
            this.V.setText(str);
        }
    }
}
