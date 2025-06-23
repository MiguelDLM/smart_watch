package me.devilsen.czxing;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.devilsen.czxing.code.BarcodeFormat;
import oxOIoIx.oIX0oI;

/* loaded from: classes6.dex */
public class ScannerManager {

    /* renamed from: II0xO0, reason: collision with root package name */
    public ScanOption f30810II0xO0 = new ScanOption();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f30811oIX0oI;

    public ScannerManager(Context context) {
        this.f30811oIX0oI = context;
    }

    public ScannerManager I0Io(boolean z) {
        this.f30810II0xO0.f30834xI = z;
        return this;
    }

    public ScannerManager II0XooXoX(int i) {
        this.f30810II0xO0.f30825XO = i;
        return this;
    }

    public ScannerManager II0xO0(String str, String str2) {
        ScanOption scanOption = this.f30810II0xO0;
        scanOption.f30832oo0xXOI0I = str;
        scanOption.f30831oo = str2;
        return this;
    }

    public ScannerManager IIXOooo(boolean z) {
        this.f30810II0xO0.f30828o00 = z;
        return this;
    }

    public ScannerManager IXxxXO(List<Integer> list) {
        this.f30810II0xO0.f30821X00IoxXI = list;
        return this;
    }

    public ScannerManager OOXIXo(String str) {
        this.f30810II0xO0.f30835xXxxox0I = str;
        return this;
    }

    public ScannerManager Oo(oIX0oI.I0Io i0Io) {
        oIX0oI.oIX0oI().X0o0xo(i0Io);
        return this;
    }

