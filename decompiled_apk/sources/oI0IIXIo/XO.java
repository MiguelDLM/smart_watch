package oI0IIXIo;

import XXO0.oIX0oI;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @NonNull
    public final oxoX f31364oIX0oI;

    public XO(@NonNull oxoX oxox) {
        this.f31364oIX0oI = oxox;
    }

    public static String I0Io(String str, FileExtension fileExtension, boolean z) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        if (z) {
            str2 = fileExtension.tempExtension();
        } else {
            str2 = fileExtension.extension;
        }
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> II0xO0(String str) {
        FileExtension fileExtension;
        try {
            File oxoX2 = oxoX(str);
            if (oxoX2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(oxoX2);
            if (oxoX2.getAbsolutePath().endsWith(OTAManager.OTA_ZIP_SUFFIX)) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            IIXOooo.XO.oIX0oI("Cache hit for " + str + " at " + oxoX2.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File Oxx0IOOO(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(X0o0xo(), I0Io(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public final File X0o0xo() {
        File oIX0oI2 = this.f31364oIX0oI.oIX0oI();
        if (oIX0oI2.isFile()) {
            oIX0oI2.delete();
        }
        if (!oIX0oI2.exists()) {
            oIX0oI2.mkdirs();
        }
        return oIX0oI2;
    }

    public void XO(String str, FileExtension fileExtension) {
        File file = new File(X0o0xo(), I0Io(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        IIXOooo.XO.oIX0oI("Copying temp file to real file (" + file2 + oIX0oI.I0Io.f4095I0Io);
        if (!renameTo) {
            IIXOooo.XO.X0o0xo("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
    }

    public void oIX0oI() {
        File X0o0xo2 = X0o0xo();
        if (X0o0xo2.exists()) {
            File[] listFiles = X0o0xo2.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : X0o0xo2.listFiles()) {
                    file.delete();
                }
            }
            X0o0xo2.delete();
        }
    }

    @Nullable
    public final File oxoX(String str) throws FileNotFoundException {
        File file = new File(X0o0xo(), I0Io(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(X0o0xo(), I0Io(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }
}
