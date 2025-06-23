package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import oI0IIXIo.X0o0xo;
import oI0IIXIo.oxoX;

public class xxIXOIIO {

    /* renamed from: I0Io  reason: collision with root package name */
    public final boolean f1139I0Io;
    @Nullable

    /* renamed from: II0xO0  reason: collision with root package name */
    public final oxoX f1140II0xO0;
    @Nullable

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final X0o0xo f1141oIX0oI;

    public static final class II0xO0 {

        /* renamed from: I0Io  reason: collision with root package name */
        public boolean f1142I0Io = false;
        @Nullable

        /* renamed from: II0xO0  reason: collision with root package name */
        public oxoX f1143II0xO0;
        @Nullable

        /* renamed from: oIX0oI  reason: collision with root package name */
        public X0o0xo f1144oIX0oI;

        /* renamed from: com.airbnb.lottie.xxIXOIIO$II0xO0$II0xO0  reason: collision with other inner class name */
        public class C0019II0xO0 implements oxoX {

            /* renamed from: oIX0oI  reason: collision with root package name */
            public final /* synthetic */ oxoX f1146oIX0oI;

            public C0019II0xO0(oxoX oxox) {
                this.f1146oIX0oI = oxox;
            }

            @NonNull
            public File oIX0oI() {
                File oIX0oI2 = this.f1146oIX0oI.oIX0oI();
                if (oIX0oI2.isDirectory()) {
                    return oIX0oI2;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        public class oIX0oI implements oxoX {

            /* renamed from: oIX0oI  reason: collision with root package name */
            public final /* synthetic */ File f1148oIX0oI;

            public oIX0oI(File file) {
                this.f1148oIX0oI = file;
            }

            @NonNull
            public File oIX0oI() {
                if (this.f1148oIX0oI.isDirectory()) {
                    return this.f1148oIX0oI;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public II0xO0 I0Io(@NonNull File file) {
            if (this.f1143II0xO0 == null) {
                this.f1143II0xO0 = new oIX0oI(file);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public II0xO0 II0xO0(boolean z) {
            this.f1142I0Io = z;
            return this;
        }

        @NonNull
        public II0xO0 X0o0xo(@NonNull X0o0xo x0o0xo) {
            this.f1144oIX0oI = x0o0xo;
            return this;
        }

        @NonNull
        public xxIXOIIO oIX0oI() {
            return new xxIXOIIO(this.f1144oIX0oI, this.f1143II0xO0, this.f1142I0Io);
        }

        @NonNull
        public II0xO0 oxoX(@NonNull oxoX oxox) {
            if (this.f1143II0xO0 == null) {
                this.f1143II0xO0 = new C0019II0xO0(oxox);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }
    }

    public xxIXOIIO(@Nullable X0o0xo x0o0xo, @Nullable oxoX oxox, boolean z) {
        this.f1141oIX0oI = x0o0xo;
        this.f1140II0xO0 = oxox;
        this.f1139I0Io = z;
    }
}
