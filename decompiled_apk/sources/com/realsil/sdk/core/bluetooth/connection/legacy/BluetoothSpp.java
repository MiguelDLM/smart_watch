package com.realsil.sdk.core.bluetooth.connection.legacy;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class BluetoothSpp extends BluetoothClient {
    public static final int ROLE_CLIENT = 1;
    public static final int ROLE_SERVER = 2;
    public static final UUID l = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public boolean b;
    public SppConnParameters c;
    public int d;
    public UUID e;
    public b f;
    public c g;
    public a h;
    public int i;
    public boolean initialized;
    public final Object j;
    public Boolean k;

    /* loaded from: classes11.dex */
    public class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final BluetoothSocket f19494a;
        public BufferedInputStream b;
        public BufferedOutputStream c;

        public c(BluetoothSocket bluetoothSocket) {
            BufferedInputStream bufferedInputStream;
            BufferedOutputStream bufferedOutputStream = null;
            this.b = null;
            this.c = null;
            ZLogger.d("create ConnectedThread");
            this.f19494a = bluetoothSocket;
            try {
                bufferedInputStream = new BufferedInputStream(bluetoothSocket.getInputStream());
            } catch (IOException e) {
                e = e;
                bufferedInputStream = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(bluetoothSocket.getOutputStream());
            } catch (IOException e2) {
                e = e2;
                ZLogger.w("temp sockets not created: " + e);
                this.b = bufferedInputStream;
                this.c = bufferedOutputStream;
            }
            this.b = bufferedInputStream;
            this.c = bufferedOutputStream;
        }

        public final void a() {
            BluetoothSocket bluetoothSocket = this.f19494a;
            if (bluetoothSocket == null) {
                return;
            }
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                ZLogger.w("close socket failed: " + e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr = new byte[1024];
            BluetoothSpp.this.updateConnectionState(2);
            synchronized (BluetoothSpp.this.j) {
                BluetoothSpp.this.k = Boolean.FALSE;
            }
            while (!Thread.currentThread().isInterrupted() && BluetoothSpp.this.f19486a == 2) {
                try {
                    int read = this.b.read(bArr);
                    if (read > 0) {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        if (BluetoothSpp.this.DBG) {
                            ZLogger.d(String.format(Locale.US, ">> (%d) %s", Integer.valueOf(read), DataConverter.bytes2Hex(bArr2)));
                        }
                        BluetoothSpp.this.dispatchDataReceived(bArr2);
                    }
                } catch (IOException e) {
                    StringBuilder a2 = com.realsil.sdk.core.a.a.a("connectionLost: ");
                    a2.append(e.toString());
                    ZLogger.w(a2.toString());
                    BluetoothSpp.c(BluetoothSpp.this);
                }
            }
            if (BluetoothSpp.this.f19486a == 3) {
                a();
                BluetoothSpp.c(BluetoothSpp.this);
            }
        }
    }

    public BluetoothSpp(BluetoothSppCallback bluetoothSppCallback) {
        this(1, l, bluetoothSppCallback);
    }

    public static void c(BluetoothSpp bluetoothSpp) {
        ZLogger.v(bluetoothSpp.DBG, "connectionLost");
        bluetoothSpp.updateConnectionState(0);
        bluetoothSpp.mDevice = null;
        synchronized (bluetoothSpp.j) {
            bluetoothSpp.k = Boolean.FALSE;
        }
        bluetoothSpp.start();
    }

    public final void a() {
        ZLogger.v(this.DBG, "cancelPreviousConnection");
        b bVar = this.f;
        if (bVar != null) {
            bVar.a();
            this.f.interrupt();
            this.f = null;
        }
        c cVar = this.g;
        if (cVar != null) {
            cVar.a();
            this.g.interrupt();
            this.g = null;
        }
    }

    public final void b() {
        ZLogger.v(this.DBG, "initialize...");
        this.DBG = RtkCore.DEBUG;
        this.VDBG = RtkCore.VDBG;
        BluetoothAdapter a2 = com.realsil.sdk.core.b.a.a(this.mContext);
        this.mBluetoothAdapter = a2;
        this.f19486a = 0;
        if (a2 == null) {
            ZLogger.d("bluetoothAdapter not initialized ");
            this.initialized = false;
        } else if (!a2.isEnabled()) {
            ZLogger.d("bluetooth is disabled");
            this.initialized = false;
        } else {
            this.initialized = true;
        }
    }

    public synchronized boolean connect(SppConnParameters sppConnParameters) {
        if (sppConnParameters == null) {
            ZLogger.v("connParameters can not be null or empty");
            return false;
        }
        if (sppConnParameters.getBluetoothDevice() == null) {
            ZLogger.v("device can not be null or empty");
            return false;
        }
        BluetoothDevice bluetoothDevice = this.mDevice;
        if (bluetoothDevice != null) {
            if (bluetoothDevice.equals(sppConnParameters.getBluetoothDevice())) {
                int i = this.f19486a;
                if (i == 2) {
                    ZLogger.v(this.DBG, "device already connected");
                    updateConnectionState(2);
                    return true;
                }
                if (i == 1) {
                    ZLogger.v(this.DBG, "device is already at connecting state");
                    updateConnectionState(1);
                    return true;
                }
            } else {
                int i2 = this.f19486a;
                if (i2 == 2) {
                    ZLogger.v(this.DBG, "other device already connected");
                    a();
                    return false;
                }
                if (i2 == 1) {
                    ZLogger.v(this.DBG, "other device is at connecting state");
                    a();
                    return false;
                }
            }
        }
        this.b = true;
        return a(sppConnParameters);
    }

    public synchronized void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        try {
            ZLogger.d(this.DBG, "spp connected");
            this.mDevice = bluetoothDevice;
            a();
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
                this.h = null;
            }
            c cVar = new c(bluetoothSocket);
            this.g = cVar;
            cVar.start();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClient
    public synchronized void destroy() {
        super.destroy();
        stop();
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClient
    public boolean isConnected() {
        if (this.mDevice == null || this.f19486a != 2) {
            return false;
        }
        return true;
    }

    public synchronized void start(boolean z) {
        try {
            ZLogger.v(this.DBG, "start secure: " + z);
            b bVar = this.f;
            if (bVar != null) {
                bVar.a();
                this.f.interrupt();
                this.f = null;
            }
            c cVar = this.g;
            if (cVar != null) {
                cVar.a();
                this.g.interrupt();
                this.g = null;
            }
            if ((this.d & 2) == 2 && this.h == null) {
                a aVar = new a(z);
                this.h = aVar;
                aVar.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stop() {
        try {
            ZLogger.v(this.VDBG, "stop");
            if (this.f19486a == 2) {
                updateConnectionState(3);
            }
            this.mDevice = null;
            b bVar = this.f;
            if (bVar != null) {
                bVar.a();
                this.f.interrupt();
                this.f = null;
            }
            c cVar = this.g;
            if (cVar != null) {
                cVar.a();
                this.g.interrupt();
                this.g = null;
            }
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
                this.h.interrupt();
                this.h = null;
            }
            synchronized (this.j) {
                this.k = Boolean.FALSE;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean write(byte[] bArr) {
        return write(bArr, true);
    }

    public BluetoothSpp(UUID uuid, BluetoothSppCallback bluetoothSppCallback) {
        this(1, uuid, bluetoothSppCallback);
    }

    public boolean write(byte[] bArr, boolean z) {
        synchronized (this) {
            try {
                if (this.f19486a != 2) {
                    ZLogger.d(this.DBG, "not connected");
                    return false;
                }
                c cVar = this.g;
                if (cVar == null) {
                    ZLogger.d("ConnectedThread not created");
                    return false;
                }
                if (cVar.c != null) {
                    try {
                        if (BluetoothSpp.this.DBG) {
                            ZLogger.d(String.format(Locale.US, "<< (%d) %s", Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
                        }
                        cVar.c.write(bArr);
                        if (!z) {
                            return true;
                        }
                        cVar.c.flush();
                        return true;
                    } catch (IOException e) {
                        ZLogger.w("Exception during write： " + e);
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public BluetoothSpp(int i, UUID uuid, BluetoothSppCallback bluetoothSppCallback) {
        this.b = false;
        this.i = -1;
        this.j = new Object();
        this.k = Boolean.FALSE;
        this.d = i;
        this.e = uuid;
        this.mCallback = bluetoothSppCallback;
        b();
    }

    public final boolean a(SppConnParameters sppConnParameters) {
        synchronized (this.j) {
            try {
                if (this.k.booleanValue()) {
                    ZLogger.w("device is busy");
                    return false;
                }
                this.k = Boolean.TRUE;
                if (!this.initialized) {
                    b();
                }
                boolean z = this.DBG;
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("createNewConnection:");
                a2.append(sppConnParameters.toString());
                ZLogger.v(z, a2.toString());
                this.c = sppConnParameters;
                this.mDevice = sppConnParameters.getBluetoothDevice();
                this.e = sppConnParameters.getUuid();
                if (sppConnParameters.getBluetoothSocket() != null) {
                    connected(sppConnParameters.getBluetoothSocket(), sppConnParameters.getBluetoothDevice());
                    return true;
                }
                a();
                b bVar = new b(this.mDevice);
                this.f = bVar;
                bVar.start();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final BluetoothServerSocket f19492a;

        public a(boolean z) {
            this.f19492a = a(z);
            BluetoothSpp.this.updateConnectionState(4);
        }

        public final BluetoothServerSocket a(boolean z) {
            BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord;
            try {
                if (z) {
                    BluetoothSpp bluetoothSpp = BluetoothSpp.this;
                    UUID uuid = BluetoothSpp.l;
                    listenUsingInsecureRfcommWithServiceRecord = bluetoothSpp.mBluetoothAdapter.listenUsingRfcommWithServiceRecord("RtkSppSecure", bluetoothSpp.e);
                } else {
                    BluetoothSpp bluetoothSpp2 = BluetoothSpp.this;
                    UUID uuid2 = BluetoothSpp.l;
                    listenUsingInsecureRfcommWithServiceRecord = bluetoothSpp2.mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord("RtkSppInsecure", bluetoothSpp2.e);
                }
                return listenUsingInsecureRfcommWithServiceRecord;
            } catch (IOException e) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("createServerSocket failed: ");
                a2.append(e.toString());
                ZLogger.d(a2.toString());
                return null;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:10|11|(6:13|(1:(2:16|(2:18|19)))|23|(1:25)|26|19)|27|28|19) */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
        
            com.realsil.sdk.core.logger.ZLogger.w("Could not close unwanted socket： " + r0);
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r6 = this;
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r0 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this
                java.util.UUID r1 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.l
                boolean r0 = r0.DBG
                java.lang.String r1 = "BEGIN mAcceptThread"
                com.realsil.sdk.core.logger.ZLogger.v(r0, r1)
                java.lang.String r0 = "AcceptThread:BluetoothSpp"
                r6.setName(r0)
            L10:
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r0 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this
                int r0 = r0.f19486a
                r1 = 2
                if (r0 == r1) goto L82
                android.bluetooth.BluetoothServerSocket r0 = r6.f19492a     // Catch: java.io.IOException -> L67
                android.bluetooth.BluetoothSocket r0 = r0.accept()     // Catch: java.io.IOException -> L67
                if (r0 == 0) goto L10
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r2 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this
                monitor-enter(r2)
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r3 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this     // Catch: java.lang.Throwable -> L3e
                int r4 = r3.f19486a     // Catch: java.lang.Throwable -> L3e
                if (r4 == 0) goto L4a
                r5 = 1
                if (r4 == r5) goto L31
                if (r4 == r1) goto L4a
                r1 = 4
                if (r4 == r1) goto L31
                goto L63
            L31:
                int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3e
                r4 = 23
                if (r1 < r4) goto L40
                int r1 = com.realsil.sdk.core.bluetooth.connection.legacy.oIX0oI.oIX0oI(r0)     // Catch: java.lang.Throwable -> L3e
                r3.i = r1     // Catch: java.lang.Throwable -> L3e
                goto L40
            L3e:
                r0 = move-exception
                goto L65
            L40:
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r1 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this     // Catch: java.lang.Throwable -> L3e
                android.bluetooth.BluetoothDevice r3 = r0.getRemoteDevice()     // Catch: java.lang.Throwable -> L3e
                r1.connected(r0, r3)     // Catch: java.lang.Throwable -> L3e
                goto L63
            L4a:
                r0.close()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L4e
                goto L63
            L4e:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
                r1.<init>()     // Catch: java.lang.Throwable -> L3e
                java.lang.String r3 = "Could not close unwanted socket： "
                r1.append(r3)     // Catch: java.lang.Throwable -> L3e
                r1.append(r0)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L3e
                com.realsil.sdk.core.logger.ZLogger.w(r0)     // Catch: java.lang.Throwable -> L3e
            L63:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L3e
                goto L10
            L65:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L3e
                throw r0
            L67:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "accept() failed"
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                com.realsil.sdk.core.logger.ZLogger.w(r0)
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r0 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this
                r1 = 0
                r0.updateConnectionState(r1)
            L82:
                com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp r0 = com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.this
                boolean r0 = r0.DBG
                java.lang.String r1 = "END AcceptThread"
                com.realsil.sdk.core.logger.ZLogger.d(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp.a.run():void");
        }

        public final void a() {
            try {
                if (this.f19492a != null) {
                    BluetoothSpp bluetoothSpp = BluetoothSpp.this;
                    UUID uuid = BluetoothSpp.l;
                    ZLogger.v(bluetoothSpp.DBG, "cancel AcceptThread");
                    this.f19492a.close();
                }
            } catch (IOException e) {
                ZLogger.w("close() of server failed： " + e);
            }
        }
    }

    public static boolean b(BluetoothSpp bluetoothSpp) {
        return bluetoothSpp.f19486a == 1;
    }

    public synchronized void start() {
        start(true);
    }

    /* loaded from: classes11.dex */
    public class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public BluetoothSocket f19493a;
        public final BluetoothDevice b;

        public b(BluetoothDevice bluetoothDevice) {
            this.b = bluetoothDevice;
            this.f19493a = a(bluetoothDevice, true);
        }

        public final BluetoothSocket a(BluetoothDevice bluetoothDevice, boolean z) {
            BluetoothSocket bluetoothSocket;
            int connectionType;
            BluetoothSpp bluetoothSpp = BluetoothSpp.this;
            UUID uuid = BluetoothSpp.l;
            boolean z2 = bluetoothSpp.VDBG;
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("mSecureUuid=");
            a2.append(BluetoothSpp.this.e);
            ZLogger.v(z2, a2.toString());
            try {
                if (z) {
                    bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(BluetoothSpp.this.e);
                } else {
                    bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothSpp.this.e);
                }
            } catch (IOException e) {
                StringBuilder a3 = com.realsil.sdk.core.a.a.a("createBluetoothSocket failed: ");
                a3.append(e.toString());
                ZLogger.w(a3.toString());
                bluetoothSocket = null;
            }
            if (bluetoothSocket != null && Build.VERSION.SDK_INT >= 23) {
                BluetoothSpp bluetoothSpp2 = BluetoothSpp.this;
                connectionType = bluetoothSocket.getConnectionType();
                bluetoothSpp2.i = connectionType;
            }
            return bluetoothSocket;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BluetoothSpp bluetoothSpp;
            setName("ConnectThread:BluetoothSpp");
            BluetoothSpp bluetoothSpp2 = BluetoothSpp.this;
            UUID uuid = BluetoothSpp.l;
            if (bluetoothSpp2.VDBG) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("SocketConnectionType: ");
                a2.append(BluetoothSpp.this.i);
                ZLogger.v(a2.toString());
            }
            BluetoothAdapter bluetoothAdapter = BluetoothSpp.this.mBluetoothAdapter;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.cancelDiscovery();
            }
            BluetoothSocket bluetoothSocket = this.f19493a;
            if (bluetoothSocket == null) {
                ZLogger.w("create BluetoothSocket fail");
                BluetoothSpp.this.updateConnectionState(0);
                synchronized (BluetoothSpp.this.j) {
                    BluetoothSpp.this.k = Boolean.FALSE;
                }
                return;
            }
            if (bluetoothSocket.isConnected()) {
                ZLogger.d(BluetoothSpp.this.DBG, "socket already connected");
            } else {
                if (BluetoothSpp.b(BluetoothSpp.this)) {
                    ZLogger.i("is already in connecting, ignore connect req, and wait connect result");
                    return;
                }
                BluetoothSpp.this.updateConnectionState(1);
                ZLogger.v(BluetoothSpp.this.VDBG, "connect socket ...");
                try {
                    this.f19493a.connect();
                } catch (Exception e) {
                    StringBuilder a3 = com.realsil.sdk.core.a.a.a("connect socket failed, ");
                    a3.append(e.toString());
                    ZLogger.w(a3.toString());
                    try {
                        this.f19493a.close();
                    } catch (IOException e2) {
                        ZLogger.w("unable to close socket during connection failure: " + e2);
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e3) {
                        ZLogger.v(BluetoothSpp.this.VDBG, e3.toString());
                    }
                    if ("Connect refused".equals(e.getMessage())) {
                        if (this.b.getBondState() == 12) {
                            this.f19493a = a(this.b, false);
                        }
                        BluetoothSocket bluetoothSocket2 = this.f19493a;
                        if (bluetoothSocket2 == null) {
                            ZLogger.d("create Insecure BluetoothSocket fail");
                            BluetoothSpp.this.updateConnectionState(0);
                            synchronized (BluetoothSpp.this.j) {
                                BluetoothSpp.this.k = Boolean.FALSE;
                                return;
                            }
                        }
                        if (bluetoothSocket2.isConnected()) {
                            ZLogger.d("socket already connected");
                            return;
                        }
                        BluetoothSpp.this.updateConnectionState(1);
                        BluetoothSpp bluetoothSpp3 = BluetoothSpp.this;
                        UUID uuid2 = BluetoothSpp.l;
                        ZLogger.v(bluetoothSpp3.VDBG, "refused, connect socket ...");
                        try {
                            this.f19493a.connect();
                            return;
                        } catch (Exception e4) {
                            StringBuilder a4 = com.realsil.sdk.core.a.a.a("connect socket failed, ");
                            a4.append(e4.toString());
                            ZLogger.d(a4.toString());
                            try {
                                this.f19493a.close();
                            } catch (IOException e5) {
                                ZLogger.w("unable to close socket during connection failure: " + e5);
                            }
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e6) {
                                ZLogger.v(BluetoothSpp.this.VDBG, e6.toString());
                            }
                            BluetoothSpp.a(BluetoothSpp.this);
                            return;
                        }
                    }
                    BluetoothSpp.a(BluetoothSpp.this);
                    return;
                }
            }
            synchronized (BluetoothSpp.this) {
                bluetoothSpp = BluetoothSpp.this;
                bluetoothSpp.f = null;
            }
            bluetoothSpp.connected(this.f19493a, this.b);
        }

        public final void a() {
            try {
                BluetoothSocket bluetoothSocket = this.f19493a;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e) {
                ZLogger.w("close socket failed: " + e);
            }
        }
    }

    public static void a(BluetoothSpp bluetoothSpp) {
        Boolean bool;
        if (bluetoothSpp.b) {
            bluetoothSpp.b = false;
            BluetoothDevice bluetoothDevice = bluetoothSpp.mDevice;
            if (bluetoothDevice == null) {
                ZLogger.v(bluetoothSpp.VDBG, "mDevice == null");
            } else {
                int i = bluetoothSpp.f19486a;
                if (i != 1) {
                    ZLogger.v(bluetoothSpp.VDBG, String.format("mConnState=0x%04X", Integer.valueOf(i)));
                } else {
                    int bondState = bluetoothDevice.getBondState();
                    ZLogger.v(bluetoothSpp.VDBG, String.format("bondState=0x%02X", Integer.valueOf(bondState)));
                    if (bondState == 12) {
                        int connectionState = BluetoothProfileManager.getInstance().getConnectionState(1, bluetoothSpp.mDevice);
                        ZLogger.v(bluetoothSpp.VDBG, String.format("hfpState=0x%02X", Integer.valueOf(connectionState)));
                        if (connectionState == 2) {
                            bluetoothSpp.b = false;
                            synchronized (bluetoothSpp.j) {
                                bool = Boolean.FALSE;
                                bluetoothSpp.k = bool;
                            }
                            bluetoothSpp.f19486a = 0;
                            ZLogger.v(bluetoothSpp.VDBG, "processAbnormalDisconnection ..");
                            if (bluetoothSpp.a(bluetoothSpp.c)) {
                                return;
                            }
                            ZLogger.v(bluetoothSpp.DBG, "processAbnormalDisconnection failed");
                            bluetoothSpp.updateConnectionState(0);
                            bluetoothSpp.mDevice = null;
                            synchronized (bluetoothSpp.j) {
                                bluetoothSpp.k = bool;
                            }
                            bluetoothSpp.start();
                            return;
                        }
                    }
                }
            }
        }
        ZLogger.v(bluetoothSpp.DBG, "connectionFailed");
        bluetoothSpp.updateConnectionState(0);
        bluetoothSpp.mDevice = null;
        synchronized (bluetoothSpp.j) {
            bluetoothSpp.k = Boolean.FALSE;
        }
        bluetoothSpp.start();
    }
}
