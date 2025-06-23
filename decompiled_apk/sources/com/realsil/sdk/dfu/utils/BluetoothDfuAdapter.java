package com.realsil.sdk.dfu.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.BluetoothProfileCallback;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManager;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.utils.ConnectParams;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import java.io.File;
import java.util.Locale;

/* loaded from: classes11.dex */
public abstract class BluetoothDfuAdapter extends DfuAdapter {
    public BluetoothDevice A;
    public String C;
    public BluetoothProfileCallback E;
    public BluetoothAdapter x;
    public BluetoothProfileManager y;
    public RtkBluetoothManager z;
    public int B = 10;
    public final RtkBluetoothManagerCallback D = new a();
    public com.realsil.sdk.dfu.x.b F = new b();

    /* loaded from: classes11.dex */
    public class a extends RtkBluetoothManagerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback
        public void onBondStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onBondStateChanged(bluetoothDevice, i);
            BluetoothDevice bluetoothDevice2 = BluetoothDfuAdapter.this.A;
            if (bluetoothDevice2 != null && bluetoothDevice2.equals(bluetoothDevice)) {
                BluetoothDfuAdapter.this.processBondStateChanged(i);
            } else {
                ZLogger.v(BluetoothDfuAdapter.this.j, "bonded device not match with current device");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends com.realsil.sdk.dfu.x.b {
        public b() {
        }

        @Override // com.realsil.sdk.dfu.x.b
        public void a(boolean z, com.realsil.sdk.dfu.x.a aVar) {
            if (z) {
                ZLogger.d("DfuService connected");
                BluetoothDfuAdapter bluetoothDfuAdapter = BluetoothDfuAdapter.this;
                bluetoothDfuAdapter.k = aVar;
                bluetoothDfuAdapter.notifyStateChanged(258);
                return;
            }
            ZLogger.d("DfuService disconnected");
            BluetoothDfuAdapter bluetoothDfuAdapter2 = BluetoothDfuAdapter.this;
            bluetoothDfuAdapter2.k = null;
            bluetoothDfuAdapter2.notifyStateChanged(0);
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onError(int i) {
            BluetoothDfuAdapter bluetoothDfuAdapter = BluetoothDfuAdapter.this;
            bluetoothDfuAdapter.s = false;
            bluetoothDfuAdapter.notifyError(i);
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onProgressChanged(DfuProgressInfo dfuProgressInfo) {
            super.onProgressChanged(dfuProgressInfo);
            BluetoothDfuAdapter.this.notifyProgressChanged(dfuProgressInfo);
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onStateChanged(int i, Throughput throughput) {
            boolean z;
            super.onStateChanged(i, throughput);
            BluetoothDfuAdapter bluetoothDfuAdapter = BluetoothDfuAdapter.this;
            if ((i & 512) == 512) {
                z = true;
            } else {
                z = false;
            }
            bluetoothDfuAdapter.s = z;
            DfuAdapter.DfuHelperCallback dfuHelperCallback = bluetoothDfuAdapter.n;
            if (dfuHelperCallback != null) {
                dfuHelperCallback.onProcessStateChanged(i, throughput);
            } else {
                ZLogger.v(bluetoothDfuAdapter.j, "no callback registered");
            }
        }
    }

    public void a(DfuException dfuException) {
        if (a(dfuException.getErrCode())) {
            this.m--;
            Handler handler = this.v;
            if (handler != null) {
                handler.postDelayed(this.w, 1000L);
                return;
            }
            return;
        }
        disconnect();
        notifyError(dfuException.getErrType(), dfuException.getErrCode());
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean abort() {
        com.realsil.sdk.dfu.x.a aVar = this.k;
        if (aVar != null) {
            return aVar.a();
        }
        ZLogger.w("dfu has not been initialized");
        c();
        return false;
    }

    public boolean activeImage(boolean z) {
        com.realsil.sdk.dfu.x.a aVar = this.k;
        if (aVar != null) {
            return aVar.a(z);
        }
        ZLogger.w("dfu has not been initialized");
        c();
        return false;
    }

    public void c() {
        boolean z = RtkDfu.DEBUG_ENABLE;
        this.h = z;
        this.i = z;
        this.j = RtkDfu.VDBG;
        this.x = BluetoothAdapter.getDefaultAdapter();
        getOtaDeviceInfo().setMode(2);
        this.E = getBluetoothProfileCallback();
        BluetoothProfileManager bluetoothProfileManager = BluetoothProfileManager.getInstance();
        this.y = bluetoothProfileManager;
        if (bluetoothProfileManager == null) {
            BluetoothProfileManager.initial(this.mContext);
            this.y = BluetoothProfileManager.getInstance();
        }
        BluetoothProfileManager bluetoothProfileManager2 = this.y;
        if (bluetoothProfileManager2 != null) {
            bluetoothProfileManager2.addManagerCallback(this.E);
        } else {
            ZLogger.v(this.h, "BluetoothProfileManager not initialized");
        }
        RtkBluetoothManager rtkBluetoothManager = RtkBluetoothManager.getInstance();
        this.z = rtkBluetoothManager;
        if (rtkBluetoothManager == null) {
            RtkBluetoothManager.initial(this.mContext);
            this.z = RtkBluetoothManager.getInstance();
        }
        RtkBluetoothManager rtkBluetoothManager2 = this.z;
        if (rtkBluetoothManager2 != null) {
            rtkBluetoothManager2.addManagerCallback(this.D);
        } else {
            ZLogger.w("BluetoothProfileManager not initialized");
        }
    }

    public boolean checkImage(String str, boolean z, OtaDeviceInfo otaDeviceInfo) throws DfuException {
        BinInfo loadImageBinInfo = FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().with(this.mContext).fileLocation(0).setFilePath(str).setOtaDeviceInfo(otaDeviceInfo).setSectionSizeCheckEnabled(false).setIcCheckEnabled(false).versionCheckEnabled(z).build());
        return loadImageBinInfo != null && loadImageBinInfo.status == 4096;
    }

    public boolean checkUpgrade(File file, int i) {
        return checkUpgrade(file, true, i);
    }

    public void close() {
        this.n = null;
        disconnect();
        destroy();
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectDevice(ConnectParams connectParams) {
        if (!super.connectDevice(connectParams)) {
            return false;
        }
        if (this.l.getAddress() != null) {
            return true;
        }
        ZLogger.w("address is null");
        return false;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        this.A = null;
        this.C = null;
        RtkBluetoothManager rtkBluetoothManager = this.z;
        if (rtkBluetoothManager != null) {
            rtkBluetoothManager.removeManagerCallback(this.D);
        }
        BluetoothProfileManager bluetoothProfileManager = this.y;
        if (bluetoothProfileManager != null) {
            bluetoothProfileManager.removeManagerCallback(this.E);
        }
    }

    public BluetoothProfileCallback getBluetoothProfileCallback() {
        return null;
    }

    public int getBondState(String str) {
        BluetoothDevice remoteDevice;
        if (this.x == null || (remoteDevice = getRemoteDevice(str)) == null) {
            return 10;
        }
        return remoteDevice.getBondState();
    }

    public int getCurrentOtaState() {
        com.realsil.sdk.dfu.x.a aVar = this.k;
        if (aVar != null) {
            return aVar.e();
        }
        ZLogger.w("dfu has not been initialized");
        c();
        return -1;
    }

    public OtaDeviceInfo getOtaDeviceInfo() {
        return new OtaDeviceInfo(2);
    }

    public BluetoothDevice getRemoteDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter = this.x;
        if (bluetoothAdapter == null) {
            ZLogger.w("mBluetoothAdapter == null");
            return null;
        }
        try {
            return bluetoothAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            ZLogger.e(e.toString());
            return null;
        }
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean initialize() {
        return initialize(this.n);
    }

    public boolean isBluetoothSupported() {
        if (this.x != null) {
            return true;
        }
        return false;
    }

    public boolean isIdle() {
        if ((getCurrentOtaState() & 256) == 256) {
            return true;
        }
        return false;
    }

    public int preCheck(OtaDeviceInfo otaDeviceInfo, DfuConfig dfuConfig) {
        try {
            BinInfo loadImageBinInfo = FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().with(this.mContext).fileLocation(dfuConfig.getFileLocation()).setFilePath(dfuConfig.getFilePath()).setSectionSizeCheckEnabled(dfuConfig.isSectionSizeCheckEnabled()).setIcCheckEnabled(dfuConfig.isIcCheckEnabled()).setFileSuffix(dfuConfig.getFileSuffix()).versionCheckEnabled(dfuConfig.isVersionCheckEnabled(), dfuConfig.getVersionCheckMode()).setWorkMode(dfuConfig.getOtaWorkMode()).setOtaDeviceInfo(otaDeviceInfo).build());
            if (loadImageBinInfo == null) {
                ZLogger.w("load binInfo failed");
                return 4097;
            }
            if (loadImageBinInfo.status != 4096) {
                ZLogger.w("checkImage failed");
                return loadImageBinInfo.status;
            }
            if (dfuConfig.isBatteryCheckEnabled() && otaDeviceInfo.isBasSupported()) {
                if (otaDeviceInfo.isRwsEnabled()) {
                    if (otaDeviceInfo.getPrimaryBat() > 0 && otaDeviceInfo.getPrimaryBat() < dfuConfig.getLowBatteryThreshold()) {
                        ZLogger.d(this.h, String.format("primary battery can not be less thant %d", Integer.valueOf(dfuConfig.getLowBatteryThreshold())));
                        return 269;
                    }
                    if (otaDeviceInfo.getSecondaryBat() > 0 && otaDeviceInfo.getSecondaryBat() < dfuConfig.getLowBatteryThreshold()) {
                        ZLogger.d(this.h, String.format("secondary battery can not be less thant %d", Integer.valueOf(dfuConfig.getLowBatteryThreshold())));
                        return 269;
                    }
                } else if (otaDeviceInfo.getPrimaryBat() < dfuConfig.getLowBatteryThreshold()) {
                    ZLogger.d(this.h, String.format("battery can not be less thant %d", Integer.valueOf(dfuConfig.getLowBatteryThreshold())));
                    return 269;
                }
            }
            return 0;
        } catch (LoadFileException e) {
            return e.getErrCode();
        }
    }

    public void processBondStateChanged(int i) {
        this.B = i;
        if (i == 12) {
            notifyLock();
        }
    }

    public void processHidStateChanged(int i) {
    }

    public boolean startOtaProcedure(DfuConfig dfuConfig) {
        return startOtaProcedure(dfuConfig, true);
    }

    public boolean startOtaProcess(DfuConfig dfuConfig) {
        return startOtaProcedure(dfuConfig, true);
    }

    public boolean checkUpgrade(File file, boolean z, int i) {
        if (getOtaDeviceInfo() == null) {
            ZLogger.w("please reConnectToDevice() method to connect and get otaDeviceInfo first.");
            return false;
        }
        try {
            if (checkImage(0, file.getPath(), z, false, false, getOtaDeviceInfo())) {
                return !getOtaDeviceInfo().isBasSupported() || getOtaDeviceInfo().getPrimaryBat() >= i;
            }
            return false;
        } catch (DfuException e) {
            ZLogger.w(e.toString());
            return false;
        }
    }

    public boolean initialize(DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        this.n = dfuHelperCallback;
        if (this.q == 257) {
            ZLogger.w("STATE_INIT_BINDING_SERVICE ...");
            return false;
        }
        if (this.k == null) {
            notifyStateChanged(257);
            boolean a2 = com.realsil.sdk.dfu.x.a.a(this.mContext, this.F);
            ZLogger.v(this.j, "getDfuProxy: " + a2);
            if (a2) {
                return a2;
            }
            notifyStateChanged(0);
            return a2;
        }
        ZLogger.v(this.h, "dfu already binded");
        notifyStateChanged(258);
        return true;
    }

    public boolean startOtaProcedure(OtaDeviceInfo otaDeviceInfo, DfuConfig dfuConfig) {
        return startOtaProcedure(otaDeviceInfo, dfuConfig, null, true);
    }

    public boolean startOtaProcedure(DfuConfig dfuConfig, boolean z) {
        return startOtaProcedure(getOtaDeviceInfo(), dfuConfig, null, z);
    }

    public boolean connectDevice(String str) {
        return connectDevice(new ConnectParams.Builder().address(str).hid(false).build());
    }

    public boolean startOtaProcedure(DfuConfig dfuConfig, OtaDeviceInfo otaDeviceInfo, boolean z) {
        return startOtaProcedure(otaDeviceInfo, dfuConfig, null, z);
    }

    public boolean startOtaProcedure(OtaDeviceInfo otaDeviceInfo, DfuConfig dfuConfig, QcConfig qcConfig, boolean z) {
        int preCheck;
        if (dfuConfig != null) {
            if (this.k == null) {
                ZLogger.w("DFU not ready, please make sure that you have call initialize() before");
                initialize();
                return false;
            }
            if (otaDeviceInfo != null) {
                dfuConfig.setProtocolType(otaDeviceInfo.getProtocolType());
            }
            if (z && otaDeviceInfo != null && (preCheck = preCheck(otaDeviceInfo, dfuConfig)) != 0) {
                notifyError(preCheck);
                return false;
            }
            if (qcConfig == null) {
                ZLogger.v("not set qcConfig");
            } else {
                ZLogger.v("qcConfig:" + qcConfig.toString());
            }
            this.t = otaDeviceInfo;
            this.u = dfuConfig;
            return true;
        }
        ZLogger.w("dfuConfig cannot be null");
        throw new IllegalArgumentException("dfuConfig cannot be null");
    }

    public boolean a(int i) {
        if (this.q <= 258) {
            ZLogger.w("has not be initialized");
            return false;
        }
        int i2 = this.m;
        if (i2 > 0) {
            return i == 0 || i == 1 || i == 6;
        }
        ZLogger.v(String.format(Locale.US, "reconnectTimes=%d, no need to reconnect", Integer.valueOf(i2)));
        return false;
    }

    public boolean connectDevice(BluetoothDevice bluetoothDevice, boolean z) {
        return connectDevice(new ConnectParams.Builder().address(bluetoothDevice.getAddress()).hid(z).build());
    }

    public boolean checkImage(int i, String str, boolean z, boolean z2, boolean z3, OtaDeviceInfo otaDeviceInfo) throws LoadFileException {
        BinInfo loadImageBinInfo = FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().with(this.mContext).fileLocation(i).setFilePath(str).setOtaDeviceInfo(otaDeviceInfo).setSectionSizeCheckEnabled(z2).setIcCheckEnabled(z3).versionCheckEnabled(z).build());
        return loadImageBinInfo != null && loadImageBinInfo.status == 4096;
    }

    public boolean connectDevice(String str, boolean z, int i) {
        return connectDevice(new ConnectParams.Builder().address(str).hid(z).reconnectTimes(i).build());
    }

    public boolean connectDevice(String str, boolean z) {
        return connectDevice(new ConnectParams.Builder().address(str).hid(z).build());
    }

    public boolean checkImage(DfuConfig dfuConfig, OtaDeviceInfo otaDeviceInfo) throws LoadFileException {
        BinInfo loadImageBinInfo = FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().with(this.mContext).fileLocation(dfuConfig.getFileLocation()).setFilePath(dfuConfig.getFilePath()).setSectionSizeCheckEnabled(dfuConfig.isSectionSizeCheckEnabled()).setIcCheckEnabled(dfuConfig.isIcCheckEnabled()).setFileSuffix(dfuConfig.getFileSuffix()).versionCheckEnabled(dfuConfig.isVersionCheckEnabled(), dfuConfig.getVersionCheckMode()).setWorkMode(dfuConfig.getOtaWorkMode()).setOtaDeviceInfo(otaDeviceInfo).build());
        return loadImageBinInfo != null && loadImageBinInfo.status == 4096;
    }
}
