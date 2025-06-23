package com.realsil.sdk.dfu.u;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.scanner.BrEdrScannerPresenter;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.u.b;
import com.realsil.sdk.dfu.v.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import jxl.read.biff.oIX0oI;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class c extends com.realsil.sdk.dfu.t.b {
    public final TransportLayerCallback L;
    public int M;

    /* loaded from: classes11.dex */
    public class a extends TransportLayerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onAckReceive(AckPacket ackPacket) {
            super.onAckReceive(ackPacket);
            c.this.a(ackPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, boolean z, int i) {
            super.onConnectionStateChanged(bluetoothDevice, z, i);
            if (i == 2) {
                c.this.setConnectionState(515);
            } else if (i == 0) {
                if (c.this.mProcessState == 521) {
                    c.this.mErrorState = 2048;
                    c cVar = c.this;
                    if (cVar.DBG) {
                        ZLogger.w(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(cVar.mErrorState)));
                    }
                    c.this.g();
                }
                c.this.setConnectionState(0);
            } else {
                return;
            }
            c.this.notifyConnectionLock();
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onDataReceive(TransportLayerPacket transportLayerPacket) {
            super.onDataReceive(transportLayerPacket);
            c.this.a(transportLayerPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onError(int i) {
            super.onError(i);
        }
    }

    public c(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.L = new a();
        this.M = 0;
    }

    public final boolean A() {
        try {
            ZLogger.d(this.DBG, String.format("<< CMD_OTA_RESET (0x%04X)", (short) 1541));
            return a((short) 1541, (byte[]) null);
        } catch (DfuException e) {
            ZLogger.w(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public final void B() throws DfuException {
        ZLogger.v(this.DBG, String.format("<< CMD_OTA_START(0x%04X)", (short) 1538));
        byte[] bArr = new byte[16];
        System.arraycopy(this.mCurBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
        if (getOtaDeviceInfo().isAesEncryptEnabled()) {
            a((short) 1538, this.l.aesEncrypt(bArr, 0, 16));
        } else {
            a((short) 1538, bArr);
        }
        ZLogger.v(this.DBG, "... Reading CMD_OTA_START notification");
        byte b = n()[0];
        if (b == 1) {
            return;
        }
        ZLogger.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public final boolean C() throws DfuException {
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return false;
        }
        notifyStateChanged(521);
        if (this.DBG) {
            ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
            ZLogger.v(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (this.DBG) {
            ZLogger.v(getDfuProgressInfo().toString());
        }
        if (getOtaDeviceInfo().icType <= 3) {
            if (this.DBG) {
                ZLogger.d("not support ic:" + getOtaDeviceInfo().icType);
            }
        } else {
            if (this.DBG) {
                ZLogger.v("isBufferCheckEnabled=" + getOtaDeviceInfo().isBufferCheckEnabled());
            }
            if (!getOtaDeviceInfo().isBufferCheckEnabled()) {
                this.r = 0;
            } else {
                this.r = t();
            }
            if (this.DBG) {
                ZLogger.v("mRemoteOtaFunctionInfo=" + this.r);
            }
        }
        if (getOtaDeviceInfo().isAesEncryptEnabled() && !b()) {
            b(4113);
            return false;
        }
        getDfuProgressInfo().start();
        e(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
        }
        if (this.mImageUpdateOffset == 0) {
            B();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            if (this.DBG) {
                ZLogger.d("Last send reach the bottom");
            }
        } else {
            f(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                c(this.mCurBinInputStream);
            } else {
                b(this.mCurBinInputStream);
            }
        }
        getDfuProgressInfo().sendOver();
        h(getDfuProgressInfo().getCurImageId());
        return true;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean activeImage(boolean z) {
        if (!super.activeImage(z)) {
            return false;
        }
        if (this.mConnectionState != 515) {
            if (this.DBG) {
                ZLogger.d("start to re-connect the RCU which going to active image, current state is: " + this.mConnectionState);
            }
            int a2 = a(this.mOtaDeviceAddress, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                ZLogger.e("Something error in OTA process, errorCode: " + a2 + "mProcessState" + this.mProcessState);
                a(a2, true);
                return false;
            }
        }
        if (z) {
            try {
                p();
                if (getDfuConfig().isCompleteActionEnabled(1)) {
                    BluetoothProfileManager.getInstance().disconnectA2dpSource(this.z.getRemoteDevice(this.mOtaDeviceAddress));
                    BluetoothProfileManager.getInstance().disconnectHfp(this.mOtaDeviceAddress);
                }
                notifyStateChanged(258);
            } catch (DfuException e) {
                ZLogger.w(e.toString());
                b(e.getErrCode());
            }
        } else {
            A();
            a(274, true);
        }
        return true;
    }

    public final void b(BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
        c();
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                startSpeedControl();
                ZLogger.v(getDfuProgressInfo().toString());
                try {
                    getDfuProgressInfo().getBytesSent();
                    if (this.mImageUpdateOffset == 0) {
                        int i2 = this.MAX_PACKET_SIZE;
                        byte[] bArr2 = new byte[i2];
                        baseBinInputStream.read(bArr2, i2 - 12);
                        System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                        read = this.MAX_PACKET_SIZE;
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        if (this.DBG) {
                            ZLogger.v("reach the end of the file, only read some");
                        }
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    if (read <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.i("image file has already been send over");
                            return;
                        }
                        ZLogger.e("Error while reading file with size: " + read);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i3 = read; i3 > 0; i3 -= 16) {
                            if (i3 >= 16) {
                                int i4 = read - i3;
                                System.arraycopy(this.l.aesEncrypt(bArr, i4, 16), 0, bArr, i4, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    if (a((short) 1539, bArr, read)) {
                        getDfuProgressInfo().addBytesSent(read);
                        notifyProcessChanged();
                    }
                    j();
                    blockSpeedControl();
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0058, code lost:
    
        if (r13 != (getDfuProgressInfo().getBytesSent() + r2)) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[Catch: IOException -> 0x01fe, TryCatch #0 {IOException -> 0x01fe, blocks: (B:78:0x004a, B:80:0x004f, B:13:0x0067, B:15:0x006b, B:16:0x00b5, B:18:0x00b9, B:19:0x00ca, B:21:0x00d4, B:23:0x00e0, B:25:0x00f6, B:27:0x00fa, B:75:0x0093, B:76:0x00a3, B:12:0x005a), top: B:77:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b9 A[Catch: IOException -> 0x01fe, TryCatch #0 {IOException -> 0x01fe, blocks: (B:78:0x004a, B:80:0x004f, B:13:0x0067, B:15:0x006b, B:16:0x00b5, B:18:0x00b9, B:19:0x00ca, B:21:0x00d4, B:23:0x00e0, B:25:0x00f6, B:27:0x00fa, B:75:0x0093, B:76:0x00a3, B:12:0x005a), top: B:77:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d4 A[Catch: IOException -> 0x01fe, TryCatch #0 {IOException -> 0x01fe, blocks: (B:78:0x004a, B:80:0x004f, B:13:0x0067, B:15:0x006b, B:16:0x00b5, B:18:0x00b9, B:19:0x00ca, B:21:0x00d4, B:23:0x00e0, B:25:0x00f6, B:27:0x00fa, B:75:0x0093, B:76:0x00a3, B:12:0x005a), top: B:77:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.realsil.sdk.dfu.image.stream.BaseBinInputStream r17) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.u.c.c(com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    public final void d(String str) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(516);
            int a2 = a(str, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                if (a2 != 4128) {
                    ZLogger.d(String.format("connect failed:0x%04X", Integer.valueOf(a2)));
                    a(m());
                    int a3 = a(str, getDfuConfig().getRetransConnectTimes());
                    if (a3 == 0) {
                        return;
                    }
                    if (a3 == 4128) {
                        throw new OtaException("aborted, connectRemoteDevice failed", a3);
                    }
                    throw new OtaException("connectRemoteDevice failed", a3);
                }
                throw new OtaException("aborted, connectRemoteDevice failed", a2);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void e(int i) throws DfuException {
        a(new b.C0920b(i).a());
        ZLogger.v(this.DBG, "... Reading CMD_OTA_IMAGE_INFO notification");
        k a2 = k.a(n());
        if (a2 != null && a2.b() == 1) {
            if (this.DBG) {
                ZLogger.v(a2.toString());
            }
            this.mImageUpdateOffset = a2.c();
            return;
        }
        ZLogger.w(String.format("0x%02X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXS0000");
            ZLogger.d("ProcessorXS0000 running.");
            innerCheck = innerCheck();
        } catch (Exception e) {
            ZLogger.w(e.toString());
            b(0);
        }
        if (innerCheck != 0) {
            b(innerCheck);
            return;
        }
        notifyStateChanged(514);
        this.mOtaDeviceAddress = this.mDeviceAddress;
        this.otaModeEnabled = true;
        this.mBytesSentBuffer = 0;
        if (w()) {
            if (getOtaDeviceInfo().isRwsEnabled()) {
                p();
                notifyStateChanged(DfuConstants.PROGRESS_HAND_OVER_PROCESSING);
                this.otaModeEnabled = true;
                this.otaEnvironmentPrepared = false;
                this.mBytesSentBuffer = 0;
                ZLogger.d(this.DBG, "wait master to handover ...");
                sleepInner(getDfuConfig().getHandoverTimeout() * 1000);
                if (w()) {
                    if (!this.o) {
                        notifyStateChanged(523);
                    } else {
                        p();
                        if (getDfuConfig().isCompleteActionEnabled(1)) {
                            BluetoothProfileManager.getInstance().disconnectA2dpSource(this.z.getRemoteDevice(this.mOtaDeviceAddress));
                            BluetoothProfileManager.getInstance().disconnectHfp(this.mOtaDeviceAddress);
                        }
                        notifyStateChanged(258);
                    }
                }
            } else if (!this.o) {
                notifyStateChanged(523);
            } else {
                p();
                if (getDfuConfig().isCompleteActionEnabled(1)) {
                    BluetoothProfileManager.getInstance().disconnectA2dpSource(this.z.getRemoteDevice(this.mOtaDeviceAddress));
                    BluetoothProfileManager.getInstance().disconnectHfp(this.mOtaDeviceAddress);
                }
                notifyStateChanged(258);
            }
        }
        closeInputStream(this.mCurBinInputStream);
        if (this.DBG) {
            ZLogger.d("DfuThread stopped");
        }
        SppTransportLayer sppTransportLayer = this.K;
        if (sppTransportLayer != null) {
            sppTransportLayer.unregister(this.L);
        }
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    public final void f(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            this.mImageUpdateOffset = 12;
            ZLogger.d(this.DBG, String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.mImageUpdateOffset)));
        } else {
            ZLogger.d(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        int bytesSent = getDfuProgressInfo().getBytesSent();
        int i3 = this.mImageUpdateOffset;
        if (bytesSent != i3 && i3 != -1) {
            ZLogger.w("mBytesSent != mImageUpdateOffset, reload image bin file");
            this.imageFileLoaded = false;
            l();
            alignmentSendBytes(this.mImageUpdateOffset, false);
        }
    }

    public final void g(int i) {
        int i2 = this.mConnectionState;
        if (i2 != 0 && i2 != 1280) {
            s();
        }
        q();
        if (this.DBG) {
            ZLogger.d(String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i)));
        }
    }

    public final void h(int i) throws DfuException {
        byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255)};
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_VALID (0x%04X)", (short) 1540));
        if (a((short) 1540, bArr)) {
            ZLogger.d(this.DBG, "... waiting CMD_OTA_VALID response");
            byte b = b(30000L)[0];
            if (b == 1) {
                return;
            }
            if (b == 5) {
                ZLogger.e(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b)));
                throw new OtaException("Validate FW failed", 517);
            }
            ZLogger.e(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b)));
            throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("Validate FW failed", 512);
    }

    public final void p() throws DfuException {
        if (a((byte[]) null)) {
            if (getOtaDeviceInfo().isRwsEnabled()) {
                ZLogger.v("RWS, no need to disconnect manully");
            } else {
                if (d()) {
                    waitUntilDisconnected();
                } else {
                    ZLogger.d("device already disconnected");
                }
                g(0);
            }
            closeInputStream(this.mCurBinInputStream);
        }
    }

    public final void q() {
        v().disconnect();
        v().unregister(this.L);
        setConnectionState(1280);
    }

    public final boolean r() throws DfuException {
        d(this.mOtaDeviceAddress);
        if (!this.otaEnvironmentPrepared) {
            x();
        } else {
            k();
        }
        if (this.mCurBinInputStream == null) {
            b(4097);
            return false;
        }
        return true;
    }

    public final void s() {
        int i = this.mConnectionState;
        if (i != 0 && i != 1280) {
            v().disconnect();
            waitUntilDisconnected();
        } else if (this.DBG) {
            ZLogger.d("already disconnect");
        }
    }

    public final int t() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_BUFFER_CHECK_ENABLE (0x%04X)", (short) 1543));
        a((short) 1543, (byte[]) null);
        try {
            ZLogger.d(this.DBG, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            byte[] b = b(1600L);
            if (b[0] == 1) {
                ByteBuffer wrap = ByteBuffer.wrap(b);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i = (((short) (wrap.get(2) & 255)) << 8) | ((short) (wrap.get(1) & 255));
                int i2 = ((short) (wrap.get(3) & 255)) | (((short) (wrap.get(4) & 255)) << 8);
                ZLogger.v(this.DBG, "maxBufferSize=" + i + ", bufferCheckMtuSize=" + i2);
                a(i);
                c(i2);
                return 1;
            }
        } catch (DfuException unused) {
            ZLogger.w("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
            this.mErrorState = 0;
        }
        return 0;
    }

    public final void u() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_GET_OTHER_INFO (0x%04X)", (short) 1547));
        byte[] a2 = a((short) 1547);
        if (a2 != null && a2.length > 0) {
            getOtaDeviceInfo().setRwsUpdateFlag(a2[0] & 1);
        } else {
            getOtaDeviceInfo().setRwsUpdateFlag(0);
        }
    }

    public final SppTransportLayer v() {
        if (this.K == null) {
            SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
            this.K = sppTransportLayer;
            sppTransportLayer.register(this.L);
        }
        return this.K;
    }

    public boolean w() {
        BaseBinInputStream baseBinInputStream;
        boolean z = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode == 4097) {
                    a(errCode, false);
                } else {
                    A();
                    b(errCode);
                }
            }
            if (!r() || !C()) {
                return false;
            }
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.d("no pendding image file to upload.");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                z = true;
            } else {
                ZLogger.d("has pendding image file to upload");
                if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                    this.mOtaDeviceAddress = this.mDeviceAddress;
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    p();
                    i();
                } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update imae");
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    a((byte) 1);
                    i();
                }
            }
            sleepInner(1000L);
            if (z) {
                return z;
            }
        }
        b(DfuException.ERROR_DFU_ABORTED);
        return false;
    }

    public final void x() throws DfuException {
        this.otaEnvironmentPrepared = false;
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return;
        }
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        z();
        if (getOtaDeviceInfo().isRwsEnabled()) {
            u();
            if (getOtaDeviceInfo().getRwsUpdateFlag() != 0) {
                throw new OtaException("rws state not ready", 282);
            }
        }
        y();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public final void y() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X)", (short) 1537));
        getOtaDeviceInfo().setActiveImageVersionValues(a((short) 1537));
    }

    public final boolean z() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_GET_DEVICE_INFO (0x%04X)", (short) 1536));
        byte[] a2 = a((short) 1536);
        if (a2 != null) {
            ZLogger.v(DataConverter.bytes2Hex(a2));
            getOtaDeviceInfo().parseX0000(a2);
            a(getOtaDeviceInfo().maxBufferchecksize);
            if (this.DBG) {
                ZLogger.d(getOtaDeviceInfo().toString());
            }
            return true;
        }
        ZLogger.e("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public final int a(String str, int i) {
        int i2 = 0;
        while (a()) {
            int c = c(str);
            if (c == 0) {
                return 0;
            }
            if ((c & (-2049)) != 133) {
                s();
            } else if (this.DBG) {
                ZLogger.d("connect fail with GATT_ERROR, do not need disconnect");
            }
            setConnectionState(1280);
            sleepInner(1600L);
            i2++;
            if (i2 > i) {
                return c;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void a(byte b) throws DfuException {
        if (a(new byte[]{b})) {
            if (getOtaDeviceInfo().isRwsEnabled()) {
                ZLogger.v("RWS, no need to disconnect manully");
            } else {
                if (d()) {
                    waitUntilDisconnected();
                } else {
                    ZLogger.d("device already disconnected");
                }
                g(0);
            }
            closeInputStream(this.mCurBinInputStream);
        }
    }

    public final boolean a(byte[] bArr) throws DfuException {
        boolean z = true;
        int i = 0;
        notifyStateChanged(DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET);
        try {
            if (this.DBG) {
                ZLogger.d(String.format("<< CMD_OTA_ACTIVE_RESET(0x%04X)", (short) 1542));
            }
            z = a((short) 1542, bArr);
        } catch (DfuException e) {
            if (e.getErrCode() == 4128) {
                z = false;
                i = DfuException.ERROR_DFU_ABORTED;
            } else if (!getDfuConfig().isWaitActiveCmdAckEnabled()) {
                ZLogger.d("active cmd has no response, ignore");
            } else {
                ZLogger.w("active cmd has no response, notify error");
                i = e.getErrCode();
                z = false;
            }
        }
        if (z) {
            ZLogger.d("image active success");
            return z;
        }
        throw new OtaException(i);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void a(int i, boolean z) {
        if (this.mAborted) {
            i = DfuException.ERROR_DFU_ABORTED;
        }
        if (i != 4128) {
            notifyStateChanged(260, true);
        }
        if (this.DBG) {
            ZLogger.d(String.format("error = 0x%04X", Integer.valueOf(i)));
        }
        if (z) {
            A();
        }
        BrEdrScannerPresenter brEdrScannerPresenter = this.D;
        if (brEdrScannerPresenter != null) {
            brEdrScannerPresenter.stopScan();
        }
        if (getDfuConfig().isErrorActionEnabled(1)) {
            g(i);
        }
        closeInputStream(this.mCurBinInputStream);
        DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
        if (dfuThreadCallback != null) {
            dfuThreadCallback.onError(i);
        }
        this.mAborted = true;
    }

    public final boolean b(byte[] bArr, int i) throws DfuException {
        short a2 = a(bArr, i);
        if (this.DBG) {
            ZLogger.v(String.format("<< CMD_OTA_BUFFER_CHECK(0x%04X)", (short) 1544));
        }
        a((short) 1544, new byte[]{(byte) (i & 255), (byte) (i >> 8), (byte) (a2 & 255), (byte) ((a2 >> 8) & 255)});
        if (this.DBG) {
            ZLogger.v(String.format("... waiting EVENT_OTA_BUFFER_CHECK(0x%04X)response", (short) 1542));
        }
        byte[] n = n();
        byte b = n[0];
        if (b != 1) {
            if (b == 5 || b == 6 || b == 7) {
                return false;
            }
            if (b != 8) {
                throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
            throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b | 512);
        }
        ByteBuffer wrap = ByteBuffer.wrap(n);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int i2 = wrap.getInt(1);
        this.mImageUpdateOffset = i2;
        if (this.DBG) {
            ZLogger.d(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        return true;
    }

    public final void a(AckPacket ackPacket) {
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (this.J.containsKey(Short.valueOf(toAckId))) {
            this.J.put(Short.valueOf(toAckId), ackPacket);
        }
        switch (toAckId) {
            case oIX0oI.f28372XO /* 1536 */:
                ZLogger.v("ACK-CMD_OTA_GET_DEVICE_INFO");
                if (status == 2 || status == 1) {
                    ZLogger.w("CMD_OTA_GET_DEVICE_INFO not support");
                    this.mErrorState = 281;
                    this.mReadRxData = null;
                    this.I.remove((short) 1536);
                    notifyReadLock();
                    return;
                }
                return;
            case 1537:
            default:
                return;
            case SubBinId.Bbpro.DSP_APP_IMAGE /* 1538 */:
            case 1540:
            case 1541:
            case 1542:
            case 1543:
            case 1544:
            case 1545:
                d(ackPacket.getStatus());
                break;
            case SubBinId.Bbpro.DSP_SCENARIO2 /* 1539 */:
                break;
        }
        if (ackPacket.getStatus() != 0) {
            this.mWriteRetransFlag = true;
            g();
        }
    }

    public final void a(TransportLayerPacket transportLayerPacket) {
        short opcode = transportLayerPacket.getOpcode();
        transportLayerPacket.getPayload();
        byte[] parameters = transportLayerPacket.getParameters();
        switch (opcode) {
            case oIX0oI.f28372XO /* 1536 */:
            case 1537:
            case 1544:
            case 1545:
                short s = (short) (opcode & OX00O0xII.f29066Oxx0xo);
                if (!this.I.contains(Short.valueOf(s))) {
                    ZLogger.w(String.format("not expect event: 0x%04X", Short.valueOf(s)));
                    return;
                }
                this.I.remove(Short.valueOf(s));
                this.mReadRxData = parameters;
                notifyReadLock();
                return;
            case SubBinId.Bbpro.DSP_APP_IMAGE /* 1538 */:
            case 1540:
            case 1541:
            case 1542:
            case 1543:
                synchronized (this.p) {
                    this.G = parameters;
                    this.H = true;
                    this.p.notifyAll();
                }
                return;
            case SubBinId.Bbpro.DSP_SCENARIO2 /* 1539 */:
                if (((parameters == null || parameters.length <= 0) ? (byte) 1 : parameters[0]) == 1) {
                    this.mWriteRetransFlag = false;
                } else {
                    this.mWriteRetransFlag = true;
                }
                g();
                return;
            default:
                return;
        }
    }

    public final int c(String str) {
        BluetoothDevice b = b(str);
        if (b == null) {
            return 4112;
        }
        setConnectionState(256);
        this.mErrorState = 0;
        this.isConnectedCallbackCome = false;
        ZLogger.v(this.DBG, "connecting to " + BluetoothHelper.formatAddress(str, true));
        v().register(this.L);
        v().connect(b, null);
        try {
            synchronized (this.mConnectionLock) {
                try {
                    if (!this.isConnectedCallbackCome && this.mErrorState == 0) {
                        ZLogger.d(this.DBG, "wait for connect for " + getDfuConfig().getConnectionTimeout() + " ms");
                        this.mConnectionLock.wait(getDfuConfig().getConnectionTimeout());
                    }
                } finally {
                }
            }
        } catch (InterruptedException e) {
            ZLogger.w("Sleeping interrupted : " + e.toString());
            this.mErrorState = 259;
        }
        if (this.mErrorState == 0) {
            if (!this.isConnectedCallbackCome) {
                ZLogger.w("wait for connect, but can not connect with no callback");
                this.mErrorState = 260;
            } else if (this.mConnectionState != 515) {
                ZLogger.w("connect with some error, please check. mConnectionState" + this.mConnectionState);
                this.mErrorState = 264;
            }
        }
        if (this.mErrorState != 0) {
            if (this.mConnectionState == 256) {
                setConnectionState(0);
            }
        } else {
            ZLogger.v(this.DBG, "connected the device which going to upgrade");
        }
        return this.mErrorState;
    }

    public final byte[] a(short s) throws DfuException {
        this.mErrorState = 0;
        this.mReadRxData = null;
        if (s == 1536) {
            this.I.add((short) 1536);
        } else if (s == 1537) {
            this.I.add((short) 1537);
        } else if (s == 1546) {
            this.I.add((short) 1544);
        } else if (s == 1547) {
            this.I.add((short) 1545);
        }
        this.mReadRequestCompleted = false;
        if (!v().sendCmd(s, null)) {
            return null;
        }
        synchronized (this.mReadLock) {
            try {
                if (this.mErrorState == 0 && !this.mReadRequestCompleted && this.mConnectionState == 515) {
                    this.mReadLock.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                }
            } catch (InterruptedException e) {
                ZLogger.w("mCharacteristicReadCalledLock Sleeping interrupted,e:" + e);
                this.mErrorState = 259;
            }
        }
        if (this.mErrorState == 0 && !this.mReadRequestCompleted) {
            ZLogger.d(this.DBG, "read value but no callback");
            this.mErrorState = 261;
        }
        if (this.mErrorState == 0) {
            return this.mReadRxData;
        }
        throw new OtaException("Error while send command", this.mErrorState);
    }

    public boolean a(BaseBinInputStream baseBinInputStream, int i, int i2) {
        ZLogger.v(this.DBG, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(baseBinInputStream.remainSizeInBytes()), Integer.valueOf(i), Integer.valueOf(i2)));
        return baseBinInputStream.remainSizeInBytes() + i > i2;
    }
}
