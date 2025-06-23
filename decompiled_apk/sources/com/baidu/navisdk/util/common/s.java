package com.baidu.navisdk.util.common;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes8.dex */
public class s {
    public static boolean a(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    return file.delete();
                }
                File[] listFiles = file.listFiles();
                int length = file.listFiles().length;
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i].isDirectory()) {
                        z = z && a(listFiles[i].getAbsolutePath());
                    }
                    z = z && listFiles[i].delete();
                }
                return z;
            }
            if (file.isFile()) {
                return file.delete();
            }
        }
        return false;
    }

    public static boolean b(String str) throws IOException {
        return a(new File(str));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static String c(String str) {
        FileInputStream fileInputStream;
        ?? isEmpty = TextUtils.isEmpty(str);
        String str2 = null;
        str2 = null;
        str2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = isEmpty;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isEmpty != 0) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str2 = new BigInteger(1, messageDigest.digest()).toString(16);
                fileInputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return str2;
    }

    public static boolean d(String str) {
        return new File(str).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static String e(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(str);
        char[] cArr = new char[1024];
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                    while (true) {
                        try {
                            int read = inputStreamReader.read(cArr);
                            r2 = -1;
                            if (read == -1) {
                                break;
                            }
                            stringBuffer.append(cArr, 0, read);
                        } catch (Exception e) {
                            e = e;
                            r2 = inputStreamReader;
                            LogUtil.e("Common", e.toString());
                            if (r2 != 0) {
                                r2.close();
                                r2 = r2;
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th) {
                            th = th;
                            r2 = inputStreamReader;
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    inputStreamReader.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.lang.String r3, java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r3 = 0
            java.io.File r1 = r0.getParentFile()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            if (r1 != 0) goto L1c
            java.io.File r1 = r0.getParentFile()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1.mkdirs()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            goto L1c
        L18:
            r4 = move-exception
            goto L6c
        L1a:
            r4 = move-exception
            goto L3d
        L1c:
            boolean r1 = r0.exists()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            if (r1 != 0) goto L25
            r0.createNewFile()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
        L25:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1.write(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r1.flush()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r1.close()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r1.close()     // Catch: java.io.IOException -> L37
            goto L69
        L37:
            r3 = move-exception
            goto L66
        L39:
            r3 = move-exception
            goto L6a
        L3b:
            r3 = move-exception
            goto L3f
        L3d:
            r1 = r3
            r3 = r4
        L3f:
            boolean r4 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L60
            java.lang.String r4 = "Common"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r0.<init>()     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = ""
            r0.append(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.Throwable r2 = r3.getCause()     // Catch: java.lang.Throwable -> L39
            r0.append(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L39
            com.baidu.navisdk.util.common.LogUtil.e(r4, r0)     // Catch: java.lang.Throwable -> L39
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L39
        L60:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> L37
            goto L69
        L66:
            r3.printStackTrace()
        L69:
            return
        L6a:
            r4 = r3
            r3 = r1
        L6c:
            if (r3 == 0) goto L76
            r3.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r3 = move-exception
            r3.printStackTrace()
        L76:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.s.b(java.lang.String, java.lang.String):void");
    }

    public static boolean a(File file) throws IOException {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    return file.delete();
                }
                File[] listFiles = file.listFiles();
                int length = file.listFiles().length;
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i].isDirectory()) {
                        z = z && a(listFiles[i]);
                    }
                    z = z && listFiles[i].delete();
                }
                return file.delete();
            }
            if (file.isFile()) {
                return file.delete();
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("moveFileToOtherDirectory: " + str + "->" + str2);
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                File file2 = new File(str2 + "/" + file.getName());
                if (!file2.exists()) {
                    file2.mkdir();
                }
                a(file.getAbsolutePath(), file2.getAbsolutePath());
            } else {
                file.renameTo(new File(str2 + "/" + file.getName()));
            }
        }
        return true;
    }
}
