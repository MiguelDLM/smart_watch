package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class an implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9857a;

    public an(z zVar) {
        this.f9857a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i;
        int i2;
        int i3;
        int i4;
        relativeLayout = this.f9857a.w;
        relativeLayout.clearAnimation();
        relativeLayout2 = this.f9857a.w;
        relativeLayout2.setVisibility(8);
        try {
            JSONObject jSONObject = new JSONObject();
            i = this.f9857a.C;
            if (i != 0) {
                i2 = this.f9857a.C;
                if (i2 != 1) {
                    i3 = this.f9857a.C;
                    if (i3 != 2) {
                        i4 = this.f9857a.C;
                        if (i4 == 4) {
                            jSONObject.put("status", "poiLoading");
                        }
                    } else {
                        jSONObject.put("status", "routeFail");
                    }
                } else {
                    jSONObject.put("status", "routeSuc");
                }
            } else {
                jSONObject.put("status", "routeLoading");
            }
        } catch (Exception unused) {
        }
    }
}
