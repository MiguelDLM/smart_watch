package com.goodix.ble.gr.libdfu;

import com.goodix.ble.gr.libdfu.dfu.DfuTxRxFactory;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate;
import com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdateAB;
import com.goodix.ble.gr.libdfu.task.param.DfuFileList;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.transceiver.IFrameSender;
import com.goodix.ble.libcomx.transceiver.Transceiver;
import com.goodix.ble.libcomx.transceiver.buffer.BufferedPduSender;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class EasyDfu {
    private static final String j = "EasyDfu";

    /* renamed from: a, reason: collision with root package name */
    private final DeviceFirmwareUpdate.Listener f16072a;
    private DfuEvent b;
    private ILogger c;
    private IFrameSender d;
    private final Transceiver e;
    private final DeviceFirmwareUpdate f;
    private DeviceFirmwareUpdateAB g;
    private final BufferedPduSender h;
    private boolean i;

    /* loaded from: classes9.dex */
    public interface DfuEvent {
        void onDfuComplete();

        void onDfuError(String str, Error error);

        void onDfuErrorFirmwareOverlay();

        void onDfuProgress(int i);

        void onDfuStart();
    }

    /* loaded from: classes9.dex */
    public class a implements DeviceFirmwareUpdate.Listener {
        public a() {
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuCanceled() {
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuComplete() {
            EasyDfu.this.i = false;
            if (EasyDfu.this.b != null) {
                EasyDfu.this.b.onDfuComplete();
            }
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuError(String str, Error error) {
            EasyDfu.this.i = false;
            if (EasyDfu.this.b != null) {
                EasyDfu.this.b.onDfuError(str, error);
            }
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuErrorFirmwareOverlap() {
            EasyDfu.this.i = false;
            if (EasyDfu.this.b != null) {
                EasyDfu.this.b.onDfuErrorFirmwareOverlay();
            }
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuProgressUpdate(int i) {
            if (EasyDfu.this.b != null) {
                EasyDfu.this.b.onDfuProgress(i);
            }
        }

        @Override // com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate.Listener
        public void onDfuStart() {
            EasyDfu.this.i = true;
            if (EasyDfu.this.b != null) {
                EasyDfu.this.b.onDfuStart();
            }
        }
    }

    public EasyDfu() {
        BufferedPduSender bufferedPduSender = new BufferedPduSender(new IFrameSender() { // from class: com.goodix.ble.gr.libdfu.oIX0oI
            @Override // com.goodix.ble.libcomx.transceiver.IFrameSender
            public final boolean sendFrame(byte[] bArr) {
                boolean a2;
                a2 = EasyDfu.this.a(bArr);
                return a2;
            }
        }, 4096);
        this.h = bufferedPduSender;
        Transceiver create = new DfuTxRxFactory().create();
        this.e = create;
        create.setSender(bufferedPduSender);
        DeviceFirmwareUpdate deviceFirmwareUpdate = new DeviceFirmwareUpdate();
        this.f = deviceFirmwareUpdate;
        a aVar = new a();
        this.f16072a = aVar;
        deviceFirmwareUpdate.setListener(aVar);
    }

    public void onRcvPduSegment(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.e.handleRcvData(bArr, 0, bArr.length);
    }

    public void onSentPduSegment() {
        this.h.nextSegment();
    }

    public void setListener(DfuEvent dfuEvent) {
        this.b = dfuEvent;
    }

    public void setLogger(ILogger iLogger) {
        this.c = iLogger;
    }

    public void setMaxSegmentSize(int i) {
        this.h.setMaxSegmentSize(i);
    }

    public void setPduSender(IFrameSender iFrameSender) {
        this.d = iFrameSender;
    }

    public boolean startDfu(InputStream inputStream, boolean z, boolean z2) {
        if (this.d != null && !this.i) {
            DfuFile dfuFile = new DfuFile();
            dfuFile.load(inputStream);
            this.e.setLogger(this.c);
            this.f.setLogger(this.c).setOverwriteFw(z2).setDfuFile(dfuFile).setTransceiver(this.e);
            this.f.setAsDfuMode(z);
            this.f.start();
            return true;
        }
        return false;
    }

    public boolean startDfuInABMode(InputStream inputStream, InputStream inputStream2) {
        if (this.d == null || this.i) {
            return false;
        }
        DfuFile dfuFile = new DfuFile();
        if (!dfuFile.load(inputStream)) {
            DfuEvent dfuEvent = this.b;
            if (dfuEvent != null) {
                dfuEvent.onDfuStart();
                this.b.onDfuError("Failed to load firmware A.", new Error("Failed to load firmware A."));
            }
            return false;
        }
        DfuFile dfuFile2 = new DfuFile();
        if (!dfuFile2.load(inputStream2)) {
            DfuEvent dfuEvent2 = this.b;
            if (dfuEvent2 != null) {
                dfuEvent2.onDfuStart();
                this.b.onDfuError("Failed to load firmware B.", new Error("Failed to load firmware B."));
            }
            return false;
        }
        DfuFileList dfuFileList = new DfuFileList();
        dfuFileList.setList(new ArrayList(2));
        dfuFileList.getList().add(dfuFile);
        dfuFileList.getList().add(dfuFile2);
        if (this.g == null) {
            DeviceFirmwareUpdateAB deviceFirmwareUpdateAB = new DeviceFirmwareUpdateAB();
            this.g = deviceFirmwareUpdateAB;
            deviceFirmwareUpdateAB.setListener(this.f16072a).setTransceiver(this.e).setLogger(this.c).setDfuFile(dfuFileList);
        }
        this.g.start();
        return true;
    }

    public boolean startDfuInCopyMode(InputStream inputStream, int i) {
        if (this.d != null && !this.i) {
            DfuFile dfuFile = new DfuFile();
            dfuFile.load(inputStream);
            this.e.setLogger(this.c);
            this.f.setLogger(this.c).setDfuFile(dfuFile).setTransceiver(this.e);
            this.f.setAsCopyMode(i);
            this.f.start();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(byte[] bArr) {
        IFrameSender iFrameSender = this.d;
        if (iFrameSender != null) {
            return iFrameSender.sendFrame(bArr);
        }
        return false;
    }
}
