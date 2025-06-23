package I00O;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes13.dex */
public class I0Io implements Runnable {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final Reader f37IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final X0o0xo<I00O.oIX0oI> f38IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public oxoX<I00O.oIX0oI> f40Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final ArrayBlockingQueue<Object> f42XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f43oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final Thread f44xoXoI;

    /* renamed from: Oo, reason: collision with root package name */
    public final I00O.oIX0oI f39Oo = new I00O.oIX0oI(-1);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f41OxxIIOOXO = true;

    /* loaded from: classes13.dex */
    public class oIX0oI extends X0o0xo<I00O.oIX0oI> {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final /* synthetic */ int f46Oxx0IOOO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(int i, int i2) {
            super(i);
            this.f46Oxx0IOOO = i2;
        }

        @Override // I00O.X0o0xo
        /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
        public I00O.oIX0oI II0xO0() {
            return new I00O.oIX0oI(this.f46Oxx0IOOO);
        }
    }

    public I0Io(Reader reader, int i, int i2) {
        this.f43oI0IIXIo = false;
        this.f42XO = new ArrayBlockingQueue<>(i2);
        this.f37IIXOooo = reader;
        this.f38IXxxXO = new oIX0oI(i2, i);
        this.f43oI0IIXIo = false;
        Thread thread = new Thread(this, "unVocity-parsers input reading thread");
        this.f44xoXoI = thread;
        thread.start();
    }

    public void II0xO0() {
        IllegalStateException illegalStateException;
        this.f41OxxIIOOXO = false;
        try {
            try {
                this.f37IIXOooo.close();
                try {
                    this.f44xoXoI.interrupt();
                } finally {
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error closing input", e);
            }
        } catch (Throwable th) {
            try {
                this.f44xoXoI.interrupt();
                throw th;
            } finally {
            }
        }
    }

    public synchronized I00O.oIX0oI oIX0oI() {
        try {
            if (this.f43oI0IIXIo) {
                return this.f39Oo;
            }
            oxoX<I00O.oIX0oI> oxox = this.f40Oxx0xo;
            if (oxox != null) {
                this.f38IXxxXO.I0Io(oxox);
            }
            Object take = this.f42XO.take();
            I00O.oIX0oI oix0oi = this.f39Oo;
            if (take == oix0oi) {
                this.f43oI0IIXIo = true;
                return oix0oi;
            }
            oxoX<I00O.oIX0oI> oxox2 = (oxoX) take;
            this.f40Oxx0xo = oxox2;
            return oxox2.oIX0oI();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.f43oI0IIXIo = true;
            return this.f39Oo;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int oIX0oI2;
        Thread.currentThread().setName("Character reading thread");
        do {
            try {
                try {
                    try {
                        try {
                            oxoX<I00O.oIX0oI> oIX0oI3 = this.f38IXxxXO.oIX0oI();
                            oIX0oI2 = oIX0oI3.oIX0oI().oIX0oI(this.f37IIXOooo);
                            if (oIX0oI2 != -1) {
                                this.f42XO.put(oIX0oI3);
                            } else {
                                this.f38IXxxXO.I0Io(oIX0oI3);
                            }
                            if (!this.f41OxxIIOOXO) {
                                break;
                            }
                        } catch (Throwable th) {
                            this.f42XO.put(this.f39Oo);
                            throw th;
                        }
                    } catch (IOException e) {
                        throw new IllegalStateException("Error processing input", e);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                II0xO0();
            }
        } while (oIX0oI2 != -1);
        this.f42XO.put(this.f39Oo);
    }
}
