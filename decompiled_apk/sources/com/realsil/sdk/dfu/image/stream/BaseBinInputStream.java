package com.realsil.sdk.dfu.image.stream;

import androidx.core.view.ViewCompat;
import com.garmin.fit.IXXIXx00I;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.core.utility.StringUtils;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.f.a;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public abstract class BaseBinInputStream extends BufferedInputStream {
    public static final int AUTH_HEADER_BUF_SIZE = 304;
    public static final int COMPARE_VERSION_EQUAL = 0;
    public static final int COMPARE_VERSION_HIGH = 1;
    public static final int COMPARE_VERSION_LOW = -1;
    public static final int DFU_HEADER_BUF_SIZE = 12;
    public static final int HEADER_SIZE = 12;
    public static final int IMAGE_SIZE_MECHANISM_IMAGE_HEADER = 0;
    public static final int IMAGE_SIZE_MECHANISM_MP_HEADER_DATA_LENGTH = 1;
    public static final int IMAGE_SIZE_MECHANISM_MP_HEADER_IMAGE_SIZE = 2;
    public static int MPHEADER_PARSE_FORMAT = 1;
    public static int MPHEADER_PARSE_HEADER = 0;
    public static int MPHEADER_PARSE_MARK = 1;
    public static final int MP_HEADER_BUF_SIZE = 512;
    public static final int PACKET_SIZE_DEF = 20;
    public static final int SHA256_LENGTH = 32;
    public int A;
    public int B;
    public byte[] C;
    public String D;
    public int E;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19544a;
    public boolean b;
    public final byte[] c;
    public int customizeId;
    public List<a> d;
    public int e;
    public int f;
    public final byte[] g;
    public int h;
    public boolean i;
    public byte icType;
    public int imageVersion;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;
    public int otaTempBufferCheckOrder;
    public int otaVersion;
    public int p;
    public byte q;
    public short r;
    public int s;
    public byte[] t;
    public byte[] u;
    public int v;
    public int versionCheckOrder;
    public final int w;
    public int x;
    public int y;
    public int z;

    public BaseBinInputStream(InputStream inputStream, int i, int i2) throws IOException {
        super(new BufferedInputStream(inputStream));
        this.f19544a = true;
        this.b = RtkDfu.VDBG;
        this.otaVersion = 0;
        this.k = 0;
        this.n = "";
        this.s = 0;
        this.v = 255;
        this.y = 1;
        this.z = 1;
        this.versionCheckOrder = 254;
        this.otaTempBufferCheckOrder = 1;
        this.A = 0;
        this.B = 0;
        this.D = "";
        this.E = 0;
        this.f19544a = RtkDfu.DEBUG_ENABLE;
        this.s = i;
        this.w = i2;
        this.c = new byte[512];
        this.g = new byte[12];
        this.t = new byte[12];
        this.x = 0;
        c();
    }

    public static int toUnsigned(short s) {
        return s & OX00O0xII.f29066Oxx0xo;
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public boolean b() {
        List<a> list = this.d;
        return list != null && list.size() > 0;
    }

    public final void c() throws IOException {
        if (MPHEADER_PARSE_FORMAT == MPHEADER_PARSE_MARK && markSupported()) {
            g();
        } else {
            h();
        }
    }

    public final void d() throws IOException {
        if (this.b) {
            ZLogger.v("dfuHeader=" + DataConverter.bytes2Hex(this.t));
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.t, 0, 12);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        a(wrap);
    }

    public final void e() {
        if (this.b) {
            ZLogger.v("mpHeaderBuf=" + DataConverter.bytes2Hex(this.c));
        }
        List<a> a2 = a.a(this.c);
        this.d = a2;
        if (a2 != null && a2.size() > 0) {
            for (a aVar : this.d) {
                byte[] a3 = aVar.a();
                if (a3 != null && a3.length > 0) {
                    int b = aVar.b();
                    if (b != 27) {
                        if (b != 29) {
                            if (b != 30) {
                                if (b != 1) {
                                    if (b != 2) {
                                        if (b != 3) {
                                            if (b != 4) {
                                                switch (b) {
                                                    case 17:
                                                        this.otaVersion = a3[0] & 255;
                                                        break;
                                                    case 18:
                                                        if (a3.length >= 2) {
                                                            this.h = ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                            this.i = true;
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    case 19:
                                                        if (a3.length >= 4) {
                                                            this.o = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    case 20:
                                                        if (a3.length >= 4) {
                                                            int i = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                            this.f = i;
                                                            if (this.k < 2) {
                                                                this.k = 2;
                                                                this.j = i - 12;
                                                                break;
                                                            } else {
                                                                break;
                                                            }
                                                        } else {
                                                            break;
                                                        }
                                                    case 21:
                                                        if (a3.length >= 2) {
                                                            this.p = ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    case 22:
                                                        if (a3.length >= 4) {
                                                            this.imageVersion = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                }
                                            } else if (a3.length >= 4) {
                                                int i2 = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                                this.e = i2;
                                                if (this.k < 1) {
                                                    this.k = 1;
                                                    this.j = i2 - 12;
                                                }
                                            }
                                        } else {
                                            this.n = b(a3);
                                        }
                                    } else if (a3.length != 4) {
                                        ZLogger.d("invalid sub header, " + aVar.toString());
                                        this.d = null;
                                    } else {
                                        this.m = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                    }
                                } else if (a3.length != 2) {
                                    ZLogger.d("invalid sub header, " + aVar.toString());
                                    this.d = null;
                                } else {
                                    this.l = ((a3[1] << 8) & 65280) | (a3[0] & 255);
                                }
                            } else {
                                this.D = a(a3);
                            }
                        } else {
                            this.C = a3;
                        }
                    } else if (a3.length >= 4) {
                        this.A = 1;
                        this.B = ((a3[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((a3[2] << 16) & 16711680) | ((a3[1] << 8) & 65280) | (a3[0] & 255);
                    }
                }
            }
            if (this.f19544a) {
                Locale locale = Locale.US;
                ZLogger.d(String.format(locale, "MpHeader: binId=0x%04x, binVersion=0x%04x, partNumber=%s, mpDataLength=0x%08x(%d), otaVersion=0x%02x,  mImageSizeMechanism=0x%02x", Integer.valueOf(this.l), Integer.valueOf(this.m), this.n, Integer.valueOf(this.e), Integer.valueOf(this.e), Integer.valueOf(this.otaVersion), Integer.valueOf(this.k)));
                if (this.otaVersion > 0) {
                    ZLogger.d(String.format(locale, "imageId=0x%04x, flashAddr=0x%08x, mpImageSize=0x%08x(%d), secureVersion=0x%04x, imageVersion=0x%08x", Integer.valueOf(this.h), Integer.valueOf(this.o), Integer.valueOf(this.f), Integer.valueOf(this.f), Integer.valueOf(this.p), Integer.valueOf(this.imageVersion)));
                    return;
                }
                return;
            }
            return;
        }
        ZLogger.d("not found mp header");
    }

    public final void f() throws IOException {
        if (this.b) {
            ZLogger.v("headBuf=" + DataConverter.bytes2Hex(this.g));
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.g, 0, 12);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        a(wrap);
    }

    public final void g() throws IOException {
        if (this.b) {
            ZLogger.v("markSupported");
        }
        mark(0);
        read(this.c, 0, 512);
        e();
        if (!b()) {
            ZLogger.v(this.b, "reset to begin");
            reset();
        }
        ZLogger.v(this.b, String.format(Locale.US, "isNeedReadDfuHeader()=%b, available()=%d", Boolean.valueOf(isNeedReadDfuHeader()), Integer.valueOf(available())));
        if (isNeedReadDfuHeader() && available() >= this.s + 12) {
            mark(0);
            try {
                skip(this.s);
            } catch (IOException unused) {
                ZLogger.w("skip error");
            }
            read(this.t, 0, 12);
            d();
            reset();
            read(this.g, 0, 12);
            return;
        }
        read(this.g, 0, 12);
        System.arraycopy(this.g, 0, this.t, 0, 12);
        f();
    }

    public int getActiveCompareVersionFlag() {
        return this.y;
    }

    public int getBinId() {
        return this.l;
    }

    public int getBinVersion() {
        return this.m;
    }

    public int getCustomizeId() {
        return this.customizeId;
    }

    public byte[] getDfuHeader() {
        return this.t;
    }

    public int getFlashAddr() {
        return this.o;
    }

    public byte[] getHeaderBuf() {
        return this.g;
    }

    public byte getIcType() {
        return this.icType;
    }

    public String getImageFeature() {
        return this.D;
    }

    public int getImageId() {
        return this.h;
    }

    public int getImageSize() {
        return this.j;
    }

    public int getImageVersion() {
        return this.imageVersion;
    }

    public int getInactiveVersionCompFlag() {
        return this.z;
    }

    public int getOtaVersion() {
        return this.otaVersion;
    }

    public byte[] getPubKeyHash() {
        return this.C;
    }

    public int getSecureVersion() {
        return this.p;
    }

    public byte[] getSha256() {
        return this.u;
    }

    public int getTotalImageSize() {
        return this.j + 12;
    }

    public final void h() throws IOException {
        read(this.g, 0, 12);
        byte[] bArr = this.g;
        if (bArr[0] == 1 && bArr[1] == 0 && bArr[2] == 2) {
            System.arraycopy(bArr, 0, this.c, 0, 12);
            read(this.c, 12, 500);
            e();
            read(this.g, 0, 12);
        }
        ZLogger.v(this.b, String.format(Locale.US, "isNeedReadDfuHeader()=%b, available()=%d", Boolean.valueOf(isNeedReadDfuHeader()), Integer.valueOf(available())));
        if (isNeedReadDfuHeader()) {
            int available = available();
            int i = this.s;
            if (available >= i + 12) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(this.g, 0, bArr2, 0, 12);
                read(bArr2, 12, this.s - 12);
                read(this.t, 0, 12);
                d();
                return;
            }
        }
        System.arraycopy(this.g, 0, this.t, 0, 12);
        f();
    }

    public boolean isNeedReadDfuHeader() {
        if (this.s > 0) {
            return true;
        }
        return false;
    }

    public void parseImageHeaderEx() {
        int i;
        int i2;
        try {
            int a2 = a();
            int i3 = a2 - 12;
            int i4 = a2 + 20;
            if (this.h == 10148) {
                i = 1014;
                i2 = 1016;
            } else {
                i = 0;
                i2 = 0;
            }
            int max = Math.max(i4, i2);
            ZLogger.v(this.f19544a, String.format("buf1=%d, vpIdBuf=%d, bufferSize=%d", Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(max)));
            byte[] bArr = new byte[max];
            if (i4 <= i2) {
                int read = read(bArr, 0, i4);
                ZLogger.v(this.f19544a, String.format("readOffset=%d, buffer1=%s", Integer.valueOf(read), DataConverter.bytes2Hex(bArr)));
                if (read > 0) {
                    byte[] bArr2 = new byte[32];
                    this.u = bArr2;
                    System.arraycopy(bArr, i3, bArr2, 0, 32);
                    ZLogger.v(this.b, "sha256=" + DataConverter.bytes2Hex(this.u));
                }
                int read2 = read(bArr, i4, max - i4);
                ZLogger.v(this.f19544a, String.format("readOffset=%d, buffer1=%s", Integer.valueOf(read2), DataConverter.bytes2Hex(bArr)));
                if (read2 > 0) {
                    byte[] bArr3 = new byte[2];
                    System.arraycopy(bArr, i, bArr3, 0, 2);
                    int i5 = ((bArr3[1] << 8) & 65280) | (bArr3[0] & 255);
                    this.customizeId = i5;
                    ZLogger.v(this.b, String.format("customizeId=%04X", Integer.valueOf(i5)));
                    return;
                }
                return;
            }
            if (i2 > 0) {
                int read3 = read(bArr, 0, i2);
                ZLogger.v(String.format("readOffset=%d, buffer1=%s", Integer.valueOf(read3), DataConverter.bytes2Hex(bArr)));
                if (read3 > 0) {
                    byte[] bArr4 = new byte[2];
                    System.arraycopy(bArr, i, bArr4, 0, 2);
                    int i6 = (bArr4[0] & 255) | ((bArr4[1] << 8) & 65280);
                    this.customizeId = i6;
                    ZLogger.v(this.b, String.format("customizeId=%04X", Integer.valueOf(i6)));
                }
            }
            int read4 = read(bArr, i2, max - i2);
            ZLogger.v(String.format("readOffset=%d, buffer1=%s", Integer.valueOf(read4), DataConverter.bytes2Hex(bArr)));
            if (read4 > 0) {
                byte[] bArr5 = new byte[32];
                this.u = bArr5;
                System.arraycopy(bArr, i3, bArr5, 0, 32);
                ZLogger.v(this.b, "sha256=" + DataConverter.bytes2Hex(this.u));
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Use readPacket() method instead");
    }

    public int readPacket(byte[] bArr) throws IOException {
        return read(bArr, this.w);
    }

    public int remainNumInPackets(int i) {
        int i2;
        int remainSizeInBytes = remainSizeInBytes();
        int i3 = remainSizeInBytes / i;
        if (remainSizeInBytes % i > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    public int remainSizeInBytes() {
        return this.j - this.x;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.x = 0;
    }

    public void setActiveCompareVersionFlag(int i) {
        this.y = i;
    }

    public void setCustomizeId(int i) {
        this.customizeId = i;
    }

    public void setInactiveVersionCompFlag(int i) {
        this.z = i;
    }

    public void setSha256(byte[] bArr) {
        this.u = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BinInputStream{");
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\totaVersion=0x%02X, icType=0x%02X, imageId=0x%04X,binId=0x%04X, imageVersion=0x%08X, imageSize=0x%08X(%d)", Integer.valueOf(this.otaVersion), Byte.valueOf(this.icType), Integer.valueOf(this.h), Integer.valueOf(this.l), Integer.valueOf(this.imageVersion), Integer.valueOf(this.j), Integer.valueOf(this.j)));
        sb.append(String.format(locale, "\n\tactiveCompareVersionFlag=%d, inactiveVersionCompFlag=%d,otaTempBufferCheckOrder=%d", Integer.valueOf(this.y), Integer.valueOf(this.z), Integer.valueOf(this.otaTempBufferCheckOrder)));
        sb.append(String.format("\n\tpubKeyHash=%s", DataConverter.bytes2Hex(this.C)));
        sb.append(String.format("\n\tsha256, src=%d, offset=%d, value=%s", Integer.valueOf(this.A), Integer.valueOf(this.B), DataConverter.bytes2Hex(this.u)));
        if (!StringUtils.isEmpty(this.D)) {
            sb.append(String.format("\n\timageFeature=%s", this.D));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public final int a() {
        if (this.A == 1) {
            return this.B;
        }
        if (this.icType == 11) {
            return 272;
        }
        return IXXIXx00I.f11768x0OxxIOxX;
    }

    public final String b(byte[] bArr) {
        int length = bArr.length;
        for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
            byte b = bArr[length2];
            if (b == -1 || b == 0) {
                length--;
            }
        }
        try {
            return new String(bArr, 0, length, "ascii");
        } catch (UnsupportedEncodingException e) {
            ZLogger.w(e.toString());
            return "";
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, bArr.length);
    }

    public int read(byte[] bArr, int i) throws IOException {
        int read = read(bArr, 0, i);
        if (read > 0) {
            this.x += read;
        }
        return read;
    }

    public final String a(byte[] bArr) {
        int length = bArr.length;
        for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
            byte b = bArr[length2];
            if (b == -1 || b == 0) {
                length--;
            }
        }
        return new String(bArr, 0, length, StandardCharsets.US_ASCII);
    }
}
