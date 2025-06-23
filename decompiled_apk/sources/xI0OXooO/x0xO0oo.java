package xI0OXooO;

import java.util.Objects;

/* loaded from: classes6.dex */
public class x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Integer f34137I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Integer f34138II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Integer f34139oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Integer f34140oxoX;

    public x0xO0oo(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f34139oIX0oI = num;
        this.f34138II0xO0 = num2;
        this.f34137I0Io = num3;
        this.f34140oxoX = num4;
    }

    public Integer I0Io() {
        return this.f34138II0xO0;
    }

    public Integer II0xO0() {
        return this.f34139oIX0oI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x0xO0oo x0xo0oo = (x0xO0oo) obj;
        if (Objects.equals(this.f34139oIX0oI, x0xo0oo.f34139oIX0oI) && Objects.equals(this.f34138II0xO0, x0xo0oo.f34138II0xO0) && Objects.equals(this.f34137I0Io, x0xo0oo.f34137I0Io) && Objects.equals(this.f34140oxoX, x0xo0oo.f34140oxoX)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f34139oIX0oI, this.f34138II0xO0, this.f34137I0Io, this.f34140oxoX);
    }

    public Integer oIX0oI() {
        return this.f34137I0Io;
    }

    public Integer oxoX() {
        return this.f34140oxoX;
    }

    public String toString() {
        return "Distance: " + this.f34139oIX0oI + ", Insert: " + this.f34138II0xO0 + ", Delete: " + this.f34137I0Io + ", Substitute: " + this.f34140oxoX;
    }
}
