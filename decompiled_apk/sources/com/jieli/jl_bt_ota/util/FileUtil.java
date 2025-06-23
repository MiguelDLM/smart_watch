package com.jieli.jl_bt_ota.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class FileUtil {
    public static final int FILE_TYPE_PIC = 1;
    public static final int FILE_TYPE_UNKNOWN = 0;
    public static final int FILE_TYPE_VIDEO = 2;

    /* renamed from: a, reason: collision with root package name */
    private static final String f17811a = "FileUtil";

    private static String a(Context context) {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (Build.VERSION.SDK_INT >= 29) {
            if (context == null) {
                return path;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return path;
            }
            return externalFilesDir.getPath();
        }
        return path;
    }

    public static boolean bitmapToFile(Bitmap bitmap, String str, int i) {
        FileOutputStream fileOutputStream;
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static boolean bytesToFile(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        if (bArr != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static boolean checkFileExist(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).exists();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0097 -> B:25:0x00b0). Please report as a decompilation issue!!! */
    public static void copyFromAssetsToSdcard(Context context, boolean z, String str, String str2) {
        FileOutputStream fileOutputStream;
        IOException e;
        FileNotFoundException e2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (z || (!z && !file.exists())) {
                try {
                    try {
                        try {
                            context = context.getResources().getAssets().open(str);
                            try {
                                fileOutputStream = new FileOutputStream(str2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = context.read(bArr, 0, 1024);
                                        if (read >= 0) {
                                            fileOutputStream.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                    }
                                    fileOutputStream.close();
                                    context.close();
                                } catch (FileNotFoundException e4) {
                                    e2 = e4;
                                    e2.printStackTrace();
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (context != 0) {
                                        context.close();
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (context != 0) {
                                        context.close();
                                    }
                                }
                            } catch (FileNotFoundException e8) {
                                fileOutputStream = null;
                                e2 = e8;
                            } catch (IOException e9) {
                                fileOutputStream = null;
                                e = e9;
                            } catch (Throwable th) {
                                str = 0;
                                th = th;
                                if (str != 0) {
                                    try {
                                        str.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (context != 0) {
                                    try {
                                        context.close();
                                        throw th;
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    } catch (FileNotFoundException e13) {
                        fileOutputStream = null;
                        e2 = e13;
                        context = 0;
                    } catch (IOException e14) {
                        fileOutputStream = null;
                        e = e14;
                        context = 0;
                    } catch (Throwable th2) {
                        str = 0;
                        th = th2;
                        context = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                if (file.delete()) {
                    JL_Log.i("FileUtil", "delete file success!");
                    return;
                }
                return;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        deleteFile(file2);
                    }
                    if (file.delete()) {
                        JL_Log.i("FileUtil", "delete empty file success!");
                        return;
                    }
                    return;
                }
                if (file.delete()) {
                    JL_Log.i("FileUtil", "delete empty file success!");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] getBytes(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 == 0) goto Lad
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto Lb
            goto Lad
        Lb:
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L5b java.io.FileNotFoundException -> L5f
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L5b java.io.FileNotFoundException -> L5f
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c java.io.FileNotFoundException -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c java.io.FileNotFoundException -> L4f
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
        L1e:
            int r3 = r6.read(r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            r4 = -1
            if (r3 == r4) goto L31
            r4 = 0
            r1.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c java.io.FileNotFoundException -> L2e
            goto L1e
        L2a:
            r0 = move-exception
            goto L45
        L2c:
            r2 = move-exception
            goto L63
        L2e:
            r2 = move-exception
            goto L7a
        L31:
            r1.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r0 = move-exception
            r0.printStackTrace()
        L39:
            byte[] r0 = r1.toByteArray()
            r6.close()     // Catch: java.io.IOException -> L42
            goto L94
        L42:
            r6 = move-exception
            goto L91
        L45:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L95
        L4a:
            r1 = move-exception
            goto L95
        L4c:
            r1 = move-exception
            r2 = r1
            goto L52
        L4f:
            r1 = move-exception
            r2 = r1
            goto L54
        L52:
            r1 = r0
            goto L63
        L54:
            r1 = r0
            goto L7a
        L56:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L45
        L5b:
            r2 = move-exception
            r6 = r0
            r1 = r6
            goto L63
        L5f:
            r2 = move-exception
            r6 = r0
            r1 = r6
            goto L7a
        L63:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            byte[] r0 = r1.toByteArray()
        L74:
            if (r6 == 0) goto L94
            r6.close()     // Catch: java.io.IOException -> L42
            goto L94
        L7a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L8b
            r1.close()     // Catch: java.io.IOException -> L83
            goto L87
        L83:
            r0 = move-exception
            r0.printStackTrace()
        L87:
            byte[] r0 = r1.toByteArray()
        L8b:
            if (r6 == 0) goto L94
            r6.close()     // Catch: java.io.IOException -> L42
            goto L94
        L91:
            r6.printStackTrace()
        L94:
            return r0
        L95:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.io.IOException -> L9b
            goto L9f
        L9b:
            r2 = move-exception
            r2.printStackTrace()
        L9f:
            r0.toByteArray()
        La2:
            if (r6 == 0) goto Lac
            r6.close()     // Catch: java.io.IOException -> La8
            goto Lac
        La8:
            r6 = move-exception
            r6.printStackTrace()
        Lac:
            throw r1
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.util.FileUtil.getBytes(java.lang.String):byte[]");
    }

    public static byte[] getFromRaw(Context context, int i) {
        byte[] bArr;
        IOException e;
        InputStream openRawResource;
        InputStream inputStream = null;
        r0 = null;
        byte[] bArr2 = null;
        inputStream = null;
        try {
            try {
                openRawResource = context.getResources().openRawResource(i);
            } catch (Exception e2) {
                e = e2;
                bArr = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            int i2 = IoUtils.DEFAULT_IMAGE_TOTAL_SIZE;
            if (runtime != null && runtime.freeMemory() < IoUtils.DEFAULT_IMAGE_TOTAL_SIZE) {
                i2 = (int) runtime.freeMemory();
            }
            byte[] bArr3 = new byte[i2];
            byte[] bArr4 = new byte[1024];
            int i3 = 0;
            while (true) {
                int read = openRawResource.read(bArr4, 0, 1024);
                if (read < 0) {
                    break;
                }
                int i4 = i3 + read;
                if (i4 <= i2) {
                    System.arraycopy(bArr4, 0, bArr3, i3, read);
                    i3 = i4;
                }
            }
            if (i3 > 0) {
                bArr2 = new byte[i3];
                System.arraycopy(bArr3, 0, bArr2, 0, i3);
            }
            try {
                openRawResource.close();
                return bArr2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e4) {
            e = e4;
            byte[] bArr5 = bArr2;
            inputStream = openRawResource;
            bArr = bArr5;
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    bArr2 = bArr;
                    e = e5;
                    e.printStackTrace();
                    return bArr2;
                }
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            inputStream = openRawResource;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static int judgeFileType(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.endsWith(".png") && !str.endsWith(".PNG") && !str.endsWith(".JPEG") && !str.endsWith(".jpeg") && !str.endsWith(".jpg") && !str.endsWith(".JPG")) {
                if (str.endsWith(".mov") || str.endsWith(".MOV") || str.endsWith(".mp4") || str.endsWith(".MP4") || str.endsWith(".avi") || str.endsWith(".AVI")) {
                    return 2;
                }
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public static String splicingFilePath(Context context, String str, String str2, String str3, String str4) {
        String a2 = a(context);
        if (!TextUtils.isEmpty(str)) {
            String str5 = File.separator;
            if (str.contains(str5)) {
                for (String str6 : str.split(str5)) {
                    if (!TextUtils.isEmpty(str6)) {
                        a2 = a2 + File.separator + str6;
                        File file = new File(a2);
                        if (!file.exists() && file.mkdir()) {
                            JL_Log.w("FileUtil", "create root dir success! path : " + a2);
                        }
                    }
                }
            } else {
                a2 = a2 + str5 + str;
                File file2 = new File(a2);
                if (!file2.exists() && file2.mkdir()) {
                    JL_Log.w("FileUtil", "create root dir success! path : " + a2);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            String str7 = File.separator;
            sb.append(str7);
            sb.append(str2);
            String sb2 = sb.toString();
            File file3 = new File(sb2);
            if (!file3.exists() && file3.mkdir()) {
                JL_Log.w("FileUtil", "create one dir success!");
            }
            if (TextUtils.isEmpty(str3)) {
                return sb2;
            }
            String str8 = sb2 + str7 + str3;
            File file4 = new File(str8);
            if (!file4.exists() && file4.mkdir()) {
                JL_Log.w("FileUtil", "create two dir success!");
            }
            if (TextUtils.isEmpty(str4)) {
                return str8;
            }
            a2 = str8 + str7 + str4;
            File file5 = new File(a2);
            if (!file5.exists() && file5.mkdir()) {
                JL_Log.w("FileUtil", "create three sub dir success!");
            }
        }
        return a2;
    }
}
