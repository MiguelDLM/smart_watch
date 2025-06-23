package no.nordicsemi.android.dfu.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* loaded from: classes6.dex */
public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";

    @Nullable
    private byte[] applicationBytes;

    @Nullable
    private byte[] applicationInitBytes;
    private int applicationSize;

    @Nullable
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;

    @Nullable
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;

    @Nullable
    private byte[] markedSource;

    @Nullable
    private byte[] softDeviceAndBootloaderBytes;

    @Nullable
    private byte[] softDeviceBytes;
    private int softDeviceSize;

    @Nullable
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    /* JADX WARN: Removed duplicated region for block: B:81:0x025d A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0025, B:7:0x002d, B:13:0x003b, B:15:0x005d, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00de, B:29:0x00df, B:30:0x00e6, B:31:0x00e7, B:34:0x00f1, B:36:0x00f5, B:38:0x0117, B:39:0x011e, B:40:0x013b, B:41:0x013c, B:44:0x0146, B:46:0x014a, B:48:0x014e, B:50:0x0152, B:52:0x0174, B:55:0x0250, B:58:0x01b0, B:59:0x01b7, B:60:0x0185, B:61:0x01a2, B:62:0x01a3, B:63:0x01aa, B:65:0x0067, B:66:0x0084, B:69:0x01ba, B:77:0x0220, B:81:0x025d, B:82:0x0264, B:83:0x0223, B:85:0x022f, B:86:0x0239, B:88:0x023d, B:89:0x01f4, B:91:0x0200, B:92:0x020a, B:94:0x020e, B:95:0x01be, B:97:0x01ca, B:98:0x01d4, B:100:0x01d8), top: B:4:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022f A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0025, B:7:0x002d, B:13:0x003b, B:15:0x005d, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00de, B:29:0x00df, B:30:0x00e6, B:31:0x00e7, B:34:0x00f1, B:36:0x00f5, B:38:0x0117, B:39:0x011e, B:40:0x013b, B:41:0x013c, B:44:0x0146, B:46:0x014a, B:48:0x014e, B:50:0x0152, B:52:0x0174, B:55:0x0250, B:58:0x01b0, B:59:0x01b7, B:60:0x0185, B:61:0x01a2, B:62:0x01a3, B:63:0x01aa, B:65:0x0067, B:66:0x0084, B:69:0x01ba, B:77:0x0220, B:81:0x025d, B:82:0x0264, B:83:0x0223, B:85:0x022f, B:86:0x0239, B:88:0x023d, B:89:0x01f4, B:91:0x0200, B:92:0x020a, B:94:0x020e, B:95:0x01be, B:97:0x01ca, B:98:0x01d4, B:100:0x01d8), top: B:4:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023d A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0025, B:7:0x002d, B:13:0x003b, B:15:0x005d, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00de, B:29:0x00df, B:30:0x00e6, B:31:0x00e7, B:34:0x00f1, B:36:0x00f5, B:38:0x0117, B:39:0x011e, B:40:0x013b, B:41:0x013c, B:44:0x0146, B:46:0x014a, B:48:0x014e, B:50:0x0152, B:52:0x0174, B:55:0x0250, B:58:0x01b0, B:59:0x01b7, B:60:0x0185, B:61:0x01a2, B:62:0x01a3, B:63:0x01aa, B:65:0x0067, B:66:0x0084, B:69:0x01ba, B:77:0x0220, B:81:0x025d, B:82:0x0264, B:83:0x0223, B:85:0x022f, B:86:0x0239, B:88:0x023d, B:89:0x01f4, B:91:0x0200, B:92:0x020a, B:94:0x020e, B:95:0x01be, B:97:0x01ca, B:98:0x01d4, B:100:0x01d8), top: B:4:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0200 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0025, B:7:0x002d, B:13:0x003b, B:15:0x005d, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00de, B:29:0x00df, B:30:0x00e6, B:31:0x00e7, B:34:0x00f1, B:36:0x00f5, B:38:0x0117, B:39:0x011e, B:40:0x013b, B:41:0x013c, B:44:0x0146, B:46:0x014a, B:48:0x014e, B:50:0x0152, B:52:0x0174, B:55:0x0250, B:58:0x01b0, B:59:0x01b7, B:60:0x0185, B:61:0x01a2, B:62:0x01a3, B:63:0x01aa, B:65:0x0067, B:66:0x0084, B:69:0x01ba, B:77:0x0220, B:81:0x025d, B:82:0x0264, B:83:0x0223, B:85:0x022f, B:86:0x0239, B:88:0x023d, B:89:0x01f4, B:91:0x0200, B:92:0x020a, B:94:0x020e, B:95:0x01be, B:97:0x01ca, B:98:0x01d4, B:100:0x01d8), top: B:4:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020e A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0025, B:7:0x002d, B:13:0x003b, B:15:0x005d, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00de, B:29:0x00df, B:30:0x00e6, B:31:0x00e7, B:34:0x00f1, B:36:0x00f5, B:38:0x0117, B:39:0x011e, B:40:0x013b, B:41:0x013c, B:44:0x0146, B:46:0x014a, B:48:0x014e, B:50:0x0152, B:52:0x0174, B:55:0x0250, B:58:0x01b0, B:59:0x01b7, B:60:0x0185, B:61:0x01a2, B:62:0x01a3, B:63:0x01aa, B:65:0x0067, B:66:0x0084, B:69:0x01ba, B:77:0x0220, B:81:0x025d, B:82:0x0264, B:83:0x0223, B:85:0x022f, B:86:0x0239, B:88:0x023d, B:89:0x01f4, B:91:0x0200, B:92:0x020a, B:94:0x020e, B:95:0x01be, B:97:0x01ca, B:98:0x01d4, B:100:0x01d8), top: B:4:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArchiveInputStream(java.io.InputStream r6, int r7, int r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String validateFilename = validateFilename(nextEntry.getName(), FileUtils.FILE_EXTENSION_SEPARATOR);
            if (nextEntry.isDirectory()) {
                Log.w(TAG, "A directory found in the ZIP: " + validateFilename + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = this.zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (validateFilename.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, i);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if (MANIFEST.equals(validateFilename)) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    this.entries.put(validateFilename, byteArray);
                }
            }
        }
        if (!this.entries.isEmpty()) {
            if (str != null) {
                Manifest manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
                this.manifest = manifest;
                if (manifest == null) {
                    Log.w(TAG, "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
                    return;
                }
                return;
            }
            Log.w(TAG, "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
            return;
        }
        throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
    }

    private int rawRead(@NonNull byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.currentSource;
        if (bArr2 != null && i >= 0 && i2 >= 0) {
            int min = Math.min(i2, bArr2.length - this.bytesReadFromCurrentSource);
            System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, i, min);
            this.bytesReadFromCurrentSource += min;
            this.bytesRead += min;
            this.crc32.update(bArr, i, min);
            return min;
        }
        return -1;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 == this.softDeviceBytes && (bArr = this.bootloaderBytes) != null && (this.type & 2) > 0) {
            this.currentSource = bArr;
        } else {
            bArr = this.applicationBytes;
            if (bArr2 != bArr && bArr != null && (this.type & 4) > 0) {
                this.currentSource = bArr;
            } else {
                bArr = null;
                this.currentSource = null;
            }
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    private String validateFilename(@NonNull String str, @NonNull String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath.substring(1);
        }
        throw new IllegalStateException("File is outside extraction target directory.");
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() {
        int softDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr != null && this.softDeviceSize == 0 && this.bootloaderSize == 0 && (this.type & 3) > 0) {
            softDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        } else {
            softDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        }
        return softDeviceImageSize - i;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (bArr2 != null && (bArr = this.bootloaderBytes) != null && this.currentSource == bArr) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest = this.manifest;
        if (manifest != null && manifest.isSecureDfuRequired()) {
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        int i;
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i2 = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i2;
        this.bytesRead = i2;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        byte[] bArr2 = this.currentSource;
        if (bArr2 != null && (i = this.bytesReadFromCurrentSource) > 0) {
            this.crc32.update(bArr2, 0, i);
        }
    }

    public int setContentType(int i) {
        byte[] bArr;
        this.type = i;
        int i2 = i & 4;
        if (i2 > 0 && this.applicationBytes == null) {
            this.type = i & (-5);
        }
        int i3 = i & 3;
        if (i3 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i3 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((i & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((i & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i2 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return 0L;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int rawRead = rawRead(bArr, i, i2);
        return (i2 <= rawRead || startNextFile() == null) ? rawRead : rawRead + rawRead(bArr, i + rawRead, i2 - rawRead);
    }
}
