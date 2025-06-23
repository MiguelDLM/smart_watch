package com.baidu.sec.privacy.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.bluetrum.fota.manager.OtaCommandGenerator;
import com.garmin.fit.Fit;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import okio.Utf8;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10020a = a(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    public static final byte[] b = {34, 120, 93, 28, 86, 125, 58, -72, 104, -79, 40, 125, 82, -26, -85, 124, -100, -25, 25, 17, 88, -127, -116, -8, 0, 33, 70, -4, -1, OtaCommandGenerator.CMD_GET_INFO_TLV, Fit.f11239xXoOI00O, -85, 5, 81, -70, -27, -98, -7, 42, 124, -74, 47, -120, 124, 20, -14, 74, -107, Fit.f11239xXoOI00O, 116, -101, -8, -89, -71, 99, -124, 9, 55, 107, -18, -114, 5, -79, 58, 64, OtaCommandGenerator.CMD_GET_INFO_TLV, -51, 78, -29, 69, -51, Utf8.REPLACEMENT_BYTE, -77, -73, 106, 43, 10, -95, -98, OtaCommandGenerator.CMD_NOTIFY_STATUS, -50, -87, -98, -91, -61, -39, 57, -75, -31, -85, 80, 89, 42, -25, 45, -119, -18, -90, -56, -101, -23, 59, -91, -52, 124, 83, IIIxO.oIX0oI.f236II0XooXoX, -20, 119, -105, -74, 102, -27, 86, 17, -15, OtaCommandGenerator.CMD_GET_INFO_TLV, 75, -59, 123, -24, 42, 117, 48, 11, 11, -127, 9, 12, -57, 93, -92, -30, -47, -4, 109, -67, 101, 38, -91, -73, -75, -25, 66, -41, -43, -28, -84, -50, 33, Fit.f11227x0OxxIOxX, 10, -94, 5, -49, -36, 64, -101, 87, -12, 78, 35, -44, 94, -53, -28, 115, 107, 117, -81, -6, 51, 86, 40, -108, -80, 110, -71, -30, -9, 49, -49, 100, 50, -41, 20, -97, 32, -34, -14, 60, -25, 53, -97, 35, -37, -122, -122, -80, 41, 54, 0, -9, OtaCommandGenerator.CMD_GET_INFO, 55, 90, 17, 41, 82, -49, -73, 51, 9, 56, 92, 97, -126, 85, 4, -114, -48, 109, -57, 96, -31, -102, -71, -87, -76, -77, -52, 58, 107, 66, -103, 35, 5, 47, OtaCommandGenerator.CMD_NOTIFY_STATUS, 39, -58, 101, 77, -21, 4, -59, 41, -3, 35, -36, 44, 109, 40, OtaCommandGenerator.CMD_GET_INFO, 115, 23};
    public static final byte[] c = {0, -70, 42, -20, -46, -12, -1, -114, 74, -47, 126, -90, 23, -7, -79, -117, -90, 82, 94, 22, -56, 34, -71, -22, 52, 103, TransportLayerPacket.SYNC_WORD, -90, -58, -3, 60, -16, 92, 55, 73, -24, 47, -125, 16, 17, OtaCommandGenerator.CMD_OTA_INFO, -42, 96, 93, IIIxO.oIX0oI.f236II0XooXoX, -90, 43, -72, -47, 68, 59, -106, -59, 67, 103, 34, 69, -88, -92, -19, -15, OtaCommandGenerator.CMD_NOTIFY_STATUS, 58, 17, 94, 38, -48, 35, -62, 23, -56, Fit.f11227x0OxxIOxX, -2, 43, 65, -119, -50, -59, -90, -119, 17, -66, -99, 90, -71, OtaCommandGenerator.CMD_GET_INFO, -64, 10, -30, -64, 70, 52, 97, 33, 114, -15, Utf8.REPLACEMENT_BYTE, 71, -54, -54, -76, -6, 79, -53, 24, 79, -81, 24, -48, 1, 23, -63, 89, TransportLayerPacket.SYNC_WORD, -83, -121, -1, 42, Byte.MAX_VALUE, -46, 93, 3, 77, -39, -81, 123, 114, 20, 89};
    public static final byte[] d = {0, -113, 121, 53, -39, -71, TransportLayerPacket.SYNC_WORD, -23, Fit.f11227x0OxxIOxX, -85, -19, -120, 122, -49, 73, 81, -74, -13, 46, -59, -98, 59, -81, 55, 24, -24, -22, -60, -106, 31, 62, -3, 54, 6, -25, 67, 81, -87, -60, 24, 51, 57, -72, 9, -25, -62, -82, 28, 83, -101, -89, 71, 91, -123, -48, 17, -83, -72, -76, 121, -121, 117, 73, -124, 105, 92, -84, 14, -113, 20, -77, 54, 8, 40, -94, 47, -6, 39, 17, 10, IIIxO.oIX0oI.f236II0XooXoX, 98, -87, -109, 69, 52, 9, OtaCommandGenerator.CMD_OTA_INFO, -2, 105, 108, 70, 88, -8, 75, -35, 32, -127, -100, 55, 9, OtaCommandGenerator.CMD_OTA_INFO, 16, 87, -79, -107, -83, -51, 0, 35, IIIxO.oIX0oI.f236II0XooXoX, -70, 84, -124, -74, 41, 31, -99, 100, -114, -8, -125, 68, -122, 119, -105, -100, -20, 4, -76, 52, -90, -84, 46, 117, -23, -104, 93, -30, IIIxO.oIX0oI.f236II0XooXoX, -80, 41, 47, -63, 17, -116, -97, -6, -99, -127, -127, -25, 51, -115, -73, OtaCommandGenerator.CMD_GET_INFO_TLV, -73, 48, -41, -71, -29, 73, 89, 47, 104, 9, -104, 114, 21, 57, 21, -22, IIIxO.oIX0oI.f236II0XooXoX, 107, -117, 70, 83, -58, 51, 69, -113, Byte.MIN_VALUE, 59, 50, -92, -62, -32, -14, 114, OtaCommandGenerator.CMD_NOTIFY_STATUS, 37, 110, 78, Utf8.REPLACEMENT_BYTE, -118, 59, 8, 56, -95, -60, 80, -28, -31, -116, 26, 41, -93, 125, -33, 94, -95, 67, -34, 75, 102, -1, 4, OtaCommandGenerator.CMD_NOTIFY_STATUS, 62, -43, -49, 22, 35, -31, 88, -44, -121, -58, 8, -23, Byte.MAX_VALUE, 33, 28, -40, 29, -54, 35, -53, 110, 56, 7, 101, -8, 34, -29, 66, -66, 72, 76, 5, 118, 57, 57, 96, 28, -42, 103};

    public static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static String b(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        try {
            File a2 = com.baidu.sec.privacy.a.b.a(context).a(context.getFilesDir().getParent() + "/.helios/ids/aid/aid.dat");
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    byte[] bArr = new byte[32];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(a(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())), "UTF-8");
                    try {
                        fileInputStream2.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        c.a(th);
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    try {
                        c.a(th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                c.a(th3);
                                return "";
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            return "";
                        }
                        return "";
                    } catch (Throwable th4) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th5) {
                                c.a(th5);
                                throw th4;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context) {
        try {
            IBinder binder = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".helios.ipc.default"), "_method_get_bridge", "", new Bundle()).getBinder("bridge_binder");
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.baidu.helios.bridge.multiprocess.IMultiProcessBridge");
            obtain.writeString("aid");
            binder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                return ((Bundle) Bundle.CREATOR.createFromParcel(obtain2)).getString("id");
            }
        } catch (Throwable th) {
            c.a(th);
        }
        return "";
    }

    public static byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= 12) {
            byte[] bArr = new byte[12];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            a(bArr, a(), allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer2.remaining();
        int i = remaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer a2 = a(bArr, bArr2, i3 + 32);
            if (i3 == i) {
                a(byteBuffer, byteBuffer2, a2, remaining % 64);
            } else {
                a(byteBuffer, byteBuffer2, a2, 64);
            }
        }
    }

    public static ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
        int[] a2 = a(a(bArr), a(bArr2), i);
        int[] iArr = (int[]) a2.clone();
        a(iArr);
        for (int i2 = 0; i2 < a2.length; i2++) {
            a2[i2] = a2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(a2, 0, 16);
        return order;
    }

    public static void a(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    public static void a(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int a2 = a(i5 ^ iArr[i4], 16);
        iArr[i4] = a2;
        int i6 = iArr[i3] + a2;
        iArr[i3] = i6;
        int a3 = a(iArr[i2] ^ i6, 12);
        iArr[i2] = a3;
        int i7 = iArr[i] + a3;
        iArr[i] = i7;
        int a4 = a(iArr[i4] ^ i7, 8);
        iArr[i4] = a4;
        int i8 = iArr[i3] + a4;
        iArr[i3] = i8;
        iArr[i2] = a(iArr[i2] ^ i8, 7);
    }

    public static byte[] a() {
        return new BigInteger(b).modPow(new BigInteger(c), new BigInteger(d)).toByteArray();
    }

    public static int[] a(int[] iArr, int[] iArr2, int i) {
        if (iArr.length == 3) {
            int[] iArr3 = new int[16];
            a(iArr3, iArr2);
            iArr3[12] = i;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
    }

    public static int[] a(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f10020a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }
}
