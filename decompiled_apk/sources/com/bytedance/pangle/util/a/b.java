package com.bytedance.pangle.util.a;

import android.util.Pair;
import com.bytedance.pangle.util.f;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f10625a = "";

    public static String[] a(File file) {
        String str;
        ByteBuffer b;
        String str2 = "";
        try {
            b = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (b.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer a2 = a(b, b.capacity() - 24);
            int i = 0;
            while (a2.hasRemaining()) {
                i++;
                if (a2.remaining() >= 8) {
                    long j = a2.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int position = a2.position() + i2;
                    if (i2 > a2.remaining()) {
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
                    }
                    int i3 = a2.getInt();
                    if (i3 == -262969152) {
                        f10625a = BleDeviceInfo.PROTOTYPE_V3;
                    } else if (i3 == 1896449818) {
                        f10625a = "V2";
                    } else {
                        a2.position(position);
                    }
                    str2 = f.a(b.array());
                    str = "";
                    break;
                }
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            str = "without v2 & v3 signature.";
            return new String[]{str2, f10625a, str};
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static ByteBuffer b(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        Pair<ByteBuffer, Long> a2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() >= 22 && (a2 = c.a(randomAccessFile, 0)) == null) {
                a2 = c.a(randomAccessFile, 65535);
            }
            if (a2 != null) {
                ByteBuffer byteBuffer = (ByteBuffer) a2.first;
                long longValue = ((Long) a2.second).longValue();
                long j = longValue - 20;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new Exception("ZIP64 APK not supported");
                    }
                }
                c.a(byteBuffer);
                long a3 = c.a(byteBuffer, byteBuffer.position() + 16);
                if (a3 <= longValue) {
                    c.a(byteBuffer);
                    if (c.a(byteBuffer, byteBuffer.position() + 12) + a3 == longValue) {
                        if (a3 >= 32) {
                            ByteBuffer allocate = ByteBuffer.allocate(24);
                            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                            allocate.order(byteOrder);
                            randomAccessFile.seek(a3 - allocate.capacity());
                            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                                long j2 = allocate.getLong(0);
                                if (j2 >= allocate.capacity() && j2 <= 2147483639) {
                                    int i = (int) (8 + j2);
                                    long j3 = a3 - i;
                                    if (j3 >= 0) {
                                        ByteBuffer allocate2 = ByteBuffer.allocate(i);
                                        allocate2.order(byteOrder);
                                        randomAccessFile.seek(j3);
                                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                                        long j4 = allocate2.getLong(0);
                                        if (j4 == j2) {
                                            ByteBuffer byteBuffer2 = (ByteBuffer) Pair.create(allocate2, Long.valueOf(j3)).first;
                                            randomAccessFile.close();
                                            return byteBuffer2;
                                        }
                                        throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                                    }
                                    throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
                                }
                                throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                            }
                            throw new Exception("No APK Signing Block before ZIP Central Directory");
                        }
                        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a3)));
                    }
                    throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                throw new Exception("ZIP Central Directory offset out of range: " + a3 + ". ZIP End of Central Directory offset: " + longValue);
            }
            throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        if (i >= 8) {
            int capacity = byteBuffer.capacity();
            if (i <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i + " < 8");
    }
}
