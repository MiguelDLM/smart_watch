package com.szabh.smable3.ota;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public final class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public String f26490I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public oIX0oI f26491II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final Context f26492oIX0oI;

    public oxoX(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.f26492oIX0oI = context;
        this.f26490I0Io = BleCache.INSTANCE.getMBleAddress();
    }

    public final void I0Io(@OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        this.f26490I0Io = address;
    }

    public final void II0xO0() {
        oIX0oI oix0oi = this.f26491II0xO0;
        if (oix0oi != null) {
            oix0oi.X0o0xo();
        }
    }

    @OOXIXo
    public final Context oIX0oI() {
        return this.f26492oIX0oI;
    }

    public final void oxoX(@OOXIXo String filePath, @OOXIXo I0Io callback) {
        oIX0oI rOTAManager;
        IIX0o.x0xO0oo(filePath, "filePath");
        IIX0o.x0xO0oo(callback, "callback");
        String mPlatform = BleCache.INSTANCE.getMPlatform();
        if (IIX0o.Oxx0IOOO(mPlatform, BleDeviceInfo.PLATFORM_JL)) {
            rOTAManager = this.f26491II0xO0;
            if (rOTAManager == null) {
                rOTAManager = new II0xO0(this.f26492oIX0oI, callback);
            }
        } else if (IIX0o.Oxx0IOOO(mPlatform, BleDeviceInfo.PLATFORM_SIFLI)) {
            rOTAManager = new SOTAManager(this.f26492oIX0oI, callback);
        } else {
            rOTAManager = new ROTAManager(this.f26492oIX0oI, callback);
        }
        oIX0oI oix0oi = rOTAManager;
        this.f26491II0xO0 = oix0oi;
        if (oix0oi != null) {
            oIX0oI.xoIox(oix0oi, filePath, this.f26490I0Io, false, 4, null);
        }
    }
}
