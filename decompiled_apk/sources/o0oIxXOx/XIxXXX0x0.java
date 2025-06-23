package o0oIxXOx;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.commons.text.lookup.DefaultStringLookup;

/* loaded from: classes6.dex */
public final class XIxXXX0x0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f31159II0XooXoX = "base64Encoder";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f31161IIXOooo = "urlEncoder";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f31162IXxxXO = "script";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f31163OOXIXo = "dns";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f31164Oo = "resourceBundle";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f31165Oxx0IOOO = "base64Decoder";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f31166Oxx0xo = "sys";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f31167OxxIIOOXO = "urlDecoder";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f31170oI0IIXIo = "url";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f31172oO = "localhost";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f31173oOoXoXO = "env";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f31174ooOOo0oXI = "file";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f31176x0XOIxOo = "java";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f31177x0xO0oo = "properties";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f31178xoIox = "date";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f31179xoXoI = "xml";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f31180xxIXOIIO = "const";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final XIxXXX0x0 f31171oIX0oI = new XIxXXX0x0();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final OOXIXo<String> f31160II0xO0 = OOXIXo.II0XooXoX(new Function() { // from class: o0oIxXOx.o00
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String OxxIIOOXO2;
            OxxIIOOXO2 = XIxXXX0x0.OxxIIOOXO((String) obj);
            return OxxIIOOXO2;
        }
    });

    /* renamed from: I0Io, reason: collision with root package name */
    public static final OOXIXo<String> f31158I0Io = OOXIXo.II0XooXoX(new Function() { // from class: o0oIxXOx.OxI
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String IIXOooo2;
            IIXOooo2 = XIxXXX0x0.IIXOooo((String) obj);
            return IIXOooo2;
        }
    });

    /* renamed from: oxoX, reason: collision with root package name */
    public static final OOXIXo<String> f31175oxoX = OOXIXo.II0XooXoX(new Function() { // from class: o0oIxXOx.O0xOxO
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return System.getenv((String) obj);
        }
    });

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final OOXIXo<String> f31168X0o0xo = OOXIXo.II0XooXoX(new Function() { // from class: o0oIxXOx.X0IIOO
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String xoXoI2;
            xoXoI2 = XIxXXX0x0.xoXoI((String) obj);
            return xoXoI2;
        }
    });

    /* renamed from: XO, reason: collision with root package name */
    public static final OOXIXo<String> f31169XO = OOXIXo.II0XooXoX(new Function() { // from class: o0oIxXOx.XI0IXoo
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return System.getProperty((String) obj);
        }
    });

    public static /* synthetic */ String IIXOooo(String str) {
        Base64.Encoder encoder;
        String encodeToString;
        encoder = Base64.getEncoder();
        encodeToString = encoder.encodeToString(str.getBytes(StandardCharsets.ISO_8859_1));
        return encodeToString;
    }

    public static /* synthetic */ String OxxIIOOXO(String str) {
        Base64.Decoder decoder;
        byte[] decode;
        decoder = Base64.getDecoder();
        decode = decoder.decode(str);
        return new String(decode, StandardCharsets.ISO_8859_1);
    }

    public static /* synthetic */ String xoXoI(String str) {
        return null;
    }

    public static void xxIXOIIO() {
        XO.Oxx0IOOO();
    }

    public <R, U> X0o0xo<U> II0XooXoX(BiFunction<String, U, R> biFunction) {
        return I0Io.X0o0xo(biFunction);
    }

    public OxxIIOOXO IIX0o() {
        return XxX0x0xxx.f31184I0Io;
    }

    public OxxIIOOXO IXxxXO(Map<String, OxxIIOOXO> map, OxxIIOOXO oxxIIOOXO, boolean z) {
        return new x0XOIxOo(map, oxxIIOOXO, z);
    }

    public OxxIIOOXO O0xOxO() {
        return f31168X0o0xo;
    }

    public OxxIIOOXO OOXIXo() {
        return Oxx0IOOO.f31155I0Io;
    }

    public <V> OxxIIOOXO Oo(Map<String, V> map) {
        return new x0XOIxOo(map);
    }

    public <V> OxxIIOOXO OxI(Map<String, V> map) {
        return OOXIXo.Oxx0IOOO(map);
    }

    @Deprecated
    public OxxIIOOXO Oxx0IOOO() {
        return f31160II0xO0;
    }

    public OxxIIOOXO Oxx0xo(OxxIIOOXO oxxIIOOXO) {
        return new x0XOIxOo(oxxIIOOXO);
    }

    public OxxIIOOXO X0IIOO() {
        return IXxxXO.f31152I0Io;
    }

    public OxxIIOOXO X0o0xo() {
        return f31160II0xO0;
    }

    public OxxIIOOXO XI0IXoo() {
        return Oxx0xo.f31156oxoX;
    }

    public OxxIIOOXO XIxXXX0x0(String str) {
        return new Oxx0xo(str);
    }

    public OxxIIOOXO XO() {
        return f31158I0Io;
    }

    public OxxIIOOXO XxX0x0xxx() {
        return f31169XO;
    }

    public OxxIIOOXO o00() {
        return x0xO0oo.f31202I0Io;
    }

    public OxxIIOOXO oI0IIXIo() {
        return oO.f31188I0Io;
    }

    public <R> OxxIIOOXO oO(Function<String, R> function) {
        return OOXIXo.II0XooXoX(function);
    }

    public OxxIIOOXO oOoXoXO() {
        return II0XooXoX.f31149I0Io;
    }

    public OxxIIOOXO ooOOo0oXI() {
        return f31175oxoX;
    }

    public OxxIIOOXO ooXIXxIX() {
        return xXxxox0I.f31203I0Io;
    }

    public void oxoX(Map<String, OxxIIOOXO> map) {
        if (map != null) {
            map.put("base64", f31160II0xO0);
            for (DefaultStringLookup defaultStringLookup : DefaultStringLookup.values()) {
                map.put(x0XOIxOo.II0XooXoX(defaultStringLookup.getKey()), defaultStringLookup.getStringLookup());
            }
        }
    }

    public OxxIIOOXO x0XOIxOo() {
        return xxIXOIIO.f31205I0Io;
    }

    public OxxIIOOXO x0xO0oo() {
        return x0XOIxOo.f31198X0o0xo;
    }

    public OxxIIOOXO xI() {
        return IIX0o.f31151I0Io;
    }

    public OxxIIOOXO xXxxox0I() {
        return xxX.f31206I0Io;
    }

    public OxxIIOOXO xoIox() {
        return XO.f31182X0o0xo;
    }

    public OxxIIOOXO xxX() {
        return oI0IIXIo.f31185I0Io;
    }
}
