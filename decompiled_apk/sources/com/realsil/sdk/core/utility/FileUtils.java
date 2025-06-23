package com.realsil.sdk.core.utility;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.realsil.sdk.core.logger.ZLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes11.dex */
public final class FileUtils {
    public static String a(Context context, Uri uri) {
        if (isGooglePhotosUri(uri)) {
            ZLogger.v("isGooglePhotosUri");
            return uri.getLastPathSegment();
        }
        if (isOppoUri(uri)) {
            ZLogger.v("isOppoUri");
            String path = uri.getPath();
            File file = new File(path);
            if (file.exists()) {
                ZLogger.v(String.format(Locale.US, ">>>> %s\n%s\n%d", file.getPath(), file.getName(), Long.valueOf(file.length())));
                return path;
            }
            if (path.contains("/file_share/")) {
                return path.replace("/file_share", "");
            }
            return path;
        }
        if (!isHuaweiUri(uri) && !isHuaweiShareUri(uri)) {
            if (isNokia(uri)) {
                ZLogger.v("isNokia");
                String path2 = uri.getPath();
                File file2 = new File(path2);
                if (file2.exists()) {
                    ZLogger.v(String.format(Locale.US, ">>>> %s\n%s\n%d", file2.getPath(), file2.getName(), Long.valueOf(file2.length())));
                    return path2;
                }
                if (path2.contains("/shared_files/")) {
                    return path2.replace("/shared_files", "");
                }
                return path2;
            }
            if (isTencentProvider(uri)) {
                ZLogger.v("TencentProvider");
                String path3 = uri.getPath();
                File file3 = new File(path3);
                if (file3.exists()) {
                    ZLogger.v(String.format(Locale.US, ">>>> %s\n%s\n%d", file3.getPath(), file3.getName(), Long.valueOf(file3.length())));
                    return path3;
                }
                if (path3.contains("/QQBrowser/")) {
                    return Environment.getExternalStorageDirectory() + path3.replace("/QQBrowser", "");
                }
                return path3;
            }
            String dataColumn = getDataColumn(context, uri, null, null);
            ZLogger.v("getDataColumn:" + dataColumn);
            if (!TextUtils.isEmpty(dataColumn)) {
                return dataColumn;
            }
            return uri.getPath();
        }
        ZLogger.v("isHuaweiUri");
        String path4 = uri.getPath();
        File file4 = new File(path4);
        if (file4.exists()) {
            ZLogger.v(String.format(Locale.US, ">>>> %s\n%s\n%d", file4.getPath(), file4.getName(), Long.valueOf(file4.length())));
            return path4;
        }
        if (path4.contains("/root/")) {
            return path4.replace("/root", "");
        }
        return path4;
    }

