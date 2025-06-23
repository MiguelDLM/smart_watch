package com.bluetrum.fota.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bluetrum.fota.log.Logger;
import com.bluetrum.fota.manager.OtaManager;
import com.bluetrum.fota.utils.HexUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* loaded from: classes8.dex */
public abstract class OtaManager {
    private static final int DEFAULT_TIMEOUT = 10000;
    protected static final int DELAY_AFTER_SEND_IDENTIFICATION = 200;
    private static final String TAG = "OtaManager";
    private static final int UNDEFINED_FIRMWARE_VERSION = -1;
    protected boolean allowedUpdate;
    protected OtaDataProvider dataProvider;
    private final EventListener eventListener;
    protected int otaFirmwareVersion = -1;
    protected int deviceFirmwareVersion = -1;
    private int mBlockSize = 4096;
    private int mPacketSize = 240;
    protected boolean isUpdating = false;
    protected boolean isUpdatePause = false;
    protected Boolean isTwsDevice = null;
    protected Boolean isTwsConnected = null;
    public boolean disconnectedDueToDeviceError = false;
    private boolean _needIdentification = true;
    protected boolean sentIdentification = false;
    private final Handler notifyHandler = new Handler(Looper.getMainLooper());
    private final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    protected OtaCommandGenerator commandGenerator = new OtaCommandGenerator();

    /* loaded from: classes8.dex */
    public interface EventListener {
        void onOtaContinue();

        void onOtaError(OtaError otaError);

        void onOtaFinish();

        void onOtaPause();

        void onOtaProgress(int i);

        void onOtaReady();

        void onOtaStart();

        void onOtaStop();

        void onReceiveChannel(boolean z);

        void onReceiveIsTWS(boolean z);

        void onReceiveTWSConnected(boolean z);

        void onReceiveVersion(int i);

        void onTWSDisconnected();
    }

    public OtaManager(@NonNull EventListener eventListener) {
        this.eventListener = eventListener;
    }

