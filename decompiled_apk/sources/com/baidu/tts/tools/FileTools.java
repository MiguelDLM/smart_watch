package com.baidu.tts.tools;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes8.dex */
public class FileTools {
    public static void createDir(String str) {
        new File(str).mkdirs();
    }

    public static File createFile(String str) {
        return getFile(str);
    }

    public static boolean deleteFile(String str) {
        return deleteFile(createFile(str));
    }

    public static String extractFileName(String str) {
        return str.substring(str.lastIndexOf(File.separator) + 1);
    }

    public static boolean fileCopy(String str, String str2) throws FileNotFoundException {
        return fileCopy(createFile(str), createFile(str2));
    }

    public static File getFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                file.mkdirs();
            } else {
                File file2 = new File(str.substring(0, str.lastIndexOf(str2)));
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static String jointPathAndName(String str, String str2) {
        String str3 = File.separator;
        if (str.endsWith(str3)) {
            return str + str2;
        }
        return str + str3 + str2;
    }

    public static boolean writeFile(String str, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File createFile(String str, String str2) {
        return getFile(jointPathAndName(str, str2));
    }

    public static boolean deleteFile(File file) {
        return !file.exists() || file.delete();
    }

    public static boolean isFileExist(Object... objArr) {
        File createFile;
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof File) {
                createFile = (File) obj;
            } else {
                createFile = obj instanceof String ? createFile((String) obj) : null;
            }
        } else if (objArr.length == 2) {
            createFile = createFile((String) objArr[0], (String) objArr[1]);
        } else {
            throw new UnknownError();
        }
        if (createFile != null) {
            return createFile.exists();
        }
        return false;
    }

    public static boolean fileCopy(String str, String str2, String str3, String str4) throws FileNotFoundException {
        return fileCopy(createFile(str, str2), createFile(str3, str4));
    }

    public static boolean fileCopy(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) {
        return fileCopy(new FileInputStream(fileDescriptor), new FileOutputStream(fileDescriptor2));
    }

    public static boolean fileCopy(File file, File file2) throws FileNotFoundException {
        return fileCopy(new FileInputStream(file), new FileOutputStream(file2));
    }

    public static boolean fileCopy(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        try {
            try {
                boolean fileCopy = fileCopy(fileInputStream.getChannel(), fileOutputStream.getChannel());
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return fileCopy;
                } catch (IOException e) {
                    e.printStackTrace();
                    return fileCopy;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            fileInputStream.close();
            fileOutputStream.close();
            return false;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public static File getFile(String str, String str2) {
        return getFile(jointPathAndName(str, str2));
    }

    public static boolean fileCopy(FileChannel fileChannel, FileChannel fileChannel2) {
        try {
            try {
                fileChannel.transferTo(0L, fileChannel.size(), fileChannel2);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    fileChannel.close();
                    fileChannel2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                fileChannel.close();
                fileChannel2.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            try {
                fileChannel.close();
                fileChannel2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }
}
