package com.jieli.watchtesttool.util;

import android.content.Context;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.jieli.jl_bt_ota.util.JL_Log;

/* loaded from: classes10.dex */
public class JL_LogUtils {
    private static boolean isEnable = false;

    public static void disableLog(Context context) {
        isEnable = false;
        JL_Log.setLog(false);
        JL_Log.setIsSaveLogFile(context, false);
        com.jieli.bluetooth_connect.util.JL_Log.setLog(false);
        com.jieli.bluetooth_connect.util.JL_Log.setLogOutput(null);
    }

    public static void enableLog(Context context) {
        if (!isEnable) {
            isEnable = true;
            JL_Log.setLog(true);
            JL_Log.setIsSaveLogFile(context, true);
            com.jieli.bluetooth_connect.util.JL_Log.setLog(true);
            com.jieli.bluetooth_connect.util.JL_Log.setLogOutput(new JL_Log.ILogOutput() { // from class: com.jieli.watchtesttool.util.JL_LogUtils.1
                @Override // com.jieli.bluetooth_connect.util.JL_Log.ILogOutput
                public void output(String str) {
                    com.jieli.jl_bt_ota.util.JL_Log.addLogOutput(str);
                }
            });
        }
    }
}
