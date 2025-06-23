package com.huawei.hms.ads;

import android.util.Log;

/* loaded from: classes10.dex */
public final class fd extends ez {
    private fd() {
    }

    public static fg Code() {
        return new fd();
    }

    @Override // com.huawei.hms.ads.fg
    public fg Code(String str, String str2) {
        fg fgVar = this.Code;
        if (fgVar != null) {
            fgVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.fg
    public void Code(fi fiVar, int i, String str) {
        if (fiVar == null) {
            return;
        }
        Code(fiVar.V(), i, str);
        fg fgVar = this.Code;
        if (fgVar != null) {
            fgVar.Code(fiVar, i, str);
        }
    }

    private void Code(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
            return;
        }
        if (i != 4) {
            if (i == 5) {
                Log.w(str2, str);
                return;
            } else if (i == 6) {
                Log.e(str2, str);
                return;
            }
        }
        Log.i(str2, str);
    }
}
