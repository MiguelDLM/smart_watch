package Ox0XO;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class xxIXOIIO implements OoOoXO0.I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public II0xO0 f2982I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f2983II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OoOoXO0.OOXIXo f2984II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoOoXO0.I0Io f2985Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OoOoXO0.IIXOooo f2986X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Object f2987XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OoOoXO0.oO f2988oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public OoOoXO0.x0xO0oo f2989oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f2990xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OoOoXO0.ooOOo0oXI f2991xxIXOIIO;

    public xxIXOIIO(OoOoXO0.OOXIXo oOXIXo, OoOoXO0.oO oOVar, II0xO0 iI0xO0, OoOoXO0.x0xO0oo x0xo0oo, OoOoXO0.IIXOooo iIXOooo, Object obj, OoOoXO0.I0Io i0Io, boolean z) {
        this.f2988oIX0oI = oOVar;
        this.f2984II0xO0 = oOXIXo;
        this.f2982I0Io = iI0xO0;
        this.f2989oxoX = x0xo0oo;
        this.f2986X0o0xo = iIXOooo;
        this.f2987XO = obj;
        this.f2985Oxx0IOOO = i0Io;
        this.f2983II0XooXoX = x0xo0oo.X0o0xo();
        this.f2990xoIox = z;
    }

    public void II0xO0(OoOoXO0.ooOOo0oXI ooooo0oxi) {
        this.f2991xxIXOIIO = ooooo0oxi;
    }

    public void oIX0oI() throws MqttPersistenceException {
        OoOoXO0.IIXOooo iIXOooo = new OoOoXO0.IIXOooo(this.f2984II0xO0.getClientId());
        iIXOooo.setActionCallback(this);
        iIXOooo.setUserContext(this);
        this.f2988oIX0oI.oIX0oI(this.f2984II0xO0.getClientId(), this.f2984II0xO0.getServerURI());
        if (this.f2989oxoX.x0XOIxOo()) {
            this.f2988oIX0oI.clear();
        }
        if (this.f2989oxoX.X0o0xo() == 0) {
            this.f2989oxoX.oI0IIXIo(4);
        }
        try {
            this.f2982I0Io.oO(this.f2989oxoX, iIXOooo);
        } catch (MqttException e) {
            onFailure(iIXOooo, e);
        }
    }

    @Override // OoOoXO0.I0Io
    public void onFailure(OoOoXO0.II0XooXoX iI0XooXoX, Throwable th) {
        MqttException mqttException;
        int length = this.f2982I0Io.xxX().length;
        int XIxXXX0x02 = this.f2982I0Io.XIxXXX0x0() + 1;
        if (XIxXXX0x02 >= length && (this.f2983II0XooXoX != 0 || this.f2989oxoX.X0o0xo() != 4)) {
            if (this.f2983II0XooXoX == 0) {
                this.f2989oxoX.oI0IIXIo(0);
            }
            if (th instanceof MqttException) {
                mqttException = (MqttException) th;
            } else {
                mqttException = new MqttException(th);
            }
            this.f2986X0o0xo.f2606oIX0oI.IXxxXO(null, mqttException);
            this.f2986X0o0xo.f2606oIX0oI.Oxx0xo();
            this.f2986X0o0xo.f2606oIX0oI.xoXoI(this.f2984II0xO0);
            if (this.f2985Oxx0IOOO != null) {
                this.f2986X0o0xo.setUserContext(this.f2987XO);
                this.f2985Oxx0IOOO.onFailure(this.f2986X0o0xo, th);
                return;
            }
            return;
        }
        if (this.f2983II0XooXoX == 0) {
            if (this.f2989oxoX.X0o0xo() == 4) {
                this.f2989oxoX.oI0IIXIo(3);
            } else {
                this.f2989oxoX.oI0IIXIo(4);
                this.f2982I0Io.oxxXoxO(XIxXXX0x02);
            }
        } else {
            this.f2982I0Io.oxxXoxO(XIxXXX0x02);
        }
        try {
            oIX0oI();
        } catch (MqttPersistenceException e) {
            onFailure(iI0XooXoX, e);
        }
    }

    @Override // OoOoXO0.I0Io
    public void onSuccess(OoOoXO0.II0XooXoX iI0XooXoX) {
        if (this.f2983II0XooXoX == 0) {
            this.f2989oxoX.oI0IIXIo(0);
        }
        this.f2986X0o0xo.f2606oIX0oI.IXxxXO(iI0XooXoX.getResponse(), null);
        this.f2986X0o0xo.f2606oIX0oI.Oxx0xo();
        this.f2986X0o0xo.f2606oIX0oI.xoXoI(this.f2984II0xO0);
        if (this.f2990xoIox) {
            this.f2982I0Io.x0o();
        }
        if (this.f2985Oxx0IOOO != null) {
            this.f2986X0o0xo.setUserContext(this.f2987XO);
            this.f2985Oxx0IOOO.onSuccess(this.f2986X0o0xo);
        }
        if (this.f2991xxIXOIIO != null) {
            this.f2991xxIXOIIO.connectComplete(this.f2990xoIox, this.f2982I0Io.xxX()[this.f2982I0Io.XIxXXX0x0()].getServerURI());
        }
    }
}
