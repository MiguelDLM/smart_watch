package com.realsil.sdk.dfu.d;

import android.content.Context;
import androidx.core.view.ViewCompat;
import com.realsil.sdk.core.logger.ZLogger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f19537a;
    public long b;
    public int c;
    public int d;

    public a(String str, int i, int i2, int i3) {
        this.f19537a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public static a a(String str, int i, byte[] bArr) {
        a aVar = new a(str, i, ((bArr[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), bArr[4] & 1);
        ZLogger.v(aVar.toString());
        return aVar;
    }

    public InputStream b() {
        FileInputStream fileInputStream;
        IOException e;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.f19537a);
            try {
                fileInputStream.skip(this.b);
                return fileInputStream;
            } catch (FileNotFoundException unused) {
                fileInputStream2 = fileInputStream;
                ZLogger.w(String.format(Locale.US, "FileNotFoundException:%s, %d", this.f19537a, Long.valueOf(this.b)));
                return fileInputStream2;
            } catch (IOException e2) {
                e = e2;
                ZLogger.w(e.toString());
                return fileInputStream;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e3) {
            fileInputStream = null;
            e = e3;
        }
    }

    public int c() {
        return this.c;
    }

    public long d() {
        return this.b;
    }

    public String toString() {
        return String.format(Locale.US, "skipOffset=%d, length=0x%02X, budRole=0x%02X", Long.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    public int a() {
        return this.d;
    }

    public InputStream a(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(this.f19537a);
            inputStream.skip(this.b);
            return inputStream;
        } catch (FileNotFoundException unused) {
            ZLogger.w(String.format(Locale.US, "FileNotFoundException:%s, %d", this.f19537a, Long.valueOf(this.b)));
            return inputStream;
        } catch (IOException e) {
            ZLogger.w(e.toString());
            return inputStream;
        }
    }
}
