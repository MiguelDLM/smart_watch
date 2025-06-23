package com.iflytek.sparkchain.utils;

import android.content.Context;
import android.os.Environment;
import android.os.MemoryFile;
import android.text.TextUtils;
import com.iflytek.sparkchain.media.record.c;
import com.iflytek.sparkchain.utils.log.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes10.dex */
public class FileUtil {
    private static final String CHILD_FOLDER_NAME = "res";
    private static final String FOLDER_NAME = "msc";
    private static final String FORMAT_PCM = "pcm";
    private static final String FORMAT_WAV = "wav";
    public static final String RES_SUFFIX = ".jet";
    private static String userPath = "";

    public static boolean checkFileMD5(String str, String str2) {
        if (str.equals(Encrypter.getFileMd5(new File(str2)))) {
            return true;
        }
        deleteFile(str2);
        return false;
    }

    public static String codeString(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int read = (bufferedInputStream.read() << 8) + bufferedInputStream.read();
            return read != 4094 ? read != 61371 ? read != 65279 ? "GBK" : "YTF-16BE" : "UTF-8" : "Unicode";
        } catch (FileNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void copyAssetsFile(Context context, String str, String str2) throws IOException {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                makeDir(str2);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2, false);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            inputStream.close();
                            fileOutputStream2.close();
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean formatPcm(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || FORMAT_PCM.equals(str)) {
            return true;
        }
        if (FORMAT_WAV.equals(str)) {
            return pcm2Wav(str2, i);
        }
        LogUtil.e("format not supported");
        return false;
    }

    public static String getResFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = System.currentTimeMillis() + "";
        }
        String absolutePath = ("mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory() : context.getFilesDir()).getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str2 = (absolutePath + "msc/") + "res/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + str;
        if (str3.endsWith(RES_SUFFIX)) {
            return str3;
        }
        return str3 + RES_SUFFIX;
    }

    public static String getUserPath(Context context) {
        if (!TextUtils.isEmpty(userPath)) {
            return userPath;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str = absolutePath + "msclib/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        userPath = str;
        return str;
    }

    public static void makeDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!str.endsWith("/")) {
            file = file.getParentFile();
        }
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean pcm2Wav(String str, int i) {
        try {
            c cVar = new c(new File(str), i);
            cVar.c();
            cVar.a();
            return true;
        } catch (IOException e) {
            LogUtil.e(e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] readFile(java.lang.String r3) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            boolean r3 = r1.exists()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            if (r3 != 0) goto Ld
            return r0
        Ld:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            int r1 = r3.available()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            byte[] r0 = new byte[r1]     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            r3.read(r0)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            r3.close()     // Catch: java.io.IOException -> L1f
            goto L3f
        L1f:
            r3 = move-exception
            goto L3a
        L21:
            r0 = move-exception
            goto L44
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
            goto L2d
        L28:
            r3 = move-exception
            goto L47
        L2a:
            r3 = move-exception
            r1 = r3
            r3 = r0
        L2d:
            com.iflytek.sparkchain.utils.log.LogUtil.e(r1)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.io.IOException -> L36
            goto L3e
        L36:
            r0 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
        L3a:
            com.iflytek.sparkchain.utils.log.LogUtil.e(r3)
            goto L3f
        L3e:
            r0 = r3
        L3f:
            return r0
        L40:
            r3 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
        L44:
            r2 = r0
            r0 = r3
            r3 = r2
        L47:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r0 = move-exception
            com.iflytek.sparkchain.utils.log.LogUtil.e(r0)
        L51:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.utils.FileUtil.readFile(java.lang.String):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    public static byte[] readFileFromAssets(Context context, String str) {
        Object obj;
        IOException e;
        ?? open;
        ?? r0 = 0;
        r0 = 0;
        InputStream inputStream = null;
        try {
            try {
                open = context.getAssets().open(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            obj = null;
        }
        try {
            r0 = new byte[open.available()];
            open.read(r0);
            try {
                open.close();
                r0 = r0;
            } catch (IOException e3) {
                e = e3;
                LogUtil.e(e);
                return r0;
            }
        } catch (Exception e4) {
            e = e4;
            Object obj2 = r0;
            inputStream = open;
            obj = obj2;
            LogUtil.e(e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    r0 = obj;
                    e = e5;
                    LogUtil.e(e);
                    return r0;
                }
            }
            r0 = obj;
            return r0;
        } catch (Throwable th2) {
            th = th2;
            r0 = open;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e6) {
                    LogUtil.e(e6);
                }
            }
            throw th;
        }
        return r0;
    }

    public static boolean saveFile(MemoryFile memoryFile, long j, String str) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (memoryFile == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    deleteFile(str);
                    makeDir(str);
                    fileOutputStream = new FileOutputStream(str);
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[65536];
            int i = 0;
            while (true) {
                long j2 = i;
                if (j2 >= j) {
                    break;
                }
                long j3 = j - j2;
                if (j3 > 65536) {
                    j3 = 65536;
                }
                int i2 = (int) j3;
                memoryFile.readBytes(bArr, i, 0, i2);
                fileOutputStream.write(bArr, 0, i2);
                i += i2;
            }
            z = true;
            fileOutputStream.close();
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            LogUtil.e(e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        return z;
    }

    public static boolean saveFile(ConcurrentLinkedQueue<byte[]> concurrentLinkedQueue, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                makeDir(str);
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator<byte[]> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                fileOutputStream.write(it.next());
            }
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            LogUtil.e(e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e3) {
                    LogUtil.e(e3);
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    LogUtil.e(e4);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[Catch: Exception -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003f, blocks: (B:31:0x0031, B:11:0x003c), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean saveFile(byte[] r3, java.lang.String r4, boolean r5, int r6) {
        /*
            r0 = 0
            if (r5 != 0) goto Lb
            deleteFile(r4)     // Catch: java.lang.Throwable -> L7 java.lang.Exception -> L9
            goto Lb
        L7:
            r3 = move-exception
            goto L40
        L9:
            r3 = move-exception
            goto L36
        Lb:
            makeDir(r4)     // Catch: java.lang.Throwable -> L7 java.lang.Exception -> L9
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L7 java.lang.Exception -> L9
            java.lang.String r2 = "rw"
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L7 java.lang.Exception -> L9
            if (r5 != 0) goto L22
            r4 = 0
            r1.setLength(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            goto L2d
        L1d:
            r3 = move-exception
            r0 = r1
            goto L40
        L20:
            r3 = move-exception
            goto L35
        L22:
            if (r6 >= 0) goto L29
            long r4 = r1.length()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            goto L2a
        L29:
            long r4 = (long) r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
        L2a:
            r1.seek(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
        L2d:
            r1.write(r3)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            r3 = 1
            r1.close()     // Catch: java.lang.Exception -> L3f
            goto L3f
        L35:
            r0 = r1
        L36:
            com.iflytek.sparkchain.utils.log.LogUtil.e(r3)     // Catch: java.lang.Throwable -> L7
            r3 = 0
            if (r0 == 0) goto L3f
            r0.close()     // Catch: java.lang.Exception -> L3f
        L3f:
            return r3
        L40:
            if (r0 == 0) goto L45
            r0.close()     // Catch: java.lang.Exception -> L45
        L45:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.utils.FileUtil.saveFile(byte[], java.lang.String, boolean, int):boolean");
    }
}
