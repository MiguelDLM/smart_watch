package com.realsil.sdk.dfu.v;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.garmin.fit.OxXXx0X;
import com.google.android.exoplayer2.C;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
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
import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DeviceInfoWrapper;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.s.c;
import com.realsil.sdk.dfu.v.c;
import com.realsil.sdk.dfu.v.d;
import com.realsil.sdk.dfu.v.e;
import com.realsil.sdk.dfu.v.j;
import com.realsil.sdk.dfu.v.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jxl.read.biff.oIX0oI;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public abstract class m extends com.realsil.sdk.dfu.t.b {
    public int L;
    public boolean M;
    public TransportLayerCallback N;

    /* loaded from: classes11.dex */
    public class a extends TransportLayerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onAckReceive(AckPacket ackPacket) {
            super.onAckReceive(ackPacket);
            m.this.a(ackPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, boolean z, int i) {
            super.onConnectionStateChanged(bluetoothDevice, z, i);
            ZLogger.v(m.this.VDBG, String.format("onConnectionStateChanged: newsTATE=0x%04X", Integer.valueOf(i)));
            if (i == 2) {
                m.this.setConnectionState(515);
            } else if (i == 0) {
                if (m.this.mProcessState == 521) {
                    m.this.mErrorState = 2048;
                    if (m.this.DBG) {
                        ZLogger.d("disconnect in OTA process, mErrorState: " + m.this.mErrorState);
                    }
                }
                m.this.setConnectionState(0);
                synchronized (m.this.mReadLock) {
                    m.this.mReadRequestCompleted = false;
                    m.this.mReadLock.notifyAll();
                }
            } else {
                return;
            }
            m.this.notifyConnectionLock();
            m.this.g();
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onDataReceive(TransportLayerPacket transportLayerPacket) {
            super.onDataReceive(transportLayerPacket);
            m.this.a(transportLayerPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onError(int i) {
            super.onError(i);
        }
    }

    public m(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.N = new a();
    }

    public void A() throws DfuException {
        ZLogger.v(this.DBG, String.format("<< CMD_OTA_IMAGE_SECTION_SIZE_INFO (0x%04X)", (short) 1546));
        getOtaDeviceInfo().setImageSectionSizeValues(a((short) 1546));
    }

    public void B() throws DfuException {
        if (getOtaDeviceInfo().specVersion <= 5) {
            ZLogger.v(this.DBG, String.format("<< CMD_GET_INACTIVE_BANK_IMAGE_INFO (0x%04X)", (short) 1550));
            getOtaDeviceInfo().setInactiveImageVersionValues(a((short) 1550));
        } else {
            ZLogger.v(this.DBG, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X), bank=0x01", (short) 1537));
            getOtaDeviceInfo().setImageVersionValues(b((short) 1537, new byte[]{1}));
        }
    }

    public boolean C() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_GET_TARGET_INFO (0x%04X)", (short) 1536));
        byte[] a2 = a((short) 1536);
        if (a2 != null) {
            getOtaDeviceInfo().parseX0011(a2);
            return true;
        }
        ZLogger.w("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public boolean D() {
        try {
            if (this.DBG) {
                ZLogger.v(String.format("<< CMD_OTA_RESET (0x%04X)", (short) 1541));
            }
            return a((short) 1541, (byte[]) null, true);
        } catch (DfuException e) {
            ZLogger.w(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public void E() throws DfuException {
        a((byte) 0);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean activeImage(boolean z) {
        if (!super.activeImage(z)) {
            return false;
        }
        if (this.mConnectionState != 515) {
            ZLogger.i(this.DBG, "start to re-connect the RCU which going to active image, current state is: " + this.mConnectionState);
            int a2 = a(this.mOtaDeviceAddress, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                ZLogger.w("Something error in OTA process, errorCode: " + a2 + "mProcessState" + this.mProcessState);
                a(a2, true);
                return false;
            }
        }
        if (z) {
            try {
                a(true);
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
            D();
            a(274, true);
        }
        onDestroy();
        return true;
    }

    public boolean b(BaseBinInputStream baseBinInputStream) {
        return (baseBinInputStream.icType == 11 && baseBinInputStream.getBinId() == 520) || this.mCurBinInputStream.getActiveCompareVersionFlag() == 0 || this.mCurBinInputStream.getInactiveVersionCompFlag() == 0;
    }

    public int c(String str) {
        BluetoothDevice b = b(str);
        if (b == null) {
            return 4112;
        }
        setConnectionState(256);
        this.mErrorState = 0;
        this.isConnectedCallbackCome = false;
        ZLogger.v(this.DBG, "connecting to " + BluetoothHelper.formatAddress(str, true));
        v().register(this.N);
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
            ZLogger.v(this.VDBG, "connected the device which going to upgrade");
        }
        return this.mErrorState;
    }

    public void d(String str) throws DfuException {
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

    public boolean e(int i) throws DfuException {
        byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255)};
        ZLogger.v(this.DBG, String.format("<< CMD_COPY_IMAGE (0x%04X)", (short) 1551));
        if (a((short) 1551, bArr)) {
            ZLogger.v(this.VDBG, "... waiting CMD_COPY_IMAGE response");
            byte b = b(30000L)[0];
            if (b == 1) {
                return true;
            }
            ZLogger.w(String.format("copyImage failed, status=0x%02X", Byte.valueOf(b)));
            throw new OtaException("copyImage failed", 288);
        }
        throw new OtaException("copyImage failed", 512);
    }

    public final boolean f(int i) throws DfuException {
        notifyStateChanged(521);
        getDfuProgressInfo().start();
        if (this.VDBG) {
            ZLogger.v(String.format("forceCopyProcedure, imageId=0x%04X", Integer.valueOf(i)));
            ZLogger.v(getDfuProgressInfo().toString());
        }
        e(i);
        getDfuProgressInfo().sendOver();
        notifyProcessChanged();
        return true;
    }

    public boolean g(int i) {
        return i == 1024 || i == 1040 || i == 1280 || i == 1538 || i == 2304;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public int h() throws DfuException {
        BaseBinInputStream baseBinInputStream;
        notifyStateChanged(521);
        getDfuProgressInfo().start();
        if (this.DBG) {
            ZLogger.v("processCopyProcedure ...");
            ZLogger.v(getDfuProgressInfo().toString());
        }
        try {
            e(getDfuProgressInfo().getCurImageId());
            getDfuProgressInfo().sendOver();
            notifyProcessChanged();
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.v(this.VDBG, "no pendding image file to upload");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                return 3;
            }
            ZLogger.d("has pendding image file to upload");
            if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                this.mOtaDeviceAddress = this.mDeviceAddress;
                this.otaModeEnabled = true;
                this.mBytesSentBuffer = 0;
                a(true);
                getDfuProgressInfo().getActiveImageSize();
                a(30000L);
            } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                this.otaModeEnabled = true;
                this.mBytesSentBuffer = 0;
                a((byte) 1, true);
                getDfuProgressInfo().getActiveImageSize();
                a(30000L);
            }
            return 2;
        } catch (DfuException unused) {
            return 1;
        }
    }

    public void i(int i) throws DfuException {
        a(new j.b(i).a());
        ZLogger.v(this.VDBG, "... Reading CMD_OTA_IMAGE_INFO notification");
        k a2 = k.a(n());
        if (a2 != null && a2.b == 1) {
            if (this.DBG) {
                ZLogger.v(a2.toString());
            }
            this.mImageUpdateOffset = a2.c();
            this.mImageBuffercheckOffset = a2.a();
            return;
        }
        ZLogger.w(String.format("0x%02X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public boolean j(int i) throws DfuException {
        byte[] bArr = {(byte) (i & 255)};
        ZLogger.v(this.DBG, String.format("<< CMD_OTA_ROLE_SWAP (0x%04X)", (short) 1553));
        if (a((short) 1553, bArr)) {
            ZLogger.v(this.VDBG, "... waiting CMD_OTA_ROLE_SWAP response");
            byte b = b(30000L)[0];
            if (b == 1) {
                ZLogger.d(this.DBG, "role swap operation done");
                return true;
            }
            ZLogger.w(String.format("role swap failed, maybe b2b disconnect, status=0x%02X", Byte.valueOf(b)));
            throw new OtaException(String.format("roleSwap failed, status=0x%02X", Byte.valueOf(b)), 283);
        }
        throw new OtaException("roleSwap failed", 512);
    }

    public void k(int i) throws DfuException {
        if (this.mImageUpdateOffset == 0 && w()) {
            this.mImageUpdateOffset = 12;
        }
        ZLogger.d(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        int bytesSent = getDfuProgressInfo().getBytesSent();
        int i2 = this.mImageUpdateOffset;
        if (bytesSent != i2 && i2 != -1) {
            ZLogger.w("mBytesSent != mImageUpdateOffset, reload image bin file");
            this.imageFileLoaded = false;
            l();
            alignmentSendBytes(this.mImageUpdateOffset, false);
        }
    }

    public void l(int i) {
        int i2 = this.mConnectionState;
        if (i2 != 0 && i2 != 1280) {
            s();
        }
        r();
        ZLogger.d(this.DBG, String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i)));
    }

    @Override // com.realsil.sdk.dfu.t.b, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void onDestroy() {
        super.onDestroy();
        SppTransportLayer sppTransportLayer = this.K;
        if (sppTransportLayer != null) {
            sppTransportLayer.unregister(this.N);
        }
    }

    public boolean p() throws DfuException {
        int i;
        if (!getOtaDeviceInfo().isBankEnabled() || getOtaDeviceInfo().specVersion < 5) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list != null && list.size() > 0) {
            i = this.pendingImageInputStreams.size();
            for (BaseBinInputStream baseBinInputStream : this.pendingImageInputStreams) {
                if (b(baseBinInputStream)) {
                    ZLogger.v(this.VDBG, baseBinInputStream.toString());
                    arrayList.add(new c.C0917c(baseBinInputStream.getImageId(), baseBinInputStream.getSha256()));
                }
            }
        } else {
            i = 0;
        }
        if (arrayList.size() <= 0) {
            ZLogger.v(this.VDBG, "no item need to check");
            return true;
        }
        e a2 = new e.b().a(new c.b().a(arrayList).a()).a();
        if (this.DBG) {
            ZLogger.v(a2.toString());
        }
        if (a((short) 1552, a2.a())) {
            ZLogger.v(this.VDBG, "... waiting CMD_CHECK_IMAGE response");
            com.realsil.sdk.dfu.s.a a3 = com.realsil.sdk.dfu.s.a.a(b(30000L));
            if (this.VDBG) {
                ZLogger.v(a3.toString());
            }
            if (arrayList.size() != i || !a3.a()) {
                return true;
            }
            throw new OtaException("already be latest version", 287);
        }
        throw new OtaException("checkImage failed", 512);
    }

    public void q() throws DfuException {
        byte[] bArr;
        int i;
        if (getOtaDeviceInfo().specVersion < 8) {
            return;
        }
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list != null && list.size() > 0) {
            bArr = new byte[this.pendingImageInputStreams.size() * 6];
            i = 0;
            for (BaseBinInputStream baseBinInputStream : this.pendingImageInputStreams) {
                if (baseBinInputStream.getPubKeyHash() != null && baseBinInputStream.getPubKeyHash().length == 4) {
                    int i2 = i * 6;
                    bArr[i2] = (byte) (baseBinInputStream.getImageId() & 255);
                    bArr[i2 + 1] = (byte) ((baseBinInputStream.getImageId() >> 8) & 255);
                    System.arraycopy(baseBinInputStream.getPubKeyHash(), 0, bArr, i2 + 2, 4);
                    i++;
                }
            }
        } else {
            bArr = null;
            i = 0;
        }
        if (bArr != null && bArr.length > 0) {
            a(new d.b().a(i, bArr).a());
            ZLogger.v(this.DBG, String.format("... waiting EVENT_CHECK_PUBLIC_KEY_HASH(0x%04X) response", (short) 1553));
            byte[] n = n();
            if (n != null && n.length > 0 && n[0] == 1) {
                return;
            }
            ZLogger.w("check pub key failed");
            throw new OtaException("ERROR_DFU_PUB_KEYS_CONFLICT", 285);
        }
    }

    public void r() {
        ZLogger.v(this.DBG, "closeGatt");
        v().disconnect();
        v().unregister(this.N);
        setConnectionState(1280);
    }

    public void s() {
        int i = this.mConnectionState;
        if (i != 0 && i != 1280) {
            v().disconnect();
            waitUntilDisconnected();
        } else {
            ZLogger.d(this.DBG, "already disconnect");
        }
    }

    public boolean t() throws DfuException {
        int i;
        ZLogger.v(this.DBG, String.format("<< CMD_OTA_BUFFER_CHECK_ENABLE (0x%04X)", (short) 1543));
        if (!a((short) 1543, (byte[]) null)) {
            ZLogger.d("enableBufferCheck failed");
            return false;
        }
        try {
            ZLogger.v(this.DBG, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE response");
            f a2 = f.a(b(3000L));
            ZLogger.v(this.DBG, a2.toString());
            if (a2.b != 1) {
                ZLogger.d("enableBufferCheck failed");
                return false;
            }
            if (getOtaDeviceInfo().specVersion >= 6) {
                i = getOtaDeviceInfo().mtu;
            } else {
                i = a2.d;
            }
            a(a2.c);
            c(i);
            return true;
        } catch (DfuException unused) {
            ZLogger.w("wait EnableBufferCheckRsp timeout");
            this.mErrorState = 284;
            throw new OtaException("Unable to receive notification", 284);
        }
    }

    public int u() throws DfuException {
        int i;
        if (!getOtaDeviceInfo().isBankEnabled() || getOtaDeviceInfo().specVersion < 5) {
            return 0;
        }
        ZLogger.d(String.format(Locale.US, "binId=0x%04X, activeCompareVersionFlag=%d, inactiveCompareVersionFlag=%d", Integer.valueOf(this.mCurBinInputStream.getBinId()), Integer.valueOf(this.mCurBinInputStream.getActiveCompareVersionFlag()), Integer.valueOf(this.mCurBinInputStream.getInactiveVersionCompFlag())));
        if (!b(this.mCurBinInputStream)) {
            return 0;
        }
        byte a2 = a(getDfuProgressInfo().getCurImageId(), this.mCurBinInputStream.getSha256());
        if ((a2 & 1) == 1) {
            ZLogger.d("current image's sha256 is same as the inactive bank image, need to skip");
            i = 1;
        } else {
            i = 0;
        }
        if ((a2 & 2) == 2) {
            if (g(getDfuProgressInfo().getBinId())) {
                ZLogger.d("current image's sha256 is same as the active bank image, need to copy");
                return i | 2;
            }
            ZLogger.v(String.format("0x%04X not support copy image", Integer.valueOf(getDfuProgressInfo().getBinId())));
            return i;
        }
        return i;
    }

    public SppTransportLayer v() {
        if (this.K == null) {
            SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
            this.K = sppTransportLayer;
            sppTransportLayer.register(this.N);
        }
        return this.K;
    }

    public final boolean w() {
        if (getOtaDeviceInfo().specVersion >= 3) {
            return false;
        }
        return true;
    }

    public void x() throws DfuException {
        if (h(ErrorCode.MSP_ERROR_INVALID_OPERATION)) {
            f(ErrorCode.MSP_ERROR_INVALID_OPERATION);
        }
        if (h(ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE)) {
            f(ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE);
        }
        if (h(10134)) {
            f(10134);
        }
        if (h(10135)) {
            f(10135);
        }
        if (h(ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT)) {
            f(ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT);
        }
        if (h(ErrorCode.MSP_ERROR_BUSY_GRMBUILDING)) {
            f(ErrorCode.MSP_ERROR_BUSY_GRMBUILDING);
        }
        if (h(ErrorCode.MSP_ERROR_BUSY_LEXUPDATING)) {
            f(ErrorCode.MSP_ERROR_BUSY_LEXUPDATING);
        }
    }

    public void y() throws DfuException {
        ZLogger.v(this.VDBG, "processRoleSwapProcedure ...");
        if (getOtaDeviceInfo().specVersion <= 5) {
            a(false);
        } else {
            this.M = true;
            if (getOtaDeviceInfo().getBudRole() == 1) {
                this.L = 2;
            } else if (getOtaDeviceInfo().getBudRole() == 2) {
                this.L = 1;
            } else {
                this.L = 1;
            }
            j(0);
        }
        notifyStateChanged(DfuConstants.PROGRESS_HAND_OVER_PROCESSING);
        ZLogger.d(this.DBG, "wait master to handover ...");
        sleepInner(getDfuConfig().getHandoverTimeout() * 1000);
    }

    public void z() throws DfuException {
        byte[] b;
        if (getOtaDeviceInfo().specVersion <= 5) {
            ZLogger.v(this.DBG, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X)", (short) 1537));
            b = a((short) 1537);
        } else {
            ZLogger.v(this.DBG, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X), bank=0x00", (short) 1537));
            b = b((short) 1537, new byte[]{0});
        }
        getOtaDeviceInfo().setImageVersionValues(b);
    }

    public int a(String str, int i) {
        int i2 = 0;
        while (a()) {
            int c = c(str);
            if (c == 0) {
                return 0;
            }
            if ((c & (-2049)) != 133) {
                s();
            } else {
                ZLogger.w(this.DBG, "connect fail with GATT_ERROR, do not need disconnect");
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

    public boolean b(byte[] bArr, int i) throws DfuException {
        a(new c.b().a(bArr, i).a());
        ZLogger.v(this.DBG, String.format("... waiting EVENT_OTA_BUFFER_CHECK(0x%04X)response", (short) 1542));
        b a2 = b.a(n());
        byte b = a2.b;
        if (b == 1) {
            int i2 = a2.c;
            this.mImageUpdateOffset = i2;
            ZLogger.d(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
            return true;
        }
        if (b == 5 || b == 6 || b == 7) {
            ZLogger.w(String.format("buffer check failed, status=0x%02X ", Byte.valueOf(b)));
            return false;
        }
        if (b != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", a2.b | 512);
    }

    public final byte a(int i, byte[] bArr) throws DfuException {
        if (bArr != null && bArr.length == 32) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.C0917c(i, bArr));
            e a2 = new e.b().a(new c.b().a(arrayList).a()).a();
            if (this.DBG) {
                ZLogger.v(a2.toString());
            }
            if (a((short) 1552, a2.a())) {
                ZLogger.v(this.VDBG, "... waiting CMD_CHECK_IMAGE response");
                com.realsil.sdk.dfu.s.a a3 = com.realsil.sdk.dfu.s.a.a(b(30000L));
                if (this.VDBG) {
                    ZLogger.v(a3.toString());
                }
                return a3.a(i).b;
            }
            throw new OtaException("checkImage failed", 512);
        }
        ZLogger.v("invalid sha256:" + DataConverter.bytes2Hex(bArr));
        return (byte) 0;
    }

    public byte[] b(short s, byte[] bArr) throws DfuException {
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
        } else if (s == 1550) {
            this.I.add((short) 1549);
        }
        this.mReadRequestCompleted = false;
        if (!v().sendCmd(s, bArr)) {
            return null;
        }
        synchronized (this.mReadLock) {
            try {
                if (this.mErrorState == 0 && !this.mReadRequestCompleted && this.mConnectionState == 515) {
                    this.mReadLock.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                }
            } catch (InterruptedException e) {
                ZLogger.w("sleeping interrupted:" + e);
                this.mErrorState = 259;
            }
        }
        if (this.mErrorState == 0 && !this.mReadRequestCompleted) {
            ZLogger.d(this.VDBG, "read value but no callback");
            this.mErrorState = 261;
        }
        if (this.mErrorState == 0) {
            return this.mReadRxData;
        }
        throw new OtaException("Error while send command", this.mErrorState);
    }

    public void a(boolean z) throws DfuException {
        if (a((byte[]) null)) {
            if (z) {
                if (d()) {
                    waitUntilDisconnected();
                } else {
                    ZLogger.d("device already disconnected");
                }
                l(0);
            }
            closeInputStream(this.mCurBinInputStream);
        }
    }

    public final boolean h(int i) {
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list == null) {
            return false;
        }
        Iterator<BaseBinInputStream> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getImageId() == i) {
                ZLogger.v(this.DBG, String.format("image 0x%04X has been packed, no need to force copy", Integer.valueOf(i)));
                return false;
            }
        }
        SocImageWrapper imageWrapper = new DeviceInfoWrapper(getOtaDeviceInfo()).getImageWrapper(i);
        if (imageWrapper == null || imageWrapper.getImageVersion() == -1) {
            return false;
        }
        ZLogger.v(this.DBG, String.format(Locale.US, "image 0x%04X has not been packed, and active SOC image is: 0x%08X, need to force copy", Integer.valueOf(i), Integer.valueOf(imageWrapper.getImageVersion())));
        return true;
    }

    public void a(byte b, boolean z) throws DfuException {
        if (a(new byte[]{b})) {
            if (z) {
                if (d()) {
                    waitUntilDisconnected();
                } else {
                    ZLogger.d("device already disconnected");
                }
                l(0);
            }
            closeInputStream(this.mCurBinInputStream);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r9) throws com.realsil.sdk.dfu.DfuException {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            r2 = 524(0x20c, float:7.34E-43)
            r8.notifyStateChanged(r2)
            r2 = 4
            boolean r3 = r8.DBG     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            java.lang.String r4 = "<< CMD_OTA_ACTIVE_RESET(0x%04X)"
            r5 = 1542(0x606, float:2.161E-42)
            java.lang.Short r6 = java.lang.Short.valueOf(r5)     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            r7[r0] = r6     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            java.lang.String r4 = java.lang.String.format(r4, r7)     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            com.realsil.sdk.core.logger.ZLogger.d(r3, r4)     // Catch: com.realsil.sdk.dfu.DfuException -> L23
            boolean r9 = r8.a(r5, r9)     // Catch: com.realsil.sdk.dfu.DfuException -> L23
        L21:
            r4 = 0
            goto L6b
        L23:
            r9 = move-exception
            int r3 = r9.getErrCode()
            r4 = 4128(0x1020, float:5.785E-42)
            if (r3 != r4) goto L2e
        L2c:
            r9 = 0
            goto L6b
        L2e:
            com.realsil.sdk.dfu.model.OtaDeviceInfo r3 = r8.getOtaDeviceInfo()
            int r3 = r3.specVersion
            if (r3 >= r2) goto L51
            com.realsil.sdk.dfu.model.DfuConfig r3 = r8.getDfuConfig()
            boolean r3 = r3.isWaitActiveCmdAckEnabled()
            if (r3 != 0) goto L47
            java.lang.String r9 = "active cmd has no response, ignore"
            com.realsil.sdk.core.logger.ZLogger.d(r9)
            r9 = 1
            goto L21
        L47:
            java.lang.String r3 = "active cmd has no response, notify error"
            com.realsil.sdk.core.logger.ZLogger.w(r3)
            int r4 = r9.getErrCode()
            goto L2c
        L51:
            int r3 = r9.getErrCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r3
            java.lang.String r3 = "activeImageAndReset failed, errcode= 0x%04X"
            java.lang.String r3 = java.lang.String.format(r3, r4)
            com.realsil.sdk.core.logger.ZLogger.d(r3)
            int r4 = r9.getErrCode()
            goto L2c
        L6b:
            if (r9 == 0) goto L8d
            com.realsil.sdk.dfu.model.OtaDeviceInfo r1 = r8.getOtaDeviceInfo()
            int r1 = r1.specVersion
            if (r1 < r2) goto Lb0
            boolean r1 = r8.DBG     // Catch: com.realsil.sdk.dfu.DfuException -> L82
            java.lang.String r2 = "... Reading CMD_OTA_ACTIVE_RESET notification"
            com.realsil.sdk.core.logger.ZLogger.v(r1, r2)     // Catch: com.realsil.sdk.dfu.DfuException -> L82
            r1 = 1600(0x640, double:7.905E-321)
            r8.b(r1)     // Catch: com.realsil.sdk.dfu.DfuException -> L82
            goto Lb0
        L82:
            r9 = move-exception
            java.lang.String r1 = "Read CMD_OTA_ACTIVE_RESET notification failed"
            com.realsil.sdk.core.logger.ZLogger.w(r1)
            int r4 = r9.getErrCode()
            goto Lb1
        L8d:
            com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer r2 = r8.v()
            int r2 = r2.getConnectionState()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r0] = r3
            java.lang.String r0 = "connectState=0x%04X"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            com.realsil.sdk.core.logger.ZLogger.v(r0)
            r0 = 2
            if (r2 == r0) goto Lb0
            java.lang.String r9 = "connection maybe lost"
            com.realsil.sdk.core.logger.ZLogger.v(r9)
            r0 = 1
            goto Lb1
        Lb0:
            r0 = r9
        Lb1:
            if (r0 == 0) goto Lb9
            java.lang.String r9 = "image active success"
            com.realsil.sdk.core.logger.ZLogger.d(r9)
            return r0
        Lb9:
            com.realsil.sdk.dfu.exception.OtaException r9 = new com.realsil.sdk.dfu.exception.OtaException
            r9.<init>(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.m.a(byte[]):boolean");
    }

    public void a(byte b) throws DfuException {
        r a2 = new r.b().a(this.mCurBinInputStream.getDfuHeader()).a(b).a();
        if (getOtaDeviceInfo().isAesEncryptEnabled()) {
            byte[] aesEncrypt = this.l.aesEncrypt(a2.a(), 0, 16);
            ZLogger.v(this.DBG, a2.toString());
            a(a2.b(), aesEncrypt);
        } else {
            a(a2);
        }
        ZLogger.v(this.VDBG, "... Reading CMD_OTA_START notification");
        byte b2 = n()[0];
        if (b2 == 1) {
            return;
        }
        ZLogger.w(String.format("start dfu failed, status=0x%02X", Byte.valueOf(b2)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void a(int i, byte b) throws DfuException {
        byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255), b};
        ZLogger.v(this.DBG, String.format("<< CMD_OTA_VALID (0x%04X)", (short) 1540));
        if (a((short) 1540, bArr)) {
            ZLogger.v(this.VDBG, "... waiting CMD_OTA_VALID response");
            byte b2 = b(30000L)[0];
            if (b2 == 1) {
                ZLogger.v(this.VDBG, "validate success");
                return;
            } else {
                if (b2 == 5) {
                    ZLogger.w(String.format("0x%02X, Validate FW failed", Byte.valueOf(b2)));
                    throw new OtaException("Validate FW failed", 517);
                }
                ZLogger.w(String.format("Validate FW failed, status=0x%02X", Byte.valueOf(b2)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
        }
        throw new OtaException("Validate FW failed", 512);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void a(int i, boolean z) {
        if (this.mAborted) {
            i = DfuException.ERROR_DFU_ABORTED;
        }
        if (this.DBG) {
            ZLogger.v(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i), Boolean.valueOf(z)));
        }
        if (i != 4128) {
            notifyStateChanged(260, true);
        }
        if (z) {
            D();
        }
        BrEdrScannerPresenter brEdrScannerPresenter = this.D;
        if (brEdrScannerPresenter != null) {
            brEdrScannerPresenter.stopScan();
        }
        if (getDfuConfig().isErrorActionEnabled(1)) {
            l(i);
        }
        closeInputStream(this.mCurBinInputStream);
        DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
        if (dfuThreadCallback != null) {
            dfuThreadCallback.onError(i);
        }
        this.mAborted = true;
    }

    public byte[] a(short s) throws DfuException {
        return b(s, (byte[]) null);
    }

    public final void a(AckPacket ackPacket) {
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (this.J.containsKey(Short.valueOf(toAckId))) {
            this.J.put(Short.valueOf(toAckId), ackPacket);
        }
        if (this.VDBG) {
            ZLogger.v(String.format("decodeAckPacket:0x%04X", Short.valueOf(toAckId)));
        }
        if (toAckId != 1536) {
            switch (toAckId) {
                case SubBinId.Bbpro.DSP_APP_IMAGE /* 1538 */:
                case SubBinId.Bbpro.DSP_SCENARIO2 /* 1539 */:
                case 1540:
                case 1541:
                case 1542:
                case 1543:
                case 1544:
                case 1545:
                    break;
                default:
                    switch (toAckId) {
                        case OxXXx0X.f12952I0X0x0oIo /* 1551 */:
                        case 1552:
                        case 1553:
                        case 1554:
                        case OxXXx0X.f13178oX /* 1555 */:
                            break;
                        default:
                            return;
                    }
            }
            d(ackPacket.getStatus());
            return;
        }
        ZLogger.v("ACK-CMD_OTA_GET_DEVICE_INFO");
        if (status == 2 || status == 1) {
            ZLogger.w("CMD_OTA_GET_DEVICE_INFO not support");
            this.mErrorState = 281;
            this.mReadRxData = null;
            this.I.remove((short) 1536);
            notifyReadLock();
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
            case 1549:
                short s = (short) (opcode & OX00O0xII.f29066Oxx0xo);
                if (!this.I.contains(Short.valueOf(s))) {
                    ZLogger.d(String.format("not expect event: 0x%04X", Short.valueOf(s)));
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
            case 1547:
            case 1550:
            case OxXXx0X.f12952I0X0x0oIo /* 1551 */:
            case 1552:
            case 1553:
                synchronized (this.p) {
                    this.G = parameters;
                    this.H = true;
                    this.p.notifyAll();
                }
                return;
            case SubBinId.Bbpro.DSP_SCENARIO2 /* 1539 */:
            case 1546:
            case 1548:
            default:
                return;
        }
    }

    public boolean a(BaseBinInputStream baseBinInputStream, int i, int i2) {
        ZLogger.v(this.DBG, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(baseBinInputStream.remainSizeInBytes()), Integer.valueOf(i), Integer.valueOf(i2)));
        return baseBinInputStream.remainSizeInBytes() + i > i2;
    }
}
