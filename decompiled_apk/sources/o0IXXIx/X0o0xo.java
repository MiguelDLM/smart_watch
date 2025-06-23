package o0IXXIx;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;

/* loaded from: classes11.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final File f31085oIX0oI = XO("download");

    public static void I0Io(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static File II0XooXoX(Context context) {
        File externalCacheDir;
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            externalCacheDir = null;
        } else {
            externalCacheDir = context.getExternalCacheDir();
        }
        if (externalCacheDir == null) {
            return context.getCacheDir();
        }
        return externalCacheDir;
    }

    public static final File II0xO0(Context context) {
        File X0o0xo2 = X0o0xo(context);
        if (X0o0xo2 != null) {
            File file = new File(X0o0xo2.getPath() + "/Octopus/download/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static void Oxx0IOOO(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    public static File X0o0xo(Context context) {
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                file = context.getExternalFilesDir(null);
            }
            if (file == null) {
                return context.getFilesDir();
            }
            return file;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static File XO(String str) {
        File file = new File(oIX0oI(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File oIX0oI() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory(), "Octopus");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static boolean oxoX(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (context.getPackageManager().getApplicationInfo(str, 0) == null) {
            return false;
        }
        return true;
    }
}
