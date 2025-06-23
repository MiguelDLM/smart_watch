package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class km {
    private static String Do;

    public static File a(Bitmap bitmap, File file, int i) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            return file;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return file;
    }

    public static void b(final File file, final File file2, boolean z) {
        if (file.exists()) {
            if (z) {
                new AsyncTask<Void, Void, Void>() { // from class: com.baidu.ar.km.1
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        km.b(file, file2, false);
                        return null;
                    }
                }.execute(new Void[0]);
                return;
            }
            d(file2);
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    a(file3, new File(file2, file3.getName()), Boolean.TRUE);
                } else {
                    b(file3, new File(file2, file3.getName()), false);
                }
            }
        }
    }

    public static String cm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(new File(str));
    }

    public static void d(File file) {
        if (file.exists()) {
            if (!file.isFile()) {
                return;
            } else {
                file.delete();
            }
        }
        file.mkdirs();
    }

    public static void e(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean f(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static FileOutputStream g(File file) {
        f(file);
        e(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(java.io.File r2) {
        /*
            boolean r0 = j(r2)
            r1 = 0
            if (r0 == 0) goto L44
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.lang.String r2 = com.baidu.ar.ko.a(r0)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1f
            com.baidu.ar.ko.closeQuietly(r0)
            r0.close()     // Catch: java.io.IOException -> L17
            goto L1b
        L17:
            r0 = move-exception
            r0.printStackTrace()
        L1b:
            return r2
        L1c:
            r2 = move-exception
            r1 = r0
            goto L36
        L1f:
            r2 = move-exception
            goto L25
        L21:
            r2 = move-exception
            goto L36
        L23:
            r2 = move-exception
            r0 = r1
        L25:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1c
            com.baidu.ar.ko.closeQuietly(r0)
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.io.IOException -> L31
            goto L44
        L31:
            r2 = move-exception
            r2.printStackTrace()
            goto L44
        L36:
            com.baidu.ar.ko.closeQuietly(r1)
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L3f
            goto L43
        L3f:
            r0 = move-exception
            r0.printStackTrace()
        L43:
            throw r2
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.km.h(java.io.File):java.lang.String");
    }

    public static ArrayList<File> i(File file) {
        File[] listFiles = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                } else {
                    i(file2);
                }
            }
        }
        return arrayList;
    }

    public static boolean j(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean k(File file) {
        File file2 = new File(file, "succeed.txt");
        if (file2.exists()) {
            return file2.delete();
        }
        return false;
    }

    public static boolean l(File file) {
        try {
            return new File(file, "succeed.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m(File file) {
        return new File(file, "succeed.txt").exists();
    }

    public static boolean n(File file) {
        File[] listFiles;
        if (file == null || (listFiles = file.listFiles()) == null) {
            return false;
        }
        boolean z = false;
        for (File file2 : listFiles) {
            if (file2.getName().endsWith("succeed.txt")) {
                z = true;
            }
        }
        return z;
    }

    public static String o(Context context) {
        String str = Do;
        if (str != null) {
            return str;
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        Do = externalFilesDir == null ? context.getFilesDir().getAbsolutePath() : externalFilesDir.getAbsolutePath();
        return Do;
    }

    public static String a(String str, Bitmap bitmap, int i) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return str;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            a(bitmap, file, i);
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(File file) {
        a(file, true);
    }

    public static void a(File file, boolean z) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2, z);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static boolean a(File file, File file2, Boolean bool) {
        FileOutputStream fileOutputStream;
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return false;
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (file2.exists() && bool.booleanValue()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    ko.a(fileInputStream2, fileOutputStream);
                    fileOutputStream.flush();
                    ko.closeQuietly(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        ko.closeQuietly(fileInputStream);
                        ko.closeQuietly(fileOutputStream);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        ko.closeQuietly(fileInputStream);
                        ko.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    ko.closeQuietly(fileInputStream);
                    ko.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        ko.closeQuietly(fileOutputStream);
        return true;
    }

    public static boolean a(File file, String str) {
        return new File(file, str).exists();
    }

    public static String[] a(ArrayList<File> arrayList) {
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = arrayList.get(i).getPath();
        }
        return strArr;
    }
}
