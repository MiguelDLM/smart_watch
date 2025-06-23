package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f5133I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public final oI0IIXIo.oxoX f5134II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @Nullable
    public final oI0IIXIo.X0o0xo f5135oIX0oI;

    /* loaded from: classes.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public boolean f5136I0Io = false;

        /* renamed from: II0xO0, reason: collision with root package name */
        @Nullable
        public oI0IIXIo.oxoX f5137II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @Nullable
        public oI0IIXIo.X0o0xo f5138oIX0oI;

        /* renamed from: com.airbnb.lottie.xxIXOIIO$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0099II0xO0 implements oI0IIXIo.oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ oI0IIXIo.oxoX f5140oIX0oI;

            public C0099II0xO0(oI0IIXIo.oxoX oxox) {
                this.f5140oIX0oI = oxox;
            }

            @Override // oI0IIXIo.oxoX
            @NonNull
            public File oIX0oI() {
                File oIX0oI2 = this.f5140oIX0oI.oIX0oI();
                if (oIX0oI2.isDirectory()) {
                    return oIX0oI2;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements oI0IIXIo.oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ File f5142oIX0oI;

            public oIX0oI(File file) {
                this.f5142oIX0oI = file;
            }

            @Override // oI0IIXIo.oxoX
            @NonNull
            public File oIX0oI() {
                if (this.f5142oIX0oI.isDirectory()) {
                    return this.f5142oIX0oI;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public II0xO0 I0Io(@NonNull File file) {
            if (this.f5137II0xO0 == null) {
                this.f5137II0xO0 = new oIX0oI(file);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public II0xO0 II0xO0(boolean z) {
            this.f5136I0Io = z;
            return this;
        }

        @NonNull
        public II0xO0 X0o0xo(@NonNull oI0IIXIo.X0o0xo x0o0xo) {
            this.f5138oIX0oI = x0o0xo;
            return this;
        }

        @NonNull
        public xxIXOIIO oIX0oI() {
            return new xxIXOIIO(this.f5138oIX0oI, this.f5137II0xO0, this.f5136I0Io);
        }

        @NonNull
        public II0xO0 oxoX(@NonNull oI0IIXIo.oxoX oxox) {
            if (this.f5137II0xO0 == null) {
                this.f5137II0xO0 = new C0099II0xO0(oxox);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }
    }

    public xxIXOIIO(@Nullable oI0IIXIo.X0o0xo x0o0xo, @Nullable oI0IIXIo.oxoX oxox, boolean z) {
        this.f5135oIX0oI = x0o0xo;
        this.f5134II0xO0 = oxox;
        this.f5133I0Io = z;
    }
}
