package ox;

import com.kuaishou.weapon.p0.t;
import java.text.DecimalFormat;

/* loaded from: classes9.dex */
public class ooOOo0oXI extends x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public DecimalFormat f33519I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33520II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String[] f33521oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f33522oxoX;

    public ooOOo0oXI() {
        this.f33521oIX0oI = new String[]{"", t.f18411a, "m", "b", "t"};
        this.f33520II0xO0 = 5;
        this.f33522oxoX = "";
        this.f33519I0Io = new DecimalFormat("###E00");
    }

    @Override // ox.x0xO0oo
    public String II0XooXoX(float f) {
        return ooOOo0oXI(f) + this.f33522oxoX;
    }

    public void oO(int i) {
        this.f33520II0xO0 = i;
    }

    public int oOoXoXO() {
        return 0;
    }

    public final String ooOOo0oXI(double d) {
        String format = this.f33519I0Io.format(d);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f33521oIX0oI[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.f33520II0xO0 && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }

    public void x0XOIxOo(String str) {
        this.f33522oxoX = str;
    }

    public void x0xO0oo(String[] strArr) {
        this.f33521oIX0oI = strArr;
    }

    public ooOOo0oXI(String str) {
        this();
        this.f33522oxoX = str;
    }
}
