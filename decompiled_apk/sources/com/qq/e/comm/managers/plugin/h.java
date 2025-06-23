package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f19453a = b.a("e_qq_com_plugin");
    private static String b = b.a("e_qq_com_dex");

    public static String a() {
        return "gdt_plugin";
    }

    public static void b(Context context) {
        try {
            File file = new File(context.getDir(f19453a, 0), "stub_ver");
            if (TextUtils.equals(a(file), SDKStatus.getSDKVersion())) {
                return;
            }
            a(SDKStatus.getSDKVersion(), file);
            a(context);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    public static File c(Context context) {
        return context.getDir(b, 0);
    }

    public static File d(Context context) {
        return new File(context.getDir(f19453a, 0), "update_lc");
    }

    public static File e(Context context) {
        return new File(context.getDir(f19453a, 0), "gdt_plugin.next");
    }

    public static File f(Context context) {
        return new File(context.getDir(f19453a, 0), "gdt_plugin.next.sig");
    }

    public static File g(Context context) {
        return new File(context.getDir(f19453a, 0), "gdt_plugin.jar");
    }

    public static File h(Context context) {
        return new File(context.getDir(f19453a, 0), "gdt_plugin.jar.sig");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public static String a(File file) throws IOException {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(File file, boolean z) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static void a(String str, File file) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                outputStreamWriter.write(str);
                a(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
                a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
    }

    public static boolean a(File file, Context context) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static boolean a(File file, File file2, Context context, boolean z) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z) {
                return a(file2, context);
            }
            return true;
        }
        try {
            boolean a2 = a(new FileInputStream(file), file2);
            if (!z) {
                return a2;
            }
            if (a2) {
                return a(file2, context);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context) {
        try {
            File dir = context.getDir(f19453a, 0);
            if (new File(dir, "disdoat").exists()) {
                return;
            }
            a(context.getDir(b, 0), false);
            a(new File(dir, "oat"), false);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }
}
