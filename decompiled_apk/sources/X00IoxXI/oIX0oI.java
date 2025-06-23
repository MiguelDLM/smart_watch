package X00IoxXI;

import OXOo.OOXIXo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMyFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyFile.kt\ncom/bestmafen/androidbase/io/MyFile\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,98:1\n107#2:99\n79#2,22:100\n*S KotlinDebug\n*F\n+ 1 MyFile.kt\ncom/bestmafen/androidbase/io/MyFile\n*L\n39#1:99\n39#1:100,22\n*E\n"})
/* loaded from: classes8.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f3233oIX0oI = new oIX0oI();

    /* renamed from: X00IoxXI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class C0049oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3234oIX0oI;

        static {
            int[] iArr = new int[Location.values().length];
            try {
                iArr[Location.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Location.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Location.PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3234oIX0oI = iArr;
        }
    }

    public static /* synthetic */ File II0xO0(oIX0oI oix0oi, Location location, II0xO0 iI0xO0, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        return oix0oi.oIX0oI(location, iI0xO0, str);
    }

    public final File I0Io(Location location) {
        int i = C0049oIX0oI.f3234oIX0oI[location.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new File(PathUtils.getExternalStoragePath());
                }
                throw new NoWhenBranchMatchedException();
            }
            return new File(PathUtils.getExternalAppDataPath());
        }
        return new File(PathUtils.getInternalAppDataPath());
    }

    public final void X0o0xo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
    }

    @OOXIXo
    public final File oIX0oI(@OOXIXo Location location, @OOXIXo II0xO0 path, @OOXIXo String name) {
        int i;
        boolean z;
        IIX0o.x0xO0oo(location, "location");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(name, "name");
        if (name.length() == 0) {
            return new File(I0Io(location), path.oIX0oI());
        }
        File I0Io2 = I0Io(location);
        StringBuilder sb = new StringBuilder();
        sb.append(path.oIX0oI());
        sb.append(File.separator);
        int length = name.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            if (!z2) {
                i = i2;
            } else {
                i = length;
            }
            if (name.charAt(i) == File.separatorChar) {
                z = true;
            } else {
                z = false;
            }
            if (!z2) {
                if (!z) {
                    z2 = true;
                } else {
                    i2++;
                }
            } else {
                if (!z) {
                    break;
                }
                length--;
            }
        }
        sb.append(name.subSequence(i2, length + 1).toString());
        return new File(I0Io2, sb.toString());
    }

    @OOXIXo
    public final Uri oxoX(@OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        if (Build.VERSION.SDK_INT >= 24) {
            ProviderInfo providerInfo = Utils.getApp().getPackageManager().getProviderInfo(new ComponentName(Utils.getApp(), (Class<?>) FileProvider.class), 128);
            IIX0o.oO(providerInfo, "getProviderInfo(...)");
            Uri uriForFile = FileProvider.getUriForFile(Utils.getApp(), providerInfo.authority, file);
            IIX0o.ooOOo0oXI(uriForFile);
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        IIX0o.ooOOo0oXI(fromFile);
        return fromFile;
    }
}
