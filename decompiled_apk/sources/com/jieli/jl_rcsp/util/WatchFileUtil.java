package com.jieli.jl_rcsp.util;

import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes10.dex */
public class WatchFileUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18230a = "WatchFileUtil";

    public static boolean deleteFile(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                deleteFile(file2.getPath());
            }
        }
        return file.delete();
    }

    public static String getDirPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (!str.equals(str2)) {
                int lastIndexOf = str.lastIndexOf(str2);
                if (lastIndexOf == -1) {
                    return str;
                }
                return str.substring(0, lastIndexOf);
            }
            return null;
        }
        return null;
    }

    public static String getFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (!str.equals(str2)) {
                int lastIndexOf = str.lastIndexOf(str2);
                if (lastIndexOf == -1) {
                    return str;
                }
                int i = lastIndexOf + 1;
                if (i == str.length()) {
                    return getFileName(str.substring(0, lastIndexOf));
                }
                return str.substring(i);
            }
            return "";
        }
        return "";
    }

    public static String getJsonFileName(String str) {
        String fileName = getFileName(str);
        if (TextUtils.isEmpty(fileName)) {
            return fileName;
        }
        int lastIndexOf = fileName.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        if (lastIndexOf != -1) {
            fileName = fileName.substring(0, lastIndexOf);
        }
        return fileName + ".json";
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public static String obtainUpdateFilePath(String str, String str2) {
        File[] listFiles;
        String str3 = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (file.isFile()) {
            if (!str.endsWith(str2)) {
                return null;
            }
            return str;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                str3 = obtainUpdateFilePath(file2.getPath(), str2);
                if (str3 != null) {
                    break;
                }
            }
        }
        return str3;
    }

    public static byte[] readFileData(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        IOException e;
        byte[] bArr;
        IOException e2;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        byte[] bArr2 = null;
        FileInputStream fileInputStream3 = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                if (file.isFile()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        bArr = null;
                    } catch (IOException e4) {
                        e = e4;
                        bArr = null;
                    }
                    try {
                        byte[] bArr3 = new byte[fileInputStream.available()];
                        int read = fileInputStream.read(bArr3);
                        bArr2 = new byte[read];
                        System.arraycopy(bArr3, 0, bArr2, 0, read);
                        try {
                            fileInputStream.close();
                            return bArr2;
                        } catch (IOException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            return bArr2;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        byte[] bArr4 = bArr2;
                        fileInputStream3 = fileInputStream;
                        bArr = bArr4;
                        e.printStackTrace();
                        JL_Log.w(f18230a, "readFileData", "file not found");
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e7) {
                                bArr2 = bArr;
                                e2 = e7;
                                e2.printStackTrace();
                                return bArr2;
                            }
                        }
                        return bArr;
                    } catch (IOException e8) {
                        e = e8;
                        byte[] bArr5 = bArr2;
                        fileInputStream2 = fileInputStream;
                        bArr = bArr5;
                        e.printStackTrace();
                        JL_Log.w(f18230a, "readFileData", "error : " + e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        }
        JL_Log.w(f18230a, "readFileData", "file path not exist.");
        return null;
    }
}
