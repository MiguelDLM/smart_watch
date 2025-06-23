package XOxIOxOx;

import com.bestmafen.baseble.scanner.BleDevice;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;

/* loaded from: classes8.dex */
public final class I0Io implements X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f3951oIX0oI;

    public I0Io(@OXOo.OOXIXo String mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        this.f3951oIX0oI = mAddress;
    }

    public final void I0Io(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f3951oIX0oI = str;
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        return this.f3951oIX0oI;
    }

    @Override // XOxIOxOx.X0o0xo
    public boolean oIX0oI(@OXOo.OOXIXo BleDevice device) {
        IIX0o.x0xO0oo(device, "device");
        return OxI.oX0I0O(this.f3951oIX0oI, device.getMBluetoothDevice().getAddress(), true);
    }
}
