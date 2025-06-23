package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.o;

/* loaded from: classes10.dex */
public abstract class f {
    public static void Code(Context context, long j, o.a aVar) {
        o.Code(context, context.getString(R.string.hiad_reminder_app_over_size, Long.valueOf(j)), context.getString(R.string.hiad_download_app_via_mobile_data), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void V(Context context, long j, o.a aVar) {
        o.Code(context, context.getString(R.string.hiad_dialog_title_tip), com.huawei.openalliance.ad.utils.j.Code(context, R.string.hiad_download_use_mobile_network, "hiad_download_use_mobile_network", ay.Code(context, j)), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void Code(Context context, boolean z, o.a aVar) {
        o.Code(context, "", context.getString(z ? R.string.hiad_confirm_restore_app : R.string.hiad_confirm_download_app), context.getString(R.string.hiad_download_install), context.getString(R.string.hiad_dialog_cancel), aVar);
    }
}
