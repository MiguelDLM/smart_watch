package com.goodix.ble.libble.v2.misc;

import com.goodix.ble.libble.BleUuid;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.transceiver.IFrameSender;
import com.goodix.ble.libcomx.transceiver.Transceiver;
import com.goodix.ble.libcomx.transceiver.buffer.BufferedPduSender;

/* loaded from: classes9.dex */
public class BleTransceiver implements IEventListener, IFrameSender {

    /* renamed from: a, reason: collision with root package name */
    private Transceiver f16188a;
    private IFrameSender b;
    private BufferedPduSender c;
    private GBGattCharacteristic d;
    private GBGattDescriptor e;

    public BleTransceiver(GBGattCharacteristic gBGattCharacteristic) {
        this.d = gBGattCharacteristic;
        this.e = null;
        this.e = gBGattCharacteristic.requireDescriptor(BleUuid.CCCD, false);
    }

    public Transceiver bindTransceiver(Transceiver transceiver) {
        return bindTransceiver(transceiver, 0);
    }

    public IFrameSender getBufferedFrameSender(int i) {
        if (this.c == null) {
            this.c = new BufferedPduSender(this, i);
            GBRemoteDevice remoteDevice = this.d.getService().getRemoteDevice();
            this.d.evtWritten().register(this);
            remoteDevice.evtStateChanged().register(this);
            remoteDevice.evtMtuUpdated().register(this);
        }
        return this.c;
    }

    public IFrameSender getFrameSender() {
        return this;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        BufferedPduSender bufferedPduSender;
        Transceiver transceiver;
        byte[] bArr;
        Transceiver transceiver2;
        if (i == 106) {
            int intValue = ((Integer) obj2).intValue();
            Transceiver transceiver3 = this.f16188a;
            if (intValue == 2) {
                if (transceiver3 != null) {
                    transceiver3.reset();
                    transceiver3.setReady(this.d.isNotifyEnabled() || this.d.isIndicateEnabled());
                }
                BufferedPduSender bufferedPduSender2 = this.c;
                if (bufferedPduSender2 != null) {
                    bufferedPduSender2.setMaxSegmentSize(20);
                    bufferedPduSender2.clear();
                }
            } else if (transceiver3 != null) {
                transceiver3.setReady(false);
            }
        }
        if (i == 103) {
            this.c.setMaxSegmentSize(((Integer) obj2).intValue() - 3);
        }
        if (i != 44) {
            if (i == 55 || i == 66) {
                byte[] bArr2 = (byte[]) obj2;
                if (obj == this.d && (transceiver2 = this.f16188a) != null && bArr2 != null) {
                    transceiver2.handleRcvData(bArr2, 0, bArr2.length);
                }
            }
        } else if (obj == this.d && (bufferedPduSender = this.c) != null) {
            bufferedPduSender.nextSegment();
        }
        if (obj == this.e) {
            if ((i == 4354 || i == 4353) && (transceiver = this.f16188a) != null && (bArr = (byte[]) obj2) != null && bArr.length == 2 && bArr[1] == 0) {
                transceiver.setReady(bArr[0] != 0);
            }
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSender
    public boolean sendFrame(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !this.d.getService().getRemoteDevice().isConnected()) {
            return false;
        }
        ((this.d.getProperty() & 4) == 4 ? this.d.writeByCommand(bArr, false) : this.d.writeByRequest(bArr)).startProcedure();
        return true;
    }

    public void unbind() {
        GBRemoteDevice remoteDevice = this.d.getService().getRemoteDevice();
        Transceiver transceiver = this.f16188a;
        if (transceiver != null) {
            transceiver.setSender(null);
            this.f16188a = null;
            this.d.evtNotify().remove(this);
            this.d.evtIndicate().remove(this);
            GBGattDescriptor gBGattDescriptor = this.e;
            if (gBGattDescriptor != null) {
                gBGattDescriptor.evtRead().remove(this);
                this.e.evtWritten().remove(this);
            }
        }
        if (this.c != null) {
            this.c = null;
            this.d.evtWritten().remove(this);
            remoteDevice.evtMtuUpdated().remove(this);
        }
        remoteDevice.evtStateChanged().remove(this);
    }

    public Transceiver bindTransceiver(Transceiver transceiver, int i) {
        IFrameSender iFrameSender;
        Transceiver transceiver2 = this.f16188a;
        if (transceiver2 != null) {
            transceiver2.setSender(null);
        }
        this.f16188a = transceiver;
        this.d.evtNotify().register(this);
        this.d.evtIndicate().register(this);
        if (i > 20) {
            iFrameSender = getBufferedFrameSender(i);
        } else {
            this.d.getService().getRemoteDevice().evtStateChanged().register(this);
            iFrameSender = this;
        }
        transceiver.setSender(iFrameSender);
        GBGattDescriptor gBGattDescriptor = this.e;
        if (gBGattDescriptor != null) {
            gBGattDescriptor.evtRead().register(this);
            this.e.evtWritten().register(this);
        }
        transceiver.setReady(this.d.getService().getRemoteDevice().isConnected() && (this.d.isNotifyEnabled() || this.d.isIndicateEnabled()));
        return transceiver;
    }
}