    public static String b(Context context, Uri uri) {
        int i;
        String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            i = 1;
        } else if ("com.android.providers.downloads.documents".equals(authority)) {
            i = 2;
        } else if ("com.android.providers.media.documents".equals(authority)) {
            i = 3;
        } else if ("com.google.android.apps.docs.storage".equals(authority)) {
            i = 4;
        } else {
            i = 0;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        String[] split = documentId.split(":");
        ZLogger.v(String.format("getPathFromDocumentUri, type=0x%02X, docId=%s", Integer.valueOf(i), documentId));
        if (i != 1) {
            Uri uri2 = null;
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
                        int columnIndex = query.getColumnIndex("_display_name");
                        int columnIndex2 = query.getColumnIndex("_size");
                        query.moveToFirst();
                        String string = query.getString(columnIndex);
                        ZLogger.e("name:" + string);
                        ZLogger.e("size:" + Long.toString(query.getLong(columnIndex2)));
                        File file = new File(context.getCacheDir(), string);
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
                            while (true) {
                                int read = openInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            openInputStream.close();
                            fileOutputStream.close();
                            ZLogger.d("File Path: " + file.getPath());
                            ZLogger.d("File Size: " + file.length());
                        } catch (Exception e) {
                            ZLogger.e(e.getMessage());
                        }
                        return file.getPath();
                    }
                } else {
                    String str = split[0];
                    if ("image".equalsIgnoreCase(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equalsIgnoreCase(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split[1]});
                }
            } else {
                int length = split.length;
                if (length >= 2) {
                    String str2 = split[0];
                    ZLogger.v("type=" + str2);
                    if ("raw".equalsIgnoreCase(str2)) {
                        return split[1];
                    }
                    if ("msf".equalsIgnoreCase(str2)) {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(split[1])), null, null);
                    }
                    getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ContentUris.parseId(uri)), null, null);
                } else if (length == 1) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), null, null);
                }
            }
            return null;
        }
        if (split.length <= 0) {
            return documentId;
        }
        String str3 = split[0];
        ZLogger.v(String.format("type=%s", str3));
        if ("primary".equalsIgnoreCase(str3)) {
            return Environment.getExternalStorageDirectory() + "/" + split[1];
        }
        return Environment.getExternalStorageDirectory() + "/" + split[1];
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:12|13|14)|15|16|(2:26|27)|(1:25)|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0096, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        com.realsil.sdk.core.logger.ZLogger.w(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:
    
        if (r3 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
    
        if (r2 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
    
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyFile(java.lang.String r5, java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L20
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = " not exist"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.realsil.sdk.core.logger.ZLogger.w(r5)
            return
        L20:
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L5d
            boolean r2 = r1.createNewFile()     // Catch: java.io.IOException -> L48
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L48
            r3.<init>()     // Catch: java.io.IOException -> L48
            java.lang.String r4 = "createNewFile: "
            r3.append(r4)     // Catch: java.io.IOException -> L48
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.io.IOException -> L48
            r3.append(r2)     // Catch: java.io.IOException -> L48
            java.lang.String r2 = r3.toString()     // Catch: java.io.IOException -> L48
            com.realsil.sdk.core.logger.ZLogger.e(r2)     // Catch: java.io.IOException -> L48
            goto L5d
        L48:
            r2 = move-exception
            java.lang.String r3 = "createFile failed: "
            java.lang.StringBuilder r3 = com.realsil.sdk.core.a.a.a(r3)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.realsil.sdk.core.logger.ZLogger.e(r2)
        L5d:
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L6c
            r3.<init>(r0)     // Catch: java.io.FileNotFoundException -> L6c
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L6a
            r0.<init>(r1)     // Catch: java.io.FileNotFoundException -> L6a
            r2 = r0
            goto L75
        L6a:
            r0 = move-exception
            goto L6e
        L6c:
            r0 = move-exception
            r3 = r2
        L6e:
            java.lang.String r0 = r0.toString()
            com.realsil.sdk.core.logger.ZLogger.e(r0)
        L75:
            java.lang.String r0 = "copyFile from %s to %s"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            r4 = 0
            r1[r4] = r5     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            r5 = 1
            r1[r5] = r6     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            java.lang.String r5 = java.lang.String.format(r0, r1)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            com.realsil.sdk.core.logger.ZLogger.d(r5)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            copyFile(r3, r2)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            if (r3 == 0) goto L91
            r3.close()     // Catch: java.io.IOException -> L90
            goto L91
        L90:
        L91:
            if (r2 == 0) goto Laa
            goto La7
        L94:
            r5 = move-exception
            goto Lab
        L96:
            r5 = move-exception
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L94
            com.realsil.sdk.core.logger.ZLogger.w(r5)     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto La5
            r3.close()     // Catch: java.io.IOException -> La4
            goto La5
        La4:
        La5:
            if (r2 == 0) goto Laa
        La7:
            r2.close()     // Catch: java.io.IOException -> Laa
        Laa:
            return
        Lab:
            if (r3 == 0) goto Lb2
            r3.close()     // Catch: java.io.IOException -> Lb1
            goto Lb2
        Lb1:
        Lb2:
            if (r2 == 0) goto Lb7
            r2.close()     // Catch: java.io.IOException -> Lb7
        Lb7:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.utility.FileUtils.copyFile(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyFileStream(java.io.File r2, android.net.Uri r3, android.content.Context r4) throws java.io.IOException {
        /*
            r0 = 0
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            java.io.InputStream r3 = r4.openInputStream(r3)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L31
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L31
            if (r3 == 0) goto L24
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
        L14:
            int r0 = r3.read(r2)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r0 <= 0) goto L24
            r1 = 0
            r4.write(r2, r1, r0)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            goto L14
        L1f:
            r2 = move-exception
            goto L49
        L21:
            r2 = move-exception
        L22:
            r0 = r3
            goto L39
        L24:
            if (r3 == 0) goto L29
            r3.close()
        L29:
            r4.close()
            goto L46
        L2d:
            r2 = move-exception
            r4 = r0
            r0 = r3
            goto L48
        L31:
            r2 = move-exception
            r4 = r0
            goto L22
        L34:
            r2 = move-exception
            r4 = r0
            goto L48
        L37:
            r2 = move-exception
            r4 = r0
        L39:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L41
            r0.close()
        L41:
            if (r4 == 0) goto L46
            r4.close()
        L46:
            return
        L47:
            r2 = move-exception
        L48:
            r3 = r0
        L49:
            if (r3 == 0) goto L4e
            r3.close()
        L4e:
            if (r4 == 0) goto L53
            r4.close()
        L53:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.utility.FileUtils.copyFileStream(java.io.File, android.net.Uri, android.content.Context):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x009f -> B:23:0x00a2). Please report as a decompilation issue!!! */
    public static void copyFromAssetsToSdcard(Context context, boolean z, String str, String str2) {
        ?? r0;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        IOException e;
        InputStream inputStream2;
        FileNotFoundException e2;
        InputStream inputStream3;
        InputStream open;
        boolean exists = new File(str2).exists();
        if (!exists || z) {
            try {
                try {
                    try {
                        open = context.getAssets().open(str);
                    } catch (Throwable th2) {
                        th = th2;
                        r0 = exists;
                        inputStream = context;
                    }
                } catch (FileNotFoundException e3) {
                    fileOutputStream = null;
                    e2 = e3;
                    inputStream3 = null;
                } catch (IOException e4) {
                    fileOutputStream = null;
                    e = e4;
                    inputStream2 = null;
                } catch (Throwable th3) {
                    r0 = 0;
                    th = th3;
                    inputStream = null;
                }
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = open.read(bArr, 0, 1024);
                            if (read < 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        ZLogger.v("source = " + str + ", dest = " + str2);
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        open.close();
                    } catch (FileNotFoundException e6) {
                        e2 = e6;
                        inputStream3 = open;
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                    } catch (IOException e8) {
                        e = e8;
                        inputStream2 = open;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    }
                } catch (FileNotFoundException e10) {
                    fileOutputStream = null;
                    e2 = e10;
                    inputStream3 = open;
                } catch (IOException e11) {
                    fileOutputStream = null;
                    e = e11;
                    inputStream2 = open;
                } catch (Throwable th4) {
                    r0 = 0;
                    th = th4;
                    inputStream = open;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException e13) {
                            e13.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e14) {
                e14.printStackTrace();
            }
        }
    }

    public static File createDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean exists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            ZLogger.e(e.getMessage());
            return false;
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                    if (columnIndexOrThrow >= 0) {
                        String string = cursor.getString(columnIndexOrThrow);
                        cursor.close();
                        return string;
                    }
                    ZLogger.w("column '_data' does not exist. ");
                }
                if (cursor == null) {
                    return "";
                }
            } catch (Exception e) {
                ZLogger.w(e.toString());
                if (0 == 0) {
                    return "";
                }
            }
            cursor.close();
            return "";
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!str.isEmpty() && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
                return str.substring(lastIndexOf + 1);
            }
            return "";
        }
        return "";
    }

    public static String getFileExtensionFromUrl2(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            ZLogger.d("fragment=" + lastIndexOf2);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            ZLogger.d("query=" + lastIndexOf3);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!str.isEmpty() && Pattern.matches("[a-zA-Z_0-9\\+\\.\\-\\(\\)\\%]+", str) && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
                return str.substring(lastIndexOf + 1);
            }
            return "";
        }
        return "";
    }

    public static long getFileSize(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            long j = 0;
            for (File file2 : file.listFiles()) {
                j += getFileSize(file2.getAbsolutePath());
            }
            return j;
        }
        return file.length();
    }

    public static String getPath(Context context, Uri uri) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            ZLogger.w(e.toString());
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            return b(context, uri);
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String a2 = a(context, uri);
            if (TextUtils.isEmpty(a2)) {
                String lastPathSegment = uri.getLastPathSegment();
                File file = new File(lastPathSegment);
                if (file.exists()) {
                    ZLogger.v(String.format(Locale.US, "> %s\n%s\n%d", file.getPath(), file.getName(), Long.valueOf(file.length())));
                    return lastPathSegment;
                }
                String path = uri.getPath();
                if (TextUtils.isEmpty(path)) {
                    String path2 = uri.getPath();
                    File file2 = new File(path2);
                    if (file2.exists()) {
                        ZLogger.v(String.format(Locale.US, ">>> %s\n%s\n%d", file2.getPath(), file2.getName(), Long.valueOf(file2.length())));
                        return path2;
                    }
                    ZLogger.d(">>>file not exist");
                    return path2;
                }
                File file3 = new File(path);
                if (file3.exists()) {
                    ZLogger.v(String.format(Locale.US, ">>>> %s\n%s\n%d", file3.getPath(), file3.getName(), Long.valueOf(file3.length())));
                    return path;
                }
                String replace = path.replace("/file_share", "");
                File file4 = new File(replace);
                if (file4.exists()) {
                    ZLogger.v(String.format(Locale.US, ">>> %s\n%s\n%d", file4.getPath(), file4.getName(), Long.valueOf(file4.length())));
                    return replace;
                }
                return replace.replace("/file_share", "");
            }
            File file5 = new File(a2);
            if (file5.exists()) {
                ZLogger.v(String.format(Locale.US, ">> %s\n%s\n%d", file5.getPath(), file5.getName(), Long.valueOf(file5.length())));
                return a2;
            }
            ZLogger.d(">> file not exist");
            return a2;
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            ZLogger.v("file:" + uri.getPath());
            return uri.getPath();
        }
        return "";
    }

    public static String getSDCardAbsPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static File getSaveFile(String str, String str2) {
        return getSaveFile(str, str2, true);
    }

    public static File getSaveFolder(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSDCardAbsPath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        File file = new File(sb.toString());
        file.mkdirs();
        return file;
    }

    public static String getSavePath(String str) {
        return getSaveFolder(str).getAbsolutePath();
    }

    public static String getSavePathCompat(String str) {
        return getSaveFolder(str).getAbsolutePath();
    }

    public static String getSuffix(File file) {
        if (file != null && file.exists() && !file.isDirectory()) {
            return getSuffix(file.getName());
        }
        return "";
    }

    public static int getUrlFileSize(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            return contentLength;
        } catch (Exception e) {
            ZLogger.e(e.toString());
            return 0;
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGoogleCloudDocument(Uri uri) {
        return "com.google.android.apps.docs.storage".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isHuaweiShareUri(Uri uri) {
        return "com.huawei.filemanager.share.fileprovider".equals(uri.getAuthority());
    }

    public static boolean isHuaweiUri(Uri uri) {
        return "com.huawei.hidisk.fileprovider".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isNokia(Uri uri) {
        return "com.fihtdc.filemanager.provider".equals(uri.getAuthority());
    }

    public static boolean isOppoUri(Uri uri) {
        return "com.coloros.fileprovider".equals(uri.getAuthority());
    }

    public static boolean isTencentProvider(Uri uri) {
        return "com.tencent.mtt.fileprovider".equals(uri.getAuthority());
    }

    public static boolean makeDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static File getSaveFile(String str, String str2, boolean z) {
        return getSaveFile(getSavePath(str) + File.separator + str2, z);
    }

    public static File getSaveFile(String str, boolean z) {
        File file = new File(str);
        try {
            if (!file.exists() && z) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static String getSuffix(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(com.tenmeter.smlibrary.utils.FileUtils.FILE_EXTENSION_SEPARATOR)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(com.tenmeter.smlibrary.utils.FileUtils.FILE_EXTENSION_SEPARATOR);
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1).toLowerCase(Locale.US);
        }
        return "";
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0098 -> B:23:0x009b). Please report as a decompilation issue!!! */
    public static void copyFromAssetsToSdcard(AssetManager assetManager, boolean z, String str, String str2) {
        InputStream inputStream;
        ?? r0;
        FileOutputStream fileOutputStream;
        IOException e;
        InputStream inputStream2;
        FileNotFoundException e2;
        InputStream inputStream3;
        InputStream open;
        boolean exists = new File(str2).exists();
        if (!exists || z) {
            try {
                try {
                    try {
                        open = assetManager.open(str);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (FileNotFoundException e4) {
                    fileOutputStream = null;
                    e2 = e4;
                    inputStream3 = null;
                } catch (IOException e5) {
                    fileOutputStream = null;
                    e = e5;
                    inputStream2 = null;
                } catch (Throwable th) {
                    r0 = 0;
                    th = th;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = exists;
                inputStream = assetManager;
            }
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    ZLogger.v("source = " + str + ", dest = " + str2);
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    open.close();
                } catch (FileNotFoundException e7) {
                    e2 = e7;
                    inputStream3 = open;
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                } catch (IOException e9) {
                    e = e9;
                    inputStream2 = open;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                }
            } catch (FileNotFoundException e11) {
                fileOutputStream = null;
                e2 = e11;
                inputStream3 = open;
            } catch (IOException e12) {
                fileOutputStream = null;
                e = e12;
                inputStream2 = open;
            } catch (Throwable th3) {
                r0 = 0;
                th = th3;
                inputStream = open;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
    }
}
