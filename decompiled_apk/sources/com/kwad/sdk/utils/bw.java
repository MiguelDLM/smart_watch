package com.kwad.sdk.utils;

import XXO0.oIX0oI;
import android.text.TextUtils;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes11.dex */
public final class bw {

    /* loaded from: classes11.dex */
    public static class a extends ZipOutputStream {
        private Map<String, Integer> aSr;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aSr = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aSr.get(name);
            if (num2 != null && num2.intValue() > 0) {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", oIX0oI.I0Io.f4096II0xO0 + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            } else {
                zipEntry2 = zipEntry;
                num = 1;
            }
            this.aSr.put(name, num);
            super.putNextEntry(zipEntry2);
        }
    }

    private static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            byte[] bArr = new byte[4096];
            a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i = 0; i <= 0; i++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.e.c.e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                }
            }
            aVar2.flush();
            aVar2.closeEntry();
            com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String hl(String str) {
        if (TextUtils.isEmpty(str) && str.length() > 1) {
            return str;
        }
        if (!TextUtils.isEmpty(str) && str.charAt(0) == '.') {
            return str.substring(1);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        ZipInputStream zipInputStream;
        Closeable closeable;
        Closeable closeable2;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            if (nextEntry.isDirectory()) {
                                new File(str + "/" + name).mkdirs();
                            } else {
                                File file2 = new File(str + "/" + name);
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                    while (true) {
                                        try {
                                            try {
                                                int read = zipInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            } catch (IOException e2) {
                                                e = e2;
                                                closeable = fileOutputStream;
                                                com.kwad.sdk.core.e.c.e("ZipUtils", "error unZip when write", e);
                                                closeable2 = closeable;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                                                zipInputStream.closeEntry();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zipInputStream2 = fileOutputStream;
                                            com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                                            throw th;
                                        }
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.getFD().sync();
                                    closeable2 = fileOutputStream;
                                } catch (IOException e3) {
                                    e = e3;
                                    closeable = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                                zipInputStream.closeEntry();
                            }
                        }
                    } else {
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return true;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                zipInputStream2 = zipInputStream;
                com.kwad.sdk.core.e.c.e("ZipUtils", "error unZip", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                zipInputStream2 = zipInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file != null && file.exists()) {
            String absolutePath = file.getAbsolutePath();
            if (!absolutePath.endsWith(OTAManager.OTA_ZIP_SUFFIX)) {
                if (zip(file, new File(absolutePath + OTAManager.OTA_ZIP_SUFFIX))) {
                    file.delete();
                }
            }
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        File[] listFiles;
        BufferedInputStream bufferedInputStream;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.e.c.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
            return;
        }
        if (!file.exists()) {
            com.kwad.sdk.core.e.c.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
            return;
        }
        String hl = TextUtils.isEmpty(str) ? hl(file.getName()) : str + File.separator + hl(file.getName());
        if (file.isFile()) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e) {
                e = e;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry(hl));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, bArr.length);
                    if (-1 != read) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream2 = bufferedInputStream;
                com.kwad.sdk.core.e.c.e("ZipUtils", "error doZip", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                throw e;
            }
        } else {
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                a(zipOutputStream, file2, hl, bArr);
            }
        }
    }
}
