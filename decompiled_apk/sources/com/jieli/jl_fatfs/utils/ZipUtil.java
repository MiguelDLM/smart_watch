package com.jieli.jl_fatfs.utils;

import com.jieli.jl_rcsp.util.WatchFileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes10.dex */
public class ZipUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17819a = "ZipUtil";

    public static void a(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        } else {
            String[] list = file.list();
            if (list != null) {
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    a(str, str2 + File.separator + str3, zipOutputStream);
                }
            }
        }
    }

    public static List<File> getFileList(String str, boolean z, boolean z2) throws Exception {
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    File file = new File(name.substring(0, name.length() - 1));
                    if (z) {
                        arrayList.add(file);
                    }
                } else {
                    File file2 = new File(name);
                    if (z2) {
                        arrayList.add(file2);
                    }
                }
            } else {
                zipInputStream.close();
                return arrayList;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0133 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void unZipFolder(java.lang.String r6, java.lang.String r7) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_fatfs.utils.ZipUtil.unZipFolder(java.lang.String, java.lang.String):void");
    }

    public static InputStream upZip(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void zipFolder(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    public static void unZipFolder(String str, String str2, String str3) throws Exception {
        File file = new File(str2, str3);
        if (file.exists()) {
            WatchFileUtil.deleteFile(file.getPath());
        }
        if (file.mkdirs()) {
            str2 = file.getPath();
        }
        unZipFolder(str, str2);
    }
}
