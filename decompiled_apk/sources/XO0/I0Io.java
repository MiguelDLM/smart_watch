package XO0;

/* loaded from: classes6.dex */
public final class I0Io {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f3831oxoX = "default_tag";

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f3832I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3833II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Class<?> f3834oIX0oI;

    public I0Io(Class<?> cls) {
        this(cls, f3831oxoX);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || I0Io.class != obj.getClass()) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        Class<?> cls = this.f3834oIX0oI;
        if (cls == null) {
            if (i0Io.f3834oIX0oI != null) {
                return false;
            }
        } else if (!cls.equals(i0Io.f3834oIX0oI)) {
            return false;
        }
        String str = this.f3833II0xO0;
        if (str == null) {
            if (i0Io.f3833II0xO0 != null) {
                return false;
            }
        } else if (!str.equals(i0Io.f3833II0xO0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        Class<?> cls = this.f3834oIX0oI;
        int i = 0;
        if (cls == null) {
            hashCode = 0;
        } else {
            hashCode = cls.hashCode();
        }
        int i2 = (hashCode + 31) * 31;
        String str = this.f3833II0xO0;
        if (str != null) {
            i = str.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "EventType [paramClass=" + this.f3834oIX0oI.getName() + ", tag=" + this.f3833II0xO0 + "]";
    }

    public I0Io(Class<?> cls, String str) {
        this.f3834oIX0oI = cls;
        this.f3833II0xO0 = str;
    }
}
