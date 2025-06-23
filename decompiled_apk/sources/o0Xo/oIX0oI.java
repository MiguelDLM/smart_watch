package o0Xo;

/* loaded from: classes12.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f31129I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31130II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f31131Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f31132X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f31133XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f31134oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f31135oxoX;

    public oIX0oI(float minValue, float maxValue, String descriptionText, int color) {
        this.f31132X0o0xo = minValue;
        this.f31133XO = maxValue;
        this.f31130II0xO0 = descriptionText;
        this.f31135oxoX = color;
    }

    public String I0Io() {
        return this.f31130II0xO0;
    }

    public void II0XooXoX(int color) {
        this.f31135oxoX = color;
    }

    public String II0xO0() {
        return this.f31134oIX0oI;
    }

    public void OOXIXo(float maxValue) {
        this.f31133XO = maxValue;
    }

    public String Oxx0IOOO() {
        return this.f31129I0Io;
    }

    public float X0o0xo() {
        return this.f31132X0o0xo;
    }

    public int XO() {
        return this.f31131Oxx0IOOO;
    }

    public int oIX0oI() {
        return this.f31135oxoX;
    }

    public void oOoXoXO(float minValue) {
        this.f31132X0o0xo = minValue;
    }

    public void ooOOo0oXI(int secondaryColor) {
        this.f31131Oxx0IOOO = secondaryColor;
    }

    public float oxoX() {
        return this.f31133XO;
    }

    public String toString() {
        return "Segment{descriptionText='" + this.f31130II0xO0 + "', color=" + this.f31135oxoX + ", minValue=" + this.f31132X0o0xo + ", maxValue=" + this.f31133XO + '}';
    }

    public oIX0oI x0XOIxOo(String topDescriptionText) {
        this.f31129I0Io = topDescriptionText;
        return this;
    }

    public oIX0oI xoIox(String descriptionText) {
        this.f31130II0xO0 = descriptionText;
        return this;
    }

    public void xxIXOIIO(String customText) {
        this.f31134oIX0oI = customText;
    }

    public oIX0oI(String customText, String descriptionText, int color) {
        this.f31132X0o0xo = -1.0f;
        this.f31133XO = -1.0f;
        this.f31134oIX0oI = customText;
        this.f31130II0xO0 = descriptionText;
        this.f31135oxoX = color;
    }

    public oIX0oI(float minValue, float maxValue, int color) {
        this.f31132X0o0xo = minValue;
        this.f31133XO = maxValue;
        this.f31135oxoX = color;
    }

    public oIX0oI(float minValue, float maxValue, int color, int secondaryColor) {
        this.f31132X0o0xo = minValue;
        this.f31133XO = maxValue;
        this.f31135oxoX = color;
        this.f31131Oxx0IOOO = secondaryColor;
    }

    public oIX0oI(float minValue, float maxValue, String customText, String descriptionText, int color) {
        this.f31132X0o0xo = minValue;
        this.f31133XO = maxValue;
        this.f31134oIX0oI = customText;
        this.f31130II0xO0 = descriptionText;
        this.f31135oxoX = color;
    }
}
