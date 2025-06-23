package com.baidu.platform.comapi.walknavi.h.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static Toast f9800a;

    public static void a(Context context, String str) {
        List<ActivityManager.RunningTaskInfo> list;
        ComponentName componentName;
        if (context == null) {
            return;
        }
        int i = 1;
        try {
            list = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1);
        } catch (SecurityException unused) {
            Log.e("TipTool", "catch SecurityException");
            list = null;
        }
        if (list != null && list.get(0) != null) {
            String packageName = context.getPackageName();
            componentName = list.get(0).baseActivity;
            if (packageName.equals(componentName.getPackageName())) {
                Toast toast = f9800a;
                if (toast != null) {
                    toast.cancel();
                }
                if (str.length() <= 15) {
                    i = 0;
                }
                Toast makeText = Toast.makeText(context, str, i);
                f9800a = makeText;
                makeText.show();
            }
        }
    }
}
