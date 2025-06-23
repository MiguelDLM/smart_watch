package xXo;

/* loaded from: classes13.dex */
public class IIXOooo implements Oxx0IOOO<String, String> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f34683II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f34684oIX0oI;

    public IIXOooo(String str, String str2) {
        this.f34684oIX0oI = str;
        this.f34683II0xO0 = str2;
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public String II0xO0(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(this.f34684oIX0oI, this.f34683II0xO0);
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(String str) {
        return II0xO0(str);
    }
}
