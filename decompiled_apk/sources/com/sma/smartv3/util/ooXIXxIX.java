package com.sma.smartv3.util;

import android.content.Context;
import com.jieli.bluetooth_connect.util.JL_Log;

/* loaded from: classes12.dex */
public class ooXIXxIX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static boolean f24515oIX0oI = false;

    /* loaded from: classes12.dex */
    public class oIX0oI implements JL_Log.ILogOutput {
        @Override // com.jieli.bluetooth_connect.util.JL_Log.ILogOutput
        public void output(String logcat) {
            com.jieli.jl_bt_ota.util.JL_Log.addLogOutput(logcat);
        }
    }

    public static void II0xO0(Context context) {
        if (!f24515oIX0oI) {
            f24515oIX0oI = true;
            com.jieli.jl_bt_ota.util.JL_Log.setLog(true);
            com.jieli.jl_bt_ota.util.JL_Log.setIsSaveLogFile(context, true);
            JL_Log.setLog(true);
            JL_Log.setLogOutput(new oIX0oI());
        }
    }

    public static void oIX0oI(Context context) {
        f24515oIX0oI = false;
        com.jieli.jl_bt_ota.util.JL_Log.setLog(false);
        com.jieli.jl_bt_ota.util.JL_Log.setIsSaveLogFile(context, false);
        JL_Log.setLog(false);
        JL_Log.setLogOutput(null);
    }
}
