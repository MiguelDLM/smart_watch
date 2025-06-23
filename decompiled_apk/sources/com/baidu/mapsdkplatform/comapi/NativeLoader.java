package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes7.dex */
public class NativeLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6126a = "NativeLoader";
    private static Context b;
    private static NativeLoader e;
    private static final Set<String> c = new HashSet();
    private static final Set<String> d = new HashSet();
    private static a f = a.ARMEABI;
    private static boolean g = false;
    private static String h = null;

    /* loaded from: classes7.dex */
    public enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");

        private String f;

        a(String str) {
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    private NativeLoader() {
    }

    public static void a(boolean z, String str) {
        g = z;
        h = str;
    }

    private boolean b(String str, String str2) {
        a aVar = a.ARMEABI;
        if (a(str2, aVar)) {
            return f(str2, str);
        }
        Log.e(f6126a, "found lib " + aVar.a() + "/" + str + ".so error");
        return false;
    }

    private boolean c(String str, String str2) {
        if (!a(str2, a.ARM64)) {
            return a(str, str2);
        }
        return f(str2, str);
    }

    private boolean d(String str, String str2) {
        if (!a(str2, a.X86)) {
            return a(str, str2);
        }
        return f(str2, str);
    }

    private boolean e(String str, String str2) {
        if (!a(str2, a.X86_64)) {
            return d(str, str2);
        }
        return f(str2, str);
    }

    private boolean f(String str, String str2) {
        try {
            System.loadLibrary(new File(b(), str).getAbsolutePath());
            Set<String> set = c;
            synchronized (set) {
                set.add(str2);
            }
            g(str, str2);
            return true;
        } catch (Throwable th) {
            Set<String> set2 = d;
            synchronized (set2) {
                set2.add(str2);
                a(th);
                return false;
            }
        }
    }

    private void g(String str, String str2) {
        if (str != null && !str.isEmpty() && str.contains("libBaiduMapSDK_")) {
            try {
                String[] split = str.split("_v");
                if (split.length <= 1) {
                    return;
                }
                File[] listFiles = new File(b()).listFiles(new d(this, split[1]));
                if (listFiles != null && listFiles.length != 0) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            try {
                if (e == null) {
                    e = new NativeLoader();
                    f = c();
                }
                nativeLoader = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!g) {
            return a(str);
        }
        String str2 = h;
        if (str2 != null && !str2.isEmpty()) {
            return b(str);
        }
        Log.e(f6126a, "Given custom so file path is null, please check!");
        return false;
    }

    private boolean a(String str) {
        try {
            Set<String> set = c;
            synchronized (set) {
                try {
                    if (set.contains(str)) {
                        return true;
                    }
                    System.loadLibrary(str);
                    synchronized (set) {
                        set.add(str);
                    }
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return b(str);
        }
    }

    private boolean b(String str) {
        boolean c2;
        String mapLibraryName = System.mapLibraryName(str);
        Set<String> set = c;
        synchronized (set) {
            try {
                if (set.contains(str)) {
                    return true;
                }
                int i = e.f6162a[f.ordinal()];
                if (i == 1) {
                    c2 = c(str, mapLibraryName);
                } else if (i == 2) {
                    c2 = a(str, mapLibraryName);
                } else if (i == 3) {
                    c2 = b(str, mapLibraryName);
                } else if (i != 4) {
                    c2 = i != 5 ? false : d(str, mapLibraryName);
                } else {
                    c2 = e(str, mapLibraryName);
                }
                synchronized (set) {
                    set.add(str);
                }
                return c2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(21)
    private static a c() {
        String str = Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return a.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f = a.ARMV7;
        }
        if (str.contains("arm") && str.contains("64") && d()) {
            f = a.ARM64;
        }
        if (str.contains("x86")) {
            if (str.contains("64")) {
                f = a.X86_64;
            } else {
                f = a.X86;
            }
        }
        return f;
    }

    private static boolean d() {
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        return Build.CPU_ABI.equals(Build.SUPPORTED_64_BIT_ABIS[0]);
    }

    private boolean a(String str, String str2) {
        if (!a(str2, a.ARMV7)) {
            return b(str, str2);
        }
        return f(str2, str);
    }

    private boolean a(String str, a aVar) {
        String str2;
        ZipFile zipFile;
        File file = new File(b(), str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        String str3 = a(aVar) + str;
        if (!g) {
            str2 = a();
        } else {
            str2 = h;
        }
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str3);
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    Log.e(f6126a, "Release file failed", e3);
                }
                return false;
            }
            a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.e(f6126a, "Release file failed", e4);
            }
            return true;
        } catch (Exception e5) {
            e = e5;
            zipFile2 = zipFile;
            Log.e(f6126a, "Copy library file error", e);
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e6) {
                    Log.e(f6126a, "Release file failed", e6);
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e7) {
                    Log.e(f6126a, "Release file failed", e7);
                }
            }
            throw th;
        }
    }

    private String b() {
        if (b == null) {
            return "";
        }
        File file = new File(b.getFilesDir(), "libs" + File.separator + f.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    @TargetApi(8)
    private String a() {
        if (b == null) {
            return "";
        }
        return b.getPackageCodePath();
    }

    private void a(Throwable th) {
        Log.e(f6126a, "loadException", th);
        for (String str : d) {
            Log.e(f6126a, str + " Failed to load.");
        }
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e2) {
            Log.e(f6126a, "Close InputStream error", e2);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            Log.e(f6126a, "Close OutputStream error", e3);
        }
    }

    private String a(a aVar) {
        return "lib/" + aVar.a() + "/";
    }
}
