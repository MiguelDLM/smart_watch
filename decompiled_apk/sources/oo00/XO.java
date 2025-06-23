package oo00;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f32204I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f32205II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f32206II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f32207OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public long f32208Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public AudioTrack f32209X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f32210XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final File f32211oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public final Runnable f32212oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f32213oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Integer, oXIO0o0XI> f32214xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public Handler f32215xxIXOIIO;

    public XO(@OOXIXo File pcmFile, int i, int i2, int i3) {
        IIX0o.x0xO0oo(pcmFile, "pcmFile");
        this.f32211oIX0oI = pcmFile;
        this.f32206II0xO0 = i;
        this.f32204I0Io = i2;
        this.f32213oxoX = i3;
        this.f32215xxIXOIIO = new Handler(Looper.getMainLooper());
        this.f32207OOXIXo = 2;
        this.f32207OOXIXo = i2 == 12 ? 4 : 2;
        this.f32208Oxx0IOOO = pcmFile.length() / this.f32207OOXIXo;
        this.f32212oOoXoXO = new Runnable() { // from class: oo00.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                XO.XO(XO.this);
            }
        };
    }

    public static final void Oxx0IOOO(XO this$0, int i) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo = this$0.f32214xoIox;
        if (oooxoxo != null) {
            oooxoxo.invoke(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f9, code lost:
    
        if (r3 >= r11.f32208Oxx0IOOO) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011a, code lost:
    
        if (r3 >= r11.f32208Oxx0IOOO) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14, types: [long] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void XO(final oo00.XO r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oo00.XO.XO(oo00.XO):void");
    }

    public static final void ooOOo0oXI(XO this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo = this$0.f32214xoIox;
        if (oooxoxo != null) {
            oooxoxo.invoke(0);
        }
    }

    public final void II0XooXoX(int i) {
        synchronized (this) {
            try {
                long oo2 = IIXOooo.oo(i * this.f32206II0xO0, 0L, this.f32208Oxx0IOOO);
                boolean z = this.f32210XO;
                if (z) {
                    oOoXoXO(false);
                }
                this.f32205II0XooXoX = (int) oo2;
                if (z) {
                    xoIox();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void OOXIXo() {
        oOoXoXO(true);
    }

    public final void X0o0xo() {
        synchronized (this) {
            this.f32210XO = false;
            AudioTrack audioTrack = this.f32209X0o0xo;
            if (audioTrack != null) {
                audioTrack.pause();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }
    }

    public final void oOoXoXO(boolean z) {
        synchronized (this) {
            try {
                this.f32210XO = false;
                AudioTrack audioTrack = this.f32209X0o0xo;
                if (audioTrack != null && audioTrack.getState() != 0) {
                    audioTrack.stop();
                    audioTrack.release();
                }
                this.f32209X0o0xo = null;
                if (z) {
                    this.f32205II0XooXoX = 0;
                    this.f32215xxIXOIIO.post(new Runnable() { // from class: oo00.oxoX
                        @Override // java.lang.Runnable
                        public final void run() {
                            XO.ooOOo0oXI(XO.this);
                        }
                    });
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int oxoX() {
        return (int) (this.f32208Oxx0IOOO / this.f32206II0xO0);
    }

    public final void xoIox() {
        synchronized (this) {
            if (this.f32210XO) {
                return;
            }
            this.f32210XO = true;
            new Thread(this.f32212oOoXoXO).start();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void xxIXOIIO(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.f32214xoIox = listener;
    }

    public /* synthetic */ XO(File file, int i, int i2, int i3, int i4, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(file, (i4 & 2) != 0 ? 16000 : i, (i4 & 4) != 0 ? 4 : i2, (i4 & 8) != 0 ? 2 : i3);
    }
}
