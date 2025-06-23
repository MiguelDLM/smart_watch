package com.realsil.sdk.dfu.e;

import android.content.Context;
import androidx.core.view.ViewCompat;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class a extends BufferedInputStream {
    public static final boolean p = RtkDfu.VDBG;

    /* renamed from: a, reason: collision with root package name */
    public int f19539a;
    public int b;
    public byte[] c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public byte[] i;
    public int j;
    public int k;
    public int l;
    public ArrayList<SubFileInfo> m;
    public String n;
    public long o;

    public a(String str, long j, InputStream inputStream) throws IOException {
        super(inputStream);
        this.e = 1;
        this.j = 4;
        this.k = 16;
        if (available() >= 44) {
            this.n = str;
            this.o = j;
            e();
            f();
            close();
            return;
        }
        throw new IOException("The input file size is less to 44, please check!");
    }

    public static a a(String str) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            a a2 = a(str, 0L, bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            return a2;
        } catch (IOException e2) {
            if (!p) {
                return null;
            }
            ZLogger.v(e2.toString());
            return null;
        }
    }

    public SubFileInfo b() {
        if (this.h == 14) {
            return a(2048);
        }
        return b(2);
    }

    public ArrayList<SubFileInfo> c() {
        return this.m;
    }

    public boolean d() {
        return this.f;
    }

    public final void e() throws IOException {
        boolean z;
        boolean z2 = true;
        byte[] bArr = new byte[40];
        read(bArr, 0, 40);
        if (p) {
            ZLogger.v(String.format(Locale.US, "PackHeader:(%d)%s", 40, DataConverter.bytes2Hex(bArr)));
        }
        int i = (((bArr[1] << 8) & 65280) | (bArr[0] & 255)) & 65535;
        this.f19539a = i;
        if (i == 19783) {
            this.b = ((bArr[5] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[4] << 16) & 16711680) | ((bArr[3] << 8) & 65280) | (bArr[2] & 255);
            byte[] bArr2 = new byte[32];
            this.c = bArr2;
            System.arraycopy(bArr, 6, bArr2, 0, 32);
            int i2 = (bArr[38] & 255) | (65280 & (bArr[39] << 8));
            int i3 = i2 & 65535;
            this.d = i3;
            int i4 = i2 & 15;
            this.e = i4;
            if (((byte) ((i3 >> 7) & 1)) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            this.h = (i3 >> 8) & 255;
            if (i4 <= 1) {
                this.f = true;
                this.j = 4;
            } else if (i4 == 2) {
                this.f = true;
                this.j = 32;
            } else {
                if (((byte) ((i3 >> 6) & 1)) != 1) {
                    z2 = false;
                }
                this.f = z2;
                this.j = 32;
            }
            int i5 = this.j;
            this.k = i5 * 4;
            byte[] bArr3 = new byte[i5];
            this.i = bArr3;
            read(bArr3, 0, i5);
            this.o += 40 + this.j;
            return;
        }
        throw new IOException(String.format("The signature(0x%04X) is not right", Integer.valueOf(this.f19539a)));
    }

    public final void f() throws IOException {
        int i;
        this.l = 0;
        this.m = new ArrayList<>();
        byte[] bArr = this.i;
        int length = bArr.length;
        for (byte b : bArr) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (((byte) (((byte) (b >> i2)) & 1)) == 1) {
                    this.l++;
                }
            }
        }
        long j = this.o + (this.l * 12);
        int i3 = 0;
        for (byte b2 : this.i) {
            int i4 = 0;
            while (i4 < 8) {
                if (((byte) (((byte) (b2 >> i4)) & 1)) == 1) {
                    byte[] bArr2 = new byte[12];
                    read(bArr2, 0, 12);
                    i = i4;
                    SubFileInfo builder = SubFileInfo.builder(this.h, this.n, i3, this.k, j, bArr2);
                    if (p) {
                        ZLogger.v(builder.toString());
                    }
                    this.m.add(builder);
                    j += builder.size;
                } else {
                    i = i4;
                }
                i3++;
                i4 = i + 1;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (p) {
            sb.append(String.format("signature==0x%04X", Integer.valueOf(this.f19539a)));
        }
        sb.append(String.format(Locale.US, "size=0x%08x(%d)", Integer.valueOf(this.b), Integer.valueOf(this.b)) + String.format("packVersion=0x%02X, dualBank=%b", Integer.valueOf(this.e), Boolean.valueOf(this.g)) + String.format(", icType=0x%02X", Integer.valueOf(this.h)) + String.format(", subFileNum=0x%04X, subFileIndicator=%s", Integer.valueOf(this.l), DataConverter.bytes2Hex(this.i)));
        return sb.toString();
    }

    public List<SubFileInfo> c(int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SubFileInfo> arrayList2 = this.m;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int i2 = this.e >= 2 ? 128 : 16;
            if (i == 1) {
                Iterator<SubFileInfo> it = this.m.iterator();
                while (it.hasNext()) {
                    SubFileInfo next = it.next();
                    int i3 = next.bitNumber;
                    if (i3 >= i2) {
                        arrayList.add(next);
                    } else if (this.h == 11 && i3 == 24) {
                        arrayList.add(next);
                    }
                }
            } else {
                Iterator<SubFileInfo> it2 = this.m.iterator();
                while (it2.hasNext()) {
                    SubFileInfo next2 = it2.next();
                    if (next2.bitNumber < i2) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return arrayList;
    }

    public SubFileInfo b(int i) {
        ArrayList<SubFileInfo> arrayList = this.m;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<SubFileInfo> it = this.m.iterator();
            while (it.hasNext()) {
                SubFileInfo next = it.next();
                if (next.bitNumber == i) {
                    return next;
                }
            }
        }
        return null;
    }

    public static a a(String str, long j, InputStream inputStream) {
        a aVar;
        try {
            aVar = new a(str, j, inputStream);
        } catch (IOException e) {
            if (p) {
                ZLogger.d(e.toString());
            }
            aVar = null;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            ZLogger.w(e2.toString());
        }
        return aVar;
    }

    public SubFileInfo b(int i, int i2) {
        int i3 = this.e >= 2 ? 128 : 16;
        if (i2 == 1) {
            i += i3;
        }
        return b(i);
    }

    public a(Context context, String str, InputStream inputStream, long j) throws IOException {
        super(inputStream);
        this.e = 1;
        this.j = 4;
        this.k = 16;
        if (available() >= 44) {
            this.n = str;
            this.o = j;
            e();
            a(context);
            close();
            return;
        }
        throw new IOException("The input file size is less to 44, please check!");
    }

    public static a a(Context context, String str, InputStream inputStream, long j) {
        a aVar = null;
        if (inputStream == null) {
            ZLogger.w("InputStream can not be null");
            return null;
        }
        try {
            aVar = new a(context, str, inputStream, j);
        } catch (IOException e) {
            if (p) {
                ZLogger.d(e.toString());
            }
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            ZLogger.w(e2.toString());
        }
        return aVar;
    }

    public final void a(Context context) throws IOException {
        int i;
        this.l = 0;
        this.m = new ArrayList<>();
        byte[] bArr = this.i;
        int length = bArr.length;
        for (byte b : bArr) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (((byte) (((byte) (b >> i2)) & 1)) == 1) {
                    this.l++;
                }
            }
        }
        long j = this.o + (this.l * 12);
        int i3 = 0;
        for (byte b2 : this.i) {
            int i4 = 0;
            while (i4 < 8) {
                if (((byte) (((byte) (b2 >> i4)) & 1)) == 1) {
                    byte[] bArr2 = new byte[12];
                    read(bArr2, 0, 12);
                    i = i4;
                    SubFileInfo builderFromAssets = SubFileInfo.builderFromAssets(context, this.h, this.n, i3, this.k, j, bArr2);
                    if (p) {
                        ZLogger.v(builderFromAssets.toString());
                    }
                    this.m.add(builderFromAssets);
                    j += builderFromAssets.size;
                } else {
                    i = i4;
                }
                i3++;
                i4 = i + 1;
            }
        }
    }

    public SubFileInfo a(int i) {
        Iterator<SubFileInfo> it = this.m.iterator();
        while (it.hasNext()) {
            SubFileInfo next = it.next();
            if (next.binId == i) {
                return next;
            }
        }
        return null;
    }

    public boolean a(int i, int i2) {
        return b(i, i2) != null;
    }

    public int a() {
        return this.h;
    }
}
