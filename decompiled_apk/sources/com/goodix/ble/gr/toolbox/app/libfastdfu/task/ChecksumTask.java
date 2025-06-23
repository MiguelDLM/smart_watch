package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexEndian;

/* loaded from: classes9.dex */
public class ChecksumTask extends Task implements IEventListener<byte[]> {
    private static final int d = 3;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16131a;

    @TaskParameter
    private FastDfuProfile b;
    private EventDisposer c = new EventDisposer();

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.b.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register2(this);
        HexBuilder hexBuilder = new HexBuilder(9);
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(3, 1);
        hexBuilder.put(this.f16131a.getFileChecksum(), 4);
        this.b.getFdsCmd().writeByCommand(hexBuilder.getBuffer(), false).start(this, null);
        return 10000;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.c.disposeAll(this);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, byte[] bArr) {
        if (bArr[0] == 3) {
            int fromByte = HexEndian.fromByte(bArr, 1, 4, false);
            int fileChecksum = this.f16131a.getFileChecksum();
            if (fromByte == fileChecksum) {
                finishedWithDone();
                return;
            }
            finishedWithError("Checksum: " + fromByte + " is not equal to expected: " + fileChecksum);
        }
    }
}
