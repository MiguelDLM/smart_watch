package com.jd.ad.sdk.jad_rc;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public final class jad_hu implements com.jd.ad.sdk.jad_hs.jad_fs {
    public static final byte[] jad_an = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] jad_bo = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_cp {
        public final ByteBuffer jad_an;

        public jad_an(ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) {
            int min = Math.min(i, this.jad_an.remaining());
            if (min == 0) {
                return -1;
            }
            this.jad_an.get(bArr, 0, min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public long jad_an(long j) {
            int min = (int) Math.min(this.jad_an.remaining(), j);
            ByteBuffer byteBuffer = this.jad_an;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public short jad_an() {
            if (this.jad_an.remaining() >= 1) {
                return (short) (this.jad_an.get() & 255);
            }
            throw new jad_cp.jad_an();
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo {
        public final ByteBuffer jad_an;

        public jad_bo(byte[] bArr, int i) {
            this.jad_an = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short jad_an(int i) {
            if (this.jad_an.remaining() - i >= 2) {
                return this.jad_an.getShort(i);
            }
            return (short) -1;
        }

        public int jad_bo(int i) {
            if (this.jad_an.remaining() - i >= 4) {
                return this.jad_an.getInt(i);
            }
            return -1;
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_cp {

        /* loaded from: classes10.dex */
        public static final class jad_an extends IOException {
            public jad_an() {
                super("Unexpectedly reached end of a file");
            }
        }

        int jad_an(byte[] bArr, int i);

        long jad_an(long j);

        short jad_an();

        int jad_bo();
    }

    /* loaded from: classes10.dex */
    public static final class jad_dq implements jad_cp {
        public final InputStream jad_an;

        public jad_dq(InputStream inputStream) {
            this.jad_an = inputStream;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.jad_an.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new jad_cp.jad_an();
            }
            return i2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public long jad_an(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.jad_an.skip(j2);
                if (skip <= 0) {
                    if (this.jad_an.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public short jad_an() {
            int read = this.jad_an.read();
            if (read != -1) {
                return (short) read;
            }
            throw new jad_cp.jad_an();
        }
    }

    public final int jad_an(jad_cp jad_cpVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if ((jad_bo2 & 65496) != 65496 && jad_bo2 != 19789 && jad_bo2 != 18761) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + jad_bo2);
                }
                return -1;
            }
            int jad_bo3 = jad_bo(jad_cpVar);
            if (jad_bo3 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) jad_boVar.jad_an(jad_bo3, byte[].class);
            try {
                return jad_an(jad_cpVar, bArr, jad_bo3);
            } finally {
                jad_boVar.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
            }
        } catch (jad_cp.jad_an unused) {
            return -1;
        }
    }

    public final int jad_bo(jad_cp jad_cpVar) {
        short jad_an2;
        int jad_bo2;
        long j;
        long jad_an3;
        do {
            short jad_an4 = jad_cpVar.jad_an();
            if (jad_an4 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) jad_an4));
                }
                return -1;
            }
            jad_an2 = jad_cpVar.jad_an();
            if (jad_an2 == 218) {
                return -1;
            }
            if (jad_an2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            jad_bo2 = jad_cpVar.jad_bo() - 2;
            if (jad_an2 == 225) {
                return jad_bo2;
            }
            j = jad_bo2;
            jad_an3 = jad_cpVar.jad_an(j);
        } while (jad_an3 == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Logger.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) jad_an2) + ", wanted to skip: " + jad_bo2 + ", but actually skipped: " + jad_an3);
        }
        return -1;
    }

    @NonNull
    public final jad_fs.jad_bo jad_an(jad_cp jad_cpVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if (jad_bo2 == 65496) {
                return jad_fs.jad_bo.JPEG;
            }
            int jad_an2 = (jad_bo2 << 8) | jad_cpVar.jad_an();
            if (jad_an2 == 4671814) {
                return jad_fs.jad_bo.GIF;
            }
            int jad_an3 = (jad_an2 << 8) | jad_cpVar.jad_an();
            if (jad_an3 == -1991225785) {
                jad_cpVar.jad_an(21L);
                try {
                    return jad_cpVar.jad_an() >= 3 ? jad_fs.jad_bo.PNG_A : jad_fs.jad_bo.PNG;
                } catch (jad_cp.jad_an unused) {
                    return jad_fs.jad_bo.PNG;
                }
            }
            if (jad_an3 == 1380533830) {
                jad_cpVar.jad_an(4L);
                if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) != 1464156752) {
                    return jad_fs.jad_bo.UNKNOWN;
                }
                int jad_bo3 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if ((jad_bo3 & (-256)) != 1448097792) {
                    return jad_fs.jad_bo.UNKNOWN;
                }
                int i = jad_bo3 & 255;
                if (i == 88) {
                    jad_cpVar.jad_an(4L);
                    short jad_an4 = jad_cpVar.jad_an();
                    return (jad_an4 & 2) != 0 ? jad_fs.jad_bo.ANIMATED_WEBP : (jad_an4 & 16) != 0 ? jad_fs.jad_bo.WEBP_A : jad_fs.jad_bo.WEBP;
                }
                if (i != 76) {
                    return jad_fs.jad_bo.WEBP;
                }
                jad_cpVar.jad_an(4L);
                return (jad_cpVar.jad_an() & 8) != 0 ? jad_fs.jad_bo.WEBP_A : jad_fs.jad_bo.WEBP;
            }
            if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) == 1718909296) {
                int jad_bo4 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if (jad_bo4 != 1635150182 && jad_bo4 != 1635150195) {
                    jad_cpVar.jad_an(4L);
                    int i2 = jad_an3 - 16;
                    if (i2 % 4 == 0) {
                        int i3 = 0;
                        while (i3 < 5 && i2 > 0) {
                            int jad_bo5 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                            if (jad_bo5 != 1635150182 && jad_bo5 != 1635150195) {
                                i3++;
                                i2 -= 4;
                            }
                        }
                    }
                }
                return jad_fs.jad_bo.AVIF;
            }
            return jad_fs.jad_bo.UNKNOWN;
        } catch (jad_cp.jad_an unused2) {
            return jad_fs.jad_bo.UNKNOWN;
        }
    }

    public final boolean jad_an(byte[] bArr, int i) {
        boolean z = bArr != null && i > jad_an.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = jad_an;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    public int jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        if (inputStream == null) {
            throw new NullPointerException("Argument must not be null");
        }
        jad_dq jad_dqVar = new jad_dq(inputStream);
        if (jad_boVar != null) {
            return jad_an(jad_dqVar, jad_boVar);
        }
        throw new NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    public int jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        if (byteBuffer == null) {
            throw new NullPointerException("Argument must not be null");
        }
        jad_an jad_anVar = new jad_an(byteBuffer);
        if (jad_boVar != null) {
            return jad_an(jad_anVar, jad_boVar);
        }
        throw new NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            return jad_an(new jad_dq(inputStream));
        }
        throw new NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return jad_an(new jad_an(byteBuffer));
        }
        throw new NullPointerException("Argument must not be null");
    }

    public final int jad_an(jad_cp jad_cpVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        short s = 12;
        int jad_an2 = jad_cpVar.jad_an(bArr, i);
        int i2 = 3;
        if (jad_an2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Logger.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + jad_an2);
            }
            return -1;
        }
        if (jad_an(bArr, i)) {
            jad_bo jad_boVar = new jad_bo(bArr, i);
            short jad_an3 = jad_boVar.jad_an(6);
            if (jad_an3 != 18761) {
                if (jad_an3 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) jad_an3));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            jad_boVar.jad_an.order(byteOrder);
            int jad_bo2 = jad_boVar.jad_bo(10);
            short jad_an4 = jad_boVar.jad_an(6 + jad_bo2);
            int i3 = 0;
            while (i3 < jad_an4) {
                int i4 = (i3 * 12) + jad_bo2 + 8;
                short jad_an5 = jad_boVar.jad_an(i4);
                if (jad_an5 == 274) {
                    short jad_an6 = jad_boVar.jad_an(i4 + 2);
                    if (jad_an6 >= 1 && jad_an6 <= s) {
                        int jad_bo3 = jad_boVar.jad_bo(i4 + 4);
                        if (jad_bo3 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", i2)) {
                                Logger.d("DfltImageHeaderParser", "Got tagIndex=" + i3 + " tagType=" + ((int) jad_an5) + " formatCode=" + ((int) jad_an6) + " componentCount=" + jad_bo3);
                            }
                            int i5 = jad_bo3 + jad_bo[jad_an6];
                            if (i5 <= 4) {
                                int i6 = i4 + 8;
                                if (i6 < 0 || i6 > jad_boVar.jad_an.remaining()) {
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Logger.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i6 + " tagType=" + ((int) jad_an5));
                                    }
                                } else {
                                    if (i5 >= 0 && i5 + i6 <= jad_boVar.jad_an.remaining()) {
                                        return jad_boVar.jad_an(i6);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Logger.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) jad_an5));
                                    }
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Logger.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) jad_an6));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", i2)) {
                            Logger.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Logger.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) jad_an6));
                    }
                }
                i3++;
                s = 12;
                i2 = 3;
            }
            return -1;
        }
        if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
            return -1;
        }
        Logger.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        return -1;
    }
}
