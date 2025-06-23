package oI00o;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oI00o.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1122oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f31359XO;

        public RunnableC1122oIX0oI(Context context) {
            this.f31359XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Context context = this.f31359XO;
                oIX0oI.II0xO0(context, "", oIX0oI.oIX0oI(context).getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void I0Io(Context context) {
        new Thread(new RunnableC1122oIX0oI(context)).start();
    }

    public static void II0xO0(Context context, String str, String str2) throws IOException {
        AssetManager assets = context.getAssets();
        String[] list = assets.list(str);
        if (list != null && list.length != 0) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str)) {
                    str3 = str + "/" + str3;
                }
                II0xO0(context, str3, str2);
            }
            return;
        }
        try {
            InputStream open = assets.open(str);
            File file = new File(str2, str);
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File oIX0oI(Context context) {
        return new File(context.getExternalCacheDir().getAbsolutePath(), "Assets");
    }

    @Nullable
    @CheckResult
    public static String oxoX(@NonNull Context context, @Nullable String str, @NonNull String str2) {
        File file;
        File externalCacheDir = context.getExternalCacheDir();
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(externalCacheDir.getAbsolutePath());
            String str3 = File.separator;
            sb.append(str3);
            sb.append("Assets");
            sb.append(str3);
            sb.append(str2);
            file = new File(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalCacheDir.getAbsolutePath());
            String str4 = File.separator;
            sb2.append(str4);
            sb2.append("Assets");
            sb2.append(str4);
            sb2.append(str);
            sb2.append(str4);
            sb2.append(str2);
            file = new File(sb2.toString());
        }
        if (file.exists()) {
            Log.d("CZXing", "Asset file absolute path: " + file.getAbsolutePath());
            return file.getAbsolutePath();
        }
        Log.w("CZXing", "Asset file absolute path: 请检查路径");
        return null;
    }
}
