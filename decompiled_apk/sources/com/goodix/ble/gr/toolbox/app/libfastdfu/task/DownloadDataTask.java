package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.impl.procedure.CharacteristicWrite;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexEndian;
import java.io.ByteArrayInputStream;

/* loaded from: classes9.dex */
public class DownloadDataTask extends Task implements IEventListener {
    private static final int l = 547;
    private static final int m = 100;
    private static final int n = 4096;
    private static final int o = 2;
    private static final int p = 6;
    private static final int q = 7;
    private static final int r = 9;
    private static final int s = 10;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16132a;

    @TaskParameter
    private FastDfuProfile b;
    private GBGattProcedureWrite d;
    private GBGattProcedureWrite e;
    private int h;
    private ILogger k;
    private final EventDisposer c = new EventDisposer();
    private byte[] f = null;
    private ByteArrayInputStream g = null;
    private boolean i = true;
    private int j = 3000;

    private void a() {
        CharacteristicWrite characteristicWrite;
        ByteArrayInputStream byteArrayInputStream;
        if (this.f == null) {
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = new byte[4096];
                        this.g = new ByteArrayInputStream(this.f);
                    }
                } finally {
                }
            }
        }
        if (this.h == 0) {
            synchronized (this) {
                try {
                    ILogger logger = this.b.getRemoteDevice().getLogger();
                    this.k = logger;
                    if (logger != null) {
                        this.b.getRemoteDevice().setLogger(null);
                        this.k.i(getName(), "remove logger for high speed temporarily.");
                    }
                } finally {
                }
            }
        }
        byte[] firmware = this.f16132a.getFirmware();
        int i = this.h;
        if (i < firmware.length) {
            byte[] bArr = this.f;
            int length = bArr.length;
            if (i + length > firmware.length) {
                length = firmware.length - i;
            }
            System.arraycopy(firmware, i, bArr, 0, length);
            if (length == this.f.length) {
                this.g.reset();
                characteristicWrite = (CharacteristicWrite) this.d;
                byteArrayInputStream = this.g;
            } else {
                characteristicWrite = (CharacteristicWrite) this.d;
                byteArrayInputStream = new ByteArrayInputStream(this.f, 0, length);
            }
            characteristicWrite.setValue(byteArrayInputStream, false);
            this.h += length;
            this.d.start(null, null);
            publishProgress((this.h * 100) / firmware.length);
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.h = 0;
        HexBuilder hexBuilder = new HexBuilder(5);
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(2, 1);
        GBGattProcedureWrite writeByCommand = this.b.getFdsCmd().writeByCommand(hexBuilder.getBuffer(), false);
        this.e = writeByCommand;
        writeByCommand.evtFinished().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.b.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        GBGattProcedureWrite writeByCommand2 = this.b.getFdsDat().writeByCommand(null, false);
        this.d = writeByCommand2;
        writeByCommand2.evtProgress().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.d.evtFinished().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.d.setDebounceProgressEvent(false);
        startTimer(l, 200L, 100L);
        HexBuilder hexBuilder2 = new HexBuilder(5);
        hexBuilder2.put(1196379972, 4);
        hexBuilder2.put(9, 1);
        this.b.getFdsCmd().writeByCommand(hexBuilder2.getBuffer(), false).setName("GetBufferSize").start(this, null);
        this.b.getSpeedometer().start();
        return this.j;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.c.disposeAll(this);
        FastDfuProfile fastDfuProfile = this.b;
        if (fastDfuProfile != null) {
            fastDfuProfile.getSpeedometer().stop();
            synchronized (this) {
                try {
                    ILogger iLogger = this.k;
                    if (iLogger != null) {
                        iLogger.i(getName(), "recover logger.");
                        this.b.getRemoteDevice().setLogger(this.k);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            GBGattProcedureWrite gBGattProcedureWrite = this.d;
            if (gBGattProcedureWrite != null) {
                gBGattProcedureWrite.abort();
            }
        }
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        String str;
        ITaskResult iTaskResult;
        if (obj == this.d) {
            if (i == 341) {
                refreshTaskTimeout();
                return;
            }
            if (i != 342) {
                return;
            }
            iTaskResult = (ITaskResult) obj2;
            if (iTaskResult.getError() == null) {
                if (this.h >= this.f16132a.getFirmware().length) {
                    synchronized (this) {
                        try {
                            ILogger iLogger = this.k;
                            if (iLogger != null) {
                                iLogger.i(getName(), "recover logger after transferring all data.");
                                this.b.getRemoteDevice().setLogger(this.k);
                                this.k = null;
                            }
                        } finally {
                        }
                    }
                    refreshTaskTimeout();
                    this.e.start(this, this.d);
                    return;
                }
                return;
            }
        } else {
            if (obj != this.e || i != 342) {
                if (obj == this.b.getFdsCmd() && i == 55) {
                    byte[] bArr = (byte[]) obj2;
                    if (bArr != null && bArr.length == 1) {
                        byte b = bArr[0];
                        if (b == 2) {
                            finishedWithDone();
                            return;
                        }
                        if (b == 6) {
                            str = "FlowCtrl = true, buffer overflowed.";
                        } else if (b == 7) {
                            str = "FlowCtrl = false, not allowed.";
                        } else if (b != 10) {
                            return;
                        }
                        finishedWithError(str);
                        return;
                    }
                    if (bArr == null || bArr[0] != 9 || bArr.length != 5) {
                        return;
                    }
                    int fromByte = HexEndian.fromByte(bArr, 1, 4, false);
                    synchronized (this) {
                        try {
                            byte[] bArr2 = this.f;
                            if (bArr2 != null) {
                                if (bArr2.length != fromByte) {
                                }
                            }
                            this.f = new byte[fromByte];
                            this.g = new ByteArrayInputStream(this.f);
                        } finally {
                        }
                    }
                    this.i = false;
                    a();
                    return;
                }
                return;
            }
            iTaskResult = (ITaskResult) obj2;
            if (iTaskResult.getError() == null) {
                return;
            }
        }
        finished(iTaskResult.getCode(), iTaskResult.getError());
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        if (i == l && this.i && !this.d.isStarted()) {
            a();
        }
    }

    public DownloadDataTask setTimeout(int i) {
        this.j = i;
        return this;
    }
}
