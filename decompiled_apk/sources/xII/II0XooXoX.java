package xII;

import OXOo.OOXIXo;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class II0XooXoX extends II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final byte[] f34146I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final String f34147II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f34148oIX0oI;

    public II0XooXoX(@OOXIXo String mService, @OOXIXo String mCharacteristic, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mService, "mService");
        IIX0o.x0xO0oo(mCharacteristic, "mCharacteristic");
        IIX0o.x0xO0oo(mData, "mData");
        this.f34148oIX0oI = mService;
        this.f34147II0xO0 = mCharacteristic;
        this.f34146I0Io = mData;
    }

    @OOXIXo
    public final String I0Io() {
        return this.f34148oIX0oI;
    }

    @OOXIXo
    public final byte[] II0xO0() {
        return this.f34146I0Io;
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f34147II0xO0;
    }

    @OOXIXo
    public String toString() {
        return "WriteMessage(service='" + this.f34148oIX0oI + "', characteristic='" + this.f34147II0xO0 + "', data=" + ByteArrayExtKt.getMHexString(this.f34146I0Io);
    }
}
