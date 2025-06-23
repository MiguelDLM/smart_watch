package x0xO0oo;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oxoX f34093I0Io = new oxoX("COMPOSITION");

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public X0o0xo f34094II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<String> f34095oIX0oI;

    public oxoX(String... strArr) {
        this.f34095oIX0oI = Arrays.asList(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean I0Io(String str, int i) {
        boolean z;
        boolean z2;
        if (i >= this.f34095oIX0oI.size()) {
            return false;
        }
        if (i == this.f34095oIX0oI.size() - 1) {
            z = true;
        } else {
            z = false;
        }
        String str2 = this.f34095oIX0oI.get(i);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if ((!z && (i != this.f34095oIX0oI.size() - 2 || !II0xO0())) || !z2) {
                return false;
            }
            return true;
        }
        if (!z && this.f34095oIX0oI.get(i + 1).equals(str)) {
            if (i != this.f34095oIX0oI.size() - 2 && (i != this.f34095oIX0oI.size() - 3 || !II0xO0())) {
                return false;
            }
            return true;
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f34095oIX0oI.size() - 1) {
            return false;
        }
        return this.f34095oIX0oI.get(i2).equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean II0XooXoX(String str, int i) {
        if (XO(str)) {
            return true;
        }
        if (i >= this.f34095oIX0oI.size()) {
            return false;
        }
        if (this.f34095oIX0oI.get(i).equals(str) || this.f34095oIX0oI.get(i).equals("**") || this.f34095oIX0oI.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public final boolean II0xO0() {
        return this.f34095oIX0oI.get(r0.size() - 1).equals("**");
    }

    public String Oxx0IOOO() {
        return this.f34095oIX0oI.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int X0o0xo(String str, int i) {
        if (XO(str)) {
            return 0;
        }
        if (!this.f34095oIX0oI.get(i).equals("**")) {
            return 1;
        }
        if (i == this.f34095oIX0oI.size() - 1 || !this.f34095oIX0oI.get(i + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public final boolean XO(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public oxoX oIX0oI(String str) {
        oxoX oxox = new oxoX(this);
        oxox.f34095oIX0oI.add(str);
        return oxox;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public X0o0xo oxoX() {
        return this.f34094II0xO0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f34095oIX0oI);
        sb.append(",resolved=");
        if (this.f34094II0xO0 != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append('}');
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public oxoX xoIox(X0o0xo x0o0xo) {
        oxoX oxox = new oxoX(this);
        oxox.f34094II0xO0 = x0o0xo;
        return oxox;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean xxIXOIIO(String str, int i) {
        if ("__container".equals(str) || i < this.f34095oIX0oI.size() - 1 || this.f34095oIX0oI.get(i).equals("**")) {
            return true;
        }
        return false;
    }

    public oxoX(oxoX oxox) {
        this.f34095oIX0oI = new ArrayList(oxox.f34095oIX0oI);
        this.f34094II0xO0 = oxox.f34094II0xO0;
    }
}
