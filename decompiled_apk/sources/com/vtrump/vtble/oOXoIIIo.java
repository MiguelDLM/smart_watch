package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes13.dex */
public class oOXoIIIo extends VTDevice {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Timer f27507IIXOooo;

    /* renamed from: OxI, reason: collision with root package name */
    public TimerTask f27508OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Xx000oIo f27509OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public Timer f27510o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f27511oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public TimerTask f27512xoXoI;

    public oOXoIIIo(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27511oI0IIXIo = 20;
        this.f27509OxxIIOOXO = null;
        this.f27507IIXOooo = null;
        this.f27512xoXoI = null;
        this.f27510o00 = null;
        this.f27508OxI = null;
    }
}