    private void cancelTimeout() {
        this.timeoutHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeout() {
        if (this.isUpdatePause) {
            return;
        }
        Logger.e(TAG, "Timed out while waiting for response: " + this.isUpdating);
        synchronized (this) {
            try {
                if (this.isUpdating) {
                    notifyOnError(OtaError.TIMEOUT_RECEIVE_RESPONSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnError$1(OtaError otaError) {
        this.eventListener.onOtaError(otaError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnProgress$0(int i) {
        this.eventListener.onOtaProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnReceiveChannel$5(boolean z) {
        this.eventListener.onReceiveChannel(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnReceiveIsTWS$3(boolean z) {
        this.eventListener.onReceiveIsTWS(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnReceiveTWSConnected$4(boolean z) {
        this.eventListener.onReceiveTWSConnected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnReceiveVersion$2(int i) {
        this.eventListener.onReceiveVersion(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runDataSend$6() {
        this.sentIdentification = true;
        getAllInfo();
    }

    private void processGetInfoTLV(byte[] bArr) {
        while (bArr.length > 2) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte[] bArr2 = new byte[wrap.get()];
            wrap.get(bArr2);
            processInfo(b, bArr2);
            if (!wrap.hasRemaining()) {
                break;
            }
            byte[] bArr3 = new byte[wrap.remaining()];
            wrap.get(bArr3);
            bArr = bArr3;
        }
        checkIfReadyToUpdate();
    }

    private void processInfo(byte b, byte[] bArr) {
        String str = TAG;
        Logger.d(str, "processInfo: " + ((int) b) + org.apache.commons.text.oIX0oI.f33048oxoX + HexUtils.bytesToHex(bArr));
        boolean z = true;
        if (b != 1) {
            if (b != 2) {
                if (b != 3) {
                    if (b != 4) {
                        if (b == 6 && bArr.length == 1) {
                            byte b2 = bArr[0];
                            if (b2 == 1) {
                                Logger.d(str, "Channel: Left");
                                notifyOnReceiveChannel(true);
                                return;
                            } else {
                                if (b2 == 0) {
                                    Logger.d(str, "Channel: Right");
                                    notifyOnReceiveChannel(false);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (bArr.length == 2) {
                        if ((ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort() & 1) == 0) {
                            z = false;
                        }
                        this.isTwsConnected = Boolean.valueOf(z);
                        Logger.d(str, "isTwsConnected: " + this.isTwsConnected);
                        notifyOnReceiveTWSConnected(this.isTwsConnected.booleanValue());
                        return;
                    }
                    return;
                }
                if (bArr.length == 2) {
                    if ((ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort() & 1) == 0) {
                        z = false;
                    }
                    this.isTwsDevice = Boolean.valueOf(z);
                    Logger.d(str, "isTWS: " + this.isTwsDevice);
                    notifyOnReceiveIsTWS(this.isTwsDevice.booleanValue());
                    return;
                }
                return;
            }
            if (bArr.length == 11) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                int i = order.getInt();
                this.dataProvider.setStartAddress(i);
                Logger.d(str, "startAddress = " + i);
                int i2 = order.getInt();
                this.mBlockSize = i2;
                this.dataProvider.setBlockSize(i2);
                Logger.d(str, "blockSize = " + i2);
                short s = order.getShort();
                this.mPacketSize = s;
                this.dataProvider.setPacketSize(s);
                Logger.d(str, "packetSize = " + ((int) s));
                if (order.get() != 1) {
                    z = false;
                }
                this.allowedUpdate = z;
                Logger.d(str, "allowedUpdate = " + this.allowedUpdate);
                return;
            }
            return;
        }
        if (bArr.length == 2) {
            short s2 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort();
            notifyOnReceiveVersion(s2);
            this.deviceFirmwareVersion = s2;
        }
    }

    private void waitingForTimeout() {
        this.timeoutHandler.postDelayed(new Runnable() { // from class: com.bluetrum.fota.manager.XO
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.handleTimeout();
            }
        }, 10000L);
    }

    public abstract void btSendData(byte[] bArr);

    public boolean canSendNow() {
        if (this.allowedUpdate && !this.dataProvider.isBlockSendFinish()) {
            return true;
        }
        return false;
    }

    public void checkIfReadyToUpdate() {
        boolean isReadyToUpdate = isReadyToUpdate();
        Logger.i(TAG, "checkIfReadyToUpdate: " + isReadyToUpdate);
        if (isReadyToUpdate) {
            notifyOnReady();
        }
    }

    public void getAllInfo() {
        btSendData(this.commandGenerator.cmdGetAllInfo());
        waitingForTimeout();
    }

    public int getBlockSize() {
        return this.mBlockSize;
    }

    public void getOtaInfoUpdate(int i) {
        OtaDataProvider otaDataProvider = this.dataProvider;
        if (otaDataProvider != null) {
            try {
                btSendData(this.commandGenerator.cmdGetInfoUpdate(i, otaDataProvider.getHash()));
                waitingForTimeout();
            } catch (IOException e) {
                e.printStackTrace();
                notifyOnError(OtaError.DATA_READER_ERROR);
            }
        }
    }

    public void getOtaInfoVersion() {
        btSendData(this.commandGenerator.cmdGetInfoVersion());
        waitingForTimeout();
    }

    public int getPacketSize() {
        return this.mPacketSize;
    }

    public void init() {
    }

    public boolean isCompressedData() {
        return this.dataProvider.isCompressedData();
    }

    public boolean isDeviceReady() {
        Logger.i(TAG, "isDeviceReady: isTwsDevice = " + this.isTwsDevice + ", isTwsConnected = " + this.isTwsConnected);
        Boolean bool = this.isTwsDevice;
        if (bool == null) {
            return false;
        }
        if (bool.booleanValue()) {
            return isTwsConnected();
        }
        return true;
    }

    public boolean isReadyToUpdate() {
        boolean z;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("isReadyToUpdate: DeviceReady = ");
        sb.append(isDeviceReady());
        sb.append(", DataReady = ");
        if (this.dataProvider != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        Logger.i(str, sb.toString());
        if (!isDeviceReady() || this.dataProvider == null) {
            return false;
        }
        return true;
    }

    public boolean isTwsConnected() {
        Boolean bool = this.isTwsConnected;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isTwsDevice() {
        Boolean bool = this.isTwsDevice;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isUpdating() {
        return this.isUpdating;
    }

    public boolean needIdentification() {
        return this._needIdentification;
    }

    public void notifyOnContinue() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onOtaContinue();
            }
        });
    }

    public void notifyOnError(final OtaError otaError) {
        this.disconnectedDueToDeviceError = true;
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.x0XOIxOo
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnError$1(otaError);
            }
        });
        release();
    }

    public void notifyOnFinish() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onOtaFinish();
            }
        });
    }

    public void notifyOnPause() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onOtaPause();
            }
        });
    }

    public void notifyOnProgress(final int i) {
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.Oxx0IOOO
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnProgress$0(i);
            }
        });
    }

    public void notifyOnReady() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.oO
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onOtaReady();
            }
        });
    }

    public void notifyOnReceiveChannel(final boolean z) {
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnReceiveChannel$5(z);
            }
        });
    }

    public void notifyOnReceiveIsTWS(final boolean z) {
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.II0XooXoX
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnReceiveIsTWS$3(z);
            }
        });
    }

    public void notifyOnReceiveTWSConnected(final boolean z) {
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnReceiveTWSConnected$4(z);
            }
        });
    }

    public void notifyOnReceiveVersion(final int i) {
        this.notifyHandler.post(new Runnable() { // from class: com.bluetrum.fota.manager.ooOOo0oXI
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.this.lambda$notifyOnReceiveVersion$2(i);
            }
        });
    }

    public void notifyOnStart() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onOtaStart();
            }
        });
    }

    public void notifyOnStop() {
        if (!this.disconnectedDueToDeviceError) {
            Handler handler = this.notifyHandler;
            final EventListener eventListener = this.eventListener;
            Objects.requireNonNull(eventListener);
            handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    OtaManager.EventListener.this.onOtaStop();
                }
            });
        }
        this.disconnectedDueToDeviceError = false;
    }

    public void notifyTWSDisconnected() {
        Handler handler = this.notifyHandler;
        final EventListener eventListener = this.eventListener;
        Objects.requireNonNull(eventListener);
        handler.post(new Runnable() { // from class: com.bluetrum.fota.manager.oOoXoXO
            @Override // java.lang.Runnable
            public final void run() {
                OtaManager.EventListener.this.onTWSDisconnected();
            }
        });
    }

    public void prepareToUpdate() {
        if (needIdentification()) {
            sendOtaIdentification();
        } else {
            getAllInfo();
        }
    }

    public boolean processData(byte[] bArr) {
        if (bArr.length < 3) {
            Logger.w(TAG, "The length of received data less than 3");
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b = wrap.get();
        wrap.get();
        switch (b) {
            case -112:
                processNotifyStatus(wrap.get());
                return true;
            case -111:
                cancelTimeout();
                byte b2 = wrap.get();
                byte[] bArr2 = new byte[wrap.remaining()];
                wrap.get(bArr2, 0, wrap.remaining());
                processGetInfo(b2, bArr2);
                return true;
            case -110:
                cancelTimeout();
                byte[] bArr3 = new byte[wrap.remaining()];
                wrap.get(bArr3, 0, wrap.remaining());
                processGetInfoTLV(bArr3);
                return true;
            default:
                return false;
        }
    }

    public void processGetInfo(byte b, byte[] bArr) {
        processInfo(b, bArr);
        if (b != 1) {
            if (b == 2) {
                if (this.allowedUpdate) {
                    sendOtaStart();
                    return;
                } else {
                    cancelTimeout();
                    notifyOnError(OtaError.REFUSED_BY_DEVICE);
                    return;
                }
            }
            return;
        }
        getOtaInfoUpdate(this.otaFirmwareVersion);
    }

    public void processNotifyStatus(byte b) {
        if (b != Byte.MIN_VALUE) {
            if (b != -3) {
                if (b != -2) {
                    if (b != -1) {
                        if (b != 0) {
                            OtaError otaError = OtaError.REPORT_FROM_DEVICE;
                            otaError.setDeviceErrorCode(b);
                            cancelTimeout();
                            notifyOnError(otaError);
                            return;
                        }
                        cancelTimeout();
                        if (!this.isUpdatePause && !this.dataProvider.isAllDataSent()) {
                            sendOtaStart();
                            return;
                        }
                        return;
                    }
                    cancelTimeout();
                    notifyOnFinish();
                    release();
                    return;
                }
                notifyOnContinue();
                this.isUpdating = true;
                this.isUpdatePause = false;
                getOtaInfoVersion();
                return;
            }
            cancelTimeout();
            this.allowedUpdate = false;
            this.isUpdating = false;
            this.isUpdatePause = true;
            notifyOnPause();
            return;
        }
        cancelTimeout();
        this.isUpdating = false;
        this.isTwsConnected = Boolean.FALSE;
        notifyTWSDisconnected();
        notifyOnReceiveTWSConnected(this.isTwsConnected.booleanValue());
    }

    public void release() {
        synchronized (this) {
            this.otaFirmwareVersion = -1;
            this.deviceFirmwareVersion = -1;
            this.allowedUpdate = false;
            this.isUpdating = false;
            this.isUpdatePause = false;
            this.sentIdentification = false;
            cancelTimeout();
            this.commandGenerator.reset();
            OtaDataProvider otaDataProvider = this.dataProvider;
            if (otaDataProvider != null) {
                try {
                    otaDataProvider.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void runDataSend() {
        if (needIdentification() && !this.sentIdentification) {
            HandlerThread handlerThread = new HandlerThread("Get All Info");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).postDelayed(new Runnable() { // from class: com.bluetrum.fota.manager.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    OtaManager.this.lambda$runDataSend$6();
                }
            }, 200L);
        } else {
            if (canSendNow()) {
                sendOtaDataOnce();
                return;
            }
            OtaDataProvider otaDataProvider = this.dataProvider;
            if (otaDataProvider != null && otaDataProvider.isBlockSendFinish()) {
                waitingForTimeout();
            }
        }
    }

    public void sendOtaData() {
        byte[] cmdSendDataHeader = this.commandGenerator.cmdSendDataHeader();
        int length = cmdSendDataHeader.length;
        try {
            byte[] dataToBeSent = this.dataProvider.getDataToBeSent(length);
            byte[] bArr = new byte[dataToBeSent.length + length];
            System.arraycopy(cmdSendDataHeader, 0, bArr, 0, length);
            System.arraycopy(dataToBeSent, 0, bArr, length, dataToBeSent.length);
            btSendData(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            notifyOnError(OtaError.DATA_READER_ERROR);
        }
        notifyOnProgress(this.dataProvider.getProgress());
    }

    public void sendOtaDataOnce() {
        sendOtaData();
    }

    public void sendOtaIdentification() {
        btSendData(this.commandGenerator.cmdOtaIdentification());
    }

    public void sendOtaStart() {
        byte[] cmdStartSendHeader = this.commandGenerator.cmdStartSendHeader(this.dataProvider.getStartAddress(), this.dataProvider.getTotalLengthToBeSent());
        int length = cmdStartSendHeader.length;
        try {
            byte[] startData = this.dataProvider.getStartData(length);
            byte[] bArr = new byte[startData.length + length];
            System.arraycopy(cmdStartSendHeader, 0, bArr, 0, length);
            System.arraycopy(startData, 0, bArr, length, startData.length);
            btSendData(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            notifyOnError(OtaError.DATA_READER_ERROR);
        }
        notifyOnProgress(this.dataProvider.getProgress());
    }

    public void setDataReader(@NonNull DataReader dataReader) {
        try {
            OtaDataProvider otaDataProvider = new OtaDataProvider(dataReader);
            this.dataProvider = otaDataProvider;
            otaDataProvider.open();
            this.dataProvider.setBlockSize(getBlockSize());
            this.dataProvider.setPacketSize(getPacketSize());
            checkIfReadyToUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            notifyOnError(OtaError.DATA_READER_ERROR);
        }
    }

    public void setNeedIdentification(boolean z) {
        this._needIdentification = z;
    }

    public void setOtaData(@NonNull byte[] bArr) {
        setDataReader(new OtaDataReader(bArr));
    }

    public void setOtaFirmwareVersion(int i) {
        this.otaFirmwareVersion = i;
    }

    public void startOTA() {
        this.isUpdating = true;
        notifyOnStart();
        getOtaInfoVersion();
    }
}
