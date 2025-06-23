package com.sifli.siflidfu;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes11.dex */
public class FileProcess {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "dfuFileProcess";
    private static String mLogString;

    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean LoadListFile(java.util.ArrayList<com.sifli.siflidfu.OTAFile> r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "temp_list.txt"
            java.util.Iterator r1 = r10.iterator()
        L6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L1f
            java.lang.Object r2 = r1.next()
            com.sifli.siflidfu.OTAFile r2 = (com.sifli.siflidfu.OTAFile) r2
            java.lang.String r3 = r2.getFileName()
            java.lang.String r4 = "ota_file_list_order.txt"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L6
            goto L20
        L1f:
            r2 = 0
        L20:
            java.lang.String r1 = "dfuFileProcess"
            r3 = 0
            if (r2 != 0) goto L2b
            java.lang.String r10 = "fail to find list file"
            android.util.Log.e(r1, r10)
            return r3
        L2b:
            r4 = 1
            r2.setFileIndex(r4)
            java.io.FileOutputStream r5 = r11.openFileOutput(r0, r3)     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            byte[] r2 = r2.getFileData()     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            r5.write(r2)     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            r5.close()     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            java.io.FileInputStream r11 = r11.openFileInput(r0)     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            r0.<init>(r11)     // Catch: java.io.IOException -> L8b java.io.FileNotFoundException -> L8e
            r2 = 2
            r5 = 1
        L48:
            java.lang.String r6 = r0.readLine()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            if (r6 == 0) goto L84
            java.lang.String r7 = "/"
            int r7 = r6.lastIndexOf(r7)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            r8 = -1
            if (r7 == r8) goto L81
            int r7 = r7 + 1
            java.lang.String r6 = r6.substring(r7)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            java.util.Iterator r7 = r10.iterator()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
        L61:
            boolean r8 = r7.hasNext()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            if (r8 == 0) goto L81
            java.lang.Object r8 = r7.next()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            com.sifli.siflidfu.OTAFile r8 = (com.sifli.siflidfu.OTAFile) r8     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            java.lang.String r9 = r8.getFileName()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            boolean r9 = r9.equals(r6)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            if (r9 == 0) goto L61
            r8.setFileIndex(r2)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            int r5 = r5 + 1
            goto L81
        L7d:
            r11 = move-exception
            goto L91
        L7f:
            r11 = move-exception
            goto L95
        L81:
            int r2 = r2 + 1
            goto L48
        L84:
            r0.close()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            r11.close()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            goto L98
        L8b:
            r11 = move-exception
            r5 = 1
            goto L91
        L8e:
            r11 = move-exception
            r5 = 1
            goto L95
        L91:
            r11.printStackTrace()
            goto L98
        L95:
            r11.printStackTrace()
        L98:
            int r11 = r10.size()
            if (r11 == r5) goto Lbf
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "list file process error, size "
            r11.append(r0)
            int r10 = r10.size()
            r11.append(r10)
            java.lang.String r10 = ", count "
            r11.append(r10)
            r11.append(r5)
            java.lang.String r10 = r11.toString()
            android.util.Log.e(r1, r10)
            return r3
        Lbf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sifli.siflidfu.FileProcess.LoadListFile(java.util.ArrayList, android.content.Context):boolean");
    }

