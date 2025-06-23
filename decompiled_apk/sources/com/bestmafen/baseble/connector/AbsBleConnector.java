package com.bestmafen.baseble.connector;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XOxIOxOx.oO;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.bestmafen.baseble.connector.AbsBleConnector$mBluetoothGattCallback$2;
import com.bestmafen.baseble.connector.AbsBleConnector$mReceiver$2;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.bestmafen.baseble.scanner.BleDevice;
import java.lang.reflect.Method;
import java.util.UUID;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import xII.Oxx0IOOO;
import xII.oxoX;

/* loaded from: classes8.dex */
public abstract class AbsBleConnector {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final long TIMEOUT = 8000;
    private boolean disableStreamLog;
    private boolean isConnecting;
    private boolean isRefreshDeviceCache;

    @oOoXoXO
    private com.bestmafen.baseble.connector.I0Io mBleGattCallback;

    @oOoXoXO
    private BluetoothGatt mBluetoothGatt;
    protected Context mContext;
    private boolean mNotified;
    private int mRetry;

    @oOoXoXO
    private XOxIOxOx.II0xO0 mScanner;

    @oOoXoXO
    private String mTargetAddress;
    private int mTransport;

    @OOXIXo
    private final String LOG_HEADER = "AbsBleConnector";
    private int mMtu = xII.I0Io.oIX0oI();

