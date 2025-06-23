package org.apache.commons.lang3;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.huawei.openalliance.ad.constant.bn;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes6.dex */
public class ooOOo0oXI {
    public static String I0Io(Class<?> cls, String str) {
        xoIxX.xo0x(cls, "Parameter '%s' must not be null!", bn.f.o);
        xoIxX.xo0x(str, "Parameter '%s' must not be null!", "resourceName");
        return oxoX(cls.getPackage(), str);
    }

    public static String II0xO0(Package r4, String str) {
        xoIxX.xo0x(r4, "Parameter '%s' must not be null!", bn.f.o);
        xoIxX.xo0x(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName() + FileUtils.FILE_EXTENSION_SEPARATOR + str;
    }

    public static String oIX0oI(Class<?> cls, String str) {
        xoIxX.xo0x(cls, "Parameter '%s' must not be null!", bn.f.o);
        xoIxX.xo0x(str, "Parameter '%s' must not be null!", "resourceName");
        return II0xO0(cls.getPackage(), str);
    }

    public static String oxoX(Package r4, String str) {
        xoIxX.xo0x(r4, "Parameter '%s' must not be null!", bn.f.o);
        xoIxX.xo0x(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + str;
    }
}