    public ScannerManager Oxx0IOOO(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f30810II0xO0.f30829oI0IIXIo = i;
            this.f30810II0xO0.f30820OxxIIOOXO = i2;
            return this;
        }
        throw new IllegalArgumentException("scan box width or height must > 0");
    }

    @Deprecated
    public ScannerManager Oxx0xo(int i) {
        this.f30810II0xO0.f30813IIXOooo = i;
        return this;
    }

    public ScannerManager OxxIIOOXO(String str) {
        this.f30810II0xO0.f30836xoXoI = str;
        return this;
    }

    public ScannerManager X0o0xo(int i) {
        this.f30810II0xO0.f30817Oo = i;
        return this;
    }

    public ScannerManager XO(int i) {
        if (i > 0) {
            this.f30810II0xO0.f30819Oxx0xo = i;
            return this;
        }
        throw new IllegalArgumentException("scan box size must > 0");
    }

    public ScannerManager o00(String str, String str2) {
        ScanOption scanOption = this.f30810II0xO0;
        scanOption.f30815IoOoX = str;
        scanOption.f30830oOXoIIIo = str2;
        return this;
    }

    public ScannerManager oI0IIXIo(String str) {
        this.f30810II0xO0.f30833ooXIXxIX = str;
        return this;
    }

    public ScannerManager oIX0oI() {
        this.f30810II0xO0.f30816O0xOxO = true;
        return this;
    }

    public ScannerManager oO(int i) {
        this.f30810II0xO0.f30814IXxxXO = i;
        return this;
    }

    public ScannerManager oOoXoXO(int i) {
        this.f30810II0xO0.f30824XIxXXX0x0 = i;
        return this;
    }

    public ScannerManager ooOOo0oXI(String str) {
        this.f30810II0xO0.f30827XxX0x0xxx = str;
        return this;
    }

    public ScannerManager oxoX(BarcodeFormat... barcodeFormatArr) {
        this.f30810II0xO0.f30826Xx000oIo = Arrays.asList(barcodeFormatArr);
        return this;
    }

    public ScannerManager x0XOIxOo() {
        this.f30810II0xO0.f30818OxI = true;
        return this;
    }

    public ScannerManager x0xO0oo(oIX0oI.II0xO0 iI0xO0) {
        oIX0oI.oIX0oI().oxoX(iI0xO0);
        return this;
    }

    public ScannerManager xoIox(int i) {
        this.f30810II0xO0.f30837xxX = i;
        return this;
    }

    public void xoXoI() {
        Intent intent = new Intent(this.f30811oIX0oI, (Class<?>) ScanActivity.class);
        intent.putExtra("option", this.f30810II0xO0);
        this.f30811oIX0oI.startActivity(intent);
    }

    public ScannerManager xxIXOIIO() {
        this.f30810II0xO0.f30812IIX0o = true;
        return this;
    }

    /* loaded from: classes6.dex */
    public static class ScanOption implements Parcelable {
        public static final Parcelable.Creator<ScanOption> CREATOR = new oIX0oI();

        /* renamed from: IIX0o, reason: collision with root package name */
        public boolean f30812IIX0o;

        /* renamed from: IIXOooo, reason: collision with root package name */
        public int f30813IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f30814IXxxXO;

        /* renamed from: IoOoX, reason: collision with root package name */
        public String f30815IoOoX;

        /* renamed from: O0xOxO, reason: collision with root package name */
        public boolean f30816O0xOxO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f30817Oo;

        /* renamed from: OxI, reason: collision with root package name */
        public boolean f30818OxI;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public int f30819Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public int f30820OxxIIOOXO;

        /* renamed from: X00IoxXI, reason: collision with root package name */
        public List<Integer> f30821X00IoxXI;

        /* renamed from: X0IIOO, reason: collision with root package name */
        public int f30822X0IIOO;

        /* renamed from: XI0IXoo, reason: collision with root package name */
        public boolean f30823XI0IXoo;

        /* renamed from: XIxXXX0x0, reason: collision with root package name */
        public int f30824XIxXXX0x0;

        /* renamed from: XO, reason: collision with root package name */
        public int f30825XO;

        /* renamed from: Xx000oIo, reason: collision with root package name */
        public List<BarcodeFormat> f30826Xx000oIo;

        /* renamed from: XxX0x0xxx, reason: collision with root package name */
        public String f30827XxX0x0xxx;

        /* renamed from: o00, reason: collision with root package name */
        public boolean f30828o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public int f30829oI0IIXIo;

        /* renamed from: oOXoIIIo, reason: collision with root package name */
        public String f30830oOXoIIIo;

        /* renamed from: oo, reason: collision with root package name */
        public String f30831oo;

        /* renamed from: oo0xXOI0I, reason: collision with root package name */
        public String f30832oo0xXOI0I;

        /* renamed from: ooXIXxIX, reason: collision with root package name */
        public String f30833ooXIXxIX;

        /* renamed from: xI, reason: collision with root package name */
        public boolean f30834xI;

        /* renamed from: xXxxox0I, reason: collision with root package name */
        public String f30835xXxxox0I;

        /* renamed from: xoXoI, reason: collision with root package name */
        public String f30836xoXoI;

        /* renamed from: xxX, reason: collision with root package name */
        public int f30837xxX;

        /* loaded from: classes6.dex */
        public class oIX0oI implements Parcelable.Creator<ScanOption> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public ScanOption[] newArray(int i) {
                return new ScanOption[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public ScanOption createFromParcel(Parcel parcel) {
                return new ScanOption(parcel);
            }
        }

        public ScanOption() {
            this.f30828o00 = true;
            this.f30823XI0IXoo = true;
            this.f30834xI = true;
        }

        public int IIX0o() {
            return this.f30822X0IIOO;
        }

        public int IIXOooo() {
            return this.f30820OxxIIOOXO;
        }

        public boolean IO() {
            return this.f30823XI0IXoo;
        }

        public String IoOoX() {
            return this.f30815IoOoX;
        }

        public String O0xOxO() {
            return this.f30831oo;
        }

        public int OxI() {
            return this.f30825XO;
        }

        public int OxxIIOOXO() {
            return this.f30817Oo;
        }

        public boolean X00IoxXI() {
            return this.f30812IIX0o;
        }

        public String X0IIOO() {
            return this.f30832oo0xXOI0I;
        }

        public int XI0IXoo() {
            return this.f30837xxX;
        }

        public String XIxXXX0x0() {
            return this.f30835xXxxox0I;
        }

        public boolean Xx000oIo() {
            return this.f30816O0xOxO;
        }

        public String XxX0x0xxx() {
            return this.f30827XxX0x0xxx;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int o00() {
            return this.f30829oI0IIXIo;
        }

        public BarcodeFormat[] oI0IIXIo() {
            return (BarcodeFormat[]) this.f30826Xx000oIo.toArray(new BarcodeFormat[0]);
        }

        public String oOXoIIIo() {
            return this.f30836xoXoI;
        }

        public String oo() {
            return this.f30830oOXoIIIo;
        }

        public String oo0xXOI0I() {
            return this.f30833ooXIXxIX;
        }

        public List<Integer> ooXIXxIX() {
            return this.f30821X00IoxXI;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f30825XO);
            parcel.writeInt(this.f30817Oo);
            parcel.writeInt(this.f30814IXxxXO);
            parcel.writeInt(this.f30819Oxx0xo);
            parcel.writeInt(this.f30829oI0IIXIo);
            parcel.writeInt(this.f30820OxxIIOOXO);
            parcel.writeInt(this.f30813IIXOooo);
            parcel.writeString(this.f30836xoXoI);
            parcel.writeByte(this.f30828o00 ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f30818OxI ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f30816O0xOxO ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f30824XIxXXX0x0);
            parcel.writeInt(this.f30837xxX);
            parcel.writeString(this.f30827XxX0x0xxx);
            parcel.writeString(this.f30835xXxxox0I);
            parcel.writeByte(this.f30812IIX0o ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f30833ooXIXxIX);
            parcel.writeList(this.f30826Xx000oIo);
            parcel.writeList(this.f30821X00IoxXI);
            parcel.writeByte(this.f30834xI ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f30822X0IIOO);
            parcel.writeByte(this.f30823XI0IXoo ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f30832oo0xXOI0I);
            parcel.writeString(this.f30831oo);
            parcel.writeString(this.f30815IoOoX);
            parcel.writeString(this.f30830oOXoIIIo);
        }

        public boolean x0o() {
            return this.f30828o00;
        }

        public int xI() {
            return this.f30813IIXOooo;
        }

        public boolean xII() {
            return this.f30818OxI;
        }

        public int xXxxox0I() {
            return this.f30814IXxxXO;
        }

        public int xoXoI() {
            return this.f30819Oxx0xo;
        }

        public int xxX() {
            return this.f30824XIxXXX0x0;
        }

        public ScanOption(Parcel parcel) {
            this.f30828o00 = true;
            this.f30823XI0IXoo = true;
            this.f30834xI = true;
            this.f30825XO = parcel.readInt();
            this.f30817Oo = parcel.readInt();
            this.f30814IXxxXO = parcel.readInt();
            this.f30819Oxx0xo = parcel.readInt();
            this.f30829oI0IIXIo = parcel.readInt();
            this.f30820OxxIIOOXO = parcel.readInt();
            this.f30813IIXOooo = parcel.readInt();
            this.f30836xoXoI = parcel.readString();
            this.f30828o00 = parcel.readByte() != 0;
            this.f30818OxI = parcel.readByte() != 0;
            this.f30816O0xOxO = parcel.readByte() != 0;
            this.f30824XIxXXX0x0 = parcel.readInt();
            this.f30837xxX = parcel.readInt();
            this.f30827XxX0x0xxx = parcel.readString();
            this.f30835xXxxox0I = parcel.readString();
            this.f30812IIX0o = parcel.readByte() != 0;
            this.f30833ooXIXxIX = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.f30826Xx000oIo = arrayList;
            parcel.readList(arrayList, BarcodeFormat.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            this.f30821X00IoxXI = arrayList2;
            parcel.readList(arrayList2, Integer.class.getClassLoader());
            this.f30834xI = parcel.readByte() != 0;
            this.f30822X0IIOO = parcel.readInt();
            this.f30823XI0IXoo = parcel.readByte() != 0;
            this.f30832oo0xXOI0I = parcel.readString();
            this.f30831oo = parcel.readString();
            this.f30815IoOoX = parcel.readString();
            this.f30830oOXoIIIo = parcel.readString();
        }
    }
}
