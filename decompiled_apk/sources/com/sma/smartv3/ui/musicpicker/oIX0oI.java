package com.sma.smartv3.ui.musicpicker;

/* loaded from: classes11.dex */
public class oIX0oI implements Comparable<oIX0oI> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f23689IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f23690IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f23691O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f23692Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f23693OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f23694Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f23695OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public String f23696X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f23697XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public String f23698XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public long f23699XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f23700o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public long f23701oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public String f23702xoXoI;

    public oIX0oI(long id, String title, String album, int duration, long size, String artist, String url, String coverUrl, int local) {
        this.f23699XO = id;
        this.f23692Oo = title;
        this.f23690IXxxXO = album;
        this.f23694Oxx0xo = duration;
        this.f23701oI0IIXIo = size;
        this.f23695OxxIIOOXO = artist;
        this.f23689IIXOooo = url;
        this.f23702xoXoI = coverUrl;
        this.f23693OxI = local;
    }

    @Override // java.lang.Comparable
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public int compareTo(oIX0oI other) {
        String str;
        String str2 = this.f23692Oo;
        if (str2 != null && (str = other.f23692Oo) != null) {
            return str2.compareTo(str);
        }
        return -1;
    }

    public String II0XooXoX() {
        return this.f23702xoXoI;
    }

    public void IIX0o(String url) {
        this.f23689IIXOooo = url;
    }

    public void IIXOooo(String auth) {
        this.f23696X0IIOO = auth;
    }

    public String IXxxXO() {
        return this.f23689IIXOooo;
    }

    public void O0xOxO(long id) {
        this.f23699XO = id;
    }

    public int OOXIXo() {
        return this.f23694Oxx0xo;
    }

    public String Oo() {
        return this.f23698XIxXXX0x0;
    }

    public void OxI(int duration) {
        this.f23694Oxx0xo = duration;
    }

    public String Oxx0IOOO() {
        return this.f23696X0IIOO;
    }

    public boolean Oxx0xo() {
        return this.f23700o00;
    }

    public void OxxIIOOXO(String artist) {
        this.f23695OxxIIOOXO = artist;
    }

    public void X0IIOO(int local) {
        this.f23693OxI = local;
    }

    public void XI0IXoo(int position) {
        this.f23697XI0IXoo = position;
    }

    public void XIxXXX0x0(boolean selected) {
        this.f23700o00 = selected;
    }

    public String XO() {
        return this.f23695OxxIIOOXO;
    }

    public void XxX0x0xxx(String title) {
        this.f23692Oo = title;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.f23699XO == ((oIX0oI) o).f23699XO) {
            return true;
        }
        return false;
    }

    public void o00(int download) {
        this.f23691O0xOxO = download;
    }

    public void oI0IIXIo(String album) {
        this.f23690IXxxXO = album;
    }

    public long oO() {
        return this.f23701oI0IIXIo;
    }

    public long oOoXoXO() {
        return this.f23699XO;
    }

    public int ooOOo0oXI() {
        return this.f23693OxI;
    }

    public String oxoX() {
        return this.f23690IXxxXO;
    }

    public int x0XOIxOo() {
        return this.f23697XI0IXoo;
    }

    public String x0xO0oo() {
        return this.f23692Oo;
    }

    public void xXxxox0I(String uri) {
        this.f23698XIxXXX0x0 = uri;
    }

    public int xoIox() {
        return this.f23691O0xOxO;
    }

    public void xoXoI(String coverUrl) {
        this.f23702xoXoI = coverUrl;
    }

    public void xxX(long size) {
        this.f23701oI0IIXIo = size;
    }

    public oIX0oI(long id, String title, String artist, String url, String coverUrl, int local) {
        this.f23699XO = id;
        this.f23692Oo = title;
        this.f23695OxxIIOOXO = artist;
        this.f23689IIXOooo = url;
        this.f23702xoXoI = coverUrl;
        this.f23693OxI = local;
    }

    public oIX0oI() {
    }

    public oIX0oI(long id) {
        this.f23699XO = id;
    }
}
