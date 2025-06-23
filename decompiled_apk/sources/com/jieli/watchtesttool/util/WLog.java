package com.jieli.watchtesttool.util;

import android.content.Context;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class WLog extends JL_Log {
    public static void configureLog(Context context, boolean z, boolean z2) {
        JL_Log.setTagPrefix("watch_test");
        JL_Log.configureLog(context, z, z2);
        com.jieli.bluetooth_connect.util.JL_Log.setLog(z);
        com.jieli.jl_bt_ota.util.JL_Log.setLog(z);
        if (z2) {
            com.jieli.bluetooth_connect.util.JL_Log.setLogOutput(new JL_Log.ILogOutput() { // from class: com.jieli.watchtesttool.util.oIX0oI
                @Override // com.jieli.bluetooth_connect.util.JL_Log.ILogOutput
                public final void output(String str) {
                    com.jieli.jl_rcsp.util.JL_Log.addLogOutput(str);
                }
            });
            com.jieli.jl_bt_ota.util.JL_Log.setLogOutput(new JL_Log.ILogOutput() { // from class: com.jieli.watchtesttool.util.II0xO0
                @Override // com.jieli.jl_bt_ota.util.JL_Log.ILogOutput
                public final void output(String str) {
                    com.jieli.jl_rcsp.util.JL_Log.addLogOutput(str);
                }
            });
        } else {
            com.jieli.bluetooth_connect.util.JL_Log.setLogOutput(null);
            com.jieli.jl_bt_ota.util.JL_Log.setLogOutput(null);
        }
    }
}
