package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.File copyUri2Cache(android.net.Uri r7) {
        /*
            java.lang.String r0 = "UriUtils"
            java.lang.String r1 = "copyUri2Cache() called"
            android.util.Log.d(r0, r1)
            r0 = 0
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            java.io.InputStream r7 = r1.openInputStream(r7)     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            android.app.Application r2 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            java.io.File r2 = r2.getCacheDir()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            r3.<init>()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            java.lang.String r4 = ""
            r3.append(r4)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            r3.append(r4)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            java.lang.String r2 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            com.blankj.utilcode.util.UtilsBridge.writeFileFromIS(r2, r7)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4a
            if (r7 == 0) goto L47
            r7.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r7 = move-exception
            r7.printStackTrace()
        L47:
            return r1
        L48:
            r0 = move-exception
            goto L61
        L4a:
            r1 = move-exception
            goto L53
        L4c:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L61
        L51:
            r1 = move-exception
            r7 = r0
        L53:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r7 == 0) goto L60
            r7.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r7 = move-exception
            r7.printStackTrace()
        L60:
            return r0
        L61:
            if (r7 == 0) goto L6b
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r7 = move-exception
            r7.printStackTrace()
        L6b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.copyUri2Cache(android.net.Uri):java.io.File");
    }

    public static Uri file2Uri(File file) {
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
        }
        return Uri.fromFile(file);
    }

    private static File getFileFromUri(Uri uri, String str) {
        return getFileFromUri(uri, null, null, str);
    }

    public static Uri res2Uri(String str) {
        return Uri.parse("android.resource://" + Utils.getApp().getPackageName() + "/" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] uri2Bytes(android.net.Uri r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L23 java.io.FileNotFoundException -> L28
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L23 java.io.FileNotFoundException -> L28
            java.io.InputStream r4 = r1.openInputStream(r4)     // Catch: java.lang.Throwable -> L23 java.io.FileNotFoundException -> L28
            byte[] r0 = com.blankj.utilcode.util.UtilsBridge.inputStream2Bytes(r4)     // Catch: java.lang.Throwable -> L1f java.io.FileNotFoundException -> L21
            if (r4 == 0) goto L1e
            r4.close()     // Catch: java.io.IOException -> L1a
            goto L1e
        L1a:
            r4 = move-exception
            r4.printStackTrace()
        L1e:
            return r0
        L1f:
            r0 = move-exception
            goto L40
        L21:
            r1 = move-exception
            goto L2a
        L23:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L40
        L28:
            r1 = move-exception
            r4 = r0
        L2a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = "UriUtils"
            java.lang.String r2 = "uri to bytes failed."
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r4 == 0) goto L3f
            r4.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r4 = move-exception
            r4.printStackTrace()
        L3f:
            return r0
        L40:
            if (r4 == 0) goto L4a
            r4.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r4 = move-exception
            r4.printStackTrace()
        L4a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.uri2Bytes(android.net.Uri):byte[]");
    }

    public static File uri2File(Uri uri) {
        if (uri == null) {
            return null;
        }
        File uri2FileReal = uri2FileReal(uri);
        if (uri2FileReal != null) {
            return uri2FileReal;
        }
        return copyUri2Cache(uri);
    }

    private static File uri2FileReal(Uri uri) {
        Uri uri2;
        File fileFromUri;
        String str;
        File file;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i2 = 0; i2 < 2; i2++) {
                String str2 = strArr[i2];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, "/"));
                    if (file2.exists()) {
                        Log.d("UriUtils", uri.toString() + org.apache.commons.text.oIX0oI.f33048oxoX + str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(Utils.getApp().getFilesDir().getAbsolutePath() + path.replace("/files_path/", "/"));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(Utils.getApp().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", "/"));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(Utils.getApp().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", "/"));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(Utils.getApp().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", "/"));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                Log.d("UriUtils", uri.toString() + org.apache.commons.text.oIX0oI.f33048oxoX + path);
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 0");
            return null;
        }
        if (DocumentsContract.isDocumentUri(Utils.getApp(), uri)) {
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str3 = split[0];
                if ("primary".equalsIgnoreCase(str3)) {
                    return new File(Environment.getExternalStorageDirectory() + "/" + split[1]);
                }
                StorageManager storageManager = (StorageManager) Utils.getApp().getSystemService("storage");
                try {
                    Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                    Method method = storageManager.getClass().getMethod("getVolumeList", null);
                    Method method2 = cls.getMethod("getUuid", null);
                    Method method3 = cls.getMethod("getState", null);
                    Method method4 = cls.getMethod("getPath", null);
                    Method method5 = cls.getMethod("isPrimary", null);
                    Method method6 = cls.getMethod("isEmulated", null);
                    Object invoke = method.invoke(storageManager, null);
                    int length = Array.getLength(invoke);
                    while (i < length) {
                        Object obj = Array.get(invoke, i);
                        Object obj2 = invoke;
                        if (!"mounted".equals(method3.invoke(obj, null))) {
                            if ("mounted_ro".equals(method3.invoke(obj, null))) {
                            }
                            i++;
                            invoke = obj2;
                        }
                        if ((!((Boolean) method5.invoke(obj, null)).booleanValue() || !((Boolean) method6.invoke(obj, null)).booleanValue()) && (str = (String) method2.invoke(obj, null)) != null && str.equals(str3)) {
                            return new File(method4.invoke(obj, null) + "/" + split[1]);
                        }
                        i++;
                        invoke = obj2;
                    }
                } catch (Exception e) {
                    Log.d("UriUtils", uri.toString() + " parse failed. " + e.toString() + " -> 1_0");
                }
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_0");
                return null;
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (TextUtils.isEmpty(documentId)) {
                    Log.d("UriUtils", uri.toString() + " parse failed(id is null). -> 1_1");
                    return null;
                }
                if (documentId.startsWith("raw:")) {
                    return new File(documentId.substring(4));
                }
                if (documentId.startsWith("msf:")) {
                    documentId = documentId.split(":")[1];
                }
                try {
                    long parseLong = Long.parseLong(documentId);
                    String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
                    while (i < 3) {
                        try {
                            fileFromUri = getFileFromUri(ContentUris.withAppendedId(Uri.parse(strArr2[i]), parseLong), "1_1");
                        } catch (Exception unused) {
                        }
                        if (fileFromUri != null) {
                            return fileFromUri;
                        }
                        i++;
                    }
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_1");
                } catch (Exception unused2) {
                }
                return null;
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str4 = split2[0];
                if ("image".equals(str4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (MimeTypes.BASE_TYPE_AUDIO.equals(str4)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_2");
                    return null;
                }
                return getFileFromUri(uri2, "_id=?", new String[]{split2[1]}, "1_2");
            }
            if ("content".equals(scheme)) {
                return getFileFromUri(uri, "1_3");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_4");
            return null;
        }
        if ("content".equals(scheme)) {
            return getFileFromUri(uri, "2");
        }
        Log.d("UriUtils", uri.toString() + " parse failed. -> 3");
        return null;
    }

    private static File getFileFromUri(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor query = Utils.getApp().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (query == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            }
            if (query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("_data");
                if (columnIndex > -1) {
                    return new File(query.getString(columnIndex));
                }
                Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
                return null;
            }
            Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            query.close();
        }
    }
}
