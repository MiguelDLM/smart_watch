package com.bytedance.pangle.util.b.a;

import XXO0.oIX0oI;
import com.bytedance.pangle.util.b.b.d;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class a {
    public static d a(String str) {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                if (randomAccessFile2.length() >= 22) {
                    d dVar = new d(str);
                    long length = randomAccessFile2.length();
                    if (length >= 22) {
                        long j = length - 22;
                        randomAccessFile2.seek(j);
                        if (dVar.c.a(randomAccessFile2) != 101010256) {
                            j = b(randomAccessFile2, dVar);
                        }
                        randomAccessFile2.seek(j + 4);
                        com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
                        randomAccessFile2.skipBytes(6);
                        bVar.f10630a = dVar.c.b(randomAccessFile2);
                        randomAccessFile2.skipBytes(4);
                        bVar.b = dVar.c.a(randomAccessFile2);
                        dVar.b = bVar;
                        if (bVar.f10630a == 0) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException unused) {
                            }
                            return dVar;
                        }
                        a(randomAccessFile2, dVar);
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused2) {
                        }
                        return dVar;
                    }
                    throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
                }
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static long b(RandomAccessFile randomAccessFile, d dVar) {
        long length = randomAccessFile.length() - 22;
        long j = 65536;
        if (randomAccessFile.length() < 65536) {
            j = randomAccessFile.length();
        }
        while (j > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.c.a(randomAccessFile) == 101010256) {
                return length;
            }
            j--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.b;
        long j = bVar.b;
        long j2 = bVar.f10630a;
        randomAccessFile.seek(j);
        for (int i = 0; i < j2; i++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.c.a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                cVar.f10631a = dVar.c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.b = dVar.c.a(randomAccessFile);
                cVar.c = dVar.c.a(randomAccessFile);
                cVar.d = dVar.c.a(randomAccessFile);
                int b = dVar.c.b(randomAccessFile);
                cVar.e = b;
                cVar.f = dVar.c.b(randomAccessFile);
                int b2 = dVar.c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.i = dVar.c.a(randomAccessFile);
                if (b > 0) {
                    byte[] bArr = new byte[b];
                    randomAccessFile.readFully(bArr);
                    cVar.h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f);
                    if (b2 > 0) {
                        randomAccessFile.skipBytes(b2);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.i + 28);
                    cVar.g = dVar.c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + oIX0oI.I0Io.f4095I0Io);
            }
        }
        aVar.f10629a = arrayList;
        dVar.f10632a = aVar;
    }
}
