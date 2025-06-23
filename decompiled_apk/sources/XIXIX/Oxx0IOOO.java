package XIXIX;

import XIXIX.II0XooXoX;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes9.dex */
public class Oxx0IOOO extends II0XooXoX.oIX0oI {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final Parcelable.Creator<Oxx0IOOO> f3769OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static II0XooXoX<Oxx0IOOO> f3770oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f3771IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f3772Oxx0xo;

    /* loaded from: classes9.dex */
    public static class oIX0oI implements Parcelable.Creator<Oxx0IOOO> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public Oxx0IOOO[] newArray(int i) {
            return new Oxx0IOOO[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Oxx0IOOO createFromParcel(Parcel parcel) {
            Oxx0IOOO oxx0IOOO = new Oxx0IOOO(0.0f, 0.0f);
            oxx0IOOO.Oxx0IOOO(parcel);
            return oxx0IOOO;
        }
    }

    static {
        II0XooXoX<Oxx0IOOO> oIX0oI2 = II0XooXoX.oIX0oI(32, new Oxx0IOOO(0.0f, 0.0f));
        f3770oI0IIXIo = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
        f3769OxxIIOOXO = new oIX0oI();
    }

    public Oxx0IOOO() {
    }

    public static Oxx0IOOO I0Io(float f, float f2) {
        Oxx0IOOO II0xO02 = f3770oI0IIXIo.II0xO0();
        II0xO02.f3771IXxxXO = f;
        II0xO02.f3772Oxx0xo = f2;
        return II0xO02;
    }

    public static void II0XooXoX(Oxx0IOOO oxx0IOOO) {
        f3770oI0IIXIo.Oxx0IOOO(oxx0IOOO);
    }

    public static Oxx0IOOO II0xO0() {
        return f3770oI0IIXIo.II0xO0();
    }

    public static Oxx0IOOO oxoX(Oxx0IOOO oxx0IOOO) {
        Oxx0IOOO II0xO02 = f3770oI0IIXIo.II0xO0();
        II0xO02.f3771IXxxXO = oxx0IOOO.f3771IXxxXO;
        II0xO02.f3772Oxx0xo = oxx0IOOO.f3772Oxx0xo;
        return II0xO02;
    }

    public static void xxIXOIIO(List<Oxx0IOOO> list) {
        f3770oI0IIXIo.II0XooXoX(list);
    }

    public void Oxx0IOOO(Parcel parcel) {
        this.f3771IXxxXO = parcel.readFloat();
        this.f3772Oxx0xo = parcel.readFloat();
    }

    public float X0o0xo() {
        return this.f3771IXxxXO;
    }

    public float XO() {
        return this.f3772Oxx0xo;
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new Oxx0IOOO(0.0f, 0.0f);
    }

    public Oxx0IOOO(float f, float f2) {
        this.f3771IXxxXO = f;
        this.f3772Oxx0xo = f2;
    }
}
