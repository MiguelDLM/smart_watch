package com.jd.ad.sdk.jad_oz;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_tg implements com.jd.ad.sdk.jad_hs.jad_dq<InputStream> {
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_an;

    public jad_tg(com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_dq
    public boolean jad_an(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.jad_an.jad_an(65536, byte[].class);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Logger.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.jad_an.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.jad_an.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                        throw th;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
                this.jad_an.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
