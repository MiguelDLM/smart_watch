package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.views.AppDownloadButton;

/* loaded from: classes10.dex */
public class e extends com.huawei.hms.ads.template.downloadbuttonstyle.a {
    private RemoteButtonStyleAttr Z;

    /* loaded from: classes10.dex */
    public static class a extends com.huawei.openalliance.ad.views.c {
        public a(Context context, RemoteButtonStyleAttr remoteButtonStyleAttr) {
            super(context);
            this.V.Code(remoteButtonStyleAttr.F());
            this.V.V((int) remoteButtonStyleAttr.l());
            this.V.Code(remoteButtonStyleAttr.a());
            this.I.Code(remoteButtonStyleAttr.b());
            this.I.V((int) remoteButtonStyleAttr.l());
            this.I.Code(remoteButtonStyleAttr.c());
            this.Z.Code(remoteButtonStyleAttr.d());
            this.Z.V((int) remoteButtonStyleAttr.l());
            this.Z.Code(remoteButtonStyleAttr.e());
            this.B.Code(remoteButtonStyleAttr.D());
            this.C = remoteButtonStyleAttr.f() == null ? context.getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn_dark) : remoteButtonStyleAttr.f();
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.huawei.openalliance.ad.views.c {
        public b(Context context, RemoteButtonStyleAttr remoteButtonStyleAttr) {
            super(context);
            this.V.Code(remoteButtonStyleAttr.Code());
            this.V.V((int) remoteButtonStyleAttr.l());
            this.V.Code(remoteButtonStyleAttr.V());
            this.I.Code(remoteButtonStyleAttr.I());
            this.I.V((int) remoteButtonStyleAttr.l());
            this.I.Code(remoteButtonStyleAttr.Z());
            this.Z.Code(remoteButtonStyleAttr.B());
            this.Z.V((int) remoteButtonStyleAttr.l());
            this.Z.Code(remoteButtonStyleAttr.C());
            this.B.Code(remoteButtonStyleAttr.D());
            this.C = remoteButtonStyleAttr.S() == null ? context.getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn) : remoteButtonStyleAttr.S();
        }
    }

    public e(Context context, AppDownloadButton appDownloadButton, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        super(context, appDownloadButton);
        this.Z = remoteButtonStyleAttr;
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void Code() {
        AppDownloadButton appDownloadButton;
        com.huawei.openalliance.ad.views.a aVar;
        boolean Code = Code(this.Code.getResources().getConfiguration().uiMode);
        boolean f = bc.f(this.Code);
        if (fb.Code()) {
            fb.Code("RemoteButtonStyle", "emui9DarkMode %s, isNight %s", Boolean.valueOf(f), Boolean.valueOf(Code));
        }
        if (Code || f) {
            appDownloadButton = this.V;
            aVar = new a(this.Code, this.Z);
        } else {
            appDownloadButton = this.V;
            aVar = new b(this.Code, this.Z);
        }
        appDownloadButton.setAppDownloadButtonStyle(aVar);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void V(Context context) {
        this.V.setMinWidth(this.Z.j());
        this.V.setPaddingRelative(this.Z.n(), this.Z.p(), this.Z.o(), this.Z.q());
        this.V.setMaxWidth(this.Z.i());
        this.V.setFontFamily(this.Z.m());
        this.V.setTextSize(this.Z.l());
        this.V.updateLayoutHeight();
        this.V.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.a
    public void Code(String str) {
        this.V.setMinWidth(this.Z.j());
        this.V.setPaddingRelative(this.Z.n(), this.Z.p(), this.Z.o(), this.Z.q());
        this.V.setMaxWidth(this.Z.i());
        this.V.setResetWidth(this.Z.h());
        this.V.setFixedWidth(this.Z.g());
        this.V.setFontFamily(this.Z.m());
        this.V.setTextSize(this.Z.l());
        this.V.setTextColor(this.Z.V());
        this.V.setBackground(this.Z.Code());
        if (TextUtils.isEmpty(str)) {
            this.V.setText(this.Code.getString(R.string.hiad_detail));
        } else {
            this.V.setText(str);
        }
    }

    private boolean Code(int i) {
        return (i & 48) == 32;
    }
}
