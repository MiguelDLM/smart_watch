package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.interaction.tanxc_for;
import com.alimm.tanx.core.utils.LogUtils;
import com.baidu.navisdk.ui.widget.BNWebViewClient;

public class tanxc_if {
    public static boolean tanxc_do(Context context, String str) {
        if (!tanxc_do(str)) {
            return tanxc_for.tanxc_do.tanxc_do.tanxc_do(context, str);
        }
        return false;
    }

    public static boolean tanxc_do(int i, long j) {
        if (i != 0) {
            if (i == 1 || i == 5 || i == 6 || i == 7 || i == 8) {
                return true;
            }
        } else if (j == -1) {
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("isUserHit: diff = ");
            long j2 = currentTimeMillis - j;
            sb.append(j2);
            sb.append(", hitTest = ");
            sb.append(5000);
            LogUtils.d("AdWebHelper", sb.toString());
            if (j2 > ((long) 5000)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().startsWith(BNWebViewClient.URL_HTTP_PREFIX) || str.toLowerCase().startsWith(BNWebViewClient.URL_HTTPS_PREFIX)) {
            return true;
        }
        return false;
    }
}
