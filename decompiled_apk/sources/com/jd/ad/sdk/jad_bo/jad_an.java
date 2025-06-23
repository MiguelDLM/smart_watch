package com.jd.ad.sdk.jad_bo;

import XXO0.oIX0oI;
import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.garmin.fit.X0xOO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes10.dex */
public class jad_an {
    public static final byte[] jad_cn;
    public static final byte[] jad_do;
    public static final byte[] jad_ep;
    public static final String[] jad_fq;
    public static final int[] jad_gr;
    public static final byte[] jad_hs;
    public static final jad_dq jad_it;
    public static final jad_dq[][] jad_ju;
    public static final jad_dq[] jad_kv;
    public static final HashMap<Integer, jad_dq>[] jad_lw;
    public static final HashMap<String, jad_dq>[] jad_mx;
    public static final boolean jad_na = Log.isLoggable("ExifInterface", 3);
    public static final HashSet<String> jad_ny;
    public static final int[] jad_ob;
    public static final HashMap<Integer, Integer> jad_oz;
    public static final Charset jad_pa;
    public static final int[] jad_pc;
    public static final byte[] jad_qb;
    public static final byte[] jad_qd;
    public static final byte[] jad_rc;
    public static final byte[] jad_re;
    public static final byte[] jad_sf;
    public static final byte[] jad_tg;
    public static final byte[] jad_uh;
    public static final byte[] jad_vi;
    public static final byte[] jad_wj;
    public static final byte[] jad_xk;
    public static final byte[] jad_yl;
    public static final byte[] jad_zm;
    public FileDescriptor jad_an;
    public AssetManager.AssetInputStream jad_bo;
    public int jad_cp;
    public boolean jad_dq;
    public final HashMap<String, jad_cp>[] jad_er;
    public Set<Integer> jad_fs;
    public boolean jad_hu;
    public int jad_iv;
    public ByteOrder jad_jt;
    public int jad_jw;
    public int jad_kx;
    public int jad_ly;
    public int jad_mz;

    /* renamed from: com.jd.ad.sdk.jad_bo.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0680jad_an extends MediaDataSource {
        public long jad_an;
        public final /* synthetic */ jad_bo jad_bo;