    public static void copyFile(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            copyStream(openInputStream, fileOutputStream);
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } finally {
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e) {
            Log.e(TAG, "out close error", e);
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e2) {
            Log.e(TAG, "in close error", e2);
        }
        return i;
    }

    public static void deleteFolderFile(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFolderFile(file2.getAbsolutePath(), true);
                }
            }
            if (z) {
                if (!file.isDirectory()) {
                    file.delete();
                    return;
                }
                File[] listFiles = file.listFiles();
                Objects.requireNonNull(listFiles);
                if (listFiles.length == 0) {
                    file.delete();
                }
            }
        }
    }

    public static int getFileBlockCount(ArrayList<OTAFile> arrayList, int i) {
        int fileLength;
        Iterator<OTAFile> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            OTAFile next = it.next();
            next.getFileLength();
            if (next.getFileLength() % i == 0) {
                fileLength = next.getFileLength() / i;
            } else {
                fileLength = (next.getFileLength() / i) + 1;
            }
            i2 += fileLength;
        }
        return i2;
    }

    public static String getFileName(Uri uri) {
        String path;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(lastIndexOf + 1);
    }

    public static String getFilePathFromURI(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file")) {
            if (scheme.equals("content")) {
                File externalFilesDir = context.getExternalFilesDir(null);
                String fileName = getFileName(uri);
                if (TextUtils.isEmpty(fileName)) {
                    return null;
                }
                File file = new File(externalFilesDir + File.separator + fileName);
                copyFile(context, uri, file);
                return file.getAbsolutePath();
            }
            throw new InvalidParameterException("不支持的Uri类型:" + scheme);
        }
        return uri.getPath();
    }

    public static int getFileSize(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            int available = fileInputStream.available();
            fileInputStream.close();
            return available;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<OTAFile> getImageFile(ArrayList<DFUImagePath> arrayList, Context context, int i) {
        byte[] openFile;
        ArrayList<OTAFile> arrayList2 = new ArrayList<>();
        mLogString = null;
        Iterator<DFUImagePath> it = arrayList.iterator();
        while (it.hasNext()) {
            DFUImagePath next = it.next();
            String imagePath = next.getImagePath();
            Uri imageUri = next.getImageUri();
            int imageType = next.getImageType();
            if (imageType >= -1) {
                if (imageUri != null) {
                    imagePath = getFilePathFromURI(context, imageUri);
                    Log.d(TAG, "image id " + imageType + ", md5: " + getMD5(imagePath));
                }
                if (imagePath == null) {
                    return null;
                }
                if (i != 0 && imageType != -1) {
                    openFile = null;
                } else {
                    openFile = openFile(context, imagePath);
                    if (openFile == null) {
                        mLogString += ", id " + imageType + " load fail\n";
                        Log.e(TAG, "id " + imageType + " open fail");
                    }
                }
                OTAFile oTAFile = new OTAFile(openFile, imageType);
                oTAFile.setFilePath(imagePath);
                arrayList2.add(oTAFile);
            }
        }
        return arrayList2;
    }

    public static String getMD5(String str) {
        int i;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString().toLowerCase();
        } catch (IOException e) {
            e = e;
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<OTAFile> getNandResFiles(String str, ArrayList<OTAFile> arrayList, String str2, Context context) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                String absolutePath = file2.getAbsolutePath();
                arrayList.add(new OTAFile(absolutePath.substring(str2.length()), openFile(context, absolutePath), file2.getName()));
            } else if (file2.isDirectory()) {
                getNandResFiles(file2.getAbsolutePath(), arrayList, str2, context);
            }
        }
        return arrayList;
    }

    public static String getmLogString() {
        return mLogString;
    }

    public static byte[] openFile(Context context, String str) {
        File file = new File(str);
        context.getResources().getAssets();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.ISO_8859_1);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = bufferedReader.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return byteArray;
                }
            }
        } catch (FileNotFoundException unused) {
            Log.e(TAG, str + " doesn't found!");
            mLogString += str + " doesn't found!";
            return null;
        } catch (IOException e) {
            Log.e(TAG, str + " read exception, " + e.getMessage());
            mLogString += str + " read exception, " + e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] openFilePartly(Context context, String str, int i, int i2) {
        File file = new File(str);
        byte[] bArr = new byte[i2];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.skip(i);
            fileInputStream.read(bArr, 0, i2);
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
    
        throw new java.lang.SecurityException("zip path have traversal characters path");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.util.zip.ZipInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x00e8 -> B:32:0x0143). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void unzipFolder(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sifli.siflidfu.FileProcess.unzipFolder(java.lang.String, java.lang.String):void");
    }
}
