package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes8.dex */
public class q0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static String a(Uri uri, Context context) {
        InputStreamReader inputStreamReader;
        int read;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                try {
                    inputStreamReader = new InputStreamReader(context.getContentResolver().openInputStream(uri));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            inputStreamReader.close();
            r0 = read;
        } catch (Exception e3) {
            e = e3;
            r0 = inputStreamReader;
            e.printStackTrace();
            if (r0 != 0) {
                r0.close();
                r0 = r0;
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            r0 = inputStreamReader;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return sb.toString();
    }

    public static boolean a(Uri uri, Uri uri2, Context context) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        if (context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(context.getContentResolver().openInputStream(uri));
            try {
                bufferedOutputStream = new BufferedOutputStream(context.getContentResolver().openOutputStream(uri2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException unused) {
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            throw th;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (IOException unused3) {
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(DocumentFile documentFile, DocumentFile documentFile2, Context context) {
        if (context == null || !documentFile.exists()) {
            return false;
        }
        if (!documentFile2.exists()) {
            documentFile2.getParentFile().createDirectory(documentFile.getName());
        }
        DocumentFile[] listFiles = documentFile.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                DocumentFile documentFile3 = listFiles[i];
                String name = documentFile3.getName();
                DocumentFile findFile = documentFile2.findFile(name);
                if (findFile == null) {
                    findFile = documentFile2.createFile(null, name);
                }
                z = z && a(documentFile3.getUri(), findFile.getUri(), context);
            }
            if (listFiles[i].isDirectory()) {
                DocumentFile documentFile4 = listFiles[i];
                String name2 = documentFile4.getName();
                DocumentFile findFile2 = documentFile2.findFile(name2);
                if (findFile2 == null) {
                    findFile2 = documentFile2.createDirectory(name2);
                }
                z = z && a(documentFile4, findFile2, context);
            }
        }
        return z;
    }
}
