package xXo;

/* loaded from: classes13.dex */
public class OxI implements Oxx0IOOO<String, String> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34691oIX0oI;

    public OxI() {
        this.f34691oIX0oI = -1;
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public String II0xO0(String str) {
        if (str == null) {
            return null;
        }
        if (this.f34691oIX0oI != -1) {
            str = str.trim();
            int length = str.length();
            int i = this.f34691oIX0oI;
            if (length > i) {
                return str.substring(0, i);
            }
        }
        return str.trim();
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(String str) {
        return II0xO0(str);
    }

    public OxI(int i) {
        if (i >= 0) {
            this.f34691oIX0oI = i;
            return;
        }
        throw new IllegalArgumentException("Maximum trim length must be positive");
    }
}
