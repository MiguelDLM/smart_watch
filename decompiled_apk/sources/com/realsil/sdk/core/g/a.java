package com.realsil.sdk.core.g;

import android.util.Log;
import com.realsil.sdk.core.logger.Logger;

/* loaded from: classes11.dex */
public final class a implements Logger {
    @Override // com.realsil.sdk.core.logger.Logger
    public final void log(int i, String str, String str2) {
        switch (i) {
            case 1:
                Log.v(str, str2);
                return;
            case 2:
                Log.d(str, str2);
                return;
            case 3:
                Log.i(str, str2);
                return;
            case 4:
                Log.w(str, str2);
                return;
            case 5:
                Log.e(str, str2);
                return;
            case 6:
                Log.wtf(str, str2);
                return;
            default:
                return;
        }
    }
}
