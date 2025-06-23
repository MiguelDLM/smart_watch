package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.dfu.entity.BootInfo;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.param.ImgInfoList;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.goodix.ble.libcomx.util.IntUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes9.dex */
public class CheckOverlayTask extends Task {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16111a;

    @TaskParameter
    private ImgInfoList b;
    private Integer c = null;
    private boolean d = false;
    private boolean e = false;

    private boolean a(BootInfo bootInfo, int i, int i2) {
        if (bootInfo == null) {
            return false;
        }
        int runAddr = bootInfo.getRunAddr();
        int appSize = bootInfo.getAppSize();
        if (!IntUtil.memoryOverlap(runAddr, appSize, i, i2)) {
            return false;
        }
        finishedWithError(341, new HexStringBuilder(64).put("Running firmware is overlapped: ").Ox().put(i).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(i + i2).put(" overwrite ").Ox().put(runAddr).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(runAddr + appSize).toString());
        return true;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        if (this.e) {
            finishedWithDone();
            return 0;
        }
        BootInfo bootInfo = this.b.getList().get(0).getBootInfo();
        int length = this.f16111a.getFirmware().length;
        Integer num = this.c;
        if (num != null) {
            if (this.d) {
                a(bootInfo, num.intValue(), length);
                return 0;
            }
            if (a(bootInfo, num.intValue(), length)) {
                return 0;
            }
            int intValue = this.c.intValue();
            int loadAddr = this.f16111a.getImgInfo().getBootInfo().getLoadAddr();
            if (IntUtil.memoryOverlap(intValue, length, loadAddr, length)) {
                finishedWithError(341, new HexStringBuilder(64).put("Copy address overlaps firmware: ").Ox().put(intValue).put(" in ").Ox().put(loadAddr).put(HelpFormatter.DEFAULT_OPT_PREFIX).Ox().put(loadAddr + length).toString());
            }
            return 0;
        }
        a(bootInfo, this.f16111a.getImgInfo().getBootInfo().getLoadAddr(), length);
        return 0;
    }

    public CheckOverlayTask setStartAddressInFlash(Integer num, boolean z, boolean z2) {
        this.c = num;
        this.d = z;
        this.e = z2;
        return this;
    }
}
