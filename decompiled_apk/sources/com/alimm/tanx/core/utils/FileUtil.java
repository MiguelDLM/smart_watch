package com.alimm.tanx.core.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class FileUtil implements NotConfused {

    /* loaded from: classes.dex */
    public interface WriteProgress {
        void error(Exception exc);

        void writeProgress(int i);
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (new File(str).exists()) {
                    fileInputStream = new FileInputStream(str);
                    try {
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1444];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        z = true;
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } else {
                    fileInputStream = null;
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return z;
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static synchronized File getAndCreateFile(String str, String str2) {
        File file;
        synchronized (FileUtil.class) {
            try {
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    private static File getCacheDirectory(Context context, boolean z) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/cache/");
        }
        return cacheDir;
    }

    public static long getFileName(File file) {
        if (file != null) {
            return Long.parseLong(file.getName().replace(".txt", ""));
        }
        return 0L;
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        return new File(getCacheDirectory(context, true), str);
    }

    public static void writeFile(ResponseBody responseBody, File file, long j, boolean z, WriteProgress writeProgress) {
        FileOutputStream fileOutputStream;
        if (responseBody == null) {
            return;
        }
        InputStream byteStream = responseBody.byteStream();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[1024];
                    if (z) {
                        fileOutputStream = new FileOutputStream(file, true);
                    } else {
                        fileOutputStream = new FileOutputStream(file);
                    }
                    fileOutputStream2 = fileOutputStream;
                    if (!z) {
                        j = 0;
                    }
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            fileOutputStream2.flush();
                            byteStream.close();
                            fileOutputStream2.close();
                            return;
                        } else {
                            fileOutputStream2.write(bArr, 0, read);
                            j += read;
                            writeProgress.writeProgress((int) (((((float) j) * 1.0f) / ((float) responseBody.contentLength())) * 100.0f));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                writeProgress.error(e2);
                e2.printStackTrace();
                if (byteStream != null) {
                    byteStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            }
        } catch (Throwable th) {
            if (byteStream != null) {
                try {
                    byteStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (0 != 0) {
                fileOutputStream2.close();
            }
            throw th;
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
}
