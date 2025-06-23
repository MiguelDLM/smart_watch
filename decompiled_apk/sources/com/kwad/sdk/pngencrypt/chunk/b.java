package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes11.dex */
public final class b {
    public static final byte[] aNb = gr("IHDR");
    public static final byte[] aNc = gr("PLTE");
    public static final byte[] aNd = gr("IDAT");
    public static final byte[] aNe = gr("IEND");
    private static byte[] aNf = new byte[4096];
    public static Pattern aNg = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream;
        InflaterInputStream inflaterInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
        try {
            i(inflaterInputStream, byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
            return byteArray;
        } catch (Exception e4) {
            e = e4;
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            try {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                return new byte[0];
            } catch (Throwable th4) {
                th = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.aMJ);
    }

    public static String e(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.aMK);
    }

    public static byte[] gr(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.aMJ);
    }

    public static boolean gs(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean gt(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gu(String str) {
        if (!Character.isUpperCase(str.charAt(3))) {
            return true;
        }
        return false;
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aMJ);
    }

    public static String j(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aMK);
    }

    private static void i(InputStream inputStream, OutputStream outputStream) {
        synchronized (aNf) {
            while (true) {
                try {
                    int read = inputStream.read(aNf);
                    if (read > 0) {
                        outputStream.write(aNf, 0, read);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String i(byte[] bArr, int i) {
        if (bArr != null && bArr.length >= 8) {
            return d(bArr, 4, 4);
        }
        return LocationInfo.NA;
    }
}
