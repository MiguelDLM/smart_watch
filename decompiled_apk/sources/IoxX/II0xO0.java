package IoxX;

import androidx.work.WorkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Random;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f872X0o0xo = 6;

    /* renamed from: I0Io, reason: collision with root package name */
    public byte[] f873I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f874II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte f875oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f876oxoX;

    public II0xO0(byte b, boolean z, byte[] bArr) {
        this.f876oxoX = false;
        this.f875oIX0oI = b;
        this.f874II0xO0 = z;
        this.f873I0Io = bArr;
    }

    public static void I0Io(ByteBuffer byteBuffer, int i, byte[] bArr) {
        if (bArr != null) {
            II0xO0(byteBuffer, i, true);
            byteBuffer.put(bArr);
        } else {
            II0xO0(byteBuffer, i, false);
        }
    }

    public static void II0xO0(ByteBuffer byteBuffer, int i, boolean z) {
        int i2;
        if (i >= 0) {
            if (z) {
                i2 = WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            } else {
                i2 = 0;
            }
            if (i > 65535) {
                byteBuffer.put((byte) (i2 | 127));
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) ((i >> 24) & 255));
                byteBuffer.put((byte) ((i >> 16) & 255));
                byteBuffer.put((byte) ((i >> 8) & 255));
                byteBuffer.put((byte) (i & 255));
                return;
            }
            if (i >= 126) {
                byteBuffer.put((byte) (i2 | 126));
                byteBuffer.put((byte) (i >> 8));
                byteBuffer.put((byte) (i & 255));
                return;
            }
            byteBuffer.put((byte) (i | i2));
            return;
        }
        throw new IllegalArgumentException("Length cannot be negative");
    }

    public static byte[] X0o0xo() {
        Random random = new Random();
        return new byte[]{(byte) random.nextInt(255), (byte) random.nextInt(255), (byte) random.nextInt(255), (byte) random.nextInt(255)};
    }

    public static void oIX0oI(ByteBuffer byteBuffer, byte b, boolean z) {
        byte b2;
        if (z) {
            b2 = (byte) 128;
        } else {
            b2 = 0;
        }
        byteBuffer.put((byte) ((b & 15) | b2));
    }

    public boolean II0XooXoX() {
        return this.f876oxoX;
    }

    public byte[] Oxx0IOOO() {
        return this.f873I0Io;
    }

    public byte XO() {
        return this.f875oIX0oI;
    }

    public byte[] oxoX() {
        byte[] bArr = this.f873I0Io;
        int length = bArr.length;
        int i = length + 6;
        if (bArr.length > 65535) {
            i = length + 14;
        } else if (bArr.length >= 126) {
            i = length + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        oIX0oI(allocate, this.f875oIX0oI, this.f874II0xO0);
        byte[] X0o0xo2 = X0o0xo();
        I0Io(allocate, this.f873I0Io.length, X0o0xo2);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f873I0Io;
            if (i2 >= bArr2.length) {
                allocate.flip();
                return allocate.array();
            }
            byte b = (byte) (bArr2[i2] ^ X0o0xo2[i2 % 4]);
            bArr2[i2] = b;
            allocate.put(b);
            i2++;
        }
    }

    public final void xoIox(byte b) {
        boolean z;
        if ((b & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f874II0xO0 = z;
        this.f875oIX0oI = (byte) (b & 15);
    }

    public boolean xxIXOIIO() {
        return this.f874II0xO0;
    }

    public II0xO0(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        this.f876oxoX = false;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        xoIox(wrap.get());
        byte b = wrap.get();
        boolean z = (b & 128) != 0;
        int i2 = (byte) (b & Byte.MAX_VALUE);
        int i3 = i2 == 127 ? 8 : i2 == 126 ? 2 : 0;
        while (true) {
            i3--;
            if (i3 <= 0) {
                break;
            } else {
                i2 |= (wrap.get() & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr2 = new byte[4];
            wrap.get(bArr2, 0, 4);
        } else {
            bArr2 = null;
        }
        byte[] bArr3 = new byte[i2];
        this.f873I0Io = bArr3;
        wrap.get(bArr3, 0, i2);
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr4 = this.f873I0Io;
            if (i >= bArr4.length) {
                return;
            }
            bArr4[i] = (byte) (bArr4[i] ^ bArr2[i % 4]);
            i++;
        }
    }

    public II0xO0(InputStream inputStream) throws IOException {
        byte[] bArr;
        int i = 0;
        this.f876oxoX = false;
        xoIox((byte) inputStream.read());
        byte b = this.f875oIX0oI;
        if (b != 2) {
            if (b == 8) {
                this.f876oxoX = true;
                return;
            } else {
                StringBuffer stringBuffer = new StringBuffer("Invalid Frame: Opcode: ");
                stringBuffer.append((int) this.f875oIX0oI);
                throw new IOException(stringBuffer.toString());
            }
        }
        byte read = (byte) inputStream.read();
        boolean z = (read & 128) != 0;
        int i2 = (byte) (read & Byte.MAX_VALUE);
        int i3 = i2 != 127 ? i2 == 126 ? 2 : 0 : 8;
        i2 = i3 > 0 ? 0 : i2;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            } else {
                i2 |= (((byte) inputStream.read()) & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
        } else {
            bArr = null;
        }
        this.f873I0Io = new byte[i2];
        int i4 = i2;
        int i5 = 0;
        while (i5 != i2) {
            int read2 = inputStream.read(this.f873I0Io, i5, i4);
            i5 += read2;
            i4 -= read2;
        }
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr2 = this.f873I0Io;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i % 4]);
            i++;
        }
    }
}
