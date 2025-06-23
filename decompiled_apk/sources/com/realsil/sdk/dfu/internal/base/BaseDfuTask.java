package com.realsil.sdk.dfu.internal.base;

import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.FileUtils;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.i.b;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.utils.AesJni;
import com.realsil.sdk.dfu.utils.DfuUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public abstract class BaseDfuTask extends Thread {
    public DfuConfig i;
    public boolean imageFileLoaded;
    public boolean initialized;
    public byte[] k;
    public AesJni l;
    public volatile boolean lastPacketTransferred;
    public String m;
    public boolean mAborted;
    public BinInfo mBinIno;
    public int mBytesSentBuffer;
    public Context mContext;
    public BaseBinInputStream mCurBinInputStream;
    public String mDeviceAddress;
    public volatile int mErrorState;
    public int mNextBinIndex;
    public BaseBinInputStream mNextBinInputStream;
    public String mOtaDeviceAddress;
    public OtaDeviceInfo mOtaDeviceInfo;
    public String mOtaDeviceName;
    public volatile boolean mReadRequestCompleted;
    public DfuThreadCallback mThreadCallback;
    public volatile boolean mWriteRequestCompleted;
    public volatile int mWriteRequestStatus;
    public volatile boolean mWriteRetransFlag;
    public boolean otaEnvironmentPrepared;
    public boolean otaModeEnabled;
    public DfuProgressInfo q;
    public b x;
    public boolean DBG = false;
    public boolean VDBG = false;
    public int h = 0;
    public volatile boolean isConnectedCallbackCome = false;
    public final Object mConnectionLock = new Object();
    public int mConnectionState = 0;
    public final Object mReadLock = new Object();
    public volatile byte[] mReadRxData = null;
    public final Object j = new Object();
    public volatile int mProcessState = 257;
    public List<BaseBinInputStream> pendingImageInputStreams = new ArrayList();
    public int n = -1;
    public int mOtaWorkMode = 0;
    public boolean o = false;
    public int MAX_PACKET_SIZE = 20;
    public final Object p = new Object();
    public int r = 0;
    public int mImageUpdateOffset = 0;
    public int mImageBuffercheckOffset = 0;
    public int s = 256;
    public int t = 16;
    public boolean u = false;
    public final Object v = new Object();
    public final Object w = new Object();

    public BaseDfuTask(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        this.mContext = context;
        this.i = dfuConfig;
        this.mThreadCallback = dfuThreadCallback;
    }

    public static byte[] convertAddress(String str) {
        byte[] bArr = new byte[6];
        if (str != null) {
            bArr[5] = (byte) ((Character.digit(str.charAt(15), 16) * 16) + Character.digit(str.charAt(16), 16));
            bArr[4] = (byte) ((Character.digit(str.charAt(12), 16) * 16) + Character.digit(str.charAt(13), 16));
            bArr[3] = (byte) ((Character.digit(str.charAt(9), 16) * 16) + Character.digit(str.charAt(10), 16));
            bArr[2] = (byte) ((Character.digit(str.charAt(6), 16) * 16) + Character.digit(str.charAt(7), 16));
            bArr[1] = (byte) ((Character.digit(str.charAt(3), 16) * 16) + Character.digit(str.charAt(4), 16));
            bArr[0] = (byte) ((Character.digit(str.charAt(0), 16) * 16) + Character.digit(str.charAt(1), 16));
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
        }
        return bArr;
    }

    public abstract void a(int i, boolean z);

    public void a(long j) {
        try {
            ZLogger.v("wait device auto reconnect for " + j);
            synchronized (this.w) {
                this.w.wait(j);
            }
        } catch (InterruptedException e) {
            ZLogger.w(e.toString());
        }
    }

    public boolean abort() {
        if (isIdle()) {
            ZLogger.d("already in idle state");
        } else {
            this.mAborted = true;
            notifyStateChanged(525, true);
            abortInner();
        }
        e();
        synchronized (this.mReadLock) {
            this.mReadLock.notifyAll();
        }
        synchronized (this.mConnectionLock) {
            this.mConnectionLock.notifyAll();
        }
        f();
        return true;
    }

    public void abortInner() {
    }

    public boolean activeImage(boolean z) {
        if (this.mProcessState == 523) {
            return true;
        }
        ZLogger.w(String.format("activeImage failed, state conflict: 0x%04X", Integer.valueOf(this.mProcessState)));
        return false;
    }

    public void alignmentSendBytes(int i, boolean z) {
        int read;
        int i2 = 0;
        if (i != 0) {
            try {
                int max = Math.max(i - 12, 0);
                byte[] bArr = new byte[getDfuProgressInfo().getImageSizeInBytes()];
                if (z) {
                    read = this.mCurBinInputStream.read(bArr, max);
                } else {
                    read = this.mCurBinInputStream.read(bArr, 0, max);
                }
                i2 = read;
            } catch (IOException e) {
                ZLogger.w(e.toString());
                return;
            }
        }
        getDfuProgressInfo().setBytesSent(i2);
    }

    public boolean b() {
        if (this.l == null) {
            this.l = new AesJni();
        }
        if (this.l.aesInit(3, this.k)) {
            return true;
        }
        if (this.VDBG) {
            ZLogger.w("encrpt initial error, encrypted key: " + Arrays.toString(this.k));
            return false;
        }
        ZLogger.w("encrpt initial error, encrypted key invalid!");
        return false;
    }

    public void blockSpeedControl() {
        b bVar = this.x;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void c() {
        this.x = new b(getDfuConfig().isFlowControlEnabled(), getDfuConfig().getFlowControlInterval());
    }

    public void closeInputStream(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            if (this.VDBG) {
                ZLogger.v("closeInputStream...");
            }
            inputStream.close();
        } catch (IOException e) {
            ZLogger.w(this.DBG, "closeInputStream fail: " + e.toString());
        }
    }

    public boolean d() {
        if ((this.mConnectionState & 512) == 512) {
            return true;
        }
        return false;
    }

    public void e() {
        synchronized (this.p) {
            this.p.notifyAll();
        }
    }

    public abstract void executeOtaProcedure();

    public void f() {
        try {
            synchronized (this.w) {
                this.w.notifyAll();
            }
        } catch (Exception e) {
            ZLogger.e(e.toString());
        }
    }

    public void g() {
        synchronized (this.j) {
            this.mWriteRequestCompleted = true;
            this.j.notifyAll();
        }
    }

    public DfuConfig getDfuConfig() {
        if (this.i == null) {
            this.i = new DfuConfig();
        }
        return this.i;
    }

    public DfuProgressInfo getDfuProgressInfo() {
        if (this.q == null) {
            this.q = new DfuProgressInfo();
        }
        return this.q;
    }

    public OtaDeviceInfo getOtaDeviceInfo() {
        if (this.mOtaDeviceInfo == null) {
            this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        }
        return this.mOtaDeviceInfo;
    }

    public int getProcessState() {
        return this.mProcessState;
    }

    public int h() throws DfuException {
        return 0;
    }

    public void i() {
        a(5000L);
    }

    public void initialize() {
        notifyStateChanged(513, true);
        this.initialized = false;
        this.mAborted = false;
        this.u = false;
        this.l = new AesJni();
        this.otaEnvironmentPrepared = false;
        this.imageFileLoaded = false;
        this.pendingImageInputStreams = new ArrayList();
        this.mBytesSentBuffer = 0;
        this.q = new DfuProgressInfo();
        this.mErrorState = 0;
        if (getDfuConfig().getLogLevel() != 0) {
            this.DBG = true;
        } else {
            this.DBG = RtkDfu.DEBUG_ENABLE;
        }
        this.VDBG = RtkDfu.VDBG;
        if (this.DBG) {
            ZLogger.d(getDfuConfig().toString());
        }
        this.h = getDfuConfig().getProtocolType();
        this.mDeviceAddress = getDfuConfig().getAddress();
        this.mOtaWorkMode = getDfuConfig().getOtaWorkMode();
        this.m = getDfuConfig().getFilePath();
        this.n = getDfuConfig().getFileIndicator();
        this.k = getDfuConfig().getSecretKey();
        this.o = getDfuConfig().isAutomaticActiveEnabled();
        this.MAX_PACKET_SIZE = getDfuConfig().getPrimaryMtuSize();
    }

    public int innerCheck() {
        if (!this.initialized) {
            ZLogger.w("DfuThread not initialized");
            return 4114;
        }
        if (TextUtils.isEmpty(this.m)) {
            ZLogger.w("the file path string is null");
            return 4098;
        }
        String suffix = FileUtils.getSuffix(this.m);
        if (suffix != null && suffix.equalsIgnoreCase(getDfuConfig().getFileSuffix())) {
            if (getDfuConfig().getFileLocation() == 1) {
                if (!DfuUtils.isAssetsFileExist(this.mContext, this.m)) {
                    ZLogger.w("the bin file not exist, path: " + this.m);
                    return 4100;
                }
                return 0;
            }
            if (!FileUtils.exists(this.m)) {
                ZLogger.w("the bin file not exist, path: " + this.m);
                return 4100;
            }
            return 0;
        }
        ZLogger.w("the file suffix is not right, suffix=" + suffix);
        return 4099;
    }

    public boolean isIdle() {
        if ((this.mProcessState & 256) == 256) {
            return true;
        }
        return false;
    }

    public void notifyConnectionLock() {
        try {
            synchronized (this.mConnectionLock) {
                try {
                    this.isConnectedCallbackCome = true;
                    if (this.VDBG) {
                        ZLogger.v(String.format("isConnectedCallbackCome=%b", Boolean.valueOf(this.isConnectedCallbackCome)));
                    }
                    this.mConnectionLock.notifyAll();
                } finally {
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void notifyProcessChanged() {
        this.lastPacketTransferred = getDfuProgressInfo().isFileSendOver();
        DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
        if (dfuThreadCallback != null) {
            dfuThreadCallback.onProgressChanged(getDfuProgressInfo());
        } else {
            ZLogger.v(this.VDBG, "no callback registered ");
        }
    }

    public void notifyReadLock() {
        synchronized (this.mReadLock) {
            this.mReadRequestCompleted = true;
            this.mReadLock.notifyAll();
        }
    }

    public void notifyStateChanged(int i) {
        notifyStateChanged(i, true);
    }

    public void onDestroy() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        setName("DFU");
        executeOtaProcedure();
        if (this.mProcessState != 523) {
            onDestroy();
        }
    }

    public void setConnectionState(int i) {
        ZLogger.d(String.format("Conn: 0x%04X >> 0x%04X(%s)", Integer.valueOf(this.mConnectionState), Integer.valueOf(i), DfuConstants.parseConnectionState(i)));
        this.mConnectionState = i;
    }

    public void sleepInner(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public void startSpeedControl() {
        if (this.x == null) {
            c();
        }
        this.x.b();
    }

    public void waitUntilDisconnected() {
        try {
        } catch (InterruptedException e) {
            ZLogger.w("waitUntilDisconnected interrupted: " + e.toString());
        }
        synchronized (this.mConnectionLock) {
            try {
                int i = this.mConnectionState;
                if (i != 0 && i != 1280) {
                    if (this.DBG) {
                        ZLogger.v("wait for disconnect, wait for " + getDfuConfig().getConnectionTimeout() + "ms");
                    }
                    this.mConnectionLock.wait(getDfuConfig().getConnectionTimeout());
                    int i2 = this.mConnectionState;
                    if (i2 != 0 && i2 != 1280) {
                        ZLogger.d("waitUntilDisconnected timeout");
                        return;
                    } else {
                        if (this.DBG) {
                            ZLogger.d("connection disconnected");
                            return;
                        }
                        return;
                    }
                }
                if (this.DBG) {
                    ZLogger.d("connection already disconnected");
                }
            } finally {
            }
        }
    }

    public void notifyStateChanged(int i, boolean z) {
        ZLogger.d(String.format("DFU: 0x%04X >> 0x%04X(%s)", Integer.valueOf(this.mProcessState), Integer.valueOf(i), DfuConstants.parseOtaState(i)));
        this.mProcessState = i;
        if (z) {
            DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
            if (dfuThreadCallback != null) {
                dfuThreadCallback.onStateChanged(this.mProcessState, null);
                return;
            } else {
                ZLogger.v(this.VDBG, "no callback registered");
                return;
            }
        }
        ZLogger.d("no need to notify state change");
    }

    public boolean a() {
        return !this.mAborted;
    }

    public void a(int i) {
        int max = Math.max(16, i);
        this.s = max;
        ZLogger.v(this.DBG, String.format(Locale.US, "mCurrentMaxBufferSize= %d", Integer.valueOf(max)));
    }

    public void b(int i) {
        a(i, false);
    }

    public void a(BaseBinInputStream baseBinInputStream) {
        if (getDfuProgressInfo().getImageSizeInBytes() <= 102400 || getDfuProgressInfo().getBytesSent() != 104000) {
            return;
        }
        try {
            getDfuProgressInfo().setBytesSent(143348);
            baseBinInputStream.skip(39348);
            ZLogger.d(this.DBG, "big image reach the special size, skip some packet");
        } catch (IOException e) {
            ZLogger.w(e.toString());
        }
    }

    public short a(byte[] bArr, int i) {
        short s = 0;
        for (int i2 = 0; i2 < i; i2 += 2) {
            s = (short) (s ^ ((short) ((bArr[i2 + 1] << 8) | (bArr[i2] & 255))));
        }
        return (short) (((s & 255) << 8) | ((65280 & s) >> 8));
    }
}
