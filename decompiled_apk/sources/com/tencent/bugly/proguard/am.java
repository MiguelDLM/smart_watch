package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public final class am {

    /* loaded from: classes13.dex */
    public static class oIX0oI implements FilenameFilter {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f26545Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f26546XO;

        public oIX0oI(String str, String str2) {
            this.f26546XO = str;
            this.f26545Oo = str2;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            if (str == null || !str.startsWith(this.f26546XO) || !str.endsWith(this.f26545Oo)) {
                return false;
            }
            return true;
        }
    }

    public static boolean a(File file, String str, long j, boolean z) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            boolean a2 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j);
            bufferedWriter.close();
            return a2;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static List<File> b(String str, String str2, String str3, long j) {
        ArrayList arrayList = new ArrayList();
        if (str2 != null && str3 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles(new oIX0oI(str2, str3));
                    if (listFiles != null && listFiles.length != 0) {
                        return a(listFiles, str2, str3, currentTimeMillis - j);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    al.a(th);
                    return arrayList;
                }
            }
            return arrayList;
        }
        al.d("prefix %s and/or postfix %s is null.", str2, str3);
        return arrayList;
    }

    private static boolean a(Writer writer, char[] cArr, int i, long j, long j2) {
        if (j >= j2) {
            return false;
        }
        try {
            if ((i * 2) + j <= j2) {
                writer.write(cArr, 0, i);
            } else {
                writer.write(cArr, 0, (int) ((j2 - j) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            al.a(e);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, long j) {
        try {
            int i = 0;
            for (File file : b(str, str2, str3, j)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a2 = a(file.getName(), str, str2);
            if (a2 >= 0 && 0 <= a2 && a2 <= j) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1L;
    }

    public static boolean a(String str, String str2, int i) {
        boolean z = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j = i;
                if (file.length() >= j) {
                    z = false;
                }
                return a(file, str2, j, z);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
