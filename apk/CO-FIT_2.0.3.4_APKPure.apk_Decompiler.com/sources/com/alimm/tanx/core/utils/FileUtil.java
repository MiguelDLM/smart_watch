package com.alimm.tanx.core.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

public class FileUtil implements NotConfused {

    public interface WriteProgress {
        void error(Exception exc);

        void writeProgress(int i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0051 A[SYNTHETIC, Splitter:B:36:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0056 A[Catch:{ IOException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005c A[SYNTHETIC, Splitter:B:42:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0064 A[Catch:{ IOException -> 0x0060 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            if (r2 == 0) goto L_0x0039
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0031 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0031 }
            r5 = 1444(0x5a4, float:2.023E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
        L_0x001b:
            int r1 = r2.read(r5)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r3 = -1
            if (r1 == r3) goto L_0x002c
            r4.write(r5, r0, r1)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            goto L_0x001b
        L_0x0026:
            r5 = move-exception
            r1 = r4
            goto L_0x005a
        L_0x0029:
            r5 = move-exception
            r1 = r4
            goto L_0x004c
        L_0x002c:
            r0 = 1
            r1 = r4
            goto L_0x003a
        L_0x002f:
            r5 = move-exception
            goto L_0x005a
        L_0x0031:
            r5 = move-exception
            goto L_0x004c
        L_0x0033:
            r5 = move-exception
            r2 = r1
            goto L_0x005a
        L_0x0036:
            r5 = move-exception
            r2 = r1
            goto L_0x004c
        L_0x0039:
            r2 = r1
        L_0x003a:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0042
        L_0x0040:
            r4 = move-exception
            goto L_0x0048
        L_0x0042:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0059
        L_0x0048:
            r4.printStackTrace()
            goto L_0x0059
        L_0x004c:
            r5.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0059:
            return r0
        L_0x005a:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            r4 = move-exception
            goto L_0x0068
        L_0x0062:
            if (r2 == 0) goto L_0x006b
            r2.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x006b
        L_0x0068:
            r4.printStackTrace()
        L_0x006b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
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
                while (true) {
                    throw th;
                }
            }
        }
        return file;
    }

    private static File getCacheDirectory(Context context, boolean z) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static long getFileName(File file) {
        if (file != null) {
            return Long.parseLong(file.getName().replace(".txt", ""));
        }
        return 0;
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        return new File(getCacheDirectory(context, true), str);
    }

    public static void writeFile(ResponseBody responseBody, File file, long j, boolean z, WriteProgress writeProgress) {
        FileOutputStream fileOutputStream;
        if (responseBody != null) {
            InputStream byteStream = responseBody.byteStream();
            FileOutputStream fileOutputStream2 = null;
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
                        try {
                            byteStream.close();
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        fileOutputStream2.write(bArr, 0, read);
                        j += (long) read;
                        writeProgress.writeProgress((int) (((((float) j) * 1.0f) / ((float) responseBody.contentLength())) * 100.0f));
                    }
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
            } catch (Throwable th) {
                if (byteStream != null) {
                    try {
                        byteStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
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
}
