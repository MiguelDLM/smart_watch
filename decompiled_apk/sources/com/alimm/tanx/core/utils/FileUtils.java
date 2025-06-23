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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FileUtils implements NotConfused {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final String TAG = "FileUtils";

    /* loaded from: classes.dex */
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
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
            if (inputStream == null) {
                return false;
            }
            inputStream.close();
            return false;
        }
    }

    private static boolean copyTo(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    closeIO(fileOutputStream);
                    return true;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            LogUtils.d(TAG, "copyTo exception: output = " + file, e);
            closeIO(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            closeIO(fileOutputStream2);
            throw th;
        }
    }

    public static boolean decompress(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
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
                        if (nextEntry != null) {
                            if (!TextUtils.isEmpty(nextEntry.getName()) && nextEntry.getName().contains("../")) {
                                LogUtils.e("decompress", "发现不安全的zip文件解压路径！");
                                closeIO(zipInputStream2);
                                return false;
                            }
                            String joinPath = joinPath(str2, nextEntry.getName());
                            if (nextEntry.isDirectory()) {
                                mkdir(joinPath);
                            } else {
                                z &= copyTo(new File(joinPath), zipInputStream2);
                            }
                        } else {
                            closeIO(zipInputStream2);
                            return z;
                        }
                    } catch (Exception e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
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
                if (!file.exists() || System.currentTimeMillis() - file.lastModified() <= TimeUnit.DAYS.toMillis(i)) {
                    return;
                }
                if (fileKeepRule != null && fileKeepRule.needKept(file.getName())) {
                    return;
                }
                LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                deleteFile(file);
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
                Iterator<File> it = files.iterator();
                while (it.hasNext()) {
                    deleteExpiredFile(it.next(), i, fileKeepRule);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteExpiredFiles: exception." + LogUtils.getStackTraceMessage(e), "");
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
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
    }

    private static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                if (!file.createNewFile()) {
                    return false;
                }
                return true;
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
        return true;
    }

    public static boolean exists(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!new File(str).exists()) {
                return false;
            }
            return true;
        } catch (SecurityException e) {
            LogUtils.d(TAG, "call exists failed.", e);
            return false;
        }
    }

    public static File getExternalDir(Context context, int i) {
        File file = null;
        try {
        } catch (Throwable unused) {
            LogUtils.d(TAG, "getExternalDir exception: type = " + i);
        }
        if (i == 0) {
            file = context.getExternalFilesDir(null);
        } else {
            if (i == 1) {
                file = context.getExternalCacheDir();
            }
            return file;
        }
        return file;
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

    public static synchronized String getStrFromFile(String str) {
        String str2;
        synchronized (FileUtils.class) {
            String str3 = "";
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Exception e) {
                    e = e;
                }
                if (!new File(str).exists()) {
                    closeIO(null);
                    return null;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr);
                        str2 = new String(bArr, StandardCharsets.UTF_8);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        closeIO(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    fileInputStream2.close();
                    closeIO(fileInputStream2);
                } catch (Exception e3) {
                    e = e3;
                    str3 = str2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    closeIO(fileInputStream);
                    str2 = str3;
                    return str2;
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length && !TextUtils.isEmpty(strArr[i]); i++) {
                if (i > 0) {
                    sb.append(File.separator);
                }
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static File mkdir(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    return file;
                } catch (Exception e) {
                    LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e);
                    return file;
                }
            }
            return file;
        }
        return null;
    }

    public static String readAssetFile(Context context, String str) {
        BufferedReader bufferedReader;
        if (context == null || str == null) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    closeIO(bufferedReader);
                    return sb2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            closeIO(bufferedReader2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            closeIO(bufferedReader2);
            throw th;
        }
    }

    public static List<String> readLines(String str) {
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader = null;
            try {
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
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    }
                    closeIO(bufferedReader2);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStr2File(File file, String str) {
        FileOutputStream fileOutputStream;
        synchronized (FileUtils.class) {
            boolean z = false;
            if (file == null) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                closeIO(fileOutputStream);
                z = true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                LogUtils.e(TAG, "saveStrToFile ", e);
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                e.printStackTrace();
                closeIO(fileOutputStream2);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                closeIO(fileOutputStream2);
                throw th;
            }
            return z;
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
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
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
        PrintWriter printWriter;
        if (!ensureFileExists(str)) {
            return;
        }
        PrintWriter printWriter2 = null;
        try {
            try {
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(str, z)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            printWriter.println(str2);
            closeIO(printWriter);
        } catch (IOException e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            closeIO(printWriter2);
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            closeIO(printWriter2);
            throw th;
        }
    }

    public static void deleteExpiredFile(String str, int i, FileKeepRule fileKeepRule) {
        File[] listFiles;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteExpiredFile(file2, i, fileKeepRule);
                }
            }
            deleteExpiredFile(new File(str), i, fileKeepRule);
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

    public static synchronized boolean saveStr2File(String str, String str2) {
        FileOutputStream fileOutputStream;
        synchronized (FileUtils.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        new File(file.getParent()).mkdirs();
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
                closeIO(fileOutputStream);
                z = true;
            } catch (Exception e2) {
                fileOutputStream2 = fileOutputStream;
                e = e2;
                LogUtils.e(TAG, "saveStrToFile ", e);
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                e.printStackTrace();
                closeIO(fileOutputStream2);
                return z;
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                closeIO(fileOutputStream2);
                throw th;
            }
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    public static synchronized String getStrFromFile(File file) {
        synchronized (FileUtils.class) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            if (!file.exists()) {
                closeIO(null);
                return null;
            }
            ?? fileInputStream = new FileInputStream(file);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader((InputStream) fileInputStream, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                inputStreamReader.close();
                closeIO(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = fileInputStream;
                e.printStackTrace();
                closeIO(bufferedReader);
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = fileInputStream;
                closeIO(bufferedReader);
                throw th;
            }
            return sb.toString();
        }
    }
}
