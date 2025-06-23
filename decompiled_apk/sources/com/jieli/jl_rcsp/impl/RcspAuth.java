package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspConstant;
import com.jieli.jl_rcsp.interfaces.listener.LibLoader;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class RcspAuth {
    private static final int AUTH_RETRY_COUNT = 2;
    private static final long DEFAULT_AUTH_TIMEOUT = 3000;
    private static long DELAY_AUTH_WAITING_TIME = 3000;
    public static final int ERR_AUTH_DATA_CHECK = 40980;
    public static final int ERR_AUTH_DATA_SEND = 40979;
    public static final int ERR_AUTH_DEVICE_TIMEOUT = 40977;
    public static final int ERR_AUTH_USER_STOP = 40978;
    public static final int ERR_NONE = 0;
    private static final int MSG_AUTH_DEVICE_TIMEOUT = 18;
    private static final int MSG_SEND_AUTH_DATA_TIMEOUT = 17;
    private static final String TAG = "RcspAuth";
    private static volatile boolean mIsLibLoaded = false;
    public static final LibLoader sLocalLibLoader = new LibLoader() { // from class: com.jieli.jl_rcsp.impl.ooOOo0oXI
        @Override // com.jieli.jl_rcsp.interfaces.listener.LibLoader
        public final void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private boolean isLibInit;
    private final Map<String, AuthTask> mAuthTaskMap = Collections.synchronizedMap(new HashMap());
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.impl.RcspAuth.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i = message.what;
            if (i != 17) {
                if (i == 18) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) message.obj;
                    AuthTask authTask = (AuthTask) RcspAuth.this.mAuthTaskMap.get(bluetoothDevice.getAddress());
                    if (authTask != null && !authTask.isAuthDevice()) {
                        RcspAuth.this.onAuthFailed(bluetoothDevice, 40977);
                    }
                }
            } else {
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) message.obj;
                AuthTask authTask2 = (AuthTask) RcspAuth.this.mAuthTaskMap.get(bluetoothDevice2.getAddress());
                if (authTask2 == null) {
                    return false;
                }
                if (authTask2.getRetryNum() >= 2) {
                    RcspAuth.this.onAuthFailed(bluetoothDevice2, 40977);
                } else {
                    authTask2.setRetryNum(authTask2.getRetryNum() + 1);
                    RcspAuth.this.mRcspAuthOp.sendAuthDataToDevice(authTask2.getDevice(), authTask2.getRandomData());
                    RcspAuth.this.mHandler.removeMessages(18);
                    RcspAuth.this.mHandler.sendMessageDelayed(RcspAuth.this.mHandler.obtainMessage(17, bluetoothDevice2), RcspAuth.DELAY_AUTH_WAITING_TIME);
                }
            }
            return true;
        }
    });
    private final OnRcspAuthListener mListener;
    private final IRcspAuthOp mRcspAuthOp;

    /* loaded from: classes8.dex */
    public static class AuthTask {

        /* renamed from: a, reason: collision with root package name */
        public BluetoothDevice f17893a;
        public boolean b;
        public boolean c;
        public byte[] d;
        public int e;

        public AuthTask() {
        }

        public BluetoothDevice getDevice() {
            return this.f17893a;
        }

        public byte[] getRandomData() {
            return this.d;
        }

        public int getRetryNum() {
            return this.e;
        }

        public boolean isAuthDevice() {
            return this.c;
        }

        public boolean isAuthProgressResult() {
            return this.b;
        }

        public void setAuthDevice(boolean z) {
            this.c = z;
        }

        public void setAuthProgressResult(boolean z) {
            this.b = z;
        }

        public AuthTask setDevice(BluetoothDevice bluetoothDevice) {
            this.f17893a = bluetoothDevice;
            return this;
        }

        public AuthTask setRandomData(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public void setRetryNum(int i) {
            this.e = i;
        }

        public String toString() {
            return "AuthTask{device=" + this.f17893a + ", isAuthProgressResult=" + this.b + ", isAuthDevice=" + this.c + ", randomData=" + CHexConver.byte2HexStr(this.d) + ", retryNum=" + this.e + '}';
        }
    }

    /* loaded from: classes8.dex */
    public interface IRcspAuthOp {
        boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface OnRcspAuthListener {
        void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str);

        void onAuthSuccess(BluetoothDevice bluetoothDevice);

        void onInitResult(boolean z);
    }

    public RcspAuth(IRcspAuthOp iRcspAuthOp, OnRcspAuthListener onRcspAuthListener) {
        if (iRcspAuthOp != null) {
            this.mRcspAuthOp = iRcspAuthOp;
            this.mListener = onRcspAuthListener;
            loadLibrariesOnce(null);
            boolean nativeInit = nativeInit();
            this.isLibInit = nativeInit;
            onInitResult(nativeInit);
            return;
        }
        throw new IllegalArgumentException("IRcspAuthOp can not be null.");
    }

    private String getErrorMsg(int i) {
        switch (i) {
            case 40977:
                return "Auth device timeout.";
            case 40978:
                return "User stop auth device.";
            case 40979:
                return "Failed to send data.";
            case 40980:
                return "Check auth data error.";
            default:
                return "";
        }
    }

    private byte[] getResetAuthFlagCmdData() {
        return CHexConver.hexStr2Bytes("FEDCBAC00600020001EF");
    }

    private boolean isValidAuthData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        if (bArr.length != 5 || bArr[0] != 2) {
            if (bArr.length != 17) {
                return false;
            }
            byte b = bArr[0];
            if (b != 0 && b != 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAuth$0(BluetoothDevice bluetoothDevice, AuthTask authTask) {
        if (this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, authTask.getRandomData())) {
            this.mHandler.removeMessages(17);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
            return;
        }
        onAuthFailed(bluetoothDevice, 40979, "Failed to send data.");
    }

    public static void loadLibrariesOnce(LibLoader libLoader) {
        synchronized (RcspAuth.class) {
            try {
                if (!mIsLibLoaded) {
                    if (libLoader == null) {
                        libLoader = sLocalLibLoader;
                    }
                    libLoader.loadLibrary(RcspConstant.JL_RCSP_LIB);
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthFailed(BluetoothDevice bluetoothDevice, int i) {
        onAuthFailed(bluetoothDevice, i, getErrorMsg(i));
    }

    private void onAuthSuccess(BluetoothDevice bluetoothDevice) {
        JL_Log.w(TAG, "onAuthSuccess", RcspUtil.formatString("device = %s, auth ok.", bluetoothDevice));
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onAuthSuccess(bluetoothDevice);
        }
    }

    private void onInitResult(boolean z) {
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onInitResult(z);
        }
    }

    public static boolean setAuthTimeout(long j) {
        if (j < 3000) {
            JL_Log.d(TAG, "setAuthTimeout", "The timeout is too short to be set successfully.  timeout : " + j);
            return false;
        }
        DELAY_AUTH_WAITING_TIME = j;
        return true;
    }

    @Deprecated
    public void addListener(OnRcspAuthListener onRcspAuthListener) {
    }

    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAuthTaskMap.clear();
        this.isLibInit = false;
        mIsLibLoaded = false;
    }

    public byte[] getAuthData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return getEncryptedAuthData(bArr);
    }

    public byte[] getAuthOkData() {
        return new byte[]{2, 112, 97, 115, 115};
    }

    public native byte[] getEncryptedAuthData(byte[] bArr);

    public native byte[] getRandomAuthData();

    public byte[] getRandomData() {
        return getRandomAuthData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r8.mRcspAuthOp.sendAuthDataToDevice(r9, getAuthOkData()) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
    
        r10 = 40979;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
    
        if (r8.mRcspAuthOp.sendAuthDataToDevice(r9, r10) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleAuthData(android.bluetooth.BluetoothDevice r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.impl.RcspAuth.handleAuthData(android.bluetooth.BluetoothDevice, byte[]):void");
    }

    public native boolean nativeInit();

    @Deprecated
    public void removeListener(OnRcspAuthListener onRcspAuthListener) {
    }

    public int setDeviceConnectionLinkKey(byte[] bArr) {
        return setLinkKey(bArr);
    }

    public native int setLinkKey(byte[] bArr);

    public boolean startAuth(final BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && this.isLibInit) {
            if (this.mAuthTaskMap.containsKey(bluetoothDevice.getAddress())) {
                AuthTask authTask = this.mAuthTaskMap.get(bluetoothDevice.getAddress());
                if (authTask != null && (authTask.isAuthDevice() || this.mHandler.hasMessages(18))) {
                    JL_Log.i(TAG, "startAuth", "The device has been certified or certification of device is in progress.");
                    return true;
                }
                this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
            }
            JL_Log.d(TAG, "startAuth", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice));
            final AuthTask randomData = new AuthTask().setDevice(bluetoothDevice).setRandomData(getRandomData());
            this.mAuthTaskMap.put(bluetoothDevice.getAddress(), randomData);
            boolean sendAuthDataToDevice = this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, getResetAuthFlagCmdData());
            if (sendAuthDataToDevice) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.impl.oOoXoXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        RcspAuth.this.lambda$startAuth$0(bluetoothDevice, randomData);
                    }
                }, 500L);
            }
            return sendAuthDataToDevice;
        }
        return false;
    }

    public void stopAuth(BluetoothDevice bluetoothDevice) {
        stopAuth(bluetoothDevice, true);
    }

    private void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str) {
        JL_Log.e(TAG, "onAuthFailed", RcspUtil.formatString("Device = %s, code = %d, message = %s.", bluetoothDevice, Integer.valueOf(i), str));
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onAuthFailed(bluetoothDevice, i, str);
        }
    }

    public void stopAuth(BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null || !this.isLibInit) {
            return;
        }
        AuthTask remove = this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        if (z) {
            if (remove != null) {
                onAuthFailed(bluetoothDevice, 40978);
            }
            this.mHandler.removeMessages(17);
            this.mHandler.removeMessages(18);
        }
    }
}
