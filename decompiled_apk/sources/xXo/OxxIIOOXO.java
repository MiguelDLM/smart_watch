package xXo;

/* loaded from: classes13.dex */
public abstract class OxxIIOOXO<T> implements Oxx0IOOO<String, T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f34694II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public T f34695oIX0oI;

    public OxxIIOOXO() {
        this(null, null);
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(T t) {
        if (t == null) {
            return this.f34694II0xO0;
        }
        return String.valueOf(t);
    }

    public T Oxx0IOOO() {
        return this.f34695oIX0oI;
    }

    public abstract T X0o0xo(String str);

    public String XO() {
        return this.f34694II0xO0;
    }

    @Override // xXo.Oxx0IOOO
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public T II0xO0(String str) {
        if (str == null) {
            return this.f34695oIX0oI;
        }
        return X0o0xo(str);
    }

    public void xoIox(T t) {
        this.f34695oIX0oI = t;
    }

    public void xxIXOIIO(String str) {
        this.f34694II0xO0 = str;
    }

    public OxxIIOOXO(T t, String str) {
        this.f34695oIX0oI = t;
        this.f34694II0xO0 = str;
    }
}
