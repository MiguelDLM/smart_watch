package com.baidu.platform.comapi.wnplatform.p;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes8.dex */
public class l {
    public static int a(Context context) {
        if (b(context) == null) {
            return 0;
        }
        return b(context).getStreamVolume(3);
    }

    private static AudioManager b(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        return null;
    }

    public static void a(Context context, int i) {
        if (b(context) == null) {
            return;
        }
        b(context).setStreamVolume(3, i, 0);
        if (b(context).isBluetoothScoOn()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("VolumeUtil", "phone state isBluetoothScoOn volume=" + i);
            b(context).setStreamVolume(6, i, 0);
        }
    }
}
