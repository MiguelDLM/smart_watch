package xIOXX;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f34157I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f34158II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Map<String, String> f34159X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f34160oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f34161oxoX;

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f34162I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f34163II0xO0 = 3;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public Map<String, String> f34164X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f34165oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f34166oxoX;

        public oIX0oI(String str) {
            this.f34165oIX0oI = str;
        }

        public oIX0oI I0Io(String str, String str2) {
            if (this.f34164X0o0xo == null) {
                this.f34164X0o0xo = new HashMap(16);
            }
            this.f34164X0o0xo.put(str, str2);
            return this;
        }

        public oIX0oI II0XooXoX(int i) {
            this.f34162I0Io = i;
            return this;
        }

        public oIX0oI II0xO0(int i) {
            this.f34163II0xO0 = i;
            return this;
        }

        public oIX0oI XO(int i) {
            this.f34166oxoX = i;
            return this;
        }

        public oxoX oxoX() {
            return new oxoX(this);
        }
    }

    public oxoX(oIX0oI oix0oi) {
        this.f34160oIX0oI = oix0oi.f34165oIX0oI;
        this.f34158II0xO0 = oix0oi.f34163II0xO0;
        this.f34157I0Io = oix0oi.f34162I0Io;
        this.f34161oxoX = oix0oi.f34166oxoX;
        this.f34159X0o0xo = oix0oi.f34164X0o0xo;
    }

    public int II0xO0() {
        return this.f34158II0xO0;
    }

    public String oIX0oI() {
        return this.f34160oIX0oI;
    }
}
