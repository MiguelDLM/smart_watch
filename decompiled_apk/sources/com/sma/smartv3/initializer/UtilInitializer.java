package com.sma.smartv3.initializer;

import android.app.Application;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.x0o;

@XX({"SMAP\nUtilInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtilInitializer.kt\ncom/sma/smartv3/initializer/UtilInitializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n1002#2,2:93\n1864#2,3:95\n*S KotlinDebug\n*F\n+ 1 UtilInitializer.kt\ncom/sma/smartv3/initializer/UtilInitializer\n*L\n70#1:93,2\n71#1:95,3\n*E\n"})
/* loaded from: classes12.dex */
public final class UtilInitializer implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final UtilInitializer f20904XO = new UtilInitializer();

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f20903Oo = 240;

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 UtilInitializer.kt\ncom/sma/smartv3/initializer/UtilInitializer\n*L\n1#1,328:1\n70#2:329\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            File file = (File) t;
            UtilInitializer utilInitializer = UtilInitializer.f20904XO;
            IIX0o.ooOOo0oXI(file);
            Long valueOf = Long.valueOf(-utilInitializer.I0Io(file));
            File file2 = (File) t2;
            IIX0o.ooOOo0oXI(file2);
            return xX0ox.Oxx0IOOO.oOoXoXO(valueOf, Long.valueOf(-utilInitializer.I0Io(file2)));
        }
    }

    public static /* synthetic */ void XO(UtilInitializer utilInitializer, File file, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = f20903Oo;
        }
        utilInitializer.X0o0xo(file, i);
    }

    public final long I0Io(File file) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).parse(file.getName());
            IIX0o.ooOOo0oXI(parse);
            return parse.getTime();
        } catch (Exception unused) {
            return file.lastModified();
        }
    }

    @XO0.XO(tag = XoI0Ixx0.f24489xoIox)
    public final void Oxx0IOOO(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onPrivacyAgree");
        CrashUtils.init(IXxxXO.x0xO0oo(X00IoxXI.oIX0oI.f3233oIX0oI));
        kotlinx.coroutines.II0XooXoX.X0o0xo(x0o.oIX0oI(Xo0.I0Io()), null, null, new UtilInitializer$onPrivacyAgree$1(null), 3, null);
    }

    public final void X0o0xo(File file, int i) {
        long[] oI0IIXIo2 = com.sma.smartv3.util.xoIox.oI0IIXIo(i);
        List<File> listFilesInDir = FileUtils.listFilesInDir(file);
        IIX0o.ooOOo0oXI(listFilesInDir);
        if (listFilesInDir.size() > 1) {
            kotlin.collections.o00.OO0x0xX(listFilesInDir, new oIX0oI());
        }
        IIX0o.oO(listFilesInDir, "apply(...)");
        int i2 = 0;
        for (Object obj : listFilesInDir) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            File file2 = (File) obj;
            UtilInitializer utilInitializer = f20904XO;
            IIX0o.ooOOo0oXI(file2);
            long I0Io2 = utilInitializer.I0Io(file2);
            if (I0Io2 < oI0IIXIo2[0] || I0Io2 > oI0IIXIo2[1]) {
                FileUtils.delete(file2);
            }
            i2 = i3;
        }
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        Utils.init(app);
        LogUtils.Config config = LogUtils.getConfig();
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        config.setLogSwitch(xo0.XO().getBoolean(XoI0Ixx0.f24433XxX0x0xxx, false));
        config.setGlobalTag("TAAG");
        config.setLog2FileSwitch(true);
        config.setDir(IXxxXO.oxxXoxO(X00IoxXI.oIX0oI.f3233oIX0oI));
        if (xo0.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
            LogUtils.d("UtilInitializer initialize");
            Oxx0IOOO(new Object());
        }
    }

    public final int oxoX() {
        return f20903Oo;
    }
}
