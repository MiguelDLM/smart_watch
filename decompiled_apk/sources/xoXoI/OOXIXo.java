package xoXoI;

/* loaded from: classes.dex */
public class OOXIXo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f35156II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public float f35157oIX0oI;

    public OOXIXo(float f, float f2) {
        this.f35157oIX0oI = f;
        this.f35156II0xO0 = f2;
    }

    public float I0Io() {
        return this.f35156II0xO0;
    }

    public float II0xO0() {
        return this.f35157oIX0oI;
    }

    public boolean oIX0oI(float f, float f2) {
        if (this.f35157oIX0oI == f && this.f35156II0xO0 == f2) {
            return true;
        }
        return false;
    }

    public void oxoX(float f, float f2) {
        this.f35157oIX0oI = f;
        this.f35156II0xO0 = f2;
    }

    public String toString() {
        return II0xO0() + "x" + I0Io();
    }

    public OOXIXo() {
        this(1.0f, 1.0f);
    }
}
