package com.alimm.tanx.ui.image.glide.manager;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes.dex */
public class ConnectivityMonitorFactory {
    public ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        if (context.checkCallingOrSelfPermission(g.b) == 0) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
