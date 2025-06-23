package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f19448a;

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        String processName;
        synchronized (b.class) {
            if (!TextUtils.isEmpty(f19448a)) {
                return f19448a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f19448a = processName;
                return f19448a;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception unused) {
                    }
                    if (next.pid == myPid) {
                        f19448a = next.processName;
                        return f19448a;
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static void a(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        String str;
        InputStream inputStream2;
        boolean z;
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream = null;
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str4 = Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            h.a(context);
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str3), file);
                inputStream2 = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                        byte[] bArr = new byte[1024];
                        int length = bytes.length;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            int i3 = 0;
                            while (i3 < read) {
                                int i4 = i2 + 1;
                                if (i2 >= 64) {
                                    bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                    i++;
                                }
                                i3++;
                                i2 = i4;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream = fileOutputStream2;
                        inputStream2 = inputStream;
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            GDTLogger.e("插件加载失败", th);
                            throw th;
                        } catch (Throwable th2) {
                            a(inputStream);
                            a(fileOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (z) {
                try {
                    z = h.a(file, context);
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = inputStream2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            a(inputStream2);
            a(fileOutputStream);
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static synchronized String a(String str) {
        String str2;
        synchronized (b.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str3 = f19448a;
                if (TextUtils.isEmpty(str3)) {
                    return str;
                }
                boolean endsWith = str3.endsWith("_");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(endsWith ? "" : "_");
                try {
                    str2 = new String(str3);
                    try {
                        str2 = d.a(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str2 = null;
                }
                sb.append(str2);
                return sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
