package com.baidu.tts.tools;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.huawei.openalliance.ad.utils.r;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes8.dex */
public class FileUtil {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkDirExists(String str) {
        if (new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static boolean createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            Log.i(r.Code, "创建目录失败，目标目录已存在！");
            return false;
        }
        str.endsWith(File.separator);
        if (file.mkdirs()) {
            Log.i(r.Code, "创建成功！");
            return true;
        }
        Log.e(r.Code, "创建目录失败！");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x003f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:64), block:B:41:0x003f */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.Closeable] */
    public static String getOfflineResource(String str) {
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        IOException e;
        Throwable e2;
        Closeable closeable;
        LoggerProxy.d(r.Code, "resourcePath = " + ((String) str));
        StringBuilder sb = new StringBuilder();
        Closeable closeable2 = null;
        try {
            try {
                str = new FileInputStream(new File((String) str, ConfigTool.OFFLINE_SPEAKER_RESOURCE_NAME));
                try {
                    inputStreamReader = new InputStreamReader((InputStream) str, "UTF-8");
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = null;
                    e2 = e;
                    inputStreamReader = null;
                    e2.printStackTrace();
                    a(str);
                    a(inputStreamReader);
                    a(bufferedReader);
                    String sb2 = sb.toString();
                    LoggerProxy.d(r.Code, "offline resource = " + sb2);
                    return sb2;
                } catch (UnsupportedEncodingException e4) {
                    e = e4;
                    bufferedReader = null;
                    e2 = e;
                    inputStreamReader = null;
                    e2.printStackTrace();
                    a(str);
                    a(inputStreamReader);
                    a(bufferedReader);
                    String sb22 = sb.toString();
                    LoggerProxy.d(r.Code, "offline resource = " + sb22);
                    return sb22;
                } catch (IOException e5) {
                    bufferedReader = null;
                    e = e5;
                    inputStreamReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable2 = closeable;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            inputStreamReader = null;
            bufferedReader = null;
            e2 = e;
            str = 0;
            e2.printStackTrace();
            a(str);
            a(inputStreamReader);
            a(bufferedReader);
            String sb222 = sb.toString();
            LoggerProxy.d(r.Code, "offline resource = " + sb222);
            return sb222;
        } catch (UnsupportedEncodingException e7) {
            e = e7;
            inputStreamReader = null;
            bufferedReader = null;
            e2 = e;
            str = 0;
            e2.printStackTrace();
            a(str);
            a(inputStreamReader);
            a(bufferedReader);
            String sb2222 = sb.toString();
            LoggerProxy.d(r.Code, "offline resource = " + sb2222);
            return sb2222;
        } catch (IOException e8) {
            inputStreamReader = null;
            bufferedReader = null;
            e = e8;
            str = 0;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
            inputStreamReader = null;
        }
        try {
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (FileNotFoundException e9) {
                    e2 = e9;
                    e2.printStackTrace();
                    a(str);
                    a(inputStreamReader);
                    a(bufferedReader);
                    String sb22222 = sb.toString();
                    LoggerProxy.d(r.Code, "offline resource = " + sb22222);
                    return sb22222;
                } catch (UnsupportedEncodingException e10) {
                    e2 = e10;
                    e2.printStackTrace();
                    a(str);
                    a(inputStreamReader);
                    a(bufferedReader);
                    String sb222222 = sb.toString();
                    LoggerProxy.d(r.Code, "offline resource = " + sb222222);
                    return sb222222;
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    a(str);
                    a(inputStreamReader);
                    a(bufferedReader);
                    String sb2222222 = sb.toString();
                    LoggerProxy.d(r.Code, "offline resource = " + sb2222222);
                    return sb2222222;
                }
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            Throwable th5 = e;
            bufferedReader = null;
            e2 = th5;
            e2.printStackTrace();
            a(str);
            a(inputStreamReader);
            a(bufferedReader);
            String sb22222222 = sb.toString();
            LoggerProxy.d(r.Code, "offline resource = " + sb22222222);
            return sb22222222;
        } catch (UnsupportedEncodingException e13) {
            e = e13;
            Throwable th52 = e;
            bufferedReader = null;
            e2 = th52;
            e2.printStackTrace();
            a(str);
            a(inputStreamReader);
            a(bufferedReader);
            String sb222222222 = sb.toString();
            LoggerProxy.d(r.Code, "offline resource = " + sb222222222);
            return sb222222222;
        } catch (IOException e14) {
            bufferedReader = null;
            e = e14;
        } catch (Throwable th6) {
            th = th6;
            a(str);
            a(inputStreamReader);
            a(closeable2);
            throw th;
        }
        a(str);
        a(inputStreamReader);
        a(bufferedReader);
        String sb2222222222 = sb.toString();
        LoggerProxy.d(r.Code, "offline resource = " + sb2222222222);
        return sb2222222222;
    }

    public static int getOriginalAudSeq(Context context) {
        String readLine;
        if (context == null) {
            return -1;
        }
        File file = new File(context.getFilesDir(), "originalAudSeq.txt");
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (!file.exists()) {
            a(null);
            return -1;
        }
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
        try {
            readLine = bufferedReader3.readLine();
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = bufferedReader3;
            Log.e(r.Code, "Exception in upload() combine");
            e.printStackTrace();
            bufferedReader3 = bufferedReader2;
            bufferedReader = bufferedReader2;
            a(bufferedReader3);
            return -1;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader3;
            a(bufferedReader);
            throw th;
        }
        if (!TextUtils.isEmpty(readLine)) {
            int parseInt = Integer.parseInt(readLine);
            a(bufferedReader3);
            return parseInt;
        }
        bufferedReader3.close();
        bufferedReader = readLine;
        a(bufferedReader3);
        return -1;
    }

    public static int getOriginalAudSeqServer(Context context) {
        String readLine;
        if (context == null) {
            return -1;
        }
        File file = new File(context.getFilesDir(), "originalAudSeqServer.txt");
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (!file.exists()) {
            a(null);
            return -1;
        }
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
        try {
            readLine = bufferedReader3.readLine();
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = bufferedReader3;
            Log.e(r.Code, "Exception in upload() combine");
            e.printStackTrace();
            bufferedReader3 = bufferedReader2;
            bufferedReader = bufferedReader2;
            a(bufferedReader3);
            return -1;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader3;
            a(bufferedReader);
            throw th;
        }
        if (!TextUtils.isEmpty(readLine)) {
            int parseInt = Integer.parseInt(readLine);
            a(bufferedReader3);
            return parseInt;
        }
        bufferedReader3.close();
        bufferedReader = readLine;
        a(bufferedReader3);
        return -1;
    }

    public static boolean mkdirs(String str) {
        if (!checkDirExists(str)) {
            return new File(str).mkdirs();
        }
        return true;
    }

    public static void saveOutFile(byte[] bArr, String str) {
        Log.d(r.Code, "write path = " + str);
        saveOutFile(bArr, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.OutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0067 -> B:18:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int setOriginalAudSeq(android.content.Context r3, int r4) {
        /*
            if (r3 != 0) goto L4
            r3 = -1
            return r3
        L4:
            java.io.File r3 = r3.getFilesDir()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "originalAudSeq.txt"
            r0.<init>(r3, r1)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L1d
            r0.createNewFile()     // Catch: java.lang.Exception -> L19
            goto L1d
        L19:
            r3 = move-exception
            r3.printStackTrace()
        L1d:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L76
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r1.write(r3)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r3 = "FileUtil"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r2 = "OriginalAudUpload, OriginalAudSeq="
            r0.append(r2)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r0.append(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            android.util.Log.d(r3, r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r1.close()     // Catch: java.io.IOException -> L50
            goto L76
        L50:
            r3 = move-exception
            goto L67
        L52:
            r3 = move-exception
            goto L56
        L54:
            r3 = move-exception
            goto L5e
        L56:
            r4 = r3
            r3 = r1
            goto L6b
        L59:
            r4 = move-exception
            goto L6b
        L5b:
            r4 = move-exception
            r1 = r3
            r3 = r4
        L5e:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L76
            r1.close()     // Catch: java.io.IOException -> L50
            goto L76
        L67:
            r3.printStackTrace()
            goto L76
        L6b:
            if (r3 == 0) goto L75
            r3.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r3 = move-exception
            r3.printStackTrace()
        L75:
            throw r4
        L76:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.tools.FileUtil.setOriginalAudSeq(android.content.Context, int):int");
    }

    public static void saveOutFile(byte[] bArr, String str, boolean z) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, z);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            a(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }
}
