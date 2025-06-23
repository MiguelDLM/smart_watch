package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: classes10.dex */
public class ii extends fu<kt> implements iv<kt> {
    private ky B;
    private ed I;
    private ij Z;

    public ii(Context context, kt ktVar) {
        Code((ii) ktVar);
        this.I = ed.Code(context);
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(int i, boolean z) {
        fb.V("SloganPresenter", "show image");
        if (i <= 0) {
            Code(z);
            return;
        }
        I().Code(i);
        if (z) {
            hy hyVar = new hy(this.I, this.B);
            this.Z = hyVar;
            hyVar.V();
        }
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(ky kyVar) {
        this.B = kyVar;
    }

    private void Code(boolean z) {
        if (z) {
            hx hxVar = new hx(this.I, this.B);
            this.Z = hxVar;
            hxVar.Code();
        }
    }
}
