package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.jsb.inner.data.DeviceInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.util.Map;

/* loaded from: classes10.dex */
public class an extends ag {
    public static final String Z = "JsbReqSettings";

    public an() {
        super(aj.Code);
    }

    private int I(String str) {
        try {
            return R.string.class.getField(str).getInt(null);
        } catch (Throwable th) {
            fb.I(Z, "getResourceId err, " + th.getClass().getSimpleName());
            return 0;
        }
    }

    private String V(Context context) {
        Resources resources = context.getResources();
        Map<String, String> Code = com.huawei.openalliance.ad.utils.aa.Code(resources.getString(R.string.hiad_jssdk_i18n));
        if (Code == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : Code.entrySet()) {
            int I = I(entry.getValue());
            if (I > 0) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(resources.getString(I));
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.Code(ck.Code(context).V());
        deviceInfo.Code(d.Code());
        deviceInfo.V(V(context));
        ag.Code(remoteCallResultCallback, this.Code, 1000, com.huawei.openalliance.ad.utils.aa.Code(deviceInfo), true);
    }
}
