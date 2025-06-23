package XOxIOxOx;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Looper;
import com.bestmafen.baseble.scanner.ScanMode;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public abstract class II0xO0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f3956OOXIXo = 10;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3957xoIox = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final BluetoothAdapter f3958I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3959II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public ScanMode f3960II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public X0o0xo f3961Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public volatile boolean f3962X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oxoX f3963XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final UUID[] f3964oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Handler f3965oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Runnable f3966xxIXOIIO;

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static final void xoIox(II0xO0 this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.oOoXoXO(false);
    }

    @OXOo.oOoXoXO
    public final oxoX I0Io() {
        return this.f3963XO;
    }

    @OXOo.oOoXoXO
    public final UUID[] II0XooXoX() {
        return this.f3964oIX0oI;
    }

    public void II0xO0() {
        oOoXoXO(false);
        this.f3963XO = null;
    }

    @OXOo.OOXIXo
    public final II0xO0 IXxxXO(@OXOo.OOXIXo X0o0xo filter) {
        IIX0o.x0xO0oo(filter, "filter");
        this.f3961Oxx0IOOO = filter;
        return this;
    }

    public final void OOXIXo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AbsBleScanner -> removeStop");
        this.f3965oxoX.removeCallbacks(this.f3966xxIXOIIO);
    }

    @OXOo.OOXIXo
    public final II0xO0 Oo(int i) {
        this.f3959II0XooXoX = i;
        return this;
    }

    @OXOo.OOXIXo
    public final ScanMode Oxx0IOOO() {
        return this.f3960II0xO0;
    }

    public final void Oxx0xo(boolean z) {
        this.f3962X0o0xo = z;
    }

    @OXOo.OOXIXo
    public final Handler X0o0xo() {
        return this.f3965oxoX;
    }

    @OXOo.oOoXoXO
    public final X0o0xo XO() {
        return this.f3961Oxx0IOOO;
    }

    public final void oI0IIXIo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AbsBleScanner -> stopScanDelay");
        this.f3965oxoX.postDelayed(this.f3966xxIXOIIO, this.f3959II0XooXoX * 1000);
    }

    public final void oO(@OXOo.oOoXoXO X0o0xo x0o0xo) {
        this.f3961Oxx0IOOO = x0o0xo;
    }

    public abstract void oOoXoXO(boolean z);

    @OXOo.OOXIXo
    public final II0xO0 ooOOo0oXI(@OXOo.oOoXoXO oxoX oxox) {
        this.f3963XO = oxox;
        return this;
    }

    @OXOo.OOXIXo
    public final BluetoothAdapter oxoX() {
        return this.f3958I0Io;
    }

    public final void x0XOIxOo(@OXOo.oOoXoXO oxoX oxox) {
        this.f3963XO = oxox;
    }

    public final void x0xO0oo(@OXOo.OOXIXo ScanMode scanMode) {
        IIX0o.x0xO0oo(scanMode, "<set-?>");
        this.f3960II0xO0 = scanMode;
    }

    public final boolean xxIXOIIO() {
        return this.f3962X0o0xo;
    }

    public II0xO0(@OXOo.oOoXoXO UUID[] uuidArr, @OXOo.OOXIXo ScanMode mScanMode) {
        IIX0o.x0xO0oo(mScanMode, "mScanMode");
        this.f3964oIX0oI = uuidArr;
        this.f3960II0xO0 = mScanMode;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        IIX0o.oO(defaultAdapter, "getDefaultAdapter(...)");
        this.f3958I0Io = defaultAdapter;
        this.f3965oxoX = new Handler(Looper.getMainLooper());
        this.f3959II0XooXoX = 10;
        this.f3966xxIXOIIO = new Runnable() { // from class: XOxIOxOx.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                II0xO0.xoIox(II0xO0.this);
            }
        };
    }

    public /* synthetic */ II0xO0(UUID[] uuidArr, ScanMode scanMode, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : uuidArr, (i & 2) != 0 ? ScanMode.BALANCED : scanMode);
    }
}
