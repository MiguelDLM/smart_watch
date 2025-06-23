package com.realsil.sdk.dfu.v;

import com.realsil.sdk.bbpro.core.protocol.CommandContract;
import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.Command;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jxl.read.biff.oIX0oI;

/* loaded from: classes11.dex */
public class a extends com.realsil.sdk.dfu.t.a {
    public b n;
    public boolean o = true;

    /* loaded from: classes11.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean sendCmd;
            boolean sendCmd2;
            super.run();
            setName("AdapterXS0011-DeviceInfoThread");
            a.this.b(257);
            if (a.this.e()) {
                a.this.b(258);
                if (a.this.c().sendCmd((short) 1536, null)) {
                    a.this.h();
                    if (a.this.b().isRwsEnabled()) {
                        a.this.f.add(new OtaModeInfo(21));
                    } else {
                        a.this.f.add(new OtaModeInfo(16));
                    }
                    if (a.this.b().isSeqOtaSupported()) {
                        a.this.f.add(new OtaModeInfo(23));
                    }
                    if (a.this.b().isVpIdOtaSupported()) {
                        a.this.f.add(new OtaModeInfo(24));
                    }
                    if (a.this.e()) {
                        a.this.b(259);
                        if (a.this.b().specVersion <= 5) {
                            sendCmd = a.this.c().sendCmd((short) 1537, null);
                        } else {
                            sendCmd = a.this.c().sendCmd((short) 1537, new byte[]{0});
                        }
                        if (sendCmd) {
                            a.this.h();
                            if (a.this.b().specVersion >= 5) {
                                if (a.this.b().isBankEnabled()) {
                                    if (a.this.h == 1) {
                                        a.this.f.add(new OtaModeInfo(19));
                                        a.this.f.add(new OtaModeInfo(20));
                                    }
                                    if (a.this.e()) {
                                        a.this.b(260);
                                        if (a.this.b().specVersion >= 6) {
                                            sendCmd2 = a.this.c().sendCmd((short) 1537, new byte[]{1});
                                        } else {
                                            sendCmd2 = a.this.c().sendCmd((short) 1550, null);
                                        }
                                        if (sendCmd2) {
                                            a.this.h();
                                        } else {
                                            if (com.realsil.sdk.dfu.t.a.k) {
                                                ZLogger.v(a.this.b().toString());
                                            }
                                            a.this.b(2);
                                            return;
                                        }
                                    } else {
                                        ZLogger.d(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                                        return;
                                    }
                                }
                                if (a.this.e()) {
                                    a.this.b(261);
                                    if (a.this.c().sendCmd((short) 1549, null)) {
                                        a.this.h();
                                        if (a.this.b.isImageFeatureEnabled()) {
                                            a.this.o = true;
                                            List<ImageVersionInfo> imageVersionInfos = a.this.b().getImageVersionInfos();
                                            if (imageVersionInfos != null && imageVersionInfos.size() > 0) {
                                                for (ImageVersionInfo imageVersionInfo : imageVersionInfos) {
                                                    if (!a.this.o) {
                                                        break;
                                                    }
                                                    if (imageVersionInfo.getVersion() != -1) {
                                                        a.this.b(265);
                                                        if (a.this.c().sendCommand(new Command.Builder().writeType(2).packet((short) 793, new byte[]{(byte) (imageVersionInfo.getImageId() & 255), (byte) ((imageVersionInfo.getImageId() >> 8) & 255)}).eventId((short) 793).build())) {
                                                            a.this.h();
                                                        } else {
                                                            if (com.realsil.sdk.dfu.t.a.k) {
                                                                ZLogger.d(a.this.b().toString());
                                                            }
                                                            a.this.b(2);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (com.realsil.sdk.dfu.t.a.m) {
                                            ZLogger.v(a.this.b().dumpFeatures());
                                        }
                                    } else {
                                        if (com.realsil.sdk.dfu.t.a.k) {
                                            ZLogger.d(a.this.b().toString());
                                        }
                                        a.this.b(2);
                                        return;
                                    }
                                } else {
                                    ZLogger.d(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                                    return;
                                }
                            }
                            if (a.this.b().getUpdateMechanism() == 3) {
                                if (a.this.e()) {
                                    a.this.b(262);
                                    if (a.this.c().sendCmd((short) 1546, null)) {
                                        a.this.h();
                                    } else {
                                        if (com.realsil.sdk.dfu.t.a.k) {
                                            ZLogger.d(a.this.b().toString());
                                        }
                                        a.this.b(2);
                                        return;
                                    }
                                } else {
                                    ZLogger.d(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                                    return;
                                }
                            }
                            if (a.this.e()) {
                                a.this.b(263);
                                if (a.this.c().sendCmd((short) 24, new byte[]{2})) {
                                    a.this.h();
                                    if (a.this.e()) {
                                        a.this.b(264);
                                        if (a.this.c().sendCmd(CommandContract.buildPacket(CommandContract.CMD_GET_PACKAGE_ID))) {
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
                                    ZLogger.d(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                                    return;
                                }
                                if (com.realsil.sdk.dfu.t.a.k) {
                                    ZLogger.d(a.this.b().toString());
                                }
                                a.this.b(2);
                                return;
                            }
                            ZLogger.d(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                            return;
                        }
                        if (com.realsil.sdk.dfu.t.a.k) {
                            ZLogger.d(a.this.b().toString());
                        }
                        a.this.b(2);
                        return;
                    }
                    ZLogger.v(com.realsil.sdk.dfu.t.a.l, "already in idle state");
                    return;
                }
                if (com.realsil.sdk.dfu.t.a.k) {
                    ZLogger.v(a.this.b().toString());
                }
                a.this.b(2);
                return;
            }
            ZLogger.v("already in idle state");
        }
    }

    public a() {
        this.f19607a = 17;
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void f() {
        this.f = new ArrayList();
        b bVar = new b();
        this.n = bVar;
        bVar.start();
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void a(AckPacket ackPacket) {
        super.a(ackPacket);
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (toAckId == 24) {
            if (status != 2 && status != 1) {
                ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_GET_STATUS");
                return;
            }
            ZLogger.w("CMD_GET_STATUS not support");
            if (this.c == 263) {
                g();
                return;
            }
            return;
        }
        if (toAckId == 783) {
            if (status != 2 && status != 1) {
                ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_GET_PACKAGE_ID");
                return;
            }
            ZLogger.d("CMD_GET_PACKAGE_ID not support");
            if (this.c == 264) {
                g();
                return;
            }
            return;
        }
        if (toAckId == 793) {
            if (status != 0) {
                ZLogger.d("CMD_GET_IMAGE_FEATURE_INFO not support");
                this.o = false;
                if (this.c == 265) {
                    g();
                    return;
                }
                return;
            }
            ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_GET_IMAGE_FEATURE_INFO");
            return;
        }
        if (toAckId == 1546) {
            if (status != 2 && status != 1) {
                ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_OTA_IMAGE_SECTION_SIZE_INFO");
                return;
            }
            ZLogger.d("CMD_OTA_IMAGE_SECTION_SIZE_INFO not support");
            if (this.c == 262) {
                g();
                return;
            }
            return;
        }
        if (toAckId == 1536) {
            if (status == 2 || status == 1 || status == 3) {
                if (com.realsil.sdk.dfu.t.a.k) {
                    ZLogger.d("GET_TERGET_INFO failed");
                }
                if (this.c == 258) {
                    g();
                    return;
                }
                return;
            }
            return;
        }
        if (toAckId == 1537) {
            if (status == 2 || status == 1 || status == 3) {
                if (com.realsil.sdk.dfu.t.a.k) {
                    ZLogger.d("GET_IMAGE_INFO failed");
                }
                if (this.c == 259) {
                    g();
                    return;
                } else {
                    if (b().specVersion < 5 || this.c != 260) {
                        return;
                    }
                    g();
                    return;
                }
            }
            return;
        }
        if (toAckId == 1549) {
            if (status != 2 && status != 1) {
                ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_GET_CONFIG_RELEASE_VERSION");
                return;
            }
            ZLogger.d("CMD_GET_CONFIG_RELEASE_VERSION not support");
            if (this.c == 261) {
                g();
                return;
            }
            return;
        }
        if (toAckId != 1550) {
            return;
        }
        if (status != 2 && status != 1) {
            ZLogger.v(com.realsil.sdk.dfu.t.a.l, "ACK-CMD_GET_INACTIVE_BANK_IMAGE_INFO");
            return;
        }
        ZLogger.d("CMD_GET_INACTIVE_BANK_IMAGE_INFO not support");
        if (this.c == 260) {
            g();
        }
    }

    @Override // com.realsil.sdk.dfu.t.a
    public void a(TransportLayerPacket transportLayerPacket) {
        super.a(transportLayerPacket);
        short opcode = transportLayerPacket.getOpcode();
        transportLayerPacket.getPayload();
        byte[] parameters = transportLayerPacket.getParameters();
        if (opcode == 25) {
            if (com.realsil.sdk.dfu.t.a.k) {
                ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
            }
            if (this.c != 263 || parameters == null || parameters.length <= 0 || parameters[0] != 2) {
                return;
            }
            b().setBatteryLevel(parameters.length > 1 ? parameters[1] & 255 : 0, parameters.length > 2 ? parameters[2] & 255 : 0);
            g();
            return;
        }
        if (opcode != 793) {
            if (opcode != 1553) {
                if (opcode == 2321) {
                    if (com.realsil.sdk.dfu.t.a.k) {
                        ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                    }
                    if (this.c == 264) {
                        if (parameters != null && parameters.length >= 2) {
                            b().setIcId(parameters[0]);
                            b().setPackageId(parameters[1]);
                        }
                        g();
                        return;
                    }
                    return;
                }
                if (opcode == 1548) {
                    if (com.realsil.sdk.dfu.t.a.k) {
                        ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                    }
                    b().setAppConfigReleaseVer(parameters);
                    g();
                    return;
                }
                if (opcode != 1549) {
                    switch (opcode) {
                        case oIX0oI.f28372XO /* 1536 */:
                            if (com.realsil.sdk.dfu.t.a.k) {
                                ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                            }
                            if (this.c == 258) {
                                b().parseX0011(parameters);
                                g();
                                return;
                            }
                            return;
                        case 1537:
                            if (com.realsil.sdk.dfu.t.a.k) {
                                ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                            }
                            b().appendImageVersionBytes(parameters);
                            g();
                            return;
                        case SubBinId.Bbpro.DSP_APP_IMAGE /* 1538 */:
                            break;
                        default:
                            switch (opcode) {
                                case 1540:
                                case 1541:
                                case 1542:
                                case 1543:
                                case 1545:
                                    break;
                                case 1544:
                                    if (com.realsil.sdk.dfu.t.a.k) {
                                        ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                                    }
                                    if (this.c == 262) {
                                        if (parameters != null && parameters.length > 0) {
                                            b().appendImageSectionSizeBytes(parameters);
                                        }
                                        g();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    if (com.realsil.sdk.dfu.t.a.k) {
                        ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                    }
                    b().appendInactiveImageVersionBytes(parameters);
                    g();
                    return;
                }
            }
            if (com.realsil.sdk.dfu.t.a.k) {
                ZLogger.d(String.format(Locale.US, "[0x%04X >>] (S0011)%s", Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                return;
            }
            return;
        }
        if (this.c == 265) {
            com.realsil.sdk.dfu.s.b a2 = com.realsil.sdk.dfu.s.b.a(parameters);
            if (a2 != null) {
                if (com.realsil.sdk.dfu.t.a.m) {
                    ZLogger.v(String.format("image:0x%04X, feature:%s", Integer.valueOf(a2.f19603a), a2.b));
                }
                b().appendImageFeatureInfo(a2.f19603a, a2.b);
            }
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

    @Override // com.realsil.sdk.dfu.t.a
    public boolean a(OtaDeviceInfo otaDeviceInfo, QcConfig qcConfig) {
        return c().sendCmd((short) 1554, new byte[]{(byte) (qcConfig.getIndicator() & 255)});
    }
}
