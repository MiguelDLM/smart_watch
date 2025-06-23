package com.alimm.tanx.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileUtils implements NotConfused {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final String TAG = "FileUtils";

    public interface FileKeepRule {
        boolean needKept(String str);
    }

    private static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean copyFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        try {
            byte[] bArr = new byte[1444];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            inputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            if (inputStream == null) {
                return false;
            }
            inputStream.close();
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static boolean copyTo(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        closeIO(fileOutputStream2);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    LogUtils.d(TAG, "copyTo exception: output = " + file, e);
                    closeIO(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                closeIO(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            LogUtils.d(TAG, "copyTo exception: output = " + file, e);
            closeIO(fileOutputStream);
            return false;
        }
    }

    public static boolean decompress(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(new File(str)));
            boolean z = true;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        closeIO(zipInputStream2);
                        return z;
                    } else if (TextUtils.isEmpty(nextEntry.getName()) || !nextEntry.getName().contains("../")) {
                        String joinPath = joinPath(str2, nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            mkdir(joinPath);
                        } else {
                            z &= copyTo(new File(joinPath), zipInputStream2);
                        }
                    } else {
                        LogUtils.e("decompress", "发现不安全的zip文件解压路径！");
                        closeIO(zipInputStream2);
                        return false;
                    }
                } catch (Exception e) {
                    ZipInputStream zipInputStream3 = zipInputStream2;
                    e = e;
                    zipInputStream = zipInputStream3;
                    try {
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeIO(zipInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipInputStream = zipInputStream2;
                    closeIO(zipInputStream);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
            closeIO(zipInputStream);
            return false;
        }
    }

    public static void delete(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                deleteFile(new File(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteExpiredFile(File file, int i, FileKeepRule fileKeepRule) {
        if (file != null) {
            try {
                if (file.exists() && System.currentTimeMillis() - file.lastModified() > TimeUnit.DAYS.toMillis((long) i)) {
                    if (fileKeepRule != null) {
                        if (fileKeepRule.needKept(file.getName())) {
                            return;
                        }
                    }
                    LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                    deleteFile(file);
                }
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }

    public static void deleteExpiredFiles(String str, int i, FileKeepRule fileKeepRule) {
        try {
            List<File> files = getFiles(str);
            LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i);
            if (files != null && files.size() > 0) {
                for (File deleteExpiredFile : files) {
                    deleteExpiredFile(deleteExpiredFile, i, fileKeepRule);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", (Throwable) e);
            int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
            TanxBaseUt.utError(intCode, TAG, "deleteExpiredFiles: exception." + LogUtils.getStackTraceMessage(e), "");
        }
    }

    public static synchronized boolean deleteFile(File file) {
        File[] listFiles;
        synchronized (FileUtils.class) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                boolean delete = file.delete();
                return delete;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File deleteFile : listFiles) {
                    if (!deleteFile(deleteFile)) {
                        return false;
                    }
                }
            }
            boolean delete2 = file.delete();
            return delete2;
        }
    }

    private static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            if ((parentFile.exists() || parentFile.mkdirs()) && file.createNewFile()) {
                return true;
            }
            return false;
        } catch (IOException e) {
            e = e;
            e.printStackTrace();
            return false;
        } catch (SecurityException e2) {
            e = e2;
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exists(String str) {
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            return true;
        } catch (SecurityException e) {
            LogUtils.d(TAG, "call exists failed.", e);
            return false;
        }
    }

    public static File getExternalDir(Context context, int i) {
        if (i == 0) {
            try {
                return context.getExternalFilesDir((String) null);
            } catch (Throwable unused) {
                LogUtils.d(TAG, "getExternalDir exception: type = " + i);
                return null;
            }
        } else if (i == 1) {
            return context.getExternalCacheDir();
        } else {
            return null;
        }
    }

    private static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        r5 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getStrFromFile(java.lang.String r5) {
        /*
            java.lang.Class<com.alimm.tanx.core.utils.FileUtils> r0 = com.alimm.tanx.core.utils.FileUtils.class
            monitor-enter(r0)
            java.lang.String r1 = ""
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x003f }
            r3.<init>(r5)     // Catch:{ Exception -> 0x003f }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x003f }
            if (r3 != 0) goto L_0x0018
            closeIO(r2)     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r2
        L_0x0016:
            r5 = move-exception
            goto L_0x004d
        L_0x0018:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f }
            r3.<init>(r5)     // Catch:{ Exception -> 0x003f }
            int r5 = r3.available()     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r3.read(r5)     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r2.<init>(r5, r4)     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r3.close()     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            closeIO(r3)     // Catch:{ all -> 0x0016 }
            goto L_0x0047
        L_0x0034:
            r5 = move-exception
            r2 = r3
            goto L_0x0049
        L_0x0037:
            r5 = move-exception
            r1 = r2
        L_0x0039:
            r2 = r3
            goto L_0x0040
        L_0x003b:
            r5 = move-exception
            goto L_0x0039
        L_0x003d:
            r5 = move-exception
            goto L_0x0049
        L_0x003f:
            r5 = move-exception
        L_0x0040:
            r5.printStackTrace()     // Catch:{ all -> 0x003d }
            closeIO(r2)     // Catch:{ all -> 0x0016 }
            r2 = r1
        L_0x0047:
            monitor-exit(r0)
            return r2
        L_0x0049:
            closeIO(r2)     // Catch:{ all -> 0x0016 }
            throw r5     // Catch:{ all -> 0x0016 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.FileUtils.getStrFromFile(java.lang.String):java.lang.String");
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            int i = 0;
            while (i < strArr.length && !TextUtils.isEmpty(strArr[i])) {
                if (i > 0) {
                    sb.append(File.separator);
                }
                sb.append(strArr[i]);
                i++;
            }
        }
        return sb.toString();
    }

    public static File mkdir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.mkdirs();
            return file;
        } catch (Exception e) {
            LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e);
            return file;
        }
    }

    public static String readAssetFile(Context context, String str) {
        if (context == null || str == null) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        closeIO(bufferedReader2);
                        return sb2;
                    }
                }
            } catch (Exception e) {
                e = e;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    closeIO(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                closeIO(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            closeIO(bufferedReader);
            return "";
        }
    }

    public static List<String> readLines(String str) {
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        linkedList.add(readLine);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        try {
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th) {
                            th = th;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        closeIO(bufferedReader);
                        throw th;
                    }
                }
                closeIO(bufferedReader2);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                closeIO(bufferedReader);
                return linkedList;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStr2File(File file, String str) {
        synchronized (FileUtils.class) {
            boolean z = false;
            if (file == null) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.close();
                    closeIO(fileOutputStream2);
                    z = true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        LogUtils.e(TAG, "saveStrToFile ", (Throwable) e);
                        int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
                        TanxBaseUt.utError(intCode, TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                        e.printStackTrace();
                        closeIO(fileOutputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        closeIO(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                LogUtils.e(TAG, "saveStrToFile ", (Throwable) e);
                int intCode2 = UtErrorCode.CRASH_ERROR.getIntCode();
                TanxBaseUt.utError(intCode2, TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                e.printStackTrace();
                closeIO(fileOutputStream);
                return z;
            }
        }
    }

    public static boolean unZipFolder(String str, String str2) throws Exception {
        if (!new File(str).exists()) {
            return false;
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    new File(str2 + File.separator + substring).mkdirs();
                } else {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return true;
            }
        }
    }

    public static InputStream upZip(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void writeLine(String str, boolean z, String str2) {
        if (ensureFileExists(str)) {
            PrintWriter printWriter = null;
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(str, z)));
                try {
                    printWriter2.println(str2);
                    closeIO(printWriter2);
                } catch (IOException e) {
                    e = e;
                    printWriter = printWriter2;
                    try {
                        e.printStackTrace();
                        closeIO(printWriter);
                    } catch (Throwable th) {
                        th = th;
                        closeIO(printWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    closeIO(printWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                closeIO(printWriter);
            }
        }
    }

    public static void deleteExpiredFile(String str, int i, FileKeepRule fileKeepRule) {
        File[] listFiles;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File deleteExpiredFile : listFiles) {
                        deleteExpiredFile(deleteExpiredFile, i, fileKeepRule);
                    }
                }
                deleteExpiredFile(new File(str), i, fileKeepRule);
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public static List<File> getFiles(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean saveStr2File(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alimm.tanx.core.utils.FileUtils> r0 = com.alimm.tanx.core.utils.FileUtils.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0046 }
            r2 = 0
            if (r1 != 0) goto L_0x0084
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0012
            goto L_0x0084
        L_0x0012:
            r1 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0030 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0030 }
            boolean r6 = r3.exists()     // Catch:{ Exception -> 0x0030 }
            if (r6 != 0) goto L_0x0032
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = r3.getParent()     // Catch:{ Exception -> 0x0030 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0030 }
            r6.mkdirs()     // Catch:{ Exception -> 0x0030 }
            r3.createNewFile()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x002e:
            r6 = move-exception
            goto L_0x0080
        L_0x0030:
            r6 = move-exception
            goto L_0x004f
        L_0x0032:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0030 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0030 }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            r6.write(r7)     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            r6.close()     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            closeIO(r6)     // Catch:{ all -> 0x0046 }
            r2 = 1
            goto L_0x007e
        L_0x0046:
            r6 = move-exception
            goto L_0x0086
        L_0x0048:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L_0x0080
        L_0x004c:
            r7 = move-exception
            r1 = r6
            r6 = r7
        L_0x004f:
            java.lang.String r7 = "FileUtils"
            java.lang.String r3 = "saveStrToFile "
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r7, (java.lang.String) r3, (java.lang.Throwable) r6)     // Catch:{ all -> 0x002e }
            com.alimm.tanx.core.ut.UtErrorCode r7 = com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR     // Catch:{ all -> 0x002e }
            int r7 = r7.getIntCode()     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "FileUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r4.<init>()     // Catch:{ all -> 0x002e }
            java.lang.String r5 = "saveStrToFile "
            r4.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r6)     // Catch:{ all -> 0x002e }
            r4.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002e }
            java.lang.String r5 = ""
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError((int) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x002e }
            r6.printStackTrace()     // Catch:{ all -> 0x002e }
            closeIO(r1)     // Catch:{ all -> 0x0046 }
        L_0x007e:
            monitor-exit(r0)
            return r2
        L_0x0080:
            closeIO(r1)     // Catch:{ all -> 0x0046 }
            throw r6     // Catch:{ all -> 0x0046 }
        L_0x0084:
            monitor-exit(r0)
            return r2
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.FileUtils.saveStr2File(java.lang.String, java.lang.String):boolean");
    }

    public static synchronized String getStrFromFile(File file) {
        synchronized (FileUtils.class) {
            StringBuilder sb = new StringBuilder();
            FileInputStream fileInputStream = null;
            try {
                if (!file.exists()) {
                    closeIO((Closeable) null);
                    return null;
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream2, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    closeIO(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        closeIO(fileInputStream);
                        String sb2 = sb.toString();
                        return sb2;
                    } catch (Throwable th) {
                        th = th;
                        closeIO(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeIO(fileInputStream);
                    throw th;
                }
                String sb22 = sb.toString();
                return sb22;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                closeIO(fileInputStream);
                String sb222 = sb.toString();
                return sb222;
            }
        }
    }
}
