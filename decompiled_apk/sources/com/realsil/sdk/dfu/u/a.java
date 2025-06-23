package com.realsil.sdk.dfu.u;

import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class a extends com.realsil.sdk.dfu.t.a {
    public b n;

    /* loaded from: classes11.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            setName("AdapterXS0000-DeviceInfoThread");
            a.this.b(257);
            if (a.this.e()) {
                a.this.b(258);
                if (a.this.c().sendCmd((short) 1536, null)) {
                    a.this.h();
                    if (a.this.e()) {
                        a.this.b(259);
                        if (a.this.c().sendCmd((short) 1537, null)) {
                            a.this.h();
                            if (a.this.e()) {
                                a.this.b(263);
                                if (a.this.c().sendCmd((short) 24, new byte[]{2})) {
                                    a.this.h();
                                    if (com.realsil.sdk.dfu.t.a.k) {
                                        ZLogger.d(a.this.b().toString());
                                    }
                                    a.this.b(1);
                                    return;
                                }
                                if (com.realsil.sdk.dfu.t.a.k) {
                                    ZLogger.d(a.this.b().toString());
                                }
                                a.this.b(2);
                                return;
                            }
                            ZLogger.d("already in idle state");
                            return;
                        }
                        if (com.realsil.sdk.dfu.t.a.k) {
                            ZLogger.d(a.this.b().toString());
                        }
                        a.this.b(2);
                        return;
                    }
                    ZLogger.d("already in idle state");
                    return;
                }
                if (com.realsil.sdk.dfu.t.a.k) {
                    ZLogger.d(a.this.b().toString());
                }
                a.this.b(2);
                return;
            }
            ZLogger.d("already in idle state");
        }
    }

    public a() {
        this.f19607a = 0;
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void a(AckPacket ackPacket) {
        super.a(ackPacket);
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (toAckId == 24) {
            ZLogger.v("ACK-CMD_GET_STATUS");
            if (status == 2 || status == 1) {
                ZLogger.w("CMD_GET_STATUS not support");
                if (this.c == 263) {
                    g();
                    return;
                }
                return;
            }
            return;
        }
        if (toAckId == 1536) {
            ZLogger.v("ACK-CMD_OTA_GET_DEVICE_INFO");
            if (status == 2 || status == 1) {
                ZLogger.w("CMD_OTA_GET_DEVICE_INFO not support");
                if (this.c == 258) {
                    g();
                    return;
                }
                return;
            }
            return;
        }
        if (toAckId != 1537) {
            return;
        }
        if (status == 2 || status == 1 || status == 3) {
            if (com.realsil.sdk.dfu.t.a.k) {
                ZLogger.d("GET_IMAGE_INFO failed");
            }
            if (this.c == 259) {
                g();
            }
        }
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void f() {
        super.f();
        b bVar = new b();
        this.n = bVar;
        bVar.start();
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void a(TransportLayerPacket transportLayerPacket) {
        super.a(transportLayerPacket);
        short opcode = transportLayerPacket.getOpcode();
        transportLayerPacket.getPayload();
        byte[] parameters = transportLayerPacket.getParameters();
        ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0000)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
        if (opcode == 25) {
            if (this.c != 263 || parameters == null || parameters.length <= 0 || parameters[0] != 2) {
                return;
            }
            b().setBatteryLevel(parameters.length > 1 ? parameters[1] & 255 : 0, parameters.length > 2 ? parameters[2] & 255 : 0);
            g();
            return;
        }
        if (opcode == 1536) {
            b().parseX0000(parameters);
            g();
        } else {
            if (opcode != 1537) {
                return;
            }
            b().appendActiveImageVersionBytes(parameters);
            g();
        }
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void a() {
        super.a();
        b bVar = this.n;
        if (bVar != null) {
            bVar.interrupt();
            this.n = null;
        }
    }
}
