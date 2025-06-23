package me.zheteng.countrycodeselector;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes6.dex */
public class Country implements Parcelable {
    public static final Parcelable.Creator<Country> CREATOR = new oIX0oI();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public List<String> f30970IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f30971IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f30972Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f30973Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f30974OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public String f30975XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f30976oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public List<String> f30977xoXoI;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Parcelable.Creator<Country> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public Country[] newArray(int i) {
            return new Country[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }
    }

    public Country() {
    }

    public String I0Io() {
        return this.f30973Oxx0xo;
    }

    public List<String> II0XooXoX() {
        return this.f30970IIXOooo;
    }

    public String II0xO0() {
        return this.f30975XO;
    }

    public void OOXIXo(String str) {
        this.f30973Oxx0xo = str;
    }

    public List<String> Oxx0IOOO() {
        return this.f30977xoXoI;
    }

    public String X0o0xo() {
        return this.f30972Oo;
    }

    public String XO() {
        return this.f30974OxxIIOOXO;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String oIX0oI() {
        return this.f30971IXxxXO;
    }

    public void oO(List<String> list) {
        this.f30977xoXoI = list;
    }

    public void oOoXoXO(String str) {
        this.f30976oI0IIXIo = str;
    }

    public void ooOOo0oXI(String str) {
        this.f30972Oo = str;
    }

    public String oxoX() {
        return this.f30976oI0IIXIo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30975XO);
        parcel.writeString(this.f30972Oo);
        parcel.writeString(this.f30971IXxxXO);
        parcel.writeString(this.f30973Oxx0xo);
        parcel.writeString(this.f30976oI0IIXIo);
        parcel.writeString(this.f30974OxxIIOOXO);
        parcel.writeStringList(this.f30970IIXOooo);
        parcel.writeStringList(this.f30977xoXoI);
    }

    public void x0XOIxOo(String str) {
        this.f30974OxxIIOOXO = str;
    }

    public void x0xO0oo(List<String> list) {
        this.f30970IIXOooo = list;
    }

    public void xoIox(String str) {
        this.f30975XO = str;
    }

    public void xxIXOIIO(String str) {
        this.f30971IXxxXO = str;
    }

    public Country(Parcel parcel) {
        this.f30975XO = parcel.readString();
        this.f30972Oo = parcel.readString();
        this.f30971IXxxXO = parcel.readString();
        this.f30973Oxx0xo = parcel.readString();
        this.f30976oI0IIXIo = parcel.readString();
        this.f30974OxxIIOOXO = parcel.readString();
        this.f30970IIXOooo = parcel.createStringArrayList();
        this.f30977xoXoI = parcel.createStringArrayList();
    }
}
