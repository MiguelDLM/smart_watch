package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.garmin.fit.xxXXXxIxo;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.logger.Logger;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexEndian;

/* loaded from: classes9.dex */
public class EraseFlashTask extends Task implements IEventListener<byte[]> {
    public static final int SIZE_4K = 4096;
    private static final String e = "EraseFlashTask";

    /* renamed from: a, reason: collision with root package name */
    private FastDfuProfile f16134a;
    private EventDisposer b = new EventDisposer();
    private HexBuilder c;
    private int d;

    public EraseFlashTask(FastDfuProfile fastDfuProfile) {
        this.f16134a = fastDfuProfile;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.f16134a.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.b).register2(this);
        this.f16134a.getFdsCmd().writeByCommand(this.c.getBuffer(), false).startProcedure();
        return 10000;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.b.disposeAll(this);
    }

    public EraseFlashTask setTarget(int i, int i2) {
        HexBuilder hexBuilder = this.c;
        if (hexBuilder == null) {
            HexBuilder hexBuilder2 = new HexBuilder(13);
            this.c = hexBuilder2;
            hexBuilder2.put(1196379972, 4);
            this.c.put(1, 1);
        } else {
            hexBuilder.setPos(5);
        }
        this.c.put(i, 4);
        this.c.put(i2, 4);
        int i3 = (i2 + xxXXXxIxo.f15726I0Io) / 4096;
        this.d = i3;
        if (i3 <= 0) {
            this.d = 1;
        }
        return this;
    }

    public EraseFlashTask(FastDfuProfile fastDfuProfile, int i, int i2) {
        this.f16134a = fastDfuProfile;
        setTarget(i, i2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000d. Please report as an issue. */
    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, byte[] bArr) {
        int i2;
        String str;
        int i3 = 0;
        if (bArr[0] == 1) {
            refreshTaskTimeout();
            switch (bArr[1] & 255) {
                case 0:
                    i2 = 112;
                    str = "Address is not 4K aligned.";
                    finishedWithError(i2, str);
                    return;
                case 1:
                    if (this.printVerboseLog) {
                        Logger.v(this.logger, e, "Start erasing...");
                    }
                    publishProgress(i3);
                    return;
                case 2:
                    i3 = (HexEndian.fromByte(bArr, 2, 2, false) * 100) / this.d;
                    publishProgress(i3);
                    return;
                case 3:
                    finishedWithDone();
                    return;
                case 4:
                    i2 = 230;
                    str = "Overlap running firmware.";
                    finishedWithError(i2, str);
                    return;
                case 5:
                    i2 = 113;
                    str = "Failed to erase.";
                    finishedWithError(i2, str);
                    return;
                case 6:
                    i2 = 114;
                    str = "No ext flash.";
                    finishedWithError(i2, str);
                    return;
                default:
                    return;
            }
        }
    }
}
