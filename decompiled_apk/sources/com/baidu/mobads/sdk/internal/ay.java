package com.baidu.mobads.sdk.internal;

import OoOoXO0.xoXoI;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.vtrump.vtble.Oxx0IOOO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes7.dex */
public class ay extends ax {
    public static final String b = "logout";
    private static final String[] c = {xoXoI.f2670oxoX, xoXoI.f2670oxoX, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", Oxx0IOOO.f27277xI, "W", ExifInterface.LONGITUDE_EAST, "A"};

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    @NonNull
    public String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    public void a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c2 = aa.a().c();
            if (c2 != null) {
                c2.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
