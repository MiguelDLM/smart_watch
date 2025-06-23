package ox;

import java.util.Collection;

/* loaded from: classes9.dex */
public class oOoXoXO extends x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33517II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String[] f33518oIX0oI;

    public oOoXoXO() {
        this.f33518oIX0oI = new String[0];
        this.f33517II0xO0 = 0;
    }

    @Override // ox.x0xO0oo
    public String II0XooXoX(float f) {
        int round = Math.round(f);
        if (round >= 0 && round < this.f33517II0xO0 && round == ((int) f)) {
            return this.f33518oIX0oI[round];
        }
        return "";
    }

    public String[] oOoXoXO() {
        return this.f33518oIX0oI;
    }

    public void ooOOo0oXI(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f33518oIX0oI = strArr;
        this.f33517II0xO0 = strArr.length;
    }

    public oOoXoXO(String[] strArr) {
        this.f33518oIX0oI = new String[0];
        this.f33517II0xO0 = 0;
        if (strArr != null) {
            ooOOo0oXI(strArr);
        }
    }

    public oOoXoXO(Collection<String> collection) {
        this.f33518oIX0oI = new String[0];
        this.f33517II0xO0 = 0;
        if (collection != null) {
            ooOOo0oXI((String[]) collection.toArray(new String[collection.size()]));
        }
    }
}
