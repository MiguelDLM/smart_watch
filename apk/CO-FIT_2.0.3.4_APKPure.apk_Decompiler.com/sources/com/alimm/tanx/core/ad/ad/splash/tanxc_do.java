package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tanxc_do {
    private static tanxc_do tanxc_do;
    private Queue<String> tanxc_for = new LinkedList();
    private List<RsDownloadStatus> tanxc_if = new ArrayList();
    private long tanxc_int = 0;

    private tanxc_do() {
    }

    public static tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_do();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return tanxc_do;
    }

    public synchronized void tanxc_do(@NonNull Context context) {
        this.tanxc_if.clear();
        SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.clear();
        edit.apply();
    }

    public synchronized void tanxc_do(@NonNull Context context, @NonNull String str, int i) {
        try {
            LogUtils.d("SplashAdAnalytics", "setRsDownloadStatus: resourceName = " + str + ", status = " + i);
            if (i == 0) {
                RsDownloadStatus rsDownloadStatus = new RsDownloadStatus(str, i);
                this.tanxc_if.add(rsDownloadStatus);
                tanxc_do(context, rsDownloadStatus);
            } else {
                for (RsDownloadStatus next : this.tanxc_if) {
                    if (TextUtils.equals(next.getFileName(), str)) {
                        next.setStatus(i);
                        tanxc_do(context, next);
                    }
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void tanxc_do(@NonNull Context context, @NonNull RsDownloadStatus rsDownloadStatus) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.putInt(rsDownloadStatus.getFileName(), rsDownloadStatus.getStatus());
        edit.apply();
    }
}
