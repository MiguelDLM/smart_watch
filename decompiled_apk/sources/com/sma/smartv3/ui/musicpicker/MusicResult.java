package com.sma.smartv3.ui.musicpicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes11.dex */
public class MusicResult implements Parcelable {
    public static final Parcelable.Creator<MusicResult> CREATOR = new oIX0oI();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f23675IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f23676IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f23677O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f23678Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f23679OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f23680Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f23681OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public String f23682X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f23683XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public String f23684XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public long f23685XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f23686o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public long f23687oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public String f23688xoXoI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements Parcelable.Creator<MusicResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public MusicResult[] newArray(int size) {
            return new MusicResult[size];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MusicResult createFromParcel(Parcel in) {
            return new MusicResult(in);
        }
    }

    public MusicResult(com.sma.smartv3.ui.musicpicker.oIX0oI music) {
        this.f23683XI0IXoo = 0;
        this.f23685XO = music.oOoXoXO();
        this.f23678Oo = music.x0xO0oo();
        this.f23676IXxxXO = music.oxoX();
        this.f23680Oxx0xo = music.OOXIXo();
        this.f23687oI0IIXIo = music.oO();
        this.f23681OxxIIOOXO = music.XO();
        this.f23675IIXOooo = music.IXxxXO();
        this.f23688xoXoI = music.II0XooXoX();
        this.f23679OxI = music.ooOOo0oXI();
        this.f23677O0xOxO = music.xoIox();
        this.f23682X0IIOO = music.Oxx0IOOO();
        this.f23683XI0IXoo = music.x0XOIxOo();
        this.f23684XIxXXX0x0 = music.Oo();
    }

    public String I0Io() {
        return this.f23682X0IIOO;
    }

    public int II0XooXoX() {
        return this.f23679OxI;
    }

    public String II0xO0() {
        return this.f23681OxxIIOOXO;
    }

    public void IIXOooo(int local) {
        this.f23679OxI = local;
    }

    public void IXxxXO(String coverUrl) {
        this.f23688xoXoI = coverUrl;
    }

    public void O0xOxO(String title) {
        this.f23678Oo = title;
    }

    public String OOXIXo() {
        return this.f23678Oo;
    }

    public void Oo(String auth) {
        this.f23682X0IIOO = auth;
    }

    public void OxI(long size) {
        this.f23687oI0IIXIo = size;
    }

    public long Oxx0IOOO() {
        return this.f23685XO;
    }

    public void Oxx0xo(int download) {
        this.f23677O0xOxO = download;
    }

    public void OxxIIOOXO(long id) {
        this.f23685XO = id;
    }

    public void X0IIOO(String uri) {
        this.f23684XIxXXX0x0 = uri;
    }

    public int X0o0xo() {
        return this.f23677O0xOxO;
    }

    public void XI0IXoo(String url) {
        this.f23675IIXOooo = url;
    }

    public int XO() {
        return this.f23680Oxx0xo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void o00(boolean selected) {
        this.f23686o00 = selected;
    }

    public void oI0IIXIo(int duration) {
        this.f23680Oxx0xo = duration;
    }

    public String oIX0oI() {
        return this.f23676IXxxXO;
    }

    public void oO(String album) {
        this.f23676IXxxXO = album;
    }

    public String oOoXoXO() {
        return this.f23684XIxXXX0x0;
    }

    public String ooOOo0oXI() {
        return this.f23675IIXOooo;
    }

    public String oxoX() {
        return this.f23688xoXoI;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f23685XO);
        dest.writeString(this.f23678Oo);
        dest.writeString(this.f23676IXxxXO);
        dest.writeInt(this.f23680Oxx0xo);
        dest.writeLong(this.f23687oI0IIXIo);
        dest.writeString(this.f23681OxxIIOOXO);
        dest.writeString(this.f23675IIXOooo);
        dest.writeString(this.f23688xoXoI);
        dest.writeInt(this.f23679OxI);
        dest.writeInt(this.f23677O0xOxO);
        dest.writeString(this.f23682X0IIOO);
        dest.writeInt(this.f23683XI0IXoo);
        dest.writeString(this.f23684XIxXXX0x0);
    }

    public boolean x0XOIxOo() {
        return this.f23686o00;
    }

    public void x0xO0oo(String artist) {
        this.f23681OxxIIOOXO = artist;
    }

    public long xoIox() {
        return this.f23687oI0IIXIo;
    }

    public void xoXoI(int position) {
        this.f23683XI0IXoo = position;
    }

    public int xxIXOIIO() {
        return this.f23683XI0IXoo;
    }

    public MusicResult(Parcel in) {
        this.f23683XI0IXoo = 0;
        this.f23685XO = in.readLong();
        this.f23678Oo = in.readString();
        this.f23676IXxxXO = in.readString();
        this.f23680Oxx0xo = in.readInt();
        this.f23687oI0IIXIo = in.readLong();
        this.f23681OxxIIOOXO = in.readString();
        this.f23675IIXOooo = in.readString();
        this.f23688xoXoI = in.readString();
        this.f23679OxI = in.readInt();
        this.f23677O0xOxO = in.readInt();
        this.f23682X0IIOO = in.readString();
        this.f23683XI0IXoo = in.readInt();
        this.f23684XIxXXX0x0 = in.readString();
    }
}
