package com.iflytek.sparkchain.plugins.music.tools;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.iflytek.sparkchain.plugins.base.BasePlugin;
import java.util.List;

/* loaded from: classes10.dex */
public class MusicPlugin extends BasePlugin {
    public static final String OperateTool = "switchSongs";
    public static final String PlayMusic = "musicPlayer";

    public MusicPlugin() {
        this.tools.append(new b()).append(new a());
    }

    public static boolean isService(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(100);
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().contains(str)) {
                return true;
            }
        }
        return false;
    }
}