    @OOXIXo
    private final X0IIOO mBluetoothGattCallback$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbsBleConnector$mBluetoothGattCallback$2.oIX0oI>() { // from class: com.bestmafen.baseble.connector.AbsBleConnector$mBluetoothGattCallback$2

        /* loaded from: classes8.dex */
        public static final class oIX0oI extends BluetoothGattCallback {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ AbsBleConnector f10348oIX0oI;

            public oIX0oI(AbsBleConnector absBleConnector) {
                this.f10348oIX0oI = absBleConnector;
            }

            public static final void II0xO0(AbsBleConnector this$0) {
                IIX0o.x0xO0oo(this$0, "this$0");
                this$0.mNotified = true;
                this$0.getMBleMessenger().dequeueMessage();
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(@OOXIXo BluetoothGatt gatt, @OOXIXo BluetoothGattCharacteristic characteristic) {
                I0Io mBleGattCallback;
                IIX0o.x0xO0oo(gatt, "gatt");
                IIX0o.x0xO0oo(characteristic, "characteristic");
                OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " onCharacteristicChanged -> " + characteristic.getUuid() + ", " + ByteArrayExtKt.getMHexString(characteristic.getValue()));
                x0o.oIX0oI mBleParser = this.f10348oIX0oI.getMBleParser();
                byte[] value = characteristic.getValue();
                IIX0o.oO(value, "getValue(...)");
                byte[] onReceive = mBleParser.onReceive(value);
                if (onReceive != null && (mBleGattCallback = this.f10348oIX0oI.getMBleGattCallback()) != null) {
                    mBleGattCallback.onCharacteristicChanged(onReceive);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(@OOXIXo BluetoothGatt gatt, @OOXIXo BluetoothGattCharacteristic characteristic, int i) {
                IIX0o.x0xO0oo(gatt, "gatt");
                IIX0o.x0xO0oo(characteristic, "characteristic");
                byte[] value = characteristic.getValue();
                String stringValue = characteristic.getStringValue(0);
                OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " onCharacteristicRead -> " + characteristic.getUuid() + ", " + ByteArrayExtKt.getMHexString(value) + ", " + stringValue);
                this.f10348oIX0oI.getMBleMessenger().dequeueMessage();
                I0Io mBleGattCallback = this.f10348oIX0oI.getMBleGattCallback();
                if (mBleGattCallback != null) {
                    String valueOf = String.valueOf(characteristic.getUuid());
                    IIX0o.ooOOo0oXI(value);
                    IIX0o.ooOOo0oXI(stringValue);
                    mBleGattCallback.onCharacteristicRead(valueOf, value, stringValue);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(@OOXIXo BluetoothGatt gatt, @OOXIXo BluetoothGattCharacteristic characteristic, int i) {
                IIX0o.x0xO0oo(gatt, "gatt");
                IIX0o.x0xO0oo(characteristic, "characteristic");
                if (!this.f10348oIX0oI.getDisableStreamLog()) {
                    OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " onCharacteristicWrite -> " + AbsBleConnector.Companion.I0Io(i) + ", " + characteristic.getUuid() + ", " + ByteArrayExtKt.getMHexString(characteristic.getValue()));
                }
                this.f10348oIX0oI.getMBleMessenger().dequeueWritePacket();
                I0Io mBleGattCallback = this.f10348oIX0oI.getMBleGattCallback();
                if (mBleGattCallback != null) {
                    String valueOf = String.valueOf(characteristic.getUuid());
                    byte[] value = characteristic.getValue();
                    IIX0o.oO(value, "getValue(...)");
                    mBleGattCallback.onCharacteristicWrite(valueOf, value);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(@OOXIXo BluetoothGatt gatt, int i, int i2) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                I0Io mBleGattCallback;
                IIX0o.x0xO0oo(gatt, "gatt");
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f10348oIX0oI.getLOG_HEADER());
                sb.append(" onConnectionStateChange -> ");
                sb.append(z3);
                sb.append(", status=");
                AbsBleConnector.oIX0oI oix0oi2 = AbsBleConnector.Companion;
                sb.append(oix0oi2.I0Io(i));
                sb.append(", newState=");
                sb.append(oix0oi2.II0xO0(i2));
                oix0oi.oxoX(sb.toString());
                this.f10348oIX0oI.getMBleMessenger().reset();
                this.f10348oIX0oI.getMBleParser().reset();
                if (z3) {
                    gatt.discoverServices();
                    this.f10348oIX0oI.connect(false);
                    if (this.f10348oIX0oI.getMBluetoothGatt() == null) {
                        this.f10348oIX0oI.setMBluetoothGatt(gatt);
                    }
                    I0Io mBleGattCallback2 = this.f10348oIX0oI.getMBleGattCallback();
                    if (mBleGattCallback2 != null) {
                        mBleGattCallback2.onConnectionStateChange(true);
                        return;
                    }
                    return;
                }
                if (this.f10348oIX0oI.isAutoReconnect()) {
                    z4 = this.f10348oIX0oI.mNotified;
                    if (z4 && (mBleGattCallback = this.f10348oIX0oI.getMBleGattCallback()) != null) {
                        mBleGattCallback.onConnectionStateChange(false);
                    }
                    this.f10348oIX0oI.connect(true);
                    return;
                }
                I0Io mBleGattCallback3 = this.f10348oIX0oI.getMBleGattCallback();
                if (mBleGattCallback3 != null) {
                    mBleGattCallback3.onConnectionStateChange(false);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(@OOXIXo BluetoothGatt gatt, @OOXIXo BluetoothGattDescriptor descriptor, int i) {
                IIX0o.x0xO0oo(gatt, "gatt");
                IIX0o.x0xO0oo(descriptor, "descriptor");
                OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " -> onDescriptorWrite");
                Handler mHandler = this.f10348oIX0oI.getMHandler();
                final AbsBleConnector absBleConnector = this.f10348oIX0oI;
                mHandler.postDelayed(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE 
                      (r3v4 'mHandler' android.os.Handler)
                      (wrap:java.lang.Runnable:0x0030: CONSTRUCTOR (r4v3 'absBleConnector' com.bestmafen.baseble.connector.AbsBleConnector A[DONT_INLINE]) A[MD:(com.bestmafen.baseble.connector.AbsBleConnector):void (m), WRAPPED] (LINE:49) call: com.bestmafen.baseble.connector.II0xO0.<init>(com.bestmafen.baseble.connector.AbsBleConnector):void type: CONSTRUCTOR)
                      (1000 long)
                     VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:54) in method: com.bestmafen.baseble.connector.AbsBleConnector$mBluetoothGattCallback$2.oIX0oI.onDescriptorWrite(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattDescriptor, int):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bestmafen.baseble.connector.II0xO0, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r5 = "gatt"
                    kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                    java.lang.String r3 = "descriptor"
                    kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
                    OI0.oIX0oI r3 = OI0.oIX0oI.f1507oIX0oI
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    com.bestmafen.baseble.connector.AbsBleConnector r5 = r2.f10348oIX0oI
                    java.lang.String r5 = r5.getLOG_HEADER()
                    r4.append(r5)
                    java.lang.String r5 = " -> onDescriptorWrite"
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    r3.oxoX(r4)
                    com.bestmafen.baseble.connector.AbsBleConnector r3 = r2.f10348oIX0oI
                    android.os.Handler r3 = r3.getMHandler()
                    com.bestmafen.baseble.connector.AbsBleConnector r4 = r2.f10348oIX0oI
                    com.bestmafen.baseble.connector.II0xO0 r5 = new com.bestmafen.baseble.connector.II0xO0
                    r5.<init>(r4)
                    r0 = 1000(0x3e8, double:4.94E-321)
                    r3.postDelayed(r5, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bestmafen.baseble.connector.AbsBleConnector$mBluetoothGattCallback$2.oIX0oI.onDescriptorWrite(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattDescriptor, int):void");
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onMtuChanged(@OOXIXo BluetoothGatt gatt, int i, int i2) {
                boolean z;
                IIX0o.x0xO0oo(gatt, "gatt");
                OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " onMtuChanged -> mtu=" + i);
                z = this.f10348oIX0oI.mNotified;
                if (!z) {
                    return;
                }
                this.f10348oIX0oI.getMBleMessenger().setMPacketSize(i - 3);
                this.f10348oIX0oI.getMBleMessenger().dequeueMessage();
                I0Io mBleGattCallback = this.f10348oIX0oI.getMBleGattCallback();
                if (mBleGattCallback != null) {
                    mBleGattCallback.onMtuChanged();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(@OOXIXo BluetoothGatt gatt, int i) {
                IIX0o.x0xO0oo(gatt, "gatt");
                OI0.oIX0oI.f1507oIX0oI.oxoX(this.f10348oIX0oI.getLOG_HEADER() + " -> onServicesDiscovered");
                this.f10348oIX0oI.getMBleMessenger().enqueueMessage(new oxoX(this.f10348oIX0oI.getMService(), this.f10348oIX0oI.getMNotify(), false, 4, null));
                this.f10348oIX0oI.getMBleMessenger().enqueueMessage(new Oxx0IOOO(this.f10348oIX0oI.getMMtu()));
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final oIX0oI invoke() {
            return new oIX0oI(AbsBleConnector.this);
        }
    });

    @OOXIXo
    private final X0IIOO mReceiver$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbsBleConnector$mReceiver$2.AnonymousClass1>() { // from class: com.bestmafen.baseble.connector.AbsBleConnector$mReceiver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.bestmafen.baseble.connector.AbsBleConnector$mReceiver$2$1] */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final AnonymousClass1 invoke() {
            final AbsBleConnector absBleConnector = AbsBleConnector.this;
            return new BroadcastReceiver() { // from class: com.bestmafen.baseble.connector.AbsBleConnector$mReceiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@OOXIXo Context context, @OOXIXo Intent intent) {
                    boolean z;
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(intent, "intent");
                    if (TextUtils.equals(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                        OI0.oIX0oI.f1507oIX0oI.oxoX(AbsBleConnector.this.getLOG_HEADER() + " onReceive BluetoothAdapter.ACTION_STATE_CHANGED -> state=" + AbsBleConnector.Companion.oIX0oI(intExtra));
                        if (intExtra != 10) {
                            if (intExtra == 12 && AbsBleConnector.this.isAutoReconnect()) {
                                AbsBleConnector.this.connect(true);
                                return;
                            }
                            return;
                        }
                        AbsBleConnector.this.getMBleMessenger().reset();
                        AbsBleConnector.this.getMBleParser().reset();
                        z = AbsBleConnector.this.mNotified;
                        if (z) {
                            AbsBleConnector.this.mNotified = false;
                            I0Io mBleGattCallback = AbsBleConnector.this.getMBleGattCallback();
                            if (mBleGattCallback != null) {
                                mBleGattCallback.onConnectionStateChange(false);
                            }
                        }
                        AbsBleConnector.this.setConnecting(false);
                    }
                }
            };
        }
    });
    private final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    @OOXIXo
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @OOXIXo
    private final XOxIOxOx.I0Io mScanFilter = new XOxIOxOx.I0Io("");
    private boolean isAutoReconnect = true;
    private boolean mConnectDirectly = true;
    private int mReconnectBasePeriod = 5;
    private long mTimeout = TIMEOUT;
    private final int mReconnectMaxPeriod = 40;
    private final int mScanMaxDuration = 12;

    @OOXIXo
    private final I0Io mReconnection = new I0Io();

    /* loaded from: classes8.dex */
    public static final class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsBleConnector.this.closeConnection(false);
            if (!AbsBleConnector.this.XO()) {
                AbsBleConnector.this.setConnecting(false);
                return;
            }
            AbsBleConnector.this.mRetry++;
            if (AbsBleConnector.this.mRetry < 1) {
                AbsBleConnector.this.mRetry = 1;
            }
            int mReconnectBasePeriod = AbsBleConnector.this.mRetry * AbsBleConnector.this.getMReconnectBasePeriod();
            if (mReconnectBasePeriod > AbsBleConnector.this.getMReconnectMaxPeriod()) {
                AbsBleConnector.this.mRetry = 1;
                mReconnectBasePeriod = AbsBleConnector.this.mRetry * AbsBleConnector.this.getMReconnectBasePeriod();
            }
            if (!AbsBleConnector.this.getMConnectDirectly()) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(AbsBleConnector.this.getLOG_HEADER() + " connect scan " + mReconnectBasePeriod);
                XOxIOxOx.II0xO0 iI0xO0 = AbsBleConnector.this.mScanner;
                if (iI0xO0 != null) {
                    AbsBleConnector absBleConnector = AbsBleConnector.this;
                    int i = (int) (mReconnectBasePeriod * 0.75f);
                    if (i > absBleConnector.getMScanMaxDuration()) {
                        i = absBleConnector.getMScanMaxDuration();
                    }
                    iI0xO0.Oo(i);
                    iI0xO0.oOoXoXO(true);
                }
            } else {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(AbsBleConnector.this.getLOG_HEADER() + " connect directly");
                AbsBleConnector.this.oIX0oI();
            }
            AbsBleConnector absBleConnector2 = AbsBleConnector.this;
            absBleConnector2.setMConnectDirectly(true ^ absBleConnector2.getMConnectDirectly());
            AbsBleConnector.this.getMHandler().postDelayed(this, mReconnectBasePeriod * 1000);
        }
    }

    /* loaded from: classes8.dex */
    public static final class II0xO0 implements XOxIOxOx.oxoX {
        public II0xO0() {
        }

        @Override // XOxIOxOx.oxoX
        public void I0Io() {
        }

        @Override // XOxIOxOx.oxoX
        public void II0xO0(@OOXIXo BleDevice device) {
            IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AbsBleConnector.this.getLOG_HEADER() + " onDeviceFound -> " + device);
            XOxIOxOx.II0xO0 iI0xO0 = AbsBleConnector.this.mScanner;
            if (iI0xO0 != null) {
                iI0xO0.oOoXoXO(false);
            }
            if (AbsBleConnector.this.getMBluetoothGatt() != null) {
                return;
            }
            AbsBleConnector absBleConnector = AbsBleConnector.this;
            absBleConnector.setMBluetoothGatt(absBleConnector.II0xO0(device.getMBluetoothDevice()));
        }

        @Override // XOxIOxOx.oxoX
        public void oIX0oI(boolean z) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String I0Io(int i) {
            if (i != 0) {
                if (i != 13) {
                    if (i != 15) {
                        if (i != 143) {
                            if (i != 257) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (i != 5) {
                                            if (i != 6) {
                                                if (i != 7) {
                                                    return i + " unknown";
                                                }
                                                return i + " INVALID_OFFSET";
                                            }
                                            return i + " REQUEST_NOT_SUPPORTED";
                                        }
                                        return i + " INSUFFICIENT_AUTHENTICATION";
                                    }
                                    return i + " WRITE_NOT_PERMITTED";
                                }
                                return i + " READ_NOT_PERMITTED";
                            }
                            return i + " FAILURE";
                        }
                        return i + " CONNECTION_CONGESTED";
                    }
                    return i + " INSUFFICIENT_ENCRYPTION";
                }
                return i + " INVALID_ATTRIBUTE_LENGTH";
            }
            return i + " SUCCESS";
        }

        @OOXIXo
        public final String II0xO0(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return i + " unknown";
                        }
                        return "DISCONNECTING";
                    }
                    return "CONNECTED";
                }
                return "CONNECTING";
            }
            return "DISCONNECTED";
        }

        @OOXIXo
        public final String oIX0oI(int i) {
            switch (i) {
                case 10:
                    return "STATE_OFF";
                case 11:
                    return "STATE_TURNING_ON";
                case 12:
                    return "STATE_ON";
                case 13:
                    return "STATE_TURNING_OFF";
                default:
                    return i + " unknown";
            }
        }

        public oIX0oI() {
        }
    }

    public static /* synthetic */ AbsBleConnector setBleDevice$default(AbsBleConnector absBleConnector, BleDevice bleDevice, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return absBleConnector.setBleDevice(bleDevice, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBleDevice");
    }

    public final AbsBleConnector$mBluetoothGattCallback$2.oIX0oI I0Io() {
        return (AbsBleConnector$mBluetoothGattCallback$2.oIX0oI) this.mBluetoothGattCallback$delegate.getValue();
    }

    public final BluetoothGatt II0xO0(BluetoothDevice bluetoothDevice) {
        BluetoothGatt connectGatt;
        int type = bluetoothDevice.getType();
        if (this.mTransport == 0 && type == 3) {
            this.mTransport = 2;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " BluetoothGatt -> type = " + bluetoothDevice.getType() + " , transport = " + this.mTransport);
        if (Build.VERSION.SDK_INT >= 23) {
            connectGatt = bluetoothDevice.connectGatt(getMContext(), false, I0Io(), this.mTransport);
            IIX0o.ooOOo0oXI(connectGatt);
            return connectGatt;
        }
        BluetoothGatt connectGatt2 = bluetoothDevice.connectGatt(getMContext(), false, I0Io());
        IIX0o.ooOOo0oXI(connectGatt2);
        return connectGatt2;
    }

    public final void X0o0xo() {
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", null);
            if (method != null) {
                Object invoke = method.invoke(this.mBluetoothGatt, null);
                IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) invoke).booleanValue();
                OI0.oIX0oI.f1507oIX0oI.oxoX(getLOG_HEADER() + " refreshDeviceCache -> " + booleanValue);
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(getLOG_HEADER() + " refreshDeviceCache -> error = " + e.getMessage());
        }
    }

    public final boolean XO() {
        boolean z;
        if (this.mBluetoothAdapter.isEnabled() && !TextUtils.isEmpty(this.mTargetAddress)) {
            z = true;
        } else {
            z = false;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " shouldReconnect -> " + z + ", BluetoothAdapter isEnabled: " + this.mBluetoothAdapter.isEnabled() + ", mTargetAddress: " + this.mTargetAddress);
        return z;
    }

    public final synchronized void closeConnection(boolean z) {
        com.bestmafen.baseble.connector.I0Io i0Io;
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " closeConnection -> stopReconnecting = " + z);
            getMBleMessenger().reset();
            getMBleParser().reset();
            if (this.mNotified) {
                this.mNotified = false;
                if (z && (i0Io = this.mBleGattCallback) != null) {
                    i0Io.onConnectionStateChange(false);
                }
            }
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt != null) {
                if (this.isRefreshDeviceCache) {
                    IIX0o.ooOOo0oXI(bluetoothGatt);
                    bluetoothGatt.disconnect();
                    X0o0xo();
                }
                BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                IIX0o.ooOOo0oXI(bluetoothGatt2);
                bluetoothGatt2.close();
                this.mBluetoothGatt = null;
            }
            if (z) {
                this.mTargetAddress = "";
                connect(false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void connect(boolean z) {
        try {
            if (isConnecting() == z) {
                return;
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " connect -> " + z);
            setConnecting(z);
            this.mRetry = 0;
            if (z) {
                if (this.isAutoReconnect) {
                    this.mHandler.post(this.mReconnection);
                } else {
                    oIX0oI();
                }
            } else {
                XOxIOxOx.II0xO0 iI0xO0 = this.mScanner;
                if (iI0xO0 != null) {
                    iI0xO0.oOoXoXO(false);
                }
                this.mHandler.removeCallbacks(this.mReconnection);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void exit() {
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " -> exit");
            XOxIOxOx.II0xO0 iI0xO0 = this.mScanner;
            if (iI0xO0 != null) {
                iI0xO0.II0xO0();
            }
            closeConnection(true);
            getMContext().unregisterReceiver(oxoX());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @oOoXoXO
    public final BluetoothGattCharacteristic getCharacteristic(@OOXIXo String serviceUuid, @OOXIXo String characteristicUuid) {
        IIX0o.x0xO0oo(serviceUuid, "serviceUuid");
        IIX0o.x0xO0oo(characteristicUuid, "characteristicUuid");
        if (this.mBluetoothGatt == null || TextUtils.isEmpty(serviceUuid) || TextUtils.isEmpty(characteristicUuid)) {
            return null;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        IIX0o.ooOOo0oXI(bluetoothGatt);
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(serviceUuid));
        if (service == null) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(getLOG_HEADER() + " getCharacteristic -> service(" + serviceUuid + ")=null");
            return null;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(characteristicUuid));
        if (characteristic == null) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(getLOG_HEADER() + " getCharacteristic -> service(" + serviceUuid + "), characteristic(" + characteristicUuid + ")=null");
            return null;
        }
        return characteristic;
    }

    public final boolean getDisableStreamLog() {
        return this.disableStreamLog;
    }

    @OOXIXo
    public String getLOG_HEADER() {
        return this.LOG_HEADER;
    }

    @oOoXoXO
    public final com.bestmafen.baseble.connector.I0Io getMBleGattCallback() {
        return this.mBleGattCallback;
    }

    @OOXIXo
    public abstract xII.oIX0oI getMBleMessenger();

    @OOXIXo
    public abstract x0o.oIX0oI getMBleParser();

    @oOoXoXO
    public final BluetoothGatt getMBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public final boolean getMConnectDirectly() {
        return this.mConnectDirectly;
    }

    @OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @OOXIXo
    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final int getMMtu() {
        return this.mMtu;
    }

    @OOXIXo
    public abstract String getMNotify();

    public final int getMReconnectBasePeriod() {
        return this.mReconnectBasePeriod;
    }

    public final int getMReconnectMaxPeriod() {
        return this.mReconnectMaxPeriod;
    }

    public final int getMScanMaxDuration() {
        return this.mScanMaxDuration;
    }

    @OOXIXo
    public abstract String getMService();

    @oOoXoXO
    public final String getMTargetAddress() {
        return this.mTargetAddress;
    }

    public final long getMTimeout() {
        return this.mTimeout;
    }

    public final int getMTransport() {
        return this.mTransport;
    }

    @oOoXoXO
    public final BluetoothGattDescriptor getNotifyDescriptor(@oOoXoXO BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic == null) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(getLOG_HEADER() + " getNotifyDescriptor -> characteristic=null");
            return null;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO(getLOG_HEADER() + " getNotifyDescriptor -> descriptor=null");
            return null;
        }
        return descriptor;
    }

    @OOXIXo
    @SuppressLint({"WrongConstant"})
    public final AbsBleConnector init(@OOXIXo Context context, @OOXIXo com.bestmafen.baseble.connector.I0Io bleGattCallback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(bleGattCallback, "bleGattCallback");
        Context applicationContext = context.getApplicationContext();
        IIX0o.oO(applicationContext, "getApplicationContext(...)");
        setMContext(applicationContext);
        this.mBleGattCallback = bleGattCallback;
        this.mScanner = oO.II0xO0(oO.f3971oIX0oI, null, null, 3, null).IXxxXO(this.mScanFilter).ooOOo0oXI(new II0xO0());
        getMBleMessenger().setMAbsBleConnector(this);
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(context, oxoX(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
        } else {
            getMContext().registerReceiver(oxoX(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        return this;
    }

    public final boolean isAutoReconnect() {
        return this.isAutoReconnect;
    }

    public boolean isConnecting() {
        return this.isConnecting;
    }

    public final boolean isRefreshDeviceCache() {
        return this.isRefreshDeviceCache;
    }

    public final void oIX0oI() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(getLOG_HEADER() + " connectGatt");
        try {
            BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(this.mTargetAddress);
            IIX0o.oO(remoteDevice, "getRemoteDevice(...)");
            this.mBluetoothGatt = II0xO0(remoteDevice);
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(getLOG_HEADER() + " connect Exception");
            e.printStackTrace();
        }
    }

    public final AbsBleConnector$mReceiver$2.AnonymousClass1 oxoX() {
        return (AbsBleConnector$mReceiver$2.AnonymousClass1) this.mReceiver$delegate.getValue();
    }

    @OOXIXo
    public final AbsBleConnector setAddress(@OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        this.mTargetAddress = address;
        this.mScanFilter.I0Io(address);
        return this;
    }

    public final void setAutoReconnect(boolean z) {
        this.isAutoReconnect = z;
    }

    @OOXIXo
    public final AbsBleConnector setBleDevice(@OOXIXo BleDevice bleDevice, int i) {
        IIX0o.x0xO0oo(bleDevice, "bleDevice");
        this.mTransport = i;
        return setBluetoothDevice(bleDevice.getMBluetoothDevice());
    }

    @OOXIXo
    public final AbsBleConnector setBluetoothDevice(@OOXIXo BluetoothDevice bluetoothDevice) {
        IIX0o.x0xO0oo(bluetoothDevice, "bluetoothDevice");
        String address = bluetoothDevice.getAddress();
        IIX0o.oO(address, "getAddress(...)");
        return setAddress(address);
    }

    public void setConnecting(boolean z) {
        this.isConnecting = z;
    }

    public final void setDisableStreamLog(boolean z) {
        this.disableStreamLog = z;
    }

    public final void setMBleGattCallback(@oOoXoXO com.bestmafen.baseble.connector.I0Io i0Io) {
        this.mBleGattCallback = i0Io;
    }

    public final void setMBluetoothGatt(@oOoXoXO BluetoothGatt bluetoothGatt) {
        this.mBluetoothGatt = bluetoothGatt;
    }

    public final void setMConnectDirectly(boolean z) {
        this.mConnectDirectly = z;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMMtu(int i) {
        this.mMtu = i;
    }

    public final void setMReconnectBasePeriod(int i) {
        this.mReconnectBasePeriod = i;
    }

    public final void setMTargetAddress(@oOoXoXO String str) {
        this.mTargetAddress = str;
    }

    public final void setMTimeout(long j) {
        this.mTimeout = j;
    }

    public final void setMTransport(int i) {
        this.mTransport = i;
    }

    public final void setRefreshDeviceCache(boolean z) {
        this.isRefreshDeviceCache = z;
    }

    public final void setTimeout(long j) {
        this.mTimeout = j;
    }

    public final void isAutoReconnect(boolean z) {
        this.isAutoReconnect = z;
    }
}
