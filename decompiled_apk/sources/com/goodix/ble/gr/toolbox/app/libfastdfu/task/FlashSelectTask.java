package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class FlashSelectTask extends Task implements IEventListener<byte[]> {
    private static final int d = 5;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private FastDfuProfile f16136a;
    private EventDisposer b = new EventDisposer();
    private boolean c;

    public FlashSelectTask(boolean z) {
        this.c = z;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.f16136a.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.b).register2(this);
        HexBuilder hexBuilder = new HexBuilder(6);
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(5, 1);
        hexBuilder.put(this.c ? 1 : 0, 1);
        this.f16136a.getFdsCmd().writeByCommand(hexBuilder.getBuffer(), false).start(this, null);
        return 10000;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.b.disposeAll(this);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, byte[] bArr) {
        if (bArr[0] == 5) {
            finishedWithDone();
        }
    }
}
