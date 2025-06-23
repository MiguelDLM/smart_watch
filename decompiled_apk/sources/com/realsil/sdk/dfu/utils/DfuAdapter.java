package com.realsil.sdk.dfu.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.FileTypeInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.x.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class DfuAdapter {
    public static final int MODE_QC = 1;
    public static final int MODE_RELEASE = 0;
    public static final int SECONDARY_STATE_IDLE = 0;
    public static final int STAGE_BACK_CONNECT = 2048;
    public static final int STAGE_IDLE = 0;
    public static final int STAGE_INIT = 256;
    public static final int STAGE_OTA = 1024;
    public static final int STAGE_PREPARE = 512;
    public static final int STATE_ABORTED = 8193;
    public static final int STATE_BACKCONNECT_COMPLETED = 2063;
    public static final int STATE_BACKCONNECT_CONNECTING = 2071;
    public static final int STATE_BACKCONNECT_FAILED = 2062;
    public static final int STATE_BACKCONNECT_SYNC_DATA = 2074;
    public static final int STATE_BACKCONNECT_VALIDATE = 2077;
    public static final int STATE_BACKCONNECT_VALIDATE_FAILED = 2061;
    public static final int STATE_BACKCONNECT_WAIT_PROFILE_CONNECTED = 2065;
    public static final int STATE_CONNECT_FAILED = 4098;
    public static final int STATE_DISCONNECTED = 4097;
    public static final int STATE_DISCONNECTING = 4096;
    public static final int STATE_DISCOVERY_SERVICE = 537;
    public static final int STATE_INIT_BINDING_SERVICE = 257;
    public static final int STATE_INIT_OK = 258;
    public static final int STATE_MASK_BUSY = 16;
    public static final int STATE_MASK_IDLE = 0;
    public static final int STATE_OTA_PROCESSING = 1025;
    public static final int STATE_OTA_START_FAILED = 1026;
    public static final int STATE_PENDDING_DISCOVERY_SERVICE = 536;
    public static final int STATE_PENDING_ABORT = 8192;
    public static final int STATE_PREPARED = 527;
    public static final int STATE_PREPARE_CONNECTING = 535;
    public static final int STATE_PREPARE_PAIRING_REQUEST = 534;
    public static final int STATE_READ_BATTERY_INFO = 542;
    public static final int STATE_READ_DEVICE_INFO = 539;
    public static final int STATE_READ_IMAGE_INFO = 543;
    public static final int STATE_READ_PROTOCOL_TYPE = 540;
    public static final int STATE_SYNC_SUB_INFO = 541;
    public ConnectParams l;
    public Context mContext;
    public DfuHelperCallback n;
    public OtaDeviceInfo t;
    public DfuConfig u;
    public boolean h = true;
    public boolean i = RtkDfu.DEBUG_ENABLE;
    public boolean j = RtkDfu.VDBG;
    public a k = null;
    public int m = 2;
    public Object o = new Object();
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public boolean s = false;
    public Handler v = new Handler(Looper.myLooper());
    public Runnable w = new Runnable() { // from class: com.realsil.sdk.dfu.utils.DfuAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            DfuAdapter.this.b();
        }
    };

    /* loaded from: classes11.dex */
    public static final class BackConnectState extends ConnectState {
        public static final int CHECK_OTA_RESULT = 29;
        public static final int CHECK_OTA_RESULT_FAILED = 13;
    }

    /* loaded from: classes11.dex */
    public static class ConnectState {
        public static final int COMPLETED = 15;
        public static final int CONNECTING = 23;
        public static final int CONNECT_PROILE = 17;
        public static final int CONNECT_PROILE_A2DP = 18;
        public static final int CONNECT_PROILE_HFP = 19;
        public static final int DISCOVERY_SERVICE = 25;
        public static final int ERROR = 14;
        public static final int PAIRING_REQUEST = 22;
        public static final int PENDING_CREATE_BOND = 20;
        public static final int PENDING_DISCOVERY_SERVICE = 24;
        public static final int PENDING_REMOVE_BOND = 21;
        public static final int READ_BATTERY_INFO = 30;
        public static final int READ_DEVICE_INFO = 27;
        public static final int READ_IMAGE_INFO = 31;
        public static final int READ_PROTOCOL_TYPE = 28;
        public static final int SYNC_DATA = 26;
        public static final int SYNC_SUB_INFO = 29;
    }

    /* loaded from: classes11.dex */
    public static abstract class DfuHelperCallback {
        public void onError(int i, int i2) {
        }

        public void onProcessStateChanged(int i, Throughput throughput) {
        }

        public void onProgressChanged(DfuProgressInfo dfuProgressInfo) {
        }

        public void onStateChanged(int i) {
        }

        public void onTargetInfoChanged(OtaDeviceInfo otaDeviceInfo) {
        }
    }

    /* loaded from: classes11.dex */
    public interface IInnerHandler {
        void handleMessage(Message message);
    }

    /* loaded from: classes11.dex */
    public static class InnerHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public IInnerHandler f19617a;

        public InnerHandler(IInnerHandler iInnerHandler) {
            this.f19617a = iInnerHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            IInnerHandler iInnerHandler = this.f19617a;
            if (iInnerHandler != null) {
                iInnerHandler.handleMessage(message);
            } else {
                ZLogger.v("mIInnerHandler is null");
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class InnerHandler2 extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<IInnerHandler> f19618a;

        public InnerHandler2(IInnerHandler iInnerHandler) {
            this.f19618a = new WeakReference<>(iInnerHandler);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            IInnerHandler iInnerHandler = this.f19618a.get();
            if (iInnerHandler != null) {
                iInnerHandler.handleMessage(message);
            } else {
                ZLogger.v("mWeakReference is null");
            }
        }
    }

    public static List<FileTypeInfo> getSupportedFileContents(BinInfo binInfo) {
        List<SubFileInfo> list;
        BinIndicator binIndicatorByBinId;
        ArrayList arrayList = new ArrayList();
        if (binInfo != null) {
            list = binInfo.supportSubFileInfos;
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            for (SubFileInfo subFileInfo : list) {
                int i = binInfo.icType;
                if (i <= 3) {
                    binIndicatorByBinId = BinIndicator.getBinIndicatorByBitNumber(i, subFileInfo.wrapperBitNumber());
                } else {
                    binIndicatorByBinId = BinIndicator.getBinIndicatorByBinId(i, subFileInfo.binId, subFileInfo.bitNumber);
                }
                if (binIndicatorByBinId != null) {
                    arrayList.add(new FileTypeInfo(subFileInfo.bitNumber, binIndicatorByBinId.flashLayoutName));
                } else {
                    arrayList.add(new FileTypeInfo(subFileInfo.bitNumber, ""));
                }
            }
        }
        return arrayList;
    }

    public boolean a() {
        DfuConfig dfuConfig = this.u;
        return dfuConfig != null && dfuConfig.isCheckOtaResultEnabled();
    }

    public boolean abort() {
        return true;
    }

    public void addDfuHelperCallback(DfuHelperCallback dfuHelperCallback) {
        this.n = dfuHelperCallback;
    }

    public boolean b() {
        if (this.k == null) {
            ZLogger.d(this.h, "dfu has not been initialized");
            initialize();
        }
        if (this.l == null) {
            ZLogger.d("mConnectParams == null");
            notifyStateChanged(4098);
            return false;
        }
        ZLogger.v("retry to reconnect device, reconnectTimes =" + this.m);
        return true;
    }

    public boolean checkResult(OtaDeviceInfo otaDeviceInfo, BinInfo binInfo, com.realsil.sdk.dfu.y.a aVar) {
        return false;
    }

    public boolean checkStage(int i) {
        if ((this.q & i) == i) {
            return true;
        }
        return false;
    }

    public boolean checkState(int i, int i2) {
        if (this.q == (i | i2)) {
            return true;
        }
        return false;
    }

    public boolean connectBack() {
        if (this.s) {
            ZLogger.d("ota is processing, please wait");
            return false;
        }
        return true;
    }

    public boolean connectDevice(ConnectParams connectParams) {
        if (this.k == null) {
            ZLogger.w(this.h, "dfu has not been initialized");
            initialize();
            return false;
        }
        if (connectParams == null) {
            ZLogger.w("ConnectParams can not be null");
            return false;
        }
        this.l = connectParams;
        this.m = connectParams.getReconnectTimes();
        ZLogger.v("mConnectParams:" + this.l.toString());
        return true;
    }

    public void destroy() {
        ZLogger.v(this.h, "destroy");
        this.p = 0;
        this.q = 0;
        this.l = null;
        this.m = 0;
        Handler handler = this.v;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        this.n = null;
        a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void disconnect() {
        this.m = 0;
        Handler handler = this.v;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public boolean equals(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public Context getContext() {
        return this.mContext;
    }

    public DfuHelperCallback getDfuAdapterCallback() {
        return this.n;
    }

    public OtaModeInfo getPriorityWorkMode(int i) {
        List<OtaModeInfo> supportedModes = getSupportedModes();
        if (supportedModes != null && supportedModes.size() > 0) {
            for (OtaModeInfo otaModeInfo : supportedModes) {
                if (otaModeInfo != null && otaModeInfo.getWorkmode() == i) {
                    return otaModeInfo;
                }
            }
            return supportedModes.get(0);
        }
        return new OtaModeInfo(0);
    }

    public int getState() {
        return this.q;
    }

    public List<OtaModeInfo> getSupportedModes() {
        return new ArrayList();
    }

    public boolean initialize() {
        return true;
    }

    public boolean isBackConnecting() {
        if ((this.q & 2048) == 2048) {
            return true;
        }
        return false;
    }

    public boolean isBusy() {
        if ((this.q & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean isInitalized() {
        if (this.q >= 258) {
            return true;
        }
        return false;
    }

    public boolean isPreparing() {
        int i = this.q;
        if ((i & 512) == 512 && i != 527) {
            return true;
        }
        return false;
    }

    public boolean isStageBusy(int i) {
        int i2 = this.q;
        if ((i2 & i) != i || (i2 & 16) != 16) {
            return false;
        }
        return true;
    }

    public void notifyError(int i) {
        notifyError(65536, i);
    }

    public void notifyLock() {
        try {
            synchronized (this.o) {
                try {
                    if (this.j) {
                        ZLogger.v("notifyLock");
                    }
                    this.o.notifyAll();
                } finally {
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void notifyProgressChanged(DfuProgressInfo dfuProgressInfo) {
        DfuHelperCallback dfuHelperCallback = this.n;
        if (dfuHelperCallback != null) {
            dfuHelperCallback.onProgressChanged(dfuProgressInfo);
        } else {
            ZLogger.v(this.j, "no callback registered");
        }
    }

    public void notifyStateChanged(int i) {
        int i2 = this.q;
        if (i != i2) {
            ZLogger.v(String.format("DFU 0x%04X >> 0x%04X", Integer.valueOf(i2), Integer.valueOf(i)));
        }
        this.q = i;
        DfuHelperCallback dfuHelperCallback = this.n;
        if (dfuHelperCallback != null) {
            dfuHelperCallback.onStateChanged(i);
        } else {
            ZLogger.v(this.j, "no callback registered");
        }
    }

    public void removeDfuHelperCallback(DfuHelperCallback dfuHelperCallback) {
        this.n = null;
    }

    public void setDfuAdapterCallback(DfuHelperCallback dfuHelperCallback) {
        this.n = dfuHelperCallback;
    }

    public void setMode(int i) {
        this.r = i;
    }

    public boolean setTestParams(OtaDeviceInfo otaDeviceInfo, QcConfig qcConfig) {
        if (otaDeviceInfo != null && qcConfig != null) {
            return false;
        }
        ZLogger.d("IllegalArgumentException: deviceInfo and params can not be null");
        return false;
    }

    public boolean validate(OtaDeviceInfo otaDeviceInfo) {
        if (this.t == null) {
            ZLogger.d("cacheDeviceInfo has already been clean");
            return false;
        }
        return true;
    }

    public void a(long j) {
        synchronized (this.o) {
            try {
                try {
                    if (this.j) {
                        ZLogger.v("waitSyncLock");
                    }
                    this.o.wait(j);
                } catch (InterruptedException e) {
                    ZLogger.d(this.i, "wait sync data interrupted: " + e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyError(int i, int i2) {
        ZLogger.v(String.format("onError: 0x%04X", Integer.valueOf(i2)));
        DfuHelperCallback dfuHelperCallback = this.n;
        if (dfuHelperCallback != null) {
            dfuHelperCallback.onError(i, i2);
        } else {
            ZLogger.v(this.j, "no callback registered");
        }
    }

    public OtaModeInfo getPriorityWorkMode() {
        return getPriorityWorkMode(16);
    }

    public void notifyStateChanged(int i, int i2) {
        int i3 = i2 | i;
        ZLogger.v(String.format("notifyStateChanged 0x%04X >> 0x%04X", Integer.valueOf(this.q), Integer.valueOf(i3)));
        this.p = i;
        this.q = i3;
        DfuHelperCallback dfuHelperCallback = this.n;
        if (dfuHelperCallback != null) {
            dfuHelperCallback.onStateChanged(i3);
        } else {
            ZLogger.v(this.j, "no callback registered");
        }
    }
}
