package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

/* loaded from: classes10.dex */
public class ReceiveSppDataThread extends Thread {
    public static final int EXIT_REASON_IO_EXCEPTION = 2;
    public static final int EXIT_REASON_PARAM_ERROR = 1;
    public static final int EXIT_REASON_SUCCESS = 0;
    private static final String TAG = "ReceiveSppDataThread";
    private volatile boolean isRunning;
    private final int mBlockSize;
    private final BluetoothSocket mBluetoothSocket;
    private final BluetoothDevice mConnectedSppDev;
    private final OnRecvSppDataListener mOnRecvSppDataListener;

    /* loaded from: classes10.dex */
    public interface OnRecvSppDataListener {
        void onRecvSppData(long threadID, BluetoothDevice device, byte[] data);

        void onThreadStart(long threadID);

        void onThreadStop(long threadID, int reason, BluetoothDevice device);
    }

    public ReceiveSppDataThread(BluetoothDevice device, BluetoothSocket socket, OnRecvSppDataListener listener) {
        this(device, socket, 4096, listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r9 = this;
            super.run()
            java.lang.String r0 = com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.TAG
            java.lang.String r1 = "start."
            com.jieli.bluetooth_connect.util.JL_Log.i(r0, r0, r1)
            r0 = 1
            r9.isRunning = r0
            com.jieli.bluetooth_connect.tool.ReceiveSppDataThread$OnRecvSppDataListener r1 = r9.mOnRecvSppDataListener
            if (r1 == 0) goto L18
            long r2 = r9.getId()
            r1.onThreadStart(r2)
        L18:
            android.bluetooth.BluetoothDevice r1 = r9.mConnectedSppDev
            r2 = 0
            if (r1 == 0) goto La4
            int r0 = r9.mBlockSize
            byte[] r0 = new byte[r0]
            android.bluetooth.BluetoothSocket r1 = r9.mBluetoothSocket
            if (r1 == 0) goto L2e
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.io.IOException -> L2a
            goto L2f
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            r1 = 0
        L2f:
            java.lang.String r3 = com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "isRunning : "
            r4.append(r5)
            boolean r5 = r9.isRunning
            r4.append(r5)
            java.lang.String r5 = ", mBluetoothSocket : "
            r4.append(r5)
            android.bluetooth.BluetoothSocket r5 = r9.mBluetoothSocket
            r4.append(r5)
            java.lang.String r5 = ", inputStream : "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.jieli.bluetooth_connect.util.JL_Log.i(r3, r3, r4)
        L59:
            boolean r3 = r9.isRunning
            if (r3 == 0) goto La3
            if (r1 == 0) goto La3
            r3 = 2
            int r4 = r1.read(r0)     // Catch: java.lang.Exception -> L70
            if (r4 >= 0) goto L68
        L66:
            r0 = 2
            goto La4
        L68:
            if (r4 != 0) goto L72
            r4 = 30
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Exception -> L70
            goto L59
        L70:
            r0 = move-exception
            goto L85
        L72:
            byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L70
            java.lang.System.arraycopy(r0, r2, r5, r2, r4)     // Catch: java.lang.Exception -> L70
            com.jieli.bluetooth_connect.tool.ReceiveSppDataThread$OnRecvSppDataListener r4 = r9.mOnRecvSppDataListener     // Catch: java.lang.Exception -> L70
            if (r4 == 0) goto L59
            long r6 = r9.getId()     // Catch: java.lang.Exception -> L70
            android.bluetooth.BluetoothDevice r8 = r9.mConnectedSppDev     // Catch: java.lang.Exception -> L70
            r4.onRecvSppData(r6, r8, r5)     // Catch: java.lang.Exception -> L70
            goto L59
        L85:
            java.lang.String r1 = com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "have an exception : "
            r4.append(r5)
            java.lang.String r5 = r0.getMessage()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.jieli.bluetooth_connect.util.JL_Log.e(r1, r1, r4)
            r0.printStackTrace()
            goto L66
        La3:
            r0 = 0
        La4:
            r9.isRunning = r2
            com.jieli.bluetooth_connect.tool.ReceiveSppDataThread$OnRecvSppDataListener r1 = r9.mOnRecvSppDataListener
            if (r1 == 0) goto Lb3
            long r2 = r9.getId()
            android.bluetooth.BluetoothDevice r4 = r9.mConnectedSppDev
            r1.onThreadStop(r2, r0, r4)
        Lb3:
            java.lang.String r0 = com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.TAG
            java.lang.String r1 = "exit"
            com.jieli.bluetooth_connect.util.JL_Log.i(r0, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.run():void");
    }

    public void stopThread() {
        this.isRunning = false;
    }

    public ReceiveSppDataThread(BluetoothDevice device, BluetoothSocket socket, int blockSize, OnRecvSppDataListener listener) {
        super("ReceiveSppDataThread : " + device);
        this.mConnectedSppDev = device;
        this.mBluetoothSocket = socket;
        this.mBlockSize = blockSize;
        this.mOnRecvSppDataListener = listener;
    }
}
