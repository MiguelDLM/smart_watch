package oXxOXOX;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@SuppressLint({TtmlNode.COMBINE_ALL})
@IgnoreJRERequirement
/* loaded from: classes6.dex */
public final class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final boolean f32185II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f32186oIX0oI = new II0xO0();

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements ClassFileTransformer {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public static final oIX0oI f32187oIX0oI = new oIX0oI();

        @oOoXoXO
        public byte[] oIX0oI(@oOoXoXO ClassLoader classLoader, @OOXIXo String str, @oOoXoXO Class<?> cls, @OOXIXo ProtectionDomain protectionDomain, @oOoXoXO byte[] bArr) {
            if (classLoader != null && IIX0o.Oxx0IOOO(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                kotlinx.coroutines.debug.internal.oIX0oI.f29949oIX0oI.II0xO0(true);
                return kotlin.io.oIX0oI.x0xO0oo(classLoader.getResourceAsStream("DebugProbesKt.bin"));
            }
            return null;
        }
    }

    static {
        Object m287constructorimpl;
        boolean OxxIIOOXO2;
        Boolean bool;
        Object obj = null;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            if (property != null) {
                bool = Boolean.valueOf(Boolean.parseBoolean(property));
            } else {
                bool = null;
            }
            m287constructorimpl = Result.m287constructorimpl(bool);
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
        }
        if (!Result.m293isFailureimpl(m287constructorimpl)) {
            obj = m287constructorimpl;
        }
        Boolean bool2 = (Boolean) obj;
        if (bool2 != null) {
            OxxIIOOXO2 = bool2.booleanValue();
        } else {
            OxxIIOOXO2 = DebugProbesImpl.f29924oIX0oI.OxxIIOOXO();
        }
        f32185II0xO0 = OxxIIOOXO2;
    }

    public static final void I0Io(Signal signal) {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f29924oIX0oI;
        if (debugProbesImpl.X0IIOO()) {
            debugProbesImpl.XO(System.out);
        } else {
            System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @x0XOIxOo
    public static final void oxoX(@oOoXoXO String str, @OOXIXo Instrumentation instrumentation) {
        kotlinx.coroutines.debug.internal.oIX0oI.f29949oIX0oI.II0xO0(true);
        instrumentation.addTransformer(oIX0oI.f32187oIX0oI);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f29924oIX0oI;
        debugProbesImpl.IoOoX(f32185II0xO0);
        debugProbesImpl.OxI();
        f32186oIX0oI.II0xO0();
    }

    public final void II0xO0() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: oXxOXOX.oIX0oI
                public final void oIX0oI(Signal signal) {
                    II0xO0.I0Io(signal);
                }
            });
        } catch (Throwable unused) {
        }
    }
}
