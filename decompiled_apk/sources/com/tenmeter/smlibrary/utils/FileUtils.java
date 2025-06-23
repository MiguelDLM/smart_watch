package com.tenmeter.smlibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes13.dex */
public class FileUtils {
    public static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final long SIZE_GB = 1073741824;
    private static final long SIZE_KB = 1024;
    private static final long SIZE_MB = 1048576;

    /* loaded from: classes13.dex */
    public static class CompratorByLastModified implements Comparator<File> {
        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    private FileUtils() {
        throw new AssertionError();
    }

    public static String checkDirPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static void clearCache(Context context) {
        delete(context.getCacheDir());
        delete(context.getExternalCacheDir());
    }

    public static boolean copyFile(String str, String str2) {
        try {
            return writeFile(str2, new FileInputStream(str));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        }
    }

    public static void delete(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                deleteDirRecursive(file);
            } else {
                file.delete();
            }
        }
    }

    public static void deleteDirRecursive(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                file2.delete();
            } else {
                deleteDirRecursive(file2);
            }
        }
        file.delete();
    }

    public static boolean deleteFile(String str) {
        if (StringUtils.isBlank(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        if (file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    deleteFile(file2.getAbsolutePath());
                }
            }
        }
        return file.delete();
    }

    public static String formatFileSize(long j) {
        if (j < 1073741824) {
            return StringUtil.formatDoubZeroToString(Double.valueOf(BigDecimal.valueOf(j / 1048576.0d).setScale(2, 0).doubleValue())) + "M";
        }
        return StringUtil.formatDoubZeroToString(Double.valueOf(BigDecimal.valueOf(j / 1.073741824E9d).setScale(2, 0).doubleValue())) + "G";
    }

    public static String getAppStorageDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return getStorageDir(context);
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static String getFileExtension(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1 || lastIndexOf2 >= lastIndexOf) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static List<File> getFileList(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            arrayList.add(file2);
        }
        return arrayList;
    }

    public static String getFileMD5(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                messageDigest.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return new BigInteger(1, messageDigest.digest()).toString(16);
            }
        }
    }

    public static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String getFileNameWithoutExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            if (lastIndexOf != -1) {
                return str.substring(0, lastIndexOf);
            }
            return str;
        }
        if (lastIndexOf == -1) {
            return str.substring(lastIndexOf2 + 1);
        }
        if (lastIndexOf2 < lastIndexOf) {
            return str.substring(lastIndexOf2 + 1, lastIndexOf);
        }
        return str.substring(lastIndexOf2 + 1);
    }

    public static long getFileSize(String str) {
        if (StringUtils.isBlank(str)) {
            return 0L;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return -1L;
    }

    public static String getFolderName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static String getRealFilePathFromUri(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equalsIgnoreCase(scheme)) {
            return uri.getPath();
        }
        if (!"content".equalsIgnoreCase(scheme) || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    private static String getSDCardDir() {
        File[] listFiles = Environment.getExternalStorageDirectory().getParentFile().listFiles();
        String str = null;
        long j = 0;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].canWrite()) {
                String absolutePath = listFiles[i].getAbsolutePath();
                long sDFreeSize = getSDFreeSize(absolutePath);
                if (sDFreeSize > j) {
                    str = absolutePath;
                    j = sDFreeSize;
                }
            }
        }
        return str;
    }

    public static long getSDFreeSize(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String getStorageDir(Context context) {
        return getStorageDir(context, true);
    }

    public static boolean isFileExist(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public static boolean isFolderExist(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        return true;
    }

    public static String loadCacheSize(Context context) {
        return formatFileSize(getFileSize(context.getCacheDir()) + getFileSize(context.getExternalCacheDir()));
    }

    public static boolean makeDirs(String str) {
        String folderName = getFolderName(str);
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static File makeFilePath(String str, String str2) {
        File file;
        makeRootDirectory(str);
        File file2 = null;
        try {
            file = new File(str + str2);
        } catch (Exception e) {
            e = e;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
                return file;
            }
            return file;
        } catch (Exception e2) {
            e = e2;
            file2 = file;
            e.printStackTrace();
            return file2;
        }
    }

    public static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }

    public static void moveFile(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            moveFile(new File(str), new File(str2));
            return;
        }
        throw new RuntimeException("Both sourceFilePath and destFilePath cannot be null.");
    }

    public static String readFile(String str) {
        String str2 = "";
        File file = new File(str);
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine + " ";
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return str2;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static byte[] readFileToByteArray(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        ?? exists = file.exists();
        try {
            if (exists == 0) {
                KLog.e("File doesn't exist!");
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.getChannel().size() == 0) {
                        KLog.d("The FileInputStream has no content!");
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                        return bArr;
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                    return null;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                exists = 0;
                try {
                    exists.close();
                    throw th;
                } catch (IOException unused5) {
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<String> readFileToList(String str, String str2) {
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), str2));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        } else {
                            bufferedReader2.close();
                            try {
                                bufferedReader2.close();
                                return arrayList;
                            } catch (IOException e) {
                                throw new RuntimeException("IOException occurred. ", e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                throw new RuntimeException("IOException occurred. ", e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFile(String str, String str2, boolean z) {
        FileWriter fileWriter;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                makeDirs(str);
                fileWriter = new FileWriter(str, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileWriter.write(str2);
            fileWriter.close();
            try {
                fileWriter.close();
                return true;
            } catch (IOException e2) {
                throw new RuntimeException("IOException occurred. ", e2);
            }
        } catch (IOException e3) {
            e = e3;
            throw new RuntimeException("IOException occurred. ", e);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e4) {
                    throw new RuntimeException("IOException occurred. ", e4);
                }
            }
            throw th;
        }
    }

    public static void writeTxtToFile(String str, String str2, String str3) {
        makeFilePath(str2, str3);
        String str4 = str2 + str3;
        String str5 = str + "\r\n";
        try {
            File file = new File(str4);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + str4);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str5.getBytes());
            randomAccessFile.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

    public static String getStorageDir(Context context, boolean z) {
        String file = Environment.getExternalStorageDirectory().toString();
        if (!new File(file).canWrite()) {
            String sDCardDir = getSDCardDir();
            if (sDCardDir == null) {
                if (z) {
                    return context.getCacheDir().toString();
                }
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(sDCardDir);
            String str = File.separator;
            sb.append(str);
            sb.append("uet");
            sb.append(str);
            sb.append("teacherpad");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("uet");
        sb2.append(str2);
        sb2.append("teacherpad");
        return sb2.toString();
    }

    public static long getFileSize(File file) {
        long j = 0;
        if (file == null) {
            return 0L;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    j += getFileSize(file2);
                } else {
                    j += r5.available();
                    new FileInputStream(file2).close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    public static void moveFile(File file, File file2) {
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file.getAbsolutePath(), file2.getAbsolutePath());
        deleteFile(file.getAbsolutePath());
    }

    public static boolean writeFile(String str, List<String> list, boolean z) {
        FileWriter fileWriter;
        int i = 0;
        if (list == null || list.size() == 0) {
            return false;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                makeDirs(str);
                fileWriter = new FileWriter(str, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            for (String str2 : list) {
                int i2 = i + 1;
                if (i > 0) {
                    fileWriter.write("\r\n");
                }
                fileWriter.write(str2);
                i = i2;
            }
            fileWriter.close();
            try {
                fileWriter.close();
                return true;
            } catch (IOException e2) {
                throw new RuntimeException("IOException occurred. ", e2);
            }
        } catch (IOException e3) {
            e = e3;
            throw new RuntimeException("IOException occurred. ", e);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e4) {
                    throw new RuntimeException("IOException occurred. ", e4);
                }
            }
            throw th;
        }
    }

    public static boolean writeFile(String str, String str2) {
        return writeFile(str, str2, false);
    }

    public static boolean writeFile(String str, List<String> list) {
        return writeFile(str, list, false);
    }

    public static boolean writeFile(String str, InputStream inputStream) {
        return writeFile(str, inputStream, false);
    }

    public static boolean writeFile(String str, InputStream inputStream, boolean z) {
        return writeFile(str != null ? new File(str) : null, inputStream, z);
    }

    public static boolean writeFile(File file, InputStream inputStream) {
        return writeFile(file, inputStream, false);
    }

    public static boolean writeFile(File file, InputStream inputStream, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                makeDirs(file.getAbsolutePath());
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                        inputStream.close();
                        return true;
                    } catch (IOException e3) {
                        throw new RuntimeException("IOException occurred. ", e3);
                    }
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        } catch (IOException e5) {
            e = e5;
            throw new RuntimeException("IOException occurred. ", e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    inputStream.close();
                } catch (IOException e6) {
                    throw new RuntimeException("IOException occurred. ", e6);
                }
            }
            throw th;
        }
    }
}
