package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.define.MemoryLayout;
import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEmptyResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramEnd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramStart;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfig;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfigResponse;
import com.goodix.ble.gr.libdfu.dfu.entity.BootInfo;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.goodix.ble.libcomx.util.IntUtil;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes9.dex */
public class UploadDfuFileTask extends Task implements IEventListener<IFrameSdu4Rx> {
    public static final int EVT_SPEED_UPDATED = 173;
    private static final String t = "UploadDfuFileTask";
    private static final int u = 666;
    private static final int v = 2000;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16117a;

    @TaskParameter
    private ITransceiver b;
    private BootInfo c;
    private boolean d;
    private int e;
    private long f;
    private Event g;
    private int l;
    private boolean m;
    private TimerTask n;
    private int o;
    private int p;
    private long q;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private Event<Void> r = new Event<>(this, 173);
    private Timer s = null;

    /* loaded from: classes9.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (UploadDfuFileTask.this.q != 0 && currentTimeMillis > UploadDfuFileTask.this.q) {
                UploadDfuFileTask.this.p = (int) ((r2.o * 1000) / (currentTimeMillis - UploadDfuFileTask.this.q));
                UploadDfuFileTask.this.r.postEvent(null);
                UploadDfuFileTask.this.q = currentTimeMillis;
                UploadDfuFileTask.this.o = 0;
            }
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        byte[] firmware = this.f16117a.getFirmware();
        if (firmware != null && firmware.length > 0) {
            Event<IFrameSdu4Rx> subEvent = this.b.evtRcvFrame().subEvent();
            this.g = subEvent;
            subEvent.setExecutor(getExecutor());
            this.g.register(this);
            this.e = 0;
            this.m = false;
            this.n = null;
            this.d = false;
            this.c = null;
            XSystemConfig txSdu = Cmd.SystemConfig.getTxSdu();
            MemoryLayout memoryLayout = MemoryLayout.BOOT_INFO;
            txSdu.address = memoryLayout.getAddress();
            txSdu.length = memoryLayout.getSize();
            txSdu.opUdate = false;
            if (!this.b.send(Cmd.SystemConfig.CODE, txSdu)) {
                finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
                return 5000;
            }
            return 5000;
        }
        finished(0, null);
        return 0;
    }

    public Event<Void> evtSpeedUpdated() {
        return this.r;
    }

    public int getInstantaneousSpeed() {
        return this.p;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        Event event = this.g;
        if (event != null) {
            event.clear();
            this.g = null;
        }
        TimerTask timerTask = this.n;
        if (timerTask != null) {
            timerTask.cancel();
            this.n = null;
        }
        Timer timer = this.s;
        if (timer != null) {
            timer.cancel();
            this.s = null;
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        if (i == 666 && this.m) {
            this.n = null;
            this.m = false;
            finished(0, null);
        }
    }

    public UploadDfuFileTask setAsCopyMode(int i) {
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = true;
        this.l = i;
        return this;
    }

    public UploadDfuFileTask setAsDfuMode(boolean z) {
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = z;
        this.l = 0;
        return this;
    }

    public UploadDfuFileTask setAsResourceMode(boolean z, int i) {
        this.h = true;
        this.i = z;
        this.j = false;
        this.k = false;
        this.l = i;
        return this;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, IFrameSdu4Rx iFrameSdu4Rx) {
        boolean z = true;
        if (Cmd.SystemConfig.CODE == i) {
            XSystemConfigResponse xSystemConfigResponse = (XSystemConfigResponse) iFrameSdu4Rx;
            if (xSystemConfigResponse.response == 1 && !xSystemConfigResponse.imgInfos.isEmpty()) {
                this.c = xSystemConfigResponse.imgInfos.get(0).getBootInfo();
            }
            a();
            return;
        }
        if (Cmd.ProgramStart.CODE == i || Cmd.ProgramFlash.CODE == i || Cmd.ProgramEnd.CODE == i) {
            XEmptyResponse xEmptyResponse = (XEmptyResponse) iFrameSdu4Rx;
            HexStringBuilder hexStringBuilder = new HexStringBuilder(128);
            hexStringBuilder.format("Response: 0x%02X", Integer.valueOf(xEmptyResponse.response));
            long currentTimeMillis = System.currentTimeMillis() - this.f;
            if (xEmptyResponse.response == 1) {
                if (Cmd.ProgramStart.CODE == i) {
                    this.q = System.currentTimeMillis();
                    this.p = 0;
                    this.o = 0;
                    Timer timer = this.s;
                    if (timer != null) {
                        timer.cancel();
                    }
                    Timer timer2 = new Timer();
                    this.s = timer2;
                    timer2.scheduleAtFixedRate(new a(), 0L, 1000L);
                }
                if (Cmd.ProgramFlash.CODE == i || Cmd.ProgramStart.CODE == i) {
                    if (this.e < this.f16117a.getFirmware().length) {
                        XProgramFlash txSdu = Cmd.ProgramFlash.getTxSdu();
                        txSdu.setType(this.i, 1);
                        txSdu.address = this.l + this.e;
                        int length = this.f16117a.getFirmware().length - this.e;
                        if (length > 1024) {
                            length = 1024;
                        }
                        txSdu.setData(this.f16117a.getFirmware(), this.e, length);
                        if (this.b.send(Cmd.ProgramFlash.CODE, txSdu)) {
                            this.e += length;
                            this.o += length;
                            z = false;
                        }
                        int length2 = (this.e * 100) / this.f16117a.getFirmware().length;
                        publishProgress(length2);
                        hexStringBuilder.newLine().put("Send Flash: 0x").put(this.e);
                        hexStringBuilder.newLine().put("Total: 0x").put(this.f16117a.getFirmware().length);
                        StringBuilder stringBuilder = hexStringBuilder.newLine().put("Progress: ").getStringBuilder();
                        stringBuilder.append(length2);
                        stringBuilder.append("%");
                        StringBuilder stringBuilder2 = hexStringBuilder.newLine().put("Time: ").getStringBuilder();
                        stringBuilder2.append(currentTimeMillis);
                        stringBuilder2.append("ms");
                    } else {
                        XProgramEnd txSdu2 = Cmd.ProgramEnd.getTxSdu();
                        txSdu2.checksum = this.f16117a.getFileChecksum();
                        if (this.h) {
                            txSdu2.resetFlag = this.i ? 18 : 2;
                        } else {
                            txSdu2.resetFlag = this.k ? 1 : 0;
                        }
                        if (this.b.send(Cmd.ProgramEnd.CODE, txSdu2)) {
                            this.m = true;
                            startTimer(666, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                            z = false;
                        }
                        hexStringBuilder.newLine().put("Send End: 0x").put(this.e);
                        publishProgress(100);
                    }
                    if (z) {
                        finishedWithError(-1, "Failed to send data.");
                    }
                }
                if (Cmd.ProgramEnd.CODE == i) {
                    hexStringBuilder.newLine().put("Send Complete.");
                    StringBuilder stringBuilder3 = hexStringBuilder.newLine().put("Time: ").getStringBuilder();
                    stringBuilder3.append(currentTimeMillis);
                    stringBuilder3.append("ms");
                    finished(0, null);
                }
            } else {
                if (Cmd.ProgramFlash.CODE == i) {
                    hexStringBuilder.newLine().put("Address: 0x").put(this.l + this.e);
                    StringBuilder stringBuilder4 = hexStringBuilder.newLine().put("Time: ").getStringBuilder();
                    stringBuilder4.append(currentTimeMillis);
                    stringBuilder4.append("ms");
                }
                if (Cmd.ProgramEnd.CODE == i) {
                    hexStringBuilder.newLine().put("Send Complete Failed.");
                    StringBuilder stringBuilder5 = hexStringBuilder.newLine().put("Time: ").getStringBuilder();
                    stringBuilder5.append(currentTimeMillis);
                    stringBuilder5.append("ms");
                }
                finishedWithError(-1, hexStringBuilder.toString());
            }
            ILogger iLogger = this.logger;
            if (iLogger == null || !this.printVerboseLog) {
                return;
            }
            iLogger.v(t, hexStringBuilder.toString());
        }
    }

    private void a() {
        if (this.d) {
            return;
        }
        int length = this.f16117a.getFirmware().length;
        XProgramStart txSdu = Cmd.ProgramStart.getTxSdu();
        if (this.h) {
            if (!this.i && a(this.l, length)) {
                return;
            } else {
                txSdu.programResourceToFlash(this.i, this.l, length);
            }
        } else {
            ImgInfo imgInfo = this.f16117a.getImgInfo();
            if (imgInfo != null && imgInfo.getPatern() == 18244) {
                if (this.j) {
                    int i = this.l;
                    int loadAddr = imgInfo.getBootInfo().getLoadAddr();
                    if (IntUtil.memoryOverlap(i, length, loadAddr, length)) {
                        finishedWithError(341, new HexStringBuilder(64).put("Copy address overlaps firmware: ").Ox().put(i).put(" in ").Ox().put(loadAddr).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(loadAddr + length).toString());
                        return;
                    } else {
                        if (a(i, length)) {
                            return;
                        }
                        HexBuilder hexBuilder = new HexBuilder(imgInfo.getSerializeSize());
                        imgInfo.serialize(hexBuilder);
                        imgInfo = new ImgInfo();
                        imgInfo.deserialize(new HexReader(hexBuilder.getBuffer()));
                        imgInfo.getBootInfo().setLoadAddr(this.l);
                    }
                } else if (a(imgInfo.getBootInfo().getLoadAddr(), length)) {
                    return;
                }
                txSdu.programInnerFlash(imgInfo);
                this.l = imgInfo.getBootInfo().getLoadAddr();
            } else {
                finishedWithError("Invalid image information in DFU file.");
                return;
            }
        }
        if (this.b.send(Cmd.ProgramStart.CODE, txSdu)) {
            this.f = System.currentTimeMillis();
            this.d = true;
        } else {
            finishedWithError(-1, "Failed to send start command.");
        }
    }

    private boolean a(int i, int i2) {
        BootInfo bootInfo = this.c;
        if (bootInfo == null) {
            return false;
        }
        int runAddr = bootInfo.getRunAddr();
        int appSize = this.c.getAppSize();
        if (!IntUtil.memoryOverlap(runAddr, appSize, i, i2)) {
            return false;
        }
        finishedWithError(341, new HexStringBuilder(64).put("Running firmware is overlapped: ").Ox().put(i).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(i + i2).put(" overwrite ").Ox().put(runAddr).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(runAddr + appSize).toString());
        return true;
    }
}
