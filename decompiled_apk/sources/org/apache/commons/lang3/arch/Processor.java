package org.apache.commons.lang3.arch;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes6.dex */
public class Processor {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Type f32634II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Arch f32635oIX0oI;

    /* loaded from: classes6.dex */
    public enum Arch {
        BIT_32("32-bit"),
        BIT_64("64-bit"),
        UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);

        private final String label;

        Arch(String str) {
            this.label = str;
        }

        public String getLabel() {
            return this.label;
        }
    }

    /* loaded from: classes6.dex */
    public enum Type {
        X86,
        IA_64,
        PPC,
        UNKNOWN
    }

    public Processor(Arch arch, Type type) {
        this.f32635oIX0oI = arch;
        this.f32634II0xO0 = type;
    }

    public boolean I0Io() {
        return Arch.BIT_32.equals(this.f32635oIX0oI);
    }

    public Type II0xO0() {
        return this.f32634II0xO0;
    }

    public boolean Oxx0IOOO() {
        return Type.X86.equals(this.f32634II0xO0);
    }

    public boolean X0o0xo() {
        return Type.IA_64.equals(this.f32634II0xO0);
    }

    public boolean XO() {
        return Type.PPC.equals(this.f32634II0xO0);
    }

    public Arch oIX0oI() {
        return this.f32635oIX0oI;
    }

    public boolean oxoX() {
        return Arch.BIT_64.equals(this.f32635oIX0oI);
    }
}
