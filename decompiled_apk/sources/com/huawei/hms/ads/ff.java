package com.huawei.hms.ads;

import androidx.exifinterface.media.ExifInterface;
import com.vtrump.vtble.Oxx0IOOO;

/* loaded from: classes10.dex */
public abstract class ff {
    public static final int Code = 3;
    public static final int I = 5;
    public static final int V = 4;
    public static final int Z = 6;

    public static String Code(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST : "W" : Oxx0IOOO.f27277xI : "D";
    }
}
