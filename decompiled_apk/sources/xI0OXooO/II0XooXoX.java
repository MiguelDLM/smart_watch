package xI0OXooO;

import java.util.Objects;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f34120I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f34121II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34122oIX0oI;

    public II0XooXoX(int i, int i2, int i3) {
        if (i >= 0) {
            if (i2 >= 0) {
                if (i3 >= 0 && i3 <= Math.min(i, i2)) {
                    this.f34122oIX0oI = i;
                    this.f34121II0xO0 = i2;
                    this.f34120I0Io = i3;
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid intersection of |A| and |B|: " + i3);
                }
            }
            throw new IllegalArgumentException("Set size |B| is not positive: " + i2);
        }
        throw new IllegalArgumentException("Set size |A| is not positive: " + i);
    }

    public int I0Io() {
        return this.f34121II0xO0;
    }

    public int II0xO0() {
        return this.f34122oIX0oI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        II0XooXoX iI0XooXoX = (II0XooXoX) obj;
        if (this.f34122oIX0oI == iI0XooXoX.f34122oIX0oI && this.f34121II0xO0 == iI0XooXoX.f34121II0xO0 && this.f34120I0Io == iI0XooXoX.f34120I0Io) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f34122oIX0oI), Integer.valueOf(this.f34121II0xO0), Integer.valueOf(this.f34120I0Io));
    }

    public int oIX0oI() {
        return this.f34120I0Io;
    }

    public String toString() {
        return "Size A: " + this.f34122oIX0oI + ", Size B: " + this.f34121II0xO0 + ", Intersection: " + this.f34120I0Io;
    }
}
