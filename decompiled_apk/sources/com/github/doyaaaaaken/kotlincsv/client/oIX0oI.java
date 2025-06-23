package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final char f15767I0Io = 65279;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final C0572oIX0oI f15768II0xO0 = new C0572oIX0oI(null);

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final X0o0xo f15769oIX0oI;

    /* renamed from: com.github.doyaaaaaken.kotlincsv.client.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0572oIX0oI {
        public /* synthetic */ C0572oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public C0572oIX0oI() {
        }
    }

    public oIX0oI(@OOXIXo X0o0xo br) {
        IIX0o.x0xO0oo(br, "br");
        this.f15769oIX0oI = br;
    }

    @oOoXoXO
    public final String I0Io() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = this.f15769oIX0oI.read();
            if (read == -1) {
                if (II0xO0(sb)) {
                    return null;
                }
            } else {
                char c = (char) read;
                sb.append(c);
                if (c == '\n' || c == 8232 || c == 8233 || c == 133) {
                    break;
                }
                if (c == '\r') {
                    this.f15769oIX0oI.oIX0oI(1);
                    int read2 = this.f15769oIX0oI.read();
                    if (read2 != -1) {
                        if (((char) read2) == '\n') {
                            sb.append('\n');
                        } else {
                            this.f15769oIX0oI.reset();
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public final boolean II0xO0(StringBuilder sb) {
        if (sb.length() == 0) {
            return true;
        }
        if (sb.length() == 1 && sb.charAt(0) == 65279) {
            return true;
        }
        return false;
    }

    public final void oIX0oI() {
        this.f15769oIX0oI.close();
    }
}
