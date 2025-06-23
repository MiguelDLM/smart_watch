package oI0IIXIo;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.x0xO0oo;
import com.baidu.mobads.sdk.internal.an;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    @NonNull
    public final X0o0xo f31362II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @NonNull
    public final XO f31363oIX0oI;

    public Oxx0IOOO(@NonNull XO xo2, @NonNull X0o0xo x0o0xo) {
        this.f31363oIX0oI = xo2;
        this.f31362II0xO0 = x0o0xo;
    }

    @NonNull
    @WorkerThread
    public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> I0Io(@NonNull String str, @Nullable String str2) {
        com.airbnb.lottie.Oxx0IOOO oIX0oI2 = oIX0oI(str, str2);
        if (oIX0oI2 != null) {
            return new x0xO0oo<>(oIX0oI2);
        }
        IIXOooo.XO.oIX0oI("Animation for " + str + " not found in cache. Fetching from network.");
        return II0xO0(str, str2);
    }

    @NonNull
    @WorkerThread
    public final x0xO0oo<com.airbnb.lottie.Oxx0IOOO> II0xO0(@NonNull String str, @Nullable String str2) {
        boolean z;
        IIXOooo.XO.oIX0oI("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                I0Io oIX0oI2 = this.f31362II0xO0.oIX0oI(str);
                if (oIX0oI2.isSuccessful()) {
                    x0xO0oo<com.airbnb.lottie.Oxx0IOOO> oxoX2 = oxoX(str, oIX0oI2.x0xO0oo(), oIX0oI2.ooOOo0oXI(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    if (oxoX2.II0xO0() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    IIXOooo.XO.oIX0oI(sb.toString());
                    try {
                        oIX0oI2.close();
                    } catch (IOException e) {
                        IIXOooo.XO.XO("LottieFetchResult close failed ", e);
                    }
                    return oxoX2;
                }
                x0xO0oo<com.airbnb.lottie.Oxx0IOOO> x0xo0oo = new x0xO0oo<>(new IllegalArgumentException(oIX0oI2.error()));
                try {
                    oIX0oI2.close();
                } catch (IOException e2) {
                    IIXOooo.XO.XO("LottieFetchResult close failed ", e2);
                }
                return x0xo0oo;
            } catch (Exception e3) {
                x0xO0oo<com.airbnb.lottie.Oxx0IOOO> x0xo0oo2 = new x0xO0oo<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        IIXOooo.XO.XO("LottieFetchResult close failed ", e4);
                    }
                }
                return x0xo0oo2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    IIXOooo.XO.XO("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    public final x0xO0oo<com.airbnb.lottie.Oxx0IOOO> X0o0xo(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.II0XooXoX.OOXIXo(inputStream, null);
        }
        return com.airbnb.lottie.II0XooXoX.OOXIXo(new FileInputStream(new File(this.f31363oIX0oI.Oxx0IOOO(str, inputStream, FileExtension.JSON).getAbsolutePath())), str);
    }

    @NonNull
    public final x0xO0oo<com.airbnb.lottie.Oxx0IOOO> XO(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.II0XooXoX.XI0IXoo(new ZipInputStream(inputStream), null);
        }
        return com.airbnb.lottie.II0XooXoX.XI0IXoo(new ZipInputStream(new FileInputStream(this.f31363oIX0oI.Oxx0IOOO(str, inputStream, FileExtension.ZIP))), str);
    }

    @Nullable
    @WorkerThread
    public final com.airbnb.lottie.Oxx0IOOO oIX0oI(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> II0xO02;
        x0xO0oo<com.airbnb.lottie.Oxx0IOOO> OOXIXo2;
        if (str2 == null || (II0xO02 = this.f31363oIX0oI.II0xO0(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) II0xO02.first;
        InputStream inputStream = (InputStream) II0xO02.second;
        if (fileExtension == FileExtension.ZIP) {
            OOXIXo2 = com.airbnb.lottie.II0XooXoX.XI0IXoo(new ZipInputStream(inputStream), str);
        } else {
            OOXIXo2 = com.airbnb.lottie.II0XooXoX.OOXIXo(inputStream, str);
        }
        if (OOXIXo2.II0xO0() == null) {
            return null;
        }
        return OOXIXo2.II0xO0();
    }

    @NonNull
    public final x0xO0oo<com.airbnb.lottie.Oxx0IOOO> oxoX(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        x0xO0oo<com.airbnb.lottie.Oxx0IOOO> XO2;
        if (str2 == null) {
            str2 = an.d;
        }
        if (!str2.contains(DfuBaseService.MIME_TYPE_ZIP) && !str.split("\\?")[0].endsWith(".lottie")) {
            IIXOooo.XO.oIX0oI("Received json response.");
            fileExtension = FileExtension.JSON;
            XO2 = X0o0xo(str, inputStream, str3);
        } else {
            IIXOooo.XO.oIX0oI("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            XO2 = XO(str, inputStream, str3);
        }
        if (str3 != null && XO2.II0xO0() != null) {
            this.f31363oIX0oI.XO(str, fileExtension);
        }
        return XO2;
    }
}
