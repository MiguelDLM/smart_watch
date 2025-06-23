package xx0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: classes13.dex */
public class oO {

    /* loaded from: classes13.dex */
    public static class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public long f35205I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public long f35206II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public File f35207oIX0oI;

        public static I0Io X0o0xo(File file) {
            I0Io i0Io = new I0Io();
            i0Io.I0Io(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            i0Io.II0xO0(blockCount * blockSize);
            i0Io.XO(availableBlocks * blockSize);
            return i0Io;
        }

        public void I0Io(File file) {
            this.f35207oIX0oI = file;
        }

        public void II0xO0(long j) {
            this.f35206II0xO0 = j;
        }

        public long Oxx0IOOO() {
            return this.f35205I0Io;
        }

        public void XO(long j) {
            this.f35205I0Io = j;
        }

        public File oIX0oI() {
            return this.f35207oIX0oI;
        }

        public long oxoX() {
            return this.f35206II0xO0;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", oIX0oI().getAbsolutePath(), Long.valueOf(Oxx0IOOO()), Long.valueOf(oxoX()));
        }
    }

    /* loaded from: classes13.dex */
    public static final class II0xO0 {
        public static I0Io II0xO0() {
            if (!oIX0oI()) {
                return null;
            }
            return I0Io.X0o0xo(Environment.getExternalStorageDirectory());
        }

        public static boolean oIX0oI() {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState) && !"mounted_ro".equals(externalStorageState)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes13.dex */
    public static final class oIX0oI {
        public static final boolean oIX0oI(int i, int i2) {
            if (i2 == (i & i2)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes13.dex */
    public static final class oxoX {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat oIX0oI(String str) {
            return new SimpleDateFormat(str);
        }
    }

    public static Bundle I0Io(Bundle bundle) {
        if (!oIX0oI(bundle)) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove("access_token");
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove("expires_in");
        bundle2.remove("openid");
        return bundle2;
    }

    public static boolean II0xO0(String str) {
        if (!str.contains("access_token") && !str.contains("pay_token") && !str.contains("pfkey") && !str.contains("expires_in") && !str.contains("openid")) {
            return false;
        }
        return true;
    }

    public static boolean oIX0oI(Bundle bundle) {
        if (!bundle.containsKey("access_token") && !bundle.containsKey("pay_token") && !bundle.containsKey("pfkey") && !bundle.containsKey("expires_in") && !bundle.containsKey("openid")) {
            return false;
        }
        return true;
    }
}
