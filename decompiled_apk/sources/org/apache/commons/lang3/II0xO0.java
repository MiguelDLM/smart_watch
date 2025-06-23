package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.apache.commons.lang3.arch.Processor;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Map<String, Processor> f32490oIX0oI = new HashMap();

    static {
        XO();
    }

    public static void I0Io(final Processor processor, String... strArr) {
        Stream of;
        of = Stream.of((Object[]) strArr);
        of.forEach(new Consumer() { // from class: org.apache.commons.lang3.oIX0oI
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                II0xO0.II0xO0((String) obj, Processor.this);
            }
        });
    }

    public static void II0XooXoX() {
        I0Io(new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64), "ia64", "ia64w");
    }

    public static void II0xO0(String str, Processor processor) {
        Map<String, Processor> map = f32490oIX0oI;
        if (!map.containsKey(str)) {
            map.put(str, processor);
            return;
        }
        throw new IllegalStateException("Key " + str + " already exists in processor map");
    }

    public static void OOXIXo() {
        I0Io(new Processor(Processor.Arch.BIT_32, Processor.Type.X86), "x86", "i386", "i486", "i586", "i686", "pentium");
    }

    public static void Oxx0IOOO() {
        I0Io(new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64), "ia64_32", "ia64n");
    }

    public static Processor X0o0xo(String str) {
        return f32490oIX0oI.get(str);
    }

    public static void XO() {
        OOXIXo();
        oOoXoXO();
        Oxx0IOOO();
        II0XooXoX();
        xxIXOIIO();
        xoIox();
    }

    public static void oOoXoXO() {
        I0Io(new Processor(Processor.Arch.BIT_64, Processor.Type.X86), "x86_64", "amd64", "em64t", "universal");
    }

    public static Processor oxoX() {
        return X0o0xo(XX0.f32580Xx000oIo);
    }

    public static void xoIox() {
        I0Io(new Processor(Processor.Arch.BIT_64, Processor.Type.PPC), "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    public static void xxIXOIIO() {
        I0Io(new Processor(Processor.Arch.BIT_32, Processor.Type.PPC), "ppc", "power", "powerpc", "power_pc", "power_rs");
    }
}