        public C0680jad_an(jad_an jad_anVar, jad_bo jad_boVar) {
            this.jad_bo = jad_boVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.jad_an;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + this.jad_bo.jad_an.available()) {
                        return -1;
                    }
                    this.jad_bo.jad_bo(j);
                    this.jad_an = j;
                }
                if (i2 > this.jad_bo.jad_an.available()) {
                    i2 = this.jad_bo.jad_an.available();
                }
                jad_bo jad_boVar = this.jad_bo;
                int read = jad_boVar.jad_an.read(bArr, i, i2);
                jad_boVar.jad_dq += read;
                if (read >= 0) {
                    this.jad_an += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.jad_an = -1L;
            return -1;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo extends InputStream implements DataInput {
        public static final ByteOrder jad_er = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder jad_fs = ByteOrder.BIG_ENDIAN;
        public DataInputStream jad_an;
        public ByteOrder jad_bo;
        public final int jad_cp;
        public int jad_dq;

        public jad_bo(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.available();
        }

        public void jad_bo(long j) {
            long j2 = this.jad_dq;
            if (j2 > j) {
                this.jad_dq = 0;
                this.jad_an.reset();
                this.jad_an.mark(this.jad_cp);
            } else {
                j -= j2;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int read() {
            this.jad_dq++;
            return this.jad_an.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.jad_dq++;
            return this.jad_an.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int i = this.jad_dq + 1;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int read = this.jad_an.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.jad_dq += 2;
            return this.jad_an.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            int i3 = this.jad_dq + i2;
            this.jad_dq = i3;
            if (i3 <= this.jad_cp) {
                if (this.jad_an.read(bArr, i, i2) != i2) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() {
            int i = this.jad_dq + 4;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int read = this.jad_an.read();
                int read2 = this.jad_an.read();
                int read3 = this.jad_an.read();
                int read4 = this.jad_an.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.jad_bo;
                    if (byteOrder == jad_er) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == jad_fs) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
                    jad_an.append(this.jad_bo);
                    throw new IOException(jad_an.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int i = this.jad_dq + 8;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int read = this.jad_an.read();
                int read2 = this.jad_an.read();
                int read3 = this.jad_an.read();
                int read4 = this.jad_an.read();
                int read5 = this.jad_an.read();
                int read6 = this.jad_an.read();
                int read7 = this.jad_an.read();
                int read8 = this.jad_an.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.jad_bo;
                    if (byteOrder == jad_er) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == jad_fs) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
                    jad_an.append(this.jad_bo);
                    throw new IOException(jad_an.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int read = this.jad_an.read();
                int read2 = this.jad_an.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.jad_bo;
                    if (byteOrder == jad_er) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == jad_fs) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
                    jad_an.append(this.jad_bo);
                    throw new IOException(jad_an.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.jad_dq += 2;
            return this.jad_an.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.jad_dq++;
            return this.jad_an.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int read = this.jad_an.read();
                int read2 = this.jad_an.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.jad_bo;
                    if (byteOrder == jad_er) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == jad_fs) {
                        return (read << 8) + read2;
                    }
                    StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
                    jad_an.append(this.jad_bo);
                    throw new IOException(jad_an.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = Math.min(i, this.jad_cp - this.jad_dq);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.jad_an.skipBytes(min - i2);
            }
            this.jad_dq += i2;
            return i2;
        }

        public jad_bo(InputStream inputStream, ByteOrder byteOrder) {
            this.jad_bo = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.jad_an = dataInputStream;
            int available = dataInputStream.available();
            this.jad_cp = available;
            this.jad_dq = 0;
            this.jad_an.mark(available);
            this.jad_bo = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.jad_an.read(bArr, i, i2);
            this.jad_dq += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            int length = this.jad_dq + bArr.length;
            this.jad_dq = length;
            if (length <= this.jad_cp) {
                if (this.jad_an.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public long jad_bo() {
            return readInt() & BleWatchFaceId.WATCHFACE_ID_INVALID;
        }

        public jad_bo(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_er {
        public final long jad_an;
        public final long jad_bo;

        public jad_er(long j, long j2) {
            if (j2 == 0) {
                this.jad_an = 0L;
                this.jad_bo = 1L;
            } else {
                this.jad_an = j;
                this.jad_bo = j2;
            }
        }

        public String toString() {
            return this.jad_an + "/" + this.jad_bo;
        }
    }

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        jad_ob = new int[]{8, 8, 8};
        jad_pc = new int[]{8};
        jad_qd = new byte[]{-1, -40, -1};
        jad_re = new byte[]{102, 116, 121, 112};
        jad_sf = new byte[]{109, 105, 102, 49};
        jad_tg = new byte[]{104, 101, 105, 99};
        jad_uh = new byte[]{79, 76, 89, 77, 80, 0};
        jad_vi = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        jad_wj = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        jad_xk = new byte[]{101, 88, 73, 102};
        jad_yl = new byte[]{73, 72, 68, 82};
        jad_zm = new byte[]{73, 69, 78, 68};
        jad_cn = new byte[]{82, 73, 70, 70};
        jad_do = new byte[]{87, 69, 66, 80};
        jad_ep = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        "XMP ".getBytes(Charset.defaultCharset());
        jad_fq = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        jad_gr = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        jad_hs = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        jad_dq[] jad_dqVarArr = {new jad_dq(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new jad_dq(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new jad_dq(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new jad_dq(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new jad_dq(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new jad_dq(ExifInterface.TAG_COMPRESSION, 259, 3), new jad_dq(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new jad_dq(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new jad_dq(ExifInterface.TAG_MAKE, 271, 2), new jad_dq(ExifInterface.TAG_MODEL, 272, 2), new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new jad_dq(ExifInterface.TAG_ORIENTATION, 274, 3), new jad_dq(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new jad_dq(ExifInterface.TAG_ROWS_PER_STRIP, 278, 3, 4), new jad_dq(ExifInterface.TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new jad_dq(ExifInterface.TAG_X_RESOLUTION, 282, 5), new jad_dq(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new jad_dq(ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new jad_dq(ExifInterface.TAG_RESOLUTION_UNIT, X0xOO.f13664XxXX, 3), new jad_dq(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new jad_dq(ExifInterface.TAG_SOFTWARE, 305, 2), new jad_dq(ExifInterface.TAG_DATETIME, 306, 2), new jad_dq(ExifInterface.TAG_ARTIST, 315, 2), new jad_dq(ExifInterface.TAG_WHITE_POINT, 318, 5), new jad_dq(ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new jad_dq("SubIFDPointer", 330, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new jad_dq(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE, 5), new jad_dq(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new jad_dq(ExifInterface.TAG_Y_CB_CR_POSITIONING, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, 3), new jad_dq(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new jad_dq(ExifInterface.TAG_COPYRIGHT, 33432, 2), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new jad_dq(ExifInterface.TAG_RW2_ISO, 23, 3), new jad_dq(ExifInterface.TAG_RW2_JPG_FROM_RAW, 46, 7), new jad_dq(ExifInterface.TAG_XMP, 700, 1)};
        jad_dq[] jad_dqVarArr2 = {new jad_dq(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new jad_dq(ExifInterface.TAG_F_NUMBER, 33437, 5), new jad_dq(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new jad_dq(ExifInterface.TAG_SPECTRAL_SENSITIVITY, 34852, 2), new jad_dq(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new jad_dq(ExifInterface.TAG_OECF, 34856, 7), new jad_dq(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new jad_dq(ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new jad_dq(ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED, 34867, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new jad_dq(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new jad_dq(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new jad_dq(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME, 36880, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new jad_dq(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new jad_dq(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new jad_dq(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new jad_dq(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new jad_dq(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new jad_dq(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new jad_dq(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new jad_dq(ExifInterface.TAG_SUBJECT_DISTANCE, 37382, 5), new jad_dq(ExifInterface.TAG_METERING_MODE, 37383, 3), new jad_dq(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new jad_dq(ExifInterface.TAG_FLASH, 37385, 3), new jad_dq(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new jad_dq(ExifInterface.TAG_SUBJECT_AREA, 37396, 3), new jad_dq(ExifInterface.TAG_MAKER_NOTE, 37500, 7), new jad_dq(ExifInterface.TAG_USER_COMMENT, 37510, 7), new jad_dq(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new jad_dq(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new jad_dq(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new jad_dq(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new jad_dq(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new jad_dq(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new jad_dq(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new jad_dq(ExifInterface.TAG_RELATED_SOUND_FILE, 40964, 2), new jad_dq("InteroperabilityIFDPointer", 40965, 4), new jad_dq(ExifInterface.TAG_FLASH_ENERGY, 41483, 5), new jad_dq(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new jad_dq(ExifInterface.TAG_SUBJECT_LOCATION, 41492, 3), new jad_dq(ExifInterface.TAG_EXPOSURE_INDEX, 41493, 5), new jad_dq(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new jad_dq(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new jad_dq(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new jad_dq(ExifInterface.TAG_CFA_PATTERN, 41730, 7), new jad_dq(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new jad_dq(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new jad_dq(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new jad_dq(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new jad_dq(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new jad_dq(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new jad_dq(ExifInterface.TAG_GAIN_CONTROL, 41991, 3), new jad_dq(ExifInterface.TAG_CONTRAST, 41992, 3), new jad_dq(ExifInterface.TAG_SATURATION, 41993, 3), new jad_dq(ExifInterface.TAG_SHARPNESS, 41994, 3), new jad_dq(ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new jad_dq(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new jad_dq(ExifInterface.TAG_IMAGE_UNIQUE_ID, 42016, 2), new jad_dq("CameraOwnerName", 42032, 2), new jad_dq(ExifInterface.TAG_BODY_SERIAL_NUMBER, 42033, 2), new jad_dq(ExifInterface.TAG_LENS_SPECIFICATION, 42034, 5), new jad_dq(ExifInterface.TAG_LENS_MAKE, 42035, 2), new jad_dq(ExifInterface.TAG_LENS_MODEL, 42036, 2), new jad_dq(ExifInterface.TAG_GAMMA, 42240, 5), new jad_dq(ExifInterface.TAG_DNG_VERSION, 50706, 1), new jad_dq(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        jad_dq[] jad_dqVarArr3 = {new jad_dq(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new jad_dq(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new jad_dq(ExifInterface.TAG_GPS_LATITUDE, 2, 5), new jad_dq(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new jad_dq(ExifInterface.TAG_GPS_LONGITUDE, 4, 5), new jad_dq(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new jad_dq(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new jad_dq(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new jad_dq(ExifInterface.TAG_GPS_SATELLITES, 8, 2), new jad_dq(ExifInterface.TAG_GPS_STATUS, 9, 2), new jad_dq(ExifInterface.TAG_GPS_MEASURE_MODE, 10, 2), new jad_dq(ExifInterface.TAG_GPS_DOP, 11, 5), new jad_dq(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new jad_dq(ExifInterface.TAG_GPS_SPEED, 13, 5), new jad_dq(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new jad_dq(ExifInterface.TAG_GPS_TRACK, 15, 5), new jad_dq(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new jad_dq(ExifInterface.TAG_GPS_IMG_DIRECTION, 17, 5), new jad_dq(ExifInterface.TAG_GPS_MAP_DATUM, 18, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LATITUDE, 20, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LONGITUDE, 22, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_BEARING, 24, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_DISTANCE, 26, 5), new jad_dq(ExifInterface.TAG_GPS_PROCESSING_METHOD, 27, 7), new jad_dq(ExifInterface.TAG_GPS_AREA_INFORMATION, 28, 7), new jad_dq(ExifInterface.TAG_GPS_DATESTAMP, 29, 2), new jad_dq(ExifInterface.TAG_GPS_DIFFERENTIAL, 30, 3), new jad_dq(ExifInterface.TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        jad_dq[] jad_dqVarArr4 = {new jad_dq(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        jad_dq[] jad_dqVarArr5 = {new jad_dq(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new jad_dq(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new jad_dq(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new jad_dq(ExifInterface.TAG_COMPRESSION, 259, 3), new jad_dq(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new jad_dq(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new jad_dq(ExifInterface.TAG_MAKE, 271, 2), new jad_dq(ExifInterface.TAG_MODEL, 272, 2), new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_ORIENTATION, 274, 3), new jad_dq(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new jad_dq(ExifInterface.TAG_ROWS_PER_STRIP, 278, 3, 4), new jad_dq(ExifInterface.TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new jad_dq(ExifInterface.TAG_X_RESOLUTION, 282, 5), new jad_dq(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new jad_dq(ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new jad_dq(ExifInterface.TAG_RESOLUTION_UNIT, X0xOO.f13664XxXX, 3), new jad_dq(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new jad_dq(ExifInterface.TAG_SOFTWARE, 305, 2), new jad_dq(ExifInterface.TAG_DATETIME, 306, 2), new jad_dq(ExifInterface.TAG_ARTIST, 315, 2), new jad_dq(ExifInterface.TAG_WHITE_POINT, 318, 5), new jad_dq(ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new jad_dq("SubIFDPointer", 330, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new jad_dq(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE, 5), new jad_dq(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new jad_dq(ExifInterface.TAG_Y_CB_CR_POSITIONING, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, 3), new jad_dq(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new jad_dq(ExifInterface.TAG_COPYRIGHT, 33432, 2), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq(ExifInterface.TAG_DNG_VERSION, 50706, 1), new jad_dq(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        jad_it = new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3);
        jad_ju = new jad_dq[][]{jad_dqVarArr, jad_dqVarArr2, jad_dqVarArr3, jad_dqVarArr4, jad_dqVarArr5, jad_dqVarArr, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new jad_dq("CameraSettingsIFDPointer", 8224, 4), new jad_dq("ImageProcessingIFDPointer", 8256, 4)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new jad_dq(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_ASPECT_FRAME, 4371, 3)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_COLOR_SPACE, 55, 3)}};
        jad_kv = new jad_dq[]{new jad_dq("SubIFDPointer", 330, 4), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq("InteroperabilityIFDPointer", 40965, 4), new jad_dq("CameraSettingsIFDPointer", 8224, 1), new jad_dq("ImageProcessingIFDPointer", 8256, 1)};
        jad_lw = new HashMap[10];
        jad_mx = new HashMap[10];
        jad_ny = new HashSet<>(Arrays.asList(ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_GPS_TIMESTAMP));
        jad_oz = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        jad_pa = forName;
        jad_qb = "Exif\u0000\u0000".getBytes(forName);
        jad_rc = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            jad_dq[][] jad_dqVarArr6 = jad_ju;
            if (i < jad_dqVarArr6.length) {
                jad_lw[i] = new HashMap<>();
                jad_mx[i] = new HashMap<>();
                for (jad_dq jad_dqVar : jad_dqVarArr6[i]) {
                    jad_lw[i].put(Integer.valueOf(jad_dqVar.jad_an), jad_dqVar);
                    jad_mx[i].put(jad_dqVar.jad_bo, jad_dqVar);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = jad_oz;
                jad_dq[] jad_dqVarArr7 = jad_kv;
                hashMap.put(Integer.valueOf(jad_dqVarArr7[0].jad_an), 5);
                hashMap.put(Integer.valueOf(jad_dqVarArr7[1].jad_an), 1);
                hashMap.put(Integer.valueOf(jad_dqVarArr7[2].jad_an), 2);
                hashMap.put(Integer.valueOf(jad_dqVarArr7[3].jad_an), 3);
                hashMap.put(Integer.valueOf(jad_dqVarArr7[4].jad_an), 7);
                hashMap.put(Integer.valueOf(jad_dqVarArr7[5].jad_an), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    public jad_an(@NonNull InputStream inputStream, boolean z) {
        jad_dq[][] jad_dqVarArr = jad_ju;
        this.jad_er = new HashMap[jad_dqVarArr.length];
        this.jad_fs = new HashSet(jad_dqVarArr.length);
        this.jad_jt = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            if (z) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (!jad_bo(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.jad_dq = true;
                this.jad_bo = null;
                this.jad_an = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.jad_bo = (AssetManager.AssetInputStream) inputStream;
                this.jad_an = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (jad_an(fileInputStream.getFD())) {
                        this.jad_bo = null;
                        this.jad_an = fileInputStream.getFD();
                    }
                }
                this.jad_bo = null;
                this.jad_an = null;
            }
            jad_an(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    @Nullable
    public String jad_an(@NonNull String str) {
        jad_cp jad_bo2 = jad_bo(str);
        if (jad_bo2 != null) {
            if (!jad_ny.contains(str)) {
                return jad_bo2.jad_cp(this.jad_jt);
            }
            if (str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                int i = jad_bo2.jad_an;
                if (i != 5 && i != 10) {
                    StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("GPS Timestamp format is not rational. format=");
                    jad_an.append(jad_bo2.jad_an);
                    Log.w("ExifInterface", jad_an.toString());
                    return null;
                }
                jad_er[] jad_erVarArr = (jad_er[]) jad_bo2.jad_dq(this.jad_jt);
                if (jad_erVarArr != null && jad_erVarArr.length == 3) {
                    jad_er jad_erVar = jad_erVarArr[0];
                    Integer valueOf = Integer.valueOf((int) (((float) jad_erVar.jad_an) / ((float) jad_erVar.jad_bo)));
                    jad_er jad_erVar2 = jad_erVarArr[1];
                    Integer valueOf2 = Integer.valueOf((int) (((float) jad_erVar2.jad_an) / ((float) jad_erVar2.jad_bo)));
                    jad_er jad_erVar3 = jad_erVarArr[2];
                    return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) jad_erVar3.jad_an) / ((float) jad_erVar3.jad_bo))));
                }
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid GPS Timestamp array. array=");
                jad_an2.append(Arrays.toString(jad_erVarArr));
                Log.w("ExifInterface", jad_an2.toString());
                return null;
            }
            try {
                return Double.toString(jad_bo2.jad_an(this.jad_jt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @Nullable
    public final jad_cp jad_bo(@NonNull String str) {
        if (str != null) {
            if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
                if (jad_na) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i = 0; i < jad_ju.length; i++) {
                jad_cp jad_cpVar = this.jad_er[i].get(str);
                if (jad_cpVar != null) {
                    return jad_cpVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final boolean jad_cp(byte[] bArr) {
        jad_bo jad_boVar = null;
        try {
            jad_bo jad_boVar2 = new jad_bo(bArr);
            try {
                ByteOrder jad_iv = jad_iv(jad_boVar2);
                this.jad_jt = jad_iv;
                jad_boVar2.jad_bo = jad_iv;
                boolean z = jad_boVar2.readShort() == 85;
                jad_boVar2.close();
                return z;
            } catch (Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void jad_dq(jad_bo jad_boVar) {
        jad_boVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        jad_boVar.read(bArr);
        jad_boVar.skipBytes(4);
        jad_boVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        jad_an(jad_boVar, i, 5);
        jad_boVar.jad_bo(i2);
        jad_boVar.jad_bo = ByteOrder.BIG_ENDIAN;
        int readInt = jad_boVar.readInt();
        if (jad_na) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = jad_boVar.readUnsignedShort();
            int readUnsignedShort2 = jad_boVar.readUnsignedShort();
            if (readUnsignedShort == jad_it.jad_an) {
                short readShort = jad_boVar.readShort();
                short readShort2 = jad_boVar.readShort();
                jad_cp jad_an = jad_cp.jad_an((int) readShort, this.jad_jt);
                jad_cp jad_an2 = jad_cp.jad_an((int) readShort2, this.jad_jt);
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_an);
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_an2);
                if (jad_na) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            jad_boVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void jad_er(jad_bo jad_boVar) {
        jad_cp jad_cpVar;
        jad_an(jad_boVar, jad_boVar.jad_an.available());
        jad_bo(jad_boVar, 0);
        jad_dq(jad_boVar, 0);
        jad_dq(jad_boVar, 5);
        jad_dq(jad_boVar, 4);
        jad_cp();
        if (this.jad_cp == 8 && (jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_MAKER_NOTE)) != null) {
            jad_bo jad_boVar2 = new jad_bo(jad_cpVar.jad_cp);
            jad_boVar2.jad_bo = this.jad_jt;
            jad_boVar2.jad_bo(6L);
            jad_bo(jad_boVar2, 9);
            jad_cp jad_cpVar2 = this.jad_er[9].get(ExifInterface.TAG_COLOR_SPACE);
            if (jad_cpVar2 != null) {
                this.jad_er[1].put(ExifInterface.TAG_COLOR_SPACE, jad_cpVar2);
            }
        }
    }

    public final void jad_fs(jad_bo jad_boVar) {
        jad_er(jad_boVar);
        if (this.jad_er[0].get(ExifInterface.TAG_RW2_JPG_FROM_RAW) != null) {
            jad_an(jad_boVar, this.jad_mz, 5);
        }
        jad_cp jad_cpVar = this.jad_er[0].get(ExifInterface.TAG_RW2_ISO);
        jad_cp jad_cpVar2 = this.jad_er[1].get(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (jad_cpVar != null && jad_cpVar2 == null) {
            this.jad_er[1].put(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, jad_cpVar);
        }
    }

    public final void jad_hu(jad_bo jad_boVar) {
        if (jad_na) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + jad_boVar);
        }
        jad_boVar.jad_bo = ByteOrder.LITTLE_ENDIAN;
        jad_boVar.skipBytes(jad_cn.length);
        int readInt = jad_boVar.readInt() + 8;
        int skipBytes = jad_boVar.skipBytes(jad_do.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (jad_boVar.read(bArr) == 4) {
                    int readInt2 = jad_boVar.readInt();
                    int i = skipBytes + 8;
                    if (Arrays.equals(jad_ep, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (jad_boVar.read(bArr2) == readInt2) {
                            this.jad_iv = i;
                            jad_an(bArr2, 0);
                            this.jad_iv = i;
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr));
                        }
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i2 = i + readInt2;
                    if (i2 == readInt) {
                        return;
                    }
                    if (i2 <= readInt) {
                        int skipBytes2 = jad_boVar.skipBytes(readInt2);
                        if (skipBytes2 == readInt2) {
                            skipBytes = i + skipBytes2;
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final ByteOrder jad_iv(jad_bo jad_boVar) {
        short readShort = jad_boVar.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (jad_na) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
            jad_an.append(Integer.toHexString(readShort));
            throw new IOException(jad_an.toString());
        }
        if (jad_na) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    public final void jad_jt(jad_bo jad_boVar) {
        byte[] bArr = jad_qb;
        jad_boVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[jad_boVar.jad_an.available()];
        jad_boVar.readFully(bArr2);
        this.jad_iv = bArr.length;
        jad_an(bArr2, 0);
    }

    public final void jad_jw(jad_bo jad_boVar) {
        jad_cp jad_cpVar;
        int jad_bo2;
        HashMap<String, jad_cp> hashMap = this.jad_er[4];
        jad_cp jad_cpVar2 = hashMap.get(ExifInterface.TAG_COMPRESSION);
        if (jad_cpVar2 != null) {
            int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
            if (jad_bo3 != 1) {
                if (jad_bo3 != 6) {
                    if (jad_bo3 != 7) {
                        return;
                    }
                } else {
                    jad_an(jad_boVar, hashMap);
                    return;
                }
            }
            jad_cp jad_cpVar3 = hashMap.get(ExifInterface.TAG_BITS_PER_SAMPLE);
            if (jad_cpVar3 != null) {
                int[] iArr = (int[]) jad_cpVar3.jad_dq(this.jad_jt);
                int[] iArr2 = jad_ob;
                if (Arrays.equals(iArr2, iArr) || (this.jad_cp == 3 && (jad_cpVar = hashMap.get(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((jad_bo2 = jad_cpVar.jad_bo(this.jad_jt)) == 1 && Arrays.equals(iArr, jad_pc)) || (jad_bo2 == 6 && Arrays.equals(iArr, iArr2))))) {
                    jad_cp jad_cpVar4 = hashMap.get(ExifInterface.TAG_STRIP_OFFSETS);
                    jad_cp jad_cpVar5 = hashMap.get(ExifInterface.TAG_STRIP_BYTE_COUNTS);
                    if (jad_cpVar4 != null && jad_cpVar5 != null) {
                        long[] jad_an = jad_an(jad_cpVar4.jad_dq(this.jad_jt));
                        long[] jad_an2 = jad_an(jad_cpVar5.jad_dq(this.jad_jt));
                        if (jad_an != null && jad_an.length != 0) {
                            if (jad_an2 != null && jad_an2.length != 0) {
                                if (jad_an.length != jad_an2.length) {
                                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                                    return;
                                }
                                long j = 0;
                                for (long j2 : jad_an2) {
                                    j += j2;
                                }
                                byte[] bArr = new byte[(int) j];
                                this.jad_hu = true;
                                int i = 0;
                                int i2 = 0;
                                for (int i3 = 0; i3 < jad_an.length; i3++) {
                                    int i4 = (int) jad_an[i3];
                                    int i5 = (int) jad_an2[i3];
                                    if (i3 < jad_an.length - 1 && i4 + i5 != jad_an[i3 + 1]) {
                                        this.jad_hu = false;
                                    }
                                    int i6 = i4 - i;
                                    if (i6 < 0) {
                                        Log.d("ExifInterface", "Invalid strip offset value");
                                    }
                                    jad_boVar.jad_bo(i6);
                                    int i7 = i + i6;
                                    byte[] bArr2 = new byte[i5];
                                    jad_boVar.read(bArr2);
                                    i = i7 + i5;
                                    System.arraycopy(bArr2, 0, bArr, i2, i5);
                                    i2 += i5;
                                }
                                if (this.jad_hu) {
                                    long j3 = jad_an[0];
                                    return;
                                }
                                return;
                            }
                            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                            return;
                        }
                        Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                        return;
                    }
                    return;
                }
            }
            if (jad_na) {
                Log.d("ExifInterface", "Unsupported data type value");
                return;
            }
            return;
        }
        jad_an(jad_boVar, hashMap);
    }

    /* loaded from: classes10.dex */
    public static class jad_dq {
        public final int jad_an;
        public final String jad_bo;
        public final int jad_cp;
        public final int jad_dq;

        public jad_dq(String str, int i, int i2) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = -1;
        }

        public jad_dq(String str, int i, int i2, int i3) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = i3;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_cp(int i, int i2, long j, byte[] bArr) {
            this.jad_an = i;
            this.jad_bo = i2;
            this.jad_cp = bArr;
        }

        public static jad_cp jad_an(int i, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[3]]);
            wrap.order(byteOrder);
            wrap.putShort((short) new int[]{i}[0]);
            return new jad_cp(3, 1, -1L, wrap.array());
        }

        public int jad_bo(ByteOrder byteOrder) {
            Object jad_dq = jad_dq(byteOrder);
            if (jad_dq != null) {
                if (jad_dq instanceof String) {
                    return Integer.parseInt((String) jad_dq);
                }
                if (jad_dq instanceof long[]) {
                    long[] jArr = (long[]) jad_dq;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (jad_dq instanceof int[]) {
                    int[] iArr = (int[]) jad_dq;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String jad_cp(ByteOrder byteOrder) {
            Object jad_dq = jad_dq(byteOrder);
            if (jad_dq == null) {
                return null;
            }
            if (jad_dq instanceof String) {
                return (String) jad_dq;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (jad_dq instanceof long[]) {
                long[] jArr = (long[]) jad_dq;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (jad_dq instanceof int[]) {
                int[] iArr = (int[]) jad_dq;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (jad_dq instanceof double[]) {
                double[] dArr = (double[]) jad_dq;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(jad_dq instanceof jad_er[])) {
                return null;
            }
            jad_er[] jad_erVarArr = (jad_er[]) jad_dq;
            while (i < jad_erVarArr.length) {
                sb.append(jad_erVarArr[i].jad_an);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(jad_erVarArr[i].jad_bo);
                i++;
                if (i != jad_erVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:171:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object jad_dq(java.nio.ByteOrder r12) {
            /*
                Method dump skipped, instructions count: 444
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_dq(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an(oIX0oI.I0Io.f4096II0xO0);
            jad_an.append(jad_an.jad_fq[this.jad_an]);
            jad_an.append(", data length:");
            jad_an.append(this.jad_cp.length);
            jad_an.append(oIX0oI.I0Io.f4095I0Io);
            return jad_an.toString();
        }

        public static jad_cp jad_an(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[4]]);
            wrap.order(byteOrder);
            wrap.putInt((int) jArr[0]);
            return new jad_cp(4, 1, -1L, wrap.array());
        }

        public static jad_cp jad_an(String str) {
            byte[] bytes = (str + (char) 0).getBytes(jad_an.jad_pa);
            return new jad_cp(2, bytes.length, -1L, bytes);
        }

        public static jad_cp jad_an(jad_er jad_erVar, ByteOrder byteOrder) {
            jad_er[] jad_erVarArr = {jad_erVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[5]]);
            wrap.order(byteOrder);
            jad_er jad_erVar2 = jad_erVarArr[0];
            wrap.putInt((int) jad_erVar2.jad_an);
            wrap.putInt((int) jad_erVar2.jad_bo);
            return new jad_cp(5, 1, -1L, wrap.array());
        }

        public double jad_an(ByteOrder byteOrder) {
            Object jad_dq = jad_dq(byteOrder);
            if (jad_dq != null) {
                if (jad_dq instanceof String) {
                    return Double.parseDouble((String) jad_dq);
                }
                if (jad_dq instanceof long[]) {
                    if (((long[]) jad_dq).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (jad_dq instanceof int[]) {
                    if (((int[]) jad_dq).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (jad_dq instanceof double[]) {
                    double[] dArr = (double[]) jad_dq;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (jad_dq instanceof jad_er[]) {
                    jad_er[] jad_erVarArr = (jad_er[]) jad_dq;
                    if (jad_erVarArr.length == 1) {
                        jad_er jad_erVar = jad_erVarArr[0];
                        return jad_erVar.jad_an / jad_erVar.jad_bo;
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
    }

    public final void jad_bo() {
        for (int i = 0; i < this.jad_er.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.jad_er[i].size());
            for (Map.Entry<String, jad_cp> entry : this.jad_er[i].entrySet()) {
                jad_cp value = entry.getValue();
                StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("tagName: ");
                jad_an.append(entry.getKey());
                jad_an.append(", tagType: ");
                jad_an.append(value.toString());
                jad_an.append(", tagValue: '");
                jad_an.append(value.jad_cp(this.jad_jt));
                jad_an.append("'");
                Log.d("ExifInterface", jad_an.toString());
            }
        }
    }

    public final void jad_cp(jad_bo jad_boVar) {
        if (jad_na) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + jad_boVar);
        }
        jad_boVar.jad_bo = ByteOrder.BIG_ENDIAN;
        byte[] bArr = jad_wj;
        jad_boVar.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = jad_boVar.readInt();
                byte[] bArr2 = new byte[4];
                if (jad_boVar.read(bArr2) == 4) {
                    int i = length + 8;
                    if (i == 16 && !Arrays.equals(bArr2, jad_yl)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (Arrays.equals(bArr2, jad_zm)) {
                        return;
                    }
                    if (Arrays.equals(bArr2, jad_xk)) {
                        byte[] bArr3 = new byte[readInt];
                        if (jad_boVar.read(bArr3) == readInt) {
                            int readInt2 = jad_boVar.readInt();
                            CRC32 crc32 = new CRC32();
                            crc32.update(bArr2);
                            crc32.update(bArr3);
                            if (((int) crc32.getValue()) == readInt2) {
                                this.jad_iv = i;
                                jad_an(bArr3, 0);
                                jad_cp();
                                return;
                            } else {
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr2));
                    }
                    int i2 = readInt + 4;
                    jad_boVar.skipBytes(i2);
                    length = i + i2;
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final boolean jad_bo(byte[] bArr) {
        jad_bo jad_boVar = null;
        try {
            jad_bo jad_boVar2 = new jad_bo(bArr);
            try {
                ByteOrder jad_iv = jad_iv(jad_boVar2);
                this.jad_jt = jad_iv;
                jad_boVar2.jad_bo = jad_iv;
                short readShort = jad_boVar2.readShort();
                boolean z = readShort == 20306 || readShort == 21330;
                jad_boVar2.close();
                return z;
            } catch (Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void jad_an(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            for (int i = 0; i < jad_ju.length; i++) {
                try {
                    try {
                        this.jad_er[i] = new HashMap<>();
                    } catch (IOException e) {
                        boolean z = jad_na;
                        if (z) {
                            Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                        }
                        jad_an();
                        if (!z) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    jad_an();
                    if (jad_na) {
                        jad_bo();
                    }
                    throw th;
                }
            }
            if (!this.jad_dq) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.jad_cp = jad_an(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            jad_bo jad_boVar = new jad_bo(inputStream, ByteOrder.BIG_ENDIAN);
            if (!this.jad_dq) {
                switch (this.jad_cp) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 11:
                        jad_er(jad_boVar);
                        break;
                    case 4:
                        jad_an(jad_boVar, 0, 0);
                        break;
                    case 7:
                        jad_bo(jad_boVar);
                        break;
                    case 9:
                        jad_dq(jad_boVar);
                        break;
                    case 10:
                        jad_fs(jad_boVar);
                        break;
                    case 12:
                        jad_an(jad_boVar);
                        break;
                    case 13:
                        jad_cp(jad_boVar);
                        break;
                    case 14:
                        jad_hu(jad_boVar);
                        break;
                }
            } else {
                jad_jt(jad_boVar);
            }
            jad_jw(jad_boVar);
            jad_an();
            if (!jad_na) {
                return;
            }
            jad_bo();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    public static boolean jad_bo(BufferedInputStream bufferedInputStream) {
        byte[] bArr = jad_qb;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = jad_qb;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    public final void jad_bo(jad_bo jad_boVar) {
        int i;
        int i2;
        jad_er(jad_boVar);
        jad_cp jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_MAKER_NOTE);
        if (jad_cpVar != null) {
            jad_bo jad_boVar2 = new jad_bo(jad_cpVar.jad_cp);
            jad_boVar2.jad_bo = this.jad_jt;
            byte[] bArr = jad_uh;
            byte[] bArr2 = new byte[bArr.length];
            jad_boVar2.readFully(bArr2);
            jad_boVar2.jad_bo(0L);
            byte[] bArr3 = jad_vi;
            byte[] bArr4 = new byte[bArr3.length];
            jad_boVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                jad_boVar2.jad_bo(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                jad_boVar2.jad_bo(12L);
            }
            jad_bo(jad_boVar2, 6);
            jad_cp jad_cpVar2 = this.jad_er[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START);
            jad_cp jad_cpVar3 = this.jad_er[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (jad_cpVar2 != null && jad_cpVar3 != null) {
                this.jad_er[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, jad_cpVar2);
                this.jad_er[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, jad_cpVar3);
            }
            jad_cp jad_cpVar4 = this.jad_er[8].get(ExifInterface.TAG_ORF_ASPECT_FRAME);
            if (jad_cpVar4 != null) {
                int[] iArr = (int[]) jad_cpVar4.jad_dq(this.jad_jt);
                if (iArr != null && iArr.length == 4) {
                    int i3 = iArr[2];
                    int i4 = iArr[0];
                    if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                        return;
                    }
                    int i5 = (i3 - i4) + 1;
                    int i6 = (i - i2) + 1;
                    if (i5 < i6) {
                        int i7 = i5 + i6;
                        i6 = i7 - i6;
                        i5 = i7 - i6;
                    }
                    jad_cp jad_an = jad_cp.jad_an(i5, this.jad_jt);
                    jad_cp jad_an2 = jad_cp.jad_an(i6, this.jad_jt);
                    this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_an);
                    this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_an2);
                    return;
                }
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid aspect frame values. frame=");
                jad_an3.append(Arrays.toString(iArr));
                Log.w("ExifInterface", jad_an3.toString());
            }
        }
    }

    public final void jad_dq(jad_bo jad_boVar, int i) {
        jad_cp jad_an;
        jad_cp jad_an2;
        jad_cp jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_DEFAULT_CROP_SIZE);
        jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER);
        jad_cp jad_cpVar3 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER);
        jad_cp jad_cpVar4 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER);
        jad_cp jad_cpVar5 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (jad_cpVar == null) {
            if (jad_cpVar2 != null && jad_cpVar3 != null && jad_cpVar4 != null && jad_cpVar5 != null) {
                int jad_bo2 = jad_cpVar2.jad_bo(this.jad_jt);
                int jad_bo3 = jad_cpVar4.jad_bo(this.jad_jt);
                int jad_bo4 = jad_cpVar5.jad_bo(this.jad_jt);
                int jad_bo5 = jad_cpVar3.jad_bo(this.jad_jt);
                if (jad_bo3 <= jad_bo2 || jad_bo4 <= jad_bo5) {
                    return;
                }
                jad_cp jad_an3 = jad_cp.jad_an(jad_bo3 - jad_bo2, this.jad_jt);
                jad_cp jad_an4 = jad_cp.jad_an(jad_bo4 - jad_bo5, this.jad_jt);
                this.jad_er[i].put(ExifInterface.TAG_IMAGE_LENGTH, jad_an3);
                this.jad_er[i].put(ExifInterface.TAG_IMAGE_WIDTH, jad_an4);
                return;
            }
            jad_cp(jad_boVar, i);
            return;
        }
        if (jad_cpVar.jad_an == 5) {
            jad_er[] jad_erVarArr = (jad_er[]) jad_cpVar.jad_dq(this.jad_jt);
            if (jad_erVarArr != null && jad_erVarArr.length == 2) {
                jad_an = jad_cp.jad_an(jad_erVarArr[0], this.jad_jt);
                jad_an2 = jad_cp.jad_an(jad_erVarArr[1], this.jad_jt);
            } else {
                StringBuilder jad_an5 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=");
                jad_an5.append(Arrays.toString(jad_erVarArr));
                Log.w("ExifInterface", jad_an5.toString());
                return;
            }
        } else {
            int[] iArr = (int[]) jad_cpVar.jad_dq(this.jad_jt);
            if (iArr != null && iArr.length == 2) {
                jad_an = jad_cp.jad_an(iArr[0], this.jad_jt);
                jad_an2 = jad_cp.jad_an(iArr[1], this.jad_jt);
            } else {
                StringBuilder jad_an6 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=");
                jad_an6.append(Arrays.toString(iArr));
                Log.w("ExifInterface", jad_an6.toString());
                return;
            }
        }
        this.jad_er[i].put(ExifInterface.TAG_IMAGE_WIDTH, jad_an);
        this.jad_er[i].put(ExifInterface.TAG_IMAGE_LENGTH, jad_an2);
    }

    public final void jad_cp(jad_bo jad_boVar, int i) {
        jad_cp jad_cpVar;
        jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar3 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_WIDTH);
        if ((jad_cpVar2 == null || jad_cpVar3 == null) && (jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            jad_an(jad_boVar, jad_cpVar.jad_bo(this.jad_jt), i);
        }
    }

    public static boolean jad_an(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!jad_na) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public final void jad_cp() {
        jad_an(0, 5);
        jad_an(0, 4);
        jad_an(5, 4);
        jad_cp jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_PIXEL_X_DIMENSION);
        jad_cp jad_cpVar2 = this.jad_er[1].get(ExifInterface.TAG_PIXEL_Y_DIMENSION);
        if (jad_cpVar != null && jad_cpVar2 != null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVar);
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVar2);
        }
        if (this.jad_er[4].isEmpty() && jad_an((HashMap) this.jad_er[5])) {
            HashMap<String, jad_cp>[] hashMapArr = this.jad_er;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (jad_an((HashMap) this.jad_er[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int jad_an(java.io.BufferedInputStream r17) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_bo.jad_an.jad_an(java.io.BufferedInputStream):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void jad_bo(com.jd.ad.sdk.jad_bo.jad_an.jad_bo r25, int r26) {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_bo.jad_an.jad_bo(com.jd.ad.sdk.jad_bo.jad_an$jad_bo, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0185, code lost:
    
        r19.jad_bo = r18.jad_jt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0189, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00ae. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_bo.jad_an.jad_an(com.jd.ad.sdk.jad_bo.jad_an$jad_bo, int, int):void");
    }

    public final void jad_an(jad_bo jad_boVar) {
        String str;
        String str2;
        String str3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new C0680jad_an(this, jad_boVar));
            } else {
                FileDescriptor fileDescriptor = this.jad_an;
                if (fileDescriptor == null) {
                    mediaMetadataRetriever.release();
                    return;
                }
                mediaMetadataRetriever.setDataSource(fileDescriptor);
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if (str != null) {
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cp.jad_an(Integer.parseInt(str), this.jad_jt));
            }
            if (str2 != null) {
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cp.jad_an(Integer.parseInt(str2), this.jad_jt));
            }
            if (str3 != null) {
                int parseInt = Integer.parseInt(str3);
                this.jad_er[0].put(ExifInterface.TAG_ORIENTATION, jad_cp.jad_an(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.jad_jt));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    jad_boVar.jad_bo(parseInt2);
                    byte[] bArr = new byte[6];
                    if (jad_boVar.read(bArr) == 6) {
                        int i = parseInt2 + 6;
                        int i2 = parseInt3 - 6;
                        if (Arrays.equals(bArr, jad_qb)) {
                            byte[] bArr2 = new byte[i2];
                            if (jad_boVar.read(bArr2) == i2) {
                                this.jad_iv = i;
                                jad_an(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (jad_na) {
                Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    public final void jad_an(byte[] bArr, int i) {
        jad_bo jad_boVar = new jad_bo(bArr);
        jad_an(jad_boVar, bArr.length);
        jad_bo(jad_boVar, i);
    }

    public final void jad_an() {
        String jad_an = jad_an(ExifInterface.TAG_DATETIME_ORIGINAL);
        if (jad_an != null && jad_an(ExifInterface.TAG_DATETIME) == null) {
            this.jad_er[0].put(ExifInterface.TAG_DATETIME, jad_cp.jad_an(jad_an));
        }
        if (jad_an(ExifInterface.TAG_IMAGE_WIDTH) == null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_IMAGE_LENGTH) == null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_ORIENTATION) == null) {
            this.jad_er[0].put(ExifInterface.TAG_ORIENTATION, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_LIGHT_SOURCE) == null) {
            this.jad_er[1].put(ExifInterface.TAG_LIGHT_SOURCE, jad_cp.jad_an(0L, this.jad_jt));
        }
    }

    public final void jad_an(jad_bo jad_boVar, int i) {
        ByteOrder jad_iv = jad_iv(jad_boVar);
        this.jad_jt = jad_iv;
        jad_boVar.jad_bo = jad_iv;
        int readUnsignedShort = jad_boVar.readUnsignedShort();
        int i2 = this.jad_cp;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid start code: ");
            jad_an.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(jad_an.toString());
        }
        int readInt = jad_boVar.readInt();
        if (readInt >= 8 && readInt < i) {
            int i3 = readInt - 8;
            if (i3 <= 0 || jad_boVar.skipBytes(i3) == i3) {
                return;
            }
            throw new IOException("Couldn't jump to first Ifd: " + i3);
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    public final void jad_an(jad_bo jad_boVar, HashMap hashMap) {
        jad_cp jad_cpVar = (jad_cp) hashMap.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        jad_cp jad_cpVar2 = (jad_cp) hashMap.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return;
        }
        int jad_bo2 = jad_cpVar.jad_bo(this.jad_jt);
        int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
        if (this.jad_cp == 7) {
            jad_bo2 += this.jad_jw;
        }
        int min = Math.min(jad_bo3, jad_boVar.jad_cp - jad_bo2);
        if (jad_bo2 > 0 && min > 0) {
            int i = this.jad_iv + jad_bo2;
            if (this.jad_bo == null && this.jad_an == null) {
                jad_boVar.jad_bo(i);
                jad_boVar.readFully(new byte[min]);
            }
        }
        if (jad_na) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + jad_bo2 + ", length: " + min);
        }
    }

    public final boolean jad_an(HashMap hashMap) {
        jad_cp jad_cpVar = (jad_cp) hashMap.get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar2 = (jad_cp) hashMap.get(ExifInterface.TAG_IMAGE_WIDTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return false;
        }
        return jad_cpVar.jad_bo(this.jad_jt) <= 512 && jad_cpVar2.jad_bo(this.jad_jt) <= 512;
    }

    public final void jad_an(int i, int i2) {
        if (!this.jad_er[i].isEmpty() && !this.jad_er[i2].isEmpty()) {
            jad_cp jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_IMAGE_LENGTH);
            jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_WIDTH);
            jad_cp jad_cpVar3 = this.jad_er[i2].get(ExifInterface.TAG_IMAGE_LENGTH);
            jad_cp jad_cpVar4 = this.jad_er[i2].get(ExifInterface.TAG_IMAGE_WIDTH);
            if (jad_cpVar == null || jad_cpVar2 == null) {
                if (jad_na) {
                    Log.d("ExifInterface", "First image does not contain valid size information");
                    return;
                }
                return;
            }
            if (jad_cpVar3 != null && jad_cpVar4 != null) {
                int jad_bo2 = jad_cpVar.jad_bo(this.jad_jt);
                int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
                int jad_bo4 = jad_cpVar3.jad_bo(this.jad_jt);
                int jad_bo5 = jad_cpVar4.jad_bo(this.jad_jt);
                if (jad_bo2 >= jad_bo4 || jad_bo3 >= jad_bo5) {
                    return;
                }
                HashMap<String, jad_cp>[] hashMapArr = this.jad_er;
                HashMap<String, jad_cp> hashMap = hashMapArr[i];
                hashMapArr[i] = hashMapArr[i2];
                hashMapArr[i2] = hashMap;
                return;
            }
            if (jad_na) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        if (jad_na) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public static long[] jad_an(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        }
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public static boolean jad_an(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String jad_an(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
