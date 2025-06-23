package com.jd.ad.sdk.jad_xi;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.jad_xi.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes10.dex */
public class jad_fs implements jad_dq {
    @NonNull
    public jad_cp jad_an(@NonNull Context context, @NonNull jad_cp.jad_an jad_anVar) {
        boolean z = ContextCompat.checkSelfPermission(context, g.b) == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Logger.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new jad_er(context, jad_anVar) : new jad_na();
    }
}
